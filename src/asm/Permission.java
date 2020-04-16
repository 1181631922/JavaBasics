package asm;

import asm.permissionjudge.DMPermission;
import com.ripple.permission.RipplePermission;
import com.ripple.permission.annotation.NeedPermission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 15:13
 * Email: fanyafeng@live.cn
 */
@PermissionClassAnnon(value = "测试", pageName = "页面名称", names = {"a", "b", "c"})
public class Permission {
    private String name;

    @PermissionAnnon(value = true, failMethod = "onFail", permissionList = {"真特么的", "好难啊卧槽", "插装这方式简直了"})
    private void annonMethod(List<Object> strings) {
        System.out.println("调用方法:annonMethod");
    }

    public void onFail() {
        System.out.println("失败的实体方法被调用");
    }

    public void on() {
        List<String> stringArrayList = new ArrayList<>();
//        stringArrayList.add("fanyafeng");
//        stringArrayList.add("xiaofan");

        if (stringArrayList != null) {
            return;
        }
    }

    private  void find(List<Object> list) {
        List<String> permissionList = new ArrayList<>();
        if (!RipplePermission.INSTANCE.doCheckPermission(this, permissionList,
                "methodName", "methodDesc", list, "find")) {

        }
    }

    public void fun1(List<Object> list) {
        List<Object> permissionList = new ArrayList<>();
        permissionList.add(list);
    }
}
