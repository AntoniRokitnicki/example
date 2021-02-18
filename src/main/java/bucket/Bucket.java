package bucket;

import java.math.BigDecimal;

public interface Bucket {
    Bucket add(Item item);

    BigDecimal calculateValue();
}
