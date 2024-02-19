# StringBuffer

## String Buffer Class

Key Points:
- Used for creating mutable String.
- Is thread safe i.e multiple threads cannnot access it simultaneously.

Methods:
- public synchronized StringBuffer append(String s)
- public synchronized StringBuffer insert(int offset, String s)
- public synchronized StringBuffer replace(int startIndex, int endIndex, String str) 
- public synchronized StringBuffer delete(int startIndex, int endIndex)
- public synchronized StringBuffer reverse()
- public int capacity()
- public void ensureCapacity(int minimumCapacity)
- public char charAt(int index)
- public int length()
- public String substring(int beginIndex)
- public String substring(int beginIndex, int endIndex)

```java
class Test {
public static void main(String args[]) {
String str = "study";
str.concat("tonight"); System.out.println(str); // Output: study

StringBuffer strB = new StringBuffer("study"); strB.append("tonight");
System.out.println(strB); // Output: studytonight
} }
```