package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.AdPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/unity3d/ads/adplayer/FullscreenAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface FullscreenAdPlayer extends AdPlayer {

    /* compiled from: FullscreenAdPlayer.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object destroy(FullscreenAdPlayer fullscreenAdPlayer, Continuation<? super Unit> continuation) {
            Object destroy = AdPlayer.DefaultImpls.destroy(fullscreenAdPlayer, continuation);
            return destroy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? destroy : Unit.INSTANCE;
        }

        public static void show(FullscreenAdPlayer fullscreenAdPlayer, ShowOptions showOptions) {
            Intrinsics.checkNotNullParameter(showOptions, "showOptions");
            AdPlayer.DefaultImpls.show(fullscreenAdPlayer, showOptions);
        }
    }
}
