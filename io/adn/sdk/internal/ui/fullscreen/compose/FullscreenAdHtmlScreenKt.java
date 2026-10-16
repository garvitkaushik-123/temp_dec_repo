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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt;
import io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.common.mraid.MraidController;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiStateKt;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenHtmlSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdHtmlScreen.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"FullscreenAdHtmlScreen", "", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenHtmlSceneViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenHtmlSceneViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Html;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdHtmlScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$19(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullscreenAdHtmlScreen(fullscreenHtmlSceneViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenAdHtmlScreen(final FullscreenHtmlSceneViewModel viewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Modifier modifier3;
        State collectAsState;
        FullscreenAdSceneConfig.Html config;
        SceneAsset.Html asset;
        boolean showLoadingCard;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int i4;
        Composer composer2;
        BoxScopeInstance boxScopeInstance;
        PromotedAppUiState promotedAppUiState;
        State state;
        BoxScopeInstance boxScopeInstance2;
        Modifier modifier4;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        Composer composer3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-130721252);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
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
                modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-130721252, i3, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreen (FullscreenAdHtmlScreen.kt:23)");
                }
                collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
                config = FullscreenAdHtmlScreen$lambda$0(collectAsState).getConfig();
                asset = FullscreenAdHtmlScreen$lambda$0(collectAsState).getAsset();
                PromotedAppUiState promotedAppUiState2 = FullscreenAdHtmlScreen$lambda$0(collectAsState).getPromotedAppUiState();
                showLoadingCard = FullscreenAdHtmlScreen$lambda$0(collectAsState).getShowLoadingCard();
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
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
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(690400120);
                if (asset == null) {
                    MraidController controller = asset.getController();
                    RedirectionStrategy redirectionStrategy = config.getRedirectionStrategy();
                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    startRestartGroup.startReplaceableGroup(690407638);
                    boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$2$lambda$1;
                                FullscreenAdHtmlScreen$lambda$18$lambda$2$lambda$1 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$2$lambda$1(FullscreenHtmlSceneViewModel.this);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$2$lambda$1;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    Function0 function0 = (Function0) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(690409458);
                    boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$4$lambda$3;
                                FullscreenAdHtmlScreen$lambda$18$lambda$4$lambda$3 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$4$lambda$3(FullscreenHtmlSceneViewModel.this);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    Function0 function02 = (Function0) rememberedValue4;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(690411255);
                    boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function3() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$6$lambda$5;
                                FullscreenAdHtmlScreen$lambda$18$lambda$6$lambda$5 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$6$lambda$5(FullscreenHtmlSceneViewModel.this, ((Boolean) obj).booleanValue(), (AdnClickElement) obj2, (ClickPosition) obj3);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$6$lambda$5;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceableGroup();
                    boxScopeInstance = boxScopeInstance3;
                    i4 = 0;
                    AdHtmlWebViewKt.AdHtmlWebView(controller, redirectionStrategy, fillMaxSize$default2, function0, function02, (Function3) rememberedValue5, startRestartGroup, 384, 0);
                    composer2 = startRestartGroup;
                } else {
                    i4 = 0;
                    composer2 = startRestartGroup;
                    boxScopeInstance = boxScopeInstance3;
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(690418404);
                if (showLoadingCard) {
                    FullscreenAdLoadingCardKt.FullscreenAdLoadingScreen(promotedAppUiState2 != null ? FullscreenAdUiStateKt.icon(promotedAppUiState2) : null, StringResources_androidKt.stringResource(R.string.adn__loading, composer2, i4), composer2, i4);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(690425142);
                if (config.getPrivacyConfig().getEnabled()) {
                    AdPrivacyConfig privacyConfig = config.getPrivacyConfig();
                    composer2.startReplaceableGroup(690429345);
                    boolean changedInstance6 = composer2.changedInstance(viewModel);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$8$lambda$7;
                                FullscreenAdHtmlScreen$lambda$18$lambda$8$lambda$7 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$8$lambda$7(FullscreenHtmlSceneViewModel.this);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$8$lambda$7;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    PrivacyButtonKt.privacyButton(privacyConfig, (Function0) rememberedValue6, composer2, i4).invoke(boxScopeInstance, composer2, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(690431503);
                if (config.getCtaConfig().getEnabled()) {
                    promotedAppUiState = promotedAppUiState2;
                } else {
                    AdCtaConfig ctaConfig = config.getCtaConfig();
                    composer2.startReplaceableGroup(690436871);
                    boolean changedInstance7 = composer2.changedInstance(viewModel);
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (changedInstance7 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$10$lambda$9;
                                FullscreenAdHtmlScreen$lambda$18$lambda$10$lambda$9 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$10$lambda$9(FullscreenHtmlSceneViewModel.this);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$10$lambda$9;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceableGroup();
                    promotedAppUiState = promotedAppUiState2;
                    CTAButtonKt.ctaButton(ctaConfig, promotedAppUiState2, (Function0) rememberedValue7, composer2, 0, 0).invoke(boxScopeInstance, composer2, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(690439888);
                if (config.getStoreConfig().getEnabled() || showLoadingCard || promotedAppUiState == null) {
                    state = collectAsState;
                    boxScopeInstance2 = boxScopeInstance;
                    modifier4 = modifier3;
                } else {
                    AdCtaConfig ctaConfig2 = config.getCtaConfig();
                    double delay = config.getStoreConfig().getDelay();
                    boolean dismissable = config.getStoreConfig().getDismissable();
                    composer2.startReplaceableGroup(-1123882737);
                    boolean changedInstance8 = composer2.changedInstance(viewModel);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (changedInstance8 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdHtmlScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                                FullscreenAdHtmlScreen$lambda$18$lambda$13$lambda$12$lambda$11 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$13$lambda$12$lambda$11(FullscreenHtmlSceneViewModel.this);
                                return FullscreenAdHtmlScreen$lambda$18$lambda$13$lambda$12$lambda$11;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue8);
                    }
                    composer2.endReplaceableGroup();
                    BoxScopeInstance boxScopeInstance4 = boxScopeInstance;
                    Composer composer4 = composer2;
                    modifier4 = modifier3;
                    state = collectAsState;
                    boxScopeInstance2 = boxScopeInstance4;
                    composer2 = composer4;
                    StoreOverlayKt.storeOverlay(delay, dismissable, (Function0) rememberedValue8, null, null, null, promotedAppUiState, ctaConfig2, composer4, 0, 56).invoke(boxScopeInstance2, composer2, 6);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                AdCloseConfig effectiveCloseConfig = FullscreenAdHtmlScreen$lambda$0(state).getEffectiveCloseConfig();
                composer2.startReplaceableGroup(690458514);
                changedInstance = composer2.changedInstance(viewModel);
                rememberedValue = composer2.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14;
                            FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14(FullscreenHtmlSceneViewModel.this);
                            return FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function0 function03 = (Function0) rememberedValue;
                composer2.endReplaceableGroup();
                int effectiveCloseIcon = FullscreenAdHtmlScreen$lambda$0(state).getEffectiveCloseIcon();
                composer2.startReplaceableGroup(690461929);
                changedInstance2 = composer2.changedInstance(viewModel);
                rememberedValue2 = composer2.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16;
                            FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16(FullscreenHtmlSceneViewModel.this);
                            return FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceableGroup();
                Composer composer5 = composer2;
                composer3 = composer5;
                CloseButtonKt.closeButton(effectiveCloseConfig, function03, effectiveCloseIcon, (Function0) rememberedValue2, composer5, 0, 0).invoke(boxScopeInstance2, composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer3 = startRestartGroup;
            }
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FullscreenAdHtmlScreen$lambda$19;
                        FullscreenAdHtmlScreen$lambda$19 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$19(FullscreenHtmlSceneViewModel.this, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return FullscreenAdHtmlScreen$lambda$19;
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
        collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
        config = FullscreenAdHtmlScreen$lambda$0(collectAsState).getConfig();
        asset = FullscreenAdHtmlScreen$lambda$0(collectAsState).getAsset();
        PromotedAppUiState promotedAppUiState22 = FullscreenAdHtmlScreen$lambda$0(collectAsState).getPromotedAppUiState();
        showLoadingCard = FullscreenAdHtmlScreen$lambda$0(collectAsState).getShowLoadingCard();
        Modifier fillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
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
        BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(690400120);
        if (asset == null) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(690418404);
        if (showLoadingCard) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(690425142);
        if (config.getPrivacyConfig().getEnabled()) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(690431503);
        if (config.getCtaConfig().getEnabled()) {
        }
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(690439888);
        if (config.getStoreConfig().getEnabled()) {
        }
        state = collectAsState;
        boxScopeInstance2 = boxScopeInstance;
        modifier4 = modifier3;
        composer2.endReplaceableGroup();
        AdCloseConfig effectiveCloseConfig2 = FullscreenAdHtmlScreen$lambda$0(state).getEffectiveCloseConfig();
        composer2.startReplaceableGroup(690458514);
        changedInstance = composer2.changedInstance(viewModel);
        rememberedValue = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14;
                FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14(FullscreenHtmlSceneViewModel.this);
                return FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14;
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        Function0 function032 = (Function0) rememberedValue;
        composer2.endReplaceableGroup();
        int effectiveCloseIcon2 = FullscreenAdHtmlScreen$lambda$0(state).getEffectiveCloseIcon();
        composer2.startReplaceableGroup(690461929);
        changedInstance2 = composer2.changedInstance(viewModel);
        rememberedValue2 = composer2.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdHtmlScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16;
                FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16 = FullscreenAdHtmlScreenKt.FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16(FullscreenHtmlSceneViewModel.this);
                return FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        composer2.endReplaceableGroup();
        Composer composer52 = composer2;
        composer3 = composer52;
        CloseButtonKt.closeButton(effectiveCloseConfig2, function032, effectiveCloseIcon2, (Function0) rememberedValue2, composer52, 0, 0).invoke(boxScopeInstance2, composer3, 6);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        composer3.endReplaceableGroup();
        composer3.endNode();
        composer3.endReplaceableGroup();
        composer3.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier4;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$2$lambda$1(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        fullscreenHtmlSceneViewModel.onDisplayed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$4$lambda$3(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        FullscreenSceneViewModel.onClose$default(fullscreenHtmlSceneViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$6$lambda$5(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel, boolean z, AdnClickElement adnClickElement, ClickPosition clickPosition) {
        if (adnClickElement == null) {
            adnClickElement = AdnClickElement.MainMedia.INSTANCE;
        }
        fullscreenHtmlSceneViewModel.onClicked(adnClickElement, clickPosition, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$8$lambda$7(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        fullscreenHtmlSceneViewModel.onPrivacyPolicyClicked();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$10$lambda$9(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenHtmlSceneViewModel, AdnClickElement.Cta.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$13$lambda$12$lambda$11(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenHtmlSceneViewModel, AdnClickElement.StoreOverlay.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$15$lambda$14(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        FullscreenSceneViewModel.onClose$default(fullscreenHtmlSceneViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdHtmlScreen$lambda$18$lambda$17$lambda$16(FullscreenHtmlSceneViewModel fullscreenHtmlSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenHtmlSceneViewModel, AdnClickElement.Close.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    private static final FullscreenAdSceneUiState.Html FullscreenAdHtmlScreen$lambda$0(State<FullscreenAdSceneUiState.Html> state) {
        return state.getValue();
    }
}
