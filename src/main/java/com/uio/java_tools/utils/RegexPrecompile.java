package com.uio.java_tools.utils;

import com.uio.java_tools.enums.RegexEnum;

import java.util.regex.Pattern;

/**
 * @author VM
 * Date 2021/10/31 17:18
 * Description: 匹配规则
 */
public class RegexPrecompile {
    public static final Pattern METHOD_PATTERN = Pattern.compile(RegexEnum.METHOD_REGEX.getRegexString(), Pattern.CASE_INSENSITIVE);
    public static final Pattern PARAM_REGEX = Pattern.compile(RegexEnum.PARAMETER_REGEX.getRegexString(), Pattern.CASE_INSENSITIVE);
    public static final Pattern TYPE_AND_FILED_REGEX = Pattern.compile(RegexEnum.TYPE_FIELD_REGEX.getRegexString(), Pattern.CASE_INSENSITIVE);
}
