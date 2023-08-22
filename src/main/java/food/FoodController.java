package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final  FoodService foodService;
    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public String create(@RequestBody FoodForm form) {
        Food food = new Food();
        food.setId(form.getId());
        food.setName(form.getName());
        food.setPrice(form.getPrice());

        foodService.join(food);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public Food getFood(@PathVariable Long id) {
        return foodService.findOne(id);
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.findAll();
    }

    @PutMapping("/{id}")
    public String updateFood(@PathVariable Long id, @RequestBody FoodForm form) {
        foodService.updateFood(id, form);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return "redirect:/";
    }
}