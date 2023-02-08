package bg.softuni.coffeeshop.models.entities;

import bg.softuni.coffeeshop.models.enums.CategoryOption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryOption name;

    @Column(nullable = false)
    private Integer neededTime;
}
