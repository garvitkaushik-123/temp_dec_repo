package io.adn.sdk.internal.data.api.local;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdvertisingIdsApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.api.local.AdvertisingIdsApiImpl", f = "AdvertisingIdsApi.kt", i = {0, 0}, l = {30}, m = "getAdvertisingInfo", n = {"this", "advertisingIdInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class AdvertisingIdsApiImpl$getAdvertisingInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvertisingIdsApiImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvertisingIdsApiImpl$getAdvertisingInfo$1(AdvertisingIdsApiImpl advertisingIdsApiImpl, Continuation<? super AdvertisingIdsApiImpl$getAdvertisingInfo$1> continuation) {
        super(continuation);
        this.this$0 = advertisingIdsApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAdvertisingInfo(this);
    }
}
