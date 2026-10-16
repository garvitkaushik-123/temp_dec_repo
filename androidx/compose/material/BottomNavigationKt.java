package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
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
import androidx.compose.ui.unit.ConstraintsKt;
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

/* compiled from: BottomNavigation.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a`\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aX\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u000b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0001\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010!\u001aR\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2&\u0010\u0013\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0092\u0001\u0010,\u001a\u00020\u000b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020&2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010/\u001a\u00020&2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00103\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a&\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a8\u0010?\u001a\u000207*\u0002082\u0006\u0010@\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\b\u0001\u0010 \u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C²\u0006\n\u0010)\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomNavigation", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = Dp.m6389constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;
    private static final WindowInsets ZeroInsets;

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0060  */
    /* renamed from: BottomNavigation-_UMDTes, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1549BottomNavigation_UMDTes(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        int i4;
        float f2;
        int i5;
        float m1547getElevationD9Ej5fM;
        long j5;
        long j6;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1278406810);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigation)P(5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)103@4719L6,104@4768L32,108@4911L474:BottomNavigation.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i6 = 2048;
                        i3 |= i6;
                    }
                } else {
                    j4 = j2;
                }
                i6 = 1024;
                i3 |= i6;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                if ((i2 & 32) == 0) {
                    if ((i & 458752) == 0) {
                        i5 = startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                m1547getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m1547getElevationD9Ej5fM();
                                j5 = j3;
                                j6 = j4;
                                modifier3 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1278406810, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:107)");
                                }
                                composer2 = startRestartGroup;
                                SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, m1547getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(startRestartGroup, -352628062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                                        float f4;
                                        ComposerKt.sourceInformation(composer3, "C114@5065L314:BottomNavigation.kt#jmzs0o");
                                        if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-352628062, i9, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:114)");
                                            }
                                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                            f4 = BottomNavigationKt.BottomNavigationHeight;
                                            Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
                                }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                j7 = j5;
                                j8 = j6;
                                f3 = m1547getElevationD9Ej5fM;
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
                        j6 = j4;
                        m1547getElevationD9Ej5fM = f2;
                        modifier3 = modifier2;
                        j5 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, m1547getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(startRestartGroup, -352628062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                                float f4;
                                ComposerKt.sourceInformation(composer3, "C114@5065L314:BottomNavigation.kt#jmzs0o");
                                if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-352628062, i9, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:114)");
                                    }
                                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                    f4 = BottomNavigationKt.BottomNavigationHeight;
                                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
                        }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        j7 = j5;
                        j8 = j6;
                        f3 = m1547getElevationD9Ej5fM;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j7 = j3;
                        j8 = j4;
                        f3 = f2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$2
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
                                BottomNavigationKt.m1549BottomNavigation_UMDTes(WindowInsets.this, modifier4, j7, j8, f3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i5;
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                j6 = j4;
                m1547getElevationD9Ej5fM = f2;
                modifier3 = modifier2;
                j5 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, m1547getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(startRestartGroup, -352628062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                        float f4;
                        ComposerKt.sourceInformation(composer3, "C114@5065L314:BottomNavigation.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-352628062, i9, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:114)");
                            }
                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                            f4 = BottomNavigationKt.BottomNavigationHeight;
                            Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
                }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j5;
                j8 = j6;
                f3 = m1547getElevationD9Ej5fM;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((i2 & 32) == 0) {
            }
            i3 |= i5;
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            j6 = j4;
            m1547getElevationD9Ej5fM = f2;
            modifier3 = modifier2;
            j5 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, m1547getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(startRestartGroup, -352628062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                    float f4;
                    ComposerKt.sourceInformation(composer3, "C114@5065L314:BottomNavigation.kt#jmzs0o");
                    if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-352628062, i9, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:114)");
                        }
                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                        f4 = BottomNavigationKt.BottomNavigationHeight;
                        Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
            }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j5;
            j8 = j6;
            f3 = m1547getElevationD9Ej5fM;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
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
        if ((i2 & 32) == 0) {
        }
        i3 |= i5;
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        j6 = j4;
        m1547getElevationD9Ej5fM = f2;
        modifier3 = modifier2;
        j5 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, m1547getElevationD9Ej5fM, ComposableLambdaKt.composableLambda(startRestartGroup, -352628062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$1
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
                float f4;
                ComposerKt.sourceInformation(composer3, "C114@5065L314:BottomNavigation.kt#jmzs0o");
                if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-352628062, i9, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:114)");
                    }
                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                    f4 = BottomNavigationKt.BottomNavigationHeight;
                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m913defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer3, 6);
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
        }), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j5;
        j8 = j6;
        f3 = m1547getElevationD9Ej5fM;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0088  */
    /* renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1548BottomNavigationPEIptTM(Modifier modifier, long j, long j2, float f, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        Modifier modifier3;
        int i4;
        long j5;
        float m1547getElevationD9Ej5fM;
        int i5;
        Composer composer2;
        final Modifier modifier4;
        final long j6;
        final long j7;
        final float f3;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(456489494);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)158@6919L6,159@6968L32,163@7111L89:BottomNavigation.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
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
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                j3 = j;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : 128;
        } else {
            j4 = j2;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 57344) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
                if ((46811 & i3) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i8 != 0) {
                            modifier3 = companion;
                            i4 = 57344;
                            j5 = j4;
                            m1547getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m1547getElevationD9Ej5fM();
                            i5 = 6;
                            long j8 = j3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(456489494, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:162)");
                            }
                            int i9 = i3 << 3;
                            composer2 = startRestartGroup;
                            m1549BottomNavigation_UMDTes(ZeroInsets, modifier3, j8, j5, m1547getElevationD9Ej5fM, function3, composer2, (i4 & i9) | i5 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (i9 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            j6 = j8;
                            j7 = j5;
                            f3 = m1547getElevationD9Ej5fM;
                        } else {
                            modifier3 = companion;
                            i4 = 57344;
                            j5 = j4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        i4 = 57344;
                        j5 = j4;
                        modifier3 = modifier2;
                    }
                    i5 = 6;
                    m1547getElevationD9Ej5fM = f2;
                    long j82 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i92 = i3 << 3;
                    composer2 = startRestartGroup;
                    m1549BottomNavigation_UMDTes(ZeroInsets, modifier3, j82, j5, m1547getElevationD9Ej5fM, function3, composer2, (i4 & i92) | i5 | (i92 & 112) | (i92 & 896) | (i92 & 7168) | (i92 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j6 = j82;
                    j7 = j5;
                    f3 = m1547getElevationD9Ej5fM;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier4 = modifier2;
                    j6 = j3;
                    j7 = j4;
                    f3 = f2;
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigation$3
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
                            BottomNavigationKt.m1548BottomNavigationPEIptTM(Modifier.this, j6, j7, f3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            if ((46811 & i3) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i8 != 0) {
            }
        }
        f2 = f;
        if ((i2 & 16) == 0) {
        }
        if ((46811 & i3) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i8 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca  */
    /* renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1550BottomNavigationItemjY6E1Zs(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z5;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        int i12;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        long j4;
        int i13;
        final boolean z6;
        int i14;
        final ComposableLambda composableLambda;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier4;
        final boolean z8;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)207@9524L39,208@9617L7,209@9709L6,220@10212L61,222@10279L804:BottomNavigation.kt#jmzs0o");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            z4 = z;
            i4 |= startRestartGroup.changed(z4) ? 32 : 16;
            if ((i3 & 2) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                function02 = function0;
                i4 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
                if ((i3 & 4) != 0) {
                    i4 |= 3072;
                } else if ((i & 7168) == 0) {
                    i4 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                }
                i5 = i3 & 8;
                if (i5 != 0) {
                    i4 |= 24576;
                } else if ((57344 & i) == 0) {
                    modifier2 = modifier;
                    i4 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    i6 = i3 & 16;
                    if (i6 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        z5 = z2;
                        i4 |= startRestartGroup.changed(z5) ? 131072 : 65536;
                        i7 = i3 & 32;
                        if (i7 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        }
                        i8 = i3 & 64;
                        if (i8 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            i4 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                        }
                        i9 = i3 & 128;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i & 1879048192) == 0) {
                            if ((i3 & 256) == 0) {
                                i10 = i9;
                                if (startRestartGroup.changed(j)) {
                                    i15 = 536870912;
                                    i4 |= i15;
                                }
                            } else {
                                i10 = i9;
                            }
                            i15 = 268435456;
                            i4 |= i15;
                        } else {
                            i10 = i9;
                        }
                        if ((i2 & 14) == 0) {
                            i11 = i10;
                            j3 = j2;
                            i12 = i2 | (((i3 & 512) == 0 && startRestartGroup.changed(j3)) ? 4 : 2);
                        } else {
                            j3 = j2;
                            i11 = i10;
                            i12 = i2;
                        }
                        int i16 = i12;
                        if ((i4 & 1533916891) == 306783378 || (i16 & 11) != 2 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i6 != 0) {
                                    z5 = true;
                                }
                                function23 = i7 != 0 ? null : function22;
                                boolean z9 = i8 != 0 ? true : z3;
                                if (i11 != 0) {
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
                                if ((i3 & 256) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    modifier3 = companion;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    j4 = ((Color) consume).m4073unboximpl();
                                    i4 &= -1879048193;
                                } else {
                                    modifier3 = companion;
                                    j4 = j;
                                }
                                if ((i3 & 512) != 0) {
                                    j3 = Color.m4062copywmQWz5c$default(j4, ContentAlpha.INSTANCE.getMedium(startRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i13 = i16 & (-15);
                                } else {
                                    i13 = i16;
                                }
                                z6 = z9;
                                modifier2 = modifier3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 256) != 0) {
                                    i4 &= -1879048193;
                                }
                                if ((i3 & 512) != 0) {
                                    function23 = function22;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    j4 = j;
                                    i13 = i16 & (-15);
                                    z6 = z3;
                                } else {
                                    function23 = function22;
                                    z6 = z3;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    j4 = j;
                                    i13 = i16;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1473735525, i4, i13, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:210)");
                            }
                            if (function23 != null) {
                                i14 = i13;
                                composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1343298261, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
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

                                    public final void invoke(Composer composer2, int i17) {
                                        ComposerKt.sourceInformation(composer2, "C213@9843L10,214@9909L40:BottomNavigation.kt#jmzs0o");
                                        if ((i17 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1343298261, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:213)");
                                            }
                                            TextKt.ProvideTextStyle(TextStyle.m5901copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6281getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function23, composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                            } else {
                                i14 = i13;
                                composableLambda = null;
                            }
                            Modifier modifier5 = modifier2;
                            Modifier weight$default = RowScope.weight$default(rowScope, SelectableKt.m1120selectableO2vRcR0(modifier5, z4, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i4 >> 21) & 896) | 6, 2), z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02), 1.0f, false, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            long j7 = j3;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
                            m1551BottomNavigationTransitionKlgxPg(j4, j7, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                                    invoke(f.floatValue(), composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f, Composer composer2, int i17) {
                                    ComposerKt.sourceInformation(composer2, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                                    if ((i17 & 14) == 0) {
                                        i17 |= composer2.changed(f) ? 4 : 2;
                                    }
                                    if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1411872801, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                                        }
                                        if (z6) {
                                            f = 1.0f;
                                        }
                                        BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, composableLambda, f, composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i14 << 3) & 112) | ((i4 << 3) & 896));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z6;
                            function24 = function23;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier2;
                            z8 = z5;
                            j5 = j4;
                            j6 = j7;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z8 = z5;
                            j6 = j3;
                            function24 = function22;
                            z7 = z3;
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            j5 = j;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
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

                                public final void invoke(Composer composer2, int i17) {
                                    BottomNavigationKt.m1550BottomNavigationItemjY6E1Zs(RowScope.this, z, function0, function2, modifier4, z8, function24, z7, mutableInteractionSource3, j5, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z5 = z2;
                    i7 = i3 & 32;
                    if (i7 != 0) {
                    }
                    i8 = i3 & 64;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 128;
                    if (i9 != 0) {
                    }
                    if ((i & 1879048192) == 0) {
                    }
                    if ((i2 & 14) == 0) {
                    }
                    int i162 = i12;
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) != 0) {
                    }
                    z6 = z9;
                    modifier2 = modifier3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (function23 != null) {
                    }
                    Modifier modifier52 = modifier2;
                    Modifier weight$default2 = RowScope.weight$default(rowScope, SelectableKt.m1120selectableO2vRcR0(modifier52, z4, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i4 >> 21) & 896) | 6, 2), z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02), 1.0f, false, 2, null);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    long j72 = j3;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default2);
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
                    m1551BottomNavigationTransitionKlgxPg(j4, j72, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                            invoke(f.floatValue(), composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f, Composer composer2, int i17) {
                            ComposerKt.sourceInformation(composer2, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                            if ((i17 & 14) == 0) {
                                i17 |= composer2.changed(f) ? 4 : 2;
                            }
                            if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1411872801, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                                }
                                if (z6) {
                                    f = 1.0f;
                                }
                                BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, composableLambda, f, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i14 << 3) & 112) | ((i4 << 3) & 896));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z7 = z6;
                    function24 = function23;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier2;
                    z8 = z5;
                    j5 = j4;
                    j6 = j72;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i6 = i3 & 16;
                if (i6 == 0) {
                }
                z5 = z2;
                i7 = i3 & 32;
                if (i7 != 0) {
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                }
                if ((i & 1879048192) == 0) {
                }
                if ((i2 & 14) == 0) {
                }
                int i1622 = i12;
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) != 0) {
                }
                z6 = z9;
                modifier2 = modifier3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (function23 != null) {
                }
                Modifier modifier522 = modifier2;
                Modifier weight$default22 = RowScope.weight$default(rowScope, SelectableKt.m1120selectableO2vRcR0(modifier522, z4, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i4 >> 21) & 896) | 6, 2), z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02), 1.0f, false, 2, null);
                Alignment center22 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                long j722 = j3;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(weight$default22);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
                m1551BottomNavigationTransitionKlgxPg(j4, j722, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                        invoke(f.floatValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, Composer composer2, int i17) {
                        ComposerKt.sourceInformation(composer2, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                        if ((i17 & 14) == 0) {
                            i17 |= composer2.changed(f) ? 4 : 2;
                        }
                        if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1411872801, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                            }
                            if (z6) {
                                f = 1.0f;
                            }
                            BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, composableLambda, f, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i14 << 3) & 112) | ((i4 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                z7 = z6;
                function24 = function23;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier2;
                z8 = z5;
                j5 = j4;
                j6 = j722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function02 = function0;
            if ((i3 & 4) != 0) {
            }
            i5 = i3 & 8;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            i6 = i3 & 16;
            if (i6 == 0) {
            }
            z5 = z2;
            i7 = i3 & 32;
            if (i7 != 0) {
            }
            i8 = i3 & 64;
            if (i8 != 0) {
            }
            i9 = i3 & 128;
            if (i9 != 0) {
            }
            if ((i & 1879048192) == 0) {
            }
            if ((i2 & 14) == 0) {
            }
            int i16222 = i12;
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) != 0) {
            }
            z6 = z9;
            modifier2 = modifier3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (function23 != null) {
            }
            Modifier modifier5222 = modifier2;
            Modifier weight$default222 = RowScope.weight$default(rowScope, SelectableKt.m1120selectableO2vRcR0(modifier5222, z4, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i4 >> 21) & 896) | 6, 2), z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02), 1.0f, false, 2, null);
            Alignment center222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
            long j7222 = j3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(weight$default222);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
            m1551BottomNavigationTransitionKlgxPg(j4, j7222, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                    invoke(f.floatValue(), composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, Composer composer2, int i17) {
                    ComposerKt.sourceInformation(composer2, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                    if ((i17 & 14) == 0) {
                        i17 |= composer2.changed(f) ? 4 : 2;
                    }
                    if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1411872801, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                        }
                        if (z6) {
                            f = 1.0f;
                        }
                        BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, composableLambda, f, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i14 << 3) & 112) | ((i4 << 3) & 896));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            z7 = z6;
            function24 = function23;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier4 = modifier2;
            z8 = z5;
            j5 = j4;
            j6 = j7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z4 = z;
        if ((i3 & 2) == 0) {
        }
        function02 = function0;
        if ((i3 & 4) != 0) {
        }
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 16;
        if (i6 == 0) {
        }
        z5 = z2;
        i7 = i3 & 32;
        if (i7 != 0) {
        }
        i8 = i3 & 64;
        if (i8 != 0) {
        }
        i9 = i3 & 128;
        if (i9 != 0) {
        }
        if ((i & 1879048192) == 0) {
        }
        if ((i2 & 14) == 0) {
        }
        int i162222 = i12;
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) != 0) {
        }
        z6 = z9;
        modifier2 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (function23 != null) {
        }
        Modifier modifier52222 = modifier2;
        Modifier weight$default2222 = RowScope.weight$default(rowScope, SelectableKt.m1120selectableO2vRcR0(modifier52222, z4, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, j4, startRestartGroup, ((i4 >> 21) & 896) | 6, 2), z5, Role.m5709boximpl(Role.INSTANCE.m5722getTabo7Vup1c()), function02), 1.0f, false, 2, null);
        Alignment center2222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
        long j72222 = j3;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(weight$default2222);
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
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1277961335, "C235@10656L421:BottomNavigation.kt#jmzs0o");
        m1551BottomNavigationTransitionKlgxPg(j4, j72222, z, ComposableLambdaKt.composableLambda(startRestartGroup, -1411872801, true, new Function3<Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Composer composer2, Integer num) {
                invoke(f.floatValue(), composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f, Composer composer2, int i17) {
                ComposerKt.sourceInformation(composer2, "C242@10886L181:BottomNavigation.kt#jmzs0o");
                if ((i17 & 14) == 0) {
                    i17 |= composer2.changed(f) ? 4 : 2;
                }
                if ((i17 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1411872801, i17, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:240)");
                    }
                    if (z6) {
                        f = 1.0f;
                    }
                    BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, composableLambda, f, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i14 << 3) & 112) | ((i4 << 3) & 896));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z6;
        function24 = function23;
        mutableInteractionSource3 = mutableInteractionSource2;
        modifier4 = modifier2;
        z8 = z5;
        j5 = j4;
        j6 = j72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1551BottomNavigationTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)288@12485L128,295@12688L181:BottomNavigation.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-985175058, i2, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:287)");
            }
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, null, startRestartGroup, 48, 28);
            long m4114lerpjxsXWHM = ColorKt.m4114lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(Color.m4062copywmQWz5c$default(m4114lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(m4114lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(startRestartGroup, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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
                    float BottomNavigationTransition_Klgx_Pg$lambda$3;
                    ComposerKt.sourceInformation(composer2, "C299@12837L26:BottomNavigation.kt#jmzs0o");
                    if ((i3 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-138092754, i3, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:299)");
                    }
                    Function3<Float, Composer, Integer, Unit> function32 = function3;
                    BottomNavigationTransition_Klgx_Pg$lambda$3 = BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$3(animateFloatAsState);
                    function32.invoke(Float.valueOf(BottomNavigationTransition_Klgx_Pg$lambda$3), composer2, 0);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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
                    BottomNavigationKt.m1551BottomNavigationTransitionKlgxPg(j, j2, z, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1162995092);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigationItemBaselineLayout)P(!1,2)320@13538L1211:BottomNavigation.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-1162995092, i2, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:319)");
            }
            startRestartGroup.startReplaceableGroup(-1545736730);
            boolean changedInstance = startRestartGroup.changedInstance(function22) | startRestartGroup.changed(f);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeable;
                        MeasureResult m1556placeLabelAndIconDIyivk0;
                        MeasureResult m1555placeIcon3p2s80s;
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
                                    m1555placeIcon3p2s80s = BottomNavigationKt.m1555placeIcon3p2s80s(measureScope, mo5333measureBRTryo0, j);
                                    return m1555placeIcon3p2s80s;
                                }
                                Intrinsics.checkNotNull(placeable2);
                                m1556placeLabelAndIconDIyivk0 = BottomNavigationKt.m1556placeLabelAndIconDIyivk0(measureScope, placeable2, mo5333measureBRTryo0, j, f);
                                return m1556placeLabelAndIconDIyivk0;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 620000090, "C322@13568L41:BottomNavigation.kt#jmzs0o");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1517371748, "C322@13601L6:BottomNavigation.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1198309649);
            ComposerKt.sourceInformation(startRestartGroup, "324@13659L253");
            if (function22 != null) {
                Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1517371446, "C329@13903L7:BottomNavigation.kt#jmzs0o");
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$3
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
                    BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, function22, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1555placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, measureScope.mo624roundToPx0680j_4(BottomNavigationHeight));
        final int height = (m6358constrainHeightK40F9xA - placeable.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), m6358constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, height, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1556placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        int i = measureScope.mo624roundToPx0680j_4(CombinedItemTextBaseline) - placeable.get(AlignmentLineKt.getFirstBaseline());
        int height = placeable2.getHeight() + placeable.getHeight() + i;
        int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, Math.max(height, measureScope.mo624roundToPx0680j_4(BottomNavigationHeight)));
        final int coerceAtLeast = RangesKt.coerceAtLeast((m6358constrainHeightK40F9xA - height) / 2, 0);
        int height2 = (m6358constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        final int height3 = placeable2.getHeight() + coerceAtLeast + i;
        int max = Math.max(placeable.getWidth(), placeable2.getWidth());
        final int width = (max - placeable.getWidth()) / 2;
        final int width2 = (max - placeable2.getWidth()) / 2;
        final int roundToInt = MathKt.roundToInt((height2 - coerceAtLeast) * (1 - f));
        return MeasureScope.layout$default(measureScope, max, m6358constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
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
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, height3 + roundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, coerceAtLeast + roundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 12;
        BottomNavigationItemHorizontalPadding = Dp.m6389constructorimpl(f);
        CombinedItemTextBaseline = Dp.m6389constructorimpl(f);
        float f2 = 0;
        ZeroInsets = WindowInsetsKt.m952WindowInsetsa9UjIt4(Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
