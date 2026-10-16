package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aS\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a.\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0016\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX WARN: Removed duplicated region for block: B:100:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0345 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0322  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        SwitchColors switchColors2;
        MutableInteractionSource mutableInteractionSource3;
        String str;
        int i6;
        Modifier modifier3;
        boolean z4;
        SwitchColors switchColors3;
        MutableInteractionSource mutableInteractionSource4;
        Object rememberedValue;
        MutableState mutableState;
        boolean changed;
        Object rememberedValue2;
        boolean changed2;
        SwitchKt$Switch$2$1 rememberedValue3;
        MutableState mutableState2;
        boolean changed3;
        SwitchKt$Switch$3$1 rememberedValue4;
        final boolean z5;
        MutableInteractionSource mutableInteractionSource5;
        int i7;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean changed4;
        Object rememberedValue5;
        Composer composer2;
        final Modifier modifier4;
        final SwitchColors switchColors4;
        final MutableInteractionSource mutableInteractionSource6;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(25866825);
        ComposerKt.sourceInformation(startRestartGroup, "C(Switch)P(!1,5,4,2,3)98@4576L39,99@4659L8,*102@4731L7,107@5113L34,108@5202L7,109@5279L447,121@5761L37,122@5825L29,123@5859L354,132@6218L178,137@6434L7,152@6875L1050:Switch.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((i & 458752) != 0) {
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
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 == 0 ? true : z3;
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue6;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                str = "CC(remember):Composables.kt#9igjgp";
                                SwitchColors m1794colorsSQMK_m0 = SwitchDefaults.INSTANCE.m1794colorsSQMK_m0(0L, 0L, 0.0f, 0L, 0L, 0.0f, 0L, 0L, 0L, 0L, startRestartGroup, 0, 6, 1023);
                                startRestartGroup = startRestartGroup;
                                i6 = i3 & (-458753);
                                z4 = z6;
                                switchColors3 = m1794colorsSQMK_m0;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier3 = companion3;
                            } else {
                                str = "CC(remember):Composables.kt#9igjgp";
                                i6 = i3;
                                modifier3 = companion3;
                                z4 = z6;
                                switchColors3 = switchColors2;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            modifier3 = modifier2;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            switchColors3 = switchColors2;
                            str = "CC(remember):Composables.kt#9igjgp";
                            i6 = i3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(25866825, i6, -1, "androidx.compose.material.Switch (Switch.kt:100)");
                        }
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float mo630toPx0680j_4 = ((Density) consume).mo630toPx0680j_4(ThumbPathLength);
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, str);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) rememberedValue;
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float mo630toPx0680j_42 = ((Density) consume2).mo630toPx0680j_4(SwitchVelocityThreshold);
                        Float valueOf = Float.valueOf(mo630toPx0680j_4);
                        Float valueOf2 = Float.valueOf(mo630toPx0680j_42);
                        startRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(valueOf2);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            final float f = 0.0f;
                            rememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<Boolean>, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                                    invoke2(draggableAnchorsConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                                    draggableAnchorsConfig.at(false, f);
                                    draggableAnchorsConfig.at(true, mo630toPx0680j_4);
                                }
                            }), new Function1<Float, Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
                                public final Float invoke(float f2) {
                                    return Float.valueOf(f2 * 0.7f);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Float invoke(Float f2) {
                                    return invoke(f2.floatValue());
                                }
                            }, new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(mo630toPx0680j_42);
                                }
                            }, AnimationSpec, null, 32, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final AnchoredDraggableState anchoredDraggableState = (AnchoredDraggableState) rememberedValue2;
                        int i10 = i6 >> 3;
                        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, i10 & 14);
                        int i11 = i6 & 14;
                        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), startRestartGroup, i11);
                        startRestartGroup.startReplaceableGroup(1204583054);
                        changed2 = startRestartGroup.changed(anchoredDraggableState) | startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changed(mutableState);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState;
                            rememberedValue3 = new SwitchKt$Switch$2$1(anchoredDraggableState, rememberUpdatedState2, rememberUpdatedState, mutableState2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        } else {
                            mutableState2 = mutableState;
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(anchoredDraggableState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 64);
                        Boolean valueOf3 = Boolean.valueOf(z);
                        Boolean valueOf4 = Boolean.valueOf(Switch$lambda$3(mutableState2));
                        startRestartGroup.startReplaceableGroup(1204583419);
                        changed3 = startRestartGroup.changed(z) | startRestartGroup.changed(anchoredDraggableState);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = new SwitchKt$Switch$3$1(z, anchoredDraggableState, null);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(valueOf3, valueOf4, (Function2) rememberedValue4, startRestartGroup, i11 | 512);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = startRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        boolean z7 = consume3 != LayoutDirection.Rtl;
                        if (function1 == null) {
                            z5 = z4;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            i7 = 2;
                            companion = ToggleableKt.m1124toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource5, null, z5, Role.m5709boximpl(Role.INSTANCE.m5721getSwitcho7Vup1c()), function1);
                        } else {
                            z5 = z4;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            i7 = 2;
                            companion = Modifier.INSTANCE;
                        }
                        if (function1 == null) {
                            companion2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            companion2 = Modifier.INSTANCE;
                        }
                        Modifier m922requiredSizeVpY3zN4 = SizeKt.m922requiredSizeVpY3zN4(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifier3.then(companion2).then(companion), anchoredDraggableState, Orientation.Horizontal, (z5 || function1 == null) ? false : true, z7, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), false, i7, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN4);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(constructor);
                        } else {
                            startRestartGroup.useNode();
                        }
                        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229337676, "C174@7661L258:Switch.kt#jmzs0o");
                        boolean booleanValue = ((Boolean) anchoredDraggableState.getTargetValue()).booleanValue();
                        startRestartGroup.startReplaceableGroup(1204584972);
                        changed4 = startRestartGroup.changed(anchoredDraggableState);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$4$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(anchoredDraggableState.requireOffset());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        startRestartGroup.endReplaceableGroup();
                        Modifier modifier5 = modifier3;
                        SwitchImpl(boxScopeInstance, booleanValue, z5, switchColors3, (Function0) rememberedValue5, mutableInteractionSource5, startRestartGroup, (i10 & 896) | 6 | ((i6 >> 6) & 7168) | ((i6 << 3) & 458752));
                        composer2 = startRestartGroup;
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
                        switchColors4 = switchColors3;
                        mutableInteractionSource6 = mutableInteractionSource5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        mutableInteractionSource6 = mutableInteractionSource2;
                        switchColors4 = switchColors2;
                        composer2 = startRestartGroup;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$5
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

                            public final void invoke(Composer composer3, int i12) {
                                SwitchKt.Switch(z, function1, modifier4, z5, mutableInteractionSource6, switchColors4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 458752) != 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float mo630toPx0680j_43 = ((Density) consume4).mo630toPx0680j_4(ThumbPathLength);
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, str);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) rememberedValue;
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float mo630toPx0680j_422 = ((Density) consume22).mo630toPx0680j_4(SwitchVelocityThreshold);
                Float valueOf5 = Float.valueOf(mo630toPx0680j_43);
                Float valueOf22 = Float.valueOf(mo630toPx0680j_422);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(valueOf5) | startRestartGroup.changed(valueOf22);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                final float f2 = 0.0f;
                rememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<Boolean>, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(false, f2);
                        draggableAnchorsConfig.at(true, mo630toPx0680j_43);
                    }
                }), new Function1<Float, Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
                    public final Float invoke(float f22) {
                        return Float.valueOf(f22 * 0.7f);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Float invoke(Float f22) {
                        return invoke(f22.floatValue());
                    }
                }, new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(mo630toPx0680j_422);
                    }
                }, AnimationSpec, null, 32, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final AnchoredDraggableState<Boolean> anchoredDraggableState2 = (AnchoredDraggableState) rememberedValue2;
                int i102 = i6 >> 3;
                State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, i102 & 14);
                int i112 = i6 & 14;
                State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), startRestartGroup, i112);
                startRestartGroup.startReplaceableGroup(1204583054);
                changed2 = startRestartGroup.changed(anchoredDraggableState2) | startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changed(rememberUpdatedState3) | startRestartGroup.changed(mutableState);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2) {
                }
                mutableState2 = mutableState;
                rememberedValue3 = new SwitchKt$Switch$2$1(anchoredDraggableState2, rememberUpdatedState22, rememberUpdatedState3, mutableState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(anchoredDraggableState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 64);
                Boolean valueOf32 = Boolean.valueOf(z);
                Boolean valueOf42 = Boolean.valueOf(Switch$lambda$3(mutableState2));
                startRestartGroup.startReplaceableGroup(1204583419);
                changed3 = startRestartGroup.changed(z) | startRestartGroup.changed(anchoredDraggableState2);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue4 = new SwitchKt$Switch$3$1(z, anchoredDraggableState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(valueOf32, valueOf42, (Function2) rememberedValue4, startRestartGroup, i112 | 512);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (consume32 != LayoutDirection.Rtl) {
                }
                if (function1 == null) {
                }
                if (function1 == null) {
                }
                Modifier m922requiredSizeVpY3zN42 = SizeKt.m922requiredSizeVpY3zN4(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifier3.then(companion2).then(companion), anchoredDraggableState2, Orientation.Horizontal, (z5 || function1 == null) ? false : true, z7, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), false, i7, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN42);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting()) {
                }
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229337676, "C174@7661L258:Switch.kt#jmzs0o");
                boolean booleanValue2 = ((Boolean) anchoredDraggableState2.getTargetValue()).booleanValue();
                startRestartGroup.startReplaceableGroup(1204584972);
                changed4 = startRestartGroup.changed(anchoredDraggableState2);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed4) {
                }
                rememberedValue5 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$4$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(anchoredDraggableState2.requireOffset());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                Modifier modifier52 = modifier3;
                SwitchImpl(boxScopeInstance2, booleanValue2, z5, switchColors3, (Function0) rememberedValue5, mutableInteractionSource5, startRestartGroup, (i102 & 896) | 6 | ((i6 >> 6) & 7168) | ((i6 << 3) & 458752));
                composer2 = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier52;
                switchColors4 = switchColors3;
                mutableInteractionSource6 = mutableInteractionSource5;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 458752) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume42 = startRestartGroup.consume(localDensity32);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float mo630toPx0680j_432 = ((Density) consume42).mo630toPx0680j_4(ThumbPathLength);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, str);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableState = (MutableState) rememberedValue;
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float mo630toPx0680j_4222 = ((Density) consume222).mo630toPx0680j_4(SwitchVelocityThreshold);
            Float valueOf52 = Float.valueOf(mo630toPx0680j_432);
            Float valueOf222 = Float.valueOf(mo630toPx0680j_4222);
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(valueOf52) | startRestartGroup.changed(valueOf222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            final float f22 = 0.0f;
            rememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<Boolean>, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                    invoke2(draggableAnchorsConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                    draggableAnchorsConfig.at(false, f22);
                    draggableAnchorsConfig.at(true, mo630toPx0680j_432);
                }
            }), new Function1<Float, Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
                public final Float invoke(float f222) {
                    return Float.valueOf(f222 * 0.7f);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Float f222) {
                    return invoke(f222.floatValue());
                }
            }, new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(mo630toPx0680j_4222);
                }
            }, AnimationSpec, null, 32, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final AnchoredDraggableState<Boolean> anchoredDraggableState22 = (AnchoredDraggableState) rememberedValue2;
            int i1022 = i6 >> 3;
            State rememberUpdatedState32 = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, i1022 & 14);
            int i1122 = i6 & 14;
            State rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), startRestartGroup, i1122);
            startRestartGroup.startReplaceableGroup(1204583054);
            changed2 = startRestartGroup.changed(anchoredDraggableState22) | startRestartGroup.changed(rememberUpdatedState222) | startRestartGroup.changed(rememberUpdatedState32) | startRestartGroup.changed(mutableState);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2) {
            }
            mutableState2 = mutableState;
            rememberedValue3 = new SwitchKt$Switch$2$1(anchoredDraggableState22, rememberUpdatedState222, rememberUpdatedState32, mutableState2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(anchoredDraggableState22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 64);
            Boolean valueOf322 = Boolean.valueOf(z);
            Boolean valueOf422 = Boolean.valueOf(Switch$lambda$3(mutableState2));
            startRestartGroup.startReplaceableGroup(1204583419);
            changed3 = startRestartGroup.changed(z) | startRestartGroup.changed(anchoredDraggableState22);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue4 = new SwitchKt$Switch$3$1(z, anchoredDraggableState22, null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(valueOf322, valueOf422, (Function2) rememberedValue4, startRestartGroup, i1122 | 512);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localLayoutDirection22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (consume322 != LayoutDirection.Rtl) {
            }
            if (function1 == null) {
            }
            if (function1 == null) {
            }
            Modifier m922requiredSizeVpY3zN422 = SizeKt.m922requiredSizeVpY3zN4(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifier3.then(companion2).then(companion), anchoredDraggableState22, Orientation.Horizontal, (z5 || function1 == null) ? false : true, z7, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), false, i7, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN422);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229337676, "C174@7661L258:Switch.kt#jmzs0o");
            boolean booleanValue22 = ((Boolean) anchoredDraggableState22.getTargetValue()).booleanValue();
            startRestartGroup.startReplaceableGroup(1204584972);
            changed4 = startRestartGroup.changed(anchoredDraggableState22);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed4) {
            }
            rememberedValue5 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$4$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(anchoredDraggableState22.requireOffset());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            Modifier modifier522 = modifier3;
            SwitchImpl(boxScopeInstance22, booleanValue22, z5, switchColors3, (Function0) rememberedValue5, mutableInteractionSource5, startRestartGroup, (i1022 & 896) | 6 | ((i6 >> 6) & 7168) | ((i6 << 3) & 458752));
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier522;
            switchColors4 = switchColors3;
            mutableInteractionSource6 = mutableInteractionSource5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 458752) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity322 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume422 = startRestartGroup.consume(localDensity322);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float mo630toPx0680j_4322 = ((Density) consume422).mo630toPx0680j_4(ThumbPathLength);
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, str);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState = (MutableState) rememberedValue;
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float mo630toPx0680j_42222 = ((Density) consume2222).mo630toPx0680j_4(SwitchVelocityThreshold);
        Float valueOf522 = Float.valueOf(mo630toPx0680j_4322);
        Float valueOf2222 = Float.valueOf(mo630toPx0680j_42222);
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(valueOf522) | startRestartGroup.changed(valueOf2222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        final float f222 = 0.0f;
        rememberedValue2 = new AnchoredDraggableState(Boolean.valueOf(z), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<Boolean>, Unit>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                invoke2(draggableAnchorsConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DraggableAnchorsConfig<Boolean> draggableAnchorsConfig) {
                draggableAnchorsConfig.at(false, f222);
                draggableAnchorsConfig.at(true, mo630toPx0680j_4322);
            }
        }), new Function1<Float, Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$2
            public final Float invoke(float f2222) {
                return Float.valueOf(f2222 * 0.7f);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f2222) {
                return invoke(f2222.floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$anchoredDraggableState$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(mo630toPx0680j_42222);
            }
        }, AnimationSpec, null, 32, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final AnchoredDraggableState<Boolean> anchoredDraggableState222 = (AnchoredDraggableState) rememberedValue2;
        int i10222 = i6 >> 3;
        State rememberUpdatedState322 = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, i10222 & 14);
        int i11222 = i6 & 14;
        State rememberUpdatedState2222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z), startRestartGroup, i11222);
        startRestartGroup.startReplaceableGroup(1204583054);
        changed2 = startRestartGroup.changed(anchoredDraggableState222) | startRestartGroup.changed(rememberUpdatedState2222) | startRestartGroup.changed(rememberUpdatedState322) | startRestartGroup.changed(mutableState);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed2) {
        }
        mutableState2 = mutableState;
        rememberedValue3 = new SwitchKt$Switch$2$1(anchoredDraggableState222, rememberUpdatedState2222, rememberUpdatedState322, mutableState2, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(anchoredDraggableState222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 64);
        Boolean valueOf3222 = Boolean.valueOf(z);
        Boolean valueOf4222 = Boolean.valueOf(Switch$lambda$3(mutableState2));
        startRestartGroup.startReplaceableGroup(1204583419);
        changed3 = startRestartGroup.changed(z) | startRestartGroup.changed(anchoredDraggableState222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue4 = new SwitchKt$Switch$3$1(z, anchoredDraggableState222, null);
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(valueOf3222, valueOf4222, (Function2) rememberedValue4, startRestartGroup, i11222 | 512);
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localLayoutDirection222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        if (consume3222 != LayoutDirection.Rtl) {
        }
        if (function1 == null) {
        }
        if (function1 == null) {
        }
        Modifier m922requiredSizeVpY3zN4222 = SizeKt.m922requiredSizeVpY3zN4(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(modifier3.then(companion2).then(companion), anchoredDraggableState222, Orientation.Horizontal, (z5 || function1 == null) ? false : true, z7, mutableInteractionSource5, false), Alignment.INSTANCE.getCenter(), false, i7, null), DefaultSwitchPadding), SwitchWidth, SwitchHeight);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN4222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229337676, "C174@7661L258:Switch.kt#jmzs0o");
        boolean booleanValue222 = ((Boolean) anchoredDraggableState222.getTargetValue()).booleanValue();
        startRestartGroup.startReplaceableGroup(1204584972);
        changed4 = startRestartGroup.changed(anchoredDraggableState222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed4) {
        }
        rememberedValue5 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.SwitchKt$Switch$4$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(anchoredDraggableState222.requireOffset());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        Modifier modifier5222 = modifier3;
        SwitchImpl(boxScopeInstance222, booleanValue222, z5, switchColors3, (Function0) rememberedValue5, mutableInteractionSource5, startRestartGroup, (i10222 & 896) | 6 | ((i6 >> 6) & 7168) | ((i6 << 3) & 458752));
        composer2 = startRestartGroup;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier5222;
        switchColors4 = switchColors3;
        mutableInteractionSource6 = mutableInteractionSource5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0<Float> function0, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        float f;
        long SwitchImpl$lambda$17;
        Composer startRestartGroup = composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(!1,2!1,4)220@9007L46,222@9059L648,241@9910L28,242@9943L171,248@10144L28,249@10222L7,*250@10281L7,252@10392L6,251@10331L228,264@10804L59,258@10564L475:Switch.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:219)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            startRestartGroup.startReplaceableGroup(1204586249);
            boolean changed = startRestartGroup.changed(interactionSource) | startRestartGroup.changed(snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function2) new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, ((i2 >> 15) & 14) | 64);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            int i3 = ((i2 >> 3) & 896) | ((i2 >> 6) & 14) | (i2 & 112);
            final State<Color> trackColor = switchColors.trackColor(z2, z, startRestartGroup, i3);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(1204587189);
            boolean changed2 = startRestartGroup.changed(trackColor);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        long SwitchImpl$lambda$15;
                        SwitchImpl$lambda$15 = SwitchKt.SwitchImpl$lambda$15(trackColor);
                        SwitchKt.m1796drawTrackRPmYEkk(drawScope, SwitchImpl$lambda$15, drawScope.mo630toPx0680j_4(SwitchKt.getTrackWidth()), drawScope.mo630toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue3, startRestartGroup, 0);
            State<Color> thumbColor = switchColors.thumbColor(z2, z, startRestartGroup, i3);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) consume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float m6389constructorimpl = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + f);
            startRestartGroup.startReplaceableGroup(-539243554);
            ComposerKt.sourceInformation(startRestartGroup, "253@10467L36");
            if (Color.m4064equalsimpl0(SwitchImpl$lambda$17(thumbColor), MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU()) && elevationOverlay != null) {
                SwitchImpl$lambda$17 = elevationOverlay.mo1643apply7g2Lkgo(SwitchImpl$lambda$17(thumbColor), m6389constructorimpl, startRestartGroup, 0);
            } else {
                SwitchImpl$lambda$17 = SwitchImpl$lambda$17(thumbColor);
            }
            startRestartGroup.endReplaceableGroup();
            State<Color> m421animateColorAsStateeuL9pac = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(SwitchImpl$lambda$17, null, null, null, startRestartGroup, 0, 14);
            startRestartGroup = startRestartGroup;
            Modifier align = boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            startRestartGroup.startReplaceableGroup(1204587807);
            boolean changedInstance = startRestartGroup.changedInstance(function0);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m6508boximpl(m1797invokeBjo55l4(density));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1797invokeBjo55l4(Density density) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(function0.invoke().floatValue()), 0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(SizeKt.m920requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue4), interactionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, startRestartGroup, 54, 4)), ThumbDiameter), f, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$18(m421animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    SwitchKt.SwitchImpl(BoxScope.this, z, z2, switchColors, function0, interactionSource, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1796drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.m4599drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f2, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$15(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    private static final long SwitchImpl$lambda$17(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    static {
        float m6389constructorimpl = Dp.m6389constructorimpl(34);
        TrackWidth = m6389constructorimpl;
        TrackStrokeWidth = Dp.m6389constructorimpl(14);
        float m6389constructorimpl2 = Dp.m6389constructorimpl(20);
        ThumbDiameter = m6389constructorimpl2;
        ThumbRippleRadius = Dp.m6389constructorimpl(24);
        DefaultSwitchPadding = Dp.m6389constructorimpl(2);
        SwitchWidth = m6389constructorimpl;
        SwitchHeight = m6389constructorimpl2;
        ThumbPathLength = Dp.m6389constructorimpl(m6389constructorimpl - m6389constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m6389constructorimpl(1);
        ThumbPressedElevation = Dp.m6389constructorimpl(6);
        SwitchVelocityThreshold = Dp.m6389constructorimpl(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
    }
}
