package cn.edu.tongji.easygo.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String> list = new ArrayList<String>();
        list.add("user");
        list.add("admin");
        return list;
    }

    @Override
    public List<String> getRoleList(Object userId, String s) {
        List<String> list = new ArrayList<String>();
        if (!userId.equals(10001))
            list.add("user");
        else
            list.add("admin");
        return list;
    }
}
