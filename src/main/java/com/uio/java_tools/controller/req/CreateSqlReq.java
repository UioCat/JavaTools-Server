package com.uio.java_tools.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author han xun
 * Date 2021/11/1 10:27
 * Description:
 */
@ToString
@Setter
@Getter
public class CreateSqlReq {

    private List<SqlParameter> parameterList;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 主键
     */
    private String primaryKey;

}
