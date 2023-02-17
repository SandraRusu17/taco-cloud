package tacocloud.models.repositories;

import org.springframework.data.repository.CrudRepository;
import tacocloud.models.data.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
