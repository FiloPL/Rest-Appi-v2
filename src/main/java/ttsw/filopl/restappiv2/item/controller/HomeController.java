package ttsw.filopl.restappiv2.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by T. Filo Zegarlicki on 19.07.2022
 **/

@RestController
public class HomeController {

    @GetMapping
    public String hello() {
        return "Spring home controller";
    }
}
