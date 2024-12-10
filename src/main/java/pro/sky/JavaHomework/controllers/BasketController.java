package pro.sky.JavaHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.JavaHomework.repositories.Basket;
import pro.sky.JavaHomework.services.BasketService;

import java.util.Set;

@RestController
@RequestMapping("/store/order")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(value = "/get")
    public Set<Integer> getGoodsIdCollection() {
        return basketService.getGoodsKeySet();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Basket> postGoodsIdList(@RequestBody Set<Integer> goodsIdCollection) {
        return new ResponseEntity<>(basketService.addGoodsCollection(goodsIdCollection), HttpStatus.CREATED);
    }
}
