package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.app.Activity;
import android.content.Context;
import com.moloco.sdk.internal.services.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3454d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3458h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.N;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class l {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt", f = "PreparedVastResource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {74, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE}, m = "prepareVastResource", n = {"$this$prepareVastResource", "context", "customUserEventBuilderService", "externalLinkHandler", "onWebViewClick", "onWebViewError", "mraidHtml", "startMuted", "mraidInline", "staticWebView", "staticWebViewListenerScope"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6282a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public boolean h;
        public /* synthetic */ Object i;
        public int j;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return l.a(null, null, null, null, 0, 0, null, null, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$2", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6283a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ y c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<String> objectRef, y yVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6283a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.element = l.a(this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f6284a;
        public final /* synthetic */ Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> b;
        public final /* synthetic */ Ref.ObjectRef<C3454d> c;
        public final /* synthetic */ Ref.ObjectRef<CoroutineScope> d;

        public c(Integer num, Ref.ObjectRef<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> objectRef, Ref.ObjectRef<C3454d> objectRef2, Ref.ObjectRef<CoroutineScope> objectRef3) {
            this.f6284a = num;
            this.b = objectRef;
            this.c = objectRef2;
            this.d = objectRef3;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
        public void destroy() {
            Integer num = this.f6284a;
            if (num != null) {
                N.f5809a.b(num.intValue());
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m mVar = this.b.element;
            if (mVar != null) {
                mVar.destroy();
            }
            this.b.element = null;
            C3454d c3454d = this.c.element;
            if (c3454d != null) {
                c3454d.destroy();
            }
            this.c.element = null;
            CoroutineScope coroutineScope = this.d.element;
            if (coroutineScope != null) {
                CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
            }
            this.d.element = null;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$1", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6285a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0<Unit> function0, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((d) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6285a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.invoke();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2", f = "PreparedVastResource.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6286a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a b;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2$1", f = "PreparedVastResource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6287a;
            public /* synthetic */ Object b;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, Continuation<? super Boolean> continuation) {
                return ((a) create(gVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(continuation);
                aVar.b = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f6287a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.b) != null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function1, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = aVar;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6286a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.b.getUnrecoverableError();
                a aVar = new a(null);
                this.f6286a = 1;
                obj = FlowKt.first(unrecoverableError, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
            if (gVar != null) {
                this.c.invoke(gVar);
            }
            return Unit.INSTANCE;
        }
    }

    public static final j a(y yVar, int i, int i2) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        if (!(yVar instanceof y.c)) {
            return null;
        }
        y.c cVar = (y.c) yVar;
        if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.f6146a) {
            return new j.b(cVar.a().b(), i, i2);
        }
        return null;
    }

    public static final Unit b() {
        return Unit.INSTANCE;
    }

    public static final String a(y yVar) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        if (yVar instanceof y.a) {
            y.a aVar = (y.a) yVar;
            if (C3458h.f5847a.a(aVar.a().a())) {
                return aVar.a().a();
            }
            return null;
        }
        if (yVar instanceof y.b) {
            y.b bVar = (y.b) yVar;
            if (C3458h.f5847a.a(bVar.a().a())) {
                return bVar.a().a();
            }
            return null;
        }
        if (yVar instanceof y.c) {
            y.c cVar = (y.c) yVar;
            if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i.b && C3458h.f5847a.a(cVar.a().b())) {
                return cVar.a().b();
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m] */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(y yVar, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, InterfaceC3463m interfaceC3463m, int i, int i2, Function0<Unit> function0, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function1, boolean z, Continuation<? super k> continuation) {
        a aVar2;
        int i3;
        Ref.ObjectRef objectRef;
        Context context2;
        com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar3;
        InterfaceC3463m interfaceC3463m2;
        boolean z2;
        Function0<Unit> function02;
        Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, Unit> function12;
        y yVar2;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        String str;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        C3454d c3454d;
        Integer boxInt;
        if (continuation instanceof a) {
            aVar2 = (a) continuation;
            int i4 = aVar2.j;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                aVar2.j = i4 - Integer.MIN_VALUE;
                Object obj = aVar2.i;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aVar2.j;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    j a2 = a(yVar, i, i2);
                    if (a2 != null) {
                        return new k(a2, null);
                    }
                    objectRef = new Ref.ObjectRef();
                    CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                    b bVar = new b(objectRef, yVar, null);
                    aVar2.f6282a = yVar;
                    context2 = context;
                    aVar2.b = context2;
                    aVar3 = aVar;
                    aVar2.c = aVar3;
                    interfaceC3463m2 = interfaceC3463m;
                    aVar2.d = interfaceC3463m2;
                    aVar2.e = function0;
                    aVar2.f = function1;
                    aVar2.g = objectRef;
                    z2 = z;
                    aVar2.h = z2;
                    aVar2.j = 1;
                    if (BuildersKt.withContext(coroutineContext, bVar, aVar2) != coroutine_suspended) {
                        function02 = function0;
                        function12 = function1;
                        yVar2 = yVar;
                    }
                    return coroutine_suspended;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef7 = (Ref.ObjectRef) aVar2.c;
                    objectRef5 = (Ref.ObjectRef) aVar2.b;
                    objectRef6 = (Ref.ObjectRef) aVar2.f6282a;
                    ResultKt.throwOnFailure(obj);
                    if (obj instanceof C3454d) {
                        objectRef4 = objectRef7;
                        objectRef2 = objectRef6;
                        objectRef3 = objectRef5;
                        c3454d = null;
                    } else {
                        objectRef4 = objectRef7;
                        objectRef2 = objectRef6;
                        c3454d = (C3454d) obj;
                        objectRef3 = objectRef5;
                    }
                    boxInt = c3454d != null ? Boxing.boxInt(N.f5809a.a(c3454d)) : null;
                    c cVar = new c(boxInt, objectRef2, objectRef3, objectRef4);
                    if (boxInt != null) {
                        return new k(new j.a(boxInt.intValue()), cVar);
                    }
                    return null;
                }
                boolean z3 = aVar2.h;
                objectRef = (Ref.ObjectRef) aVar2.g;
                function12 = (Function1) aVar2.f;
                function02 = (Function0) aVar2.e;
                InterfaceC3463m interfaceC3463m3 = (InterfaceC3463m) aVar2.d;
                aVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a) aVar2.c;
                Context context3 = (Context) aVar2.b;
                yVar2 = (y) aVar2.f6282a;
                ResultKt.throwOnFailure(obj);
                interfaceC3463m2 = interfaceC3463m3;
                context2 = context3;
                z2 = z3;
                objectRef2 = new Ref.ObjectRef();
                objectRef3 = new Ref.ObjectRef();
                objectRef4 = new Ref.ObjectRef();
                str = (String) objectRef.element;
                if (str != null) {
                    Context applicationContext = context2.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    ?? aVar4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(applicationContext, null, new t(interfaceC3463m2, aVar3), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a(), false, null, 50, null);
                    objectRef3.element = aVar4;
                    ?? CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
                    objectRef4.element = CoroutineScope;
                    FlowKt.launchIn(FlowKt.onEach(aVar4.getClickthroughEvent(), new d(function02, null)), CoroutineScope);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new e(aVar4, function12, null), 3, null);
                    q.a(aVar4, yVar2);
                    c3454d = aVar4;
                    if (c3454d != null) {
                    }
                    c cVar2 = new c(boxInt, objectRef2, objectRef3, objectRef4);
                    if (boxInt != null) {
                    }
                } else {
                    Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                    ?? mVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m((Activity) context2, str, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.l$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return l.a();
                        }
                    }, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.l$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return l.b();
                        }
                    }, function02, function12, true, interfaceC3463m2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.h.a(context2, CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain()), z2), null, 512, null);
                    objectRef2.element = mVar;
                    aVar2.f6282a = objectRef2;
                    aVar2.b = objectRef3;
                    aVar2.c = objectRef4;
                    aVar2.d = null;
                    aVar2.e = null;
                    aVar2.f = null;
                    aVar2.g = null;
                    aVar2.j = 2;
                    Object c2 = mVar.c(aVar2);
                    if (c2 != coroutine_suspended) {
                        objectRef5 = objectRef3;
                        obj = c2;
                        objectRef6 = objectRef2;
                        objectRef7 = objectRef4;
                        if (obj instanceof C3454d) {
                        }
                        if (c3454d != null) {
                        }
                        c cVar22 = new c(boxInt, objectRef2, objectRef3, objectRef4);
                        if (boxInt != null) {
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
        aVar2 = new a(continuation);
        Object obj2 = aVar2.i;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aVar2.j;
        if (i3 != 0) {
        }
        objectRef2 = new Ref.ObjectRef();
        objectRef3 = new Ref.ObjectRef();
        objectRef4 = new Ref.ObjectRef();
        str = (String) objectRef.element;
        if (str != null) {
        }
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }
}
