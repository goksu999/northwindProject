package kodlamaio.northwindd.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwindd.business.abstracts.UserService;
import kodlamaio.northwindd.core.entities.User;
import kodlamaio.northwindd.core.utilities.result.ErrorDataResult;


//ÖNCE ANATASYONLAR YAZILDI.
@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	//2.OLARAK USERSERVİCE'İ KULLANICAZ İNJECTİON YANİ.
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add") // kullanıcı data veriyor, bunu ekle gibi bu durumlarda post kullanılır.
	public ResponseEntity<?> add(@Valid @RequestBody User user) { // ? yerine result yazmıstık daha onceden, ? =>  ne döneceğine şimdi karar vermıyorum, işlem sonucuna gore ekle result veya errordataresult vb  donebilir.
		//valid => bu dogrulanması gereken bir alan, o yuzden bu anatasyonu ekledik, user user ı validasyondan gecir demek.
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	//bu sistemde validatıon hatası olursa bunu devreye sok demek bu anatasyon
	//methodargumentnotvalidexception => SPRİNG VALİDATIONDAN GELİR, BÜTÜN VALİDASYON HATALARINI DOGRULAMA HATALARI YANİ, REQUİRED NOTNULL(notnal) EMAİL GİBİ BU ALANLARI M.A.N.VALİDEXCEPTİON OLARAK GECER.
	//.class => type bu şekilde verilir.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)//asagıdaki method default olarak badrequest donsün yani 500 hatası diyoruz buna.
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		//iki alan verecegimiz için ornegin email formatına uygun mu veya bos geçişmiş mi bu yüzden map yapısı kullancaz
		//iki tip verdik , ilk deger anahtar email alanında yani, hata da 2. string olan,  email alanı formata uygun değil gibi.
		//hashmap bir map implementasyonu abstract olarak gelecegi için hashmap dedik.
		Map<String,String> validationErrors = new HashMap<String,String>();
		
		//getfilederrors alanlarda olusan hataları oku örneğin user.
		//bunu okumak için liste dönmesi gerek, yani herbir field error ,bu yuzden field error yazdık. Her bir field error için diye okunur.
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());//validationErrors a hashmap i put olarak ekliyoruz.
			
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}

