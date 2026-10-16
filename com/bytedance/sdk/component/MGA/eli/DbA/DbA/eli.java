package com.bytedance.sdk.component.MGA.eli.DbA.DbA;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.eli.eli.MGA;
import com.bytedance.sdk.component.MGA.eli.eli.eli.kb;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class eli {
    private static ContentResolver Os() {
        try {
            if (wC.kb().MGA() != null) {
                return wC.kb().MGA().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void eli() {
        if (wC.kb().MGA() == null) {
            return;
        }
        try {
            ContentResolver Os = Os();
            if (Os != null) {
                Os.getType(Uri.parse(aGH() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void DbA() {
        if (wC.kb().MGA() == null) {
            return;
        }
        try {
            ContentResolver Os = Os();
            if (Os != null) {
                Os.getType(Uri.parse(aGH() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (eliVar == null) {
            return;
        }
        try {
            ContentResolver Os = Os();
            if (Os != null) {
                Os.getType(Uri.parse(aGH() + "adLogDispatch?event=" + MGA.eli(eliVar.MGA())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void eli(String str, List<String> list, boolean z) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(MGA.eli(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(MGA.eli(sb.toString())) + "&replace=" + String.valueOf(z);
            ContentResolver Os = Os();
            if (Os != null) {
                Os.getType(Uri.parse(aGH() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver Os = Os();
            if (Os != null) {
                Os.getType(Uri.parse(aGH() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String aGH() {
        return kb.DbA + "/ad_log_event/";
    }
}
