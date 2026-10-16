package com.ironsource;

import java.util.Map;

/* loaded from: classes6.dex */
public interface E4 {
    static /* synthetic */ String a(E4 e4, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return e4.a(str, str2);
    }

    String a(String str, String str2);

    void a(String str);

    Map<String, ?> allData();

    void b(String str, String str2);
}
