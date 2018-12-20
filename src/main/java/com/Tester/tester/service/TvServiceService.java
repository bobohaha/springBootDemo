package com.Tester.tester.service;

import com.Tester.tester.pojo.TvService;
import com.Tester.tester.dao.TvServicesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvServiceService {

    @Autowired TvServicesDao tvServicesDao;

    public List<TvService> getPlayerListService(){

        return tvServicesDao.getPlayerList();
    }
}
