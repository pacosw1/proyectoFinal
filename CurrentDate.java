import java.io.*;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

class CurrentDate implements Serializable {
Date date = new Date();
LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
int year  = localDate.getYear();
int month = localDate.getMonthValue();
int day   = localDate.getDayOfMonth();

public CurrentDate() {
};

public int day()
{
        return day;
}
public int month()
{
        return month;
}
public int year()
{
        return year;
}

public String toString() {
        return day + "." + month + "." + year;
}
}
