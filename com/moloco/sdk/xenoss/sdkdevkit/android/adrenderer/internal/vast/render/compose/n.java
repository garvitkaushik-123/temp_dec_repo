package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.moloco.sdk.R;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class n {

    public static final class a implements Function3<i.a, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i f6233a;
        public final /* synthetic */ Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> b;
        public final /* synthetic */ Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> c;
        public final /* synthetic */ Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> d;
        public final /* synthetic */ Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> e;
        public final /* synthetic */ K f;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i g;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0550a extends FunctionReferenceImpl implements Function0<Unit> {
            public C0550a(Object obj) {
                super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onReplay", "onReplay()V", 0);
            }

            public final void a() {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).B();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function7, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function5, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function6, Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function72, K k, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar2) {
            this.f6233a = iVar;
            this.b = function7;
            this.c = function5;
            this.d = function6;
            this.e = function72;
            this.f = k;
            this.g = iVar2;
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
                ComposerKt.traceEventStart(-1837331254, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastRenderer.<anonymous>.<anonymous> (VastRenderer.kt:88)");
            }
            if (aVar instanceof i.a.C0539a) {
                composer.startReplaceableGroup(1864270639);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h d = ((i.a.C0539a) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar = this.f6233a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.a.a(d, iVar != null ? iVar.a() : null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 384, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1864278356);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k d2 = ((i.a.c) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2 = this.f6233a;
                Function0<Unit> c = iVar2 != null ? iVar2.c() : null;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7 = this.b;
                Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5 = this.c;
                Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> function6 = this.d;
                Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> function72 = this.e;
                K k = this.f;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar3 = this.g;
                composer.startReplaceableGroup(1864289963);
                boolean changed = composer.changed(iVar3);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new C0550a(iVar3);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(d2, c, fillMaxSize$default, function7, function5, function6, function72, k, (Function0) ((KFunction) rememberedValue), composer, 384, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(1864292898);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e d3 = ((i.a.b) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar4 = this.f6233a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f.a(d3, iVar4 != null ? iVar4.b() : null, this.d, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 3072, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(1958779838);
                composer.endReplaceableGroup();
            } else {
                if (aVar != null) {
                    composer.startReplaceableGroup(1864269410);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(1958818154);
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
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<a.AbstractC0571a.c, Unit> {
        public b(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(a.AbstractC0571a.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0571a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onCTA", "onCTA()V", 0);
        }

        public final void a() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).C();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<a.AbstractC0571a.c, Unit> {
        public d(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(a.AbstractC0571a.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0571a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6234a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Function0<Unit> f;

        public e(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j, Function0<Unit> function0) {
            this.f6234a = alignment;
            this.b = paddingValues;
            this.c = str;
            this.d = str2;
            this.e = j;
            this.f = function0;
        }

        public static final i.a b(State<? extends i.a> state) {
            return state.getValue();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, StateFlow<? extends i.a> stateFlow, Function1<? super a.AbstractC0571a.c, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), stateFlow, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(BoxScope boxScope, boolean z, StateFlow<? extends i.a> currentAdPartFlow, Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, Function0<Unit> onCTA, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(currentAdPartFlow, "currentAdPartFlow");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            Intrinsics.checkNotNullParameter(onCTA, "onCTA");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(432764356, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous> (VastRenderer.kt:295)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f6234a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1004334236, true, new a(onButtonRendered, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, (i >> 6) & 14, 1), this.c, this.d, this.e, onCTA, this.f)), composer, ((i >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<a.AbstractC0571a.c, Unit> f6235a;
            public final /* synthetic */ State<i.a> b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ long e;
            public final /* synthetic */ Function0<Unit> f;
            public final /* synthetic */ Function0<Unit> g;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super a.AbstractC0571a.c, Unit> function1, State<? extends i.a> state, String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                this.f6235a = function1;
                this.b = state;
                this.c = str;
                this.d = str2;
                this.e = j;
                this.f = function0;
                this.g = function02;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1004334236, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous> (VastRenderer.kt:314)");
                }
                i.a b2 = e.b(this.b);
                if (b2 instanceof i.a.C0539a) {
                    composer.startReplaceableGroup(1203578611);
                    v.a(null, a.AbstractC0571a.c.EnumC0573a.g, this.f6235a, ComposableLambdaKt.composableLambda(composer, -832302220, true, new C0551a(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.c) {
                    composer.startReplaceableGroup(1204169843);
                    v.a(null, a.AbstractC0571a.c.EnumC0573a.g, this.f6235a, ComposableLambdaKt.composableLambda(composer, 1517460509, true, new b(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.b) {
                    composer.startReplaceableGroup(1204743343);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.d) {
                    composer.startReplaceableGroup(1204828748);
                    composer.endReplaceableGroup();
                } else {
                    if (b2 != null) {
                        composer.startReplaceableGroup(-1485196921);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(1204863499);
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f6237a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ Function0<Unit> d;
                public final /* synthetic */ Function0<Unit> e;

                public b(String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                    this.f6237a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = function0;
                    this.e = function02;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1517460509, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:337)");
                    }
                    String str = this.f6237a;
                    String str2 = this.b;
                    long j = this.c;
                    composer.startReplaceableGroup(-1483979143);
                    boolean changed = composer.changed(this.d) | composer.changed(this.e);
                    final Function0<Unit> function0 = this.d;
                    final Function0<Unit> function02 = this.e;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$b$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return n.e.a.b.a(Function0.this, function02);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.a(it, str, str2, j, (Function0) rememberedValue, composer, i & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public static final Unit a(Function0 function0, Function0 function02) {
                    function0.invoke();
                    if (function02 != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$a, reason: collision with other inner class name */
            public static final class C0551a implements Function3<Modifier, Composer, Integer, Unit> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f6236a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ Function0<Unit> d;
                public final /* synthetic */ Function0<Unit> e;

                public C0551a(String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                    this.f6236a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = function0;
                    this.e = function02;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-832302220, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:320)");
                    }
                    String str = this.f6236a;
                    String str2 = this.b;
                    long j = this.c;
                    composer.startReplaceableGroup(-1483998215);
                    boolean changed = composer.changed(this.d) | composer.changed(this.e);
                    final Function0<Unit> function0 = this.d;
                    final Function0<Unit> function02 = this.e;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$a$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return n.e.a.C0551a.a(Function0.this, function02);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.a(it, str, str2, j, (Function0) rememberedValue, composer, i & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public static final Unit a(Function0 function0, Function0 function02) {
                    function0.invoke();
                    if (function02 != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public static final class f implements Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit>, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6238a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ Painter c;
        public final /* synthetic */ Painter d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ long f;
        public final /* synthetic */ long g;
        public final /* synthetic */ long h;
        public final /* synthetic */ Shape i;
        public final /* synthetic */ long j;

        public f(Alignment alignment, PaddingValues paddingValues, Painter painter, Painter painter2, Function0<Unit> function0, long j, long j2, long j3, Shape shape, long j4) {
            this.f6238a = alignment;
            this.b = paddingValues;
            this.c = painter;
            this.d = painter2;
            this.e = function0;
            this.f = j;
            this.g = j2;
            this.h = j3;
            this.i = shape;
            this.j = j4;
        }

        public static final a.AbstractC0571a.c b(MutableState<a.AbstractC0571a.c> mutableState) {
            return mutableState.getValue();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, Boolean bool2, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit> function2, Function1<? super Boolean, ? extends Unit> function1, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), bool2.booleanValue(), function2, function1, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final void b(MutableState<a.AbstractC0571a.c> mutableState, a.AbstractC0571a.c cVar) {
            mutableState.setValue(cVar);
        }

        public final void a(BoxScope boxScope, boolean z, boolean z2, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit> onButtonReplaced, Function1<? super Boolean, Unit> onMuteChange, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonReplaced, "onButtonReplaced");
            Intrinsics.checkNotNullParameter(onMuteChange, "onMuteChange");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(onButtonReplaced) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= composer.changed(onMuteChange) ? 16384 : 8192;
            }
            int i3 = i2;
            if ((74899 & i3) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-545982054, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton.<anonymous> (VastRenderer.kt:231)");
            }
            composer.startReplaceableGroup(-1304253431);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(a.AbstractC0571a.c.EnumC0573a.e), null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f6238a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -2071462974, true, new a(z2, this.c, this.d, (MutableState) rememberedValue, onButtonReplaced, onMuteChange, this.e, z, this.f, this.g, this.h, this.i, this.j)), composer, ((i3 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f6239a;
            public final /* synthetic */ Painter b;
            public final /* synthetic */ Painter c;
            public final /* synthetic */ MutableState<a.AbstractC0571a.c> d;
            public final /* synthetic */ Function2<a.AbstractC0571a.c, a.AbstractC0571a.c.EnumC0573a, Unit> e;
            public final /* synthetic */ Function1<Boolean, Unit> f;
            public final /* synthetic */ Function0<Unit> g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ long i;
            public final /* synthetic */ long j;
            public final /* synthetic */ long k;
            public final /* synthetic */ Shape l;
            public final /* synthetic */ long m;

            /* JADX WARN: Multi-variable type inference failed */
            public a(boolean z, Painter painter, Painter painter2, MutableState<a.AbstractC0571a.c> mutableState, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit> function2, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, boolean z2, long j, long j2, long j3, Shape shape, long j4) {
                this.f6239a = z;
                this.b = painter;
                this.c = painter2;
                this.d = mutableState;
                this.e = function2;
                this.f = function1;
                this.g = function0;
                this.h = z2;
                this.i = j;
                this.j = j2;
                this.k = j3;
                this.l = shape;
                this.m = j4;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2071462974, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton.<anonymous>.<anonymous> (VastRenderer.kt:242)");
                }
                Painter painter = this.f6239a ? this.b : this.c;
                Modifier.Companion companion = Modifier.INSTANCE;
                a.AbstractC0571a.c b = f.b(this.d);
                composer.startReplaceableGroup(-133207083);
                boolean changed = composer.changed(this.d) | composer.changed(this.e) | composer.changed(this.f6239a);
                final Function2<a.AbstractC0571a.c, a.AbstractC0571a.c.EnumC0573a, Unit> function2 = this.e;
                final boolean z = this.f6239a;
                final MutableState<a.AbstractC0571a.c> mutableState = this.d;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$f$a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return n.f.a.a(Function2.this, z, mutableState, (a.AbstractC0571a.c) obj);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a.a(companion, b, (Function1<? super a.AbstractC0571a.c, Unit>) rememberedValue);
                composer.startReplaceableGroup(-133199999);
                final String str = "mute_button";
                boolean changed2 = composer.changed("mute_button");
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$f$a$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return n.f.a.a(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(a2, false, (Function1) rememberedValue2, 1, null);
                composer.startReplaceableGroup(-133193669);
                boolean changed3 = composer.changed(this.f) | composer.changed(this.f6239a) | composer.changed(this.d) | composer.changed(this.e) | composer.changed(this.g);
                final Function1<Boolean, Unit> function1 = this.f;
                final boolean z2 = this.f6239a;
                final Function2<a.AbstractC0571a.c, a.AbstractC0571a.c.EnumC0573a, Unit> function22 = this.e;
                final Function0<Unit> function0 = this.g;
                final MutableState<a.AbstractC0571a.c> mutableState2 = this.d;
                Object rememberedValue3 = composer.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$f$a$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return n.f.a.a(Function1.this, z2, function22, function0, mutableState2);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                r.a(painter, (Function0) rememberedValue3, semantics$default, this.h, "mute/unmute", this.i, this.j, this.k, this.l, this.m, composer, 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public static final Unit a(Function2 function2, boolean z, MutableState mutableState, a.AbstractC0571a.c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                f.b(mutableState, it);
                function2.invoke(f.b(mutableState), z ? a.AbstractC0571a.c.EnumC0573a.e : a.AbstractC0571a.c.EnumC0573a.f);
                return Unit.INSTANCE;
            }

            public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, str);
                SemanticsPropertiesKt.setTestTag(semantics, str);
                return Unit.INSTANCE;
            }

            public static final Unit a(Function1 function1, boolean z, Function2 function2, Function0 function0, MutableState mutableState) {
                function1.invoke(Boolean.valueOf(!z));
                f.b(mutableState, new a.AbstractC0571a.c(z ? a.AbstractC0571a.c.EnumC0573a.e : a.AbstractC0571a.c.EnumC0573a.f, f.b(mutableState).e(), f.b(mutableState).f()));
                function2.invoke(f.b(mutableState), z ? a.AbstractC0571a.c.EnumC0573a.f : a.AbstractC0571a.c.EnumC0573a.e);
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static final class g implements Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6240a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ long c;

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f6241a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i b;
            public final /* synthetic */ long c;

            public a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, long j) {
                this.f6241a = z;
                this.b = iVar;
                this.c = j;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1435522410, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous>.<anonymous> (VastRenderer.kt:378)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m.a(this.f6241a, this.b, null, this.c, composer, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        public g(Alignment alignment, PaddingValues paddingValues, long j) {
            this.f6240a = alignment;
            this.b = paddingValues;
            this.c = j;
        }

        public final void a(BoxScope boxScope, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(progress, "progress");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= composer.changed(progress) ? 256 : 128;
            }
            if ((i2 & 1171) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1967084142, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous> (VastRenderer.kt:370)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z || ((progress instanceof i.c) && ((i.c) progress).c() > 0), PaddingKt.padding(boxScope.align(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), this.f6240a), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -1435522410, true, new a(z, progress, this.c)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class h implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final h f6242a = new h();

        public final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(838284708);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(838284708, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:174)");
            }
            Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a2 = n.a(0L, 0L, null, 0L, null, null, 0L, null, null, null, composer, 0, 1023);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class i implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final i f6243a = new i();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-562763068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-562763068, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:175)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
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

    public static final class j implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f6244a = new j();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-450891997);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450891997, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:176)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
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

    public static final class k implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final k f6245a = new k();

        public final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-832109727);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-832109727, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:177)");
            }
            Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a2 = n.a(null, null, 0L, null, null, null, composer, 0, 63);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class l implements Function2<Composer, Integer, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final l f6246a = new l();

        public final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(976926819);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(976926819, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:179)");
            }
            Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a2 = n.a(null, null, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class m implements Function2<Composer, Integer, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public static final m f6247a = new m();

        public final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(658271039);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(658271039, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:180)");
            }
            Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(null, null, composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$n, reason: collision with other inner class name */
    public static final class C0552n implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final C0552n f6248a = new C0552n();

        public final Void a(Composer composer, int i) {
            composer.startReplaceableGroup(-1106742594);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106742594, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:181)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((Composer) obj, ((Number) obj2).intValue());
        }
    }

    public static final class o implements Function2<Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f6249a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit>> c;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> d;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> e;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit>> f;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i g;
        public final /* synthetic */ Function2<Composer, Integer, Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit>> h;
        public final /* synthetic */ Function2<Composer, Integer, Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit>> i;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit>> j;
        public final /* synthetic */ K k;

        public static final class a implements Function2<Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f6250a;
            public final /* synthetic */ long b;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit>> c;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> d;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> e;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit>> f;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i g;
            public final /* synthetic */ Function2<Composer, Integer, Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit>> h;
            public final /* synthetic */ Function2<Composer, Integer, Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit>> i;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit>> j;
            public final /* synthetic */ K k;

            /* JADX WARN: Multi-variable type inference failed */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> function2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function22, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function23, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> function25, Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function26, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function27, K k) {
                this.f6250a = iVar;
                this.b = j;
                this.c = function2;
                this.d = function22;
                this.e = function23;
                this.f = function24;
                this.g = iVar2;
                this.h = function25;
                this.i = function26;
                this.j = function27;
                this.k = k;
            }

            public final void a(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(831245532, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:189)");
                }
                n.a(this.f6250a, null, this.b, this.c.invoke(composer, 0), this.d.invoke(composer, 0), this.e.invoke(composer, 0), this.f.invoke(composer, 0), this.g, this.h.invoke(composer, 0), this.i.invoke(composer, 0), this.j.invoke(composer, 0), this.k, composer, 0, 0, 2);
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
        public o(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> function2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function22, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function23, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> function25, Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function26, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function27, K k) {
            this.f6249a = iVar;
            this.b = j;
            this.c = function2;
            this.d = function22;
            this.e = function23;
            this.f = function24;
            this.g = iVar2;
            this.h = function25;
            this.i = function26;
            this.j = function27;
            this.k = k;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876197241, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:188)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, 831245532, true, new a(this.f6249a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k)), composer, 48, 1);
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

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, Modifier modifier, long j2, Function7 function7, Function10 function10, Function10 function102, Function7 function72, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function5 function5, Function6 function6, Function7 function73, K k2, int i2, int i3, int i4, Composer composer, int i5) {
        a(iVar, modifier, j2, function7, function10, function102, function72, iVar2, function5, function6, function73, k2, composer, i2 | 1, i3, i4);
        return Unit.INSTANCE;
    }

    public static final boolean b(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b6  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.compose.foundation.layout.PaddingValues, androidx.compose.ui.Alignment] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, Modifier modifier, long j2, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function7, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function72, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function5, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function6, Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function73, final K viewVisibilityTracker, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        long j3;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function103;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function104;
        Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function74;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function75;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function105;
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function106;
        Modifier modifier3;
        ?? r13;
        int i13;
        Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function76;
        Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function52;
        Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function62;
        Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function77;
        Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function53;
        Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function63;
        int i14;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2;
        Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function78;
        final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar3;
        int i15;
        Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function79;
        Composer composer3;
        boolean changed;
        Object rememberedValue;
        Composer composer4;
        final Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function54;
        final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function107;
        final Modifier modifier4;
        final Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function710;
        final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function108;
        final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar4;
        final Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function64;
        final Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function711;
        final Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function712;
        final long j4;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        int i18;
        int i19;
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Composer startRestartGroup = composer.startRestartGroup(1056246356);
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(adViewModel) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i20 = i4 & 2;
        if (i20 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
                j3 = j2;
            } else {
                j3 = j2;
                if ((i2 & 384) == 0) {
                    i5 |= startRestartGroup.changed(j3) ? 256 : 128;
                }
            }
            if ((i2 & 3072) == 0) {
                if ((i4 & 8) == 0 && startRestartGroup.changed(function7)) {
                    i19 = 2048;
                    i5 |= i19;
                }
                i19 = 1024;
                i5 |= i19;
            }
            if ((i2 & 24576) != 0) {
                if ((i4 & 16) == 0) {
                    function103 = function10;
                    if (startRestartGroup.changed(function103)) {
                        i18 = 16384;
                        i5 |= i18;
                    }
                } else {
                    function103 = function10;
                }
                i18 = 8192;
                i5 |= i18;
            } else {
                function103 = function10;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                function104 = function102;
                i5 |= ((i4 & 32) == 0 && startRestartGroup.changed(function104)) ? 131072 : 65536;
            } else {
                function104 = function102;
            }
            if ((i2 & 1572864) != 0) {
                function74 = function72;
                i5 |= ((i4 & 64) == 0 && startRestartGroup.changed(function74)) ? 1048576 : 524288;
            } else {
                function74 = function72;
            }
            i7 = i4 & 128;
            if (i7 == 0) {
                i5 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                i8 = i5 | (startRestartGroup.changed(iVar) ? 8388608 : 4194304);
                if ((i2 & 100663296) == 0) {
                    if ((i4 & 256) == 0 && startRestartGroup.changed(function5)) {
                        i17 = 67108864;
                        i8 |= i17;
                    }
                    i17 = 33554432;
                    i8 |= i17;
                }
                if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
                    if ((i4 & 512) == 0 && startRestartGroup.changed(function6)) {
                        i16 = 536870912;
                        i8 |= i16;
                    }
                    i16 = 268435456;
                    i8 |= i16;
                }
                i9 = i8;
                i10 = i4 & 1024;
                if (i10 != 0) {
                    i12 = i3 | 6;
                    i11 = i10;
                } else {
                    i11 = i10;
                    if ((i3 & 6) == 0) {
                        i12 = i3 | (startRestartGroup.changed(function73) ? 4 : 2);
                    } else {
                        i12 = i3;
                    }
                }
                if ((i4 & 2048) != 0) {
                    i12 |= 48;
                } else if ((i3 & 48) == 0) {
                    i12 |= startRestartGroup.changed(viewVisibilityTracker) ? 32 : 16;
                }
                int i21 = i12;
                if ((i9 & 306783379) != 306783378 && (i21 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    iVar3 = adViewModel;
                    function64 = function6;
                    j4 = j3;
                    function107 = function103;
                    function108 = function104;
                    modifier4 = modifier2;
                    composer4 = startRestartGroup;
                    function712 = function74;
                    function711 = function7;
                    iVar4 = iVar;
                    function54 = function5;
                    function710 = function73;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier modifier5 = i20 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i6 != 0) {
                            j3 = Color.INSTANCE.m4089getBlack0d7_KjU();
                        }
                        long j5 = j3;
                        if ((i4 & 8) != 0) {
                            composer2 = startRestartGroup;
                            i9 &= -7169;
                            function75 = a(0L, 0L, null, 0L, null, null, 0L, null, null, null, startRestartGroup, 0, 1023);
                        } else {
                            composer2 = startRestartGroup;
                            function75 = function7;
                        }
                        int i22 = i9;
                        if ((i4 & 16) != 0) {
                            i22 &= -57345;
                            function105 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(null, null, 0L, 0L, 0L, null, null, null, composer2, 0, 255);
                        } else {
                            function105 = function103;
                        }
                        if ((i4 & 32) != 0) {
                            i22 &= -458753;
                            function106 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(null, null, 0L, 0L, 0L, null, null, null, composer2, 0, 255);
                        } else {
                            function106 = function104;
                        }
                        int i23 = i22;
                        if ((i4 & 64) != 0) {
                            modifier3 = modifier5;
                            r13 = 0;
                            i13 = 0;
                            function76 = a(null, null, 0L, null, null, null, composer2, 0, 63);
                            i23 &= -3670017;
                        } else {
                            modifier3 = modifier5;
                            r13 = 0;
                            i13 = 0;
                            function76 = function74;
                        }
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar5 = i7 != 0 ? r13 : iVar;
                        if ((i4 & 256) != 0) {
                            Composer composer5 = composer2;
                            function52 = a(null, null, 0L, composer5, 0, 7);
                            startRestartGroup = composer5;
                            i23 &= -234881025;
                        } else {
                            startRestartGroup = composer2;
                            function52 = function5;
                        }
                        if ((i4 & 512) != 0) {
                            function62 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(r13, r13, startRestartGroup, i13, 3);
                            i23 &= -1879048193;
                        } else {
                            function62 = function6;
                        }
                        if (i11 != 0) {
                            function53 = function52;
                            function63 = function62;
                            function77 = r13;
                        } else {
                            function77 = function73;
                            function53 = function52;
                            function63 = function62;
                        }
                        i14 = i23;
                        modifier2 = modifier3;
                        function103 = function105;
                        iVar2 = iVar5;
                        j3 = j5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i4 & 8) != 0) {
                            i9 &= -7169;
                        }
                        if ((i4 & 16) != 0) {
                            i9 &= -57345;
                        }
                        if ((i4 & 32) != 0) {
                            i9 &= -458753;
                        }
                        if ((i4 & 64) != 0) {
                            i9 &= -3670017;
                        }
                        if ((i4 & 256) != 0) {
                            i9 &= -234881025;
                        }
                        if ((i4 & 512) != 0) {
                            i9 &= -1879048193;
                        }
                        function75 = function7;
                        iVar2 = iVar;
                        function63 = function6;
                        function76 = function74;
                        i14 = i9;
                        function77 = function73;
                        function106 = function104;
                        function53 = function5;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1056246356, i14, i21, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastRenderer (VastRenderer.kt:79)");
                    }
                    Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), j3, null, 2, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    Alignment.Companion companion = Alignment.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    int i24 = i14;
                    LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    function78 = function76;
                    ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    long j6 = j3;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m527backgroundbw27NRU$default);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar6 = iVar2;
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
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    State collectAsState = SnapshotStateKt.collectAsState(adViewModel.k(), null, startRestartGroup, 0, 1);
                    i.a a2 = a(collectAsState);
                    Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function55 = function53;
                    Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function65 = function63;
                    Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function713 = function77;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1837331254, true, new a(iVar6, function75, function55, function65, function713, viewVisibilityTracker, adViewModel));
                    Composer composer6 = startRestartGroup;
                    CrossfadeKt.Crossfade(a2, null, null, composableLambda, composer6, 3072, 6);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance, adViewModel, a(collectAsState), function106, function103, composer6, ((i24 << 3) & 112) | 6 | ((i24 >> 6) & 7168) | (i24 & 57344));
                    iVar3 = adViewModel;
                    composer6.startReplaceableGroup(-1443724119);
                    if (function78 == null) {
                        i15 = 6;
                        composer3 = composer6;
                        function79 = function78;
                    } else {
                        i15 = 6;
                        Boolean valueOf = Boolean.valueOf(b(SnapshotStateKt.collectAsState(iVar3.o(), null, composer6, 0, 1)));
                        StateFlow<i.a> k2 = iVar3.k();
                        composer6.startReplaceableGroup(1864315475);
                        boolean changed2 = composer6.changed(iVar3);
                        Object rememberedValue2 = composer6.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new b(iVar3);
                            composer6.updateRememberedValue(rememberedValue2);
                        }
                        KFunction kFunction = (KFunction) rememberedValue2;
                        composer6.endReplaceableGroup();
                        composer6.startReplaceableGroup(1864316968);
                        boolean changed3 = composer6.changed(iVar3);
                        Object rememberedValue3 = composer6.rememberedValue();
                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new c(iVar3);
                            composer6.updateRememberedValue(rememberedValue3);
                        }
                        composer6.endReplaceableGroup();
                        function78.invoke(boxScopeInstance, valueOf, k2, kFunction, (KFunction) rememberedValue3, composer6, 6);
                        function79 = function78;
                        boxScopeInstance = boxScopeInstance;
                        composer3 = composer6;
                        Unit unit = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    Composer composer7 = composer3;
                    Function5<BoxScope, Function1<? super a.AbstractC0571a.c, Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> b2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.b(PaddingKt.m879padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, companion.getBottomStart()), Dp.m6389constructorimpl(12)), null, null, null, composer7, 0, 14);
                    composer7.startReplaceableGroup(-1443710796);
                    changed = composer7.changed(iVar3);
                    rememberedValue = composer7.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new d(iVar3);
                        composer7.updateRememberedValue(rememberedValue);
                    }
                    composer7.endReplaceableGroup();
                    b2.invoke(boxScopeInstance, (KFunction) rememberedValue, iVar3.k(), composer7, Integer.valueOf(i15));
                    composer4 = composer7;
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function54 = function55;
                    function107 = function103;
                    modifier4 = modifier2;
                    function710 = function713;
                    function108 = function106;
                    iVar4 = iVar6;
                    function64 = function65;
                    function711 = function75;
                    function712 = function79;
                    j4 = j6;
                }
                endRestartGroup = composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return n.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.this, modifier4, j4, function711, function107, function108, function712, iVar4, function54, function64, function710, viewVisibilityTracker, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i8 = i5;
            if ((i2 & 100663296) == 0) {
            }
            if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            }
            i9 = i8;
            i10 = i4 & 1024;
            if (i10 != 0) {
            }
            if ((i4 & 2048) != 0) {
            }
            int i212 = i12;
            if ((i9 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i20 != 0) {
            }
            if (i6 != 0) {
            }
            long j52 = j3;
            if ((i4 & 8) != 0) {
            }
            int i222 = i9;
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) != 0) {
            }
            int i232 = i222;
            if ((i4 & 64) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if ((i4 & 512) != 0) {
            }
            if (i11 != 0) {
            }
            i14 = i232;
            modifier2 = modifier3;
            function103 = function105;
            iVar2 = iVar5;
            j3 = j52;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m527backgroundbw27NRU$default2 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), j3, null, 2, null);
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            int i242 = i14;
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            function78 = function76;
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            long j62 = j3;
            Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m527backgroundbw27NRU$default2);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar62 = iVar2;
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
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            State collectAsState2 = SnapshotStateKt.collectAsState(adViewModel.k(), null, startRestartGroup, 0, 1);
            i.a a22 = a(collectAsState2);
            Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function552 = function53;
            Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function652 = function63;
            Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function7132 = function77;
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -1837331254, true, new a(iVar62, function75, function552, function652, function7132, viewVisibilityTracker, adViewModel));
            Composer composer62 = startRestartGroup;
            CrossfadeKt.Crossfade(a22, null, null, composableLambda2, composer62, 3072, 6);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance2, adViewModel, a(collectAsState2), function106, function103, composer62, ((i242 << 3) & 112) | 6 | ((i242 >> 6) & 7168) | (i242 & 57344));
            iVar3 = adViewModel;
            composer62.startReplaceableGroup(-1443724119);
            if (function78 == null) {
            }
            composer3.endReplaceableGroup();
            Composer composer72 = composer3;
            Function5<BoxScope, Function1<? super a.AbstractC0571a.c, Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> b22 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.b(PaddingKt.m879padding3ABfNKs(boxScopeInstance2.align(Modifier.INSTANCE, companion3.getBottomStart()), Dp.m6389constructorimpl(12)), null, null, null, composer72, 0, 14);
            composer72.startReplaceableGroup(-1443710796);
            changed = composer72.changed(iVar3);
            rememberedValue = composer72.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new d(iVar3);
            composer72.updateRememberedValue(rememberedValue);
            composer72.endReplaceableGroup();
            b22.invoke(boxScopeInstance2, (KFunction) rememberedValue, iVar3.k(), composer72, Integer.valueOf(i15));
            composer4 = composer72;
            composer4.endReplaceableGroup();
            composer4.endReplaceableGroup();
            composer4.endNode();
            composer4.endReplaceableGroup();
            composer4.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            function54 = function552;
            function107 = function103;
            modifier4 = modifier2;
            function710 = function7132;
            function108 = function106;
            iVar4 = iVar62;
            function64 = function652;
            function711 = function75;
            function712 = function79;
            j4 = j62;
            endRestartGroup = composer4.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i2 & 1572864) != 0) {
        }
        i7 = i4 & 128;
        if (i7 == 0) {
        }
        i8 = i5;
        if ((i2 & 100663296) == 0) {
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
        }
        i9 = i8;
        i10 = i4 & 1024;
        if (i10 != 0) {
        }
        if ((i4 & 2048) != 0) {
        }
        int i2122 = i12;
        if ((i9 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i20 != 0) {
        }
        if (i6 != 0) {
        }
        long j522 = j3;
        if ((i4 & 8) != 0) {
        }
        int i2222 = i9;
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) != 0) {
        }
        int i2322 = i2222;
        if ((i4 & 64) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if ((i4 & 512) != 0) {
        }
        if (i11 != 0) {
        }
        i14 = i2322;
        modifier2 = modifier3;
        function103 = function105;
        iVar2 = iVar5;
        j3 = j522;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m527backgroundbw27NRU$default22 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), j3, null, 2, null);
        startRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion32 = Alignment.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(companion32.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        int i2422 = i14;
        LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        function78 = function76;
        ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        long j622 = j3;
        Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(m527backgroundbw27NRU$default22);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar622 = iVar2;
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
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        State collectAsState22 = SnapshotStateKt.collectAsState(adViewModel.k(), null, startRestartGroup, 0, 1);
        i.a a222 = a(collectAsState22);
        Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function5522 = function53;
        Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function6522 = function63;
        Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function71322 = function77;
        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, -1837331254, true, new a(iVar622, function75, function5522, function6522, function71322, viewVisibilityTracker, adViewModel));
        Composer composer622 = startRestartGroup;
        CrossfadeKt.Crossfade(a222, null, null, composableLambda22, composer622, 3072, 6);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance22, adViewModel, a(collectAsState22), function106, function103, composer622, ((i2422 << 3) & 112) | 6 | ((i2422 >> 6) & 7168) | (i2422 & 57344));
        iVar3 = adViewModel;
        composer622.startReplaceableGroup(-1443724119);
        if (function78 == null) {
        }
        composer3.endReplaceableGroup();
        Composer composer722 = composer3;
        Function5<BoxScope, Function1<? super a.AbstractC0571a.c, Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> b222 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.b(PaddingKt.m879padding3ABfNKs(boxScopeInstance22.align(Modifier.INSTANCE, companion32.getBottomStart()), Dp.m6389constructorimpl(12)), null, null, null, composer722, 0, 14);
        composer722.startReplaceableGroup(-1443710796);
        changed = composer722.changed(iVar3);
        rememberedValue = composer722.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new d(iVar3);
        composer722.updateRememberedValue(rememberedValue);
        composer722.endReplaceableGroup();
        b222.invoke(boxScopeInstance22, (KFunction) rememberedValue, iVar3.k(), composer722, Integer.valueOf(i15));
        composer4 = composer722;
        composer4.endReplaceableGroup();
        composer4.endReplaceableGroup();
        composer4.endNode();
        composer4.endReplaceableGroup();
        composer4.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        function54 = function5522;
        function107 = function103;
        modifier4 = modifier2;
        function710 = function71322;
        function108 = function106;
        iVar4 = iVar622;
        function64 = function6522;
        function711 = function75;
        function712 = function79;
        j4 = j622;
        endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static /* synthetic */ Function2 a(long j2, Function2 function2, Function2 function22, Function2 function23, Function2 function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function2 function25, Function2 function26, Function2 function27, K k2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = Color.INSTANCE.m4089getBlack0d7_KjU();
        }
        if ((i2 & 2) != 0) {
            function2 = h.f6242a;
        }
        if ((i2 & 4) != 0) {
            function22 = i.f6243a;
        }
        if ((i2 & 8) != 0) {
            function23 = j.f6244a;
        }
        if ((i2 & 16) != 0) {
            function24 = k.f6245a;
        }
        if ((i2 & 32) != 0) {
            iVar = null;
        }
        if ((i2 & 64) != 0) {
            function25 = l.f6246a;
        }
        if ((i2 & 128) != 0) {
            function26 = m.f6247a;
        }
        if ((i2 & 256) != 0) {
            function27 = C0552n.f6248a;
        }
        if ((i2 & 512) != 0) {
            k2 = a.h.f5756a.j();
        }
        Function2 function28 = function27;
        K k3 = k2;
        Function2 function29 = function25;
        Function2 function210 = function26;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2 = iVar;
        Function2 function211 = function23;
        Function2 function212 = function2;
        return a(j2, function212, function22, function211, function24, iVar2, function29, function210, function28, k3);
    }

    public static final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> a(final long j2, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> muteButton, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adCloseCountdownButton, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adSkipCountdownButton, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> ctaButton, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, final Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> progressBar, final Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> vastIcon, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> playbackControl, final K viewVisibilityTracker) {
        Intrinsics.checkNotNullParameter(muteButton, "muteButton");
        Intrinsics.checkNotNullParameter(adCloseCountdownButton, "adCloseCountdownButton");
        Intrinsics.checkNotNullParameter(adSkipCountdownButton, "adSkipCountdownButton");
        Intrinsics.checkNotNullParameter(ctaButton, "ctaButton");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(vastIcon, "vastIcon");
        Intrinsics.checkNotNullParameter(playbackControl, "playbackControl");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        return new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return n.a(j2, muteButton, adCloseCountdownButton, adSkipCountdownButton, ctaButton, iVar, progressBar, vastIcon, playbackControl, viewVisibilityTracker, (Context) obj, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) obj2);
            }
        };
    }

    public static final ComposeView a(long j2, Function2 function2, Function2 function22, Function2 function23, Function2 function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function2 function25, Function2 function26, Function2 function27, K k2, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setId(R.id.moloco_fullscreen_ad_view_id);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(876197241, true, new o(adViewModel, j2, function2, function22, function23, function24, iVar, function25, function26, function27, k2)));
        return composeView;
    }

    public static final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(long j2, long j3, Shape shape, long j4, Alignment alignment, PaddingValues paddingValues, long j5, Painter painter, Painter painter2, Function0<Unit> function0, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(447650301);
        long b2 = (i3 & 1) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j2;
        long j6 = (i3 & 2) != 0 ? b2 : j3;
        Shape f2 = (i3 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.f() : shape;
        long e2 = (i3 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : j4;
        Alignment topStart = (i3 & 16) != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
        PaddingValues m872PaddingValues0680j_4 = (i3 & 32) != 0 ? PaddingKt.m872PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long m1603getPrimary0d7_KjU = (i3 & 64) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m1603getPrimary0d7_KjU() : j5;
        Painter painterResource = (i3 & 128) != 0 ? PainterResources_androidKt.painterResource(R.drawable.ic_round_volume_off_24, composer, 0) : painter;
        Painter painterResource2 = (i3 & 256) != 0 ? PainterResources_androidKt.painterResource(R.drawable.ic_round_volume_up_24, composer, 0) : painter2;
        Function0<Unit> function02 = (i3 & 512) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(447650301, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton (VastRenderer.kt:226)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -545982054, true, new f(topStart, m872PaddingValues0680j_4, painterResource, painterResource2, function02, m1603getPrimary0d7_KjU, b2, j6, f2, e2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, long j2, String str, String str2, Function0<Unit> function0, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-926425258);
        if ((i3 & 1) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        Alignment alignment2 = alignment;
        if ((i3 & 2) != 0) {
            paddingValues = PaddingKt.m872PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a());
        }
        PaddingValues paddingValues2 = paddingValues;
        if ((i3 & 4) != 0) {
            j2 = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m1603getPrimary0d7_KjU();
        }
        long j3 = j2;
        String stringResource = (i3 & 8) != 0 ? StringResources_androidKt.stringResource(R.string.com_moloco_sdk_xenoss_player_learn_more, composer, 0) : str;
        String str3 = (i3 & 16) != 0 ? null : str2;
        Function0<Unit> function02 = (i3 & 32) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-926425258, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton (VastRenderer.kt:294)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 432764356, true, new e(alignment2, paddingValues2, str3, stringResource, j3, function02));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, long j2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(716005120);
        if ((i3 & 1) != 0) {
            alignment = Alignment.INSTANCE.getBottomCenter();
        }
        if ((i3 & 2) != 0) {
            paddingValues = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0));
        }
        if ((i3 & 4) != 0) {
            j2 = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m1603getPrimary0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(716005120, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar (VastRenderer.kt:369)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1967084142, true, new g(alignment, paddingValues, j2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final i.a a(State<? extends i.a> state) {
        return state.getValue();
    }
}
