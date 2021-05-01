package community.happenuponjava.repository;

import community.happenuponjava.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends
        CrudRepository<User, Long>
{

}
