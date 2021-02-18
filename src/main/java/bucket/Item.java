package bucket;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String name;
    private BigDecimal price;

    public Item(String name, BigDecimal price) {
        Objects.requireNonNull(name,"name must not be null");
        Objects.requireNonNull(price,"price must not be null");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
