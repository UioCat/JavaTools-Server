package com.uio.java_tools.service.impl;

import com.uio.java_tools.dto.AnalysisDTO;
import com.uio.java_tools.service.TokenizerService;
import org.springframework.stereotype.Service;

/**
 * @author han xun
 * Date 2021/11/6 13:39
 * Description:
 */
@Service("tokenizer_sql")
public class TokenizerSqlServiceImpl implements TokenizerService {

    @Override
    public AnalysisDTO analysisText(String text) {
        return null;
    }

    @Override
    public String getClassName(String code) {
        return null;
    }
}
