package com.unity3d.ads.core.domain;

import com.unity3d.ads.TokenConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: GetHeaderBiddingToken.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦Bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;", "", "invoke", "", "tokenNumber", "", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", "(ILcom/unity3d/ads/TokenConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface GetHeaderBiddingToken {
    Object invoke(int i, TokenConfiguration tokenConfiguration, Continuation<? super String> continuation);

    /* compiled from: GetHeaderBiddingToken.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(GetHeaderBiddingToken getHeaderBiddingToken, int i, TokenConfiguration tokenConfiguration, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i2 & 2) != 0) {
                tokenConfiguration = null;
            }
            return getHeaderBiddingToken.invoke(i, tokenConfiguration, continuation);
        }
    }
}
