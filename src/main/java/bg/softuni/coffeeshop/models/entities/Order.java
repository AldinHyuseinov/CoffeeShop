package bg.softuni.coffeeshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "DECIMAL(19,2)", nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @ManyToOne(optional = false)
    private Category category;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    private User employee;
}
