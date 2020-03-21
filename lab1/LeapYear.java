/** Class that determines whether or not a year is a leap year.
<<<<<<< HEAD
 *  @author Qizhen
=======
 *  @author YOUR NAME HERE
>>>>>>> fa6b0b8a7f1d83bf1aa47b9182bce4cad238f14e
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }
<<<<<<< HEAD
    /** Check if a given year is a leap year.*/
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 & year % 100 != 0);
    }
=======
>>>>>>> fa6b0b8a7f1d83bf1aa47b9182bce4cad238f14e

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

