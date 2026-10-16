package com.applovin.impl.sdk;

import com.applovin.impl.c2;
import com.applovin.impl.k7;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeCrashReporter implements g.d {
    private static boolean b;
    private static boolean c;
    private static final NativeCrashReporter d = new NativeCrashReporter();

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f666a = new HashMap();

    private NativeCrashReporter() {
    }

    public static void a(k kVar) {
        if (kVar == null) {
            return;
        }
        if (!((Boolean) kVar.a(v4.n4)).booleanValue() && !k7.k(k.o())) {
            if (c) {
                try {
                    g l = kVar.l();
                    NativeCrashReporter nativeCrashReporter = d;
                    l.a(nativeCrashReporter);
                    nativeCrashReporter.disable();
                    return;
                } catch (Throwable th) {
                    kVar.O();
                    if (o.a()) {
                        kVar.O().a("NativeCrashReporter", "Failed to disable native crash reporter", th);
                    }
                    kVar.E().a("NativeCrashReporter", "disableInstance", th);
                    return;
                }
            }
            return;
        }
        if (a()) {
            List c2 = kVar.c(v4.o4);
            int[] iArr = new int[c2.size()];
            for (int i = 0; i < c2.size(); i++) {
                try {
                    iArr[i] = Integer.parseInt((String) c2.get(i));
                } catch (NumberFormatException unused) {
                }
            }
            File file = new File(k.o().getCacheDir(), "al-reports");
            if (file.exists()) {
                a(file, kVar);
            } else if (!file.mkdir()) {
                kVar.O();
                if (o.a()) {
                    kVar.O().b("NativeCrashReporter", "Failed to create reports directory");
                    return;
                }
                return;
            }
            try {
                NativeCrashReporter nativeCrashReporter2 = d;
                nativeCrashReporter2.enable(file.getAbsolutePath(), iArr, ((Boolean) kVar.a(v4.p4)).booleanValue());
                if (((Boolean) kVar.a(v4.q4)).booleanValue()) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(g.c.LOADING);
                    hashSet.add(g.c.LOAD);
                    hashSet.add(g.c.SHOW);
                    hashSet.add(g.c.CLICK);
                    hashSet.add(g.c.SHOW_ERROR);
                    hashSet.add(g.c.DESTROY);
                    kVar.l().a(nativeCrashReporter2, hashSet);
                }
            } catch (Throwable th2) {
                kVar.O();
                if (o.a()) {
                    kVar.O().a("NativeCrashReporter", "Failed to enable native crash reporter", th2);
                }
                kVar.E().a("NativeCrashReporter", "enableInstance", th2);
            }
        }
    }

    private native void disable();

    private native void enable(String str, int[] iArr, boolean z);

    private native void updateAdInfo(String str);

    private static boolean a() {
        if (!b) {
            b = true;
            try {
                System.loadLibrary("applovin-native-crash-reporter");
                c = true;
            } catch (Throwable th) {
                o.b("NativeCrashReporter", "Failed to load native crash reporter library", th);
            }
        }
        return c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(2:7|(8:9|10|11|(1:13)(4:31|(4:34|(2:36|37)(2:39|40)|38|32)|41|42)|14|15|(2:17|(2:19|20)(1:22))(1:23)|21))|48|(1:50)|14|15|(0)(0)|21) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ed, code lost:
    
        r17.O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f4, code lost:
    
        if (com.applovin.impl.sdk.o.a() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f6, code lost:
    
        r17.O().a("NativeCrashReporter", "Failed to delete native crash report: " + r6.getAbsolutePath(), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6 A[Catch: all -> 0x00ec, TryCatch #1 {all -> 0x00ec, blocks: (B:15:0x00c0, B:17:0x00c6, B:19:0x00cf), top: B:14:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(File file, k kVar) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            File file2 = listFiles[i];
            String f = kVar.H().f(file2);
            if (StringUtils.isValidString(f)) {
                String[] split = f.split("@@@@@");
                if (split.length == 3) {
                    try {
                        String str = split[0];
                        String str2 = split[1];
                        JSONArray jSONArray = new JSONArray(split[2]);
                        if (jSONArray.length() == 0) {
                            kVar.E().a(c2.H0, str2, CollectionUtils.hashMap("error_message", str));
                        } else {
                            ArrayList arrayList = new ArrayList(jSONArray.length());
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
                                if (jSONObject != null) {
                                    HashMap<String, String> hashMap = CollectionUtils.hashMap("error_message", str);
                                    hashMap.put("source", str2);
                                    hashMap.putAll(JsonUtils.toStringMap(jSONObject));
                                    arrayList.add(hashMap);
                                }
                            }
                            kVar.E().a(c2.H0, arrayList, 0L);
                        }
                    } catch (Throwable th) {
                        kVar.O();
                        if (o.a()) {
                            kVar.O().a("NativeCrashReporter", "Failed to symbolicate native crash report", th);
                        }
                    }
                    if (file2.delete()) {
                        kVar.O();
                        if (o.a()) {
                            kVar.O().b("NativeCrashReporter", "Failed to delete native crash report: " + file2.getAbsolutePath());
                        }
                    }
                }
            }
            kVar.O();
            if (o.a()) {
                kVar.O().b("NativeCrashReporter", "Failed to read native crash error report: " + file2.getAbsolutePath());
            }
            if (file2.delete()) {
            }
        }
    }

    @Override // com.applovin.impl.sdk.g.d
    public void a(g.b bVar) {
        String h = bVar.h();
        if (bVar.i() == g.c.DESTROY) {
            this.f666a.remove(h);
        } else if (this.f666a.containsKey(h)) {
            JsonUtils.putString((JSONObject) this.f666a.get(h), "operation", bVar.i().toString());
        } else {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "ad_unit_id", bVar.a());
            JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, bVar.g());
            JsonUtils.putString(jSONObject, "network_name", bVar.c());
            JsonUtils.putString(jSONObject, "adapter_class", bVar.b());
            JsonUtils.putString(jSONObject, "adapter_version", bVar.d());
            JsonUtils.putString(jSONObject, "bcode", bVar.e());
            JsonUtils.putString(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, bVar.f());
            JsonUtils.putString(jSONObject, "operation", bVar.i().toString());
            this.f666a.put(h, jSONObject);
        }
        try {
            updateAdInfo(new JSONArray(this.f666a.values()).toString());
        } catch (Throwable unused) {
        }
    }
}
