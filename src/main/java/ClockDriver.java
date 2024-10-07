public class ClockDriver {
    public static void main(String[] args) {
        // Test for ClockDisplay
        System.out.println("Testing ClockDisplay");

        // Empty constructor & read time
        ClockDisplay clockDisplay = new ClockDisplay();
        System.out.println("Initial time (empty constructor): " + clockDisplay.getTime()); // Expect "00:00"

        // Constructor with time given & read time
        ClockDisplay clockDisplayWithTime = new ClockDisplay(3, 32);
        System.out.println("Initial time (constructor with time): " + clockDisplayWithTime.getTime()); // Expect "03:32"

        // Set time
        clockDisplayWithTime.setTime(4, 15);
        System.out.println("Time after setting: " + clockDisplayWithTime.getTime()); // Expect "04:15"

        // Read time
        System.out.println("Reading time: " + clockDisplayWithTime.getTime()); // Expect "04:15"

        // Tick time
        clockDisplayWithTime.timeTick();
        System.out.println("Time after tick: " + clockDisplayWithTime.getTime()); // Expect "04:16"

        // Specific tick tests
        tickTest(clockDisplayWithTime, 3, 32, 3, 33); // Expect tick from 03:32 to 03:33
        tickTest(clockDisplayWithTime, 3, 9, 3, 10); // Expect tick from 03:09 to 03:10
        tickTest(clockDisplayWithTime, 1, 59, 2, 0); // Expect tick from 01:59 to 02:00
        tickTest(clockDisplayWithTime, 9, 59, 10, 0); // Expect tick from 09:59 to 10:00
        tickTest(clockDisplayWithTime, 23, 59, 0, 0); // Expect tick from 23:59 to 00:00

        // Test for ClockDisplaySeconds
        System.out.println("\nTesting ClockDisplaySeconds");

        // Empty constructor & read time
        ClockDisplaySeconds clockDisplaySeconds = new ClockDisplaySeconds();
        System.out.println("Initial time (empty constructor): " + clockDisplaySeconds.getTime()); // Expect "00:00:00"

        // Constructor with time given & read time
        ClockDisplaySeconds clockDisplaySecondsWithTime = new ClockDisplaySeconds(3, 32, 45);
        System.out.println("Initial time (constructor with time): " + clockDisplaySecondsWithTime.getTime()); // Expect "03:32:45"

        // Set time
        clockDisplaySecondsWithTime.setTime(5, 45, 30);
        System.out.println("Time after setting: " + clockDisplaySecondsWithTime.getTime()); // Expect "05:45:30"

        // Read time
        System.out.println("Reading time: " + clockDisplaySecondsWithTime.getTime()); // Expect "05:45:30"

        // Tick time
        clockDisplaySecondsWithTime.timeTick();
        System.out.println("Time after tick: " + clockDisplaySecondsWithTime.getTime()); // Expect "05:45:31"

        // Specific tick tests
        tickSecondsTest(clockDisplaySecondsWithTime, 3, 32, 59, 3, 33, 0); // Expect from 03:32:59 to 03:33:00
        tickSecondsTest(clockDisplaySecondsWithTime, 1, 0, 59, 1, 1, 0); // Expect from 01:00:59 to 01:01:00
        tickSecondsTest(clockDisplaySecondsWithTime, 1, 59, 59, 2, 0, 0); // Expect from 01:59:59 to 02:00:00
        tickSecondsTest(clockDisplaySecondsWithTime, 23, 59, 59, 0, 0, 0); // Expect from 23:59:59 to 00:00:00

        // Test for ClockDisplay12Hour
        System.out.println("\nTesting ClockDisplay12Hour");

        // Empty constructor & read time
        ClockDisplay12Hour clockDisplay12Hour = new ClockDisplay12Hour();
        System.out.println("Initial time (empty constructor): " + clockDisplay12Hour.getTime()); // Expect "12:00 AM"

        // Constructor with time given & read time
        ClockDisplay12Hour clockDisplay12HourWithTime = new ClockDisplay12Hour(3, 32);
        System.out.println("Initial time (constructor with time): " + clockDisplay12HourWithTime.getTime()); // Expect "03:32 PM"

        // Set time
        clockDisplay12HourWithTime.setTime(4, 15);
        System.out.println("Time after setting: " + clockDisplay12HourWithTime.getTime()); // Expect "04:15 PM"

        // Read time
        System.out.println("Reading time: " + clockDisplay12HourWithTime.getTime()); // Expect "04:15 PM"

        // Tick time
        clockDisplay12HourWithTime.timeTick();
        System.out.println("Time after tick: " + clockDisplay12HourWithTime.getTime()); // Expect "04:16 PM"

        // Specific tick tests
        tick12HourTest(clockDisplay12HourWithTime, 3, 32, "PM", 3, 33, "PM"); // Expect from 03:32 PM to 03:33 PM
        tick12HourTest(clockDisplay12HourWithTime, 11, 59, "PM", 12, 0, "AM"); // Expect from 11:59 PM to 12:00 AM
        tick12HourTest(clockDisplay12HourWithTime, 11, 59, "AM", 12, 0, "PM"); // Expect from 11:59 AM to 12:00 PM
        tick12HourTest(clockDisplay12HourWithTime, 12, 59, "PM", 1, 0, "PM"); // Expect from 12:59 PM to 01:00 PM
    }

    private static void tickTest(ClockDisplay clock, int startHour, int startMin, int expectedHour, int expectedMin) {
        clock.setTime(startHour, startMin);
        clock.timeTick();
        System.out.println(String.format("Tick test: %02d:%02d to %02d:%02d => Result: %s", startHour, startMin, expectedHour, expectedMin, clock.getTime().equals(String.format("%02d:%02d", expectedHour, expectedMin)) ? "Passed" : "Failed"));
    }

    private static void tickSecondsTest(ClockDisplaySeconds clock, int startHour, int startMin, int startSec, int expectedHour, int expectedMin, int expectedSec) {
        clock.setTime(startHour, startMin, startSec);
        clock.timeTick();
        System.out.println(String.format("Tick seconds test: %02d:%02d:%02d to %02d:%02d:%02d => Result: %s", startHour, startMin, startSec, expectedHour, expectedMin, expectedSec, clock.getTime().equals(String.format("%02d:%02d:%02d", expectedHour, expectedMin, expectedSec)) ? "Passed" : "Failed"));
    }

    private static void tick12HourTest(ClockDisplay12Hour clock, int startHour, int startMin, String startPeriod, int expectedHour, int expectedMin, String expectedPeriod) {
        clock.setTime(startHour, startMin);
        System.out.println("Set time to " + startHour + ":" + startMin + " " + startPeriod);
        clock.timeTick();
        System.out.println(String.format("Tick test for 12-hour: %02d:%02d %s to %02d:%02d %s => Result: %s",
            startHour, startMin, startPeriod, expectedHour, expectedMin, expectedPeriod,
            clock.getTime().equals(String.format("%02d:%02d %s", expectedHour, expectedMin, expectedPeriod)) ? "Passed" : "Failed"));
    }
}
