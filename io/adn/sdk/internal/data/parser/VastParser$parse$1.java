package io.adn.sdk.internal.data.parser;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: VastParser.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.parser.VastParser", f = "VastParser.kt", i = {}, l = {44}, m = "parse", n = {}, s = {})
/* loaded from: classes7.dex */
final class VastParser$parse$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VastParser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VastParser$parse$1(VastParser vastParser, Continuation<? super VastParser$parse$1> continuation) {
        super(continuation);
        this.this$0 = vastParser;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.parse(null, this);
    }
}
