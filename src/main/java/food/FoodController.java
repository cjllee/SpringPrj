package food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody FoodForm form) {
        Food food = Food.builder()
                .id(form.getId())
                .name(form.getName())
                .price(form.getPrice())
                .build();

        foodService.join(food);

        return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        try {
            Food food = foodService.findOne(id);
            return new ResponseEntity<>(food, HttpStatus.OK);
        } catch (FoodNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateFood(@RequestBody FoodForm form) {
        try {
            foodService.updateFood(form.getId(), form);
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } catch (FoodNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        try {
            foodService.deleteFood(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } catch (FoodNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<String> handleFoodNotFoundException(FoodNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}