package com.company.greenspaceproject.service.impl;

import com.company.greenspaceproject.dao.DistrictMapper;
import com.company.greenspaceproject.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    DistrictMapper districtMapper;

    @Override
    public List<String> getStatesByCountry(String country) {

        return districtMapper.findStatesByCountry(country);
    }

    @Override
    public List<String> getCitiesByState(String state) {

        return districtMapper.findCitiesByState(state);
    }
}
