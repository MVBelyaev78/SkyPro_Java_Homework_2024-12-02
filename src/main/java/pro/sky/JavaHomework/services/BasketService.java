package pro.sky.JavaHomework.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.JavaHomework.components.Basket;

import java.util.Set;

@Service
@SessionScope
public class BasketService {
    private final Basket basket;

    public BasketService() {
        this.basket = new Basket();
    }

    public Set<Integer> getGoodsSet() {
        return basket.getGoodsSet();
    }

    public void addGoods(Set<Integer> keys) {
        keys.forEach(basket::addGoods);
    }
}
