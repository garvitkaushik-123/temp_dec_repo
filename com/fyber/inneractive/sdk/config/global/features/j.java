package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class j extends h {
    public j() {
        super("load_timeouts");
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    public static boolean d(String str) {
        return UnitDisplayType.INTERSTITIAL.name().equalsIgnoreCase(str) || UnitDisplayType.REWARDED.name().equalsIgnoreCase(str);
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? "all_mediators" : str.toLowerCase(Locale.US);
    }

    public final int b(String str, String str2) {
        String a2 = a(str, "bidding", "global_timeout", e(str2));
        String a3 = a(str, "bidding", "global_timeout", "all_mediators");
        int i = d(str) ? 30000 : 10000;
        Integer a4 = a(a(str, "global_timeout", "all_mediators"));
        if (a4 != null) {
            i = a4.intValue();
        }
        Integer a5 = a(a3);
        if (a5 != null) {
            i = a5.intValue();
        }
        Integer a6 = a(a2);
        return a6 != null ? a6.intValue() : i;
    }

    public final int c(String str, String str2) {
        String a2 = a(str, "global_timeout", e(str2));
        String a3 = a(str, "global_timeout", "all_mediators");
        int i = d(str) ? 30000 : 10000;
        Integer a4 = a(a(str, "global_timeout", "all_mediators"));
        if (a4 != null) {
            i = a4.intValue();
        }
        Integer a5 = a(a3);
        if (a5 != null) {
            i = a5.intValue();
        }
        Integer a6 = a(a2);
        return a6 != null ? a6.intValue() : i;
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        j jVar = new j();
        a(jVar);
        return jVar;
    }
}
