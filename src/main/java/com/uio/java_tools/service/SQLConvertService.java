package com.uio.java_tools.service;

import com.uio.java_tools.dto.EntityParameterDTO;
import com.uio.java_tools.utils.BackMessage;
import com.uio.java_tools.dto.ParameterDTO;

/**
 * @author uio
 * Date 2021/5/20 下午1:54
 * Description:
 */
public interface SQLConvertService {

    /**
     * 根据参数写出创表命令
     * @param parameterDTO parameter，tbName
     * @return 创表命令
     */
    BackMessage<String> createSqlService(EntityParameterDTO parameterDTO);

    /**
     * 更新数据库表命令
     * @param parameterDTO parameter, keyParameter, tbName
     * @return
     */
    BackMessage<String> updateTableService(ParameterDTO parameterDTO);

    /**
     * 插入数据库命令
     * @param parameterDTO parameter，tbName
     * @return 参入数据库命令
     */
    BackMessage<String> insertMsgService(ParameterDTO parameterDTO);

    /**
     * 生成删除信息命令
     * @param parameterDTO keyParameter,tbName
     * @return 删除信息命令
     */
    BackMessage<String> deleteMsg(ParameterDTO parameterDTO);

    /**
     * 查询信息命令生成
     * @param parameterDTO parameter，keyParameter，tbName
     * @return 查询数据库信息命令
     */
    BackMessage<String> selectMsg(ParameterDTO parameterDTO);
}
