package com.inmobi.media;

import java.util.Map;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class G0 {
    public static final String a(String str, Map map) {
        if (map == null || str == null) {
            return str;
        }
        String str2 = str;
        for (Object obj : map.keySet()) {
            str2 = str2 != null ? StringsKt.replace$default(str2, String.valueOf(obj), String.valueOf(map.get(obj)), false, 4, (Object) null) : null;
        }
        return str2;
    }
}
