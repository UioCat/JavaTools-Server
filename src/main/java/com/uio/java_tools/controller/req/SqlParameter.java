package com.uio.java_tools.controller.req;

import com.uio.java_tools.dto.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun
 * Date 2021/11/6 14:01
 * Description:
 */
@ToString
@Getter
@Setter
public class SqlParameter extends Parameter {

    /**
     * 是否为唯一键
     */
    private Boolean uniqueKey;
}
