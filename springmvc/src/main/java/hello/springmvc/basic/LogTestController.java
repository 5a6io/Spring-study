package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller로 하면 뷰 이름이 반환되지만 RestController는 RestAPI를 만드는데 편리한 컨트롤러
//@Slf4j 이걸 넣으면 따로 log 변수를 만들 필요 없이 로그 사용 가능. 롬복에서 지원해줌.
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); // 모든 게 다 출력됨. 운영 서버에 'system.out.println'이 전부 다 남아 지저분해짐.

        log.trace("trace log={}", name); // 1
        log.debug("debug log={}", name); // 2
        log.info(" info log={}", name); // 3 application.properties 에 설정을 하지 않으면 기본은 info로 설정이 되어있으므로 trace와 debug는 출력이 되지 않음.
        log.warn(" warn log={}", name); // 4
        log.error("error log={}", name); // 5 error가 가장 하위레벨

        return "ok";
    }
}
