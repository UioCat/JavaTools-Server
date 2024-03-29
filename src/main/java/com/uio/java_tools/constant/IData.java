package com.uio.java_tools.constant;

/**
 * @author uio
 * Date 2021/4/20 10:59
 * Description:
 */
public interface IData {

    /**
     * 用于生成MySQL 生成表命令模版文件路径
     */
    String templateForCreateSQLFile = "velocity_template/create_sql.vm";

    /**
     * 用户生成MySQL 插入语句的模版文件路径
     */
    String templateForInsertSQLFile = "velocity_template/insert_sql.vm";

    /**
     * 用户生成MySQL更新语句的模板文件路径
     */
    String templateForUpdateSQLFile = "velocity_template/update_sql.vm";

    /**
     * 用户生成MySQL查询语句的模板文件路径
     */
    String templateForSelectSQLFile = "velocity_template/select_sql.vm";

    /**
     * 用户生成MySQL删除语句的模板文件路径
     */
    String templateForDeleteSQLFile = "velocity_template/delete_sql.vm";
}
