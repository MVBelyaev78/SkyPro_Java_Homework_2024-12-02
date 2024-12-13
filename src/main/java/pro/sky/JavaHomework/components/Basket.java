package pro.sky.JavaHomework.components;

import java.util.Set;

public interface Basket {
    Set<Integer> getGoods();
    void addGoods(Integer key);
    void delGoods(Integer key);
}
