package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:100:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03cd  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1842Text4IGK_g(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        long j5;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Modifier.Companion companion;
        long m4099getUnspecified0d7_KjU;
        TextAlign textAlign2;
        int m6330getClipgIe3tQ8;
        int i27;
        int i28;
        Function1<? super TextLayoutResult, Unit> function12;
        TextStyle textStyle2;
        TextDecoration textDecoration2;
        FontStyle fontStyle3;
        long j6;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long j7;
        int i29;
        long j8;
        final long m4062copywmQWz5c$default;
        boolean changed;
        ColorProducer rememberedValue;
        Composer composer2;
        final int i30;
        final boolean z3;
        final Modifier modifier2;
        final TextAlign textAlign3;
        final int i31;
        final int i32;
        final long j9;
        final TextStyle textStyle3;
        final long j10;
        final FontWeight fontWeight4;
        final FontStyle fontStyle4;
        final FontFamily fontFamily4;
        final long j11;
        final long j12;
        final Function1<? super TextLayoutResult, Unit> function13;
        final TextDecoration textDecoration3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1028090691);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)109@5711L7,128@6923L7,129@6977L7,138@7204L632:Text.kt#jmzs0o");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            i7 |= 48;
        } else if ((i4 & 112) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 896) == 0) {
                i7 |= startRestartGroup.changed(j) ? 256 : 128;
            }
            i9 = i6 & 8;
            if (i9 == 0) {
                i7 |= 3072;
                j5 = j2;
            } else {
                j5 = j2;
                if ((i4 & 7168) == 0) {
                    i7 |= startRestartGroup.changed(j5) ? 2048 : 1024;
                }
            }
            i10 = i6 & 16;
            if (i10 == 0) {
                i7 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 57344) == 0) {
                    i7 |= startRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i11 = i6 & 32;
            if (i11 == 0) {
                i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 458752) == 0) {
                    i7 |= startRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i12 = i6 & 64;
            if (i12 == 0) {
                i7 |= 1572864;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i4 & 3670016) == 0) {
                    i7 |= startRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                }
            }
            i13 = i6 & 128;
            if (i13 == 0) {
                i7 |= 12582912;
            } else if ((i4 & 29360128) == 0) {
                i7 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
            }
            i14 = i6 & 256;
            if (i14 == 0) {
                i7 |= 100663296;
            } else if ((i4 & 234881024) == 0) {
                i7 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
            }
            i15 = i6 & 512;
            if (i15 == 0) {
                i7 |= C.ENCODING_PCM_32BIT;
            } else if ((i4 & 1879048192) == 0) {
                i16 = i15;
                i7 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                i17 = i6 & 1024;
                if (i17 != 0) {
                    i18 = i5 | 6;
                } else if ((i5 & 14) == 0) {
                    i18 = i5 | (startRestartGroup.changed(j4) ? 4 : 2);
                } else {
                    i18 = i5;
                }
                i19 = i6 & 2048;
                if (i19 != 0) {
                    i18 |= 48;
                    i20 = i19;
                } else if ((i5 & 112) == 0) {
                    i20 = i19;
                    i18 |= startRestartGroup.changed(i) ? 32 : 16;
                } else {
                    i20 = i19;
                }
                int i34 = i18;
                i21 = i6 & 4096;
                if (i21 != 0) {
                    i34 |= 384;
                } else if ((i5 & 896) == 0) {
                    z2 = z;
                    i34 |= startRestartGroup.changed(z2) ? 256 : 128;
                    i22 = i6 & 8192;
                    if (i22 == 0) {
                        i23 = i34 | 3072;
                    } else {
                        int i35 = i34;
                        if ((i5 & 7168) == 0) {
                            i23 = i35 | (startRestartGroup.changed(i2) ? 2048 : 1024);
                        } else {
                            i23 = i35;
                        }
                    }
                    i24 = i6 & 16384;
                    if (i24 == 0) {
                        i23 |= 24576;
                    } else if ((i5 & 57344) == 0) {
                        i25 = i23 | (startRestartGroup.changed(i3) ? 16384 : 8192);
                        i26 = i6 & 32768;
                        if (i26 != 0) {
                            i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i5 & 458752) == 0) {
                            i25 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                        }
                        if ((i5 & 3670016) == 0) {
                            i25 |= ((i6 & 65536) == 0 && startRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                        }
                        if ((i7 & 1533916891) == 306783378 || (i25 & 2995931) != 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i33 != 0 ? Modifier.INSTANCE : modifier;
                                m4099getUnspecified0d7_KjU = i8 != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j;
                                if (i9 != 0) {
                                    j5 = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();
                                }
                                if (i10 != 0) {
                                    fontStyle2 = null;
                                }
                                if (i11 != 0) {
                                    fontWeight2 = null;
                                }
                                if (i12 != 0) {
                                    fontFamily2 = null;
                                }
                                long m6591getUnspecifiedXSAIIZE = i13 != 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j3;
                                TextDecoration textDecoration4 = i14 != 0 ? null : textDecoration;
                                textAlign2 = i16 != 0 ? null : textAlign;
                                long m6591getUnspecifiedXSAIIZE2 = i17 != 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j4;
                                m6330getClipgIe3tQ8 = i20 != 0 ? TextOverflow.INSTANCE.m6330getClipgIe3tQ8() : i;
                                if (i21 != 0) {
                                    z2 = true;
                                }
                                i27 = i22 != 0 ? Integer.MAX_VALUE : i2;
                                i28 = i24 == 0 ? i3 : 1;
                                function12 = i26 == 0 ? function1 : null;
                                if ((i6 & 65536) != 0) {
                                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(providableCompositionLocal);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    i25 &= -3670017;
                                    textStyle2 = (TextStyle) consume;
                                } else {
                                    textStyle2 = textStyle;
                                }
                                textDecoration2 = textDecoration4;
                                fontStyle3 = fontStyle2;
                                j6 = j5;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                j7 = m6591getUnspecifiedXSAIIZE;
                                i29 = i25;
                                j8 = m6591getUnspecifiedXSAIIZE2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 65536) != 0) {
                                    i25 &= -3670017;
                                }
                                companion = modifier;
                                m4099getUnspecified0d7_KjU = j;
                                j7 = j3;
                                textDecoration2 = textDecoration;
                                textAlign2 = textAlign;
                                j8 = j4;
                                m6330getClipgIe3tQ8 = i;
                                i27 = i2;
                                i28 = i3;
                                function12 = function1;
                                textStyle2 = textStyle;
                                fontStyle3 = fontStyle2;
                                j6 = j5;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                i29 = i25;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1028090691, i7, i29, "androidx.compose.material.Text (Text.kt:110)");
                            }
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            long m4073unboximpl = ((Color) consume2).m4073unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(localContentAlpha);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            float floatValue = ((Number) consume3).floatValue();
                            if (m4099getUnspecified0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m4062copywmQWz5c$default = m4099getUnspecified0d7_KjU;
                            } else if (textStyle2.m5918getColor0d7_KjU() != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m4062copywmQWz5c$default = textStyle2.m5918getColor0d7_KjU();
                            } else {
                                m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(m4073unboximpl, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            TextStyle m5908mergedA7vx0o$default = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 != null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                            startRestartGroup.startReplaceableGroup(-1505838219);
                            changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                                    @Override // androidx.compose.ui.graphics.ColorProducer
                                    /* renamed from: invoke-0d7_KjU, reason: not valid java name */
                                    public final long mo1845invoke0d7_KjU() {
                                        return m4062copywmQWz5c$default;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            int i36 = i29 << 9;
                            BasicTextKt.m1159BasicTextVhcvRP8(str, companion, m5908mergedA7vx0o$default, function12, m6330getClipgIe3tQ8, z2, i27, i28, (ColorProducer) rememberedValue, startRestartGroup, 134217728 | (i7 & 14) | (i7 & 112) | ((i29 >> 6) & 7168) | (i36 & 57344) | (i36 & 458752) | (i36 & 3670016) | (i36 & 29360128), 0);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i30 = i27;
                            z3 = z2;
                            modifier2 = companion;
                            textAlign3 = textAlign2;
                            i31 = m6330getClipgIe3tQ8;
                            i32 = i28;
                            j9 = m4099getUnspecified0d7_KjU;
                            textStyle3 = textStyle2;
                            j10 = j6;
                            fontWeight4 = fontWeight3;
                            fontStyle4 = fontStyle3;
                            fontFamily4 = fontFamily3;
                            j11 = j7;
                            j12 = j8;
                            function13 = function12;
                            textDecoration3 = textDecoration2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            textDecoration3 = textDecoration;
                            i31 = i;
                            i30 = i2;
                            i32 = i3;
                            function13 = function1;
                            textStyle3 = textStyle;
                            composer2 = startRestartGroup;
                            z3 = z2;
                            fontStyle4 = fontStyle2;
                            j10 = j5;
                            fontWeight4 = fontWeight2;
                            fontFamily4 = fontFamily2;
                            j9 = j;
                            j11 = j3;
                            textAlign3 = textAlign;
                            j12 = j4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i37) {
                                    TextKt.m1842Text4IGK_g(str, modifier2, j9, j10, fontStyle4, fontWeight4, fontFamily4, j11, textDecoration3, textAlign3, j12, i31, z3, i30, i32, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i25 = i23;
                    i26 = i6 & 32768;
                    if (i26 != 0) {
                    }
                    if ((i5 & 3670016) == 0) {
                    }
                    if ((i7 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i4 & 1) != 0) {
                    }
                    if (i33 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if ((i6 & 65536) != 0) {
                    }
                    textDecoration2 = textDecoration4;
                    fontStyle3 = fontStyle2;
                    j6 = j5;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j7 = m6591getUnspecifiedXSAIIZE;
                    i29 = i25;
                    j8 = m6591getUnspecifiedXSAIIZE2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long m4073unboximpl2 = ((Color) consume22).m4073unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume32 = startRestartGroup.consume(localContentAlpha2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    float floatValue2 = ((Number) consume32).floatValue();
                    if (m4099getUnspecified0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    TextStyle m5908mergedA7vx0o$default2 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 != null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                    startRestartGroup.startReplaceableGroup(-1505838219);
                    changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                        @Override // androidx.compose.ui.graphics.ColorProducer
                        /* renamed from: invoke-0d7_KjU, reason: not valid java name */
                        public final long mo1845invoke0d7_KjU() {
                            return m4062copywmQWz5c$default;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    int i362 = i29 << 9;
                    BasicTextKt.m1159BasicTextVhcvRP8(str, companion, m5908mergedA7vx0o$default2, function12, m6330getClipgIe3tQ8, z2, i27, i28, (ColorProducer) rememberedValue, startRestartGroup, 134217728 | (i7 & 14) | (i7 & 112) | ((i29 >> 6) & 7168) | (i362 & 57344) | (i362 & 458752) | (i362 & 3670016) | (i362 & 29360128), 0);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i30 = i27;
                    z3 = z2;
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    i31 = m6330getClipgIe3tQ8;
                    i32 = i28;
                    j9 = m4099getUnspecified0d7_KjU;
                    textStyle3 = textStyle2;
                    j10 = j6;
                    fontWeight4 = fontWeight3;
                    fontStyle4 = fontStyle3;
                    fontFamily4 = fontFamily3;
                    j11 = j7;
                    j12 = j8;
                    function13 = function12;
                    textDecoration3 = textDecoration2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                i22 = i6 & 8192;
                if (i22 == 0) {
                }
                i24 = i6 & 16384;
                if (i24 == 0) {
                }
                i25 = i23;
                i26 = i6 & 32768;
                if (i26 != 0) {
                }
                if ((i5 & 3670016) == 0) {
                }
                if ((i7 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i4 & 1) != 0) {
                }
                if (i33 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if ((i6 & 65536) != 0) {
                }
                textDecoration2 = textDecoration4;
                fontStyle3 = fontStyle2;
                j6 = j5;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j7 = m6591getUnspecifiedXSAIIZE;
                i29 = i25;
                j8 = m6591getUnspecifiedXSAIIZE2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Color> localContentColor22 = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localContentColor22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long m4073unboximpl22 = ((Color) consume222).m4073unboximpl();
                ProvidableCompositionLocal<Float> localContentAlpha22 = ContentAlphaKt.getLocalContentAlpha();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume322 = startRestartGroup.consume(localContentAlpha22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                float floatValue22 = ((Number) consume322).floatValue();
                if (m4099getUnspecified0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                TextStyle m5908mergedA7vx0o$default22 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 != null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                startRestartGroup.startReplaceableGroup(-1505838219);
                changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                    @Override // androidx.compose.ui.graphics.ColorProducer
                    /* renamed from: invoke-0d7_KjU, reason: not valid java name */
                    public final long mo1845invoke0d7_KjU() {
                        return m4062copywmQWz5c$default;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i3622 = i29 << 9;
                BasicTextKt.m1159BasicTextVhcvRP8(str, companion, m5908mergedA7vx0o$default22, function12, m6330getClipgIe3tQ8, z2, i27, i28, (ColorProducer) rememberedValue, startRestartGroup, 134217728 | (i7 & 14) | (i7 & 112) | ((i29 >> 6) & 7168) | (i3622 & 57344) | (i3622 & 458752) | (i3622 & 3670016) | (i3622 & 29360128), 0);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                i30 = i27;
                z3 = z2;
                modifier2 = companion;
                textAlign3 = textAlign2;
                i31 = m6330getClipgIe3tQ8;
                i32 = i28;
                j9 = m4099getUnspecified0d7_KjU;
                textStyle3 = textStyle2;
                j10 = j6;
                fontWeight4 = fontWeight3;
                fontStyle4 = fontStyle3;
                fontFamily4 = fontFamily3;
                j11 = j7;
                j12 = j8;
                function13 = function12;
                textDecoration3 = textDecoration2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i19 = i6 & 2048;
            if (i19 != 0) {
            }
            int i342 = i18;
            i21 = i6 & 4096;
            if (i21 != 0) {
            }
            z2 = z;
            i22 = i6 & 8192;
            if (i22 == 0) {
            }
            i24 = i6 & 16384;
            if (i24 == 0) {
            }
            i25 = i23;
            i26 = i6 & 32768;
            if (i26 != 0) {
            }
            if ((i5 & 3670016) == 0) {
            }
            if ((i7 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
            }
            if (i33 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if ((i6 & 65536) != 0) {
            }
            textDecoration2 = textDecoration4;
            fontStyle3 = fontStyle2;
            j6 = j5;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            j7 = m6591getUnspecifiedXSAIIZE;
            i29 = i25;
            j8 = m6591getUnspecifiedXSAIIZE2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Color> localContentColor222 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localContentColor222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long m4073unboximpl222 = ((Color) consume2222).m4073unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha222 = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3222 = startRestartGroup.consume(localContentAlpha222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float floatValue222 = ((Number) consume3222).floatValue();
            if (m4099getUnspecified0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            TextStyle m5908mergedA7vx0o$default222 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 != null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
            startRestartGroup.startReplaceableGroup(-1505838219);
            changed = startRestartGroup.changed(m4062copywmQWz5c$default);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* renamed from: invoke-0d7_KjU, reason: not valid java name */
                public final long mo1845invoke0d7_KjU() {
                    return m4062copywmQWz5c$default;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i36222 = i29 << 9;
            BasicTextKt.m1159BasicTextVhcvRP8(str, companion, m5908mergedA7vx0o$default222, function12, m6330getClipgIe3tQ8, z2, i27, i28, (ColorProducer) rememberedValue, startRestartGroup, 134217728 | (i7 & 14) | (i7 & 112) | ((i29 >> 6) & 7168) | (i36222 & 57344) | (i36222 & 458752) | (i36222 & 3670016) | (i36222 & 29360128), 0);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            i30 = i27;
            z3 = z2;
            modifier2 = companion;
            textAlign3 = textAlign2;
            i31 = m6330getClipgIe3tQ8;
            i32 = i28;
            j9 = m4099getUnspecified0d7_KjU;
            textStyle3 = textStyle2;
            j10 = j6;
            fontWeight4 = fontWeight3;
            fontStyle4 = fontStyle3;
            fontFamily4 = fontFamily3;
            j11 = j7;
            j12 = j8;
            function13 = function12;
            textDecoration3 = textDecoration2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 == 0) {
        }
        i12 = i6 & 64;
        if (i12 == 0) {
        }
        i13 = i6 & 128;
        if (i13 == 0) {
        }
        i14 = i6 & 256;
        if (i14 == 0) {
        }
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i19 = i6 & 2048;
        if (i19 != 0) {
        }
        int i3422 = i18;
        i21 = i6 & 4096;
        if (i21 != 0) {
        }
        z2 = z;
        i22 = i6 & 8192;
        if (i22 == 0) {
        }
        i24 = i6 & 16384;
        if (i24 == 0) {
        }
        i25 = i23;
        i26 = i6 & 32768;
        if (i26 != 0) {
        }
        if ((i5 & 3670016) == 0) {
        }
        if ((i7 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i4 & 1) != 0) {
        }
        if (i33 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if ((i6 & 65536) != 0) {
        }
        textDecoration2 = textDecoration4;
        fontStyle3 = fontStyle2;
        j6 = j5;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily2;
        j7 = m6591getUnspecifiedXSAIIZE;
        i29 = i25;
        j8 = m6591getUnspecifiedXSAIIZE2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Color> localContentColor2222 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localContentColor2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long m4073unboximpl2222 = ((Color) consume22222).m4073unboximpl();
        ProvidableCompositionLocal<Float> localContentAlpha2222 = ContentAlphaKt.getLocalContentAlpha();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32222 = startRestartGroup.consume(localContentAlpha2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        float floatValue2222 = ((Number) consume32222).floatValue();
        if (m4099getUnspecified0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        TextStyle m5908mergedA7vx0o$default2222 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 != null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
        startRestartGroup.startReplaceableGroup(-1505838219);
        changed = startRestartGroup.changed(m4062copywmQWz5c$default);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
            @Override // androidx.compose.ui.graphics.ColorProducer
            /* renamed from: invoke-0d7_KjU, reason: not valid java name */
            public final long mo1845invoke0d7_KjU() {
                return m4062copywmQWz5c$default;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i362222 = i29 << 9;
        BasicTextKt.m1159BasicTextVhcvRP8(str, companion, m5908mergedA7vx0o$default2222, function12, m6330getClipgIe3tQ8, z2, i27, i28, (ColorProducer) rememberedValue, startRestartGroup, 134217728 | (i7 & 14) | (i7 & 112) | ((i29 >> 6) & 7168) | (i362222 & 57344) | (i362222 & 458752) | (i362222 & 3670016) | (i362222 & 29360128), 0);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        i30 = i27;
        z3 = z2;
        modifier2 = companion;
        textAlign3 = textAlign2;
        i31 = m6330getClipgIe3tQ8;
        i32 = i28;
        j9 = m4099getUnspecified0d7_KjU;
        textStyle3 = textStyle2;
        j10 = j6;
        fontWeight4 = fontWeight3;
        fontStyle4 = fontStyle3;
        fontFamily4 = fontFamily3;
        j11 = j7;
        j12 = j8;
        function13 = function12;
        textDecoration3 = textDecoration2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02c2  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1844TextfLXpl1I(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        long j5;
        int i8;
        int i9;
        long j6;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z2;
        int i25;
        int i26;
        int i27;
        int i28;
        Modifier modifier2;
        TextAlign textAlign2;
        boolean z3;
        long j7;
        int i29;
        int i30;
        long j8;
        Function1 function12;
        TextStyle textStyle2;
        Modifier modifier3;
        int i31;
        TextDecoration textDecoration2;
        long j9;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long j10;
        Composer composer2;
        final Modifier modifier4;
        final long j11;
        final long j12;
        final FontStyle fontStyle3;
        final FontWeight fontWeight4;
        final FontFamily fontFamily4;
        final long j13;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final long j14;
        final int i32;
        final boolean z4;
        final int i33;
        final Function1 function13;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)181@8616L7,183@8632L322:Text.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i34 = i5 & 2;
        if (i34 != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i8 = i6 | 384;
                j5 = j;
            } else {
                int i35 = i6;
                j5 = j;
                if ((i3 & 896) == 0) {
                    i35 |= startRestartGroup.changed(j5) ? 256 : 128;
                }
                i8 = i35;
            }
            i9 = i5 & 8;
            if (i9 == 0) {
                i8 |= 3072;
                j6 = j2;
            } else {
                j6 = j2;
                if ((i3 & 7168) == 0) {
                    i8 |= startRestartGroup.changed(j6) ? 2048 : 1024;
                }
            }
            i10 = i5 & 16;
            if (i10 == 0) {
                i8 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i3 & 57344) == 0) {
                    i8 |= startRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i11 = i5 & 32;
            if (i11 == 0) {
                i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i3 & 458752) == 0) {
                    i8 |= startRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i12 = i5 & 64;
            if (i12 == 0) {
                i8 |= 1572864;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i3 & 3670016) == 0) {
                    i8 |= startRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                }
            }
            i13 = i5 & 128;
            if (i13 == 0) {
                i8 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                i14 = i8 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
                i15 = i5 & 256;
                if (i15 != 0) {
                    i14 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i16 = i15;
                    i14 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i17 = i5 & 512;
                    if (i17 == 0) {
                        i14 |= C.ENCODING_PCM_32BIT;
                        i18 = i17;
                    } else if ((i3 & 1879048192) == 0) {
                        i18 = i17;
                        i14 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    } else {
                        i18 = i17;
                    }
                    i19 = i14;
                    i20 = i5 & 1024;
                    if (i20 == 0) {
                        i21 = i4 | 6;
                    } else if ((i4 & 14) == 0) {
                        i21 = i4 | (startRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i21 = i4;
                    }
                    i22 = i5 & 2048;
                    if (i22 == 0) {
                        i21 |= 48;
                        i23 = i22;
                    } else if ((i4 & 112) == 0) {
                        i23 = i22;
                        i21 |= startRestartGroup.changed(i) ? 32 : 16;
                    } else {
                        i23 = i22;
                    }
                    int i36 = i21;
                    i24 = i5 & 4096;
                    if (i24 == 0) {
                        i36 |= 384;
                    } else if ((i4 & 896) == 0) {
                        z2 = z;
                        i36 |= startRestartGroup.changed(z2) ? 256 : 128;
                        i25 = i5 & 8192;
                        if (i25 != 0) {
                            i26 = i36 | 3072;
                        } else {
                            int i37 = i36;
                            if ((i4 & 7168) == 0) {
                                i26 = i37 | (startRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i26 = i37;
                            }
                        }
                        i27 = i5 & 16384;
                        if (i27 != 0) {
                            i26 |= 24576;
                        } else if ((i4 & 57344) == 0) {
                            i28 = i26 | (startRestartGroup.changedInstance(function1) ? 16384 : 8192);
                            if ((i4 & 458752) == 0) {
                                i28 |= ((i5 & 32768) == 0 && startRestartGroup.changed(textStyle)) ? 131072 : 65536;
                            }
                            if ((i19 & 1533916891) == 306783378 || (i28 & 374491) != 74898 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i34 == 0 ? Modifier.INSTANCE : modifier;
                                    if (i7 != 0) {
                                        j5 = Color.INSTANCE.m4099getUnspecified0d7_KjU();
                                    }
                                    if (i9 != 0) {
                                        j6 = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();
                                    }
                                    if (i10 != 0) {
                                        fontStyle2 = null;
                                    }
                                    if (i11 != 0) {
                                        fontWeight2 = null;
                                    }
                                    if (i12 != 0) {
                                        fontFamily2 = null;
                                    }
                                    long m6591getUnspecifiedXSAIIZE = i13 == 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j3;
                                    TextDecoration textDecoration4 = i16 == 0 ? null : textDecoration;
                                    TextAlign textAlign4 = i18 == 0 ? textAlign : null;
                                    long m6591getUnspecifiedXSAIIZE2 = i20 == 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j4;
                                    int m6330getClipgIe3tQ8 = i23 == 0 ? TextOverflow.INSTANCE.m6330getClipgIe3tQ8() : i;
                                    if (i24 != 0) {
                                        z2 = true;
                                    }
                                    int i38 = i25 == 0 ? Integer.MAX_VALUE : i2;
                                    TextKt$Text$3 textKt$Text$3 = i27 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextLayoutResult textLayoutResult) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }
                                    } : function1;
                                    if ((i5 & 32768) == 0) {
                                        modifier2 = companion;
                                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(providableCompositionLocal);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textStyle2 = (TextStyle) consume;
                                        i30 = i28 & (-458753);
                                        j8 = m6591getUnspecifiedXSAIIZE2;
                                        textAlign2 = textAlign4;
                                        function12 = textKt$Text$3;
                                        z3 = z2;
                                        j7 = j5;
                                        i29 = m6330getClipgIe3tQ8;
                                    } else {
                                        modifier2 = companion;
                                        textAlign2 = textAlign4;
                                        z3 = z2;
                                        j7 = j5;
                                        i29 = m6330getClipgIe3tQ8;
                                        i30 = i28;
                                        j8 = m6591getUnspecifiedXSAIIZE2;
                                        function12 = textKt$Text$3;
                                        textStyle2 = textStyle;
                                    }
                                    int i39 = i38;
                                    modifier3 = modifier2;
                                    long j15 = m6591getUnspecifiedXSAIIZE;
                                    i31 = i39;
                                    FontFamily fontFamily5 = fontFamily2;
                                    textDecoration2 = textDecoration4;
                                    j9 = j6;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily5;
                                    j10 = j15;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i5 & 32768) != 0) {
                                        i28 &= -458753;
                                    }
                                    modifier3 = modifier;
                                    textAlign2 = textAlign;
                                    i29 = i;
                                    i31 = i2;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    z3 = z2;
                                    j7 = j5;
                                    j9 = j6;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    i30 = i28;
                                    j10 = j3;
                                    textDecoration2 = textDecoration;
                                    j8 = j4;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-366126944, i19, i30, "androidx.compose.material.Text (Text.kt:182)");
                                }
                                int i40 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
                                int i41 = i30 << 3;
                                composer2 = startRestartGroup;
                                m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i40 | (i41 & 458752) | (i41 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                j11 = j7;
                                j12 = j9;
                                fontStyle3 = fontStyle2;
                                fontWeight4 = fontWeight3;
                                fontFamily4 = fontFamily3;
                                j13 = j10;
                                textDecoration3 = textDecoration2;
                                textAlign3 = textAlign2;
                                j14 = j8;
                                i32 = i29;
                                z4 = z3;
                                i33 = i31;
                                function13 = function12;
                                textStyle3 = textStyle2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier4 = modifier;
                                textAlign3 = textAlign;
                                i32 = i;
                                i33 = i2;
                                function13 = function1;
                                textStyle3 = textStyle;
                                composer2 = startRestartGroup;
                                z4 = z2;
                                j11 = j5;
                                fontStyle3 = fontStyle2;
                                j12 = j6;
                                fontWeight4 = fontWeight2;
                                fontFamily4 = fontFamily2;
                                j13 = j3;
                                textDecoration3 = textDecoration;
                                j14 = j4;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i42) {
                                        TextKt.m1844TextfLXpl1I(str, modifier4, j11, j12, fontStyle3, fontWeight4, fontFamily4, j13, textDecoration3, textAlign3, j14, i32, z4, i33, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i28 = i26;
                        if ((i4 & 458752) == 0) {
                        }
                        if ((i19 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i34 == 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if ((i5 & 32768) == 0) {
                        }
                        int i392 = i38;
                        modifier3 = modifier2;
                        long j152 = m6591getUnspecifiedXSAIIZE;
                        i31 = i392;
                        FontFamily fontFamily52 = fontFamily2;
                        textDecoration2 = textDecoration4;
                        j9 = j6;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily52;
                        j10 = j152;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i402 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
                        int i412 = i30 << 3;
                        composer2 = startRestartGroup;
                        m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i402 | (i412 & 458752) | (i412 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        j11 = j7;
                        j12 = j9;
                        fontStyle3 = fontStyle2;
                        fontWeight4 = fontWeight3;
                        fontFamily4 = fontFamily3;
                        j13 = j10;
                        textDecoration3 = textDecoration2;
                        textAlign3 = textAlign2;
                        j14 = j8;
                        i32 = i29;
                        z4 = z3;
                        i33 = i31;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z2 = z;
                    i25 = i5 & 8192;
                    if (i25 != 0) {
                    }
                    i27 = i5 & 16384;
                    if (i27 != 0) {
                    }
                    i28 = i26;
                    if ((i4 & 458752) == 0) {
                    }
                    if ((i19 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i34 == 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if ((i5 & 32768) == 0) {
                    }
                    int i3922 = i38;
                    modifier3 = modifier2;
                    long j1522 = m6591getUnspecifiedXSAIIZE;
                    i31 = i3922;
                    FontFamily fontFamily522 = fontFamily2;
                    textDecoration2 = textDecoration4;
                    j9 = j6;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily522;
                    j10 = j1522;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i4022 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
                    int i4122 = i30 << 3;
                    composer2 = startRestartGroup;
                    m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i4022 | (i4122 & 458752) | (i4122 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j11 = j7;
                    j12 = j9;
                    fontStyle3 = fontStyle2;
                    fontWeight4 = fontWeight3;
                    fontFamily4 = fontFamily3;
                    j13 = j10;
                    textDecoration3 = textDecoration2;
                    textAlign3 = textAlign2;
                    j14 = j8;
                    i32 = i29;
                    z4 = z3;
                    i33 = i31;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 == 0) {
                }
                i19 = i14;
                i20 = i5 & 1024;
                if (i20 == 0) {
                }
                i22 = i5 & 2048;
                if (i22 == 0) {
                }
                int i362 = i21;
                i24 = i5 & 4096;
                if (i24 == 0) {
                }
                z2 = z;
                i25 = i5 & 8192;
                if (i25 != 0) {
                }
                i27 = i5 & 16384;
                if (i27 != 0) {
                }
                i28 = i26;
                if ((i4 & 458752) == 0) {
                }
                if ((i19 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i34 == 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i20 == 0) {
                }
                if (i23 == 0) {
                }
                if (i24 != 0) {
                }
                if (i25 == 0) {
                }
                if (i27 == 0) {
                }
                if ((i5 & 32768) == 0) {
                }
                int i39222 = i38;
                modifier3 = modifier2;
                long j15222 = m6591getUnspecifiedXSAIIZE;
                i31 = i39222;
                FontFamily fontFamily5222 = fontFamily2;
                textDecoration2 = textDecoration4;
                j9 = j6;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily5222;
                j10 = j15222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i40222 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
                int i41222 = i30 << 3;
                composer2 = startRestartGroup;
                m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i40222 | (i41222 & 458752) | (i41222 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j11 = j7;
                j12 = j9;
                fontStyle3 = fontStyle2;
                fontWeight4 = fontWeight3;
                fontFamily4 = fontFamily3;
                j13 = j10;
                textDecoration3 = textDecoration2;
                textAlign3 = textAlign2;
                j14 = j8;
                i32 = i29;
                z4 = z3;
                i33 = i31;
                function13 = function12;
                textStyle3 = textStyle2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i14 = i8;
            i15 = i5 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 == 0) {
            }
            i19 = i14;
            i20 = i5 & 1024;
            if (i20 == 0) {
            }
            i22 = i5 & 2048;
            if (i22 == 0) {
            }
            int i3622 = i21;
            i24 = i5 & 4096;
            if (i24 == 0) {
            }
            z2 = z;
            i25 = i5 & 8192;
            if (i25 != 0) {
            }
            i27 = i5 & 16384;
            if (i27 != 0) {
            }
            i28 = i26;
            if ((i4 & 458752) == 0) {
            }
            if ((i19 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i34 == 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i20 == 0) {
            }
            if (i23 == 0) {
            }
            if (i24 != 0) {
            }
            if (i25 == 0) {
            }
            if (i27 == 0) {
            }
            if ((i5 & 32768) == 0) {
            }
            int i392222 = i38;
            modifier3 = modifier2;
            long j152222 = m6591getUnspecifiedXSAIIZE;
            i31 = i392222;
            FontFamily fontFamily52222 = fontFamily2;
            textDecoration2 = textDecoration4;
            j9 = j6;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily52222;
            j10 = j152222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i402222 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
            int i412222 = i30 << 3;
            composer2 = startRestartGroup;
            m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i402222 | (i412222 & 458752) | (i412222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j11 = j7;
            j12 = j9;
            fontStyle3 = fontStyle2;
            fontWeight4 = fontWeight3;
            fontFamily4 = fontFamily3;
            j13 = j10;
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            j14 = j8;
            i32 = i29;
            z4 = z3;
            i33 = i31;
            function13 = function12;
            textStyle3 = textStyle2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i9 = i5 & 8;
        if (i9 == 0) {
        }
        i10 = i5 & 16;
        if (i10 == 0) {
        }
        i11 = i5 & 32;
        if (i11 == 0) {
        }
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & 128;
        if (i13 == 0) {
        }
        i14 = i8;
        i15 = i5 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 == 0) {
        }
        i19 = i14;
        i20 = i5 & 1024;
        if (i20 == 0) {
        }
        i22 = i5 & 2048;
        if (i22 == 0) {
        }
        int i36222 = i21;
        i24 = i5 & 4096;
        if (i24 == 0) {
        }
        z2 = z;
        i25 = i5 & 8192;
        if (i25 != 0) {
        }
        i27 = i5 & 16384;
        if (i27 != 0) {
        }
        i28 = i26;
        if ((i4 & 458752) == 0) {
        }
        if ((i19 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i34 == 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i20 == 0) {
        }
        if (i23 == 0) {
        }
        if (i24 != 0) {
        }
        if (i25 == 0) {
        }
        if (i27 == 0) {
        }
        if ((i5 & 32768) == 0) {
        }
        int i3922222 = i38;
        modifier3 = modifier2;
        long j1522222 = m6591getUnspecifiedXSAIIZE;
        i31 = i3922222;
        FontFamily fontFamily522222 = fontFamily2;
        textDecoration2 = textDecoration4;
        j9 = j6;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily522222;
        j10 = j1522222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i4022222 = (i30 & 14) | 24576 | (i30 & 112) | (i30 & 896) | (i30 & 7168);
        int i4122222 = i30 << 3;
        composer2 = startRestartGroup;
        m1842Text4IGK_g(str, modifier3, j7, j9, fontStyle2, fontWeight3, fontFamily3, j10, textDecoration2, textAlign2, j8, i29, z3, i31, 1, (Function1<? super TextLayoutResult, Unit>) function12, textStyle2, composer2, i19 & 2147483646, i4022222 | (i4122222 & 458752) | (i4122222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j11 = j7;
        j12 = j9;
        fontStyle3 = fontStyle2;
        fontWeight4 = fontWeight3;
        fontFamily4 = fontFamily3;
        j13 = j10;
        textDecoration3 = textDecoration2;
        textAlign3 = textAlign2;
        j14 = j8;
        i32 = i29;
        z4 = z3;
        i33 = i31;
        function13 = function12;
        textStyle3 = textStyle2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0430  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1843TextIbK3jfQ(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        long j5;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Modifier.Companion companion;
        long m4099getUnspecified0d7_KjU;
        TextAlign textAlign2;
        int m6330getClipgIe3tQ8;
        int i30;
        int i31;
        Map<String, InlineTextContent> emptyMap;
        TextKt$Text$5 textKt$Text$5;
        TextStyle textStyle2;
        TextDecoration textDecoration2;
        FontStyle fontStyle3;
        long j6;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long j7;
        int i32;
        long j8;
        final long m4062copywmQWz5c$default;
        boolean changed;
        ColorProducer rememberedValue;
        Composer composer2;
        final boolean z3;
        final Modifier modifier2;
        final TextAlign textAlign3;
        final Function1<? super TextLayoutResult, Unit> function12;
        final int i33;
        final long j9;
        final FontWeight fontWeight4;
        final FontStyle fontStyle4;
        final FontFamily fontFamily4;
        final long j10;
        final TextDecoration textDecoration3;
        final long j11;
        final int i34;
        final Map<String, InlineTextContent> map2;
        final int i35;
        final long j12;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(744129681);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)277@13313L7,296@14525L7,297@14579L7,306@14799L671:Text.kt#jmzs0o");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i36 = i6 & 2;
        if (i36 != 0) {
            i7 |= 48;
        } else if ((i4 & 112) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 896) == 0) {
                i7 |= startRestartGroup.changed(j) ? 256 : 128;
            }
            i9 = i6 & 8;
            if (i9 == 0) {
                i7 |= 3072;
                j5 = j2;
            } else {
                j5 = j2;
                if ((i4 & 7168) == 0) {
                    i7 |= startRestartGroup.changed(j5) ? 2048 : 1024;
                }
            }
            i10 = i6 & 16;
            if (i10 == 0) {
                i7 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 57344) == 0) {
                    i7 |= startRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i11 = i6 & 32;
            if (i11 == 0) {
                i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 458752) == 0) {
                    i7 |= startRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i12 = i6 & 64;
            if (i12 == 0) {
                i7 |= 1572864;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i4 & 3670016) == 0) {
                    i7 |= startRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                }
            }
            i13 = i6 & 128;
            if (i13 == 0) {
                i7 |= 12582912;
            } else if ((i4 & 29360128) == 0) {
                i7 |= startRestartGroup.changed(j3) ? 8388608 : 4194304;
            }
            i14 = i6 & 256;
            if (i14 == 0) {
                i7 |= 100663296;
            } else if ((i4 & 234881024) == 0) {
                i7 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
            }
            i15 = i6 & 512;
            if (i15 == 0) {
                i7 |= C.ENCODING_PCM_32BIT;
            } else if ((i4 & 1879048192) == 0) {
                i16 = i15;
                i7 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                i17 = i6 & 1024;
                if (i17 != 0) {
                    i18 = i5 | 6;
                } else if ((i5 & 14) == 0) {
                    i18 = i5 | (startRestartGroup.changed(j4) ? 4 : 2);
                } else {
                    i18 = i5;
                }
                i19 = i6 & 2048;
                if (i19 != 0) {
                    i18 |= 48;
                    i20 = i19;
                } else if ((i5 & 112) == 0) {
                    i20 = i19;
                    i18 |= startRestartGroup.changed(i) ? 32 : 16;
                } else {
                    i20 = i19;
                }
                int i37 = i18;
                i21 = i6 & 4096;
                if (i21 != 0) {
                    i37 |= 384;
                } else if ((i5 & 896) == 0) {
                    z2 = z;
                    i37 |= startRestartGroup.changed(z2) ? 256 : 128;
                    i22 = i6 & 8192;
                    if (i22 == 0) {
                        i23 = i37 | 3072;
                    } else {
                        int i38 = i37;
                        if ((i5 & 7168) == 0) {
                            i23 = i38 | (startRestartGroup.changed(i2) ? 2048 : 1024);
                        } else {
                            i23 = i38;
                        }
                    }
                    i24 = i6 & 16384;
                    if (i24 == 0) {
                        i23 |= 24576;
                    } else if ((i5 & 57344) == 0) {
                        i25 = i23 | (startRestartGroup.changed(i3) ? 16384 : 8192);
                        i26 = i6 & 32768;
                        if (i26 != 0) {
                            i25 |= 65536;
                        }
                        i27 = i6 & 65536;
                        if (i27 != 0) {
                            i25 |= 1572864;
                        } else if ((i5 & 3670016) == 0) {
                            i28 = i24;
                            i25 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                            if ((i5 & 29360128) == 0) {
                                i25 |= ((i6 & 131072) == 0 && startRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                            }
                            if (i26 != 32768) {
                                i29 = i26;
                                if ((1533916891 & i7) == 306783378 && (i25 & 23967451) == 4793490 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    textDecoration3 = textDecoration;
                                    i33 = i;
                                    i34 = i2;
                                    i35 = i3;
                                    map2 = map;
                                    function12 = function1;
                                    textStyle3 = textStyle;
                                    composer2 = startRestartGroup;
                                    z3 = z2;
                                    fontStyle4 = fontStyle2;
                                    j9 = j5;
                                    fontWeight4 = fontWeight2;
                                    fontFamily4 = fontFamily2;
                                    j12 = j;
                                    j10 = j3;
                                    textAlign3 = textAlign;
                                    j11 = j4;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$7
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i39) {
                                                TextKt.m1843TextIbK3jfQ(AnnotatedString.this, modifier2, j12, j9, fontStyle4, fontWeight4, fontFamily4, j10, textDecoration3, textAlign3, j11, i33, z3, i34, i35, map2, function12, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                i29 = i26;
                            }
                            startRestartGroup.startDefaults();
                            if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i36 == 0 ? Modifier.INSTANCE : modifier;
                                m4099getUnspecified0d7_KjU = i8 == 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j;
                                if (i9 != 0) {
                                    j5 = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();
                                }
                                if (i10 != 0) {
                                    fontStyle2 = null;
                                }
                                if (i11 != 0) {
                                    fontWeight2 = null;
                                }
                                if (i12 != 0) {
                                    fontFamily2 = null;
                                }
                                long m6591getUnspecifiedXSAIIZE = i13 == 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j3;
                                TextDecoration textDecoration4 = i14 == 0 ? null : textDecoration;
                                textAlign2 = i16 == 0 ? textAlign : null;
                                long m6591getUnspecifiedXSAIIZE2 = i17 == 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j4;
                                m6330getClipgIe3tQ8 = i20 == 0 ? TextOverflow.INSTANCE.m6330getClipgIe3tQ8() : i;
                                if (i21 != 0) {
                                    z2 = true;
                                }
                                i30 = i22 == 0 ? Integer.MAX_VALUE : i2;
                                i31 = i28 == 0 ? i3 : 1;
                                emptyMap = i29 == 0 ? MapsKt.emptyMap() : map;
                                textKt$Text$5 = i27 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$5
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function1;
                                if ((i6 & 131072) == 0) {
                                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(providableCompositionLocal);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    i25 &= -29360129;
                                    textStyle2 = (TextStyle) consume;
                                } else {
                                    textStyle2 = textStyle;
                                }
                                textDecoration2 = textDecoration4;
                                fontStyle3 = fontStyle2;
                                j6 = j5;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                j7 = m6591getUnspecifiedXSAIIZE;
                                i32 = i25;
                                j8 = m6591getUnspecifiedXSAIIZE2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 131072) != 0) {
                                    i25 &= -29360129;
                                }
                                companion = modifier;
                                m4099getUnspecified0d7_KjU = j;
                                j7 = j3;
                                textDecoration2 = textDecoration;
                                textAlign2 = textAlign;
                                j8 = j4;
                                m6330getClipgIe3tQ8 = i;
                                i30 = i2;
                                i31 = i3;
                                emptyMap = map;
                                textKt$Text$5 = function1;
                                textStyle2 = textStyle;
                                fontStyle3 = fontStyle2;
                                j6 = j5;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                i32 = i25;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(744129681, i7, i32, "androidx.compose.material.Text (Text.kt:278)");
                            }
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            long m4073unboximpl = ((Color) consume2).m4073unboximpl();
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(localContentAlpha);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            float floatValue = ((Number) consume3).floatValue();
                            if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m4062copywmQWz5c$default = m4099getUnspecified0d7_KjU;
                            } else if (textStyle2.m5918getColor0d7_KjU() != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                m4062copywmQWz5c$default = textStyle2.m5918getColor0d7_KjU();
                            } else {
                                m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(m4073unboximpl, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
                            }
                            TextStyle m5908mergedA7vx0o$default = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                            startRestartGroup.startReplaceableGroup(-1505830585);
                            changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                                    @Override // androidx.compose.ui.graphics.ColorProducer
                                    /* renamed from: invoke-0d7_KjU */
                                    public final long mo1845invoke0d7_KjU() {
                                        return m4062copywmQWz5c$default;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            int i39 = i32 << 9;
                            BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i39 & 57344) | (458752 & i39) | (i39 & 3670016) | (i39 & 29360128), 0);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z2;
                            modifier2 = companion;
                            textAlign3 = textAlign2;
                            function12 = textKt$Text$5;
                            i33 = m6330getClipgIe3tQ8;
                            j9 = j6;
                            fontWeight4 = fontWeight3;
                            fontStyle4 = fontStyle3;
                            fontFamily4 = fontFamily3;
                            j10 = j7;
                            textDecoration3 = textDecoration2;
                            j11 = j8;
                            i34 = i30;
                            map2 = emptyMap;
                            i35 = i31;
                            j12 = m4099getUnspecified0d7_KjU;
                            textStyle3 = textStyle2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i28 = i24;
                        if ((i5 & 29360128) == 0) {
                        }
                        if (i26 != 32768) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i4 & 1) != 0) {
                        }
                        if (i36 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if ((i6 & 131072) == 0) {
                        }
                        textDecoration2 = textDecoration4;
                        fontStyle3 = fontStyle2;
                        j6 = j5;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily2;
                        j7 = m6591getUnspecifiedXSAIIZE;
                        i32 = i25;
                        j8 = m6591getUnspecifiedXSAIIZE2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localContentColor2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long m4073unboximpl2 = ((Color) consume22).m4073unboximpl();
                        ProvidableCompositionLocal<Float> localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume32 = startRestartGroup.consume(localContentAlpha2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        float floatValue2 = ((Number) consume32).floatValue();
                        if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        }
                        TextStyle m5908mergedA7vx0o$default2 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                        startRestartGroup.startReplaceableGroup(-1505830585);
                        changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                            @Override // androidx.compose.ui.graphics.ColorProducer
                            /* renamed from: invoke-0d7_KjU */
                            public final long mo1845invoke0d7_KjU() {
                                return m4062copywmQWz5c$default;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        int i392 = i32 << 9;
                        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default2, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i392 & 57344) | (458752 & i392) | (i392 & 3670016) | (i392 & 29360128), 0);
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z3 = z2;
                        modifier2 = companion;
                        textAlign3 = textAlign2;
                        function12 = textKt$Text$5;
                        i33 = m6330getClipgIe3tQ8;
                        j9 = j6;
                        fontWeight4 = fontWeight3;
                        fontStyle4 = fontStyle3;
                        fontFamily4 = fontFamily3;
                        j10 = j7;
                        textDecoration3 = textDecoration2;
                        j11 = j8;
                        i34 = i30;
                        map2 = emptyMap;
                        i35 = i31;
                        j12 = m4099getUnspecified0d7_KjU;
                        textStyle3 = textStyle2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i25 = i23;
                    i26 = i6 & 32768;
                    if (i26 != 0) {
                    }
                    i27 = i6 & 65536;
                    if (i27 != 0) {
                    }
                    i28 = i24;
                    if ((i5 & 29360128) == 0) {
                    }
                    if (i26 != 32768) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i4 & 1) != 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if ((i6 & 131072) == 0) {
                    }
                    textDecoration2 = textDecoration4;
                    fontStyle3 = fontStyle2;
                    j6 = j5;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j7 = m6591getUnspecifiedXSAIIZE;
                    i32 = i25;
                    j8 = m6591getUnspecifiedXSAIIZE2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Color> localContentColor22 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localContentColor22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long m4073unboximpl22 = ((Color) consume222).m4073unboximpl();
                    ProvidableCompositionLocal<Float> localContentAlpha22 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume322 = startRestartGroup.consume(localContentAlpha22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    float floatValue22 = ((Number) consume322).floatValue();
                    if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                    }
                    TextStyle m5908mergedA7vx0o$default22 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                    startRestartGroup.startReplaceableGroup(-1505830585);
                    changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                        @Override // androidx.compose.ui.graphics.ColorProducer
                        /* renamed from: invoke-0d7_KjU */
                        public final long mo1845invoke0d7_KjU() {
                            return m4062copywmQWz5c$default;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    int i3922 = i32 << 9;
                    BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default22, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i3922 & 57344) | (458752 & i3922) | (i3922 & 3670016) | (i3922 & 29360128), 0);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z3 = z2;
                    modifier2 = companion;
                    textAlign3 = textAlign2;
                    function12 = textKt$Text$5;
                    i33 = m6330getClipgIe3tQ8;
                    j9 = j6;
                    fontWeight4 = fontWeight3;
                    fontStyle4 = fontStyle3;
                    fontFamily4 = fontFamily3;
                    j10 = j7;
                    textDecoration3 = textDecoration2;
                    j11 = j8;
                    i34 = i30;
                    map2 = emptyMap;
                    i35 = i31;
                    j12 = m4099getUnspecified0d7_KjU;
                    textStyle3 = textStyle2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                i22 = i6 & 8192;
                if (i22 == 0) {
                }
                i24 = i6 & 16384;
                if (i24 == 0) {
                }
                i25 = i23;
                i26 = i6 & 32768;
                if (i26 != 0) {
                }
                i27 = i6 & 65536;
                if (i27 != 0) {
                }
                i28 = i24;
                if ((i5 & 29360128) == 0) {
                }
                if (i26 != 32768) {
                }
                startRestartGroup.startDefaults();
                if ((i4 & 1) != 0) {
                }
                if (i36 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                if (i20 == 0) {
                }
                if (i21 != 0) {
                }
                if (i22 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 == 0) {
                }
                if (i27 == 0) {
                }
                if ((i6 & 131072) == 0) {
                }
                textDecoration2 = textDecoration4;
                fontStyle3 = fontStyle2;
                j6 = j5;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j7 = m6591getUnspecifiedXSAIIZE;
                i32 = i25;
                j8 = m6591getUnspecifiedXSAIIZE2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Color> localContentColor222 = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localContentColor222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long m4073unboximpl222 = ((Color) consume2222).m4073unboximpl();
                ProvidableCompositionLocal<Float> localContentAlpha222 = ContentAlphaKt.getLocalContentAlpha();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3222 = startRestartGroup.consume(localContentAlpha222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                float floatValue222 = ((Number) consume3222).floatValue();
                if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                }
                TextStyle m5908mergedA7vx0o$default222 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
                startRestartGroup.startReplaceableGroup(-1505830585);
                changed = startRestartGroup.changed(m4062copywmQWz5c$default);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                    @Override // androidx.compose.ui.graphics.ColorProducer
                    /* renamed from: invoke-0d7_KjU */
                    public final long mo1845invoke0d7_KjU() {
                        return m4062copywmQWz5c$default;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i39222 = i32 << 9;
                BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default222, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i39222 & 57344) | (458752 & i39222) | (i39222 & 3670016) | (i39222 & 29360128), 0);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                z3 = z2;
                modifier2 = companion;
                textAlign3 = textAlign2;
                function12 = textKt$Text$5;
                i33 = m6330getClipgIe3tQ8;
                j9 = j6;
                fontWeight4 = fontWeight3;
                fontStyle4 = fontStyle3;
                fontFamily4 = fontFamily3;
                j10 = j7;
                textDecoration3 = textDecoration2;
                j11 = j8;
                i34 = i30;
                map2 = emptyMap;
                i35 = i31;
                j12 = m4099getUnspecified0d7_KjU;
                textStyle3 = textStyle2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i19 = i6 & 2048;
            if (i19 != 0) {
            }
            int i372 = i18;
            i21 = i6 & 4096;
            if (i21 != 0) {
            }
            z2 = z;
            i22 = i6 & 8192;
            if (i22 == 0) {
            }
            i24 = i6 & 16384;
            if (i24 == 0) {
            }
            i25 = i23;
            i26 = i6 & 32768;
            if (i26 != 0) {
            }
            i27 = i6 & 65536;
            if (i27 != 0) {
            }
            i28 = i24;
            if ((i5 & 29360128) == 0) {
            }
            if (i26 != 32768) {
            }
            startRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
            }
            if (i36 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            if (i20 == 0) {
            }
            if (i21 != 0) {
            }
            if (i22 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 == 0) {
            }
            if (i27 == 0) {
            }
            if ((i6 & 131072) == 0) {
            }
            textDecoration2 = textDecoration4;
            fontStyle3 = fontStyle2;
            j6 = j5;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            j7 = m6591getUnspecifiedXSAIIZE;
            i32 = i25;
            j8 = m6591getUnspecifiedXSAIIZE2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Color> localContentColor2222 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localContentColor2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long m4073unboximpl2222 = ((Color) consume22222).m4073unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha2222 = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32222 = startRestartGroup.consume(localContentAlpha2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float floatValue2222 = ((Number) consume32222).floatValue();
            if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            TextStyle m5908mergedA7vx0o$default2222 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
            startRestartGroup.startReplaceableGroup(-1505830585);
            changed = startRestartGroup.changed(m4062copywmQWz5c$default);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* renamed from: invoke-0d7_KjU */
                public final long mo1845invoke0d7_KjU() {
                    return m4062copywmQWz5c$default;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i392222 = i32 << 9;
            BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default2222, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i392222 & 57344) | (458752 & i392222) | (i392222 & 3670016) | (i392222 & 29360128), 0);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            z3 = z2;
            modifier2 = companion;
            textAlign3 = textAlign2;
            function12 = textKt$Text$5;
            i33 = m6330getClipgIe3tQ8;
            j9 = j6;
            fontWeight4 = fontWeight3;
            fontStyle4 = fontStyle3;
            fontFamily4 = fontFamily3;
            j10 = j7;
            textDecoration3 = textDecoration2;
            j11 = j8;
            i34 = i30;
            map2 = emptyMap;
            i35 = i31;
            j12 = m4099getUnspecified0d7_KjU;
            textStyle3 = textStyle2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 == 0) {
        }
        i12 = i6 & 64;
        if (i12 == 0) {
        }
        i13 = i6 & 128;
        if (i13 == 0) {
        }
        i14 = i6 & 256;
        if (i14 == 0) {
        }
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i19 = i6 & 2048;
        if (i19 != 0) {
        }
        int i3722 = i18;
        i21 = i6 & 4096;
        if (i21 != 0) {
        }
        z2 = z;
        i22 = i6 & 8192;
        if (i22 == 0) {
        }
        i24 = i6 & 16384;
        if (i24 == 0) {
        }
        i25 = i23;
        i26 = i6 & 32768;
        if (i26 != 0) {
        }
        i27 = i6 & 65536;
        if (i27 != 0) {
        }
        i28 = i24;
        if ((i5 & 29360128) == 0) {
        }
        if (i26 != 32768) {
        }
        startRestartGroup.startDefaults();
        if ((i4 & 1) != 0) {
        }
        if (i36 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i20 == 0) {
        }
        if (i21 != 0) {
        }
        if (i22 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 == 0) {
        }
        if (i27 == 0) {
        }
        if ((i6 & 131072) == 0) {
        }
        textDecoration2 = textDecoration4;
        fontStyle3 = fontStyle2;
        j6 = j5;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily2;
        j7 = m6591getUnspecifiedXSAIIZE;
        i32 = i25;
        j8 = m6591getUnspecifiedXSAIIZE2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Color> localContentColor22222 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localContentColor22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long m4073unboximpl22222 = ((Color) consume222222).m4073unboximpl();
        ProvidableCompositionLocal<Float> localContentAlpha22222 = ContentAlphaKt.getLocalContentAlpha();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322222 = startRestartGroup.consume(localContentAlpha22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        float floatValue22222 = ((Number) consume322222).floatValue();
        if (m4099getUnspecified0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        TextStyle m5908mergedA7vx0o$default22222 = TextStyle.m5908mergedA7vx0o$default(textStyle2, 0L, j6, fontWeight3, fontStyle3, null, fontFamily3, null, j7, null, null, null, 0L, textDecoration2, null, null, textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m6287getUnspecifiede0LSkKk(), 0, j8, null, null, 0, 0, null, null, 16609105, null);
        startRestartGroup.startReplaceableGroup(-1505830585);
        changed = startRestartGroup.changed(m4062copywmQWz5c$default);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
            @Override // androidx.compose.ui.graphics.ColorProducer
            /* renamed from: invoke-0d7_KjU */
            public final long mo1845invoke0d7_KjU() {
                return m4062copywmQWz5c$default;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i3922222 = i32 << 9;
        BasicTextKt.m1157BasicTextRWo7tUw(annotatedString, companion, m5908mergedA7vx0o$default22222, textKt$Text$5, m6330getClipgIe3tQ8, z2, i30, i31, emptyMap, (ColorProducer) rememberedValue, startRestartGroup, 1207959552 | (i7 & 14) | (i7 & 112) | ((i32 >> 9) & 7168) | (i3922222 & 57344) | (458752 & i3922222) | (i3922222 & 3670016) | (i3922222 & 29360128), 0);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        z3 = z2;
        modifier2 = companion;
        textAlign3 = textAlign2;
        function12 = textKt$Text$5;
        i33 = m6330getClipgIe3tQ8;
        j9 = j6;
        fontWeight4 = fontWeight3;
        fontStyle4 = fontStyle3;
        fontFamily4 = fontFamily3;
        j10 = j7;
        textDecoration3 = textDecoration2;
        j11 = j8;
        i34 = i30;
        map2 = emptyMap;
        i35 = i31;
        j12 = m4099getUnspecified0d7_KjU;
        textStyle3 = textStyle2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02cd  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1841Text4IGK_g(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        long j5;
        int i8;
        int i9;
        long j6;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z2;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Modifier modifier2;
        TextAlign textAlign2;
        Map map2;
        TextStyle textStyle2;
        Function1 function12;
        int i29;
        long j7;
        TextAlign textAlign3;
        Map map3;
        int i30;
        Modifier modifier3;
        int i31;
        boolean z3;
        long j8;
        FontFamily fontFamily2;
        long j9;
        FontWeight fontWeight3;
        TextDecoration textDecoration2;
        FontStyle fontStyle3;
        long j10;
        Composer composer2;
        final Modifier modifier4;
        final long j11;
        final long j12;
        final FontStyle fontStyle4;
        final FontWeight fontWeight4;
        final FontFamily fontFamily3;
        final long j13;
        final TextDecoration textDecoration3;
        final TextAlign textAlign4;
        final long j14;
        final int i32;
        final boolean z4;
        final int i33;
        final Map map4;
        final Function1 function13;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation(startRestartGroup, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)351@16320L7,353@16336L345:Text.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i34 = i5 & 2;
        if (i34 != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i8 = i6 | 384;
                j5 = j;
            } else {
                int i35 = i6;
                j5 = j;
                if ((i3 & 896) == 0) {
                    i35 |= startRestartGroup.changed(j5) ? 256 : 128;
                }
                i8 = i35;
            }
            i9 = i5 & 8;
            if (i9 == 0) {
                i8 |= 3072;
                j6 = j2;
            } else {
                j6 = j2;
                if ((i3 & 7168) == 0) {
                    i8 |= startRestartGroup.changed(j6) ? 2048 : 1024;
                }
            }
            i10 = i5 & 16;
            if (i10 == 0) {
                i8 |= 24576;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i3 & 57344) == 0) {
                    i8 |= startRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
            }
            i11 = i5 & 32;
            if (i11 == 0) {
                i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i3 & 458752) == 0) {
                    i8 |= startRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                }
            }
            i12 = i5 & 64;
            if (i12 == 0) {
                i8 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                i8 |= startRestartGroup.changed(fontFamily) ? 1048576 : 524288;
            }
            i13 = i5 & 128;
            if (i13 == 0) {
                i8 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                i14 = i8 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
                i15 = i5 & 256;
                if (i15 != 0) {
                    i14 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i16 = i15;
                    i14 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i17 = i5 & 512;
                    if (i17 == 0) {
                        i14 |= C.ENCODING_PCM_32BIT;
                        i18 = i17;
                    } else if ((i3 & 1879048192) == 0) {
                        i18 = i17;
                        i14 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    } else {
                        i18 = i17;
                    }
                    int i36 = i14;
                    i19 = i5 & 1024;
                    if (i19 == 0) {
                        i20 = i4 | 6;
                    } else if ((i4 & 14) == 0) {
                        i20 = i4 | (startRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i20 = i4;
                    }
                    i21 = i5 & 2048;
                    if (i21 == 0) {
                        i20 |= 48;
                        i22 = i21;
                    } else if ((i4 & 112) == 0) {
                        i22 = i21;
                        i20 |= startRestartGroup.changed(i) ? 32 : 16;
                    } else {
                        i22 = i21;
                    }
                    int i37 = i20;
                    i23 = i5 & 4096;
                    if (i23 == 0) {
                        i37 |= 384;
                    } else if ((i4 & 896) == 0) {
                        z2 = z;
                        i37 |= startRestartGroup.changed(z2) ? 256 : 128;
                        i24 = i5 & 8192;
                        if (i24 != 0) {
                            i25 = i37 | 3072;
                        } else {
                            int i38 = i37;
                            if ((i4 & 7168) == 0) {
                                i25 = i38 | (startRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i25 = i38;
                            }
                        }
                        i26 = i5 & 16384;
                        if (i26 != 0) {
                            i25 |= 8192;
                        }
                        i27 = i5 & 32768;
                        if (i27 != 0) {
                            i28 = i25 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            int i39 = i25;
                            if ((i4 & 458752) == 0) {
                                i28 = i39 | (startRestartGroup.changedInstance(function1) ? 131072 : 65536);
                            } else {
                                i28 = i39;
                            }
                        }
                        if ((i4 & 3670016) == 0) {
                            i28 |= ((i5 & 65536) == 0 && startRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                        }
                        if (i26 == 16384 || (1533916891 & i36) != 306783378 || (i28 & 2995931) != 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i34 != 0 ? Modifier.INSTANCE : modifier;
                                if (i7 != 0) {
                                    j5 = Color.INSTANCE.m4099getUnspecified0d7_KjU();
                                }
                                if (i9 != 0) {
                                    j6 = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();
                                }
                                if (i10 != 0) {
                                    fontStyle2 = null;
                                }
                                if (i11 != 0) {
                                    fontWeight2 = null;
                                }
                                FontFamily fontFamily4 = i12 != 0 ? null : fontFamily;
                                long m6591getUnspecifiedXSAIIZE = i13 != 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j3;
                                TextDecoration textDecoration4 = i16 != 0 ? null : textDecoration;
                                TextAlign textAlign5 = i18 == 0 ? textAlign : null;
                                long m6591getUnspecifiedXSAIIZE2 = i19 != 0 ? TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE() : j4;
                                int m6330getClipgIe3tQ8 = i22 != 0 ? TextOverflow.INSTANCE.m6330getClipgIe3tQ8() : i;
                                if (i23 != 0) {
                                    z2 = true;
                                }
                                int i40 = i24 != 0 ? Integer.MAX_VALUE : i2;
                                Map emptyMap = i26 != 0 ? MapsKt.emptyMap() : map;
                                TextKt$Text$8 textKt$Text$8 = i27 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$8
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function1;
                                if ((i5 & 65536) != 0) {
                                    modifier2 = companion;
                                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                    textAlign2 = textAlign5;
                                    map2 = emptyMap;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(providableCompositionLocal);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    i28 &= -3670017;
                                    textStyle2 = (TextStyle) consume;
                                } else {
                                    modifier2 = companion;
                                    textAlign2 = textAlign5;
                                    map2 = emptyMap;
                                    textStyle2 = textStyle;
                                }
                                function12 = textKt$Text$8;
                                i29 = i28;
                                j7 = m6591getUnspecifiedXSAIIZE2;
                                textAlign3 = textAlign2;
                                map3 = map2;
                                i30 = m6330getClipgIe3tQ8;
                                int i41 = i40;
                                modifier3 = modifier2;
                                long j15 = m6591getUnspecifiedXSAIIZE;
                                i31 = i41;
                                z3 = z2;
                                j8 = j5;
                                fontFamily2 = fontFamily4;
                                j9 = j6;
                                fontWeight3 = fontWeight2;
                                textDecoration2 = textDecoration4;
                                fontStyle3 = fontStyle2;
                                j10 = j15;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i5 & 65536) != 0) {
                                    i28 &= -3670017;
                                }
                                modifier3 = modifier;
                                textAlign3 = textAlign;
                                j7 = j4;
                                i31 = i2;
                                map3 = map;
                                function12 = function1;
                                textStyle2 = textStyle;
                                z3 = z2;
                                j8 = j5;
                                j9 = j6;
                                fontStyle3 = fontStyle2;
                                fontWeight3 = fontWeight2;
                                i29 = i28;
                                fontFamily2 = fontFamily;
                                j10 = j3;
                                textDecoration2 = textDecoration;
                                i30 = i;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-422393234, i36, i29, "androidx.compose.material.Text (Text.kt:352)");
                            }
                            int i42 = i36 & 2147483646;
                            int i43 = 286720 | (i29 & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168);
                            int i44 = i29 << 3;
                            composer2 = startRestartGroup;
                            m1843TextIbK3jfQ(annotatedString, modifier3, j8, j9, fontStyle3, fontWeight3, fontFamily2, j10, textDecoration2, textAlign3, j7, i30, z3, i31, 1, map3, function12, textStyle2, composer2, i42, i43 | (i44 & 3670016) | (i44 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            j11 = j8;
                            j12 = j9;
                            fontStyle4 = fontStyle3;
                            fontWeight4 = fontWeight3;
                            fontFamily3 = fontFamily2;
                            j13 = j10;
                            textDecoration3 = textDecoration2;
                            textAlign4 = textAlign3;
                            j14 = j7;
                            i32 = i30;
                            z4 = z3;
                            i33 = i31;
                            map4 = map3;
                            function13 = function12;
                            textStyle3 = textStyle2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier;
                            fontFamily3 = fontFamily;
                            textAlign4 = textAlign;
                            i32 = i;
                            i33 = i2;
                            map4 = map;
                            function13 = function1;
                            textStyle3 = textStyle;
                            composer2 = startRestartGroup;
                            z4 = z2;
                            j11 = j5;
                            j12 = j6;
                            fontStyle4 = fontStyle2;
                            fontWeight4 = fontWeight2;
                            j13 = j3;
                            textDecoration3 = textDecoration;
                            j14 = j4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i45) {
                                    TextKt.m1841Text4IGK_g(AnnotatedString.this, modifier4, j11, j12, fontStyle4, fontWeight4, fontFamily3, j13, textDecoration3, textAlign4, j14, i32, z4, i33, map4, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z2 = z;
                    i24 = i5 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i5 & 16384;
                    if (i26 != 0) {
                    }
                    i27 = i5 & 32768;
                    if (i27 != 0) {
                    }
                    if ((i4 & 3670016) == 0) {
                    }
                    if (i26 == 16384) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i34 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if ((i5 & 65536) != 0) {
                    }
                    function12 = textKt$Text$8;
                    i29 = i28;
                    j7 = m6591getUnspecifiedXSAIIZE2;
                    textAlign3 = textAlign2;
                    map3 = map2;
                    i30 = m6330getClipgIe3tQ8;
                    int i412 = i40;
                    modifier3 = modifier2;
                    long j152 = m6591getUnspecifiedXSAIIZE;
                    i31 = i412;
                    z3 = z2;
                    j8 = j5;
                    fontFamily2 = fontFamily4;
                    j9 = j6;
                    fontWeight3 = fontWeight2;
                    textDecoration2 = textDecoration4;
                    fontStyle3 = fontStyle2;
                    j10 = j152;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i422 = i36 & 2147483646;
                    int i432 = 286720 | (i29 & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168);
                    int i442 = i29 << 3;
                    composer2 = startRestartGroup;
                    m1843TextIbK3jfQ(annotatedString, modifier3, j8, j9, fontStyle3, fontWeight3, fontFamily2, j10, textDecoration2, textAlign3, j7, i30, z3, i31, 1, map3, function12, textStyle2, composer2, i422, i432 | (i442 & 3670016) | (i442 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j11 = j8;
                    j12 = j9;
                    fontStyle4 = fontStyle3;
                    fontWeight4 = fontWeight3;
                    fontFamily3 = fontFamily2;
                    j13 = j10;
                    textDecoration3 = textDecoration2;
                    textAlign4 = textAlign3;
                    j14 = j7;
                    i32 = i30;
                    z4 = z3;
                    i33 = i31;
                    map4 = map3;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 == 0) {
                }
                int i362 = i14;
                i19 = i5 & 1024;
                if (i19 == 0) {
                }
                i21 = i5 & 2048;
                if (i21 == 0) {
                }
                int i372 = i20;
                i23 = i5 & 4096;
                if (i23 == 0) {
                }
                z2 = z;
                i24 = i5 & 8192;
                if (i24 != 0) {
                }
                i26 = i5 & 16384;
                if (i26 != 0) {
                }
                i27 = i5 & 32768;
                if (i27 != 0) {
                }
                if ((i4 & 3670016) == 0) {
                }
                if (i26 == 16384) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i34 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i16 != 0) {
                }
                if (i18 == 0) {
                }
                if (i19 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if ((i5 & 65536) != 0) {
                }
                function12 = textKt$Text$8;
                i29 = i28;
                j7 = m6591getUnspecifiedXSAIIZE2;
                textAlign3 = textAlign2;
                map3 = map2;
                i30 = m6330getClipgIe3tQ8;
                int i4122 = i40;
                modifier3 = modifier2;
                long j1522 = m6591getUnspecifiedXSAIIZE;
                i31 = i4122;
                z3 = z2;
                j8 = j5;
                fontFamily2 = fontFamily4;
                j9 = j6;
                fontWeight3 = fontWeight2;
                textDecoration2 = textDecoration4;
                fontStyle3 = fontStyle2;
                j10 = j1522;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i4222 = i362 & 2147483646;
                int i4322 = 286720 | (i29 & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168);
                int i4422 = i29 << 3;
                composer2 = startRestartGroup;
                m1843TextIbK3jfQ(annotatedString, modifier3, j8, j9, fontStyle3, fontWeight3, fontFamily2, j10, textDecoration2, textAlign3, j7, i30, z3, i31, 1, map3, function12, textStyle2, composer2, i4222, i4322 | (i4422 & 3670016) | (i4422 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j11 = j8;
                j12 = j9;
                fontStyle4 = fontStyle3;
                fontWeight4 = fontWeight3;
                fontFamily3 = fontFamily2;
                j13 = j10;
                textDecoration3 = textDecoration2;
                textAlign4 = textAlign3;
                j14 = j7;
                i32 = i30;
                z4 = z3;
                i33 = i31;
                map4 = map3;
                function13 = function12;
                textStyle3 = textStyle2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i14 = i8;
            i15 = i5 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 == 0) {
            }
            int i3622 = i14;
            i19 = i5 & 1024;
            if (i19 == 0) {
            }
            i21 = i5 & 2048;
            if (i21 == 0) {
            }
            int i3722 = i20;
            i23 = i5 & 4096;
            if (i23 == 0) {
            }
            z2 = z;
            i24 = i5 & 8192;
            if (i24 != 0) {
            }
            i26 = i5 & 16384;
            if (i26 != 0) {
            }
            i27 = i5 & 32768;
            if (i27 != 0) {
            }
            if ((i4 & 3670016) == 0) {
            }
            if (i26 == 16384) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i34 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i16 != 0) {
            }
            if (i18 == 0) {
            }
            if (i19 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if ((i5 & 65536) != 0) {
            }
            function12 = textKt$Text$8;
            i29 = i28;
            j7 = m6591getUnspecifiedXSAIIZE2;
            textAlign3 = textAlign2;
            map3 = map2;
            i30 = m6330getClipgIe3tQ8;
            int i41222 = i40;
            modifier3 = modifier2;
            long j15222 = m6591getUnspecifiedXSAIIZE;
            i31 = i41222;
            z3 = z2;
            j8 = j5;
            fontFamily2 = fontFamily4;
            j9 = j6;
            fontWeight3 = fontWeight2;
            textDecoration2 = textDecoration4;
            fontStyle3 = fontStyle2;
            j10 = j15222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i42222 = i3622 & 2147483646;
            int i43222 = 286720 | (i29 & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168);
            int i44222 = i29 << 3;
            composer2 = startRestartGroup;
            m1843TextIbK3jfQ(annotatedString, modifier3, j8, j9, fontStyle3, fontWeight3, fontFamily2, j10, textDecoration2, textAlign3, j7, i30, z3, i31, 1, map3, function12, textStyle2, composer2, i42222, i43222 | (i44222 & 3670016) | (i44222 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j11 = j8;
            j12 = j9;
            fontStyle4 = fontStyle3;
            fontWeight4 = fontWeight3;
            fontFamily3 = fontFamily2;
            j13 = j10;
            textDecoration3 = textDecoration2;
            textAlign4 = textAlign3;
            j14 = j7;
            i32 = i30;
            z4 = z3;
            i33 = i31;
            map4 = map3;
            function13 = function12;
            textStyle3 = textStyle2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i9 = i5 & 8;
        if (i9 == 0) {
        }
        i10 = i5 & 16;
        if (i10 == 0) {
        }
        i11 = i5 & 32;
        if (i11 == 0) {
        }
        i12 = i5 & 64;
        if (i12 == 0) {
        }
        i13 = i5 & 128;
        if (i13 == 0) {
        }
        i14 = i8;
        i15 = i5 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 == 0) {
        }
        int i36222 = i14;
        i19 = i5 & 1024;
        if (i19 == 0) {
        }
        i21 = i5 & 2048;
        if (i21 == 0) {
        }
        int i37222 = i20;
        i23 = i5 & 4096;
        if (i23 == 0) {
        }
        z2 = z;
        i24 = i5 & 8192;
        if (i24 != 0) {
        }
        i26 = i5 & 16384;
        if (i26 != 0) {
        }
        i27 = i5 & 32768;
        if (i27 != 0) {
        }
        if ((i4 & 3670016) == 0) {
        }
        if (i26 == 16384) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i34 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i16 != 0) {
        }
        if (i18 == 0) {
        }
        if (i19 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if ((i5 & 65536) != 0) {
        }
        function12 = textKt$Text$8;
        i29 = i28;
        j7 = m6591getUnspecifiedXSAIIZE2;
        textAlign3 = textAlign2;
        map3 = map2;
        i30 = m6330getClipgIe3tQ8;
        int i412222 = i40;
        modifier3 = modifier2;
        long j152222 = m6591getUnspecifiedXSAIIZE;
        i31 = i412222;
        z3 = z2;
        j8 = j5;
        fontFamily2 = fontFamily4;
        j9 = j6;
        fontWeight3 = fontWeight2;
        textDecoration2 = textDecoration4;
        fontStyle3 = fontStyle2;
        j10 = j152222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i422222 = i36222 & 2147483646;
        int i432222 = 286720 | (i29 & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168);
        int i442222 = i29 << 3;
        composer2 = startRestartGroup;
        m1843TextIbK3jfQ(annotatedString, modifier3, j8, j9, fontStyle3, fontWeight3, fontFamily2, j10, textDecoration2, textAlign3, j7, i30, z3, i31, 1, map3, function12, textStyle2, composer2, i422222, i432222 | (i442222 & 3670016) | (i442222 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j11 = j8;
        j12 = j9;
        fontStyle4 = fontStyle3;
        fontWeight4 = fontWeight3;
        fontFamily3 = fontFamily2;
        j13 = j10;
        textDecoration3 = textDecoration2;
        textAlign4 = textAlign3;
        j14 = j7;
        i32 = i30;
        z4 = z3;
        i33 = i31;
        map4 = map3;
        function13 = function12;
        textStyle3 = textStyle2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)394@17636L7,395@17661L80:Text.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle)), function2, startRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
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

                public final void invoke(Composer composer2, int i3) {
                    TextKt.ProvideTextStyle(TextStyle.this, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
