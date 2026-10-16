package com.moloco.sdk.internal.services.analytics;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.internal.services.analytics.a {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final i f5619a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c c;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.analytics.AnalyticsServiceImpl$recordApplicationBackground$1", f = "AnalyticsService.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5620a;
        public final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5620a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar2 = b.this.b;
                long j = this.c;
                a.AbstractC0571a.C0572a c0572a = a.AbstractC0571a.C0572a.b;
                String a2 = b.this.c.a();
                this.f5620a = 1;
                aVar = this;
                obj = aVar2.a(j, c0572a, a2, aVar);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                aVar = this;
            }
            b.this.f5619a.a((String) obj);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.analytics.AnalyticsServiceImpl$recordApplicationForeground$1", f = "AnalyticsService.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.services.analytics.b$b, reason: collision with other inner class name */
    public static final class C0455b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5621a;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0455b(long j, long j2, Continuation<? super C0455b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = j2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0455b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0455b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C0455b c0455b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5621a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = b.this.b;
                long j = this.c;
                a.AbstractC0571a.b bVar = new a.AbstractC0571a.b(this.d);
                String d = b.this.c.d();
                this.f5621a = 1;
                c0455b = this;
                obj = aVar.a(j, bVar, d, c0455b);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                c0455b = this;
            }
            b.this.f5619a.a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public b(i persistentHttpRequest, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c configService) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(configService, "configService");
        this.f5619a = persistentHttpRequest;
        this.b = customUserEventBuilderService;
        this.c = configService;
    }

    @Override // com.moloco.sdk.internal.services.analytics.a
    public void a(long j, long j2) {
        if (!this.c.c() || this.c.d().length() <= 0) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, c.f5622a, "Recording applicationForeground with timestamp: " + j + ", lastBgTimestamp: " + j2, false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f5599a.b(), null, null, new C0455b(j, j2, null), 3, null);
    }

    @Override // com.moloco.sdk.internal.services.analytics.a
    public void a(long j) {
        if (!this.c.c() || this.c.a().length() <= 0) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, c.f5622a, "Recording applicationBackground with timestamp: " + j, false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f5599a.b(), null, null, new a(j, null), 3, null);
    }
}
