package com.bytedance.sdk.openadsdk.multipro.eli;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.ui;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes3.dex */
public class DbA implements com.bytedance.sdk.openadsdk.multipro.eli {
    private static final Object DbA = new Object();
    private Context eli;

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli() {
        return "t_db";
    }

    private boolean DbA(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    private Context DbA() {
        Context context = this.eli;
        return context == null ? dV.eli() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        synchronized (DbA) {
            if (DbA(uri)) {
                return null;
            }
            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (split != null && split.length >= 4) {
                String str3 = split[2];
                String str4 = split[3];
                if (!"ttopensdk.db".equals(str3)) {
                    return null;
                }
                return ui.eli(DbA()).eli().eli(str4, strArr, str, strArr2, null, null, str2);
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli(Uri uri) {
        synchronized (DbA) {
            if (DbA(uri)) {
                return null;
            }
            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (split != null && split.length >= 5) {
                String str = split[2];
                String str2 = split[4];
                if ("ttopensdk.db".equals(str)) {
                    if ("execSQL".equals(str2)) {
                        String queryParameter = uri.getQueryParameter("sql");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            ui.eli(DbA()).eli().eli(Uri.decode(queryParameter));
                        }
                    } else if ("transactionBegin".equals(str2)) {
                        ui.eli(DbA()).eli().DbA();
                    } else if ("transactionSetSuccess".equals(str2)) {
                        ui.eli(DbA()).eli().Os();
                    } else if ("transactionEnd".equals(str2)) {
                        ui.eli(DbA()).eli().aGH();
                    }
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Uri eli(Uri uri, ContentValues contentValues) {
        synchronized (DbA) {
            if (DbA(uri)) {
                return null;
            }
            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (split != null && split.length >= 4) {
                String str = split[2];
                String str2 = split[3];
                if ("ttopensdk.db".equals(str)) {
                    ui.eli(DbA()).eli().eli(str2, (String) null, contentValues);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, String str, String[] strArr) {
        synchronized (DbA) {
            if (DbA(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (split != null && split.length >= 4) {
                String str2 = split[2];
                String str3 = split[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return ui.eli(DbA()).eli().eli(str3, str, strArr);
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        synchronized (DbA) {
            if (DbA(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (split != null && split.length >= 4) {
                String str2 = split[2];
                String str3 = split[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return ui.eli(DbA()).eli().eli(str3, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
