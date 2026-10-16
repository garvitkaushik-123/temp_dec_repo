package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3459i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a {
    public static final int m = 8;

    /* renamed from: a, reason: collision with root package name */
    public final C3459i f6272a;
    public final InterfaceC3463m b;
    public final CoroutineScope c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d d;
    public final d e;
    public final MutableSharedFlow<b> f;
    public final Flow<b> g;
    public final boolean h;
    public final String i;
    public final String j;
    public final String k;
    public final n l;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.DECControllerImpl$onEvent$1", f = "DECControllerImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6273a;
        public final /* synthetic */ b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6273a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = c.this.f;
                b bVar = this.c;
                this.f6273a = 1;
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

    public /* synthetic */ c(C3459i c3459i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVar, int i, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, InterfaceC3463m interfaceC3463m, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3459i, eVar, i, context, aVar, interfaceC3463m);
    }

    public static Object b(c cVar) {
        return Reflection.property0(new PropertyReference0Impl(cVar.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    public static Object c(c cVar) {
        return Reflection.property0(new PropertyReference0Impl(cVar.l, n.class, "vastPrivacyIcon", "getVastPrivacyIcon()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean K() {
        return this.h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public StateFlow<j> O() {
        return this.l.O();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        this.l.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    public String g() {
        return this.j;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void i() {
        this.l.i();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    public String l() {
        return this.i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        return this.d.m();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.d.reset();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a
    public void u() {
        this.e.b();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void v() {
        this.l.v();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    public String z() {
        return this.k;
    }

    public c(C3459i dec, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVar, int i, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, InterfaceC3463m externalLinkHandler) {
        Intrinsics.checkNotNullParameter(dec, "dec");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        this.f6272a = dec;
        this.b = externalLinkHandler;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.c = CoroutineScope;
        this.d = f.a(i, CoroutineScope);
        this.e = new d(customUserEventBuilderService, CollectionsKt.listOfNotNull(dec.k()), CollectionsKt.listOfNotNull(dec.m()), CollectionsKt.listOfNotNull(dec.n()), null, null, 48, null);
        MutableSharedFlow<b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f = MutableSharedFlow$default;
        this.g = MutableSharedFlow$default;
        this.h = dec.l() != null;
        this.i = dec.h();
        this.j = dec.i();
        this.k = dec.j();
        this.l = p.a(eVar != null ? eVar.f() : null, eVar != null ? Integer.valueOf(eVar.h()) : null, eVar != null ? Integer.valueOf(eVar.d()) : null, eVar != null ? eVar.a() : null, CoroutineScope, context, customUserEventBuilderService, externalLinkHandler, null, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a
    public Flow<b> a() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e
    public void b() {
        this.e.a();
        a(b.f6271a);
    }

    public final Job a(b bVar) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(bVar, null), 3, null);
        return launch$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.e.a(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(a.AbstractC0571a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        String l = this.f6272a.l();
        if (l != null) {
            this.e.a(position);
            this.b.a(l);
            a(b.b);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.e.a(buttonType);
    }
}
