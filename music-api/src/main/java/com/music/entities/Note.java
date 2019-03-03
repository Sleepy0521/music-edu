package com.music.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
@Data //get set 方法
@Accessors(chain=true) //链式调用
@ToString
public class Note implements Serializable {
    private Integer id;

    private String content;

    private Date updateTime;

    private String title;

    private String author;

    private Integer ispublic;


}