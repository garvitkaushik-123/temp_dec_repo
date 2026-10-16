package io.adn.sdk.internal.data.parser;

import com.explorestack.protobuf.openrtb.LossReason;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {LossReason.LOSS_REASON_CREATIVE_FILTERED_ANIMATION_TOO_LONG_VALUE, 212, Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE}, m = "parseWrapperTag", n = {"vastAdTagUrl", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "adSystem", "impressions", "errorUrls", "creatives", "$this$iterateTag$iv", "initialDepth$iv", "vastAdTagUrl", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "adSystem", "impressions", "errorUrls", "creatives", "$this$iterateTag$iv", "initialDepth$iv", "vastAdTagUrl", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "adSystem", "impressions", "errorUrls", "creatives", "$this$iterateTag$iv", "initialDepth$iv", "vastAdTagUrl", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "adSystem", "impressions", "errorUrls", "creatives", "$this$iterateTag$iv", "initialDepth$iv", "vastAdTagUrl", VastAttributes.FOLLOW_ADDITIONAL_WRAPPERS, "adSystem", "impressions", "errorUrls", "creatives", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseWrapperTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseWrapperTag$1(Continuation<? super VastParserKt$parseWrapperTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseWrapperTag(null, this);
    }
}
