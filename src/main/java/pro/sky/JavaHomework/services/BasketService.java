package pro.sky.JavaHomework.services;

import java.util.Set;

public interface BasketService {
    Set<Integer> getGoods();
    void addGoods(Set<Integer> keys);
    void delGoods(Set<Integer> keys);
}
