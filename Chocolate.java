class Chocolate extends Drink  {
  //Construct
    private String type;
    public Chocolate(double price,String code, String name,String size, Recipe recipe,String type, int quantity){ //blanco o negro (chocolate)
      super(price,code,name,size,recipe, quantity);
    }
  //Set
    public void setSize(String size){
      this.size = size;
    }
  //Get
    public String getSize(){
      return size;
    }
}
