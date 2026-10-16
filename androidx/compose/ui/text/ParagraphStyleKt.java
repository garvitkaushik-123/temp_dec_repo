package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParagraphStyle.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001af\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();

    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        int value = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m6274boximpl(paragraphStyle.getTextAlign()), TextAlign.m6274boximpl(paragraphStyle2.getTextAlign()), f)).getValue();
        int value2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m6288boximpl(paragraphStyle.getTextDirection()), TextDirection.m6288boximpl(paragraphStyle2.getTextDirection()), f)).getValue();
        long m5853lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m5853lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight(), paragraphStyle2.getLineHeight(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(value, value2, m5853lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m6194boximpl(paragraphStyle.getLineBreak()), LineBreak.m6194boximpl(paragraphStyle2.getLineBreak()), f)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m6184boximpl(paragraphStyle.getHyphens()), Hyphens.m6184boximpl(paragraphStyle2.getHyphens()), f)).getValue(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int m6286getStarte0LSkKk = TextAlign.m6277equalsimpl0(paragraphStyle.getTextAlign(), TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk()) ? TextAlign.INSTANCE.m6286getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int m5934resolveTextDirectionIhaHGbI = TextStyleKt.m5934resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnitKt.m6598isUnspecifiedR2X_6o(paragraphStyle.getLineHeight()) ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int m6213getSimplerAG3T2k = LineBreak.m6200equalsimpl0(paragraphStyle.getLineBreak(), LineBreak.INSTANCE.m6214getUnspecifiedrAG3T2k()) ? LineBreak.INSTANCE.m6213getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int m6192getNonevmbZdU8 = Hyphens.m6187equalsimpl0(paragraphStyle.getHyphens(), Hyphens.INSTANCE.m6193getUnspecifiedvmbZdU8()) ? Hyphens.INSTANCE.m6192getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(m6286getStarte0LSkKk, m5934resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, m6213getSimplerAG3T2k, m6192getNonevmbZdU8, textMotion, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x003d, code lost:
    
        if (androidx.compose.ui.unit.TextUnit.m6577equalsimpl0(r11, r23.getLineHeight()) != false) goto L14;
     */
    /* renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ParagraphStyle m5806fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i2, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i3, int i4, TextMotion textMotion) {
        long j2;
        int i5 = i;
        TextIndent textIndent2 = textIndent;
        if (TextAlign.m6277equalsimpl0(i5, TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk()) || TextAlign.m6277equalsimpl0(i5, paragraphStyle.getTextAlign())) {
            if (TextUnitKt.m6598isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
            }
            if ((textIndent2 == null || Intrinsics.areEqual(textIndent2, paragraphStyle.getTextIndent())) && ((TextDirection.m6291equalsimpl0(i2, TextDirection.INSTANCE.m6300getUnspecifieds_7Xco()) || TextDirection.m6291equalsimpl0(i2, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || Intrinsics.areEqual(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || Intrinsics.areEqual(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((LineBreak.m6200equalsimpl0(i3, LineBreak.INSTANCE.m6214getUnspecifiedrAG3T2k()) || LineBreak.m6200equalsimpl0(i3, paragraphStyle.getLineBreak())) && ((Hyphens.m6187equalsimpl0(i4, Hyphens.INSTANCE.m6193getUnspecifiedvmbZdU8()) || Hyphens.m6187equalsimpl0(i4, paragraphStyle.getHyphens())) && (textMotion == null || Intrinsics.areEqual(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long lineHeight = TextUnitKt.m6598isUnspecifiedR2X_6o(j2) ? paragraphStyle.getLineHeight() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m6277equalsimpl0(i5, TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk())) {
            i5 = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(i5, !TextDirection.m6291equalsimpl0(i2, TextDirection.INSTANCE.m6300getUnspecifieds_7Xco()) ? i2 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m6200equalsimpl0(i3, LineBreak.INSTANCE.m6214getUnspecifiedrAG3T2k()) ? i3 : paragraphStyle.getLineBreak(), !Hyphens.m6187equalsimpl0(i4, Hyphens.INSTANCE.m6193getUnspecifiedvmbZdU8()) ? i4 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (DefaultConstructorMarker) null);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return paragraphStyle.getPlatformStyle();
        }
        return paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }
}
