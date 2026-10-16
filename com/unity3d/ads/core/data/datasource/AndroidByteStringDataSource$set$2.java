package com.unity3d.ads.core.data.datasource;

import com.google.protobuf.ByteString;
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

/* compiled from: AndroidByteStringDataSource.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/datastore/ByteStringStoreOuterClass$ByteStringStore;", "currentData"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$set$2", f = "AndroidByteStringDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidByteStringDataSource$set$2 extends SuspendLambda implements Function2<ByteStringStoreOuterClass.ByteStringStore, Continuation<? super ByteStringStoreOuterClass.ByteStringStore>, Object> {
    final /* synthetic */ ByteString $data;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidByteStringDataSource$set$2(ByteString byteString, Continuation<? super AndroidByteStringDataSource$set$2> continuation) {
        super(2, continuation);
        this.$data = byteString;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidByteStringDataSource$set$2 androidByteStringDataSource$set$2 = new AndroidByteStringDataSource$set$2(this.$data, continuation);
        androidByteStringDataSource$set$2.L$0 = obj;
        return androidByteStringDataSource$set$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ByteStringStoreOuterClass.ByteStringStore byteStringStore, Continuation<? super ByteStringStoreOuterClass.ByteStringStore> continuation) {
        return ((AndroidByteStringDataSource$set$2) create(byteStringStore, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ByteStringStoreOuterClass.ByteStringStore build = ((ByteStringStoreOuterClass.ByteStringStore) this.L$0).toBuilder().setData(this.$data).build();
        Intrinsics.checkNotNullExpressionValue(build, "currentData.toBuilder()\n…\n                .build()");
        return build;
    }
}
