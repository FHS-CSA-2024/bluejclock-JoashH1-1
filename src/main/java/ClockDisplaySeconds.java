public class ClockDisplaySeconds extends ClockDisplay {
    private NumberDisplay seconds; // NumberDisplay for seconds

    // Constructor with no parameters
    public ClockDisplaySeconds() {
        super(); // Call the superclass constructor for hours and minutes
        seconds = new NumberDisplay(60); // Initialize seconds with a limit of 60
        updateDisplay(); // Update the display initially
    }

    // Constructor with parameters to set initial time
    public ClockDisplaySeconds(int hour, int minute, int second) {
        this(); // Call the no-argument constructor to set limits
        setTime(hour, minute, second); // Set the supplied time
    }

    // Method to set time with hours, minutes, and seconds
    public void setTime(int hour, int minute, int second) {
        super.setTime(hour, minute); // Set hours and minutes from parent class
        seconds.setValue(second); // Set seconds value and ensure it's valid
        updateDisplay(); // Update the display after setting time
    }

    @Override
    public void timeTick() {
        seconds.increment(); // Increment seconds
        if (seconds.getValue() == 0) { // If seconds rolled over
            super.timeTick(); // Call the parent class method to handle minute and hour increment
        }
        updateDisplay(); // Update the display after incrementing time
    }

    @Override
    protected void updateDisplay() {
        // Format the display string to include hours, minutes, and seconds
        display = String.format("%02d:%02d:%02d", getHours(), getMinutes(), seconds.getValue());
    }

    // Getters for the hours and minutes from the parent class
    private int getHours() {
        return hours.getValue(); // Access hours through the NumberDisplay
    }

    private int getMinutes() {
        return minutes.getValue(); // Access minutes through the NumberDisplay
    }
}
