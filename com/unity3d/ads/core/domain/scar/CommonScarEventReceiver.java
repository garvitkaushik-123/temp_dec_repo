package com.unity3d.ads.core.domain.scar;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: CommonScarEventReceiver.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J9\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/unity3d/ads/core/domain/scar/CommonScarEventReceiver;", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "_gmaEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;", "_versionFlow", "", "gmaEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getGmaEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "versionFlow", "getVersionFlow", "canSend", "", "sendEvent", "eventCategory", "", "eventId", "params", "", "", "(Ljava/lang/Enum;Ljava/lang/Enum;[Ljava/lang/Object;)Z", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonScarEventReceiver implements IEventSender {
    private final MutableSharedFlow<GmaEventData> _gmaEventFlow;
    private final MutableSharedFlow<String> _versionFlow;
    private final SharedFlow<GmaEventData> gmaEventFlow;
    private final CoroutineScope scope;
    private final SharedFlow<String> versionFlow;

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean canSend() {
        return true;
    }

    public CommonScarEventReceiver(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        MutableSharedFlow<String> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._versionFlow = MutableSharedFlow$default;
        this.versionFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<GmaEventData> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._gmaEventFlow = MutableSharedFlow$default2;
        this.gmaEventFlow = FlowKt.asSharedFlow(MutableSharedFlow$default2);
    }

    public final SharedFlow<String> getVersionFlow() {
        return this.versionFlow;
    }

    public final SharedFlow<GmaEventData> getGmaEventFlow() {
        return this.gmaEventFlow;
    }

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean sendEvent(Enum<?> eventCategory, Enum<?> eventId, Object... params) {
        Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!CollectionsKt.contains(SetsKt.setOf((Object[]) new WebViewEventCategory[]{WebViewEventCategory.INIT_GMA, WebViewEventCategory.GMA, WebViewEventCategory.BANNER}), eventCategory)) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CommonScarEventReceiver$sendEvent$1(eventId, params, this, null), 3, null);
        return true;
    }
}
