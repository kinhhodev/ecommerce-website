package info.kinhho.kshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomepageController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index() {

        return "homepage";
    }
}
