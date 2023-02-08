package bg.softuni.coffeeshop.repositories;

import bg.softuni.coffeeshop.models.entities.Category;
import bg.softuni.coffeeshop.models.enums.CategoryOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryOption option);
}
