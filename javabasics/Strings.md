# STRINGS

String are pieces of text within a program. Strings are not primitive data type in java, however very common in java.

## Comparing Strings

To compare strings for equality in java, string object's *equals* or *equalIgnoreCase* methods are used.

```java
String firstString = "Test123";
String secondString = "Test" + 123;

if (firstString.equals(secondString)) {
    // Both string have the same content
}
```

In the example below, the strings are compared independent of their cases.

```java
String firstString = "Test123";
String secondString = "TEST123";
if (firstString.equalsIgnoreCase(secondString)) {
// Both Strings are equal, ignoring the case of the individual characters.
}
```

**Note that** equalsIgnoreCase does not let you specify a Locale. For instance, if you compare the two words "Taki" and "TAKI" in English they are equal; however, in Turkish they are different (in Turkish, the lowercase I is ı). For cases like this, converting both strings to lowercase (or uppercase) with Locale and then comparing with equals is the solution.

    String firstString = "Taki";
    String secondString = "TAKI";
    System.out.println(firstString.equalsIgnoreCase(secondString)); //prints true
    Locale locale = Locale.forLanguageTag("tr-TR");
    System.out.println(firstString.toLowerCase(locale).equals( secondString.toLowerCase(locale))); //prints false

when comparing strings in Java, do not use the '==' or '!=', unless you can guarantee that all strings have been interned.
These operators test reference and since multiple String objects can represents the same String, this is liable to give wrong answers. Instead use String.equals(Object).

### Comparing Strings with a constant value

When comparing a String to a constant value, you can put the constant value on the left to avoid a NullPointerException if the other String is null.

    "baz".equals(foo)

while foo.equals("baz") will throw a NullPointerException if foo is null

A more readable alternative is to use Objects.equals(), which does anull check on both parameters 

    Objects.equals(foo, "baz")

### String ordering

The String class implements Comparable<`String`>  with the String.compareTo method. This makes the natural ordering of String Objects case-sensitive order. The String class provide a Comparator<`String`> constant called CASE_INSENSITIVE_ORDER suitable for case-insensitive sorting. 

### Comparing with interned Strings

The java Language specification (JLS 3.10.6) states the following
    *"Moreover, a string literal always refers to the same instance of class String. This is because string literals -or, more generally, strings that are the values of constant expressions-are interned so as to share unique instances, using the method String.intern"*

This means that it is safe to compare references to two string literals using ==. Morever, the same is true for references to String objects that have been produced using the String.intern() method.

```java
String strObj = new String("Hello!"); 
String str = "Hello!";
// The two string references point two strings that are equal
if (strObj.equals(str)) { System.out.println("The strings are equal");
}
// The two string references do not point to the same object
if (strObj != str) {
System.out.println("The strings are not the same object");
}
// If we intern a string that is equal to a given literal, the result is // a string that has the same reference as the literal.
String internedStr = strObj.intern();
if (internedStr == str) {
System.out.println("The interned string and the literal are the same object");
}
```

Behind the scenes, the interning mechanism maintains a hash table that contains all interned strings that are still reachable. When you call intern() on a string, the method looks up the object in the hash table:

- if the string is found, then that value is returned as the interned string.
- Otherwise, a copy of the string is added to the hash table and that string  is returned as the interned string.

It is possible to use interning to allow strings to be compared using ==. However, there significant problems with doing this.

## Changing the case of characters within a string

The String type provides two methods for converting strings between upper case and lower case:

- toUpperCase to convert all characters to upper case
- toLowerCase to convert all characters to lower case

These methods both return the converted string as a new String instances: the original String objects are not modified because String is immutable in java.

```java
String string = "This is a random string";
String upper = string.toUpperCase();
String lower = string.toLowerCase();

System.out.println(string);// prints "This is a Random String"
System.out.println(lower);// prints "this is a random string"
System.out.println(upper);// prints "THIS IS A RANDOM STRING"
```

Non-alphabetic characters, such as digits and punctuations marks, are unaffected by these methods. These methods may also incorrectly deal with certain Unicode characters under certsin conditions.

Non-alphabetic characters, such as digits and punctuation marks, are unaffected by these methods. Note that these methods may also incorrectly deal with certain Unicode characters under certain conditions.

**Note**: These methods are locale-sensitive, and may produce unexpected results if used on strings that are intended to be interpreted independent of the locale. Examples are programming language identifiers, protocol keys, and HTML tags.

For instance, "TITLE".toLowerCase() in a Turkish locale returns "tıtle", where ı (\u0131) is the LATIN SMALL LETTER DOTLESS I character. To obtain correct results for locale insensitive strings, pass Locale.ROOT as a parameter to the corresponding case converting method (e.g. toLowerCase(Locale.ROOT) or toUpperCase(Locale.ROOT)).

