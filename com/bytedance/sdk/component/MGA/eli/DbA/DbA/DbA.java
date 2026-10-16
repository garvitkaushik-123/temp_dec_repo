package com.bytedance.sdk.component.MGA.eli.DbA.DbA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.MGA;
import com.bytedance.sdk.component.MGA.eli.aGH;
import com.bytedance.sdk.component.MGA.eli.eli.eli.kb;
import com.bytedance.sdk.component.MGA.eli.wC;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.sdk.controller.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA {
    public static MGA eli;

    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int eli(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri eli(Uri uri, ContentValues contentValues) {
        return null;
    }

    public static MGA eli(Context context) {
        try {
            if (eli == null) {
                eli = wC.kb().aqO().du();
            }
        } catch (Exception unused) {
        }
        return eli;
    }

    public static void eli() {
        if (wC.kb().MGA() == null) {
            return;
        }
        try {
            MGA eli2 = eli(wC.kb().MGA());
            if (eli2 != null) {
                eli2.eli(Uri.parse(aGH() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void DbA() {
        if (wC.kb().MGA() == null) {
            return;
        }
        try {
            MGA eli2 = eli(wC.kb().MGA());
            if (eli2 != null) {
                eli2.eli(Uri.parse(aGH() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (eliVar == null) {
            return;
        }
        try {
            MGA eli2 = eli(wC.kb().MGA());
            if (eli2 != null) {
                eli2.eli(Uri.parse(aGH() + "adLogDispatch?event=" + com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.eli(eliVar.MGA())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void eli(String str, List<String> list, boolean z, int i, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.eli(it.next())).append(",");
            }
            String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.eli(sb.toString())) + "&replace=" + String.valueOf(z) + "&urlType=" + String.valueOf(i) + "&adId=" + str2;
            MGA eli2 = eli(wC.kb().MGA());
            if (eli2 != null) {
                eli2.eli(Uri.parse(aGH() + "trackAdUrl" + str3));
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(String str, boolean z) {
        if (wC.kb().aqO().MGA() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            MGA eli2 = eli(wC.kb().MGA());
            if (eli2 != null) {
                eli2.eli(Uri.parse(aGH() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z));
            }
        } catch (Throwable unused) {
        }
    }

    private static String aGH() {
        return kb.DbA + "/ad_log_event/";
    }

    public String Os() {
        return "ad_log_event";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0037, code lost:
    
        if (r0.equals("adLogStop") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String eli(Uri uri) {
        com.bytedance.sdk.component.MGA.eli.aGH.eli Os;
        char c = 2;
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        str.hashCode();
        int i = 0;
        switch (str.hashCode()) {
            case -482705237:
                if (str.equals("trackAdFailed")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -171493183:
                if (str.equals("adLogStart")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 964299715:
                break;
            case 1025736635:
                if (str.equals("adLogDispatch")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1131732929:
                if (str.equals("trackAdUrl")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                com.bytedance.sdk.component.MGA.eli.MGA.eli.eli().eli(uri.getQueryParameter("did"), uri.getBooleanQueryParameter("triggerOnInit", false));
                break;
            case 1:
                wC.kb().FC();
                break;
            case 2:
                wC.kb().du();
                break;
            case 3:
                String queryParameter = uri.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter) && (Os = com.bytedance.sdk.component.MGA.eli.aGH.eli.eli.Os(com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.DbA(queryParameter))) != null) {
                    aGH.eli.eli(Os);
                    break;
                }
                break;
            case 4:
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean booleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter3 = uri.getQueryParameter("track");
                    String queryParameter4 = uri.getQueryParameter("urlType");
                    String queryParameter5 = uri.getQueryParameter(f.b.c);
                    String[] split = com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.DbA(queryParameter3).split(",");
                    if (split.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : split) {
                            String DbA = com.bytedance.sdk.component.MGA.eli.eli.eli.MGA.DbA(str2);
                            if (!TextUtils.isEmpty(DbA)) {
                                arrayList.add(DbA);
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                i = Integer.parseInt(queryParameter4);
                            }
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.component.MGA.eli.MGA.eli.eli().eli(queryParameter2, arrayList, booleanValue, null, i, queryParameter5);
                        break;
                    }
                } catch (Throwable unused2) {
                    return null;
                }
                break;
        }
        return null;
    }
}
