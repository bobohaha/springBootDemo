package com.Tester.tester.dao;

import com.Tester.tester.pojo.TvService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TvServicesDao {

    @Select("select * from vidioinfo")
    List<TvService> getPlayerList();
}
