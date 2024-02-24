package ru.yampolskiy.trackuseraction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.yampolskiy.trackuseraction.model.aspect.JournalAspect;
import ru.yampolskiy.trackuseraction.model.aspect.ProductTrackerAspect;
import ru.yampolskiy.trackuseraction.model.aspect.TimeTrackerAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public JournalAspect journalAspect() {
        return new JournalAspect();
    }

    @Bean
    public TimeTrackerAspect timeTrackerAspect() {
        return new TimeTrackerAspect();
    }

    @Bean
    public ProductTrackerAspect productTrackerAspect() {
        return new ProductTrackerAspect();
    }
}
