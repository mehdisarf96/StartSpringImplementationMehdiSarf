package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.controllers.model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
// @RestController = @Controller + @ResponseBody
public class HelloController {

    @RequestMapping("/france")
    @ResponseBody
    public Country france() {

        Country country = new Country("france", 67);
        return country;
    }

    @RequestMapping("/enemies")
    @ResponseBody
    public List<Country> EnemyCountries() {

        List<Country> enemies = new ArrayList<>();

        enemies.add(new Country("North Korea", 50));
        enemies.add(new Country("South Korea", 120));

        return enemies;
    }
}
