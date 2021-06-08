package kodlamaio.northwindd.business.abstracts;

import kodlamaio.northwindd.core.entities.User;
import kodlamaio.northwindd.core.utilities.results.DataResult;
import kodlamaio.northwindd.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
