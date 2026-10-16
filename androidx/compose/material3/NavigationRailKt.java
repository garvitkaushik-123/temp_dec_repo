package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: NavigationRail.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u007f\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailVerticalPadding;
    private static final float NavigationRailHeaderPadding = Dp.m6389constructorimpl(8);
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m3290getContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m3293getNoLabelActiveIndicatorHeightD9Ej5fM();

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0099  */
    /* renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2376NavigationRailqi6gXK8(Modifier modifier, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets2;
        long j5;
        final WindowInsets windowInsets3;
        Modifier modifier3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        Composer composer2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long j6;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(118552648);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)106@4973L14,107@5015L31,109@5162L12,112@5232L748:NavigationRail.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            function33 = function3;
            i3 |= startRestartGroup.changedInstance(function33) ? 2048 : 1024;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    if (startRestartGroup.changed(windowInsets2)) {
                        i4 = 16384;
                        i3 |= i4;
                    }
                } else {
                    windowInsets2 = windowInsets;
                }
                i4 = 8192;
                i3 |= i4;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j3 = NavigationRailDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        function33 = null;
                    }
                    if ((i2 & 16) == 0) {
                        windowInsets3 = NavigationRailDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                        i3 &= -57345;
                        j5 = j4;
                    } else {
                        j5 = j4;
                        windowInsets3 = windowInsets2;
                    }
                    modifier3 = companion;
                    function34 = function33;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    j5 = j4;
                    function34 = function33;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                }
                long j8 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(118552648, i3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:111)");
                }
                int i8 = (i3 & 14) | 12582912;
                int i9 = i3 << 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier3, null, j8, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
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

                    public final void invoke(Composer composer3, int i10) {
                        float f;
                        ComposerKt.sourceInformation(composer3, "C117@5355L619:NavigationRail.kt#uh7d8r");
                        if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2092683357, i10, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                            }
                            Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(SizeKt.m935widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), NavigationRailTokens.INSTANCE.m3290getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                            Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                            Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m788spacedBy0680j_4, centerHorizontally, composer3, 54);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
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
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 716053806, "C131@5955L9:NavigationRail.kt#uh7d8r");
                            composer3.startReplaceableGroup(716053806);
                            ComposerKt.sourceInformation(composer3, "128@5851L8,129@5876L52");
                            if (function36 != null) {
                                function36.invoke(columnScopeInstance, composer3, 6);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                f = NavigationRailKt.NavigationRailHeaderPadding;
                                SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion2, f), composer3, 6);
                            }
                            composer3.endReplaceableGroup();
                            function37.invoke(columnScopeInstance, composer3, 6);
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
                }), composer2, i8 | (i9 & 896) | (i9 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function35 = function34;
                windowInsets4 = windowInsets3;
                modifier4 = modifier3;
                j6 = j8;
                j7 = j5;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
                modifier4 = modifier2;
                j6 = j3;
                j7 = j4;
                function35 = function33;
                windowInsets4 = windowInsets2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$2
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

                    public final void invoke(Composer composer3, int i10) {
                        NavigationRailKt.m2376NavigationRailqi6gXK8(Modifier.this, j6, j7, function35, windowInsets4, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        function33 = function3;
        if ((i & 24576) != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        modifier3 = companion;
        function34 = function33;
        long j82 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i82 = (i3 & 14) | 12582912;
        int i92 = i3 << 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier3, null, j82, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2092683357, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRail$1
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

            public final void invoke(Composer composer3, int i10) {
                float f;
                ComposerKt.sourceInformation(composer3, "C117@5355L619:NavigationRail.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2092683357, i10, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                    }
                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(SizeKt.m935widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), NavigationRailTokens.INSTANCE.m3290getContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
                    Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                    Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m788spacedBy0680j_4, centerHorizontally, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
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
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 716053806, "C131@5955L9:NavigationRail.kt#uh7d8r");
                    composer3.startReplaceableGroup(716053806);
                    ComposerKt.sourceInformation(composer3, "128@5851L8,129@5876L52");
                    if (function36 != null) {
                        function36.invoke(columnScopeInstance, composer3, 6);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        f = NavigationRailKt.NavigationRailHeaderPadding;
                        SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion2, f), composer3, 6);
                    }
                    composer3.endReplaceableGroup();
                    function37.invoke(columnScopeInstance, composer3, 6);
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
        }), composer2, i82 | (i92 & 896) | (i92 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        function35 = function34;
        windowInsets4 = windowInsets3;
        modifier4 = modifier3;
        j6 = j82;
        j7 = j5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0380  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationRailItem(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        final boolean z4;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i7;
        boolean z5;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        NavigationRailItemColors navigationRailItemColors2;
        MutableInteractionSource mutableInteractionSource3;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean changed;
        Object rememberedValue;
        final Shape value;
        boolean changed2;
        Object rememberedValue2;
        final boolean z6;
        final NavigationRailItemColors navigationRailItemColors3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1533971045);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItem)P(8,7,3,6,2,5)172@7762L8,173@7822L39,196@8797L2874:NavigationRail.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
                i4 = i2 & 8;
                if (i4 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
                    i5 = i2 & 16;
                    if (i5 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        z4 = z2;
                        i3 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                        i6 = i2 & 32;
                        if (i6 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            function23 = function22;
                            i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                            i7 = i2 & 64;
                            if (i7 == 0) {
                                i3 |= 1572864;
                                z5 = z3;
                            } else {
                                z5 = z3;
                                if ((i & 1572864) == 0) {
                                    i3 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                                }
                            }
                            if ((i & 12582912) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changed(navigationRailItemColors)) {
                                    i9 = 8388608;
                                    i3 |= i9;
                                }
                                i9 = 4194304;
                                i3 |= i9;
                            }
                            i8 = i2 & 256;
                            if (i8 == 0) {
                                i3 |= 100663296;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                if ((i & 100663296) == 0) {
                                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                                }
                            }
                            if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i4 == 0 ? Modifier.INSTANCE : modifier;
                                    if (i5 != 0) {
                                        z4 = true;
                                    }
                                    if (i6 != 0) {
                                        function23 = null;
                                    }
                                    if (i7 != 0) {
                                        z5 = true;
                                    }
                                    if ((i2 & 128) == 0) {
                                        navigationRailItemColors2 = NavigationRailItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        navigationRailItemColors2 = navigationRailItemColors;
                                    }
                                    if (i8 != 0) {
                                        startRestartGroup.startReplaceableGroup(-1687813390);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue3;
                                        startRestartGroup.endReplaceableGroup();
                                        int i10 = i3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1533971045, i10, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:174)");
                                        }
                                        final NavigationRailItemColors navigationRailItemColors4 = navigationRailItemColors2;
                                        final boolean z7 = z5;
                                        final boolean z8 = z4;
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
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

                                            public final void invoke(Composer composer2, int i11) {
                                                ComposerKt.sourceInformation(composer2, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                                                    }
                                                    State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z8, composer2, 0);
                                                    Modifier.Companion clearAndSetSemantics = (function24 == null || !(z7 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            invoke2(semanticsPropertyReceiver);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    Function2<Composer, Integer, Unit> function25 = function2;
                                                    composer2.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                                    composer2.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                                                    if (!(composer2.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer2.startReusableNode();
                                                    if (composer2.getInserting()) {
                                                        composer2.createNode(constructor);
                                                    } else {
                                                        composer2.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                    composer2.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer2, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function25, composer2, ProvidedValue.$stable);
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

                                            private static final long invoke$lambda$0(State<Color> state) {
                                                return state.getValue().m4073unboximpl();
                                            }
                                        });
                                        ComposableLambda composableLambda2 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -105269599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                                            public final void invoke(Composer composer2, int i11) {
                                                ComposerKt.sourceInformation(composer2, "C186@8468L10,187@8561L49,188@8623L152:NavigationRail.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-105269599, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:186)");
                                                    }
                                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(NavigationRailItemColors.this.textColor$material3_release(z, z4, composer2, 0)), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), NavigationRailTokens.INSTANCE.getLabelTextFont()), function23, composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }

                                            private static final long invoke$lambda$0(State<Color> state) {
                                                return state.getValue().m4073unboximpl();
                                            }
                                        }) : null;
                                        Modifier modifier4 = companion;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                        Modifier m935widthInVpY3zN4$default = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4, z, mutableInteractionSource5, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        startRestartGroup.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, true, startRestartGroup, 54);
                                        startRestartGroup.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default);
                                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        startRestartGroup.startReusableNode();
                                        if (startRestartGroup.getInserting()) {
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
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
                                        boolean z9 = z5;
                                        final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Density density = (Density) consume;
                                        long Offset = OffsetKt.Offset((density.mo624roundToPx0680j_4(r1) - density.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                                        Unit unit = Unit.INSTANCE;
                                        startRestartGroup.startReplaceableGroup(1104517079);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                                        changed = startRestartGroup.changed(Offset) | ((234881024 & i10) == 67108864);
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new MappedInteractionSource(mutableInteractionSource5, Offset, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                        if (function23 != null) {
                                            startRestartGroup.startReplaceableGroup(1104517249);
                                            ComposerKt.sourceInformation(startRestartGroup, "230@10292L5");
                                            value = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6);
                                            startRestartGroup.endReplaceableGroup();
                                        } else {
                                            startRestartGroup.startReplaceableGroup(1104517326);
                                            ComposerKt.sourceInformation(startRestartGroup, "232@10376L5");
                                            value = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getNoLabelActiveIndicatorShape(), startRestartGroup, 6);
                                            startRestartGroup.endReplaceableGroup();
                                        }
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i11) {
                                                ComposerKt.sourceInformation(composer2, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                                    }
                                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i11) {
                                                ComposerKt.sourceInformation(composer2, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                                    }
                                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                                    composer2.startReplaceableGroup(540475060);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):NavigationRail.kt#9igjgp");
                                                    boolean changed3 = composer2.changed(animateFloatAsState);
                                                    final State<Float> state = animateFloatAsState;
                                                    Object rememberedValue4 = composer2.rememberedValue();
                                                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                                            }
                                                        };
                                                        composer2.updateRememberedValue(rememberedValue4);
                                                    }
                                                    composer2.endReplaceableGroup();
                                                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors4.getSelectedIndicatorColor(), value), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        startRestartGroup.startReplaceableGroup(1104518640);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                                        changed2 = startRestartGroup.changed(animateFloatAsState);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Float invoke() {
                                                    return animateFloatAsState.getValue();
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        NavigationRailItemLayout(composableLambda3, composableLambda4, composableLambda, composableLambda2, z9, (Function0) rememberedValue2, startRestartGroup, (57344 & (i10 >> 6)) | 438);
                                        startRestartGroup = startRestartGroup;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.endNode();
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        z6 = z9;
                                        navigationRailItemColors3 = navigationRailItemColors4;
                                        modifier3 = modifier4;
                                        mutableInteractionSource4 = mutableInteractionSource5;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    companion = modifier;
                                    navigationRailItemColors2 = navigationRailItemColors;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                int i102 = i3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final NavigationRailItemColors navigationRailItemColors42 = navigationRailItemColors2;
                                final boolean z72 = z5;
                                final boolean z82 = z4;
                                final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
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

                                    public final void invoke(Composer composer2, int i11) {
                                        ComposerKt.sourceInformation(composer2, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                                            }
                                            State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z82, composer2, 0);
                                            Modifier.Companion clearAndSetSemantics = (function242 == null || !(z72 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function25 = function2;
                                            composer2.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                            composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                                            ComposerKt.sourceInformationMarkerStart(composer2, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function25, composer2, ProvidedValue.$stable);
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

                                    private static final long invoke$lambda$0(State<Color> state) {
                                        return state.getValue().m4073unboximpl();
                                    }
                                });
                                if (function23 != null) {
                                }
                                Modifier modifier42 = companion;
                                MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                Modifier m935widthInVpY3zN4$default2 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier42, z, mutableInteractionSource52, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
                                Alignment center2 = Alignment.INSTANCE.getCenter();
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, true, startRestartGroup, 54);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default2);
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
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
                                boolean z92 = z5;
                                final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Density density2 = (Density) consume2;
                                long Offset2 = OffsetKt.Offset((density2.mo624roundToPx0680j_4(r1) - density2.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                                Unit unit2 = Unit.INSTANCE;
                                startRestartGroup.startReplaceableGroup(1104517079);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                                changed = startRestartGroup.changed(Offset2) | ((234881024 & i102) == 67108864);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue = new MappedInteractionSource(mutableInteractionSource52, Offset2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                if (function23 != null) {
                                }
                                ComposableLambda composableLambda32 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i11) {
                                        ComposerKt.sourceInformation(composer2, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                            }
                                            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                ComposableLambda composableLambda42 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i11) {
                                        ComposerKt.sourceInformation(composer2, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                                        if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                            }
                                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                            composer2.startReplaceableGroup(540475060);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):NavigationRail.kt#9igjgp");
                                            boolean changed3 = composer2.changed(animateFloatAsState2);
                                            final State<Float> state = animateFloatAsState2;
                                            Object rememberedValue4 = composer2.rememberedValue();
                                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                                        graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                                    }
                                                };
                                                composer2.updateRememberedValue(rememberedValue4);
                                            }
                                            composer2.endReplaceableGroup();
                                            BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors42.getSelectedIndicatorColor(), value), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(1104518640);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                                changed2 = startRestartGroup.changed(animateFloatAsState2);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed2) {
                                }
                                rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return animateFloatAsState2.getValue();
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                startRestartGroup.endReplaceableGroup();
                                NavigationRailItemLayout(composableLambda32, composableLambda42, composableLambda5, composableLambda2, z92, (Function0) rememberedValue2, startRestartGroup, (57344 & (i102 >> 6)) | 438);
                                startRestartGroup = startRestartGroup;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z6 = z92;
                                navigationRailItemColors3 = navigationRailItemColors42;
                                modifier3 = modifier42;
                                mutableInteractionSource4 = mutableInteractionSource52;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                navigationRailItemColors3 = navigationRailItemColors;
                                modifier3 = modifier2;
                                z6 = z5;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            Composer composer2 = startRestartGroup;
                            final boolean z10 = z4;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$3
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
                                        NavigationRailKt.NavigationRailItem(z, function0, function2, modifier3, z10, function25, z6, navigationRailItemColors3, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function23 = function22;
                        i7 = i2 & 64;
                        if (i7 == 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                        }
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        int i1022 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final NavigationRailItemColors navigationRailItemColors422 = navigationRailItemColors2;
                        final boolean z722 = z5;
                        final boolean z822 = z4;
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = function23;
                        ComposableLambda composableLambda52 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer22, Integer num) {
                                invoke(composer22, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer22, int i11) {
                                ComposerKt.sourceInformation(composer22, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                                    }
                                    State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z822, composer22, 0);
                                    Modifier.Companion clearAndSetSemantics = (function2422 == null || !(z722 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Function2<Composer, Integer, Unit> function252 = function2;
                                    composer22.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer22, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer22, 0);
                                    composer22.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer22, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer22, 0);
                                    CompositionLocalMap currentCompositionLocalMap22 = composer22.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                                    if (!(composer22.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer22.startReusableNode();
                                    if (composer22.getInserting()) {
                                        composer22.createNode(constructor22);
                                    } else {
                                        composer22.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer22);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                                    }
                                    modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer22)), composer22, 0);
                                    composer22.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer22, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer22, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function252, composer22, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer22);
                                    ComposerKt.sourceInformationMarkerEnd(composer22);
                                    composer22.endReplaceableGroup();
                                    composer22.endNode();
                                    composer22.endReplaceableGroup();
                                    composer22.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer22.skipToGroupEnd();
                            }

                            private static final long invoke$lambda$0(State<Color> state) {
                                return state.getValue().m4073unboximpl();
                            }
                        });
                        if (function23 != null) {
                        }
                        Modifier modifier422 = companion;
                        MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                        Modifier m935widthInVpY3zN4$default22 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier422, z, mutableInteractionSource522, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
                        Alignment center22 = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, true, startRestartGroup, 54);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default22);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
                        boolean z922 = z5;
                        final State<Float> animateFloatAsState22 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localDensity22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density22 = (Density) consume22;
                        long Offset22 = OffsetKt.Offset((density22.mo624roundToPx0680j_4(r1) - density22.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                        Unit unit22 = Unit.INSTANCE;
                        startRestartGroup.startReplaceableGroup(1104517079);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                        changed = startRestartGroup.changed(Offset22) | ((234881024 & i1022) == 67108864);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new MappedInteractionSource(mutableInteractionSource522, Offset22, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final MappedInteractionSource mappedInteractionSource22 = (MappedInteractionSource) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        if (function23 != null) {
                        }
                        ComposableLambda composableLambda322 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer22, Integer num) {
                                invoke(composer22, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer22, int i11) {
                                ComposerKt.sourceInformation(composer22, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                    }
                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource22, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer22, 0, 7)), composer22, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer22.skipToGroupEnd();
                            }
                        });
                        ComposableLambda composableLambda422 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer22, Integer num) {
                                invoke(composer22, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer22, int i11) {
                                ComposerKt.sourceInformation(composer22, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                    }
                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                    composer22.startReplaceableGroup(540475060);
                                    ComposerKt.sourceInformation(composer22, "CC(remember):NavigationRail.kt#9igjgp");
                                    boolean changed3 = composer22.changed(animateFloatAsState22);
                                    final State<Float> state = animateFloatAsState22;
                                    Object rememberedValue4 = composer22.rememberedValue();
                                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                            }
                                        };
                                        composer22.updateRememberedValue(rememberedValue4);
                                    }
                                    composer22.endReplaceableGroup();
                                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors422.getSelectedIndicatorColor(), value), composer22, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer22.skipToGroupEnd();
                            }
                        });
                        startRestartGroup.startReplaceableGroup(1104518640);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                        changed2 = startRestartGroup.changed(animateFloatAsState22);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return animateFloatAsState22.getValue();
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        NavigationRailItemLayout(composableLambda322, composableLambda422, composableLambda52, composableLambda2, z922, (Function0) rememberedValue2, startRestartGroup, (57344 & (i1022 >> 6)) | 438);
                        startRestartGroup = startRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z6 = z922;
                        navigationRailItemColors3 = navigationRailItemColors422;
                        modifier3 = modifier422;
                        mutableInteractionSource4 = mutableInteractionSource522;
                        Composer composer22 = startRestartGroup;
                        final boolean z102 = z4;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        endRestartGroup = composer22.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    i6 = i2 & 32;
                    if (i6 != 0) {
                    }
                    function23 = function22;
                    i7 = i2 & 64;
                    if (i7 == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource;
                    int i10222 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final NavigationRailItemColors navigationRailItemColors4222 = navigationRailItemColors2;
                    final boolean z7222 = z5;
                    final boolean z8222 = z4;
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = function23;
                    ComposableLambda composableLambda522 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer222, Integer num) {
                            invoke(composer222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer222, int i11) {
                            ComposerKt.sourceInformation(composer222, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                                }
                                State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z8222, composer222, 0);
                                Modifier.Companion clearAndSetSemantics = (function24222 == null || !(z7222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function2<Composer, Integer, Unit> function2522 = function2;
                                composer222.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer222, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer222, 0);
                                composer222.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer222, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer222, 0);
                                CompositionLocalMap currentCompositionLocalMap222 = composer222.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                                if (!(composer222.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer222.startReusableNode();
                                if (composer222.getInserting()) {
                                    composer222.createNode(constructor222);
                                } else {
                                    composer222.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer222);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                                }
                                modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer222)), composer222, 0);
                                composer222.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer222, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer222, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function2522, composer222, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer222);
                                ComposerKt.sourceInformationMarkerEnd(composer222);
                                composer222.endReplaceableGroup();
                                composer222.endNode();
                                composer222.endReplaceableGroup();
                                composer222.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer222.skipToGroupEnd();
                        }

                        private static final long invoke$lambda$0(State<Color> state) {
                            return state.getValue().m4073unboximpl();
                        }
                    });
                    if (function23 != null) {
                    }
                    Modifier modifier4222 = companion;
                    MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                    Modifier m935widthInVpY3zN4$default222 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4222, z, mutableInteractionSource5222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center222 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, true, startRestartGroup, 54);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default222);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
                    boolean z9222 = z5;
                    final State<Float> animateFloatAsState222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                    ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localDensity222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density222 = (Density) consume222;
                    long Offset222 = OffsetKt.Offset((density222.mo624roundToPx0680j_4(r1) - density222.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                    Unit unit222 = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1104517079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                    changed = startRestartGroup.changed(Offset222) | ((234881024 & i10222) == 67108864);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new MappedInteractionSource(mutableInteractionSource5222, Offset222, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final MappedInteractionSource mappedInteractionSource222 = (MappedInteractionSource) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    if (function23 != null) {
                    }
                    ComposableLambda composableLambda3222 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer222, Integer num) {
                            invoke(composer222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer222, int i11) {
                            ComposerKt.sourceInformation(composer222, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                                }
                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer222, 0, 7)), composer222, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer222.skipToGroupEnd();
                        }
                    });
                    ComposableLambda composableLambda4222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer222, Integer num) {
                            invoke(composer222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer222, int i11) {
                            ComposerKt.sourceInformation(composer222, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                }
                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                composer222.startReplaceableGroup(540475060);
                                ComposerKt.sourceInformation(composer222, "CC(remember):NavigationRail.kt#9igjgp");
                                boolean changed3 = composer222.changed(animateFloatAsState222);
                                final State<Float> state = animateFloatAsState222;
                                Object rememberedValue4 = composer222.rememberedValue();
                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                            graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                        }
                                    };
                                    composer222.updateRememberedValue(rememberedValue4);
                                }
                                composer222.endReplaceableGroup();
                                BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors4222.getSelectedIndicatorColor(), value), composer222, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer222.skipToGroupEnd();
                        }
                    });
                    startRestartGroup.startReplaceableGroup(1104518640);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                    changed2 = startRestartGroup.changed(animateFloatAsState222);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return animateFloatAsState222.getValue();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    NavigationRailItemLayout(composableLambda3222, composableLambda4222, composableLambda522, composableLambda2, z9222, (Function0) rememberedValue2, startRestartGroup, (57344 & (i10222 >> 6)) | 438);
                    startRestartGroup = startRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z6 = z9222;
                    navigationRailItemColors3 = navigationRailItemColors4222;
                    modifier3 = modifier4222;
                    mutableInteractionSource4 = mutableInteractionSource5222;
                    Composer composer222 = startRestartGroup;
                    final boolean z1022 = z4;
                    final Function2<? super Composer, ? super Integer, Unit> function2522 = function23;
                    endRestartGroup = composer222.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 16;
                if (i5 == 0) {
                }
                z4 = z2;
                i6 = i2 & 32;
                if (i6 != 0) {
                }
                function23 = function22;
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (i8 != 0) {
                }
                mutableInteractionSource3 = mutableInteractionSource;
                int i102222 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final NavigationRailItemColors navigationRailItemColors42222 = navigationRailItemColors2;
                final boolean z72222 = z5;
                final boolean z82222 = z4;
                final Function2<? super Composer, ? super Integer, Unit> function242222 = function23;
                ComposableLambda composableLambda5222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2222, Integer num) {
                        invoke(composer2222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2222, int i11) {
                        ComposerKt.sourceInformation(composer2222, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                            }
                            State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z82222, composer2222, 0);
                            Modifier.Companion clearAndSetSemantics = (function242222 == null || !(z72222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }
                            });
                            Function2<Composer, Integer, Unit> function25222 = function2;
                            composer2222.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2222, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2222, 0);
                            composer2222.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2222, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2222, 0);
                            CompositionLocalMap currentCompositionLocalMap2222 = composer2222.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                            if (!(composer2222.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2222.startReusableNode();
                            if (composer2222.getInserting()) {
                                composer2222.createNode(constructor2222);
                            } else {
                                composer2222.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2222);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                            }
                            modifierMaterializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2222)), composer2222, 0);
                            composer2222.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2222, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2222, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function25222, composer2222, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer2222);
                            ComposerKt.sourceInformationMarkerEnd(composer2222);
                            composer2222.endReplaceableGroup();
                            composer2222.endNode();
                            composer2222.endReplaceableGroup();
                            composer2222.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2222.skipToGroupEnd();
                    }

                    private static final long invoke$lambda$0(State<Color> state) {
                        return state.getValue().m4073unboximpl();
                    }
                });
                if (function23 != null) {
                }
                Modifier modifier42222 = companion;
                MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                Modifier m935widthInVpY3zN4$default2222 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier42222, z, mutableInteractionSource52222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
                Alignment center2222 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, true, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default2222);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting()) {
                }
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
                modifierMaterializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
                boolean z92222 = z5;
                final State<Float> animateFloatAsState2222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localDensity2222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2222 = (Density) consume2222;
                long Offset2222 = OffsetKt.Offset((density2222.mo624roundToPx0680j_4(r1) - density2222.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
                Unit unit2222 = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1104517079);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                changed = startRestartGroup.changed(Offset2222) | ((234881024 & i102222) == 67108864);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new MappedInteractionSource(mutableInteractionSource52222, Offset2222, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final MappedInteractionSource mappedInteractionSource2222 = (MappedInteractionSource) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                if (function23 != null) {
                }
                ComposableLambda composableLambda32222 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2222, Integer num) {
                        invoke(composer2222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2222, int i11) {
                        ComposerKt.sourceInformation(composer2222, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                            }
                            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource2222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2222, 0, 7)), composer2222, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2222.skipToGroupEnd();
                    }
                });
                ComposableLambda composableLambda42222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2222, Integer num) {
                        invoke(composer2222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2222, int i11) {
                        ComposerKt.sourceInformation(composer2222, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                        if ((i11 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                            }
                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                            composer2222.startReplaceableGroup(540475060);
                            ComposerKt.sourceInformation(composer2222, "CC(remember):NavigationRail.kt#9igjgp");
                            boolean changed3 = composer2222.changed(animateFloatAsState2222);
                            final State<Float> state = animateFloatAsState2222;
                            Object rememberedValue4 = composer2222.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                        graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                    }
                                };
                                composer2222.updateRememberedValue(rememberedValue4);
                            }
                            composer2222.endReplaceableGroup();
                            BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors42222.getSelectedIndicatorColor(), value), composer2222, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2222.skipToGroupEnd();
                    }
                });
                startRestartGroup.startReplaceableGroup(1104518640);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                changed2 = startRestartGroup.changed(animateFloatAsState2222);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return animateFloatAsState2222.getValue();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                NavigationRailItemLayout(composableLambda32222, composableLambda42222, composableLambda5222, composableLambda2, z92222, (Function0) rememberedValue2, startRestartGroup, (57344 & (i102222 >> 6)) | 438);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                z6 = z92222;
                navigationRailItemColors3 = navigationRailItemColors42222;
                modifier3 = modifier42222;
                mutableInteractionSource4 = mutableInteractionSource52222;
                Composer composer2222 = startRestartGroup;
                final boolean z10222 = z4;
                final Function2<? super Composer, ? super Integer, Unit> function25222 = function23;
                endRestartGroup = composer2222.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i4 = i2 & 8;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            function23 = function22;
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (i8 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource;
            int i1022222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final NavigationRailItemColors navigationRailItemColors422222 = navigationRailItemColors2;
            final boolean z722222 = z5;
            final boolean z822222 = z4;
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = function23;
            ComposableLambda composableLambda52222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer22222, Integer num) {
                    invoke(composer22222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer22222, int i11) {
                    ComposerKt.sourceInformation(composer22222, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                        }
                        State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z822222, composer22222, 0);
                        Modifier.Companion clearAndSetSemantics = (function2422222 == null || !(z722222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        Function2<Composer, Integer, Unit> function252222 = function2;
                        composer22222.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer22222, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer22222, 0);
                        composer22222.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer22222, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer22222, 0);
                        CompositionLocalMap currentCompositionLocalMap22222 = composer22222.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                        if (!(composer22222.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer22222.startReusableNode();
                        if (composer22222.getInserting()) {
                            composer22222.createNode(constructor22222);
                        } else {
                            composer22222.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer22222);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy22222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
                        }
                        modifierMaterializerOf22222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer22222)), composer22222, 0);
                        composer22222.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer22222, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer22222, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function252222, composer22222, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer22222);
                        ComposerKt.sourceInformationMarkerEnd(composer22222);
                        composer22222.endReplaceableGroup();
                        composer22222.endNode();
                        composer22222.endReplaceableGroup();
                        composer22222.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer22222.skipToGroupEnd();
                }

                private static final long invoke$lambda$0(State<Color> state) {
                    return state.getValue().m4073unboximpl();
                }
            });
            if (function23 != null) {
            }
            Modifier modifier422222 = companion;
            MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
            Modifier m935widthInVpY3zN4$default22222 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier422222, z, mutableInteractionSource522222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
            Alignment center22222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(center22222, true, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default22222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy22222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22222);
            modifierMaterializerOf22222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
            boolean z922222 = z5;
            final State<Float> animateFloatAsState22222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
            ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localDensity22222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density22222 = (Density) consume22222;
            long Offset22222 = OffsetKt.Offset((density22222.mo624roundToPx0680j_4(r1) - density22222.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
            Unit unit22222 = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1104517079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
            changed = startRestartGroup.changed(Offset22222) | ((234881024 & i1022222) == 67108864);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new MappedInteractionSource(mutableInteractionSource522222, Offset22222, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final MappedInteractionSource mappedInteractionSource22222 = (MappedInteractionSource) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            if (function23 != null) {
            }
            ComposableLambda composableLambda322222 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer22222, Integer num) {
                    invoke(composer22222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer22222, int i11) {
                    ComposerKt.sourceInformation(composer22222, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                        }
                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource22222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer22222, 0, 7)), composer22222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer22222.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda422222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer22222, Integer num) {
                    invoke(composer22222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer22222, int i11) {
                    ComposerKt.sourceInformation(composer22222, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                        }
                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                        composer22222.startReplaceableGroup(540475060);
                        ComposerKt.sourceInformation(composer22222, "CC(remember):NavigationRail.kt#9igjgp");
                        boolean changed3 = composer22222.changed(animateFloatAsState22222);
                        final State<Float> state = animateFloatAsState22222;
                        Object rememberedValue4 = composer22222.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                    graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                }
                            };
                            composer22222.updateRememberedValue(rememberedValue4);
                        }
                        composer22222.endReplaceableGroup();
                        BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors422222.getSelectedIndicatorColor(), value), composer22222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer22222.skipToGroupEnd();
                }
            });
            startRestartGroup.startReplaceableGroup(1104518640);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
            changed2 = startRestartGroup.changed(animateFloatAsState22222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return animateFloatAsState22222.getValue();
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            NavigationRailItemLayout(composableLambda322222, composableLambda422222, composableLambda52222, composableLambda2, z922222, (Function0) rememberedValue2, startRestartGroup, (57344 & (i1022222 >> 6)) | 438);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            z6 = z922222;
            navigationRailItemColors3 = navigationRailItemColors422222;
            modifier3 = modifier422222;
            mutableInteractionSource4 = mutableInteractionSource522222;
            Composer composer22222 = startRestartGroup;
            final boolean z102222 = z4;
            final Function2<? super Composer, ? super Integer, Unit> function252222 = function23;
            endRestartGroup = composer22222.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        function23 = function22;
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (i8 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource;
        int i10222222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final NavigationRailItemColors navigationRailItemColors4222222 = navigationRailItemColors2;
        final boolean z7222222 = z5;
        final boolean z8222222 = z4;
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = function23;
        ComposableLambda composableLambda522222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1023357515, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer222222, Integer num) {
                invoke(composer222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer222222, int i11) {
                ComposerKt.sourceInformation(composer222222, "C176@7934L49,179@8153L185:NavigationRail.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1023357515, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:176)");
                    }
                    State<Color> iconColor$material3_release = NavigationRailItemColors.this.iconColor$material3_release(z, z8222222, composer222222, 0);
                    Modifier.Companion clearAndSetSemantics = (function24222222 == null || !(z7222222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$styledIcon$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }
                    });
                    Function2<Composer, Integer, Unit> function2522222 = function2;
                    composer222222.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer222222, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer222222, 0);
                    composer222222.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer222222, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer222222, 0);
                    CompositionLocalMap currentCompositionLocalMap222222 = composer222222.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor222222 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222222 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                    if (!(composer222222.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer222222.startReusableNode();
                    if (composer222222.getInserting()) {
                        composer222222.createNode(constructor222222);
                    } else {
                        composer222222.useNode();
                    }
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer222222);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy222222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap222222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222222);
                    }
                    modifierMaterializerOf222222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer222222)), composer222222, 0);
                    composer222222.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer222222, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance222222 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer222222, 540472160, "C180@8250L78:NavigationRail.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$0(iconColor$material3_release))), function2522222, composer222222, ProvidedValue.$stable);
                    ComposerKt.sourceInformationMarkerEnd(composer222222);
                    ComposerKt.sourceInformationMarkerEnd(composer222222);
                    composer222222.endReplaceableGroup();
                    composer222222.endNode();
                    composer222222.endReplaceableGroup();
                    composer222222.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer222222.skipToGroupEnd();
            }

            private static final long invoke$lambda$0(State<Color> state) {
                return state.getValue().m4073unboximpl();
            }
        });
        if (function23 != null) {
        }
        Modifier modifier4222222 = companion;
        MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
        Modifier m935widthInVpY3zN4$default222222 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4222222, z, mutableInteractionSource5222222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, 1, null), NavigationRailItemWidth, 0.0f, 2, null);
        Alignment center222222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222222 = BoxKt.rememberBoxMeasurePolicy(center222222, true, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222222 = LayoutKt.modifierMaterializerOf(m935widthInVpY3zN4$default222222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy222222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap222222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222222);
        modifierMaterializerOf222222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance222222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1104516321, "C211@9346L145,*220@9775L7,225@10066L120,267@11627L27,261@11376L289:NavigationRail.kt#uh7d8r");
        boolean z9222222 = z5;
        final State<Float> animateFloatAsState222222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(150, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
        ProvidableCompositionLocal<Density> localDensity222222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localDensity222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density222222 = (Density) consume222222;
        long Offset222222 = OffsetKt.Offset((density222222.mo624roundToPx0680j_4(r1) - density222222.mo624roundToPx0680j_4(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM())) / 2, 0.0f);
        Unit unit222222 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1104517079);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
        changed = startRestartGroup.changed(Offset222222) | ((234881024 & i10222222) == 67108864);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new MappedInteractionSource(mutableInteractionSource5222222, Offset222222, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final MappedInteractionSource mappedInteractionSource222222 = (MappedInteractionSource) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        if (function23 != null) {
        }
        ComposableLambda composableLambda3222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 211026382, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicatorRipple$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer222222, Integer num) {
                invoke(composer222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer222222, int i11) {
                ComposerKt.sourceInformation(composer222222, "C245@10920L16,239@10651L321:NavigationRail.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(211026382, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:238)");
                    }
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), Shape.this), mappedInteractionSource222222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer222222, 0, 7)), composer222222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer222222.skipToGroupEnd();
            }
        });
        ComposableLambda composableLambda4222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1862011490, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer222222, Integer num) {
                invoke(composer222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer222222, int i11) {
                ComposerKt.sourceInformation(composer222222, "C253@11150L35,250@11033L323:NavigationRail.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1862011490, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                    }
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                    composer222222.startReplaceableGroup(540475060);
                    ComposerKt.sourceInformation(composer222222, "CC(remember):NavigationRail.kt#9igjgp");
                    boolean changed3 = composer222222.changed(animateFloatAsState222222);
                    final State<Float> state = animateFloatAsState222222;
                    Object rememberedValue4 = composer222222.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$indicator$1$1$1
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
                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                            }
                        };
                        composer222222.updateRememberedValue(rememberedValue4);
                    }
                    composer222222.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue4), navigationRailItemColors4222222.getSelectedIndicatorColor(), value), composer222222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer222222.skipToGroupEnd();
            }
        });
        startRestartGroup.startReplaceableGroup(1104518640);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
        changed2 = startRestartGroup.changed(animateFloatAsState222222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItem$2$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return animateFloatAsState222222.getValue();
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        NavigationRailItemLayout(composableLambda3222222, composableLambda4222222, composableLambda522222, composableLambda2, z9222222, (Function0) rememberedValue2, startRestartGroup, (57344 & (i10222222 >> 6)) | 438);
        startRestartGroup = startRestartGroup;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z9222222;
        navigationRailItemColors3 = navigationRailItemColors4222222;
        modifier3 = modifier4222222;
        mutableInteractionSource4 = mutableInteractionSource5222222;
        Composer composer222222 = startRestartGroup;
        final boolean z1022222 = z4;
        final Function2<? super Composer, ? super Integer, Unit> function2522222 = function23;
        endRestartGroup = composer222222.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)516@22576L2124,503@22202L2498:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498399348, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:502)");
            }
            startRestartGroup.startReplaceableGroup(-753441910);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
            int i3 = 458752 & i2;
            int i4 = 57344 & i2;
            boolean z2 = (i3 == 131072) | ((i2 & 7168) == 2048) | (i4 == 16384);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        float f;
                        Measurable measurable;
                        Placeable placeable;
                        MeasureResult m2380placeLabelAndIconzUg2_y0;
                        MeasureResult m2379placeIconX9ElhV4;
                        MeasureScope measureScope2 = measureScope;
                        float floatValue = function0.invoke().floatValue();
                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        int size = list.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Measurable measurable2 = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable mo5333measureBRTryo0 = measurable2.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                int width = mo5333measureBRTryo0.getWidth();
                                f = NavigationRailKt.IndicatorHorizontalPadding;
                                float f2 = 2;
                                int i6 = width + measureScope2.mo624roundToPx0680j_4(Dp.m6389constructorimpl(f * f2));
                                int roundToInt = MathKt.roundToInt(i6 * floatValue);
                                int height = mo5333measureBRTryo0.getHeight() + measureScope2.mo624roundToPx0680j_4(Dp.m6389constructorimpl((function24 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f2));
                                int size2 = list.size();
                                int i7 = 0;
                                while (i7 < size2) {
                                    Measurable measurable3 = list.get(i7);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable mo5333measureBRTryo02 = measurable3.mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i6, height));
                                        int size3 = list.size();
                                        int i8 = 0;
                                        while (true) {
                                            if (i8 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i8);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i8++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable mo5333measureBRTryo03 = measurable4 != null ? measurable4.mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(roundToInt, height)) : null;
                                        if (function24 != null) {
                                            int size4 = list.size();
                                            for (int i9 = 0; i9 < size4; i9++) {
                                                Measurable measurable5 = list.get(i9);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeable = measurable5.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeable = null;
                                        if (function24 == null) {
                                            m2379placeIconX9ElhV4 = NavigationRailKt.m2379placeIconX9ElhV4(measureScope2, mo5333measureBRTryo0, mo5333measureBRTryo02, mo5333measureBRTryo03, j);
                                            return m2379placeIconX9ElhV4;
                                        }
                                        Intrinsics.checkNotNull(placeable);
                                        m2380placeLabelAndIconzUg2_y0 = NavigationRailKt.m2380placeLabelAndIconzUg2_y0(measureScope, placeable, mo5333measureBRTryo0, mo5333measureBRTryo02, mo5333measureBRTryo03, j, z, floatValue);
                                        return m2380placeLabelAndIconzUg2_y0;
                                    }
                                    i7++;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i5++;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            int i5 = i2;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 484846918, "C504@22219L17,505@22245L11,507@22266L50:NavigationRail.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
            function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960475328, "C507@22308L6:NavigationRail.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-753442160);
            ComposerKt.sourceInformation(startRestartGroup, "513@22472L60,510@22359L199");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                startRestartGroup.startReplaceableGroup(484847171);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z3 = (i4 == 16384) | (i3 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$2$1
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
                            graphicsLayerScope.setAlpha(z ? 1.0f : function0.invoke().floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(graphicsLayer);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -960475087, "C514@22549L7:NavigationRail.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$3
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

                public final void invoke(Composer composer2, int i6) {
                    NavigationRailKt.NavigationRailItemLayout(function2, function22, function23, function24, z, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2379placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, measureScope.mo624roundToPx0680j_4(NavigationRailItemHeight));
        final int width = (m6359constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = (m6358constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (m6359constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height2 = (m6358constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, m6359constrainWidthK40F9xA, m6358constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
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
                Placeable.PlacementScope placementScope2;
                Placeable placeable4 = Placeable.this;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (m6359constrainWidthK40F9xA - placeable4.getWidth()) / 2, (m6358constrainHeightK40F9xA - placeable4.getHeight()) / 2, 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, height, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2380placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPaddingWithLabel;
        float f3 = height + measureScope.mo630toPx0680j_4(f2);
        float f4 = NavigationRailItemVerticalPadding;
        float f5 = f3 + measureScope.mo630toPx0680j_4(f4) + placeable.getHeight();
        float f6 = 2;
        final float coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m6346getMinHeightimpl(j) - f5) / f6, measureScope.mo630toPx0680j_4(f2));
        float f7 = f5 + (coerceAtLeast * f6);
        final float height2 = ((z ? coerceAtLeast : (f7 - placeable2.getHeight()) / f6) - coerceAtLeast) * (1 - f);
        final float height3 = placeable2.getHeight() + coerceAtLeast + measureScope.mo630toPx0680j_4(f2) + measureScope.mo630toPx0680j_4(f4);
        final int m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int width = (m6359constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int width2 = (m6359constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width3 = (m6359constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final float f8 = coerceAtLeast - measureScope.mo630toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, m6359constrainWidthK40F9xA, MathKt.roundToInt(f7), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
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
                Placeable.PlacementScope placementScope2;
                float f9;
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    int i = m6359constrainWidthK40F9xA;
                    float f10 = coerceAtLeast;
                    MeasureScope measureScope2 = measureScope;
                    float f11 = height2;
                    int width4 = (i - placeable5.getWidth()) / 2;
                    f9 = NavigationRailKt.IndicatorVerticalPaddingWithLabel;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, width4, MathKt.roundToInt((f10 - measureScope2.mo630toPx0680j_4(f9)) + f11), 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                if (z || f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, MathKt.roundToInt(height3 + height2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, width2, MathKt.roundToInt(coerceAtLeast + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, width3, MathKt.roundToInt(f8 + height2), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    static {
        float f = 4;
        NavigationRailVerticalPadding = Dp.m6389constructorimpl(f);
        NavigationRailItemVerticalPadding = Dp.m6389constructorimpl(f);
        float f2 = 2;
        IndicatorHorizontalPadding = Dp.m6389constructorimpl(Dp.m6389constructorimpl(NavigationRailTokens.INSTANCE.m3288getActiveIndicatorWidthD9Ej5fM() - NavigationRailTokens.INSTANCE.m3291getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingWithLabel = Dp.m6389constructorimpl(Dp.m6389constructorimpl(NavigationRailTokens.INSTANCE.m3287getActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3291getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingNoLabel = Dp.m6389constructorimpl(Dp.m6389constructorimpl(NavigationRailTokens.INSTANCE.m3293getNoLabelActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3291getIconSizeD9Ej5fM()) / f2);
    }
}
