package io.adn.sdk.internal.data.parser;

import io.bidmachine.protobuf.EventTypeExtended;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {EventTypeExtended.EVENT_TYPE_EXTENDED_CUSTOM_LOSS_VALUE, EventTypeExtended.EVENT_TYPE_EXTENDED_CUSTOM_WIN_VALUE}, m = "parseIconClicksTag", n = {"clickThroughUrl", "clickTrackingUrlList", "$this$iterateTag$iv", "initialDepth$iv", "clickThroughUrl", "clickTrackingUrlList", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseIconClicksTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseIconClicksTag$1(Continuation<? super VastParserKt$parseIconClicksTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseIconClicksTag(null, this);
    }
}
