package com.aa.apidemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class RequestApi {

    @Scheduled(fixedDelay=5000)
    public void scheduledApiRequest() {
        System.out.println("Entered scheduledApiRequest");
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.weather.gov/alerts/active?area=TX";
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }
}
