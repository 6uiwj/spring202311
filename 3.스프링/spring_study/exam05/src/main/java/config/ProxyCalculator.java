package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ProxyCalculator {
    //@Pointcut("execution(* aopex..*(..))")
    //public void publicTarget(){}
    //@Around("publicTarget()")
    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        //현재 호출하고있는 핵심기능의 메서드에 대한 정보 반환
        //Signature sig = joinPoint.getSignature();
        //System.out.println(sig.toLongString());
        Object[] args = joinPoint.getArgs();
        long num = (Long)args[0];
        System.out.println(num);
        
        long stime = System.nanoTime(); // 공통 기능

        try {
            Object result = joinPoint.proceed(); //핵심 기능을 대신 수행하는 메서드
                // factorial(...)
            return result;
        } finally {
            long etime = System.nanoTime(); //공통 기능
            System.out.printf("걸린시간 : %d%n", etime - stime);
        }
    }
}
