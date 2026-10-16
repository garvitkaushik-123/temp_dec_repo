package com.inmobi.media;

import com.inmobi.ads.rendering.InMobiAdActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Kb extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Kb f2342a = new Kb();

    public Kb() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = InMobiAdActivity.l;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.p();
        }
        return Unit.INSTANCE;
    }
}
