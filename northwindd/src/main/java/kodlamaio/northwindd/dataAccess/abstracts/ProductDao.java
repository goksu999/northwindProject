package kodlamaio.northwindd.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwindd.entities.concretes.Product;
import kodlamaio.northwindd.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
	//Asagıkdailerin hepsi hazır sekilde gelir onemli olan dogru sekilde yazmak getBy..
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);//category_categoryıd demek lazım = categorının category ıdsi diye okunur ve boyle yazılır.
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); //burda or operatoru var bu işlemler jpa repository tarafından hazır olarak gelir.
	//isimlendirme hatası yaptık dogrusu yukardaki gibi biz ...OrCategoryId yazmıstık category yazmamız gerekir.
	
	List<Product> getByCategoryIn(List<Integer> categories); //select * from products where category_id in(1,2,3,4) bu işlemi yaptık 1 2 3 4 ü içerenleri getir. categoryIdleri getir product türünde, categorieslei integer türünde listele .
	
	//ürünün ismine göre arama  işlemi
	List<Product> getByProductNameContains(String productName);
	
	//Özel bir isimle baslayanları getirir.
	List<Product> getByProductNameStartsWith(String productName);
	
	//JPQL, bu yapıda listenin içinde bi tane döndürür.
	//select yazmaya gerek yok From ile başla, Product entities den al ve yaz, : ile parametre gecilir, parametreler asagıda => 31. satır.
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") //burdaki değerler Product içindeki alanladır.categoryId vs vs, category.categoryId=:categoryId => product ın categorisinin categoryıd si diye okunur.
	//yukardaki jpql dir.
	List<Product> getByNameAndCategory(String productName, int categoryId);
	//select * from products where product_name=bisey and categoryId=bisey
	
	@Query("Select new kodlamaio.northwindd.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p") //1 saat 20. dk anlatıyor.ÖNEMLİİİİİİİ
	List<ProductWithCategoryDto> getProductWithCategoryDetails();//burası imza diye adlandırılır.
	//37. satırda asagıdaki belli baslı alanları cekmek istediğimiz için select kodlama.. From yazarız.
	//select p.productId, p.productName, c.categoryName from Category c inner join Product p
	//on c.categoryId = p.categoryId
	
}
