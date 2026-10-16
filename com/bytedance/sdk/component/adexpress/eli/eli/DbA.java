package com.bytedance.sdk.component.adexpress.eli.eli;

import android.content.ContentValues;
import android.database.Cursor;

/* loaded from: classes3.dex */
public interface DbA {
    int eli(String str, ContentValues contentValues, String str2, String[] strArr);

    int eli(String str, String str2, String[] strArr);

    Cursor eli(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    void eli(String str, ContentValues contentValues);
}
