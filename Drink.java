class Drink extends Product{//Abstract or Inteface?
  protected String size;
  /*public double calculatePrice(); price depends on size
  Sizes: small = $, medium = $, tall = $*/
  //Construct
  	public Drink(String size, CurrentDate timestamp) {
  		super(timestamp);
  		setSize(size);
  	}
  //Set
    public void setTimestamp(CurrentDate timestamp){
      this.timestamp = timestamp;
    }
    public void setSize(String size) {
      this.size = size;
    }
  //Get
    public CurrentDate getTimestamp(){
      return timestamp;
    }
    public String getSize() {
      return size;
    }
}
