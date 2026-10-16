package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.ads.core.domain.scar.ScarTimeHackFixer;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AndroidScarManager.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$2", f = "AndroidScarManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidScarManager$loadAd$2 extends SuspendLambda implements Function2<FlowCollector<? super GmaEventData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $adString;
    final /* synthetic */ String $adUnitId;
    final /* synthetic */ boolean $canSkip;
    final /* synthetic */ String $placementId;
    final /* synthetic */ String $queryId;
    final /* synthetic */ int $videoLength;
    int label;
    final /* synthetic */ AndroidScarManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidScarManager$loadAd$2(AndroidScarManager androidScarManager, boolean z, String str, String str2, String str3, String str4, int i, Continuation<? super AndroidScarManager$loadAd$2> continuation) {
        super(2, continuation);
        this.this$0 = androidScarManager;
        this.$canSkip = z;
        this.$placementId = str;
        this.$queryId = str2;
        this.$adString = str3;
        this.$adUnitId = str4;
        this.$videoLength = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidScarManager$loadAd$2(this.this$0, this.$canSkip, this.$placementId, this.$queryId, this.$adString, this.$adUnitId, this.$videoLength, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super GmaEventData> flowCollector, Continuation<? super Unit> continuation) {
        return ((AndroidScarManager$loadAd$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GMAScarAdapterBridge gMAScarAdapterBridge;
        ScarTimeHackFixer scarTimeHackFixer;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            gMAScarAdapterBridge = this.this$0.gmaBridge;
            boolean z = this.$canSkip;
            String str = this.$placementId;
            String str2 = this.$queryId;
            String str3 = this.$adString;
            String str4 = this.$adUnitId;
            scarTimeHackFixer = this.this$0.scarTimeHackFixer;
            gMAScarAdapterBridge.load(z, str, str2, str3, str4, scarTimeHackFixer.invoke(this.$videoLength));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
