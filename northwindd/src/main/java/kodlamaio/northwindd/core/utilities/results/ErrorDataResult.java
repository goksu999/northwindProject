package kodlamaio.northwindd.core.utilities.results;


//işlemin basarısız oldugu noktadaki dataresultı nı dondurcez.
public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult(T data, String message) { //okunusu : bana bir tane data ver bir tanede success bilgisi ver demek.
		super(data, false, message); 
	}

	public ErrorDataResult(T data) { //sadece datayı ve success bilgisini döndürdükk.
		super(data,false);
	}
	
	public ErrorDataResult(String message) { //okunusu :  sadece message döndurmek istiyorum.
		super(null, false, message); //data döndürmek istemedim  mesage ve success döndürdüm.
	}
	
	public ErrorDataResult() { //okunusu :  sadece message döndurmek istiyorum.
		super(null, false); //data döndürmek istemedim  mesage ve success döndürdüm.
	}
	
}
