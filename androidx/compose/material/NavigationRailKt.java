package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
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
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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

/* compiled from: NavigationRail.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0082\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001az\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008e\u0001\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000e0$¢\u0006\u0002\b\u00192\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\"2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010$¢\u0006\u0002\b\u00192\b\b\u0002\u0010(\u001a\u00020\"2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a?\u0010/\u001a\u00020\u000e2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000e0$¢\u0006\u0002\b\u00192\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010$¢\u0006\u0002\b\u00192\b\b\u0001\u00100\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00101\u001aR\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2&\u0010\u001b\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a&\u0010:\u001a\u00020;*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a8\u0010C\u001a\u00020;*\u00020<2\u0006\u0010D\u001a\u00020>2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\b\u0001\u00100\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u00107\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "NavigationRail", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationRailKt {
    private static final float HeaderPadding;
    private static final float NavigationRailPadding;
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = Dp.m6389constructorimpl(72);
    private static final float NavigationRailItemCompactSize = Dp.m6389constructorimpl(56);
    private static final float ItemLabelBaselineBottomOffset = Dp.m6389constructorimpl(16);
    private static final float ItemIconTopOffset = Dp.m6389constructorimpl(14);
    private static final WindowInsets ZeroInsets = WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0079  */
    /* renamed from: NavigationRail-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1712NavigationRailafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        int i4;
        float f2;
        int i5;
        int i6;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        long j5;
        float f3;
        int i7;
        Modifier modifier3;
        long j6;
        Composer composer2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1389243291);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRail)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)105@4893L6,106@4935L32,111@5137L603:NavigationRail.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 7168) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i6 = 458752;
                    function33 = function3;
                } else {
                    i6 = 458752;
                    function33 = function3;
                    if ((i & 458752) == 0) {
                        i3 |= startRestartGroup.changedInstance(function33) ? 131072 : 65536;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                }
                if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            f2 = NavigationRailDefaults.INSTANCE.m1710getElevationD9Ej5fM();
                        }
                        if (i5 != 0) {
                            function34 = null;
                            j5 = j4;
                            f3 = f2;
                            i7 = -1389243291;
                            modifier3 = modifier2;
                            j6 = j3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:110)");
                            }
                            composer2 = startRestartGroup;
                            SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -245908831, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                                    float f5;
                                    float f6;
                                    ComposerKt.sourceInformation(composer3, "C117@5291L443:NavigationRail.kt#jmzs0o");
                                    if ((i10 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-245908831, i10, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                                        }
                                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                        f5 = NavigationRailKt.NavigationRailPadding;
                                        Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                                        Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, 65525993, "C129@5715L9:NavigationRail.kt#jmzs0o");
                                        composer3.startReplaceableGroup(65525993);
                                        ComposerKt.sourceInformation(composer3, "126@5625L8,127@5650L38");
                                        if (function36 != null) {
                                            function36.invoke(columnScopeInstance, composer3, 6);
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f6 = NavigationRailKt.HeaderPadding;
                                            SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion, f6), composer3, 6);
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
                            }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & i6), 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function35 = function34;
                            modifier4 = modifier3;
                            j7 = j6;
                            j8 = j5;
                            f4 = f3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                    }
                    f3 = f2;
                    function34 = function33;
                    i7 = -1389243291;
                    j6 = j3;
                    j5 = j4;
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -245908831, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                            float f5;
                            float f6;
                            ComposerKt.sourceInformation(composer3, "C117@5291L443:NavigationRail.kt#jmzs0o");
                            if ((i10 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-245908831, i10, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                                }
                                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                f5 = NavigationRailKt.NavigationRailPadding;
                                Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                                Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                                ComposerKt.sourceInformationMarkerStart(composer3, 65525993, "C129@5715L9:NavigationRail.kt#jmzs0o");
                                composer3.startReplaceableGroup(65525993);
                                ComposerKt.sourceInformation(composer3, "126@5625L8,127@5650L38");
                                if (function36 != null) {
                                    function36.invoke(columnScopeInstance, composer3, 6);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f6 = NavigationRailKt.HeaderPadding;
                                    SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion, f6), composer3, 6);
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
                    }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & i6), 18);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function35 = function34;
                    modifier4 = modifier3;
                    j7 = j6;
                    j8 = j5;
                    f4 = f3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier4 = modifier2;
                    j7 = j3;
                    j8 = j4;
                    f4 = f2;
                    function35 = function33;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$2
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
                            NavigationRailKt.m1712NavigationRailafqeVBk(WindowInsets.this, modifier4, j7, j8, f4, function35, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f2 = f;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            f3 = f2;
            function34 = function33;
            i7 = -1389243291;
            j6 = j3;
            j5 = j4;
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -245908831, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                    float f5;
                    float f6;
                    ComposerKt.sourceInformation(composer3, "C117@5291L443:NavigationRail.kt#jmzs0o");
                    if ((i10 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-245908831, i10, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                        }
                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                        f5 = NavigationRailKt.NavigationRailPadding;
                        Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                        Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 65525993, "C129@5715L9:NavigationRail.kt#jmzs0o");
                        composer3.startReplaceableGroup(65525993);
                        ComposerKt.sourceInformation(composer3, "126@5625L8,127@5650L38");
                        if (function36 != null) {
                            function36.invoke(columnScopeInstance, composer3, 6);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            f6 = NavigationRailKt.HeaderPadding;
                            SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion, f6), composer3, 6);
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
            }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & i6), 18);
            if (ComposerKt.isTraceInProgress()) {
            }
            function35 = function34;
            modifier4 = modifier3;
            j7 = j6;
            j8 = j5;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        f3 = f2;
        function34 = function33;
        i7 = -1389243291;
        j6 = j3;
        j5 = j4;
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -245908831, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$1
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
                float f5;
                float f6;
                ComposerKt.sourceInformation(composer3, "C117@5291L443:NavigationRail.kt#jmzs0o");
                if ((i10 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-245908831, i10, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:117)");
                    }
                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                    f5 = NavigationRailKt.NavigationRailPadding;
                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m881paddingVpY3zN4$default(windowInsetsPadding, 0.0f, f5, 1, null));
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Function3<ColumnScope, Composer, Integer, Unit> function36 = function34;
                    Function3<ColumnScope, Composer, Integer, Unit> function37 = function32;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                    ComposerKt.sourceInformationMarkerStart(composer3, 65525993, "C129@5715L9:NavigationRail.kt#jmzs0o");
                    composer3.startReplaceableGroup(65525993);
                    ComposerKt.sourceInformation(composer3, "126@5625L8,127@5650L38");
                    if (function36 != null) {
                        function36.invoke(columnScopeInstance, composer3, 6);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f6 = NavigationRailKt.HeaderPadding;
                        SpacerKt.Spacer(SizeKt.m914height3ABfNKs(companion, f6), composer3, 6);
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
        }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & i6), 18);
        if (ComposerKt.isTraceInProgress()) {
        }
        function35 = function34;
        modifier4 = modifier3;
        j7 = j6;
        j8 = j5;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x008a  */
    /* renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1711NavigationRailHsRjFd4(Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33;
        Modifier modifier3;
        int i5;
        float f3;
        int i6;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34;
        int i7;
        long j5;
        long j6;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final float f4;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1790971523);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)170@7588L6,171@7630L32,176@7832L95:NavigationRail.kt#jmzs0o");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i3 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i3 |= i9;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i8 = 256;
                    i3 |= i8;
                }
            } else {
                j4 = j2;
            }
            i8 = 128;
            i3 |= i8;
        } else {
            j4 = j2;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 57344) == 0) {
                function33 = function3;
                i3 |= startRestartGroup.changedInstance(function33) ? 16384 : 8192;
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    if ((i3 & 374491) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                                j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                            }
                            if ((i2 & 4) != 0) {
                                long m1621contentColorForek8zF_U = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                                j4 = m1621contentColorForek8zF_U;
                            }
                            if (i11 != 0) {
                                f2 = NavigationRailDefaults.INSTANCE.m1710getElevationD9Ej5fM();
                            }
                            if (i4 == 0) {
                                float f5 = f2;
                                modifier3 = companion;
                                i5 = 458752;
                                f3 = f5;
                                function34 = null;
                                j6 = j4;
                                i6 = 6;
                                i7 = 1790971523;
                                j5 = j3;
                            } else {
                                float f6 = f2;
                                modifier3 = companion;
                                i5 = 458752;
                                f3 = f6;
                                i6 = 6;
                                function34 = function33;
                                i7 = 1790971523;
                                j5 = j3;
                                j6 = j4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            i6 = 6;
                            function34 = function33;
                            i5 = 458752;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            modifier3 = modifier2;
                            i7 = 1790971523;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:175)");
                        }
                        int i12 = i3 << 3;
                        composer2 = startRestartGroup;
                        m1712NavigationRailafqeVBk(ZeroInsets, modifier3, j5, j6, f3, function34, function32, composer2, (i5 & i12) | i6 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (i12 & 57344) | (3670016 & i12), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        j7 = j5;
                        j8 = j6;
                        f4 = f3;
                        function35 = function34;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        function35 = function33;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRail$3
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
                                NavigationRailKt.m1711NavigationRailHsRjFd4(Modifier.this, j7, j8, f4, function35, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 374491) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 == 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i122 = i3 << 3;
                composer2 = startRestartGroup;
                m1712NavigationRailafqeVBk(ZeroInsets, modifier3, j5, j6, f3, function34, function32, composer2, (i5 & i122) | i6 | (i122 & 112) | (i122 & 896) | (i122 & 7168) | (i122 & 57344) | (3670016 & i122), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                function35 = function34;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function33 = function3;
            if ((i2 & 32) != 0) {
            }
            if ((i3 & 374491) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 == 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1222 = i3 << 3;
            composer2 = startRestartGroup;
            m1712NavigationRailafqeVBk(ZeroInsets, modifier3, j5, j6, f3, function34, function32, composer2, (i5 & i1222) | i6 | (i1222 & 112) | (i1222 & 896) | (i1222 & 7168) | (i1222 & 57344) | (3670016 & i1222), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            function35 = function34;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function33 = function3;
        if ((i2 & 32) != 0) {
        }
        if ((i3 & 374491) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i12222 = i3 << 3;
        composer2 = startRestartGroup;
        m1712NavigationRailafqeVBk(ZeroInsets, modifier3, j5, j6, f3, function34, function32, composer2, (i5 & i12222) | i6 | (i12222 & 112) | (i12222 & 896) | (i12222 & 7168) | (i12222 & 57344) | (3670016 & i12222), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        function35 = function34;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019e  */
    /* renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1713NavigationRailItem0S3VyRs(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i7;
        final boolean z5;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        long j4;
        int i12;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        Composer composer2;
        final long j5;
        final boolean z6;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1813548445);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)211@9729L39,212@9818L6,213@9888L7,213@9922L6,228@10720L83,232@10808L804:NavigationRail.kt#jmzs0o");
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
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        function23 = function22;
                        i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            z5 = z3;
                            i3 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                            i8 = i2 & 128;
                            if (i8 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 29360128) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                if ((i & 234881024) == 0) {
                                    i10 = i3 | (((i2 & 256) == 0 && startRestartGroup.changed(j)) ? 67108864 : 33554432);
                                } else {
                                    i10 = i3;
                                }
                                if ((i & 1879048192) == 0) {
                                    j3 = j2;
                                    i10 |= ((i2 & 512) == 0 && startRestartGroup.changed(j3)) ? 536870912 : 268435456;
                                } else {
                                    j3 = j2;
                                }
                                i11 = i10;
                                if ((i11 & 1533916891) == 306783378 || !startRestartGroup.getSkipping()) {
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
                                        if (i9 != 0) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
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
                                        if ((i2 & 256) != 0) {
                                            j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1603getPrimary0d7_KjU();
                                            i12 = i11 & (-234881025);
                                        } else {
                                            j4 = j;
                                            i12 = i11;
                                        }
                                        if ((i2 & 512) != 0) {
                                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localContentColor);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            j3 = Color.m4062copywmQWz5c$default(((Color) consume).m4073unboximpl(), ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                            i12 &= -1879048193;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        int i13 = (i2 & 256) != 0 ? i11 & (-234881025) : i11;
                                        if ((i2 & 512) != 0) {
                                            i13 &= -1879048193;
                                        }
                                        j4 = j;
                                        i12 = i13;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1813548445, i12, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:214)");
                                    }
                                    final ComposableLambda composableLambda = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                                        public final void invoke(Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-180398615, i14, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                                                }
                                                TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : null;
                                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource4, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    startRestartGroup.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                                    startRestartGroup.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                                    long j7 = j3;
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
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
                                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                                            invoke(f.floatValue(), composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(float f, Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                                            if ((i14 & 14) == 0) {
                                                i14 |= composer3.changed(f) ? 4 : 2;
                                            }
                                            if ((i14 & 91) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(670576792, i14, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                                }
                                                if (z5) {
                                                    f = 1.0f;
                                                }
                                                NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda, f, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                    int i14 = i12 >> 24;
                                    m1714NavigationRailTransitionKlgxPg(j4, j7, z, composableLambda2, startRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i12 << 6) & 896));
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endNode();
                                    startRestartGroup.endReplaceableGroup();
                                    startRestartGroup.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    function24 = function23;
                                    composer2 = startRestartGroup;
                                    j5 = j7;
                                    z6 = z4;
                                    j6 = j4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    composer2 = startRestartGroup;
                                    function24 = function23;
                                    j5 = j3;
                                    z6 = z4;
                                    j6 = j;
                                }
                                final Modifier modifier3 = modifier2;
                                final boolean z7 = z5;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$3
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

                                        public final void invoke(Composer composer3, int i15) {
                                            NavigationRailKt.m1713NavigationRailItem0S3VyRs(z, function0, function2, modifier3, z6, function24, z7, mutableInteractionSource3, j6, j5, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i9 = i8;
                            if ((i & 234881024) == 0) {
                            }
                            if ((i & 1879048192) == 0) {
                            }
                            i11 = i10;
                            if ((i11 & 1533916891) == 306783378) {
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
                            if (i9 != 0) {
                            }
                            if ((i2 & 256) != 0) {
                            }
                            if ((i2 & 512) != 0) {
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda3 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                                public final void invoke(Composer composer3, int i142) {
                                    ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                                    if ((i142 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-180398615, i142, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                                        }
                                        TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null;
                            MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                            Modifier m928size3ABfNKs2 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource42, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs2);
                            long j72 = j3;
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
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
                            ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                                    invoke(f.floatValue(), composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f, Composer composer3, int i142) {
                                    ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                                    if ((i142 & 14) == 0) {
                                        i142 |= composer3.changed(f) ? 4 : 2;
                                    }
                                    if ((i142 & 91) != 18 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(670576792, i142, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                        }
                                        if (z5) {
                                            f = 1.0f;
                                        }
                                        NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda3, f, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            });
                            int i142 = i12 >> 24;
                            m1714NavigationRailTransitionKlgxPg(j4, j72, z, composableLambda22, startRestartGroup, (i142 & 112) | (i142 & 14) | 3072 | ((i12 << 6) & 896));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            mutableInteractionSource3 = mutableInteractionSource42;
                            function24 = function23;
                            composer2 = startRestartGroup;
                            j5 = j72;
                            z6 = z4;
                            j6 = j4;
                            final Modifier modifier32 = modifier2;
                            final boolean z72 = z5;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        z5 = z3;
                        i8 = i2 & 128;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        if ((i & 234881024) == 0) {
                        }
                        if ((i & 1879048192) == 0) {
                        }
                        i11 = i10;
                        if ((i11 & 1533916891) == 306783378) {
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
                        if (i9 != 0) {
                        }
                        if ((i2 & 256) != 0) {
                        }
                        if ((i2 & 512) != 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda32 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                            public final void invoke(Composer composer3, int i1422) {
                                ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                                if ((i1422 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-180398615, i1422, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                                    }
                                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }) : null;
                        MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                        Modifier m928size3ABfNKs22 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource422, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                        Alignment center22 = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs22);
                        long j722 = j3;
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
                        ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                                invoke(f.floatValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f, Composer composer3, int i1422) {
                                ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                                if ((i1422 & 14) == 0) {
                                    i1422 |= composer3.changed(f) ? 4 : 2;
                                }
                                if ((i1422 & 91) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(670576792, i1422, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                    }
                                    if (z5) {
                                        f = 1.0f;
                                    }
                                    NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda32, f, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        int i1422 = i12 >> 24;
                        m1714NavigationRailTransitionKlgxPg(j4, j722, z, composableLambda222, startRestartGroup, (i1422 & 112) | (i1422 & 14) | 3072 | ((i12 << 6) & 896));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource422;
                        function24 = function23;
                        composer2 = startRestartGroup;
                        j5 = j722;
                        z6 = z4;
                        j6 = j4;
                        final Modifier modifier322 = modifier2;
                        final boolean z722 = z5;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function23 = function22;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    z5 = z3;
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if ((i & 234881024) == 0) {
                    }
                    if ((i & 1879048192) == 0) {
                    }
                    i11 = i10;
                    if ((i11 & 1533916891) == 306783378) {
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
                    if (i9 != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if ((i2 & 512) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda322 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                        public final void invoke(Composer composer3, int i14222) {
                            ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                            if ((i14222 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-180398615, i14222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                                }
                                TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }) : null;
                    MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
                    Modifier m928size3ABfNKs222 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource4222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                    Alignment center222 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs222);
                    long j7222 = j3;
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
                    ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                            invoke(f.floatValue(), composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer3, int i14222) {
                            ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                            if ((i14222 & 14) == 0) {
                                i14222 |= composer3.changed(f) ? 4 : 2;
                            }
                            if ((i14222 & 91) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(670576792, i14222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                                }
                                if (z5) {
                                    f = 1.0f;
                                }
                                NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda322, f, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    int i14222 = i12 >> 24;
                    m1714NavigationRailTransitionKlgxPg(j4, j7222, z, composableLambda2222, startRestartGroup, (i14222 & 112) | (i14222 & 14) | 3072 | ((i12 << 6) & 896));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource4222;
                    function24 = function23;
                    composer2 = startRestartGroup;
                    j5 = j7222;
                    z6 = z4;
                    j6 = j4;
                    final Modifier modifier3222 = modifier2;
                    final boolean z7222 = z5;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z2;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function23 = function22;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                z5 = z3;
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i & 234881024) == 0) {
                }
                if ((i & 1879048192) == 0) {
                }
                i11 = i10;
                if ((i11 & 1533916891) == 306783378) {
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
                if (i9 != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if ((i2 & 512) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> composableLambda3222 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                    public final void invoke(Composer composer3, int i142222) {
                        ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                        if ((i142222 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-180398615, i142222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                            }
                            TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }) : null;
                MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
                Modifier m928size3ABfNKs2222 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource42222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
                Alignment center2222 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs2222);
                long j72222 = j3;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
                ComposableLambda composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                        invoke(f.floatValue(), composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer3, int i142222) {
                        ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                        if ((i142222 & 14) == 0) {
                            i142222 |= composer3.changed(f) ? 4 : 2;
                        }
                        if ((i142222 & 91) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(670576792, i142222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                            }
                            if (z5) {
                                f = 1.0f;
                            }
                            NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda3222, f, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                });
                int i142222 = i12 >> 24;
                m1714NavigationRailTransitionKlgxPg(j4, j72222, z, composableLambda22222, startRestartGroup, (i142222 & 112) | (i142222 & 14) | 3072 | ((i12 << 6) & 896));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource3 = mutableInteractionSource42222;
                function24 = function23;
                composer2 = startRestartGroup;
                j5 = j72222;
                z6 = z4;
                j6 = j4;
                final Modifier modifier32222 = modifier2;
                final boolean z72222 = z5;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z4 = z2;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function23 = function22;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            z5 = z3;
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i & 234881024) == 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            i11 = i10;
            if ((i11 & 1533916891) == 306783378) {
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
            if (i9 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if ((i2 & 512) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> composableLambda32222 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

                public final void invoke(Composer composer3, int i1422222) {
                    ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                    if ((i1422222 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180398615, i1422222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                        }
                        TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }) : null;
            MutableInteractionSource mutableInteractionSource422222 = mutableInteractionSource2;
            Modifier m928size3ABfNKs22222 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource422222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
            Alignment center22222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(center22222, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs22222);
            long j722222 = j3;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
            ComposableLambda composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                    invoke(f.floatValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, Composer composer3, int i1422222) {
                    ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                    if ((i1422222 & 14) == 0) {
                        i1422222 |= composer3.changed(f) ? 4 : 2;
                    }
                    if ((i1422222 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(670576792, i1422222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                        }
                        if (z5) {
                            f = 1.0f;
                        }
                        NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda32222, f, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            int i1422222 = i12 >> 24;
            m1714NavigationRailTransitionKlgxPg(j4, j722222, z, composableLambda222222, startRestartGroup, (i1422222 & 112) | (i1422222 & 14) | 3072 | ((i12 << 6) & 896));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource3 = mutableInteractionSource422222;
            function24 = function23;
            composer2 = startRestartGroup;
            j5 = j722222;
            z6 = z4;
            j6 = j4;
            final Modifier modifier322222 = modifier2;
            final boolean z722222 = z5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z4 = z2;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function23 = function22;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        z5 = z3;
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i & 234881024) == 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        i11 = i10;
        if ((i11 & 1533916891) == 306783378) {
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
        if (i9 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if ((i2 & 512) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> composableLambda322222 = function23 != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -180398615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
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

            public final void invoke(Composer composer3, int i14222222) {
                ComposerKt.sourceInformation(composer3, "C217@10056L10,218@10122L40:NavigationRail.kt#jmzs0o");
                if ((i14222222 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180398615, i14222222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:217)");
                    }
                    TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }) : null;
        MutableInteractionSource mutableInteractionSource4222222 = mutableInteractionSource2;
        Modifier m928size3ABfNKs222222 = SizeKt.m928size3ABfNKs(SelectableKt.m1120selectableO2vRcR0(modifier2, z, mutableInteractionSource4222222, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i12 >> 18) & 896) | 6, 2), z4, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function0), function23 == null ? NavigationRailItemCompactSize : NavigationRailItemSize);
        Alignment center222222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222222 = BoxKt.rememberBoxMeasurePolicy(center222222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222222 = LayoutKt.modifierMaterializerOf(m928size3ABfNKs222222);
        long j7222222 = j3;
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
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1714403881, "C245@11189L417:NavigationRail.kt#jmzs0o");
        ComposableLambda composableLambda2222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 670576792, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer3, Integer num) {
                invoke(f.floatValue(), composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f, Composer composer3, int i14222222) {
                ComposerKt.sourceInformation(composer3, "C252@11417L179:NavigationRail.kt#jmzs0o");
                if ((i14222222 & 14) == 0) {
                    i14222222 |= composer3.changed(f) ? 4 : 2;
                }
                if ((i14222222 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(670576792, i14222222, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:250)");
                    }
                    if (z5) {
                        f = 1.0f;
                    }
                    NavigationRailKt.NavigationRailItemBaselineLayout(function2, composableLambda322222, f, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        int i14222222 = i12 >> 24;
        m1714NavigationRailTransitionKlgxPg(j4, j7222222, z, composableLambda2222222, startRestartGroup, (i14222222 & 112) | (i14222222 & 14) | 3072 | ((i12 << 6) & 896));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource3 = mutableInteractionSource4222222;
        function24 = function23;
        composer2 = startRestartGroup;
        j5 = j7222222;
        z6 = z4;
        j6 = j4;
        final Modifier modifier3222222 = modifier2;
        final boolean z7222222 = z5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1714NavigationRailTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-207161906);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)298@12977L126,305@13178L181:NavigationRail.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207161906, i2, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:297)");
            }
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, null, startRestartGroup, 48, 28);
            long m4114lerpjxsXWHM = ColorKt.m4114lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(Color.m4062copywmQWz5c$default(m4114lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(m4114lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(startRestartGroup, -1688205042, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$1
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
                    float NavigationRailTransition_Klgx_Pg$lambda$3;
                    ComposerKt.sourceInformation(composer2, "C309@13327L26:NavigationRail.kt#jmzs0o");
                    if ((i3 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1688205042, i3, -1, "androidx.compose.material.NavigationRailTransition.<anonymous> (NavigationRail.kt:309)");
                    }
                    Function3<Float, Composer, Integer, Unit> function32 = function3;
                    NavigationRailTransition_Klgx_Pg$lambda$3 = NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$3(animateFloatAsState);
                    function32.invoke(Float.valueOf(NavigationRailTransition_Klgx_Pg$lambda$3), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailTransition$2
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
                    NavigationRailKt.m1714NavigationRailTransitionKlgxPg(j, j2, z, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1903861684);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemBaselineLayout)P(!1,2)330@14024L1126:NavigationRail.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1903861684, i2, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:329)");
            }
            startRestartGroup.startReplaceableGroup(-498208610);
            boolean changedInstance = startRestartGroup.changedInstance(function22) | startRestartGroup.changed(f);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeable;
                        MeasureResult m1719placeLabelAndIconDIyivk0;
                        MeasureResult m1718placeIcon3p2s80s;
                        int size = list.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Measurable measurable = list.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                                Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j);
                                if (function22 != null) {
                                    int size2 = list.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        Measurable measurable2 = list.get(i4);
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                                            placeable = measurable2.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                                placeable = null;
                                Placeable placeable2 = placeable;
                                if (function22 == null) {
                                    m1718placeIcon3p2s80s = NavigationRailKt.m1718placeIcon3p2s80s(measureScope, mo5333measureBRTryo0, j);
                                    return m1718placeIcon3p2s80s;
                                }
                                Intrinsics.checkNotNull(placeable2);
                                m1719placeLabelAndIconDIyivk0 = NavigationRailKt.m1719placeLabelAndIconDIyivk0(measureScope, placeable2, mo5333measureBRTryo0, j, f);
                                return m1719placeLabelAndIconDIyivk0;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 116753849, "C332@14054L41:NavigationRail.kt#jmzs0o");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2053497723, "C332@14087L6:NavigationRail.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(286686926);
            ComposerKt.sourceInformation(startRestartGroup, "334@14145L168");
            if (function22 != null) {
                Modifier alpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(alpha);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2053497940, "C338@14304L7:NavigationRail.kt#jmzs0o");
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$3
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
                    NavigationRailKt.NavigationRailItemBaselineLayout(function2, function22, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1718placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        final int max = Math.max(0, (Constraints.m6345getMaxWidthimpl(j) - placeable.getWidth()) / 2);
        final int max2 = Math.max(0, (Constraints.m6344getMaxHeightimpl(j) - placeable.getHeight()) / 2);
        return MeasureScope.layout$default(measureScope, Constraints.m6345getMaxWidthimpl(j), Constraints.m6344getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, max, max2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1719placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        final int m6344getMaxHeightimpl = (Constraints.m6344getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo624roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        final int m6345getMaxWidthimpl = (Constraints.m6345getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        final int i = measureScope.mo624roundToPx0680j_4(ItemIconTopOffset);
        int m6344getMaxHeightimpl2 = (Constraints.m6344getMaxHeightimpl(j) - placeable2.getHeight()) / 2;
        final int m6345getMaxWidthimpl2 = (Constraints.m6345getMaxWidthimpl(j) - placeable2.getWidth()) / 2;
        final int roundToInt = MathKt.roundToInt((m6344getMaxHeightimpl2 - i) * (1 - f));
        return MeasureScope.layout$default(measureScope, Constraints.m6345getMaxWidthimpl(j), Constraints.m6344getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.NavigationRailKt$placeLabelAndIcon$1
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
                if (f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, m6345getMaxWidthimpl, m6344getMaxHeightimpl + roundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, m6345getMaxWidthimpl2, i + roundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 8;
        NavigationRailPadding = Dp.m6389constructorimpl(f);
        HeaderPadding = Dp.m6389constructorimpl(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailTransition_Klgx_Pg$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
