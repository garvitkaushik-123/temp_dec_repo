package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public interface eli {
    int eli(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int eli(Uri uri, String str, String[] strArr);

    Cursor eli(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Uri eli(Uri uri, ContentValues contentValues);

    String eli();

    String eli(Uri uri);
}
