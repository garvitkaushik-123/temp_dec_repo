package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Menu.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001aY\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0080\u0001\u0010\u001f\u001a\u00020\u000e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000e0!¢\u0006\u0002\b\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!2\u0006\u0010\u0017\u001a\u00020\u00182\u0013\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010!¢\u0006\u0002\b\u001c2\u0013\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010!¢\u0006\u0002\b\u001c2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\u0010,\u001a\u001d\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0002\u00101\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u00062²\u0006\n\u00103\u001a\u000204X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u000204X\u008a\u0084\u0002"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MenuKt {
    public static final int InTransitionDuration = 120;
    public static final int OutTransitionDuration = 75;
    private static final float MenuVerticalMargin = Dp.m6389constructorimpl(48);
    private static final float DropdownMenuItemHorizontalPadding = Dp.m6389constructorimpl(12);
    private static final float DropdownMenuVerticalPadding = Dp.m6389constructorimpl(8);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m6389constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m6389constructorimpl(280);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuContent(final MutableTransitionState<Boolean> mutableTransitionState, final MutableState<TransformOrigin> mutableState, final ScrollState scrollState, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean changed;
        Object rememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1289304092);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuContent)P(1,4,3,2)235@9967L47,237@10044L569,257@10643L380,272@11080L153,278@11277L5,279@11314L11,271@11029L701:Menu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(mutableTransitionState) : startRestartGroup.changedInstance(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(mutableState) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(scrollState) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1289304092, i3, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:232)");
                }
                Transition updateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", startRestartGroup, MutableTransitionState.$stable | 48 | (i3 & 14), 0);
                MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i6) {
                        TweenSpec tween$default;
                        composer2.startReplaceableGroup(-952455731);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-952455731, i6, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:239)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tween$default;
                    }
                };
                startRestartGroup.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                startRestartGroup.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                boolean booleanValue = ((Boolean) updateTransition.getCurrentState()).booleanValue();
                startRestartGroup.startReplaceableGroup(2092995144);
                ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2092995144, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:254)");
                }
                float f = !booleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                startRestartGroup.endReplaceableGroup();
                Float valueOf = Float.valueOf(f);
                boolean booleanValue2 = ((Boolean) updateTransition.getTargetState()).booleanValue();
                startRestartGroup.startReplaceableGroup(2092995144);
                ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2092995144, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:254)");
                }
                float f2 = !booleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                startRestartGroup.endReplaceableGroup();
                int i6 = i3;
                final Modifier modifier4 = modifier2;
                final State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f2), menuKt$DropdownMenuContent$scale$2.invoke((MenuKt$DropdownMenuContent$scale$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i7) {
                        TweenSpec tween$default;
                        composer2.startReplaceableGroup(-1498621383);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1498621383, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:259)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tween$default;
                    }
                };
                startRestartGroup.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                startRestartGroup.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                boolean booleanValue3 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
                startRestartGroup.startReplaceableGroup(1546829492);
                ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    i4 = -1;
                } else {
                    i4 = -1;
                    ComposerKt.traceEventStart(1546829492, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:268)");
                }
                float f3 = !booleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                startRestartGroup.endReplaceableGroup();
                Float valueOf2 = Float.valueOf(f3);
                boolean booleanValue4 = ((Boolean) updateTransition.getTargetState()).booleanValue();
                startRestartGroup.startReplaceableGroup(1546829492);
                ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1546829492, 0, i4, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:268)");
                }
                float f4 = !booleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                startRestartGroup.endReplaceableGroup();
                final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f4), menuKt$DropdownMenuContent$alpha$2.invoke((MenuKt$DropdownMenuContent$alpha$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "FloatAnimation", startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(1402453378);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Menu.kt#9igjgp");
                changed = startRestartGroup.changed(createTransitionAnimation) | startRestartGroup.changed(createTransitionAnimation2) | ((i6 & 112) == 32);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                            float DropdownMenuContent$lambda$1;
                            float DropdownMenuContent$lambda$12;
                            float DropdownMenuContent$lambda$3;
                            DropdownMenuContent$lambda$1 = MenuKt.DropdownMenuContent$lambda$1(createTransitionAnimation);
                            graphicsLayerScope.setScaleX(DropdownMenuContent$lambda$1);
                            DropdownMenuContent$lambda$12 = MenuKt.DropdownMenuContent$lambda$1(createTransitionAnimation);
                            graphicsLayerScope.setScaleY(DropdownMenuContent$lambda$12);
                            DropdownMenuContent$lambda$3 = MenuKt.DropdownMenuContent$lambda$3(createTransitionAnimation2);
                            graphicsLayerScope.setAlpha(DropdownMenuContent$lambda$3);
                            graphicsLayerScope.mo4256setTransformOrigin__ExYCQ(mutableState.getValue().getPackedValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                SurfaceKt.m2633SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue), ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), startRestartGroup, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), MenuTokens.INSTANCE.getContainerColor()), 0L, MenuTokens.INSTANCE.m3272getContainerElevationD9Ej5fM(), MenuTokens.INSTANCE.m3272getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1266256833, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        ComposerKt.sourceInformation(composer2, "C283@11492L232:Menu.kt#uh7d8r");
                        if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266256833, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:283)");
                            }
                            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m881paddingVpY3zN4$default(Modifier.this, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), scrollState, false, null, false, 14, null);
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 12804096, 72);
                startRestartGroup = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, scrollState, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Transition updateTransition2 = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", startRestartGroup, MutableTransitionState.$stable | 48 | (i3 & 14), 0);
        MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i62) {
                TweenSpec tween$default;
                composer2.startReplaceableGroup(-952455731);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-952455731, i62, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:239)");
                }
                if (segment.isTransitioningTo(false, true)) {
                    tween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                } else {
                    tween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceableGroup();
                return tween$default;
            }
        };
        startRestartGroup.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        startRestartGroup.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        boolean booleanValue5 = ((Boolean) updateTransition2.getCurrentState()).booleanValue();
        startRestartGroup.startReplaceableGroup(2092995144);
        ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!booleanValue5) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        Float valueOf3 = Float.valueOf(f);
        boolean booleanValue22 = ((Boolean) updateTransition2.getTargetState()).booleanValue();
        startRestartGroup.startReplaceableGroup(2092995144);
        ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!booleanValue22) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        int i62 = i3;
        final Modifier modifier42 = modifier2;
        final State<Float> createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition2, valueOf3, Float.valueOf(f2), menuKt$DropdownMenuContent$scale$22.invoke((MenuKt$DropdownMenuContent$scale$2) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "FloatAnimation", startRestartGroup, 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$22 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i7) {
                TweenSpec tween$default;
                composer2.startReplaceableGroup(-1498621383);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498621383, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:259)");
                }
                if (segment.isTransitioningTo(false, true)) {
                    tween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                } else {
                    tween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceableGroup();
                return tween$default;
            }
        };
        startRestartGroup.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        startRestartGroup.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
        boolean booleanValue32 = ((Boolean) updateTransition2.getCurrentState()).booleanValue();
        startRestartGroup.startReplaceableGroup(1546829492);
        ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!booleanValue32) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        Float valueOf22 = Float.valueOf(f3);
        boolean booleanValue42 = ((Boolean) updateTransition2.getTargetState()).booleanValue();
        startRestartGroup.startReplaceableGroup(1546829492);
        ComposerKt.sourceInformation(startRestartGroup, "C:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!booleanValue42) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        final State<Float> createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition2, valueOf22, Float.valueOf(f4), menuKt$DropdownMenuContent$alpha$22.invoke((MenuKt$DropdownMenuContent$alpha$2) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22, "FloatAnimation", startRestartGroup, 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        startRestartGroup.startReplaceableGroup(1402453378);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Menu.kt#9igjgp");
        changed = startRestartGroup.changed(createTransitionAnimation3) | startRestartGroup.changed(createTransitionAnimation22) | ((i62 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                float DropdownMenuContent$lambda$1;
                float DropdownMenuContent$lambda$12;
                float DropdownMenuContent$lambda$3;
                DropdownMenuContent$lambda$1 = MenuKt.DropdownMenuContent$lambda$1(createTransitionAnimation3);
                graphicsLayerScope.setScaleX(DropdownMenuContent$lambda$1);
                DropdownMenuContent$lambda$12 = MenuKt.DropdownMenuContent$lambda$1(createTransitionAnimation3);
                graphicsLayerScope.setScaleY(DropdownMenuContent$lambda$12);
                DropdownMenuContent$lambda$3 = MenuKt.DropdownMenuContent$lambda$3(createTransitionAnimation22);
                graphicsLayerScope.setAlpha(DropdownMenuContent$lambda$3);
                graphicsLayerScope.mo4256setTransformOrigin__ExYCQ(mutableState.getValue().getPackedValue());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        SurfaceKt.m2633SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue), ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), startRestartGroup, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), MenuTokens.INSTANCE.getContainerColor()), 0L, MenuTokens.INSTANCE.m3272getContainerElevationD9Ej5fM(), MenuTokens.INSTANCE.m3272getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1266256833, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i7) {
                ComposerKt.sourceInformation(composer2, "C283@11492L232:Menu.kt#uh7d8r");
                if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266256833, i7, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:283)");
                    }
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m881paddingVpY3zN4$default(Modifier.this, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), scrollState, false, null, false, 14, null);
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 12804096, 72);
        startRestartGroup = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void DropdownMenuItemContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final boolean z, final MenuItemColors menuItemColors, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1564716777);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)312@12376L20,306@12132L2357:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(menuItemColors) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:304)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.m932sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m559clickableO2vRcR0$default(modifier, mutableInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6), z, null, null, function0, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, MenuTokens.INSTANCE.m3273getListItemContainerHeightD9Ej5fM(), DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1557325246, "C324@12879L10,324@12848L1635:Menu.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), MenuTokens.INSTANCE.getListItemLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1065051884, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C334@13380L18,334@13321L777,356@14235L26,355@14155L304:Menu.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1065051884, i3, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:325)");
                        }
                        composer2.startReplaceableGroup(1426260804);
                        ComposerKt.sourceInformation(composer2, "327@13072L25,326@12992L302");
                        if (function22 != null) {
                            ProvidedValue<Color> provides = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(menuItemColors.m2325leadingIconColorXeAY9LY$material3_release(z, composer2, 0)));
                            final Function2<Composer, Integer, Unit> function24 = function22;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer2, 2035552199, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.1
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

                                public final void invoke(Composer composer3, int i4) {
                                    ComposerKt.sourceInformation(composer3, "C329@13139L137:Menu.kt#uh7d8r");
                                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2035552199, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:329)");
                                        }
                                        Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m3274getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function25 = function24;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m913defaultMinSizeVpY3zN4$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 116818474, "C330@13241L13:Menu.kt#uh7d8r");
                                        function25.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ProvidedValue.$stable | 48);
                        }
                        composer2.endReplaceableGroup();
                        ProvidedValue<Color> provides2 = ContentColorKt.getLocalContentColor().provides(menuItemColors.textColor$material3_release(z, composer2, 0).getValue());
                        final RowScope rowScope = rowScopeInstance;
                        final Function2<Composer, Integer, Unit> function25 = function22;
                        final Function2<Composer, Integer, Unit> function26 = function23;
                        final Function2<Composer, Integer, Unit> function27 = function2;
                        CompositionLocalKt.CompositionLocalProvider(provides2, ComposableLambdaKt.composableLambda(composer2, -1728894036, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.2
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

                            public final void invoke(Composer composer3, int i4) {
                                float m6389constructorimpl;
                                float m6389constructorimpl2;
                                ComposerKt.sourceInformation(composer3, "C335@13424L660:Menu.kt#uh7d8r");
                                if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1728894036, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:335)");
                                    }
                                    Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    if (function25 != null) {
                                        m6389constructorimpl = MenuKt.DropdownMenuItemHorizontalPadding;
                                    } else {
                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                    }
                                    float f = m6389constructorimpl;
                                    if (function26 != null) {
                                        m6389constructorimpl2 = MenuKt.DropdownMenuItemHorizontalPadding;
                                    } else {
                                        m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                    }
                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(weight$default, f, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                    Function2<Composer, Integer, Unit> function28 = function27;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 116819293, "C351@14060L6:Menu.kt#uh7d8r");
                                    function28.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, ProvidedValue.$stable | 48);
                        if (function23 != null) {
                            ProvidedValue<Color> provides3 = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(menuItemColors.m2326trailingIconColorXeAY9LY$material3_release(z, composer2, 0)));
                            final Function2<Composer, Integer, Unit> function28 = function23;
                            CompositionLocalKt.CompositionLocalProvider(provides3, ComposableLambdaKt.composableLambda(composer2, 580312062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.3
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

                                public final void invoke(Composer composer3, int i4) {
                                    ComposerKt.sourceInformation(composer3, "C358@14302L139:Menu.kt#uh7d8r");
                                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(580312062, i4, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:358)");
                                        }
                                        Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m3275getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function29 = function28;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m913defaultMinSizeVpY3zN4$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 116819638, "C359@14405L14:Menu.kt#uh7d8r");
                                        function29.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ProvidedValue.$stable | 48);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier, function22, function23, z, menuItemColors, paddingValues, mutableInteractionSource, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float max;
        float f = 1.0f;
        if (intRect2.getLeft() < intRect.getRight()) {
            if (intRect2.getRight() <= intRect.getLeft()) {
                max = 1.0f;
            } else if (intRect2.getWidth() != 0) {
                max = (((Math.max(intRect.getLeft(), intRect2.getLeft()) + Math.min(intRect.getRight(), intRect2.getRight())) / 2) - intRect2.getLeft()) / intRect2.getWidth();
            }
            if (intRect2.getTop() < intRect.getBottom()) {
                if (intRect2.getBottom() > intRect.getTop()) {
                    if (intRect2.getHeight() != 0) {
                        f = (((Math.max(intRect.getTop(), intRect2.getTop()) + Math.min(intRect.getBottom(), intRect2.getBottom())) / 2) - intRect2.getTop()) / intRect2.getHeight();
                    }
                }
                return TransformOriginKt.TransformOrigin(max, f);
            }
            f = 0.0f;
            return TransformOriginKt.TransformOrigin(max, f);
        }
        max = 0.0f;
        if (intRect2.getTop() < intRect.getBottom()) {
        }
        f = 0.0f;
        return TransformOriginKt.TransformOrigin(max, f);
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
