package com.inmobi.media;

import android.content.ContentValues;
import com.google.android.gms.measurement.AppMeasurement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R5 extends AbstractC2838r4 {
    public R5() {
        super(AppMeasurement.CRASH_ORIGIN, "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, componentType TEXT NOT NULL, eventId TEXT NOT NULL, eventType TEXT NOT NULL, payload TEXT NOT NULL, ts TEXT NOT NULL)");
    }

    @Override // com.inmobi.media.T1
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString("eventId");
        String asString2 = contentValues.getAsString("eventType");
        String asString3 = contentValues.getAsString("componentType");
        String asString4 = contentValues.getAsString("payload");
        String asString5 = contentValues.getAsString("ts");
        Intrinsics.checkNotNullExpressionValue(asString5, "getAsString(...)");
        long parseLong = Long.parseLong(asString5);
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asString3);
        Intrinsics.checkNotNull(asString2);
        T5 t5 = new T5(asString, asString3, asString2, asString4);
        t5.b = parseLong;
        Integer asInteger = contentValues.getAsInteger("id");
        Intrinsics.checkNotNullExpressionValue(asInteger, "getAsInteger(...)");
        t5.c = asInteger.intValue();
        return t5;
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        T5 item = (T5) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        item.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventId", item.e);
        contentValues.put("componentType", item.f);
        contentValues.put("eventType", item.f2446a);
        contentValues.put("payload", item.a());
        contentValues.put("ts", String.valueOf(item.b));
        return contentValues;
    }
}
