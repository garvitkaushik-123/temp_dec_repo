package io.adn.sdk.internal.data.parser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {}, l = {848}, m = "parseIFrameResourceTag", n = {}, s = {})
/* loaded from: classes7.dex */
final class VastParserKt$parseIFrameResourceTag$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseIFrameResourceTag$1(Continuation<? super VastParserKt$parseIFrameResourceTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseIFrameResourceTag(null, this);
    }
}
