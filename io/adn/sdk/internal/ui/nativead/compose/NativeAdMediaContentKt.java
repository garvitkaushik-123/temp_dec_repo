package io.adn.sdk.internal.ui.nativead.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImageKt;
import coil.request.ImageRequest;
import io.adn.sdk.internal.domain.model.ad.PlaybackProgress;
import io.adn.sdk.internal.domain.model.ui.VideoState;
import io.adn.sdk.internal.ui.common.design.compose.AdTrackingViewKt;
import io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.PlayButtonKt;
import io.adn.sdk.internal.ui.common.design.compose.VideoPlayerKt;
import io.adn.sdk.internal.ui.nativead.NativeImageMediaViewModel;
import io.adn.sdk.internal.ui.nativead.NativeMediaViewModel;
import io.adn.sdk.internal.ui.nativead.NativeVideoMediaViewModel;
import io.adn.sdk.internal.ui.nativead.state.NativeAdImageUiState;
import io.adn.sdk.internal.ui.nativead.state.NativeAdVideoUiState;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdMediaContent.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\t\u001aW\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"NativeAdMediaContent", "", "viewModel", "Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;", "onClicked", "Lkotlin/Function0;", "(Lio/adn/sdk/internal/ui/nativead/NativeMediaViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "VideoContent", "Lio/adn/sdk/internal/ui/nativead/NativeVideoMediaViewModel;", "(Lio/adn/sdk/internal/ui/nativead/NativeVideoMediaViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ControlButtons", "isVisibilityThresholdMet", "", "isPlaying", "isMuted", "onMuteToggle", "Lkotlin/Function1;", "onPlayToggle", "modifier", "Landroidx/compose/ui/Modifier;", "(ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImageContent", "Lio/adn/sdk/internal/ui/nativead/NativeImageMediaViewModel;", "(Lio/adn/sdk/internal/ui/nativead/NativeImageMediaViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdVideoUiState;", "Lio/adn/sdk/internal/ui/nativead/state/NativeAdImageUiState;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdMediaContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ControlButtons$lambda$26(boolean z, boolean z2, boolean z3, Function1 function1, Function1 function12, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ControlButtons(z, z2, z3, function1, function12, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$39(NativeImageMediaViewModel nativeImageMediaViewModel, Function0 function0, int i, Composer composer, int i2) {
        ImageContent(nativeImageMediaViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NativeAdMediaContent$lambda$0(NativeMediaViewModel nativeMediaViewModel, Function0 function0, int i, Composer composer, int i2) {
        NativeAdMediaContent(nativeMediaViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$24(NativeVideoMediaViewModel nativeVideoMediaViewModel, Function0 function0, int i, Composer composer, int i2) {
        VideoContent(nativeVideoMediaViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NativeAdMediaContent(final NativeMediaViewModel viewModel, final Function0<Unit> onClicked, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        Composer startRestartGroup = composer.startRestartGroup(2043121937);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClicked) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043121937, i2, -1, "io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContent (NativeAdMediaContent.kt:38)");
            }
            if (viewModel instanceof NativeVideoMediaViewModel) {
                startRestartGroup.startReplaceableGroup(-1999262511);
                VideoContent((NativeVideoMediaViewModel) viewModel, onClicked, startRestartGroup, i2 & 112);
                startRestartGroup.endReplaceableGroup();
            } else if (viewModel instanceof NativeImageMediaViewModel) {
                startRestartGroup.startReplaceableGroup(-1999163311);
                ImageContent((NativeImageMediaViewModel) viewModel, onClicked, startRestartGroup, i2 & 112);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1999101621);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NativeAdMediaContent$lambda$0;
                    NativeAdMediaContent$lambda$0 = NativeAdMediaContentKt.NativeAdMediaContent$lambda$0(NativeMediaViewModel.this, onClicked, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NativeAdMediaContent$lambda$0;
                }
            });
        }
    }

    private static final void VideoContent(final NativeVideoMediaViewModel nativeVideoMediaViewModel, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-37630793);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(nativeVideoMediaViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-37630793, i2, -1, "io.adn.sdk.internal.ui.nativead.compose.VideoContent (NativeAdMediaContent.kt:54)");
            }
            boolean z = false;
            State collectAsState = SnapshotStateKt.collectAsState(nativeVideoMediaViewModel.getUiState(), null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceableGroup(153813352);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(153817269);
            boolean z2 = (i2 & 112) == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit VideoContent$lambda$6$lambda$5;
                        VideoContent$lambda$6$lambda$5 = NativeAdMediaContentKt.VideoContent$lambda$6$lambda$5(Function0.this);
                        return VideoContent$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(fillMaxSize$default, false, null, null, (Function0) rememberedValue2, 7, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m561clickableXHw0xAI$default);
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
            File file = VideoContent$lambda$1(collectAsState).getFile();
            if (VideoContent$lambda$1(collectAsState).isVisible() && VideoContent$lambda$1(collectAsState).getShouldPlay()) {
                z = true;
            }
            long lastPosition = VideoContent$lambda$1(collectAsState).getLastPosition();
            boolean isMuted = VideoContent$lambda$1(collectAsState).isMuted();
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(434779040);
            boolean changedInstance = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit VideoContent$lambda$23$lambda$8$lambda$7;
                        VideoContent$lambda$23$lambda$8$lambda$7 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$8$lambda$7(NativeVideoMediaViewModel.this);
                        return VideoContent$lambda$23$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(434782188);
            boolean changedInstance2 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$10$lambda$9;
                        VideoContent$lambda$23$lambda$10$lambda$9 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$10$lambda$9(NativeVideoMediaViewModel.this, mutableState, (VideoState) obj);
                        return VideoContent$lambda$23$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(434787523);
            boolean changedInstance3 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$12$lambda$11;
                        VideoContent$lambda$23$lambda$12$lambda$11 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$12$lambda$11(NativeVideoMediaViewModel.this, (PlaybackProgress) obj);
                        return VideoContent$lambda$23$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function1 function12 = (Function1) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(434790266);
            boolean changedInstance4 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$14$lambda$13;
                        VideoContent$lambda$23$lambda$14$lambda$13 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$14$lambda$13(NativeVideoMediaViewModel.this, (String) obj);
                        return VideoContent$lambda$23$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceableGroup();
            VideoPlayerKt.VideoPlayer(fillMaxSize$default2, file, z, lastPosition, isMuted, true, true, function02, function1, function12, (Function1) rememberedValue6, startRestartGroup, 1769478, 0, 0);
            String uuid = VideoContent$lambda$1(collectAsState).getUuid();
            Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
            startRestartGroup.startReplaceableGroup(434798213);
            boolean changedInstance5 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$16$lambda$15;
                        VideoContent$lambda$23$lambda$16$lambda$15 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$16$lambda$15(NativeVideoMediaViewModel.this, (View) obj);
                        return VideoContent$lambda$23$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function1 function13 = (Function1) rememberedValue7;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(434800227);
            boolean changedInstance6 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit VideoContent$lambda$23$lambda$18$lambda$17;
                        VideoContent$lambda$23$lambda$18$lambda$17 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$18$lambda$17(NativeVideoMediaViewModel.this);
                        return VideoContent$lambda$23$lambda$18$lambda$17;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            AdTrackingViewKt.AdTrackingView(uuid, matchParentSize, function13, (Function0) rememberedValue8, startRestartGroup, 0);
            Modifier align = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart());
            boolean isVisible = VideoContent$lambda$1(collectAsState).isVisible();
            boolean VideoContent$lambda$3 = VideoContent$lambda$3(mutableState);
            boolean isMuted2 = VideoContent$lambda$1(collectAsState).isMuted();
            startRestartGroup.startReplaceableGroup(434809463);
            boolean changedInstance7 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$20$lambda$19;
                        VideoContent$lambda$23$lambda$20$lambda$19 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$20$lambda$19(NativeVideoMediaViewModel.this, ((Boolean) obj).booleanValue());
                        return VideoContent$lambda$23$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            Function1 function14 = (Function1) rememberedValue9;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(434813055);
            boolean changedInstance8 = startRestartGroup.changedInstance(nativeVideoMediaViewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit VideoContent$lambda$23$lambda$22$lambda$21;
                        VideoContent$lambda$23$lambda$22$lambda$21 = NativeAdMediaContentKt.VideoContent$lambda$23$lambda$22$lambda$21(NativeVideoMediaViewModel.this, mutableState, ((Boolean) obj).booleanValue());
                        return VideoContent$lambda$23$lambda$22$lambda$21;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceableGroup();
            ControlButtons(isVisible, VideoContent$lambda$3, isMuted2, function14, (Function1) rememberedValue10, align, startRestartGroup, 0, 0);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoContent$lambda$24;
                    VideoContent$lambda$24 = NativeAdMediaContentKt.VideoContent$lambda$24(NativeVideoMediaViewModel.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoContent$lambda$24;
                }
            });
        }
    }

    private static final boolean VideoContent$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VideoContent$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$8$lambda$7(NativeVideoMediaViewModel nativeVideoMediaViewModel) {
        nativeVideoMediaViewModel.onVideoRendered();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$10$lambda$9(NativeVideoMediaViewModel nativeVideoMediaViewModel, MutableState mutableState, VideoState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        VideoContent$lambda$4(mutableState, state instanceof VideoState.Playing);
        nativeVideoMediaViewModel.onPlaybackStateChange(state);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$12$lambda$11(NativeVideoMediaViewModel nativeVideoMediaViewModel, PlaybackProgress it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeVideoMediaViewModel.onPlayerProgress(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$14$lambda$13(NativeVideoMediaViewModel nativeVideoMediaViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeVideoMediaViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$16$lambda$15(NativeVideoMediaViewModel nativeVideoMediaViewModel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeVideoMediaViewModel.onViewAttached(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$18$lambda$17(NativeVideoMediaViewModel nativeVideoMediaViewModel) {
        nativeVideoMediaViewModel.onViewDetached();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$20$lambda$19(NativeVideoMediaViewModel nativeVideoMediaViewModel, boolean z) {
        nativeVideoMediaViewModel.onMuteToggle(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoContent$lambda$23$lambda$22$lambda$21(NativeVideoMediaViewModel nativeVideoMediaViewModel, MutableState mutableState, boolean z) {
        VideoContent$lambda$4(mutableState, z);
        nativeVideoMediaViewModel.onPlayToggle(z);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0199 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void ControlButtons(final boolean z, final boolean z2, final boolean z3, final Function1<? super Boolean, Unit> function1, final Function1<? super Boolean, Unit> function12, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z4;
        Function1<? super Boolean, Unit> function13;
        int i4;
        Modifier modifier2;
        boolean z5;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(65397986);
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
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(z4) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            function13 = function1;
            i3 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
                i4 = i2 & 32;
                if (i4 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(65397986, i3, -1, "io.adn.sdk.internal.ui.nativead.compose.ControlButtons (NativeAdMediaContent.kt:117)");
                        }
                        Modifier m879padding3ABfNKs = PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(16));
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        startRestartGroup.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, startRestartGroup, 54);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        z5 = false;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m879padding3ABfNKs);
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
                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        if (z && z2) {
                            z5 = true;
                        }
                        int i5 = i3 >> 3;
                        MuteButtonKt.m9528MuteButtonAI0w5tM(z5, z4, function13, null, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i5 & 112) | 100884480 | (i5 & 896), 200);
                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(8)), startRestartGroup, 6);
                        Modifier modifier4 = companion;
                        PlayButtonKt.m9529PlayButtonrjX7Trg(z, z2, function12, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i3 & 14) | 12610560 | (i3 & 112) | ((i3 >> 6) & 896), 96);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ControlButtons$lambda$26;
                                ControlButtons$lambda$26 = NativeAdMediaContentKt.ControlButtons$lambda$26(z, z2, z3, function1, function12, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return ControlButtons$lambda$26;
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                if ((74899 & i3) == 74898) {
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m879padding3ABfNKs2 = PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(16));
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                z5 = false;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m879padding3ABfNKs2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting()) {
                }
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                if (z) {
                    z5 = true;
                }
                int i52 = i3 >> 3;
                MuteButtonKt.m9528MuteButtonAI0w5tM(z5, z4, function13, null, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i52 & 112) | 100884480 | (i52 & 896), 200);
                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(8)), startRestartGroup, 6);
                Modifier modifier42 = companion;
                PlayButtonKt.m9529PlayButtonrjX7Trg(z, z2, function12, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i3 & 14) | 12610560 | (i3 & 112) | ((i3 >> 6) & 896), 96);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i4 = i2 & 32;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            if ((74899 & i3) == 74898) {
            }
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m879padding3ABfNKs22 = PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(16));
            Arrangement.HorizontalOrVertical center22 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically22 = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(center22, centerVertically22, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            z5 = false;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m879padding3ABfNKs22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
            if (z) {
            }
            int i522 = i3 >> 3;
            MuteButtonKt.m9528MuteButtonAI0w5tM(z5, z4, function13, null, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i522 & 112) | 100884480 | (i522 & 896), 200);
            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(8)), startRestartGroup, 6);
            Modifier modifier422 = companion;
            PlayButtonKt.m9529PlayButtonrjX7Trg(z, z2, function12, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i3 & 14) | 12610560 | (i3 & 112) | ((i3 >> 6) & 896), 96);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function13 = function1;
        if ((i2 & 16) == 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((74899 & i3) == 74898) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m879padding3ABfNKs222 = PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(16));
        Arrangement.HorizontalOrVertical center222 = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical centerVertically222 = Alignment.INSTANCE.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(center222, centerVertically222, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        z5 = false;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m879padding3ABfNKs222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
        if (z) {
        }
        int i5222 = i3 >> 3;
        MuteButtonKt.m9528MuteButtonAI0w5tM(z5, z4, function13, null, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i5222 & 112) | 100884480 | (i5222 & 896), 200);
        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(8)), startRestartGroup, 6);
        Modifier modifier4222 = companion;
        PlayButtonKt.m9529PlayButtonrjX7Trg(z, z2, function12, UIConstants.INSTANCE.m9599getNATIVE_ICON_BUTTON_SIZEMYxV2XQ$adn_sdk_release(), UIConstants.INSTANCE.m9598getNATIVE_ICON_BUTTON_COLOR0d7_KjU$adn_sdk_release(), null, null, false, startRestartGroup, (i3 & 14) | 12610560 | (i3 & 112) | ((i3 >> 6) & 896), 96);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final void ImageContent(final NativeImageMediaViewModel nativeImageMediaViewModel, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1417813833);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(nativeImageMediaViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1417813833, i2, -1, "io.adn.sdk.internal.ui.nativead.compose.ImageContent (NativeAdMediaContent.kt:147)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(nativeImageMediaViewModel.getUiState(), null, startRestartGroup, 0, 1);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(-758423371);
            boolean z = (i2 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ImageContent$lambda$29$lambda$28;
                        ImageContent$lambda$29$lambda$28 = NativeAdMediaContentKt.ImageContent$lambda$29$lambda$28(Function0.this);
                        return ImageContent$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(fillMaxSize$default, false, null, null, (Function0) rememberedValue, 7, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m561clickableXHw0xAI$default);
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
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ImageRequest build = new ImageRequest.Builder((Context) consume).data(ImageContent$lambda$27(collectAsState).getData()).build();
            ContentScale crop = ContentScale.INSTANCE.getCrop();
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(1908988356);
            boolean changedInstance = startRestartGroup.changedInstance(nativeImageMediaViewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ImageContent$lambda$38$lambda$31$lambda$30;
                        ImageContent$lambda$38$lambda$31$lambda$30 = NativeAdMediaContentKt.ImageContent$lambda$38$lambda$31$lambda$30(NativeImageMediaViewModel.this, (AsyncImagePainter.State.Success) obj);
                        return ImageContent$lambda$38$lambda$31$lambda$30;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function1 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1908986408);
            boolean changedInstance2 = startRestartGroup.changedInstance(nativeImageMediaViewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ImageContent$lambda$38$lambda$33$lambda$32;
                        ImageContent$lambda$38$lambda$33$lambda$32 = NativeAdMediaContentKt.ImageContent$lambda$38$lambda$33$lambda$32(NativeImageMediaViewModel.this, (AsyncImagePainter.State.Error) obj);
                        return ImageContent$lambda$38$lambda$33$lambda$32;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            SingletonAsyncImageKt.m6741AsyncImageVb_qNX0(build, null, fillMaxSize$default2, null, null, null, null, function1, (Function1) rememberedValue3, null, crop, 0.0f, null, 0, false, null, startRestartGroup, 432, 6, 64120);
            String uuid = ImageContent$lambda$27(collectAsState).getUuid();
            Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
            startRestartGroup.startReplaceableGroup(1908994117);
            boolean changedInstance3 = startRestartGroup.changedInstance(nativeImageMediaViewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ImageContent$lambda$38$lambda$35$lambda$34;
                        ImageContent$lambda$38$lambda$35$lambda$34 = NativeAdMediaContentKt.ImageContent$lambda$38$lambda$35$lambda$34(NativeImageMediaViewModel.this, (View) obj);
                        return ImageContent$lambda$38$lambda$35$lambda$34;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function12 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1908996131);
            boolean changedInstance4 = startRestartGroup.changedInstance(nativeImageMediaViewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ImageContent$lambda$38$lambda$37$lambda$36;
                        ImageContent$lambda$38$lambda$37$lambda$36 = NativeAdMediaContentKt.ImageContent$lambda$38$lambda$37$lambda$36(NativeImageMediaViewModel.this);
                        return ImageContent$lambda$38$lambda$37$lambda$36;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceableGroup();
            AdTrackingViewKt.AdTrackingView(uuid, matchParentSize, function12, (Function0) rememberedValue5, startRestartGroup, 0);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.nativead.compose.NativeAdMediaContentKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageContent$lambda$39;
                    ImageContent$lambda$39 = NativeAdMediaContentKt.ImageContent$lambda$39(NativeImageMediaViewModel.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageContent$lambda$39;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$29$lambda$28(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$38$lambda$33$lambda$32(NativeImageMediaViewModel nativeImageMediaViewModel, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeImageMediaViewModel.onError(ComposeKt.message(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$38$lambda$31$lambda$30(NativeImageMediaViewModel nativeImageMediaViewModel, AsyncImagePainter.State.Success it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeImageMediaViewModel.onImageRendered();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$38$lambda$35$lambda$34(NativeImageMediaViewModel nativeImageMediaViewModel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nativeImageMediaViewModel.onViewAttached(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageContent$lambda$38$lambda$37$lambda$36(NativeImageMediaViewModel nativeImageMediaViewModel) {
        nativeImageMediaViewModel.onViewDetached();
        return Unit.INSTANCE;
    }

    private static final NativeAdVideoUiState VideoContent$lambda$1(State<NativeAdVideoUiState> state) {
        return state.getValue();
    }

    private static final NativeAdImageUiState ImageContent$lambda$27(State<NativeAdImageUiState> state) {
        return state.getValue();
    }
}
