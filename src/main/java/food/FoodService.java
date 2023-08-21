package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    public Long join(Food food){

        foodRepository.save(food);
        return food.getId();
    }
}
