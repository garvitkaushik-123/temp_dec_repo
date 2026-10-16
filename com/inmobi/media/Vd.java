package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Vd extends AbstractC2838r4 {
    public Vd() {
        super("telemetry", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, eventSource TEXT NOT NULL, ts TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("eventType");
        String asString2 = contentValues.getAsString("payload");
        String asString3 = contentValues.getAsString("eventSource");
        String asString4 = contentValues.getAsString("ts");
        Intrinsics.checkNotNullExpressionValue(asString4, "getAsString(...)");
        long parseLong = Long.parseLong(asString4);
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asString3);
        Wd wd = new Wd(asString, asString2, asString3);
        wd.b = parseLong;
        Integer asInteger = contentValues.getAsInteger("id");
        Intrinsics.checkNotNullExpressionValue(asInteger, "getAsInteger(...)");
        wd.c = asInteger.intValue();
        return wd;
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        Wd item = (Wd) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        item.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventType", item.f2446a);
        contentValues.put("payload", item.a());
        contentValues.put("eventSource", item.e);
        contentValues.put("ts", String.valueOf(item.b));
        return contentValues;
    }
}
