package com.inmobi.media;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class J8 extends C2714j8 {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f2326a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J8(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final T7 getNativeStrandAd() {
        WeakReference weakReference = this.f2326a;
        if (weakReference != null) {
            return (T7) weakReference.get();
        }
        return null;
    }

    public final void setNativeStrandAd(T7 t7) {
        this.f2326a = new WeakReference(t7);
    }
}
