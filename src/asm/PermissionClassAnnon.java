package asm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 15:20
 * Email: fanyafeng@live.cn
 */
@Retention(RetentionPolicy.CLASS)
public @interface PermissionClassAnnon {
    /**
     * 生成类的全部链接,不能为空
     * 此为以后所有value的key值
     * 勿动
     *
     * @return
     */
    String value();

    /**
     * 生成的为pageName
     * 如果为空则默认为全部大写字母
     * 否则取当前注解值
     * @return
     */
    String pageName() default "";

    /**
     * 是否需要登录，鉴于实际情况需要登录情况居多默认为true
     * 如需登录此注解可空
     * 否则直接设置为false即可
     * @return
     */
    boolean needLogin() default true;

    /**
     * 此为note消息，主要是给自己或者同事看，最好加上
     * 此类的作用或者是那个页面等等
     * @return
     */
    String note() default "";

    String[] names();
}
