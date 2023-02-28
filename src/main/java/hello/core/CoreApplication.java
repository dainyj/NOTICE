package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// @SpringBootApplication를 프로젝트 시작 위치에 두는 것이 관례, 이 설정 안에 @ComponentScan이 들어있다.
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
