package ru.yampolskiy.trackuseraction.model.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.yampolskiy.trackuseraction.model.Product;
import ru.yampolskiy.trackuseraction.model.annotation.ProductActions;
import ru.yampolskiy.trackuseraction.model.annotation.ProductTracker;
import ru.yampolskiy.trackuseraction.service.ProductService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ProductTrackerAspect extends JournalAspect {

    //@Pointcut("execution(* ru.yampolskiy.trackuseraction.service.*.*(..))")
    @Pointcut("execution(public * *(..)) && @annotation(ru.yampolskiy.trackuseraction.model.annotation.ProductTracker)")
    public void callProductTracker() { }


    @Around("callProductTracker()")
    public Object productTracker(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result =null;
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ProductTracker productTracker = method.getAnnotation(ProductTracker.class);
        String action = productTracker.action().toString();
        logger.info("Операция: {}", action);

        if (args.length > 0 && args[0] instanceof Product && action.equals("CREATE")) {
            Product product = (Product) args[0];
            logger.info("Cобытие: {}",joinPoint.getKind());
            logger.info("Содержащий класс: {}",joinPoint.getSignature().getDeclaringType());
            logger.info("Вызываемый метод: {}", joinPoint.getSignature().getName());
            logger.info("ID before action: {}", product.getId());
            logger.info("Title before action: {}", product.getTitle());
            logger.info("Description before action: {}", product.getDescription());
            logger.info("Cost before action: {}", product.getCost());
            logger.info("Amount before action: {}", product.getAmount());
            logger.info("Reserved before action: {}", product.getReserved());

            result = joinPoint.proceed();

            logger.info("ID after action: {}", product.getId());
            logger.info("Title after action: {}", product.getTitle());
            logger.info("Description after action: {}", product.getDescription());
            logger.info("Cost after action: {}", product.getCost());
            logger.info("Amount after action: {}", product.getAmount());
            logger.info("Reserved after action: {}", product.getReserved());

            return result;
        }
        return null;
    }



}
