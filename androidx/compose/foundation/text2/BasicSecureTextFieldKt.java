package androidx.compose.foundation.text2;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.CodepointTransformationKt;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.InputTransformationKt;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.TextObfuscationMode;
import androidx.compose.foundation.text2.input.internal.StateSyncingModifierKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BasicSecureTextField.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001aÔ\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aè\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030,2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u001928\b\u0002\u0010\u001a\u001a2\u0012\u0004\u0012\u00020\u001c\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b¢\u0006\u0002\b\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a \u0010/\u001a\u00020\u00032\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\u0002\b1H\u0003¢\u0006\u0002\u00102\u001a\u0010\u00103\u001a\u0002042\u0006\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002"}, d2 = {"LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "onSubmit", "Landroidx/compose/foundation/text2/input/ImeActionHandler;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textObfuscationMode", "Landroidx/compose/foundation/text2/input/TextObfuscationMode;", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "decorator", "Landroidx/compose/foundation/text2/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-mMrxcSU", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "BasicSecureTextField-TLP4tmw", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text2/input/ImeActionHandler;IIIZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "KeyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release", "valueWithSelection", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:100:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026c  */
    /* renamed from: BasicSecureTextField-TLP4tmw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1387BasicSecureTextFieldTLP4tmw(final String str, final Function1<? super String, Unit> function1, Modifier modifier, ImeActionHandler imeActionHandler, int i, int i2, int i3, boolean z, InputTransformation inputTransformation, TextStyle textStyle, MutableInteractionSource mutableInteractionSource, Brush brush, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        ImeActionHandler imeActionHandler2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
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
        int i27;
        int m1417getRevealLastTypedpyid5Pk;
        TextStyle textStyle2;
        ImeActionHandler imeActionHandler3;
        boolean z3;
        SolidColor solidColor;
        TextFieldDecorator textFieldDecorator2;
        ScrollState scrollState2;
        int i28;
        int i29;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        InputTransformation inputTransformation2;
        boolean z4;
        int i30;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush2;
        TextFieldDecorator textFieldDecorator3;
        Object rememberedValue;
        int i31;
        ImeActionHandler imeActionHandler4;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        Composer composer2;
        final Modifier modifier4;
        final ImeActionHandler imeActionHandler5;
        final int i32;
        final int i33;
        final int i34;
        final boolean z5;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle3;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final TextFieldDecorator textFieldDecorator4;
        final ScrollState scrollState3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(917546540);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)P(14,10,7,8,3:c#ui.text.input.ImeAction,12:c#foundation.text2.input.TextObfuscationMode,6:c#ui.text.input.KeyboardType,2,4,13,5!1,9)156@9390L21,158@9433L213,168@9839L174,178@10082L957:BasicSecureTextField.kt#g98mwb");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i4 & 112) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i35 = i6 & 4;
        if (i35 != 0) {
            i7 |= 384;
        } else if ((i4 & 896) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i4 & 7168) == 0) {
                imeActionHandler2 = imeActionHandler;
                i7 |= startRestartGroup.changed(imeActionHandler2) ? 2048 : 1024;
                i9 = i6 & 16;
                int i36 = 8192;
                if (i9 != 0) {
                    i7 |= 24576;
                    i10 = i;
                } else {
                    i10 = i;
                    if ((i4 & 57344) == 0) {
                        i7 |= startRestartGroup.changed(i10) ? 16384 : 8192;
                    }
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i12 = i2;
                } else {
                    i12 = i2;
                    if ((i4 & 458752) == 0) {
                        i7 |= startRestartGroup.changed(i12) ? 131072 : 65536;
                    }
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                    i7 |= 1572864;
                    i14 = i3;
                } else {
                    i14 = i3;
                    if ((i4 & 3670016) == 0) {
                        i7 |= startRestartGroup.changed(i14) ? 1048576 : 524288;
                    }
                }
                i15 = i6 & 128;
                if (i15 != 0) {
                    i7 |= 12582912;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i4 & 29360128) == 0) {
                        i7 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                }
                i16 = i6 & 256;
                if (i16 != 0) {
                    i7 |= 100663296;
                } else if ((i4 & 234881024) == 0) {
                    i7 |= startRestartGroup.changed(inputTransformation) ? 67108864 : 33554432;
                }
                i17 = i6 & 512;
                if (i17 != 0) {
                    i7 |= C.ENCODING_PCM_32BIT;
                } else if ((i4 & 1879048192) == 0) {
                    i18 = i17;
                    i7 |= startRestartGroup.changed(textStyle) ? 536870912 : 268435456;
                    i19 = i6 & 1024;
                    if (i19 == 0) {
                        i21 = i5 | 6;
                        i20 = i19;
                    } else if ((i5 & 14) == 0) {
                        i20 = i19;
                        i21 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i20 = i19;
                        i21 = i5;
                    }
                    i22 = i6 & 2048;
                    if (i22 == 0) {
                        i21 |= 48;
                        i23 = i22;
                    } else if ((i5 & 112) == 0) {
                        i23 = i22;
                        i21 |= startRestartGroup.changed(brush) ? 32 : 16;
                    } else {
                        i23 = i22;
                    }
                    int i37 = i21;
                    i24 = i6 & 4096;
                    if (i24 == 0) {
                        i25 = i37 | 384;
                    } else {
                        int i38 = i37;
                        if ((i5 & 896) == 0) {
                            i38 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
                        }
                        i25 = i38;
                    }
                    i26 = i6 & 8192;
                    if (i26 == 0) {
                        i27 = i25 | 3072;
                    } else {
                        int i39 = i25;
                        if ((i5 & 7168) == 0) {
                            i27 = i39 | (startRestartGroup.changed(textFieldDecorator) ? 2048 : 1024);
                        } else {
                            i27 = i39;
                        }
                    }
                    if ((i5 & 57344) == 0) {
                        if ((i6 & 16384) == 0 && startRestartGroup.changed(scrollState)) {
                            i36 = 16384;
                        }
                        i27 |= i36;
                    }
                    if ((i7 & 1533916891) == 306783378 || (i27 & 46811) != 9362 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i35 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i8 != 0) {
                                imeActionHandler2 = null;
                            }
                            int m6064getDefaulteUduSuo = i9 == 0 ? ImeAction.INSTANCE.m6064getDefaulteUduSuo() : i10;
                            m1417getRevealLastTypedpyid5Pk = i11 == 0 ? TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk() : i12;
                            if (i13 != 0) {
                                i14 = KeyboardType.INSTANCE.m6117getPasswordPjHm6EE();
                            }
                            if (i15 != 0) {
                                z2 = true;
                            }
                            InputTransformation inputTransformation4 = i16 == 0 ? null : inputTransformation;
                            textStyle2 = i18 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                            MutableInteractionSource mutableInteractionSource4 = i20 == 0 ? null : mutableInteractionSource;
                            if (i23 == 0) {
                                imeActionHandler3 = imeActionHandler2;
                                z3 = z2;
                                solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                            } else {
                                imeActionHandler3 = imeActionHandler2;
                                z3 = z2;
                                solidColor = brush;
                            }
                            Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i24 == 0 ? null : function2;
                            textFieldDecorator2 = i26 == 0 ? null : textFieldDecorator;
                            if ((i6 & 16384) == 0) {
                                i27 &= -57345;
                                scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                            } else {
                                scrollState2 = scrollState;
                            }
                            i28 = i14;
                            i29 = i27;
                            function22 = function24;
                            inputTransformation2 = inputTransformation4;
                            z4 = z3;
                            i30 = m6064getDefaulteUduSuo;
                            modifier3 = modifier2;
                            mutableInteractionSource2 = mutableInteractionSource4;
                            brush2 = solidColor;
                            imeActionHandler2 = imeActionHandler3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i6 & 16384) != 0) {
                                i27 &= -57345;
                            }
                            textStyle2 = textStyle;
                            brush2 = brush;
                            textFieldDecorator2 = textFieldDecorator;
                            scrollState2 = scrollState;
                            m1417getRevealLastTypedpyid5Pk = i12;
                            modifier3 = modifier2;
                            i29 = i27;
                            mutableInteractionSource2 = mutableInteractionSource;
                            function22 = function2;
                            z4 = z2;
                            i30 = i10;
                            i28 = i14;
                            inputTransformation2 = inputTransformation;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            textFieldDecorator3 = textFieldDecorator2;
                        } else {
                            textFieldDecorator3 = textFieldDecorator2;
                            ComposerKt.traceEventStart(917546540, i7, i29, "androidx.compose.foundation.text2.BasicSecureTextField (BasicSecureTextField.kt:157)");
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                            i31 = i7;
                            imeActionHandler4 = imeActionHandler2;
                            rememberedValue = new TextFieldState(str, TextRangeKt.TextRange(str.length()), (DefaultConstructorMarker) null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        } else {
                            i31 = i7;
                            imeActionHandler4 = imeActionHandler2;
                        }
                        startRestartGroup.endReplaceableGroup();
                        TextFieldState textFieldState = (TextFieldState) rememberedValue;
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, TextRangeKt.TextRange(str.length()), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue2;
                        mutableState.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicSecureTextField_TLP4tmw$lambda$2(mutableState), str, 0L, (TextRange) null, 6, (Object) null));
                        TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2 = BasicSecureTextField_TLP4tmw$lambda$2(mutableState);
                        startRestartGroup.startReplaceableGroup(1829191301);
                        changed = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(function1);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1
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
                                    TextFieldValue BasicSecureTextField_TLP4tmw$lambda$22;
                                    String text = textFieldValue.getText();
                                    BasicSecureTextField_TLP4tmw$lambda$22 = BasicSecureTextFieldKt.BasicSecureTextField_TLP4tmw$lambda$2(mutableState);
                                    if (!Intrinsics.areEqual(text, BasicSecureTextField_TLP4tmw$lambda$22.getText())) {
                                        function1.invoke(textFieldValue.getText());
                                    }
                                    mutableState.setValue(textFieldValue);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        Modifier syncTextFieldState = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState, BasicSecureTextField_TLP4tmw$lambda$2, (Function1) rememberedValue3, false);
                        int i40 = i31 >> 3;
                        TextFieldDecorator textFieldDecorator5 = textFieldDecorator3;
                        ImeActionHandler imeActionHandler6 = imeActionHandler4;
                        composer2 = startRestartGroup;
                        m1388BasicSecureTextFieldmMrxcSU(textFieldState, syncTextFieldState, imeActionHandler6, i30, m1417getRevealLastTypedpyid5Pk, i28, z4, inputTransformation2, textStyle2, mutableInteractionSource2, brush2, function22, textFieldDecorator5, scrollState2, composer2, (i40 & 234881024) | (i40 & 896) | 6 | (i40 & 7168) | (i40 & 57344) | (458752 & i40) | (3670016 & i40) | (29360128 & i40) | ((i29 << 27) & 1879048192), (i29 >> 3) & 8190, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        imeActionHandler5 = imeActionHandler6;
                        i32 = i30;
                        i33 = m1417getRevealLastTypedpyid5Pk;
                        i34 = i28;
                        z5 = z4;
                        inputTransformation3 = inputTransformation2;
                        textStyle3 = textStyle2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        brush3 = brush2;
                        function23 = function22;
                        textFieldDecorator4 = textFieldDecorator5;
                        scrollState3 = scrollState2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        textStyle3 = textStyle;
                        textFieldDecorator4 = textFieldDecorator;
                        composer2 = startRestartGroup;
                        imeActionHandler5 = imeActionHandler2;
                        z5 = z2;
                        i32 = i10;
                        i33 = i12;
                        i34 = i14;
                        modifier4 = modifier2;
                        inputTransformation3 = inputTransformation;
                        mutableInteractionSource3 = mutableInteractionSource;
                        brush3 = brush;
                        function23 = function2;
                        scrollState3 = scrollState;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$2
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

                            public final void invoke(Composer composer3, int i41) {
                                BasicSecureTextFieldKt.m1387BasicSecureTextFieldTLP4tmw(str, function1, modifier4, imeActionHandler5, i32, i33, i34, z5, inputTransformation3, textStyle3, mutableInteractionSource3, brush3, function23, textFieldDecorator4, scrollState3, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                i18 = i17;
                i19 = i6 & 1024;
                if (i19 == 0) {
                }
                i22 = i6 & 2048;
                if (i22 == 0) {
                }
                int i372 = i21;
                i24 = i6 & 4096;
                if (i24 == 0) {
                }
                i26 = i6 & 8192;
                if (i26 == 0) {
                }
                if ((i5 & 57344) == 0) {
                }
                if ((i7 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i4 & 1) != 0) {
                }
                if (i35 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i20 == 0) {
                }
                if (i23 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if ((i6 & 16384) == 0) {
                }
                i28 = i14;
                i29 = i27;
                function22 = function24;
                inputTransformation2 = inputTransformation4;
                z4 = z3;
                i30 = m6064getDefaulteUduSuo;
                modifier3 = modifier2;
                mutableInteractionSource2 = mutableInteractionSource4;
                brush2 = solidColor;
                imeActionHandler2 = imeActionHandler3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                TextFieldState textFieldState2 = (TextFieldState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<TextFieldValue> mutableState2 = (MutableState) rememberedValue2;
                mutableState2.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicSecureTextField_TLP4tmw$lambda$2(mutableState2), str, 0L, (TextRange) null, 6, (Object) null));
                TextFieldValue BasicSecureTextField_TLP4tmw$lambda$22 = BasicSecureTextField_TLP4tmw$lambda$2(mutableState2);
                startRestartGroup.startReplaceableGroup(1829191301);
                changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(function1);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1
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
                        TextFieldValue BasicSecureTextField_TLP4tmw$lambda$222;
                        String text = textFieldValue.getText();
                        BasicSecureTextField_TLP4tmw$lambda$222 = BasicSecureTextFieldKt.BasicSecureTextField_TLP4tmw$lambda$2(mutableState2);
                        if (!Intrinsics.areEqual(text, BasicSecureTextField_TLP4tmw$lambda$222.getText())) {
                            function1.invoke(textFieldValue.getText());
                        }
                        mutableState2.setValue(textFieldValue);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                Modifier syncTextFieldState2 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState2, BasicSecureTextField_TLP4tmw$lambda$22, (Function1) rememberedValue3, false);
                int i402 = i31 >> 3;
                TextFieldDecorator textFieldDecorator52 = textFieldDecorator3;
                ImeActionHandler imeActionHandler62 = imeActionHandler4;
                composer2 = startRestartGroup;
                m1388BasicSecureTextFieldmMrxcSU(textFieldState2, syncTextFieldState2, imeActionHandler62, i30, m1417getRevealLastTypedpyid5Pk, i28, z4, inputTransformation2, textStyle2, mutableInteractionSource2, brush2, function22, textFieldDecorator52, scrollState2, composer2, (i402 & 234881024) | (i402 & 896) | 6 | (i402 & 7168) | (i402 & 57344) | (458752 & i402) | (3670016 & i402) | (29360128 & i402) | ((i29 << 27) & 1879048192), (i29 >> 3) & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                imeActionHandler5 = imeActionHandler62;
                i32 = i30;
                i33 = m1417getRevealLastTypedpyid5Pk;
                i34 = i28;
                z5 = z4;
                inputTransformation3 = inputTransformation2;
                textStyle3 = textStyle2;
                mutableInteractionSource3 = mutableInteractionSource2;
                brush3 = brush2;
                function23 = function22;
                textFieldDecorator4 = textFieldDecorator52;
                scrollState3 = scrollState2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            imeActionHandler2 = imeActionHandler;
            i9 = i6 & 16;
            int i362 = 8192;
            if (i9 != 0) {
            }
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            i15 = i6 & 128;
            if (i15 != 0) {
            }
            i16 = i6 & 256;
            if (i16 != 0) {
            }
            i17 = i6 & 512;
            if (i17 != 0) {
            }
            i18 = i17;
            i19 = i6 & 1024;
            if (i19 == 0) {
            }
            i22 = i6 & 2048;
            if (i22 == 0) {
            }
            int i3722 = i21;
            i24 = i6 & 4096;
            if (i24 == 0) {
            }
            i26 = i6 & 8192;
            if (i26 == 0) {
            }
            if ((i5 & 57344) == 0) {
            }
            if ((i7 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i4 & 1) != 0) {
            }
            if (i35 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i20 == 0) {
            }
            if (i23 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if ((i6 & 16384) == 0) {
            }
            i28 = i14;
            i29 = i27;
            function22 = function24;
            inputTransformation2 = inputTransformation4;
            z4 = z3;
            i30 = m6064getDefaulteUduSuo;
            modifier3 = modifier2;
            mutableInteractionSource2 = mutableInteractionSource4;
            brush2 = solidColor;
            imeActionHandler2 = imeActionHandler3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldState textFieldState22 = (TextFieldState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<TextFieldValue> mutableState22 = (MutableState) rememberedValue2;
            mutableState22.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicSecureTextField_TLP4tmw$lambda$2(mutableState22), str, 0L, (TextRange) null, 6, (Object) null));
            TextFieldValue BasicSecureTextField_TLP4tmw$lambda$222 = BasicSecureTextField_TLP4tmw$lambda$2(mutableState22);
            startRestartGroup.startReplaceableGroup(1829191301);
            changed = startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(function1);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1
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
                    TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2222;
                    String text = textFieldValue.getText();
                    BasicSecureTextField_TLP4tmw$lambda$2222 = BasicSecureTextFieldKt.BasicSecureTextField_TLP4tmw$lambda$2(mutableState22);
                    if (!Intrinsics.areEqual(text, BasicSecureTextField_TLP4tmw$lambda$2222.getText())) {
                        function1.invoke(textFieldValue.getText());
                    }
                    mutableState22.setValue(textFieldValue);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            Modifier syncTextFieldState22 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState22, BasicSecureTextField_TLP4tmw$lambda$222, (Function1) rememberedValue3, false);
            int i4022 = i31 >> 3;
            TextFieldDecorator textFieldDecorator522 = textFieldDecorator3;
            ImeActionHandler imeActionHandler622 = imeActionHandler4;
            composer2 = startRestartGroup;
            m1388BasicSecureTextFieldmMrxcSU(textFieldState22, syncTextFieldState22, imeActionHandler622, i30, m1417getRevealLastTypedpyid5Pk, i28, z4, inputTransformation2, textStyle2, mutableInteractionSource2, brush2, function22, textFieldDecorator522, scrollState2, composer2, (i4022 & 234881024) | (i4022 & 896) | 6 | (i4022 & 7168) | (i4022 & 57344) | (458752 & i4022) | (3670016 & i4022) | (29360128 & i4022) | ((i29 << 27) & 1879048192), (i29 >> 3) & 8190, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            imeActionHandler5 = imeActionHandler622;
            i32 = i30;
            i33 = m1417getRevealLastTypedpyid5Pk;
            i34 = i28;
            z5 = z4;
            inputTransformation3 = inputTransformation2;
            textStyle3 = textStyle2;
            mutableInteractionSource3 = mutableInteractionSource2;
            brush3 = brush2;
            function23 = function22;
            textFieldDecorator4 = textFieldDecorator522;
            scrollState3 = scrollState2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        imeActionHandler2 = imeActionHandler;
        i9 = i6 & 16;
        int i3622 = 8192;
        if (i9 != 0) {
        }
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        i15 = i6 & 128;
        if (i15 != 0) {
        }
        i16 = i6 & 256;
        if (i16 != 0) {
        }
        i17 = i6 & 512;
        if (i17 != 0) {
        }
        i18 = i17;
        i19 = i6 & 1024;
        if (i19 == 0) {
        }
        i22 = i6 & 2048;
        if (i22 == 0) {
        }
        int i37222 = i21;
        i24 = i6 & 4096;
        if (i24 == 0) {
        }
        i26 = i6 & 8192;
        if (i26 == 0) {
        }
        if ((i5 & 57344) == 0) {
        }
        if ((i7 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i4 & 1) != 0) {
        }
        if (i35 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i20 == 0) {
        }
        if (i23 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if ((i6 & 16384) == 0) {
        }
        i28 = i14;
        i29 = i27;
        function22 = function24;
        inputTransformation2 = inputTransformation4;
        z4 = z3;
        i30 = m6064getDefaulteUduSuo;
        modifier3 = modifier2;
        mutableInteractionSource2 = mutableInteractionSource4;
        brush2 = solidColor;
        imeActionHandler2 = imeActionHandler3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        TextFieldState textFieldState222 = (TextFieldState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TextFieldValue> mutableState222 = (MutableState) rememberedValue2;
        mutableState222.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicSecureTextField_TLP4tmw$lambda$2(mutableState222), str, 0L, (TextRange) null, 6, (Object) null));
        TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2222 = BasicSecureTextField_TLP4tmw$lambda$2(mutableState222);
        startRestartGroup.startReplaceableGroup(1829191301);
        changed = startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(function1);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$1$1
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
                TextFieldValue BasicSecureTextField_TLP4tmw$lambda$22222;
                String text = textFieldValue.getText();
                BasicSecureTextField_TLP4tmw$lambda$22222 = BasicSecureTextFieldKt.BasicSecureTextField_TLP4tmw$lambda$2(mutableState222);
                if (!Intrinsics.areEqual(text, BasicSecureTextField_TLP4tmw$lambda$22222.getText())) {
                    function1.invoke(textFieldValue.getText());
                }
                mutableState222.setValue(textFieldValue);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        Modifier syncTextFieldState222 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState222, BasicSecureTextField_TLP4tmw$lambda$2222, (Function1) rememberedValue3, false);
        int i40222 = i31 >> 3;
        TextFieldDecorator textFieldDecorator5222 = textFieldDecorator3;
        ImeActionHandler imeActionHandler6222 = imeActionHandler4;
        composer2 = startRestartGroup;
        m1388BasicSecureTextFieldmMrxcSU(textFieldState222, syncTextFieldState222, imeActionHandler6222, i30, m1417getRevealLastTypedpyid5Pk, i28, z4, inputTransformation2, textStyle2, mutableInteractionSource2, brush2, function22, textFieldDecorator5222, scrollState2, composer2, (i40222 & 234881024) | (i40222 & 896) | 6 | (i40222 & 7168) | (i40222 & 57344) | (458752 & i40222) | (3670016 & i40222) | (29360128 & i40222) | ((i29 << 27) & 1879048192), (i29 >> 3) & 8190, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        imeActionHandler5 = imeActionHandler6222;
        i32 = i30;
        i33 = m1417getRevealLastTypedpyid5Pk;
        i34 = i28;
        z5 = z4;
        inputTransformation3 = inputTransformation2;
        textStyle3 = textStyle2;
        mutableInteractionSource3 = mutableInteractionSource2;
        brush3 = brush2;
        function23 = function22;
        textFieldDecorator4 = textFieldDecorator5222;
        scrollState3 = scrollState2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicSecureTextField_TLP4tmw$lambda$2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01d0, code lost:
    
        if (r3.changed(r47) == false) goto L149;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0395  */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r31v6, types: [androidx.compose.foundation.text2.TextFieldDecorator] */
    /* JADX WARN: Type inference failed for: r31v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r46v0, types: [androidx.compose.foundation.text2.TextFieldDecorator, java.lang.Object] */
    /* renamed from: BasicSecureTextField-mMrxcSU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1388BasicSecureTextFieldmMrxcSU(final TextFieldState textFieldState, Modifier modifier, ImeActionHandler imeActionHandler, int i, int i2, int i3, boolean z, InputTransformation inputTransformation, TextStyle textStyle, MutableInteractionSource mutableInteractionSource, Brush brush, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        ImeActionHandler imeActionHandler2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
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
        int i27;
        int m1417getRevealLastTypedpyid5Pk;
        Modifier modifier3;
        ImeActionHandler imeActionHandler3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        SolidColor solidColor;
        final ImeActionHandler imeActionHandler4;
        final ScrollState scrollState2;
        final Brush brush2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final int i28;
        final int i29;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        final ?? r31;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        final boolean m1412equalsimpl0;
        final CodepointTransformation codepointTransformation;
        CodepointTransformation mask;
        Modifier.Companion companion;
        Composer composer2;
        final int i30;
        final Modifier modifier4;
        final InputTransformation inputTransformation3;
        final int i31;
        final int i32;
        final ImeActionHandler imeActionHandler5;
        final boolean z4;
        final TextStyle textStyle3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush3;
        final TextFieldDecorator textFieldDecorator2;
        final ScrollState scrollState3;
        ScopeUpdateScope endRestartGroup;
        ?? startRestartGroup = composer.startRestartGroup(1073441926);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)P(11,7,8,3:c#ui.text.input.ImeAction,12:c#foundation.text2.input.TextObfuscationMode,6:c#ui.text.input.KeyboardType,2,4,13,5!1,9)277@16038L21,281@16205L24,282@16266L82,322@17467L1064:BasicSecureTextField.kt#g98mwb");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i7 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            i7 |= 48;
        } else if ((i4 & 112) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 896) == 0) {
                imeActionHandler2 = imeActionHandler;
                i7 |= startRestartGroup.changed(imeActionHandler2) ? 256 : 128;
                i9 = i6 & 8;
                int i34 = 2048;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i4 & 7168) == 0) {
                    i10 = i;
                    i7 |= startRestartGroup.changed(i10) ? 2048 : 1024;
                    i11 = i6 & 16;
                    if (i11 == 0) {
                        i7 |= 24576;
                        i12 = i2;
                    } else {
                        i12 = i2;
                        if ((i4 & 57344) == 0) {
                            i7 |= startRestartGroup.changed(i12) ? 16384 : 8192;
                        }
                    }
                    i13 = i6 & 32;
                    if (i13 == 0) {
                        i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i14 = i3;
                    } else {
                        i14 = i3;
                        if ((i4 & 458752) == 0) {
                            i7 |= startRestartGroup.changed(i14) ? 131072 : 65536;
                        }
                    }
                    i15 = i6 & 64;
                    if (i15 == 0) {
                        i7 |= 1572864;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i4 & 3670016) == 0) {
                            i7 |= startRestartGroup.changed(z2) ? 1048576 : 524288;
                        }
                    }
                    i16 = i6 & 128;
                    if (i16 == 0) {
                        i7 |= 12582912;
                    } else if ((i4 & 29360128) == 0) {
                        i7 |= startRestartGroup.changed(inputTransformation) ? 8388608 : 4194304;
                    }
                    i17 = i6 & 256;
                    if (i17 == 0) {
                        i7 |= 100663296;
                    } else if ((i4 & 234881024) == 0) {
                        i18 = i17;
                        i7 |= startRestartGroup.changed(textStyle) ? 67108864 : 33554432;
                        i19 = i6 & 512;
                        if (i19 != 0) {
                            i7 |= C.ENCODING_PCM_32BIT;
                        } else if ((i4 & 1879048192) == 0) {
                            i20 = i19;
                            i7 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            i21 = i6 & 1024;
                            if (i21 == 0) {
                                i23 = i5 | 6;
                                i22 = i21;
                            } else if ((i5 & 14) == 0) {
                                i22 = i21;
                                i23 = i5 | (startRestartGroup.changed(brush) ? 4 : 2);
                            } else {
                                i22 = i21;
                                i23 = i5;
                            }
                            i24 = i6 & 2048;
                            if (i24 == 0) {
                                i23 |= 48;
                                i25 = i24;
                            } else if ((i5 & 112) == 0) {
                                i25 = i24;
                                i23 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
                            } else {
                                i25 = i24;
                            }
                            int i35 = i23;
                            i26 = i6 & 4096;
                            if (i26 == 0) {
                                i27 = i35 | 384;
                            } else {
                                i27 = i35;
                                if ((i5 & 896) == 0) {
                                    i27 |= startRestartGroup.changed(textFieldDecorator) ? 256 : 128;
                                    if ((i5 & 7168) == 0) {
                                        if ((i6 & 8192) != 0) {
                                        }
                                        i34 = 1024;
                                        i27 |= i34;
                                    }
                                    int i36 = i27;
                                    if ((i7 & 1533916891) == 306783378 || (i36 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i4 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            Modifier.Companion companion2 = i33 != 0 ? Modifier.INSTANCE : modifier2;
                                            if (i8 != 0) {
                                                imeActionHandler2 = null;
                                            }
                                            if (i9 != 0) {
                                                i10 = ImeAction.INSTANCE.m6064getDefaulteUduSuo();
                                            }
                                            m1417getRevealLastTypedpyid5Pk = i11 != 0 ? TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk() : i12;
                                            int m6117getPasswordPjHm6EE = i13 != 0 ? KeyboardType.INSTANCE.m6117getPasswordPjHm6EE() : i14;
                                            if (i15 != 0) {
                                                z2 = true;
                                            }
                                            InputTransformation inputTransformation4 = i16 != 0 ? null : inputTransformation;
                                            TextStyle textStyle4 = i18 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                                            MutableInteractionSource mutableInteractionSource4 = i20 != 0 ? null : mutableInteractionSource;
                                            if (i22 != 0) {
                                                imeActionHandler3 = imeActionHandler2;
                                                modifier3 = companion2;
                                                function22 = null;
                                                solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                                            } else {
                                                modifier3 = companion2;
                                                imeActionHandler3 = imeActionHandler2;
                                                function22 = null;
                                                solidColor = brush;
                                            }
                                            Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = i25 != 0 ? function22 : function2;
                                            Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function26 = i26 != 0 ? function22 : textFieldDecorator;
                                            if ((i6 & 8192) != 0) {
                                                i36 &= -7169;
                                                imeActionHandler4 = imeActionHandler3;
                                                scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                            } else {
                                                imeActionHandler4 = imeActionHandler3;
                                                scrollState2 = scrollState;
                                            }
                                            brush2 = solidColor;
                                            function23 = function25;
                                            i28 = i10;
                                            i29 = m6117getPasswordPjHm6EE;
                                            inputTransformation2 = inputTransformation4;
                                            textStyle2 = textStyle4;
                                            mutableInteractionSource2 = mutableInteractionSource4;
                                            z3 = z2;
                                            r31 = function26;
                                            modifier2 = modifier3;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i6 & 8192) != 0) {
                                                i36 &= -7169;
                                            }
                                            inputTransformation2 = inputTransformation;
                                            textStyle2 = textStyle;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            brush2 = brush;
                                            function23 = function2;
                                            r31 = textFieldDecorator;
                                            scrollState2 = scrollState;
                                            imeActionHandler4 = imeActionHandler2;
                                            i28 = i10;
                                            m1417getRevealLastTypedpyid5Pk = i12;
                                            i29 = i14;
                                            z3 = z2;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1073441926, i7, i36, "androidx.compose.foundation.text2.BasicSecureTextField (BasicSecureTextField.kt:280)");
                                        }
                                        startRestartGroup.startReplaceableGroup(773894976);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                        changed = startRestartGroup.changed(coroutineScope);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new SecureTextFieldController(coroutineScope);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) rememberedValue2;
                                        m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
                                        if (!m1412equalsimpl0) {
                                            secureTextFieldController.getPasswordRevealFilter().hide();
                                        }
                                        if (m1412equalsimpl0) {
                                            mask = secureTextFieldController.getCodepointTransformation();
                                        } else if (TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1416getHiddenpyid5Pk())) {
                                            mask = CodepointTransformationKt.mask(CodepointTransformation.INSTANCE, Typography.bullet);
                                        } else {
                                            codepointTransformation = null;
                                            Modifier semantics = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            return false;
                                                        }
                                                    }, 1, null);
                                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            return false;
                                                        }
                                                    }, 1, null);
                                                }
                                            });
                                            if (!m1412equalsimpl0) {
                                                companion = secureTextFieldController.getFocusChangeModifier();
                                            } else {
                                                companion = Modifier.INSTANCE;
                                            }
                                            final Modifier then = semantics.then(companion);
                                            DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                                                /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                                                
                                                    r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                                                 */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final void invoke(Composer composer3, int i37) {
                                                    InputTransformation inputTransformation5;
                                                    KeyboardActions keyboardActions;
                                                    ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                                                    if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                                                        }
                                                        if (m1412equalsimpl0) {
                                                            inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController.getPasswordRevealFilter());
                                                        } else {
                                                            inputTransformation5 = inputTransformation2;
                                                        }
                                                        InputTransformation inputTransformation6 = inputTransformation5;
                                                        TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                                                        ImeActionHandler imeActionHandler6 = imeActionHandler4;
                                                        if (imeActionHandler6 == null || keyboardActions == null) {
                                                            keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                                        }
                                                        BasicTextField2Kt.BasicTextField2(textFieldState, then, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer3.skipToGroupEnd();
                                                }
                                            }), startRestartGroup, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2 = startRestartGroup;
                                            i30 = m1417getRevealLastTypedpyid5Pk;
                                            modifier4 = modifier2;
                                            inputTransformation3 = inputTransformation2;
                                            i31 = i29;
                                            i32 = i28;
                                            imeActionHandler5 = imeActionHandler4;
                                            z4 = z3;
                                            textStyle3 = textStyle2;
                                            function24 = function23;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            brush3 = brush2;
                                            textFieldDecorator2 = r31;
                                            scrollState3 = scrollState2;
                                        }
                                        codepointTransformation = mask;
                                        Modifier semantics2 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        return false;
                                                    }
                                                }, 1, null);
                                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        return false;
                                                    }
                                                }, 1, null);
                                            }
                                        });
                                        if (!m1412equalsimpl0) {
                                        }
                                        final Modifier then2 = semantics2.then(companion);
                                        DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                                            /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                                            
                                                r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                                             */
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final void invoke(Composer composer3, int i37) {
                                                InputTransformation inputTransformation5;
                                                KeyboardActions keyboardActions;
                                                ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                                                if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                                                    }
                                                    if (m1412equalsimpl0) {
                                                        inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController.getPasswordRevealFilter());
                                                    } else {
                                                        inputTransformation5 = inputTransformation2;
                                                    }
                                                    InputTransformation inputTransformation6 = inputTransformation5;
                                                    TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                                                    ImeActionHandler imeActionHandler6 = imeActionHandler4;
                                                    if (imeActionHandler6 == null || keyboardActions == null) {
                                                        keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                                    }
                                                    BasicTextField2Kt.BasicTextField2(textFieldState, then2, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        composer2 = startRestartGroup;
                                        i30 = m1417getRevealLastTypedpyid5Pk;
                                        modifier4 = modifier2;
                                        inputTransformation3 = inputTransformation2;
                                        i31 = i29;
                                        i32 = i28;
                                        imeActionHandler5 = imeActionHandler4;
                                        z4 = z3;
                                        textStyle3 = textStyle2;
                                        function24 = function23;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        brush3 = brush2;
                                        textFieldDecorator2 = r31;
                                        scrollState3 = scrollState2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        inputTransformation3 = inputTransformation;
                                        function24 = function2;
                                        scrollState3 = scrollState;
                                        composer2 = startRestartGroup;
                                        imeActionHandler5 = imeActionHandler2;
                                        i32 = i10;
                                        i30 = i12;
                                        i31 = i14;
                                        modifier4 = modifier2;
                                        z4 = z2;
                                        textStyle3 = textStyle;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        textFieldDecorator2 = textFieldDecorator;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$4
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
                                                BasicSecureTextFieldKt.m1388BasicSecureTextFieldmMrxcSU(TextFieldState.this, modifier4, imeActionHandler5, i32, i30, i31, z4, inputTransformation3, textStyle3, mutableInteractionSource3, brush3, function24, textFieldDecorator2, scrollState3, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if ((i5 & 7168) == 0) {
                            }
                            int i362 = i27;
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
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i25 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if ((i6 & 8192) != 0) {
                            }
                            brush2 = solidColor;
                            function23 = function25;
                            i28 = i10;
                            i29 = m6117getPasswordPjHm6EE;
                            inputTransformation2 = inputTransformation4;
                            textStyle2 = textStyle4;
                            mutableInteractionSource2 = mutableInteractionSource4;
                            z3 = z2;
                            r31 = function26;
                            modifier2 = modifier3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                            changed = startRestartGroup.changed(coroutineScope2);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue2 = new SecureTextFieldController(coroutineScope2);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            startRestartGroup.endReplaceableGroup();
                            final SecureTextFieldController secureTextFieldController2 = (SecureTextFieldController) rememberedValue2;
                            m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
                            if (!m1412equalsimpl0) {
                            }
                            if (m1412equalsimpl0) {
                            }
                            codepointTransformation = mask;
                            Modifier semantics22 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            return false;
                                        }
                                    }, 1, null);
                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            return false;
                                        }
                                    }, 1, null);
                                }
                            });
                            if (!m1412equalsimpl0) {
                            }
                            final Modifier then22 = semantics22.then(companion);
                            DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                                /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                                
                                    r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                                 */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke(Composer composer3, int i37) {
                                    InputTransformation inputTransformation5;
                                    KeyboardActions keyboardActions;
                                    ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                                    if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                                        }
                                        if (m1412equalsimpl0) {
                                            inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController2.getPasswordRevealFilter());
                                        } else {
                                            inputTransformation5 = inputTransformation2;
                                        }
                                        InputTransformation inputTransformation6 = inputTransformation5;
                                        TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                                        ImeActionHandler imeActionHandler6 = imeActionHandler4;
                                        if (imeActionHandler6 == null || keyboardActions == null) {
                                            keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                        }
                                        BasicTextField2Kt.BasicTextField2(textFieldState, then22, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, 6);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            i30 = m1417getRevealLastTypedpyid5Pk;
                            modifier4 = modifier2;
                            inputTransformation3 = inputTransformation2;
                            i31 = i29;
                            i32 = i28;
                            imeActionHandler5 = imeActionHandler4;
                            z4 = z3;
                            textStyle3 = textStyle2;
                            function24 = function23;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            brush3 = brush2;
                            textFieldDecorator2 = r31;
                            scrollState3 = scrollState2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i20 = i19;
                        i21 = i6 & 1024;
                        if (i21 == 0) {
                        }
                        i24 = i6 & 2048;
                        if (i24 == 0) {
                        }
                        int i352 = i23;
                        i26 = i6 & 4096;
                        if (i26 == 0) {
                        }
                        if ((i5 & 7168) == 0) {
                        }
                        int i3622 = i27;
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
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i25 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if ((i6 & 8192) != 0) {
                        }
                        brush2 = solidColor;
                        function23 = function25;
                        i28 = i10;
                        i29 = m6117getPasswordPjHm6EE;
                        inputTransformation2 = inputTransformation4;
                        textStyle2 = textStyle4;
                        mutableInteractionSource2 = mutableInteractionSource4;
                        z3 = z2;
                        r31 = function26;
                        modifier2 = modifier3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                        changed = startRestartGroup.changed(coroutineScope22);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = new SecureTextFieldController(coroutineScope22);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        final SecureTextFieldController secureTextFieldController22 = (SecureTextFieldController) rememberedValue2;
                        m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
                        if (!m1412equalsimpl0) {
                        }
                        if (m1412equalsimpl0) {
                        }
                        codepointTransformation = mask;
                        Modifier semantics222 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        return false;
                                    }
                                }, 1, null);
                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        return false;
                                    }
                                }, 1, null);
                            }
                        });
                        if (!m1412equalsimpl0) {
                        }
                        final Modifier then222 = semantics222.then(companion);
                        DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                            /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                            
                                r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke(Composer composer3, int i37) {
                                InputTransformation inputTransformation5;
                                KeyboardActions keyboardActions;
                                ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                                if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                                    }
                                    if (m1412equalsimpl0) {
                                        inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController22.getPasswordRevealFilter());
                                    } else {
                                        inputTransformation5 = inputTransformation2;
                                    }
                                    InputTransformation inputTransformation6 = inputTransformation5;
                                    TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                                    ImeActionHandler imeActionHandler6 = imeActionHandler4;
                                    if (imeActionHandler6 == null || keyboardActions == null) {
                                        keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                    }
                                    BasicTextField2Kt.BasicTextField2(textFieldState, then222, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        i30 = m1417getRevealLastTypedpyid5Pk;
                        modifier4 = modifier2;
                        inputTransformation3 = inputTransformation2;
                        i31 = i29;
                        i32 = i28;
                        imeActionHandler5 = imeActionHandler4;
                        z4 = z3;
                        textStyle3 = textStyle2;
                        function24 = function23;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        brush3 = brush2;
                        textFieldDecorator2 = r31;
                        scrollState3 = scrollState2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i18 = i17;
                    i19 = i6 & 512;
                    if (i19 != 0) {
                    }
                    i20 = i19;
                    i21 = i6 & 1024;
                    if (i21 == 0) {
                    }
                    i24 = i6 & 2048;
                    if (i24 == 0) {
                    }
                    int i3522 = i23;
                    i26 = i6 & 4096;
                    if (i26 == 0) {
                    }
                    if ((i5 & 7168) == 0) {
                    }
                    int i36222 = i27;
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
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i25 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if ((i6 & 8192) != 0) {
                    }
                    brush2 = solidColor;
                    function23 = function25;
                    i28 = i10;
                    i29 = m6117getPasswordPjHm6EE;
                    inputTransformation2 = inputTransformation4;
                    textStyle2 = textStyle4;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    z3 = z2;
                    r31 = function26;
                    modifier2 = modifier3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed = startRestartGroup.changed(coroutineScope222);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new SecureTextFieldController(coroutineScope222);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    final SecureTextFieldController secureTextFieldController222 = (SecureTextFieldController) rememberedValue2;
                    m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
                    if (!m1412equalsimpl0) {
                    }
                    if (m1412equalsimpl0) {
                    }
                    codepointTransformation = mask;
                    Modifier semantics2222 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return false;
                                }
                            }, 1, null);
                            SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return false;
                                }
                            }, 1, null);
                        }
                    });
                    if (!m1412equalsimpl0) {
                    }
                    final Modifier then2222 = semantics2222.then(companion);
                    DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                        
                            r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(Composer composer3, int i37) {
                            InputTransformation inputTransformation5;
                            KeyboardActions keyboardActions;
                            ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                            if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                                }
                                if (m1412equalsimpl0) {
                                    inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController222.getPasswordRevealFilter());
                                } else {
                                    inputTransformation5 = inputTransformation2;
                                }
                                InputTransformation inputTransformation6 = inputTransformation5;
                                TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                                ImeActionHandler imeActionHandler6 = imeActionHandler4;
                                if (imeActionHandler6 == null || keyboardActions == null) {
                                    keyboardActions = KeyboardActions.INSTANCE.getDefault();
                                }
                                BasicTextField2Kt.BasicTextField2(textFieldState, then2222, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    i30 = m1417getRevealLastTypedpyid5Pk;
                    modifier4 = modifier2;
                    inputTransformation3 = inputTransformation2;
                    i31 = i29;
                    i32 = i28;
                    imeActionHandler5 = imeActionHandler4;
                    z4 = z3;
                    textStyle3 = textStyle2;
                    function24 = function23;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    brush3 = brush2;
                    textFieldDecorator2 = r31;
                    scrollState3 = scrollState2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i;
                i11 = i6 & 16;
                if (i11 == 0) {
                }
                i13 = i6 & 32;
                if (i13 == 0) {
                }
                i15 = i6 & 64;
                if (i15 == 0) {
                }
                i16 = i6 & 128;
                if (i16 == 0) {
                }
                i17 = i6 & 256;
                if (i17 == 0) {
                }
                i18 = i17;
                i19 = i6 & 512;
                if (i19 != 0) {
                }
                i20 = i19;
                i21 = i6 & 1024;
                if (i21 == 0) {
                }
                i24 = i6 & 2048;
                if (i24 == 0) {
                }
                int i35222 = i23;
                i26 = i6 & 4096;
                if (i26 == 0) {
                }
                if ((i5 & 7168) == 0) {
                }
                int i362222 = i27;
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
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i18 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i25 != 0) {
                }
                if (i26 != 0) {
                }
                if ((i6 & 8192) != 0) {
                }
                brush2 = solidColor;
                function23 = function25;
                i28 = i10;
                i29 = m6117getPasswordPjHm6EE;
                inputTransformation2 = inputTransformation4;
                textStyle2 = textStyle4;
                mutableInteractionSource2 = mutableInteractionSource4;
                z3 = z2;
                r31 = function26;
                modifier2 = modifier3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(coroutineScope2222);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new SecureTextFieldController(coroutineScope2222);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final SecureTextFieldController secureTextFieldController2222 = (SecureTextFieldController) rememberedValue2;
                m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
                if (!m1412equalsimpl0) {
                }
                if (m1412equalsimpl0) {
                }
                codepointTransformation = mask;
                Modifier semantics22222 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return false;
                            }
                        }, 1, null);
                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return false;
                            }
                        }, 1, null);
                    }
                });
                if (!m1412equalsimpl0) {
                }
                final Modifier then22222 = semantics22222.then(companion);
                DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                    
                        r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(Composer composer3, int i37) {
                        InputTransformation inputTransformation5;
                        KeyboardActions keyboardActions;
                        ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                        if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                            }
                            if (m1412equalsimpl0) {
                                inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController2222.getPasswordRevealFilter());
                            } else {
                                inputTransformation5 = inputTransformation2;
                            }
                            InputTransformation inputTransformation6 = inputTransformation5;
                            TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                            ImeActionHandler imeActionHandler6 = imeActionHandler4;
                            if (imeActionHandler6 == null || keyboardActions == null) {
                                keyboardActions = KeyboardActions.INSTANCE.getDefault();
                            }
                            BasicTextField2Kt.BasicTextField2(textFieldState, then22222, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                i30 = m1417getRevealLastTypedpyid5Pk;
                modifier4 = modifier2;
                inputTransformation3 = inputTransformation2;
                i31 = i29;
                i32 = i28;
                imeActionHandler5 = imeActionHandler4;
                z4 = z3;
                textStyle3 = textStyle2;
                function24 = function23;
                mutableInteractionSource3 = mutableInteractionSource2;
                brush3 = brush2;
                textFieldDecorator2 = r31;
                scrollState3 = scrollState2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            imeActionHandler2 = imeActionHandler;
            i9 = i6 & 8;
            int i342 = 2048;
            if (i9 != 0) {
            }
            i10 = i;
            i11 = i6 & 16;
            if (i11 == 0) {
            }
            i13 = i6 & 32;
            if (i13 == 0) {
            }
            i15 = i6 & 64;
            if (i15 == 0) {
            }
            i16 = i6 & 128;
            if (i16 == 0) {
            }
            i17 = i6 & 256;
            if (i17 == 0) {
            }
            i18 = i17;
            i19 = i6 & 512;
            if (i19 != 0) {
            }
            i20 = i19;
            i21 = i6 & 1024;
            if (i21 == 0) {
            }
            i24 = i6 & 2048;
            if (i24 == 0) {
            }
            int i352222 = i23;
            i26 = i6 & 4096;
            if (i26 == 0) {
            }
            if ((i5 & 7168) == 0) {
            }
            int i3622222 = i27;
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
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i18 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i25 != 0) {
            }
            if (i26 != 0) {
            }
            if ((i6 & 8192) != 0) {
            }
            brush2 = solidColor;
            function23 = function25;
            i28 = i10;
            i29 = m6117getPasswordPjHm6EE;
            inputTransformation2 = inputTransformation4;
            textStyle2 = textStyle4;
            mutableInteractionSource2 = mutableInteractionSource4;
            z3 = z2;
            r31 = function26;
            modifier2 = modifier3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(coroutineScope22222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new SecureTextFieldController(coroutineScope22222);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final SecureTextFieldController secureTextFieldController22222 = (SecureTextFieldController) rememberedValue2;
            m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
            if (!m1412equalsimpl0) {
            }
            if (m1412equalsimpl0) {
            }
            codepointTransformation = mask;
            Modifier semantics222222 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return false;
                        }
                    }, 1, null);
                }
            });
            if (!m1412equalsimpl0) {
            }
            final Modifier then222222 = semantics222222.then(companion);
            DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
                
                    r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(Composer composer3, int i37) {
                    InputTransformation inputTransformation5;
                    KeyboardActions keyboardActions;
                    ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                    if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                        }
                        if (m1412equalsimpl0) {
                            inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController22222.getPasswordRevealFilter());
                        } else {
                            inputTransformation5 = inputTransformation2;
                        }
                        InputTransformation inputTransformation6 = inputTransformation5;
                        TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                        ImeActionHandler imeActionHandler6 = imeActionHandler4;
                        if (imeActionHandler6 == null || keyboardActions == null) {
                            keyboardActions = KeyboardActions.INSTANCE.getDefault();
                        }
                        BasicTextField2Kt.BasicTextField2(textFieldState, then222222, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            i30 = m1417getRevealLastTypedpyid5Pk;
            modifier4 = modifier2;
            inputTransformation3 = inputTransformation2;
            i31 = i29;
            i32 = i28;
            imeActionHandler5 = imeActionHandler4;
            z4 = z3;
            textStyle3 = textStyle2;
            function24 = function23;
            mutableInteractionSource3 = mutableInteractionSource2;
            brush3 = brush2;
            textFieldDecorator2 = r31;
            scrollState3 = scrollState2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        imeActionHandler2 = imeActionHandler;
        i9 = i6 & 8;
        int i3422 = 2048;
        if (i9 != 0) {
        }
        i10 = i;
        i11 = i6 & 16;
        if (i11 == 0) {
        }
        i13 = i6 & 32;
        if (i13 == 0) {
        }
        i15 = i6 & 64;
        if (i15 == 0) {
        }
        i16 = i6 & 128;
        if (i16 == 0) {
        }
        i17 = i6 & 256;
        if (i17 == 0) {
        }
        i18 = i17;
        i19 = i6 & 512;
        if (i19 != 0) {
        }
        i20 = i19;
        i21 = i6 & 1024;
        if (i21 == 0) {
        }
        i24 = i6 & 2048;
        if (i24 == 0) {
        }
        int i3522222 = i23;
        i26 = i6 & 4096;
        if (i26 == 0) {
        }
        if ((i5 & 7168) == 0) {
        }
        int i36222222 = i27;
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
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i18 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i25 != 0) {
        }
        if (i26 != 0) {
        }
        if ((i6 & 8192) != 0) {
        }
        brush2 = solidColor;
        function23 = function25;
        i28 = i10;
        i29 = m6117getPasswordPjHm6EE;
        inputTransformation2 = inputTransformation4;
        textStyle2 = textStyle4;
        mutableInteractionSource2 = mutableInteractionSource4;
        z3 = z2;
        r31 = function26;
        modifier2 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope222222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(coroutineScope222222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new SecureTextFieldController(coroutineScope222222);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final SecureTextFieldController secureTextFieldController222222 = (SecureTextFieldController) rememberedValue2;
        m1412equalsimpl0 = TextObfuscationMode.m1412equalsimpl0(m1417getRevealLastTypedpyid5Pk, TextObfuscationMode.INSTANCE.m1417getRevealLastTypedpyid5Pk());
        if (!m1412equalsimpl0) {
        }
        if (m1412equalsimpl0) {
        }
        codepointTransformation = mask;
        Modifier semantics2222222 = SemanticsModifierKt.semantics(modifier2, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return false;
                    }
                }, 1, null);
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return false;
                    }
                }, 1, null);
            }
        });
        if (!m1412equalsimpl0) {
        }
        final Modifier then2222222 = semantics2222222.then(companion);
        DisableCutCopy(ComposableLambdaKt.composableLambda(startRestartGroup, -1415093334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3
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

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
            
                r2 = androidx.compose.foundation.text2.BasicSecureTextFieldKt.KeyboardActions(new androidx.compose.foundation.text2.BasicSecureTextFieldKt$BasicSecureTextField$3$1$1(r2));
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(Composer composer3, int i37) {
                InputTransformation inputTransformation5;
                KeyboardActions keyboardActions;
                ComposerKt.sourceInformation(composer3, "C323@17492L1033:BasicSecureTextField.kt#g98mwb");
                if ((i37 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1415093334, i37, -1, "androidx.compose.foundation.text2.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:323)");
                    }
                    if (m1412equalsimpl0) {
                        inputTransformation5 = InputTransformationKt.thenOrNull(inputTransformation2, secureTextFieldController222222.getPasswordRevealFilter());
                    } else {
                        inputTransformation5 = inputTransformation2;
                    }
                    InputTransformation inputTransformation6 = inputTransformation5;
                    TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, i29, i28, null, 17, null);
                    ImeActionHandler imeActionHandler6 = imeActionHandler4;
                    if (imeActionHandler6 == null || keyboardActions == null) {
                        keyboardActions = KeyboardActions.INSTANCE.getDefault();
                    }
                    BasicTextField2Kt.BasicTextField2(textFieldState, then2222222, z3, false, inputTransformation6, textStyle2, keyboardOptions, keyboardActions, singleLine, function23, mutableInteractionSource2, brush2, codepointTransformation, r31, scrollState2, composer3, 100666368, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        i30 = m1417getRevealLastTypedpyid5Pk;
        modifier4 = modifier2;
        inputTransformation3 = inputTransformation2;
        i31 = i29;
        i32 = i28;
        imeActionHandler5 = imeActionHandler4;
        z4 = z3;
        textStyle3 = textStyle2;
        function24 = function23;
        mutableInteractionSource3 = mutableInteractionSource2;
        brush3 = brush2;
        textFieldDecorator2 = r31;
        scrollState3 = scrollState2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyboardActions KeyboardActions(final ImeActionHandler imeActionHandler) {
        return new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6065getDoneeUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6065getDoneeUduSuo());
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6066getGoeUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6066getGoeUduSuo());
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6067getNexteUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6067getNexteUduSuo());
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6069getPreviouseUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6069getPreviouseUduSuo());
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6070getSearcheUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6070getSearcheUduSuo());
            }
        }, new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$KeyboardActions$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                if (ImeActionHandler.this.mo1389onImeActionKlQnJC8(ImeAction.INSTANCE.m6071getSendeUduSuo())) {
                    return;
                }
                keyboardActionScope.mo1178defaultKeyboardActionKlQnJC8(ImeAction.INSTANCE.m6071getSendeUduSuo());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(930154034);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)491@23154L7,492@23192L680,511@23877L434:BasicSecureTextField.kt#g98mwb");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930154034, i2, -1, "androidx.compose.foundation.text2.DisableCutCopy (BasicSecureTextField.kt:490)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) consume;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    {
                        this.$$delegate_0 = TextToolbar.this;
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        TextToolbar.this.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), ComposableLambdaKt.composableLambda(startRestartGroup, -1741121166, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$DisableCutCopy$1
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
                    ComposerKt.sourceInformation(composer2, "C512@23959L346:BasicSecureTextField.kt#g98mwb");
                    if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1741121166, i3, -1, "androidx.compose.foundation.text2.DisableCutCopy.<anonymous> (BasicSecureTextField.kt:512)");
                        }
                        Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$DisableCutCopy$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m1390invokeZmokQxo(keyEvent.m5060unboximpl());
                            }

                            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m1390invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                KeyCommand mo1177mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1177mapZmokQxo(keyEvent);
                                return Boolean.valueOf(mo1177mapZmokQxo == KeyCommand.COPY || mo1177mapZmokQxo == KeyCommand.CUT);
                            }
                        });
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onPreviewKeyEvent);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 1102005134, "C518@24286L9:BasicSecureTextField.kt#g98mwb");
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
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicSecureTextFieldKt$DisableCutCopy$2
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
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
