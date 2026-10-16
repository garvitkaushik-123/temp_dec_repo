package com.inmobi.media;

import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public abstract class J9 {
    public static final boolean a(C2895uc c2895uc) {
        String str;
        Intrinsics.checkNotNullParameter(c2895uc, "<this>");
        HashMap hashMap = c2895uc.c;
        return (hashMap == null || (str = (String) hashMap.get(HttpHeaders.CONTENT_ENCODING)) == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) "gzip", false, 2, (Object) null)) ? false : true;
    }

    public static final String a(String url, Map map) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (map == null) {
            return url;
        }
        boolean z = T9.f2439a;
        T9.a(map);
        String a2 = T9.a(C3040d4.i.c, map);
        StringBuilder sb = new StringBuilder(url);
        int length = a2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare((int) a2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (a2.subSequence(i, length + 1).toString().length() > 0) {
            if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "?", false, 2, (Object) null)) {
                sb.append("?");
            }
            if (!StringsKt.endsWith$default(url, C3040d4.i.c, false, 2, (Object) null) && !StringsKt.endsWith$default(url, "?", false, 2, (Object) null)) {
                sb.append(C3040d4.i.c);
            }
            sb.append(a2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return new String(bArr, Charsets.UTF_8);
            } catch (UnsupportedEncodingException | Exception unused) {
            }
        }
        return "";
    }
}
