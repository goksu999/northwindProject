package kodlamaio.northwindd.business.abstracts;

import java.util.List;

import kodlamaio.northwindd.core.utilities.results.DataResult;
import kodlamaio.northwindd.core.utilities.results.Result;
import kodlamaio.northwindd.entities.concretes.Product;
import kodlamaio.northwindd.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll(); //list<Product> datanın türü budur ve dataresult ın ıcıne gonderdık.
	DataResult<List<Product>> getAll(int pageNo, int pageSize); //sayfalama için birseyler yapıcaz. => Örnegin bir sayfada 10 data olacaktır 100 ürün için 10 sayfa gelcek, biz 7. sayfayı istiyoruz,
	//bu yuzden 71. üründen itibaren 79. ürüne kadar gostercez mantık bu.
	//pagesize bi sayfada kac data var onu tutuyoruz bu parametrede.
	DataResult<List<Product>> getAllSorted(); //datayı sıralama işlemleri için bunu olusturduk => getallsorted
	Result add(Product product); // bizim döndurecegimiz base resultın kendisi ve add operasyonu ile bir tane product isteyip bu product ı ekliyor olacagız.
	
	
	//Asagıdakiler productdao dan geldi, sadece query sildik onunla işimiz yok burda
	//Ve asagıkdalılerin hepsi data döneceği icin başlarına dataresult ekleyecegiz.
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId); //burda or operatoru var bu işlemler jpa repository tarafından hazır olarak gelir.
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories); //select * from products where category_id in(1,2,3,4) bu işlemi yaptık 1 2 3 4 ü içerenleri getir. categoryIdleri getir product türünde, categorieslei integer türünde listele .
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
}
