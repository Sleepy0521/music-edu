package com.music.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
@Data //get set 方法
@Accessors(chain=true) //链式调用
@ToString
public class Users {
    private Integer id;

    private String name;

    private String password;

    private String description;

    private Date createdate;

    private String loginname;

    private Integer age;


}