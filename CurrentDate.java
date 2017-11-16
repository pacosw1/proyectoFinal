import java.io.*;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.LocalTime;

class CurrentDate implements Serializable {
Date date = new Date();
LocalTime now = LocalTime.now();
LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
private int year  = localDate.getYear();
private int month = localDate.getMonthValue();
private int day   = localDate.getDayOfMonth();
private int hour = now.getHour();
private int min = now.getMinute();
private int sec = now.getSecond();




public String toString() {
        return hour + ":"+min+":"+sec+" | "+ day + "/" + month + "/" + year;
}



public int getYear() {
        return year;
}

public int getMonth() {
        return month;
}

public int getDay() {
        return day;
}

public int getHour() {
        return hour;
}

public int getMin() {
        return min;
}

public int getSec() {
        return sec;
}

public void setYear(int year) {
        this.year = year;
}

public void setMonth(int month) {
        this.month = month;
}

public void setDay(int day) {
        this.day = day;
}

public void setHour(int hour) {
        this.hour = hour;
}

public void setMin(int min) {
        this.min = min;
}

public void setSec(int sec) {
        this.sec = sec;
}
}
