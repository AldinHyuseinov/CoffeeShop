package bg.softuni.coffeeshop.models.dto;

import bg.softuni.coffeeshop.models.enums.CategoryOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ShowOrderDTO {
    private Long id;

    private CategoryOption categoryName;

    private String name;

    private Double price;
}
