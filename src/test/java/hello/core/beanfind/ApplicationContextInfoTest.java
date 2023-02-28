package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.AliasRegistry;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기") 
    void findAllBean() {//스프링에 등록된 모든 빈 정보 출력
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회
        
        for (String beanDefinitionName :
                beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            //ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회
            System.out.println("name = " + beanDefinitionName + " object = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기") 
    void findApplicationBean() { // 내가 등록한 빈 정보만 출력
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName :
                beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //getRole() : 스프링 내부에서 사용하는 빈 구분
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);

            }
        }
    }

    //기본적인 스프링 빈 조회 방법
    // ac.getBean(빈이름, 타입)
    // ac.getBean(타입)
    // NoSuchBeanDefinitionException : No bean named 'xxxxx' available, 조회 대상 스프링 빈이 없을때 예외발생

} // class end
