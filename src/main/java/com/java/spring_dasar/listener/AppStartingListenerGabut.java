package com.java.spring_dasar.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class AppStartingListenerGabut implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
    log.info("Application Gabut Starting");
    }
}
