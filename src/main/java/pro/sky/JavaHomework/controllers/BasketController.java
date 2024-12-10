package pro.sky.JavaHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.JavaHomework.repositories.Basket;
import pro.sky.JavaHomework.services.BasketService;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/add")
    public ResponseEntity<Basket> addGoodsIdList(@RequestParam(value = "ids") String ids) {
        return getHttpQueryCreated(Arrays
                .stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Basket> postGoodsIdList(@RequestBody Set<Integer> goodsIdCollection) {
        return getHttpQueryCreated(goodsIdCollection);
    }

    private ResponseEntity<Basket> getHttpQueryCreated(Set<Integer> goodsIdCollection) {
        basketService.addGoodsCollection(goodsIdCollection);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
