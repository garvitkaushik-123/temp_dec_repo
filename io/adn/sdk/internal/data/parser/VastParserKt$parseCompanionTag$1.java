package io.adn.sdk.internal.data.parser;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {CommonGatewayClient.CODE_TOO_MANY_REQUESTS, 430, 431, 432, 433, 435, 438, 439}, m = "parseCompanionTag", n = {"id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv", "id", "widthPx", "heightPx", "type", "altText", VastAttributes.API_FRAMEWORK, "adParameters", "creativeViewTrackingList", "resources", "clickThroughUrl", "clickTrackingList", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseCompanionTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
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

    VastParserKt$parseCompanionTag$1(Continuation<? super VastParserKt$parseCompanionTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseCompanionTag(null, this);
    }
}
