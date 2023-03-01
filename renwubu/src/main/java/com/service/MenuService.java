package com.service;


import com.persistence.entity.Menu;
import com.persistence.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    public Menu getMenuByGuid(String guid) throws Exception{
        Menu result = menuMapper.findByGuid(guid);

        if (result==null) {
            throw new Exception("找不到该菜单！");
        }

        return result;
    }

    public List<Menu> getMenus(String identity) throws Exception{
        List<Menu> result = menuMapper.findByIdentity(identity);

        if (result.isEmpty()) {
            throw new Exception("找不到该菜单！");
        }

        return result;
    }
}