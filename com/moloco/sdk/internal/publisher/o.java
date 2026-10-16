package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o {
    public static final a c = new a(null);
    public static final int d = 0;
    public static final String e = "BidLoader";

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.a f5574a;
    public final p b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0, 0}, l = {33, 46}, m = "parse", n = {"this", "adUnitId"}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5575a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return o.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {71}, m = "parseBidResponse", n = {"adUnitId"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5576a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {58}, m = "processBidResponse$moloco_sdk_release", n = {"bidResponseJson"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5577a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.a(null, this);
        }
    }

    public o(com.moloco.sdk.internal.ortb.a bidResponseParser, p bidProcessor) {
        Intrinsics.checkNotNullParameter(bidResponseParser, "bidResponseParser");
        Intrinsics.checkNotNullParameter(bidProcessor, "bidProcessor");
        this.f5574a = bidResponseParser;
        this.b = bidProcessor;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> continuation) {
        c cVar;
        int i;
        com.moloco.sdk.internal.v vVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.d = i2 - Integer.MIN_VALUE;
                Object obj = cVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.ortb.a aVar = this.f5574a;
                    cVar.f5576a = str2;
                    cVar.d = 1;
                    obj = aVar.a(str, cVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) cVar.f5576a;
                    ResultKt.throwOnFailure(obj);
                }
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.a)) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "parseBidResponse failed to parse BID json string.", (Throwable) ((v.a) vVar).a(), false, 8, null);
                    return new v.a(com.moloco.sdk.internal.t.a(str2, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.c));
                }
                if (vVar instanceof v.b) {
                    return new v.b(((com.moloco.sdk.internal.ortb.model.e) ((v.b) vVar).a()).b().get(0).b().get(0));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.d;
        if (i != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, String str2, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> continuation) {
        b bVar;
        int i;
        o oVar;
        String str3;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.e = i2 - Integer.MIN_VALUE;
                Object obj = bVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.debug$default(MolocoLogger.INSTANCE, e, "parse() called with bidResponseJson: " + str2, false, 4, null);
                    bVar.f5575a = this;
                    bVar.b = str;
                    bVar.e = 1;
                    obj = a(str2, bVar);
                    if (obj != coroutine_suspended) {
                        oVar = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                str = (String) bVar.b;
                oVar = (o) bVar.f5575a;
                ResultKt.throwOnFailure(obj);
                str3 = (String) obj;
                if (str3 != null) {
                    return new v.a(com.moloco.sdk.internal.t.a(str, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.b));
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, e, "Processed the bidResponse, proceeding with parsing it.", null, false, 12, null);
                bVar.f5575a = null;
                bVar.b = null;
                bVar.e = 2;
                Object b2 = oVar.b(str3, str, bVar);
                return b2 == coroutine_suspended ? coroutine_suspended : b2;
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.e;
        if (i != 0) {
        }
        str3 = (String) obj2;
        if (str3 != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation<? super String> continuation) {
        d dVar;
        int i;
        String str2;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.d = i2 - Integer.MIN_VALUE;
                Object obj = dVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    p pVar = this.b;
                    dVar.f5577a = str;
                    dVar.d = 1;
                    obj = pVar.a(str, dVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) dVar.f5577a;
                    ResultKt.throwOnFailure(obj);
                }
                str2 = (String) obj;
                if (str2 != null) {
                    return str;
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, e, "Found no pre-preprocessor for the current mediation. Returning the original bid response.", null, false, 12, null);
                return str2;
            }
        }
        dVar = new d(continuation);
        Object obj2 = dVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dVar.d;
        if (i != 0) {
        }
        str2 = (String) obj2;
        if (str2 != null) {
        }
    }
}
