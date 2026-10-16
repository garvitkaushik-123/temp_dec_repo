package io.adn.sdk.internal.data.parser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {690, 691, 692}, m = "parseVideoClicksTag", n = {"clickThrough", "clickTrackingList", "customClickList", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", "clickThrough", "clickTrackingList", "customClickList", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", "clickThrough", "clickTrackingList", "customClickList", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseVideoClicksTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseVideoClicksTag$1(Continuation<? super VastParserKt$parseVideoClicksTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseVideoClicksTag(null, false, this);
    }
}
