package q10;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Product> products;
	private Invoice invoice;
	
	public Order() {
		products = new ArrayList<>();
	}

	public void addProduct(Product product) {
	    products.add(product);
	}
	public List<Product> getProducts() {
	    return products;
	}
	
	public void setInvoice(Invoice invoice) {
		    this.invoice = invoice;
	}
	public Invoice getInvoice() {
		    return invoice;
	}


	@Override
	public String toString() {
		return "Order [products=" + products + ", invoice=" + invoice + "]";
	}
		
	

}
