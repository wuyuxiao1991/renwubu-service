package com.model.request;

import lombok.Data;

/**
 *
 * @author wuyuxiao
 */

@Data
public class DeleteItemRequest {
    private String id;

    private String tableName;


    public String getId() {
        return id;

    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

