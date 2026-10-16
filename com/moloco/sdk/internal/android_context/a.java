package com.moloco.sdk.internal.android_context;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5369a = new a();
    public static volatile Context b;

    public final Context a() {
        Context context = b;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return null;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b = context.getApplicationContext();
    }
}
