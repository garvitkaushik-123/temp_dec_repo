package io.adn.sdk.internal.ui.fullscreen.compose;

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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImageKt;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenImageSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.publisher.AdnClickElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdImageScreen.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"FullscreenAdImageScreen", "", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenImageSceneViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenImageSceneViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Image;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdImageScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$19(FullscreenImageSceneViewModel fullscreenImageSceneViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullscreenAdImageScreen(fullscreenImageSceneViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenAdImageScreen(final FullscreenImageSceneViewModel viewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        FullscreenAdSceneConfig.Image config;
        SceneAsset.Media asset;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int i4;
        State state;
        Modifier modifier3;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        PromotedAppUiState promotedAppUiState;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        boolean changedInstance3;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(765732220);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changedInstance(viewModel) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i3 & 19) == 18 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(765732220, i3, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreen (FullscreenAdImageScreen.kt:24)");
                }
                State collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
                config = FullscreenAdImageScreen$lambda$0(collectAsState).getConfig();
                PromotedAppUiState promotedAppUiState2 = FullscreenAdImageScreen$lambda$0(collectAsState).getPromotedAppUiState();
                asset = FullscreenAdImageScreen$lambda$0(collectAsState).getAsset();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1800236341);
                if (asset == null) {
                    File file = asset.getResource().getFile();
                    ContentScale crop = ContentScale.INSTANCE.getCrop();
                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    startRestartGroup.startReplaceableGroup(-1800224864);
                    boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$2$lambda$1;
                                FullscreenAdImageScreen$lambda$18$lambda$2$lambda$1 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$2$lambda$1(FullscreenImageSceneViewModel.this, (AsyncImagePainter.State.Success) obj);
                                return FullscreenAdImageScreen$lambda$18$lambda$2$lambda$1;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    Function1 function1 = (Function1) rememberedValue4;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1800228088);
                    boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$4$lambda$3;
                                FullscreenAdImageScreen$lambda$18$lambda$4$lambda$3 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$4$lambda$3(FullscreenImageSceneViewModel.this, (AsyncImagePainter.State.Error) obj);
                                return FullscreenAdImageScreen$lambda$18$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier3 = companion;
                    i4 = 0;
                    state = collectAsState;
                    boxScopeInstance = boxScopeInstance2;
                    SingletonAsyncImageKt.m6741AsyncImageVb_qNX0(file, null, fillMaxSize$default2, null, null, null, null, function1, (Function1) rememberedValue5, null, crop, 0.0f, null, 0, false, null, startRestartGroup, 432, 6, 64120);
                    composer2 = startRestartGroup;
                } else {
                    i4 = 0;
                    state = collectAsState;
                    modifier3 = companion;
                    boxScopeInstance = boxScopeInstance2;
                    composer2 = startRestartGroup;
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1800221488);
                if (FullscreenAdImageScreen$lambda$0(state).isRedirectionEnabled()) {
                    Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                    AdnClickElement.MainMedia mainMedia = AdnClickElement.MainMedia.INSTANCE;
                    composer2.startReplaceableGroup(-1800215405);
                    boolean changedInstance6 = composer2.changedInstance(viewModel);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function3() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$6$lambda$5;
                                FullscreenAdImageScreen$lambda$18$lambda$6$lambda$5 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$6$lambda$5(FullscreenImageSceneViewModel.this, (AdnClickElement) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                                return FullscreenAdImageScreen$lambda$18$lambda$6$lambda$5;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    BoxKt.Box(ComposeKt.clickWithCoordinates(matchParentSize, mainMedia, false, (Function3) rememberedValue6, composer2, 48, 2), composer2, i4);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1800210628);
                if (config.getPrivacyConfig().getEnabled()) {
                    AdPrivacyConfig privacyConfig = config.getPrivacyConfig();
                    composer2.startReplaceableGroup(-1800206425);
                    boolean changedInstance7 = composer2.changedInstance(viewModel);
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$8$lambda$7;
                                FullscreenAdImageScreen$lambda$18$lambda$8$lambda$7 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$8$lambda$7(FullscreenImageSceneViewModel.this);
                                return FullscreenAdImageScreen$lambda$18$lambda$8$lambda$7;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    PrivacyButtonKt.privacyButton(privacyConfig, (Function0) rememberedValue7, composer2, i4).invoke(boxScopeInstance, composer2, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1800204267);
                if (config.getCtaConfig().getEnabled()) {
                    promotedAppUiState = promotedAppUiState2;
                } else {
                    AdCtaConfig ctaConfig = config.getCtaConfig();
                    composer2.startReplaceableGroup(-1800198899);
                    boolean changedInstance8 = composer2.changedInstance(viewModel);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (changedInstance8 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$10$lambda$9;
                                FullscreenAdImageScreen$lambda$18$lambda$10$lambda$9 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$10$lambda$9(FullscreenImageSceneViewModel.this);
                                return FullscreenAdImageScreen$lambda$18$lambda$10$lambda$9;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue8);
                    }
                    composer2.endReplaceableGroup();
                    promotedAppUiState = promotedAppUiState2;
                    CTAButtonKt.ctaButton(ctaConfig, promotedAppUiState2, (Function0) rememberedValue8, composer2, 0, 0).invoke(boxScopeInstance, composer2, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1800195936);
                if (config.getStoreConfig().getEnabled() && promotedAppUiState != null) {
                    AdCtaConfig ctaConfig2 = config.getCtaConfig();
                    double delay = config.getStoreConfig().getDelay();
                    boolean dismissable = config.getStoreConfig().getDismissable();
                    composer2.startReplaceableGroup(1132574517);
                    changedInstance3 = composer2.changedInstance(viewModel);
                    rememberedValue3 = composer2.rememberedValue();
                    if (!changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                                FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11(FullscreenImageSceneViewModel.this);
                                return FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    StoreOverlayKt.storeOverlay(delay, dismissable, (Function0) rememberedValue3, null, null, null, promotedAppUiState, ctaConfig2, composer2, 0, 56).invoke(boxScopeInstance, composer2, 6);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                AdCloseConfig effectiveCloseConfig = FullscreenAdImageScreen$lambda$0(state).getEffectiveCloseConfig();
                composer2.startReplaceableGroup(-1800178024);
                changedInstance = composer2.changedInstance(viewModel);
                rememberedValue = composer2.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14;
                            FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14(FullscreenImageSceneViewModel.this);
                            return FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer2.endReplaceableGroup();
                int effectiveCloseIcon = FullscreenAdImageScreen$lambda$0(state).getEffectiveCloseIcon();
                composer2.startReplaceableGroup(-1800174609);
                changedInstance2 = composer2.changedInstance(viewModel);
                rememberedValue2 = composer2.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16;
                            FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16(FullscreenImageSceneViewModel.this);
                            return FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceableGroup();
                CloseButtonKt.closeButton(effectiveCloseConfig, function0, effectiveCloseIcon, (Function0) rememberedValue2, composer2, 0, 0).invoke(boxScopeInstance, composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FullscreenAdImageScreen$lambda$19;
                        FullscreenAdImageScreen$lambda$19 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$19(FullscreenImageSceneViewModel.this, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return FullscreenAdImageScreen$lambda$19;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i3 & 19) == 18) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        State collectAsState2 = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
        config = FullscreenAdImageScreen$lambda$0(collectAsState2).getConfig();
        PromotedAppUiState promotedAppUiState22 = FullscreenAdImageScreen$lambda$0(collectAsState2).getPromotedAppUiState();
        asset = FullscreenAdImageScreen$lambda$0(collectAsState2).getAsset();
        Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxSize$default3);
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
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1800236341);
        if (asset == null) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1800221488);
        if (FullscreenAdImageScreen$lambda$0(state).isRedirectionEnabled()) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1800210628);
        if (config.getPrivacyConfig().getEnabled()) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1800204267);
        if (config.getCtaConfig().getEnabled()) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1800195936);
        if (config.getStoreConfig().getEnabled()) {
            AdCtaConfig ctaConfig22 = config.getCtaConfig();
            double delay2 = config.getStoreConfig().getDelay();
            boolean dismissable2 = config.getStoreConfig().getDismissable();
            composer2.startReplaceableGroup(1132574517);
            changedInstance3 = composer2.changedInstance(viewModel);
            rememberedValue3 = composer2.rememberedValue();
            if (!changedInstance3) {
            }
            rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                    FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11(FullscreenImageSceneViewModel.this);
                    return FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                }
            };
            composer2.updateRememberedValue(rememberedValue3);
            composer2.endReplaceableGroup();
            StoreOverlayKt.storeOverlay(delay2, dismissable2, (Function0) rememberedValue3, null, null, null, promotedAppUiState, ctaConfig22, composer2, 0, 56).invoke(boxScopeInstance, composer2, 6);
            Unit unit3 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        }
        composer2.endReplaceableGroup();
        AdCloseConfig effectiveCloseConfig2 = FullscreenAdImageScreen$lambda$0(state).getEffectiveCloseConfig();
        composer2.startReplaceableGroup(-1800178024);
        changedInstance = composer2.changedInstance(viewModel);
        rememberedValue = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14;
                FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14(FullscreenImageSceneViewModel.this);
                return FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14;
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        Function0 function02 = (Function0) rememberedValue;
        composer2.endReplaceableGroup();
        int effectiveCloseIcon2 = FullscreenAdImageScreen$lambda$0(state).getEffectiveCloseIcon();
        composer2.startReplaceableGroup(-1800174609);
        changedInstance2 = composer2.changedInstance(viewModel);
        rememberedValue2 = composer2.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdImageScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16;
                FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16 = FullscreenAdImageScreenKt.FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16(FullscreenImageSceneViewModel.this);
                return FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        composer2.endReplaceableGroup();
        CloseButtonKt.closeButton(effectiveCloseConfig2, function02, effectiveCloseIcon2, (Function0) rememberedValue2, composer2, 0, 0).invoke(boxScopeInstance, composer2, 6);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$4$lambda$3(FullscreenImageSceneViewModel fullscreenImageSceneViewModel, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fullscreenImageSceneViewModel.onError(ComposeKt.message(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$2$lambda$1(FullscreenImageSceneViewModel fullscreenImageSceneViewModel, AsyncImagePainter.State.Success it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fullscreenImageSceneViewModel.onDisplayed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$6$lambda$5(FullscreenImageSceneViewModel fullscreenImageSceneViewModel, AdnClickElement element, int i, int i2) {
        Intrinsics.checkNotNullParameter(element, "element");
        FullscreenSceneViewModel.onClicked$default(fullscreenImageSceneViewModel, element, new ClickPosition(i, i2), false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$8$lambda$7(FullscreenImageSceneViewModel fullscreenImageSceneViewModel) {
        fullscreenImageSceneViewModel.onPrivacyPolicyClicked();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$10$lambda$9(FullscreenImageSceneViewModel fullscreenImageSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenImageSceneViewModel, AdnClickElement.Cta.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$13$lambda$12$lambda$11(FullscreenImageSceneViewModel fullscreenImageSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenImageSceneViewModel, AdnClickElement.StoreOverlay.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$15$lambda$14(FullscreenImageSceneViewModel fullscreenImageSceneViewModel) {
        FullscreenSceneViewModel.onClose$default(fullscreenImageSceneViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdImageScreen$lambda$18$lambda$17$lambda$16(FullscreenImageSceneViewModel fullscreenImageSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenImageSceneViewModel, AdnClickElement.Close.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    private static final FullscreenAdSceneUiState.Image FullscreenAdImageScreen$lambda$0(State<FullscreenAdSceneUiState.Image> state) {
        return state.getValue();
    }
}
