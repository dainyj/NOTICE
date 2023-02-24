package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

//주문 생성 요청이 오면, 회원 정보를 조회하고, 할인 정책을 적용한 다음 주문 객체를 생성해서 반환한다.
//메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성한다.
public class OrderServiceImpl implements OrderService { //주문 서비스 구현체


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //A코드
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //1. 할인 정책을 변경하기 위해 B코드로 변경

    //B코드
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();//할인 정책을 변경하기 위해 코드 수정
    //2. 할인 정책을 적용하는 코드로 수정했더니 문제점 발견(DIP위반), 인터페이스에만 의존하도록 코드 변경해야하므로 C코드로 수정해야함.

    //C코드
    private DiscountPolicy discountPolicy;


    //인터페이스에만 의존하도록 설계와 코드를 변경했다.
    //그런데 구현체가 없는데 어떻게 코드를 실행할 수 있을까?
    //실제 실행을 해보면 NPE(null pointer exception)가 발생한다.
    //해결방안
    //이 문제를 해결하려면 누군가가 클라이언트인 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를
    //대신 생성하고 주입해주어야 한다.



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
