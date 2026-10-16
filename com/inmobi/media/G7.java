package com.inmobi.media;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class G7 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f2293a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G7(int[] iArr) {
        super(1);
        this.f2293a = iArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2607d2 event = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        return Boolean.valueOf(ArraysKt.contains(this.f2293a, event.f2542a));
    }
}
