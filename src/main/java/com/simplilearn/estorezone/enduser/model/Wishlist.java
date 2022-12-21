package com.simplilearn.estorezone.enduser.model;

/**
 * WishList Mode
 * @author Akshata 
 *
 */
public class Wishlist {
	
	//wishList model properties
	private int wishList;
	private int productId;
	private int userId;
	
	
	//default constructor
	public Wishlist() {
		
	}


	//parameterized constructor
	public Wishlist(int wishList, int productId, int userId) {
		super();
		this.wishList = wishList;
		this.productId = productId;
		this.userId = userId;
	}


	//getters and setters methods
	public int getWishList() {
		return wishList;
	}


	public void setWishList(int wishList) {
		this.wishList = wishList;
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


	//override to string
	@Override
	public String toString() {
		return "Wishlist [wishList=" + wishList + ", productId=" + productId + ", userId=" + userId + "]";
	}
	
	 

}
