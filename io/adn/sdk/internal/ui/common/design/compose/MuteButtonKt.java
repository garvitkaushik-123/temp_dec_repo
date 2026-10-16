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
import io.adn.sdk.internal.domain.model.ad.AdMuteConfig;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MuteButton.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aO\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001H\u0001¢\u0006\u0002\u0010\f\u001ak\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"muteButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "config", "Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "isEnabled", "", "isMuted", "onMuteChange", "(Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function3;", "MuteButton", "modifier", "Landroidx/compose/ui/Modifier;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/DpSize;", "color", "Landroidx/compose/ui/graphics/Color;", "muteIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "unmuteIcon", "useDefaultBackground", "MuteButton-AI0w5tM", "(ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MuteButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MuteButton_AI0w5tM$lambda$3(boolean z, boolean z2, Function1 function1, Modifier modifier, long j, long j2, Painter painter, Painter painter2, boolean z3, int i, int i2, Composer composer, int i3) {
        m9528MuteButtonAI0w5tM(z, z2, function1, modifier, j, j2, painter, painter2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> muteButton(final AdMuteConfig config, final boolean z, final boolean z2, final Function1<? super Boolean, Unit> onMuteChange, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onMuteChange, "onMuteChange");
        composer.startReplaceableGroup(1562016242);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1562016242, i, -1, "io.adn.sdk.internal.ui.common.design.compose.muteButton (MuteButton.kt:24)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 280724108, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$muteButton$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i2) {
                int i3;
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer2.changed(boxScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i3 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(280724108, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.muteButton.<anonymous> (MuteButton.kt:25)");
                    }
                    MuteButtonKt.m9528MuteButtonAI0w5tM(z, z2, onMuteChange, PaddingKt.padding(boxScope.align(Modifier.INSTANCE, ComposeKt.toAlignment(AdMuteConfig.this.getPosition())), UIConstants.INSTANCE.getICON_BUTTON_PADDING$adn_sdk_release()), ComposeKt.toDpSize(AdMuteConfig.this.getSize()), ComposeKt.toColor(AdMuteConfig.this.getColor()), null, null, false, composer2, 0, 448);
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0254  */
    /* renamed from: MuteButton-AI0w5tM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9528MuteButtonAI0w5tM(final boolean z, final boolean z2, final Function1<? super Boolean, Unit> onMuteChange, Modifier modifier, final long j, final long j2, Painter painter, Painter painter2, boolean z3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Painter painter3;
        Painter painter4;
        int i4;
        int i5;
        int i6;
        int i7;
        Painter painter5;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean z4;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier3;
        final Painter painter6;
        final boolean z5;
        final Painter painter7;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Intrinsics.checkNotNullParameter(onMuteChange, "onMuteChange");
        Composer startRestartGroup = composer.startRestartGroup(-1251596351);
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
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(onMuteChange) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changed(j) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changed(j2) ? 131072 : 65536;
            }
            if ((i & 1572864) != 0) {
                painter3 = painter;
                i3 |= ((i2 & 64) == 0 && startRestartGroup.changedInstance(painter3)) ? 1048576 : 524288;
            } else {
                painter3 = painter;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    painter4 = painter2;
                    if (startRestartGroup.changedInstance(painter4)) {
                        i8 = 8388608;
                        i3 |= i8;
                    }
                } else {
                    painter4 = painter2;
                }
                i8 = 4194304;
                i3 |= i8;
            } else {
                painter4 = painter2;
            }
            i4 = i2 & 256;
            if (i4 == 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i5 = i4;
                i3 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                i6 = i3;
                if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    boolean z6 = true;
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 64) != 0) {
                            painter3 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_volume_off, startRestartGroup, 0);
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            painter4 = PainterResources_androidKt.painterResource(R.drawable.adn_ic_volume_up, startRestartGroup, 0);
                        }
                        if (i5 != 0) {
                            i7 = i6;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                painter5 = painter4;
                            } else {
                                painter5 = painter4;
                                ComposerKt.traceEventStart(-1251596351, i7, -1, "io.adn.sdk.internal.ui.common.design.compose.MuteButton (MuteButton.kt:48)");
                            }
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
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
                            Painter painter8 = !z2 ? painter3 : painter5;
                            startRestartGroup.startReplaceableGroup(-939343808);
                            z4 = ((i7 & 896) != 256) | ((i7 & 14) != 4) | ((i7 & 112) == 32);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                                        MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0 = MuteButtonKt.MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0(z, onMuteChange, z2);
                                        return MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            composer2 = startRestartGroup;
                            GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter8, (Function0) rememberedValue, null, false, "Mute/Unmute", j2, j, z6, 0.0f, composer2, ((i7 << 3) & 3670016) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i7 << 9) & 29360128) | (i7 & 234881024), 537);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            painter6 = painter3;
                            z5 = z6;
                            painter7 = painter5;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                        }
                    }
                    i7 = i6;
                    z6 = z3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier2);
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
                    if (!z2) {
                    }
                    startRestartGroup.startReplaceableGroup(-939343808);
                    if ((i7 & 14) != 4) {
                    }
                    z4 = ((i7 & 896) != 256) | ((i7 & 14) != 4) | ((i7 & 112) == 32);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z4) {
                    }
                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                            MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0 = MuteButtonKt.MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0(z, onMuteChange, z2);
                            return MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    composer2 = startRestartGroup;
                    GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter8, (Function0) rememberedValue, null, false, "Mute/Unmute", j2, j, z6, 0.0f, composer2, ((i7 << 3) & 3670016) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i7 << 9) & 29360128) | (i7 & 234881024), 537);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    painter6 = painter3;
                    z5 = z6;
                    painter7 = painter5;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    painter6 = painter3;
                    z5 = z3;
                    painter7 = painter4;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit MuteButton_AI0w5tM$lambda$3;
                            MuteButton_AI0w5tM$lambda$3 = MuteButtonKt.MuteButton_AI0w5tM$lambda$3(z, z2, onMuteChange, modifier3, j, j2, painter6, painter7, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return MuteButton_AI0w5tM$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            i5 = i4;
            i6 = i3;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            boolean z62 = true;
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i5 != 0) {
            }
            i7 = i6;
            z62 = z3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(modifier2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
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
            if (!z2) {
            }
            startRestartGroup.startReplaceableGroup(-939343808);
            if ((i7 & 14) != 4) {
            }
            z4 = ((i7 & 896) != 256) | ((i7 & 14) != 4) | ((i7 & 112) == 32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                    MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0 = MuteButtonKt.MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0(z, onMuteChange, z2);
                    return MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter8, (Function0) rememberedValue, null, false, "Mute/Unmute", j2, j, z62, 0.0f, composer2, ((i7 << 3) & 3670016) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i7 << 9) & 29360128) | (i7 & 234881024), 537);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            painter6 = painter3;
            z5 = z62;
            painter7 = painter5;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i4 = i2 & 256;
        if (i4 == 0) {
        }
        i5 = i4;
        i6 = i3;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        boolean z622 = true;
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i5 != 0) {
        }
        i7 = i6;
        z622 = z3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(modifier2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
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
        if (!z2) {
        }
        startRestartGroup.startReplaceableGroup(-939343808);
        if ((i7 & 14) != 4) {
        }
        z4 = ((i7 & 896) != 256) | ((i7 & 14) != 4) | ((i7 & 112) == 32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.MuteButtonKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
                MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0 = MuteButtonKt.MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0(z, onMuteChange, z2);
                return MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        composer2 = startRestartGroup;
        GenericIconButtonKt.m9526GenericIconButtonmPunlVI(null, painter8, (Function0) rememberedValue, null, false, "Mute/Unmute", j2, j, z622, 0.0f, composer2, ((i7 << 3) & 3670016) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i7 << 9) & 29360128) | (i7 & 234881024), 537);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        painter6 = painter3;
        z5 = z622;
        painter7 = painter5;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MuteButton_AI0w5tM$lambda$2$lambda$1$lambda$0(boolean z, Function1 function1, boolean z2) {
        if (z) {
            function1.invoke(Boolean.valueOf(!z2));
        }
        return Unit.INSTANCE;
    }
}
