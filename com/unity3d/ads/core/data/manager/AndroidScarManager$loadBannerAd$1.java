package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
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
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadBannerAd$1", f = "AndroidScarManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidScarManager$loadBannerAd$1 extends SuspendLambda implements Function2<FlowCollector<? super GmaEventData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ UnityBannerSize $bannerSize;
    final /* synthetic */ BannerView $bannerView;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $opportunityId;
    final /* synthetic */ ScarAdMetadata $scarAdMetadata;
    int label;
    final /* synthetic */ AndroidScarManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidScarManager$loadBannerAd$1(AndroidScarManager androidScarManager, Context context, BannerView bannerView, String str, ScarAdMetadata scarAdMetadata, UnityBannerSize unityBannerSize, Continuation<? super AndroidScarManager$loadBannerAd$1> continuation) {
        super(2, continuation);
        this.this$0 = androidScarManager;
        this.$context = context;
        this.$bannerView = bannerView;
        this.$opportunityId = str;
        this.$scarAdMetadata = scarAdMetadata;
        this.$bannerSize = unityBannerSize;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidScarManager$loadBannerAd$1(this.this$0, this.$context, this.$bannerView, this.$opportunityId, this.$scarAdMetadata, this.$bannerSize, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super GmaEventData> flowCollector, Continuation<? super Unit> continuation) {
        return ((AndroidScarManager$loadBannerAd$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GMAScarAdapterBridge gMAScarAdapterBridge;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            gMAScarAdapterBridge = this.this$0.gmaBridge;
            gMAScarAdapterBridge.loadBanner(this.$context, this.$bannerView, this.$opportunityId, this.$scarAdMetadata, this.$bannerSize);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
