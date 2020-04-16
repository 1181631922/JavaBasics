package asm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author： fanyafeng
 * Data： 2020/4/9 19:21
 * Email: fanyafeng@live.cn
 * 对应注解类
 */
public class PermissionAnnonModel implements Serializable {
    private boolean value;
    private String failMethodName;
    private ArrayList<String> permissionList=new ArrayList<>();

    public PermissionAnnonModel() {
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getFailMethodName() {
        return failMethodName;
    }

    public void setFailMethodName(String failMethodName) {
        this.failMethodName = failMethodName;
    }

    public ArrayList<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(ArrayList<String> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "PermissionAnnonModel{" +
                "value=" + value +
                ", failMethodName='" + failMethodName + '\'' +
                ", permissionList=" + permissionList +
                '}';
    }
}
