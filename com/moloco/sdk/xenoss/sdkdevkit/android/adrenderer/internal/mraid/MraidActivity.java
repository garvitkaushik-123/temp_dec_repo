package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\r\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u0010J\u0015\u0010\r\u001a\u0004\u0018\u00010\u0012*\u00020\u0011H\u0002¢\u0006\u0004\b\r\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/MraidActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/n$f;", "expectedOrientation", "a", "(Lkotlinx/coroutines/flow/StateFlow;)V", "orientationCommand", "(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/n$f;)V", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/p;", "", "(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/p;)Ljava/lang/Integer;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/a;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "c", "()Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/a;", "customUserEventBuilderService", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/a;", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/a;", "_adPlaylistController", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/j;", "d", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/j;", "_mraidContentController", "", "e", "Z", "isClosedByUser", InneractiveMediationDefs.GENDER_FEMALE, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class MraidActivity extends ComponentActivity {
    public static final String h = "MraidActivity";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy customUserEventBuilderService = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MraidActivity.b();
        }
    });

    /* renamed from: c, reason: from kotlin metadata */
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a _adPlaylistController;

    /* renamed from: d, reason: from kotlin metadata */
    public j _mraidContentController;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean isClosedByUser;

    /* renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g = 8;
    public static final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> i = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        public final boolean b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return bVar instanceof b.f;
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c adData, j controller, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f options, z zVar, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(options, "options");
            if (!a(controller)) {
                return false;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a;
            bVar.a(adData);
            bVar.a(zVar);
            bVar.a(options.a());
            bVar.a(options.c());
            bVar.a(function0);
            bVar.a(controller);
            bVar.b(function02);
            Intent intent = new Intent(context, (Class<?>) MraidActivity.class);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r.a(intent, options.b());
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r.b(intent, options.d());
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        }

        public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return Intrinsics.areEqual(bVar, b.e.b);
        }

        public final boolean a(j jVar) {
            WebView c;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a;
            j h = bVar.h();
            if (h != null && !Intrinsics.areEqual(h, jVar)) {
                return false;
            }
            bVar.a((j) null);
            ViewParent parent = (h == null || (c = h.c()) == null) ? null : c.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(h.c());
            }
            bVar.a((Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View>) null);
            bVar.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) null);
            bVar.a((z) null);
            Activity g = bVar.g();
            if (g != null) {
                g.finish();
            }
            bVar.a((Activity) null);
            return true;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5880a;

        static {
            int[] iArr = new int[p.values().length];
            try {
                iArr[p.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[p.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[p.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5880a = iArr;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity$onCreate$1", f = "MraidActivity.kt", i = {0}, l = {116}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5881a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super Unit> continuation) {
            return ((c) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = MraidActivity.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5881a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
                MutableSharedFlow mutableSharedFlow = MraidActivity.i;
                this.b = bVar2;
                this.f5881a = 1;
                if (mutableSharedFlow.emit(bVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar = bVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.b;
                ResultKt.throwOnFailure(obj);
            }
            Companion companion = MraidActivity.INSTANCE;
            if (companion.b(bVar)) {
                MraidActivity.this.finish();
            } else if (companion.a(bVar)) {
                MraidActivity.this.isClosedByUser = true;
                MraidActivity.this.finish();
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends AdaptedFunctionReference implements Function2<n.f, Continuation<? super Unit>, Object>, SuspendFunction {
        public e(Object obj) {
            super(2, obj, MraidActivity.class, "setOrientation", "setOrientation(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/MraidJsCommand$SetOrientationProperties;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n.f fVar, Continuation<? super Unit> continuation) {
            return MraidActivity.b((MraidActivity) this.receiver, fVar, continuation);
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b() {
        return a.k.f5759a.b();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a) this.customUserEventBuilderService.getValue();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar;
        MraidActivity mraidActivity = this;
        super.onCreate(savedInstanceState);
        com.moloco.sdk.internal.android_context.b.a(mraidActivity.getApplicationContext());
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a;
        bVar.a(mraidActivity);
        Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> b2 = bVar.b();
        Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> c2 = bVar.c();
        if (c2 == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "can't display ad: MraidRenderer is missing", null, false, 12, null);
            mraidActivity.finish();
            return;
        }
        j h2 = bVar.h();
        if (h2 == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "can't display ad: mraid controller is missing", null, false, 12, null);
            mraidActivity.finish();
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c a2 = bVar.a();
        if (a2 != null) {
            InterfaceC3463m f = a.h.f5756a.f();
            Intent intent = mraidActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a a3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a(a2, f, mraidActivity, h2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r.d(intent), mraidActivity.c());
            mraidActivity = mraidActivity;
            aVar = a3;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, h, "can't display ad: mraid ad data is missing", null, false, 12, null);
            mraidActivity.finish();
            return;
        }
        mraidActivity.a(h2.e());
        FlowKt.launchIn(FlowKt.onEach(aVar.a(), mraidActivity.new c(null)), mraidActivity.scope);
        ComponentActivityKt.setContent$default(mraidActivity, null, ComposableLambdaKt.composableLambdaInstance(-1048815572, true, mraidActivity.new d(aVar, h2, c2, b2)), 1, null);
        aVar.d();
        mraidActivity._adPlaylistController = aVar;
        mraidActivity._mraidContentController = h2;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Function0<Unit> e2;
        super.onDestroy();
        if (!this.isClosedByUser && (e2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a.e()) != null) {
            e2.invoke();
        }
        Function0<Unit> d2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a.d();
        if (d2 != null) {
            d2.invoke();
        }
        INSTANCE.a(this._mraidContentController);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this._adPlaylistController;
        if (aVar != null) {
            aVar.destroy();
        }
        this._adPlaylistController = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    public static final /* synthetic */ Object b(MraidActivity mraidActivity, n.f fVar, Continuation continuation) {
        mraidActivity.a(fVar);
        return Unit.INSTANCE;
    }

    public final void a(StateFlow<n.f> expectedOrientation) {
        a(expectedOrientation.getValue());
        FlowKt.launchIn(FlowKt.onEach(expectedOrientation, new e(this)), this.scope);
    }

    public final void a(n.f orientationCommand) {
        p c2;
        Integer a2;
        if (orientationCommand == null || (c2 = orientationCommand.c()) == null || (a2 = a(c2)) == null) {
            return;
        }
        setRequestedOrientation(a2.intValue());
    }

    public final Integer a(p pVar) {
        int i2 = b.f5880a[pVar.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 0;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class d implements Function2<Composer, Integer, Unit> {
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a b;
        public final /* synthetic */ j c;
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> d;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> e;

        public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(Object obj) {
                super(0, obj, j.class, "onSkipOrClose", "onSkipOrClose()V", 0);
            }

            public final void a() {
                ((j) this.receiver).D();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, j jVar, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> function9, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2) {
            this.b = aVar;
            this.c = jVar;
            this.d = function9;
            this.e = function2;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048815572, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.onCreate.<anonymous> (MraidActivity.kt:126)");
            }
            MraidActivity mraidActivity = MraidActivity.this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.b;
            WebView c = this.c.c();
            Intent intent = MraidActivity.this.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            int c2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r.c(intent);
            composer.startReplaceableGroup(-674125612);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity$d$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MraidActivity.d.a((a.AbstractC0571a.c) obj);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            composer.endReplaceableGroup();
            j jVar = this.c;
            composer.startReplaceableGroup(-674123563);
            boolean changed = composer.changed(jVar);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new a(jVar);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(mraidActivity, aVar, c, c2, function1, (Function0) ((KFunction) rememberedValue2), this.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f5884a.f(), this.e.invoke(composer, 0), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255), composer, 24576);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final Unit a(a.AbstractC0571a.c it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }
}
