package io.adn.sdk.internal.ui.fullscreen.compose;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiState;
import io.adn.sdk.internal.ui.fullscreen.model.OverlayMode;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenAdViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenImageSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenPromotedAppCardViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenVideoSceneViewModel;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdScreen.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"FullscreenAdScreen", "", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenAdViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SceneContent", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenSceneViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdUiState;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdScreen$lambda$5(FullscreenAdViewModel fullscreenAdViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullscreenAdScreen(fullscreenAdViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SceneContent$lambda$7(FullscreenSceneViewModel fullscreenSceneViewModel, Modifier modifier, int i, Composer composer, int i2) {
        SceneContent(fullscreenSceneViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenAdScreen(final FullscreenAdViewModel viewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final State collectAsState;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        Object rememberedValue;
        FullscreenSceneViewModel fullscreenSceneViewModel;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(1096745012);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i3 & 19) == 18 || !startRestartGroup.getSkipping()) {
                Modifier modifier3 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1096745012, i3, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreen (FullscreenAdScreen.kt:29)");
                }
                collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
                Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), FullscreenAdScreen$lambda$0(collectAsState).m9586getBackgroundColor0d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m527backgroundbw27NRU$default);
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
                int activeSceneIndex = FullscreenAdScreen$lambda$0(collectAsState).getActiveSceneIndex();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(FullscreenAdScreen$lambda$0(collectAsState).getOverlayMode() != OverlayMode.Blurred ? BlurKt.m3718blurF8QBwvs$default(Modifier.INSTANCE, Dp.m6389constructorimpl(12), null, 2, null) : Modifier.INSTANCE);
                Integer valueOf = Integer.valueOf(activeSceneIndex);
                startRestartGroup.startReplaceableGroup(-418146053);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            ContentTransform FullscreenAdScreen$lambda$4$lambda$2$lambda$1;
                            FullscreenAdScreen$lambda$4$lambda$2$lambda$1 = FullscreenAdScreenKt.FullscreenAdScreen$lambda$4$lambda$2$lambda$1((AnimatedContentTransitionScope) obj);
                            return FullscreenAdScreen$lambda$4$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier modifier4 = modifier3;
                AnimatedContentKt.AnimatedContent(valueOf, then, (Function1) rememberedValue, null, "", null, ComposableLambdaKt.composableLambda(startRestartGroup, 2136544900, true, new Function4<AnimatedContentScope, Integer, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt$FullscreenAdScreen$1$2
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Integer num, Composer composer2, Integer num2) {
                        invoke(animatedContentScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope AnimatedContent, int i5, Composer composer2, int i6) {
                        FullscreenAdUiState FullscreenAdScreen$lambda$0;
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2136544900, i6, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreen.<anonymous>.<anonymous> (FullscreenAdScreen.kt:48)");
                        }
                        FullscreenSceneViewModel fullscreenSceneViewModel2 = (FullscreenSceneViewModel) CollectionsKt.getOrNull(FullscreenAdViewModel.this.getSceneViewModels(), i5);
                        if (fullscreenSceneViewModel2 != null) {
                            State<FullscreenAdUiState> state = collectAsState;
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            FullscreenAdScreen$lambda$0 = FullscreenAdScreenKt.FullscreenAdScreen$lambda$0(state);
                            FullscreenAdScreenKt.SceneContent(fullscreenSceneViewModel2, BackgroundKt.m527backgroundbw27NRU$default(fillMaxSize$default, FullscreenAdScreen$lambda$0.m9586getBackgroundColor0d7_KjU(), null, 2, null), composer2, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 1597824, 40);
                startRestartGroup.startReplaceableGroup(-418122530);
                if (FullscreenAdScreen$lambda$0(collectAsState).getOverlayMode() != OverlayMode.None && (fullscreenSceneViewModel = (FullscreenSceneViewModel) CollectionsKt.getOrNull(viewModel.getSceneViewModels(), FullscreenAdScreen$lambda$0(collectAsState).getOverlaySceneIndex())) != null) {
                    SceneContent(fullscreenSceneViewModel, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), startRestartGroup, 48);
                }
                startRestartGroup.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FullscreenAdScreen$lambda$5;
                        FullscreenAdScreen$lambda$5 = FullscreenAdScreenKt.FullscreenAdScreen$lambda$5(FullscreenAdViewModel.this, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return FullscreenAdScreen$lambda$5;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i3 & 19) == 18) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
        Modifier m527backgroundbw27NRU$default2 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), FullscreenAdScreen$lambda$0(collectAsState).m9586getBackgroundColor0d7_KjU(), null, 2, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m527backgroundbw27NRU$default2);
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
        int activeSceneIndex2 = FullscreenAdScreen$lambda$0(collectAsState).getActiveSceneIndex();
        Modifier then2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(FullscreenAdScreen$lambda$0(collectAsState).getOverlayMode() != OverlayMode.Blurred ? BlurKt.m3718blurF8QBwvs$default(Modifier.INSTANCE, Dp.m6389constructorimpl(12), null, 2, null) : Modifier.INSTANCE);
        Integer valueOf2 = Integer.valueOf(activeSceneIndex2);
        startRestartGroup.startReplaceableGroup(-418146053);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        Modifier modifier42 = modifier3;
        AnimatedContentKt.AnimatedContent(valueOf2, then2, (Function1) rememberedValue, null, "", null, ComposableLambdaKt.composableLambda(startRestartGroup, 2136544900, true, new Function4<AnimatedContentScope, Integer, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt$FullscreenAdScreen$1$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Integer num, Composer composer2, Integer num2) {
                invoke(animatedContentScope, num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedContentScope AnimatedContent, int i5, Composer composer2, int i6) {
                FullscreenAdUiState FullscreenAdScreen$lambda$0;
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2136544900, i6, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreen.<anonymous>.<anonymous> (FullscreenAdScreen.kt:48)");
                }
                FullscreenSceneViewModel fullscreenSceneViewModel2 = (FullscreenSceneViewModel) CollectionsKt.getOrNull(FullscreenAdViewModel.this.getSceneViewModels(), i5);
                if (fullscreenSceneViewModel2 != null) {
                    State<FullscreenAdUiState> state = collectAsState;
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    FullscreenAdScreen$lambda$0 = FullscreenAdScreenKt.FullscreenAdScreen$lambda$0(state);
                    FullscreenAdScreenKt.SceneContent(fullscreenSceneViewModel2, BackgroundKt.m527backgroundbw27NRU$default(fillMaxSize$default, FullscreenAdScreen$lambda$0.m9586getBackgroundColor0d7_KjU(), null, 2, null), composer2, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 1597824, 40);
        startRestartGroup.startReplaceableGroup(-418122530);
        if (FullscreenAdScreen$lambda$0(collectAsState).getOverlayMode() != OverlayMode.None) {
            SceneContent(fullscreenSceneViewModel, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), startRestartGroup, 48);
        }
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier42;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform FullscreenAdScreen$lambda$4$lambda$2$lambda$1(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(1000, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SceneContent(final FullscreenSceneViewModel fullscreenSceneViewModel, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-864919446);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(fullscreenSceneViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-864919446, i2, -1, "io.adn.sdk.internal.ui.fullscreen.compose.SceneContent (FullscreenAdScreen.kt:74)");
            }
            Modifier noClickable = ComposeKt.noClickable(modifier);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(noClickable);
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
            if (fullscreenSceneViewModel instanceof FullscreenHtmlSceneViewModel) {
                startRestartGroup.startReplaceableGroup(486188468);
                FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen((FullscreenHtmlSceneViewModel) fullscreenSceneViewModel, null, startRestartGroup, 0, 2);
                startRestartGroup.endReplaceableGroup();
            } else if (fullscreenSceneViewModel instanceof FullscreenImageSceneViewModel) {
                startRestartGroup.startReplaceableGroup(486191637);
                FullscreenAdImageScreenKt.FullscreenAdImageScreen((FullscreenImageSceneViewModel) fullscreenSceneViewModel, null, startRestartGroup, 0, 2);
                startRestartGroup.endReplaceableGroup();
            } else if (fullscreenSceneViewModel instanceof FullscreenVideoSceneViewModel) {
                startRestartGroup.startReplaceableGroup(486194926);
                FullscreenAdVideoScreenKt.FullscreenAdVideoScreen((FullscreenVideoSceneViewModel) fullscreenSceneViewModel, true, null, startRestartGroup, 48, 4);
                startRestartGroup.endReplaceableGroup();
            } else if (fullscreenSceneViewModel instanceof FullscreenPromotedAppCardViewModel) {
                startRestartGroup.startReplaceableGroup(486201049);
                FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard((FullscreenPromotedAppCardViewModel) fullscreenSceneViewModel, null, startRestartGroup, 0, 2);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-2107590225);
                startRestartGroup.endReplaceableGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SceneContent$lambda$7;
                    SceneContent$lambda$7 = FullscreenAdScreenKt.SceneContent$lambda$7(FullscreenSceneViewModel.this, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SceneContent$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FullscreenAdUiState FullscreenAdScreen$lambda$0(State<FullscreenAdUiState> state) {
        return state.getValue();
    }
}
