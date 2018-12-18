package com.Tester.tester;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
//
@RequestMapping("/tvservices")

public class TvServiceController {

    private static final Log log = LogFactory.getLog(TvServiceController.class);

    @GetMapping
    public List<TvServiceDto> getAll() {

        if (log.isTraceEnabled()) {
            log.trace("getAll()");
        }
        Calendar calendar = Calendar.getInstance();
        List<TvServiceDto> list = new ArrayList<>();
        calendar.set(2018, Calendar.UNDECIMBER, 12);
        list.add(new TvServiceDto(001, "郭德纲", 12, calendar.getTime()));
        calendar.set(2018, Calendar.UNDECIMBER, 12);
        list.add(new TvServiceDto(001, "于谦", 12, calendar.getTime()));
        calendar.set(2018, Calendar.UNDECIMBER, 12);
        list.add(new TvServiceDto(001, "李大猫", 12, calendar.getTime()));

        return list;
    }
//    public Map<String, Object> test(){
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("message", "hello world");
//
//        return result;
//    }

}
