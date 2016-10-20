package de.miwoe;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Grauschleier on 20.10.2016.
 */
@Controller
public class SomeController {

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public @ResponseBody String one() {
        return "one";
    }

    @RequestMapping(value = "/to_one", method = RequestMethod.GET)
    public String redirectToOne() {
        return "redirect:/webapp/one";
    }
}
