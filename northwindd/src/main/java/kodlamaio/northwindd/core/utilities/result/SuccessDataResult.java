package kodlamaio.northwindd.core.utilities.result;


//işlemin basarılı oldugu noktadaki dataresultı nı dondurcez.
//ürün listesi ürün kategori kategori listesi donebilir bu yzuden generic olur.
//true olan versiyonunu burda yazcaz dataresult ın.
public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data, String message) { //okunusu : bana bir tane data ver bir tanede success bilgisi ver demek.
		super(data, true, message); //true = succes zaten basarılı oldugu ıcın true bilgisi girdik.
	}

	public SuccessDataResult(T data) { //sadece datayı ve success bilgisini döndürdükk.
		super(data,true);
	}
	
	public SuccessDataResult(String message) { //okunusu :  sadece message döndurmek istiyorum.
		super(null, true, message); //data döndürmek istemedim  mesage ve success döndürdüm.
	}
	
	public SuccessDataResult() { //okunusu :  sadece message döndurmek istiyorum.
		super(null, true); //data döndürmek istemedim  mesage ve success döndürdüm.
	}
	
}
