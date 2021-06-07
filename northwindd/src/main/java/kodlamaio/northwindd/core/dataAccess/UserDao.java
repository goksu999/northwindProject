package kodlamaio.northwindd.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwindd.core.entities.User;


//T => TYPE YANİ USER, ID => alanımızızn veri türü yani integer olcak
public interface UserDao extends JpaRepository<User, Integer>{
	
	//getbyemail yada findbyemail isimli operasyon olustur, bu operasyonla kullanıcı bilgilerine mail ile ulasılır.
	
	User findByEmail(String email);
}
