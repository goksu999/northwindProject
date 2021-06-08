package kodlamaio.northwindd.core.utilities.results;

//basarılı olma durumu icin class olsuyturduk.
public class SuccessResult extends Result{

	public SuccessResult() { //mesaj vermıyor parametre yok.
		
		super(true);
	}
	
	public SuccessResult(String message) { 
		
		super(true,message);
	}
}
