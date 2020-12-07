package com.mt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mt.model.Userinfo;
import com.mt.model.Word;


import java.util.List;

public interface UserinfoMapper extends BaseMapper<Userinfo> {


    List<Userinfo> query(Integer id);

    void updateinfo(Userinfo userinfo);

    void deleteCollection(Userinfo userinfo);

    List<Word> queryCollection(Integer id);
}
