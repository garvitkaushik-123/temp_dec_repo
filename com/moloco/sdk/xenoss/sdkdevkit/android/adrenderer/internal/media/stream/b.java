package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public c f5874a;
    public final Flow<c> b;
    public Function1<? super File, Unit> c;
    public Function2<? super File, ? super c.d, Unit> d;
    public Function1<? super c.a, Unit> e;
    public Function1<? super c.b, Unit> f;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.MediaStreamListenerFlow$streamStatusFlow$1", f = "MediaStreamListenerFlow.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<ProducerScope<? super c>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5875a;
        public /* synthetic */ Object b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super c> producerScope, Continuation<? super Unit> continuation) {
            return ((a) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = b.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5875a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.b;
                b.this.c = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return b.a.a(ProducerScope.this, (File) obj2);
                    }
                };
                b.this.d = new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return b.a.a(ProducerScope.this, (File) obj2, (c.d) obj3);
                    }
                };
                b.this.e = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return b.a.a(ProducerScope.this, (c.a) obj2);
                    }
                };
                b.this.f = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return b.a.a(ProducerScope.this, (c.b) obj2);
                    }
                };
                final b bVar = b.this;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b$a$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.a.a(b.this);
                    }
                };
                this.f5875a = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        public static final Unit a(ProducerScope producerScope, File file) {
            producerScope.mo11746trySendJP2dKIU(new c.C0482c(file, new c.d(0L, 0L)));
            return Unit.INSTANCE;
        }

        public static final Unit a(ProducerScope producerScope, File file, c.d dVar) {
            producerScope.mo11746trySendJP2dKIU(new c.C0482c(file, dVar));
            return Unit.INSTANCE;
        }

        public static final Unit a(ProducerScope producerScope, c.a aVar) {
            producerScope.mo11746trySendJP2dKIU(aVar);
            return Unit.INSTANCE;
        }

        public static final Unit a(ProducerScope producerScope, c.b bVar) {
            producerScope.mo11746trySendJP2dKIU(bVar);
            return Unit.INSTANCE;
        }

        public static final Unit a(b bVar) {
            bVar.c = null;
            bVar.d = null;
            bVar.e = null;
            bVar.f = null;
            return Unit.INSTANCE;
        }
    }

    public b(c initialStatus) {
        Intrinsics.checkNotNullParameter(initialStatus, "initialStatus");
        this.f5874a = initialStatus;
        this.b = FlowKt.callbackFlow(new a(null));
    }

    public final Flow<c> b() {
        return this.b;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public c a() {
        return this.f5874a;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f5874a = new c.C0482c(file, new c.d(0L, 0L));
        Function1<? super File, Unit> function1 = this.c;
        if (function1 != null) {
            function1.invoke(file);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(File file, c.d progress) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.f5874a = new c.C0482c(file, progress);
        Function2<? super File, ? super c.d, Unit> function2 = this.d;
        if (function2 != null) {
            function2.invoke(file, progress);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(c.a result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f5874a = result;
        Function1<? super c.a, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(result);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a
    public void a(c.b error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f5874a = error;
        Function1<? super c.b, Unit> function1 = this.f;
        if (function1 != null) {
            function1.invoke(error);
        }
    }
}
