package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // 생성자를 직접 생성할 필요가 없는 경우. 이걸 많이 사용함.
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;// = new MemoryMemberRepository(); // 회원정보 조회하기 위해서 필요
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존 // setter룰 사용하려면 final을 지워야 함.
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률할인정책. 추상 인터페이스와 구현 클래스 둘 다 의존
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정할인정책

//    @Autowired // 수정자 의존 관계. memberRepository가 스프링에 등록이 되어있지 않을 수 있는데 이 때 선택적으로 주입 가능.
//    public void setMemberRepository(MemberRepository memberRepository) { //setter가 없으면 값이 들어오지 않음.
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired //의존관계를 주입하는 단계
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    @Autowired //생성자 주입은 OrderServiceImpl 객체를 호출해야지 주입이 됨. new(memberRepository, discountPolicy) 이걸 찾아서 주입이 됨.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {// @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) { // 생성자를 만들어 인터페이스에만 의존하도록 변경함.
//        System.out.println("1. orderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired // 생성자 주입이랑 수정자 주입 안에서 보통 거의 다 해결하기 때문에 일반 주입은 잘 사용되지 않음.
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
