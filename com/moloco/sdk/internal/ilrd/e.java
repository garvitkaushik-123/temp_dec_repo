package com.moloco.sdk.internal.ilrd;

import android.content.Context;
import com.moloco.sdk.Init;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.ilrd.g;
import com.moloco.sdk.internal.services.bidtoken.providers.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class e {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "IlrdService";

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f5422a;
    public final IlrdEventsRepository b;
    public final Lazy c;
    public final Set<com.moloco.sdk.internal.ilrd.c> d;
    public Job e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdService$subscribe$1", f = "IlrdService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5423a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5423a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<com.moloco.sdk.internal.ilrd.c> a2 = e.this.a();
            e eVar = e.this;
            for (com.moloco.sdk.internal.ilrd.c cVar : a2) {
                g value = cVar.getState().getValue();
                if (value instanceof g.a) {
                    MolocoLogger.warn$default(MolocoLogger.INSTANCE, e.h, "Failed to subscribe to " + cVar.a() + " ILRD: " + ((g.a) value).b(), null, false, 12, null);
                } else if (value instanceof g.c) {
                    eVar.a(cVar);
                } else if (!(value instanceof g.b)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdService$subscribeToProvider$2$1", f = "IlrdService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<c.a, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5424a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(c.a aVar, Continuation<? super Unit> continuation) {
            return ((c) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = e.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5424a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            c.a aVar = (c.a) this.b;
            MolocoLogger.info$default(MolocoLogger.INSTANCE, e.h, "Revenue event: " + aVar, null, false, 12, null);
            e.this.b.b(aVar);
            return Unit.INSTANCE;
        }
    }

    public e(CoroutineScope scope, final Context context, IlrdEventsRepository eventsRepository, final List<? extends Init.SDKInitResponse.SupportedNetworks> supportedNetworksList) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(supportedNetworksList, "supportedNetworksList");
        this.f5422a = scope;
        this.b = eventsRepository;
        this.c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e.a(supportedNetworksList, context, this);
            }
        });
        this.d = Collections.synchronizedSet(new LinkedHashSet());
    }

    public final synchronized void c() {
        Job launch$default;
        Job job = this.e;
        if (job == null || !job.isActive()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.f5422a, null, null, new b(null), 3, null);
            this.e = launch$default;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        r0 = com.moloco.sdk.internal.ilrd.f.b(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final p b() {
        p b2;
        IlrdEventsRepository ilrdEventsRepository = this.b;
        ilrdEventsRepository.i();
        com.moloco.sdk.internal.ilrd.a session = ilrdEventsRepository.getSession();
        if (session != null && b2 != null) {
            return b2;
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, h, "provideDataForBidToken() Session is null", null, false, 12, null);
        return null;
    }

    public final List<com.moloco.sdk.internal.ilrd.c> a() {
        return (List) this.c.getValue();
    }

    public static final List a(List list, Context context, e eVar) {
        ArrayList arrayList = new ArrayList();
        if (list.contains(Init.SDKInitResponse.SupportedNetworks.MAX)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "Adding AppLovin as ILRD provider", null, false, 12, null);
            arrayList.add(new com.moloco.sdk.internal.ilrd.provider.a(context, eVar.f5422a));
        }
        if (list.contains(Init.SDKInitResponse.SupportedNetworks.LEVEL_PLAY)) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "Adding IronSource as ILRD provider", null, false, 12, null);
            arrayList.add(new com.moloco.sdk.internal.ilrd.provider.b(context, eVar.f5422a));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final void a(com.moloco.sdk.internal.ilrd.c cVar) {
        Object b2 = cVar.b();
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(b2);
        if (m10244exceptionOrNullimpl != null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, h, "Failed to subscribe to " + cVar.a() + " ILRD: " + m10244exceptionOrNullimpl, null, false, 12, null);
        }
        if (Result.m10248isSuccessimpl(b2)) {
            this.d.add(cVar);
            FlowKt.launchIn(FlowKt.onEach(cVar.c(), new c(null)), this.f5422a);
        }
    }
}
