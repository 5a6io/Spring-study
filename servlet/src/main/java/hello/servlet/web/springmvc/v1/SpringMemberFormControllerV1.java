package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // component 스캔의 대상이 되어서 자동으로 스프링 빈에 등록이 됨. Controller 넣는 것이 제일 깔끔하고 이 방식을 많이 쑴.
//@Component // 컴포넌트 스캔의 대상이 됨. 그러나 이것만 있으면 안 되고 RequestMapping이 필요함.
//@RequestMapping // 클래스 레벨에 있으면 메소드 레벤에 있으면 안 됨. 그럼 인식이 안 됨.
//// 스프링 빈으로 직접 등록해도 됨.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
