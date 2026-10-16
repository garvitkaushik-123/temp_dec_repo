package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {

    /* renamed from: com.bytedance.sdk.component.utils.eli$eli, reason: collision with other inner class name */
    static class C0151eli {
        static final Random eli = eli.Os();
    }

    public static JSONObject eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return eli(jSONObject.toString());
    }

    public static JSONObject eli(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    String DbA = DbA(str);
                    if (!TextUtils.isEmpty(DbA)) {
                        jSONObject.put(PglCryptUtils.KEY_MESSAGE, DbA);
                        jSONObject.put("cypher", 3);
                        return jSONObject;
                    }
                    jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
                    jSONObject.put("cypher", 0);
                    return jSONObject;
                } catch (Throwable th) {
                    th.getMessage();
                }
            } catch (Throwable unused) {
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
                jSONObject.put("cypher", 0);
            }
        }
        return jSONObject;
    }

    public static String DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String eli = eli();
        String eli2 = eli(eli, 32);
        String DbA = DbA();
        String eli3 = (eli2 == null || DbA == null) ? null : com.bytedance.sdk.component.aGH.eli.eli(str, DbA, eli2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(eli).append(DbA).append(eli3);
        return sb.toString();
    }

    public static String Os(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String eli = eli(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || eli == null) ? str : com.bytedance.sdk.component.aGH.eli.DbA(str.substring(49), substring, eli);
    }

    public static String eli() {
        String eli = eli(16);
        if (eli == null || eli.length() != 32) {
            return null;
        }
        return eli;
    }

    public static String eli(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String DbA() {
        String eli = eli(8);
        if (eli == null || eli.length() != 16) {
            return null;
        }
        return eli;
    }

    public static String eli(int i) {
        try {
            byte[] bArr = new byte[i];
            C0151eli.eli.nextBytes(bArr);
            return ui.eli(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random Os() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
