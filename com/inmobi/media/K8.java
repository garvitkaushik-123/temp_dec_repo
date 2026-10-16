package com.inmobi.media;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class K8 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2339a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K8(Context context, byte b) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2339a = b;
    }

    public abstract void a(C2681h8 c2681h8, L8 l8, int i, int i2, D8 d8);

    public final byte getType() {
        return this.f2339a;
    }
}
