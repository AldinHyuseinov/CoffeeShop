package bg.softuni.coffeeshop.models.dto;

import bg.softuni.coffeeshop.models.enums.CategoryOption;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class AddOrderDTO {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20.")
    private String name;

    @Min(value = 1, message = "The price must be positive.")
    @NotNull(message = "The price is required.")
    private Double price;

    @PastOrPresent(message = "Order time cannot be in the future.")
    @NotNull(message = "Order time is required.")
    private LocalDateTime orderTime;

    @NotNull(message = "You must select the category.")
    private CategoryOption categoryName;

    @Size(min = 5, message = "Description size must be minimum 5 chars.")
    private String description;
}
