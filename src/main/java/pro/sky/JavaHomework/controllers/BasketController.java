package pro.sky.JavaHomework.controllers;

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
    public Set<Integer> getGoodsIdCollection() {
        return basketService.getGoodsSet();
    }

    @GetMapping(value = "/add")
    public Set<Integer> addGoodsIdList(@RequestParam(value = "ids") String ids) {
        final Set<Integer> result = Arrays
                .stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        basketService.addGoods(result);
        return result;
    }
}
