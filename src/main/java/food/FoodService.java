package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Transactional
    public Long join(Food food){
        foodRepository.save(food);
        return food.getId();
    }

    public Food findOne(Long foodId){
        return foodRepository.findOne(foodId);
    }
}
