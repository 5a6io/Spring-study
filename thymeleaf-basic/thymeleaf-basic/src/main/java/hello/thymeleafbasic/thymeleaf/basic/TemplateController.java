package hello.thymeleafbasic.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/frag" +
            "ment")
    public String template() {
        return "template/fragment/fragmentMain";
    }

    @GetMapping("/layout")
    public String layout() {
        return "template/layout/layoutMain";
    }

    @GetMapping("layoutExtend")
    public String layoutExtends() {
        return "template/layoutExtend/layoutExtendMain";
    }
}
