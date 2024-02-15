# **Java Basics**

Ever java application contains at least one class definition.

   **public static void** main( String[ ] args) {

This is an entry point method (defined by its name and signature ** public static void** main( String [ ] args)) from which jvm can run your program. Every java program should have on.

- **public -** meaning that the method can be accessed from anywhere, from outside the program as well.
- **static -** means, it exists and can run by itself(at the class level without creating an object.)
- **void -** it returns no value.

The name args is a variable, so it can be called anything you want, although it is typically called args.

Whether its parameter type is an array (String [] args) or varargs(String...) does not matter because arrays can be passed into varargs.

**Note:** A single Application may have multiple classes containing an entry point(main) method. The entry point of the application is determined by the class name passed as an argument to the java command.

-> Each statement in Java must end with a semicolon.

## Type Conversion
### Numeric Primitive Casting
Numeric primitive casting can be done in two ways:
- Implicit casting and
- Explicit casting.

Implicit casting happens when the source type has smaller range than the target type.

    //implicit casting
    byte byteVar = 42;
    short shortVar = byteVar;
    int intVar = shortVar;
    long longVar = intVar;
    float floatVar = longVar;
    double doubleVar = floatVar

Explicit Casting has to be done when the source type has a larger range than the target type.
    
    //Explicit casting
    double doubleVar = 42.0d;
    float floatVar = (float) doubleVar;
    long LongVar = (long) floatVar;
    int intVar = (int) LongVar;
    short shortVar = (short) intVar;
    byte byteVar = (byte) shortVar

-> When casting a floating point primitives (float, double) to whole number primitives the number is rounded down.

### Basic Numeric Promotion
    char char1 = 1, char2 = 2;
    short short1 = 1, short2 = 2;
    int int1 = 1, int2 = 2;
    float float1 = 1.0f, float2 = 2.0f;

    // char1 = char1 + char2; // Error cannot convert from int to char.
    // short1 = short1 + short2 // Error cannot convert from int to char.
    int1 = char1 + char2 // char is promoted to int.
    int1 = short1 + short2 //short is promoted to int.
    int1 = char1 + short1 // both short and int is promoted to int.
    float1 = float1 + short1 // short is promoted to float


### Non-Numeric Primitive Casting

 - The boolean type cannot be cast from/to any other primitive type.
 - A char can be cast to/from any numeric type by using the code points mapping specified by Unicode.
 - A char is represented in memory as an unsigned 16-bit integer value(2-bytes), so casting to a bit will drop 8-bits(safe for ASCII characters).
 - The utility methods of the character class use int(4 bytes) to transfer to/from code-point values, but a short (2 bytes) would also suffice for storing s Unicode code-point.

 ```
 int badInt = (int) true // Compiler Error: Incompatible types
 char char1 = (char) 65; // A
 byte byte1 = (byte) 'A'; // 65
 short short1 = (short) 'A'; // 65
 int int1 = (int) 'A'; // 65
 
 char char2 = (char) 8253; // ?
 byte byte2 = (byte) '?' // 61 (Truncated code-point into ASCII range) 
 short short2 = (short) '?' // 8253
 int int2 = (int) '?' // 8253
 ```

### Object Casting

As with primitives, objects can be cast both explicitly and implicitly.
Implicit casting happens when the source type extends or implements the target type(casting to a super class or an interface).
Explicit casting has to be done when the source type is extended or implemented by the target type(casting to a subtype). This can produce a runtime exception(classCastException) when the object being cast is not of the target type(or targets subtype).

```java
Float floatVar = new Float(42.0f);
Number n = floatVar;   // Implicit: Float implements number
Float floatVar2 = (Float) n; // Explicit
Double doubleVar = (Double) n; // ThrowsException (the object is not Double)
```
// ### Testing if An Object can be Cast Using instanceof

# GETTERS AND SETTERS
### Using a Setter or getter to Implement constraint

Setters and Getters allow for an object to contain private variables which can be accessed and change with restrictions.

```java
public class Person {
    private String name;
    
    public String getName (){
        return this.name;
        
    }
    public void setName(String name){
        if( name != null && name.length() > 2){
            this.name = name;
        }

    }
}
```

### Importance of Getters and Setters
- Getters and setters allows you to interact with a class internal nature as it dictates.
- Getters and setters makes access synchronization simple.

### ADDING GETTERS AND SETTERS
Encapsulation is a basic concept in Object Oriented-Programming, it's about wrapping data and code as a single unit.
It's a good practice to declare the variables as private and the access them through getters and setters to view and/or modify.
With private variables, they cannot be accessed from outside the class. Hence they are protected from unauthorized access. But if you want to view or modify them, you can use getters and setters.

# REFERENCE DATA TYPES
### Dereferencing

Dereferencing happens with the . (dot) operator.

```java
Object obj = new Object();
String text = obj.toString(); // 'obj' is dereferenced
```
Dereferencing  follows the memory address stored in a reference, to the place in memory where the actual object resides.
When an object has been found, the requested method is called (toString in this case).
When a reference has the value null, dereferencing results in a NullPointerException.

### Instantiating a Reference Type
````java
Object obj = new Object(); 
````
- Object is  reference type
- obj is the variable in which to store the new reference
- Object() is the call to constructor of ana Object
What Happens:
- space in memory is located for the object
- The constructor Object() is called to initialize that memory space
- The memory address is stored in the obj.,so that it reference the newly  created object
This is different in primitives where int i = 10, value 10 is stored in i.

# Documenting Java Code

For later update
# Command Line Argument Processing

# Literals

A java literal is a syntatic element

### Using underscore to improve readability
It is possible sinve java 7 to use one or more underscore (_) for seperating groups of didgits in a primitive number literal to improve readability. e.g

    int i1 123456;
    int i2 = 123_456;
    System.out.println(i1 == 12); // true

Use of underscore can be applied to all primitive number literals.

    byte color = 1_2_3;
    short yearsAnnoDomini= 2_016;
    int socialSecurtyNumber = 999_99_9999;
    long creditCardNumber = 1234_5678_9012_3456L; float piFourDecimals = 3.14_15F;
    double piTenDecimals = 3.14_15_92_65_35;

The underscore also works with:
    short binary= 0b0_1_0_1;
    int octal = 07_7_7_7_7_7_7_7_0; long hexBytes = 0xFF_EC_DE_5E;

To work with underscores, the following rules has to be abided by:

- It cannot be used at the beginning or end of a number(_123 - is not valid)
- Underscores cannot be used adjacent to decimal point in a floating point literal(1._23 or 1_.123 - is not valid)
- Underscores cannot be used prior to an L of F suffix(1.23F or 99999_L - is not valid)
- cannot be used where a string of didigts is expected(0_xFFFF is not valid).

### Hexadecimal, Octal and Binary literals
- A hexadecimal numvber is avalue in base 16. Tgere are 16 digits, 0-9 and letters A-F(case does not matter). A-F represents 10-15.
- An Octal number is a value in base-8 and uses the digits 0-7.
- A binary number is a value in base-2 and uses the digits 0 and 1.

All the above numbers result in the same value, 110.

    int dec = 110; // no prefix --> decimal literal
    int bin = 0b1101110; // '0b' prefix --> binary literal
    int oct = 0156 // '0' prefix --> octal literal;
    int hex = 0x6E // '0x' prefix --> hexadecimal literal.

The Octal literal can easily be a trap for semantic errors. If you define a leading '0' to your decimal literals you will get the wrong value.

    int a = 0100; // Instead of 100, a == 64

### Boolean literals
Boolean literals are the simplest literals in java, with two possible boolean value, true and false.

### String Literals

Provides the most convenient way to represents string values in java. A string literal consist of:
 - An opening double quote Character.
 - Zero or more other characters that are neither a double-quote or a line-break character.
 - Closing double quote character.

 ### The Null Literal

 The null literal(null) represents the one and only value of the null type.The null type has no name so you cannot express it in java, and has no runtime representation either.
 The sole purpose of the null type is to be of null. It is assignment compstible with all reference type, and can be type cast to any reference type.(in the later case, the cast does not entail a runtime type check.)
 Null has the property that null **instanceof** ``<SomereferenceType>`` will evaluate to false, no matter what the type is.

 ### Escape Sequence Literal

 String character literals provide an escape mechanism that allows express character codes that would otherwise not be allowed in the literal. An escape sequence consists of a backlash character(\\) followed by one or more other character. The same sequence are valid in both character and string literals. 

 ### Character Literals

 Provides the most convenient way to express char values in java source code.  A character literal consist of:
  - An opening single-quote(') character.
  - A representation of s character. This representation cannot be a singlr-quote or a line-break character, but it can be an escape sequence introduced by a backlash(\\) character.
  - A closing single quote(') character.

A line-break in a character literal is acompilation error.
    char newLine = '
    // compilation error in previous line
    char newLine = '\n' // correct

### Decimal Integer Literals

Integer literals provide values that can be used where you need a byte, short, int, long or char instance.
#### Ordinary Integer literals
The simplest and most common form of integer literal is a decimal integer literal
    0 // decimal number zero (type 'int')
    1 // The decimal number one (type 'int')
    42 // The decimal number forty two (type 'int')

Leading zeros cause an integer literal to be intepreted as octal not decimal.
    077 // this literal means 7 * 7 + 8 ... or 63 decimal!

Integer literals are unsigned. values like -10 or +10 are actually expressions using the unary -  and unary + operators
The range of integer literals of this form have an intrinsic type of int, and must fall in the range zero to 231 or 2,147,482,648 

231 is 1 greater than Integer.MAX_VALUE. Literals from 0 through to 2147483647 can be used anywhere, but is a compilation error to use 2147483648 without preceeding unary - uperator.(it is reserved for expressing the value of Integer.MIN_VALUE.)

    int max = 2147483647; // OK
    int min = -2147483648; // OK
    int tooBig = 2147483648; // ERROR
#### Long integer literals

Literals of type long are expressed by adding an L suffix.
    0L // The decimal number zero (type 'long')
    1L // The decimal number one (type 'long')
    2147483648L // The value of Integer.MAX_VALUE + 1
    long big = 2147483648; // Error
    long big2 = 2147483648L; //OK

The distinction between int and long literals is significant in other places

```java
int i = 2147483647;
long I = i + 1;  // Produces a negative value 
                // because the operation 
                // is performed using 32 bit 
                // arithmetic, and the 
                // addidtion overflows
long I2 = i + 1L // Produces the (intuitively correct value)
```

### Floating Point Literals

Floating point literals provide values that can be used where you need a float or double instance. The are three kinds of floating point literal.
 - Simple decimal forms
 - Scaled decimal forms
 - Hexadecimal forms

There are distinct literal  types for float and double literals, expressed using suffixes. The various forms use letters to express different things. These letters are case sensitive.

#### Simple Decimal Forms
The simplest form of floating point literal consists of one or more decimal digits  and a decimal point(.) and an optional suffix (f,F,d or D). The suffix helps in specifying if the literal is float(f or F) or double (d or D) value. The default(when no suffix is specified) is double.
Decimal digits followed by a suffix is also a floating point literal.

#### Scaled Decimal Forms

Scaled decimal forms consist of simple decimal with an exponent part introduced by an E or e, and followed by a signed integer. The exponent part is a short hand for multiplying the decimal form by a power ten. There is also an optional suffix to distinguish float and double literals.

    1.0E1 // this means 1.0 * 10^1 ... or 10.0 (double)
    1E-1D // this means 1.0 * 10^(-1) ... or 0.1(double)
    1.0e10f // this means 1.0 * 10^(10) ... or 10000000000.0(float)

The size ofnthe literal is limited by the representation (float or double). It is a compilation error if the scale factor results in a value that is too large or too small.

#### HexaDecimal Forms

From java 6, it is possible to express floating point literals in hexadecimal. The hexadecimal form have an analogous sysntax to the simple and scaled decimal forms with the following differences.

 1. Every hexadecimal floating pont value starts with a 0 and then x or X
 2. The digits of the number(but not the exponent part!) also includes the hexadecimal digits a through f and their uppercase equivalents.
 3. The exponent is manadatory, and is introduced by the letter p(or P) instead of an e or E. the exponent represents a scaling factor that is power of 2 instead of a power of 10.

    0x0.0p0f // this is zero expressed in hexadecimal form ('float')
    0xff.0p19 // this 255.0 * 2^19 ('double')

# PRIMITIVE DATA TYPES

The 8 primitive data types **byte**, **short**, **int** **long**, **char**, **boolean**, **float** and **double** are the types that store most raw numericals data in java programs.

### The char primitive
A char can store a single 16-bit Unicode character.

```java
char myChar = 'u';
char myChar2 = '5';
char myChar3 = 65; // myChar3 == 'A'
```
It has a minimum value of \u0000(0 in the decimal representation, also called the null character) and a maximum value of \uffff(65,535).
The default value of char is \u0000

    char defaultChar; // defaultChar == \u0000

In order to define a char ' value an escape sequence (chara cter preceded by a a backlash) has to be used;

    char singleQuote = '\'';
    // other escape sequences
    char tab = '\t';
    char backspace = '\b';
    char newline = '\n';
    char carriageReturn = '\r';
    char formfeed = '\f';
    char singleQuote = '\''
    char doubleQuote = '\""' // escaping is redundant as '"' would also work, however still allowed
    char unicodeChar = '\uXXXX' //represents a unicode value or character

You can declare a char of any unicode character

    char heart = '\u2764'; 

### Primitive types cheat sheet
    type   representation range default
    ____________________________________
    bolean | n/a | false and true | false

    byte | 8-bits signed | -27 to 27-1 |  0

    short | 16-bit signed | -215 to 215-1 | 0
                    |  -32,768 t0 +32,767|

    int | 32-bit signed | -231 to 231 - 1 | 0
    
        |-2,147,483,648 to +2,147,483,647  |
    long| 64-bit signed | -263 to 263-1 | 0L
    | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807|

    |float |32-bit floating point| 1.401298464e-45 to 3.402823466e+38 (positive or negative) |0.0F |

    |double| 64-bit floating point|4.94065645841246544e-324d to 1.79769313486231570e+308d(positive or negative)|0.0D

    |char | 16-bit unsigned |0 to 216 - 1| 0
          | 0 to 65,535|

Notes:
1. The Java Language Specification mandates that signed integral types (byte through long) use binary twos- complement representation, and the floating point types use standard IEE 754 binary floating point representations.
2. Java 8 and later provide methods to perform unsigned arithmetic operations on int and long. While these methods allow a program to treat values of the respective types as unsigned, the types remain signed types.
3. The smallest floating point shown above are subnormal; i.e. they have less precision than a normal value. The smallest normal numbers are 1.175494351e−38 and 2.2250738585072014e−308
4. A char conventionally represents a Unicode / UTF-16 code unit.
5. Although a boolean contains just one bit of information, its size in memory varies depending on the Java
Virtual Machine implementation

### The float Primitive

A float is a single precision 32-bit IEEE 754  floating point number. By default, decimals are interpreted as doubles. To create a float, an f is appended to the decimal literal.

```java
double doubleExample = 0.5; // without 'f' after digits = double
float floatExample = 0.5f; // with 'f' = float
float myFloat = 92.7f; // this is a float
float positiveFloat = 89.3f; // it can be positive
float negativeFloat = -89.3f; // or negative 
float integerFloat = 43.0f; //can be a whole numebr
float underZeroFloat = 0.0549f; // fractional value less than zero
```

floats handle the five common arithmetical operations: addition, subtraction, division, multiplication and modulus

*while using float is fine for most applications, neither float nor double should be used to store exact representations of decimal numbers (like monetary amounts) or numbers where higher precision is required instead, the BigDecimal class should be used*

**Note**: Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN are float values. NaN stands for results of operations that cannot be determined, such as dividing 2 infinite values. Furthermore 0f and -0f are different, but == yields true:

```java
float f1 = 0f;
float f2 = -0f;
System.out.println(f1 == f2); // true
System.out.println(1f / f1); // Infinity
System.out.println(1f / f2); // -Infinity System.out.println(Float.POSITIVE_INFINITY / Float.POSITIVE_INFINITY); // NaN
```

### The int primitive

A primitive data type such as int holds value directly into the variable that is using it, meanwhile a variable that was declared using Integer holds a reference to the value.

By default, int is a 32-bit signed integer.It can store minimum value of -231 and a maximum value  of 231-1.

```java
int example = -42; int myInt = 284;
int anotherInt = 73;
int addedInts = myInt + anotherInt; // 284 + 73 = 357
int subtractedInts = myInt - anotherInt; // 284 - 73 = 211
```

If you need to store a number outside of this range, long should be used instead. Exceeding the value range of int leads to an integer overflow, causing the value exceeding the range to be added to the opposite side of the range(positive becomes negative and vice versa). The value is((value - min_value) % RANGE) + MIN_VALUE, or ((value + 2147483648) % 4294967296) - 21447483648

```java
int demo = 2147483647; //maximum positive
 integer System.out.println(demo); //prints 2147483647 
 demo = demo + 1; //leads to an integer overflow 
 System.out.println(demo); //prints -2147483648
```

The maximum and minimum value of int can be found at:
```java
int high = Integer.MAX_VALUE; // high == 2147483647 
int low = Integer.MIN_VALUE; // low == -2147483648
```

The default value of int is 0.

### Converting primitives

In Java, you can convert between integer values and floating-point values. Also, since every character corresponds to a number in the Unicode encoding, char types can be converted to and from the integer and floating-point types. boolean is the only primitive datatype that cannot be converted to or from any other primitive datatype.
There are two types of conversions: widening conversion and narrowing conversion.
A widening conversion is when a value of one datatype is converted to a value of another datatype that occupies
more bits than the former. There is no issue of data loss in this case.
Correspondingly, A narrowing conversion is when a value of one datatype is converted to a value of another datatype that occupies fewer bits than the former. Data loss can occur in this case.
Java performs widening conversions automatically. But if you want to perform a narrowing conversion (if you are sure that no data loss will occur), then you can force Java to perform the conversion using a language construct known as a cast.

```java
// widening conversion
int a = 1
double d = a; // valid conversion
```

```java
// Narrowing conversion
double d = 18.96;
int b = d; // invalid conversion, throws compile time error
int b = (int) d; // valid conversion to int, but result is truncated(rounded down)
// this is type casting, b is now = 18.
```
### Memory Consumption of primitives vs. boxed primitives

Primitive - Boxed - memory - size primitive/boxed
_________________________________________________
boolean - Boolean - 1byte/16bytes

byte    - Byte    - 1byte/16byte

short   - Short   - 2bytes/16bytes

char    - Char    - 2bytes/16bytes

int     - Int     - 4bytes/16bytes

long    - Long    - 8bytes/16bytes

float   - float   - 4bytes/16bytes

double  - Double  - 8bytes/16bytes

Boxed objects always require 8 bytes for type and memory management, and because the size of objects is always a multiple of 8, boxed types all require 16 bytes total. In addition, each usage of a boxed object entails storing a reference which accounts for another 4 or 8 bytes, depending on the JVM and JVM options.

In data-intensive operations, memory consumption can have a major impact on performance. Memory consumption grows even more when using arrays: a float[5] array will require only 32 bytes; whereas a Float[5] storing 5 distinct non-null values will require 112 bytes total (on 64 bit without compressed pointers, this increases to 152 bytes).

#### Boxed value caches
The space overheads of the boxed types can be mitigated to a degree by the boxed value caches. Some of the boxed types implement a cache of instances. For example, by default, the Integer class will cache instances to represent numbers in the range -128 to +127. This does not, however, reduce the additional cost arising from the additional memory indirection.

If you create an instance of a boxed type either by autoboxing or by calling the static valueOf(primitive) method, the runtime system will attempt to use a cached value. If your application uses a lot of values in the range that is cached, then this can substantially reduce the memory penalty of using boxed types. Certainly, if you are creating boxed value instances "by hand", it is better to use valueOf rather than new. (The new operation always creates a new instance.) If, however, the majority of your values are not in the cached range, it can be faster to call new and save the cache lookup.

### The double primitive

A double is a double-precision 64-bit IEEE 754 floating point number

    double example = -7162.37; double myDouble = 974.21; double anotherDouble = 658.7;
    double addedDoubles = myDouble + anotherDouble; // 315.51 double subtractedDoubles = myDouble - anotherDouble; // 1632.91
    double scientificNotationDouble = 1.2e-3; // 0.0012

because of the way floating point number is stored, many numbers dont have an exact representation.

    double notExact = 1.32 - 0.42; // result should be 0.9 
    System.out.println(notExact); // 0.9000000000000001

while using double is fine for most applications, neither float nor double should be used to store precise numbers such as currency. Instead, the BigDecimal class should be used.

### The long primitive

By default, long is a 64-bit signed integer(in java 8, it can either be signed or unsigned). Signed, it can store a minimum value of -263 and a maximum value of 263-1, and unsigned it can store a minimum value of 0 and a maximum value of 264-1

    long example = -42; long myLong = 284; long anotherLong = 73;
    //an "L" must be appended to the end of the number, because by default,
    //numbers are assumed to be the int type. Appending an "L" makes it a long
    //as 549755813888 (2 ^ 39) is larger than the maximum value of an int (2^31 - 1), //"L" must be appended
    long bigNumber = 549755813888L;
    long addedLongs = myLong + anotherLong; // 284 + 73 = 357
    long subtractedLongs = myLong - anotherLong; // 284 - 73 = 211

The minimum and maximum value of long can be found at:
    long high = Long.MAX_VALUE; // high == 9223372036854775807L 
    long low = Long.MIN_VALUE; // low == -9223372036854775808L

**Note:** letter "L" appended at the end of long literal is case insensitive, however it is good practice to use capital as it is easier to distinct from digit one:

### The boolean primitive

A boolean can store one of two values, either true or false

### The byte primitive
A  byte is an 8-bits signed integer. It can store a maximum value of -27(-128), and a maximum value of 27-1(127)

    byte example = -36; 
    byte myByte = 96; 
    byte anotherByte = 7;
    byte addedBytes = (byte) (myByte + anotherByte); // 103
    byte subtractedBytes = (byte) (myBytes - anotherByte); // 89

The maximum and minimum value of byte can be found at:

    byte high = Byte.MAX_VALUE; // high == 127 
    byte low = Byte.MIN_VALUE; // low == -128

### The short primitive

A short is a 16-bit signed integer. It has a minimum value of -215(-32,768), and a maximum value of 215-1(32,767)

    short example = -48; short myShort = 987; short anotherShort = 17;
    short addedShorts = (short) (myShort + anotherShort); // 1,004 short subtractedShorts = (short) (myShort - anotherShort); // 970

The maximum and minimum values of a short can be found at:

    short high = Short.MAX_VALUE; // high == 32767 
    short low = Short.MIN_VALUE; // low == -32768


