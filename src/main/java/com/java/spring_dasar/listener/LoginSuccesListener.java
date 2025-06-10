package com.java.spring_dasar.listener;

import com.java.spring_dasar.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginSuccesListener implements ApplicationListener<LoginSuccesEvent> {

    @Override
    public void onApplicationEvent(LoginSuccesEvent event) {
        log.info("Loggin Succes for user : {}", event.getUser());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
