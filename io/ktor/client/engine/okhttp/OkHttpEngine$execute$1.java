package io.ktor.client.engine.okhttp;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OkHttpEngine.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER, 81}, m = "execute", n = {"this", "data"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class OkHttpEngine$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OkHttpEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkHttpEngine$execute$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
