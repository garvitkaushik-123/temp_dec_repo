package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.v;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w implements v {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final String g = "ServerBidTokenCache";
    public static final long h = 15;
    public static final long i = 2;
    public final com.moloco.sdk.internal.bidtoken.b b;
    public final I c;
    public k d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0}, l = {62}, m = "tokenStatus", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5662a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return w.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0, 0, 1, 1, 1}, l = {95, 98}, m = "updateCache", n = {"this", "bidTokenComponents", "this", "bidTokenComponents", "newToken"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5663a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return w.this.a(null, this);
        }
    }

    public w(com.moloco.sdk.internal.bidtoken.b bidTokenParser, I timeProviderService) {
        Intrinsics.checkNotNullParameter(bidTokenParser, "bidTokenParser");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.b = bidTokenParser;
        this.c = timeProviderService;
        this.d = new k("", "", e.a());
    }

    public static /* synthetic */ void d() {
    }

    public final void a(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.d = kVar;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public void b() {
        this.d = new k("", "", e.a());
    }

    public final k c() {
        return this.d;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public k a() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Continuation<? super B> continuation) {
        b bVar;
        int i2;
        w wVar;
        com.moloco.sdk.internal.v vVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i3 = bVar.d;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bVar.d = i3 - Integer.MIN_VALUE;
                Object obj = bVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = bVar.d;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (a().d().length() == 0) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "] cached bidToken is empty, needs refresh", null, false, 12, null);
                        return B.f5625a;
                    }
                    com.moloco.sdk.internal.bidtoken.b bVar2 = this.b;
                    String d = a().d();
                    bVar.f5662a = this;
                    bVar.d = 1;
                    obj = bVar2.a(d, bVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    wVar = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wVar = (w) bVar.f5662a;
                    ResultKt.throwOnFailure(obj);
                }
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.a)) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "] Failed to parse cached token for expiration, needs refresh", null, false, 12, null);
                    return B.f5625a;
                }
                if (vVar instanceof v.b) {
                    com.moloco.sdk.internal.bidtoken.a aVar = (com.moloco.sdk.internal.bidtoken.a) ((v.b) vVar).a();
                    long a2 = wVar.c.a();
                    if (x.a(aVar, a2)) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "] Bid token expired, needs refresh", null, false, 12, null);
                        return B.f5625a;
                    }
                    if (x.b(aVar, a2)) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "] Bid token is near expiry. It will expire soon", null, false, 12, null);
                        return B.b;
                    }
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    MolocoLogger.info$default(molocoLogger, g, "[Thread: " + Thread.currentThread().getName() + "] Bid token has not expired", null, false, 12, null);
                    MolocoLogger.info$default(molocoLogger, g, "[Thread: " + Thread.currentThread().getName() + "] Bid token doesn't need refresh", null, false, 12, null);
                    return B.c;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = bVar.d;
        if (i2 != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(k kVar, Continuation<? super Unit> continuation) {
        c cVar;
        int i2;
        w wVar;
        com.moloco.sdk.internal.v vVar;
        k kVar2;
        com.moloco.sdk.internal.bidtoken.a aVar;
        w wVar2;
        com.moloco.sdk.internal.v vVar2;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i3 = cVar.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                cVar.f = i3 - Integer.MIN_VALUE;
                Object obj = cVar.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = cVar.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, checking for new token expiry");
                    if (Intrinsics.areEqual(this.d.d(), "")) {
                        this.d = kVar;
                        a("[Thread: " + Thread.currentThread().getName() + "] Updated cache with new bidToken as existing token was empty");
                        return Unit.INSTANCE;
                    }
                    com.moloco.sdk.internal.bidtoken.b bVar = this.b;
                    String d = kVar.d();
                    cVar.f5663a = this;
                    cVar.b = kVar;
                    cVar.f = 1;
                    obj = bVar.a(d, cVar);
                    if (obj != coroutine_suspended) {
                        wVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (com.moloco.sdk.internal.bidtoken.a) cVar.c;
                    kVar2 = (k) cVar.b;
                    wVar2 = (w) cVar.f5663a;
                    ResultKt.throwOnFailure(obj);
                    vVar2 = (com.moloco.sdk.internal.v) obj;
                    if (!(vVar2 instanceof v.b)) {
                        if (aVar.a() > ((com.moloco.sdk.internal.bidtoken.a) ((v.b) vVar2).a()).a()) {
                            wVar2.d = kVar2;
                            wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Updated cache with new bidToken");
                        } else {
                            wVar2.a("[Thread: " + Thread.currentThread().getName() + "] New token's expiration is not greater than the existing token's expiration. Cache not updated.");
                        }
                    } else {
                        wVar2.d = kVar2;
                        wVar2.a("[Thread: " + Thread.currentThread().getName() + "] Current token parsing failed. Updated cache with new bidToken");
                    }
                    return Unit.INSTANCE;
                }
                kVar = (k) cVar.b;
                wVar = (w) cVar.f5663a;
                ResultKt.throwOnFailure(obj);
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.b)) {
                    com.moloco.sdk.internal.bidtoken.a aVar2 = (com.moloco.sdk.internal.bidtoken.a) ((v.b) vVar).a();
                    com.moloco.sdk.internal.bidtoken.b bVar2 = wVar.b;
                    String d2 = wVar.d.d();
                    cVar.f5663a = wVar;
                    cVar.b = kVar;
                    cVar.c = aVar2;
                    cVar.f = 2;
                    Object a2 = bVar2.a(d2, cVar);
                    if (a2 != coroutine_suspended) {
                        kVar2 = kVar;
                        aVar = aVar2;
                        obj = a2;
                        wVar2 = wVar;
                        vVar2 = (com.moloco.sdk.internal.v) obj;
                        if (!(vVar2 instanceof v.b)) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                wVar.a("[Thread: " + Thread.currentThread().getName() + "] New token parsing failed. Cache not updated.");
                return Unit.INSTANCE;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = cVar.f;
        if (i2 != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.b)) {
        }
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, false, 4, null);
    }
}
