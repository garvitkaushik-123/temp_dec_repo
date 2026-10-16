package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.ironsource.Y2;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final float f6325a = Dp.m6389constructorimpl(12);

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$b, reason: collision with other inner class name */
    public static final class C0564b implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0564b f6327a = new C0564b();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-1994751775);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994751775, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous> (AdWebViewRenderer.kt:141)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2 = q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class c implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableStateFlow<Boolean> f6328a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Function1<a.AbstractC0571a.c, Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ long f;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> g;
        public final /* synthetic */ z h;
        public final /* synthetic */ Dp i;
        public final /* synthetic */ boolean j;

        public static final class a implements Function2<Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MutableStateFlow<Boolean> f6329a;
            public final /* synthetic */ WebView b;
            public final /* synthetic */ int c;
            public final /* synthetic */ Function1<a.AbstractC0571a.c, Unit> d;
            public final /* synthetic */ Function0<Unit> e;
            public final /* synthetic */ long f;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> g;
            public final /* synthetic */ z h;
            public final /* synthetic */ Dp i;
            public final /* synthetic */ boolean j;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRendererKt$defaultAdWebViewRenderer$2$1$1$1$1$1", f = "AdWebViewRenderer.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a, reason: collision with other inner class name */
            public static final class C0565a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f6330a;
                public final /* synthetic */ MutableState<Boolean> b;
                public final /* synthetic */ MutableStateFlow<Boolean> c;

                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a$a, reason: collision with other inner class name */
                public static final class C0566a<T> implements FlowCollector {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ MutableStateFlow<Boolean> f6331a;

                    public C0566a(MutableStateFlow<Boolean> mutableStateFlow) {
                        this.f6331a = mutableStateFlow;
                    }

                    public final Object a(boolean z, Continuation<? super Unit> continuation) {
                        this.f6331a.setValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return a(((Boolean) obj).booleanValue(), continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0565a(MutableState<Boolean> mutableState, MutableStateFlow<Boolean> mutableStateFlow, Continuation<? super C0565a> continuation) {
                    super(2, continuation);
                    this.b = mutableState;
                    this.c = mutableStateFlow;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0565a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0565a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6330a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        final MutableState<Boolean> mutableState = this.b;
                        Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(b.c.a.C0565a.a(MutableState.this));
                            }
                        });
                        C0566a c0566a = new C0566a(this.c);
                        this.f6330a = 1;
                        if (snapshotFlow.collect(c0566a, this) == coroutine_suspended) {
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

                public static final boolean a(MutableState mutableState) {
                    return ((Boolean) mutableState.getValue()).booleanValue();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(MutableStateFlow<Boolean> mutableStateFlow, WebView webView, int i, Function1<? super a.AbstractC0571a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, z zVar, Dp dp, boolean z) {
                this.f6329a = mutableStateFlow;
                this.b = webView;
                this.c = i;
                this.d = function1;
                this.e = function0;
                this.f = j;
                this.g = function2;
                this.h = zVar;
                this.i = dp;
                this.j = z;
            }

            public final void a(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126697744, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:148)");
                }
                composer.startReplaceableGroup(1335678415);
                MutableStateFlow<Boolean> mutableStateFlow = this.f6329a;
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableStateFlow.getValue(), null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                composer.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
                composer.startReplaceableGroup(1335682252);
                boolean changed = composer.changed(mutableState) | composer.changed(this.f6329a);
                MutableStateFlow<Boolean> mutableStateFlow2 = this.f6329a;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new C0565a(mutableState, mutableStateFlow2, null);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 6);
                b.a(this.b, this.c, mutableState, this.d, this.e, null, this.f, this.g.invoke(composer, 0), this.h, this.i.m6403unboximpl(), this.j, composer, 384, 0, 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(MutableStateFlow<Boolean> mutableStateFlow, WebView webView, int i, Function1<? super a.AbstractC0571a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, z zVar, Dp dp, boolean z) {
            this.f6328a = mutableStateFlow;
            this.b = webView;
            this.c = i;
            this.d = function1;
            this.e = function0;
            this.f = j;
            this.g = function2;
            this.h = zVar;
            this.i = dp;
            this.j = z;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1932677773, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:147)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, -126697744, true, new a(this.f6328a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(WebView webView, int i, MutableState mutableState, Function1 function1, Function0 function0, Modifier modifier, long j, Function10 function10, z zVar, float f, boolean z, int i2, int i3, int i4, Composer composer, int i5) {
        a(webView, i, mutableState, function1, function0, modifier, j, function10, zVar, f, z, composer, i2 | 1, i3, i4);
        return Unit.INSTANCE;
    }

    public static final void c(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static final Unit d(MutableStateFlow mutableStateFlow, Function0 function0) {
        c(mutableStateFlow, function0);
        return Unit.INSTANCE;
    }

    public static final Unit e(MutableStateFlow mutableStateFlow, Function0 function0) {
        c(mutableStateFlow, function0);
        return Unit.INSTANCE;
    }

    public static final Unit a(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, WebView webView, int i, Function1 function1, Function0 function0, Function9 function9, z zVar, Function10 function10, Function10 function102, int i2, Composer composer, int i3) {
        a(activity, iVar, webView, i, function1, function0, function9, zVar, function10, function102, composer, i2 | 1);
        return Unit.INSTANCE;
    }

    public static final Unit b(MutableStateFlow mutableStateFlow, Function0 function0) {
        a((MutableStateFlow<Boolean>) mutableStateFlow, (Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    public static final Unit a(Activity activity, WebView webView, int i, Function1 function1, Function0 function0, Function9 function9, z zVar, int i2, Composer composer, int i3) {
        a(activity, webView, i, function1, function0, function9, zVar, composer, i2 | 1);
        return Unit.INSTANCE;
    }

    public static final float a() {
        return f6325a;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final WebView webView, final int i, final MutableState<Boolean> mutableState, Function1<? super a.AbstractC0571a.c, Unit> function1, final Function0<Unit> function0, Modifier modifier, long j, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, final z zVar, final float f, final boolean z, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Function0<Unit> function02;
        Modifier modifier2;
        int i6;
        long j2;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102;
        z zVar2;
        int i7;
        int i8;
        Modifier modifier3;
        long j3;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function103;
        int i9;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function104;
        int i10;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function105;
        BoxScopeInstance boxScopeInstance;
        final Function1<? super a.AbstractC0571a.c, Unit> function12;
        Composer composer2;
        final long j4;
        final Modifier modifier4;
        final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function106;
        ScopeUpdateScope endRestartGroup;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1592744116);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(webView) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i5 |= startRestartGroup.changed(function1) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 24576) == 0) {
                i5 |= startRestartGroup.changed(function02) ? 16384 : 8192;
            }
        }
        int i12 = i4 & 32;
        if (i12 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((196608 & i2) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
            i6 = i4 & 64;
            if (i6 == 0) {
                i5 |= 1572864;
                j2 = j;
            } else {
                j2 = j;
                if ((i2 & 1572864) == 0) {
                    i5 |= startRestartGroup.changed(j2) ? 1048576 : 524288;
                }
            }
            if ((i2 & 12582912) != 0) {
                if ((i4 & 128) == 0) {
                    function102 = function10;
                    if (startRestartGroup.changed(function102)) {
                        i11 = 8388608;
                        i5 |= i11;
                    }
                } else {
                    function102 = function10;
                }
                i11 = 4194304;
                i5 |= i11;
            } else {
                function102 = function10;
            }
            if ((i4 & 256) == 0) {
                i5 |= 100663296;
            } else if ((i2 & 100663296) == 0) {
                zVar2 = zVar;
                i5 |= startRestartGroup.changed(zVar2) ? 67108864 : 33554432;
                if ((i4 & 512) != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
                    i5 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
                }
                if ((i4 & 1024) != 0) {
                    i7 = i12;
                    i8 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    i7 = i12;
                    i8 = i3 | (startRestartGroup.changed(z) ? 4 : 2);
                } else {
                    i7 = i12;
                    i8 = i3;
                }
                if ((i5 & 306783379) != 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    function12 = function1;
                    composer2 = startRestartGroup;
                    function106 = function102;
                    j4 = j2;
                    modifier4 = modifier2;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i4 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        j3 = j2;
                        function103 = function102;
                        i9 = i5;
                        modifier3 = modifier2;
                    } else {
                        modifier3 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i6 != 0) {
                            j2 = Color.INSTANCE.m4089getBlack0d7_KjU();
                        }
                        if ((i4 & 128) != 0) {
                            function102 = q.a(null, null, 0L, 0L, 0L, null, null, null, startRestartGroup, 0, 255);
                            i5 &= -29360129;
                        }
                        j3 = j2;
                        function103 = function102;
                        i9 = i5;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1592744116, i9, i8, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRenderDisplay (AdWebViewRenderer.kt:74)");
                    }
                    Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j3, null, 2, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion = Alignment.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Modifier modifier5 = modifier3;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m527backgroundbw27NRU$default);
                    function104 = function103;
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, density, companion2.getSetDensity());
                    Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                    Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    int i13 = i8;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(webView, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), zVar2, startRestartGroup, ((i9 >> 18) & 896) | (i9 & 14) | 48, 0);
                    startRestartGroup.startReplaceableGroup(-1422949219);
                    if (function104 == null) {
                        boxScopeInstance = boxScopeInstance2;
                        i10 = i9;
                        function12 = function1;
                        function105 = function104;
                    } else {
                        startRestartGroup.startReplaceableGroup(1485611125);
                        boolean changed = startRestartGroup.changed(i);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new m(UInt.m10330boximpl(UInt.m10336constructorimpl(RangesKt.coerceAtLeast(i, 0))));
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        m mVar = (m) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        boolean booleanValue = mutableState.getValue().booleanValue();
                        startRestartGroup.startReplaceableGroup(1485623865);
                        boolean changed2 = startRestartGroup.changed(mutableState);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return b.a(MutableState.this);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        i10 = i9;
                        t.a(boxScopeInstance2, mVar, true, booleanValue, (Function0) rememberedValue2, function02, function1, function104, z, startRestartGroup, ((i9 << 3) & 458752) | 390 | ((i9 << 9) & 3670016) | ((i13 << 24) & 234881024));
                        function105 = function104;
                        startRestartGroup = startRestartGroup;
                        boxScopeInstance = boxScopeInstance2;
                        function12 = function1;
                        Unit unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceableGroup();
                    Composer composer3 = startRestartGroup;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.c(PaddingKt.m879padding3ABfNKs(boxScopeInstance.align(companion3, companion.getBottomStart()), f), null, null, null, composer3, 0, 14).invoke(boxScopeInstance, function12, composer3, Integer.valueOf(((i10 >> 6) & 112) | 6));
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composer3;
                    j4 = j3;
                    modifier4 = modifier5;
                    function106 = function105;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return b.a(webView, i, mutableState, function12, function0, modifier4, j4, function106, zVar, f, z, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            zVar2 = zVar;
            if ((i4 & 512) != 0) {
            }
            if ((i4 & 1024) != 0) {
            }
            if ((i5 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) == 0) {
            }
            if (i7 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            j3 = j2;
            function103 = function102;
            i9 = i5;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m527backgroundbw27NRU$default2 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j3, null, 2, null);
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion4.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Modifier modifier52 = modifier3;
            Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m527backgroundbw27NRU$default2);
            function104 = function103;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl2, density2, companion22.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion22.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion22.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion32 = Modifier.INSTANCE;
            int i132 = i8;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(webView, SizeKt.fillMaxSize$default(companion32, 0.0f, 1, null), zVar2, startRestartGroup, ((i9 >> 18) & 896) | (i9 & 14) | 48, 0);
            startRestartGroup.startReplaceableGroup(-1422949219);
            if (function104 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            Composer composer32 = startRestartGroup;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.c(PaddingKt.m879padding3ABfNKs(boxScopeInstance.align(companion32, companion4.getBottomStart()), f), null, null, null, composer32, 0, 14).invoke(boxScopeInstance, function12, composer32, Integer.valueOf(((i10 >> 6) & 112) | 6));
            composer32.endReplaceableGroup();
            composer32.endReplaceableGroup();
            composer32.endNode();
            composer32.endReplaceableGroup();
            composer32.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = composer32;
            j4 = j3;
            modifier4 = modifier52;
            function106 = function105;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 64;
        if (i6 == 0) {
        }
        if ((i2 & 12582912) != 0) {
        }
        if ((i4 & 256) == 0) {
        }
        zVar2 = zVar;
        if ((i4 & 512) != 0) {
        }
        if ((i4 & 1024) != 0) {
        }
        if ((i5 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) == 0) {
        }
        if (i7 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        j3 = j2;
        function103 = function102;
        i9 = i5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m527backgroundbw27NRU$default22 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), j3, null, 2, null);
        startRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion42 = Alignment.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(companion42.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Modifier modifier522 = modifier3;
        Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(m527backgroundbw27NRU$default22);
        function104 = function103;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        startRestartGroup.disableReusing();
        Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl22, rememberBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl22, density22, companion222.getSetDensity());
        Updater.m3600setimpl(m3593constructorimpl22, layoutDirection22, companion222.getSetLayoutDirection());
        Updater.m3600setimpl(m3593constructorimpl22, viewConfiguration22, companion222.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        Modifier.Companion companion322 = Modifier.INSTANCE;
        int i1322 = i8;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(webView, SizeKt.fillMaxSize$default(companion322, 0.0f, 1, null), zVar2, startRestartGroup, ((i9 >> 18) & 896) | (i9 & 14) | 48, 0);
        startRestartGroup.startReplaceableGroup(-1422949219);
        if (function104 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        Composer composer322 = startRestartGroup;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.c(PaddingKt.m879padding3ABfNKs(boxScopeInstance.align(companion322, companion42.getBottomStart()), f), null, null, null, composer322, 0, 14).invoke(boxScopeInstance, function12, composer322, Integer.valueOf(((i10 >> 6) & 112) | 6));
        composer322.endReplaceableGroup();
        composer322.endReplaceableGroup();
        composer322.endNode();
        composer322.endReplaceableGroup();
        composer322.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = composer322;
        j4 = j3;
        modifier4 = modifier522;
        function106 = function105;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final class a implements Function3<i.a, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> f6326a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MutableStateFlow<Boolean> d;
        public final /* synthetic */ Function1<a.AbstractC0571a.c, Unit> e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ z g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> function9, WebView webView, int i, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super a.AbstractC0571a.c, Unit> function1, Function0<Unit> function0, z zVar) {
            this.f6326a = function9;
            this.b = webView;
            this.c = i;
            this.d = mutableStateFlow;
            this.e = function1;
            this.f = function0;
            this.g = zVar;
        }

        public final void a(i.a aVar, Composer composer, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = (composer.changed(aVar) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1684775380, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen.<anonymous>.<anonymous> (AdWebViewRenderer.kt:218)");
            }
            if (aVar instanceof i.a.C0539a) {
                composer.startReplaceableGroup(1825931895);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1825994391);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(-1880756851);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f.a(((i.a.b) aVar).d(), null, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, Y2.b.f, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(-1880747644);
                composer.startReplaceableGroup(-1880746209);
                boolean changed = composer.changed(this.f6326a) | composer.changed(this.b) | composer.changed(this.c) | composer.changed(this.d) | composer.changed(this.e) | composer.changed(this.f) | composer.changed(this.g);
                final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> function9 = this.f6326a;
                final WebView webView = this.b;
                final int i3 = this.c;
                final MutableStateFlow<Boolean> mutableStateFlow = this.d;
                final Function1<a.AbstractC0571a.c, Unit> function1 = this.e;
                final z zVar = this.g;
                final Function0<Unit> function0 = this.f;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function12 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return b.a.a(Function9.this, webView, i3, mutableStateFlow, function1, zVar, function0, (Context) obj);
                        }
                    };
                    composer.updateRememberedValue(function12);
                    rememberedValue = function12;
                }
                composer.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) rememberedValue, null, null, composer, 0, 6);
                composer.endReplaceableGroup();
            } else {
                if (aVar != null) {
                    composer.startReplaceableGroup(-1880762669);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(1826950307);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(i.a aVar, Composer composer, Integer num) {
            a(aVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final View a(Function9 function9, WebView webView, int i, final MutableStateFlow mutableStateFlow, Function1 function1, z zVar, final Function0 function0, Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return (View) function9.invoke(it, webView, Integer.valueOf(i), mutableStateFlow, function1, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$a$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return b.a.a(MutableStateFlow.this, function0);
                }
            }, zVar, Dp.m6387boximpl(b.a()), Boolean.TRUE);
        }

        public static final Unit a(MutableStateFlow mutableStateFlow, Function0 function0) {
            b.a((MutableStateFlow<Boolean>) mutableStateFlow, (Function0<Unit>) function0);
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Function9 a(long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Color.INSTANCE.m4089getBlack0d7_KjU();
        }
        if ((i & 2) != 0) {
            function2 = C0564b.f6327a;
        }
        return a(j, (Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>>) function2);
    }

    public static final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> a(final long j, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adCloseCountdownButton) {
        Intrinsics.checkNotNullParameter(adCloseCountdownButton, "adCloseCountdownButton");
        return new Function9() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function9
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return b.a(j, adCloseCountdownButton, (Context) obj, (WebView) obj2, ((Integer) obj3).intValue(), (MutableStateFlow) obj4, (Function1) obj5, (Function0) obj6, (z) obj7, (Dp) obj8, ((Boolean) obj9).booleanValue());
            }
        };
    }

    public static final ComposeView a(long j, Function2 function2, Context context, WebView webView, int i, MutableStateFlow canClose, Function1 onButtonRendered, Function0 onClose, z zVar, Dp dp, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(canClose, "canClose");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setId(R.id.moloco_fullscreen_ad_view_id);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1932677773, true, new c(canClose, webView, i, onButtonRendered, onClose, j, function2, zVar, dp, z)));
        return composeView;
    }

    public static final void a(final Activity activity, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, final WebView webView, final int i, final Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, Function0<Unit> onClose, final Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, final z zVar, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102, Composer composer, final int i2) {
        int i3;
        final Function0<Unit> function0;
        Composer composer2;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer startRestartGroup = composer.startRestartGroup(-476084514);
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(activity) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(adViewModel) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(webView) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changed(onButtonRendered) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changed(onClose) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= startRestartGroup.changed(adWebViewRenderer) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= startRestartGroup.changed(zVar) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= startRestartGroup.changed(function10) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i3 |= startRestartGroup.changed(function102) ? 536870912 : 268435456;
        }
        int i4 = i3;
        if ((306783379 & i4) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function0 = onClose;
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476084514, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen (AdWebViewRenderer.kt:200)");
            }
            Modifier testTag = TestTagKt.testTag(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m4089getBlack0d7_KjU(), null, 2, null), "MraidAdContainerScreen");
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(testTag);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, density, companion.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1204536538);
            boolean changed = startRestartGroup.changed(i);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i == 0));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableStateFlow mutableStateFlow = (MutableStateFlow) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            State collectAsState = SnapshotStateKt.collectAsState(adViewModel.k(), null, startRestartGroup, 0, 1);
            i.a a2 = a((State<? extends i.a>) collectAsState);
            function0 = onClose;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1684775380, true, new a(adWebViewRenderer, webView, i, mutableStateFlow, onButtonRendered, onClose, zVar));
            composer2 = startRestartGroup;
            CrossfadeKt.Crossfade(a2, null, null, composableLambda, composer2, 3072, 6);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance, adViewModel, a((State<? extends i.a>) collectAsState), function102, function10, composer2, (i4 & 112) | 6 | ((i4 >> 18) & 7168) | ((i4 >> 12) & 57344));
            composer2.startReplaceableGroup(1204592495);
            boolean changed2 = composer2.changed(mutableStateFlow) | composer2.changed(function0);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.b(MutableStateFlow.this, function0);
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, composer2, 0, 1);
            s.a(activity, composer2, i4 & 14);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function02 = function0;
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b.a(activity, adViewModel, webView, i, onButtonRendered, function02, adWebViewRenderer, zVar, function10, function102, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static final void a(final Activity activity, final WebView webView, final int i, final Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, final Function0<Unit> onClose, final Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, final z zVar, Composer composer, final int i2) {
        int i3;
        final Function0<Unit> function0;
        Composer composer2;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer startRestartGroup = composer.startRestartGroup(-1336318846);
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(activity) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(webView) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changed(onButtonRendered) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changed(onClose) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changed(adWebViewRenderer) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= startRestartGroup.changed(zVar) ? 1048576 : 524288;
        }
        int i4 = i3;
        if ((599187 & i4) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1336318846, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.StaticAdWebViewScreen (AdWebViewRenderer.kt:270)");
            }
            Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m4089getBlack0d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m527backgroundbw27NRU$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, density, companion.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1609892771);
            boolean changed = startRestartGroup.changed(i);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i == 0));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableStateFlow mutableStateFlow = (MutableStateFlow) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1609900314);
            boolean changed2 = startRestartGroup.changed(adWebViewRenderer) | startRestartGroup.changed(webView) | startRestartGroup.changed(i) | startRestartGroup.changed(mutableStateFlow) | startRestartGroup.changed(onButtonRendered) | startRestartGroup.changed(onClose) | startRestartGroup.changed(zVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b.a(Function9.this, webView, i, mutableStateFlow, onButtonRendered, zVar, onClose, (Context) obj);
                    }
                };
                mutableStateFlow = mutableStateFlow;
                function0 = onClose;
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue2 = function1;
            } else {
                function0 = onClose;
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            AndroidView_androidKt.AndroidView((Function1) rememberedValue2, null, null, composer2, 0, 6);
            composer2.startReplaceableGroup(1609912856);
            boolean changed3 = composer2.changed(mutableStateFlow) | composer2.changed(function0);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.e(MutableStateFlow.this, function0);
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue3, composer2, 0, 1);
            s.a(activity, composer2, i4 & 14);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b.a(activity, webView, i, onButtonRendered, onClose, adWebViewRenderer, zVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final View a(Function9 function9, WebView webView, int i, final MutableStateFlow mutableStateFlow, Function1 function1, z zVar, final Function0 function0, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (View) function9.invoke(it, webView, Integer.valueOf(i), mutableStateFlow, function1, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.d(MutableStateFlow.this, function0);
            }
        }, zVar, Dp.m6387boximpl(f6325a), Boolean.FALSE);
    }

    public static final i.a a(State<? extends i.a> state) {
        return state.getValue();
    }
}
