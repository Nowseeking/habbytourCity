package com.mt.service;


import com.fh.utils.ServerRequest;
import com.mt.model.Userinfo;

public interface UserinfoService {
    ServerRequest query(Integer id);

    ServerRequest updateinfo(Userinfo userinfo);

    ServerRequest deleteCollection(Userinfo userinfo);

    ServerRequest queryCollection(Integer id);
}
