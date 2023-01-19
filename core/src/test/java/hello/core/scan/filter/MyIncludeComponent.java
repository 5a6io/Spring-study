package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    //MyIncludeComponent 가 붙은 것들은 ComponentScan 에 추가할 것임
}
