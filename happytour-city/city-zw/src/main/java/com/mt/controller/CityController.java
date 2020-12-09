package com.mt.controller;

import com.mt.common.ServerResponse;
import com.mt.model.City;
import com.mt.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {

    @Resource
    private CityService cityService;

    //获取类型
    @RequestMapping("queryCity")
    public ServerResponse queryCity() {
        return cityService.queryCity();
    }

    //新增和修改类型
    @RequestMapping("addOrUpdate")
    public ServerResponse addOrUpdate(City city) {
        return cityService.addOrUpdate(city);
    }

    //删除类型
    @RequestMapping("deleteCity")
    public ServerResponse deleteCity(@RequestParam("idList") List<Integer> idList) {
        return cityService.deleteCity(idList);
    }
}
