package com.aspectaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.aspectaop.service.MesajService.mesajYaz(..))")
    public void runBeforeMesajYazMethod(JoinPoint joinPoint){
        System.out.println("Metottan önce çalıştı ve gelen mesaj yakalandı :"+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
    @After("execution(* com.aspectaop.service.*.*(..))")
    public void runAfterMesajYazMethod(JoinPoint joinPoint){
        System.out.println("Metottan sonra çalıştı ve gelen mesaj yazkalandı :"+joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
    }
}
