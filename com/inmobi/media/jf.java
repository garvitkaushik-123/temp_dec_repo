package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class jf extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lf f2615a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf(lf lfVar) {
        super(0);
        this.f2615a = lfVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        lf lfVar = this.f2615a;
        return new gf(lfVar, lfVar.i);
    }
}
