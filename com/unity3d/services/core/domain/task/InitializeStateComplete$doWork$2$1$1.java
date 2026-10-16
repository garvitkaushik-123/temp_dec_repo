package com.unity3d.services.core.domain.task;

import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializeStateComplete.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/datastore/ByteStringStoreOuterClass$ByteStringStore;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2$1$1", f = "InitializeStateComplete.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class InitializeStateComplete$doWork$2$1$1 extends SuspendLambda implements Function2<ByteStringStoreOuterClass.ByteStringStore, Continuation<? super ByteStringStoreOuterClass.ByteStringStore>, Object> {
    /* synthetic */ Object L$0;
    int label;

    InitializeStateComplete$doWork$2$1$1(Continuation<? super InitializeStateComplete$doWork$2$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateComplete$doWork$2$1$1 initializeStateComplete$doWork$2$1$1 = new InitializeStateComplete$doWork$2$1$1(continuation);
        initializeStateComplete$doWork$2$1$1.L$0 = obj;
        return initializeStateComplete$doWork$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ByteStringStoreOuterClass.ByteStringStore byteStringStore, Continuation<? super ByteStringStoreOuterClass.ByteStringStore> continuation) {
        return ((InitializeStateComplete$doWork$2$1$1) create(byteStringStore, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ByteStringStoreOuterClass.ByteStringStore build = ((ByteStringStoreOuterClass.ByteStringStore) this.L$0).toBuilder().clear().build();
        Intrinsics.checkNotNullExpressionValue(build, "it.toBuilder().clear().build()");
        return build;
    }
}
