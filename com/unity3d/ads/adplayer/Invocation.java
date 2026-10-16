package com.unity3d.ads.adplayer;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* compiled from: Invocation.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0013\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J1\u0010\u0015\u001a\u00020\t2\u001e\b\u0002\u0010\u0016\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/unity3d/ads/adplayer/Invocation;", "", FirebaseAnalytics.Param.LOCATION, "", "parameters", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "_isHandled", "Lkotlinx/coroutines/CompletableDeferred;", "", "completableDeferred", "isHandled", "Lkotlinx/coroutines/Deferred;", "()Lkotlinx/coroutines/Deferred;", "getLocation", "()Ljava/lang/String;", "getParameters", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "handler", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Invocation {
    private final CompletableDeferred<Unit> _isHandled;
    private final CompletableDeferred<Object> completableDeferred;
    private final String location;
    private final Object[] parameters;

    public Invocation(String location, Object[] parameters) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.location = location;
        this.parameters = parameters;
        this._isHandled = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.completableDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public final String getLocation() {
        return this.location;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }

    public final Deferred<Unit> isHandled() {
        return this._isHandled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object handle$default(Invocation invocation, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Invocation$handle$2(null);
        }
        return invocation.handle(function1, continuation);
    }

    public final Object handle(Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        this._isHandled.complete(Unit.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation.get$context()), null, null, new Invocation$handle$3(function1, this, null), 3, null);
        return Unit.INSTANCE;
    }

    public final Object getResult(Continuation<Object> continuation) {
        return this.completableDeferred.await(continuation);
    }
}
