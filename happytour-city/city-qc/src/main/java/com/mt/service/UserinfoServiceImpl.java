package com.mt.service;


import com.fh.utils.ServerRequest;
import com.mt.mapper.UserinfoMapper;
import com.mt.model.Userinfo;
import com.mt.model.Word;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Resource
    private UserinfoMapper userinfoMapper;

    @Override
    public ServerRequest query(Integer id) {

        List<Userinfo> list = userinfoMapper.query(id);

        return ServerRequest.success(list);
    }

    @Override
    public ServerRequest updateinfo(Userinfo userinfo) {

        userinfoMapper.updateinfo(userinfo);

        return ServerRequest.success();
    }

    @Override
    public ServerRequest deleteCollection(Userinfo userinfo) {
        userinfoMapper.deleteCollection(userinfo);

        return ServerRequest.success();
    }

    @Override
    public ServerRequest queryCollection(Integer id) {
        List<Word> list = userinfoMapper.queryCollection(id);

        return ServerRequest.success(list);
    }


}
