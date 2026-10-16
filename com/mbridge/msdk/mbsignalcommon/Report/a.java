package com.mbridge.msdk.mbsignalcommon.Report;

import android.content.Context;
import android.util.Base64;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: H5ReportManager.java */
/* loaded from: classes6.dex */
public class a {
    private static final String c = "a";

    /* renamed from: a, reason: collision with root package name */
    int f4528a = 0;
    int b = 1;

    /* compiled from: H5ReportManager.java */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.Report.a$a, reason: collision with other inner class name */
    private static final class C0361a {

        /* renamed from: a, reason: collision with root package name */
        private static a f4529a = new a();
    }

    public static a a() {
        return C0361a.f4529a;
    }

    public void a(Object obj, String str, JSONArray jSONArray, int i) {
        int i2;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONObject optJSONObject10;
        JSONObject optJSONObject11;
        int i3;
        try {
            if (jSONArray == null) {
                a(this.b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.b, "called reporter failed, params empty", obj);
                return;
            }
            int i4 = 0;
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    i3 = length - 1;
                    if (i4 >= i3) {
                        break;
                    }
                    JSONObject optJSONObject12 = jSONArray.optJSONObject(i4);
                    if (optJSONObject12 != null) {
                        stringBuffer = stringBuffer.append(optJSONObject12.optString(C3040d4.h.W)).append(C3040d4.i.b).append(optJSONObject12.opt("value")).append(C3040d4.i.c);
                    }
                    i4++;
                }
                JSONObject optJSONObject13 = jSONArray.optJSONObject(i3);
                if (optJSONObject13 != null) {
                    stringBuffer = stringBuffer.append(optJSONObject13.optString(C3040d4.h.W)).append(C3040d4.i.b).append(optJSONObject13.opt("value"));
                }
                a(stringBuffer.toString());
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String string = (length <= 0 || (optJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : optJSONObject11.getString("value");
                int i5 = (length <= 1 || (optJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : optJSONObject10.getInt("value");
                int i6 = (length <= 2 || (optJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : optJSONObject9.getInt("value");
                int i7 = (length <= 3 || (optJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : optJSONObject8.getInt("value");
                int i8 = (length <= 4 || (optJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : optJSONObject7.getInt("value");
                String string2 = (length <= 5 || (optJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : optJSONObject6.getString("value");
                String string3 = (length <= 6 || (optJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : optJSONObject5.getString("value");
                int i9 = (length <= 7 || (optJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : optJSONObject4.getInt("value");
                String string4 = (length <= 8 || (optJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : optJSONObject3.getString("value");
                int i10 = (length <= 9 || (optJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : optJSONObject2.getInt("value");
                if (length <= 10 || (optJSONObject = jSONArray.optJSONObject(10)) == null) {
                    i2 = i6;
                    str2 = string3;
                    str3 = "";
                } else {
                    i2 = i6;
                    str2 = string3;
                    str3 = optJSONObject.getString("value");
                }
                a(string, i5, i2, i7, i8, string2, str2, i9, string4, i10, str3);
            }
            a(this.f4528a, "called reporter success", obj);
        } catch (Throwable th) {
            p0.a(c, th.getMessage());
            a(this.b, "exception: " + th.getMessage(), obj);
        }
    }

    public void a(String str) {
        d.b().e(str);
    }

    public void a(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, int i6, String str5) {
        try {
            Context d = c.m().d();
            if (d != null) {
                n.a(g.a(d)).a(new com.mbridge.msdk.foundation.entity.n(str, i, i2, i3, i4, str2, str3, i5, str4, i6, str5));
            }
        } catch (Throwable th) {
            p0.a(c, th.getMessage());
        }
    }

    public void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            p0.a(c, e.getMessage());
        } catch (Throwable th) {
            p0.a(c, th.getMessage());
        }
    }
}
