package silverstar.udemy.kotlin4jd.datatypes.java;

public class JavaUtils {

    public static String isVacationTime(boolean onVacation) {
        return onVacation ? "I am on vacation" : "I am working";
    }

    public static void printNumbers(int[] numbers) {
        for (int number: numbers) System.out.println(number);
    }

    public static void printChars(char[] chars) {
        for (char c: chars) System.out.println(c);
    }
}
