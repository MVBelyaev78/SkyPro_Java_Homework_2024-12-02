package pro.sky.JavaHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.JavaHomework.repositories.Basket;
import pro.sky.JavaHomework.repositories.Goods;
import pro.sky.JavaHomework.services.BasketService;

@RestController
@RequestMapping("/store/order")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(value = "/get")
    public Iterable<Integer> getGoodsIdList() {
        return basketService.getGoodsList();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Basket> postGoodsIdList(Iterable<Integer> goodsIdList) {
        Basket basket = Basket.valueOf();
        goodsIdList.forEach(id -> {
            basket.addGoods(Goods.valueOf(id));
        });
        return new ResponseEntity<>(basket, HttpStatus.CREATED);
    }
}
