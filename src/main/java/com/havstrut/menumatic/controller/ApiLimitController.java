package com.havstrut.menumatic.controller;

import com.havstrut.menumatic.model.ApiLimit;
import com.havstrut.menumatic.service.ApiLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reset-counter/")
public class ApiLimitController {

    private ApiLimitService apiLimitService;

    @Autowired
    public ApiLimitController(ApiLimitService apiLimitService) {
        this.apiLimitService = apiLimitService;
    }

    @CrossOrigin
    @GetMapping("get/")
    public int setApiLimit()  {
       return apiLimitService.fetchCountLimit();
    }

    @CrossOrigin
    @PostMapping("set/")
    public void setApiLimit(@RequestHeader("request-check") String json) throws Exception {
       // System.out.println(newUid);
        System.out.println(json);
        String newJson = json.replace('"', ' ').trim();
        apiLimitService.setApiCounterLimit(newJson);
    }


}
