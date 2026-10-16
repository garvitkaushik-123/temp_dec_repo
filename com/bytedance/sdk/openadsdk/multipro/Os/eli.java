package com.bytedance.sdk.openadsdk.multipro.Os;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.MGA.eli.MGA;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.multipro.aGH;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.sdk.openadsdk.multipro.eli {
    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Uri eli(Uri uri, ContentValues contentValues) {
        return null;
    }

    private static MGA aGH() {
        try {
            if (dV.eli() != null) {
                return com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean eli(String str) {
        if (dV.eli() == null) {
            return false;
        }
        try {
            MGA aGH = aGH();
            if (aGH != null) {
                return "true".equals(aGH.eli(Uri.parse(ui() + "checkFrequency?rit=" + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean DbA() {
        if (dV.eli() == null) {
            return false;
        }
        try {
            MGA aGH = aGH();
            if (aGH != null) {
                return "true".equals(aGH.eli(Uri.parse(ui() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Os() {
        if (dV.eli() == null) {
            return null;
        }
        try {
            MGA aGH = aGH();
            if (aGH != null) {
                return aGH.eli(Uri.parse(ui() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String ui() {
        return aGH.DbA + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli(Uri uri) {
        new StringBuilder("get type uri: ").append(uri);
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.kb.eli.eli().eli(uri.getQueryParameter("rit")) ? "true" : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.kb.eli.eli().DbA() ? "true" : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.kb.eli.eli().Os();
        }
        return null;
    }
}
