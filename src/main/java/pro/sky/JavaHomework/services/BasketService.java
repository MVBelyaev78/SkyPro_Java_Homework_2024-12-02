package pro.sky.JavaHomework.services;

import org.springframework.stereotype.Service;
import pro.sky.JavaHomework.repositories.Basket;
import pro.sky.JavaHomework.repositories.Goods;

@Service
public class BasketService {
    private final Basket basket;

    public BasketService() {
        this.basket = Basket.valueOf();
    }

    public Iterable<Integer> getGoodsList() {
        return basket
                .getBasketGoodsList()
                .stream()
                .map(Goods::getGoodsId)
                .toList();
    }
}
