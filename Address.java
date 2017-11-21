class Address 
{
   private String street;
   private String number;
   private String col;
   
   public Address(String street,String number, String col) 
   {
      setStreet(street);
      setNumber(number);
      setCol(col);
   }
   public void setStreet(String street) 
   {
      this.street = street;
   }
   public void setNumber(String number) 
   {
      this.number = number;
   }
   public void setCol(String col) 
   {
      this.col = col;
   }
   
   public String street() 
   {
      return street;
   }
   public String toString() 
   {
    return "Dirrecion: \n " + number + street +", " + col;
    
   }
   public String number() 
   {
      return number;
   }
   public String col() 
   {
      return col;
   }



}