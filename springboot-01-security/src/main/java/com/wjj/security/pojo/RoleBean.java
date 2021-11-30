package com.wjj.security.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author wjj
 * @create 2021/10/13
 * @Description
 */
@Getter
@Setter
@Entity(name = "t_role")
public class RoleBean {

/*
@GeneratedValue注解存在的意义主要就是为一个实体生成一个唯一标识的主键、@GeneratedValue提供了主键的生成策略。
@GeneratedValue注解有两个属性,分别是strategy和generator,
strategy提供四种值
-AUTO主键由程序控制, 是默认选项 ,不设置就是这个
-IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
-SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
-Table 提供特定的数据库产生主键, 该方式更有利于数据库的移植*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "name_zh")
    private String nameZh;
}
