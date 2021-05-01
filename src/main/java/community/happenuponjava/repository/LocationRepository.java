package community.happenuponjava.repository;

import community.happenuponjava.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends
        CrudRepository<Location, Long>
{

}
