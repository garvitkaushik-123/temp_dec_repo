package com.unity3d.ads.core.data.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidScarManager.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager", f = "AndroidScarManager.kt", i = {}, l = {89}, m = "loadAd", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidScarManager$loadAd$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidScarManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidScarManager$loadAd$1(AndroidScarManager androidScarManager, Continuation<? super AndroidScarManager$loadAd$1> continuation) {
        super(continuation);
        this.this$0 = androidScarManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadAd(null, null, null, null, null, 0, this);
    }
}
