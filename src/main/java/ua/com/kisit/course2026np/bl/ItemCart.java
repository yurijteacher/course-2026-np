package ua.com.kisit.course2026np.bl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit.course2026np.entity.Products;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCart {

    private Products products;
    private int quantity;

}
