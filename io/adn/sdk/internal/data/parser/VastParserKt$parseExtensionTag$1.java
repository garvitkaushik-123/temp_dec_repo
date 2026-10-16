package io.adn.sdk.internal.data.parser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0}, l = {490}, m = "parseExtensionTag", n = {"type", "customEvents", "$this$iterateTag$iv", "nameAttr", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseExtensionTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseExtensionTag$1(Continuation<? super VastParserKt$parseExtensionTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseExtensionTag(null, this);
    }
}
