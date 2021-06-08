package kodlamaio.northwindd.core.utilities.results;

public class Result {

	private boolean success;
	private String message;
	
	
	//burada sadece true false bilgisi gectik yani success
	public Result(boolean success) {
		this.success = success;//this.success = parametre ile gönderilen success
	}
	
	//burda hem success hemde message bilgisi gectik.
	public Result(boolean success, String message) {
		this(success);//yukardaki tek parametleri ctor u cagırmıs olduk.
		this.message = message;
	}
	
	//şimdi getter yazacaz dısarıdan erişimi saglamak amacıyla success ve message bilgisi icin
	public boolean isSuccess() {
		
		return this.success;
	}
	
	public String getMessage() {
			
			return this.message;
		}
}