### Changing case of a specific character within an ASCII string:

To change the case of a specific character of an ASCII string, the following algorithm van be used:

1. Declare a string.
2. Input the string.
3. Convert the string into a character array.
4. Input the character that is to be searched.
5. Search for the character into the character array.
6. If found,check if the character is lowercase or uppercase.
If Uppercase, add 32 to the ASCII code of the character.
If Lowercase, subtract 32 from the ASCII code of the character. 7. Change the original character from the Character array.
8. Convert the character array back into the string.

## Finding a String Within Another String

To check if string a is contained with another string b, the method ** String.contains()** can be used.

    b.contains(a) // returns true or false

The `String.contains()` method can be used to verify if a CharSequence can be found in the String. The method looks for the string a in the string b in a case-sensitive way.

```java 
String str1 = "Hello World";
String str2 = "Hello";
String str3 = "hello";

System.out.println(str1.contains(str2)); // prints true
System.out.println(str1.contains(str3)); // prints false
```
To find the exact position where  a String stands within  another String, use String.IndexOf();

```java
String s = "this is a long sentence";
int i = s.indexOf('i'); // the first 'i' in String is at index 2
int j = s.indexOf("long"); // the index of the first occurrence of "long" in s is 10 
int k = s.indexOf('z'); // k is -1 because 'z' was not found in String s
int h = s.indexOf("LoNg"); // h is -1 because "LoNg" was not found in String s
```

The String.indexOf() method returns the first index of a char or String in another String. The method returns -1 if it is not found.

**Note:** The String.indexOf method is case sensitive.

```java 
String str1 = "Hello World";
String str2 = "wOr";
str1.indexOf(str2); // -1 
str1.toLowerCase().contains(str2.toLowerCase()); // true 
str1.toLowerCase().indexOf(str2.toLowerCase()); // 6
```

## String pool and heap storage

Like all java objects, all String instances are created on the heap, even literals. When the JVM creates a corresponding String instance on the heap  and it also stores a reference to the newly created String instance in the String pool. Any other references to the same String literal are placed with the previously created String instance in the heap.

```java 
class Strings {
public static void main (String[] args) {
String a = "alpha";
String b = "alpha";
String c = new String("alpha");
        //All three strings are equivalent
        System.out.println(a.equals(b) && b.equals(c));
        //Although only a and b reference the same heap object
        System.out.println(a == b); // true
        System.out.println(a != c); // true
        System.out.println(b != c); // true
} 
}
```

When you use double quotes to create a string, java first looks for the String with the same value in the String pool and returns the reference if found else it creates a new String in the pool and then returns the reference.

Using the new Operator, will force String class to create a new String object in the heap space. You can use intern() method to put it into the pool or refer to other String pool having same value.

The String pool itself is also created on the heap.

## Splitting Strings

You can split a String on a particular delimitting character or a Regular Expression, through the use of String.split() method, that has the following signature.

    public String[] split(String regex)

```java 
String lineFromCsvFile = "Mickey;Bolton;12345;121216";
String[] dataCells = lineFromCsvFile.split(";");
// Result is dataCells = { "Mickey", "Bolton", "12345", "121216"};

// using regular expression
String lineFromInput = "What do you need from me?";
String[] words = lineFromInput.split("\\+"); // one or more space chars 
// Result is words = {"What", "do", "you", "need", "from", "me?"};
```

You can even directly split a character:

```java 
String[] firstNames = "Mickey, Frank, Alice, Tom".split(",");
// Results is firstNames = {"Mickey", "Frank", "Alice", "tOM"};
```

***Warning*: Characters are always treard as a regular expression

    "aab.bbb".split("."); // This returns an empty array

. is treated as the regular expresssion wildcard that matches any character, and since every character is a delimiter, the result is an empty array.

### Splitting based on a delimiter which is a regex meta-character

The following characters are considered special(aka meta-characters) in regex

    < > - = ! ( ) [ ] { } \ ^ $ | ? * .

To split a string based on one of the above delimiters, you need to either escape them using `\\` or use Pattern.quote():

- Using Pattern.quote():

        String s = "a|b|c";
        String regex = Pattern.quote("|");
        String[] arr = s.split(regex);

 - Escaping special characters:

        String s = "a|b|c"
        String[] arr = s.split("\\|")

### Split removes empty values

split(delimiter) by default removes the trailing empty strings from result array. To turn this mechanism off, you need to use overloaded version of split(delimiter, limit) with limit set to negative value like:

    String[] split = data.split("\\|", -1);

