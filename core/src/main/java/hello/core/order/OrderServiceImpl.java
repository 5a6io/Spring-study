package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;// = new MemoryMemberRepository(); // 회원정보 조회하기 위해서 필요

    @Autowired
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률할인정책. 추상 인터페이스와 구현 클래스 둘 다 의존
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정할인정책

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { // 생성자를 만들어 인터페이스에만 의존하도록 변경함.
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
