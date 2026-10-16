package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanStyle.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001aÀ\u0001\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0000ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010;\u001a\u0004\u0018\u00010\u0013*\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", "T", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpanStyleKt {
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.INSTANCE.m4098getTransparent0d7_KjU();
    private static final long DefaultColor = Color.INSTANCE.m4089getBlack0d7_KjU();

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    /* renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m5853lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m6598isUnspecifiedR2X_6o(j) || TextUnitKt.m6598isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m6570boximpl(j), TextUnit.m6570boximpl(j2), f)).getPackedValue();
        }
        return TextUnitKt.m6600lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle lerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long m5853lerpTextUnitInheritableC3pnCVY = m5853lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight lerp2 = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long m5853lerpTextUnitInheritableC3pnCVY2 = m5853lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float m6171unboximpl = baselineShift != null ? baselineShift.m6171unboximpl() : BaselineShift.m6166constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float m6178lerpjWV1Mfo = BaselineShiftKt.m6178lerpjWV1Mfo(m6171unboximpl, baselineShift2 != null ? baselineShift2.m6171unboximpl() : BaselineShift.m6166constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform lerp3 = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long m4114lerpjxsXWHM = ColorKt.m4114lerpjxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(lerp, m5853lerpTextUnitInheritableC3pnCVY, lerp2, fontStyle, fontSynthesis, fontFamily, str, m5853lerpTextUnitInheritableC3pnCVY2, BaselineShift.m6165boximpl(m6178lerpjWV1Mfo), lerp3, localeList, m4114lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long letterSpacing;
        TextForegroundStyle takeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextForegroundStyle invoke() {
                long j;
                TextForegroundStyle.Companion companion = TextForegroundStyle.INSTANCE;
                j = SpanStyleKt.DefaultColor;
                return companion.m6302from8_81llA(j);
            }
        });
        long fontSize = TextUnitKt.m6598isUnspecifiedR2X_6o(spanStyle.getFontSize()) ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle m5994boximpl = FontStyle.m5994boximpl(fontStyle != null ? fontStyle.m6000unboximpl() : FontStyle.INSTANCE.m6004getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis m6005boximpl = FontSynthesis.m6005boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6014getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m6598isUnspecifiedR2X_6o(spanStyle.getLetterSpacing())) {
            letterSpacing = DefaultLetterSpacing;
        } else {
            letterSpacing = spanStyle.getLetterSpacing();
        }
        long j = letterSpacing;
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        BaselineShift m6165boximpl = BaselineShift.m6165boximpl(baselineShift != null ? baselineShift.m6171unboximpl() : BaselineShift.INSTANCE.m6175getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        if (background == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            background = DefaultBackgroundColor;
        }
        long j2 = background;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(takeOrElse, fontSize, fontWeight2, m5994boximpl, m6005boximpl, fontFamily2, str, j, m6165boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0026, code lost:
    
        if (androidx.compose.ui.unit.TextUnit.m6577equalsimpl0(r11, r21.getFontSize()) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x004b, code lost:
    
        if (androidx.compose.ui.graphics.Color.m4064equalsimpl0(r22, r21.getTextForegroundStyle().mo6179getColor0d7_KjU()) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0057, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r29, r21.getFontStyle()) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0063, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r28, r21.getFontWeight()) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x006b, code lost:
    
        if (r31 != r21.getFontFamily()) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x007d, code lost:
    
        if (androidx.compose.ui.unit.TextUnit.m6577equalsimpl0(r33, r21.getLetterSpacing()) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00da, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r14, r21.getTextGeometricTransform()) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00eb, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r37, r21.getLocaleList()) == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0104, code lost:
    
        if (androidx.compose.ui.graphics.Color.m4064equalsimpl0(r7, r21.getBackground()) != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0133  */
    /* renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpanStyle m5852fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        long j5;
        TextGeometricTransform textGeometricTransform2;
        long j6;
        DrawStyle drawStyle2;
        TextForegroundStyle m6302from8_81llA;
        String str2 = str;
        BaselineShift baselineShift2 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (TextUnitKt.m6598isUnspecifiedR2X_6o(j2)) {
            j5 = j2;
        } else {
            j5 = j2;
        }
        if (brush == null) {
            if (j != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
        }
        if (fontStyle != null) {
        }
        if (fontWeight != null) {
        }
        if (fontFamily != null) {
        }
        if (TextUnitKt.m6598isUnspecifiedR2X_6o(j3)) {
        }
        if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.getFontSynthesis())) && ((str2 == null || Intrinsics.areEqual(str2, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.getBaselineShift())))))) {
            if (textGeometricTransform != null) {
                textGeometricTransform2 = textGeometricTransform;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            if (localeList == null) {
            }
            if (j4 != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                j6 = j4;
            } else {
                j6 = j4;
            }
            if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                drawStyle2 = drawStyle;
                if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                    return spanStyle;
                }
                if (brush != null) {
                    m6302from8_81llA = TextForegroundStyle.INSTANCE.from(brush, f);
                } else {
                    m6302from8_81llA = TextForegroundStyle.INSTANCE.m6302from8_81llA(j);
                }
                TextForegroundStyle merge = spanStyle.getTextForegroundStyle().merge(m6302from8_81llA);
                FontFamily fontFamily2 = fontFamily == null ? spanStyle.getFontFamily() : fontFamily;
                if (TextUnitKt.m6598isUnspecifiedR2X_6o(j5)) {
                    j5 = spanStyle.getFontSize();
                }
                FontWeight fontWeight2 = fontWeight == null ? spanStyle.getFontWeight() : fontWeight;
                FontStyle fontStyle2 = fontStyle == null ? spanStyle.getFontStyle() : fontStyle;
                FontSynthesis fontSynthesis2 = fontSynthesis == null ? spanStyle.getFontSynthesis() : fontSynthesis;
                if (str2 == null) {
                    str2 = spanStyle.getFontFeatureSettings();
                }
                long letterSpacing = !TextUnitKt.m6598isUnspecifiedR2X_6o(j3) ? j3 : spanStyle.getLetterSpacing();
                if (baselineShift2 == null) {
                    baselineShift2 = spanStyle.getBaselineShift();
                }
                if (textGeometricTransform2 == null) {
                    textGeometricTransform2 = spanStyle.getTextGeometricTransform();
                }
                LocaleList localeList2 = localeList == null ? spanStyle.getLocaleList() : localeList;
                if (j6 == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    j6 = spanStyle.getBackground();
                }
                if (textDecoration2 == null) {
                    textDecoration2 = spanStyle.getTextDecoration();
                }
                if (shadow2 == null) {
                    shadow2 = spanStyle.getShadow();
                }
                return new SpanStyle(merge, j5, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
            }
            drawStyle2 = drawStyle;
            if (brush != null) {
            }
            TextForegroundStyle merge2 = spanStyle.getTextForegroundStyle().merge(m6302from8_81llA);
            if (fontFamily == null) {
            }
            if (TextUnitKt.m6598isUnspecifiedR2X_6o(j5)) {
            }
            if (fontWeight == null) {
            }
            if (fontStyle == null) {
            }
            if (fontSynthesis == null) {
            }
            if (str2 == null) {
            }
            if (!TextUnitKt.m6598isUnspecifiedR2X_6o(j3)) {
            }
            if (baselineShift2 == null) {
            }
            if (textGeometricTransform2 == null) {
            }
            if (localeList == null) {
            }
            if (j6 == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            if (textDecoration2 == null) {
            }
            if (shadow2 == null) {
            }
            return new SpanStyle(merge2, j5, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
        }
        textGeometricTransform2 = textGeometricTransform;
        j6 = j4;
        drawStyle2 = drawStyle;
        if (brush != null) {
        }
        TextForegroundStyle merge22 = spanStyle.getTextForegroundStyle().merge(m6302from8_81llA);
        if (fontFamily == null) {
        }
        if (TextUnitKt.m6598isUnspecifiedR2X_6o(j5)) {
        }
        if (fontWeight == null) {
        }
        if (fontStyle == null) {
        }
        if (fontSynthesis == null) {
        }
        if (str2 == null) {
        }
        if (!TextUnitKt.m6598isUnspecifiedR2X_6o(j3)) {
        }
        if (baselineShift2 == null) {
        }
        if (textGeometricTransform2 == null) {
        }
        if (localeList == null) {
        }
        if (j6 == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        if (textDecoration2 == null) {
        }
        if (shadow2 == null) {
        }
        return new SpanStyle(merge22, j5, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, j6, textDecoration2, shadow2, mergePlatformStyle(spanStyle, platformSpanStyle), drawStyle2 == null ? spanStyle.getDrawStyle() : drawStyle2, (DefaultConstructorMarker) null);
    }
}
