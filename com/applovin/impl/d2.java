package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.applovin.impl.c2;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class d2 {
    private static volatile ExecutorService g;

    /* renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f432a;
    protected final com.applovin.impl.sdk.o b;
    private final c2.b c;
    private final Map d = Collections.synchronizedMap(new HashMap());
    private final Set e = Collections.synchronizedSet(new HashSet());
    private static final int f = (int) TimeUnit.SECONDS.toMillis(30);
    private static final Object h = new Object();

    class a implements ThreadFactory {

        /* renamed from: com.applovin.impl.d2$a$a, reason: collision with other inner class name */
        class C0093a implements Thread.UncaughtExceptionHandler {
            C0093a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                d2.this.f432a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    d2.this.f432a.O().a("HealthEventsReporter", "Caught unhandled exception", th);
                }
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) d2.this.f432a.a(v4.Q)).intValue());
            thread.setUncaughtExceptionHandler(new C0093a());
            return thread;
        }
    }

    public d2(com.applovin.impl.sdk.k kVar, c2.b bVar) {
        this.f432a = kVar;
        this.b = kVar.O();
        this.c = bVar;
        a();
    }

    private void a() {
        if (g != null) {
            return;
        }
        synchronized (h) {
            if (g != null) {
                return;
            }
            g = Executors.newFixedThreadPool(1, new a());
        }
    }

    private void c(c2 c2Var, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (c2Var.a() == c2.b.AD || c2Var.a() == c2.b.MEDIATED_AD || c2Var.a() == c2.b.USER_SESSION || !k7.a(((Integer) this.f432a.a(v4.z)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) a(c2Var, map).openConnection();
                try {
                    int i = f;
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i);
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("AppLovin-Event-Type", c2Var.b());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.a("HealthEventsReporter", c2Var.b() + " reported with code " + responseCode + " and extra parameters " + map);
                    }
                    this.d.put(c2Var, Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (com.applovin.impl.sdk.o.a()) {
                            this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b() + " with extra parameters " + map, th);
                        }
                        k7.a(httpURLConnection, this.f432a);
                    } finally {
                        k7.a(httpURLConnection, this.f432a);
                    }
                }
            } catch (Throwable th3) {
                httpURLConnection = null;
                th = th3;
            }
        }
    }

    public void d(c2 c2Var, Map map) {
        a(c2Var, map, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, c2 c2Var, JSONObject jSONObject) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(str);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                int i = f;
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setReadTimeout(i);
                httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                httpURLConnection2.setDefaultUseCaches(false);
                httpURLConnection2.setAllowUserInteraction(false);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setFixedLengthStreamingMode(bytes.length);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("AppLovin-Event-Type", c2Var.b());
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
                int responseCode = httpURLConnection2.getResponseCode();
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.a("HealthEventsReporter", c2Var.b() + " reported with code " + responseCode);
                }
                this.d.put(c2Var, Long.valueOf(System.currentTimeMillis()));
                k7.a(httpURLConnection2, this.f432a);
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b(), th);
                    }
                } finally {
                    k7.a(httpURLConnection, this.f432a);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void d(final c2 c2Var, List list) {
        final String str = (String) this.f432a.a(v4.A);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double a2 = c2Var.a(this.f432a);
        if (k7.a(a2)) {
            if (((Boolean) this.f432a.a(v4.G)).booleanValue()) {
                a(str, c2Var, a(c2Var, a2, list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject a3 = a(c2Var, a2, Collections.singletonList((Map) it.next()));
                g.execute(new Runnable() { // from class: com.applovin.impl.d2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d2.this.a(str, c2Var, a3);
                    }
                });
            }
        }
    }

    public void a(c2 c2Var, String str) {
        a(c2Var, str, new HashMap());
    }

    public void a(c2 c2Var, String str, Map map) {
        map.put("source", str);
        d(c2Var, map);
    }

    public void a(c2 c2Var, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.e.add(str2)) {
            map.put("source", str);
            a(c2Var, str, map);
        }
    }

    public void a(c2 c2Var, Map map, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(c2Var, arrayList, j);
    }

    private Map b(c2 c2Var, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", c2Var.b());
        if (c2Var == c2.y0 || c2Var == c2.x0 || c2Var == c2.N0 || c2Var == c2.L0) {
            if (((Boolean) this.f432a.a(v4.k4)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(k8.d()), hashMap);
                CollectionUtils.putStringIfValid("wvv", k8.c(), hashMap);
                CollectionUtils.putStringIfValid("wvpn", k8.b(), hashMap);
            }
            CollectionUtils.putStringIfValid("oglv", this.f432a.B().I(), hashMap);
        }
        Map L = this.f432a.B().L();
        hashMap.put(N6.H, String.valueOf(L.get(N6.H)));
        hashMap.put("country_code", String.valueOf(L.get("country_code")));
        hashMap.put("cc", this.f432a.w().getCountryCode());
        hashMap.put("applovin_random_token", this.f432a.i0());
        hashMap.put("compass_random_token", this.f432a.v());
        hashMap.put(N6.B, Build.MODEL);
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("revision", Build.DEVICE);
        hashMap.put(N6.F, Build.VERSION.RELEASE);
        hashMap.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put(BidTokenRepositoryKt.SDK_VERSION, String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", j.b(), hashMap);
        hashMap.put(N6.u, (String) this.f432a.a(v4.t));
        b(hashMap);
        a(hashMap);
        if (map != null) {
            hashMap.putAll(c(c2Var, map));
        }
        return hashMap;
    }

    private Map c(c2 c2Var, Map map) {
        HashMap hashMap = new HashMap(map);
        if (c2Var == c2.C0) {
            hashMap.remove("details");
        }
        return hashMap;
    }

    public void a(final c2 c2Var, final List list, long j) {
        if (a(c2Var, j)) {
            return;
        }
        try {
            if (k7.h()) {
                g.execute(new Runnable() { // from class: com.applovin.impl.d2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        d2.this.b(c2Var, list);
                    }
                });
            } else {
                b(c2Var, list);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.d("HealthEventsReporter", "Failed to report " + c2Var.b() + " with extra parameters collection " + list, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(c2 c2Var, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("HealthEventsReporter", "Reporting " + c2Var.b() + " with extra parameters collection " + list);
        }
        if (this.c != c2Var.a()) {
            k1.a("Health event " + c2Var.b() + " category: " + c2Var.a() + " does not match the reporter category: " + this.c, new Object[0]);
        }
        c(c2Var, list);
        d(c2Var, list);
    }

    private URL a(c2 c2Var, Map map) {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error?");
        Iterator it = b(c2Var, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            sb.append(encode).append(C3040d4.i.b).append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
            if (it.hasNext()) {
                sb.append(C3040d4.i.c);
            }
        }
        return new URL(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Map map) {
        String str;
        PackageInfo packageInfo;
        PackageManager packageManager;
        String str2 = "";
        try {
            packageManager = com.applovin.impl.sdk.k.o().getPackageManager();
            str = com.applovin.impl.sdk.k.o().getPackageName();
        } catch (Throwable unused) {
            str = "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (Throwable unused2) {
            packageInfo = null;
            map.put("package_name", str);
            if (packageInfo != null) {
            }
            map.put(BidTokenRepositoryKt.APP_VERSION, str2);
            map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
        }
        map.put("package_name", str);
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
        }
        map.put(BidTokenRepositoryKt.APP_VERSION, str2);
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private JSONObject a(c2 c2Var, double d, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (c2Var == c2.y0 || c2Var == c2.x0 || c2Var == c2.N0 || c2Var == c2.L0) {
            if (((Boolean) this.f432a.a(v4.k4)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(k8.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", k8.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", k8.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f432a.B().I());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map L = this.f432a.B().L();
        JsonUtils.putObject(jSONObject2, N6.H, L.get(N6.H));
        JsonUtils.putObject(jSONObject2, N6.F, L.get(N6.F));
        JsonUtils.putObject(jSONObject2, "api_level", String.valueOf(L.get("api_level")));
        JsonUtils.putObject(jSONObject2, "brand", L.get("brand"));
        JsonUtils.putObject(jSONObject2, N6.B, L.get(N6.B));
        JsonUtils.putObject(jSONObject2, "revision", L.get("revision"));
        JsonUtils.putObject(jSONObject2, "country_code", L.get("country_code"));
        JsonUtils.putObject(jSONObject2, "cc", this.f432a.w().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f432a.i0());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(j.b()));
        Map E = this.f432a.B().E();
        JsonUtils.putObject(jSONObject2, BidTokenRepositoryKt.SDK_VERSION, E.get(BidTokenRepositoryKt.SDK_VERSION));
        JsonUtils.putObject(jSONObject2, "plugin_version", this.f432a.a(v4.I3));
        JsonUtils.putObject(jSONObject2, BidTokenRepositoryKt.APP_VERSION, E.get(BidTokenRepositoryKt.APP_VERSION));
        JsonUtils.putObject(jSONObject2, "package_name", E.get("package_name"));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) E.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, N6.u, this.f432a.a(v4.t));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f432a.V());
        SessionTracker n0 = this.f432a.n0();
        JsonUtils.putObject(jSONObject2, "app_state", n0.getCurrentApplicationState().b());
        JsonUtils.putObject(jSONObject2, "app_state_duration_ms", Long.valueOf(n0.getCurrentApplicationStateDurationMillis()));
        JsonUtils.putObject(jSONObject2, "session_id", n0.getSessionId());
        JsonUtils.putObject(jSONObject2, "session_duration_ms", Long.valueOf(System.currentTimeMillis() - com.applovin.impl.sdk.k.n()));
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", c2Var.b());
            JsonUtils.putDouble(jSONObject3, "weight", d);
            JsonUtils.putString(jSONObject3, "level", "DEBUG");
            a(map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    private void a(Map map) {
        if (map == null) {
            return;
        }
        Object a2 = this.f432a.I().a();
        if (a2 instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) a2).getAdIdNumber()));
        } else if (a2 instanceof v2) {
            v2 v2Var = (v2) a2;
            map.put("fs_ad_network", v2Var.getNetworkName());
            map.put("fs_ad_creative_id", v2Var.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(c2 c2Var, long j) {
        Long l = (Long) this.d.get(c2Var);
        return System.currentTimeMillis() - (l != null ? l.longValue() : -1L) < j;
    }
}
