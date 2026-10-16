package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.p0;
import org.json.JSONArray;

/* compiled from: DomainReport.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f4310a = "DomainReport";

    public static boolean a(com.mbridge.msdk.setting.g gVar, String str) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int K = gVar.K();
                    JSONArray I = gVar.I();
                    JSONArray H = gVar.H();
                    if (H != null) {
                        for (int i = 0; i < H.length(); i++) {
                            if (str.contains(H.getString(i))) {
                                return false;
                            }
                        }
                    }
                    if (K == 2) {
                        if (I != null) {
                            for (int i2 = 0; i2 < I.length(); i2++) {
                                if (str.contains(I.getString(i2))) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
            } catch (Exception e) {
                p0.b(f4310a, e.getMessage());
            }
        }
        return true;
    }
}
