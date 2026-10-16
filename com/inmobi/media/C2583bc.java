package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.bc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2583bc extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2526a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2583bc(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        super(0);
        this.f2526a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new C2584bd(this.f2526a.getWebViewFactory(), this.f2526a.i);
    }
}
