class Drink extends Product{//Abstract or Inteface?
  protected String size;
<<<<<<< HEAD
  protected Recipe recipe;

  //Construct
	public Drink(String size, Recipe recipe, CurrentDate timestamp) {
		super(timestamp);
		setSize(size);
	}
  //Set
	public String getSize() {
		return size;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	@Override
	public String toString() {
		return "Drink [size=" + size + ", recipe=" + recipe + "]";
	}
=======
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
>>>>>>> f9ab885f52351afb595159d34d874785df0e13b1
}
