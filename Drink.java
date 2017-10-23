class Drink extends Product{
  protected String size;

  //Construct
	public Drink(String size) {
		super();
		setSize(size);
	}
  //Set
  public void setSize(String size) {
    this.size = size;
  }
  //Get
  public String getSize() {
    return size;
  }

}
