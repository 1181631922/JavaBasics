package asm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 15:14
 * Email: fanyafeng@live.cn
 */
@Target(ElementType.METHOD)
public @interface PermissionAnnon {
    boolean value();

    String failMethod();

    String[] permissionList();

}
