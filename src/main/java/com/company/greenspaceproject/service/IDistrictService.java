package com.company.greenspaceproject.service;

import java.util.List;

public interface IDistrictService {
    public List<String> getStatesByCountry(String country);

    public List<String> getCitiesByState(String state);
}
