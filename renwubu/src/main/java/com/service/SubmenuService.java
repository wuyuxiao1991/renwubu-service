package com.service;

import com.persistence.entity.Submenu;
import com.persistence.mapper.SubmenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author wuyuxiao
 */
@Service
public
class SubmenuService {
    @Resource
    private SubmenuMapper submenumapper;

    public List<Submenu> getSubmenusByMenuGuid(String menuGuid) throws Exception {
        List<Submenu> list = submenumapper.findByMenuGuid(menuGuid);
        if (list.isEmpty()) {
            throw new Exception("找不到该子菜单！");
        }

        return list;
    }

    public List<Submenu> getSubmenusByName(String name) throws Exception {
        List<Submenu> list = submenumapper.findByName(name);
        if (list.isEmpty()) {
            throw new Exception("找不到该子菜单！");
        }

        return list;
    }

    public Submenu getSubmenusByGuid(String submenuGuid) {
        return submenumapper.findByGuid(submenuGuid);
    }

    public Submenu addSubmenu(String menuGuid, String submenuName) {
        String submenuGuid = UUID.randomUUID().toString();
        Submenu submenu = new Submenu();
        submenu.submenuGuid = submenuGuid;
        submenu.menuGuid = menuGuid;
        submenu.name = submenuName;
        submenumapper.insert(submenu);
        return submenu;
    }
}