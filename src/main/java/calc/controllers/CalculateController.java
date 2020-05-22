package calc.controllers;

import calc.services.CalculateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    private CalculateService calc = new CalculateService();

    @RequestMapping(value = "/calculate")
    public String calculateAnnuatePayment(@RequestBody String inputJson) {
        System.out.println(inputJson);
        return calc.annuatePayment(inputJson);
    }
}

