package pro.sky.JavaHomework.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Goods> basketGoodsList;

    private Basket() {
    }

    public static Basket valueOf() {
        Basket basket = new Basket();
        basket.setBasketGoodsList(new ArrayList<>());
        return basket;
    }

    public List<Goods> getBasketGoodsList() {
        return basketGoodsList;
    }

    public void setBasketGoodsList(List<Goods> basketGoodsList) {
        this.basketGoodsList = basketGoodsList;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(basketGoodsList);
    }

    public void addGoods(Goods goods) {
        basketGoodsList.add(Goods.valueOf(goods.getGoodsId()));
    }
}
