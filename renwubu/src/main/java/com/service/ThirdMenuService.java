package com.service;

import com.persistence.entity.SecondMenu;
import com.persistence.entity.ThirdMenu;
import com.persistence.mapper.ThirdMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author wuyuxiao
 */
@Service
public
class ThirdMenuService {
    @Resource
    private ThirdMenuMapper thirdMenuMapper;

    public List<ThirdMenu> getBySecondMenuGuid(String secondMenuGuid)  {
        return thirdMenuMapper.findBySecondMenuGuid(secondMenuGuid);
    }

    public ThirdMenu getThirdMenuByGuid(String thirdMenuGuid) {
        return thirdMenuMapper.findByGuid(thirdMenuGuid);
    }

    public ThirdMenu addThirdMenu(String secondMenuGuid, String thirdMenuName) {
        String thirdMenuGuid = UUID.randomUUID().toString();
        ThirdMenu thirdMenu = new ThirdMenu();
        thirdMenu.thirdMenuGuid = thirdMenuGuid;
        thirdMenu.secondMenuGuid = secondMenuGuid;
        thirdMenu.name = thirdMenuName;
        thirdMenuMapper.insert(thirdMenu);
        return thirdMenu;
    }
}