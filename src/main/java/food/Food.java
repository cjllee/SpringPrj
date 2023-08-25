// Food.java
package food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import order.Order;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    // 다대일 관계 설정. 한 음식은 하나의 주문에 속할 수 있음.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}