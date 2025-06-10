package com.java.spring_dasar.listener;

import com.java.spring_dasar.event.LoginSuccesEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccesEvent1(LoginSuccesEvent event) {
        log.info("1. Sucess login for user {}", event.getUser());
    }

   @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccesEvent2(LoginSuccesEvent event) {
        log.info("2. Sucess login for user {}", event.getUser());
    }

    @EventListener(classes = LoginSuccesEvent.class)
    public void onLoginSuccesEvent3(LoginSuccesEvent event) {
        log.info("3. Sucess login for user {}", event.getUser());
    }
}
