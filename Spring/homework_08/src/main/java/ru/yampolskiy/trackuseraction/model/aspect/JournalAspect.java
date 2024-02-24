package ru.yampolskiy.trackuseraction.model.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class JournalAspect {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
