package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Category {
    private String id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
