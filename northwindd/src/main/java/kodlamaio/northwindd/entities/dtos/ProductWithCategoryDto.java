package kodlamaio.northwindd.entities.dtos;

public class ProductWithCategoryDto {

	//1 saat 14.dk ders 9 anlatıyor dto yu.
	private int id;
	private String productName;
	private String categoryName;
	
	
	public ProductWithCategoryDto() {
		
		
	}
	
	public ProductWithCategoryDto(int id, String productName, String categoryName) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
