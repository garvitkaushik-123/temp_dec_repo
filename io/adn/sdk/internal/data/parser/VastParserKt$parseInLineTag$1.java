package io.adn.sdk.internal.data.parser;

import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {166, 167, 168, 169, 170, 171, 172, 173, 174}, m = "parseInLineTag", n = {"adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv", "adSystem", "adTitle", "description", C3040d4.h.F0, "pricing", "impressions", "errorUrls", "creatives", "extensions", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseInLineTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
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

    VastParserKt$parseInLineTag$1(Continuation<? super VastParserKt$parseInLineTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseInLineTag(null, this);
    }
}
