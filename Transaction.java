class Transaction {
    private double total;
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
    this.data = data;
	}

  public void total() {
    total = price*amount;
  }
  /*
  public void saveTransaction() {
    data.addTransaction
  }



*/

























  //sets and gets

  	public double getTotal() {
  		return total;
  	}

  	public String getPayment() {
  		return payment;
  	}

  	public int getCantidad() {
  		return Cantidad;
  	}

  	public Drink getProduct() {
  		return product;
  	}

  	public CurrentDate getDatetime() {
  		return datetime;
  	}

  	public void setTotal(double total) {
  		this.total = total;
  	}

  	public void setPayment(String payment) {
  		this.payment = payment;
  	}

  	public void setCantidad(int Cantidad) {
  		this.Cantidad = Cantidad;
  	}

  	public void setProduct(Drink product) {
  		this.product = product;
  	}

  	public void setDatetime(CurrentDate datetime) {
  		this.datetime = datetime;
  	}
  }
