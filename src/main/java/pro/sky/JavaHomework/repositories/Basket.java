package pro.sky.JavaHomework.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Goods> goodsList;

    private Basket() {
    }

    public static Basket valueOf() {
        Basket basket = new Basket();
        basket.setGoodsList(new ArrayList<>());
        return basket;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsList);
    }

    public void addGoods(Goods goods) {
        goodsList.add(Goods.valueOf(goods.getGoodsId()));
    }
}
