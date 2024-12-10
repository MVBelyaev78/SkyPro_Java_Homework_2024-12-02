package pro.sky.JavaHomework.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Basket {
    private Map<Integer, Goods> goodsList;

    private Basket() {
    }

    public static Basket valueOf() {
        Basket basket = new Basket();
        basket.setGoodsList(new HashMap<>());
        return basket;
    }

    public Map<Integer, Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Map<Integer, Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsList);
    }

//    public void addGoods(Goods goods) {
//        goodsList.add(Goods.valueOf(goods.getGoodsId()));
//    }
}
