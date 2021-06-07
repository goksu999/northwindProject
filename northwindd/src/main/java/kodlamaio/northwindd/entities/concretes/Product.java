package kodlamaio.northwindd.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //veritabanı tarafında otomatık olarak olusturulcak buna strateji denir.
	@Column(name = "product_id")
	private int id;

	//@Column(name = "category_id") 36. satırdaki işlemlerden dolayı burayı yazmaya gerek yok.
	//private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	
	@ManyToOne() // bunların arasında manytoone ilişki var.
	@JoinColumn(name="category_id") // ilişkilendirilecek colonu seceriz.
	private Category category;//ürünün tek bir kategorisi var dolayısıyla liste seklinde yazılmaz bu yüzden bunu olusturduk.


	public Product() {

	}

	public Product(int id, String productName, double unitPrice, short unitsInStock,
			String quantityPerUnit, Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
		this.category = category;
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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
