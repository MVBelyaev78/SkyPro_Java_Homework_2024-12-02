package pro.sky.JavaHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.JavaHomework.repositories.Basket;
import pro.sky.JavaHomework.repositories.Goods;

import java.util.Set;

@Service
public class BasketService {
    private final Basket basket;

    public BasketService() {
        this.basket = Basket.valueOf();
    }

    public Set<Integer> getGoodsKeySet() {
        return basket.getGoodsMap().keySet();
    }

    public Basket addGoodsCollection(Set<Integer> keys) {
        Basket addedBasket = Basket.valueOf();
        keys.forEach(key -> addedBasket.addGoodsEntry(key, Goods.valueOf("")));
        keys.forEach(key -> basket.addGoodsEntry(key, Goods.valueOf("")));
        return addedBasket;
    }
}
