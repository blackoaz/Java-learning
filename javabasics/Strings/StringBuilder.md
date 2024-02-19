# StringBuilder

Java StringBuilder class is used to create mutable (modifiable) string. The java StringBuilder class is same as StringBuffer class except that it is non-synchronized.

## Comparing StringBuffer, StringBuilder, Formatter and StringJoiner

The StringBuffer, StringBuilder, Formatter and StringJoiner classes are jav SE utility classes that are primarily used for assembling strings fron other information.

  - The StringBuffer class has been present since java 1.0 and provides a variety of methods for building and modifying a "buffer" containing a sequence of characters.
  - The StringBuilder class was added in java 5 to address perfomance issues with the origin StringBuffer class. The APIs for the two classes are essentially the same. The main difference between StringBuffer and StringBuilder is that the former is thread-safe and synchorinized and the latter is not.

```java
int one = 1;
String color = "red";
StringBuilder sb = new StringBuilder();
sb.append("One=").append(one).append(", Color=").append(Color).append('\n');
System.out.Print(sb)
```

StringBuffer usage is just the same.

The StringBuffer and StringBuilder classes are suitable for both assembling and modifying strings; i.e they provide methods for replacing and removing characters as well as adding them in various. The ramaining two classes are specific to the task of assembling strings.

 - The Formatter class was added in Java 5, and is loosely modeled on the printf function in the C standard library. It takes a format string with embedded format specifiers and a sequences of other arguments, and generates a string by converting the arguments into text and substituting them in place of the format specifiers. The details of the format specifiers say how the arguments are converted into text.

 - The StringJoiner class was added in Java 8. It is a special purpose formatter that succinctly formats a sequence of strings with separators between them. It is designed with a fluent API, and can be used with Java 8 streams.

-> Formatter
 ```java
//This does the same thing as the StringBuilder example above
int one = 1;
String color = "red";
Formatter f = new Formatter();
System.out.print(f.format("one=%d, color=%s%n", one, color));
// Prints "One=1, Colour=red" followed by the platform's line separator

// The same thing using the `String.format` convenience method
System.out.print(String.format("One=%d, color=%s%n", one, color));
 ```

 The StringJoiner class is not ideal for the above task:

 ```java
 StringJoiner sj = new StringJoiner(", ", "[", "]");
 for (String s : new String[]{"A", "B", "C"}){
    sj.add(s)
 }
 System.out.println(s);
 //prints "[A, B, C]"
 ```

 The use Cases for the four classes, can be summarised as follows:

  - StringBuilder is suitable for any string assembly OR string modification task
  - StringBuffer use(only) when you require a thread-safe version of StringBuilder.
  - Formatter provides much richer string formatting functionality, but it is not as efficient as StringBuilder.This is because each call to Formatter.format(...) entails:
    - parsing the format string,
    - creating and populate a varargs array, and
    - autoboxing any primitive type arguments.
 - StringJoiner provides succinct and efficient formatting of a sequence of strings with seperators, but it is not suitable for other formatting task.

## Repeata String n times

The trivial approach would be repeatedly concatenating the string

```java
final int n = ...
final String s = ...
String result = "";

for (int i = 0; i < n; i++>){
    result += s;
}
```

This creates n new string instances containing 1 to n repetitions of s resulting in a runtime of O(s.length() * n**2) = O(s.length() * (1+2+...+(n-1)+n)).

To avoid this StringBuilder should be used, which allows creating the String in O(s.length() * n) instead:

```java
final int n = ...
final String s = ...
StringBuilder builder = new StringBuilder();
for (int i = 0; i < n; i++) {
    builder.append(s)
}
String result = builder.toString();
```