package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class Cronjob {

    private static final Logger log = LoggerFactory.getLogger(Cronjob.class);

    @Scheduled(cron = "0 */20 8-22 * * *")
    public void doSth() {
        log.info("Hello");
        WebClient webClient = WebClient.create("https://tranquil-temple-85422.herokuapp.com/hello");
        String response = webClient.get().retrieve().bodyToMono(String.class).block();
        log.info(response);
    }


}
