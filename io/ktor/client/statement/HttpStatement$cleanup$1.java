package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpStatement.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {126}, m = "cleanup", n = {}, s = {})
/* loaded from: classes8.dex */
final class HttpStatement$cleanup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpStatement$cleanup$1(HttpStatement httpStatement, Continuation<? super HttpStatement$cleanup$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cleanup(null, this);
    }
}
