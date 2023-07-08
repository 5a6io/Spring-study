package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // AppConfig, TestCongfig 가 자동으로 등록되는 것을 방지하고자 스캔대상에서 제외.
)
public class AutoAppConfig {
    // Component 붙인 것이 자동으로 스프링 빈에 등록됨.
    // 이렇게 하면 의존관계주입을 어떻게 설정하는가?
    // 자동 의존 관계 주입이 필요함. @Autowired 를 생성자에 사용.
    // base package를 지정하지 않으면 hello.core의 모든 하위 패키지를 다 뒤짐.

//    @Autowired // 필드 주입이 가능하기는 하나 이 곳에서도 웬만해서 안 하는 게 좋음. 그리고 다른 방법으로 수행할 수 있음.
//    MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;

//    @Bean
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
