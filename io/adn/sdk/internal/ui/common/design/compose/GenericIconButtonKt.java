package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericIconButton.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001ay\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"GenericIconButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "onClick", "Lkotlin/Function0;", "onOutsideClick", "enabled", "", "contentDescription", "", "tint", "Landroidx/compose/ui/graphics/Color;", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/DpSize;", "useDefaultBackground", "clickableSizeRatio", "", "GenericIconButton-mPunlVI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLjava/lang/String;JJZFLandroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GenericIconButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericIconButton_mPunlVI$lambda$3(Modifier modifier, Painter painter, Function0 function0, Function0 function02, boolean z, String str, long j, long j2, boolean z2, float f, int i, int i2, Composer composer, int i3) {
        m9526GenericIconButtonmPunlVI(modifier, painter, function0, function02, z, str, j, j2, z2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0101  */
    /* renamed from: GenericIconButton-mPunlVI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9526GenericIconButtonmPunlVI(Modifier modifier, final Painter painter, final Function0<Unit> onClick, Function0<Unit> function0, boolean z, String str, final long j, final long j2, boolean z2, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function0<Unit> function02;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function03;
        final boolean z4;
        Function0<Unit> function04;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        Modifier clip;
        final String str2;
        final boolean z5;
        final float f2;
        final Modifier modifier3;
        final Function0<Unit> function05;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1293998106);
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(painter) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            function02 = function0;
            i3 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changed(str) ? 131072 : 65536;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                    i6 = i10;
                } else {
                    i6 = i10;
                    if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(j) ? 1048576 : 524288;
                    }
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(j2) ? 8388608 : 4194304;
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                    i3 |= 100663296;
                } else if ((100663296 & i) == 0) {
                    i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    i8 = i2 & 512;
                    if (i8 == 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i11 != 0) {
                                startRestartGroup.startReplaceableGroup(-903177133);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.GenericIconButtonKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                function03 = (Function0) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                function03 = function02;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            String str3 = i5 != 0 ? null : str;
                            z4 = i7 != 0 ? true : z2;
                            float f3 = i9 != 0 ? 1.0f : f;
                            if (ComposerKt.isTraceInProgress()) {
                                function04 = function03;
                                ComposerKt.traceEventStart(-1293998106, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.GenericIconButton (GenericIconButton.kt:29)");
                            } else {
                                function04 = function03;
                            }
                            Modifier m929size6HolHcs = SizeKt.m929size6HolHcs(companion, j2);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier modifier4 = companion;
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m929size6HolHcs);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
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
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            startRestartGroup.startReplaceableGroup(1038750572);
                            if (z4) {
                                clip = ComposeKt.defaultButtonBackground(Modifier.INSTANCE, startRestartGroup, 6);
                            } else {
                                clip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape());
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier then = fillMaxSize$default.then(clip);
                            int i12 = i3 >> 3;
                            float f4 = f3;
                            BoxKt.Box(ComposeKt.noRippleClickable(then, false, function04, startRestartGroup, i12 & 896, 1), startRestartGroup, 0);
                            int i13 = i3 >> 9;
                            int i14 = (i12 & 14) | ((i3 >> 12) & 112) | (i13 & 7168);
                            String str4 = str3;
                            IconKt.m2253Iconww6aTOc(painter, str4, (Modifier) null, j, startRestartGroup, i14, 4);
                            str2 = str4;
                            startRestartGroup = startRestartGroup;
                            boolean z6 = z3;
                            BoxKt.Box(ComposeKt.noRippleClickable(SizeKt.fillMaxSize(Modifier.INSTANCE, f4), z6, onClick, startRestartGroup, (i13 & 112) | (i3 & 896), 0), startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z5 = z6;
                            f2 = f4;
                            modifier3 = modifier4;
                            function05 = function04;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            str2 = str;
                            z4 = z2;
                            modifier3 = modifier2;
                            function05 = function02;
                            z5 = z3;
                            f2 = f;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.GenericIconButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit GenericIconButton_mPunlVI$lambda$3;
                                    GenericIconButton_mPunlVI$lambda$3 = GenericIconButtonKt.GenericIconButton_mPunlVI$lambda$3(Modifier.this, painter, onClick, function05, z5, str2, j, j2, z4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    return GenericIconButton_mPunlVI$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    if (i6 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier m929size6HolHcs2 = SizeKt.m929size6HolHcs(companion, j2);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    Modifier modifier42 = companion;
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m929size6HolHcs2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
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
                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    startRestartGroup.startReplaceableGroup(1038750572);
                    if (z4) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier then2 = fillMaxSize$default2.then(clip);
                    int i122 = i3 >> 3;
                    float f42 = f3;
                    BoxKt.Box(ComposeKt.noRippleClickable(then2, false, function04, startRestartGroup, i122 & 896, 1), startRestartGroup, 0);
                    int i132 = i3 >> 9;
                    int i142 = (i122 & 14) | ((i3 >> 12) & 112) | (i132 & 7168);
                    String str42 = str3;
                    IconKt.m2253Iconww6aTOc(painter, str42, (Modifier) null, j, startRestartGroup, i142, 4);
                    str2 = str42;
                    startRestartGroup = startRestartGroup;
                    boolean z62 = z3;
                    BoxKt.Box(ComposeKt.noRippleClickable(SizeKt.fillMaxSize(Modifier.INSTANCE, f42), z62, onClick, startRestartGroup, (i132 & 112) | (i3 & 896), 0), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z5 = z62;
                    f2 = f42;
                    modifier3 = modifier42;
                    function05 = function04;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i2 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i3 & 306783379) == 306783378) {
                }
                if (i6 != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m929size6HolHcs22 = SizeKt.m929size6HolHcs(companion, j2);
                Alignment center22 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                Modifier modifier422 = companion;
                MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m929size6HolHcs22);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
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
                Modifier fillMaxSize$default22 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                startRestartGroup.startReplaceableGroup(1038750572);
                if (z4) {
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then22 = fillMaxSize$default22.then(clip);
                int i1222 = i3 >> 3;
                float f422 = f3;
                BoxKt.Box(ComposeKt.noRippleClickable(then22, false, function04, startRestartGroup, i1222 & 896, 1), startRestartGroup, 0);
                int i1322 = i3 >> 9;
                int i1422 = (i1222 & 14) | ((i3 >> 12) & 112) | (i1322 & 7168);
                String str422 = str3;
                IconKt.m2253Iconww6aTOc(painter, str422, (Modifier) null, j, startRestartGroup, i1422, 4);
                str2 = str422;
                startRestartGroup = startRestartGroup;
                boolean z622 = z3;
                BoxKt.Box(ComposeKt.noRippleClickable(SizeKt.fillMaxSize(Modifier.INSTANCE, f422), z622, onClick, startRestartGroup, (i1322 & 112) | (i3 & 896), 0), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z622;
                f2 = f422;
                modifier3 = modifier422;
                function05 = function04;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            i8 = i2 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i3 & 306783379) == 306783378) {
            }
            if (i6 != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m929size6HolHcs222 = SizeKt.m929size6HolHcs(companion, j2);
            Alignment center222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier modifier4222 = companion;
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m929size6HolHcs222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
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
            Modifier fillMaxSize$default222 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(1038750572);
            if (z4) {
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then222 = fillMaxSize$default222.then(clip);
            int i12222 = i3 >> 3;
            float f4222 = f3;
            BoxKt.Box(ComposeKt.noRippleClickable(then222, false, function04, startRestartGroup, i12222 & 896, 1), startRestartGroup, 0);
            int i13222 = i3 >> 9;
            int i14222 = (i12222 & 14) | ((i3 >> 12) & 112) | (i13222 & 7168);
            String str4222 = str3;
            IconKt.m2253Iconww6aTOc(painter, str4222, (Modifier) null, j, startRestartGroup, i14222, 4);
            str2 = str4222;
            startRestartGroup = startRestartGroup;
            boolean z6222 = z3;
            BoxKt.Box(ComposeKt.noRippleClickable(SizeKt.fillMaxSize(Modifier.INSTANCE, f4222), z6222, onClick, startRestartGroup, (i13222 & 112) | (i3 & 896), 0), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z6222;
            f2 = f4222;
            modifier3 = modifier4222;
            function05 = function04;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        i8 = i2 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i3 & 306783379) == 306783378) {
        }
        if (i6 != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m929size6HolHcs2222 = SizeKt.m929size6HolHcs(companion, j2);
        Alignment center2222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        Modifier modifier42222 = companion;
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(m929size6HolHcs2222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        modifierMaterializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        Modifier fillMaxSize$default2222 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1038750572);
        if (z4) {
        }
        startRestartGroup.endReplaceableGroup();
        Modifier then2222 = fillMaxSize$default2222.then(clip);
        int i122222 = i3 >> 3;
        float f42222 = f3;
        BoxKt.Box(ComposeKt.noRippleClickable(then2222, false, function04, startRestartGroup, i122222 & 896, 1), startRestartGroup, 0);
        int i132222 = i3 >> 9;
        int i142222 = (i122222 & 14) | ((i3 >> 12) & 112) | (i132222 & 7168);
        String str42222 = str3;
        IconKt.m2253Iconww6aTOc(painter, str42222, (Modifier) null, j, startRestartGroup, i142222, 4);
        str2 = str42222;
        startRestartGroup = startRestartGroup;
        boolean z62222 = z3;
        BoxKt.Box(ComposeKt.noRippleClickable(SizeKt.fillMaxSize(Modifier.INSTANCE, f42222), z62222, onClick, startRestartGroup, (i132222 & 112) | (i3 & 896), 0), startRestartGroup, 0);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z62222;
        f2 = f42222;
        modifier3 = modifier42222;
        function05 = function04;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
