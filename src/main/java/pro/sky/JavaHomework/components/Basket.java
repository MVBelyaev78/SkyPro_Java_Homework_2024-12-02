package pro.sky.JavaHomework.components;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
@SessionScope
public class Basket {
    private final Set<Integer> goodsSet = new HashSet<>();

    public Set<Integer> getGoodsSet() {
        return Collections.unmodifiableSet(goodsSet);
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsSet);
    }

    public void addGoods(Integer key) {
        if (goodsSet.contains(key)) {
            throw new RuntimeException("Keys must be unique!");
        }
        goodsSet.add(key);
    }
}