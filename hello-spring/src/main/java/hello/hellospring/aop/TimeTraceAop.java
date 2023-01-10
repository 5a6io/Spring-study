package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component // 스프링 빈에 등록. Componentscan됨. 그러나 SpringConfig에 Bean으로 등록하여 사용하는 것을 더 선호
@Aspect // @Aspect를 적어줘야 Aop로 사용 가능
public class TimeTraceAop {

    @Around(("execution(* hello.hellospring..*(..))")) //공통관심사항을 어디에 적용할지 타겟팅을 해줌.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed(); // joinPoint.proceed()하면 다음 메소드로 진행됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
