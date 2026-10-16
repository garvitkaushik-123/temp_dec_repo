package io.adn.sdk.internal.ui.fullscreen.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.app.NotificationCompat;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.domain.model.ad.AdMuteConfig;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.ExoVideoPlayerKt;
import io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt;
import io.adn.sdk.internal.ui.common.design.compose.VideoProgressBarKt;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenVideoSceneViewModel;
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

/* compiled from: FullscreenAdVideoScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\f\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u008a\u008e\u0002"}, d2 = {"FullscreenAdVideoScreen", "", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenVideoSceneViewModel;", "shouldPlay", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenVideoSceneViewModel;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$Video;", "isPlaying", "isMuted", NotificationCompat.CATEGORY_PROGRESS, "Lio/adn/sdk/internal/domain/model/ad/PlaybackProgress;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdVideoScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$34(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullscreenAdVideoScreen(fullscreenVideoSceneViewModel, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x024c, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenAdVideoScreen(final FullscreenVideoSceneViewModel viewModel, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Modifier modifier2;
        FullscreenAdSceneConfig.Video config;
        SceneAsset.Media asset;
        Object rememberedValue;
        Object rememberedValue2;
        Object rememberedValue3;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        State state;
        MutableState mutableState;
        BoxScopeInstance boxScopeInstance;
        MutableState mutableState2;
        final MutableState mutableState3;
        int i4;
        Modifier modifier3;
        PromotedAppUiState promotedAppUiState;
        boolean changedInstance;
        Object rememberedValue4;
        boolean changedInstance2;
        Object rememberedValue5;
        final Modifier modifier4;
        boolean changedInstance3;
        Object rememberedValue6;
        boolean changedInstance4;
        Object rememberedValue7;
        int i5;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-176895496);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changed(z2) ? 32 : 16;
            }
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-176895496, i3, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreen (FullscreenAdVideoScreen.kt:30)");
                }
                State collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
                config = FullscreenAdVideoScreen$lambda$0(collectAsState).getConfig();
                PromotedAppUiState promotedAppUiState2 = FullscreenAdVideoScreen$lambda$0(collectAsState).getPromotedAppUiState();
                asset = FullscreenAdVideoScreen$lambda$0(collectAsState).getAsset();
                startRestartGroup.startReplaceableGroup(909321540);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState4 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(909323277);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(FullscreenAdVideoScreen$lambda$0(collectAsState).isMute()), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                MutableState mutableState5 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(909325334);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState6 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
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
                startRestartGroup.startReplaceableGroup(-1432128194);
                if (asset == null) {
                    File file = asset.getResource().getFile();
                    boolean FullscreenAdVideoScreen$lambda$5 = FullscreenAdVideoScreen$lambda$5(mutableState5);
                    Modifier matchParentSize = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-1432119392);
                    boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue8 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$11$lambda$10;
                                FullscreenAdVideoScreen$lambda$33$lambda$11$lambda$10 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$11$lambda$10(FullscreenVideoSceneViewModel.this);
                                return FullscreenAdVideoScreen$lambda$33$lambda$11$lambda$10;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    }
                    Function0 function0 = (Function0) rememberedValue8;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1432115995);
                    boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
                    state = collectAsState;
                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                    if (changedInstance6 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$13$lambda$12;
                                FullscreenAdVideoScreen$lambda$33$lambda$13$lambda$12 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$13$lambda$12(FullscreenVideoSceneViewModel.this, mutableState4, (VideoState) obj);
                                return FullscreenAdVideoScreen$lambda$33$lambda$13$lambda$12;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                    }
                    Function1 function1 = (Function1) rememberedValue9;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1432110583);
                    boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue10 = startRestartGroup.rememberedValue();
                    if (changedInstance7) {
                        i5 = i3;
                    } else {
                        i5 = i3;
                    }
                    rememberedValue10 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit FullscreenAdVideoScreen$lambda$33$lambda$15$lambda$14;
                            FullscreenAdVideoScreen$lambda$33$lambda$15$lambda$14 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$15$lambda$14(FullscreenVideoSceneViewModel.this, mutableState6, (PlaybackProgress) obj);
                            return FullscreenAdVideoScreen$lambda$33$lambda$15$lambda$14;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                    Function1 function12 = (Function1) rememberedValue10;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1432106914);
                    boolean changedInstance8 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue11 = startRestartGroup.rememberedValue();
                    if (changedInstance8 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue11 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$17$lambda$16;
                                FullscreenAdVideoScreen$lambda$33$lambda$17$lambda$16 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$17$lambda$16(FullscreenVideoSceneViewModel.this, (String) obj);
                                return FullscreenAdVideoScreen$lambda$33$lambda$17$lambda$16;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue11);
                    }
                    startRestartGroup.endReplaceableGroup();
                    boxScopeInstance = boxScopeInstance2;
                    mutableState2 = mutableState4;
                    i4 = 0;
                    modifier3 = companion;
                    mutableState3 = mutableState5;
                    mutableState = mutableState6;
                    ExoVideoPlayerKt.ExoVideoPlayer(matchParentSize, file, z2, 0L, FullscreenAdVideoScreen$lambda$5, false, false, function0, function1, function12, (Function1) rememberedValue11, startRestartGroup, ((i5 << 3) & 896) | 1575936, 0, 32);
                    startRestartGroup = startRestartGroup;
                } else {
                    state = collectAsState;
                    mutableState = mutableState6;
                    boxScopeInstance = boxScopeInstance2;
                    mutableState2 = mutableState4;
                    mutableState3 = mutableState5;
                    i4 = 0;
                    modifier3 = companion;
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432101840);
                if (FullscreenAdVideoScreen$lambda$0(state).isRedirectionEnabled()) {
                    Modifier matchParentSize2 = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                    AdnClickElement.MainMedia mainMedia = AdnClickElement.MainMedia.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1432095757);
                    boolean changedInstance9 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue12 = startRestartGroup.rememberedValue();
                    if (changedInstance9 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue12 = new Function3() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$19$lambda$18;
                                FullscreenAdVideoScreen$lambda$33$lambda$19$lambda$18 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$19$lambda$18(FullscreenVideoSceneViewModel.this, (AdnClickElement) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                                return FullscreenAdVideoScreen$lambda$33$lambda$19$lambda$18;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue12);
                    }
                    startRestartGroup.endReplaceableGroup();
                    BoxKt.Box(ComposeKt.clickWithCoordinates(matchParentSize2, mainMedia, false, (Function3) rememberedValue12, startRestartGroup, 48, 2), startRestartGroup, i4);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432090767);
                if (asset != null && config.getMuteConfig().getEnabled()) {
                    AdMuteConfig muteConfig = config.getMuteConfig();
                    boolean FullscreenAdVideoScreen$lambda$52 = FullscreenAdVideoScreen$lambda$5(mutableState3);
                    boolean FullscreenAdVideoScreen$lambda$2 = FullscreenAdVideoScreen$lambda$2(mutableState2);
                    startRestartGroup.startReplaceableGroup(-1432083725);
                    changedInstance4 = startRestartGroup.changedInstance(viewModel);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (!changedInstance4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20;
                                FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20(FullscreenVideoSceneViewModel.this, mutableState3, ((Boolean) obj).booleanValue());
                                return FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceableGroup();
                    MuteButtonKt.muteButton(muteConfig, FullscreenAdVideoScreen$lambda$2, FullscreenAdVideoScreen$lambda$52, (Function1) rememberedValue7, startRestartGroup, 0).invoke(boxScopeInstance, startRestartGroup, 6);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432078795);
                if (config.getCtaConfig().getEnabled()) {
                    promotedAppUiState = promotedAppUiState2;
                } else {
                    AdCtaConfig ctaConfig = config.getCtaConfig();
                    startRestartGroup.startReplaceableGroup(-1432073427);
                    boolean changedInstance10 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue13 = startRestartGroup.rememberedValue();
                    if (changedInstance10 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue13 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$23$lambda$22;
                                FullscreenAdVideoScreen$lambda$33$lambda$23$lambda$22 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$23$lambda$22(FullscreenVideoSceneViewModel.this);
                                return FullscreenAdVideoScreen$lambda$33$lambda$23$lambda$22;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue13);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Composer composer2 = startRestartGroup;
                    promotedAppUiState = promotedAppUiState2;
                    startRestartGroup = composer2;
                    CTAButtonKt.ctaButton(ctaConfig, promotedAppUiState2, (Function0) rememberedValue13, composer2, 0, 0).invoke(boxScopeInstance, startRestartGroup, 6);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432070676);
                if (config.getProgressConfig().getEnabled() && FullscreenAdVideoScreen$lambda$8(mutableState) != null) {
                    VideoProgressBarKt.videoProgressBar(config.getProgressConfig(), FullscreenAdVideoScreen$lambda$2(mutableState2), FullscreenAdVideoScreen$lambda$8(mutableState), startRestartGroup, i4).invoke(boxScopeInstance, startRestartGroup, 6);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432062884);
                if (config.getPrivacyConfig().getEnabled()) {
                    AdPrivacyConfig privacyConfig = config.getPrivacyConfig();
                    startRestartGroup.startReplaceableGroup(-1432058681);
                    boolean changedInstance11 = startRestartGroup.changedInstance(viewModel);
                    Object rememberedValue14 = startRestartGroup.rememberedValue();
                    if (changedInstance11 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue14 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$25$lambda$24;
                                FullscreenAdVideoScreen$lambda$33$lambda$25$lambda$24 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$25$lambda$24(FullscreenVideoSceneViewModel.this);
                                return FullscreenAdVideoScreen$lambda$33$lambda$25$lambda$24;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue14);
                    }
                    startRestartGroup.endReplaceableGroup();
                    PrivacyButtonKt.privacyButton(privacyConfig, (Function0) rememberedValue14, startRestartGroup, i4).invoke(boxScopeInstance, startRestartGroup, 6);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1432056288);
                if (config.getStoreConfig().getEnabled() && promotedAppUiState != null) {
                    AdCtaConfig ctaConfig2 = config.getCtaConfig();
                    double delay = config.getStoreConfig().getDelay();
                    boolean dismissable = config.getStoreConfig().getDismissable();
                    startRestartGroup.startReplaceableGroup(381904053);
                    changedInstance3 = startRestartGroup.changedInstance(viewModel);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changedInstance3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26;
                                FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26(FullscreenVideoSceneViewModel.this);
                                return FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Composer composer3 = startRestartGroup;
                    startRestartGroup = composer3;
                    StoreOverlayKt.storeOverlay(delay, dismissable, (Function0) rememberedValue6, null, null, null, promotedAppUiState, ctaConfig2, composer3, 0, 56).invoke(boxScopeInstance, startRestartGroup, 6);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceableGroup();
                AdCloseConfig effectiveCloseConfig = FullscreenAdVideoScreen$lambda$0(state).getEffectiveCloseConfig();
                startRestartGroup.startReplaceableGroup(-1432038344);
                changedInstance = startRestartGroup.changedInstance(viewModel);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29;
                            FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29(FullscreenVideoSceneViewModel.this);
                            return FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function0 function02 = (Function0) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                int effectiveCloseIcon = FullscreenAdVideoScreen$lambda$0(state).getEffectiveCloseIcon();
                startRestartGroup.startReplaceableGroup(-1432034929);
                changedInstance2 = startRestartGroup.changedInstance(viewModel);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31;
                            FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31(FullscreenVideoSceneViewModel.this);
                            return FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceableGroup();
                CloseButtonKt.closeButton(effectiveCloseConfig, function02, effectiveCloseIcon, (Function0) rememberedValue5, startRestartGroup, 0, 0).invoke(boxScopeInstance, startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FullscreenAdVideoScreen$lambda$34;
                        FullscreenAdVideoScreen$lambda$34 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$34(FullscreenVideoSceneViewModel.this, z, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return FullscreenAdVideoScreen$lambda$34;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        State collectAsState2 = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
        config = FullscreenAdVideoScreen$lambda$0(collectAsState2).getConfig();
        PromotedAppUiState promotedAppUiState22 = FullscreenAdVideoScreen$lambda$0(collectAsState2).getPromotedAppUiState();
        asset = FullscreenAdVideoScreen$lambda$0(collectAsState2).getAsset();
        startRestartGroup.startReplaceableGroup(909321540);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState mutableState42 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(909323277);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        MutableState mutableState52 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(909325334);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState mutableState62 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxSize$default2);
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
        startRestartGroup.startReplaceableGroup(-1432128194);
        if (asset == null) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432101840);
        if (FullscreenAdVideoScreen$lambda$0(state).isRedirectionEnabled()) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432090767);
        if (asset != null) {
            AdMuteConfig muteConfig2 = config.getMuteConfig();
            boolean FullscreenAdVideoScreen$lambda$522 = FullscreenAdVideoScreen$lambda$5(mutableState3);
            boolean FullscreenAdVideoScreen$lambda$22 = FullscreenAdVideoScreen$lambda$2(mutableState2);
            startRestartGroup.startReplaceableGroup(-1432083725);
            changedInstance4 = startRestartGroup.changedInstance(viewModel);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (!changedInstance4) {
            }
            rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20;
                    FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20(FullscreenVideoSceneViewModel.this, mutableState3, ((Boolean) obj).booleanValue());
                    return FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue7);
            startRestartGroup.endReplaceableGroup();
            MuteButtonKt.muteButton(muteConfig2, FullscreenAdVideoScreen$lambda$22, FullscreenAdVideoScreen$lambda$522, (Function1) rememberedValue7, startRestartGroup, 0).invoke(boxScopeInstance, startRestartGroup, 6);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432078795);
        if (config.getCtaConfig().getEnabled()) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432070676);
        if (config.getProgressConfig().getEnabled()) {
            VideoProgressBarKt.videoProgressBar(config.getProgressConfig(), FullscreenAdVideoScreen$lambda$2(mutableState2), FullscreenAdVideoScreen$lambda$8(mutableState), startRestartGroup, i4).invoke(boxScopeInstance, startRestartGroup, 6);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432062884);
        if (config.getPrivacyConfig().getEnabled()) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1432056288);
        if (config.getStoreConfig().getEnabled()) {
            AdCtaConfig ctaConfig22 = config.getCtaConfig();
            double delay2 = config.getStoreConfig().getDelay();
            boolean dismissable2 = config.getStoreConfig().getDismissable();
            startRestartGroup.startReplaceableGroup(381904053);
            changedInstance3 = startRestartGroup.changedInstance(viewModel);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
            }
            rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26;
                    FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26(FullscreenVideoSceneViewModel.this);
                    return FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            startRestartGroup.endReplaceableGroup();
            Composer composer32 = startRestartGroup;
            startRestartGroup = composer32;
            StoreOverlayKt.storeOverlay(delay2, dismissable2, (Function0) rememberedValue6, null, null, null, promotedAppUiState, ctaConfig22, composer32, 0, 56).invoke(boxScopeInstance, startRestartGroup, 6);
            Unit unit3 = Unit.INSTANCE;
            Unit unit22 = Unit.INSTANCE;
        }
        startRestartGroup.endReplaceableGroup();
        AdCloseConfig effectiveCloseConfig2 = FullscreenAdVideoScreen$lambda$0(state).getEffectiveCloseConfig();
        startRestartGroup.startReplaceableGroup(-1432038344);
        changedInstance = startRestartGroup.changedInstance(viewModel);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29;
                FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29(FullscreenVideoSceneViewModel.this);
                return FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        Function0 function022 = (Function0) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        int effectiveCloseIcon2 = FullscreenAdVideoScreen$lambda$0(state).getEffectiveCloseIcon();
        startRestartGroup.startReplaceableGroup(-1432034929);
        changedInstance2 = startRestartGroup.changedInstance(viewModel);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdVideoScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31;
                FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31 = FullscreenAdVideoScreenKt.FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31(FullscreenVideoSceneViewModel.this);
                return FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        CloseButtonKt.closeButton(effectiveCloseConfig2, function022, effectiveCloseIcon2, (Function0) rememberedValue5, startRestartGroup, 0, 0).invoke(boxScopeInstance, startRestartGroup, 6);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean FullscreenAdVideoScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FullscreenAdVideoScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FullscreenAdVideoScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FullscreenAdVideoScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final PlaybackProgress FullscreenAdVideoScreen$lambda$8(MutableState<PlaybackProgress> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$11$lambda$10(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        fullscreenVideoSceneViewModel.onDisplayed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$13$lambda$12(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, MutableState mutableState, VideoState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FullscreenAdVideoScreen$lambda$3(mutableState, Intrinsics.areEqual(it, VideoState.Playing.INSTANCE));
        fullscreenVideoSceneViewModel.onPlaybackStateChange(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$15$lambda$14(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, MutableState mutableState, PlaybackProgress it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        fullscreenVideoSceneViewModel.onPlayerProgress(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$17$lambda$16(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        fullscreenVideoSceneViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$19$lambda$18(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, AdnClickElement element, int i, int i2) {
        Intrinsics.checkNotNullParameter(element, "element");
        FullscreenSceneViewModel.onClicked$default(fullscreenVideoSceneViewModel, element, new ClickPosition(i, i2), false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$21$lambda$20(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel, MutableState mutableState, boolean z) {
        FullscreenAdVideoScreen$lambda$6(mutableState, z);
        fullscreenVideoSceneViewModel.onMuteToggle(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$23$lambda$22(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenVideoSceneViewModel, AdnClickElement.Cta.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$25$lambda$24(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        fullscreenVideoSceneViewModel.onPrivacyPolicyClicked();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$28$lambda$27$lambda$26(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenVideoSceneViewModel, AdnClickElement.StoreOverlay.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$30$lambda$29(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        FullscreenSceneViewModel.onClose$default(fullscreenVideoSceneViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdVideoScreen$lambda$33$lambda$32$lambda$31(FullscreenVideoSceneViewModel fullscreenVideoSceneViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenVideoSceneViewModel, AdnClickElement.Close.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    private static final FullscreenAdSceneUiState.Video FullscreenAdVideoScreen$lambda$0(State<FullscreenAdSceneUiState.Video> state) {
        return state.getValue();
    }
}
