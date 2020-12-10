package com.mt.service;



import com.mt.common.ServerResponse;
import com.mt.model.City;

import java.util.List;

public interface CityService {

    ServerResponse queryCity();

    ServerResponse addOrUpdate(City city);

    ServerResponse deleteCity(List<Integer> idList);

}
