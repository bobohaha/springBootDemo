package com.Tester.tester.Controller;

import com.Tester.tester.pojo.TvService;
import com.Tester.tester.service.TvServiceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


@RestController
//
@RequestMapping("/tvservices")

public class TvServiceController {

    private static final Log log = LogFactory.getLog(TvServiceController.class);

    @Autowired TvServiceService tvServiceService;

    @GetMapping
    public List<TvService> getPlayerList() {

        if (log.isTraceEnabled()) {
            log.trace("getAll()");
        }
//        Calendar calendar = Calendar.getInstance();
//        List<TvService> list = new ArrayList<>();
//        calendar.set(2018, Calendar.UNDECIMBER, 12);
//        list.add(new TvService(001, "郭德纲", 12, calendar.getTime()));
//        calendar.set(2018, Calendar.UNDECIMBER, 12);
//        list.add(new TvService(002, "于谦", 12, calendar.getTime()));
//        calendar.set(2018, Calendar.UNDECIMBER, 12);
//        list.add(new TvService(003, "李大猫", 12, calendar.getTime()));

        List<TvService> list = tvServiceService.getPlayerListService();

        return list;
    }

    //select
    @GetMapping("/{id}")
    public TvService getDetail(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getDetail");
        }

        if (id == 001) {
            return CreateVidio1();
        } else if (id == 002) {
            return CreateVidio2();
        } else {
            log.error("not fond page");
        }
        return null;
    }

    private TvService CreateVidio1() {
        Calendar c = Calendar.getInstance();
        c.set(2018, Calendar.UNDECIMBER, 12);
        return new TvService(001, "郭德纲", 12, c.getTime());
    }

    private TvService CreateVidio2() {
        Calendar c = Calendar.getInstance();
        c.set(2018, Calendar.UNDECIMBER, 12);
        return new TvService(002, "于谦", 12, c.getTime());
    }

    //insert
    @PostMapping
    private TvService insertVidio(@RequestBody TvService tvService) {

        tvService.setId(003);
        tvService.setName("大帝");
        return tvService;
    }

    //modify
    @PutMapping("/{id}")
    private TvService modify(@PathVariable int id, @RequestBody TvService tvService) {

        if (id == 001 || id == 002) {
            return CreateVidio1();
        } else {
            log.error("not fond page");
        }
        return null;
    }

    //delete
    @DeleteMapping("/{id}")
    private Map<String, String> deleteVidio(@PathVariable int id, HttpServletRequest request, @RequestParam(value = "delete_reason", required = false) String deletteReason) {

        Map<String, String> result = new HashMap();
        if (id == 001) {
            result.put("message", "001" + request.getRemoteAddr() + "删除原因" + deletteReason + ")");
        } else {
            log.error("not fond page");
        }

        return result;
    }

    //upload file
    @PostMapping(value = "/{id}/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //consumes = MediaType.MULTIPART_FORM_DATA_VALUE 输入格式
    private void uploadPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile multipartFile) throws IOException {

        FileOutputStream fos = new FileOutputStream("target/" + multipartFile.getOriginalFilename());
        IOUtils.copy(multipartFile.getInputStream(), fos);
        fos.close();

    }

    //read file
//    @GetMapping("/{id}/icon")
//    private byte[] getFile (@PathVariable int id) throws FileNotFoundException {
//
//        String filePath = "target/1.jpg";
//        InputStream is = new FileInputStream(filePath);
//        return toByteString(is);
//    }
//    public Map<String, Object> test(){
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("message", "hello world");
//
//        return result;
//    }

}
