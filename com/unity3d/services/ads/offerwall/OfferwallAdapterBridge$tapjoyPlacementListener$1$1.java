package com.unity3d.services.ads.offerwall;

import adn.analytics.Analytics;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: OfferwallAdapterBridge.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.ads.offerwall.OfferwallAdapterBridge$tapjoyPlacementListener$1$1", f = "OfferwallAdapterBridge.kt", i = {}, l = {Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER, 83}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class OfferwallAdapterBridge$tapjoyPlacementListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $placementAvailable;
    final /* synthetic */ String $placementName;
    int label;
    final /* synthetic */ OfferwallAdapterBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfferwallAdapterBridge$tapjoyPlacementListener$1$1(boolean z, OfferwallAdapterBridge offerwallAdapterBridge, String str, Continuation<? super OfferwallAdapterBridge$tapjoyPlacementListener$1$1> continuation) {
        super(2, continuation);
        this.$placementAvailable = z;
        this.this$0 = offerwallAdapterBridge;
        this.$placementName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfferwallAdapterBridge$tapjoyPlacementListener$1$1(this.$placementAvailable, this.this$0, this.$placementName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OfferwallAdapterBridge$tapjoyPlacementListener$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r12.emit(new com.unity3d.ads.core.domain.offerwall.OfferwallEventData(r5, r6, null, null, 12, null), r11) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r12.emit(new com.unity3d.ads.core.domain.offerwall.OfferwallEventData(r4, r5, null, null, 12, null), r11) == r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HashMap hashMap;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$placementAvailable) {
                mutableSharedFlow2 = this.this$0._offerwallEventFlow;
                OfferwallEvent offerwallEvent = OfferwallEvent.REQUEST_SUCCESS;
                String str = this.$placementName;
                String str2 = str == null ? "" : str;
                this.label = 1;
            } else {
                hashMap = this.this$0.placementsMap;
                String str3 = this.$placementName;
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.remove(str3);
                mutableSharedFlow = this.this$0._offerwallEventFlow;
                OfferwallEvent offerwallEvent2 = OfferwallEvent.REQUEST_FAILED;
                String str4 = this.$placementName;
                if (str4 == null) {
                    str4 = "";
                }
                this.label = 2;
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
