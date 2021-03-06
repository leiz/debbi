package org.dl.debbi.user.account.utils;

import org.apache.commons.lang3.StringUtils;
import org.dl.debbi.common.error.CommonError;

// 特殊字符列表 http://kb.mozillazine.org/Network.IDN.blacklist_chars
public class BlackCharUtil {

    private static final String REGEX = "" +
            "\\u000A" +
            "\\u000D" +
            "\\u00A0" +
            "\\u00BC" +
            "\\u00BD" +
            "\\u00BE" +
            "\\u01C3" +
            "\\u02D0" +
            "\\u0337" +
            "\\u0338" +
            "\\u0589" +
            "\\u05C3" +
            "\\u05F4" +
            "\\u0609" +
            "\\u060A" +
            "\\u066A" +
            "\\u06D4" +
            "\\u0701" +
            "\\u0702" +
            "\\u0703" +
            "\\u0704" +
            "\\u115F" +
            "\\u1160" +
            "\\u1735" +
            "\\u2000" +
            "\\u2001" +
            "\\u2002" +
            "\\u2003" +
            "\\u2004" +
            "\\u2005" +
            "\\u2006" +
            "\\u2007" +
            "\\u2008" +
            "\\u2009" +
            "\\u200A" +
            "\\u200B" +
            "\\u2024" +
            "\\u2027" +
            "\\u2028" +
            "\\u2029" +
            "\\u202F" +
            "\\u2039" +
            "\\u203A" +
            "\\u2041" +
            "\\u2044" +
            "\\u2052" +
            "\\u205F" +
            "\\u2153" +
            "\\u2154" +
            "\\u2155" +
            "\\u2156" +
            "\\u2157" +
            "\\u2158" +
            "\\u2159" +
            "\\u215A" +
            "\\u215B" +
            "\\u215C" +
            "\\u215D" +
            "\\u215E" +
            "\\u215F" +
            "\\u2215" +
            "\\u2236" +
            "\\u23AE" +
            "\\u2571" +
            "\\u29F6" +
            "\\u29F8" +
            "\\u2AFB" +
            "\\u2AFD" +
            "\\u2FF0" +
            "\\u2FF1" +
            "\\u2FF2" +
            "\\u2FF3" +
            "\\u2FF4" +
            "\\u2FF5" +
            "\\u2FF6" +
            "\\u2FF7" +
            "\\u2FF8" +
            "\\u2FF9" +
            "\\u2FFA" +
            "\\u2FFB" +
            "\\u3000" +
            "\\u3002" +
            "\\u3014" +
            "\\u3015" +
            "\\u3033" +
            "\\u3164" +
            "\\u321D" +
            "\\u321E" +
            "\\u33AE" +
            "\\u33AF" +
            "\\u33C6" +
            "\\u33DF" +
            "\\uA789" +
            "\\uFE14" +
            "\\uFE15" +
            "\\uFE3F" +
            "\\uFE5D" +
            "\\uFE5E" +
            "\\uFEFF" +
            "\\uFF0E" +
            "\\uFF0F" +
            "\\uFF61" +
            "\\uFFA0" +
            "\\uFFF9" +
            "\\uFFFA" +
            "\\uFFFB" +
            "\\uFFFC" +
            "\\uFFFD";

    public static boolean notContentBlackChar(String str) {
        return !contentBlackChar(str);
    }

    public static boolean contentBlackChar(String str) {
        str = StringUtils.trim(str);
        if (StringUtils.isBlank(str)) return true;
        return str.matches(".*[" + REGEX + "]+.*");
    }

    public static void assertNotContentBlackChar(String str) {
        if (contentBlackChar(str)) throw CommonError.INVALID_ARGUMENT.e();
    }

    public static String trimBlackChar(String str) {
        str = StringUtils.trim(str);
        if (StringUtils.isBlank(str)) return null;
        return str.replaceAll("[" + REGEX + "]", " ").replaceAll("[\\s]{2,}", " ").trim();
    }
}
