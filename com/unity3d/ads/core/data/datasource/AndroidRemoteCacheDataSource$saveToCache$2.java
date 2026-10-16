package com.unity3d.ads.core.data.datasource;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidRemoteCacheDataSource.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$saveToCache$2", f = "AndroidRemoteCacheDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidRemoteCacheDataSource$saveToCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Object $body;
    final /* synthetic */ File $dest;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidRemoteCacheDataSource$saveToCache$2(Object obj, File file, Continuation<? super AndroidRemoteCacheDataSource$saveToCache$2> continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$dest = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidRemoteCacheDataSource$saveToCache$2(this.$body, this.$dest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((AndroidRemoteCacheDataSource$saveToCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Class<?> cls;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Object obj2 = this.$body;
        if (obj2 instanceof File) {
            FilesKt.copyTo$default((File) obj2, this.$dest, true, 0, 4, null);
            return Boxing.boxBoolean(((File) this.$body).delete());
        }
        if (obj2 instanceof byte[]) {
            this.$dest.createNewFile();
            FilesKt.writeBytes(this.$dest, (byte[]) this.$body);
            return Unit.INSTANCE;
        }
        String str = null;
        if (obj2 instanceof String) {
            this.$dest.createNewFile();
            FilesKt.writeText$default(this.$dest, (String) this.$body, null, 2, null);
            return Unit.INSTANCE;
        }
        StringBuilder sb = new StringBuilder("Unknown body type ");
        Object obj3 = this.$body;
        if (obj3 != null && (cls = obj3.getClass()) != null) {
            str = cls.getSimpleName();
        }
        throw new IllegalStateException(sb.append(str).toString().toString());
    }
}
