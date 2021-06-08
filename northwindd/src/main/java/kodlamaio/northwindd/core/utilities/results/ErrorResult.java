package kodlamaio.northwindd.core.utilities.results;


//basarısız olma durumu ıcın bunu olusturduk.
public class ErrorResult extends Result{

	public ErrorResult() { //mesaj vermıyor parametre yok.
		
		super(false);
	}
	
	public ErrorResult(String message) { 
		
		super(false,message);
	}
}
