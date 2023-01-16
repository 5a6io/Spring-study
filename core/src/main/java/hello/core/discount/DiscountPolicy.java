package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy { // 추상 인터페이스

    /**
     * @returnc 할인 대상 금액
     */
    int discount(Member member, int price);
}
