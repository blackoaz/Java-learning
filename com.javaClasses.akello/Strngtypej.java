import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Strngtypej {
    public static void main(String[] args) {
        // compareStrng();
        // compareStrngCase();
        // strngintern();
        // charactasciicase();
        // strngSplitmethod();
        // stringJoinner();
        // String name = "My name is: ".concat("Akello");
        // System.out.println(name);

        // String datestring = "2015年11月17日";
        // datestring = datestring.substring(0, 4) + "-" + datestring.substring(5, 7) + "-" + datestring.substring(8, 10);
        // System.out.println(datestring);

        //reversingStrings();
        int one = 1;
        String n = "people";

        System.out.print("Different color, " + one + " " + n);
    }

    static void compareStrng() {
        String firstString = "Test123";
        String secondString = "Test" + 123;

        if (firstString.equals(secondString)) {
            System.out.println(firstString + " is eaual to: " + secondString);
        } else {
            System.out.println("The strings are different");
        }
    }

    static void compareStrngCase() {
        String firstString = "Test123";
        String secondString = "TEST" + 123;

        if (firstString.equalsIgnoreCase(secondString)) {
            System.out.println(firstString + " is eaual to: " + secondString);
        } else {
            System.out.println("The strings are different");
        }
    }

    static void strngintern() {
        String strObj = new String("Hello!");
        String str = "Hello!";
        // The two string references point two strings that are equal
        if (strObj.equals(str)) {
            System.out.println("The strings are equal");
        }
        // The two string references do not point to the same object
        if (strObj != str) {
            System.out.println("The strings are not the same object");
        }
        // If we intern a string that is equal to a given literal, the result is // a
        // string that has the same reference as the literal.
        String internedStr = strObj.intern();
        if (internedStr == str) {
            System.out.println("The interned string and the literal are the same object");
        }

    }

    static void charactasciicase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = scanner.next();
        char[] a = s.toCharArray();
        System.out.println("Enter the character you are looking for");
        String c = scanner.next();
        scanner.close();
        char d = c.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (a[i] == d) {
                if (d >= 'a' && d <= 'z') {
                    d -= 32;
                } else if (d >= 'A' && d <= 'Z') {
                    d += 32;
                }
                a[i] = d;
                break;
            }

        }
        s = String.valueOf(a);
        System.out.println(s);
    }

    static void strngSplitmethod() {
        String str1 = "lazy The dog jumped over the fence";
        String[] a = str1.split(" ");
        System.out.println("the list of the split is : " + Arrays.toString(a));
        System.out.println("the length of the list is: " + a.length);

        for (int index = 0; index < a.length; index++) {
            if (a[index].equals("The")) {
                System.out.println("The word \"The\" has been found at index: " + index);

            } else {
                continue;
            }

        }
        ;

    }

    static void stringJoinner() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        // The last two arguments are optional
        // They define prefix and suffix for the result string
        sj.add("foo");
        sj.add("bar");
        sj.add("foobar");
        System.out.println(sj); // Prints "[foo, bar, foobar]"
    }

    static void reversingStrings() {
        String code = "code";
        System.out.println(code);
        char[] array = code.toCharArray();
        for (int index = 0, mirroredIndex = array.length - 1; index < mirroredIndex; index++, mirroredIndex--) {
            char temp = array[index];
            array[index] = array[mirroredIndex];
            array[mirroredIndex] = temp;
        }
        // print reversed
        System.out.println(new String(array));
    }

}
