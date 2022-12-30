package q10;

public class Product {
	
	private String category;
	private double price;
	private String name;
	private int stock;
	
	
	
	public Product(String category, double price, String name, int stock) {
		super();
		this.category = category;
		this.price = price;
		this.name = name;
		this.stock = stock;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [category=" + category + ", price=" + price + ", name=" + name + ", stock=" + stock + "]";
	}
	
	
}
