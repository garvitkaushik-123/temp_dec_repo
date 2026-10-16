package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ad.AdPrivacyConfig;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyButton.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0001¢\u0006\u0002\u0010\n\u001a?\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"privacyButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "config", "Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;", "onClick", "Lkotlin/Function0;", "(Lio/adn/sdk/internal/domain/model/ad/AdPrivacyConfig;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function3;", "PrivacyButton", "modifier", "Landroidx/compose/ui/Modifier;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/DpSize;", "color", "Landroidx/compose/ui/graphics/Color;", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "PrivacyButton-eHsvuiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;JJLandroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PrivacyButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrivacyButton_eHsvuiA$lambda$3(Modifier modifier, Function0 function0, long j, long j2, Painter painter, int i, int i2, Composer composer, int i3) {
        m9531PrivacyButtoneHsvuiA(modifier, function0, j, j2, painter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> privacyButton(final AdPrivacyConfig config, final Function0<Unit> onClick, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        composer.startReplaceableGroup(-1647954670);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1647954670, i, -1, "io.adn.sdk.internal.ui.common.design.compose.privacyButton (PrivacyButton.kt:22)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 586565048, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt$privacyButton$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i2 & 6) == 0) {
                    i2 |= composer2.changed(boxScope) ? 4 : 2;
                }
                if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(586565048, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.privacyButton.<anonymous> (PrivacyButton.kt:23)");
                    }
                    PrivacyButtonKt.m9531PrivacyButtoneHsvuiA(PaddingKt.padding(boxScope.align(Modifier.INSTANCE, ComposeKt.toAlignment(AdPrivacyConfig.this.getPosition())), UIConstants.INSTANCE.getICON_BUTTON_PADDING$adn_sdk_release()), onClick, ComposeKt.toDpSize(AdPrivacyConfig.this.getSize()), ComposeKt.toColor(AdPrivacyConfig.this.getColor()), null, composer2, 0, 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        if ((r33 & 16) != 0) goto L71;
     */
    /* renamed from: PrivacyButton-eHsvuiA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9531PrivacyButtoneHsvuiA(final Modifier modifier, final Function0<Unit> onClick, final long j, final long j2, Painter painter, Composer composer, final int i, final int i2) {
        int i3;
        Painter painter2;
        Composer composer2;
        final Painter painter3;
        int i4;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1433988273);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                painter2 = painter;
                if (startRestartGroup.changedInstance(painter2)) {
                    i4 = 16384;
                    i3 |= i4;
                }
            } else {
                painter2 = painter;
            }
            i4 = 8192;
            i3 |= i4;
        } else {
            painter2 = painter;
        }
        if ((i3 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if ((i2 & 16) != 0) {
                    painter2 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_info, startRestartGroup, 0);
                    i3 &= -57345;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1433988273, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.PrivacyButton (PrivacyButton.kt:40)");
                }
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
                startRestartGroup.startReplaceableGroup(-1757141775);
                boolean z = (i3 & 112) == 32;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PrivacyButton_eHsvuiA$lambda$2$lambda$1$lambda$0;
                            PrivacyButton_eHsvuiA$lambda$2$lambda$1$lambda$0 = PrivacyButtonKt.PrivacyButton_eHsvuiA$lambda$2$lambda$1$lambda$0(Function0.this);
                            return PrivacyButton_eHsvuiA$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                Painter painter4 = painter2;
                GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter4, (Function0) rememberedValue, null, false, "privacy", j2, j, false, 0.0f, composer2, ((i3 >> 9) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (3670016 & (i3 << 9)) | ((i3 << 15) & 29360128), 793);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                painter3 = painter4;
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            painter3 = painter2;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.PrivacyButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PrivacyButton_eHsvuiA$lambda$3;
                    PrivacyButton_eHsvuiA$lambda$3 = PrivacyButtonKt.PrivacyButton_eHsvuiA$lambda$3(Modifier.this, onClick, j, j2, painter3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return PrivacyButton_eHsvuiA$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrivacyButton_eHsvuiA$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
