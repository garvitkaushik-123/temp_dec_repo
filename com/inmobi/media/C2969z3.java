package com.inmobi.media;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2969z3 extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2770a = 0;

    public C2969z3(Context context) {
        super(context, "com.im_10.8.7.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase db, int i, int i2) {
        Intrinsics.checkNotNullParameter(db, "db");
    }
}
