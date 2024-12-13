package pro.sky.JavaHomework.components;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class BasketImpl implements Basket {
    private final Set<Integer> goodsSet;

    public BasketImpl() {
        goodsSet = new HashSet<>();
    }

    public Set<Integer> getGoods() {
        return Collections.unmodifiableSet(goodsSet);
    }

    public void addGoods(Integer key) {
        if (goodsSet.contains(key)) {
            throw new RuntimeException("Keys must be unique!");
        }
        goodsSet.add(key);
    }

    public void delGoods(Integer key) {
        goodsSet.remove(key);
    }
}
