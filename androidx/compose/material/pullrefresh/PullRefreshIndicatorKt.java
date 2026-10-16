package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicator.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aJ\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a>\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", NotificationCompat.CATEGORY_PROGRESS, "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float IndicatorSize = Dp.m6389constructorimpl(40);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m6389constructorimpl((float) 7.5d);
    private static final float StrokeWidth = Dp.m6389constructorimpl((float) 2.5d);
    private static final float ArrowWidth = Dp.m6389constructorimpl(10);
    private static final float ArrowHeight = Dp.m6389constructorimpl(5);
    private static final float Elevation = Dp.m6389constructorimpl(6);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m1856PullRefreshIndicatorjB83MbM(boolean z, final PullRefreshState pullRefreshState, Modifier modifier, long j, long j2, boolean z2, Composer composer, int i, final int i2) {
        int i3;
        long j3;
        int i4;
        final long j4;
        final boolean z3;
        long j5;
        Color m4053boximpl;
        Composer startRestartGroup = composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation(startRestartGroup, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)78@3382L6,79@3424L32,82@3514L98,89@3897L7,93@4025L1067:PullRefreshIndicator.kt#t44y28");
        Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
            i3 = i;
            i4 = i3 & (-7169);
        } else {
            i3 = i;
            j3 = j;
            i4 = i3;
        }
        if ((i2 & 16) != 0) {
            long m1621contentColorForek8zF_U = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 9) & 14);
            i4 &= -57345;
            j4 = m1621contentColorForek8zF_U;
        } else {
            j4 = j2;
        }
        boolean z4 = (i2 & 32) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, i4, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:81)");
        }
        Boolean valueOf = Boolean.valueOf(z);
        int i5 = i4 & 14;
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(pullRefreshState);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            z3 = z;
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(z3 || pullRefreshState.getPosition$material_release() > 0.5f);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue);
        } else {
            z3 = z;
        }
        startRestartGroup.endReplaceableGroup();
        State state = (State) rememberedValue;
        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(localElevationOverlay);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ElevationOverlay elevationOverlay = (ElevationOverlay) consume;
        startRestartGroup.startReplaceableGroup(52228748);
        ComposerKt.sourceInformation(startRestartGroup, "90@3939L53");
        if (elevationOverlay == null) {
            m4053boximpl = null;
            j5 = j3;
        } else {
            long j6 = j3;
            j5 = j6;
            m4053boximpl = Color.m4053boximpl(elevationOverlay.mo1643apply7g2Lkgo(j6, Elevation, startRestartGroup, ((i4 >> 9) & 14) | 48));
        }
        startRestartGroup.endReplaceableGroup();
        long m4073unboximpl = m4053boximpl != null ? m4053boximpl.m4073unboximpl() : j5;
        Modifier pullRefreshIndicatorTransform = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.m928size3ABfNKs(companion, IndicatorSize), pullRefreshState, z4);
        float m6389constructorimpl = PullRefreshIndicator_jB83MbM$lambda$1(state) ? Elevation : Dp.m6389constructorimpl(0);
        RoundedCornerShape roundedCornerShape = SpinnerShape;
        Modifier m526backgroundbw27NRU = BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(pullRefreshIndicatorTransform, m6389constructorimpl, roundedCornerShape, true, 0L, 0L, 24, null), m4073unboximpl, roundedCornerShape);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1406369954, "C100@4312L774:PullRefreshIndicator.kt#t44y28");
        CrossfadeKt.Crossfade(Boolean.valueOf(z3), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1853731063, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer2, Integer num) {
                invoke(bool.booleanValue(), composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z5, Composer composer2, int i6) {
                float f;
                float f2;
                Composer composer3;
                float f3;
                ComposerKt.sourceInformation(composer2, "C104@4471L605:PullRefreshIndicator.kt#t44y28");
                if ((i6 & 14) == 0) {
                    i6 |= composer2.changed(z5) ? 4 : 2;
                }
                if ((i6 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1853731063, i6, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:104)");
                    }
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    long j7 = j4;
                    PullRefreshState pullRefreshState2 = pullRefreshState;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -2035147121, "C:PullRefreshIndicator.kt#t44y28");
                    f = PullRefreshIndicatorKt.ArcRadius;
                    f2 = PullRefreshIndicatorKt.StrokeWidth;
                    float m6389constructorimpl2 = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f + f2) * 2);
                    if (z5) {
                        composer2.startReplaceableGroup(-2035147035);
                        ComposerKt.sourceInformation(composer2, "111@4719L208");
                        f3 = PullRefreshIndicatorKt.StrokeWidth;
                        ProgressIndicatorKt.m1727CircularProgressIndicatorLxG7B9w(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, m6389constructorimpl2), j7, f3, 0L, 0, composer2, 390, 24);
                        composer3 = composer2;
                        composer3.endReplaceableGroup();
                    } else {
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-2035146781);
                        ComposerKt.sourceInformation(composer3, "117@4973L71");
                        PullRefreshIndicatorKt.m1855CircularArrowIndicatoriJQMabo(pullRefreshState2, j7, SizeKt.m928size3ABfNKs(Modifier.INSTANCE, m6389constructorimpl2), composer3, 392);
                        composer3.endReplaceableGroup();
                    }
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
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, i5 | 24960, 10);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final int i6 = i3;
            final long j7 = j4;
            final boolean z5 = z4;
            final long j8 = j5;
            final Modifier modifier2 = companion;
            final boolean z6 = z3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    PullRefreshIndicatorKt.m1856PullRefreshIndicatorjB83MbM(z6, pullRefreshState, modifier2, j8, j7, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m1855CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)134@5303L61,136@5389L119,142@5531L74,145@5644L1000:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            i2 = i;
            ComposerKt.traceEventStart(-486016981, i2, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:133)");
        } else {
            i2 = i;
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        Object obj = rememberedValue;
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            Path Path = AndroidPath_androidKt.Path();
            Path.mo3956setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4345getEvenOddRgk1Os());
            startRestartGroup.updateRememberedValue(Path);
            obj = Path;
        }
        startRestartGroup.endReplaceableGroup();
        final Path path = (Path) obj;
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(pullRefreshState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(PullRefreshState.this.getProgress() < 1.0f ? 0.3f : 1.0f);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$6((State) rememberedValue2), AlphaTween, 0.0f, null, null, startRestartGroup, 48, 28);
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
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
                ArrowValues ArrowValues;
                float f;
                float f2;
                float f3;
                ArrowValues = PullRefreshIndicatorKt.ArrowValues(PullRefreshState.this.getProgress());
                float floatValue = animateFloatAsState.getValue().floatValue();
                float rotation = ArrowValues.getRotation();
                long j2 = j;
                Path path2 = path;
                long mo4611getCenterF1C5BW0 = drawScope.mo4611getCenterF1C5BW0();
                DrawContext drawContext = drawScope.getDrawContext();
                long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo4543rotateUv8p0NA(rotation, mo4611getCenterF1C5BW0);
                f = PullRefreshIndicatorKt.ArcRadius;
                float f4 = drawScope.mo630toPx0680j_4(f);
                f2 = PullRefreshIndicatorKt.StrokeWidth;
                float f5 = f4 + (drawScope.mo630toPx0680j_4(f2) / 2.0f);
                Rect rect = new Rect(Offset.m3822getXimpl(androidx.compose.ui.geometry.SizeKt.m3901getCenteruvyYCjk(drawScope.mo4612getSizeNHjbRc())) - f5, Offset.m3823getYimpl(androidx.compose.ui.geometry.SizeKt.m3901getCenteruvyYCjk(drawScope.mo4612getSizeNHjbRc())) - f5, Offset.m3822getXimpl(androidx.compose.ui.geometry.SizeKt.m3901getCenteruvyYCjk(drawScope.mo4612getSizeNHjbRc())) + f5, Offset.m3823getYimpl(androidx.compose.ui.geometry.SizeKt.m3901getCenteruvyYCjk(drawScope.mo4612getSizeNHjbRc())) + f5);
                float startAngle = ArrowValues.getStartAngle();
                float endAngle = ArrowValues.getEndAngle() - ArrowValues.getStartAngle();
                long m3857getTopLeftF1C5BW0 = rect.m3857getTopLeftF1C5BW0();
                long m3855getSizeNHjbRc = rect.m3855getSizeNHjbRc();
                f3 = PullRefreshIndicatorKt.StrokeWidth;
                DrawScope.m4592drawArcyD3GUKo$default(drawScope, j2, startAngle, endAngle, false, m3857getTopLeftF1C5BW0, m3855getSizeNHjbRc, floatValue, new Stroke(drawScope.mo630toPx0680j_4(f3), 0.0f, StrokeCap.INSTANCE.m4417getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                PullRefreshIndicatorKt.m1859drawArrowBx497Mc(drawScope, path2, rect, j2, floatValue, ArrowValues);
                drawContext.getCanvas().restore();
                drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
            }
        }, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final int i3 = i2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
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
                    PullRefreshIndicatorKt.m1855CircularArrowIndicatoriJQMabo(PullRefreshState.this, j, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 0.25f) + (coerceIn - (((float) Math.pow(coerceIn, 2)) / 4))) * 0.5f;
        float f2 = 360;
        return new ArrowValues(pow, pow * f2, ((MaxProgressArc * max) + pow) * f2, Math.min(1.0f, max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    public static final void m1859drawArrowBx497Mc(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f2 = ArrowWidth;
        path.lineTo(drawScope.mo630toPx0680j_4(f2) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo630toPx0680j_4(f2) * arrowValues.getScale()) / 2, drawScope.mo630toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.mo3958translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m3822getXimpl(rect.m3852getCenterF1C5BW0())) - ((drawScope.mo630toPx0680j_4(f2) * arrowValues.getScale()) / 2.0f), Offset.m3823getYimpl(rect.m3852getCenterF1C5BW0()) + (drawScope.mo630toPx0680j_4(StrokeWidth) / 2.0f)));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long mo4611getCenterF1C5BW0 = drawScope.mo4611getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo4543rotateUv8p0NA(endAngle, mo4611getCenterF1C5BW0);
        DrawScope.m4603drawPathLG529CI$default(drawScope, path, j, f, null, null, 0, 56, null);
        drawContext.getCanvas().restore();
        drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}
