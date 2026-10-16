package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ui implements eli {
    private static WeakReference<Context> DbA;
    private static final List<eli> Os;
    private static volatile ui eli;

    private boolean Os(Uri uri) {
        return true;
    }

    static {
        List<eli> synchronizedList = Collections.synchronizedList(new ArrayList());
        Os = synchronizedList;
        synchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.aGH.Os());
        synchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.eli.DbA());
        synchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.Os.eli());
        synchronizedList.add(new com.bytedance.sdk.openadsdk.aGH.eli.ui(new com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA()));
        Iterator<eli> it = synchronizedList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static ui eli(Context context) {
        if (context != null) {
            DbA = new WeakReference<>(context.getApplicationContext());
        }
        if (eli == null) {
            synchronized (ui.class) {
                if (eli == null) {
                    eli = new ui();
                }
            }
        }
        return eli;
    }

    private ui() {
    }

    private eli DbA(Uri uri) {
        if (uri == null || !Os(uri)) {
            return null;
        }
        String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (eli eliVar : Os) {
            if (str.equals(eliVar.eli())) {
                return eliVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            eli DbA2 = DbA(uri);
            if (DbA2 != null) {
                return DbA2.eli(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli(Uri uri) {
        try {
            eli DbA2 = DbA(uri);
            if (DbA2 != null) {
                return DbA2.eli(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Uri eli(Uri uri, ContentValues contentValues) {
        try {
            eli DbA2 = DbA(uri);
            if (DbA2 != null) {
                return DbA2.eli(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, String str, String[] strArr) {
        try {
            eli DbA2 = DbA(uri);
            if (DbA2 != null) {
                return DbA2.eli(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            eli DbA2 = DbA(uri);
            if (DbA2 != null) {
                return DbA2.eli(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
