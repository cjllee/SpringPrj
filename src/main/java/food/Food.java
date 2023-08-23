package food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@Builder
public class Food {

    @Id
    @GeneratedValue
    Long id;
    String name;
    Long price;

}
