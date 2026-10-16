package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.d3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2608d3 extends T1 {
    public C2608d3() {
        super("c_data", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, e_data TEXT NOT NULL, timestamp INTEGER NOT NULL )");
        Intrinsics.checkNotNullExpressionValue("d3", "getSimpleName(...)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("e_data");
        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
        Long asLong = contentValues.getAsLong("timestamp");
        Intrinsics.checkNotNullExpressionValue(asLong, "getAsLong(...)");
        return new C2693i4(asString, asLong.longValue());
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        C2693i4 data = (C2693i4) obj;
        Intrinsics.checkNotNullParameter(data, "data");
        ContentValues contentValues = new ContentValues();
        contentValues.put("e_data", data.f2595a);
        contentValues.put("timestamp", Long.valueOf(data.b));
        return contentValues;
    }
}
