package ru.sbrf.cars.testAPI.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.cars.testAPI.service.ResponseService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentsController {

    private static final String URL = "http://localhost:11010/api/v3/cars-dictionary-departments/departments/";
    private static final String DELIMITER = "?";
    private static final String NAME = "name";
    private static final String CODES = "codes";
    private static final String CODE_TB = "tbCode=%D0%A4%D0%B8%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9%20%D0%9F%D0%9F";
    private static final String CODE_DEPARTMENT = "uuid=C87CDFDD-B571-4C32-AD5B-1ED1D376E899";
    private static final String CODE_NAME = "name=OSB";

    @Autowired
    ResponseService service;

    @GetMapping
    public List<String> getDepartment() throws IOException, JSONException {
        List<String> result = new ArrayList<>();
        result.add(service.handleResponse(URL + DELIMITER + CODE_DEPARTMENT));
        result.add(service.handleResponse(URL + CODES + DELIMITER + CODE_TB));
        result.add(service.handleResponse(URL + NAME + DELIMITER + CODE_NAME));

        return result;
    }

    @PostMapping("")
    public List<String> postDepartment() throws IOException, JSONException {
        List<String> result = new ArrayList<>();
        result.add(service.makePost(URL));
        return result;
    }

}
