package hello.core.member;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

//애플리케이션 로직 테스트는 JUnit을 사용하는게 좋다.
class MemberServiceTest { // 회원 가입 테스트
    MemberService memberService  =new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}

//회원 도메인 설계의 문제점
//>이 코드의 설계상 문제점은?
//>다른 저장소러 변경할 때 OCP원칙을 잘 준수하는가?
//>DIP를 잘 지키고 있는가?
//>>의존 관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음-> 주만까지 만들고 나서 문제점과 해결 방안 설명