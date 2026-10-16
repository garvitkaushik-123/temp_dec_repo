package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.internal.d;
import com.moloco.sdk.internal.ortb.model.i;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final Unit a(i iVar, int i, int i2, int i3, Composer composer, int i4) {
        a(iVar, i, i2, composer, i3 | 1);
        return Unit.INSTANCE;
    }

    public static final Unit b() {
        return Unit.INSTANCE;
    }

    public static final void a(final i countDownTimer, int i, int i2, Composer composer, final int i3) {
        int i4;
        final int i5 = i;
        final int i6 = i2;
        Intrinsics.checkNotNullParameter(countDownTimer, "countDownTimer");
        Composer startRestartGroup = composer.startRestartGroup(-1297279343);
        if ((i3 & 6) == 0) {
            i4 = (startRestartGroup.changed(countDownTimer) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= startRestartGroup.changed(i6) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1297279343, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.AggregateRewardedCountDownTimer (AggregateRewardedCountDownTimer.kt:17)");
            }
            float m6389constructorimpl = Dp.m6389constructorimpl(countDownTimer.c());
            long m6411DpSizeYgX7TsA = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
            Alignment a2 = d.a(countDownTimer.i(), countDownTimer.m());
            long a3 = countDownTimer.a();
            int i7 = i4;
            long g = countDownTimer.g();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(a2, false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
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
            if (countDownTimer.o()) {
                startRestartGroup.startReplaceableGroup(2067595199);
                startRestartGroup.startReplaceableGroup(-210387540);
                final String str = "rewarded_countdown_timer";
                boolean changed = startRestartGroup.changed("rewarded_countdown_timer");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return a.a(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null);
                float m6487getWidthD9Ej5fM = DpSize.m6487getWidthD9Ej5fM(m6411DpSizeYgX7TsA);
                startRestartGroup.startReplaceableGroup(-210389350);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return a.b();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                int i8 = i7 << 21;
                c.a(a3, g, semantics$default, 0.0f, m6487getWidthD9Ej5fM, function0, null, null, i5, i6, startRestartGroup, 196608 | (234881024 & i8) | (1879048192 & i8), 200);
                startRestartGroup.endReplaceableGroup();
                i5 = i;
                i6 = i2;
            } else {
                String e = countDownTimer.e();
                if (e == null || e.length() <= 0) {
                    i5 = i;
                    i6 = i2;
                    startRestartGroup.startReplaceableGroup(2069129451);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(2068371222);
                    startRestartGroup.startReplaceableGroup(-210362420);
                    final String str2 = "rewarded_countdown_timer_custom";
                    boolean changed2 = startRestartGroup.changed("rewarded_countdown_timer_custom");
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return a.b(str2, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue3, 1, null);
                    float m6487getWidthD9Ej5fM2 = DpSize.m6487getWidthD9Ej5fM(m6411DpSizeYgX7TsA);
                    String e2 = countDownTimer.e();
                    startRestartGroup.startReplaceableGroup(-210364230);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return a.a();
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceableGroup();
                    b.a(a3, g, semantics$default2, 0.0f, m6487getWidthD9Ej5fM2, (Function0) rememberedValue4, e2, null, null, i, i2, startRestartGroup, (1879048192 & (i7 << 24)) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, (i7 >> 6) & 14, 392);
                    i5 = i;
                    i6 = i2;
                    startRestartGroup = startRestartGroup;
                    startRestartGroup.endReplaceableGroup();
                }
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(i.this, i5, i6, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit b(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }

    public static final float a(int i, int i2) {
        return ((float) UnsignedKt.uintToDouble(i)) / ((float) UnsignedKt.uintToDouble(i2));
    }
}
