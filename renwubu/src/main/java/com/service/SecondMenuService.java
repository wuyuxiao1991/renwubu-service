package com.service;

import com.persistence.entity.SecondMenu;
import com.persistence.entity.ThirdMenu;
import com.persistence.mapper.SecondMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author wuyuxiao
 */
@Service
public
class SecondMenuService {
    @Resource
    private SecondMenuMapper secondMenuMapper;

    public List<SecondMenu> getSecondMenusByMenuGuid(String menuGuid) throws Exception {
        return secondMenuMapper.findByMenuGuid(menuGuid);
    }


    public SecondMenu getSecondMenusBySecondMenuGuid(String secondMenuGuid) throws Exception {
        return secondMenuMapper.findByGuid(secondMenuGuid);
    }



    public SecondMenu addSecondMenu(String menuGuid, String secondMenuName) {
        String secondMenuGuid = UUID.randomUUID().toString();
        SecondMenu secondMenu = new SecondMenu();
        secondMenu.secondMenuGuid = secondMenuGuid;
        secondMenu.menuGuid = menuGuid;
        secondMenu.name = secondMenuName;
        secondMenuMapper.insert(secondMenu);
        return secondMenu;
    }
}