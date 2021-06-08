package kodlamaio.northwindd.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message);//yukardaki paramatleri base eden bir ctor var bu yuzden bunları set etmeye gerek yok.
		//super bilgisi base sınıfın constructorlarını calıstırır.
		// TODO Auto-generated constructor stub
		
		this.data = data; //datayı set etmiş olduk.
	}
	
	
	//bu constructorda message bilgisi gecmek zorunda değiliz.
	public DataResult(T data, boolean success) {
		super(success);//yukardaki paramatleri base eden bir ctor var bu yuzden bunları set etmeye gerek yok.
		//super bilgisi base sınıfın constructorlarını calıstırır.
		// TODO Auto-generated constructor stub
		
		this.data = data; //datayı set etmiş olduk.
	}
	
	//şimdi datayı okumak ıcın getter yazcaz
	
	
	public T getData() {
		
		return this.data; //datayı döndürdük.
	}


}
