package com.bytedance.sdk.openadsdk.multipro.aidl.eli;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.component.MGA.eli.MGA;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.FC;
import java.util.Map;

/* loaded from: classes3.dex */
public class MGA extends MGA.eli {
    private static volatile MGA eli;

    public static MGA DbA() {
        if (eli == null) {
            synchronized (MGA.class) {
                if (eli == null) {
                    eli = new MGA();
                }
            }
        }
        return eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA
    public Map eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!FC.eli()) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(com.bytedance.sdk.openadsdk.multipro.ui.eli(dV.eli()).eli(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA
    public String eli(Uri uri) {
        if (FC.eli()) {
            return com.bytedance.sdk.openadsdk.multipro.ui.eli(dV.eli()).eli(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA
    public String eli(Uri uri, ContentValues contentValues) {
        Uri eli2;
        if (FC.eli() && (eli2 = com.bytedance.sdk.openadsdk.multipro.ui.eli(dV.eli()).eli(uri, contentValues)) != null) {
            return eli2.toString();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA
    public int eli(Uri uri, String str, String[] strArr) {
        if (FC.eli()) {
            return com.bytedance.sdk.openadsdk.multipro.ui.eli(dV.eli()).eli(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.MGA
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (FC.eli()) {
            return com.bytedance.sdk.openadsdk.multipro.ui.eli(dV.eli()).eli(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
