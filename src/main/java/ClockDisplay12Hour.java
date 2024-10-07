public class ClockDisplay12Hour extends ClockDisplay {
    private String period; // To track AM or PM

    // Constructor with no parameters
    public ClockDisplay12Hour() {
        super(); // Call the superclass constructor
        period = "AM"; // Default to AM
        updateDisplay(); // Update display initially
    }

    // Constructor with parameters to set initial time
    public ClockDisplay12Hour(int hour, int minute) {
        this(); // Call the no-argument constructor
        setTime(hour, minute); // Set the supplied time
    }

    @Override
    public void setTime(int hour, int minute) {
        // Ensure hour is between 0-23 and convert to 12-hour format
        if (hour >= 12) {
            period = "PM"; // Set period to PM
            hour = hour % 12; // Convert hour to 12-hour format
        } else {
            period = "AM"; // Set period to AM
        }
        if (hour == 0) hour = 12; // Adjust 0 hour to 12

        super.setTime(hour, minute); // Call the superclass method to set time
    }

    @Override
    public void timeTick() {
        super.timeTick(); // Call the superclass method to handle incrementing

        // Check if we need to switch AM/PM (12:59 -> 1:00)
        if (getMinutes() == 0 && getHours() == 1) {
            togglePeriod(); // Switch between AM and PM
        }
    }

    // Toggle method for AM/PM
    private void togglePeriod() {
        period = period.equals("AM") ? "PM" : "AM"; // Switch periods
    }

    @Override
    protected void updateDisplay() {
        display = String.format("%02d:%02d %s", getHours(), getMinutes(), period);
    }

    // Getters for the hours and minutes from the parent class
    private int getHours() {
        return hours.getValue(); // Access hours through the NumberDisplay
    }
    
    private int getMinutes() {
        return minutes.getValue(); // Access minutes through the NumberDisplay
    }
}
