package bucket;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Discount {

    public BigDecimal discount(List<Item> storage) {
        Map<String, Long> map = storage.stream().collect((Collectors.groupingBy(Item::getName,
                Collectors.collectingAndThen(Collectors.counting(), this::promotion)
                )));
        removeNullValues(map);
        return storage.stream().filter(item -> map.containsKey(item.getName())).map(this::append).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal append(Item item) {
        return item.getPrice().multiply(new BigDecimal(20).divide(new BigDecimal(100)));
    }

    private void removeNullValues(Map<String, Long> map) {
        map.values().removeAll(Collections.singleton(null));
    }

    private Long promotion(long count) {
        return count >=3 ? count : null;
    }
}
