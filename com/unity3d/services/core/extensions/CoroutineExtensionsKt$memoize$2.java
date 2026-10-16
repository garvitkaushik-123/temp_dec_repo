package com.unity3d.services.core.extensions;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CoroutineExtensions.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2", f = "CoroutineExtensions.kt", i = {0, 0}, l = {53, 45}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
public final class CoroutineExtensionsKt$memoize$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $action;
    final /* synthetic */ Object $key;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtensionsKt$memoize$2(Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super CoroutineExtensionsKt$memoize$2> continuation) {
        super(2, continuation);
        this.$key = obj;
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutineExtensionsKt$memoize$2 coroutineExtensionsKt$memoize$2 = new CoroutineExtensionsKt$memoize$2(this.$key, this.$action, continuation);
        coroutineExtensionsKt$memoize$2.L$0 = obj;
        return coroutineExtensionsKt$memoize$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((CoroutineExtensionsKt$memoize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Mutex mutex;
        Function1<Continuation<? super T>, Object> function1;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutex = CoroutineExtensionsKt.getMutex();
                Object obj3 = this.$key;
                function1 = this.$action;
                this.L$0 = coroutineScope;
                this.L$1 = mutex;
                this.L$2 = obj3;
                this.L$3 = function1;
                this.label = 1;
                if (mutex.lock(null, this) != coroutine_suspended) {
                    obj2 = obj3;
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            function1 = (Function1) this.L$3;
            obj2 = this.L$2;
            mutex = (Mutex) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            LinkedHashMap<Object, Deferred<?>> deferreds = CoroutineExtensionsKt.getDeferreds();
            Deferred<?> deferred = deferreds.get(obj2);
            if (deferred == null) {
                deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(function1, null), 3, null);
                deferreds.put(obj2, deferred);
            }
            Deferred<?> deferred2 = deferred;
            mutex.unlock(null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            Object await = deferred2.await(this);
            return await == coroutine_suspended ? coroutine_suspended : await;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Mutex mutex = CoroutineExtensionsKt.getMutex();
        Object obj2 = this.$key;
        Function1<Continuation<? super T>, Object> function1 = this.$action;
        CoroutineExtensionsKt$memoize$2<T> coroutineExtensionsKt$memoize$2 = this;
        mutex.lock(null, coroutineExtensionsKt$memoize$2);
        try {
            LinkedHashMap<Object, Deferred<?>> deferreds = CoroutineExtensionsKt.getDeferreds();
            Deferred<?> deferred = deferreds.get(obj2);
            if (deferred == null) {
                deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(function1, null), 3, null);
                deferreds.put(obj2, deferred);
            }
            Deferred<?> deferred2 = deferred;
            mutex.unlock(null);
            return deferred2.await(coroutineExtensionsKt$memoize$2);
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }
}
