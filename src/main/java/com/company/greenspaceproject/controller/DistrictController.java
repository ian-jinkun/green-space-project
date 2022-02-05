package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.service.IDistrictService;
import com.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/", ""})
    public JsonResult<List<String>> getStates(String country){

        return null;
    }
    public JsonResult<List<String>> getCities(String state){
        return null;
    }
}
