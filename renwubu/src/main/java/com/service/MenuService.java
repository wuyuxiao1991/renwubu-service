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

    public Menu getMenus(String name, String identity) throws Exception{
        List<Menu> result = menuMapper.findByNameAndIdentity(name, identity);

        if (result.isEmpty()) {
            throw new Exception("找不到该菜单！");
        }

        return result.get(0);
    }
}