import java.lang.reflect.Field;
abstract class Report {
protected CurrentDate date;
protected String title;
protected SaveToFile save;
protected String fileName;

public Report(CurrentDate date, String title, SaveToFile save, String fileName) {
        this.date = date;
        this.title = title;
        this.save = new SaveToFile();
        this.fileName = fileName;
}

public abstract void saveReport();


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
