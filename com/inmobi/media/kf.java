package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class kf extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lf f2626a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kf(lf lfVar) {
        super(0);
        this.f2626a = lfVar;
    }

    public static final void a(lf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c.post((gf) this$0.k.getValue());
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Runnable invoke() {
        final lf lfVar = this.f2626a;
        return new Runnable() { // from class: com.inmobi.media.kf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                kf.a(lf.this);
            }
        };
    }
}
