package com.unity3d.ads.core.domain;

import com.unity3d.ads.TokenConfiguration;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: BuildHeaderBiddingToken.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH¦Bø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/unity3d/ads/core/domain/BuildHeaderBiddingToken;", "", "invoke", "Lgatewayprotocol/v1/HeaderBiddingTokenOuterClass$HeaderBiddingToken;", "tokenNumber", "", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", "scarSignalsCollected", "", "(ILcom/unity3d/ads/TokenConfiguration;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface BuildHeaderBiddingToken {
    Object invoke(int i, TokenConfiguration tokenConfiguration, boolean z, Continuation<? super HeaderBiddingTokenOuterClass.HeaderBiddingToken> continuation);

    /* compiled from: BuildHeaderBiddingToken.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object invoke$default(BuildHeaderBiddingToken buildHeaderBiddingToken, int i, TokenConfiguration tokenConfiguration, boolean z, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i2 & 2) != 0) {
                tokenConfiguration = null;
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            return buildHeaderBiddingToken.invoke(i, tokenConfiguration, z, continuation);
        }
    }
}
