package io.adn.sdk.internal.data.parser;

import com.mbridge.msdk.out.MBSupportMuteAdType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0}, l = {MBSupportMuteAdType.INTERSTITIAL_VIDEO}, m = "parseCreativesTag", n = {"creatives", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv"}, s = {"L$0", "L$1", "Z$0", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseCreativesTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseCreativesTag$1(Continuation<? super VastParserKt$parseCreativesTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseCreativesTag(null, false, this);
    }
}
