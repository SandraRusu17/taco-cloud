package tacocloud.models.repositories;

import org.springframework.data.repository.CrudRepository;
import tacocloud.models.data.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
