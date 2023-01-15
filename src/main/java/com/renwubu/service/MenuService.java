package com.renwubu.service;

import com.renwubu.persistence.entity.Menu;
import com.renwubu.persistence.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public Menu getMenus(String name, String identity) throws Exception{
        List<Menu> result = menuMapper.findByNameAndIdentity(name, identity);

        if (result.isEmpty()) {
            throw new Exception("找不到该菜单！");
        }

        return result.get(0);
    }
}