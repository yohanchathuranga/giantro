package supplement_shop_model;

public class supplement_shop_product {
	
	

	private String product_name;
	private String image_url;
	private int price;
	private double selling_price;
	private int discount;
	private String description;
	private String article_url;
	private String user_id;
	private String product_id;
	private String viewd_count;
	
	
	public String getViewd_count() {
		return viewd_count;
	}
	public void setViewd_count(String viewd_count) {
		this.viewd_count = viewd_count;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getArticle_url() {
		return article_url;
	}
	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}
	public double getSelling_price() {
		
		return selling_price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
		double s= (double) (discount*0.01);
		//System.out.println("check 1"+this.price*s);
		this.selling_price= (double)this.price*(s);
		//System.out.println(s);
		//System.out.println("selling price"+this.selling_price);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void set_selling_price() {
		double discount =(double) (this.discount*0.01);
		this.selling_price= this.price- this.price*discount;
		
	}

	
	

}
