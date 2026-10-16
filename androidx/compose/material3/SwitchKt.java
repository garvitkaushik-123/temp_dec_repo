package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001ay\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release", "isPressed"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter;

    /* JADX WARN: Removed duplicated region for block: B:101:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0224  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i5;
        boolean z3;
        SwitchColors switchColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        boolean z4;
        SwitchColors switchColors3;
        Modifier modifier3;
        int i7;
        MutableInteractionSource mutableInteractionSource3;
        boolean changed;
        Object rememberedValue;
        final float floatValue;
        Object rememberedValue2;
        MutableInteractionSource mutableInteractionSource4;
        final Animatable animatable;
        Object rememberedValue3;
        boolean changedInstance;
        Object rememberedValue4;
        boolean changedInstance2;
        Object rememberedValue5;
        float f;
        MutableInteractionSource mutableInteractionSource5;
        ?? r8;
        boolean z5;
        Animatable animatable2;
        Modifier.Companion companion;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        Composer composer2;
        final Modifier modifier4;
        final MutableInteractionSource mutableInteractionSource6;
        final boolean z6;
        final SwitchColors switchColors4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1580463220);
        ComposerKt.sourceInformation(startRestartGroup, "C(Switch)P(!1,5,4,6,2)96@4481L8,97@4541L39,*106@4829L7,107@4904L7,108@4964L111,113@5139L36,114@5192L24,116@5233L145,116@5222L156,121@5410L190,121@5384L216,145@6060L844:Switch.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function22 = function2;
                i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z2;
                    i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            if (startRestartGroup.changed(switchColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            switchColors2 = switchColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion2 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function22 = null;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    switchColors2 = SwitchDefaults.INSTANCE.colors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    startRestartGroup.startReplaceableGroup(-1221651002);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    function23 = function22;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                    modifier3 = companion2;
                                    i7 = i3;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue6;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1580463220, i7, -1, "androidx.compose.material3.Switch (Switch.kt:98)");
                                    }
                                    float f2 = function23 != null ? UncheckedThumbDiameter : ThumbDiameter;
                                    float f3 = SwitchHeight;
                                    float m6389constructorimpl = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f3 - f2) / 2);
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final float mo630toPx0680j_4 = ((Density) consume).mo630toPx0680j_4(m6389constructorimpl);
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    float f4 = ThumbPathLength;
                                    final float mo630toPx0680j_42 = ((Density) consume2).mo630toPx0680j_4(f4);
                                    startRestartGroup.startReplaceableGroup(-1221650579);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    changed = startRestartGroup.changed(mo630toPx0680j_4) | startRestartGroup.changed(mo630toPx0680j_42);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public final Float invoke(boolean z7) {
                                                return Float.valueOf(z7 ? mo630toPx0680j_42 : mo630toPx0680j_4);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Float invoke(Boolean bool) {
                                                return invoke(bool.booleanValue());
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                                    startRestartGroup.startReplaceableGroup(-1221650404);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        rememberedValue2 = AnimatableKt.Animatable$default(floatValue, 0.0f, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    } else {
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    animatable = (Animatable) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.startReplaceableGroup(773894976);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                        startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                        rememberedValue3 = compositionScopedCoroutineScopeCanceller;
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.startReplaceableGroup(-1221650310);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(mo630toPx0680j_4);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                Animatable.updateBounds$default(animatable, Float.valueOf(mo630toPx0680j_4), null, 2, null);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                                    Boolean valueOf = Boolean.valueOf(z);
                                    startRestartGroup.startReplaceableGroup(-1221650133);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope);
                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (!changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            /* compiled from: Switch.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                                                final /* synthetic */ float $targetValue;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$offset = animatable;
                                                    this.$targetValue = f;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$offset, this.$targetValue, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    TweenSpec tweenSpec;
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                                        Float boxFloat = Boxing.boxFloat(this.$targetValue);
                                                        tweenSpec = SwitchKt.AnimationSpec;
                                                        this.label = 1;
                                                        if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, this, 12, null) == coroutine_suspended) {
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

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                if (animatable.getTargetValue().floatValue() != floatValue) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(animatable, floatValue, null), 3, null);
                                                }
                                                return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                    }
                                                };
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i7 & 14);
                                    if (function1 == null) {
                                        f = m6389constructorimpl;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        r8 = 0;
                                        z5 = z4;
                                        animatable2 = animatable;
                                        companion = ToggleableKt.m1124toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m5709boximpl(Role.INSTANCE.m5721getSwitcho7Vup1c()), function1);
                                    } else {
                                        f = m6389constructorimpl;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        r8 = 0;
                                        z5 = z4;
                                        animatable2 = animatable;
                                        companion = Modifier.INSTANCE;
                                    }
                                    Modifier m922requiredSizeVpY3zN4 = SizeKt.m922requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r8, 2, null), SwitchWidth, f3);
                                    startRestartGroup.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r8, startRestartGroup, r8);
                                    startRestartGroup.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r8);
                                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN4);
                                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                        startRestartGroup.useNode();
                                    } else {
                                        startRestartGroup.createNode(constructor);
                                    }
                                    m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((int) r8));
                                    startRestartGroup.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
                                    int i10 = i7 >> 6;
                                    composer2 = startRestartGroup;
                                    Modifier modifier5 = modifier3;
                                    m2666SwitchImpl0DmnUew(boxScopeInstance, z, z5, switchColors3, animatable2.asState(), function23, mutableInteractionSource5, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f2, f, f4, composer2, ((i7 << 3) & 112) | 6 | (i10 & 896) | (i10 & 7168) | ((i7 << 6) & 458752) | (3670016 & i7), 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier5;
                                    mutableInteractionSource6 = mutableInteractionSource5;
                                    z6 = z5;
                                    switchColors4 = switchColors3;
                                    function24 = function23;
                                } else {
                                    function23 = function22;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                    modifier3 = companion2;
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function23 = function22;
                                z4 = z3;
                                switchColors3 = switchColors2;
                                i7 = i3;
                                modifier3 = modifier2;
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            float f22 = function23 != null ? UncheckedThumbDiameter : ThumbDiameter;
                            float f32 = SwitchHeight;
                            float m6389constructorimpl2 = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f32 - f22) / 2);
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float mo630toPx0680j_43 = ((Density) consume3).mo630toPx0680j_4(m6389constructorimpl2);
                            ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22 = startRestartGroup.consume(localDensity22);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            float f42 = ThumbPathLength;
                            final float mo630toPx0680j_422 = ((Density) consume22).mo630toPx0680j_4(f42);
                            startRestartGroup.startReplaceableGroup(-1221650579);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changed = startRestartGroup.changed(mo630toPx0680j_43) | startRestartGroup.changed(mo630toPx0680j_422);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Float invoke(boolean z7) {
                                    return Float.valueOf(z7 ? mo630toPx0680j_422 : mo630toPx0680j_43);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Float invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            startRestartGroup.endReplaceableGroup();
                            floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                            startRestartGroup.startReplaceableGroup(-1221650404);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
                            }
                            animatable = (Animatable) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-1221650310);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(mo630toPx0680j_43);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    Animatable.updateBounds$default(animatable, Float.valueOf(mo630toPx0680j_43), null, 2, null);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                            Boolean valueOf2 = Boolean.valueOf(z);
                            startRestartGroup.startReplaceableGroup(-1221650133);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope2);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changedInstance2) {
                            }
                            rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* compiled from: Switch.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                                    final /* synthetic */ float $targetValue;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$offset = animatable;
                                        this.$targetValue = f;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$offset, this.$targetValue, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        TweenSpec tweenSpec;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                            Float boxFloat = Boxing.boxFloat(this.$targetValue);
                                            tweenSpec = SwitchKt.AnimationSpec;
                                            this.label = 1;
                                            if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, this, 12, null) == coroutine_suspended) {
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

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    if (animatable.getTargetValue().floatValue() != floatValue) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(animatable, floatValue, null), 3, null);
                                    }
                                    return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                        }
                                    };
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(valueOf2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i7 & 14);
                            if (function1 == null) {
                            }
                            Modifier m922requiredSizeVpY3zN42 = SizeKt.m922requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r8, 2, null), SwitchWidth, f32);
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r8, startRestartGroup, r8);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r8);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN42);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!m3593constructorimpl.getInserting()) {
                            }
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((int) r8));
                            startRestartGroup.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
                            int i102 = i7 >> 6;
                            composer2 = startRestartGroup;
                            Modifier modifier52 = modifier3;
                            m2666SwitchImpl0DmnUew(boxScopeInstance2, z, z5, switchColors3, animatable2.asState(), function23, mutableInteractionSource5, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f22, f, f42, composer2, ((i7 << 3) & 112) | 6 | (i102 & 896) | (i102 & 7168) | ((i7 << 6) & 458752) | (3670016 & i7), 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier52;
                            mutableInteractionSource6 = mutableInteractionSource5;
                            z6 = z5;
                            switchColors4 = switchColors3;
                            function24 = function23;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            composer2 = startRestartGroup;
                            function24 = function22;
                            z6 = z3;
                            switchColors4 = switchColors2;
                            mutableInteractionSource6 = mutableInteractionSource2;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    SwitchKt.Switch(z, function1, modifier4, function24, z6, switchColors4, mutableInteractionSource6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                z3 = z2;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function22 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function22 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    public static final void m2666SwitchImpl0DmnUew(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final State<Float> state, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape shape, final float f, final float f2, final float f3, Composer composer, final int i, final int i2) {
        int i3;
        State<Float> state2;
        int i4;
        float m6389constructorimpl;
        final float floatValue;
        Composer composer2;
        float m3476getTrackOutlineWidthD9Ej5fM;
        Composer startRestartGroup = composer.startRestartGroup(-1968109941);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)188@7413L25,*190@7481L7,210@8114L5,222@8432L1050:Switch.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            state2 = state;
            i3 |= startRestartGroup.changed(state2) ? 16384 : 8192;
        } else {
            state2 = state;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changed(interactionSource) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(f3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) != 306783378 || (i4 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i3, i4, "androidx.compose.material3.SwitchImpl (Switch.kt:186)");
            }
            long m2663trackColorWaAFU9c$material3_release = switchColors.m2663trackColorWaAFU9c$material3_release(z2, z);
            State<Boolean> collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, startRestartGroup, (i3 >> 18) & 14);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float mo626toDpu2uoSUM = ((Density) consume).mo626toDpu2uoSUM(state2.getValue().floatValue());
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                m6389constructorimpl = SwitchTokens.INSTANCE.m3470getPressedHandleWidthD9Ej5fM();
            } else {
                m6389constructorimpl = Dp.m6389constructorimpl(f + Dp.m6389constructorimpl(Dp.m6389constructorimpl(ThumbDiameter - f) * (Dp.m6389constructorimpl(mo626toDpu2uoSUM - f2) / Dp.m6389constructorimpl(f3 - f2))));
            }
            startRestartGroup.startReplaceableGroup(-993794132);
            ComposerKt.sourceInformation(startRestartGroup, "*199@7822L7");
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density = (Density) consume2;
                if (!z) {
                    m3476getTrackOutlineWidthD9Ej5fM = SwitchTokens.INSTANCE.m3476getTrackOutlineWidthD9Ej5fM();
                } else {
                    m3476getTrackOutlineWidthD9Ej5fM = Dp.m6389constructorimpl(ThumbPathLength - SwitchTokens.INSTANCE.m3476getTrackOutlineWidthD9Ej5fM());
                }
                floatValue = density.mo630toPx0680j_4(m3476getTrackOutlineWidthD9Ej5fM);
            } else {
                floatValue = state2.getValue().floatValue();
            }
            startRestartGroup.endReplaceableGroup();
            Shape value = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), startRestartGroup, 6);
            int i5 = i3;
            float f4 = m6389constructorimpl;
            Modifier m526backgroundbw27NRU = BackgroundKt.m526backgroundbw27NRU(BorderKt.m538borderxT4_qwU(SizeKt.m914height3ABfNKs(SizeKt.m933width3ABfNKs(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), SwitchWidth), SwitchHeight), SwitchTokens.INSTANCE.m3476getTrackOutlineWidthD9Ej5fM(), switchColors.m2643borderColorWaAFU9c$material3_release(z2, z), value), m2663trackColorWaAFU9c$material3_release, value);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m526backgroundbw27NRU);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1420969714, "C228@8671L42,231@8868L134,225@8564L912:Switch.kt#uh7d8r");
            long m2662thumbColorWaAFU9c$material3_release = switchColors.m2662thumbColorWaAFU9c$material3_release(z2, z);
            Modifier align = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            startRestartGroup.startReplaceableGroup(1420969929);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            boolean changed = startRestartGroup.changed(floatValue);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                        return IntOffset.m6508boximpl(m2668invokeBjo55l4(density2));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m2668invokeBjo55l4(Density density2) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(floatValue), 0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            Modifier m526backgroundbw27NRU2 = BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue), interactionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(SwitchTokens.INSTANCE.m3474getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), f4), m2662thumbColorWaAFU9c$material3_release, shape);
            Alignment center = Alignment.INSTANCE.getCenter();
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m526backgroundbw27NRU2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -2040677128, "C:Switch.kt#uh7d8r");
            composer2.startReplaceableGroup(1420970455);
            ComposerKt.sourceInformation(composer2, "242@9308L144");
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(switchColors.m2661iconColorWaAFU9c$material3_release(z2, z))), function2, composer2, ProvidedValue.$stable | ((i5 >> 12) & 112));
            }
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    SwitchKt.m2666SwitchImpl0DmnUew(BoxScope.this, z, z2, switchColors, state, function2, interactionSource, shape, f, f2, f3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    static {
        float m3472getSelectedHandleWidthD9Ej5fM = SwitchTokens.INSTANCE.m3472getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = m3472getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = SwitchTokens.INSTANCE.m3479getUnselectedHandleWidthD9Ej5fM();
        float m3477getTrackWidthD9Ej5fM = SwitchTokens.INSTANCE.m3477getTrackWidthD9Ej5fM();
        SwitchWidth = m3477getTrackWidthD9Ej5fM;
        float m3475getTrackHeightD9Ej5fM = SwitchTokens.INSTANCE.m3475getTrackHeightD9Ej5fM();
        SwitchHeight = m3475getTrackHeightD9Ej5fM;
        float m6389constructorimpl = Dp.m6389constructorimpl(Dp.m6389constructorimpl(m3475getTrackHeightD9Ej5fM - m3472getSelectedHandleWidthD9Ej5fM) / 2);
        ThumbPadding = m6389constructorimpl;
        ThumbPathLength = Dp.m6389constructorimpl(Dp.m6389constructorimpl(m3477getTrackWidthD9Ej5fM - m3472getSelectedHandleWidthD9Ej5fM) - m6389constructorimpl);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
