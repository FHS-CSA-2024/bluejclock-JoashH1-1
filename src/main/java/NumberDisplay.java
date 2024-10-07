public class NumberDisplay {
    private int limit; // The upper limit for the display value
    private int value; // The current value of the display

    // Constructor that sets the limit and initializes the value to 0
    public NumberDisplay(int rollOverLimit) {
        this.limit = rollOverLimit;
        this.value = 0;
    }

    // Getter for limit
    public int getLimit() {
        return limit;
    }

    // Setter for limit
    public void setLimit(int limit) {
        this.limit = limit; // You may want to add validation here as well
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Setter for value with validation
    public void setValue(int value) {
        if (value < 0 || value >= limit) {
            throw new IllegalArgumentException("Value must be between 0 and " + (limit - 1));
        }
        this.value = value;
    }

    // Method to return the display value formatted as a two-digit string
    public String getDisplayValue() {
        return String.format("%02d", value);
    }

    // Method to increment the value
    public void increment() {
        value++;
        if (value >= limit) {
            value = 0; // Reset to 0 if limit is reached
        }
    }
}
