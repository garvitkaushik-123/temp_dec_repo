package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* compiled from: MaterialTextSelectionColors.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer composer, int i) {
        composer.startReplaceableGroup(-721696685);
        ComposerKt.sourceInformation(composer, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, i, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long m1603getPrimary0d7_KjU = colors.m1603getPrimary0d7_KjU();
        long m1596getBackground0d7_KjU = colors.m1596getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        ComposerKt.sourceInformation(composer, "*43@1845L7");
        long m1620contentColorFor4WTKRHQ = ColorsKt.m1620contentColorFor4WTKRHQ(colors, m1596getBackground0d7_KjU);
        if (m1620contentColorFor4WTKRHQ == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m1620contentColorFor4WTKRHQ = ((Color) consume).m4073unboximpl();
        }
        composer.endReplaceableGroup();
        long m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(m1620contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        Color m4053boximpl = Color.m4053boximpl(m1603getPrimary0d7_KjU);
        Color m4053boximpl2 = Color.m4053boximpl(m1596getBackground0d7_KjU);
        Color m4053boximpl3 = Color.m4053boximpl(m4062copywmQWz5c$default);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed(m4053boximpl) | composer.changed(m4053boximpl2) | composer.changed(m4053boximpl3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(colors.m1603getPrimary0d7_KjU(), m1701calculateSelectionBackgroundColorysEtTa8(m1603getPrimary0d7_KjU, m4062copywmQWz5c$default, m1596getBackground0d7_KjU), null);
            composer.updateRememberedValue(textSelectionColors);
            rememberedValue = textSelectionColors;
        }
        composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textSelectionColors2;
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1701calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        float m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8;
        float m1700calculateContrastRationb2GgbA = m1700calculateContrastRationb2GgbA(j, 0.4f, j2, j3);
        float m1700calculateContrastRationb2GgbA2 = m1700calculateContrastRationb2GgbA(j, 0.2f, j2, j3);
        if (m1700calculateContrastRationb2GgbA >= DesiredContrastRatio) {
            m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8 = 0.4f;
        } else {
            m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8 = m1700calculateContrastRationb2GgbA2 < DesiredContrastRatio ? 0.2f : m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3);
        }
        return Color.m4062copywmQWz5c$default(j, m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1698binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        int i = 0;
        float f = 0.2f;
        float f2 = 0.4f;
        float f3 = 0.4f;
        while (i < 7) {
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float m1700calculateContrastRationb2GgbA = (m1700calculateContrastRationb2GgbA(j4, f2, j5, j6) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= m1700calculateContrastRationb2GgbA && m1700calculateContrastRationb2GgbA <= 0.01f) {
                return f2;
            }
            if (m1700calculateContrastRationb2GgbA < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
            i++;
            j = j4;
            j2 = j5;
            j3 = j6;
        }
        return f2;
    }

    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1700calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long m4108compositeOverOWjLjI = ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, null), j3);
        return m1699calculateContrastRatioOWjLjI(ColorKt.m4108compositeOverOWjLjI(j2, m4108compositeOverOWjLjI), m4108compositeOverOWjLjI);
    }

    /* renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1699calculateContrastRatioOWjLjI(long j, long j2) {
        float m4115luminance8_81llA = ColorKt.m4115luminance8_81llA(j) + 0.05f;
        float m4115luminance8_81llA2 = ColorKt.m4115luminance8_81llA(j2) + 0.05f;
        return Math.max(m4115luminance8_81llA, m4115luminance8_81llA2) / Math.min(m4115luminance8_81llA, m4115luminance8_81llA2);
    }
}
