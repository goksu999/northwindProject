package kodlamaio.northwindd.business.abstracts;

import kodlamaio.northwindd.core.entities.User;
import kodlamaio.northwindd.core.utilities.result.DataResult;
import kodlamaio.northwindd.core.utilities.result.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
