package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Transactional
    public Long join(Food food) {
        foodRepository.save(food);
        return food.getId();
    }

    public Food findById(Long foodId) {
        Food food = foodRepository.findOne(foodId);
        if (food == null) {
            throw new FoodNotFoundException("Food not found with ID: " + foodId);
        }
        return food;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Transactional
    public void updateFood(Long id, FoodForm form) {
        Food food = findById(id);
        food.setName(form.getName());
        food.setPrice(form.getPrice());
    }

    @Transactional
    public void deleteFood(Long id) {
        foodRepository.delete(id);
    }
}