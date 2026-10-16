package com.unity3d.ads.core.data.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidOfferwallManager.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager", f = "AndroidOfferwallManager.kt", i = {}, l = {28}, m = "loadAd", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidOfferwallManager$loadAd$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidOfferwallManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidOfferwallManager$loadAd$1(AndroidOfferwallManager androidOfferwallManager, Continuation<? super AndroidOfferwallManager$loadAd$1> continuation) {
        super(continuation);
        this.this$0 = androidOfferwallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadAd(null, this);
    }
}
