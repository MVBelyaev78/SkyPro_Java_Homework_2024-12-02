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
    public Set<Integer> getGoods() {
        return basketService.getGoods();
    }

    @GetMapping(value = "/add")
    public ResponseEntity<Set<Integer>> addGoods(@RequestParam(value = "ids") String ids) {
        return addGoodsInner(convertStringListToCollection(ids));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Set<Integer>> postGoods(@RequestBody Set<Integer> goodsSet) {
        return addGoodsInner(goodsSet);
    }

    private ResponseEntity<Set<Integer>> addGoodsInner(Set<Integer> goodsSet) {
        basketService.addGoods(goodsSet);
        return new ResponseEntity<>(goodsSet, HttpStatus.CREATED);
    }

    private Set<Integer> convertStringListToCollection(String ids) {
        return Arrays
                .stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
