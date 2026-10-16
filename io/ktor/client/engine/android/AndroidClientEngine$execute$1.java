package io.ktor.client.engine.android;

import adn.analytics.Analytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidClientEngine.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngine", f = "AndroidClientEngine.kt", i = {0, 0, 1, 1, 1}, l = {35, Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER, 82}, m = "execute", n = {"this", "data", "data", "callContext", "requestTime"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes8.dex */
final class AndroidClientEngine$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidClientEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidClientEngine$execute$1(AndroidClientEngine androidClientEngine, Continuation<? super AndroidClientEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = androidClientEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
