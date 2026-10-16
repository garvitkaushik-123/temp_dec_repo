package com.apm.insight;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.insight.k.j;
import com.apm.insight.l.m;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MonitorCrashHandler.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    protected static MonitorCrash f231a;
    private static volatile ConcurrentHashMap<String, d> c = new ConcurrentHashMap<>();
    private MonitorCrash b;

    private d(MonitorCrash monitorCrash) {
        this.b = monitorCrash;
        com.apm.insight.entity.b.a(this);
        com.apm.insight.j.b.c();
        j.e();
    }

    public final boolean a(Object obj) {
        return this.b == obj;
    }

    public static Object a() {
        return f231a;
    }

    static void a(Context context, final MonitorCrash monitorCrash) {
        f231a = monitorCrash;
        d dVar = new d(monitorCrash);
        final com.apm.insight.nativecrash.b a2 = e.a();
        Npth.init(context, new ICommonParams() { // from class: com.apm.insight.d.1
            @Override // com.apm.insight.ICommonParams
            public final List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final long getUserId() {
                return 0L;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Object> getCommonParams() {
                JSONObject d = d.this.d();
                HashMap hashMap = new HashMap();
                if (d != null) {
                    Iterator<String> keys = d.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, d.opt(next));
                    }
                }
                return hashMap;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getDeviceId() {
                return TextUtils.isEmpty(monitorCrash.mConfig.mDeviceId) ? a2.d() : monitorCrash.mConfig.mDeviceId;
            }
        });
    }

    static void a(MonitorCrash monitorCrash) {
        d dVar = new d(monitorCrash);
        if (monitorCrash.mConfig != null) {
            c.put(monitorCrash.mConfig.mAid, dVar);
        }
    }

    static d a(String str) {
        return c.get(str);
    }

    public final JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        return a(stackTraceElementArr, th, null);
    }

    public final JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th, String str) {
        if (this.b.mConfig.mPackageName == null) {
            return new JSONArray().put(new m.a(0, stackTraceElementArr.length).a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        JSONArray a2 = m.a(stackTraceElementArr, this.b.mConfig.mPackageName);
        if (str != null && this.b.mConfig.mThreadList != null && a.a(a2)) {
            for (String str2 : this.b.mConfig.mThreadList) {
                if (TextUtils.equals(str2, str)) {
                    a2.put(new m.a(0, stackTraceElementArr.length).a());
                }
            }
        }
        return a2;
    }

    public final JSONArray a(String[] strArr) {
        if (this.b.config().mPackageName == null) {
            return new JSONArray().put(new m.a(0, strArr.length).a());
        }
        return m.a(strArr, this.b.mConfig.mPackageName);
    }

    public final boolean a(String str, String str2) {
        if (this.b.config().mPackageName == null) {
            return true;
        }
        return com.apm.insight.entity.b.a(str, a.a(this.b.mConfig.mSoList), str2, a.a(this.b.mConfig.mThreadList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.b.mConfig.mPackageName == null) {
                Context g = e.g();
                PackageInfo packageInfo = g.getPackageManager().getPackageInfo(g.getPackageName(), 128);
                if (packageInfo != null) {
                    if (this.b.mConfig.mVersionInt == -1) {
                        this.b.mConfig.mVersionInt = packageInfo.versionCode;
                    }
                    if (this.b.mConfig.mVersionStr == null) {
                        this.b.mConfig.mVersionStr = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(this.b.mConfig.mDeviceId) || "0".equals(this.b.mConfig.mDeviceId)) {
            this.b.mConfig.mDeviceId = e.c().a();
        }
        try {
            jSONObject.put(C3114ha.b, String.valueOf(this.b.mConfig.mAid));
            jSONObject.put("update_version_code", this.b.mConfig.mVersionInt);
            jSONObject.put("version_code", this.b.mConfig.mVersionInt);
            jSONObject.put(BidTokenRepositoryKt.APP_VERSION, this.b.mConfig.mVersionStr);
            jSONObject.put("channel", this.b.mConfig.mChannel);
            jSONObject.put("package", a.a(this.b.mConfig.mPackageName));
            jSONObject.put("device_id", this.b.mConfig.mDeviceId);
            jSONObject.put("user_id", this.b.mConfig.mUID);
            jSONObject.put("ssid", this.b.mConfig.mSSID);
            jSONObject.put(N6.F, C3040d4.d);
            jSONObject.put("so_list", a.a(this.b.mConfig.mSoList));
            jSONObject.put("thread_list", a.a(this.b.mConfig.mThreadList));
            jSONObject.put("single_upload", 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public final String b() {
        return this.b.mConfig.mAid;
    }

    public final JSONObject a(CrashType crashType, JSONArray jSONArray) {
        Map<? extends String, ? extends String> userData;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", d());
            jSONObject.put("line_num", jSONArray);
            if (crashType != null) {
                jSONObject.put("custom", (this.b.mCustomData == null || (userData = this.b.mCustomData.getUserData(crashType)) == null) ? null : new JSONObject(userData));
                jSONObject.put("filters", new JSONObject(this.b.mTagMap));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final JSONObject c() {
        return d();
    }
}
