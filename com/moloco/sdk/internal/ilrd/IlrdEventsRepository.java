package com.moloco.sdk.internal.ilrd;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.moloco.sdk.IlrdRequest;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.services.AbstractC3439c;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3440d;
import com.moloco.sdk.internal.services.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import io.ktor.http.ContentType;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\b\u0001\u0018\u0000 U2\u00020\u0001:\u0001#B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u001eH\u0001¢\u0006\u0004\b)\u0010 J\u000f\u0010*\u001a\u00020\u001eH\u0001¢\u0006\u0004\b*\u0010 J\u000f\u0010+\u001a\u00020\u001eH\u0001¢\u0006\u0004\b+\u0010 J\u000f\u0010,\u001a\u00020\u001eH\u0001¢\u0006\u0004\b,\u0010 J\u000f\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0010\u0010*\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b*\u00100J\u001f\u0010*\u001a\n 2*\u0004\u0018\u000101012\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b*\u00103J\u000f\u00104\u001a\u00020\u001eH\u0002¢\u0006\u0004\b4\u0010 J\u000f\u00105\u001a\u00020\u001eH\u0002¢\u0006\u0004\b5\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00106R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u00107R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010;R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010@R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010AR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00107R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u00107R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010BR\u0017\u0010\u0019\u001a\u00020\u00188G¢\u0006\f\n\u0004\b,\u0010C\u001a\u0004\b>\u0010DR\u0017\u0010\u001a\u001a\u00020\u00188G¢\u0006\f\n\u0004\b)\u0010C\u001a\u0004\b?\u0010DR\u0017\u0010\u001b\u001a\u00020\u00188G¢\u0006\f\n\u0004\bE\u0010C\u001a\u0004\b:\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR(\u0010O\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010J8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\b<\u0010NR&\u0010T\u001a\b\u0012\u0004\u0012\u0002010P8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bQ\u0010R\u0012\u0004\b8\u0010 \u001a\u0004\b#\u0010S¨\u0006V"}, d2 = {"Lcom/moloco/sdk/internal/ilrd/IlrdEventsRepository;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "url", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;", "persistentHttpRequest", "Lkotlin/time/Duration;", "sessionExp", "", "maxBatchSize", "uploadInterval", "sessionMaxLength", "Lcom/moloco/sdk/internal/services/I;", "timeProvider", "Landroidx/lifecycle/Lifecycle;", "processLifeycle", "Lcom/moloco/sdk/internal/services/d;", "advertisingIdService", "pubId", "appId", "Lcom/moloco/sdk/internal/services/w;", "dataStoreService", "Lcom/moloco/sdk/internal/ilrd/d;", "sessionExpiryScheduler", "sessionMaxLengthScheduler", "scheduledUploadScheduler", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;JIJJLcom/moloco/sdk/internal/services/I;Landroidx/lifecycle/Lifecycle;Lcom/moloco/sdk/internal/services/d;Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/services/w;Lcom/moloco/sdk/internal/ilrd/d;Lcom/moloco/sdk/internal/ilrd/d;Lcom/moloco/sdk/internal/ilrd/d;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "i", "()V", "Lcom/moloco/sdk/internal/ilrd/c$a;", "ilrdData", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/moloco/sdk/internal/ilrd/c$a;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", C3040d4.h.t0, "(Landroidx/lifecycle/LifecycleOwner;)V", D5.q, "a", CampaignEx.JSON_KEY_AD_K, "m", "", "h", "()Z", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/moloco/sdk/IlrdRequest$ImpressionLevelRevenue;", "kotlin.jvm.PlatformType", "(Lcom/moloco/sdk/internal/ilrd/c$a;)Lcom/moloco/sdk/IlrdRequest$ImpressionLevelRevenue;", j.b, "l", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/String;", "c", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;", "d", "J", "e", "I", InneractiveMediationDefs.GENDER_FEMALE, "g", "Lcom/moloco/sdk/internal/services/I;", "Lcom/moloco/sdk/internal/services/d;", "Lcom/moloco/sdk/internal/services/w;", "Lcom/moloco/sdk/internal/ilrd/d;", "()Lcom/moloco/sdk/internal/ilrd/d;", "o", "Lkotlinx/coroutines/sync/Mutex;", "p", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lcom/moloco/sdk/internal/ilrd/a;", "value", CampaignEx.JSON_KEY_AD_Q, "Lcom/moloco/sdk/internal/ilrd/a;", "()Lcom/moloco/sdk/internal/ilrd/a;", "session", "", "r", "Ljava/util/List;", "()Ljava/util/List;", "events", "s", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class IlrdEventsRepository implements DefaultLifecycleObserver {

    /* renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int t = 8;
    public static final String u = "IlrdEventsRepository";
    public static final String v = "ilrd_session_store";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CoroutineScope scope;

    /* renamed from: b, reason: from kotlin metadata */
    public final String url;

    /* renamed from: c, reason: from kotlin metadata */
    public final i persistentHttpRequest;

    /* renamed from: d, reason: from kotlin metadata */
    public final long sessionExp;

    /* renamed from: e, reason: from kotlin metadata */
    public final int maxBatchSize;

    /* renamed from: f, reason: from kotlin metadata */
    public final long uploadInterval;

    /* renamed from: g, reason: from kotlin metadata */
    public final long sessionMaxLength;

    /* renamed from: h, reason: from kotlin metadata */
    public final I timeProvider;

    /* renamed from: i, reason: from kotlin metadata */
    public final InterfaceC3440d advertisingIdService;

    /* renamed from: j, reason: from kotlin metadata */
    public final String pubId;

    /* renamed from: k, reason: from kotlin metadata */
    public final String appId;

    /* renamed from: l, reason: from kotlin metadata */
    public final w dataStoreService;

    /* renamed from: m, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d sessionExpiryScheduler;

    /* renamed from: n, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d sessionMaxLengthScheduler;

    /* renamed from: o, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d scheduledUploadScheduler;

    /* renamed from: p, reason: from kotlin metadata */
    public final Mutex mutex;

    /* renamed from: q, reason: from kotlin metadata */
    public com.moloco.sdk.internal.ilrd.a session;

    /* renamed from: r, reason: from kotlin metadata */
    public final List<IlrdRequest.ImpressionLevelRevenue> events;

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$1", f = "IlrdEventsRepository.kt", i = {0, 1}, l = {436, 113, 115}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5403a;
        public Object b;
        public int c;
        public final /* synthetic */ Lifecycle e;

        @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$1$2", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.internal.ilrd.IlrdEventsRepository$a$a, reason: collision with other inner class name */
        public static final class C0428a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5404a;
            public final /* synthetic */ Lifecycle b;
            public final /* synthetic */ IlrdEventsRepository c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0428a(Lifecycle lifecycle, IlrdEventsRepository ilrdEventsRepository, Continuation<? super C0428a> continuation) {
                super(2, continuation);
                this.b = lifecycle;
                this.c = ilrdEventsRepository;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0428a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0428a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5404a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.addObserver(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Lifecycle lifecycle, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = lifecycle;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new a(this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6) != r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            IlrdEventsRepository ilrdEventsRepository;
            Mutex mutex;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex3 = IlrdEventsRepository.this.mutex;
                    ilrdEventsRepository = IlrdEventsRepository.this;
                    this.f5403a = mutex3;
                    this.b = ilrdEventsRepository;
                    this.c = 1;
                    if (mutex3.lock(null, this) != coroutine_suspended) {
                        mutex = mutex3;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ilrdEventsRepository = (IlrdEventsRepository) this.b;
                    mutex = (Mutex) this.f5403a;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    mutex2 = (Mutex) this.f5403a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        CoroutineContext main = com.moloco.sdk.internal.scheduling.b.a().getMain();
                        C0428a c0428a = new C0428a(this.e, IlrdEventsRepository.this, null);
                        this.f5403a = null;
                        this.c = 3;
                    } catch (Throwable th) {
                        th = th;
                        mutex = mutex2;
                        mutex.unlock(null);
                        throw th;
                    }
                }
                this.f5403a = mutex;
                this.b = null;
                this.c = 2;
                if (ilrdEventsRepository.a(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    CoroutineContext main2 = com.moloco.sdk.internal.scheduling.b.a().getMain();
                    C0428a c0428a2 = new C0428a(this.e, IlrdEventsRepository.this, null);
                    this.f5403a = null;
                    this.c = 3;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* renamed from: com.moloco.sdk.internal.ilrd.IlrdEventsRepository$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a() {
        }

        public Companion() {
        }

        public final byte[] a(byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    Intrinsics.checkNotNullExpressionValue(byteArray, "use(...)");
                    return byteArray;
                } finally {
                }
            } finally {
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$onEvent$1", f = "IlrdEventsRepository.kt", i = {0}, l = {436}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5405a;
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ c.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c.a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new c(this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IlrdEventsRepository ilrdEventsRepository;
            Mutex mutex;
            c.a aVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = IlrdEventsRepository.this.mutex;
                ilrdEventsRepository = IlrdEventsRepository.this;
                c.a aVar2 = this.f;
                this.f5405a = mutex2;
                this.b = ilrdEventsRepository;
                this.c = aVar2;
                this.d = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                aVar = aVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (c.a) this.c;
                ilrdEventsRepository = (IlrdEventsRepository) this.b;
                mutex = (Mutex) this.f5405a;
                ResultKt.throwOnFailure(obj);
            }
            try {
                ilrdEventsRepository.a();
                ilrdEventsRepository.k();
                com.moloco.sdk.internal.ilrd.a session = ilrdEventsRepository.getSession();
                if (session != null) {
                    session.a(aVar);
                }
                IlrdRequest.ImpressionLevelRevenue a2 = ilrdEventsRepository.a(aVar);
                List<IlrdRequest.ImpressionLevelRevenue> b = ilrdEventsRepository.b();
                Intrinsics.checkNotNull(a2);
                b.add(a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, IlrdEventsRepository.u, "Event id " + a2.getEventId() + " added. Count: " + ilrdEventsRepository.b().size(), null, false, 12, null);
                if (ilrdEventsRepository.h()) {
                    ilrdEventsRepository.m();
                }
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$onPause$1", f = "IlrdEventsRepository.kt", i = {0, 1}, l = {436, 248}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5406a;
        public Object b;
        public int c;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new d(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
        
            if (r13.lock(null, r12) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            IlrdEventsRepository ilrdEventsRepository;
            IlrdEventsRepository ilrdEventsRepository2;
            Mutex mutex2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = IlrdEventsRepository.this.mutex;
                    ilrdEventsRepository = IlrdEventsRepository.this;
                    this.f5406a = mutex;
                    this.b = ilrdEventsRepository;
                    this.c = 1;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ilrdEventsRepository2 = (IlrdEventsRepository) this.b;
                        mutex2 = (Mutex) this.f5406a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            mutex = mutex2;
                            ilrdEventsRepository = ilrdEventsRepository2;
                            ilrdEventsRepository.m();
                            Unit unit = Unit.INSTANCE;
                            mutex.unlock(null);
                            return unit;
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            mutex2.unlock(null);
                            throw th3;
                        }
                    }
                    ilrdEventsRepository = (IlrdEventsRepository) this.b;
                    Mutex mutex3 = (Mutex) this.f5406a;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, IlrdEventsRepository.u, "onPause called, storing session and sending events", null, false, 12, null);
                com.moloco.sdk.internal.ilrd.a session = ilrdEventsRepository.getSession();
                if (session != null) {
                    String g = session.g();
                    w wVar = ilrdEventsRepository.dataStoreService;
                    this.f5406a = mutex;
                    this.b = ilrdEventsRepository;
                    this.c = 2;
                    if (wVar.a(IlrdEventsRepository.v, g, this) != coroutine_suspended) {
                        ilrdEventsRepository2 = ilrdEventsRepository;
                        mutex2 = mutex;
                        mutex = mutex2;
                        ilrdEventsRepository = ilrdEventsRepository2;
                    }
                    return coroutine_suspended;
                }
                ilrdEventsRepository.m();
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                return unit2;
            } catch (Throwable th4) {
                th = th4;
                mutex2 = mutex;
                Throwable th32 = th;
                mutex2.unlock(null);
                throw th32;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository", f = "IlrdEventsRepository.kt", i = {0, 1, 1}, l = {135, 136}, m = "restoreSavedSession", n = {"this", "this", "existingSession"}, s = {"L$0", "L$0", "L$1"})
    public static final class e extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5407a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return IlrdEventsRepository.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleMaxSessionLength$1", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5408a;

        public f(Continuation<? super f> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5408a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.internal.ilrd.a session = IlrdEventsRepository.this.getSession();
            if (session != null) {
                session.a();
            }
            IlrdEventsRepository.this.m();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleSessionExpiry$1", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5409a;

        public g(Continuation<? super g> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((g) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5409a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.internal.ilrd.a session = IlrdEventsRepository.this.getSession();
            if (session != null) {
                session.a();
            }
            IlrdEventsRepository.this.m();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleUploadIntervalScheduler$1", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5410a;

        public h(Continuation<? super h> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5410a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IlrdEventsRepository.this.m();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ IlrdEventsRepository(CoroutineScope coroutineScope, String str, i iVar, long j, int i, long j2, long j3, I i2, Lifecycle lifecycle, InterfaceC3440d interfaceC3440d, String str2, String str3, w wVar, com.moloco.sdk.internal.ilrd.d dVar, com.moloco.sdk.internal.ilrd.d dVar2, com.moloco.sdk.internal.ilrd.d dVar3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, str, iVar, j, i, j2, j3, i2, lifecycle, interfaceC3440d, str2, str3, wVar, dVar, dVar2, dVar3);
    }

    public static /* synthetic */ void c() {
    }

    /* renamed from: d, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getScheduledUploadScheduler() {
        return this.scheduledUploadScheduler;
    }

    /* renamed from: e, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.a getSession() {
        return this.session;
    }

    /* renamed from: f, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getSessionExpiryScheduler() {
        return this.sessionExpiryScheduler;
    }

    /* renamed from: g, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getSessionMaxLengthScheduler() {
        return this.sessionMaxLengthScheduler;
    }

    public final boolean h() {
        boolean z = this.events.size() >= this.maxBatchSize;
        if (z) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "batch size reached", null, false, 12, null);
        }
        return z;
    }

    public final synchronized void i() {
        a();
        k();
    }

    public final void j() {
        this.sessionMaxLengthScheduler.a(this.sessionMaxLength, new f(null));
    }

    public final void k() {
        this.sessionExpiryScheduler.a(this.sessionExp, new g(null));
    }

    public final void l() {
        this.scheduledUploadScheduler.a(this.uploadInterval, new h(null));
    }

    public final void m() {
        l();
        if (this.events.isEmpty()) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Request for sendEvent came, but event list is empty. Returning", null, false, 12, null);
            return;
        }
        IlrdRequest.ImpressionRevenueRequest.Builder newBuilder = IlrdRequest.ImpressionRevenueRequest.newBuilder();
        newBuilder.setOs(C3040d4.d);
        newBuilder.setPublisherId(this.pubId);
        newBuilder.setPublisherAppId(this.appId);
        AbstractC3439c a2 = this.advertisingIdService.a();
        AbstractC3439c.a aVar = a2 instanceof AbstractC3439c.a ? (AbstractC3439c.a) a2 : null;
        if (aVar != null) {
            newBuilder.setDeviceId(aVar.b());
        }
        newBuilder.addAllEvents(this.events);
        IlrdRequest.ImpressionRevenueRequest build = newBuilder.build();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Ilrd request created now sending it with " + build.getEventsList().size() + " events", null, false, 12, null);
        Companion companion = INSTANCE;
        byte[] byteArray = build.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        this.persistentHttpRequest.a(this.url, companion.a(byteArray), ContentType.Application.INSTANCE.getProtoBuf(), "gzip");
        this.events.clear();
    }

    public final void n() {
        this.session = new com.moloco.sdk.internal.ilrd.a(this.timeProvider, null, 2, null);
        j();
        l();
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("New session started: ");
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        MolocoLogger.info$default(molocoLogger, u, sb.append(aVar != null ? aVar.d() : null).toString(), null, false, 12, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        BuildersKt.launch(this.scope, EmptyCoroutineContext.INSTANCE, CoroutineStart.DEFAULT, new d(null));
    }

    public IlrdEventsRepository(CoroutineScope scope, String url, i persistentHttpRequest, long j, int i, long j2, long j3, I timeProvider, Lifecycle processLifeycle, InterfaceC3440d advertisingIdService, String pubId, String appId, w dataStoreService, com.moloco.sdk.internal.ilrd.d sessionExpiryScheduler, com.moloco.sdk.internal.ilrd.d sessionMaxLengthScheduler, com.moloco.sdk.internal.ilrd.d scheduledUploadScheduler) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(processLifeycle, "processLifeycle");
        Intrinsics.checkNotNullParameter(advertisingIdService, "advertisingIdService");
        Intrinsics.checkNotNullParameter(pubId, "pubId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(dataStoreService, "dataStoreService");
        Intrinsics.checkNotNullParameter(sessionExpiryScheduler, "sessionExpiryScheduler");
        Intrinsics.checkNotNullParameter(sessionMaxLengthScheduler, "sessionMaxLengthScheduler");
        Intrinsics.checkNotNullParameter(scheduledUploadScheduler, "scheduledUploadScheduler");
        this.scope = scope;
        this.url = url;
        this.persistentHttpRequest = persistentHttpRequest;
        this.sessionExp = j;
        this.maxBatchSize = i;
        this.uploadInterval = j2;
        this.sessionMaxLength = j3;
        this.timeProvider = timeProvider;
        this.advertisingIdService = advertisingIdService;
        this.pubId = pubId;
        this.appId = appId;
        this.dataStoreService = dataStoreService;
        this.sessionExpiryScheduler = sessionExpiryScheduler;
        this.sessionMaxLengthScheduler = sessionMaxLengthScheduler;
        this.scheduledUploadScheduler = scheduledUploadScheduler;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.events = new ArrayList();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "ILRD repository initialized - url=" + url + ", uploadInterval=" + ((Object) Duration.m11616toStringimpl(j2)) + ", maxBatchSize=" + i + ", sessionExpiry=" + ((Object) Duration.m11616toStringimpl(j)) + ", maxSessionLength=" + ((Object) Duration.m11616toStringimpl(j3)), null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new a(processLifeycle, null), 3, null);
    }

    public final List<IlrdRequest.ImpressionLevelRevenue> b() {
        return this.events;
    }

    public final void b(c.a ilrdData) {
        Intrinsics.checkNotNullParameter(ilrdData, "ilrdData");
        BuildersKt.launch(this.scope, EmptyCoroutineContext.INSTANCE, CoroutineStart.DEFAULT, new c(ilrdData, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation<? super Unit> continuation) {
        e eVar;
        int i;
        IlrdEventsRepository ilrdEventsRepository;
        String str;
        String str2;
        IlrdEventsRepository ilrdEventsRepository2;
        long e2;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.e = i2 - Integer.MIN_VALUE;
                Object obj = eVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = eVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    w wVar = this.dataStoreService;
                    eVar.f5407a = this;
                    eVar.e = 1;
                    obj = wVar.d(v, eVar);
                    if (obj != coroutine_suspended) {
                        ilrdEventsRepository = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str2 = (String) eVar.b;
                    ilrdEventsRepository2 = (IlrdEventsRepository) eVar.f5407a;
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.ilrd.a aVar = new com.moloco.sdk.internal.ilrd.a(ilrdEventsRepository2.timeProvider, str2);
                    long a2 = ilrdEventsRepository2.timeProvider.a();
                    e2 = a2 - aVar.e();
                    long i3 = aVar.b().i();
                    if (e2 <= Duration.m11585getInWholeMillisecondsimpl(ilrdEventsRepository2.sessionMaxLength)) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Discarding restored session - exceeded maximum length", null, false, 12, null);
                        return Unit.INSTANCE;
                    }
                    if (i3 > 0 && a2 - i3 > Duration.m11585getInWholeMillisecondsimpl(ilrdEventsRepository2.sessionExp)) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Discarding restored session - exceeded inactivity timeout", null, false, 12, null);
                        return Unit.INSTANCE;
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "ILRD session restored successfully", null, false, 12, null);
                    ilrdEventsRepository2.session = aVar;
                    return Unit.INSTANCE;
                }
                ilrdEventsRepository = (IlrdEventsRepository) eVar.f5407a;
                ResultKt.throwOnFailure(obj);
                str = (String) obj;
                if (str != null) {
                    return Unit.INSTANCE;
                }
                w wVar2 = ilrdEventsRepository.dataStoreService;
                eVar.f5407a = ilrdEventsRepository;
                eVar.b = str;
                eVar.e = 2;
                if (wVar2.a(v, eVar) != coroutine_suspended) {
                    str2 = str;
                    ilrdEventsRepository2 = ilrdEventsRepository;
                    com.moloco.sdk.internal.ilrd.a aVar2 = new com.moloco.sdk.internal.ilrd.a(ilrdEventsRepository2.timeProvider, str2);
                    long a22 = ilrdEventsRepository2.timeProvider.a();
                    e2 = a22 - aVar2.e();
                    long i32 = aVar2.b().i();
                    if (e2 <= Duration.m11585getInWholeMillisecondsimpl(ilrdEventsRepository2.sessionMaxLength)) {
                    }
                }
                return coroutine_suspended;
            }
        }
        eVar = new e(continuation);
        Object obj2 = eVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = eVar.e;
        if (i != 0) {
        }
        str = (String) obj2;
        if (str != null) {
        }
    }

    public final IlrdRequest.ImpressionLevelRevenue a(c.a ilrdData) {
        IlrdRequest.ImpressionLevelRevenue.Builder eventId = IlrdRequest.ImpressionLevelRevenue.newBuilder().setEventId(UUID.randomUUID().toString());
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        if (aVar != null) {
            eventId.setSessionId(aVar.d());
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Event created: sessionId=" + aVar.d() + ", sessionAge=" + (this.timeProvider.a() - aVar.e()) + "ms", null, false, 12, null);
        }
        if (ilrdData instanceof c.a.b) {
            eventId.setMax(((c.a.b) ilrdData).b());
        } else {
            if (!(ilrdData instanceof c.a.C0433a)) {
                throw new NoWhenBranchMatchedException();
            }
            eventId.setLevelplay(((c.a.C0433a) ilrdData).b());
        }
        return eventId.build();
    }

    public final void a() {
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        if (aVar != null && (aVar == null || !aVar.f())) {
            com.moloco.sdk.internal.ilrd.a aVar2 = this.session;
            if (aVar2 != null) {
                long a2 = this.timeProvider.a() - aVar2.e();
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, u, "Session validation - age: " + a2 + "ms, limit: " + Duration.m11585getInWholeMillisecondsimpl(this.sessionMaxLength) + "ms", null, false, 12, null);
                if (a2 > Duration.m11585getInWholeMillisecondsimpl(this.sessionMaxLength) || a2 < 0) {
                    MolocoLogger.info$default(molocoLogger, u, "Session has invalid duration (" + a2 + "ms), expiring", null, false, 12, null);
                    aVar2.a();
                    n();
                    return;
                }
                return;
            }
            return;
        }
        n();
    }

    public /* synthetic */ IlrdEventsRepository(CoroutineScope coroutineScope, String str, i iVar, long j, int i, long j2, long j3, I i2, Lifecycle lifecycle, InterfaceC3440d interfaceC3440d, String str2, String str3, w wVar, com.moloco.sdk.internal.ilrd.d dVar, com.moloco.sdk.internal.ilrd.d dVar2, com.moloco.sdk.internal.ilrd.d dVar3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, str, iVar, j, i, j2, j3, i2, lifecycle, interfaceC3440d, str2, str3, wVar, (i3 & 8192) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i2, "SessionExpiryScheduler") : dVar, (i3 & 16384) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i2, "SessionMaxLengthScheduler") : dVar2, (i3 & 32768) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i2, "UploadIntervalScheduler") : dVar3, null);
    }
}
