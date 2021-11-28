package com.uio.java_tools.controller.base;

import com.uio.java_tools.utils.ThreadLocalUtils;

/**
 * @author han xun
 * Date 2021-10-14 09:55
 * Description 基础Controller
 */
public class BaseController {

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId() {
        return ThreadLocalUtils.getCurrentUser().getId();
    }
}
