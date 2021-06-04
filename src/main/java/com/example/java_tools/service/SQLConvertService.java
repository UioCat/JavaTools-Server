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
     *
     * 根据参数写出创表命令
     * @param parameterMessage parameter，tbName
     * @return 创表命令
     */
    BackMessage createSqlService(ParameterMessage parameterMessage);


}
