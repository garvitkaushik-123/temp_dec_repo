package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.a.a.a;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.ironsource.V5;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.io.File;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: GeckoHubUtil.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static File f949a;
    private static Context b;
    private static String c;
    private static final Set<String> g = new HashSet(Arrays.asList("js", "css", AnalyticsConstants.CREATIVE_TYPE_HTML, "ico", "jpeg", "jpg", "png", "gif", "woff", "svg", "ttf", "woff2", "webp", "otf", "sfnt"));
    private Map.Entry<String, JSONObject> d;
    private Map.Entry<String, JSONObject> e;
    private INetWork f;

    /* synthetic */ c(byte b2) {
        this();
    }

    /* compiled from: GeckoHubUtil.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f950a = new c(0);
    }

    public static c a(Context context) {
        b = context;
        if (f949a == null) {
            f949a = new File(b.getCacheDir() + File.separator + "gecko");
        }
        return a.f950a;
    }

    public static c a() {
        return a.f950a;
    }

    private c() {
    }

    public static void a(String str) {
        c = str;
    }

    public final void a(String str, IStatisticMonitor iStatisticMonitor, Set<String> set, INetWork iNetWork) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b(new b.a(b).b("f36c832c8dbb162c49b46a7a6dd47fbd").a("f36c832c8dbb162c49b46a7a6dd47fbd").b().b(str).a("9999999.0.0").a(new a.C0113a().a().a(com.bykv.vk.openvk.preload.geckox.a.a.b.b).b()).a(f949a).a().c(c).a(iStatisticMonitor).a(iNetWork).a(SystemClock.elapsedRealtime()), (byte) 0);
        this.f = iNetWork;
        com.bykv.vk.openvk.preload.geckox.a a2 = com.bykv.vk.openvk.preload.geckox.a.a(bVar);
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            linkedList.add(new CheckRequestBodyModel.TargetChannel(it.next()));
        }
        hashMap.put("f36c832c8dbb162c49b46a7a6dd47fbd", linkedList);
        a2.a(hashMap);
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("?");
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    private JSONObject a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Map.Entry<String, JSONObject> entry = this.d;
                if (entry == null || !str.equals(entry.getKey())) {
                    String a2 = com.bykv.vk.openvk.preload.geckox.utils.b.a(new com.bykv.vk.openvk.preload.falconx.loader.a(b, "f36c832c8dbb162c49b46a7a6dd47fbd", f949a).getInputStream(str + "/manifest.json"));
                    if (TextUtils.isEmpty(a2)) {
                        return null;
                    }
                    this.d = new AbstractMap.SimpleEntry(str, new JSONObject(a2));
                }
                Map.Entry<String, JSONObject> entry2 = this.e;
                if (entry2 == null || !str.equals(entry2.getKey())) {
                    String a3 = com.bykv.vk.openvk.preload.geckox.utils.b.a(new com.bykv.vk.openvk.preload.falconx.loader.a(b, "f36c832c8dbb162c49b46a7a6dd47fbd", f949a).getInputStream(str + "/md5_url_map.json"));
                    if (TextUtils.isEmpty(a3)) {
                        return null;
                    }
                    this.e = new AbstractMap.SimpleEntry(str, new JSONObject(a3));
                }
                JSONObject value = this.d.getValue();
                JSONObject value2 = this.e.getValue();
                String a4 = a(str2, value2);
                if (value.has(a4)) {
                    JSONObject jSONObject = value.getJSONObject(a4);
                    a(value, a4, str2);
                    return jSONObject;
                }
                String b2 = b(str2);
                if (b2 == null) {
                    return null;
                }
                String a5 = a(b2, value2);
                if (value.has(a5)) {
                    JSONObject jSONObject2 = value.getJSONObject(a5);
                    a(value, a5, str2);
                    return jSONObject2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(str).getString("md5");
        } catch (Throwable unused) {
            return "";
        }
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        try {
            if ("once".equals(jSONObject.getJSONObject(str).optJSONObject("cacheStrategy").optString("hitStrategy"))) {
                jSONObject.remove(str);
                c(str2);
            }
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        try {
            if (this.f == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f.syncDoGet(str);
        } catch (Throwable unused) {
        }
    }

    public static com.bykv.vk.openvk.preload.falconx.loader.a b() {
        try {
            return new com.bykv.vk.openvk.preload.falconx.loader.a(b, "f36c832c8dbb162c49b46a7a6dd47fbd", f949a);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(ILoader iLoader) {
        if (iLoader != null) {
            try {
                iLoader.release();
            } catch (Throwable unused) {
            }
        }
    }

    public final WebResourceResponseModel a(ILoader iLoader, String str, String str2) {
        String substring;
        try {
            if (iLoader == null) {
                return new WebResourceResponseModel(-1, null);
            }
            if (!TextUtils.isEmpty(str2) && !str2.matches("^https?:\\/\\/www\\.google-analytics\\.com/(?:ga|urchin|analytics)\\.js") && !str2.matches("^https?:\\/\\/www\\.googletagmanager\\.com\\/(gtag\\/js|gtm\\.js)") && !str2.matches("^https?:\\/\\/analytics\\.tiktok\\.com\\/i18n\\/pixel") && !str2.matches("https?:\\/\\/connect\\.facebook\\.net\\/(.*)\\/fbevents\\.js") && !str2.matches("https?:\\/\\/mc\\.yandex\\.ru\\/") && !str2.contains("jsonp") && !str2.contains("Callback") && !str2.contains("analytics.tiktok.com/i18n/pixel") && !str2.contains("google-analytics.com/analytics") && !str2.contains("connect.facebook.net")) {
                JSONObject a2 = a(str, str2);
                Set<String> set = g;
                String b2 = b(str2);
                int lastIndexOf = b2.lastIndexOf(".");
                if (lastIndexOf == -1) {
                    substring = "";
                } else {
                    substring = b2.substring(lastIndexOf + 1);
                }
                int i = set.contains(substring) ? 2 : -1;
                if (a2 == null) {
                    return new WebResourceResponseModel(i, null);
                }
                String optString = a2.optString(V5.c.b, null);
                if (optString == null) {
                    return new WebResourceResponseModel(i, null);
                }
                JSONObject jSONObject = a2.has("respHeader") ? a2.getJSONObject("respHeader") : null;
                if (jSONObject == null) {
                    return new WebResourceResponseModel(i, null);
                }
                String str3 = str + File.separator + optString;
                InputStream inputStream = !iLoader.exist(str3) ? null : iLoader.getInputStream(str3);
                if (inputStream == null) {
                    return new WebResourceResponseModel(i, null);
                }
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return new WebResourceResponseModel(i, com.bykv.vk.openvk.preload.falconx.a.a.a(inputStream, hashMap));
            }
            return new WebResourceResponseModel(1, null);
        } catch (Throwable unused) {
            return new WebResourceResponseModel(-1, null);
        }
    }

    public static int a(ILoader iLoader, String str) {
        if (iLoader == null || str == null) {
            return 0;
        }
        try {
            return new com.bykv.vk.openvk.preload.falconx.loader.a(b, "f36c832c8dbb162c49b46a7a6dd47fbd", f949a).a(str + File.separator);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
