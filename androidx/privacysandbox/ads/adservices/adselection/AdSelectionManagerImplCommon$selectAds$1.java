package androidx.privacysandbox.ads.adservices.adselection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdSelectionManagerImplCommon.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon", f = "AdSelectionManagerImplCommon.kt", i = {}, l = {44}, m = "selectAds$suspendImpl", n = {}, s = {})
/* loaded from: classes2.dex */
final class AdSelectionManagerImplCommon$selectAds$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdSelectionManagerImplCommon$selectAds$1(AdSelectionManagerImplCommon adSelectionManagerImplCommon, Continuation<? super AdSelectionManagerImplCommon$selectAds$1> continuation) {
        super(continuation);
        this.this$0 = adSelectionManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdSelectionManagerImplCommon.selectAds$suspendImpl(this.this$0, (AdSelectionConfig) null, this);
    }
}
