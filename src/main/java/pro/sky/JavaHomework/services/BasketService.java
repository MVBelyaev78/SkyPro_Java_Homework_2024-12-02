package pro.sky.JavaHomework.services;

import java.util.Set;

public interface BasketService {
    public Set<Integer> getGoods();
    public void addGoods(Set<Integer> keys);
}
