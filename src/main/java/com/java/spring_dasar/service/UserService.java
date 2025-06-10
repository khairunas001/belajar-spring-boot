package com.java.spring_dasar.service;

import com.java.spring_dasar.data.User;
import com.java.spring_dasar.event.LoginSuccesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean login(String username, String password) {
        if (isLoginSucces(username, password)) {
            applicationEventPublisher.publishEvent(new LoginSuccesEvent(new User(username)));
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoginSucces(String username, String password) {
        return "joko".equals(username) && "wiwok".equals(password);
    }
}
