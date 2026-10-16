package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.net.ConnectivityManagerCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

/* loaded from: classes6.dex */
public final class v implements u {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5728a;
    public final String b;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl", f = "ConnectivityService.kt", i = {}, l = {40}, m = "waitForNetwork", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5729a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5729a = obj;
            this.c |= Integer.MIN_VALUE;
            return v.this.a(0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl$waitForNetwork$hasConnectivity$1", f = "ConnectivityService.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5730a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return v.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5730a;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (!v.this.a()) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, v.this.b, "waiting because of no network connection", null, false, 12, null);
                this.f5730a = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(true);
        }
    }

    public v(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5728a = context;
        this.b = "ConnectivityServiceImpl";
    }

    @Override // com.moloco.sdk.internal.services.u
    public boolean b() {
        try {
            return ConnectivityManagerCompat.isActiveNetworkMetered(a(this.f5728a));
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "isNetworkMetered", e.toString(), e, false, 8, null);
            return false;
        }
    }

    public final Context c() {
        return this.f5728a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.moloco.sdk.internal.services.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(long j, Continuation<? super Boolean> continuation) {
        a aVar;
        int i;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.c = i2 - Integer.MIN_VALUE;
                Object obj = aVar.f5729a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = aVar.c;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = new b(null);
                    aVar.c = 1;
                    obj = TimeoutKt.withTimeoutOrNull(j, bVar, aVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Boolean bool = (Boolean) obj;
                return Boxing.boxBoolean(bool == null ? bool.booleanValue() : false);
            }
        }
        aVar = new a(continuation);
        Object obj2 = aVar.f5729a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.c;
        if (i != 0) {
        }
        Boolean bool2 = (Boolean) obj2;
        return Boxing.boxBoolean(bool2 == null ? bool2.booleanValue() : false);
    }

    @Override // com.moloco.sdk.internal.services.u
    public boolean a() {
        NetworkCapabilities networkCapabilities;
        Object systemService = this.f5728a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final ConnectivityManager a(Context context) {
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }
}
