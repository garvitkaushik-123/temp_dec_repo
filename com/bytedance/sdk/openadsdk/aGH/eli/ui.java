package com.bytedance.sdk.openadsdk.aGH.eli;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public class ui implements com.bytedance.sdk.openadsdk.multipro.eli {
    private final com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA eli;

    public ui(com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA) {
        this.eli = dbA;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli() {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.Os();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public String eli(Uri uri) {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.eli(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.eli(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public Uri eli(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.eli(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.eli(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.eli
    public int eli(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA dbA = this.eli;
        if (dbA != null) {
            return dbA.eli(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
