# Date Class

## Convert java.util.Date to java.sql.Date

java.util.Date to java.sql.Date conversion is usually necessary when a Date object needs to be written in a database.

java.sql.Date is a wrapper around millisecond value and is used by JDBC to identify an SQL DATE type.

```java
public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is : " + utilDate);
        java.sql.Date sqlDate = convert(utilDate);
        System.out.println("java.sql.Date is : " + sqlDate);
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        System.out.println("dateFormated date is : " + df.format(utilDate));
    }

    private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

// output
java.util.Date is : Mon Feb 19 18:58:23 EAT 2024
java.sql.Date is : 2024-02-19
dateFormated date is : 19/02/2024 - 06:58:23
```
java.util.Date has both date and time information, whereas java.sql.Date only has date information.

## A basic date output

```java
// define the format to use
String formatString = "yyyy/MM/dd hh:mm.ss"; // get a current date object
Date date = Calendar.getInstance().getTime(); // create the formatter
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString); // format the date
String formattedDate = simpleDateFormat.format(date); // print it
System.out.println(formattedDate);
// single-line version of all above code
System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss").format(Calendar.getInstance().getTime()));
```

## Java 8 LocalDate and LocalDateTime objects

Date and LocalDate objects cannot be exactly converted between each other since a Date object represents both a specific day and time, While a LocalDate object does not contain time or timezone information.

