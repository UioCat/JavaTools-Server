package com.uio.java_tools.service.impl;

import com.uio.java_tools.dto.ParseParameterDTO;
import com.uio.java_tools.service.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author han xun
 * Date 2021/6/26 16:30
 * Description: 根据SQL生成文件
 */
@Service
public class GeneratorBySQL implements GeneratorService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ParseParameterDTO parse(String inputString) {

        return null;
    }
}
