package com.moloco.sdk.internal.publisher.nativead;

import android.content.Context;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ortb.model.r;
import com.moloco.sdk.internal.publisher.C3427a;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.o;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.s;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.K;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* loaded from: classes6.dex */
public final class c {
    public static final a l = new a(null);
    public static final int m = 8;
    public static final String n = "NativeAdLoader";

    /* renamed from: a, reason: collision with root package name */
    public final Context f5531a;
    public final String b;
    public final o c;
    public final com.moloco.sdk.internal.publisher.nativead.parser.a d;
    public final C3427a e;
    public final MetricsRecorder f;
    public final I g;
    public final K h;
    public final AdFormatType i;
    public final TimerEvent j;
    public final DispatcherProvider k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b {
        public static final int d = 8;

        /* renamed from: a, reason: collision with root package name */
        public final com.moloco.sdk.internal.ortb.model.c f5532a;
        public final com.moloco.sdk.internal.publisher.nativead.model.b b;
        public final com.moloco.sdk.internal.publisher.nativead.model.d c;

        public b(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            this.f5532a = bid;
            this.b = ortbResponse;
            this.c = preparedAssets;
        }

        public final com.moloco.sdk.internal.ortb.model.c a() {
            return this.f5532a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b b() {
            return this.b;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d c() {
            return this.c;
        }

        public final com.moloco.sdk.internal.ortb.model.c d() {
            return this.f5532a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f5532a, bVar.f5532a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d f() {
            return this.c;
        }

        public int hashCode() {
            return (((this.f5532a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "LoadedNativeAd(bid=" + this.f5532a + ", ortbResponse=" + this.b + ", preparedAssets=" + this.c + ')';
        }

        public final b a(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            return new b(bid, ortbResponse, preparedAssets);
        }

        public static /* synthetic */ b a(b bVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.internal.publisher.nativead.model.b bVar2, com.moloco.sdk.internal.publisher.nativead.model.d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = bVar.f5532a;
            }
            if ((i & 2) != 0) {
                bVar2 = bVar.b;
            }
            if ((i & 4) != 0) {
                dVar = bVar.c;
            }
            return bVar.a(cVar, bVar2, dVar);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0}, l = {251}, m = "fetchAssets-8Mi8wO0", n = {"this", "adType", "nativeAdPrepareTime"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.moloco.sdk.internal.publisher.nativead.c$c, reason: collision with other inner class name */
    public static final class C0445c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5533a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public C0445c(Continuation<? super C0445c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.a((com.moloco.sdk.internal.publisher.nativead.model.b) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$fireAdLoadFailedEventOnUiThread$2", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5534a;
        public final /* synthetic */ x b;
        public final /* synthetic */ s c;
        public final /* synthetic */ r d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar, s sVar, r rVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = xVar;
            this.c = sVar;
            this.d = rVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5534a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1, 2}, l = {201, Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE}, m = "handleAssetsFetching-yxL6bBk", n = {"this", "sdkEvents", "adLoadTracker", "timeoutError", "error"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0"})
    public static final class e extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5535a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object a2 = c.this.a((r) null, (com.moloco.sdk.internal.publisher.nativead.model.b) null, (x) null, 0L, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$handleAssetsFetching$result$1", f = "NativeAdLoader.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5536a;
        public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.b c;
        public final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.moloco.sdk.internal.publisher.nativead.model.b bVar, long j, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = bVar;
            this.d = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5536a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            c cVar = c.this;
            com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
            long j = this.d;
            this.f5536a = 1;
            Object a2 = cVar.a(bVar, j, this);
            return a2 == coroutine_suspended ? coroutine_suspended : a2;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1}, l = {155, 171}, m = "handleBidParsing-BWLJW6A", n = {"this", "acmLoadTimerEvent", "adLoadTracker", "it"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class g extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5537a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object a2 = c.this.a((String) null, (TimerEvent) null, (x) null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0}, l = {187}, m = "handleOrtbParsing-BWLJW6A", n = {"result"}, s = {"L$0"})
    public static final class h extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5538a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object a2 = c.this.a((String) null, (r) null, (x) null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {103}, m = "load-BWLJW6A", n = {}, s = {})
    public static final class i extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5539a;
        public int c;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5539a = obj;
            this.c |= Integer.MIN_VALUE;
            Object b = c.this.b(null, null, null, this);
            return b == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b : Result.m10240boximpl(b);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2", f = "NativeAdLoader.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 138, 144}, m = "invokeSuspend", n = {"adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "ortbResponse"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "L$1"})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public long f5540a;
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ TimerEvent f;
        public final /* synthetic */ String g;
        public final /* synthetic */ x h;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2$2", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5541a;
            public final /* synthetic */ x b;
            public final /* synthetic */ c c;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x xVar, c cVar, com.moloco.sdk.internal.ortb.model.c cVar2, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = xVar;
                this.c = cVar;
                this.d = cVar2;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5541a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.a(MolocoAdKt.createAdInfo(this.c.b, Boxing.boxFloat(this.d.g())), this.e, this.d.e().i());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TimerEvent timerEvent, String str, x xVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.f = timerEvent;
            this.g = str;
            this.h = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<b>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new j(this.f, this.g, this.h, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0159  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object a2;
            long j;
            com.moloco.sdk.internal.ortb.model.c cVar;
            long j2;
            Object a3;
            long j3;
            Throwable m10244exceptionOrNullimpl;
            Object a4;
            com.moloco.sdk.internal.publisher.nativead.model.b bVar;
            Throwable m10244exceptionOrNullimpl2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object a5 = c.this.h.a();
                x xVar = this.h;
                c cVar2 = c.this;
                Throwable m10244exceptionOrNullimpl3 = Result.m10244exceptionOrNullimpl(a5);
                if (m10244exceptionOrNullimpl3 != null) {
                    MolocoLogger.INSTANCE.error(c.n, "WebView Error: " + m10244exceptionOrNullimpl3.getMessage(), m10244exceptionOrNullimpl3, true);
                    xVar.a(t.a(cVar2.b, MolocoAdError.ErrorType.AD_LOAD_WEBVIEW_FAILED, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.g), (r) null);
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl3)));
                }
                long a6 = c.this.g.a();
                this.f.startTimer();
                c.this.f.recordTimerEvent(c.this.j);
                MetricsRecorder metricsRecorder = c.this.f;
                CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.j.c());
                String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
                String lowerCase = c.this.i.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                metricsRecorder.recordCountEvent(countEvent.withTag(c, lowerCase));
                c cVar3 = c.this;
                String str = this.g;
                TimerEvent timerEvent = this.f;
                x xVar2 = this.h;
                this.f5540a = a6;
                this.d = 1;
                a2 = cVar3.a(str, timerEvent, xVar2, this);
                if (a2 != coroutine_suspended) {
                    j = a6;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    j2 = this.f5540a;
                    cVar = (com.moloco.sdk.internal.ortb.model.c) this.b;
                    ResultKt.throwOnFailure(obj);
                    c cVar4 = c.this;
                    String a7 = cVar.a();
                    r i2 = cVar.e().i();
                    x xVar3 = this.h;
                    this.b = cVar;
                    this.f5540a = j2;
                    this.d = 3;
                    a3 = cVar4.a(a7, i2, xVar3, this);
                    if (a3 != coroutine_suspended) {
                        j3 = j2;
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a3);
                        if (m10244exceptionOrNullimpl == null) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bVar = (com.moloco.sdk.internal.publisher.nativead.model.b) this.c;
                    cVar = (com.moloco.sdk.internal.ortb.model.c) this.b;
                    ResultKt.throwOnFailure(obj);
                    a4 = ((Result) obj).getValue();
                    m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(a4);
                    if (m10244exceptionOrNullimpl2 != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m10240boximpl(Result.m10241constructorimpl(new b(cVar, bVar, (com.moloco.sdk.internal.publisher.nativead.model.d) a4)));
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl2)));
                }
                long j4 = this.f5540a;
                cVar = (com.moloco.sdk.internal.ortb.model.c) this.b;
                ResultKt.throwOnFailure(obj);
                a3 = ((Result) obj).getValue();
                j3 = j4;
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a3);
                if (m10244exceptionOrNullimpl == null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl)));
                }
                com.moloco.sdk.internal.publisher.nativead.model.b bVar2 = (com.moloco.sdk.internal.publisher.nativead.model.b) a3;
                c cVar5 = c.this;
                r i3 = cVar.e().i();
                x xVar4 = this.h;
                this.b = cVar;
                this.c = bVar2;
                this.d = 4;
                a4 = cVar5.a(i3, bVar2, xVar4, j3, this);
                if (a4 != coroutine_suspended) {
                    bVar = bVar2;
                    m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(a4);
                    if (m10244exceptionOrNullimpl2 != null) {
                    }
                }
                return coroutine_suspended;
            }
            long j5 = this.f5540a;
            ResultKt.throwOnFailure(obj);
            a2 = ((Result) obj).getValue();
            j = j5;
            Throwable m10244exceptionOrNullimpl4 = Result.m10244exceptionOrNullimpl(a2);
            if (m10244exceptionOrNullimpl4 != null) {
                Result.Companion companion5 = Result.INSTANCE;
                return Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl4)));
            }
            com.moloco.sdk.internal.ortb.model.c cVar6 = (com.moloco.sdk.internal.ortb.model.c) a2;
            CoroutineContext main = c.this.k.getMain();
            a aVar = new a(this.h, c.this, cVar6, j, null);
            this.b = cVar6;
            this.f5540a = j;
            this.d = 2;
            if (BuildersKt.withContext(main, aVar, this) != coroutine_suspended) {
                cVar = cVar6;
                j2 = j;
                c cVar42 = c.this;
                String a72 = cVar.a();
                r i22 = cVar.e().i();
                x xVar32 = this.h;
                this.b = cVar;
                this.f5540a = j2;
                this.d = 3;
                a3 = cVar42.a(a72, i22, xVar32, this);
                if (a3 != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {298}, m = "prepareAssets-8Mi8wO0", n = {}, s = {})
    public static final class k extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f5542a;
        public int c;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5542a = obj;
            this.c |= Integer.MIN_VALUE;
            return c.this.a((List<? extends b.a>) null, 0L, this);
        }
    }

    public c(Context context, String adUnitId, o bidLoader, com.moloco.sdk.internal.publisher.nativead.parser.a ortbResponseParser, C3427a createLoadTimeoutManager, MetricsRecorder metricsRecorder, I timeProvider, K webViewChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bidLoader, "bidLoader");
        Intrinsics.checkNotNullParameter(ortbResponseParser, "ortbResponseParser");
        Intrinsics.checkNotNullParameter(createLoadTimeoutManager, "createLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(webViewChecker, "webViewChecker");
        this.f5531a = context;
        this.b = adUnitId;
        this.c = bidLoader;
        this.d = ortbResponseParser;
        this.e = createLoadTimeoutManager;
        this.f = metricsRecorder;
        this.g = timeProvider;
        this.h = webViewChecker;
        AdFormatType adFormatType = AdFormatType.NATIVE;
        this.i = adFormatType;
        TimerEvent startTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.q.c());
        String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.j = startTimerEvent.withTag(c, lowerCase);
        this.k = com.moloco.sdk.internal.scheduling.b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(String str, TimerEvent timerEvent, x xVar, Continuation<? super Result<b>> continuation) {
        i iVar;
        int i2;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i3 = iVar.c;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                iVar.c = i3 - Integer.MIN_VALUE;
                Object obj = iVar.f5539a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = iVar.c;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext coroutineContext = this.k.getDefault();
                    j jVar = new j(timerEvent, str, xVar, null);
                    iVar.c = 1;
                    obj = BuildersKt.withContext(coroutineContext, jVar, iVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        iVar = new i(continuation);
        Object obj2 = iVar.f5539a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = iVar.c;
        if (i2 != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, TimerEvent timerEvent, x xVar, Continuation<? super Result<com.moloco.sdk.internal.ortb.model.c>> continuation) {
        g gVar;
        int i2;
        c cVar;
        v vVar;
        v vVar2;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i3 = gVar.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                gVar.f = i3 - Integer.MIN_VALUE;
                Object obj = gVar.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = gVar.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    o oVar = this.c;
                    String str2 = this.b;
                    gVar.f5537a = this;
                    gVar.b = timerEvent;
                    gVar.c = xVar;
                    gVar.f = 1;
                    obj = oVar.a(str2, str, gVar);
                    if (obj != coroutine_suspended) {
                        cVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    vVar2 = (v) gVar.f5537a;
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(((s) ((v.a) vVar2).a()).toString())));
                }
                xVar = (x) gVar.c;
                timerEvent = (TimerEvent) gVar.b;
                cVar = (c) gVar.f5537a;
                ResultKt.throwOnFailure(obj);
                vVar = (v) obj;
                if (!(vVar instanceof v.a)) {
                    MetricsRecorder metricsRecorder = cVar.f;
                    TimerEvent withTag = timerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE);
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
                    String c = cVar2.c();
                    MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
                    TimerEvent withTag2 = withTag.withTag(c, String.valueOf(errorType.getErrorCode()));
                    com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.c;
                    String c2 = cVar3.c();
                    String name = cVar.i.name();
                    Locale locale = Locale.ROOT;
                    String lowerCase = name.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    metricsRecorder.recordTimerEvent(withTag2.withTag(c2, lowerCase));
                    MetricsRecorder metricsRecorder2 = cVar.f;
                    CountEvent withTag3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.l.c()).withTag(cVar2.c(), String.valueOf(errorType.getErrorCode()));
                    String c3 = cVar3.c();
                    String lowerCase2 = cVar.i.name().toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    metricsRecorder2.recordCountEvent(withTag3.withTag(c3, lowerCase2));
                    s sVar = (s) ((v.a) vVar).a();
                    gVar.f5537a = vVar;
                    gVar.b = null;
                    gVar.c = null;
                    gVar.f = 2;
                    if (cVar.a(xVar, sVar, (r) null, gVar) != coroutine_suspended) {
                        vVar2 = vVar;
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(((s) ((v.a) vVar2).a()).toString())));
                    }
                    return coroutine_suspended;
                }
                if (!(vVar instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m10241constructorimpl(((v.b) vVar).a());
            }
        }
        gVar = new g(continuation);
        Object obj2 = gVar.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = gVar.f;
        if (i2 != 0) {
        }
        vVar = (v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, r rVar, x xVar, Continuation<? super Result<com.moloco.sdk.internal.publisher.nativead.model.b>> continuation) {
        h hVar;
        int i2;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i3 = hVar.e;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                hVar.e = i3 - Integer.MIN_VALUE;
                Object obj = hVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = hVar.e;
                if (i2 == 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj2 = hVar.f5538a;
                    ResultKt.throwOnFailure(obj);
                    return obj2;
                }
                ResultKt.throwOnFailure(obj);
                Object a2 = this.d.a(str);
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a2);
                if (m10244exceptionOrNullimpl != null) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, n, "handleOrtbParsing", m10244exceptionOrNullimpl, false, 8, null);
                    s a3 = t.a(this.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.f5836a);
                    hVar.f5538a = a2;
                    hVar.b = a2;
                    hVar.e = 1;
                    if (a(xVar, a3, rVar, hVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return a2;
            }
        }
        hVar = new h(continuation);
        Object obj3 = hVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = hVar.e;
        if (i2 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(r rVar, com.moloco.sdk.internal.publisher.nativead.model.b bVar, x xVar, long j2, Continuation<? super Result<com.moloco.sdk.internal.publisher.nativead.model.d>> continuation) {
        e eVar;
        int i2;
        r rVar2;
        x xVar2;
        c cVar;
        v vVar;
        s sVar;
        s sVar2;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i3 = eVar.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                eVar.f = i3 - Integer.MIN_VALUE;
                e eVar2 = eVar;
                Object obj = eVar2.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = eVar2.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, n, "nativeAd load has " + j2 + " to load the ad", null, false, 12, null);
                    long a2 = this.e.a(j2);
                    f fVar = new f(bVar, a2, null);
                    eVar2.f5535a = this;
                    rVar2 = rVar;
                    eVar2.b = rVar2;
                    xVar2 = xVar;
                    eVar2.c = xVar2;
                    eVar2.f = 1;
                    obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(a2, fVar, eVar2);
                    if (obj != coroutine_suspended) {
                        cVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        sVar2 = (s) eVar2.f5535a;
                        ResultKt.throwOnFailure(obj);
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(sVar2.toString())));
                    }
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sVar = (s) eVar2.f5535a;
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(sVar.toString())));
                }
                x xVar3 = (x) eVar2.c;
                r rVar3 = (r) eVar2.b;
                cVar = (c) eVar2.f5535a;
                ResultKt.throwOnFailure(obj);
                xVar2 = xVar3;
                rVar2 = rVar3;
                vVar = (v) obj;
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, n, "Handling native ad load result: " + vVar, null, false, 12, null);
                if (vVar != null) {
                    MolocoLogger.warn$default(molocoLogger, n, "Native ad load timeout", null, false, 12, null);
                    s a3 = t.a(cVar.b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.d);
                    eVar2.f5535a = a3;
                    eVar2.b = null;
                    eVar2.c = null;
                    eVar2.f = 2;
                    if (cVar.a(xVar2, a3, rVar2, eVar2) != coroutine_suspended) {
                        sVar2 = a3;
                        Result.Companion companion3 = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(sVar2.toString())));
                    }
                } else if (vVar instanceof v.a) {
                    s a4 = t.a(cVar.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
                    eVar2.f5535a = a4;
                    eVar2.b = null;
                    eVar2.c = null;
                    eVar2.f = 3;
                    if (cVar.a(xVar2, a4, rVar2, eVar2) != coroutine_suspended) {
                        sVar = a4;
                        Result.Companion companion22 = Result.INSTANCE;
                        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception(sVar.toString())));
                    }
                } else {
                    if (vVar instanceof v.b) {
                        Result.Companion companion4 = Result.INSTANCE;
                        return Result.m10241constructorimpl(((v.b) vVar).a());
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return coroutine_suspended;
            }
        }
        eVar = new e(continuation);
        e eVar22 = eVar;
        Object obj2 = eVar22.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = eVar22.f;
        if (i2 != 0) {
        }
        vVar = (v) obj2;
        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger2, n, "Handling native ad load result: " + vVar, null, false, 12, null);
        if (vVar != null) {
        }
        return coroutine_suspended2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(com.moloco.sdk.internal.publisher.nativead.model.b bVar, long j2, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        C0445c c0445c;
        int i2;
        c cVar;
        String str;
        TimerEvent timerEvent;
        v vVar;
        if (continuation instanceof C0445c) {
            c0445c = (C0445c) continuation;
            int i3 = c0445c.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c0445c.f = i3 - Integer.MIN_VALUE;
                Object obj = c0445c.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = c0445c.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long duration = DurationKt.toDuration(RangesKt.coerceAtLeast(Duration.m11585getInWholeMillisecondsimpl(j2) - (this.g.a() - this.g.a()), 0L), DurationUnit.MILLISECONDS);
                    List<b.a> a2 = bVar.a();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : a2) {
                        if (obj2 instanceof b.a.d) {
                            arrayList.add(obj2);
                        }
                    }
                    String str2 = !arrayList.isEmpty() ? "video" : "image";
                    TimerEvent startTimerEvent = this.f.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.k.c());
                    MetricsRecorder metricsRecorder = this.f;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.m.c());
                    String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
                    String lowerCase = str2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    metricsRecorder.recordCountEvent(countEvent.withTag(c, lowerCase));
                    List<b.a> a3 = bVar.a();
                    c0445c.f5533a = this;
                    c0445c.b = str2;
                    c0445c.c = startTimerEvent;
                    c0445c.f = 1;
                    Object a4 = a(a3, duration, c0445c);
                    if (a4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cVar = this;
                    str = str2;
                    obj = a4;
                    timerEvent = startTimerEvent;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    timerEvent = (TimerEvent) c0445c.c;
                    str = (String) c0445c.b;
                    cVar = (c) c0445c.f5533a;
                    ResultKt.throwOnFailure(obj);
                }
                vVar = (v) obj;
                if (!(vVar instanceof v.a)) {
                    v.a aVar = (v.a) vVar;
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, n, "NativeAd load failed: " + ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b(), null, false, 12, null);
                    MetricsRecorder metricsRecorder2 = cVar.f;
                    CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.n.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.d;
                    CountEvent withTag = countEvent2.withTag(cVar2.c(), AnalyticsConstants.EVENT_FAILURE);
                    com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.c;
                    String c2 = cVar3.c();
                    Locale locale = Locale.ROOT;
                    String lowerCase2 = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    CountEvent withTag2 = withTag.withTag(c2, lowerCase2);
                    com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.b;
                    metricsRecorder2.recordCountEvent(withTag2.withTag(cVar4.c(), ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b().a()).withTag(AnalyticsConstants.ASSET_ID, String.valueOf(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).a())));
                    MetricsRecorder metricsRecorder3 = cVar.f;
                    TimerEvent withTag3 = timerEvent.withTag(cVar2.c(), AnalyticsConstants.EVENT_FAILURE);
                    String c3 = cVar3.c();
                    String lowerCase3 = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    metricsRecorder3.recordTimerEvent(withTag3.withTag(c3, lowerCase3).withTag(cVar4.c(), ((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b().a()).withTag(AnalyticsConstants.ASSET_ID, String.valueOf(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).a())));
                    return new v.a(((com.moloco.sdk.internal.publisher.nativead.parser.b) aVar.a()).b());
                }
                if (vVar instanceof v.b) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, n, "NativeAd load successfully parsed and loaded all assets", null, false, 12, null);
                    MetricsRecorder metricsRecorder4 = cVar.f;
                    CountEvent countEvent3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.n.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.d;
                    CountEvent withTag4 = countEvent3.withTag(cVar5.c(), "success");
                    com.moloco.sdk.internal.client_metrics_data.c cVar6 = com.moloco.sdk.internal.client_metrics_data.c.c;
                    String c4 = cVar6.c();
                    Locale locale2 = Locale.ROOT;
                    String lowerCase4 = str.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    metricsRecorder4.recordCountEvent(withTag4.withTag(c4, lowerCase4));
                    MetricsRecorder metricsRecorder5 = cVar.f;
                    TimerEvent withTag5 = timerEvent.withTag(cVar5.c(), "success");
                    String c5 = cVar6.c();
                    String lowerCase5 = str.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    metricsRecorder5.recordTimerEvent(withTag5.withTag(c5, lowerCase5));
                    return new v.b(((v.b) vVar).a());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        c0445c = new C0445c(continuation);
        Object obj3 = c0445c.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = c0445c.f;
        if (i2 != 0) {
        }
        vVar = (v) obj3;
        if (!(vVar instanceof v.a)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(List<? extends b.a> list, long j2, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> continuation) {
        k kVar;
        int i2;
        v vVar;
        if (continuation instanceof k) {
            kVar = (k) continuation;
            int i3 = kVar.c;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                kVar.c = i3 - Integer.MIN_VALUE;
                Object obj = kVar.f5542a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = kVar.c;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Context context = this.f5531a;
                    kVar.c = 1;
                    obj = com.moloco.sdk.internal.publisher.nativead.parser.c.a(context, list, j2, kVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                vVar = (v) obj;
                if (!(vVar instanceof v.b)) {
                    return new v.b(((v.b) vVar).a());
                }
                if (vVar instanceof v.a) {
                    v.a aVar = (v.a) vVar;
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, n, "NativeAd prepareAssets failed", (Throwable) aVar.a(), false, 8, null);
                    return new v.a(aVar.a());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        kVar = new k(continuation);
        Object obj2 = kVar.f5542a;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = kVar.c;
        if (i2 != 0) {
        }
        vVar = (v) obj2;
        if (!(vVar instanceof v.b)) {
        }
    }

    public final Object a(x xVar, s sVar, r rVar, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.k.getMain(), new d(xVar, sVar, rVar, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
