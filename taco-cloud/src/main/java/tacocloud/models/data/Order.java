package tacocloud.models.data;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PLACEDAT")
    private Date placedAt;

    @NotBlank(message = "Name is required")
    @Column(name = "DELIVERYNAME")
    private String name;

    @NotBlank(message = "Street is required")
    @Column(name = "DELIVERYSTREET")
    private String street;

    @NotBlank(message = "City is required")
    @Column(name = "DELIVERYCITY")
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "DELIVERYSTATE")
    private String state;

    @NotBlank(message = "Zip is required")
    @Column(name = "DELIVERYZIP")
    private String zip;

    @CreditCardNumber(message = "Not a valid credit card number")
    @Column(name = "CCNUMBER")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    @Column(name = "CCEXPIRATION")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CCV")
    @Column(name = "CCCVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    @JoinTable(name = "taco_order_tacos",
            joinColumns = @JoinColumn(name = "TACOORDER"),
            inverseJoinColumns = @JoinColumn(name = "taco")
    )
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    @ManyToOne
    private User user;
}
