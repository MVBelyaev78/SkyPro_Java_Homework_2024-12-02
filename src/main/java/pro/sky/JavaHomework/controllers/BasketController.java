package pro.sky.JavaHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.JavaHomework.repositories.Basket;
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
    public ResponseEntity<Basket> postGoodsIdList(@RequestBody Iterable<Integer> goodsIdList) {
        return new ResponseEntity<>(basketService.addNewGoodsById(goodsIdList), HttpStatus.CREATED);
    }
}
