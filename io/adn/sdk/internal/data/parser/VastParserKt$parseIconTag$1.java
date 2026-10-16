package io.adn.sdk.internal.data.parser;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {767, 768, 769, 775, 776}, m = "parseIconTag", n = {"program", "widthPx", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "durationMillis", "clicks", "resource", "viewTrackingUrlList", "$this$iterateTag$iv", "$this$parseIconTag_u24lambda_u24109", "initialDepth$iv", "program", "widthPx", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "durationMillis", "clicks", "resource", "viewTrackingUrlList", "$this$iterateTag$iv", "$this$parseIconTag_u24lambda_u24109", "initialDepth$iv", "program", "widthPx", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "durationMillis", "clicks", "resource", "viewTrackingUrlList", "$this$iterateTag$iv", "$this$parseIconTag_u24lambda_u24109", "initialDepth$iv", "program", "widthPx", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "durationMillis", "clicks", "resource", "viewTrackingUrlList", "$this$iterateTag$iv", "initialDepth$iv", "program", "widthPx", "heightPx", VastAttributes.API_FRAMEWORK, "offset", "durationMillis", "clicks", "resource", "viewTrackingUrlList", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseIconTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseIconTag$1(Continuation<? super VastParserKt$parseIconTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseIconTag(null, this);
    }
}
