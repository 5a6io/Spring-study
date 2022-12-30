package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 자체적인 톰켓이 내장되어 있음.

/*setting or preferences -> gradle -> build and run 부분 gradle에서 intellij로 변경한 후 사용하면 빠름*/
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
