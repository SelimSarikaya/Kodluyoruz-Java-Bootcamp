package q10;


public class Invoice {
	
	 private double amount;

	 
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	 
	
	public void calculateInvoice(Order order) {
		double total = 0;
		for (Product product : order.getProducts()) {
    	total += product.getPrice();
		}
		setAmount(total);
	}

	@Override
	public String toString() {
		return "Amount= " + amount;
	}
	
	

}
