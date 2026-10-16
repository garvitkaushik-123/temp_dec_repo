package io.adn.sdk.internal.data.parser;

import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {356, 357, 358, 359, 360, 361}, m = "parseLinearTag", n = {UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", UnifiedMediationParams.KEY_SKIP_OFFSET, "adParameters", "durationMillis", "mediaFiles", "trackingList", "videoClicks", "icons", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseLinearTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseLinearTag$1(Continuation<? super VastParserKt$parseLinearTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseLinearTag(null, false, this);
    }
}
