package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001bJ3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001fJv\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,JN\u0010-\u001a\u00020\t*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "drawTrack-LUBghH0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJ)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(1376295968);
        ComposerKt.sourceInformation(composer, "C(colors)886@36284L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:886)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors$material3_release;
    }

    /* renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2525colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation(composer, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)927@38583L11:Slider.kt#uh7d8r");
        long m4099getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j;
        long m4099getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j2;
        long m4099getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j3;
        long m4099getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j4;
        long m4099getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j5;
        long m4099getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j6;
        long m4099getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j7;
        long m4099getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j8;
        long m4099getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j9;
        long m4099getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:927)");
        }
        SliderColors m2508copyK518z4 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2508copyK518z4(m4099getUnspecified0d7_KjU, m4099getUnspecified0d7_KjU2, m4099getUnspecified0d7_KjU3, m4099getUnspecified0d7_KjU4, m4099getUnspecified0d7_KjU5, m4099getUnspecified0d7_KjU6, m4099getUnspecified0d7_KjU7, m4099getUnspecified0d7_KjU8, m4099getUnspecified0d7_KjU9, m4099getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2508copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached = colorScheme.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached != null) {
            return defaultSliderColorsCached;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksActiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksInactiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSliderColorsCached$material3_release(sliderColors);
        return sliderColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0069  */
    /* renamed from: Thumb-9LiSoMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2524Thumb9LiSoMs(final MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        long j2;
        Object rememberedValue;
        SnapshotStateList snapshotStateList;
        boolean z3;
        SliderDefaults$Thumb$1$1 rememberedValue2;
        final boolean z4;
        final SliderColors sliderColors3;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(startRestartGroup, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)983@41717L8,987@41833L46,988@41922L658,988@41888L692,1006@42779L5,1014@43049L143,1009@42833L595:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                sliderColors2 = sliderColors;
            }
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
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= startRestartGroup.changed(this) ? 131072 : 65536;
                    }
                    if ((i3 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                SliderColors colors = colors(startRestartGroup, (i3 >> 15) & 14);
                                i3 &= -897;
                                sliderColors2 = colors;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i5 != 0) {
                                j2 = SliderKt.ThumbSize;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                        }
                        int i8 = i3;
                        SliderColors sliderColors4 = sliderColors2;
                        boolean z5 = z2;
                        long j4 = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-290277409, i8, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:986)");
                        }
                        startRestartGroup.startReplaceableGroup(-1142853013);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt.mutableStateListOf();
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        snapshotStateList = (SnapshotStateList) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-1142852924);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        int i9 = i8 & 14;
                        z3 = i9 == 4;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i9);
                        float f = snapshotStateList.isEmpty() ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
                        Shape value = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
                        SpacerKt.Spacer(BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m929size6HolHcs(modifier2, j4), mutableInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(SliderTokens.INSTANCE.m3450getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), !z5 ? f : Dp.m6389constructorimpl(0), value, false, 0L, 0L, 24, null), sliderColors4.m2519thumbColorvNxB06k$material3_release(z5), value), startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                        sliderColors3 = sliderColors4;
                        modifier3 = modifier2;
                        j3 = j4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        z4 = z2;
                        j3 = j2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                SliderDefaults.this.m2524Thumb9LiSoMs(mutableInteractionSource, modifier3, sliderColors3, z4, j3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                j2 = j;
                if ((i2 & 32) == 0) {
                }
                if ((i3 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                int i82 = i3;
                SliderColors sliderColors42 = sliderColors2;
                boolean z52 = z2;
                long j42 = j2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-1142853013);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                snapshotStateList = (SnapshotStateList) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1142852924);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                int i92 = i82 & 14;
                if (i92 == 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i92);
                if (snapshotStateList.isEmpty()) {
                }
                Shape value2 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
                SpacerKt.Spacer(BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m929size6HolHcs(modifier2, j42), mutableInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(SliderTokens.INSTANCE.m3450getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), !z52 ? f : Dp.m6389constructorimpl(0), value2, false, 0L, 0L, 24, null), sliderColors42.m2519thumbColorvNxB06k$material3_release(z52), value2), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z52;
                sliderColors3 = sliderColors42;
                modifier3 = modifier2;
                j3 = j42;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            j2 = j;
            if ((i2 & 32) == 0) {
            }
            if ((i3 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            int i822 = i3;
            SliderColors sliderColors422 = sliderColors2;
            boolean z522 = z2;
            long j422 = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1142853013);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            snapshotStateList = (SnapshotStateList) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1142852924);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i922 = i822 & 14;
            if (i922 == 4) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i922);
            if (snapshotStateList.isEmpty()) {
            }
            Shape value22 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
            SpacerKt.Spacer(BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m929size6HolHcs(modifier2, j422), mutableInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(SliderTokens.INSTANCE.m3450getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), !z522 ? f : Dp.m6389constructorimpl(0), value22, false, 0L, 0L, 24, null), sliderColors422.m2519thumbColorvNxB06k$material3_release(z522), value22), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z522;
            sliderColors3 = sliderColors422;
            modifier3 = modifier2;
            j3 = j422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        j2 = j;
        if ((i2 & 32) == 0) {
        }
        if ((i3 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        int i8222 = i3;
        SliderColors sliderColors4222 = sliderColors2;
        boolean z5222 = z2;
        long j4222 = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1142853013);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        snapshotStateList = (SnapshotStateList) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1142852924);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        int i9222 = i8222 & 14;
        if (i9222 == 4) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i9222);
        if (snapshotStateList.isEmpty()) {
        }
        Shape value222 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
        SpacerKt.Spacer(BackgroundKt.m526backgroundbw27NRU(ShadowKt.m3735shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m929size6HolHcs(modifier2, j4222), mutableInteractionSource, RippleKt.m1870rememberRipple9IZ8Weo(false, Dp.m6389constructorimpl(SliderTokens.INSTANCE.m3450getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), !z5222 ? f : Dp.m6389constructorimpl(0), value222, false, 0L, 0L, 24, null), sliderColors4222.m2519thumbColorvNxB06k$material3_release(z5222), value222), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z5222;
        sliderColors3 = sliderColors4222;
        modifier3 = modifier2;
        j3 = j4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0062  */
    @Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        final SliderPositions sliderPositions2;
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        int i5;
        SliderColors sliderColors3;
        boolean z3;
        boolean changed;
        Object rememberedValue;
        boolean z4;
        final SliderColors sliderColors4;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1043@44335L8,1054@44796L1870,1050@44688L1978:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderPositions2 = sliderPositions;
        } else {
            sliderPositions2 = sliderPositions;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(sliderPositions2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        SliderColors sliderColors5 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors5;
                        if (i4 != 0) {
                            z3 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1546713545, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1045)");
                            }
                            int i8 = i5;
                            final long m2521trackColorWaAFU9c$material3_release = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                            final long m2521trackColorWaAFU9c$material3_release2 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                            Modifier modifier4 = companion;
                            final long m2520tickColorWaAFU9c$material3_release = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                            final long m2520tickColorWaAFU9c$material3_release2 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                            SliderColors sliderColors6 = sliderColors3;
                            Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), SliderKt.getTrackHeight());
                            startRestartGroup.startReplaceableGroup(-1134219991);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                            changed = ((i8 & 14) != 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                z4 = z3;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        float f;
                                        ArrayList arrayList;
                                        long j;
                                        long j2;
                                        boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                                        long Offset = OffsetKt.Offset(0.0f, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                                        long Offset2 = OffsetKt.Offset(Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                                        long j3 = Offset;
                                        long j4 = z6 ? Offset2 : j3;
                                        if (!z6) {
                                            j3 = Offset2;
                                        }
                                        f = SliderKt.TickSize;
                                        float f2 = drawScope.mo630toPx0680j_4(f);
                                        float f3 = drawScope.mo630toPx0680j_4(SliderKt.getTrackHeight());
                                        DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release, j4, j3, f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        long j5 = j4;
                                        long j6 = j3;
                                        DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release2, OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getStart().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getEndInclusive().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        float[] tickFractions = sliderPositions2.getTickFractions();
                                        SliderPositions sliderPositions3 = sliderPositions2;
                                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                                        int length = tickFractions.length;
                                        for (int i9 = 0; i9 < length; i9++) {
                                            float f4 = tickFractions[i9];
                                            Boolean valueOf = Boolean.valueOf(f4 > sliderPositions3.getActiveRange().getEndInclusive().floatValue() || f4 < sliderPositions3.getActiveRange().getStart().floatValue());
                                            Object obj = linkedHashMap.get(valueOf);
                                            if (obj == null) {
                                                obj = (List) new ArrayList();
                                                linkedHashMap.put(valueOf, obj);
                                            }
                                            ((List) obj).add(Float.valueOf(f4));
                                        }
                                        long j7 = m2520tickColorWaAFU9c$material3_release;
                                        long j8 = m2520tickColorWaAFU9c$material3_release2;
                                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                                            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                                            List list = (List) entry.getValue();
                                            ArrayList arrayList2 = new ArrayList(list.size());
                                            int size = list.size();
                                            for (int i10 = 0; i10 < size; i10++) {
                                                arrayList2.add(Offset.m3811boximpl(OffsetKt.Offset(Offset.m3822getXimpl(OffsetKt.m3845lerpWko1d7g(j5, j6, ((Number) list.get(i10)).floatValue())), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()))));
                                            }
                                            long j9 = j5;
                                            long j10 = j6;
                                            ArrayList arrayList3 = arrayList2;
                                            int m4368getPointsr_lszbg = PointMode.INSTANCE.m4368getPointsr_lszbg();
                                            if (booleanValue) {
                                                j = j8;
                                                arrayList = arrayList3;
                                                j2 = j7;
                                            } else {
                                                arrayList = arrayList3;
                                                j = j8;
                                                j2 = j;
                                            }
                                            DrawScope.m4604drawPointsF8ZwMP8$default(drawScope, arrayList, m4368getPointsr_lszbg, j2, f2, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                            j6 = j10;
                                            j8 = j;
                                            j5 = j9;
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                z4 = z3;
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m914height3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors4 = sliderColors6;
                            z5 = z4;
                            modifier3 = modifier4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors7 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors7;
                        companion = modifier2;
                    }
                    z3 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i82 = i5;
                    final long m2521trackColorWaAFU9c$material3_release3 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                    final long m2521trackColorWaAFU9c$material3_release22 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                    Modifier modifier42 = companion;
                    final long m2520tickColorWaAFU9c$material3_release3 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                    final long m2520tickColorWaAFU9c$material3_release22 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                    SliderColors sliderColors62 = sliderColors3;
                    Modifier m914height3ABfNKs2 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier42, 0.0f, 1, null), SliderKt.getTrackHeight());
                    startRestartGroup.startReplaceableGroup(-1134219991);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    changed = ((i82 & 14) != 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release22) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    z4 = z3;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            float f;
                            ArrayList arrayList;
                            long j;
                            long j2;
                            boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                            long Offset = OffsetKt.Offset(0.0f, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                            long Offset2 = OffsetKt.Offset(Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                            long j3 = Offset;
                            long j4 = z6 ? Offset2 : j3;
                            if (!z6) {
                                j3 = Offset2;
                            }
                            f = SliderKt.TickSize;
                            float f2 = drawScope.mo630toPx0680j_4(f);
                            float f3 = drawScope.mo630toPx0680j_4(SliderKt.getTrackHeight());
                            DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release3, j4, j3, f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            long j5 = j4;
                            long j6 = j3;
                            DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release22, OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getStart().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getEndInclusive().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            float[] tickFractions = sliderPositions2.getTickFractions();
                            SliderPositions sliderPositions3 = sliderPositions2;
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            int length = tickFractions.length;
                            for (int i9 = 0; i9 < length; i9++) {
                                float f4 = tickFractions[i9];
                                Boolean valueOf = Boolean.valueOf(f4 > sliderPositions3.getActiveRange().getEndInclusive().floatValue() || f4 < sliderPositions3.getActiveRange().getStart().floatValue());
                                Object obj = linkedHashMap.get(valueOf);
                                if (obj == null) {
                                    obj = (List) new ArrayList();
                                    linkedHashMap.put(valueOf, obj);
                                }
                                ((List) obj).add(Float.valueOf(f4));
                            }
                            long j7 = m2520tickColorWaAFU9c$material3_release3;
                            long j8 = m2520tickColorWaAFU9c$material3_release22;
                            for (Map.Entry entry : linkedHashMap.entrySet()) {
                                boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                                List list = (List) entry.getValue();
                                ArrayList arrayList2 = new ArrayList(list.size());
                                int size = list.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    arrayList2.add(Offset.m3811boximpl(OffsetKt.Offset(Offset.m3822getXimpl(OffsetKt.m3845lerpWko1d7g(j5, j6, ((Number) list.get(i10)).floatValue())), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()))));
                                }
                                long j9 = j5;
                                long j10 = j6;
                                ArrayList arrayList3 = arrayList2;
                                int m4368getPointsr_lszbg = PointMode.INSTANCE.m4368getPointsr_lszbg();
                                if (booleanValue) {
                                    j = j8;
                                    arrayList = arrayList3;
                                    j2 = j7;
                                } else {
                                    arrayList = arrayList3;
                                    j = j8;
                                    j2 = j;
                                }
                                DrawScope.m4604drawPointsF8ZwMP8$default(drawScope, arrayList, m4368getPointsr_lszbg, j2, f2, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                j6 = j10;
                                j8 = j;
                                j5 = j9;
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m914height3ABfNKs2, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors4 = sliderColors62;
                    z5 = z4;
                    modifier3 = modifier42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors4 = sliderColors2;
                    z5 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            SliderDefaults.this.Track(sliderPositions, modifier3, sliderColors4, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            SliderColors sliderColors52 = sliderColors2;
            i5 = i3;
            sliderColors3 = sliderColors52;
            if (i4 != 0) {
            }
            z3 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i822 = i5;
            final long m2521trackColorWaAFU9c$material3_release32 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
            final long m2521trackColorWaAFU9c$material3_release222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
            Modifier modifier422 = companion;
            final long m2520tickColorWaAFU9c$material3_release32 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
            final long m2520tickColorWaAFU9c$material3_release222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
            SliderColors sliderColors622 = sliderColors3;
            Modifier m914height3ABfNKs22 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier422, 0.0f, 1, null), SliderKt.getTrackHeight());
            startRestartGroup.startReplaceableGroup(-1134219991);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            changed = ((i822 & 14) != 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            z4 = z3;
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    float f;
                    ArrayList arrayList;
                    long j;
                    long j2;
                    boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                    long Offset = OffsetKt.Offset(0.0f, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                    long Offset2 = OffsetKt.Offset(Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                    long j3 = Offset;
                    long j4 = z6 ? Offset2 : j3;
                    if (!z6) {
                        j3 = Offset2;
                    }
                    f = SliderKt.TickSize;
                    float f2 = drawScope.mo630toPx0680j_4(f);
                    float f3 = drawScope.mo630toPx0680j_4(SliderKt.getTrackHeight());
                    DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release32, j4, j3, f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    long j5 = j4;
                    long j6 = j3;
                    DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release222, OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getStart().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getEndInclusive().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    float[] tickFractions = sliderPositions2.getTickFractions();
                    SliderPositions sliderPositions3 = sliderPositions2;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int length = tickFractions.length;
                    for (int i9 = 0; i9 < length; i9++) {
                        float f4 = tickFractions[i9];
                        Boolean valueOf = Boolean.valueOf(f4 > sliderPositions3.getActiveRange().getEndInclusive().floatValue() || f4 < sliderPositions3.getActiveRange().getStart().floatValue());
                        Object obj = linkedHashMap.get(valueOf);
                        if (obj == null) {
                            obj = (List) new ArrayList();
                            linkedHashMap.put(valueOf, obj);
                        }
                        ((List) obj).add(Float.valueOf(f4));
                    }
                    long j7 = m2520tickColorWaAFU9c$material3_release32;
                    long j8 = m2520tickColorWaAFU9c$material3_release222;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                        List list = (List) entry.getValue();
                        ArrayList arrayList2 = new ArrayList(list.size());
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            arrayList2.add(Offset.m3811boximpl(OffsetKt.Offset(Offset.m3822getXimpl(OffsetKt.m3845lerpWko1d7g(j5, j6, ((Number) list.get(i10)).floatValue())), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()))));
                        }
                        long j9 = j5;
                        long j10 = j6;
                        ArrayList arrayList3 = arrayList2;
                        int m4368getPointsr_lszbg = PointMode.INSTANCE.m4368getPointsr_lszbg();
                        if (booleanValue) {
                            j = j8;
                            arrayList = arrayList3;
                            j2 = j7;
                        } else {
                            arrayList = arrayList3;
                            j = j8;
                            j2 = j;
                        }
                        DrawScope.m4604drawPointsF8ZwMP8$default(drawScope, arrayList, m4368getPointsr_lszbg, j2, f2, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        j6 = j10;
                        j8 = j;
                        j5 = j9;
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m914height3ABfNKs22, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors4 = sliderColors622;
            z5 = z4;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        SliderColors sliderColors522 = sliderColors2;
        i5 = i3;
        sliderColors3 = sliderColors522;
        if (i4 != 0) {
        }
        z3 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i8222 = i5;
        final long m2521trackColorWaAFU9c$material3_release322 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
        final long m2521trackColorWaAFU9c$material3_release2222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
        Modifier modifier4222 = companion;
        final long m2520tickColorWaAFU9c$material3_release322 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
        final long m2520tickColorWaAFU9c$material3_release2222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
        SliderColors sliderColors6222 = sliderColors3;
        Modifier m914height3ABfNKs222 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4222, 0.0f, 1, null), SliderKt.getTrackHeight());
        startRestartGroup.startReplaceableGroup(-1134219991);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        changed = ((i8222 & 14) != 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        z4 = z3;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                float f;
                ArrayList arrayList;
                long j;
                long j2;
                boolean z6 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                long Offset = OffsetKt.Offset(0.0f, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                long Offset2 = OffsetKt.Offset(Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
                long j3 = Offset;
                long j4 = z6 ? Offset2 : j3;
                if (!z6) {
                    j3 = Offset2;
                }
                f = SliderKt.TickSize;
                float f2 = drawScope.mo630toPx0680j_4(f);
                float f3 = drawScope.mo630toPx0680j_4(SliderKt.getTrackHeight());
                DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release322, j4, j3, f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                long j5 = j4;
                long j6 = j3;
                DrawScope.m4599drawLineNGM6Ib0$default(drawScope, m2521trackColorWaAFU9c$material3_release2222, OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getStart().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3822getXimpl(j4) + ((Offset.m3822getXimpl(j3) - Offset.m3822getXimpl(j4)) * sliderPositions2.getActiveRange().getEndInclusive().floatValue()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                float[] tickFractions = sliderPositions2.getTickFractions();
                SliderPositions sliderPositions3 = sliderPositions2;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int length = tickFractions.length;
                for (int i9 = 0; i9 < length; i9++) {
                    float f4 = tickFractions[i9];
                    Boolean valueOf = Boolean.valueOf(f4 > sliderPositions3.getActiveRange().getEndInclusive().floatValue() || f4 < sliderPositions3.getActiveRange().getStart().floatValue());
                    Object obj = linkedHashMap.get(valueOf);
                    if (obj == null) {
                        obj = (List) new ArrayList();
                        linkedHashMap.put(valueOf, obj);
                    }
                    ((List) obj).add(Float.valueOf(f4));
                }
                long j7 = m2520tickColorWaAFU9c$material3_release322;
                long j8 = m2520tickColorWaAFU9c$material3_release2222;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list = (List) entry.getValue();
                    ArrayList arrayList2 = new ArrayList(list.size());
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        arrayList2.add(Offset.m3811boximpl(OffsetKt.Offset(Offset.m3822getXimpl(OffsetKt.m3845lerpWko1d7g(j5, j6, ((Number) list.get(i10)).floatValue())), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()))));
                    }
                    long j9 = j5;
                    long j10 = j6;
                    ArrayList arrayList3 = arrayList2;
                    int m4368getPointsr_lszbg = PointMode.INSTANCE.m4368getPointsr_lszbg();
                    if (booleanValue) {
                        j = j8;
                        arrayList = arrayList3;
                        j2 = j7;
                    } else {
                        arrayList = arrayList3;
                        j = j8;
                        j2 = j;
                    }
                    DrawScope.m4604drawPointsF8ZwMP8$default(drawScope, arrayList, m4368getPointsr_lszbg, j2, f2, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    j6 = j10;
                    j8 = j;
                    j5 = j9;
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m914height3ABfNKs222, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors4 = sliderColors6222;
        z5 = z4;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        final SliderState sliderState2;
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        int i5;
        SliderColors sliderColors3;
        boolean z3;
        boolean changed;
        Object rememberedValue;
        boolean z4;
        final SliderColors sliderColors4;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(593554206);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1121@47426L8,1132@47886L300,1128@47778L408:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderState2 = sliderState;
        } else {
            sliderState2 = sliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(sliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        SliderColors sliderColors5 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors5;
                        if (i4 != 0) {
                            z3 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(593554206, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1123)");
                            }
                            int i8 = i5;
                            final long m2521trackColorWaAFU9c$material3_release = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                            final long m2521trackColorWaAFU9c$material3_release2 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                            Modifier modifier4 = companion;
                            final long m2520tickColorWaAFU9c$material3_release = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                            final long m2520tickColorWaAFU9c$material3_release2 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                            SliderColors sliderColors6 = sliderColors3;
                            Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), SliderKt.getTrackHeight());
                            startRestartGroup.startReplaceableGroup(-1134216901);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                            changed = ((i8 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                z4 = z3;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release, m2521trackColorWaAFU9c$material3_release2, m2520tickColorWaAFU9c$material3_release, m2520tickColorWaAFU9c$material3_release2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                z4 = z3;
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m914height3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors4 = sliderColors6;
                            z5 = z4;
                            modifier3 = modifier4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors7 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors7;
                        companion = modifier2;
                    }
                    z3 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i82 = i5;
                    final long m2521trackColorWaAFU9c$material3_release3 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                    final long m2521trackColorWaAFU9c$material3_release22 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                    Modifier modifier42 = companion;
                    final long m2520tickColorWaAFU9c$material3_release3 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                    final long m2520tickColorWaAFU9c$material3_release22 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                    SliderColors sliderColors62 = sliderColors3;
                    Modifier m914height3ABfNKs2 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier42, 0.0f, 1, null), SliderKt.getTrackHeight());
                    startRestartGroup.startReplaceableGroup(-1134216901);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    changed = ((i82 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release22) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    z4 = z3;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release3, m2521trackColorWaAFU9c$material3_release22, m2520tickColorWaAFU9c$material3_release3, m2520tickColorWaAFU9c$material3_release22);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m914height3ABfNKs2, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors4 = sliderColors62;
                    z5 = z4;
                    modifier3 = modifier42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors4 = sliderColors2;
                    z5 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            SliderDefaults.this.Track(sliderState, modifier3, sliderColors4, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            SliderColors sliderColors52 = sliderColors2;
            i5 = i3;
            sliderColors3 = sliderColors52;
            if (i4 != 0) {
            }
            z3 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i822 = i5;
            final long m2521trackColorWaAFU9c$material3_release32 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
            final long m2521trackColorWaAFU9c$material3_release222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
            Modifier modifier422 = companion;
            final long m2520tickColorWaAFU9c$material3_release32 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
            final long m2520tickColorWaAFU9c$material3_release222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
            SliderColors sliderColors622 = sliderColors3;
            Modifier m914height3ABfNKs22 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier422, 0.0f, 1, null), SliderKt.getTrackHeight());
            startRestartGroup.startReplaceableGroup(-1134216901);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            changed = ((i822 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            z4 = z3;
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release32, m2521trackColorWaAFU9c$material3_release222, m2520tickColorWaAFU9c$material3_release32, m2520tickColorWaAFU9c$material3_release222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m914height3ABfNKs22, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors4 = sliderColors622;
            z5 = z4;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        SliderColors sliderColors522 = sliderColors2;
        i5 = i3;
        sliderColors3 = sliderColors522;
        if (i4 != 0) {
        }
        z3 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i8222 = i5;
        final long m2521trackColorWaAFU9c$material3_release322 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
        final long m2521trackColorWaAFU9c$material3_release2222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
        Modifier modifier4222 = companion;
        final long m2520tickColorWaAFU9c$material3_release322 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
        final long m2520tickColorWaAFU9c$material3_release2222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
        SliderColors sliderColors6222 = sliderColors3;
        Modifier m914height3ABfNKs222 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4222, 0.0f, 1, null), SliderKt.getTrackHeight());
        startRestartGroup.startReplaceableGroup(-1134216901);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        changed = ((i8222 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        z4 = z3;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release322, m2521trackColorWaAFU9c$material3_release2222, m2520tickColorWaAFU9c$material3_release322, m2520tickColorWaAFU9c$material3_release2222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m914height3ABfNKs222, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors4 = sliderColors6222;
        z5 = z4;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        final RangeSliderState rangeSliderState2;
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        int i5;
        SliderColors sliderColors3;
        boolean z3;
        boolean changed;
        Object rememberedValue;
        boolean z4;
        final SliderColors sliderColors4;
        final boolean z5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1161@48985L8,1172@49445L367,1168@49337L475:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            rangeSliderState2 = rangeSliderState;
        } else {
            rangeSliderState2 = rangeSliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(rangeSliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        SliderColors sliderColors5 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors5;
                        if (i4 != 0) {
                            z3 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1617869097, i5, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1163)");
                            }
                            int i8 = i5;
                            final long m2521trackColorWaAFU9c$material3_release = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                            final long m2521trackColorWaAFU9c$material3_release2 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                            Modifier modifier4 = companion;
                            final long m2520tickColorWaAFU9c$material3_release = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                            final long m2520tickColorWaAFU9c$material3_release2 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                            SliderColors sliderColors6 = sliderColors3;
                            Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), SliderKt.getTrackHeight());
                            startRestartGroup.startReplaceableGroup(-1134215342);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                            changed = ((i8 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                z4 = z3;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                        invoke2(drawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DrawScope drawScope) {
                                        SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release, m2521trackColorWaAFU9c$material3_release2, m2520tickColorWaAFU9c$material3_release, m2520tickColorWaAFU9c$material3_release2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                z4 = z3;
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m914height3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors4 = sliderColors6;
                            z5 = z4;
                            modifier3 = modifier4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        SliderColors sliderColors7 = sliderColors2;
                        i5 = i3;
                        sliderColors3 = sliderColors7;
                        companion = modifier2;
                    }
                    z3 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i82 = i5;
                    final long m2521trackColorWaAFU9c$material3_release3 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
                    final long m2521trackColorWaAFU9c$material3_release22 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
                    Modifier modifier42 = companion;
                    final long m2520tickColorWaAFU9c$material3_release3 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
                    final long m2520tickColorWaAFU9c$material3_release22 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
                    SliderColors sliderColors62 = sliderColors3;
                    Modifier m914height3ABfNKs2 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier42, 0.0f, 1, null), SliderKt.getTrackHeight());
                    startRestartGroup.startReplaceableGroup(-1134215342);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    changed = ((i82 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release22) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release3) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    z4 = z3;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release3, m2521trackColorWaAFU9c$material3_release22, m2520tickColorWaAFU9c$material3_release3, m2520tickColorWaAFU9c$material3_release22);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m914height3ABfNKs2, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors4 = sliderColors62;
                    z5 = z4;
                    modifier3 = modifier42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    sliderColors4 = sliderColors2;
                    z5 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            SliderDefaults.this.Track(rangeSliderState, modifier3, sliderColors4, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            SliderColors sliderColors52 = sliderColors2;
            i5 = i3;
            sliderColors3 = sliderColors52;
            if (i4 != 0) {
            }
            z3 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i822 = i5;
            final long m2521trackColorWaAFU9c$material3_release32 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
            final long m2521trackColorWaAFU9c$material3_release222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
            Modifier modifier422 = companion;
            final long m2520tickColorWaAFU9c$material3_release32 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
            final long m2520tickColorWaAFU9c$material3_release222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
            SliderColors sliderColors622 = sliderColors3;
            Modifier m914height3ABfNKs22 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier422, 0.0f, 1, null), SliderKt.getTrackHeight());
            startRestartGroup.startReplaceableGroup(-1134215342);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            changed = ((i822 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release32) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            z4 = z3;
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release32, m2521trackColorWaAFU9c$material3_release222, m2520tickColorWaAFU9c$material3_release32, m2520tickColorWaAFU9c$material3_release222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m914height3ABfNKs22, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors4 = sliderColors622;
            z5 = z4;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        SliderColors sliderColors522 = sliderColors2;
        i5 = i3;
        sliderColors3 = sliderColors522;
        if (i4 != 0) {
        }
        z3 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i8222 = i5;
        final long m2521trackColorWaAFU9c$material3_release322 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, false);
        final long m2521trackColorWaAFU9c$material3_release2222 = sliderColors3.m2521trackColorWaAFU9c$material3_release(z3, true);
        Modifier modifier4222 = companion;
        final long m2520tickColorWaAFU9c$material3_release322 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, false);
        final long m2520tickColorWaAFU9c$material3_release2222 = sliderColors3.m2520tickColorWaAFU9c$material3_release(z3, true);
        SliderColors sliderColors6222 = sliderColors3;
        Modifier m914height3ABfNKs222 = SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4222, 0.0f, 1, null), SliderKt.getTrackHeight());
        startRestartGroup.startReplaceableGroup(-1134215342);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        changed = ((i8222 & 14) == 4) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2521trackColorWaAFU9c$material3_release2222) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release322) | startRestartGroup.changed(m2520tickColorWaAFU9c$material3_release2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        z4 = z3;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                SliderDefaults.INSTANCE.m2523drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2521trackColorWaAFU9c$material3_release322, m2521trackColorWaAFU9c$material3_release2222, m2520tickColorWaAFU9c$material3_release322, m2520tickColorWaAFU9c$material3_release2222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m914height3ABfNKs222, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors4 = sliderColors6222;
        z5 = z4;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-LUBghH0, reason: not valid java name */
    public final void m2523drawTrackLUBghH0(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4) {
        float f3;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc()), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0()));
        long j5 = Offset;
        long j6 = z ? Offset2 : j5;
        if (!z) {
            j5 = Offset2;
        }
        f3 = SliderKt.TickSize;
        float f4 = drawScope.mo630toPx0680j_4(f3);
        float f5 = drawScope.mo630toPx0680j_4(SliderKt.getTrackHeight());
        DrawScope.m4599drawLineNGM6Ib0$default(drawScope, j, j6, j5, f5, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        long j7 = j5;
        long j8 = j6;
        DrawScope.m4599drawLineNGM6Ib0$default(drawScope, j2, OffsetKt.Offset(Offset.m3822getXimpl(j6) + ((Offset.m3822getXimpl(j5) - Offset.m3822getXimpl(j6)) * f), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), OffsetKt.Offset(Offset.m3822getXimpl(j6) + ((Offset.m3822getXimpl(j5) - Offset.m3822getXimpl(j6)) * f2), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), f5, StrokeCap.INSTANCE.m4416getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float f6 = fArr[i];
            long j9 = j8;
            long j10 = j7;
            j8 = j9;
            j7 = j10;
            DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, (f6 > f2 || f6 < f) ? j3 : j4, f4 / 2.0f, OffsetKt.Offset(Offset.m3822getXimpl(OffsetKt.m3845lerpWko1d7g(j9, j10, f6)), Offset.m3823getYimpl(drawScope.mo4611getCenterF1C5BW0())), 0.0f, null, null, 0, 120, null);
        }
    }
}
