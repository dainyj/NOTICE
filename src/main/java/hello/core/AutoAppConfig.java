package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

// 컴포넌트 스캔은 의존관계 자동주입과 연관있음

@Configuration
@ComponentScan(basePackages = "hello.core",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
//컴포넌트 스캔을 사용하기 위한 설정 정보
//괄호 안은 등록에서 제외할 부분을 작성, class =Configuration.class는 AppConfig를 등록하기 않기 위해
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();

    }
}