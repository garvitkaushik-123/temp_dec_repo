package com.inmobi.media;

import android.util.SparseArray;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Mb extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Mb f2363a = new Mb();

    public Mb() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String trackerName = (String) obj;
        Map macros = (Map) obj2;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        SparseArray sparseArray = InMobiAdActivity.k;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = InMobiAdActivity.l;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.a(trackerName, macros);
        }
        return Unit.INSTANCE;
    }
}
