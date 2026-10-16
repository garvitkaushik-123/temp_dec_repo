package com.pgl.ssdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.pgl.ssdk.ces.out.PglSSCallBack;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static long f6393a = 28800;
    public static int b = 5;

    public static long a(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    public static long b() {
        Context b2 = z.b();
        if (b2 == null) {
            return 0L;
        }
        long a2 = x0.a(b2, "pgl_frt", 0L);
        if (a2 != 0) {
            return a2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        x0.b(b2, "pgl_frt", currentTimeMillis);
        return currentTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized void c() {
        synchronized (f.class) {
            if (d()) {
                String c = v.c();
                if (TextUtils.isEmpty(c)) {
                    return;
                }
                File file = new File(c);
                if (file.exists()) {
                    JSONObject a2 = a(file, true);
                    a2.put("apk_info", v.b());
                    a2.put("app_name", b0.d(z.b()));
                    PglSSManager pglSSManager = PglSSManager.getInstance();
                    if (pglSSManager == null) {
                        u0.a(String.valueOf(a2));
                        return;
                    }
                    PglSSCallBack pglCallBack = pglSSManager.getPglCallBack();
                    if (pglCallBack != null) {
                        pglCallBack.reportSoftDecData("detailed_app_info", a2.toString());
                    }
                }
            }
        }
    }

    private static boolean d() {
        int a2 = x0.a(z.b(), "pgl_is_hit", 0);
        u0.a("hitsTimes " + a2);
        if (a2 > 0) {
            return false;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - b();
        u0.a("runningTime ".concat(String.valueOf(currentTimeMillis)));
        if (currentTimeMillis < f6393a) {
            return false;
        }
        x0.b(z.b(), "pgl_is_hit", 1);
        return e();
    }

    private static boolean e() {
        boolean z = b == 100;
        return !z ? ((int) ((Math.random() * 100.0d) + 1.0d)) <= b : z;
    }

    public static void a(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "_size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, n.a(list));
    }

    private static JSONObject a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        a(jSONObject, "xml", arrayList, true);
        a(jSONObject, "png", arrayList2, true);
        a(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    public static JSONObject a() throws JSONException {
        String[] strArr;
        Context b2 = z.b();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (b2 != null) {
            ApplicationInfo applicationInfo = b2.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            arrayList.add(file2.getName());
                        }
                    }
                    if ("arm64".equals(file.getName())) {
                        a(jSONObject2, "v8a", arrayList, false);
                    } else {
                        a(jSONObject2, "v7a", arrayList, false);
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put("lib", jSONObject2);
                    }
                }
            }
            if (arrayList.isEmpty() && (strArr = applicationInfo.splitPublicSourceDirs) != null) {
                for (String str2 : strArr) {
                    if (str2.endsWith("armeabi-v7a.apk") || str2.endsWith("arm64_v8a.apk")) {
                        File file3 = new File(str2);
                        if (file3.exists()) {
                            return a(file3, false);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x019d, code lost:
    
        if (r8 != null) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(File file, boolean z) {
        ZipFile zipFile;
        int i;
        char c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (nextElement != null) {
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) || !nextElement.isDirectory()) {
                            String[] split = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                            long size = nextElement.getSize();
                            Enumeration<? extends ZipEntry> enumeration = entries;
                            if (name.startsWith("res/drawable/")) {
                                i = 2;
                                if (name.length() > 13) {
                                    arrayList2.add(split[2]);
                                    entries = enumeration;
                                }
                            } else {
                                i = 2;
                            }
                            if (name.startsWith("res/")) {
                                c = 1;
                                if (split.length == i) {
                                    arrayList3.add(split[1]);
                                    entries = enumeration;
                                }
                            } else {
                                c = 1;
                            }
                            if (name.startsWith("assets/") && split.length >= 2) {
                                arrayList.add(split[c]);
                                if (name.startsWith("assets/assets/resources/native/") && split.length >= 6 && jSONObject2.length() < 10) {
                                    if (!TextUtils.isEmpty(split[4]) && !jSONObject2.has(split[4])) {
                                        jSONObject2.put(split[4], a(size, zipFile.getInputStream(nextElement)));
                                    } else if (jSONObject2.has(split[4])) {
                                        jSONObject2.put(split[4], a(size, zipFile.getInputStream(nextElement)) + jSONObject2.getLong(split[4]));
                                    }
                                }
                            } else if (name.startsWith("lib/armeabi/") && name.length() > 12) {
                                arrayList4.add(split[2]);
                            } else if (name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                arrayList5.add(split[2]);
                            } else if (name.startsWith("lib/arm64-v8a/") && name.length() > 14) {
                                arrayList6.add(split[2]);
                            }
                            entries = enumeration;
                        }
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                a(jSONObject3, "eabi", arrayList4, false);
                a(jSONObject3, "v7a", arrayList5, false);
                a(jSONObject3, "v8a", arrayList6, false);
                if (jSONObject3.length() > 0) {
                    jSONObject.put("lib", jSONObject3);
                }
                if (z && jSONObject3.length() <= 0) {
                    jSONObject = a();
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("cocos", jSONObject2);
                }
                a(jSONObject, "assets", arrayList, false);
                JSONObject a2 = a(arrayList2);
                if (a2 != null && a2.length() > 0) {
                    jSONObject.put("drawable", a2);
                }
                JSONObject a3 = a(arrayList3);
                if (a3 != null && a3.length() > 0) {
                    jSONObject.put("res", a3);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            zipFile = null;
        }
        try {
            zipFile.close();
        } catch (IOException unused3) {
        }
        return jSONObject;
    }
}
