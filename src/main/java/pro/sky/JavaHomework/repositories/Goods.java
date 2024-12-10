package pro.sky.JavaHomework.repositories;

import java.util.Objects;

public class Goods {
    private String name;

    private Goods() {
    }

    public static Goods valueOf(String goodsName) {
        Goods goods = new Goods();
        goods.setName(goodsName);
        return goods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        return (this == object ||
                object != null && getClass() == object.getClass() && Objects.equals(this, object));
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
