import java.io.*;
import java.util.*;
class Time{
private String bestRange;
private String popularHour;
    //Construct
    public Time(String bestRange, String popularHour){
          setBestRange(bestRange);
          setPopularHour(popularHour);
    }
    //Set
    public void setBestRange(String bestRange){
           this.bestRange = bestRange;
    }
    public void setPopularHour(String popularHour){
            this.popularHour = popularHour;
    }
    //Get
    public String getBestRange(){
            return bestRange;
    }
    public String getPopularHour(){
            return popularHour;
    }
}