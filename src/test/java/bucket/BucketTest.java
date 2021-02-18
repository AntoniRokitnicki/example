package bucket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BucketTest {

    public static final String ORANGE = "orange";
    public static final String APPLE = "apple";

    @Test
    void shouldCalculateValueForEmptyBucket() {
        BucketImpl bucket = new BucketImpl();
        assertEquals(BigDecimal.ZERO, bucket.calculateValue());
    }

    @Test
    void shouldCalculateValueForSingleItem() {
        BucketImpl bucket = new BucketImpl();
        BigDecimal price = new BigDecimal(7);
        bucket.add(new Item(ORANGE, price));
        assertEquals(price, bucket.calculateValue());
    }

    @Test
    void shouldCalculateValueForMultpleItems() {
        BucketImpl bucket = new BucketImpl();
        bucket.add(new Item(ORANGE, new BigDecimal(7))).add(new Item(APPLE, new BigDecimal(3)));
        assertEquals(BigDecimal.TEN, bucket.calculateValue());
    }

    @Test
    void shouldCalculateValueForPromotion() {
        BucketImpl bucket = new BucketImpl(new Discount());
        Item orange = new Item(ORANGE, new BigDecimal(7));
        bucket.add(orange).add(new Item(APPLE, new BigDecimal(3))).add(orange).add(orange);
        assertEquals(3 + ((7 * 3) * 8/10), bucket.calculateValue().longValue());
    }
}