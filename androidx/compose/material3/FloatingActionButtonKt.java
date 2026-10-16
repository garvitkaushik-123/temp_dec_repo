package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u001az\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008c\u0001\u0010\n\u001a\u00020\u000b2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001c2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ao\u0010&\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001ao\u0010)\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u001ao\u0010+\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010(\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ExtendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "ExtendedFabEndIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "ExtendedFabMinimumWidth", "ExtendedFabStartIconPadding", "ExtendedFabTextPadding", "ExtendedFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float ExtendedFabStartIconPadding = Dp.m6389constructorimpl(16);
    private static final float ExtendedFabEndIconPadding = Dp.m6389constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m6389constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = Dp.m6389constructorimpl(80);
    private static final ExitTransition ExtendedFabCollapseAnimation = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, MotionTokens.INSTANCE.getEasingLinearCubicBezier(), 2, null), 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, null), Alignment.INSTANCE.getStart(), false, null, 12, null));
    private static final EnterTransition ExtendedFabExpandAnimation = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween(200, 100, MotionTokens.INSTANCE.getEasingLinearCubicBezier()), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedCubicBezier(), 2, null), Alignment.INSTANCE.getStart(), false, null, 12, null));

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ab  */
    /* renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2233FloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        Shape shape2;
        long j3;
        final long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i4;
        Shape shape3;
        int i5;
        long j5;
        long j6;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape4;
        long j7;
        final Modifier modifier3;
        final FloatingActionButtonElevation floatingActionButtonElevation3;
        Composer composer2;
        final Shape shape5;
        final long j8;
        final long j9;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-731723913);
        ComposerKt.sourceInformation(startRestartGroup, "C(FloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)96@4769L5,97@4833L14,98@4875L31,99@4984L11,100@5047L39,110@5412L54,103@5133L933:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    shape2 = shape;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) == 0) {
                        i3 &= -897;
                        shape3 = FloatingActionButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 8) == 0) {
                        i5 = i3 & (-7169);
                        j5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                    } else {
                        i5 = i3;
                        j5 = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(j5, startRestartGroup, (i5 >> 9) & 14);
                        i5 &= -57345;
                        j4 = m2049contentColorForek8zF_U;
                    }
                    int i9 = i5;
                    if ((i2 & 32) == 0) {
                        j6 = j5;
                        floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m2225elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                        i3 = i9 & (-458753);
                    } else {
                        j6 = j5;
                        i3 = i9;
                    }
                    if (i4 == 0) {
                        startRestartGroup.startReplaceableGroup(2094975814);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FloatingActionButton.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        modifier2 = companion;
                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier2 = companion;
                    }
                    shape4 = shape3;
                    j7 = j6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    shape4 = shape2;
                    j7 = j3;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731723913, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:102)");
                }
                int i10 = i3 << 3;
                long j10 = j4;
                SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, 1, null), false, shape4, j7, j10, floatingActionButtonElevation2.getDefaultElevation(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, startRestartGroup, ((i3 >> 18) & 14) | ((i3 >> 12) & 112)).getValue().m6403unboximpl(), null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1249316354, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
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
                        ComposerKt.sourceInformation(composer3, "C115@5646L10,113@5537L523:FloatingActionButton.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1249316354, i11, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:113)");
                            }
                            long j11 = j4;
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, fromToken, ComposableLambdaKt.composableLambda(composer3, -1771489750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i12) {
                                    ComposerKt.sourceInformation(composer4, "C117@5731L319:FloatingActionButton.kt#uh7d8r");
                                    if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1771489750, i12, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:117)");
                                        }
                                        Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM(), FabPrimaryTokens.INSTANCE.m3167getContainerHeightD9Ej5fM());
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function23 = function22;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1007141495, "C124@6039L9:FloatingActionButton.kt#uh7d8r");
                                        function23.invoke(composer4, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 14) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | ((i3 << 9) & 1879048192), 6, 260);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                composer2 = startRestartGroup;
                shape5 = shape4;
                j8 = j7;
                j9 = j10;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                startRestartGroup.skipToGroupEnd();
                mutableInteractionSource3 = mutableInteractionSource;
                modifier3 = modifier2;
                shape5 = shape2;
                composer2 = startRestartGroup;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                j8 = j3;
                j9 = j4;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$4
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
                        FloatingActionButtonKt.m2233FloatingActionButtonXz6DiA(function0, modifier3, shape5, j8, j9, floatingActionButtonElevation3, mutableInteractionSource3, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i92 = i5;
        if ((i2 & 32) == 0) {
        }
        if (i4 == 0) {
        }
        shape4 = shape3;
        j7 = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i102 = i3 << 3;
        long j102 = j4;
        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, 1, null), false, shape4, j7, j102, floatingActionButtonElevation2.getDefaultElevation(), floatingActionButtonElevation2.shadowElevation$material3_release(mutableInteractionSource2, startRestartGroup, ((i3 >> 18) & 14) | ((i3 >> 12) & 112)).getValue().m6403unboximpl(), null, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1249316354, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3
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
                ComposerKt.sourceInformation(composer3, "C115@5646L10,113@5537L523:FloatingActionButton.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1249316354, i11, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:113)");
                    }
                    long j11 = j4;
                    TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j11, fromToken, ComposableLambdaKt.composableLambda(composer3, -1771489750, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$FloatingActionButton$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i12) {
                            ComposerKt.sourceInformation(composer4, "C117@5731L319:FloatingActionButton.kt#uh7d8r");
                            if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1771489750, i12, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:117)");
                                }
                                Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM(), FabPrimaryTokens.INSTANCE.m3167getContainerHeightD9Ej5fM());
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function23 = function22;
                                composer4.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1007141495, "C124@6039L9:FloatingActionButton.kt#uh7d8r");
                                function23.invoke(composer4, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 14) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | ((i3 << 9) & 1879048192), 6, 260);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        floatingActionButtonElevation3 = floatingActionButtonElevation2;
        composer2 = startRestartGroup;
        shape5 = shape4;
        j8 = j7;
        j9 = j102;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b1  */
    /* renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2235SmallFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i5;
        long j5;
        long j6;
        long j7;
        int i6;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j8;
        final Modifier modifier3;
        Composer composer2;
        final Shape shape5;
        final long j9;
        final long j10;
        final FloatingActionButtonElevation floatingActionButtonElevation4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1444748300);
        ComposerKt.sourceInformation(startRestartGroup, "C(SmallFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)159@7912L10,160@7981L14,161@8023L31,162@8132L11,163@8195L39,166@8281L431:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    shape2 = shape;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 4) == 0) {
                                i3 &= -897;
                                shape3 = FloatingActionButtonDefaults.INSTANCE.getSmallShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 8) == 0) {
                                i5 = i3 & (-7169);
                                j5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            } else {
                                i5 = i3;
                                j5 = j3;
                            }
                            if ((i2 & 16) != 0) {
                                long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(j5, startRestartGroup, (i5 >> 9) & 14);
                                i5 &= -57345;
                                j4 = m2049contentColorForek8zF_U;
                            }
                            int i10 = i5;
                            if ((i2 & 32) == 0) {
                                j6 = j5;
                                floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m2225elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 = i10 & (-458753);
                            } else {
                                j6 = j5;
                                i3 = i10;
                            }
                            if (i4 == 0) {
                                startRestartGroup.startReplaceableGroup(585135857);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FloatingActionButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                modifier2 = companion;
                                shape4 = shape3;
                                j7 = j6;
                                i6 = 1444748300;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            } else {
                                modifier2 = companion;
                                j7 = j6;
                                i6 = 1444748300;
                                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                shape4 = shape3;
                            }
                            j8 = j4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            j7 = j3;
                            j8 = j4;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i6 = 1444748300;
                            shape4 = shape2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:165)");
                        }
                        m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimarySmallTokens.INSTANCE.m3157getContainerWidthD9Ej5fM(), FabPrimarySmallTokens.INSTANCE.m3156getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer2 = startRestartGroup;
                        shape5 = shape4;
                        j9 = j7;
                        j10 = j8;
                        floatingActionButtonElevation4 = floatingActionButtonElevation3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape5 = shape2;
                        composer2 = startRestartGroup;
                        floatingActionButtonElevation4 = floatingActionButtonElevation2;
                        j9 = j3;
                        j10 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$SmallFloatingActionButton$2
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
                                FloatingActionButtonKt.m2235SmallFloatingActionButtonXz6DiA(function0, modifier3, shape5, j9, j10, floatingActionButtonElevation4, mutableInteractionSource4, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if ((i2 & 4) == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i102 = i5;
                if ((i2 & 32) == 0) {
                }
                if (i4 == 0) {
                }
                j8 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimarySmallTokens.INSTANCE.m3157getContainerWidthD9Ej5fM(), FabPrimarySmallTokens.INSTANCE.m3156getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                composer2 = startRestartGroup;
                shape5 = shape4;
                j9 = j7;
                j10 = j8;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if ((i2 & 4) == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i1022 = i5;
            if ((i2 & 32) == 0) {
            }
            if (i4 == 0) {
            }
            j8 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimarySmallTokens.INSTANCE.m3157getContainerWidthD9Ej5fM(), FabPrimarySmallTokens.INSTANCE.m3156getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            composer2 = startRestartGroup;
            shape5 = shape4;
            j9 = j7;
            j10 = j8;
            floatingActionButtonElevation4 = floatingActionButtonElevation3;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i10222 = i5;
        if ((i2 & 32) == 0) {
        }
        if (i4 == 0) {
        }
        j8 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimarySmallTokens.INSTANCE.m3157getContainerWidthD9Ej5fM(), FabPrimarySmallTokens.INSTANCE.m3156getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        composer2 = startRestartGroup;
        shape5 = shape4;
        j9 = j7;
        j10 = j8;
        floatingActionButtonElevation4 = floatingActionButtonElevation3;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b1  */
    /* renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2234LargeFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i5;
        long j5;
        long j6;
        long j7;
        int i6;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        long j8;
        final Modifier modifier3;
        Composer composer2;
        final Shape shape5;
        final long j9;
        final long j10;
        final FloatingActionButtonElevation floatingActionButtonElevation4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1650866856);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)211@10558L10,212@10627L14,213@10669L31,214@10778L11,215@10841L39,218@10927L431:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    shape2 = shape;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                        i7 = 131072;
                        i3 |= i7;
                    }
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i7 = 65536;
                i3 |= i7;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 4) == 0) {
                                i3 &= -897;
                                shape3 = FloatingActionButtonDefaults.INSTANCE.getLargeShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 8) == 0) {
                                i5 = i3 & (-7169);
                                j5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            } else {
                                i5 = i3;
                                j5 = j3;
                            }
                            if ((i2 & 16) != 0) {
                                long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(j5, startRestartGroup, (i5 >> 9) & 14);
                                i5 &= -57345;
                                j4 = m2049contentColorForek8zF_U;
                            }
                            int i10 = i5;
                            if ((i2 & 32) == 0) {
                                j6 = j5;
                                floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m2225elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 = i10 & (-458753);
                            } else {
                                j6 = j5;
                                i3 = i10;
                            }
                            if (i4 == 0) {
                                startRestartGroup.startReplaceableGroup(2133197715);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FloatingActionButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                modifier2 = companion;
                                shape4 = shape3;
                                j7 = j6;
                                i6 = -1650866856;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            } else {
                                modifier2 = companion;
                                j7 = j6;
                                i6 = -1650866856;
                                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                shape4 = shape3;
                            }
                            j8 = j4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            j7 = j3;
                            j8 = j4;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i6 = -1650866856;
                            shape4 = shape2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:217)");
                        }
                        m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimaryLargeTokens.INSTANCE.m3146getContainerWidthD9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.m3145getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer2 = startRestartGroup;
                        shape5 = shape4;
                        j9 = j7;
                        j10 = j8;
                        floatingActionButtonElevation4 = floatingActionButtonElevation3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape5 = shape2;
                        composer2 = startRestartGroup;
                        floatingActionButtonElevation4 = floatingActionButtonElevation2;
                        j9 = j3;
                        j10 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$LargeFloatingActionButton$2
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
                                FloatingActionButtonKt.m2234LargeFloatingActionButtonXz6DiA(function0, modifier3, shape5, j9, j10, floatingActionButtonElevation4, mutableInteractionSource4, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if ((i2 & 4) == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i102 = i5;
                if ((i2 & 32) == 0) {
                }
                if (i4 == 0) {
                }
                j8 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimaryLargeTokens.INSTANCE.m3146getContainerWidthD9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.m3145getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                composer2 = startRestartGroup;
                shape5 = shape4;
                j9 = j7;
                j10 = j8;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if ((i2 & 4) == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i1022 = i5;
            if ((i2 & 32) == 0) {
            }
            if (i4 == 0) {
            }
            j8 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimaryLargeTokens.INSTANCE.m3146getContainerWidthD9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.m3145getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            composer2 = startRestartGroup;
            shape5 = shape4;
            j9 = j7;
            j10 = j8;
            floatingActionButtonElevation4 = floatingActionButtonElevation3;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i10222 = i5;
        if ((i2 & 32) == 0) {
        }
        if (i4 == 0) {
        }
        j8 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2233FloatingActionButtonXz6DiA(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, FabPrimaryLargeTokens.INSTANCE.m3146getContainerWidthD9Ej5fM(), FabPrimaryLargeTokens.INSTANCE.m3145getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), shape4, j7, j8, floatingActionButtonElevation3, mutableInteractionSource3, function2, startRestartGroup, i3 & 33554318, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        composer2 = startRestartGroup;
        shape5 = shape4;
        j9 = j7;
        j10 = j8;
        floatingActionButtonElevation4 = floatingActionButtonElevation3;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b1  */
    /* renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2232ExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i4;
        Shape shape3;
        int i5;
        long j5;
        long j6;
        Shape shape4;
        long j7;
        Modifier modifier3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        int i6;
        long j8;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Modifier modifier4;
        final Shape shape5;
        final long j9;
        final long j10;
        final FloatingActionButtonElevation floatingActionButtonElevation4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-326283107);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)P(6,5,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,4)266@13342L16,267@13417L14,268@13459L31,269@13568L11,270@13631L39,273@13726L595:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i9 = 256;
                        i3 |= i9;
                    }
                } else {
                    shape2 = shape;
                }
                i9 = 128;
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) != 0) {
                j3 = j;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                j4 = j2;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
            } else {
                j4 = j2;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                        i8 = 131072;
                        i3 |= i8;
                    }
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i8 = 65536;
                i3 |= i8;
            } else {
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
            }
            if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) == 0) {
                        i3 &= -897;
                        shape3 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(startRestartGroup, 6);
                    } else {
                        shape3 = shape2;
                    }
                    if ((i2 & 8) == 0) {
                        i5 = i3 & (-7169);
                        j5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                    } else {
                        i5 = i3;
                        j5 = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(j5, startRestartGroup, (i5 >> 9) & 14);
                        i5 &= -57345;
                        j4 = m2049contentColorForek8zF_U;
                    }
                    int i11 = i5;
                    if ((i2 & 32) == 0) {
                        j6 = j5;
                        floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m2225elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                        i3 = i11 & (-458753);
                    } else {
                        j6 = j5;
                        i3 = i11;
                    }
                    if (i4 == 0) {
                        startRestartGroup.startReplaceableGroup(-2039336939);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FloatingActionButton.kt#9igjgp");
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        shape4 = shape3;
                        j7 = j4;
                        modifier3 = companion;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        i6 = 12582912;
                        j8 = j6;
                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                        i7 = -326283107;
                    } else {
                        shape4 = shape3;
                        j7 = j4;
                        modifier3 = companion;
                        floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        i6 = 12582912;
                        j8 = j6;
                        i7 = -326283107;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    floatingActionButtonElevation3 = floatingActionButtonElevation2;
                    j7 = j4;
                    i6 = 12582912;
                    i7 = -326283107;
                    modifier3 = modifier2;
                    shape4 = shape2;
                    j8 = j3;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:272)");
                }
                m2233FloatingActionButtonXz6DiA(function02, modifier3, shape4, j8, j7, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 398457247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                        float f;
                        float f2;
                        ComposerKt.sourceInformation(composer3, "C282@13999L316:FloatingActionButton.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(398457247, i12, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:282)");
                            }
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            f = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                            Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(companion2, f, 0.0f, 0.0f, 0.0f, 14, null);
                            f2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(m932sizeInqDBjuR0$default, f2, 0.0f, 2, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                }), startRestartGroup, i6 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = startRestartGroup;
                modifier4 = modifier3;
                shape5 = shape4;
                j9 = j8;
                j10 = j7;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource2;
            } else {
                startRestartGroup.skipToGroupEnd();
                mutableInteractionSource3 = mutableInteractionSource;
                modifier4 = modifier2;
                shape5 = shape2;
                composer2 = startRestartGroup;
                floatingActionButtonElevation4 = floatingActionButtonElevation2;
                j9 = j3;
                j10 = j4;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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
                        FloatingActionButtonKt.m2232ExtendedFloatingActionButtonXz6DiA(function0, modifier4, shape5, j9, j10, floatingActionButtonElevation4, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i112 = i5;
        if ((i2 & 32) == 0) {
        }
        if (i4 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2233FloatingActionButtonXz6DiA(function02, modifier3, shape4, j8, j7, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 398457247, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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
                float f;
                float f2;
                ComposerKt.sourceInformation(composer3, "C282@13999L316:FloatingActionButton.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(398457247, i12, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:282)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    f = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                    Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(companion2, f, 0.0f, 0.0f, 0.0f, 14, null);
                    f2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                    Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(m932sizeInqDBjuR0$default, f2, 0.0f, 2, null);
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
        }), startRestartGroup, i6 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier4 = modifier3;
        shape5 = shape4;
        j9 = j8;
        j10 = j7;
        floatingActionButtonElevation4 = floatingActionButtonElevation3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a9  */
    /* renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2231ExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        final boolean z2;
        Shape shape2;
        long j3;
        int i5;
        FloatingActionButtonElevation floatingActionButtonElevation2;
        int i6;
        long j4;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        long j5;
        long j6;
        final boolean z3;
        final Modifier modifier3;
        final Shape shape4;
        final long j7;
        final long j8;
        final FloatingActionButtonElevation floatingActionButtonElevation4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1387401842);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)P(9,4,7,6,3,8,0:c#ui.graphics.Color,1:c#ui.graphics.Color)336@16884L16,337@16959L14,338@17001L31,339@17110L11,340@17173L39,342@17222L1269:FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
            }
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i9 = 131072;
                            i3 |= i9;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i9 = 65536;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i8 = 1048576;
                            i3 |= i8;
                        }
                    } else {
                        j3 = j;
                    }
                    i8 = 524288;
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                if ((i & 12582912) == 0) {
                    i5 = 12582912;
                    i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                } else {
                    i5 = 12582912;
                }
                if ((i & 100663296) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                        if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                            i7 = 67108864;
                            i3 |= i7;
                        }
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    i7 = 33554432;
                    i3 |= i7;
                } else {
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                    i3 |= C.ENCODING_PCM_32BIT;
                } else if ((805306368 & i) == 0) {
                    i3 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                    if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shape2 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(startRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                j3 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) == 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j4 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                floatingActionButtonElevation2 = FloatingActionButtonDefaults.INSTANCE.m2225elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                            }
                            if (i6 == 0) {
                                startRestartGroup.startReplaceableGroup(-2039333397);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):FloatingActionButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            shape3 = shape2;
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            j5 = j4;
                            j6 = j3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            j5 = j2;
                            mutableInteractionSource2 = mutableInteractionSource;
                            shape3 = shape2;
                            j6 = j3;
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1387401842, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:341)");
                        }
                        int i11 = i3 >> 6;
                        int i12 = i3 >> 9;
                        Modifier modifier4 = modifier2;
                        m2233FloatingActionButtonXz6DiA(function02, modifier4, shape3, j6, j5, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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

                            public final void invoke(Composer composer2, int i13) {
                                float m6389constructorimpl;
                                float m6389constructorimpl2;
                                float m3168getContainerWidthD9Ej5fM;
                                EnterTransition enterTransition;
                                ExitTransition exitTransition;
                                ComposerKt.sourceInformation(composer2, "C354@17647L838:FloatingActionButton.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1172118032, i13, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:351)");
                                    }
                                    if (z2) {
                                        m6389constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                                    } else {
                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                    }
                                    float f = m6389constructorimpl;
                                    if (z2) {
                                        m6389constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                                    } else {
                                        m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                    }
                                    float f2 = m6389constructorimpl2;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    if (z2) {
                                        m3168getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                                    } else {
                                        m3168getContainerWidthD9Ej5fM = FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM();
                                    }
                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.m932sizeInqDBjuR0$default(companion, m3168getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function23 = function22;
                                    boolean z4 = z2;
                                    final Function2<Composer, Integer, Unit> function24 = function2;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1419543993, "C364@18095L6,365@18114L361:FloatingActionButton.kt#uh7d8r");
                                    function23.invoke(composer2, 0);
                                    enterTransition = FloatingActionButtonKt.ExtendedFabExpandAnimation;
                                    exitTransition = FloatingActionButtonKt.ExtendedFabCollapseAnimation;
                                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                            invoke(animatedVisibilityScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i14) {
                                            float f3;
                                            ComposerKt.sourceInformation(composer3, "C370@18307L154:FloatingActionButton.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(176242764, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:370)");
                                            }
                                            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function25 = function24;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                                            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 180817433, "C371@18367L49,372@18437L6:FloatingActionButton.kt#uh7d8r");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            f3 = FloatingActionButtonKt.ExtendedFabEndIconPadding;
                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer3, 6);
                                            function25.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 1600518, 18);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
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
                        }), startRestartGroup, (i11 & 112) | (i11 & 14) | i5 | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (i12 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z3 = z2;
                        modifier3 = modifier4;
                        shape4 = shape3;
                        j7 = j6;
                        j8 = j5;
                        floatingActionButtonElevation4 = floatingActionButtonElevation3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z3 = z2;
                        shape4 = shape2;
                        j7 = j3;
                        floatingActionButtonElevation4 = floatingActionButtonElevation2;
                        j8 = j2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$6
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

                            public final void invoke(Composer composer2, int i13) {
                                FloatingActionButtonKt.m2231ExtendedFloatingActionButtonElI57k(function2, function22, function0, modifier3, z3, shape4, j7, j8, floatingActionButtonElevation4, mutableInteractionSource3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if (i6 == 0) {
                }
                shape3 = shape2;
                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                j5 = j4;
                j6 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i112 = i3 >> 6;
                int i122 = i3 >> 9;
                Modifier modifier42 = modifier2;
                m2233FloatingActionButtonXz6DiA(function02, modifier42, shape3, j6, j5, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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

                    public final void invoke(Composer composer2, int i13) {
                        float m6389constructorimpl;
                        float m6389constructorimpl2;
                        float m3168getContainerWidthD9Ej5fM;
                        EnterTransition enterTransition;
                        ExitTransition exitTransition;
                        ComposerKt.sourceInformation(composer2, "C354@17647L838:FloatingActionButton.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1172118032, i13, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:351)");
                            }
                            if (z2) {
                                m6389constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                            } else {
                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                            }
                            float f = m6389constructorimpl;
                            if (z2) {
                                m6389constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                            } else {
                                m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                            }
                            float f2 = m6389constructorimpl2;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            if (z2) {
                                m3168getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                            } else {
                                m3168getContainerWidthD9Ej5fM = FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM();
                            }
                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.m932sizeInqDBjuR0$default(companion, m3168getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function23 = function22;
                            boolean z4 = z2;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function2;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1419543993, "C364@18095L6,365@18114L361:FloatingActionButton.kt#uh7d8r");
                            function23.invoke(composer2, 0);
                            enterTransition = FloatingActionButtonKt.ExtendedFabExpandAnimation;
                            exitTransition = FloatingActionButtonKt.ExtendedFabCollapseAnimation;
                            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i14) {
                                    float f3;
                                    ComposerKt.sourceInformation(composer3, "C370@18307L154:FloatingActionButton.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(176242764, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:370)");
                                    }
                                    Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function25 = function24;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                                    Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 180817433, "C371@18367L49,372@18437L6:FloatingActionButton.kt#uh7d8r");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    f3 = FloatingActionButtonKt.ExtendedFabEndIconPadding;
                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer3, 6);
                                    function25.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 1600518, 18);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
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
                }), startRestartGroup, (i112 & 112) | (i112 & 14) | i5 | (i122 & 896) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (i122 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z3 = z2;
                modifier3 = modifier42;
                shape4 = shape3;
                j7 = j6;
                j8 = j5;
                floatingActionButtonElevation4 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i6 = i2 & 512;
            if (i6 != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (i6 == 0) {
            }
            shape3 = shape2;
            floatingActionButtonElevation3 = floatingActionButtonElevation2;
            j5 = j4;
            j6 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1122 = i3 >> 6;
            int i1222 = i3 >> 9;
            Modifier modifier422 = modifier2;
            m2233FloatingActionButtonXz6DiA(function02, modifier422, shape3, j6, j5, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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

                public final void invoke(Composer composer2, int i13) {
                    float m6389constructorimpl;
                    float m6389constructorimpl2;
                    float m3168getContainerWidthD9Ej5fM;
                    EnterTransition enterTransition;
                    ExitTransition exitTransition;
                    ComposerKt.sourceInformation(composer2, "C354@17647L838:FloatingActionButton.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1172118032, i13, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:351)");
                        }
                        if (z2) {
                            m6389constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                        } else {
                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                        }
                        float f = m6389constructorimpl;
                        if (z2) {
                            m6389constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                        } else {
                            m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                        }
                        float f2 = m6389constructorimpl2;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if (z2) {
                            m3168getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                        } else {
                            m3168getContainerWidthD9Ej5fM = FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM();
                        }
                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.m932sizeInqDBjuR0$default(companion, m3168getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function23 = function22;
                        boolean z4 = z2;
                        final Function2<? super Composer, ? super Integer, Unit> function24 = function2;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1419543993, "C364@18095L6,365@18114L361:FloatingActionButton.kt#uh7d8r");
                        function23.invoke(composer2, 0);
                        enterTransition = FloatingActionButtonKt.ExtendedFabExpandAnimation;
                        exitTransition = FloatingActionButtonKt.ExtendedFabCollapseAnimation;
                        AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i14) {
                                float f3;
                                ComposerKt.sourceInformation(composer3, "C370@18307L154:FloatingActionButton.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(176242764, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:370)");
                                }
                                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function2<Composer, Integer, Unit> function25 = function24;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                                Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 180817433, "C371@18367L49,372@18437L6:FloatingActionButton.kt#uh7d8r");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                f3 = FloatingActionButtonKt.ExtendedFabEndIconPadding;
                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer3, 6);
                                function25.invoke(composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 1600518, 18);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
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
            }), startRestartGroup, (i1122 & 112) | (i1122 & 14) | i5 | (i1222 & 896) | (i1222 & 7168) | (57344 & i1222) | (458752 & i1222) | (i1222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z3 = z2;
            modifier3 = modifier422;
            shape4 = shape3;
            j7 = j6;
            j8 = j5;
            floatingActionButtonElevation4 = floatingActionButtonElevation3;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z2 = z;
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i6 = i2 & 512;
        if (i6 != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (i6 == 0) {
        }
        shape3 = shape2;
        floatingActionButtonElevation3 = floatingActionButtonElevation2;
        j5 = j4;
        j6 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i11222 = i3 >> 6;
        int i12222 = i3 >> 9;
        Modifier modifier4222 = modifier2;
        m2233FloatingActionButtonXz6DiA(function02, modifier4222, shape3, j6, j5, floatingActionButtonElevation3, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 1172118032, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5
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

            public final void invoke(Composer composer2, int i13) {
                float m6389constructorimpl;
                float m6389constructorimpl2;
                float m3168getContainerWidthD9Ej5fM;
                EnterTransition enterTransition;
                ExitTransition exitTransition;
                ComposerKt.sourceInformation(composer2, "C354@17647L838:FloatingActionButton.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1172118032, i13, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:351)");
                    }
                    if (z2) {
                        m6389constructorimpl = FloatingActionButtonKt.ExtendedFabStartIconPadding;
                    } else {
                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                    }
                    float f = m6389constructorimpl;
                    if (z2) {
                        m6389constructorimpl2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                    } else {
                        m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                    }
                    float f2 = m6389constructorimpl2;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    if (z2) {
                        m3168getContainerWidthD9Ej5fM = FloatingActionButtonKt.ExtendedFabMinimumWidth;
                    } else {
                        m3168getContainerWidthD9Ej5fM = FabPrimaryTokens.INSTANCE.m3168getContainerWidthD9Ej5fM();
                    }
                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.m932sizeInqDBjuR0$default(companion, m3168getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical start = z2 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function23 = function22;
                    boolean z4 = z2;
                    final Function2<? super Composer, ? super Integer, Unit> function24 = function2;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1419543993, "C364@18095L6,365@18114L361:FloatingActionButton.kt#uh7d8r");
                    function23.invoke(composer2, 0);
                    enterTransition = FloatingActionButtonKt.ExtendedFabExpandAnimation;
                    exitTransition = FloatingActionButtonKt.ExtendedFabCollapseAnimation;
                    AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z4, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 176242764, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i14) {
                            float f3;
                            ComposerKt.sourceInformation(composer3, "C370@18307L154:FloatingActionButton.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(176242764, i14, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:370)");
                            }
                            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            Function2<Composer, Integer, Unit> function25 = function24;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 180817433, "C371@18367L49,372@18437L6:FloatingActionButton.kt#uh7d8r");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            f3 = FloatingActionButtonKt.ExtendedFabEndIconPadding;
                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer3, 6);
                            function25.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 1600518, 18);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
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
        }), startRestartGroup, (i11222 & 112) | (i11222 & 14) | i5 | (i12222 & 896) | (i12222 & 7168) | (57344 & i12222) | (458752 & i12222) | (i12222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z3 = z2;
        modifier3 = modifier4222;
        shape4 = shape3;
        j7 = j6;
        j8 = j5;
        floatingActionButtonElevation4 = floatingActionButtonElevation3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
