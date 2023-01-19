package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    //MyEncludeComponent 가 붙은 것들은 ComponentScan 에서 제외할 것임
}
