package com.inmobi.media;

import android.content.ContentValues;
import io.ktor.http.ContentDisposition;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Z6 extends T1 {
    public C5 b;

    static {
        Intrinsics.checkNotNullExpressionValue("Z6", "getSimpleName(...)");
    }

    public Z6() {
        super("logs_v2", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, filename TEXT NOT NULL, saveTimestamp INTEGER NOT NULL, retryCount INTEGER NOT NULL, hasLoggerFinished INTEGER NOT NULL, checkpoints INTEGER NOT NULL,lastRetryTimestamp INTEGER NOT NULL )");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0031, code lost:
    
        if (r12.intValue() == 1) goto L9;
     */
    @Override // com.inmobi.media.T1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        String asString = contentValues.getAsString(ContentDisposition.Parameters.FileName);
        Long asLong = contentValues.getAsLong("saveTimestamp");
        Integer asInteger = contentValues.getAsInteger("retryCount");
        Long asLong2 = contentValues.getAsLong("lastRetryTimestamp");
        Integer asInteger2 = contentValues.getAsInteger("checkpoints");
        Integer asInteger3 = contentValues.getAsInteger("hasLoggerFinished");
        boolean z = asInteger3 != null;
        boolean z2 = z;
        Intrinsics.checkNotNull(asString);
        Intrinsics.checkNotNull(asLong);
        long longValue = asLong.longValue();
        Intrinsics.checkNotNull(asInteger);
        int intValue = asInteger.intValue();
        Intrinsics.checkNotNull(asLong2);
        long longValue2 = asLong2.longValue();
        Intrinsics.checkNotNull(asInteger2);
        return new Y6(asString, longValue, intValue, longValue2, z2, asInteger2.intValue());
    }

    @Override // com.inmobi.media.T1
    public final ContentValues b(Object obj) {
        Y6 item = (Y6) obj;
        Intrinsics.checkNotNullParameter(item, "item");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDisposition.Parameters.FileName, item.f2492a);
        contentValues.put("saveTimestamp", Long.valueOf(item.b));
        contentValues.put("retryCount", Integer.valueOf(item.c));
        contentValues.put("lastRetryTimestamp", Long.valueOf(item.d));
        contentValues.put("checkpoints", Integer.valueOf(item.f));
        contentValues.put("hasLoggerFinished", Integer.valueOf(item.e ? 1 : 0));
        return contentValues;
    }

    public final void b(Y6 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b(data, "filename=\"" + data.f2492a + '\"', null);
        if (this.b != null) {
            C5.a();
        }
    }

    public final void a(Y6 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        a("filename=\"" + data.f2492a + '\"', null);
    }
}
