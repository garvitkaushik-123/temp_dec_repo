package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.ac, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2566ac extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2521a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2566ac(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        super(0);
        this.f2521a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new C2619de(this.f2521a.getAdConfig().getRendering().getScrollThrottleInterval());
    }
}
