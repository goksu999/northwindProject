package kodlamaio.northwindd.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
    //veritabanındaki değerleri buraya yazıyoruz.
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category") // okunusu asagıdaki products mappedBy categories ile, yani products categories ile ilişkilendirilmiş demek. Aralarındaki ilişki one to many dir.
	//Şu an categori deyiz ,categoriden productsa one to many şeklinde gidiyoruz.
	private List<Product> products;//BURDA İLİŞKİ YAPISI KURCAZ BURASI ANA TABLOMUZ BURASI ÖNEMLİ, ANA TABLODAN DİĞER TABLOYA GEÇİŞ YAPCAZ.
	//BURASI CATEGORİNİN ÜRÜNLERİDİR.
	
	
	public Category() {
		
		
	}
	
	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
