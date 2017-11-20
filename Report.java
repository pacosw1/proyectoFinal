import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
abstract class Report {
protected int reportCount;
protected CurrentDate date;
protected String title;
protected Json save;
protected Inventory f;
protected String path;

public Report(CurrentDate date, String title, String path){
        this.date = date;
        this.title = title;
        this.path = path;
}

public abstract ArrayList<String> values();
public abstract ArrayList<String> names();




public CurrentDate getDate(){
        return date;
}

public String getTitle() {
        return title;

}

public void setDate(CurrentDate date) {
        this.date = date;
}

public void setTitle(String title) {
        this.title = title;
}
}
