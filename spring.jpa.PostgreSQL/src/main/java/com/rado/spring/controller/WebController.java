package com.rado.spring.controller;

import com.rado.spring.model.Customer;
import com.rado.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new Customer("Rado", "Matev"));
        repository.save(new Customer("Jim", "Beam"));
        repository.save(new Customer("Jack", "Daniels"));
        repository.save(new Customer("Kim", "Basinger"));
        repository.save(new Customer("Amanda", "Smith"));
        repository.save(new Customer("Teodora", "Peneva"));

        return "Saved!";
    }

    @RequestMapping("/findall")
    public String findAll() {
        StringBuilder result = new StringBuilder("<html>");

        for (Customer cust : repository.findAll()) {
            result.append("<div>").append(cust.toString()).append("</div>");
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "<html>";
        result += repository.findById(id).toString();

        return result + "</html>";
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "<html>";

        for (Customer cust : repository.findByLastName(capitalize(lastName))) {
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    public static String capitalize(String str) {
        if(str== null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

































