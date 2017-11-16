import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
abstract class Report {
protected int reportCount;
protected CurrentDate date;
protected String title;
protected Json save;
protected SaveToFile f;
protected String path;

public Report(CurrentDate date, String title, Json save, SaveToFile f,String path) {
        this.date = date;
        this.title = title;
        this.save = new Json();
        this.path = path;
        this.f = f;
}

public abstract ArrayList<String> values();
public abstract ArrayList<String> names();




public CurrentDate getDate() {
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
