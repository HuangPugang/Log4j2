package org.hp.leopard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by paul on 16/12/21.
 */
public class BootListener implements SmartApplicationListener {
    private int order = Ordered.HIGHEST_PRECEDENCE + 10;

    private static Class<?>[] EVENT_TYPES = {ApplicationEnvironmentPreparedEvent.class};

    private static Class<?>[] SOURCE_TYPES = {SpringApplication.class,
            ApplicationContext.class};

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return isAssignableFrom(eventType, EVENT_TYPES);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return isAssignableFrom(sourceType, SOURCE_TYPES);
    }

    private boolean isAssignableFrom(Class<?> type, Class<?>... supportedTypes) {
        for (Class<?> supportedType : supportedTypes) {
            if (supportedType.isAssignableFrom(type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            SpringContext.setEnvironment(((ApplicationEnvironmentPreparedEvent) event).getEnvironment());
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
}