split(regex) internally returns result of split(regex, 0).

The limit parameter controlls the number of times the pattern is applied and therefore affects the length of the resulting array.

If the limit n is greater than zero then the pattern will be applied at most n-1 times, the array array's length will be no greater than n, and the array's last entry will contain all input beyond the last matched delimiter.
If n is negative, then the pattern will be applied as many times as possible and the array can have any length.
If n is zero then the pattern will be applied as many times as possible, the array can have any length, and trailing empty strings will be discarded.

### Splitting with a StringTkenizer

Besides the split() method Strings can also be split using a StringTokenizer.

StringTokenizer is even more restrictive than String.split(), and also a bit harder to use. It is essentially designed for pulling out tokens delimited by a fixed set of characters (given as a String). Each character will act as a separator. Because of this restriction, it's about twice as fast as String.split().

Default set of characters are empty spaces (\t\n\r\f). The following example will print out each word separately.

```java
String str = "the lazy fox jumped over the brown fence"; StringTokenizer tokenizer = new StringTokenizer(str); while (tokenizer.hasMoreTokens()) {
    System.out.println(tokenizer.nextToken());
}
```

    This will print out
    the
    lazy
    fox
    jumped
    over
    the
    brown
    fence

You can use different character sets for seperation

```java
String str = "jumped over";
// In this case character `u` and `e` will be used as delimiters 
StringTokenizer tokenizer = new StringTokenizer(str, "ue"); 
while (tokenizer.hasMoreTokens()) {
    System.out.println(tokenizer.nextToken());
}
```

This will print out:

    j
    mp
    d ov 
    r

## Joining Strings with a delimeter

An array of strings can be joined using the static method String.join()

```java
String[] elements = {"foo", "bar", "foobar"}
String singleString = String.join(" + ", elements)
System.out.println(singleString); // print "foo + bar + foobar"
```

Similarly, there is an overload String.join() method for Iterables.

To have a fine-grained control over joining, you may use StringJoiner class:

```java 
StringJoiner sj = new StringJoiner(", ", "[", "]");
// The last two arguments are optional
//They define prefix and suffix for the result string
sj.add("foo");
sj.add("bar");
sj.add("foobar");
System.out.println(sj); // Prints "[foo, bar, foobar]"
```

To join a stream of strings, you may use the joining collector:

```java
Stream<String> StringStream = Stream.of("foo", "bar", "foobar");
String joined = stringStream.collect(Collectors.joining(", ", "{", "}"));
Syste.out.println(joined); //prints "{ foo, bar, foobar}"
```
 ## String Concatenation and StringBuilders

 String concatenation can be performed using the + operator:

 ```java
 String s1 = "a";
 String s2 = "b";
 String s3 = "c";
 String s = s1 + s2 + s3; // abc
 ```

Normally a compiler implementation will perform the above concatenation using the methods involving StringBuilder under the hood. When compiled, the code looks as below:

```java
StringBuilder sb = new StringBuilder("a");
String s = sb.append("b").append("c").toString();
```

StringBuilder has several overloaded methods for appending different types, for example, to append an int instead of a String. For example, an implementation can convert:

```java
String s1 = "a";
String s2 = "b";
String s = s1 + s2 + 2; // ab2
```

The above examples illustrate a simple concatenation operation that is effectively done in a single place in the code. The concatenation involves a single instance of the StringBuilder. In some cases, a concatenation is carried out in a cumulative way such as in a loop:

```java
String result = "";
for(int i = 0; i < array.length; i++) {
    result += extractElement(array[i]);
}
return result;
```

In such cases, the compiler optimization is usually not applied, and each iteration will create a new StringBuilder object. This can be optimized by explicitly transforming the code to use a single StringBuilder:

```java
StringBuilder result = new StringBuilder(); for(int i = 0; i < array.length; i++) {
result.append(extractElement(array[i]));
}
return result.toString();
```

A StringBuilder will be initialized with an empty space of only 16 characters. If you know in advance that you will be building larger strings, it can be beneficial to initialize it with sufficient size in advance, so that the internal buffer does not need to be resized:

```java
StringBuilder buf = new StringBuilder(30); // Default is 16 characters 
buf.append("0123456789");
buf.append("0123456789"); // Would cause a reallocation of the internal buffer otherwise 
String result = buf.toString(); // Produces a 20-chars copy of the string
```

If you are producing many strings, it is advisable to reuse stringBuilders

```java
StringBuilder buf = new StringBuilder(100); for (int i = 0; i < 100; i++) {
buf.setLength(0); // Empty buffer
buf.append("This is line ").append(i).append('\n'); outputfile.write(buf.toString());
}
```