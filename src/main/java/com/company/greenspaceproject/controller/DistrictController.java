package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.service.IDistrictService;
import com.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/", ""})
    public JsonResult<List<String>> getStates(String country){
        List<String> data = districtService.getStatesByCountry(country);

        return new JsonResult<List<String>>(OK, data);

    }
    public JsonResult<List<String>> getCities(String state){
        List<String> data = districtService.getCitiesByState(state);

        return new JsonResult<List<String>>(OK, data);
    }
}
