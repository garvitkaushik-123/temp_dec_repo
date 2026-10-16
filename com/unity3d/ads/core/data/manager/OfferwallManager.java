package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: OfferwallManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0007\u001a\u00020\u0003H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/unity3d/ads/core/data/manager/OfferwallManager;", "", "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAdReady", "", "placementName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConnected", "loadAd", "", "showAd", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/core/domain/offerwall/OfferwallEventData;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface OfferwallManager {
    Object getVersion(Continuation<? super String> continuation);

    Object isAdReady(String str, Continuation<? super Boolean> continuation);

    Object isConnected(Continuation<? super Boolean> continuation);

    Object loadAd(String str, Continuation<? super Unit> continuation);

    Flow<OfferwallEventData> showAd(String placementName);
}
