package com.company.greenspaceproject.ServiceTests;

import com.company.greenspaceproject.service.IDistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictServiceTest {
    @Autowired
    private IDistrictService districtService;

    @Test
    void findStatesByCountry() {
        System.out.println(districtService.getStatesByCountry("CA"));
        System.out.println(districtService.getStatesByCountry("US"));

    }

    @Test
    void findCitiesByState() {
        System.out.println(districtService.getCitiesByState("MB"));
        System.out.println(districtService.getCitiesByState("AZ"));
    }
}
