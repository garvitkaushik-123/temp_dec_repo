package com.ironsource.environment;

import com.ironsource.C3260q4;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;
import org.slf4j.Marker;

/* loaded from: classes6.dex */
public class StringUtils {
    public static String toLowerCase(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ENGLISH);
    }

    public static String toUpperCase(String str) {
        return str == null ? "" : str.toUpperCase(Locale.ENGLISH);
    }

    public static String decodeURI(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    public static String encodeURI(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
        } catch (UnsupportedEncodingException e) {
            C3260q4.d().a(e);
            return "";
        }
    }
}
