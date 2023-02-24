package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용된다.")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용X")
    void vip_x(){
        //given
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}

//할인 정책을 변경하기 위해 OrderServiceImpl의 코드를 수정해야함.
//FixDiscountPolicy()-->RateDiscountPolicy()

//문제점 발견
// >우리는 역할과 구현을 충실하게 분리했다. OK
// >다형성도 활용하고, 인터페이스와 구현 객체를 분리했다. OK
// >OCP, DIP 같은 객체지향 설계 원칙을 충실히 준수했다
//   ->그렇게 보이지만 사실은 아니다.
// >DIP: 주문서비스 클라이언트( OrderServiceImpl )는 DiscountPolicy 인터페이스에 의존하면서 DIP를 지킨 것 같은데?
//   ->클래스 의존관계를 분석해 보자. 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다.
//     >추상(인터페이스) 의존: DiscountPolicy
//     >구체(구현) 클래스: FixDiscountPolicy , RateDiscountPolicy
// >OCP: 변경하지 않고 확장할 수 있다고 했는데!
//   ->지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! 따라서 OCP를 위반한다

//왜 클라이언트 코드를 변경해야 할까?
//클래스 다이어그램으로 의존관계를 분석해보자
// OrderServiceImpl이 DiscountPolicy인터페이스에만 의존한다 생각했다.
// 그러나 확인해보니 FixDiscountPolicy인 구체 클래스도 함께 의존하고 있으므로 DIP위반

//####중요
// FixDiscountPolicyf를 RateDiscountPolicy로 변경하면서 OrderServiceImpl의 소스 코드도 함께 변경해야한다.
// 즉, 의존관계를 변경 인터페이스에만 의존해야한다.