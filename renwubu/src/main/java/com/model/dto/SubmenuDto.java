package com.model.dto;

import com.persistence.entity.Submenu;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;


/**
 * @author wuyuxiao
 */
@NoArgsConstructor
public
class SubmenuDto {

    public String submenuGuid;

    public String name;

    public LocalDateTime createTime;

    public LocalDateTime updateTime;

    public String getSubmenuGuid() {
        return submenuGuid;
    }

    public void setSubmenuGuid(String submenuGuid) {
        this.submenuGuid = submenuGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    static public SubmenuDto transform(Submenu submenu) {
        SubmenuDto submenuDto = new SubmenuDto();
        BeanUtils.copyProperties(submenu, submenuDto);
        return submenuDto;
    }

}