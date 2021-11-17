package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DonutController {

    DonutRepository donutRepository;

    DonutController(DonutRepository donutRepository) {
        this.donutRepository = donutRepository;
    }

    @RequestMapping("/buy-donut")
    @ResponseBody
    String buyDonut(@RequestParam String donutName) {
        List<Donut> found = this.donutRepository.findByNameIgnoreCase(donutName);
        if (found.size() <= 0) {
            return "Wah. Wah. No donuts for you.";
        }
        else {
            Donut donut = found.get(0);
            if (donut.numberAvailable <= 0) {
                return "Sorry. All out of those.";
            }
            donut.numberAvailable = donut.numberAvailable - 1;
            this.donutRepository.save(donut);
            return "Enjoy your " + donutName + " donut. It costs $" +
                    donut.costDollars + ". There are " +
                    donut.numberAvailable + " of these remaining.";
        }
    }

}