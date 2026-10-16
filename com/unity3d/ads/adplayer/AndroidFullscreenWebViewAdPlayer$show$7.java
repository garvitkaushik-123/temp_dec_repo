package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.model.SessionChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class AndroidFullscreenWebViewAdPlayer$show$7 extends FunctionReferenceImpl implements Function2<SessionChange, Continuation<? super Unit>, Object>, SuspendFunction {
    AndroidFullscreenWebViewAdPlayer$show$7(Object obj) {
        super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleSessionChange", "handleSessionChange(Lcom/unity3d/ads/core/data/model/SessionChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SessionChange sessionChange, Continuation<? super Unit> continuation) {
        Object handleSessionChange;
        handleSessionChange = ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleSessionChange(sessionChange, continuation);
        return handleSessionChange;
    }
}
