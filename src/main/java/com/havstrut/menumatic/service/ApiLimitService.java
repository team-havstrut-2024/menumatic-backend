package com.havstrut.menumatic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.havstrut.menumatic.model.ApiLimit;
import com.havstrut.menumatic.repository.ApiLimitRepository;

import java.time.ZoneId;
import java.time.temporal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

@EnableScheduling
@Service
public class ApiLimitService {

    private final ApiLimitRepository apiLimitRepository;
    private final ObjectMapper objectMapper;


    @Autowired
    public ApiLimitService(ApiLimitRepository apiLimitRepository, ObjectMapper objectMapper) {
        this.apiLimitRepository = apiLimitRepository;
        this.objectMapper = objectMapper;
    }

    public int fetchCountLimit() {
        return apiLimitRepository.findByDate(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)).get().getCountLimit();
    }
    public LocalDateTime fetchLastResetTime() throws Exception {
        return apiLimitRepository.findByDate(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)).get().getLastResetTime();
    }

    @Scheduled(cron = "0 0 0 * * */24", zone = "UTC")
    public void resetInterval() throws Exception {
        System.out.println("Hej Gustav");
        ApiLimit apiLimit = new ApiLimit(LocalDateTime.now(ZoneId.of("UTC")).truncatedTo(ChronoUnit.DAYS), 5000);
        apiLimitRepository.deleteAll();
        apiLimitRepository.save(apiLimit);
    }


    public void setApiCounterLimit(String json) throws Exception {
        System.out.println("This is the json in service layer:" + json);

        Map<String, Object> jsonMap = new HashMap<>();

        jsonMap = objectMapper.readValue(json, HashMap.class);

        System.out.println(("This is the json object: " + jsonMap));

        String countLimit = Integer.toString((int)jsonMap.get("amount_left"));
        int countLimitInt = Integer.parseInt(countLimit);


        System.out.println(countLimitInt);
        try {
            LocalDateTime lastResetTime = fetchLastResetTime();
            ApiLimit row = new ApiLimit(lastResetTime, countLimitInt);
            apiLimitRepository.deleteAll();
            apiLimitRepository.save(row);
        }
        catch (Exception e) {
            ApiLimit row = new ApiLimit(LocalDateTime.now(ZoneId.of("UTC")).truncatedTo(ChronoUnit.DAYS), countLimitInt);
            apiLimitRepository.save(row);
        }




    }
}
