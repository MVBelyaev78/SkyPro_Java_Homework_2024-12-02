package pro.sky.JavaHomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Set<Integer> getGoodsSet() {
        return basketService.getGoodsSet();
    }

    @GetMapping(value = "/add")
    public ResponseEntity<Set<Integer>> addGoodsList(@RequestParam(value = "ids") String ids) {
        return addGoodsListInner(Arrays
                .stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Set<Integer>> postGoodsList(@RequestBody Set<Integer> goodsSet) {
        return addGoodsListInner(goodsSet);
    }

    private ResponseEntity<Set<Integer>> addGoodsListInner(Set<Integer> goodsSet) {
        basketService.addGoods(goodsSet);
        return new ResponseEntity<>(goodsSet, HttpStatus.CREATED);
    }
}
