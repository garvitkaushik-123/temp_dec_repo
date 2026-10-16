package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.bidmachine.protobuf.EventTypeExtended;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020%X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0479, code lost:
    
        if (r0 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x03f9, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L247;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x044d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActions keyboardActions2;
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
        int i24;
        int i25;
        int i26;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z6;
        SolidColor solidColor;
        Brush brush2;
        KeyboardOptions keyboardOptions3;
        boolean z7;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        boolean z8;
        int i27;
        int i28;
        boolean z9;
        TextStyle textStyle3;
        VisualTransformation visualTransformation2;
        Modifier modifier3;
        Function1<? super TextLayoutResult, Unit> function13;
        KeyboardActions keyboardActions4;
        MutableInteractionSource mutableInteractionSource4;
        Object rememberedValue;
        int i29;
        boolean changed;
        int i30;
        boolean changed2;
        Object rememberedValue2;
        boolean changed3;
        KeyboardOptions keyboardOptions4;
        Composer composer2;
        final TextStyle textStyle4;
        final MutableInteractionSource mutableInteractionSource5;
        final Brush brush3;
        final boolean z10;
        final boolean z11;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33;
        final KeyboardOptions keyboardOptions5;
        final boolean z12;
        final Modifier modifier4;
        final VisualTransformation visualTransformation3;
        final Function1<? super TextLayoutResult, Unit> function14;
        final KeyboardActions keyboardActions5;
        final int i31;
        final int i32;
        ScopeUpdateScope endRestartGroup;
        int i33;
        Composer startRestartGroup = composer.startRestartGroup(945255183);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)141@8417L39,148@8811L57,154@9153L227,163@9701L41,165@9748L1032:BasicTextField.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i34 = i5 & 4;
        if (i34 != 0) {
            i6 |= 384;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 7168) == 0) {
                z4 = z;
                i6 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                    z5 = z2;
                } else {
                    z5 = z2;
                    if ((i3 & 57344) == 0) {
                        i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                }
                i9 = i5 & 32;
                if (i9 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    textStyle2 = textStyle;
                } else {
                    textStyle2 = textStyle;
                    if ((i3 & 458752) == 0) {
                        i6 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                    }
                }
                i10 = i5 & 64;
                if (i10 != 0) {
                    i6 |= 1572864;
                    keyboardOptions2 = keyboardOptions;
                } else {
                    keyboardOptions2 = keyboardOptions;
                    if ((i3 & 3670016) == 0) {
                        i6 |= startRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                    }
                }
                i11 = i5 & 128;
                if (i11 != 0) {
                    i6 |= 12582912;
                    keyboardActions2 = keyboardActions;
                } else {
                    keyboardActions2 = keyboardActions;
                    if ((i3 & 29360128) == 0) {
                        i6 |= startRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                    }
                }
                i12 = i5 & 256;
                if (i12 != 0) {
                    i6 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i6 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                }
                if ((i3 & 1879048192) == 0) {
                    if ((i5 & 512) == 0 && startRestartGroup.changed(i)) {
                        i33 = 536870912;
                        i6 |= i33;
                    }
                    i33 = 268435456;
                    i6 |= i33;
                }
                i13 = i5 & 1024;
                if (i13 != 0) {
                    i15 = i4 | 6;
                    i14 = i13;
                } else if ((i4 & 14) == 0) {
                    i14 = i13;
                    i15 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                } else {
                    i14 = i13;
                    i15 = i4;
                }
                i16 = i5 & 2048;
                if (i16 != 0) {
                    i15 |= 48;
                    i17 = i16;
                } else if ((i4 & 112) == 0) {
                    i17 = i16;
                    i15 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                } else {
                    i17 = i16;
                }
                int i35 = i15;
                i18 = i5 & 4096;
                if (i18 != 0) {
                    i19 = i35 | 384;
                } else {
                    int i36 = i35;
                    if ((i4 & 896) == 0) {
                        i36 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
                    }
                    i19 = i36;
                }
                i20 = i5 & 8192;
                if (i20 != 0) {
                    i21 = i19 | 3072;
                } else {
                    int i37 = i19;
                    if ((i4 & 7168) == 0) {
                        i21 = i37 | (startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                    } else {
                        i21 = i37;
                    }
                }
                i22 = i5 & 16384;
                if (i22 != 0) {
                    i21 |= 24576;
                } else if ((i4 & 57344) == 0) {
                    i23 = i21 | (startRestartGroup.changed(brush) ? 16384 : 8192);
                    i24 = i5 & 32768;
                    if (i24 != 0) {
                        if ((i4 & 458752) == 0) {
                            i25 = startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        int i38 = i23;
                        if ((i6 & 1533916891) == 306783378 || (374491 & i38) != 74898 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (i8 != 0) {
                                    z5 = false;
                                }
                                if (i9 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i10 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions6 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                                boolean z13 = i12 != 0 ? false : z3;
                                if ((i5 & 512) != 0) {
                                    i26 = z13 ? 1 : Integer.MAX_VALUE;
                                    i6 &= -1879048193;
                                } else {
                                    i26 = i;
                                }
                                int i39 = i14 != 0 ? 1 : i2;
                                VisualTransformation none = i17 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                BasicTextFieldKt$BasicTextField$1 basicTextFieldKt$BasicTextField$1 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                if (i20 != 0) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                                    keyboardActions3 = keyboardActions6;
                                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue3;
                                } else {
                                    keyboardActions3 = keyboardActions6;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if (i22 != 0) {
                                    z6 = z13;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z6 = z13;
                                    solidColor = brush;
                                }
                                if (i24 != 0) {
                                    KeyboardOptions keyboardOptions6 = keyboardOptions2;
                                    brush2 = solidColor;
                                    keyboardOptions3 = keyboardOptions6;
                                    function32 = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1167getLambda1$foundation_release();
                                    z8 = z4;
                                    i27 = i26;
                                    i28 = i39;
                                    z9 = z5;
                                    textStyle3 = textStyle2;
                                    visualTransformation2 = none;
                                    modifier3 = modifier2;
                                    function13 = basicTextFieldKt$BasicTextField$1;
                                    keyboardActions4 = keyboardActions3;
                                    z7 = z6;
                                } else {
                                    KeyboardOptions keyboardOptions7 = keyboardOptions2;
                                    brush2 = solidColor;
                                    keyboardOptions3 = keyboardOptions7;
                                    z7 = z6;
                                    function32 = function3;
                                    z8 = z4;
                                    i27 = i26;
                                    i28 = i39;
                                    z9 = z5;
                                    textStyle3 = textStyle2;
                                    visualTransformation2 = none;
                                    modifier3 = modifier2;
                                    function13 = basicTextFieldKt$BasicTextField$1;
                                    keyboardActions4 = keyboardActions3;
                                }
                                mutableInteractionSource4 = mutableInteractionSource3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i5 & 512) != 0) {
                                    i6 &= -1879048193;
                                }
                                z7 = z3;
                                i27 = i;
                                i28 = i2;
                                visualTransformation2 = visualTransformation;
                                function32 = function3;
                                z8 = z4;
                                z9 = z5;
                                keyboardOptions3 = keyboardOptions2;
                                modifier3 = modifier2;
                                function13 = function12;
                                brush2 = brush;
                                keyboardActions4 = keyboardActions2;
                                textStyle3 = textStyle2;
                                mutableInteractionSource4 = mutableInteractionSource;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(945255183, i6, i38, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:145)");
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                i29 = i38;
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                i29 = i38;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue;
                            final TextFieldValue m6122copy3r_uNRQ$default = TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField$lambda$2(mutableState), str, 0L, (TextRange) null, 6, (Object) null);
                            int i40 = i27;
                            startRestartGroup.startReplaceableGroup(623728715);
                            changed = startRestartGroup.changed(m6122copy3r_uNRQ$default) | startRestartGroup.changed(mutableState);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changed) {
                                i30 = i28;
                            } else {
                                i30 = i28;
                            }
                            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TextFieldValue BasicTextField$lambda$2;
                                    TextFieldValue BasicTextField$lambda$22;
                                    long selection = TextFieldValue.this.getSelection();
                                    BasicTextField$lambda$2 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState);
                                    if (TextRange.m5881equalsimpl0(selection, BasicTextField$lambda$2.getSelection())) {
                                        TextRange composition = TextFieldValue.this.getComposition();
                                        BasicTextField$lambda$22 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState);
                                        if (Intrinsics.areEqual(composition, BasicTextField$lambda$22.getComposition())) {
                                            return;
                                        }
                                    }
                                    mutableState.setValue(TextFieldValue.this);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                            changed2 = startRestartGroup.changed(str);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                            ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z7);
                            boolean z14 = !z7;
                            int i41 = i29;
                            int i42 = z7 ? 1 : i30;
                            int i43 = z7 ? 1 : i40;
                            startRestartGroup.startReplaceableGroup(623729370);
                            changed3 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(function1);
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (changed3) {
                                keyboardOptions4 = keyboardOptions3;
                            } else {
                                keyboardOptions4 = keyboardOptions3;
                            }
                            rememberedValue5 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue textFieldValue) {
                                    String BasicTextField$lambda$6;
                                    mutableState.setValue(textFieldValue);
                                    BasicTextField$lambda$6 = BasicTextFieldKt.BasicTextField$lambda$6(mutableState2);
                                    boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$6, textFieldValue.getText());
                                    mutableState2.setValue(textFieldValue.getText());
                                    if (areEqual) {
                                        return;
                                    }
                                    function1.invoke(textFieldValue.getText());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                            startRestartGroup.endReplaceableGroup();
                            int i44 = i41 << 9;
                            composer2 = startRestartGroup;
                            CoreTextFieldKt.CoreTextField(m6122copy3r_uNRQ$default, (Function1) rememberedValue5, modifier3, textStyle3, visualTransformation2, function13, mutableInteractionSource4, brush2, z14, i43, i42, imeOptions$foundation_release, keyboardActions4, z8, z9, function32, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (i44 & 57344) | (i44 & 458752) | (3670016 & i44) | (i44 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i41 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            textStyle4 = textStyle3;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            brush3 = brush2;
                            z10 = z8;
                            z11 = z9;
                            function33 = function32;
                            keyboardOptions5 = keyboardOptions4;
                            z12 = z7;
                            modifier4 = modifier3;
                            visualTransformation3 = visualTransformation2;
                            function14 = function13;
                            keyboardActions5 = keyboardActions4;
                            i31 = i40;
                            i32 = i30;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            i31 = i;
                            mutableInteractionSource5 = mutableInteractionSource;
                            function33 = function3;
                            composer2 = startRestartGroup;
                            z10 = z4;
                            keyboardActions5 = keyboardActions2;
                            z11 = z5;
                            textStyle4 = textStyle2;
                            keyboardOptions5 = keyboardOptions2;
                            modifier4 = modifier2;
                            z12 = z3;
                            i32 = i2;
                            visualTransformation3 = visualTransformation;
                            function14 = function12;
                            brush3 = brush;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
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
                                    BasicTextFieldKt.BasicTextField(str, function1, modifier4, z10, z11, textStyle4, keyboardOptions5, keyboardActions5, z12, i31, i32, visualTransformation3, function14, mutableInteractionSource5, brush3, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i25 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i23 |= i25;
                    int i382 = i23;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i34 != 0) {
                    }
                    if (i7 != 0) {
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
                    if ((i5 & 512) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<TextFieldValue> mutableState3 = (MutableState) rememberedValue;
                    final TextFieldValue m6122copy3r_uNRQ$default2 = TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField$lambda$2(mutableState3), str, 0L, (TextRange) null, 6, (Object) null);
                    int i402 = i27;
                    startRestartGroup.startReplaceableGroup(623728715);
                    changed = startRestartGroup.changed(m6122copy3r_uNRQ$default2) | startRestartGroup.changed(mutableState3);
                    Object rememberedValue42 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    rememberedValue42 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            TextFieldValue BasicTextField$lambda$2;
                            TextFieldValue BasicTextField$lambda$22;
                            long selection = TextFieldValue.this.getSelection();
                            BasicTextField$lambda$2 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState3);
                            if (TextRange.m5881equalsimpl0(selection, BasicTextField$lambda$2.getSelection())) {
                                TextRange composition = TextFieldValue.this.getComposition();
                                BasicTextField$lambda$22 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState3);
                                if (Intrinsics.areEqual(composition, BasicTextField$lambda$22.getComposition())) {
                                    return;
                                }
                            }
                            mutableState3.setValue(TextFieldValue.this);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue42);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue42, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed2 = startRestartGroup.changed(str);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<String> mutableState22 = (MutableState) rememberedValue2;
                    ImeOptions imeOptions$foundation_release2 = keyboardOptions3.toImeOptions$foundation_release(z7);
                    boolean z142 = !z7;
                    int i412 = i29;
                    if (z7) {
                    }
                    if (z7) {
                    }
                    startRestartGroup.startReplaceableGroup(623729370);
                    changed3 = startRestartGroup.changed(mutableState3) | startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(function1);
                    Object rememberedValue52 = startRestartGroup.rememberedValue();
                    if (changed3) {
                    }
                    rememberedValue52 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue textFieldValue) {
                            String BasicTextField$lambda$6;
                            mutableState3.setValue(textFieldValue);
                            BasicTextField$lambda$6 = BasicTextFieldKt.BasicTextField$lambda$6(mutableState22);
                            boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$6, textFieldValue.getText());
                            mutableState22.setValue(textFieldValue.getText());
                            if (areEqual) {
                                return;
                            }
                            function1.invoke(textFieldValue.getText());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue52);
                    startRestartGroup.endReplaceableGroup();
                    int i442 = i412 << 9;
                    composer2 = startRestartGroup;
                    CoreTextFieldKt.CoreTextField(m6122copy3r_uNRQ$default2, (Function1) rememberedValue52, modifier3, textStyle3, visualTransformation2, function13, mutableInteractionSource4, brush2, z142, i43, i42, imeOptions$foundation_release2, keyboardActions4, z8, z9, function32, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (i442 & 57344) | (i442 & 458752) | (3670016 & i442) | (i442 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i412 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textStyle4 = textStyle3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    brush3 = brush2;
                    z10 = z8;
                    z11 = z9;
                    function33 = function32;
                    keyboardOptions5 = keyboardOptions4;
                    z12 = z7;
                    modifier4 = modifier3;
                    visualTransformation3 = visualTransformation2;
                    function14 = function13;
                    keyboardActions5 = keyboardActions4;
                    i31 = i402;
                    i32 = i30;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i23 = i21;
                i24 = i5 & 32768;
                if (i24 != 0) {
                }
                i23 |= i25;
                int i3822 = i23;
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i34 != 0) {
                }
                if (i7 != 0) {
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
                if ((i5 & 512) != 0) {
                }
                if (i14 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                mutableInteractionSource4 = mutableInteractionSource3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<TextFieldValue> mutableState32 = (MutableState) rememberedValue;
                final TextFieldValue m6122copy3r_uNRQ$default22 = TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField$lambda$2(mutableState32), str, 0L, (TextRange) null, 6, (Object) null);
                int i4022 = i27;
                startRestartGroup.startReplaceableGroup(623728715);
                changed = startRestartGroup.changed(m6122copy3r_uNRQ$default22) | startRestartGroup.changed(mutableState32);
                Object rememberedValue422 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                rememberedValue422 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldValue BasicTextField$lambda$2;
                        TextFieldValue BasicTextField$lambda$22;
                        long selection = TextFieldValue.this.getSelection();
                        BasicTextField$lambda$2 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState32);
                        if (TextRange.m5881equalsimpl0(selection, BasicTextField$lambda$2.getSelection())) {
                            TextRange composition = TextFieldValue.this.getComposition();
                            BasicTextField$lambda$22 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState32);
                            if (Intrinsics.areEqual(composition, BasicTextField$lambda$22.getComposition())) {
                                return;
                            }
                        }
                        mutableState32.setValue(TextFieldValue.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue422);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue422, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed2 = startRestartGroup.changed(str);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final MutableState<String> mutableState222 = (MutableState) rememberedValue2;
                ImeOptions imeOptions$foundation_release22 = keyboardOptions3.toImeOptions$foundation_release(z7);
                boolean z1422 = !z7;
                int i4122 = i29;
                if (z7) {
                }
                if (z7) {
                }
                startRestartGroup.startReplaceableGroup(623729370);
                changed3 = startRestartGroup.changed(mutableState32) | startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(function1);
                Object rememberedValue522 = startRestartGroup.rememberedValue();
                if (changed3) {
                }
                rememberedValue522 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue textFieldValue) {
                        String BasicTextField$lambda$6;
                        mutableState32.setValue(textFieldValue);
                        BasicTextField$lambda$6 = BasicTextFieldKt.BasicTextField$lambda$6(mutableState222);
                        boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$6, textFieldValue.getText());
                        mutableState222.setValue(textFieldValue.getText());
                        if (areEqual) {
                            return;
                        }
                        function1.invoke(textFieldValue.getText());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue522);
                startRestartGroup.endReplaceableGroup();
                int i4422 = i4122 << 9;
                composer2 = startRestartGroup;
                CoreTextFieldKt.CoreTextField(m6122copy3r_uNRQ$default22, (Function1) rememberedValue522, modifier3, textStyle3, visualTransformation2, function13, mutableInteractionSource4, brush2, z1422, i43, i42, imeOptions$foundation_release22, keyboardActions4, z8, z9, function32, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (i4422 & 57344) | (i4422 & 458752) | (3670016 & i4422) | (i4422 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i4122 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                textStyle4 = textStyle3;
                mutableInteractionSource5 = mutableInteractionSource4;
                brush3 = brush2;
                z10 = z8;
                z11 = z9;
                function33 = function32;
                keyboardOptions5 = keyboardOptions4;
                z12 = z7;
                modifier4 = modifier3;
                visualTransformation3 = visualTransformation2;
                function14 = function13;
                keyboardActions5 = keyboardActions4;
                i31 = i4022;
                i32 = i30;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z4 = z;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            i9 = i5 & 32;
            if (i9 != 0) {
            }
            i10 = i5 & 64;
            if (i10 != 0) {
            }
            i11 = i5 & 128;
            if (i11 != 0) {
            }
            i12 = i5 & 256;
            if (i12 != 0) {
            }
            if ((i3 & 1879048192) == 0) {
            }
            i13 = i5 & 1024;
            if (i13 != 0) {
            }
            i16 = i5 & 2048;
            if (i16 != 0) {
            }
            int i352 = i15;
            i18 = i5 & 4096;
            if (i18 != 0) {
            }
            i20 = i5 & 8192;
            if (i20 != 0) {
            }
            i22 = i5 & 16384;
            if (i22 != 0) {
            }
            i23 = i21;
            i24 = i5 & 32768;
            if (i24 != 0) {
            }
            i23 |= i25;
            int i38222 = i23;
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i34 != 0) {
            }
            if (i7 != 0) {
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
            if ((i5 & 512) != 0) {
            }
            if (i14 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<TextFieldValue> mutableState322 = (MutableState) rememberedValue;
            final TextFieldValue m6122copy3r_uNRQ$default222 = TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField$lambda$2(mutableState322), str, 0L, (TextRange) null, 6, (Object) null);
            int i40222 = i27;
            startRestartGroup.startReplaceableGroup(623728715);
            changed = startRestartGroup.changed(m6122copy3r_uNRQ$default222) | startRestartGroup.changed(mutableState322);
            Object rememberedValue4222 = startRestartGroup.rememberedValue();
            if (changed) {
            }
            rememberedValue4222 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TextFieldValue BasicTextField$lambda$2;
                    TextFieldValue BasicTextField$lambda$22;
                    long selection = TextFieldValue.this.getSelection();
                    BasicTextField$lambda$2 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState322);
                    if (TextRange.m5881equalsimpl0(selection, BasicTextField$lambda$2.getSelection())) {
                        TextRange composition = TextFieldValue.this.getComposition();
                        BasicTextField$lambda$22 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState322);
                        if (Intrinsics.areEqual(composition, BasicTextField$lambda$22.getComposition())) {
                            return;
                        }
                    }
                    mutableState322.setValue(TextFieldValue.this);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4222);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue4222, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed2 = startRestartGroup.changed(str);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final MutableState<String> mutableState2222 = (MutableState) rememberedValue2;
            ImeOptions imeOptions$foundation_release222 = keyboardOptions3.toImeOptions$foundation_release(z7);
            boolean z14222 = !z7;
            int i41222 = i29;
            if (z7) {
            }
            if (z7) {
            }
            startRestartGroup.startReplaceableGroup(623729370);
            changed3 = startRestartGroup.changed(mutableState322) | startRestartGroup.changed(mutableState2222) | startRestartGroup.changedInstance(function1);
            Object rememberedValue5222 = startRestartGroup.rememberedValue();
            if (changed3) {
            }
            rememberedValue5222 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                    invoke2(textFieldValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextFieldValue textFieldValue) {
                    String BasicTextField$lambda$6;
                    mutableState322.setValue(textFieldValue);
                    BasicTextField$lambda$6 = BasicTextFieldKt.BasicTextField$lambda$6(mutableState2222);
                    boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$6, textFieldValue.getText());
                    mutableState2222.setValue(textFieldValue.getText());
                    if (areEqual) {
                        return;
                    }
                    function1.invoke(textFieldValue.getText());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5222);
            startRestartGroup.endReplaceableGroup();
            int i44222 = i41222 << 9;
            composer2 = startRestartGroup;
            CoreTextFieldKt.CoreTextField(m6122copy3r_uNRQ$default222, (Function1) rememberedValue5222, modifier3, textStyle3, visualTransformation2, function13, mutableInteractionSource4, brush2, z14222, i43, i42, imeOptions$foundation_release222, keyboardActions4, z8, z9, function32, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (i44222 & 57344) | (i44222 & 458752) | (3670016 & i44222) | (i44222 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i41222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            textStyle4 = textStyle3;
            mutableInteractionSource5 = mutableInteractionSource4;
            brush3 = brush2;
            z10 = z8;
            z11 = z9;
            function33 = function32;
            keyboardOptions5 = keyboardOptions4;
            z12 = z7;
            modifier4 = modifier3;
            visualTransformation3 = visualTransformation2;
            function14 = function13;
            keyboardActions5 = keyboardActions4;
            i31 = i40222;
            i32 = i30;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        z4 = z;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        i9 = i5 & 32;
        if (i9 != 0) {
        }
        i10 = i5 & 64;
        if (i10 != 0) {
        }
        i11 = i5 & 128;
        if (i11 != 0) {
        }
        i12 = i5 & 256;
        if (i12 != 0) {
        }
        if ((i3 & 1879048192) == 0) {
        }
        i13 = i5 & 1024;
        if (i13 != 0) {
        }
        i16 = i5 & 2048;
        if (i16 != 0) {
        }
        int i3522 = i15;
        i18 = i5 & 4096;
        if (i18 != 0) {
        }
        i20 = i5 & 8192;
        if (i20 != 0) {
        }
        i22 = i5 & 16384;
        if (i22 != 0) {
        }
        i23 = i21;
        i24 = i5 & 32768;
        if (i24 != 0) {
        }
        i23 |= i25;
        int i382222 = i23;
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i34 != 0) {
        }
        if (i7 != 0) {
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
        if ((i5 & 512) != 0) {
        }
        if (i14 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        mutableInteractionSource4 = mutableInteractionSource3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TextFieldValue> mutableState3222 = (MutableState) rememberedValue;
        final TextFieldValue m6122copy3r_uNRQ$default2222 = TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField$lambda$2(mutableState3222), str, 0L, (TextRange) null, 6, (Object) null);
        int i402222 = i27;
        startRestartGroup.startReplaceableGroup(623728715);
        changed = startRestartGroup.changed(m6122copy3r_uNRQ$default2222) | startRestartGroup.changed(mutableState3222);
        Object rememberedValue42222 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        rememberedValue42222 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldValue BasicTextField$lambda$2;
                TextFieldValue BasicTextField$lambda$22;
                long selection = TextFieldValue.this.getSelection();
                BasicTextField$lambda$2 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState3222);
                if (TextRange.m5881equalsimpl0(selection, BasicTextField$lambda$2.getSelection())) {
                    TextRange composition = TextFieldValue.this.getComposition();
                    BasicTextField$lambda$22 = BasicTextFieldKt.BasicTextField$lambda$2(mutableState3222);
                    if (Intrinsics.areEqual(composition, BasicTextField$lambda$22.getComposition())) {
                        return;
                    }
                }
                mutableState3222.setValue(TextFieldValue.this);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue42222);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue42222, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed2 = startRestartGroup.changed(str);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final MutableState<String> mutableState22222 = (MutableState) rememberedValue2;
        ImeOptions imeOptions$foundation_release2222 = keyboardOptions3.toImeOptions$foundation_release(z7);
        boolean z142222 = !z7;
        int i412222 = i29;
        if (z7) {
        }
        if (z7) {
        }
        startRestartGroup.startReplaceableGroup(623729370);
        changed3 = startRestartGroup.changed(mutableState3222) | startRestartGroup.changed(mutableState22222) | startRestartGroup.changedInstance(function1);
        Object rememberedValue52222 = startRestartGroup.rememberedValue();
        if (changed3) {
        }
        rememberedValue52222 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
                String BasicTextField$lambda$6;
                mutableState3222.setValue(textFieldValue);
                BasicTextField$lambda$6 = BasicTextFieldKt.BasicTextField$lambda$6(mutableState22222);
                boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$6, textFieldValue.getText());
                mutableState22222.setValue(textFieldValue.getText());
                if (areEqual) {
                    return;
                }
                function1.invoke(textFieldValue.getText());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue52222);
        startRestartGroup.endReplaceableGroup();
        int i442222 = i412222 << 9;
        composer2 = startRestartGroup;
        CoreTextFieldKt.CoreTextField(m6122copy3r_uNRQ$default2222, (Function1) rememberedValue52222, modifier3, textStyle3, visualTransformation2, function13, mutableInteractionSource4, brush2, z142222, i43, i42, imeOptions$foundation_release2222, keyboardActions4, z8, z9, function32, composer2, (i6 & 896) | ((i6 >> 6) & 7168) | (i442222 & 57344) | (i442222 & 458752) | (3670016 & i442222) | (i442222 & 29360128), ((i6 >> 15) & 896) | (i6 & 7168) | (i6 & 57344) | (i412222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        textStyle4 = textStyle3;
        mutableInteractionSource5 = mutableInteractionSource4;
        brush3 = brush2;
        z10 = z8;
        z11 = z9;
        function33 = function32;
        keyboardOptions5 = keyboardOptions4;
        z12 = z7;
        modifier4 = modifier3;
        visualTransformation3 = visualTransformation2;
        function14 = function13;
        keyboardActions5 = keyboardActions4;
        i31 = i402222;
        i32 = i30;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x03a3, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L253;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x037f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActions keyboardActions2;
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
        int i24;
        int i25;
        int i26;
        VisualTransformation none;
        BasicTextFieldKt$BasicTextField$6 basicTextFieldKt$BasicTextField$6;
        boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i27;
        SolidColor solidColor;
        MutableInteractionSource mutableInteractionSource4;
        boolean z7;
        int i28;
        KeyboardOptions keyboardOptions3;
        int i29;
        KeyboardActions keyboardActions3;
        boolean z8;
        int i30;
        boolean z9;
        Brush brush2;
        TextStyle textStyle3;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> m1168getLambda2$foundation_release;
        TextStyle textStyle4;
        boolean changed;
        MutableInteractionSource mutableInteractionSource5;
        final KeyboardActions keyboardActions4;
        Composer composer2;
        final int i31;
        final int i32;
        final boolean z10;
        final VisualTransformation visualTransformation2;
        final boolean z11;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final Function1<? super TextLayoutResult, Unit> function13;
        final Brush brush3;
        final boolean z12;
        final KeyboardOptions keyboardOptions4;
        final MutableInteractionSource mutableInteractionSource6;
        final TextStyle textStyle5;
        final Modifier modifier3;
        int i33;
        Composer startRestartGroup = composer.startRestartGroup(1804514146);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)291@17267L39,296@17507L740:BasicTextField.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i34 = i5 & 4;
        if (i34 != 0) {
            i6 |= 384;
        } else if ((i3 & 896) == 0) {
            modifier2 = modifier;
            i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 7168) == 0) {
                z4 = z;
                i6 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                    z5 = z2;
                } else {
                    z5 = z2;
                    if ((i3 & 57344) == 0) {
                        i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                }
                i9 = i5 & 32;
                if (i9 != 0) {
                    i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    textStyle2 = textStyle;
                } else {
                    textStyle2 = textStyle;
                    if ((i3 & 458752) == 0) {
                        i6 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                    }
                }
                i10 = i5 & 64;
                if (i10 != 0) {
                    i6 |= 1572864;
                    keyboardOptions2 = keyboardOptions;
                } else {
                    keyboardOptions2 = keyboardOptions;
                    if ((i3 & 3670016) == 0) {
                        i6 |= startRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                    }
                }
                i11 = i5 & 128;
                if (i11 != 0) {
                    i6 |= 12582912;
                    keyboardActions2 = keyboardActions;
                } else {
                    keyboardActions2 = keyboardActions;
                    if ((i3 & 29360128) == 0) {
                        i6 |= startRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                    }
                }
                i12 = i5 & 256;
                if (i12 != 0) {
                    i6 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i6 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                }
                if ((i3 & 1879048192) == 0) {
                    if ((i5 & 512) == 0 && startRestartGroup.changed(i)) {
                        i33 = 536870912;
                        i6 |= i33;
                    }
                    i33 = 268435456;
                    i6 |= i33;
                }
                i13 = i5 & 1024;
                if (i13 != 0) {
                    i15 = i4 | 6;
                    i14 = i13;
                } else if ((i4 & 14) == 0) {
                    i14 = i13;
                    i15 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                } else {
                    i14 = i13;
                    i15 = i4;
                }
                i16 = i5 & 2048;
                if (i16 != 0) {
                    i15 |= 48;
                    i17 = i16;
                } else if ((i4 & 112) == 0) {
                    i17 = i16;
                    i15 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                } else {
                    i17 = i16;
                }
                int i35 = i15;
                i18 = i5 & 4096;
                if (i18 != 0) {
                    i19 = i35 | 384;
                } else {
                    int i36 = i35;
                    if ((i4 & 896) == 0) {
                        i36 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
                    }
                    i19 = i36;
                }
                i20 = i5 & 8192;
                if (i20 != 0) {
                    i21 = i19 | 3072;
                } else {
                    int i37 = i19;
                    if ((i4 & 7168) == 0) {
                        i21 = i37 | (startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024);
                    } else {
                        i21 = i37;
                    }
                }
                i22 = i5 & 16384;
                if (i22 != 0) {
                    i21 |= 24576;
                } else if ((i4 & 57344) == 0) {
                    i23 = i21 | (startRestartGroup.changed(brush) ? 16384 : 8192);
                    i24 = i5 & 32768;
                    if (i24 != 0) {
                        if ((i4 & 458752) == 0) {
                            i25 = startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        int i38 = i23;
                        if ((i6 & 1533916891) == 306783378 || (374491 & i38) != 74898 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i34 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                boolean z13 = i8 != 0 ? false : z5;
                                TextStyle textStyle6 = i9 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                if (i10 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                if (i11 != 0) {
                                    keyboardActions2 = KeyboardActions.INSTANCE.getDefault();
                                }
                                boolean z14 = i12 != 0 ? false : z3;
                                if ((i5 & 512) != 0) {
                                    i26 = z14 ? 1 : Integer.MAX_VALUE;
                                    i6 &= -1879048193;
                                } else {
                                    i26 = i;
                                }
                                int i39 = i14 != 0 ? 1 : i2;
                                none = i17 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                basicTextFieldKt$BasicTextField$6 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(TextLayoutResult textLayoutResult) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                        invoke2(textLayoutResult);
                                        return Unit.INSTANCE;
                                    }
                                } : function12;
                                if (i20 != 0) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    z6 = z13;
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    z6 = z13;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                if (i22 != 0) {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    i27 = i6;
                                    solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    i27 = i6;
                                    solidColor = brush;
                                }
                                if (i24 != 0) {
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    z7 = z14;
                                    i28 = i26;
                                    i29 = i39;
                                    i30 = i27;
                                    z9 = z4;
                                    brush2 = solidColor;
                                    textStyle3 = textStyle6;
                                    m1168getLambda2$foundation_release = ComposableSingletons$BasicTextFieldKt.INSTANCE.m1168getLambda2$foundation_release();
                                    keyboardOptions3 = keyboardOptions2;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z6;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        textStyle4 = textStyle3;
                                    } else {
                                        textStyle4 = textStyle3;
                                        ComposerKt.traceEventStart(1804514146, i30, i38, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:295)");
                                    }
                                    ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z7);
                                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                                    Brush brush4 = brush2;
                                    boolean z15 = !z7;
                                    int i40 = !z7 ? 1 : i29;
                                    Modifier modifier4 = modifier2;
                                    Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = m1168getLambda2$foundation_release;
                                    int i41 = !z7 ? 1 : i28;
                                    startRestartGroup.startReplaceableGroup(623737120);
                                    changed = startRestartGroup.changed(textFieldValue) | startRestartGroup.changedInstance(function1);
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (changed) {
                                        mutableInteractionSource5 = mutableInteractionSource7;
                                    } else {
                                        mutableInteractionSource5 = mutableInteractionSource7;
                                    }
                                    rememberedValue2 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                                            invoke2(textFieldValue2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextFieldValue textFieldValue2) {
                                            if (Intrinsics.areEqual(TextFieldValue.this, textFieldValue2)) {
                                                return;
                                            }
                                            function1.invoke(textFieldValue2);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                    startRestartGroup.endReplaceableGroup();
                                    int i42 = i38 << 9;
                                    int i43 = ((i30 >> 6) & 7168) | (i30 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | (i42 & 57344) | (i42 & 458752) | (i42 & 3670016) | (i42 & 29360128);
                                    int i44 = (i30 & 7168) | ((i30 >> 15) & 896) | (i30 & 57344) | (i38 & 458752);
                                    boolean z16 = z7;
                                    Function1<? super TextLayoutResult, Unit> function14 = basicTextFieldKt$BasicTextField$6;
                                    TextStyle textStyle7 = textStyle4;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    VisualTransformation visualTransformation3 = none;
                                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource5;
                                    CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) rememberedValue2, modifier4, textStyle7, visualTransformation3, function14, mutableInteractionSource8, brush4, z15, i41, i40, imeOptions$foundation_release, keyboardActions3, z9, z8, function33, startRestartGroup, i43, i44, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    keyboardActions4 = keyboardActions3;
                                    composer2 = startRestartGroup;
                                    i31 = i28;
                                    i32 = i29;
                                    z10 = z16;
                                    visualTransformation2 = visualTransformation3;
                                    z11 = z9;
                                    function32 = function33;
                                    function13 = function14;
                                    brush3 = brush4;
                                    z12 = z8;
                                    keyboardOptions4 = keyboardOptions5;
                                    mutableInteractionSource6 = mutableInteractionSource8;
                                    textStyle5 = textStyle7;
                                    modifier3 = modifier4;
                                } else {
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    z7 = z14;
                                    i28 = i26;
                                    keyboardOptions3 = keyboardOptions2;
                                    i29 = i39;
                                    keyboardActions3 = keyboardActions2;
                                    z8 = z6;
                                    i30 = i27;
                                    z9 = z4;
                                    brush2 = solidColor;
                                    textStyle3 = textStyle6;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i5 & 512) != 0) {
                                    i6 &= -1879048193;
                                }
                                z7 = z3;
                                i28 = i;
                                i29 = i2;
                                none = visualTransformation;
                                basicTextFieldKt$BasicTextField$6 = function12;
                                i30 = i6;
                                z9 = z4;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                mutableInteractionSource4 = mutableInteractionSource;
                                brush2 = brush;
                                z8 = z5;
                            }
                            m1168getLambda2$foundation_release = function3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ImeOptions imeOptions$foundation_release2 = keyboardOptions3.toImeOptions$foundation_release(z7);
                            MutableInteractionSource mutableInteractionSource72 = mutableInteractionSource4;
                            Brush brush42 = brush2;
                            boolean z152 = !z7;
                            if (!z7) {
                            }
                            Modifier modifier42 = modifier2;
                            Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function332 = m1168getLambda2$foundation_release;
                            if (!z7) {
                            }
                            startRestartGroup.startReplaceableGroup(623737120);
                            changed = startRestartGroup.changed(textFieldValue) | startRestartGroup.changedInstance(function1);
                            Object rememberedValue22 = startRestartGroup.rememberedValue();
                            if (changed) {
                            }
                            rememberedValue22 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue2) {
                                    invoke2(textFieldValue2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue textFieldValue2) {
                                    if (Intrinsics.areEqual(TextFieldValue.this, textFieldValue2)) {
                                        return;
                                    }
                                    function1.invoke(textFieldValue2);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue22);
                            startRestartGroup.endReplaceableGroup();
                            int i422 = i38 << 9;
                            int i432 = ((i30 >> 6) & 7168) | (i30 & EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_PAID_VALUE) | (i422 & 57344) | (i422 & 458752) | (i422 & 3670016) | (i422 & 29360128);
                            int i442 = (i30 & 7168) | ((i30 >> 15) & 896) | (i30 & 57344) | (i38 & 458752);
                            boolean z162 = z7;
                            Function1<? super TextLayoutResult, Unit> function142 = basicTextFieldKt$BasicTextField$6;
                            TextStyle textStyle72 = textStyle4;
                            KeyboardOptions keyboardOptions52 = keyboardOptions3;
                            VisualTransformation visualTransformation32 = none;
                            MutableInteractionSource mutableInteractionSource82 = mutableInteractionSource5;
                            CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) rememberedValue22, modifier42, textStyle72, visualTransformation32, function142, mutableInteractionSource82, brush42, z152, i41, i40, imeOptions$foundation_release2, keyboardActions3, z9, z8, function332, startRestartGroup, i432, i442, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            keyboardActions4 = keyboardActions3;
                            composer2 = startRestartGroup;
                            i31 = i28;
                            i32 = i29;
                            z10 = z162;
                            visualTransformation2 = visualTransformation32;
                            z11 = z9;
                            function32 = function332;
                            function13 = function142;
                            brush3 = brush42;
                            z12 = z8;
                            keyboardOptions4 = keyboardOptions52;
                            mutableInteractionSource6 = mutableInteractionSource82;
                            textStyle5 = textStyle72;
                            modifier3 = modifier42;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            i31 = i;
                            function13 = function12;
                            function32 = function3;
                            composer2 = startRestartGroup;
                            z11 = z4;
                            z12 = z5;
                            textStyle5 = textStyle2;
                            keyboardOptions4 = keyboardOptions2;
                            keyboardActions4 = keyboardActions2;
                            modifier3 = modifier2;
                            z10 = z3;
                            i32 = i2;
                            visualTransformation2 = visualTransformation;
                            mutableInteractionSource6 = mutableInteractionSource;
                            brush3 = brush;
                        }
                        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
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
                                    BasicTextFieldKt.BasicTextField(TextFieldValue.this, function1, modifier3, z11, z12, textStyle5, keyboardOptions4, keyboardActions4, z10, i31, i32, visualTransformation2, function13, mutableInteractionSource6, brush3, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i25 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i23 |= i25;
                    int i382 = i23;
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i34 != 0) {
                    }
                    if (i7 != 0) {
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
                    if ((i5 & 512) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                }
                i23 = i21;
                i24 = i5 & 32768;
                if (i24 != 0) {
                }
                i23 |= i25;
                int i3822 = i23;
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i34 != 0) {
                }
                if (i7 != 0) {
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
                if ((i5 & 512) != 0) {
                }
                if (i14 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
            }
            z4 = z;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            i9 = i5 & 32;
            if (i9 != 0) {
            }
            i10 = i5 & 64;
            if (i10 != 0) {
            }
            i11 = i5 & 128;
            if (i11 != 0) {
            }
            i12 = i5 & 256;
            if (i12 != 0) {
            }
            if ((i3 & 1879048192) == 0) {
            }
            i13 = i5 & 1024;
            if (i13 != 0) {
            }
            i16 = i5 & 2048;
            if (i16 != 0) {
            }
            int i352 = i15;
            i18 = i5 & 4096;
            if (i18 != 0) {
            }
            i20 = i5 & 8192;
            if (i20 != 0) {
            }
            i22 = i5 & 16384;
            if (i22 != 0) {
            }
            i23 = i21;
            i24 = i5 & 32768;
            if (i24 != 0) {
            }
            i23 |= i25;
            int i38222 = i23;
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i34 != 0) {
            }
            if (i7 != 0) {
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
            if ((i5 & 512) != 0) {
            }
            if (i14 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        z4 = z;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        i9 = i5 & 32;
        if (i9 != 0) {
        }
        i10 = i5 & 64;
        if (i10 != 0) {
        }
        i11 = i5 & 128;
        if (i11 != 0) {
        }
        i12 = i5 & 256;
        if (i12 != 0) {
        }
        if ((i3 & 1879048192) == 0) {
        }
        i13 = i5 & 1024;
        if (i13 != 0) {
        }
        i16 = i5 & 2048;
        if (i16 != 0) {
        }
        int i3522 = i15;
        i18 = i5 & 4096;
        if (i18 != 0) {
        }
        i20 = i5 & 8192;
        if (i20 != 0) {
        }
        i22 = i5 & 16384;
        if (i22 != 0) {
        }
        i23 = i21;
        i24 = i5 & 32768;
        if (i24 != 0) {
        }
        i23 |= i25;
        int i382222 = i23;
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i34 != 0) {
        }
        if (i7 != 0) {
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
        if ((i5 & 512) != 0) {
        }
        if (i14 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e5  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
        String str2;
        int i5;
        Function1 function13;
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActions keyboardActions2;
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
        int i24;
        int i25;
        int i26;
        boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        boolean z7;
        SolidColor solidColor;
        Composer composer2;
        final Modifier modifier3;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z10;
        final int i27;
        final VisualTransformation visualTransformation2;
        final Function1 function14;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)335@18937L39,340@19177L579:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            str2 = str;
        } else if ((i2 & 14) == 0) {
            str2 = str;
            i5 = (startRestartGroup.changed(str2) ? 4 : 2) | i2;
        } else {
            str2 = str;
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            function13 = function1;
            i5 |= startRestartGroup.changedInstance(function13) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    z4 = z;
                    i5 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        z5 = z2;
                    } else {
                        z5 = z2;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i2 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i10 = i4 & 64;
                    if (i10 == 0) {
                        i5 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                        i5 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i2 & 29360128) == 0) {
                            i5 |= startRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i4 & 256;
                    if (i12 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i5 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    i13 = i4 & 512;
                    if (i13 == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i2 & 1879048192) == 0) {
                        i14 = i13;
                        i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                        i15 = i4 & 1024;
                        if (i15 != 0) {
                            i17 = i3 | 6;
                            i16 = i15;
                        } else if ((i3 & 14) == 0) {
                            i16 = i15;
                            i17 = i3 | (startRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i3;
                        }
                        i18 = i4 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                            i19 = i18;
                        } else if ((i3 & 112) == 0) {
                            i19 = i18;
                            i17 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
                        } else {
                            i19 = i18;
                        }
                        int i28 = i17;
                        i20 = i4 & 4096;
                        if (i20 != 0) {
                            i21 = i28 | 384;
                        } else {
                            int i29 = i28;
                            if ((i3 & 896) == 0) {
                                i29 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                            }
                            i21 = i29;
                        }
                        i22 = i4 & 8192;
                        if (i22 != 0) {
                            i23 = i21 | 3072;
                        } else {
                            int i30 = i21;
                            if ((i3 & 7168) == 0) {
                                i23 = i30 | (startRestartGroup.changed(brush) ? 2048 : 1024);
                            } else {
                                i23 = i30;
                            }
                        }
                        i24 = i4 & 16384;
                        if (i24 != 0) {
                            i26 = i23 | 24576;
                        } else {
                            if ((i3 & 57344) == 0) {
                                i25 = i23 | (startRestartGroup.changedInstance(function3) ? 16384 : 8192);
                            } else {
                                i25 = i23;
                            }
                            i26 = i25;
                        }
                        if ((i5 & 1533916891) == 306783378 || (46811 & i26) != 9362 || !startRestartGroup.getSkipping()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            boolean z11 = i7 != 0 ? true : z4;
                            boolean z12 = i8 != 0 ? false : z5;
                            TextStyle textStyle4 = i9 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            KeyboardOptions keyboardOptions4 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                            KeyboardActions keyboardActions4 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                            boolean z13 = i12 != 0 ? false : z3;
                            int i31 = i14 != 0 ? Integer.MAX_VALUE : i;
                            VisualTransformation none = i16 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                            Function1 function15 = i19 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$10
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult textLayoutResult) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            } : function12;
                            if (i20 != 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                z6 = z11;
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                z6 = z11;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if (i22 != 0) {
                                z7 = z12;
                                solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                            } else {
                                z7 = z12;
                                solidColor = brush;
                            }
                            Function3 m1169getLambda3$foundation_release = i24 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1169getLambda3$foundation_release() : function3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-454732590, i5, i26, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:339)");
                            }
                            int i32 = i26 << 3;
                            boolean z14 = z7;
                            Brush brush3 = solidColor;
                            composer2 = startRestartGroup;
                            String str3 = str2;
                            Function1 function16 = function13;
                            TextStyle textStyle5 = textStyle4;
                            Modifier modifier4 = modifier2;
                            VisualTransformation visualTransformation3 = none;
                            boolean z15 = z6;
                            BasicTextField(str3, (Function1<? super String, Unit>) function16, modifier4, z15, z14, textStyle5, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush3, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1169getLambda3$foundation_release, composer2, i5 & 2147483646, (i32 & 112) | 6 | (i32 & 896) | (i32 & 7168) | (i32 & 57344) | (i32 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z8 = z15;
                            z9 = z14;
                            textStyle3 = textStyle5;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z10 = z13;
                            i27 = i31;
                            visualTransformation2 = visualTransformation3;
                            function14 = function15;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            brush2 = brush3;
                            function32 = m1169getLambda3$foundation_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z10 = z3;
                            function14 = function12;
                            mutableInteractionSource3 = mutableInteractionSource;
                            composer2 = startRestartGroup;
                            z8 = z4;
                            z9 = z5;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            modifier3 = modifier2;
                            i27 = i;
                            visualTransformation2 = visualTransformation;
                            brush2 = brush;
                            function32 = function3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$12
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

                                public final void invoke(Composer composer3, int i33) {
                                    BasicTextFieldKt.BasicTextField(str, function1, modifier3, z8, z9, textStyle3, keyboardOptions3, keyboardActions3, z10, i27, visualTransformation2, function14, mutableInteractionSource3, brush2, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 != 0) {
                    }
                    int i282 = i17;
                    i20 = i4 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i4 & 8192;
                    if (i22 != 0) {
                    }
                    i24 = i4 & 16384;
                    if (i24 != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
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
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i322 = i26 << 3;
                    boolean z142 = z7;
                    Brush brush32 = solidColor;
                    composer2 = startRestartGroup;
                    String str32 = str2;
                    Function1 function162 = function13;
                    TextStyle textStyle52 = textStyle4;
                    Modifier modifier42 = modifier2;
                    VisualTransformation visualTransformation32 = none;
                    boolean z152 = z6;
                    BasicTextField(str32, (Function1<? super String, Unit>) function162, modifier42, z152, z142, textStyle52, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation32, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush32, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1169getLambda3$foundation_release, composer2, i5 & 2147483646, (i322 & 112) | 6 | (i322 & 896) | (i322 & 7168) | (i322 & 57344) | (i322 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    z8 = z152;
                    z9 = z142;
                    textStyle3 = textStyle52;
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions3 = keyboardActions4;
                    z10 = z13;
                    i27 = i31;
                    visualTransformation2 = visualTransformation32;
                    function14 = function15;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    brush2 = brush32;
                    function32 = m1169getLambda3$foundation_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 == 0) {
                }
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                i12 = i4 & 256;
                if (i12 == 0) {
                }
                i13 = i4 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 != 0) {
                }
                i18 = i4 & 2048;
                if (i18 != 0) {
                }
                int i2822 = i17;
                i20 = i4 & 4096;
                if (i20 != 0) {
                }
                i22 = i4 & 8192;
                if (i22 != 0) {
                }
                i24 = i4 & 16384;
                if (i24 != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
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
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i3222 = i26 << 3;
                boolean z1422 = z7;
                Brush brush322 = solidColor;
                composer2 = startRestartGroup;
                String str322 = str2;
                Function1 function1622 = function13;
                TextStyle textStyle522 = textStyle4;
                Modifier modifier422 = modifier2;
                VisualTransformation visualTransformation322 = none;
                boolean z1522 = z6;
                BasicTextField(str322, (Function1<? super String, Unit>) function1622, modifier422, z1522, z1422, textStyle522, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation322, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush322, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1169getLambda3$foundation_release, composer2, i5 & 2147483646, (i3222 & 112) | 6 | (i3222 & 896) | (i3222 & 7168) | (i3222 & 57344) | (i3222 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                z8 = z1522;
                z9 = z1422;
                textStyle3 = textStyle522;
                keyboardOptions3 = keyboardOptions4;
                keyboardActions3 = keyboardActions4;
                z10 = z13;
                i27 = i31;
                visualTransformation2 = visualTransformation322;
                function14 = function15;
                mutableInteractionSource3 = mutableInteractionSource2;
                brush2 = brush322;
                function32 = m1169getLambda3$foundation_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 == 0) {
            }
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            i12 = i4 & 256;
            if (i12 == 0) {
            }
            i13 = i4 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 != 0) {
            }
            i18 = i4 & 2048;
            if (i18 != 0) {
            }
            int i28222 = i17;
            i20 = i4 & 4096;
            if (i20 != 0) {
            }
            i22 = i4 & 8192;
            if (i22 != 0) {
            }
            i24 = i4 & 16384;
            if (i24 != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
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
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i32222 = i26 << 3;
            boolean z14222 = z7;
            Brush brush3222 = solidColor;
            composer2 = startRestartGroup;
            String str3222 = str2;
            Function1 function16222 = function13;
            TextStyle textStyle5222 = textStyle4;
            Modifier modifier4222 = modifier2;
            VisualTransformation visualTransformation3222 = none;
            boolean z15222 = z6;
            BasicTextField(str3222, (Function1<? super String, Unit>) function16222, modifier4222, z15222, z14222, textStyle5222, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation3222, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush3222, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1169getLambda3$foundation_release, composer2, i5 & 2147483646, (i32222 & 112) | 6 | (i32222 & 896) | (i32222 & 7168) | (i32222 & 57344) | (i32222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            z8 = z15222;
            z9 = z14222;
            textStyle3 = textStyle5222;
            keyboardOptions3 = keyboardOptions4;
            keyboardActions3 = keyboardActions4;
            z10 = z13;
            i27 = i31;
            visualTransformation2 = visualTransformation3222;
            function14 = function15;
            mutableInteractionSource3 = mutableInteractionSource2;
            brush2 = brush3222;
            function32 = m1169getLambda3$foundation_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function13 = function1;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 == 0) {
        }
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        i12 = i4 & 256;
        if (i12 == 0) {
        }
        i13 = i4 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 != 0) {
        }
        i18 = i4 & 2048;
        if (i18 != 0) {
        }
        int i282222 = i17;
        i20 = i4 & 4096;
        if (i20 != 0) {
        }
        i22 = i4 & 8192;
        if (i22 != 0) {
        }
        i24 = i4 & 16384;
        if (i24 != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
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
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i322222 = i26 << 3;
        boolean z142222 = z7;
        Brush brush32222 = solidColor;
        composer2 = startRestartGroup;
        String str32222 = str2;
        Function1 function162222 = function13;
        TextStyle textStyle52222 = textStyle4;
        Modifier modifier42222 = modifier2;
        VisualTransformation visualTransformation32222 = none;
        boolean z152222 = z6;
        BasicTextField(str32222, (Function1<? super String, Unit>) function162222, modifier42222, z152222, z142222, textStyle52222, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation32222, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush32222, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1169getLambda3$foundation_release, composer2, i5 & 2147483646, (i322222 & 112) | 6 | (i322222 & 896) | (i322222 & 7168) | (i322222 & 57344) | (i322222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        z8 = z152222;
        z9 = z142222;
        textStyle3 = textStyle52222;
        keyboardOptions3 = keyboardOptions4;
        keyboardActions3 = keyboardActions4;
        z10 = z13;
        i27 = i31;
        visualTransformation2 = visualTransformation32222;
        function14 = function15;
        mutableInteractionSource3 = mutableInteractionSource2;
        brush2 = brush32222;
        function32 = m1169getLambda3$foundation_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02e5  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
        TextFieldValue textFieldValue2;
        int i5;
        Function1 function13;
        int i6;
        Modifier modifier2;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        int i9;
        TextStyle textStyle2;
        int i10;
        KeyboardOptions keyboardOptions2;
        int i11;
        KeyboardActions keyboardActions2;
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
        int i24;
        int i25;
        int i26;
        boolean z6;
        MutableInteractionSource mutableInteractionSource2;
        boolean z7;
        SolidColor solidColor;
        Composer composer2;
        final Modifier modifier3;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z10;
        final int i27;
        final VisualTransformation visualTransformation2;
        final Function1 function14;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)375@20462L39,380@20702L579:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
            textFieldValue2 = textFieldValue;
        } else if ((i2 & 14) == 0) {
            textFieldValue2 = textFieldValue;
            i5 = (startRestartGroup.changed(textFieldValue2) ? 4 : 2) | i2;
        } else {
            textFieldValue2 = textFieldValue;
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            function13 = function1;
            i5 |= startRestartGroup.changedInstance(function13) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                modifier2 = modifier;
                i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    z4 = z;
                    i5 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        z5 = z2;
                    } else {
                        z5 = z2;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i2 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i10 = i4 & 64;
                    if (i10 == 0) {
                        i5 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i11 = i4 & 128;
                    if (i11 == 0) {
                        i5 |= 12582912;
                        keyboardActions2 = keyboardActions;
                    } else {
                        keyboardActions2 = keyboardActions;
                        if ((i2 & 29360128) == 0) {
                            i5 |= startRestartGroup.changed(keyboardActions2) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i4 & 256;
                    if (i12 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i5 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    i13 = i4 & 512;
                    if (i13 == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i2 & 1879048192) == 0) {
                        i14 = i13;
                        i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                        i15 = i4 & 1024;
                        if (i15 != 0) {
                            i17 = i3 | 6;
                            i16 = i15;
                        } else if ((i3 & 14) == 0) {
                            i16 = i15;
                            i17 = i3 | (startRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i16 = i15;
                            i17 = i3;
                        }
                        i18 = i4 & 2048;
                        if (i18 != 0) {
                            i17 |= 48;
                            i19 = i18;
                        } else if ((i3 & 112) == 0) {
                            i19 = i18;
                            i17 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
                        } else {
                            i19 = i18;
                        }
                        int i28 = i17;
                        i20 = i4 & 4096;
                        if (i20 != 0) {
                            i21 = i28 | 384;
                        } else {
                            int i29 = i28;
                            if ((i3 & 896) == 0) {
                                i29 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                            }
                            i21 = i29;
                        }
                        i22 = i4 & 8192;
                        if (i22 != 0) {
                            i23 = i21 | 3072;
                        } else {
                            int i30 = i21;
                            if ((i3 & 7168) == 0) {
                                i23 = i30 | (startRestartGroup.changed(brush) ? 2048 : 1024);
                            } else {
                                i23 = i30;
                            }
                        }
                        i24 = i4 & 16384;
                        if (i24 != 0) {
                            i26 = i23 | 24576;
                        } else {
                            if ((i3 & 57344) == 0) {
                                i25 = i23 | (startRestartGroup.changedInstance(function3) ? 16384 : 8192);
                            } else {
                                i25 = i23;
                            }
                            i26 = i25;
                        }
                        if ((i5 & 1533916891) == 306783378 || (46811 & i26) != 9362 || !startRestartGroup.getSkipping()) {
                            if (i6 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            boolean z11 = i7 != 0 ? true : z4;
                            boolean z12 = i8 != 0 ? false : z5;
                            TextStyle textStyle4 = i9 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            KeyboardOptions keyboardOptions4 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions2;
                            KeyboardActions keyboardActions4 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions2;
                            boolean z13 = i12 != 0 ? false : z3;
                            int i31 = i14 != 0 ? Integer.MAX_VALUE : i;
                            VisualTransformation none = i16 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                            Function1 function15 = i19 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$13
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult textLayoutResult) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }
                            } : function12;
                            if (i20 != 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                z6 = z11;
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                z6 = z11;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if (i22 != 0) {
                                z7 = z12;
                                solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                            } else {
                                z7 = z12;
                                solidColor = brush;
                            }
                            Function3 m1170getLambda4$foundation_release = i24 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1170getLambda4$foundation_release() : function3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-560482651, i5, i26, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:379)");
                            }
                            int i32 = i26 << 3;
                            boolean z14 = z7;
                            Brush brush3 = solidColor;
                            composer2 = startRestartGroup;
                            TextFieldValue textFieldValue3 = textFieldValue2;
                            Function1 function16 = function13;
                            TextStyle textStyle5 = textStyle4;
                            Modifier modifier4 = modifier2;
                            VisualTransformation visualTransformation3 = none;
                            boolean z15 = z6;
                            BasicTextField(textFieldValue3, (Function1<? super TextFieldValue, Unit>) function16, modifier4, z15, z14, textStyle5, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush3, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1170getLambda4$foundation_release, composer2, i5 & 2147483646, (i32 & 112) | 6 | (i32 & 896) | (i32 & 7168) | (i32 & 57344) | (i32 & 458752), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z8 = z15;
                            z9 = z14;
                            textStyle3 = textStyle5;
                            keyboardOptions3 = keyboardOptions4;
                            keyboardActions3 = keyboardActions4;
                            z10 = z13;
                            i27 = i31;
                            visualTransformation2 = visualTransformation3;
                            function14 = function15;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            brush2 = brush3;
                            function32 = m1170getLambda4$foundation_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z10 = z3;
                            function14 = function12;
                            mutableInteractionSource3 = mutableInteractionSource;
                            composer2 = startRestartGroup;
                            z8 = z4;
                            z9 = z5;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            modifier3 = modifier2;
                            i27 = i;
                            visualTransformation2 = visualTransformation;
                            brush2 = brush;
                            function32 = function3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$15
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

                                public final void invoke(Composer composer3, int i33) {
                                    BasicTextFieldKt.BasicTextField(TextFieldValue.this, function1, modifier3, z8, z9, textStyle3, keyboardOptions3, keyboardActions3, z10, i27, visualTransformation2, function14, mutableInteractionSource3, brush2, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 != 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 != 0) {
                    }
                    int i282 = i17;
                    i20 = i4 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i4 & 8192;
                    if (i22 != 0) {
                    }
                    i24 = i4 & 16384;
                    if (i24 != 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
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
                    if (i14 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i322 = i26 << 3;
                    boolean z142 = z7;
                    Brush brush32 = solidColor;
                    composer2 = startRestartGroup;
                    TextFieldValue textFieldValue32 = textFieldValue2;
                    Function1 function162 = function13;
                    TextStyle textStyle52 = textStyle4;
                    Modifier modifier42 = modifier2;
                    VisualTransformation visualTransformation32 = none;
                    boolean z152 = z6;
                    BasicTextField(textFieldValue32, (Function1<? super TextFieldValue, Unit>) function162, modifier42, z152, z142, textStyle52, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation32, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush32, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1170getLambda4$foundation_release, composer2, i5 & 2147483646, (i322 & 112) | 6 | (i322 & 896) | (i322 & 7168) | (i322 & 57344) | (i322 & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    z8 = z152;
                    z9 = z142;
                    textStyle3 = textStyle52;
                    keyboardOptions3 = keyboardOptions4;
                    keyboardActions3 = keyboardActions4;
                    z10 = z13;
                    i27 = i31;
                    visualTransformation2 = visualTransformation32;
                    function14 = function15;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    brush2 = brush32;
                    function32 = m1170getLambda4$foundation_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z4 = z;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 == 0) {
                }
                i10 = i4 & 64;
                if (i10 == 0) {
                }
                i11 = i4 & 128;
                if (i11 == 0) {
                }
                i12 = i4 & 256;
                if (i12 == 0) {
                }
                i13 = i4 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 != 0) {
                }
                i18 = i4 & 2048;
                if (i18 != 0) {
                }
                int i2822 = i17;
                i20 = i4 & 4096;
                if (i20 != 0) {
                }
                i22 = i4 & 8192;
                if (i22 != 0) {
                }
                i24 = i4 & 16384;
                if (i24 != 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
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
                if (i14 != 0) {
                }
                if (i16 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i24 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i3222 = i26 << 3;
                boolean z1422 = z7;
                Brush brush322 = solidColor;
                composer2 = startRestartGroup;
                TextFieldValue textFieldValue322 = textFieldValue2;
                Function1 function1622 = function13;
                TextStyle textStyle522 = textStyle4;
                Modifier modifier422 = modifier2;
                VisualTransformation visualTransformation322 = none;
                boolean z1522 = z6;
                BasicTextField(textFieldValue322, (Function1<? super TextFieldValue, Unit>) function1622, modifier422, z1522, z1422, textStyle522, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation322, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush322, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1170getLambda4$foundation_release, composer2, i5 & 2147483646, (i3222 & 112) | 6 | (i3222 & 896) | (i3222 & 7168) | (i3222 & 57344) | (i3222 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                z8 = z1522;
                z9 = z1422;
                textStyle3 = textStyle522;
                keyboardOptions3 = keyboardOptions4;
                keyboardActions3 = keyboardActions4;
                z10 = z13;
                i27 = i31;
                visualTransformation2 = visualTransformation322;
                function14 = function15;
                mutableInteractionSource3 = mutableInteractionSource2;
                brush2 = brush322;
                function32 = m1170getLambda4$foundation_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 == 0) {
            }
            i10 = i4 & 64;
            if (i10 == 0) {
            }
            i11 = i4 & 128;
            if (i11 == 0) {
            }
            i12 = i4 & 256;
            if (i12 == 0) {
            }
            i13 = i4 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 != 0) {
            }
            i18 = i4 & 2048;
            if (i18 != 0) {
            }
            int i28222 = i17;
            i20 = i4 & 4096;
            if (i20 != 0) {
            }
            i22 = i4 & 8192;
            if (i22 != 0) {
            }
            i24 = i4 & 16384;
            if (i24 != 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
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
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i24 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i32222 = i26 << 3;
            boolean z14222 = z7;
            Brush brush3222 = solidColor;
            composer2 = startRestartGroup;
            TextFieldValue textFieldValue3222 = textFieldValue2;
            Function1 function16222 = function13;
            TextStyle textStyle5222 = textStyle4;
            Modifier modifier4222 = modifier2;
            VisualTransformation visualTransformation3222 = none;
            boolean z15222 = z6;
            BasicTextField(textFieldValue3222, (Function1<? super TextFieldValue, Unit>) function16222, modifier4222, z15222, z14222, textStyle5222, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation3222, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush3222, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1170getLambda4$foundation_release, composer2, i5 & 2147483646, (i32222 & 112) | 6 | (i32222 & 896) | (i32222 & 7168) | (i32222 & 57344) | (i32222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            z8 = z15222;
            z9 = z14222;
            textStyle3 = textStyle5222;
            keyboardOptions3 = keyboardOptions4;
            keyboardActions3 = keyboardActions4;
            z10 = z13;
            i27 = i31;
            visualTransformation2 = visualTransformation3222;
            function14 = function15;
            mutableInteractionSource3 = mutableInteractionSource2;
            brush2 = brush3222;
            function32 = m1170getLambda4$foundation_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function13 = function1;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        modifier2 = modifier;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 == 0) {
        }
        i10 = i4 & 64;
        if (i10 == 0) {
        }
        i11 = i4 & 128;
        if (i11 == 0) {
        }
        i12 = i4 & 256;
        if (i12 == 0) {
        }
        i13 = i4 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 != 0) {
        }
        i18 = i4 & 2048;
        if (i18 != 0) {
        }
        int i282222 = i17;
        i20 = i4 & 4096;
        if (i20 != 0) {
        }
        i22 = i4 & 8192;
        if (i22 != 0) {
        }
        i24 = i4 & 16384;
        if (i24 != 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
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
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i24 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i322222 = i26 << 3;
        boolean z142222 = z7;
        Brush brush32222 = solidColor;
        composer2 = startRestartGroup;
        TextFieldValue textFieldValue32222 = textFieldValue2;
        Function1 function162222 = function13;
        TextStyle textStyle52222 = textStyle4;
        Modifier modifier42222 = modifier2;
        VisualTransformation visualTransformation32222 = none;
        boolean z152222 = z6;
        BasicTextField(textFieldValue32222, (Function1<? super TextFieldValue, Unit>) function162222, modifier42222, z152222, z142222, textStyle52222, keyboardOptions4, keyboardActions4, z13, i31, 1, visualTransformation32222, (Function1<? super TextLayoutResult, Unit>) function15, mutableInteractionSource2, brush32222, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1170getLambda4$foundation_release, composer2, i5 & 2147483646, (i322222 & 112) | 6 | (i322222 & 896) | (i322222 & 7168) | (i322222 & 57344) | (i322222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        z8 = z152222;
        z9 = z142222;
        textStyle3 = textStyle52222;
        keyboardOptions3 = keyboardOptions4;
        keyboardActions3 = keyboardActions4;
        z10 = z13;
        i27 = i31;
        visualTransformation2 = visualTransformation32222;
        function14 = function15;
        mutableInteractionSource3 = mutableInteractionSource2;
        brush2 = brush32222;
        function32 = m1170getLambda4$foundation_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
