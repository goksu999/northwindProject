package kodlamaio.northwindd.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwindd.business.abstracts.ProductService;
import kodlamaio.northwindd.core.utilities.results.DataResult;
import kodlamaio.northwindd.core.utilities.results.Result;
import kodlamaio.northwindd.core.utilities.results.SuccessDataResult;
import kodlamaio.northwindd.core.utilities.results.SuccessResult;
import kodlamaio.northwindd.dataAccess.abstracts.ProductDao;
import kodlamaio.northwindd.entities.concretes.Product;
import kodlamaio.northwindd.entities.dtos.ProductWithCategoryDto;


@Service//productmanagere anatasyon verdık busıness gorevı gorecek demektir productmanager ın.
public class ProductManager implements ProductService{

	private ProductDao productDao;//constructor ile injection ını yaptık productdaonun.
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		//succesdata result döndurücem, datası this.productDao.findAll, mesajı da data listelendi dir.
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "Data listelendi" );
				
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product); // save metodu ile hızlıce ekleme silme işlemleri yapılır
		return new SuccessResult("Ürün eklendi"); // succesresult dondurcez data olmadıgı için bunu yazdık.
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product> //list of değil 32. satırdaki gibi , sadece tek bir product
		(this.productDao.getByProductName(productName), "Data listelendi" );
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business code yazılır.
		
		return new SuccessDataResult<Product> 
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId), "Data listelendi" );
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listelendi" );
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories), "Data listelendi" );
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName), "Data listelendi" ); //dao dan istediğimiz method => getByProductNameContains
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName), "Data listelendi" );
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName, categoryId), "Data listelendi" );
	}

	//jpa ile sayfalandırma, daoda bunun için bi işlem yapmaya gerek yok.bu yuzden findall dan pagelable kullanıcaz
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);//pageable importu domain olan secilecek. -1 demesek swaggerde pageno 1 pagesize 10
		//degerlerini verdiğimizde sonuc 11 den baslar yani 2. sayfadan baslıyor gibi , bu yuzden eksi bie dıyoruz.sayfalamayı sıfırdan baslatır bu yuzden pageno-1 deriz.
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(pageable).getContent(),"Başarılı");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		//data domainden gelir sort.
		Sort sort = Sort.by(Sort.Direction.DESC,"productName"); // sort direction kullandık hangi yönde yani.DESC SECTİK YANİ AZALAN.productname alanına gore listelencek.
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(), "Data listelendi" );
	}

}
