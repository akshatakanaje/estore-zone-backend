package com.simplilearn.estorezone.enduser.model;


/**
 * carts Model
 * @author akshata
 *
 */
public class Carts {
	
	//carts model attributes
	private int cartId;
	private int productId;
	private int userId;
	private int quatity;
	
	
	//default constructor
	public Carts() {
		
	}

    
	//parameterized constructor
	public Carts(int cartId, int productId, int userId, int quatity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.quatity = quatity;
	}


	//getters and setters methods
	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getQuatity() {
		return quatity;
	}


	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}


	//override to string
	@Override
	public String toString() {
		return "Carts [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + ", quatity=" + quatity
				+ "]";
	}
	
	
	
	

}
