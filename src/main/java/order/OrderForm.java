
// OrderForm.java

package order;

import food.Food;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderForm {
    private Long id;
    private String name;
    private Address address;
    private List<Food> foods;
}

