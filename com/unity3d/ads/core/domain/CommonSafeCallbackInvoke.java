package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: CommonSafeCallbackInvoke.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonSafeCallbackInvoke;", "Lcom/unity3d/ads/core/domain/SafeCallbackInvoke;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "", "block", "Lkotlin/Function0;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonSafeCallbackInvoke implements SafeCallbackInvoke {
    private final CoroutineDispatcher mainDispatcher;

    public CommonSafeCallbackInvoke(CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.mainDispatcher = mainDispatcher;
    }

    @Override // com.unity3d.ads.core.domain.SafeCallbackInvoke
    public void invoke(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.mainDispatcher), null, null, new CommonSafeCallbackInvoke$invoke$1(block, null), 3, null);
    }
}
