package pro.sky.JavaHomework.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basket {
    private Map<Integer, Goods> goodsMap;

    private Basket() {
    }

    public static Basket valueOf() {
        Basket basket = new Basket();
        basket.goodsMap = new HashMap<>();
        return basket;
    }

    public Map<Integer, Goods> getGoodsMap() {
        return goodsMap;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsMap);
    }

    public void addGoodsEntry(Integer key, Goods value) {
        if (goodsMap.containsKey(key)) {
            throw new RuntimeException("Keys must be unique!");
        }
        goodsMap.put(key, value);
    }
}
