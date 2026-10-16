package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class AndroidFullscreenWebViewAdPlayer$show$4 extends FunctionReferenceImpl implements Function2<VolumeSettingsChange, Continuation<? super Unit>, Object>, SuspendFunction {
    AndroidFullscreenWebViewAdPlayer$show$4(Object obj) {
        super(2, obj, AndroidFullscreenWebViewAdPlayer.class, "handleVolumeSettingsChange", "handleVolumeSettingsChange(Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(VolumeSettingsChange volumeSettingsChange, Continuation<? super Unit> continuation) {
        Object handleVolumeSettingsChange;
        handleVolumeSettingsChange = ((AndroidFullscreenWebViewAdPlayer) this.receiver).handleVolumeSettingsChange(volumeSettingsChange, continuation);
        return handleVolumeSettingsChange;
    }
}
