package ru.sbrf.cars.testAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.cars.testAPI.service.ResponseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sites")
public class SitesController {

    private static final String URL = "http://localhost:11000/api/v3/cars-dictionary-sites/sites/";
    private static final String DELIMETR = "?";
    private static final String SECTOR = "sector";
    private static final String TERRITORY = "territory";
    private static final String SITE = "site";
    private static final String CODE_SITE = "codeOrName=4589";
    private static final String CODE_TERRITORY = "code=007";
    private static final String CODE_SECTOR = "code=%D0%9D%D0%A1%D0%9A1-%D0%9B2";

    @Autowired
    ResponseService service;

    @GetMapping
    public List<String> list() throws Exception {
        List<String> result = new ArrayList<>();
        result.add(service.handleResponse(URL + SECTOR + DELIMETR + CODE_SECTOR));
        result.add(service.handleResponse(URL + SITE + DELIMETR + CODE_SITE));
        result.add(service.handleResponse(URL + TERRITORY + DELIMETR + CODE_TERRITORY));

        return result;
    }


}

