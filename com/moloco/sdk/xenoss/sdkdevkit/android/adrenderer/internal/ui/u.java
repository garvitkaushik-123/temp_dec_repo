package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.moloco.sdk.internal.w;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* loaded from: classes6.dex */
public final class u extends View {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6044a = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
    }

    public final Object a(MotionEvent motionEvent, com.moloco.sdk.internal.services.s sVar, String str, String str2, h hVar, MutableSharedFlow<Unit> mutableSharedFlow, w wVar, Continuation<? super Unit> continuation) {
        Object a2;
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a(ArraysKt.first(iArr), ArraysKt.last(iArr), getHeight(), getWidth(), (int) (motionEvent.getX() + ArraysKt.first(iArr)), (int) (motionEvent.getY() + ArraysKt.last(iArr)));
            if (str != null) {
                Boxing.boxBoolean(w.a.a(wVar, str, System.currentTimeMillis(), null, 4, null));
            }
            if (str2 != null && (a2 = sVar.a(str2, aVar, hVar, mutableSharedFlow, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return a2;
            }
        }
        return Unit.INSTANCE;
    }
}
