# String Tokenizer

The java.util.StringTokenizer class allows you to break a string into tokens. It is a simple way to break a string.The set of delimiters (the characters that seperate tokens) may be specified either at creation time or per token basis.
## StringTokenizer Split by Space

```java
import java.util.StringTokenizer
public class Simple{
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer("apple ball cat dog", " ");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
```

## StringTokenizer split by comma ','

```java
public static void main(String args[]) {
StringTokenizer st = new StringTokenizer("apple,ball cat,dog", ","); 
while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
}
```

# Splitting a String into Fixed length parts

## Break a string up into substrings all of a known length

The trick is to use a look-behind with the regex \G, which means "end of previous match":

    String[] parts = str.split("(?<=\\G.{8})");

The regex matches 8 characters after the end of the last match. Since in this case the match is zero-width, it could be more simply said "8 characters after the last matach".

## Break a String up into substsrings all of variable length

Same as tbe known length example, but inserts the length into regex.

    int length = 5;
    String[] parts = str.split("(?<=\\G.{" + length + "})");