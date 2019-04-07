package xyz.zhangyi.practicejava.framework.mybatis.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Course {
    private String id;
    private Teacher teacher;
    private String name;
    private String description;
    private String earning;
    private String trainee;
    private String outline;
    private double price;
    private int duration;
    private Category category;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}