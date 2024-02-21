import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        // java.util.Date utilDate = new java.util.Date();
        // System.out.println("java.util.Date is : " + utilDate);
        // java.sql.Date sqlDate = convert(utilDate);
        // System.out.println("java.sql.Date is : " + sqlDate);
        // DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        // System.out.println("dateFormated date is : " + df.format(utilDate));
        basicDate();
    }

    public static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static void basicDate(){
        // define the format to use
        String formatString = "yyyy/MM/dd hh:mm.ss"; 
        // get a current date object
        Date date = Calendar.getInstance().getTime(); 
        // create the formatter
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString); 
        // format the date
        String formattedDate = simpleDateFormat.format(date); 
        // print it
        System.out.println(formattedDate);
        // single-line version of all above code
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss").format(Calendar.getInstance().getTime()));
    }
}
