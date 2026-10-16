package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0080\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0088\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ax\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a=\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006\n\u0010@\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = Dp.m6389constructorimpl(48);
    private static final float LargeTabHeight = Dp.m6389constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m6389constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m6389constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m6389constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m6389constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0108  */
    /* renamed from: Tab-0nD-MI0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1799Tab0nDMI0(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        int i7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        int i10;
        int i11;
        int i12;
        long j3;
        Modifier modifier3;
        int i13;
        int i14;
        int i15;
        long j4;
        int i16;
        boolean z5;
        MutableInteractionSource mutableInteractionSource3;
        final ComposableLambda composableLambda;
        long m4062copywmQWz5c$default;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Modifier modifier4;
        final boolean z6;
        final MutableInteractionSource mutableInteractionSource4;
        final long j5;
        final long j6;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation(startRestartGroup, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)97@4392L39,98@4485L7,99@4577L6,107@4834L234:Tab.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i18 = i2 & 4;
        if (i18 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z4 = z2;
                i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    function23 = function2;
                    i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i7 = 57344;
                        function24 = function22;
                    } else {
                        i7 = 57344;
                        function24 = function22;
                        if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
                        }
                    }
                    i8 = i2 & 64;
                    if (i8 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i9 = 458752;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        if ((i & 29360128) == 0) {
                            int i19 = i3;
                            if ((i2 & 128) == 0) {
                                i11 = i18;
                                if (startRestartGroup.changed(j)) {
                                    i17 = 8388608;
                                    i10 = i19 | i17;
                                }
                            } else {
                                i11 = i18;
                            }
                            i17 = 4194304;
                            i10 = i19 | i17;
                        } else {
                            i10 = i3;
                            i11 = i18;
                        }
                        if ((i & 234881024) == 0) {
                            i12 = i11;
                            i10 |= ((i2 & 256) == 0 && startRestartGroup.changed(j2)) ? 67108864 : 33554432;
                        } else {
                            i12 = i11;
                        }
                        if ((i10 & 191739611) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i5 != 0) {
                                    function23 = null;
                                }
                                if (i6 != 0) {
                                    function24 = null;
                                }
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                }
                                if ((i2 & 128) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    j3 = ((Color) consume).m4073unboximpl();
                                    i10 &= -29360129;
                                } else {
                                    j3 = j;
                                }
                                if ((i2 & 256) != 0) {
                                    long j7 = j3;
                                    modifier3 = modifier2;
                                    i13 = 3670016;
                                    i14 = i9;
                                    i15 = i10 & (-234881025);
                                    j4 = j7;
                                    i16 = -1486097588;
                                    z5 = z4;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    composableLambda = null;
                                    m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(j7, ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i16, i15, -1, "androidx.compose.material.Tab (Tab.kt:100)");
                                    }
                                    if (function23 != null) {
                                        composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1729014781, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$styledText$1$1
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

                                            public final void invoke(Composer composer3, int i20) {
                                                ComposerKt.sourceInformation(composer3, "C103@4709L10,104@4774L39:Tab.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1729014781, i20, -1, "androidx.compose.material.Tab.<anonymous>.<anonymous> (Tab.kt:103)");
                                                    }
                                                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    int i20 = 12582912 | (i15 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168);
                                    int i21 = i15 >> 6;
                                    composer2 = startRestartGroup;
                                    m1800TabEVJuX4I(z3, function02, modifier3, z5, mutableInteractionSource3, j4, m4062copywmQWz5c$default, ComposableLambdaKt.composableLambda(startRestartGroup, -178151495, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                            invoke(columnScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(ColumnScope columnScope, Composer composer3, int i22) {
                                            ComposerKt.sourceInformation(composer3, "C116@5013L49:Tab.kt#jmzs0o");
                                            if ((i22 & 81) == 16 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-178151495, i22, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:116)");
                                            }
                                            TabKt.TabBaselineLayout(composableLambda, function24, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, (i21 & i7) | i20 | (i21 & i14) | (i21 & i13), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function25 = function24;
                                    function26 = function23;
                                    modifier4 = modifier3;
                                    z6 = z5;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    j5 = j4;
                                    j6 = m4062copywmQWz5c$default;
                                } else {
                                    modifier3 = modifier2;
                                    i13 = 3670016;
                                    i14 = i9;
                                    i15 = i10;
                                    j4 = j3;
                                    i16 = -1486097588;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i10 &= -234881025;
                                }
                                modifier3 = modifier2;
                                i13 = 3670016;
                                i14 = i9;
                                i15 = i10;
                                i16 = -1486097588;
                                j4 = j;
                            }
                            z5 = z4;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            composableLambda = null;
                            m4062copywmQWz5c$default = j2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (function23 != null) {
                            }
                            int i202 = 12582912 | (i15 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168);
                            int i212 = i15 >> 6;
                            composer2 = startRestartGroup;
                            m1800TabEVJuX4I(z3, function02, modifier3, z5, mutableInteractionSource3, j4, m4062copywmQWz5c$default, ComposableLambdaKt.composableLambda(startRestartGroup, -178151495, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                    invoke(columnScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope columnScope, Composer composer3, int i22) {
                                    ComposerKt.sourceInformation(composer3, "C116@5013L49:Tab.kt#jmzs0o");
                                    if ((i22 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-178151495, i22, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:116)");
                                    }
                                    TabKt.TabBaselineLayout(composableLambda, function24, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, (i212 & i7) | i202 | (i212 & i14) | (i212 & i13), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function25 = function24;
                            function26 = function23;
                            modifier4 = modifier3;
                            z6 = z5;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            j5 = j4;
                            j6 = m4062copywmQWz5c$default;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            z6 = z4;
                            function25 = function24;
                            function26 = function23;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            j5 = j;
                            j6 = j2;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$3
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

                                public final void invoke(Composer composer3, int i22) {
                                    TabKt.m1799Tab0nDMI0(z, function0, modifier4, z6, function26, function25, mutableInteractionSource4, j5, j6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = 458752;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 29360128) == 0) {
                    }
                    if ((i & 234881024) == 0) {
                    }
                    if ((i10 & 191739611) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                }
                function23 = function2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                i8 = i2 & 64;
                if (i8 == 0) {
                }
                i9 = 458752;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 29360128) == 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((i10 & 191739611) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
            }
            z4 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function23 = function2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            i8 = i2 & 64;
            if (i8 == 0) {
            }
            i9 = 458752;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 29360128) == 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((i10 & 191739611) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z4 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function23 = function2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        i8 = i2 & 64;
        if (i8 == 0) {
        }
        i9 = 458752;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 29360128) == 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i10 & 191739611) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c4  */
    /* renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1798LeadingIconTab0nDMI0(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        final boolean z3;
        int i3;
        final Function0<Unit> function02;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        long j3;
        long m4062copywmQWz5c$default;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z5;
        final long j4;
        final long j5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation(startRestartGroup, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)159@6956L39,160@7049L7,161@7141L6,166@7389L60,168@7455L929:Tab.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                i4 = i2 & 16;
                if (i4 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i5 = i2 & 32;
                    if (i5 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        z4 = z2;
                        i3 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                        i6 = i2 & 64;
                        if (i6 != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                            if ((29360128 & i) != 0) {
                                i7 = i3 | (((i2 & 128) == 0 && startRestartGroup.changed(j)) ? 8388608 : 4194304);
                            } else {
                                i7 = i3;
                            }
                            if ((i & 234881024) == 0) {
                                i7 |= ((i2 & 256) == 0 && startRestartGroup.changed(j2)) ? 67108864 : 33554432;
                            }
                            if ((191739611 & i7) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z4 = true;
                                    }
                                    if (i6 != 0) {
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    if ((i2 & 128) == 0) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        i7 &= -29360129;
                                        j3 = ((Color) consume).m4073unboximpl();
                                    } else {
                                        j3 = j;
                                    }
                                    if ((i2 & 256) != 0) {
                                        m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(j3, ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                        i7 &= -234881025;
                                        final boolean z6 = z4;
                                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1499861761, i7, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:162)");
                                        }
                                        final Indication m1870rememberRipple9IZ8Weo = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                                        final Modifier modifier4 = modifier2;
                                        int i8 = i7 >> 21;
                                        m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                                            public final void invoke(Composer composer2, int i9) {
                                                float f;
                                                float f2;
                                                float f3;
                                                ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                                                if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                                                    }
                                                    Modifier modifier5 = Modifier.this;
                                                    f = TabKt.SmallTabHeight;
                                                    Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource4, m1870rememberRipple9IZ8Weo, z6, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                                                    f2 = TabKt.HorizontalTextPadding;
                                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function2<Composer, Integer, Unit> function25 = function24;
                                                    Function2<Composer, Integer, Unit> function26 = function2;
                                                    composer2.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                                                    composer2.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                                    ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                                                    function25.invoke(composer2, 0);
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    f3 = TabKt.TextDistanceFromLeadingIcon;
                                                    SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                                                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
                                        }), startRestartGroup, (i8 & 112) | (i8 & 14) | 3072 | ((i7 << 6) & 896));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        z5 = z6;
                                        j4 = m4062copywmQWz5c$default;
                                        j5 = j3;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i7 &= -29360129;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i7 &= -234881025;
                                    }
                                    j3 = j;
                                }
                                m4062copywmQWz5c$default = j2;
                                final boolean z62 = z4;
                                final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Indication m1870rememberRipple9IZ8Weo2 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
                                final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                                final Modifier modifier42 = modifier2;
                                int i82 = i7 >> 21;
                                m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                                    public final void invoke(Composer composer2, int i9) {
                                        float f;
                                        float f2;
                                        float f3;
                                        ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                                            }
                                            Modifier modifier5 = Modifier.this;
                                            f = TabKt.SmallTabHeight;
                                            Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource42, m1870rememberRipple9IZ8Weo2, z62, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                                            f2 = TabKt.HorizontalTextPadding;
                                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function25 = function242;
                                            Function2<Composer, Integer, Unit> function26 = function2;
                                            composer2.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                                            composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                            ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                                            function25.invoke(composer2, 0);
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f3 = TabKt.TextDistanceFromLeadingIcon;
                                            SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                                            TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
                                }), startRestartGroup, (i82 & 112) | (i82 & 14) | 3072 | ((i7 << 6) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier42;
                                mutableInteractionSource3 = mutableInteractionSource42;
                                z5 = z62;
                                j4 = m4062copywmQWz5c$default;
                                j5 = j3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                j5 = j;
                                modifier3 = modifier2;
                                z5 = z4;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                j4 = j2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$3
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

                                    public final void invoke(Composer composer2, int i9) {
                                        TabKt.m1798LeadingIconTab0nDMI0(z, function0, function2, function22, modifier3, z5, mutableInteractionSource3, j5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((29360128 & i) != 0) {
                        }
                        if ((i & 234881024) == 0) {
                        }
                        if ((191739611 & i7) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if ((i2 & 256) != 0) {
                        }
                        m4062copywmQWz5c$default = j2;
                        final boolean z622 = z4;
                        final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Indication m1870rememberRipple9IZ8Weo22 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = function23;
                        final Modifier modifier422 = modifier2;
                        int i822 = i7 >> 21;
                        m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                            public final void invoke(Composer composer2, int i9) {
                                float f;
                                float f2;
                                float f3;
                                ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                                if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                                    }
                                    Modifier modifier5 = Modifier.this;
                                    f = TabKt.SmallTabHeight;
                                    Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource422, m1870rememberRipple9IZ8Weo22, z622, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                                    f2 = TabKt.HorizontalTextPadding;
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function25 = function2422;
                                    Function2<Composer, Integer, Unit> function26 = function2;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                    ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                                    function25.invoke(composer2, 0);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f3 = TabKt.TextDistanceFromLeadingIcon;
                                    SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
                        }), startRestartGroup, (i822 & 112) | (i822 & 14) | 3072 | ((i7 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier422;
                        mutableInteractionSource3 = mutableInteractionSource422;
                        z5 = z622;
                        j4 = m4062copywmQWz5c$default;
                        j5 = j3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    i6 = i2 & 64;
                    if (i6 != 0) {
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((29360128 & i) != 0) {
                    }
                    if ((i & 234881024) == 0) {
                    }
                    if ((191739611 & i7) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    m4062copywmQWz5c$default = j2;
                    final boolean z6222 = z4;
                    final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Indication m1870rememberRipple9IZ8Weo222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = function23;
                    final Modifier modifier4222 = modifier2;
                    int i8222 = i7 >> 21;
                    m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                        public final void invoke(Composer composer2, int i9) {
                            float f;
                            float f2;
                            float f3;
                            ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                            if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                                }
                                Modifier modifier5 = Modifier.this;
                                f = TabKt.SmallTabHeight;
                                Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource4222, m1870rememberRipple9IZ8Weo222, z6222, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                                f2 = TabKt.HorizontalTextPadding;
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function25 = function24222;
                                Function2<Composer, Integer, Unit> function26 = function2;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                                function25.invoke(composer2, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                f3 = TabKt.TextDistanceFromLeadingIcon;
                                SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                                TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
                    }), startRestartGroup, (i8222 & 112) | (i8222 & 14) | 3072 | ((i7 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier4222;
                    mutableInteractionSource3 = mutableInteractionSource4222;
                    z5 = z6222;
                    j4 = m4062copywmQWz5c$default;
                    j5 = j3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 32;
                if (i5 == 0) {
                }
                z4 = z2;
                i6 = i2 & 64;
                if (i6 != 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((29360128 & i) != 0) {
                }
                if ((i & 234881024) == 0) {
                }
                if ((191739611 & i7) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((i2 & 256) != 0) {
                }
                m4062copywmQWz5c$default = j2;
                final boolean z62222 = z4;
                final MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Indication m1870rememberRipple9IZ8Weo2222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
                final Function2<? super Composer, ? super Integer, Unit> function242222 = function23;
                final Modifier modifier42222 = modifier2;
                int i82222 = i7 >> 21;
                m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                    public final void invoke(Composer composer2, int i9) {
                        float f;
                        float f2;
                        float f3;
                        ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                            }
                            Modifier modifier5 = Modifier.this;
                            f = TabKt.SmallTabHeight;
                            Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource42222, m1870rememberRipple9IZ8Weo2222, z62222, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                            f2 = TabKt.HorizontalTextPadding;
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function25 = function242222;
                            Function2<Composer, Integer, Unit> function26 = function2;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                            function25.invoke(composer2, 0);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            f3 = TabKt.TextDistanceFromLeadingIcon;
                            SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                            TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
                }), startRestartGroup, (i82222 & 112) | (i82222 & 14) | 3072 | ((i7 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42222;
                mutableInteractionSource3 = mutableInteractionSource42222;
                z5 = z62222;
                j4 = m4062copywmQWz5c$default;
                j5 = j3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function23 = function22;
            i4 = i2 & 16;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            z4 = z2;
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((29360128 & i) != 0) {
            }
            if ((i & 234881024) == 0) {
            }
            if ((191739611 & i7) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((i2 & 256) != 0) {
            }
            m4062copywmQWz5c$default = j2;
            final boolean z622222 = z4;
            final MutableInteractionSource mutableInteractionSource422222 = mutableInteractionSource2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Indication m1870rememberRipple9IZ8Weo22222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = function23;
            final Modifier modifier422222 = modifier2;
            int i822222 = i7 >> 21;
            m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

                public final void invoke(Composer composer2, int i9) {
                    float f;
                    float f2;
                    float f3;
                    ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                    if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                        }
                        Modifier modifier5 = Modifier.this;
                        f = TabKt.SmallTabHeight;
                        Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource422222, m1870rememberRipple9IZ8Weo22222, z622222, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                        f2 = TabKt.HorizontalTextPadding;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function2422222;
                        Function2<Composer, Integer, Unit> function26 = function2;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                        function25.invoke(composer2, 0);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f3 = TabKt.TextDistanceFromLeadingIcon;
                        SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                        TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
            }), startRestartGroup, (i822222 & 112) | (i822222 & 14) | 3072 | ((i7 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422222;
            mutableInteractionSource3 = mutableInteractionSource422222;
            z5 = z622222;
            j4 = m4062copywmQWz5c$default;
            j5 = j3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 8) == 0) {
        }
        function23 = function22;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((29360128 & i) != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((191739611 & i7) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) != 0) {
        }
        m4062copywmQWz5c$default = j2;
        final boolean z6222222 = z4;
        final MutableInteractionSource mutableInteractionSource4222222 = mutableInteractionSource2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Indication m1870rememberRipple9IZ8Weo222222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j3, startRestartGroup, ((i7 >> 15) & 896) | 6, 2);
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = function23;
        final Modifier modifier4222222 = modifier2;
        int i8222222 = i7 >> 21;
        m1801TabTransitionKlgxPg(j3, m4062copywmQWz5c$default, z, ComposableLambdaKt.composableLambda(startRestartGroup, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
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

            public final void invoke(Composer composer2, int i9) {
                float f;
                float f2;
                float f3;
                ComposerKt.sourceInformation(composer2, "C169@7535L843:Tab.kt#jmzs0o");
                if ((i9 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(866677691, i9, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:169)");
                    }
                    Modifier modifier5 = Modifier.this;
                    f = TabKt.SmallTabHeight;
                    Modifier m1120selectableO2vRcR0 = SelectableKt.m1120selectableO2vRcR0(SizeKt.m914height3ABfNKs(modifier5, f), z3, mutableInteractionSource4222222, m1870rememberRipple9IZ8Weo222222, z6222222, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02);
                    f2 = TabKt.HorizontalTextPadding;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m881paddingVpY3zN4$default(m1120selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function25 = function24222222;
                    Function2<Composer, Integer, Unit> function26 = function2;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 106889785, "C185@8147L6,186@8166L59,187@8264L10,188@8329L39:Tab.kt#jmzs0o");
                    function25.invoke(composer2, 0);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    f3 = TabKt.TextDistanceFromLeadingIcon;
                    SpacerKt.Spacer(SizeKt.m925requiredWidth3ABfNKs(companion, f3), composer2, 6);
                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function26, composer2, 0);
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
        }), startRestartGroup, (i8222222 & 112) | (i8222222 & 14) | 3072 | ((i7 << 6) & 896));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222222;
        mutableInteractionSource3 = mutableInteractionSource4222222;
        z5 = z6222222;
        j4 = m4062copywmQWz5c$default;
        j5 = j3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0088  */
    /* renamed from: Tab-EVJuX4I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1800TabEVJuX4I(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        Function0<Unit> function02;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        long j3;
        int i7;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        long j4;
        final Modifier modifier3;
        final boolean z5;
        int i8;
        long j5;
        final MutableInteractionSource mutableInteractionSource3;
        final long j6;
        Composer composer2;
        final Modifier modifier4;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z6;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(713679175);
        ComposerKt.sourceInformation(startRestartGroup, "C(Tab)P(5,4,3,1,2,6:c#ui.graphics.Color,7:c#ui.graphics.Color)228@10125L39,229@10218L7,230@10310L6,236@10604L60,238@10670L618:Tab.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            function02 = function0;
            i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                        if ((458752 & i) == 0) {
                            if ((i2 & 32) == 0) {
                                j3 = j;
                                if (startRestartGroup.changed(j3)) {
                                    i9 = 131072;
                                    i3 |= i9;
                                }
                            } else {
                                j3 = j;
                            }
                            i9 = 65536;
                            i3 |= i9;
                        } else {
                            j3 = j;
                        }
                        if ((3670016 & i) == 0) {
                            i7 = i3 | (((i2 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : 524288);
                        } else {
                            i7 = i3;
                        }
                        if ((i2 & 128) != 0) {
                            i7 |= 12582912;
                        } else if ((29360128 & i) == 0) {
                            function32 = function3;
                            i7 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            if ((i7 & 23967451) == 4793490 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z4 = true;
                                    }
                                    if (i6 != 0) {
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    if ((i2 & 32) != 0) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        j3 = ((Color) consume).m4073unboximpl();
                                        i7 &= -458753;
                                    }
                                    j4 = j3;
                                    if ((i2 & 64) == 0) {
                                        modifier3 = modifier2;
                                        j5 = Color.m4062copywmQWz5c$default(j4, ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                        z5 = z4;
                                        i8 = i7 & (-3670017);
                                    } else {
                                        modifier3 = modifier2;
                                        z5 = z4;
                                        i8 = i7;
                                        j5 = j2;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i7 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i7 &= -3670017;
                                    }
                                    z5 = z4;
                                    j4 = j3;
                                    i8 = i7;
                                    modifier3 = modifier2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    j5 = j2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(713679175, i8, -1, "androidx.compose.material.Tab (Tab.kt:232)");
                                }
                                final Indication m1870rememberRipple9IZ8Weo = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
                                final Function0<Unit> function03 = function02;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                final boolean z7 = z3;
                                int i10 = i8 >> 15;
                                m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                                        ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                                        if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                                            }
                                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z7, mutableInteractionSource3, m1870rememberRipple9IZ8Weo, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function03), 0.0f, 1, null);
                                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Function3<ColumnScope, Composer, Integer, Unit> function34 = function33;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                                }), startRestartGroup, (i10 & 112) | (i10 & 14) | 3072 | ((i8 << 6) & 896));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j6 = j5;
                                composer2 = startRestartGroup;
                                modifier4 = modifier3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                z6 = z5;
                                j7 = j4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                composer2 = startRestartGroup;
                                z6 = z4;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                j7 = j3;
                                j6 = j2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$6
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
                                        TabKt.m1800TabEVJuX4I(z, function0, modifier4, z6, mutableInteractionSource4, j7, j6, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i7 & 23967451) == 4793490) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        j4 = j3;
                        if ((i2 & 64) == 0) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Indication m1870rememberRipple9IZ8Weo2 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
                        final Function0<Unit> function032 = function02;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                        final boolean z72 = z3;
                        int i102 = i8 >> 15;
                        m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                                ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                                if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                                    }
                                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z72, mutableInteractionSource3, m1870rememberRipple9IZ8Weo2, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function032), 0.0f, 1, null);
                                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Function3<ColumnScope, Composer, Integer, Unit> function34 = function332;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                        }), startRestartGroup, (i102 & 112) | (i102 & 14) | 3072 | ((i8 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j6 = j5;
                        composer2 = startRestartGroup;
                        modifier4 = modifier3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        z6 = z5;
                        j7 = j4;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((458752 & i) == 0) {
                    }
                    if ((3670016 & i) == 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    function32 = function3;
                    if ((i7 & 23967451) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    j4 = j3;
                    if ((i2 & 64) == 0) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Indication m1870rememberRipple9IZ8Weo22 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
                    final Function0<Unit> function0322 = function02;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322 = function32;
                    final boolean z722 = z3;
                    int i1022 = i8 >> 15;
                    m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                            ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                            if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                                }
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z722, mutableInteractionSource3, m1870rememberRipple9IZ8Weo22, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0322), 0.0f, 1, null);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Function3<ColumnScope, Composer, Integer, Unit> function34 = function3322;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                    }), startRestartGroup, (i1022 & 112) | (i1022 & 14) | 3072 | ((i8 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j5;
                    composer2 = startRestartGroup;
                    modifier4 = modifier3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    z6 = z5;
                    j7 = j4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z4 = z2;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) == 0) {
                }
                if ((3670016 & i) == 0) {
                }
                if ((i2 & 128) != 0) {
                }
                function32 = function3;
                if ((i7 & 23967451) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                j4 = j3;
                if ((i2 & 64) == 0) {
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Indication m1870rememberRipple9IZ8Weo222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
                final Function0<Unit> function03222 = function02;
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222 = function32;
                final boolean z7222 = z3;
                int i10222 = i8 >> 15;
                m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                        ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                        if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                            }
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z7222, mutableInteractionSource3, m1870rememberRipple9IZ8Weo222, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function03222), 0.0f, 1, null);
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Function3<ColumnScope, Composer, Integer, Unit> function34 = function33222;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                }), startRestartGroup, (i10222 & 112) | (i10222 & 14) | 3072 | ((i8 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j5;
                composer2 = startRestartGroup;
                modifier4 = modifier3;
                mutableInteractionSource4 = mutableInteractionSource3;
                z6 = z5;
                j7 = j4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z4 = z2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) == 0) {
            }
            if ((3670016 & i) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            function32 = function3;
            if ((i7 & 23967451) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            j4 = j3;
            if ((i2 & 64) == 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Indication m1870rememberRipple9IZ8Weo2222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
            final Function0<Unit> function032222 = function02;
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332222 = function32;
            final boolean z72222 = z3;
            int i102222 = i8 >> 15;
            m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                    ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                    if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z72222, mutableInteractionSource3, m1870rememberRipple9IZ8Weo2222, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function032222), 0.0f, 1, null);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Function3<ColumnScope, Composer, Integer, Unit> function34 = function332222;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
            }), startRestartGroup, (i102222 & 112) | (i102222 & 14) | 3072 | ((i8 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j5;
            composer2 = startRestartGroup;
            modifier4 = modifier3;
            mutableInteractionSource4 = mutableInteractionSource3;
            z6 = z5;
            j7 = j4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z4 = z2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) == 0) {
        }
        if ((3670016 & i) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        function32 = function3;
        if ((i7 & 23967451) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        j4 = j3;
        if ((i2 & 64) == 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Indication m1870rememberRipple9IZ8Weo22222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, j4, startRestartGroup, ((i8 >> 9) & 896) | 6, 2);
        final Function0<Unit> function0322222 = function02;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322222 = function32;
        final boolean z722222 = z3;
        int i1022222 = i8 >> 15;
        m1801TabTransitionKlgxPg(j4, j5, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1237246709, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$5
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
                ComposerKt.sourceInformation(composer3, "C239@10750L532:Tab.kt#jmzs0o");
                if ((i11 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1237246709, i11, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:239)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1120selectableO2vRcR0(Modifier.this, z722222, mutableInteractionSource3, m1870rememberRipple9IZ8Weo22222, z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0322222), 0.0f, 1, null);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Function3<ColumnScope, Composer, Integer, Unit> function34 = function3322222;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    function34.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
        }), startRestartGroup, (i1022222 & 112) | (i1022222 & 14) | 3072 | ((i8 << 6) & 896));
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j5;
        composer2 = startRestartGroup;
        modifier4 = modifier3;
        mutableInteractionSource4 = mutableInteractionSource3;
        z6 = z5;
        j7 = j4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1801TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(-405571117);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)269@11719L26,270@11774L550,288@12329L164:Tab.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405571117, i2, -1, "androidx.compose.material.TabTransition (Tab.kt:268)");
            }
            int i3 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, startRestartGroup, i3 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i4) {
                    TweenSpec tween$default;
                    composer2.startReplaceableGroup(-2120892502);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2120892502, i4, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:272)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return tween$default;
                }
            };
            startRestartGroup.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            }
            long j3 = booleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            ColorSpace m4067getColorSpaceimpl = Color.m4067getColorSpaceimpl(j3);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m4067getColorSpaceimpl);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4067getColorSpaceimpl);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            }
            long j4 = booleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            Color m4053boximpl = Color.m4053boximpl(j4);
            boolean booleanValue3 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:286)");
            }
            long j5 = booleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceableGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, m4053boximpl, Color.m4053boximpl(j5), tabKt$TabTransition$color$2.invoke((TabKt$TabTransition$color$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "ColorAnimation", startRestartGroup, 32768);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(Color.m4062copywmQWz5c$default(TabTransition_Klgx_Pg$lambda$5(createTransitionAnimation), 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(TabTransition_Klgx_Pg$lambda$5(createTransitionAnimation))))}, function2, startRestartGroup, (i3 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabTransition$1
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

                public final void invoke(Composer composer2, int i4) {
                    TabKt.m1801TabTransitionKlgxPg(j, j2, z2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1249848471);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)305@12901L1917:Tab.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1249848471, i2, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:304)");
            }
            startRestartGroup.startReplaceableGroup(782580000);
            boolean changedInstance = startRestartGroup.changedInstance(function2) | startRestartGroup.changedInstance(function22);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeable;
                        final Placeable placeable2;
                        if (function2 != null) {
                            int size = list.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                Measurable measurable = list.get(i3);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                                    placeable = measurable.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable = null;
                        if (function22 != null) {
                            int size2 = list.size();
                            for (int i4 = 0; i4 < size2; i4++) {
                                Measurable measurable2 = list.get(i4);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                    placeable2 = measurable2.mo5333measureBRTryo0(j);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable2 = null;
                        final int max = Math.max(placeable != null ? placeable.getWidth() : 0, placeable2 != null ? placeable2.getWidth() : 0);
                        final int i5 = measureScope.mo624roundToPx0680j_4((placeable == null || placeable2 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                        final Integer valueOf = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getFirstBaseline())) : null;
                        final Integer valueOf2 = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getLastBaseline())) : null;
                        final Placeable placeable3 = placeable;
                        return MeasureScope.layout$default(measureScope, max, i5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Placeable placeable4;
                                Placeable placeable5 = Placeable.this;
                                if (placeable5 == null || (placeable4 = placeable2) == null) {
                                    if (placeable5 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable5, i5);
                                        return;
                                    }
                                    Placeable placeable6 = placeable2;
                                    if (placeable6 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable6, i5);
                                        return;
                                    }
                                    return;
                                }
                                MeasureScope measureScope2 = measureScope;
                                int i6 = max;
                                int i7 = i5;
                                Integer num = valueOf;
                                Intrinsics.checkNotNull(num);
                                int intValue = num.intValue();
                                Integer num2 = valueOf2;
                                Intrinsics.checkNotNull(num2);
                                TabKt.placeTextAndIcon(placementScope, measureScope2, placeable5, placeable4, i6, i7, intValue, num2.intValue());
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2141028410, "C:Tab.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-2141028410);
            ComposerKt.sourceInformation(startRestartGroup, "308@12967L123");
            if (function2 != null) {
                Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1952926210, "C310@13082L6:Tab.kt#jmzs0o");
                function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(448373087);
            ComposerKt.sourceInformation(startRestartGroup, "313@13153L41");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1952926106, "C313@13186L6:Tab.kt#jmzs0o");
                function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$3
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
                    TabKt.TabBaselineLayout(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        if (i3 == i4) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int mo624roundToPx0680j_4 = density.mo624roundToPx0680j_4(f) + density.mo624roundToPx0680j_4(TabRowDefaults.INSTANCE.m1809getIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo623roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - mo624roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }
}
