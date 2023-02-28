package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


//스프링이 없는 순수한 DI컨테이너인 AppConfig는 요청 할 때마다 객체를 새로 생성
//-> 메모리 낭비가 심함.
//=> 해결 방안 :해당 객체가 딱 1개만 생성되고, 공유하도록 설계하면됨 -> 싱글톤 패턴
public class SingletonTest { // 스프링 없는 DI컨테이너
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

} // class end
