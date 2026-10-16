package com.bykv.vk.openvk.preload.falconx.a;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.bykv.vk.openvk.preload.b.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.ironsource.C3040d4;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: WebResourceUtils.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends d<?, ?>>, b> f931a = new HashMap();

    public static WebResourceResponse a(InputStream inputStream, Map<String, String> map) {
        if (inputStream == null) {
            return null;
        }
        try {
            String str = map.get("content-type");
            String[] strArr = new String[0];
            if (TextUtils.isEmpty(str)) {
                str = map.get("Content-Type");
            }
            if (!TextUtils.isEmpty(str) && str != null) {
                str = str.replace(" ", "");
                strArr = str.split(";");
            }
            String str2 = "";
            String str3 = str2;
            for (String str4 : strArr) {
                if (!TextUtils.isEmpty(str4)) {
                    int indexOf = str4.indexOf(C3040d4.i.b);
                    if (indexOf == -1) {
                        str2 = str4;
                    } else if (str4.contains("charset")) {
                        str3 = str4.substring(indexOf + 1);
                    }
                }
            }
            if (str != null ? str.contains("font/ttf") : false) {
                return new WebResourceResponse(str2, str3, 200, "OK", map, inputStream);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(str2, str3, inputStream);
            webResourceResponse.setResponseHeaders(map);
            return webResourceResponse;
        } catch (Throwable th) {
            Log.e("WebResourceUtils", "getResponseWithHeaders error", th);
            return null;
        }
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        synchronized (this.f931a) {
            b bVar = this.f931a.get(cls);
            if (bVar == null) {
                bVar = new b(new com.bykv.vk.openvk.preload.b.b.a[0]);
                this.f931a.put(cls, bVar);
            }
            bVar.a(aVar);
        }
    }

    public final com.bykv.vk.openvk.preload.b.b.a a(Class<? extends d<?, ?>> cls) {
        b bVar;
        synchronized (this.f931a) {
            bVar = this.f931a.get(cls);
        }
        return bVar;
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static DateFormat a(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i == 1) {
            str = "MMMM d, yyyy";
        } else if (i == 2) {
            str = "MMM d, yyyy";
        } else if (i == 3) {
            str = "M/d/yy";
        } else {
            throw new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(i)));
        }
        StringBuilder append = sb.append(str).append(" ");
        if (i2 == 0 || i2 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i2 == 2) {
            str2 = "h:mm:ss a";
        } else if (i2 == 3) {
            str2 = "h:mm a";
        } else {
            throw new IllegalArgumentException("Unknown DateFormat style: ".concat(String.valueOf(i2)));
        }
        return new SimpleDateFormat(append.append(str2).toString(), Locale.US);
    }
}
