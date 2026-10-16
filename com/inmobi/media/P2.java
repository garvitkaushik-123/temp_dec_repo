package com.inmobi.media;

import android.content.ContentValues;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class P2 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final P2 f2392a = new P2();

    public P2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ContentValues contentValues = (ContentValues) obj;
        Intrinsics.checkNotNullParameter(contentValues, "contentValues");
        if (contentValues.getAsString("config_value") != null) {
            return contentValues.getAsLong("update_ts");
        }
        return null;
    }
}
