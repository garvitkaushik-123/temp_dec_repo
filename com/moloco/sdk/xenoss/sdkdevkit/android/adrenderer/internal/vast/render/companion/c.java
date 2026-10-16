package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import android.content.Context;
import androidx.compose.ui.geometry.Offset;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a {
    public static final int p = 8;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c f6193a;
    public final Context b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final InterfaceC3463m d;
    public final boolean e;
    public final CoroutineScope f;
    public final d g;
    public a.AbstractC0571a.f h;
    public final g i;
    public final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> j;
    public final Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> k;
    public final boolean l;
    public k m;
    public final MutableStateFlow<j> n;
    public final StateFlow<j> o;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionControllerImpl$1", f = "CompanionControllerImpl.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f6194a;
        public int b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            c cVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar2 = c.this;
                y e = cVar2.f6193a.e();
                Context context = c.this.b;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = c.this.c;
                InterfaceC3463m interfaceC3463m = c.this.d;
                int f = c.this.f6193a.f();
                int d = c.this.f6193a.d();
                final c cVar3 = c.this;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return c.a.a(c.this);
                    }
                };
                final c cVar4 = c.this;
                Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c$a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return c.a.a(c.this, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) obj2);
                    }
                };
                boolean z = c.this.e;
                this.f6194a = cVar2;
                this.b = 1;
                Object a2 = l.a(e, context, aVar, interfaceC3463m, f, d, function0, function1, z, this);
                if (a2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cVar = cVar2;
                obj = a2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cVar = (c) this.f6194a;
                ResultKt.throwOnFailure(obj);
            }
            cVar.a((k) obj);
            return Unit.INSTANCE;
        }

        public static final Unit a(c cVar) {
            cVar.i.a(cVar.h);
            cVar.a(b.a.b);
            return Unit.INSTANCE;
        }

        public static final Unit a(c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar2) {
            cVar.a(cVar2);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionControllerImpl$onEvent$1", f = "CompanionControllerImpl.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6195a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6195a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = c.this.j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar = this.c;
                this.f6195a = 1;
                if (mutableSharedFlow.emit(bVar, this) == coroutine_suspended) {
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
    }

    public /* synthetic */ c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVar, int i, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, InterfaceC3463m interfaceC3463m, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, i, context, aVar, interfaceC3463m, z);
    }

    public static Object i(c cVar) {
        return Reflection.property0(new PropertyReference0Impl(cVar.g, d.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void A() {
        a(b.C0540b.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean K() {
        return this.l;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public StateFlow<j> L() {
        return this.o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.f, null, 1, null);
        k kVar = this.m;
        if (kVar != null) {
            kVar.destroy();
        }
        a((k) null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        return this.g.m();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.g.reset();
    }

    public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c companion, int i, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, InterfaceC3463m externalLinkHandler, boolean z) {
        Intrinsics.checkNotNullParameter(companion, "companion");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        this.f6193a = companion;
        this.b = context;
        this.c = customUserEventBuilderService;
        this.d = externalLinkHandler;
        this.e = z;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.f = CoroutineScope;
        this.g = f.a(i, CoroutineScope);
        this.h = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f6046a.a(Offset.INSTANCE.m3838getZeroF1C5BW0());
        this.i = new g(customUserEventBuilderService, companion.b(), companion.c(), null, null, 24, null);
        MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.j = MutableSharedFlow$default;
        this.k = MutableSharedFlow$default;
        this.l = companion.a() != null;
        k kVar = this.m;
        MutableStateFlow<j> MutableStateFlow = StateFlowKt.MutableStateFlow(kVar != null ? kVar.k() : null);
        this.n = MutableStateFlow;
        this.o = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new a(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void b() {
        this.i.a();
        a(b.c.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b> a() {
        return this.k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(a.AbstractC0571a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        String a2 = this.f6193a.a();
        if (a2 != null) {
            this.i.a(position);
            this.d.a(a2);
            a(b.a.b);
        }
    }

    public final Job a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new b(bVar, null), 3, null);
        return launch$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(new b.d(error));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.i.a(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.i.a(buttonType);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h
    public void a(a.AbstractC0571a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.h = position;
    }

    public final void a(k kVar) {
        this.m = kVar;
        this.n.setValue(kVar != null ? kVar.k() : null);
    }
}
