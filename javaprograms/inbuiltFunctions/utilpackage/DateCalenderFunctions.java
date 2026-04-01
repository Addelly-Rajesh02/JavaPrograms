package inbuiltFunctions.utilpackage;

import java.util.Calendar;
import java.util.Date;

public class DateCalenderFunctions {

    public static void main(String[] args) {
        demoDateMethods();
        System.out.println("-------------------------------------------------");
        demoCalendarMethods();
    }

    // ------------------------ Date methods ------------------------
    private static void demoDateMethods() {
        System.out.println("Date Methods Demo");

        // Current date-time
        Date now = new Date();

        // Create specific dates using milliseconds since epoch (Jan 1, 1970 UTC)
        // For readability, we create via Calendar and then extract Date.
        Calendar c = Calendar.getInstance();
        c.set(2023, Calendar.JANUARY, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date jan1_2023 = c.getTime();

        c.set(2024, Calendar.JANUARY, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date jan1_2024 = c.getTime();

        // getTime(): milliseconds since epoch
        System.out.println("now: " + now);
        System.out.println("now.getTime(): " + now.getTime());

        // after() and before()
        System.out.println("jan1_2024.after(jan1_2023): " + jan1_2024.after(jan1_2023));   // true
        System.out.println("jan1_2023.before(jan1_2024): " + jan1_2023.before(jan1_2024)); // true

        // Compare with 'now'
        System.out.println("now.after(jan1_2024): " + now.after(jan1_2024));
        System.out.println("now.before(jan1_2023): " + now.before(jan1_2023));
    }

    // ---------------------- Calendar methods ----------------------
    private static void demoCalendarMethods() {
        System.out.println("Calendar Methods Demo");

        // getInstance(): obtains a Calendar for the default time zone/locale
        Calendar cal = Calendar.getInstance();

        // get(): retrieve date-time fields
        int year   = cal.get(Calendar.YEAR);
        int month  = cal.get(Calendar.MONTH);       // 0-based (Jan=0, Dec=11)
        int day    = cal.get(Calendar.DAY_OF_MONTH);
        int hour   = cal.get(Calendar.HOUR_OF_DAY); // 0-23
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.printf("Current: %04d-%02d-%02d %02d:%02d:%02d%n",
                year, month + 1, day, hour, minute, second);

        // set(): set specific components (note: MONTH is 0-based)
        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, Calendar.DECEMBER); // 11
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dec31_2025_2359 = cal.getTime();
        System.out.println("After set() -> " + dec31_2025_2359);

        // add(): add or subtract time units (rolls other fields as needed)
        cal.add(Calendar.DAY_OF_MONTH, 1);  // +1 day -> 2026-01-01 23:59:00
        Date jan1_2026_2359 = cal.getTime();
        System.out.println("After add(DAY_OF_MONTH, +1) -> " + jan1_2026_2359);

        cal.add(Calendar.MONTH, -2);        // -2 months -> 2025-11-01 23:59:00
        Date nov1_2025_2359 = cal.getTime();
        System.out.println("After add(MONTH, -2) -> " + nov1_2025_2359);

        // Another example: add hours/minutes
        cal.add(Calendar.HOUR_OF_DAY, 2);   // +2 hours (may roll day)
        cal.add(Calendar.MINUTE, -30);      // -30 minutes
        System.out.println("After add(HOUR_OF_DAY, +2) & add(MINUTE, -30) -> " + cal.getTime());

        // Read back with get()
        System.out.printf("Read back with get(): %04d-%02d-%02d %02d:%02d:%02d%n",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
    }
}