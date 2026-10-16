package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.C;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r {
    public static final Unit a(Painter painter, Function0 function0, Modifier modifier, boolean z, String str, long j, long j2, long j3, Shape shape, long j4, int i, int i2, Composer composer, int i3) {
        a(painter, function0, modifier, z, str, j, j2, j3, shape, j4, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final Painter painter, final Function0<Unit> onClick, Modifier modifier, boolean z, String str, long j, long j2, long j3, Shape shape, long j4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        String str2;
        long j5;
        int i6;
        int i7;
        int i8;
        int i9;
        Modifier modifier3;
        boolean z3;
        String str3;
        long j6;
        long b;
        long j7;
        Shape f;
        long e;
        Object rememberedValue;
        Composer composer2;
        final String str4;
        final long j8;
        final long j9;
        final long j10;
        final Modifier modifier4;
        final long j11;
        final Shape shape2;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-2002285559);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(onClick) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    str2 = str;
                    i3 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            if (startRestartGroup.changed(j5)) {
                                i10 = 131072;
                                i3 |= i10;
                            }
                        } else {
                            j5 = j;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        j5 = j;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(j2) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(shape) ? 67108864 : 33554432;
                    }
                    i8 = i2 & 512;
                    if (i8 == 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(j4) ? 536870912 : 268435456;
                        if ((i3 & 306783379) != 306783378 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            z4 = z2;
                            str4 = str2;
                            j8 = j5;
                            j9 = j2;
                            j10 = j3;
                            shape2 = shape;
                            j11 = j4;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                f = shape;
                                e = j4;
                                modifier3 = modifier2;
                                z3 = z2;
                                str3 = str2;
                                j6 = j5;
                                b = j2;
                                j7 = j3;
                            } else {
                                modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                                z3 = i4 != 0 ? true : z2;
                                str3 = i5 != 0 ? null : str2;
                                if ((i2 & 32) != 0) {
                                    j6 = MaterialTheme.INSTANCE.getColors(startRestartGroup, MaterialTheme.$stable).m1603getPrimary0d7_KjU();
                                    i3 &= -458753;
                                } else {
                                    j6 = j5;
                                }
                                b = i6 != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j2;
                                if ((i2 & 128) != 0) {
                                    i3 = (-29360129) & i3;
                                    j7 = b;
                                } else {
                                    j7 = j3;
                                }
                                f = i7 != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.f() : shape;
                                e = i9 != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : j4;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2002285559, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.GenericIconButton (GenericIconButton.kt:46)");
                            }
                            Modifier m527backgroundbw27NRU$default = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m929size6HolHcs(modifier3, b), f), e, null, 2, null);
                            Indication m1870rememberRipple9IZ8Weo = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6);
                            startRestartGroup.startReplaceableGroup(-1646978682);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier m558clickableO2vRcR0 = ClickableKt.m558clickableO2vRcR0(m527backgroundbw27NRU$default, (MutableInteractionSource) rememberedValue, m1870rememberRipple9IZ8Weo, z3, str3, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), onClick);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            startRestartGroup.startReplaceableGroup(733328855);
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            Modifier modifier5 = modifier3;
                            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Shape shape3 = f;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            int i12 = i3;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(m558clickableO2vRcR0);
                            boolean z5 = z3;
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            startRestartGroup.disableReusing();
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, density, companion.getSetDensity());
                            Updater.m3600setimpl(m3593constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m3600setimpl(m3593constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                            startRestartGroup.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            startRestartGroup.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            IconKt.m1692Iconww6aTOc(painter, str3, SizeKt.m929size6HolHcs(Modifier.INSTANCE, j7), j6, startRestartGroup, (i12 & 14) | ((i12 >> 9) & 112) | ((i12 >> 6) & 7168), 0);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            str4 = str3;
                            j8 = j6;
                            j9 = b;
                            j10 = j7;
                            modifier4 = modifier5;
                            j11 = e;
                            shape2 = shape3;
                            z4 = z5;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return r.a(Painter.this, onClick, modifier4, z4, str4, j8, j9, j10, shape2, j11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i3 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) == 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier m527backgroundbw27NRU$default2 = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m929size6HolHcs(modifier3, b), f), e, null, 2, null);
                    Indication m1870rememberRipple9IZ8Weo2 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6);
                    startRestartGroup.startReplaceableGroup(-1646978682);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier m558clickableO2vRcR02 = ClickableKt.m558clickableO2vRcR0(m527backgroundbw27NRU$default2, (MutableInteractionSource) rememberedValue, m1870rememberRipple9IZ8Weo2, z3, str3, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), onClick);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    Modifier modifier52 = modifier3;
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Shape shape32 = f;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    int i122 = i3;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(m558clickableO2vRcR02);
                    boolean z52 = z3;
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    startRestartGroup.disableReusing();
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, density2, companion2.getSetDensity());
                    Updater.m3600setimpl(m3593constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                    Updater.m3600setimpl(m3593constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    IconKt.m1692Iconww6aTOc(painter, str3, SizeKt.m929size6HolHcs(Modifier.INSTANCE, j7), j6, startRestartGroup, (i122 & 14) | ((i122 >> 9) & 112) | ((i122 >> 6) & 7168), 0);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    str4 = str3;
                    j8 = j6;
                    j9 = b;
                    j10 = j7;
                    modifier4 = modifier52;
                    j11 = e;
                    shape2 = shape32;
                    z4 = z52;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                str2 = str;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i2 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i3 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m527backgroundbw27NRU$default22 = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m929size6HolHcs(modifier3, b), f), e, null, 2, null);
                Indication m1870rememberRipple9IZ8Weo22 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6);
                startRestartGroup.startReplaceableGroup(-1646978682);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                Modifier m558clickableO2vRcR022 = ClickableKt.m558clickableO2vRcR0(m527backgroundbw27NRU$default22, (MutableInteractionSource) rememberedValue, m1870rememberRipple9IZ8Weo22, z3, str3, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), onClick);
                Alignment center22 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection22 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Modifier modifier522 = modifier3;
                ViewConfiguration viewConfiguration22 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Shape shape322 = f;
                Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                int i1222 = i3;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf22 = LayoutKt.materializerOf(m558clickableO2vRcR022);
                boolean z522 = z3;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                startRestartGroup.disableReusing();
                Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl22, rememberBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl22, density22, companion22.getSetDensity());
                Updater.m3600setimpl(m3593constructorimpl22, layoutDirection22, companion22.getSetLayoutDirection());
                Updater.m3600setimpl(m3593constructorimpl22, viewConfiguration22, companion22.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                IconKt.m1692Iconww6aTOc(painter, str3, SizeKt.m929size6HolHcs(Modifier.INSTANCE, j7), j6, startRestartGroup, (i1222 & 14) | ((i1222 >> 9) & 112) | ((i1222 >> 6) & 7168), 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                str4 = str3;
                j8 = j6;
                j9 = b;
                j10 = j7;
                modifier4 = modifier522;
                j11 = e;
                shape2 = shape322;
                z4 = z522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            str2 = str;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i2 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i3 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) == 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m527backgroundbw27NRU$default222 = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m929size6HolHcs(modifier3, b), f), e, null, 2, null);
            Indication m1870rememberRipple9IZ8Weo222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6);
            startRestartGroup.startReplaceableGroup(-1646978682);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m558clickableO2vRcR0222 = ClickableKt.m558clickableO2vRcR0(m527backgroundbw27NRU$default222, (MutableInteractionSource) rememberedValue, m1870rememberRipple9IZ8Weo222, z3, str3, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), onClick);
            Alignment center222 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Modifier modifier5222 = modifier3;
            ViewConfiguration viewConfiguration222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Shape shape3222 = f;
            Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
            int i12222 = i3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf222 = LayoutKt.materializerOf(m558clickableO2vRcR0222);
            boolean z5222 = z3;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            startRestartGroup.disableReusing();
            Composer m3593constructorimpl222 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl222, rememberBoxMeasurePolicy222, companion222.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl222, density222, companion222.getSetDensity());
            Updater.m3600setimpl(m3593constructorimpl222, layoutDirection222, companion222.getSetLayoutDirection());
            Updater.m3600setimpl(m3593constructorimpl222, viewConfiguration222, companion222.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            IconKt.m1692Iconww6aTOc(painter, str3, SizeKt.m929size6HolHcs(Modifier.INSTANCE, j7), j6, startRestartGroup, (i12222 & 14) | ((i12222 >> 9) & 112) | ((i12222 >> 6) & 7168), 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            str4 = str3;
            j8 = j6;
            j9 = b;
            j10 = j7;
            modifier4 = modifier5222;
            j11 = e;
            shape2 = shape3222;
            z4 = z5222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        str2 = str;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i2 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i3 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) == 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m527backgroundbw27NRU$default2222 = BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m929size6HolHcs(modifier3, b), f), e, null, 2, null);
        Indication m1870rememberRipple9IZ8Weo2222 = RippleKt.m1870rememberRipple9IZ8Weo(true, 0.0f, 0L, startRestartGroup, 6, 6);
        startRestartGroup.startReplaceableGroup(-1646978682);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        Modifier m558clickableO2vRcR02222 = ClickableKt.m558clickableO2vRcR0(m527backgroundbw27NRU$default2222, (MutableInteractionSource) rememberedValue, m1870rememberRipple9IZ8Weo2222, z3, str3, Role.m5709boximpl(Role.INSTANCE.m5716getButtono7Vup1c()), onClick);
        Alignment center2222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(center2222, false, startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density2222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2222 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Modifier modifier52222 = modifier3;
        ViewConfiguration viewConfiguration2222 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Shape shape32222 = f;
        Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
        int i122222 = i3;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2222 = LayoutKt.materializerOf(m558clickableO2vRcR02222);
        boolean z52222 = z3;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        startRestartGroup.disableReusing();
        Composer m3593constructorimpl2222 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl2222, rememberBoxMeasurePolicy2222, companion2222.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl2222, density2222, companion2222.getSetDensity());
        Updater.m3600setimpl(m3593constructorimpl2222, layoutDirection2222, companion2222.getSetLayoutDirection());
        Updater.m3600setimpl(m3593constructorimpl2222, viewConfiguration2222, companion2222.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        IconKt.m1692Iconww6aTOc(painter, str3, SizeKt.m929size6HolHcs(Modifier.INSTANCE, j7), j6, startRestartGroup, (i122222 & 14) | ((i122222 >> 9) & 112) | ((i122222 >> 6) & 7168), 0);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        str4 = str3;
        j8 = j6;
        j9 = b;
        j10 = j7;
        modifier4 = modifier52222;
        j11 = e;
        shape2 = shape32222;
        z4 = z52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void a(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1484935213);
        if (i == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1484935213, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.Preview (GenericIconButton.kt:73)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, m.f6017a.a(), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return r.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
