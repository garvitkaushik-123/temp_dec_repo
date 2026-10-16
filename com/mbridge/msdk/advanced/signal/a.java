package com.mbridge.msdk.advanced.signal;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeAdvancedJsUtils.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f4024a = "NativeAdvancedJsUtils";

    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        JSONArray jSONArray;
        int i;
        boolean z;
        String str2;
        File file;
        String str3 = "";
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                p0.a(f4024a, e.getMessage());
                return;
            }
        }
        try {
            try {
                jSONObject2.put("code", 0);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "");
                JSONArray jSONArray2 = jSONObject.getJSONArray("resource");
                if (jSONArray2 == null || jSONArray2.length() <= 0) {
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "resource is null");
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (JSONException e2) {
                        p0.a(f4024a, e2.getMessage());
                        return;
                    }
                }
                JSONArray jSONArray3 = new JSONArray();
                int length = jSONArray2.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                    String optString = jSONObject3.optString("ref", str3);
                    int i4 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    if (i4 != i2 || TextUtils.isEmpty(optString)) {
                        str = str3;
                        jSONArray = jSONArray2;
                        i = length;
                        z = false;
                        if (i4 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray3.put(jSONObject4);
                        } else if (i4 == 3 && !TextUtils.isEmpty(optString)) {
                            try {
                                file = new File(optString);
                            } catch (Throwable th) {
                                p0.b(f4024a, th.getMessage());
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                p0.a(f4024a, "getFileInfo Mraid file " + optString);
                                str2 = "file:////" + optString;
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put("path", str2);
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray3.put(jSONObject4);
                            }
                            str2 = str;
                            JSONObject jSONObject62 = new JSONObject();
                            jSONObject62.put("type", 3);
                            jSONObject62.put("path", str2);
                            jSONObject4.put(optString, jSONObject62);
                            jSONArray3.put(jSONObject4);
                        } else if (i4 == 4 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", t0.a(optString) == null ? str : t0.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray3.put(jSONObject4);
                        }
                    } else {
                        JSONObject jSONObject8 = new JSONObject();
                        m b = com.mbridge.msdk.foundation.db.m.a(g.a(c.m().d())).b(optString);
                        if (b != null) {
                            jSONArray = jSONArray2;
                            p0.a(f4024a, "VideoBean not null");
                            jSONObject8.put("type", 1);
                            jSONObject8.put("videoDataLength", b.d());
                            String e3 = b.e();
                            if (TextUtils.isEmpty(e3)) {
                                i = length;
                                p0.a(f4024a, "VideoPath null");
                                jSONObject8.put("path", str3);
                                jSONObject8.put("path4Web", str3);
                                str = str3;
                            } else {
                                i = length;
                                str = str3;
                                p0.a(f4024a, "VideoPath not null");
                                jSONObject8.put("path", e3);
                                jSONObject8.put("path4Web", e3);
                            }
                            if (b.b() == 5) {
                                jSONObject8.put("downloaded", 1);
                                z = false;
                            } else {
                                z = false;
                                jSONObject8.put("downloaded", 0);
                            }
                            jSONObject4.put(optString, jSONObject8);
                            jSONArray3.put(jSONObject4);
                        } else {
                            str = str3;
                            jSONArray = jSONArray2;
                            i = length;
                            z = false;
                            p0.a(f4024a, "VideoBean null");
                        }
                    }
                    i3++;
                    jSONArray2 = jSONArray;
                    length = i;
                    str3 = str;
                    i2 = 1;
                }
                jSONObject2.put("resource", jSONArray3);
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (Throwable th2) {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            jSONObject2.put("code", 1);
            jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            return;
        } catch (JSONException e4) {
            p0.a(f4024a, e4.getMessage());
            return;
        }
    }

    public static void a(WebView webView, String str, String str2) {
        f.a().a(webView, str, str2);
    }

    public static void a(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sq", 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            f.a().a(webView, "thirdPartyCalled", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            p0.b(f4024a, e.getMessage());
        }
    }

    public static void a(WebView webView) {
        p0.b(f4024a, "fireOnJSBridgeConnected");
        f.a().a(webView);
    }

    public static void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", d.b);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            p0.a(f4024a, e.getMessage());
        }
    }
}
