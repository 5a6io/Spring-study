package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); // 이렇게 하면 이 메소드가 이걸 스프링 빈으로 등록함.
    }

    static class TestBean {
        @Autowired(required = false) // 의존관계가 없으면 아예 이 메소드 자체가 호출이 안 됨.
        public void setNoBean1(Member noBean1) { // 스프링 빈에서 관린하는 것이 없음.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired // 호출은 되나 null로 들어옴.
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired // 값이 있으면 optional 안에 값이 감싸짐.
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
