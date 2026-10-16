package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebView;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class g implements f {
    public static final int i = 8;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5895a;
    public final CoroutineScope b;
    public final MutableSharedFlow<n> c;
    public final SharedFlow<n> d;
    public final v e;
    public final WebView f;
    public final StateFlow<Boolean> g;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> h;

    public static final class a implements o {
        public a() {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.o
        public boolean a(String fromUrl) {
            Intrinsics.checkNotNullParameter(fromUrl, "fromUrl");
            return g.this.b(fromUrl);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBridgeImpl$consumeMraidJsCommand$1", f = "MraidBridge.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"cmd"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5897a;
        public int b;
        public final /* synthetic */ com.moloco.sdk.internal.v<n, n.b.a> c;
        public final /* synthetic */ g d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.v<n, n.b.a> vVar, g gVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = vVar;
            this.d = gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            n nVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                n nVar2 = (n) ((v.b) this.c).a();
                MutableSharedFlow mutableSharedFlow = this.d.c;
                this.f5897a = nVar2;
                this.b = 1;
                if (mutableSharedFlow.emit(nVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nVar = nVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nVar = (n) this.f5897a;
                ResultKt.throwOnFailure(obj);
            }
            this.d.a(nVar);
            return Unit.INSTANCE;
        }
    }

    public g(Context context, CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f5895a = z;
        this.b = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        MutableSharedFlow<n> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.c = MutableSharedFlow$default;
        this.d = MutableSharedFlow$default;
        v vVar = new v(context, new a());
        this.e = vVar;
        this.f = vVar;
        this.g = vVar.c();
        this.h = vVar.getUnrecoverableError();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public StateFlow<Boolean> I() {
        return this.g;
    }

    public final boolean b(String str) {
        com.moloco.sdk.internal.v<n, n.b.a> a2 = n.b.a(str);
        if (a2 instanceof v.b) {
            BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new b(a2, this, null), 3, null);
            return true;
        }
        if (a2 instanceof v.a) {
            return ((n.b.a) ((v.a) a2).a()).b();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public WebView c() {
        return this.f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.e.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void j() {
        c("mraidbridge.notifyReadyEvent()");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public SharedFlow<n> w() {
        return this.d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> x() {
        return this.h;
    }

    public final void c(String str) {
        this.e.loadUrl("javascript:" + str);
    }

    public final void a(n nVar) {
        c("mraidbridge.nativeCallComplete(" + JSONObject.quote(nVar.a()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(n command, String msg) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(msg, "msg");
        c("mraidbridge.notifyErrorEvent(" + JSONObject.quote(command.a()) + ", " + JSONObject.quote(msg) + ')');
    }

    public final String b(Rect rect) {
        return new StringBuilder().append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(r placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.c()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(t state) {
        Intrinsics.checkNotNullParameter(state, "state");
        c("mraidbridge.setState(" + JSONObject.quote(state.c()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        c("mraidbridge.setSupports(" + z + AbstractJsonLexerKt.COMMA + z2 + AbstractJsonLexerKt.COMMA + z3 + AbstractJsonLexerKt.COMMA + z4 + AbstractJsonLexerKt.COMMA + z5 + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(s screenMetrics) {
        Intrinsics.checkNotNullParameter(screenMetrics, "screenMetrics");
        c("\n                mraidbridge.setScreenSize(" + b(screenMetrics.g()) + ");\n                mraidbridge.setMaxSize(" + b(screenMetrics.f()) + ");\n                mraidbridge.setCurrentPosition(" + a(screenMetrics.b()) + ");\n                mraidbridge.setDefaultPosition(" + a(screenMetrics.d()) + ")\n            ");
        c("mraidbridge.notifySizeChangeEvent(" + b(screenMetrics.b()) + ')');
    }

    public final String a(Rect rect) {
        return new StringBuilder().append(rect.left).append(AbstractJsonLexerKt.COMMA).append(rect.top).append(AbstractJsonLexerKt.COMMA).append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public Object a(String str, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
        return this.e.a(str, this.f5895a, continuation);
    }
}
