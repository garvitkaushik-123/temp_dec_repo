package com.bytedance.sdk.openadsdk.multipro.aGH;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.dV;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Map;

/* loaded from: classes3.dex */
public class Os implements com.bytedance.sdk.openadsdk.multipro.eli {
    private Context eli;

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli() {
        return "t_sp";
    }

    private Context DbA() {
        Context context = this.eli;
        return context == null ? dV.eli() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> Os;
        if (!uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2].equals("get_all") || (Os = DbA.Os(DbA(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : Os.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            Object obj = Os.get(str3);
            objArr[2] = obj;
            if (obj instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (obj instanceof String) {
                objArr[1] = "string";
            } else if (obj instanceof Integer) {
                objArr[1] = "int";
            } else if (obj instanceof Long) {
                objArr[1] = Constants.LONG;
            } else if (obj instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli(Uri uri) {
        String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        String str = split[2];
        String str2 = split[3];
        if (str.equals("contain")) {
            return String.valueOf(DbA.eli(dV.eli(), uri.getQueryParameter("sp_file_name"), str2));
        }
        return DbA.eli(DbA(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Uri eli(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            DbA.eli(DbA(), uri.getQueryParameter("sp_file_name"), str, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (split[2].equals("clean")) {
            DbA.DbA(DbA(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = split[3];
        if (DbA.eli(DbA(), uri.getQueryParameter("sp_file_name"), str2)) {
            DbA.DbA(DbA(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        eli(uri, contentValues);
        return 0;
    }
}
