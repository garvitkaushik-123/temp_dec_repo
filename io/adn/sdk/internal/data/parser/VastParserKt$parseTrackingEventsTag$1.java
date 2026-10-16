package io.adn.sdk.internal.data.parser;

import com.unity3d.mediation.LevelPlayAdError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0}, l = {LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW}, m = "parseTrackingEventsTag", n = {"trackingList", "$this$iterateTag$iv", "initialDepth$iv"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseTrackingEventsTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseTrackingEventsTag$1(Continuation<? super VastParserKt$parseTrackingEventsTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseTrackingEventsTag(null, this);
    }
}
