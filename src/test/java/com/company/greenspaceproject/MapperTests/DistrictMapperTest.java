package com.company.greenspaceproject.MapperTests;

import com.company.greenspaceproject.dao.DistrictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DistrictMapperTest {
    @Autowired
    DistrictMapper districtMapper;

    @Test
    void findStatesByCountry() {
        System.out.println(districtMapper.findStatesByCountry("CA"));
    }

    @Test
    void findCitiesByState() {
        System.out.println(districtMapper.findCitiesByState("AB"));
    }
}
