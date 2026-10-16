package io.adn.sdk.internal.data.api.local;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdvertisingIdsApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.api.local.AdvertisingIdsApiImpl", f = "AdvertisingIdsApi.kt", i = {}, l = {48}, m = "appSetIdInfo", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdvertisingIdsApiImpl$appSetIdInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvertisingIdsApiImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvertisingIdsApiImpl$appSetIdInfo$1(AdvertisingIdsApiImpl advertisingIdsApiImpl, Continuation<? super AdvertisingIdsApiImpl$appSetIdInfo$1> continuation) {
        super(continuation);
        this.this$0 = advertisingIdsApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object appSetIdInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        appSetIdInfo = this.this$0.appSetIdInfo(this);
        return appSetIdInfo;
    }
}
