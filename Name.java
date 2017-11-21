import java.io.*;
import java.util.*;
class Name implements Serializable
{
   private String first;
   private String mid;
   private String last;

   public Name(String first, String mid, String last)
   {
      setFirst(first);
      setMid(mid);
      setLast(last);
   }
   public void setFirst(String first)
   {
      this.first = first;
   }
   public void setMid(String mid)
   {
      this.mid = mid;
   }
   public void setLast(String last)
   {
      this.last = last;
   }
   public String firstName()
   {
      return first;
   }
   public String midName()
   {
      return mid;
   }
   public String lastName()
   {
      return last;
   }


	@Override
	public String toString() {
    return first + " " + mid + " " + last;
  }
}
