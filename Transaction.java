class Transaction {
    private double price;
    private String payment;
    private int amount;
    private Drink product;
    private CurrentDate datetime;
    //private Database data;

	  public Transaction(double price, String payment, int amount, Drink product, CurrentDate datetime) {
		this.price = price;
		this.payment = payment;
		this.amount = amount;
		this.product = product;
		//this.datetime = datetime;
    //this.data = data;
	}

  public void total() {
    price = price*amount;
  }
  /*
  public void saveTransaction() {
    data.addTransaction
  }



*/

























  //sets and gets

  
  	public String getPayment() {
  		return payment;
  	}

  	public int getAmount() {
  		return amount;
  	}

  	public Drink getProduct() {
  		return product;
  	}

  	public CurrentDate getDatetime() {
  		return datetime;
  	}

  	 
  
    }
