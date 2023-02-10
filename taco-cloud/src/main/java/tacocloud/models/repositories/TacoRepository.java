package tacocloud.models.repositories;

import tacocloud.models.data.Taco;

public interface TacoRepository {

    Taco save(Taco design);
}
