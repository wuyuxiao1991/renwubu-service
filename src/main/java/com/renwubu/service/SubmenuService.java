package com.renwubu.service;

import com.renwubu.persistence.entity.Submenu;
import com.renwubu.persistence.mapper.SubmenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class SubmenuService {
    @Autowired
    private SubmenuMapper  submenumapper;
    public List<Submenu> getSubmenus(String menuGuid) throws  Exception{
        List<Submenu> list= submenumapper.findByNameAndIdentity(menuGuid);
        if(list.isEmpty()){
            throw  new Exception("找不到该子菜单！");
        }

        return list;
    }
}