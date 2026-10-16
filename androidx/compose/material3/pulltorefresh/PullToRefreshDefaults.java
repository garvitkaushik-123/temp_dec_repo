package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "()V", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "Indicator", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Indicator-FNF3uiM", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();
    private static final float PositionalThreshold = Dp.m6389constructorimpl(80);

    private PullToRefreshDefaults() {
    }

    public final Shape getShape() {
        return shape;
    }

    public final long getContainerColor(Composer composer, int i) {
        composer.startReplaceableGroup(1066257972);
        ComposerKt.sourceInformation(composer, "C150@6323L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:150)");
        }
        long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return surfaceContainerHigh;
    }

    public final long getContentColor(Composer composer, int i) {
        composer.startReplaceableGroup(813427380);
        ComposerKt.sourceInformation(composer, "C153@6487L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(813427380, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-contentColor> (PullToRefresh.kt:153)");
        }
        long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnSurfaceVariant();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return onSurfaceVariant;
    }

    /* renamed from: getPositionalThreshold-D9Ej5fM, reason: not valid java name */
    public final float m2947getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005c  */
    /* renamed from: Indicator-FNF3uiM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2946IndicatorFNF3uiM(final PullToRefreshState pullToRefreshState, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        final Modifier.Companion companion;
        final long m4073unboximpl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1160852333);
        ComposerKt.sourceInformation(startRestartGroup, "C(Indicator)P(2,1,0:c#ui.graphics.Color)165@6853L7,167@6878L781:PullToRefresh.kt#djiw08");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                j2 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
            } else {
                j2 = j;
            }
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        m4073unboximpl = ((Color) consume).m4073unboximpl();
                        i3 &= -897;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1160852333, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:166)");
                        }
                        CrossfadeKt.Crossfade(Boolean.valueOf(pullToRefreshState.isRefreshing()), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1378661396, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer2, Integer num) {
                                invoke(bool.booleanValue(), composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z, Composer composer2, int i5) {
                                Composer composer3;
                                float f;
                                ComposerKt.sourceInformation(composer2, "C171@7045L604:PullToRefresh.kt#djiw08");
                                if ((i5 & 6) == 0) {
                                    i5 |= composer2.changed(z) ? 4 : 2;
                                }
                                if ((i5 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1378661396, i5, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:171)");
                                    }
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    long j3 = m4073unboximpl;
                                    final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1849687653, "C:PullToRefresh.kt#djiw08");
                                    if (z) {
                                        composer2.startReplaceableGroup(-1849687637);
                                        ComposerKt.sourceInformation(composer2, "176@7223L201");
                                        f = PullToRefreshKt.StrokeWidth;
                                        composer3 = composer2;
                                        ProgressIndicatorKt.m2400CircularProgressIndicatorLxG7B9w(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, PullToRefreshKt.getSpinnerSize()), j3, f, 0L, 0, composer3, 390, 24);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3 = composer2;
                                        composer3.startReplaceableGroup(-1849687390);
                                        ComposerKt.sourceInformation(composer3, "183@7537L18,182@7470L147");
                                        composer3.startReplaceableGroup(-1849687301);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):PullToRefresh.kt#9igjgp");
                                        boolean changed = composer3.changed(pullToRefreshState2);
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Float invoke() {
                                                    return Float.valueOf(PullToRefreshState.this.getProgress());
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue);
                                        }
                                        composer3.endReplaceableGroup();
                                        PullToRefreshKt.m2948CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j3, composer3, 0);
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
                        }), startRestartGroup, 24960, 10);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                }
                m4073unboximpl = j2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                CrossfadeKt.Crossfade(Boolean.valueOf(pullToRefreshState.isRefreshing()), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1378661396, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer2, Integer num) {
                        invoke(bool.booleanValue(), composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z, Composer composer2, int i5) {
                        Composer composer3;
                        float f;
                        ComposerKt.sourceInformation(composer2, "C171@7045L604:PullToRefresh.kt#djiw08");
                        if ((i5 & 6) == 0) {
                            i5 |= composer2.changed(z) ? 4 : 2;
                        }
                        if ((i5 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1378661396, i5, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:171)");
                            }
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            long j3 = m4073unboximpl;
                            final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1849687653, "C:PullToRefresh.kt#djiw08");
                            if (z) {
                                composer2.startReplaceableGroup(-1849687637);
                                ComposerKt.sourceInformation(composer2, "176@7223L201");
                                f = PullToRefreshKt.StrokeWidth;
                                composer3 = composer2;
                                ProgressIndicatorKt.m2400CircularProgressIndicatorLxG7B9w(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, PullToRefreshKt.getSpinnerSize()), j3, f, 0L, 0, composer3, 390, 24);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3 = composer2;
                                composer3.startReplaceableGroup(-1849687390);
                                ComposerKt.sourceInformation(composer3, "183@7537L18,182@7470L147");
                                composer3.startReplaceableGroup(-1849687301);
                                ComposerKt.sourceInformation(composer3, "CC(remember):PullToRefresh.kt#9igjgp");
                                boolean changed = composer3.changed(pullToRefreshState2);
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(PullToRefreshState.this.getProgress());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                PullToRefreshKt.m2948CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j3, composer3, 0);
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
                }), startRestartGroup, 24960, 10);
                if (ComposerKt.isTraceInProgress()) {
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                m4073unboximpl = j2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        PullToRefreshDefaults.this.m2946IndicatorFNF3uiM(pullToRefreshState, companion, m4073unboximpl, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i3 & 147) == 146) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        m4073unboximpl = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        CrossfadeKt.Crossfade(Boolean.valueOf(pullToRefreshState.isRefreshing()), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1378661396, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer2, Integer num) {
                invoke(bool.booleanValue(), composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, Composer composer2, int i5) {
                Composer composer3;
                float f;
                ComposerKt.sourceInformation(composer2, "C171@7045L604:PullToRefresh.kt#djiw08");
                if ((i5 & 6) == 0) {
                    i5 |= composer2.changed(z) ? 4 : 2;
                }
                if ((i5 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1378661396, i5, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:171)");
                    }
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    long j3 = m4073unboximpl;
                    final PullToRefreshState pullToRefreshState2 = pullToRefreshState;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1849687653, "C:PullToRefresh.kt#djiw08");
                    if (z) {
                        composer2.startReplaceableGroup(-1849687637);
                        ComposerKt.sourceInformation(composer2, "176@7223L201");
                        f = PullToRefreshKt.StrokeWidth;
                        composer3 = composer2;
                        ProgressIndicatorKt.m2400CircularProgressIndicatorLxG7B9w(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, PullToRefreshKt.getSpinnerSize()), j3, f, 0L, 0, composer3, 390, 24);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-1849687390);
                        ComposerKt.sourceInformation(composer3, "183@7537L18,182@7470L147");
                        composer3.startReplaceableGroup(-1849687301);
                        ComposerKt.sourceInformation(composer3, "CC(remember):PullToRefresh.kt#9igjgp");
                        boolean changed = composer3.changed(pullToRefreshState2);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$Indicator$1$1$1$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(PullToRefreshState.this.getProgress());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        PullToRefreshKt.m2948CircularArrowProgressIndicatorRPmYEkk((Function0) rememberedValue, j3, composer3, 0);
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
        }), startRestartGroup, 24960, 10);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
