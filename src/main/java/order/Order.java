// Order.java
package order;

import food.Food;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String name;


    @Embedded
    private Address address;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Food> foods;

}