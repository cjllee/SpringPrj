package food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
public class Food {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long price;

    @ManyToOne

}
