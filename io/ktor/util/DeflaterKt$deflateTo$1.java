package io.ktor.util;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deflater.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER, 82, 88, 91}, m = "deflateTo", n = {"$this$deflateTo", FirebaseAnalytics.Param.DESTINATION, "pool", "crc", "deflater", "input", "compressed", "gzip", "$this$deflateTo", FirebaseAnalytics.Param.DESTINATION, "pool", "crc", "deflater", "input", "compressed", "gzip", "$this$deflateTo", FirebaseAnalytics.Param.DESTINATION, "pool", "crc", "deflater", "input", "compressed", "gzip", FirebaseAnalytics.Param.DESTINATION, "pool", "crc", "deflater", "input", "compressed", "gzip", "pool", "deflater", "input", "compressed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes8.dex */
final class DeflaterKt$deflateTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    DeflaterKt$deflateTo$1(Continuation<? super DeflaterKt$deflateTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object deflateTo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        deflateTo = DeflaterKt.deflateTo(null, null, false, null, this);
        return deflateTo;
    }
}
