package com.moloco.sdk.publisher;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/moloco/sdk/publisher/Banner;", "Landroid/widget/FrameLayout;", "Lcom/moloco/sdk/publisher/AdLoad;", "Lcom/moloco/sdk/publisher/Destroyable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "adShowListener", "Lcom/moloco/sdk/publisher/BannerAdShowListener;", "getAdShowListener", "()Lcom/moloco/sdk/publisher/BannerAdShowListener;", "setAdShowListener", "(Lcom/moloco/sdk/publisher/BannerAdShowListener;)V", "_isViewShown", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isViewShown", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class Banner extends FrameLayout implements AdLoad, Destroyable {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _isViewShown;
    private BannerAdShowListener adShowListener;
    private final StateFlow<Boolean> isViewShown;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setTag("MolocoBannerView");
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isViewShown = MutableStateFlow;
        this.isViewShown = FlowKt.asStateFlow(MutableStateFlow);
    }

    public BannerAdShowListener getAdShowListener() {
        return this.adShowListener;
    }

    public StateFlow<Boolean> isViewShown() {
        return this.isViewShown;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        this._isViewShown.setValue(Boolean.valueOf(changedView.isShown()));
    }

    public void setAdShowListener(BannerAdShowListener bannerAdShowListener) {
        this.adShowListener = bannerAdShowListener;
    }
}
