package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//VIP이면 1000원 할일, 아니면 할인 X
public class FixDiscountPolicy implements DiscountPolicy { //정액 할인 정책 구현체
    private int discountFixAmount = 1000; //1000원 할일

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
