package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new
                GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}

//XML 설정 사용
//최근에는 스프링 부트를 많이 사용하면서 XML기반의 설정은 잘 사용하지 않는다. 아직 많은 레거시
//프로젝트 들이 XML로 되어 있고, 또 XML을 사용하면 컴파일 없이 빈 설정 정보를 변경할 수 있는 장점도
//있으므로 한번쯤 배워두는 것도 괜찮다.
//GenericXmlApplicationContext 를 사용하면서 xml 설정 파일을 넘기면 된다.