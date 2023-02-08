package bg.softuni.coffeeshop.services;

import bg.softuni.coffeeshop.models.entities.Category;
import bg.softuni.coffeeshop.models.enums.CategoryOption;
import bg.softuni.coffeeshop.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @PostConstruct
    private void initCategories() {

        if (categoryRepository.count() <= 0) {
            Category coffee = new Category();
            coffee.setName(CategoryOption.Coffee);
            coffee.setNeededTime(2);

            Category cake = new Category();
            cake.setName(CategoryOption.Cake);
            cake.setNeededTime(10);

            Category drink = new Category();
            drink.setName(CategoryOption.Drink);
            drink.setNeededTime(1);

            Category other = new Category();
            other.setName(CategoryOption.Other);
            other.setNeededTime(5);

            categoryRepository.saveAllAndFlush(List.of(coffee, cake, drink, other));
        }
    }
}
