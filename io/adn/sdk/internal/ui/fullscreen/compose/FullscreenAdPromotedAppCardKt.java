package io.adn.sdk.internal.ui.fullscreen.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.SingletonAsyncImageKt;
import io.adn.sdk.internal.domain.model.ad.AdCloseConfig;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdSceneConfig;
import io.adn.sdk.internal.ui.common.design.compose.CloseButtonKt;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdSceneUiState;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiStateKt;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenPromotedAppCardViewModel;
import io.adn.sdk.internal.ui.fullscreen.viewmodel.FullscreenSceneViewModel;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdPromotedAppCard.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"FullscreenAdPromotedAppCard", "", "viewModel", "Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenPromotedAppCardViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/adn/sdk/internal/ui/fullscreen/viewmodel/FullscreenPromotedAppCardViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release", "uiState", "Lio/adn/sdk/internal/ui/fullscreen/model/FullscreenAdSceneUiState$PromotedAppCard;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdPromotedAppCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdPromotedAppCard$lambda$11(FullscreenPromotedAppCardViewModel fullscreenPromotedAppCardViewModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FullscreenAdPromotedAppCard(fullscreenPromotedAppCardViewModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FullscreenAdPromotedAppCard(final FullscreenPromotedAppCardViewModel viewModel, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        State collectAsState;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int currentCompositeKeyHash2;
        Composer m3593constructorimpl2;
        String name;
        Composer composer2;
        boolean changedInstance;
        Object rememberedValue;
        BoxScopeInstance boxScopeInstance;
        boolean changedInstance2;
        Object rememberedValue2;
        boolean changedInstance3;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-883018908);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changedInstance(viewModel) ? 4 : 2);
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
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-883018908, i3, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCard (FullscreenAdPromotedAppCard.kt:43)");
                }
                collectAsState = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, startRestartGroup, 0, 1);
                final FullscreenAdSceneConfig.PromotedAppCard config = FullscreenAdPromotedAppCard$lambda$0(collectAsState).getConfig();
                PromotedAppUiState promotedAppUiState = FullscreenAdPromotedAppCard$lambda$0(collectAsState).getPromotedAppUiState();
                Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), FullscreenAdPromotedAppCard$lambda$0(collectAsState).m9582getBackgroundColor0d7_KjU(), null, 2, null);
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
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                startRestartGroup.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier modifier3 = companion;
                SingletonAsyncImageKt.m6742AsyncImagegl8XCv8(FullscreenAdUiStateKt.icon(promotedAppUiState), null, ClipKt.clip(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(130)), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(24))), null, null, null, null, 0.0f, null, 0, false, null, startRestartGroup, 48, 0, 4088);
                float f = 30;
                SpacerKt.Spacer(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f)), startRestartGroup, 6);
                name = promotedAppUiState.getName();
                if (name == null) {
                    name = "";
                }
                TextKt.m2781Text4IGK_g(name, SizeKt.wrapContentHeight$default(PaddingKt.m881paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(f), 0.0f, 2, null), null, false, 3, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(Color.INSTANCE.m4100getWhite0d7_KjU(), TextUnitKt.getSp(28), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null), startRestartGroup, 48, 3120, 54780);
                SpacerKt.Spacer(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f)), startRestartGroup, 6);
                Modifier m935widthInVpY3zN4$default = SizeKt.m935widthInVpY3zN4$default(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(52)), Dp.m6389constructorimpl(120), 0.0f, 2, null);
                ButtonColors m1923buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1923buttonColorsro_MJ88(ComposeKt.toColor(config.getCtaConfig().getColor()), ComposeKt.toColor(config.getCtaConfig().getTextColor()), 0L, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 12);
                composer2 = startRestartGroup;
                RoundedCornerShape m1149RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(26));
                composer2.startReplaceableGroup(1452466902);
                changedInstance = composer2.changedInstance(viewModel);
                rememberedValue = composer2.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1;
                            FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1(FullscreenPromotedAppCardViewModel.this);
                            return FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                ButtonKt.Button((Function0) rememberedValue, m935widthInVpY3zN4$default, false, m1149RoundedCornerShape0680j_4, m1923buttonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer2, 1264863480, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$FullscreenAdPromotedAppCard$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer composer3, int i5) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        if ((i5 & 17) != 16 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1264863480, i5, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCard.<anonymous>.<anonymous>.<anonymous> (FullscreenAdPromotedAppCard.kt:102)");
                            }
                            TextKt.m2781Text4IGK_g(FullscreenAdSceneConfig.PromotedAppCard.this.getCtaConfig().getText(), (Modifier) null, ComposeKt.toColor(FullscreenAdSceneConfig.PromotedAppCard.this.getCtaConfig().getTextColor()), TextUnitKt.getSp(22), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131058);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, 805306416, 484);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1876259690);
                if (FullscreenAdPromotedAppCard$lambda$0(collectAsState).isRedirectionEnabled()) {
                    boxScopeInstance = boxScopeInstance2;
                } else {
                    boxScopeInstance = boxScopeInstance2;
                    Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                    AdnClickElement.MainMedia mainMedia = AdnClickElement.MainMedia.INSTANCE;
                    composer2.startReplaceableGroup(-1876253607);
                    boolean changedInstance4 = composer2.changedInstance(viewModel);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function3() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit FullscreenAdPromotedAppCard$lambda$10$lambda$5$lambda$4;
                                FullscreenAdPromotedAppCard$lambda$10$lambda$5$lambda$4 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$5$lambda$4(FullscreenPromotedAppCardViewModel.this, (AdnClickElement) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                                return FullscreenAdPromotedAppCard$lambda$10$lambda$5$lambda$4;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    BoxKt.Box(ComposeKt.clickWithCoordinates(matchParentSize, mainMedia, false, (Function3) rememberedValue4, composer2, 48, 2), composer2, 0);
                }
                composer2.endReplaceableGroup();
                AdCloseConfig closeConfig = config.getCloseConfig();
                composer2.startReplaceableGroup(-1876246530);
                changedInstance2 = composer2.changedInstance(viewModel);
                rememberedValue2 = composer2.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6;
                            FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6(FullscreenPromotedAppCardViewModel.this);
                            return FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(-1876244779);
                changedInstance3 = composer2.changedInstance(viewModel);
                rememberedValue3 = composer2.rememberedValue();
                if (!changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8;
                            FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8(FullscreenPromotedAppCardViewModel.this);
                            return FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceableGroup();
                CloseButtonKt.closeButton(closeConfig, function0, 0, (Function0) rememberedValue3, composer2, 0, 4).invoke(boxScopeInstance, composer2, 6);
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
                endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit FullscreenAdPromotedAppCard$lambda$11;
                        FullscreenAdPromotedAppCard$lambda$11 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$11(FullscreenPromotedAppCardViewModel.this, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        return FullscreenAdPromotedAppCard$lambda$11;
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
        final FullscreenAdSceneConfig.PromotedAppCard config2 = FullscreenAdPromotedAppCard$lambda$0(collectAsState).getConfig();
        PromotedAppUiState promotedAppUiState2 = FullscreenAdPromotedAppCard$lambda$0(collectAsState).getPromotedAppUiState();
        Modifier m527backgroundbw27NRU$default2 = BackgroundKt.m527backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), FullscreenAdPromotedAppCard$lambda$0(collectAsState).m9582getBackgroundColor0d7_KjU(), null, 2, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m527backgroundbw27NRU$default2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(fillMaxSize$default2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl2.getInserting()) {
        }
        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        Modifier modifier32 = companion;
        SingletonAsyncImageKt.m6742AsyncImagegl8XCv8(FullscreenAdUiStateKt.icon(promotedAppUiState2), null, ClipKt.clip(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(130)), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(24))), null, null, null, null, 0.0f, null, 0, false, null, startRestartGroup, 48, 0, 4088);
        float f2 = 30;
        SpacerKt.Spacer(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f2)), startRestartGroup, 6);
        name = promotedAppUiState2.getName();
        if (name == null) {
        }
        TextKt.m2781Text4IGK_g(name, SizeKt.wrapContentHeight$default(PaddingKt.m881paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(f2), 0.0f, 2, null), null, false, 3, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m6331getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextStyle(Color.INSTANCE.m4100getWhite0d7_KjU(), TextUnitKt.getSp(28), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null), startRestartGroup, 48, 3120, 54780);
        SpacerKt.Spacer(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(f2)), startRestartGroup, 6);
        Modifier m935widthInVpY3zN4$default2 = SizeKt.m935widthInVpY3zN4$default(SizeKt.m914height3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(52)), Dp.m6389constructorimpl(120), 0.0f, 2, null);
        ButtonColors m1923buttonColorsro_MJ882 = ButtonDefaults.INSTANCE.m1923buttonColorsro_MJ88(ComposeKt.toColor(config2.getCtaConfig().getColor()), ComposeKt.toColor(config2.getCtaConfig().getTextColor()), 0L, 0L, startRestartGroup, ButtonDefaults.$stable << 12, 12);
        composer2 = startRestartGroup;
        RoundedCornerShape m1149RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(26));
        composer2.startReplaceableGroup(1452466902);
        changedInstance = composer2.changedInstance(viewModel);
        rememberedValue = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1;
                FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1(FullscreenPromotedAppCardViewModel.this);
                return FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1;
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        ButtonKt.Button((Function0) rememberedValue, m935widthInVpY3zN4$default2, false, m1149RoundedCornerShape0680j_42, m1923buttonColorsro_MJ882, null, null, null, null, ComposableLambdaKt.composableLambda(composer2, 1264863480, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$FullscreenAdPromotedAppCard$1$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                invoke(rowScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope Button, Composer composer3, int i5) {
                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                if ((i5 & 17) != 16 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1264863480, i5, -1, "io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCard.<anonymous>.<anonymous>.<anonymous> (FullscreenAdPromotedAppCard.kt:102)");
                    }
                    TextKt.m2781Text4IGK_g(FullscreenAdSceneConfig.PromotedAppCard.this.getCtaConfig().getText(), (Modifier) null, ComposeKt.toColor(FullscreenAdSceneConfig.PromotedAppCard.this.getCtaConfig().getTextColor()), TextUnitKt.getSp(22), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3072, 0, 131058);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, 805306416, 484);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1876259690);
        if (FullscreenAdPromotedAppCard$lambda$0(collectAsState).isRedirectionEnabled()) {
        }
        composer2.endReplaceableGroup();
        AdCloseConfig closeConfig2 = config2.getCloseConfig();
        composer2.startReplaceableGroup(-1876246530);
        changedInstance2 = composer2.changedInstance(viewModel);
        rememberedValue2 = composer2.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue2 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6;
                FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6(FullscreenPromotedAppCardViewModel.this);
                return FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        Function0 function02 = (Function0) rememberedValue2;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(-1876244779);
        changedInstance3 = composer2.changedInstance(viewModel);
        rememberedValue3 = composer2.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue3 = new Function0() { // from class: io.adn.sdk.internal.ui.fullscreen.compose.FullscreenAdPromotedAppCardKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8;
                FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8 = FullscreenAdPromotedAppCardKt.FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8(FullscreenPromotedAppCardViewModel.this);
                return FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8;
            }
        };
        composer2.updateRememberedValue(rememberedValue3);
        composer2.endReplaceableGroup();
        CloseButtonKt.closeButton(closeConfig2, function02, 0, (Function0) rememberedValue3, composer2, 0, 4).invoke(boxScopeInstance, composer2, 6);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier32;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdPromotedAppCard$lambda$10$lambda$3$lambda$2$lambda$1(FullscreenPromotedAppCardViewModel fullscreenPromotedAppCardViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenPromotedAppCardViewModel, AdnClickElement.Cta.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdPromotedAppCard$lambda$10$lambda$5$lambda$4(FullscreenPromotedAppCardViewModel fullscreenPromotedAppCardViewModel, AdnClickElement element, int i, int i2) {
        Intrinsics.checkNotNullParameter(element, "element");
        FullscreenSceneViewModel.onClicked$default(fullscreenPromotedAppCardViewModel, element, new ClickPosition(i, i2), false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdPromotedAppCard$lambda$10$lambda$7$lambda$6(FullscreenPromotedAppCardViewModel fullscreenPromotedAppCardViewModel) {
        FullscreenSceneViewModel.onClose$default(fullscreenPromotedAppCardViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullscreenAdPromotedAppCard$lambda$10$lambda$9$lambda$8(FullscreenPromotedAppCardViewModel fullscreenPromotedAppCardViewModel) {
        FullscreenSceneViewModel.onClicked$default(fullscreenPromotedAppCardViewModel, AdnClickElement.Close.INSTANCE, null, false, 6, null);
        return Unit.INSTANCE;
    }

    private static final FullscreenAdSceneUiState.PromotedAppCard FullscreenAdPromotedAppCard$lambda$0(State<FullscreenAdSceneUiState.PromotedAppCard> state) {
        return state.getValue();
    }
}
