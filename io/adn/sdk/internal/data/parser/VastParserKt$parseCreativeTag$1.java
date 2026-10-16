package io.adn.sdk.internal.data.parser;

import com.ironsource.sdk.controller.f;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParserKt", f = "VastParser.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 325}, m = "parseCreativeTag", n = {"id", "sequence", f.b.c, VastAttributes.API_FRAMEWORK, "child", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv", "id", "sequence", f.b.c, VastAttributes.API_FRAMEWORK, "child", "$this$iterateTag$iv", "isInLineParent", "initialDepth$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0"})
/* loaded from: classes7.dex */
final class VastParserKt$parseCreativeTag$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    VastParserKt$parseCreativeTag$1(Continuation<? super VastParserKt$parseCreativeTag$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return VastParserKt.parseCreativeTag(null, false, this);
    }
}
