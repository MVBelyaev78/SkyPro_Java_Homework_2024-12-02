package pro.sky.JavaHomework.repositories;

import java.util.Objects;

public class Goods {
    private String goodsName;

    private Goods() {
    }

    public static Goods valueOf(String goodsName) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        return goods;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsName);
    }
}
