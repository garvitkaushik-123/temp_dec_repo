package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class AndroidFullscreenWebViewAdPlayer$show$3 extends AdaptedFunctionReference implements Function2<DisplayMessage, Continuation<? super Unit>, Object>, SuspendFunction {
    AndroidFullscreenWebViewAdPlayer$show$3(Object obj) {
        super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "displayEventsRouter", "displayEventsRouter(Lcom/unity3d/ads/adplayer/DisplayMessage;)Lkotlinx/coroutines/Job;", 12);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DisplayMessage displayMessage, Continuation<? super Unit> continuation) {
        Object show$displayEventsRouter;
        show$displayEventsRouter = AndroidFullscreenWebViewAdPlayer.show$displayEventsRouter((AndroidFullscreenWebViewAdPlayer) this.receiver, displayMessage, continuation);
        return show$displayEventsRouter;
    }
}
