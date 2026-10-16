package com.moloco.sdk.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final long f5733a = ColorKt.Color(4278354171L);

    public static final class a implements Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f5734a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ long f;

        /* renamed from: com.moloco.sdk.internal.u$a$a, reason: collision with other inner class name */
        public static final class C0459a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<a.AbstractC0571a.c, Unit> f5735a;
            public final /* synthetic */ State<i.a> b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ long e;
            public final /* synthetic */ long f;
            public final /* synthetic */ Function0<Unit> g;

            /* renamed from: com.moloco.sdk.internal.u$a$a$a, reason: collision with other inner class name */
            public static final class C0460a implements Function3<Modifier, Composer, Integer, Unit> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f5736a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;

                public C0460a(String str, String str2, long j, long j2, Function0<Unit> function0) {
                    this.f5736a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i2 = (composer.changed(it) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1938502477, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:72)");
                    }
                    u.a(it, this.f5736a, this.b, this.c, this.d, this.e, composer, i2 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }
            }

            /* renamed from: com.moloco.sdk.internal.u$a$a$b */
            public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f5737a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;

                public b(String str, String str2, long j, long j2, Function0<Unit> function0) {
                    this.f5737a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i2 = (composer.changed(it) ? 4 : 2) | i;
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-868048676, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:87)");
                    }
                    u.a(it, this.f5737a, this.b, this.c, this.d, this.e, composer, i2 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0459a(Function1<? super a.AbstractC0571a.c, Unit> function1, State<? extends i.a> state, String str, String str2, long j, long j2, Function0<Unit> function0) {
                this.f5735a = function1;
                this.b = state;
                this.c = str;
                this.d = str2;
                this.e = j;
                this.f = j2;
                this.g = function0;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-657845797, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous> (MolocoVastCTA.kt:66)");
                }
                i.a b2 = a.b(this.b);
                if (b2 instanceof i.a.C0539a) {
                    composer.startReplaceableGroup(-388830153);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v.a(null, a.AbstractC0571a.c.EnumC0573a.g, this.f5735a, ComposableLambdaKt.composableLambda(composer, -1938502477, true, new C0460a(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.c) {
                    composer.startReplaceableGroup(-388268681);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v.a(null, a.AbstractC0571a.c.EnumC0573a.g, this.f5735a, ComposableLambdaKt.composableLambda(composer, -868048676, true, new b(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.b) {
                    composer.startReplaceableGroup(-387725902);
                    composer.endReplaceableGroup();
                } else if (b2 instanceof i.a.d) {
                    composer.startReplaceableGroup(-387668366);
                    composer.endReplaceableGroup();
                } else {
                    if (b2 != null) {
                        composer.startReplaceableGroup(-843828347);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(-387633677);
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
        }

        public a(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j, long j2) {
            this.f5734a = alignment;
            this.b = paddingValues;
            this.c = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
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
                ComposerKt.traceEventStart(-927135997, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous> (MolocoVastCTA.kt:48)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f5734a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -657845797, true, new C0459a(onButtonRendered, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, (i >> 6) & 14, 1), this.c, this.d, this.e, this.f, onCTA)), composer, ((i >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final Unit a(Modifier modifier, String str, String str2, long j, long j2, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, str, str2, j, j2, (Function0<Unit>) function0, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, String str, long j, long j2, String str2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(959702933);
        if ((i2 & 1) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        Alignment alignment2 = alignment;
        if ((i2 & 2) != 0) {
            paddingValues = PaddingKt.m872PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a());
        }
        PaddingValues paddingValues2 = paddingValues;
        if ((i2 & 4) != 0) {
            str = StringResources_androidKt.stringResource(R.string.com_moloco_sdk_xenoss_player_learn_more, composer, 0);
        }
        String str3 = str;
        long m4100getWhite0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m4100getWhite0d7_KjU() : j;
        long j3 = (i2 & 16) != 0 ? f5733a : j2;
        String str4 = (i2 & 32) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959702933, i, -1, "com.moloco.sdk.internal.molocoCTAButton (MolocoVastCTA.kt:47)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -927135997, true, new a(alignment2, paddingValues2, str4, str3, m4100getWhite0d7_KjU, j3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Modifier modifier, String str, final String str2, final long j, final long j2, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        String str3;
        String str4;
        long j3;
        Function0<Unit> function02;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2035340272);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            str3 = str;
            i3 |= startRestartGroup.changed(str3) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                str4 = str2;
                i3 |= startRestartGroup.changed(str4) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(j) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                        j3 = j2;
                    } else {
                        j3 = j2;
                        if ((i & 24576) == 0) {
                            i3 |= startRestartGroup.changed(j3) ? 16384 : 8192;
                        }
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        function02 = function0;
                        i3 |= startRestartGroup.changed(function02) ? 131072 : 65536;
                        if ((74899 & i3) != 74898 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                        } else {
                            Modifier modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                str3 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2035340272, i3, -1, "com.moloco.sdk.internal.MolocoVastCTA (MolocoVastCTA.kt:113)");
                            }
                            float f = 4;
                            RoundedCornerShape m1149RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f));
                            Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, Dp.m6389constructorimpl(164), 1, null), m1149RoundedCornerShape0680j_4), j3, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 1, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            startRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, startRestartGroup, 54);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m561clickableXHw0xAI$default);
                            Modifier modifier5 = modifier4;
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
                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, density, companion.getSetDensity());
                            Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                            startRestartGroup.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            startRestartGroup.startReplaceableGroup(-678309503);
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceableGroup(-118887934);
                            if (str3 == null) {
                                composer2 = startRestartGroup;
                            } else {
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, Dp.m6389constructorimpl(f)), startRestartGroup, 6);
                                SingletonAsyncImageKt.m6740AsyncImage3HmZ8SU(str3, null, ClipKt.clip(SizeKt.m928size3ABfNKs(companion2, Dp.m6389constructorimpl(36)), m1149RoundedCornerShape0680j_4), null, null, null, null, 0.0f, null, 0, startRestartGroup, ((i3 >> 3) & 14) | 48, 1016);
                                composer2 = startRestartGroup;
                            }
                            composer2.endReplaceableGroup();
                            TextKt.m1844TextfLXpl1I(str4, PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(15), Dp.m6389constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composer2, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier5;
                        }
                        final String str5 = str3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.internal.u$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return u.a(Modifier.this, str5, str2, j, j2, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function02 = function0;
                    if ((74899 & i3) != 74898) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f2 = 4;
                    RoundedCornerShape m1149RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f2));
                    Modifier m561clickableXHw0xAI$default2 = ClickableKt.m561clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, Dp.m6389constructorimpl(164), 1, null), m1149RoundedCornerShape0680j_42), j3, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 1, null);
                    Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    startRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, startRestartGroup, 54);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m561clickableXHw0xAI$default2);
                    Modifier modifier52 = modifier4;
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    startRestartGroup.disableReusing();
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, density2, companion3.getSetDensity());
                    Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                    Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-678309503);
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-118887934);
                    if (str3 == null) {
                    }
                    composer2.endReplaceableGroup();
                    TextKt.m1844TextfLXpl1I(str4, PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(15), Dp.m6389constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composer2, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                    final String str52 = str3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                function02 = function0;
                if ((74899 & i3) != 74898) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                float f22 = 4;
                RoundedCornerShape m1149RoundedCornerShape0680j_422 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f22));
                Modifier m561clickableXHw0xAI$default22 = ClickableKt.m561clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, Dp.m6389constructorimpl(164), 1, null), m1149RoundedCornerShape0680j_422), j3, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 1, null);
                Arrangement.HorizontalOrVertical center22 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically22 = Alignment.INSTANCE.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(center22, centerVertically22, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(m561clickableXHw0xAI$default22);
                Modifier modifier522 = modifier4;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                startRestartGroup.disableReusing();
                Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl22, rowMeasurePolicy22, companion32.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl22, density22, companion32.getSetDensity());
                Updater.m3600setimpl(m3593constructorimpl22, layoutDirection22, companion32.getSetLayoutDirection());
                Updater.m3600setimpl(m3593constructorimpl22, viewConfiguration22, companion32.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-118887934);
                if (str3 == null) {
                }
                composer2.endReplaceableGroup();
                TextKt.m1844TextfLXpl1I(str4, PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(15), Dp.m6389constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composer2, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier522;
                final String str522 = str3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            str4 = str2;
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            function02 = function0;
            if ((74899 & i3) != 74898) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            float f222 = 4;
            RoundedCornerShape m1149RoundedCornerShape0680j_4222 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f222));
            Modifier m561clickableXHw0xAI$default222 = ClickableKt.m561clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, Dp.m6389constructorimpl(164), 1, null), m1149RoundedCornerShape0680j_4222), j3, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 1, null);
            Arrangement.HorizontalOrVertical center222 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically222 = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(center222, centerVertically222, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion322.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf222 = LayoutKt.materializerOf(m561clickableXHw0xAI$default222);
            Modifier modifier5222 = modifier4;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl222 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl222, rowMeasurePolicy222, companion322.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl222, density222, companion322.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl222, layoutDirection222, companion322.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl222, viewConfiguration222, companion322.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-118887934);
            if (str3 == null) {
            }
            composer2.endReplaceableGroup();
            TextKt.m1844TextfLXpl1I(str4, PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(15), Dp.m6389constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composer2, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier5222;
            final String str5222 = str3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        str3 = str;
        if ((i2 & 4) == 0) {
        }
        str4 = str2;
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        function02 = function0;
        if ((74899 & i3) != 74898) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float f2222 = 4;
        RoundedCornerShape m1149RoundedCornerShape0680j_42222 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f2222));
        Modifier m561clickableXHw0xAI$default2222 = ClickableKt.m561clickableXHw0xAI$default(AnimationModifierKt.animateContentSize$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m935widthInVpY3zN4$default(modifier4, 0.0f, Dp.m6389constructorimpl(164), 1, null), m1149RoundedCornerShape0680j_42222), j3, null, 2, null), null, null, 3, null), false, VastTagName.CTA, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 1, null);
        Arrangement.HorizontalOrVertical center2222 = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical centerVertically2222 = Alignment.INSTANCE.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(center2222, centerVertically2222, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density2222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion3222.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2222 = LayoutKt.materializerOf(m561clickableXHw0xAI$default2222);
        Modifier modifier52222 = modifier4;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        startRestartGroup.disableReusing();
        Composer m3593constructorimpl2222 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl2222, rowMeasurePolicy2222, companion3222.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl2222, density2222, companion3222.getSetDensity());
        Updater.m3600setimpl(m3593constructorimpl2222, layoutDirection2222, companion3222.getSetLayoutDirection());
        Updater.m3600setimpl(m3593constructorimpl2222, viewConfiguration2222, companion3222.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance2222 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-118887934);
        if (str3 == null) {
        }
        composer2.endReplaceableGroup();
        TextKt.m1844TextfLXpl1I(str4, PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(15), Dp.m6389constructorimpl(12)), j, 0L, null, FontWeight.INSTANCE.getBold(), FontFamily.INSTANCE.getDefault(), 0L, null, null, 0L, 0, false, 1, null, null, composer2, ((i3 >> 6) & 14) | 196656 | ((i3 >> 3) & 896), 3072, 57240);
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52222;
        final String str52222 = str3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final long a() {
        return f5733a;
    }
}
