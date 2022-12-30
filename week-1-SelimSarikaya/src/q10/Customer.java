package q10;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private int age;
	private List<Order> orders;
	private Invoice amount;
	
	
	public Invoice getAmount() {
		return amount;
	}


	public void setAmount(Invoice amount) {
		this.amount = amount;
	}


	//invoice ekleyip denenebilir!!
	public Customer() {
		this.orders = new ArrayList<>();
	}
	

	public void addOrder(Order order) {
		orders.add(order);
	}
	public List<Order> getOrders() {
		return orders;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
		
	
	
}
