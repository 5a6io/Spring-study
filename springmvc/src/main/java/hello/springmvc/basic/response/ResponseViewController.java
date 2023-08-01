package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2") // @ResponseBody를 쓰면 뷰를 찾지 않고 응답메시지로 나감.
    public String responseView2(Model model) {
        model.addAttribute("data", "hello!");

        return "response/hello";
    }

    @RequestMapping("response/hello") // 논리적인 뷰의 이름과 같으면 뷰의 이름을 반환하지 않고도 불러올 수 있음.
    public void responseView3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
