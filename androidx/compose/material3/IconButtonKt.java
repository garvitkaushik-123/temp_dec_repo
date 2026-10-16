package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IconButton.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001an\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001a`\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001an\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0016\u001aV\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001ad\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u001c\u001al\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010 \u001az\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"FilledIconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconButton", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(final Function0<Unit> function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        IconButtonColors iconButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        int i6;
        MutableInteractionSource mutableInteractionSource3;
        boolean z3;
        IconButtonColors iconButtonColors3;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final Modifier modifier3;
        final IconButtonColors iconButtonColors4;
        final MutableInteractionSource mutableInteractionSource4;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1142896114);
        ComposerKt.sourceInformation(startRestartGroup, "C(IconButton)P(5,4,2!1,3)78@3867L18,79@3937L39,87@4239L5,94@4557L135,83@4057L857:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        if (startRestartGroup.changed(iconButtonColors2)) {
                            i7 = 2048;
                            i3 |= i7;
                        }
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i7 = 1024;
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
                    }
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(startRestartGroup, 6);
                            }
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(793644531);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                i6 = i3;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                z3 = z2;
                                iconButtonColors3 = iconButtonColors2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1142896114, i6, -1, "androidx.compose.material3.IconButton (IconButton.kt:81)");
                                }
                                int i9 = i6;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                boolean z4 = z3;
                                Modifier m559clickableO2vRcR0$default = ClickableKt.m559clickableO2vRcR0$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors3.m2237containerColorvNxB06k$material3_release(z3), null, 2, null), mutableInteractionSource5, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, null, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 8, null);
                                z2 = z4;
                                Alignment center = Alignment.INSTANCE.getCenter();
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m559clickableO2vRcR0$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.useNode();
                                } else {
                                    startRestartGroup.createNode(constructor);
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
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676789843, "C102@4824L84:IconButton.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconButtonColors3.m2238contentColorvNxB06k$material3_release(z2))), function2, startRestartGroup, ProvidedValue.$stable | ((i9 >> 12) & 112));
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                iconButtonColors4 = iconButtonColors3;
                                mutableInteractionSource4 = mutableInteractionSource5;
                            } else {
                                i6 = i3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            i6 = i3;
                            companion = modifier2;
                        }
                        z3 = z2;
                        iconButtonColors3 = iconButtonColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i6;
                        MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                        boolean z42 = z3;
                        Modifier m559clickableO2vRcR0$default2 = ClickableKt.m559clickableO2vRcR0$default(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors3.m2237containerColorvNxB06k$material3_release(z3), null, 2, null), mutableInteractionSource52, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z42, null, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), function02, 8, null);
                        z2 = z42;
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m559clickableO2vRcR0$default2);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1676789843, "C102@4824L84:IconButton.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconButtonColors3.m2238contentColorvNxB06k$material3_release(z2))), function2, startRestartGroup, ProvidedValue.$stable | ((i92 >> 12) & 112));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = companion;
                        iconButtonColors4 = iconButtonColors3;
                        mutableInteractionSource4 = mutableInteractionSource52;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        iconButtonColors4 = iconButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    final boolean z5 = z2;
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$IconButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                IconButtonKt.IconButton(function0, modifier3, z5, iconButtonColors4, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) == 0) {
                }
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 == 0) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) == 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 == 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i4;
        boolean z3;
        IconToggleButtonColors iconToggleButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        IconToggleButtonColors iconToggleButtonColors3;
        int i6;
        IconToggleButtonColors iconToggleButtonColors4;
        Modifier modifier3;
        final boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(692561811);
        ComposerKt.sourceInformation(startRestartGroup, "C(IconToggleButton)P(!1,6,5,3!1,4)140@6931L24,141@7007L39,149@7309L5,150@7355L32,157@7692L135,145@7127L937:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                        if (startRestartGroup.changed(iconToggleButtonColors2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    iconToggleButtonColors2 = iconToggleButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z5 = i4 == 0 ? true : z3;
                            if ((i2 & 16) == 0) {
                                iconToggleButtonColors3 = IconButtonDefaults.INSTANCE.m2249iconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1572864, 63);
                                startRestartGroup = startRestartGroup;
                                i3 &= -57345;
                            } else {
                                iconToggleButtonColors3 = iconToggleButtonColors2;
                            }
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(155032829);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColors3;
                                i6 = i3;
                                iconToggleButtonColors4 = iconToggleButtonColors5;
                                modifier3 = companion;
                                z4 = z5;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                IconToggleButtonColors iconToggleButtonColors6 = iconToggleButtonColors3;
                                i6 = i3;
                                iconToggleButtonColors4 = iconToggleButtonColors6;
                                modifier3 = companion;
                                z4 = z5;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            i6 = i3;
                            modifier3 = modifier2;
                            z4 = z3;
                            iconToggleButtonColors4 = iconToggleButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(692561811, i6, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:143)");
                        }
                        int i9 = ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 896);
                        int i10 = i6;
                        iconToggleButtonColors2 = iconToggleButtonColors4;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        Modifier m1124toggleableO2vRcR0 = ToggleableKt.m1124toggleableO2vRcR0(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconToggleButtonColors4.containerColor$material3_release(z4, z, startRestartGroup, i9).getValue().m4073unboximpl(), null, 2, null), z, mutableInteractionSource5, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, Role.m5709boximpl(Role.INSTANCE.m5717getCheckboxo7Vup1c()), function12);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1124toggleableO2vRcR0);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.useNode();
                        } else {
                            startRestartGroup.createNode(constructor);
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 165225886, "C164@7929L30,165@7974L84:IconButton.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconToggleButtonColors2.contentColor$material3_release(z4, z, startRestartGroup, i9).getValue().m4073unboximpl())), function2, startRestartGroup, ProvidedValue.$stable | ((i10 >> 15) & 112));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource5;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    final IconToggleButtonColors iconToggleButtonColors7 = iconToggleButtonColors2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$IconToggleButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11) {
                                IconButtonKt.IconToggleButton(z, function1, modifier4, z4, iconToggleButtonColors7, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i5 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i92 = ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 896);
                int i102 = i6;
                iconToggleButtonColors2 = iconToggleButtonColors4;
                MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                Modifier m1124toggleableO2vRcR02 = ToggleableKt.m1124toggleableO2vRcR0(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconToggleButtonColors4.containerColor$material3_release(z4, z, startRestartGroup, i92).getValue().m4073unboximpl(), null, 2, null), z, mutableInteractionSource52, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, Role.m5709boximpl(Role.INSTANCE.m5717getCheckboxo7Vup1c()), function12);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1124toggleableO2vRcR02);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 165225886, "C164@7929L30,165@7974L84:IconButton.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconToggleButtonColors2.contentColor$material3_release(z4, z, startRestartGroup, i92).getValue().m4073unboximpl())), function2, startRestartGroup, ProvidedValue.$stable | ((i102 >> 15) & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource4 = mutableInteractionSource52;
                modifier4 = modifier3;
                final IconToggleButtonColors iconToggleButtonColors72 = iconToggleButtonColors2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i5 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i922 = ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 896);
            int i1022 = i6;
            iconToggleButtonColors2 = iconToggleButtonColors4;
            MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
            Modifier m1124toggleableO2vRcR022 = ToggleableKt.m1124toggleableO2vRcR0(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconToggleButtonColors4.containerColor$material3_release(z4, z, startRestartGroup, i922).getValue().m4073unboximpl(), null, 2, null), z, mutableInteractionSource522, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, Role.m5709boximpl(Role.INSTANCE.m5717getCheckboxo7Vup1c()), function12);
            Alignment center22 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m1124toggleableO2vRcR022);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 165225886, "C164@7929L30,165@7974L84:IconButton.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconToggleButtonColors2.contentColor$material3_release(z4, z, startRestartGroup, i922).getValue().m4073unboximpl())), function2, startRestartGroup, ProvidedValue.$stable | ((i1022 >> 15) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource522;
            modifier4 = modifier3;
            final IconToggleButtonColors iconToggleButtonColors722 = iconToggleButtonColors2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i5 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i9222 = ((i6 >> 9) & 14) | ((i6 << 3) & 112) | ((i6 >> 6) & 896);
        int i10222 = i6;
        iconToggleButtonColors2 = iconToggleButtonColors4;
        MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
        Modifier m1124toggleableO2vRcR0222 = ToggleableKt.m1124toggleableO2vRcR0(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m928size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3), IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(IconButtonTokens.INSTANCE.getStateLayerShape(), startRestartGroup, 6)), iconToggleButtonColors4.containerColor$material3_release(z4, z, startRestartGroup, i9222).getValue().m4073unboximpl(), null, 2, null), z, mutableInteractionSource5222, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(IconButtonTokens.INSTANCE.m3248getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, Role.m5709boximpl(Role.INSTANCE.m5717getCheckboxo7Vup1c()), function12);
        Alignment center222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m1124toggleableO2vRcR0222);
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
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 165225886, "C164@7929L30,165@7974L84:IconButton.kt#uh7d8r");
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(iconToggleButtonColors2.contentColor$material3_release(z4, z, startRestartGroup, i9222).getValue().m4073unboximpl())), function2, startRestartGroup, ProvidedValue.$stable | ((i10222 >> 15) & 112));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource5222;
        modifier4 = modifier3;
        final IconToggleButtonColors iconToggleButtonColors7222 = iconToggleButtonColors2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a6  */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        Composer composer2;
        boolean z3;
        IconButtonColors iconButtonColors3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        Shape shape4;
        int i6;
        IconButtonColors iconButtonColors4;
        ?? r1;
        Composer composer3;
        final IconButtonColors iconButtonColors5;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape5;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1594730011);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledIconButton)P(5,4,2,6!1,3)203@10017L11,204@10080L24,205@10156L39,207@10237L429:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        if (startRestartGroup.changed(iconButtonColors2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 == 0 ? true : z2;
                            if ((i2 & 8) == 0) {
                                shape3 = IconButtonDefaults.INSTANCE.getFilledShape(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 16) == 0) {
                                z3 = true;
                                iconButtonColors3 = IconButtonDefaults.INSTANCE.m2244filledIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, startRestartGroup, 24576, 15);
                                composer2 = startRestartGroup;
                                i3 &= -57345;
                            } else {
                                composer2 = startRestartGroup;
                                z3 = true;
                                iconButtonColors3 = iconButtonColors2;
                            }
                            if (i5 == 0) {
                                composer2.startReplaceableGroup(825486780);
                                ComposerKt.sourceInformation(composer2, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = composer2.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                shape4 = shape3;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                z4 = z6;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                z4 = z6;
                                shape4 = shape3;
                            }
                            i6 = i3;
                            iconButtonColors4 = iconButtonColors3;
                            r1 = z3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            companion = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i6 = i3;
                            shape4 = shape2;
                            iconButtonColors4 = iconButtonColors2;
                            composer2 = startRestartGroup;
                            z4 = z2;
                            r1 = 1;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1594730011, i6, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:207)");
                        }
                        composer3 = composer2;
                        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                            }
                        }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1560623888, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i10) {
                                ComposerKt.sourceInformation(composer4, "C216@10512L152:IconButton.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1560623888, i10, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:216)");
                                    }
                                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1557816725, "C220@10649L9:IconButton.kt#uh7d8r");
                                    function22.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        iconButtonColors5 = iconButtonColors4;
                        modifier3 = companion;
                        z5 = z4;
                        shape5 = shape4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer3 = startRestartGroup;
                        modifier3 = modifier2;
                        z5 = z2;
                        shape5 = shape2;
                        iconButtonColors5 = iconButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i10) {
                                IconButtonKt.FilledIconButton(function0, modifier3, z5, shape5, iconButtonColors5, mutableInteractionSource4, function2, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i5 == 0) {
                }
                i6 = i3;
                iconButtonColors4 = iconButtonColors3;
                r1 = z3;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer3 = composer2;
                SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1560623888, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i10) {
                        ComposerKt.sourceInformation(composer4, "C216@10512L152:IconButton.kt#uh7d8r");
                        if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1560623888, i10, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:216)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1557816725, "C220@10649L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
                if (ComposerKt.isTraceInProgress()) {
                }
                iconButtonColors5 = iconButtonColors4;
                modifier3 = companion;
                z5 = z4;
                shape5 = shape4;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i5 == 0) {
            }
            i6 = i3;
            iconButtonColors4 = iconButtonColors3;
            r1 = z3;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer3 = composer2;
            SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1560623888, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i10) {
                    ComposerKt.sourceInformation(composer4, "C216@10512L152:IconButton.kt#uh7d8r");
                    if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1560623888, i10, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:216)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                        composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -1557816725, "C220@10649L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceableGroup();
                        composer4.endNode();
                        composer4.endReplaceableGroup();
                        composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
            }
            iconButtonColors5 = iconButtonColors4;
            modifier3 = companion;
            z5 = z4;
            shape5 = shape4;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i5 == 0) {
        }
        i6 = i3;
        iconButtonColors4 = iconButtonColors3;
        r1 = z3;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer3 = composer2;
        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1560623888, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                invoke(composer4, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer4, int i10) {
                ComposerKt.sourceInformation(composer4, "C216@10512L152:IconButton.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1560623888, i10, -1, "androidx.compose.material3.FilledIconButton.<anonymous> (IconButton.kt:216)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor);
                    } else {
                        composer4.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -1557816725, "C220@10649L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer4, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
        if (ComposerKt.isTraceInProgress()) {
        }
        iconButtonColors5 = iconButtonColors4;
        modifier3 = companion;
        z5 = z4;
        shape5 = shape4;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a6  */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        Composer composer2;
        boolean z3;
        IconButtonColors iconButtonColors3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        Shape shape4;
        int i6;
        IconButtonColors iconButtonColors4;
        ?? r1;
        Composer composer3;
        final IconButtonColors iconButtonColors5;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape5;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-783937767);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledTonalIconButton)P(5,4,2,6!1,3)263@12954L11,264@13017L29,265@13098L39,267@13179L434:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        if (startRestartGroup.changed(iconButtonColors2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            boolean z6 = i4 == 0 ? true : z2;
                            if ((i2 & 8) == 0) {
                                shape3 = IconButtonDefaults.INSTANCE.getFilledShape(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 16) == 0) {
                                z3 = true;
                                iconButtonColors3 = IconButtonDefaults.INSTANCE.m2246filledTonalIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, startRestartGroup, 24576, 15);
                                composer2 = startRestartGroup;
                                i3 &= -57345;
                            } else {
                                composer2 = startRestartGroup;
                                z3 = true;
                                iconButtonColors3 = iconButtonColors2;
                            }
                            if (i5 == 0) {
                                composer2.startReplaceableGroup(1459260166);
                                ComposerKt.sourceInformation(composer2, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = composer2.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                shape4 = shape3;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                z4 = z6;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                z4 = z6;
                                shape4 = shape3;
                            }
                            i6 = i3;
                            iconButtonColors4 = iconButtonColors3;
                            r1 = z3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            companion = modifier2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            i6 = i3;
                            shape4 = shape2;
                            iconButtonColors4 = iconButtonColors2;
                            composer2 = startRestartGroup;
                            z4 = z2;
                            r1 = 1;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-783937767, i6, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:267)");
                        }
                        composer3 = composer2;
                        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                            }
                        }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1772884636, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i10) {
                                ComposerKt.sourceInformation(composer4, "C276@13454L157:IconButton.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1772884636, i10, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:276)");
                                    }
                                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 151425978, "C280@13596L9:IconButton.kt#uh7d8r");
                                    function22.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        iconButtonColors5 = iconButtonColors4;
                        modifier3 = companion;
                        z5 = z4;
                        shape5 = shape4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer3 = startRestartGroup;
                        modifier3 = modifier2;
                        z5 = z2;
                        shape5 = shape2;
                        iconButtonColors5 = iconButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i10) {
                                IconButtonKt.FilledTonalIconButton(function0, modifier3, z5, shape5, iconButtonColors5, mutableInteractionSource4, function2, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 64) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i5 == 0) {
                }
                i6 = i3;
                iconButtonColors4 = iconButtonColors3;
                r1 = z3;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer3 = composer2;
                SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1772884636, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i10) {
                        ComposerKt.sourceInformation(composer4, "C276@13454L157:IconButton.kt#uh7d8r");
                        if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1772884636, i10, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:276)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 151425978, "C280@13596L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
                if (ComposerKt.isTraceInProgress()) {
                }
                iconButtonColors5 = iconButtonColors4;
                modifier3 = companion;
                z5 = z4;
                shape5 = shape4;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 64) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i5 == 0) {
            }
            i6 = i3;
            iconButtonColors4 = iconButtonColors3;
            r1 = z3;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer3 = composer2;
            SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1772884636, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i10) {
                    ComposerKt.sourceInformation(composer4, "C276@13454L157:IconButton.kt#uh7d8r");
                    if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1772884636, i10, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:276)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                        composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, 151425978, "C280@13596L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceableGroup();
                        composer4.endNode();
                        composer4.endReplaceableGroup();
                        composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
            if (ComposerKt.isTraceInProgress()) {
            }
            iconButtonColors5 = iconButtonColors4;
            modifier3 = companion;
            z5 = z4;
            shape5 = shape4;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i5 == 0) {
        }
        i6 = i3;
        iconButtonColors4 = iconButtonColors3;
        r1 = z3;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer3 = composer2;
        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, r1, null), z4, shape4, iconButtonColors4.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors4.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, -1772884636, r1, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                invoke(composer4, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer4, int i10) {
                ComposerKt.sourceInformation(composer4, "C276@13454L157:IconButton.kt#uh7d8r");
                if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1772884636, i10, -1, "androidx.compose.material3.FilledTonalIconButton.<anonymous> (IconButton.kt:276)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor);
                    } else {
                        composer4.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, 151425978, "C280@13596L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer4, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }), composer3, (i6 & 8078) | ((i6 << 12) & 1879048192), 6, 448);
        if (ComposerKt.isTraceInProgress()) {
        }
        iconButtonColors5 = iconButtonColors4;
        modifier3 = companion;
        z5 = z4;
        shape5 = shape4;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c0  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColors3;
        int i7;
        MutableInteractionSource mutableInteractionSource3;
        boolean z5;
        ?? r2;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors4;
        final boolean z6;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1708189280);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledIconToggleButton)P(!1,6,5,3,7!1,4)321@15769L11,322@15838L30,323@15920L39,331@16193L32,332@16259L30,325@16001L500:IconButton.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                            if (startRestartGroup.changed(iconToggleButtonColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        if ((i2 & 128) != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z7 = i5 != 0 ? true : z3;
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    shape3 = IconButtonDefaults.INSTANCE.getFilledShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i10 = i3;
                                if ((i2 & 32) != 0) {
                                    z4 = true;
                                    iconToggleButtonColors3 = IconButtonDefaults.INSTANCE.m2245filledIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1572864, 63);
                                    startRestartGroup = startRestartGroup;
                                    i7 = i10 & (-458753);
                                } else {
                                    z4 = true;
                                    iconToggleButtonColors3 = iconToggleButtonColors2;
                                    i7 = i10;
                                }
                                if (i6 != 0) {
                                    startRestartGroup.startReplaceableGroup(1287876812);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):IconButton.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z5 = z7;
                                r2 = z4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                r2 = 1;
                                companion = modifier2;
                                z5 = z3;
                                shape3 = shape2;
                                i7 = i3;
                                iconToggleButtonColors3 = iconToggleButtonColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1708189280, i7, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:325)");
                            }
                            int i11 = i7 >> 9;
                            int i12 = (i11 & 896) | (i11 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColors3;
                            Modifier modifier4 = companion;
                            Shape shape5 = shape3;
                            SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                                }
                            }, r2, null), z5, shape5, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i12).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i12).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1235871670, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C335@16347L152:IconButton.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1235871670, i13, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:335)");
                                        }
                                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1822112194, "C339@16484L9:IconButton.kt#uh7d8r");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape5;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors4 = iconToggleButtonColors5;
                            z6 = z5;
                            modifier3 = modifier4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z6 = z3;
                            shape4 = shape2;
                            iconToggleButtonColors4 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    IconButtonKt.FilledIconToggleButton(z, function1, modifier3, z6, shape4, iconToggleButtonColors4, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 128) != 0) {
                    }
                    if ((4793491 & i3) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    int i102 = i3;
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    z5 = z7;
                    r2 = z4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i7 >> 9;
                    int i122 = (i112 & 896) | (i112 & 14) | ((i7 << 3) & 112);
                    IconToggleButtonColors iconToggleButtonColors52 = iconToggleButtonColors3;
                    Modifier modifier42 = companion;
                    Shape shape52 = shape3;
                    SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                        }
                    }, r2, null), z5, shape52, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i122).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i122).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1235871670, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C335@16347L152:IconButton.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1235871670, i13, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:335)");
                                }
                                Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                                ComposerKt.sourceInformationMarkerStart(composer2, 1822112194, "C339@16484L9:IconButton.kt#uh7d8r");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape52;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    iconToggleButtonColors4 = iconToggleButtonColors52;
                    z6 = z5;
                    modifier3 = modifier42;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z2;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i1022 = i3;
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                z5 = z7;
                r2 = z4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = i7 >> 9;
                int i1222 = (i1122 & 896) | (i1122 & 14) | ((i7 << 3) & 112);
                IconToggleButtonColors iconToggleButtonColors522 = iconToggleButtonColors3;
                Modifier modifier422 = companion;
                Shape shape522 = shape3;
                SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                    }
                }, r2, null), z5, shape522, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i1222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i1222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1235871670, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        ComposerKt.sourceInformation(composer2, "C335@16347L152:IconButton.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1235871670, i13, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:335)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 1822112194, "C339@16484L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape522;
                mutableInteractionSource4 = mutableInteractionSource3;
                iconToggleButtonColors4 = iconToggleButtonColors522;
                z6 = z5;
                modifier3 = modifier422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i10222 = i3;
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            z5 = z7;
            r2 = z4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = i7 >> 9;
            int i12222 = (i11222 & 896) | (i11222 & 14) | ((i7 << 3) & 112);
            IconToggleButtonColors iconToggleButtonColors5222 = iconToggleButtonColors3;
            Modifier modifier4222 = companion;
            Shape shape5222 = shape3;
            SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                }
            }, r2, null), z5, shape5222, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i12222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i12222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1235871670, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    ComposerKt.sourceInformation(composer2, "C335@16347L152:IconButton.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1235871670, i13, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:335)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 1822112194, "C339@16484L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape5222;
            mutableInteractionSource4 = mutableInteractionSource3;
            iconToggleButtonColors4 = iconToggleButtonColors5222;
            z6 = z5;
            modifier3 = modifier4222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i102222 = i3;
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        z5 = z7;
        r2 = z4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = i7 >> 9;
        int i122222 = (i112222 & 896) | (i112222 & 14) | ((i7 << 3) & 112);
        IconToggleButtonColors iconToggleButtonColors52222 = iconToggleButtonColors3;
        Modifier modifier42222 = companion;
        Shape shape52222 = shape3;
        SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
            }
        }, r2, null), z5, shape52222, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i122222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i122222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1235871670, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledIconToggleButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                ComposerKt.sourceInformation(composer2, "C335@16347L152:IconButton.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1235871670, i13, -1, "androidx.compose.material3.FilledIconToggleButton.<anonymous> (IconButton.kt:335)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledIconButtonTokens.INSTANCE.m3212getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 1822112194, "C339@16484L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape52222;
        mutableInteractionSource4 = mutableInteractionSource3;
        iconToggleButtonColors4 = iconToggleButtonColors52222;
        z6 = z5;
        modifier3 = modifier42222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c0  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        boolean z4;
        IconToggleButtonColors iconToggleButtonColors3;
        int i7;
        MutableInteractionSource mutableInteractionSource3;
        boolean z5;
        ?? r2;
        final Shape shape4;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors4;
        final boolean z6;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1676089246);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledTonalIconToggleButton)P(!1,6,5,3,7!1,4)385@19013L11,386@19082L35,387@19169L39,395@19442L32,396@19508L30,389@19250L505:IconButton.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                            if (startRestartGroup.changed(iconToggleButtonColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        if ((i2 & 128) != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z7 = i5 != 0 ? true : z3;
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    shape3 = IconButtonDefaults.INSTANCE.getFilledShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i10 = i3;
                                if ((i2 & 32) != 0) {
                                    z4 = true;
                                    iconToggleButtonColors3 = IconButtonDefaults.INSTANCE.m2247filledTonalIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1572864, 63);
                                    startRestartGroup = startRestartGroup;
                                    i7 = i10 & (-458753);
                                } else {
                                    z4 = true;
                                    iconToggleButtonColors3 = iconToggleButtonColors2;
                                    i7 = i10;
                                }
                                if (i6 != 0) {
                                    startRestartGroup.startReplaceableGroup(353404489);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):IconButton.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z5 = z7;
                                r2 = z4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                r2 = 1;
                                companion = modifier2;
                                z5 = z3;
                                shape3 = shape2;
                                i7 = i3;
                                iconToggleButtonColors3 = iconToggleButtonColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1676089246, i7, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:389)");
                            }
                            int i11 = i7 >> 9;
                            int i12 = (i11 & 896) | (i11 & 14) | ((i7 << 3) & 112);
                            IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColors3;
                            Modifier modifier4 = companion;
                            Shape shape5 = shape3;
                            SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                                }
                            }, r2, null), z5, shape5, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i12).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i12).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, -58218680, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    ComposerKt.sourceInformation(composer2, "C399@19596L157:IconButton.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-58218680, i13, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:399)");
                                        }
                                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                                        Alignment center = Alignment.INSTANCE.getCenter();
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                                        ComposerKt.sourceInformationMarkerStart(composer2, 919448388, "C403@19738L9:IconButton.kt#uh7d8r");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape5;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            iconToggleButtonColors4 = iconToggleButtonColors5;
                            z6 = z5;
                            modifier3 = modifier4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            z6 = z3;
                            shape4 = shape2;
                            iconToggleButtonColors4 = iconToggleButtonColors2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    IconButtonKt.FilledTonalIconToggleButton(z, function1, modifier3, z6, shape4, iconToggleButtonColors4, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 128) != 0) {
                    }
                    if ((4793491 & i3) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    int i102 = i3;
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    z5 = z7;
                    r2 = z4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i7 >> 9;
                    int i122 = (i112 & 896) | (i112 & 14) | ((i7 << 3) & 112);
                    IconToggleButtonColors iconToggleButtonColors52 = iconToggleButtonColors3;
                    Modifier modifier42 = companion;
                    Shape shape52 = shape3;
                    SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                        }
                    }, r2, null), z5, shape52, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i122).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i122).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, -58218680, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            ComposerKt.sourceInformation(composer2, "C399@19596L157:IconButton.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-58218680, i13, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:399)");
                                }
                                Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                                Alignment center = Alignment.INSTANCE.getCenter();
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                                ComposerKt.sourceInformationMarkerStart(composer2, 919448388, "C403@19738L9:IconButton.kt#uh7d8r");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape52;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    iconToggleButtonColors4 = iconToggleButtonColors52;
                    z6 = z5;
                    modifier3 = modifier42;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z2;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) != 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i1022 = i3;
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                z5 = z7;
                r2 = z4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = i7 >> 9;
                int i1222 = (i1122 & 896) | (i1122 & 14) | ((i7 << 3) & 112);
                IconToggleButtonColors iconToggleButtonColors522 = iconToggleButtonColors3;
                Modifier modifier422 = companion;
                Shape shape522 = shape3;
                SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                    }
                }, r2, null), z5, shape522, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i1222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i1222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, -58218680, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        ComposerKt.sourceInformation(composer2, "C399@19596L157:IconButton.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-58218680, i13, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:399)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 919448388, "C403@19738L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape522;
                mutableInteractionSource4 = mutableInteractionSource3;
                iconToggleButtonColors4 = iconToggleButtonColors522;
                z6 = z5;
                modifier3 = modifier422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) != 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i10222 = i3;
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            z5 = z7;
            r2 = z4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = i7 >> 9;
            int i12222 = (i11222 & 896) | (i11222 & 14) | ((i7 << 3) & 112);
            IconToggleButtonColors iconToggleButtonColors5222 = iconToggleButtonColors3;
            Modifier modifier4222 = companion;
            Shape shape5222 = shape3;
            SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                }
            }, r2, null), z5, shape5222, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i12222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i12222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, -58218680, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    ComposerKt.sourceInformation(composer2, "C399@19596L157:IconButton.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-58218680, i13, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:399)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 919448388, "C403@19738L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape5222;
            mutableInteractionSource4 = mutableInteractionSource3;
            iconToggleButtonColors4 = iconToggleButtonColors5222;
            z6 = z5;
            modifier3 = modifier4222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) != 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i102222 = i3;
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        z5 = z7;
        r2 = z4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = i7 >> 9;
        int i122222 = (i112222 & 896) | (i112222 & 14) | ((i7 << 3) & 112);
        IconToggleButtonColors iconToggleButtonColors52222 = iconToggleButtonColors3;
        Modifier modifier42222 = companion;
        Shape shape52222 = shape3;
        SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
            }
        }, r2, null), z5, shape52222, iconToggleButtonColors3.containerColor$material3_release(z5, z, startRestartGroup, i122222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z5, z, startRestartGroup, i122222).getValue().m4073unboximpl(), 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, -58218680, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$FilledTonalIconToggleButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                ComposerKt.sourceInformation(composer2, "C399@19596L157:IconButton.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-58218680, i13, -1, "androidx.compose.material3.FilledTonalIconToggleButton.<anonymous> (IconButton.kt:399)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, FilledTonalIconButtonTokens.INSTANCE.m3228getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 919448388, "C403@19738L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 64638 & i7, ((i7 >> 18) & 14) | 48, 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape52222;
        mutableInteractionSource4 = mutableInteractionSource3;
        iconToggleButtonColors4 = iconToggleButtonColors52222;
        z6 = z5;
        modifier3 = modifier42222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00e1  */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        IconButtonColors iconButtonColors2;
        BorderStroke borderStroke2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        Composer composer2;
        boolean z3;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        BorderStroke borderStroke4;
        boolean z4;
        IconButtonColors iconButtonColors3;
        ?? r4;
        final Modifier modifier3;
        Composer composer3;
        final boolean z5;
        final Shape shape5;
        final BorderStroke borderStroke5;
        final MutableInteractionSource mutableInteractionSource4;
        final IconButtonColors iconButtonColors4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1746603025);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedIconButton)P(6,5,3,7,1!1,4)449@22175L13,450@22240L26,451@22315L33,452@22400L39,454@22481L452:IconButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        if (startRestartGroup.changed(iconButtonColors2)) {
                            i7 = 16384;
                            i3 |= i7;
                        }
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i7 = 8192;
                    i3 |= i7;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        borderStroke2 = borderStroke;
                        if (startRestartGroup.changed(borderStroke2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    borderStroke2 = borderStroke;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) == 0) {
                                shape3 = IconButtonDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & 16) == 0) {
                                z3 = true;
                                composer2 = startRestartGroup;
                                i3 &= -57345;
                                iconButtonColors2 = IconButtonDefaults.INSTANCE.m2250outlinedIconButtonColorsro_MJ88(0L, 0L, 0L, 0L, startRestartGroup, 24576, 15);
                            } else {
                                composer2 = startRestartGroup;
                                z3 = true;
                            }
                            if ((i2 & 32) == 0) {
                                borderStroke3 = IconButtonDefaults.INSTANCE.outlinedIconButtonBorder(z2, composer2, ((i3 >> 6) & 14) | 48);
                                i3 &= -458753;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i5 == 0) {
                                composer2.startReplaceableGroup(1332264784);
                                ComposerKt.sourceInformation(composer2, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = composer2.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                z4 = z2;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                z4 = z2;
                            }
                            iconButtonColors3 = iconButtonColors2;
                            r4 = z3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            composer2 = startRestartGroup;
                            iconButtonColors3 = iconButtonColors2;
                            borderStroke4 = borderStroke2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            r4 = 1;
                            z4 = z2;
                            shape4 = shape2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1746603025, i3, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:454)");
                        }
                        int i10 = i3 & 8078;
                        int i11 = i3 << 9;
                        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                            }
                        }, r4, null), z4, shape4, iconButtonColors3.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors3.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 582332538, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i12) {
                                ComposerKt.sourceInformation(composer4, "C464@22777L154:IconButton.kt#uh7d8r");
                                if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(582332538, i12, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:464)");
                                    }
                                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -369021930, "C468@22916L9:IconButton.kt#uh7d8r");
                                    function22.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer2, i10 | (234881024 & i11) | (i11 & 1879048192), 6, 192);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer3 = composer2;
                        z5 = z4;
                        shape5 = shape4;
                        borderStroke5 = borderStroke4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        iconButtonColors4 = iconButtonColors3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer3 = startRestartGroup;
                        modifier3 = modifier2;
                        z5 = z2;
                        shape5 = shape2;
                        iconButtonColors4 = iconButtonColors2;
                        borderStroke5 = borderStroke2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i12) {
                                IconButtonKt.OutlinedIconButton(function0, modifier3, z5, shape5, iconButtonColors4, borderStroke5, mutableInteractionSource4, function2, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 128) == 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if (i5 == 0) {
                }
                iconButtonColors3 = iconButtonColors2;
                r4 = z3;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i102 = i3 & 8078;
                int i112 = i3 << 9;
                SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, r4, null), z4, shape4, iconButtonColors3.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors3.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 582332538, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i12) {
                        ComposerKt.sourceInformation(composer4, "C464@22777L154:IconButton.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(582332538, i12, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:464)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -369021930, "C468@22916L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }), composer2, i102 | (234881024 & i112) | (i112 & 1879048192), 6, 192);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                composer3 = composer2;
                z5 = z4;
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                mutableInteractionSource4 = mutableInteractionSource3;
                iconButtonColors4 = iconButtonColors3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 128) == 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if (i5 == 0) {
            }
            iconButtonColors3 = iconButtonColors2;
            r4 = z3;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1022 = i3 & 8078;
            int i1122 = i3 << 9;
            SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, r4, null), z4, shape4, iconButtonColors3.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors3.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 582332538, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i12) {
                    ComposerKt.sourceInformation(composer4, "C464@22777L154:IconButton.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(582332538, i12, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:464)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer4.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                        composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -369021930, "C468@22916L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceableGroup();
                        composer4.endNode();
                        composer4.endReplaceableGroup();
                        composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }), composer2, i1022 | (234881024 & i1122) | (i1122 & 1879048192), 6, 192);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            composer3 = composer2;
            z5 = z4;
            shape5 = shape4;
            borderStroke5 = borderStroke4;
            mutableInteractionSource4 = mutableInteractionSource3;
            iconButtonColors4 = iconButtonColors3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if (i5 == 0) {
        }
        iconButtonColors3 = iconButtonColors2;
        r4 = z3;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i10222 = i3 & 8078;
        int i11222 = i3 << 9;
        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, r4, null), z4, shape4, iconButtonColors3.m2237containerColorvNxB06k$material3_release(z4), iconButtonColors3.m2238contentColorvNxB06k$material3_release(z4), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 582332538, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                invoke(composer4, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer4, int i12) {
                ComposerKt.sourceInformation(composer4, "C464@22777L154:IconButton.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(582332538, i12, -1, "androidx.compose.material3.OutlinedIconButton.<anonymous> (IconButton.kt:464)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer4, 6);
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor);
                    } else {
                        composer4.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -369021930, "C468@22916L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer4, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }), composer2, i10222 | (234881024 & i11222) | (i11222 & 1879048192), 6, 192);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        composer3 = composer2;
        z5 = z4;
        shape5 = shape4;
        borderStroke5 = borderStroke4;
        mutableInteractionSource4 = mutableInteractionSource3;
        iconButtonColors4 = iconButtonColors3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedIconToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Shape shape2;
        IconToggleButtonColors iconToggleButtonColors2;
        BorderStroke borderStroke2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        boolean z4;
        int i7;
        IconToggleButtonColors iconToggleButtonColors3;
        BorderStroke borderStroke3;
        int i8;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke4;
        Shape shape4;
        final Shape shape5;
        final BorderStroke borderStroke5;
        final MutableInteractionSource mutableInteractionSource4;
        final IconToggleButtonColors iconToggleButtonColors4;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1470292106);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedIconToggleButton)P(1,7,6,4,8,2!1,5)511@25267L13,512@25338L32,513@25419L48,514@25519L39,522@25792L32,523@25858L30,516@25600L523:IconButton.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z3 = z2;
                    i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i11 = 16384;
                                i3 |= i11;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i11 = 8192;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                            if (startRestartGroup.changed(iconToggleButtonColors2)) {
                                i10 = 131072;
                                i3 |= i10;
                            }
                        } else {
                            iconToggleButtonColors2 = iconToggleButtonColors;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        iconToggleButtonColors2 = iconToggleButtonColors;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStroke2 = borderStroke;
                            if (startRestartGroup.changed(borderStroke2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i9 = 524288;
                        i3 |= i9;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
                        }
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                    }
                    if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) == 0) {
                                i3 &= -57345;
                                shape3 = IconButtonDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape2;
                            }
                            int i12 = i3;
                            if ((i2 & 32) == 0) {
                                i7 = i6;
                                z4 = z3;
                                iconToggleButtonColors3 = IconButtonDefaults.INSTANCE.m2251outlinedIconToggleButtonColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1572864, 63);
                                startRestartGroup = startRestartGroup;
                                i12 &= -458753;
                            } else {
                                z4 = z3;
                                i7 = i6;
                                iconToggleButtonColors3 = iconToggleButtonColors2;
                            }
                            if ((i2 & 64) == 0) {
                                borderStroke3 = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonBorder(z4, z, startRestartGroup, ((i12 >> 9) & 14) | 384 | ((i12 << 3) & 112));
                                i8 = i12 & (-3670017);
                            } else {
                                borderStroke3 = borderStroke;
                                i8 = i12;
                            }
                            if (i7 != 0) {
                                startRestartGroup.startReplaceableGroup(1810360331);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):IconButton.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            borderStroke4 = borderStroke3;
                            shape4 = shape3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            i8 = i3;
                            companion = modifier2;
                            z4 = z3;
                            iconToggleButtonColors3 = iconToggleButtonColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape4 = shape2;
                            borderStroke4 = borderStroke2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1470292106, i8, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:516)");
                        }
                        int i13 = i8 >> 9;
                        int i14 = (i13 & 896) | (i13 & 14) | ((i8 << 3) & 112);
                        Modifier modifier4 = companion;
                        IconToggleButtonColors iconToggleButtonColors5 = iconToggleButtonColors3;
                        SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                            }
                        }, 1, null), z4, shape4, iconToggleButtonColors3.containerColor$material3_release(z4, z, startRestartGroup, i14).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, startRestartGroup, i14).getValue().m4073unboximpl(), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C527@25967L154:IconButton.kt#uh7d8r");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1207657396, i15, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:527)");
                                    }
                                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                                    Alignment center = Alignment.INSTANCE.getCenter();
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                                    ComposerKt.sourceInformationMarkerStart(composer2, -866750184, "C531@26106L9:IconButton.kt#uh7d8r");
                                    function22.invoke(composer2, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, (64638 & i8) | ((i8 << 9) & 1879048192), ((i8 >> 21) & 14) | 48, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape5 = shape4;
                        borderStroke5 = borderStroke4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        iconToggleButtonColors4 = iconToggleButtonColors5;
                        z5 = z4;
                        modifier3 = modifier4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape5 = shape2;
                        iconToggleButtonColors4 = iconToggleButtonColors2;
                        borderStroke5 = borderStroke2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z5 = z3;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                IconButtonKt.OutlinedIconToggleButton(z, function1, modifier3, z5, shape5, iconToggleButtonColors4, borderStroke5, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                z3 = z2;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                if ((38347923 & i3) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) == 0) {
                }
                int i122 = i3;
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (i7 != 0) {
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                borderStroke4 = borderStroke3;
                shape4 = shape3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = i8 >> 9;
                int i142 = (i132 & 896) | (i132 & 14) | ((i8 << 3) & 112);
                Modifier modifier42 = companion;
                IconToggleButtonColors iconToggleButtonColors52 = iconToggleButtonColors3;
                SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                    }
                }, 1, null), z4, shape4, iconToggleButtonColors3.containerColor$material3_release(z4, z, startRestartGroup, i142).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, startRestartGroup, i142).getValue().m4073unboximpl(), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C527@25967L154:IconButton.kt#uh7d8r");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1207657396, i15, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:527)");
                            }
                            Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, -866750184, "C531@26106L9:IconButton.kt#uh7d8r");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (64638 & i8) | ((i8 << 9) & 1879048192), ((i8 >> 21) & 14) | 48, 384);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape5 = shape4;
                borderStroke5 = borderStroke4;
                mutableInteractionSource4 = mutableInteractionSource3;
                iconToggleButtonColors4 = iconToggleButtonColors52;
                z5 = z4;
                modifier3 = modifier42;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            if ((38347923 & i3) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            int i1222 = i3;
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (i7 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            borderStroke4 = borderStroke3;
            shape4 = shape3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1322 = i8 >> 9;
            int i1422 = (i1322 & 896) | (i1322 & 14) | ((i8 << 3) & 112);
            Modifier modifier422 = companion;
            IconToggleButtonColors iconToggleButtonColors522 = iconToggleButtonColors3;
            SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                }
            }, 1, null), z4, shape4, iconToggleButtonColors3.containerColor$material3_release(z4, z, startRestartGroup, i1422).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, startRestartGroup, i1422).getValue().m4073unboximpl(), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C527@25967L154:IconButton.kt#uh7d8r");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1207657396, i15, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:527)");
                        }
                        Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, -866750184, "C531@26106L9:IconButton.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (64638 & i8) | ((i8 << 9) & 1879048192), ((i8 >> 21) & 14) | 48, 384);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape5 = shape4;
            borderStroke5 = borderStroke4;
            mutableInteractionSource4 = mutableInteractionSource3;
            iconToggleButtonColors4 = iconToggleButtonColors522;
            z5 = z4;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        int i12222 = i3;
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (i7 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        borderStroke4 = borderStroke3;
        shape4 = shape3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i13222 = i8 >> 9;
        int i14222 = (i13222 & 896) | (i13222 & 14) | ((i8 << 3) & 112);
        Modifier modifier4222 = companion;
        IconToggleButtonColors iconToggleButtonColors5222 = iconToggleButtonColors3;
        SurfaceKt.m2635Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
            }
        }, 1, null), z4, shape4, iconToggleButtonColors3.containerColor$material3_release(z4, z, startRestartGroup, i14222).getValue().m4073unboximpl(), iconToggleButtonColors3.contentColor$material3_release(z4, z, startRestartGroup, i14222).getValue().m4073unboximpl(), 0.0f, 0.0f, borderStroke4, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 1207657396, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$OutlinedIconToggleButton$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                ComposerKt.sourceInformation(composer2, "C527@25967L154:IconButton.kt#uh7d8r");
                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1207657396, i15, -1, "androidx.compose.material3.OutlinedIconToggleButton.<anonymous> (IconButton.kt:527)");
                    }
                    Modifier m928size3ABfNKs = SizeKt.m928size3ABfNKs(Modifier.INSTANCE, OutlinedIconButtonTokens.INSTANCE.m3315getContainerSizeD9Ej5fM());
                    Alignment center = Alignment.INSTANCE.getCenter();
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m928size3ABfNKs);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -866750184, "C531@26106L9:IconButton.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (64638 & i8) | ((i8 << 9) & 1879048192), ((i8 >> 21) & 14) | 48, 384);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape5 = shape4;
        borderStroke5 = borderStroke4;
        mutableInteractionSource4 = mutableInteractionSource3;
        iconToggleButtonColors4 = iconToggleButtonColors5222;
        z5 = z4;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
