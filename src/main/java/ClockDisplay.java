public class ClockDisplay {
    private NumberDisplay hours; // NumberDisplay for hours
    private NumberDisplay minutes; // NumberDisplay for minutes
    private String display; // String to hold the formatted display

    // Constructor with no parameters
    public ClockDisplay() {
        hours = new NumberDisplay(24); // 24-hour limit
        minutes = new NumberDisplay(60); // 60-minute limit
        updateDisplay(); // Update display initially
    }

    // Constructor with parameters
    public ClockDisplay(int hour, int minute) {
        this(); // Call the no-argument constructor to set limits
        setTime(hour, minute); // Set the supplied time
    }

    // Method to increment time by one minute
    public void timeTick() {
        minutes.increment(); // Increment minutes
        if (minutes.getValue() == 0) { // If minutes rolled over
            hours.increment(); // Increment hours
        }
        updateDisplay(); // Update display after increment
    }

    // Method to set the time
    public void setTime(int hour, int minute) {
        hours.setValue(hour); // Set hour value
        minutes.setValue(minute); // Set minute value
        updateDisplay(); // Update display after setting time
    }

    // Method to get the current time as a String
    public String getTime() {
        return display; // Return the formatted display string
    }

    // Method to update the display string
    private void updateDisplay() {
        display = String.format("%02d:%02d", hours.getValue(), minutes.getValue());
    }

    // Inner class to represent NumberDisplay
    private class NumberDisplay {
        private int limit; // Maximum value
        private int value; // Current value

        // Constructor for NumberDisplay
        public NumberDisplay(int limit) {
            this.limit = limit;
            value = 0; // Initialize to 0
        }

        public void increment() {
            value = (value + 1) % limit; // Increment and wrap around
        }

        public void setValue(int value) {
            if (value < limit) {
                this.value = value; // Set value if within limits
            }
        }

        public int getValue() {
            return value; // Return current value
        }
    }
}
