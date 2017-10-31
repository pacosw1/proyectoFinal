import java.io.*;
class Product {
  protected CurrentDate timestamp;


	public Product(CurrentDate timestamp) {
    setTimestamp(timestamp);
	}


	public CurrentDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(CurrentDate timestamp) {
		this.timestamp = timestamp;
	}
}
