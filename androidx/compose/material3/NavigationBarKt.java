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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
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
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
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

/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001ab\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aq\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&H\u0003¢\u0006\u0002\u0010.\u001a\u0083\u0001\u0010/\u001a\u00020\u0014*\u00020\u001f2\u0006\u00100\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020+2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001a8\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aP\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\n\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "()F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, "Lkotlin/Function0;", NavigationBarKt.IndicatorLayoutIdTag, "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m3279getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m6389constructorimpl(8);
    private static final float NavigationBarIndicatorToLabelPadding = Dp.m6389constructorimpl(4);
    private static final float IndicatorVerticalOffset = Dp.m6389constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0099  */
    /* renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2347NavigationBarHsRjFd4(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        WindowInsets windowInsets2;
        long j5;
        float f3;
        final WindowInsets windowInsets3;
        Modifier modifier3;
        Composer composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final long j6;
        final long j7;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1596802123);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)103@4868L14,104@4924L11,106@5082L12,109@5149L583:NavigationBar.kt#uh7d8r");
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
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
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
                i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j3 = NavigationBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ColorSchemeKt.m2048contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), j3);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        f2 = NavigationBarDefaults.INSTANCE.m2334getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) == 0) {
                        windowInsets3 = NavigationBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                        i3 &= -57345;
                        j5 = j4;
                        f3 = f2;
                    } else {
                        j5 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                    }
                    modifier3 = companion;
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
                    f3 = f2;
                    modifier3 = modifier2;
                    windowInsets3 = windowInsets2;
                }
                long j8 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1596802123, i3, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:108)");
                }
                int i8 = i3 << 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier3, null, j8, j5, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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

                    public final void invoke(Composer composer3, int i9) {
                        float f5;
                        ComposerKt.sourceInformation(composer3, "C115@5312L414:NavigationBar.kt#uh7d8r");
                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(105663120, i9, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:115)");
                            }
                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                            f5 = NavigationBarKt.NavigationBarHeight;
                            Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                            Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m788spacedBy0680j_4, centerVertically, composer3, 54);
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
                }), composer2, (i3 & 14) | 12582912 | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 98);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets4 = windowInsets3;
                modifier4 = modifier3;
                j6 = j8;
                j7 = j5;
                f4 = f3;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
                modifier4 = modifier2;
                j6 = j3;
                j7 = j4;
                f4 = f2;
                windowInsets4 = windowInsets2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$2
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

                    public final void invoke(Composer composer3, int i9) {
                        NavigationBarKt.m2347NavigationBarHsRjFd4(Modifier.this, j6, j7, f4, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
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
        long j82 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i82 = i3 << 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier3, null, j82, j5, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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

            public final void invoke(Composer composer3, int i9) {
                float f5;
                ComposerKt.sourceInformation(composer3, "C115@5312L414:NavigationBar.kt#uh7d8r");
                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(105663120, i9, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:115)");
                    }
                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                    f5 = NavigationBarKt.NavigationBarHeight;
                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                    Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = Arrangement.INSTANCE.m788spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m788spacedBy0680j_4, centerVertically, composer3, 54);
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
        }), composer2, (i3 & 14) | 12582912 | (i82 & 896) | (i82 & 7168) | (i82 & 57344), 98);
        if (ComposerKt.isTraceInProgress()) {
        }
        windowInsets4 = windowInsets3;
        modifier4 = modifier3;
        j6 = j82;
        j7 = j5;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0417  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBarItem(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
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
        int i9;
        NavigationBarItemColors navigationBarItemColors2;
        MutableInteractionSource mutableInteractionSource3;
        Object rememberedValue;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean changed;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        final boolean z6;
        final NavigationBarItemColors navigationBarItemColors3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-663510974);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItem)P(8,7,3,6,2,5)171@7961L8,172@8021L39,195@9011L33,209@9453L52,197@9050L2789:NavigationBar.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            if ((i2 & 4) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                i4 = i2 & 8;
                if (i4 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i5 = i2 & 16;
                    if (i5 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z4 = z2;
                        i3 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                        i6 = i2 & 32;
                        if (i6 != 0) {
                            i3 |= 1572864;
                        } else if ((1572864 & i) == 0) {
                            function23 = function22;
                            i3 |= startRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                            i7 = i2 & 64;
                            if (i7 == 0) {
                                i3 |= 12582912;
                                z5 = z3;
                            } else {
                                z5 = z3;
                                if ((i & 12582912) == 0) {
                                    i3 |= startRestartGroup.changed(z5) ? 8388608 : 4194304;
                                }
                            }
                            if ((i & 100663296) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changed(navigationBarItemColors)) {
                                    i10 = 67108864;
                                    i3 |= i10;
                                }
                                i10 = 33554432;
                                i3 |= i10;
                            }
                            i8 = i2 & 256;
                            int i11 = i3;
                            if (i8 == 0) {
                                mutableInteractionSource2 = mutableInteractionSource;
                                i9 = i11 | C.ENCODING_PCM_32BIT;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                if ((i & C.ENCODING_PCM_32BIT) == 0) {
                                    i9 = i11 | (startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456);
                                } else {
                                    i9 = i11;
                                }
                            }
                            if ((i9 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i4 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
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
                                        navigationBarItemColors2 = NavigationBarItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i9 &= -234881025;
                                    } else {
                                        navigationBarItemColors2 = navigationBarItemColors;
                                    }
                                    if (i8 != 0) {
                                        startRestartGroup.startReplaceableGroup(-280425562);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue5;
                                        startRestartGroup.endReplaceableGroup();
                                        int i12 = i9;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-663510974, i12, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:173)");
                                        }
                                        final NavigationBarItemColors navigationBarItemColors4 = navigationBarItemColors2;
                                        final boolean z7 = z5;
                                        final boolean z8 = z4;
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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
                                                ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                                                    }
                                                    State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z8, composer2, 0);
                                                    Modifier.Companion clearAndSetSemantics = (function24 == null || !(z7 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                                    ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
                                        ComposableLambda composableLambda2 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1644987592, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
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
                                                ComposerKt.sourceInformation(composer2, "C185@8666L10,186@8758L49,187@8820L152:NavigationBar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1644987592, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:185)");
                                                    }
                                                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(NavigationBarItemColors.this.textColor$material3_release(z, z4, composer2, 0)), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), NavigationBarTokens.INSTANCE.getLabelTextFont()), function23, composer2, 0);
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
                                        startRestartGroup.startReplaceableGroup(-280424572);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                        Modifier modifier4 = modifier2;
                                        Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4, z, mutableInteractionSource5, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                                        startRestartGroup.startReplaceableGroup(-280424130);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                    m2352invokeozmzZPI(intSize.getPackedValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                public final void m2352invokeozmzZPI(long j) {
                                                    MutableIntState.this.setIntValue(IntSize.m6559getWidthimpl(j));
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(weight$default, (Function1) rememberedValue2);
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        startRestartGroup.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, true, startRestartGroup, 54);
                                        startRestartGroup.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onSizeChanged);
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
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                                        boolean z9 = z5;
                                        final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        long Offset = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume).mo630toPx0680j_4(IndicatorVerticalOffset));
                                        Unit unit = Unit.INSTANCE;
                                        startRestartGroup.startReplaceableGroup(1035150713);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                        changed = startRestartGroup.changed(Offset) | ((1879048192 & i12) == 536870912);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new MappedInteractionSource(mutableInteractionSource5, Offset, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) rememberedValue3;
                                        startRestartGroup.endReplaceableGroup();
                                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i13) {
                                                ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                                                    }
                                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i13) {
                                                ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                                                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                                                    }
                                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                                    composer2.startReplaceableGroup(1844203561);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                                                    boolean changed3 = composer2.changed(animateFloatAsState);
                                                    final State<Float> state = animateFloatAsState;
                                                    Object rememberedValue6 = composer2.rememberedValue();
                                                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                                                        composer2.updateRememberedValue(rememberedValue6);
                                                    }
                                                    composer2.endReplaceableGroup();
                                                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors4.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        startRestartGroup.startReplaceableGroup(1035152133);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                        changed2 = startRestartGroup.changed(animateFloatAsState);
                                        rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        NavigationBarItemLayout(composableLambda3, composableLambda4, composableLambda, composableLambda2, z9, (Function0) rememberedValue4, startRestartGroup, ((i12 >> 9) & 57344) | 438);
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
                                        navigationBarItemColors3 = navigationBarItemColors4;
                                        modifier3 = modifier4;
                                        mutableInteractionSource4 = mutableInteractionSource5;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i9 &= -234881025;
                                    }
                                    navigationBarItemColors2 = navigationBarItemColors;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                int i122 = i9;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final NavigationBarItemColors navigationBarItemColors42 = navigationBarItemColors2;
                                final boolean z72 = z5;
                                final boolean z82 = z4;
                                final Function2<? super Composer, ? super Integer, Unit> function242 = function23;
                                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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
                                        ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                                            }
                                            State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z82, composer2, 0);
                                            Modifier.Companion clearAndSetSemantics = (function242 == null || !(z72 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                            ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
                                startRestartGroup.startReplaceableGroup(-280424572);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                Modifier modifier42 = modifier2;
                                Modifier weight$default2 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier42, z, mutableInteractionSource52, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                                startRestartGroup.startReplaceableGroup(-280424130);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(weight$default2, (Function1) rememberedValue2);
                                Alignment center2 = Alignment.INSTANCE.getCenter();
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, true, startRestartGroup, 54);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(onSizeChanged2);
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
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                                boolean z92 = z5;
                                final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                long Offset2 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState2) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume2).mo630toPx0680j_4(IndicatorVerticalOffset));
                                Unit unit2 = Unit.INSTANCE;
                                startRestartGroup.startReplaceableGroup(1035150713);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                changed = startRestartGroup.changed(Offset2) | ((1879048192 & i122) == 536870912);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue3 = new MappedInteractionSource(mutableInteractionSource52, Offset2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) rememberedValue3;
                                startRestartGroup.endReplaceableGroup();
                                ComposableLambda composableLambda32 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                                            }
                                            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                ComposableLambda composableLambda42 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                                            }
                                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                            composer2.startReplaceableGroup(1844203561);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                                            boolean changed3 = composer2.changed(animateFloatAsState2);
                                            final State<Float> state = animateFloatAsState2;
                                            Object rememberedValue6 = composer2.rememberedValue();
                                            if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                                                composer2.updateRememberedValue(rememberedValue6);
                                            }
                                            composer2.endReplaceableGroup();
                                            BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors42.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(1035152133);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                changed2 = startRestartGroup.changed(animateFloatAsState2);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed2) {
                                }
                                rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                startRestartGroup.endReplaceableGroup();
                                NavigationBarItemLayout(composableLambda32, composableLambda42, composableLambda5, composableLambda2, z92, (Function0) rememberedValue4, startRestartGroup, ((i122 >> 9) & 57344) | 438);
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
                                navigationBarItemColors3 = navigationBarItemColors42;
                                modifier3 = modifier42;
                                mutableInteractionSource4 = mutableInteractionSource52;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource4 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                z6 = z5;
                                navigationBarItemColors3 = navigationBarItemColors;
                            }
                            Composer composer2 = startRestartGroup;
                            final boolean z10 = z4;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$4
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

                                    public final void invoke(Composer composer3, int i13) {
                                        NavigationBarKt.NavigationBarItem(RowScope.this, z, function0, function2, modifier3, z10, function25, z6, navigationBarItemColors3, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                        if ((i & 100663296) == 0) {
                        }
                        i8 = i2 & 256;
                        int i112 = i3;
                        if (i8 == 0) {
                        }
                        if ((i9 & 306783379) == 306783378) {
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
                        if (i7 != 0) {
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        int i1222 = i9;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final NavigationBarItemColors navigationBarItemColors422 = navigationBarItemColors2;
                        final boolean z722 = z5;
                        final boolean z822 = z4;
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = function23;
                        ComposableLambda composableLambda52 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                            public final void invoke(Composer composer22, int i13) {
                                ComposerKt.sourceInformation(composer22, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                                    }
                                    State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z822, composer22, 0);
                                    Modifier.Companion clearAndSetSemantics = (function2422 == null || !(z722 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                    ComposerKt.sourceInformationMarkerStart(composer22, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
                        startRestartGroup.startReplaceableGroup(-280424572);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        final MutableIntState mutableIntState22 = (MutableIntState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        Modifier modifier422 = modifier2;
                        Modifier weight$default22 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier422, z, mutableInteractionSource522, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        startRestartGroup.startReplaceableGroup(-280424130);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(weight$default22, (Function1) rememberedValue2);
                        Alignment center22 = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, true, startRestartGroup, 54);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(onSizeChanged22);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                        boolean z922 = z5;
                        final State<Float> animateFloatAsState22 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localDensity22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long Offset22 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState22) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume22).mo630toPx0680j_4(IndicatorVerticalOffset));
                        Unit unit22 = Unit.INSTANCE;
                        startRestartGroup.startReplaceableGroup(1035150713);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        changed = startRestartGroup.changed(Offset22) | ((1879048192 & i1222) == 536870912);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue3 = new MappedInteractionSource(mutableInteractionSource522, Offset22, null);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        final MappedInteractionSource mappedInteractionSource22 = (MappedInteractionSource) rememberedValue3;
                        startRestartGroup.endReplaceableGroup();
                        ComposableLambda composableLambda322 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer22, Integer num) {
                                invoke(composer22, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer22, int i13) {
                                ComposerKt.sourceInformation(composer22, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                                    }
                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer22, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer22, 0, 7)), composer22, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer22.skipToGroupEnd();
                            }
                        });
                        ComposableLambda composableLambda422 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer22, Integer num) {
                                invoke(composer22, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer22, int i13) {
                                ComposerKt.sourceInformation(composer22, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                                if ((i13 & 3) != 2 || !composer22.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                                    }
                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                    composer22.startReplaceableGroup(1844203561);
                                    ComposerKt.sourceInformation(composer22, "CC(remember):NavigationBar.kt#9igjgp");
                                    boolean changed3 = composer22.changed(animateFloatAsState22);
                                    final State<Float> state = animateFloatAsState22;
                                    Object rememberedValue6 = composer22.rememberedValue();
                                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                                        composer22.updateRememberedValue(rememberedValue6);
                                    }
                                    composer22.endReplaceableGroup();
                                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors422.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer22, 6)), composer22, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer22.skipToGroupEnd();
                            }
                        });
                        startRestartGroup.startReplaceableGroup(1035152133);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        changed2 = startRestartGroup.changed(animateFloatAsState22);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        NavigationBarItemLayout(composableLambda322, composableLambda422, composableLambda52, composableLambda2, z922, (Function0) rememberedValue4, startRestartGroup, ((i1222 >> 9) & 57344) | 438);
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
                        navigationBarItemColors3 = navigationBarItemColors422;
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
                    if ((i & 100663296) == 0) {
                    }
                    i8 = i2 & 256;
                    int i1122 = i3;
                    if (i8 == 0) {
                    }
                    if ((i9 & 306783379) == 306783378) {
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
                    if (i7 != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource;
                    int i12222 = i9;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final NavigationBarItemColors navigationBarItemColors4222 = navigationBarItemColors2;
                    final boolean z7222 = z5;
                    final boolean z8222 = z4;
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = function23;
                    ComposableLambda composableLambda522 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                        public final void invoke(Composer composer222, int i13) {
                            ComposerKt.sourceInformation(composer222, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                                }
                                State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z8222, composer222, 0);
                                Modifier.Companion clearAndSetSemantics = (function24222 == null || !(z7222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                                ComposerKt.sourceInformationMarkerStart(composer222, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
                    startRestartGroup.startReplaceableGroup(-280424572);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableIntState mutableIntState222 = (MutableIntState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    Modifier modifier4222 = modifier2;
                    Modifier weight$default222 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4222, z, mutableInteractionSource5222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    startRestartGroup.startReplaceableGroup(-280424130);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(weight$default222, (Function1) rememberedValue2);
                    Alignment center222 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, true, startRestartGroup, 54);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(onSizeChanged222);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                    boolean z9222 = z5;
                    final State<Float> animateFloatAsState222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                    ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localDensity222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long Offset222 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState222) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume222).mo630toPx0680j_4(IndicatorVerticalOffset));
                    Unit unit222 = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1035150713);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                    changed = startRestartGroup.changed(Offset222) | ((1879048192 & i12222) == 536870912);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = new MappedInteractionSource(mutableInteractionSource5222, Offset222, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    final MappedInteractionSource mappedInteractionSource222 = (MappedInteractionSource) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    ComposableLambda composableLambda3222 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer222, Integer num) {
                            invoke(composer222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer222, int i13) {
                            ComposerKt.sourceInformation(composer222, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                                }
                                BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer222, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer222, 0, 7)), composer222, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer222.skipToGroupEnd();
                        }
                    });
                    ComposableLambda composableLambda4222 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer222, Integer num) {
                            invoke(composer222, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer222, int i13) {
                            ComposerKt.sourceInformation(composer222, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer222.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                                }
                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                composer222.startReplaceableGroup(1844203561);
                                ComposerKt.sourceInformation(composer222, "CC(remember):NavigationBar.kt#9igjgp");
                                boolean changed3 = composer222.changed(animateFloatAsState222);
                                final State<Float> state = animateFloatAsState222;
                                Object rememberedValue6 = composer222.rememberedValue();
                                if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                                    composer222.updateRememberedValue(rememberedValue6);
                                }
                                composer222.endReplaceableGroup();
                                BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors4222.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer222, 6)), composer222, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer222.skipToGroupEnd();
                        }
                    });
                    startRestartGroup.startReplaceableGroup(1035152133);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                    changed2 = startRestartGroup.changed(animateFloatAsState222);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    NavigationBarItemLayout(composableLambda3222, composableLambda4222, composableLambda522, composableLambda2, z9222, (Function0) rememberedValue4, startRestartGroup, ((i12222 >> 9) & 57344) | 438);
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
                    navigationBarItemColors3 = navigationBarItemColors4222;
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
                if ((i & 100663296) == 0) {
                }
                i8 = i2 & 256;
                int i11222 = i3;
                if (i8 == 0) {
                }
                if ((i9 & 306783379) == 306783378) {
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
                if (i7 != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (i8 != 0) {
                }
                mutableInteractionSource3 = mutableInteractionSource;
                int i122222 = i9;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final NavigationBarItemColors navigationBarItemColors42222 = navigationBarItemColors2;
                final boolean z72222 = z5;
                final boolean z82222 = z4;
                final Function2<? super Composer, ? super Integer, Unit> function242222 = function23;
                ComposableLambda composableLambda5222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                    public final void invoke(Composer composer2222, int i13) {
                        ComposerKt.sourceInformation(composer2222, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                            }
                            State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z82222, composer2222, 0);
                            Modifier.Companion clearAndSetSemantics = (function242222 == null || !(z72222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                            ComposerKt.sourceInformationMarkerStart(composer2222, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
                startRestartGroup.startReplaceableGroup(-280424572);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableIntState mutableIntState2222 = (MutableIntState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                Modifier modifier42222 = modifier2;
                Modifier weight$default2222 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier42222, z, mutableInteractionSource52222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                startRestartGroup.startReplaceableGroup(-280424130);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                Modifier onSizeChanged2222 = OnRemeasuredModifierKt.onSizeChanged(weight$default2222, (Function1) rememberedValue2);
                Alignment center2222 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, true, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(onSizeChanged2222);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                boolean z92222 = z5;
                final State<Float> animateFloatAsState2222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localDensity2222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long Offset2222 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState2222) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume2222).mo630toPx0680j_4(IndicatorVerticalOffset));
                Unit unit2222 = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1035150713);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                changed = startRestartGroup.changed(Offset2222) | ((1879048192 & i122222) == 536870912);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new MappedInteractionSource(mutableInteractionSource52222, Offset2222, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                final MappedInteractionSource mappedInteractionSource2222 = (MappedInteractionSource) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                ComposableLambda composableLambda32222 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2222, Integer num) {
                        invoke(composer2222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2222, int i13) {
                        ComposerKt.sourceInformation(composer2222, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                            }
                            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2222, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2222, 0, 7)), composer2222, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2222.skipToGroupEnd();
                    }
                });
                ComposableLambda composableLambda42222 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2222, Integer num) {
                        invoke(composer2222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2222, int i13) {
                        ComposerKt.sourceInformation(composer2222, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                            }
                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                            composer2222.startReplaceableGroup(1844203561);
                            ComposerKt.sourceInformation(composer2222, "CC(remember):NavigationBar.kt#9igjgp");
                            boolean changed3 = composer2222.changed(animateFloatAsState2222);
                            final State<Float> state = animateFloatAsState2222;
                            Object rememberedValue6 = composer2222.rememberedValue();
                            if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                                composer2222.updateRememberedValue(rememberedValue6);
                            }
                            composer2222.endReplaceableGroup();
                            BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors42222.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2222, 6)), composer2222, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2222.skipToGroupEnd();
                    }
                });
                startRestartGroup.startReplaceableGroup(1035152133);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                changed2 = startRestartGroup.changed(animateFloatAsState2222);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                NavigationBarItemLayout(composableLambda32222, composableLambda42222, composableLambda5222, composableLambda2, z92222, (Function0) rememberedValue4, startRestartGroup, ((i122222 >> 9) & 57344) | 438);
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
                navigationBarItemColors3 = navigationBarItemColors42222;
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
            if ((i & 100663296) == 0) {
            }
            i8 = i2 & 256;
            int i112222 = i3;
            if (i8 == 0) {
            }
            if ((i9 & 306783379) == 306783378) {
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
            if (i7 != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (i8 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource;
            int i1222222 = i9;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final NavigationBarItemColors navigationBarItemColors422222 = navigationBarItemColors2;
            final boolean z722222 = z5;
            final boolean z822222 = z4;
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = function23;
            ComposableLambda composableLambda52222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                public final void invoke(Composer composer22222, int i13) {
                    ComposerKt.sourceInformation(composer22222, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                        }
                        State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z822222, composer22222, 0);
                        Modifier.Companion clearAndSetSemantics = (function2422222 == null || !(z722222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                        ComposerKt.sourceInformationMarkerStart(composer22222, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
            startRestartGroup.startReplaceableGroup(-280424572);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableIntState mutableIntState22222 = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Modifier modifier422222 = modifier2;
            Modifier weight$default22222 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier422222, z, mutableInteractionSource522222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
            startRestartGroup.startReplaceableGroup(-280424130);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            Modifier onSizeChanged22222 = OnRemeasuredModifierKt.onSizeChanged(weight$default22222, (Function1) rememberedValue2);
            Alignment center22222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(center22222, true, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(onSizeChanged22222);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
            boolean z922222 = z5;
            final State<Float> animateFloatAsState22222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
            ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localDensity22222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long Offset22222 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState22222) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume22222).mo630toPx0680j_4(IndicatorVerticalOffset));
            Unit unit22222 = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1035150713);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            changed = startRestartGroup.changed(Offset22222) | ((1879048192 & i1222222) == 536870912);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new MappedInteractionSource(mutableInteractionSource522222, Offset22222, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final MappedInteractionSource mappedInteractionSource22222 = (MappedInteractionSource) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            ComposableLambda composableLambda322222 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer22222, Integer num) {
                    invoke(composer22222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer22222, int i13) {
                    ComposerKt.sourceInformation(composer22222, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                        }
                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer22222, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer22222, 0, 7)), composer22222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer22222.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda422222 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer22222, Integer num) {
                    invoke(composer22222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer22222, int i13) {
                    ComposerKt.sourceInformation(composer22222, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer22222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                        }
                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                        composer22222.startReplaceableGroup(1844203561);
                        ComposerKt.sourceInformation(composer22222, "CC(remember):NavigationBar.kt#9igjgp");
                        boolean changed3 = composer22222.changed(animateFloatAsState22222);
                        final State<Float> state = animateFloatAsState22222;
                        Object rememberedValue6 = composer22222.rememberedValue();
                        if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                            composer22222.updateRememberedValue(rememberedValue6);
                        }
                        composer22222.endReplaceableGroup();
                        BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors422222.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer22222, 6)), composer22222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer22222.skipToGroupEnd();
                }
            });
            startRestartGroup.startReplaceableGroup(1035152133);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            changed2 = startRestartGroup.changed(animateFloatAsState22222);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            NavigationBarItemLayout(composableLambda322222, composableLambda422222, composableLambda52222, composableLambda2, z922222, (Function0) rememberedValue4, startRestartGroup, ((i1222222 >> 9) & 57344) | 438);
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
            navigationBarItemColors3 = navigationBarItemColors422222;
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
        if ((i & 100663296) == 0) {
        }
        i8 = i2 & 256;
        int i1122222 = i3;
        if (i8 == 0) {
        }
        if ((i9 & 306783379) == 306783378) {
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
        if (i7 != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (i8 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource;
        int i12222222 = i9;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final NavigationBarItemColors navigationBarItemColors4222222 = navigationBarItemColors2;
        final boolean z7222222 = z5;
        final boolean z8222222 = z4;
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = function23;
        ComposableLambda composableLambda522222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

            public final void invoke(Composer composer222222, int i13) {
                ComposerKt.sourceInformation(composer222222, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1419576100, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                    }
                    State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z8222222, composer222222, 0);
                    Modifier.Companion clearAndSetSemantics = (function24222222 == null || !(z7222222 || z)) ? Modifier.INSTANCE : SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
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
                    ComposerKt.sourceInformationMarkerStart(composer222222, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
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
        startRestartGroup.startReplaceableGroup(-280424572);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableIntState mutableIntState222222 = (MutableIntState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Modifier modifier4222222 = modifier2;
        Modifier weight$default222222 = RowScope.weight$default(rowScope, SizeKt.m913defaultMinSizeVpY3zN4$default(SelectableKt.m1120selectableO2vRcR0(modifier4222222, z, mutableInteractionSource5222222, null, z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
        startRestartGroup.startReplaceableGroup(-280424130);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        Modifier onSizeChanged222222 = OnRemeasuredModifierKt.onSizeChanged(weight$default222222, (Function1) rememberedValue2);
        Alignment center222222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222222 = BoxKt.rememberBoxMeasurePolicy(center222222, true, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222222 = LayoutKt.modifierMaterializerOf(onSizeChanged222222);
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
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
        boolean z9222222 = z5;
        final State<Float> animateFloatAsState222222 = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
        ProvidableCompositionLocal<Density> localDensity222222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localDensity222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long Offset222222 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState222222) - r2.mo624roundToPx0680j_4(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume222222).mo630toPx0680j_4(IndicatorVerticalOffset));
        Unit unit222222 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1035150713);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        changed = startRestartGroup.changed(Offset222222) | ((1879048192 & i12222222) == 536870912);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new MappedInteractionSource(mutableInteractionSource5222222, Offset222222, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final MappedInteractionSource mappedInteractionSource222222 = (MappedInteractionSource) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        ComposableLambda composableLambda3222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer222222, Integer num) {
                invoke(composer222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer222222, int i13) {
                ComposerKt.sourceInformation(composer222222, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(691730997, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                    }
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer222222, 6)), MappedInteractionSource.this, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer222222, 0, 7)), composer222222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer222222.skipToGroupEnd();
            }
        });
        ComposableLambda composableLambda4222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer222222, Integer num) {
                invoke(composer222222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer222222, int i13) {
                ComposerKt.sourceInformation(composer222222, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer222222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-474426875, i13, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                    }
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                    composer222222.startReplaceableGroup(1844203561);
                    ComposerKt.sourceInformation(composer222222, "CC(remember):NavigationBar.kt#9igjgp");
                    boolean changed3 = composer222222.changed(animateFloatAsState222222);
                    final State<Float> state = animateFloatAsState222222;
                    Object rememberedValue6 = composer222222.rememberedValue();
                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
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
                        composer222222.updateRememberedValue(rememberedValue6);
                    }
                    composer222222.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue6), navigationBarItemColors4222222.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer222222, 6)), composer222222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer222222.skipToGroupEnd();
            }
        });
        startRestartGroup.startReplaceableGroup(1035152133);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        changed2 = startRestartGroup.changed(animateFloatAsState222222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
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
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        NavigationBarItemLayout(composableLambda3222222, composableLambda4222222, composableLambda522222, composableLambda2, z9222222, (Function0) rememberedValue4, startRestartGroup, ((i12222222 >> 9) & 57344) | 438);
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
        navigationBarItemColors3 = navigationBarItemColors4222222;
        modifier3 = modifier4222222;
        mutableInteractionSource4 = mutableInteractionSource5222222;
        Composer composer222222 = startRestartGroup;
        final boolean z1022222 = z4;
        final Function2<? super Composer, ? super Integer, Unit> function2522222 = function23;
        endRestartGroup = composer222222.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final int NavigationBarItem$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1427075886);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)520@22742L1945,506@22286L2401:NavigationBar.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-1427075886, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:505)");
            }
            startRestartGroup.startReplaceableGroup(-1250032035);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            int i3 = 458752 & i2;
            int i4 = 57344 & i2;
            boolean z2 = (i3 == 131072) | ((i2 & 7168) == 2048) | (i4 == 16384);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        float f;
                        Measurable measurable;
                        Placeable placeable;
                        MeasureResult m2351placeLabelAndIconzUg2_y0;
                        MeasureResult m2350placeIconX9ElhV4;
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
                                f = NavigationBarKt.IndicatorHorizontalPadding;
                                float f2 = 2;
                                int i6 = width + measureScope2.mo624roundToPx0680j_4(Dp.m6389constructorimpl(f * f2));
                                int roundToInt = MathKt.roundToInt(i6 * floatValue);
                                int height = mo5333measureBRTryo0.getHeight() + measureScope2.mo624roundToPx0680j_4(Dp.m6389constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f2));
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
                                            m2350placeIconX9ElhV4 = NavigationBarKt.m2350placeIconX9ElhV4(measureScope2, mo5333measureBRTryo0, mo5333measureBRTryo02, mo5333measureBRTryo03, j);
                                            return m2350placeIconX9ElhV4;
                                        }
                                        Intrinsics.checkNotNull(placeable);
                                        m2351placeLabelAndIconzUg2_y0 = NavigationBarKt.m2351placeLabelAndIconzUg2_y0(measureScope, placeable, mo5333measureBRTryo0, mo5333measureBRTryo02, mo5333measureBRTryo03, j, z, floatValue);
                                        return m2351placeLabelAndIconzUg2_y0;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1836184647, "C507@22303L17,508@22329L11,510@22350L50:NavigationBar.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171585, "C510@22392L6:NavigationBar.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1250032367);
            ComposerKt.sourceInformation(startRestartGroup, "516@22556L60,513@22443L281");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                startRestartGroup.startReplaceableGroup(1836184900);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z3 = (i4 == 16384) | (i3 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$2$1
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
                Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2), Dp.m6389constructorimpl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171908, "C518@22715L7:NavigationBar.kt#uh7d8r");
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$3
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
                    NavigationBarKt.NavigationBarItemLayout(function2, function22, function23, function24, z, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2350placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
        final int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, measureScope.mo624roundToPx0680j_4(NavigationBarHeight));
        final int width = (m6345getMaxWidthimpl - placeable.getWidth()) / 2;
        final int height = (m6358constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (m6345getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int height2 = (m6358constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, m6345getMaxWidthimpl, m6358constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (m6345getMaxWidthimpl - placeable4.getWidth()) / 2, (m6358constrainHeightK40F9xA - placeable4.getHeight()) / 2, 0.0f, 4, null);
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
    public static final MeasureResult m2351placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPadding;
        float f3 = height + measureScope.mo630toPx0680j_4(f2);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float f5 = f3 + measureScope.mo630toPx0680j_4(f4) + placeable.getHeight();
        float f6 = 2;
        final float coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m6346getMinHeightimpl(j) - f5) / f6, measureScope.mo630toPx0680j_4(f2));
        float f7 = f5 + (coerceAtLeast * f6);
        final float height2 = ((z ? coerceAtLeast : (f7 - placeable2.getHeight()) / f6) - coerceAtLeast) * (1 - f);
        final float height3 = placeable2.getHeight() + coerceAtLeast + measureScope.mo630toPx0680j_4(f2) + measureScope.mo630toPx0680j_4(f4);
        final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
        final int width = (m6345getMaxWidthimpl - placeable.getWidth()) / 2;
        final int width2 = (m6345getMaxWidthimpl - placeable2.getWidth()) / 2;
        final int width3 = (m6345getMaxWidthimpl - placeable3.getWidth()) / 2;
        final float f8 = coerceAtLeast - measureScope.mo630toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, m6345getMaxWidthimpl, MathKt.roundToInt(f7), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
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
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    int i = m6345getMaxWidthimpl;
                    float f9 = coerceAtLeast;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, (i - placeable5.getWidth()) / 2, MathKt.roundToInt((f9 - measureScope2.mo624roundToPx0680j_4(NavigationBarKt.getIndicatorVerticalPadding())) + height2), 0.0f, 4, null);
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

    static {
        float f = 2;
        IndicatorHorizontalPadding = Dp.m6389constructorimpl(Dp.m6389constructorimpl(NavigationBarTokens.INSTANCE.m3277getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m3280getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m6389constructorimpl(Dp.m6389constructorimpl(NavigationBarTokens.INSTANCE.m3276getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m3280getIconSizeD9Ej5fM()) / f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }
}
