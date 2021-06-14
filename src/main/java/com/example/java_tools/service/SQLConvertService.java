package com.example.java_tools.service;

import com.example.java_tools.utils.BackMessage;
import com.example.java_tools.utils.json_msg.ParameterMessage;

/**
 * @author uio
 * Date 2021/5/20 下午1:54
 * Description:
 */
public interface SQLConvertService {

    /**
     * 根据参数写出创表命令
     * @param parameterMessage parameter，tbName
     * @return 创表命令
     */
    BackMessage<String> createSqlService(ParameterMessage parameterMessage);

    // todo 使用模版替换 update SQL语句
    /**
     * 更新数据库表命令
     * @param parameterMessage parameter, keyParameter, tbName
     * @return
     */
    BackMessage<String> updateTableService(ParameterMessage parameterMessage);

    /**
     * 插入数据库命令
     * @param parameterMessage parameter，tbName
     * @return 参入数据库命令
     */
    BackMessage<String> insertMsgService(ParameterMessage parameterMessage);

    // todo 使用模版替换 delete SQL语句
    /**
     * 生成删除信息命令
     * @param parameterMessage keyParameter,tbName
     * @return 删除信息命令
     */
    BackMessage<String> deleteMsg(ParameterMessage parameterMessage);

        // todo 使用模版替换 select SQL语句
    /**
     * 查询信息命令生成
     * @param parameterMessage parameter，keyParameter，tbName
     * @return 查询数据库信息命令
     */
    BackMessage<String> selectMsg(ParameterMessage parameterMessage);
}
