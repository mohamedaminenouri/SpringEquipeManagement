package tn.esprit.exam.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CnfigAOP {

    @AfterThrowing("execution(* tn.esprit.exam.service.*.affecterArbitreARencontre(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
        log.warn("il faut affecter un arbitre de meme niveau que la rencontre");
    }

/*
    @After("execution(* tn.esprit.exam.service.*.*(..))")
    public void logMethodOut(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }*/

    @Around("execution(* tn.esprit.exam.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable
    {
        long start= System.currentTimeMillis();

        Object obj= pjp.proceed();

        long elapsedTime= System.currentTimeMillis() -start;

        log.info("Methodexecutiontime: " + elapsedTime+ " milliseconds.");
        return obj;
    }


}
