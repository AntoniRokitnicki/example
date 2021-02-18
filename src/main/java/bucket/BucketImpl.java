package bucket;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BucketImpl implements Bucket {

    private List<Item> storage = new LinkedList<>();
    private Discount discount = null;


    public BucketImpl() {
    }

    public BucketImpl(Discount discount) {
        this.discount = discount;
    }

    public Bucket add(Item item) {
        Objects.requireNonNull(item,"item must not be null");
        storage.add(item);
        return this;
    }

    public BigDecimal calculateValue() {
        BigDecimal price = storage.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        return price.subtract(discount.discount(storage));
    }

}
