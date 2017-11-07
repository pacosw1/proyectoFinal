class Product {
  protected CurrentDate timestamp;
  //Construct
  	public Product(CurrentDate timestamp) {
      setTimestamp(timestamp);
  	}
  //Set
  	public void setTimestamp(CurrentDate timestamp) {
  		this.timestamp = timestamp;
  	}
  //Get
    public CurrentDate getTimestamp() {
  		return timestamp;
  	}
}
