package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); // MVC, 스프링에서 직접 받아옴
        return "hello";
    } // 섹션 1 내용

    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam("name") String name, Model model){ // 파라미터로 받아옴
        // parameter command+p => option, required = true가 기본값 false로 하면 값을 안 넘겨줘도 됨.
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //적은 내용이 그대로 뜸. 데이터를 그대로 내림.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체면 JsonConverter가 기본으로 동작
    }

    static class Hello{
        private String name;

        // command + N => getter and setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

