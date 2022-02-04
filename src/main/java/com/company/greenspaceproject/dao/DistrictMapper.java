package com.company.greenspaceproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DistrictMapper {
    List<String> findStatesByCountry(String country);

    List<String> findCitiesByState(String State);
}
