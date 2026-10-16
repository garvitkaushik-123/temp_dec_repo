package com.fyber.inneractive.sdk.util;

import android.net.Uri;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class d1 {
    public static String a(String str, HashMap hashMap) {
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append(z ? "?" : C3040d4.i.c);
            sb.append((String) entry.getKey());
            sb.append(C3040d4.i.b);
            sb.append(Uri.encode((String) entry.getValue()));
            z = false;
        }
        return sb.toString();
    }
}
