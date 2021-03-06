package com.shooter.funtl.common.modal;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {

    /**请求序号*/
    private Integer draw;

    /**当前页号，从0开始*/
    private Integer start;

    /**每页大小*/
    private Integer length;

    /**记录总数*/
    private Integer recordsTotal;

    /**记录总数*/
    private Integer recordsFiltered;

    /**查询结果*/
    private List<T> data;

    /**错误信息*/
    private String error;

}
