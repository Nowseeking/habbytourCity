package com.mt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mt.common.ServerResponse;
import com.mt.mapper.CityMapper;
import com.mt.model.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public ServerResponse queryCity() {
        //查询所有数据
        List<Map<String, Object>> allList = cityMapper.selectMaps(new QueryWrapper<>());
        //定义一个根节点集合
        List<Map<String, Object>> parentList = new ArrayList<>();
        for (Map<String, Object> allMap : allList) {
            if (allMap.get("pid").equals("0")) {
                parentList.add(allMap);
            }
        }
        getChildrenList(allList, parentList);
        return ServerResponse.success(parentList);
    }


    @Override
    public ServerResponse addOrUpdate(City city) {
        if(city.getId()==null){
            cityMapper.insert(city);
        }else{
            cityMapper.updateById(city);
        }
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteCity(List<Integer> idList) {
        cityMapper.deleteBatchIds(idList);
        return ServerResponse.success();
    }


    private void getChildrenList(List<Map<String, Object>> allList, List<Map<String, Object>> parentList) {
        if(parentList !=null && parentList.size() > 0){
            //遍历节点
            for (Map<String, Object> pmap : parentList) {
                List<Map<String,Object>> childrenList=new ArrayList<>();
                for (Map<String, Object> allMap : allList) {
                    //根据子节点找到子节点的子节点
                    if(pmap.get("id").equals(allMap.get("pid"))){
                        childrenList.add(allMap);
                    }
                }
                if(childrenList.size() > 0){
                    //就把子节点放到集合中
                    pmap.put("children",childrenList);
                    getChildrenList(allList,childrenList);
                }
            }
        }
    }
}
