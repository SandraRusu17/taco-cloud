package tacocloud.models.data;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Taco {

    private Long id;

    private LocalDateTime placedAt;

    @NonNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;

    public Taco() {
    }
}
