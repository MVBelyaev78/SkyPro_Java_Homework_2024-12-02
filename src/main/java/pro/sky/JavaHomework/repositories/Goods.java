package pro.sky.JavaHomework.repositories;

import java.util.Objects;

public class Goods {
    private Integer goodsId;

    private Goods() {
    }

    public static Goods valueOf(Integer goodsId) {
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        return goods;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(goodsId);
    }
}
