package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persistence.entity.Submenu;
import com.persistence.mapper.SubmenuMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuyuxiao
 */
@Service
public
class SubmenuService {
    @Resource
    private SubmenuMapper submenumapper;

    public List<Submenu> getSubmenus(String menuGuid) throws Exception {
        List<Submenu> list = submenumapper.findByNameAndIdentity(menuGuid);
        if (list.isEmpty()) {
            throw new Exception("找不到该子菜单！");
        }

        return list;
    }
}