package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller")  // 스프링 빈의 이름을 url로 맞춤.
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form"); // WEB-INF/views의 new-form.jsp로 감. 하지만 실행 시 뷰를 찾지 못하여 오류 페이지가 뜸.
        /**
         * application.properties에 spring.mvc.prefix와 suffix를 사용 후 뷰가 나타남.
         */
    }
}
