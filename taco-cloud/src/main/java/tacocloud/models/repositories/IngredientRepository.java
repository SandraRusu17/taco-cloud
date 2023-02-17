package tacocloud.models.repositories;

import org.springframework.data.repository.CrudRepository;
import tacocloud.models.data.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
