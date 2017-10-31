class Transaction {
    private double total;
    private String payment-type;
    private int Cantidad;
    private Drink product;
    private CurrentDate datetime;

	  public Transaction(double total, String payment, int Cantidad, Drink product, CurrentDate datetime) {
		this.total = total;
		this.payment = payment;
		this.Cantidad = Cantidad;
		this.product = product;
		this.datetime = datetime;
	}






























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
