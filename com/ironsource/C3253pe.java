package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.pe, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3253pe implements I8 {
    @Override // com.ironsource.I8
    public void a(Context context, String key, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        IronSourceUtils.saveIntToSharedPrefs(context, key, i);
    }

    @Override // com.ironsource.I8
    public int b(Context context, String key, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return IronSourceUtils.getIntFromSharedPrefs(context, key, i);
    }

    @Override // com.ironsource.I8
    public void a(Context context, String key, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        IronSourceUtils.saveLongToSharedPrefs(context, key, j);
    }

    @Override // com.ironsource.I8
    public long b(Context context, String key, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        return IronSourceUtils.getLongFromSharedPrefs(context, key, j);
    }
}
