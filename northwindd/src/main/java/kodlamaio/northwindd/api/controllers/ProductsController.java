package kodlamaio.northwindd.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwindd.business.abstracts.ProductService;
import kodlamaio.northwindd.core.utilities.result.DataResult;
import kodlamaio.northwindd.core.utilities.result.Result;
import kodlamaio.northwindd.entities.concretes.Product;
import kodlamaio.northwindd.entities.dtos.ProductWithCategoryDto;

@RestController //sen bir controllersın demek her katmanda iş yapan sınıflara anatasyon ekledık.
@RequestMapping("/api/products") //productscontroller bu işlemi yapacak.
//bu anatasyonla ile birlikte birden fazla controller olabilir demek istiyoruz, hepsiburada urun yonetımı ıcın bir controler sepet işlemleri için bir controller vs vs.dk 2 saat 14.
@CrossOrigin //cors hatasının cozumu frontend ve backendın beraber calısmasını saglar
public class ProductsController {

	private ProductService productService;
	
	@Autowired // Burası 21. satırda gelen parametreyi(ProductService) lazım dıyor projeyi tarıyor ve bu kısmı buluyor otomatık olarak.KISACASI BİZ NEWLEMIYORUZ AUTOWIRED NEWLIYOR BİZİM YERIMIZE.Aslında elimizde productmanager var cnku servic i newledik.
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") //kodlama.io/api/products/getall böyle bir istek gelirse bu kısım calısır.
	public DataResult<List<Product>> getAll(){ //burası bir method, operasyon.
		
		return this.productService.getAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails") //kodlama.io/api/products/getall böyle bir istek gelirse bu kısım calısır.
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){ //burası bir method, operasyon.
		
		return this.productService.getProductWithCategoryDetails();
	}
	
	
	//ekleme operasyonu için metod yazıcaz.
	//bu ekleme oldugundan dolayı @post  yapacaz
	//Post işlemlerinde parametre ile calısılırsa gelen requestin bodysı var deriz ve 41. satırdaki anatasyonu kullanırız, bu bir poost işlemi execute 
	//dediğimizde dk 2.23.36  mesaj gövdesıne name kısmındaki bilgileri de json datasına döndürüp onları da gönderiyor. ÖNEMLİİİİ
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){ //bu bir public method. productname ve category e gore data geitrdik.
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		
		return this.productService.getByProductNameContains(productName);
	}
	
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted(){
		
		return this.productService.getAllSorted();
	}
}
