package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w {
    public static final void a(final MolocoInitializationListener molocoInitializationListener, final MolocoInitStatus initStatus) {
        Intrinsics.checkNotNullParameter(molocoInitializationListener, "<this>");
        Intrinsics.checkNotNullParameter(initStatus, "initStatus");
        com.moloco.sdk.internal.scheduling.d.a(new Function0() { // from class: com.moloco.sdk.internal.publisher.w$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return w.b(MolocoInitializationListener.this, initStatus);
            }
        });
    }

    public static final Unit b(MolocoInitializationListener molocoInitializationListener, MolocoInitStatus molocoInitStatus) {
        molocoInitializationListener.onMolocoInitializationStatus(molocoInitStatus);
        return Unit.INSTANCE;
    }
}
