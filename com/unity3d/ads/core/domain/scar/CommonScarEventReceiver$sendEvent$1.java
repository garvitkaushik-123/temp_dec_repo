package com.unity3d.ads.core.domain.scar;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: CommonScarEventReceiver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.scar.CommonScarEventReceiver$sendEvent$1", f = "CommonScarEventReceiver.kt", i = {}, l = {35, 41, 52, 66, TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class CommonScarEventReceiver$sendEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Enum<?> $eventId;
    final /* synthetic */ Object[] $params;
    int label;
    final /* synthetic */ CommonScarEventReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonScarEventReceiver$sendEvent$1(Enum<?> r1, Object[] objArr, CommonScarEventReceiver commonScarEventReceiver, Continuation<? super CommonScarEventReceiver$sendEvent$1> continuation) {
        super(2, continuation);
        this.$eventId = r1;
        this.$params = objArr;
        this.this$0 = commonScarEventReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonScarEventReceiver$sendEvent$1(this.$eventId, this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonScarEventReceiver$sendEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0131, code lost:
    
        if (r2.emit(new com.unity3d.ads.core.domain.scar.GmaEventData(r11, r12, (java.lang.String) r4, null, null, null, null, 120, null), r20) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r3.emit(r2, r20) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
    
        if (r3.emit(r10, r20) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cb, code lost:
    
        if (r3.emit(r10, r20) == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f9, code lost:
    
        if (r2.emit(new com.unity3d.ads.core.domain.scar.GmaEventData((com.unity3d.scar.adapter.common.GMAEvent) r20.$eventId, null, null, null, null, null, null, 126, null), r20) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        MutableSharedFlow mutableSharedFlow4;
        MutableSharedFlow mutableSharedFlow5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Enum<?> r2 = this.$eventId;
            if (r2 == GMAEvent.VERSION) {
                Object[] objArr = this.$params;
                CommonScarEventReceiver commonScarEventReceiver = this.this$0;
                String str = (String) objArr[0];
                mutableSharedFlow4 = commonScarEventReceiver._versionFlow;
                if (Intrinsics.areEqual(str, "0.0.0")) {
                    str = null;
                }
                this.label = 1;
            } else if (r2 == GMAEvent.AD_LOADED) {
                Object[] objArr2 = this.$params;
                mutableSharedFlow3 = this.this$0._gmaEventFlow;
                GMAEvent gMAEvent = GMAEvent.AD_LOADED;
                Object obj2 = objArr2[0];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                GmaEventData gmaEventData = new GmaEventData(gMAEvent, null, null, (String) obj2, null, null, null, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                this.label = 2;
            } else if (r2 == GMAEvent.LOAD_ERROR) {
                Object[] objArr3 = this.$params;
                mutableSharedFlow2 = this.this$0._gmaEventFlow;
                GMAEvent gMAEvent2 = GMAEvent.LOAD_ERROR;
                Object obj3 = objArr3[0];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                String str2 = (String) obj3;
                Object obj4 = objArr3[1];
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                String str3 = (String) obj4;
                Object obj5 = objArr3[2];
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                Object obj6 = objArr3[3];
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
                GmaEventData gmaEventData2 = new GmaEventData(gMAEvent2, null, null, str2, str3, (String) obj5, (Integer) obj6, 6, null);
                this.label = 3;
            } else {
                if (this.$eventId instanceof GMAEvent) {
                    mutableSharedFlow = this.this$0._gmaEventFlow;
                    this.label = 4;
                }
                if (this.$eventId instanceof BannerBridge.BannerEvent) {
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1 && i != 2 && i != 3) {
                if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$eventId instanceof BannerBridge.BannerEvent) {
                        mutableSharedFlow5 = this.this$0._gmaEventFlow;
                        GMAEvent gMAEvent3 = GMAEvent.BANNER;
                        BannerBridge.BannerEvent bannerEvent = (BannerBridge.BannerEvent) this.$eventId;
                        Object obj7 = this.$params[0];
                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
                        this.label = 5;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
