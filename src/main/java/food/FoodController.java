package food;

import org.springframework.web.bind.annotation.PostMapping;

public class FoodController {

    @PostMapping("/foods/new")
    public String create(FoodForm form){

        Food food = new Food();
        food.setFood_id(form.getId());
        food.setName(form.getName());
        food.setPrice(form.getPrice());

        return "redirect:/";
    }
}
