package androidx.compose.foundation.text2;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.AndroidCursorHandle_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HeightInLinesModifierKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextFieldSizeKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.SingleLineCodepointTransformation;
import androidx.compose.foundation.text2.input.TextFieldLineLimits;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.StateSyncingModifierKt;
import androidx.compose.foundation.text2.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text2.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text2.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicTextField2.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aÙ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001628\b\u0002\u0010\u0017\u001a2\u0012\u0004\u0012\u00020\u0019\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0002\b\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)\u001aí\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00050-2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001628\b\u0002\u0010\u0017\u001a2\u0012\u0004\u0012\u00020\u0019\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018¢\u0006\u0002\b\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010.\u001a\u0015\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\u00102\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u00064²\u0006\n\u00105\u001a\u000206X\u008a\u008e\u0002"}, d2 = {"DefaultTextFieldDecorator", "Landroidx/compose/foundation/text2/TextFieldDecorator;", "getDefaultTextFieldDecorator$annotations", "()V", "BasicTextField2", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "lineLimits", "Landroidx/compose/foundation/text2/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "decorator", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/foundation/text2/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text2/input/CodepointTransformation;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/foundation/text2/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text2/input/CodepointTransformation;Landroidx/compose/foundation/text2/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "TextFieldCursorHandle", "selectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "(Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "foundation_release", "valueWithSelection", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextField2Kt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextField2Kt$DefaultTextFieldDecorator$1.INSTANCE;

    private static /* synthetic */ void getDefaultTextFieldDecorator$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0332  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField2(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
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
        TextFieldLineLimits textFieldLineLimits2;
        int i24;
        SolidColor solidColor;
        CodepointTransformation codepointTransformation2;
        KeyboardOptions keyboardOptions3;
        boolean z5;
        TextStyle textStyle3;
        KeyboardActions keyboardActions2;
        InputTransformation inputTransformation3;
        ScrollState scrollState2;
        Modifier modifier3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        int i25;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush2;
        TextFieldDecorator textFieldDecorator2;
        CodepointTransformation codepointTransformation3;
        Object rememberedValue;
        int i26;
        boolean z6;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        Composer composer2;
        final Modifier modifier4;
        final boolean z7;
        final boolean z8;
        final InputTransformation inputTransformation4;
        final TextStyle textStyle4;
        final KeyboardOptions keyboardOptions4;
        final KeyboardActions keyboardActions3;
        final TextFieldLineLimits textFieldLineLimits3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final MutableInteractionSource mutableInteractionSource3;
        final Brush brush3;
        final CodepointTransformation codepointTransformation4;
        final TextFieldDecorator textFieldDecorator3;
        final ScrollState scrollState3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-797091052);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField2)P(15,11,9,3,12,4,14,7,6,8,10,5,1)186@11484L21,190@11642L213,200@12048L174,210@12291L1011:BasicTextField2.kt#g98mwb");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i27 = i3 & 4;
        if (i27 != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                z3 = z;
                i4 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                    z4 = z2;
                } else {
                    z4 = z2;
                    if ((i & 57344) == 0) {
                        i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                    }
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    inputTransformation2 = inputTransformation;
                } else {
                    inputTransformation2 = inputTransformation;
                    if ((i & 458752) == 0) {
                        i4 |= startRestartGroup.changed(inputTransformation2) ? 131072 : 65536;
                    }
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                    textStyle2 = textStyle;
                } else {
                    textStyle2 = textStyle;
                    if ((i & 3670016) == 0) {
                        i4 |= startRestartGroup.changed(textStyle2) ? 1048576 : 524288;
                    }
                }
                i9 = i3 & 128;
                if (i9 != 0) {
                    i4 |= 12582912;
                    keyboardOptions2 = keyboardOptions;
                } else {
                    keyboardOptions2 = keyboardOptions;
                    if ((i & 29360128) == 0) {
                        i4 |= startRestartGroup.changed(keyboardOptions2) ? 8388608 : 4194304;
                    }
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    i4 |= startRestartGroup.changed(keyboardActions) ? 67108864 : 33554432;
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & 1879048192) == 0) {
                    i12 = i11;
                    i4 |= startRestartGroup.changed(textFieldLineLimits) ? 536870912 : 268435456;
                    i13 = i3 & 1024;
                    if (i13 == 0) {
                        i15 = i2 | 6;
                        i14 = i13;
                    } else if ((i2 & 14) == 0) {
                        i14 = i13;
                        i15 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                    } else {
                        i14 = i13;
                        i15 = i2;
                    }
                    i16 = i3 & 2048;
                    if (i16 == 0) {
                        i15 |= 48;
                        i17 = i16;
                    } else if ((i2 & 112) == 0) {
                        i17 = i16;
                        i15 |= startRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                    } else {
                        i17 = i16;
                    }
                    int i28 = i15;
                    i18 = i3 & 4096;
                    if (i18 == 0) {
                        i19 = i28 | 384;
                    } else {
                        int i29 = i28;
                        if ((i2 & 896) == 0) {
                            i29 |= startRestartGroup.changed(brush) ? 256 : 128;
                        }
                        i19 = i29;
                    }
                    i20 = i3 & 8192;
                    if (i20 == 0) {
                        i21 = i19 | 3072;
                    } else {
                        int i30 = i19;
                        if ((i2 & 7168) == 0) {
                            i21 = i30 | (startRestartGroup.changed(codepointTransformation) ? 2048 : 1024);
                        } else {
                            i21 = i30;
                        }
                    }
                    i22 = i3 & 16384;
                    if (i22 == 0) {
                        i21 |= 24576;
                    } else if ((i2 & 57344) == 0) {
                        i23 = i21 | (startRestartGroup.changed(textFieldDecorator) ? 16384 : 8192);
                        if ((i2 & 458752) == 0) {
                            i23 |= ((i3 & 32768) == 0 && startRestartGroup.changed(scrollState)) ? 131072 : 65536;
                        }
                        if ((i4 & 1533916891) == 306783378 || (i23 & 374491) != 74898 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i27 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if (i6 != 0) {
                                    z4 = false;
                                }
                                if (i7 != 0) {
                                    inputTransformation2 = null;
                                }
                                if (i8 != 0) {
                                    textStyle2 = TextStyle.INSTANCE.getDefault();
                                }
                                if (i9 != 0) {
                                    keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                }
                                KeyboardActions keyboardActions4 = i10 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                textFieldLineLimits2 = i12 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i14 != 0 ? null : function2;
                                MutableInteractionSource mutableInteractionSource4 = i17 != 0 ? null : mutableInteractionSource;
                                if (i18 != 0) {
                                    i24 = i20;
                                    solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                                } else {
                                    i24 = i20;
                                    solidColor = brush;
                                }
                                codepointTransformation2 = i24 != 0 ? null : codepointTransformation;
                                TextFieldDecorator textFieldDecorator4 = i22 != 0 ? null : textFieldDecorator;
                                Brush brush4 = solidColor;
                                if ((i3 & 32768) != 0) {
                                    i23 &= -458753;
                                    InputTransformation inputTransformation5 = inputTransformation2;
                                    keyboardOptions3 = keyboardOptions2;
                                    z5 = z4;
                                    textStyle3 = textStyle2;
                                    keyboardActions2 = keyboardActions4;
                                    inputTransformation3 = inputTransformation5;
                                    scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                } else {
                                    InputTransformation inputTransformation6 = inputTransformation2;
                                    keyboardOptions3 = keyboardOptions2;
                                    z5 = z4;
                                    textStyle3 = textStyle2;
                                    keyboardActions2 = keyboardActions4;
                                    inputTransformation3 = inputTransformation6;
                                    scrollState2 = scrollState;
                                }
                                modifier3 = modifier2;
                                function22 = function24;
                                i25 = i23;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                brush2 = brush4;
                                textFieldDecorator2 = textFieldDecorator4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 32768) != 0) {
                                    i23 &= -458753;
                                }
                                textFieldLineLimits2 = textFieldLineLimits;
                                mutableInteractionSource2 = mutableInteractionSource;
                                codepointTransformation2 = codepointTransformation;
                                textFieldDecorator2 = textFieldDecorator;
                                scrollState2 = scrollState;
                                inputTransformation3 = inputTransformation2;
                                modifier3 = modifier2;
                                i25 = i23;
                                function22 = function2;
                                brush2 = brush;
                                keyboardOptions3 = keyboardOptions2;
                                z5 = z4;
                                textStyle3 = textStyle2;
                                keyboardActions2 = keyboardActions;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                codepointTransformation3 = codepointTransformation2;
                                ComposerKt.traceEventStart(-797091052, i4, i25, "androidx.compose.foundation.text2.BasicTextField2 (BasicTextField2.kt:189)");
                            } else {
                                codepointTransformation3 = codepointTransformation2;
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                i26 = i4;
                                z6 = z3;
                                rememberedValue = new TextFieldState(str, TextRangeKt.TextRange(str.length()), (DefaultConstructorMarker) null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                i26 = i4;
                                z6 = z3;
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
                            mutableState.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField2$lambda$2(mutableState), str, 0L, (TextRange) null, 6, (Object) null));
                            TextFieldValue BasicTextField2$lambda$2 = BasicTextField2$lambda$2(mutableState);
                            startRestartGroup.startReplaceableGroup(1290401378);
                            changed = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(function1);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
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
                                        TextFieldValue BasicTextField2$lambda$22;
                                        String text = textFieldValue.getText();
                                        BasicTextField2$lambda$22 = BasicTextField2Kt.BasicTextField2$lambda$2(mutableState);
                                        if (!Intrinsics.areEqual(text, BasicTextField2$lambda$22.getText())) {
                                            function1.invoke(textFieldValue.getText());
                                        }
                                        mutableState.setValue(textFieldValue);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier syncTextFieldState = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState, BasicTextField2$lambda$2, (Function1) rememberedValue3, false);
                            int i31 = i26 >> 3;
                            CodepointTransformation codepointTransformation5 = codepointTransformation3;
                            boolean z9 = z6;
                            composer2 = startRestartGroup;
                            BasicTextField2(textFieldState, syncTextFieldState, z9, z5, inputTransformation3, textStyle3, keyboardOptions3, keyboardActions2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation5, textFieldDecorator2, scrollState2, composer2, (i31 & 234881024) | (i31 & 896) | 6 | (i31 & 7168) | (i31 & 57344) | (i31 & 458752) | (3670016 & i31) | (29360128 & i31) | ((i25 << 27) & 1879048192), (i25 >> 3) & 65534, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            z7 = z9;
                            z8 = z5;
                            inputTransformation4 = inputTransformation3;
                            textStyle4 = textStyle3;
                            keyboardOptions4 = keyboardOptions3;
                            keyboardActions3 = keyboardActions2;
                            textFieldLineLimits3 = textFieldLineLimits2;
                            function23 = function22;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            brush3 = brush2;
                            codepointTransformation4 = codepointTransformation5;
                            textFieldDecorator3 = textFieldDecorator2;
                            scrollState3 = scrollState2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            textFieldLineLimits3 = textFieldLineLimits;
                            codepointTransformation4 = codepointTransformation;
                            scrollState3 = scrollState;
                            composer2 = startRestartGroup;
                            z7 = z3;
                            keyboardOptions4 = keyboardOptions2;
                            z8 = z4;
                            inputTransformation4 = inputTransformation2;
                            textStyle4 = textStyle2;
                            modifier4 = modifier2;
                            keyboardActions3 = keyboardActions;
                            function23 = function2;
                            mutableInteractionSource3 = mutableInteractionSource;
                            brush3 = brush;
                            textFieldDecorator3 = textFieldDecorator;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$2
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

                                public final void invoke(Composer composer3, int i32) {
                                    BasicTextField2Kt.BasicTextField2(str, function1, modifier4, z7, z8, inputTransformation4, textStyle4, keyboardOptions4, keyboardActions3, textFieldLineLimits3, function23, mutableInteractionSource3, brush3, codepointTransformation4, textFieldDecorator3, scrollState3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i23 = i21;
                    if ((i2 & 458752) == 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i5 != 0) {
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
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    Brush brush42 = solidColor;
                    if ((i3 & 32768) != 0) {
                    }
                    modifier3 = modifier2;
                    function22 = function24;
                    i25 = i23;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    brush2 = brush42;
                    textFieldDecorator2 = textFieldDecorator4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
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
                    mutableState2.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField2$lambda$2(mutableState2), str, 0L, (TextRange) null, 6, (Object) null));
                    TextFieldValue BasicTextField2$lambda$22 = BasicTextField2$lambda$2(mutableState2);
                    startRestartGroup.startReplaceableGroup(1290401378);
                    changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changedInstance(function1);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
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
                            TextFieldValue BasicTextField2$lambda$222;
                            String text = textFieldValue.getText();
                            BasicTextField2$lambda$222 = BasicTextField2Kt.BasicTextField2$lambda$2(mutableState2);
                            if (!Intrinsics.areEqual(text, BasicTextField2$lambda$222.getText())) {
                                function1.invoke(textFieldValue.getText());
                            }
                            mutableState2.setValue(textFieldValue);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    Modifier syncTextFieldState2 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState2, BasicTextField2$lambda$22, (Function1) rememberedValue3, false);
                    int i312 = i26 >> 3;
                    CodepointTransformation codepointTransformation52 = codepointTransformation3;
                    boolean z92 = z6;
                    composer2 = startRestartGroup;
                    BasicTextField2(textFieldState2, syncTextFieldState2, z92, z5, inputTransformation3, textStyle3, keyboardOptions3, keyboardActions2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation52, textFieldDecorator2, scrollState2, composer2, (i312 & 234881024) | (i312 & 896) | 6 | (i312 & 7168) | (i312 & 57344) | (i312 & 458752) | (3670016 & i312) | (29360128 & i312) | ((i25 << 27) & 1879048192), (i25 >> 3) & 65534, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z7 = z92;
                    z8 = z5;
                    inputTransformation4 = inputTransformation3;
                    textStyle4 = textStyle3;
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions3 = keyboardActions2;
                    textFieldLineLimits3 = textFieldLineLimits2;
                    function23 = function22;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    brush3 = brush2;
                    codepointTransformation4 = codepointTransformation52;
                    textFieldDecorator3 = textFieldDecorator2;
                    scrollState3 = scrollState2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i12 = i11;
                i13 = i3 & 1024;
                if (i13 == 0) {
                }
                i16 = i3 & 2048;
                if (i16 == 0) {
                }
                int i282 = i15;
                i18 = i3 & 4096;
                if (i18 == 0) {
                }
                i20 = i3 & 8192;
                if (i20 == 0) {
                }
                i22 = i3 & 16384;
                if (i22 == 0) {
                }
                i23 = i21;
                if ((i2 & 458752) == 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i27 != 0) {
                }
                if (i5 != 0) {
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
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i24 != 0) {
                }
                if (i22 != 0) {
                }
                Brush brush422 = solidColor;
                if ((i3 & 32768) != 0) {
                }
                modifier3 = modifier2;
                function22 = function24;
                i25 = i23;
                mutableInteractionSource2 = mutableInteractionSource4;
                brush2 = brush422;
                textFieldDecorator2 = textFieldDecorator4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
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
                mutableState22.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField2$lambda$2(mutableState22), str, 0L, (TextRange) null, 6, (Object) null));
                TextFieldValue BasicTextField2$lambda$222 = BasicTextField2$lambda$2(mutableState22);
                startRestartGroup.startReplaceableGroup(1290401378);
                changed = startRestartGroup.changed(mutableState22) | startRestartGroup.changedInstance(function1);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
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
                        TextFieldValue BasicTextField2$lambda$2222;
                        String text = textFieldValue.getText();
                        BasicTextField2$lambda$2222 = BasicTextField2Kt.BasicTextField2$lambda$2(mutableState22);
                        if (!Intrinsics.areEqual(text, BasicTextField2$lambda$2222.getText())) {
                            function1.invoke(textFieldValue.getText());
                        }
                        mutableState22.setValue(textFieldValue);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                Modifier syncTextFieldState22 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState22, BasicTextField2$lambda$222, (Function1) rememberedValue3, false);
                int i3122 = i26 >> 3;
                CodepointTransformation codepointTransformation522 = codepointTransformation3;
                boolean z922 = z6;
                composer2 = startRestartGroup;
                BasicTextField2(textFieldState22, syncTextFieldState22, z922, z5, inputTransformation3, textStyle3, keyboardOptions3, keyboardActions2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation522, textFieldDecorator2, scrollState2, composer2, (i3122 & 234881024) | (i3122 & 896) | 6 | (i3122 & 7168) | (i3122 & 57344) | (i3122 & 458752) | (3670016 & i3122) | (29360128 & i3122) | ((i25 << 27) & 1879048192), (i25 >> 3) & 65534, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z7 = z922;
                z8 = z5;
                inputTransformation4 = inputTransformation3;
                textStyle4 = textStyle3;
                keyboardOptions4 = keyboardOptions3;
                keyboardActions3 = keyboardActions2;
                textFieldLineLimits3 = textFieldLineLimits2;
                function23 = function22;
                mutableInteractionSource3 = mutableInteractionSource2;
                brush3 = brush2;
                codepointTransformation4 = codepointTransformation522;
                textFieldDecorator3 = textFieldDecorator2;
                scrollState3 = scrollState2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z3 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 != 0) {
            }
            i8 = i3 & 64;
            if (i8 != 0) {
            }
            i9 = i3 & 128;
            if (i9 != 0) {
            }
            i10 = i3 & 256;
            if (i10 != 0) {
            }
            i11 = i3 & 512;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i3 & 1024;
            if (i13 == 0) {
            }
            i16 = i3 & 2048;
            if (i16 == 0) {
            }
            int i2822 = i15;
            i18 = i3 & 4096;
            if (i18 == 0) {
            }
            i20 = i3 & 8192;
            if (i20 == 0) {
            }
            i22 = i3 & 16384;
            if (i22 == 0) {
            }
            i23 = i21;
            if ((i2 & 458752) == 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i27 != 0) {
            }
            if (i5 != 0) {
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
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i24 != 0) {
            }
            if (i22 != 0) {
            }
            Brush brush4222 = solidColor;
            if ((i3 & 32768) != 0) {
            }
            modifier3 = modifier2;
            function22 = function24;
            i25 = i23;
            mutableInteractionSource2 = mutableInteractionSource4;
            brush2 = brush4222;
            textFieldDecorator2 = textFieldDecorator4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
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
            mutableState222.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField2$lambda$2(mutableState222), str, 0L, (TextRange) null, 6, (Object) null));
            TextFieldValue BasicTextField2$lambda$2222 = BasicTextField2$lambda$2(mutableState222);
            startRestartGroup.startReplaceableGroup(1290401378);
            changed = startRestartGroup.changed(mutableState222) | startRestartGroup.changedInstance(function1);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
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
                    TextFieldValue BasicTextField2$lambda$22222;
                    String text = textFieldValue.getText();
                    BasicTextField2$lambda$22222 = BasicTextField2Kt.BasicTextField2$lambda$2(mutableState222);
                    if (!Intrinsics.areEqual(text, BasicTextField2$lambda$22222.getText())) {
                        function1.invoke(textFieldValue.getText());
                    }
                    mutableState222.setValue(textFieldValue);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            Modifier syncTextFieldState222 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState222, BasicTextField2$lambda$2222, (Function1) rememberedValue3, false);
            int i31222 = i26 >> 3;
            CodepointTransformation codepointTransformation5222 = codepointTransformation3;
            boolean z9222 = z6;
            composer2 = startRestartGroup;
            BasicTextField2(textFieldState222, syncTextFieldState222, z9222, z5, inputTransformation3, textStyle3, keyboardOptions3, keyboardActions2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation5222, textFieldDecorator2, scrollState2, composer2, (i31222 & 234881024) | (i31222 & 896) | 6 | (i31222 & 7168) | (i31222 & 57344) | (i31222 & 458752) | (3670016 & i31222) | (29360128 & i31222) | ((i25 << 27) & 1879048192), (i25 >> 3) & 65534, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z7 = z9222;
            z8 = z5;
            inputTransformation4 = inputTransformation3;
            textStyle4 = textStyle3;
            keyboardOptions4 = keyboardOptions3;
            keyboardActions3 = keyboardActions2;
            textFieldLineLimits3 = textFieldLineLimits2;
            function23 = function22;
            mutableInteractionSource3 = mutableInteractionSource2;
            brush3 = brush2;
            codepointTransformation4 = codepointTransformation5222;
            textFieldDecorator3 = textFieldDecorator2;
            scrollState3 = scrollState2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 != 0) {
        }
        i8 = i3 & 64;
        if (i8 != 0) {
        }
        i9 = i3 & 128;
        if (i9 != 0) {
        }
        i10 = i3 & 256;
        if (i10 != 0) {
        }
        i11 = i3 & 512;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i3 & 1024;
        if (i13 == 0) {
        }
        i16 = i3 & 2048;
        if (i16 == 0) {
        }
        int i28222 = i15;
        i18 = i3 & 4096;
        if (i18 == 0) {
        }
        i20 = i3 & 8192;
        if (i20 == 0) {
        }
        i22 = i3 & 16384;
        if (i22 == 0) {
        }
        i23 = i21;
        if ((i2 & 458752) == 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i27 != 0) {
        }
        if (i5 != 0) {
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
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i24 != 0) {
        }
        if (i22 != 0) {
        }
        Brush brush42222 = solidColor;
        if ((i3 & 32768) != 0) {
        }
        modifier3 = modifier2;
        function22 = function24;
        i25 = i23;
        mutableInteractionSource2 = mutableInteractionSource4;
        brush2 = brush42222;
        textFieldDecorator2 = textFieldDecorator4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        TextFieldState textFieldState2222 = (TextFieldState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<TextFieldValue> mutableState2222 = (MutableState) rememberedValue2;
        mutableState2222.setValue(TextFieldValue.m6122copy3r_uNRQ$default(BasicTextField2$lambda$2(mutableState2222), str, 0L, (TextRange) null, 6, (Object) null));
        TextFieldValue BasicTextField2$lambda$22222 = BasicTextField2$lambda$2(mutableState2222);
        startRestartGroup.startReplaceableGroup(1290401378);
        changed = startRestartGroup.changed(mutableState2222) | startRestartGroup.changedInstance(function1);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$1$1
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
                TextFieldValue BasicTextField2$lambda$222222;
                String text = textFieldValue.getText();
                BasicTextField2$lambda$222222 = BasicTextField2Kt.BasicTextField2$lambda$2(mutableState2222);
                if (!Intrinsics.areEqual(text, BasicTextField2$lambda$222222.getText())) {
                    function1.invoke(textFieldValue.getText());
                }
                mutableState2222.setValue(textFieldValue);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        Modifier syncTextFieldState2222 = StateSyncingModifierKt.syncTextFieldState(modifier3, textFieldState2222, BasicTextField2$lambda$22222, (Function1) rememberedValue3, false);
        int i312222 = i26 >> 3;
        CodepointTransformation codepointTransformation52222 = codepointTransformation3;
        boolean z92222 = z6;
        composer2 = startRestartGroup;
        BasicTextField2(textFieldState2222, syncTextFieldState2222, z92222, z5, inputTransformation3, textStyle3, keyboardOptions3, keyboardActions2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, codepointTransformation52222, textFieldDecorator2, scrollState2, composer2, (i312222 & 234881024) | (i312222 & 896) | 6 | (i312222 & 7168) | (i312222 & 57344) | (i312222 & 458752) | (3670016 & i312222) | (29360128 & i312222) | ((i25 << 27) & 1879048192), (i25 >> 3) & 65534, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z7 = z92222;
        z8 = z5;
        inputTransformation4 = inputTransformation3;
        textStyle4 = textStyle3;
        keyboardOptions4 = keyboardOptions3;
        keyboardActions3 = keyboardActions2;
        textFieldLineLimits3 = textFieldLineLimits2;
        function23 = function22;
        mutableInteractionSource3 = mutableInteractionSource2;
        brush3 = brush2;
        codepointTransformation4 = codepointTransformation52222;
        textFieldDecorator3 = textFieldDecorator2;
        scrollState3 = scrollState2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField2$lambda$2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x044c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x043a  */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46, types: [androidx.compose.foundation.text2.TextFieldDecorator] */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [androidx.compose.foundation.text2.TextFieldDecorator] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r59v0, types: [androidx.compose.foundation.text2.TextFieldDecorator, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField2(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
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
        KeyboardActions keyboardActions2;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        boolean z5;
        boolean z6;
        CodepointTransformation codepointTransformation2;
        SolidColor solidColor;
        CodepointTransformation codepointTransformation3;
        CodepointTransformation codepointTransformation4;
        boolean z7;
        final boolean z8;
        final ScrollState scrollState2;
        final Brush brush2;
        final TextStyle textStyle3;
        TextFieldLineLimits textFieldLineLimits2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        int i24;
        Density density;
        final TextFieldLineLimits textFieldLineLimits3;
        MutableInteractionSource mutableInteractionSource3;
        boolean changed;
        Object rememberedValue;
        SingleLineCodepointTransformation singleLineCodepointTransformation;
        TransformedTextFieldState transformedTextFieldState;
        boolean changed2;
        Object rememberedValue2;
        boolean changed3;
        Object rememberedValue3;
        final TransformedTextFieldState transformedTextFieldState2;
        Density density2;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        Composer composer2;
        final CodepointTransformation codepointTransformation5;
        final InputTransformation inputTransformation3;
        final KeyboardActions keyboardActions3;
        final Modifier modifier4;
        final KeyboardOptions keyboardOptions3;
        final MutableInteractionSource mutableInteractionSource4;
        final TextFieldLineLimits textFieldLineLimits4;
        final TextStyle textStyle4;
        final Brush brush3;
        final boolean z9;
        final ScrollState scrollState3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final ?? r14;
        final boolean z10;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(437246650);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField2)P(13,9,3,11,4,14,7,6,8,10,5,1)331@19539L21,335@19712L7,336@19767L7,337@19812L7,343@20182L25,346@20295L598,357@21091L48,359@21175L319,369@21547L7,370@21611L7,371@21665L7,372@21677L440,385@22123L125,423@23614L2468:BasicTextField2.kt#g98mwb");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i25 = i3 & 2;
        if (i25 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                z3 = z;
                i4 |= startRestartGroup.changed(z3) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 7168) == 0) {
                    z4 = z2;
                    i4 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    i7 = i3 & 16;
                    int i26 = 8192;
                    if (i7 == 0) {
                        i4 |= 24576;
                        inputTransformation2 = inputTransformation;
                    } else {
                        inputTransformation2 = inputTransformation;
                        if ((i & 57344) == 0) {
                            i4 |= startRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                    }
                    i8 = i3 & 32;
                    if (i8 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i & 458752) == 0) {
                            i4 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i9 = i3 & 64;
                    if (i9 == 0) {
                        i4 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i & 3670016) == 0) {
                            i4 |= startRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i10 = i3 & 128;
                    if (i10 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i4 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                    }
                    i11 = i3 & 256;
                    if (i11 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i12 = i11;
                        i4 |= startRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                        i13 = i3 & 512;
                        if (i13 != 0) {
                            i4 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & 1879048192) == 0) {
                            i14 = i13;
                            i4 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            i15 = i3 & 1024;
                            if (i15 == 0) {
                                i17 = i2 | 6;
                                i16 = i15;
                            } else if ((i2 & 14) == 0) {
                                i16 = i15;
                                i17 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i2;
                            }
                            i18 = i3 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                                i19 = i18;
                            } else if ((i2 & 112) == 0) {
                                i19 = i18;
                                i17 |= startRestartGroup.changed(brush) ? 32 : 16;
                            } else {
                                i19 = i18;
                            }
                            int i27 = i17;
                            i20 = i3 & 4096;
                            if (i20 == 0) {
                                i21 = i27 | 384;
                            } else {
                                int i28 = i27;
                                if ((i2 & 896) == 0) {
                                    i28 |= startRestartGroup.changed(codepointTransformation) ? 256 : 128;
                                }
                                i21 = i28;
                            }
                            i22 = i3 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i29 = i21;
                                if ((i2 & 7168) == 0) {
                                    i23 = i29 | (startRestartGroup.changed((Object) textFieldDecorator) ? 2048 : 1024);
                                } else {
                                    i23 = i29;
                                }
                            }
                            if ((i2 & 57344) == 0) {
                                if ((i3 & 16384) == 0 && startRestartGroup.changed(scrollState)) {
                                    i26 = 16384;
                                }
                                i23 |= i26;
                            }
                            if ((i4 & 1533916891) == 306783378 || (i23 & 46811) != 9362 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i25 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i5 != 0) {
                                        z3 = true;
                                    }
                                    if (i6 != 0) {
                                        z4 = false;
                                    }
                                    if (i7 != 0) {
                                        inputTransformation2 = null;
                                    }
                                    TextStyle textStyle5 = i8 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                    if (i9 != 0) {
                                        keyboardOptions2 = KeyboardOptions.INSTANCE.getDefault();
                                    }
                                    keyboardActions2 = i10 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    TextFieldLineLimits textFieldLineLimits5 = i12 == 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                    Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i14 == 0 ? null : function2;
                                    mutableInteractionSource2 = i16 == 0 ? null : mutableInteractionSource;
                                    if (i19 == 0) {
                                        z5 = z3;
                                        z6 = z4;
                                        modifier3 = companion;
                                        codepointTransformation2 = null;
                                        solidColor = new SolidColor(Color.INSTANCE.m4089getBlack0d7_KjU(), null);
                                    } else {
                                        modifier3 = companion;
                                        z5 = z3;
                                        z6 = z4;
                                        codepointTransformation2 = null;
                                        solidColor = brush;
                                    }
                                    codepointTransformation3 = i20 == 0 ? codepointTransformation2 : codepointTransformation;
                                    codepointTransformation4 = i22 == 0 ? codepointTransformation2 : textFieldDecorator;
                                    if ((i3 & 16384) == 0) {
                                        z7 = z5;
                                        z8 = z6;
                                        brush2 = solidColor;
                                        textStyle3 = textStyle5;
                                        textFieldLineLimits2 = textFieldLineLimits5;
                                        function22 = function24;
                                        i24 = i23 & (-57345);
                                        scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                    } else {
                                        z7 = z5;
                                        z8 = z6;
                                        scrollState2 = scrollState;
                                        brush2 = solidColor;
                                        textStyle3 = textStyle5;
                                        textFieldLineLimits2 = textFieldLineLimits5;
                                        function22 = function24;
                                        i24 = i23;
                                    }
                                    modifier2 = modifier3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 16384) != 0) {
                                        i23 &= -57345;
                                    }
                                    textFieldLineLimits2 = textFieldLineLimits;
                                    function22 = function2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    codepointTransformation4 = textFieldDecorator;
                                    scrollState2 = scrollState;
                                    z7 = z3;
                                    z8 = z4;
                                    textStyle3 = textStyle2;
                                    i24 = i23;
                                    keyboardActions2 = keyboardActions;
                                    codepointTransformation3 = codepointTransformation;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(437246650, i4, i24, "androidx.compose.foundation.text2.BasicTextField2 (BasicTextField2.kt:334)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                density = (Density) consume;
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = startRestartGroup.consume(localWindowInfo);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                WindowInfo windowInfo = (WindowInfo) consume3;
                                final boolean areEqual = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                                startRestartGroup.startReplaceableGroup(-957633428);
                                ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
                                if (mutableInteractionSource2 != null) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                                    textFieldLineLimits3 = textFieldLineLimits2;
                                    if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue4;
                                } else {
                                    textFieldLineLimits3 = textFieldLineLimits2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                startRestartGroup.endReplaceableGroup();
                                Orientation orientation = !areEqual ? Orientation.Horizontal : Orientation.Vertical;
                                final boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                                final boolean isWindowFocused = windowInfo.isWindowFocused();
                                startRestartGroup.startReplaceableGroup(1618982084);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                                changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    if (codepointTransformation3 != null) {
                                        SingleLineCodepointTransformation singleLineCodepointTransformation2 = SingleLineCodepointTransformation.INSTANCE;
                                        if (!areEqual) {
                                            singleLineCodepointTransformation2 = null;
                                        }
                                        singleLineCodepointTransformation = singleLineCodepointTransformation2;
                                    } else {
                                        singleLineCodepointTransformation = codepointTransformation3;
                                    }
                                    rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed2 = startRestartGroup.changed(transformedTextFieldState);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new TextLayoutState();
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final TextLayoutState textLayoutState = (TextLayoutState) rememberedValue2;
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed3 = startRestartGroup.changed(transformedTextFieldState);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    boolean z11 = z7;
                                    boolean z12 = z8;
                                    rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState, density, z11, z12, !booleanValue && isWindowFocused);
                                    transformedTextFieldState2 = transformedTextFieldState;
                                    textLayoutState = textLayoutState;
                                    density2 = density;
                                    z7 = z11;
                                    z8 = z12;
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                } else {
                                    density2 = density;
                                    transformedTextFieldState2 = transformedTextFieldState;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final TextFieldSelectionState textFieldSelectionState = (TextFieldSelectionState) rememberedValue3;
                                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume4 = startRestartGroup.consume(localHapticFeedback);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final HapticFeedback hapticFeedback = (HapticFeedback) consume4;
                                ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume5 = startRestartGroup.consume(localClipboardManager);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final ClipboardManager clipboardManager = (ClipboardManager) consume5;
                                ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume6 = startRestartGroup.consume(localTextToolbar);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final TextToolbar textToolbar = (TextToolbar) consume6;
                                final Density density3 = density2;
                                final boolean z13 = z7;
                                final boolean z14 = z8;
                                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                                        TextFieldSelectionState.this.update(hapticFeedback, clipboardManager, textToolbar, density3, z13, z14);
                                    }
                                }, startRestartGroup, 0);
                                EffectsKt.DisposableEffect(textFieldSelectionState, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                        final TextFieldSelectionState textFieldSelectionState2 = TextFieldSelectionState.this;
                                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                                TextFieldSelectionState.this.dispose();
                                            }
                                        };
                                    }
                                }, startRestartGroup, 8);
                                final boolean z15 = z7;
                                final Orientation orientation2 = orientation;
                                Modifier scrollable$default = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState, textFieldSelectionState, inputTransformation2, z15, z8, keyboardOptions2, keyboardActions2, areEqual)), z15, mutableInteractionSource3), scrollState2, orientation2, !z15 && scrollState2.getMaxValue() > 0 && textFieldSelectionState.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), null, mutableInteractionSource3, 16, null);
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(scrollable$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (!startRestartGroup.getInserting()) {
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
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
                                (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

                                    public final void invoke(Composer composer3, int i30) {
                                        int i31;
                                        int i32;
                                        ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                                        if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                                            }
                                            TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                                            if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                                i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                                i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                                            } else {
                                                i31 = 1;
                                                i32 = 1;
                                            }
                                            Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue && isWindowFocused, textLayoutState, transformedTextFieldState2, textFieldSelectionState, brush2, z15 && !z8, scrollState2, orientation2));
                                            TextLayoutState textLayoutState2 = textLayoutState;
                                            TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                                            TextStyle textStyle6 = textStyle3;
                                            boolean z16 = areEqual;
                                            Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                                            boolean z17 = z15;
                                            boolean z18 = booleanValue;
                                            boolean z19 = isWindowFocused;
                                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                            boolean z20 = z8;
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                                            BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState2, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                                            composer3.startReplaceableGroup(-39277302);
                                            ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                                            if (z17 && z18 && z19 && textFieldSelectionState2.isInTouchMode()) {
                                                BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState2, composer3, 8);
                                                if (!z20) {
                                                    BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState2, composer3, 8);
                                                }
                                            }
                                            composer3.endReplaceableGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), startRestartGroup, 6);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                codepointTransformation5 = codepointTransformation3;
                                inputTransformation3 = inputTransformation2;
                                keyboardActions3 = keyboardActions2;
                                modifier4 = modifier2;
                                keyboardOptions3 = keyboardOptions2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                textFieldLineLimits4 = textFieldLineLimits3;
                                textStyle4 = textStyle3;
                                brush3 = brush2;
                                z9 = z15;
                                scrollState3 = scrollState2;
                                function23 = function22;
                                r14 = codepointTransformation4;
                                z10 = z8;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                textFieldLineLimits4 = textFieldLineLimits;
                                codepointTransformation5 = codepointTransformation;
                                scrollState3 = scrollState;
                                composer2 = startRestartGroup;
                                z9 = z3;
                                z10 = z4;
                                inputTransformation3 = inputTransformation2;
                                textStyle4 = textStyle2;
                                modifier4 = modifier2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions;
                                function23 = function2;
                                mutableInteractionSource4 = mutableInteractionSource;
                                brush3 = brush;
                                r14 = textFieldDecorator;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$6
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

                                    public final void invoke(Composer composer3, int i30) {
                                        BasicTextField2Kt.BasicTextField2(TextFieldState.this, modifier4, z9, z10, inputTransformation3, textStyle4, keyboardOptions3, keyboardActions3, textFieldLineLimits4, function23, mutableInteractionSource4, brush3, codepointTransformation5, r14, scrollState3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i14 = i13;
                        i15 = i3 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i3 & 2048;
                        if (i18 == 0) {
                        }
                        int i272 = i17;
                        i20 = i3 & 4096;
                        if (i20 == 0) {
                        }
                        i22 = i3 & 8192;
                        if (i22 == 0) {
                        }
                        if ((i2 & 57344) == 0) {
                        }
                        if ((i4 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i20 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if ((i3 & 16384) == 0) {
                        }
                        modifier2 = modifier3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume7 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        density = (Density) consume7;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        LayoutDirection layoutDirection2 = (LayoutDirection) consume22;
                        ProvidableCompositionLocal<WindowInfo> localWindowInfo2 = CompositionLocalsKt.getLocalWindowInfo();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume32 = startRestartGroup.consume(localWindowInfo2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        WindowInfo windowInfo2 = (WindowInfo) consume32;
                        final boolean areEqual2 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                        startRestartGroup.startReplaceableGroup(-957633428);
                        ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
                        if (mutableInteractionSource2 != null) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        if (!areEqual2) {
                        }
                        final boolean booleanValue2 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                        final boolean isWindowFocused2 = windowInfo2.isWindowFocused();
                        startRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                        changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        if (codepointTransformation3 != null) {
                        }
                        rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
                        startRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                        changed2 = startRestartGroup.changed(transformedTextFieldState);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue2 = new TextLayoutState();
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        final TextLayoutState textLayoutState2 = (TextLayoutState) rememberedValue2;
                        startRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                        changed3 = startRestartGroup.changed(transformedTextFieldState);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (changed3) {
                        }
                        boolean z112 = z7;
                        boolean z122 = z8;
                        rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState2, density, z112, z122, !booleanValue2 && isWindowFocused2);
                        transformedTextFieldState2 = transformedTextFieldState;
                        textLayoutState2 = textLayoutState2;
                        density2 = density;
                        z7 = z112;
                        z8 = z122;
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        final TextFieldSelectionState textFieldSelectionState2 = (TextFieldSelectionState) rememberedValue3;
                        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback2 = CompositionLocalsKt.getLocalHapticFeedback();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume42 = startRestartGroup.consume(localHapticFeedback2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final HapticFeedback hapticFeedback2 = (HapticFeedback) consume42;
                        ProvidableCompositionLocal<ClipboardManager> localClipboardManager2 = CompositionLocalsKt.getLocalClipboardManager();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume52 = startRestartGroup.consume(localClipboardManager2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final ClipboardManager clipboardManager2 = (ClipboardManager) consume52;
                        ProvidableCompositionLocal<TextToolbar> localTextToolbar2 = CompositionLocalsKt.getLocalTextToolbar();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume62 = startRestartGroup.consume(localTextToolbar2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final TextToolbar textToolbar2 = (TextToolbar) consume62;
                        final Density density32 = density2;
                        final boolean z132 = z7;
                        final boolean z142 = z8;
                        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                                TextFieldSelectionState.this.update(hapticFeedback2, clipboardManager2, textToolbar2, density32, z132, z142);
                            }
                        }, startRestartGroup, 0);
                        EffectsKt.DisposableEffect(textFieldSelectionState2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final TextFieldSelectionState textFieldSelectionState22 = TextFieldSelectionState.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextFieldSelectionState.this.dispose();
                                    }
                                };
                            }
                        }, startRestartGroup, 8);
                        final boolean z152 = z7;
                        final Orientation orientation22 = orientation;
                        Modifier scrollable$default2 = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState2, textFieldSelectionState2, inputTransformation2, z152, z8, keyboardOptions2, keyboardActions2, areEqual2)), z152, mutableInteractionSource3), scrollState2, orientation22, !z152 && scrollState2.getMaxValue() > 0 && textFieldSelectionState2.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection2, orientation, false), null, mutableInteractionSource3, 16, null);
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(scrollable$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
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
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
                        (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

                            public final void invoke(Composer composer3, int i30) {
                                int i31;
                                int i32;
                                ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                                if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                                    }
                                    TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                                    if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                        i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                        i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                                    } else {
                                        i31 = 1;
                                        i32 = 1;
                                    }
                                    Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState2.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue2 && isWindowFocused2, textLayoutState2, transformedTextFieldState2, textFieldSelectionState2, brush2, z152 && !z8, scrollState2, orientation22));
                                    TextLayoutState textLayoutState22 = textLayoutState2;
                                    TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                                    TextStyle textStyle6 = textStyle3;
                                    boolean z16 = areEqual2;
                                    Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                                    boolean z17 = z152;
                                    boolean z18 = booleanValue2;
                                    boolean z19 = isWindowFocused2;
                                    TextFieldSelectionState textFieldSelectionState22 = textFieldSelectionState2;
                                    boolean z20 = z8;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap22 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(then);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor22);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                                    }
                                    modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                                    BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState22, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                                    composer3.startReplaceableGroup(-39277302);
                                    ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                                    if (z17 && z18 && z19 && textFieldSelectionState22.isInTouchMode()) {
                                        BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState22, composer3, 8);
                                        if (!z20) {
                                            BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState22, composer3, 8);
                                        }
                                    }
                                    composer3.endReplaceableGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        codepointTransformation5 = codepointTransformation3;
                        inputTransformation3 = inputTransformation2;
                        keyboardActions3 = keyboardActions2;
                        modifier4 = modifier2;
                        keyboardOptions3 = keyboardOptions2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        textFieldLineLimits4 = textFieldLineLimits3;
                        textStyle4 = textStyle3;
                        brush3 = brush2;
                        z9 = z152;
                        scrollState3 = scrollState2;
                        function23 = function22;
                        r14 = codepointTransformation4;
                        z10 = z8;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i3 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i3 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i3 & 2048;
                    if (i18 == 0) {
                    }
                    int i2722 = i17;
                    i20 = i3 & 4096;
                    if (i20 == 0) {
                    }
                    i22 = i3 & 8192;
                    if (i22 == 0) {
                    }
                    if ((i2 & 57344) == 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i20 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if ((i3 & 16384) == 0) {
                    }
                    modifier2 = modifier3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume72 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    density = (Density) consume72;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localLayoutDirection22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection22 = (LayoutDirection) consume222;
                    ProvidableCompositionLocal<WindowInfo> localWindowInfo22 = CompositionLocalsKt.getLocalWindowInfo();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume322 = startRestartGroup.consume(localWindowInfo22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    WindowInfo windowInfo22 = (WindowInfo) consume322;
                    final boolean areEqual22 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-957633428);
                    ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
                    if (mutableInteractionSource2 != null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (!areEqual22) {
                    }
                    final boolean booleanValue22 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                    final boolean isWindowFocused22 = windowInfo22.isWindowFocused();
                    startRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                    changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    if (codepointTransformation3 != null) {
                    }
                    rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed2 = startRestartGroup.changed(transformedTextFieldState);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue2 = new TextLayoutState();
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    final TextLayoutState textLayoutState22 = (TextLayoutState) rememberedValue2;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed3 = startRestartGroup.changed(transformedTextFieldState);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed3) {
                    }
                    boolean z1122 = z7;
                    boolean z1222 = z8;
                    rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState22, density, z1122, z1222, !booleanValue22 && isWindowFocused22);
                    transformedTextFieldState2 = transformedTextFieldState;
                    textLayoutState22 = textLayoutState22;
                    density2 = density;
                    z7 = z1122;
                    z8 = z1222;
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    final TextFieldSelectionState textFieldSelectionState22 = (TextFieldSelectionState) rememberedValue3;
                    ProvidableCompositionLocal<HapticFeedback> localHapticFeedback22 = CompositionLocalsKt.getLocalHapticFeedback();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume422 = startRestartGroup.consume(localHapticFeedback22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final HapticFeedback hapticFeedback22 = (HapticFeedback) consume422;
                    ProvidableCompositionLocal<ClipboardManager> localClipboardManager22 = CompositionLocalsKt.getLocalClipboardManager();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume522 = startRestartGroup.consume(localClipboardManager22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final ClipboardManager clipboardManager22 = (ClipboardManager) consume522;
                    ProvidableCompositionLocal<TextToolbar> localTextToolbar22 = CompositionLocalsKt.getLocalTextToolbar();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume622 = startRestartGroup.consume(localTextToolbar22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final TextToolbar textToolbar22 = (TextToolbar) consume622;
                    final Density density322 = density2;
                    final boolean z1322 = z7;
                    final boolean z1422 = z8;
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                            TextFieldSelectionState.this.update(hapticFeedback22, clipboardManager22, textToolbar22, density322, z1322, z1422);
                        }
                    }, startRestartGroup, 0);
                    EffectsKt.DisposableEffect(textFieldSelectionState22, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final TextFieldSelectionState textFieldSelectionState222 = TextFieldSelectionState.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    TextFieldSelectionState.this.dispose();
                                }
                            };
                        }
                    }, startRestartGroup, 8);
                    final boolean z1522 = z7;
                    final Orientation orientation222 = orientation;
                    Modifier scrollable$default22 = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState22, textFieldSelectionState22, inputTransformation2, z1522, z8, keyboardOptions2, keyboardActions2, areEqual22)), z1522, mutableInteractionSource3), scrollState2, orientation222, !z1522 && scrollState2.getMaxValue() > 0 && textFieldSelectionState22.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection22, orientation, false), null, mutableInteractionSource3, 16, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(scrollable$default22);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
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
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
                    (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

                        public final void invoke(Composer composer3, int i30) {
                            int i31;
                            int i32;
                            ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                            if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                                }
                                TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                                if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                    i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                    i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                                } else {
                                    i31 = 1;
                                    i32 = 1;
                                }
                                Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState22.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue22 && isWindowFocused22, textLayoutState22, transformedTextFieldState2, textFieldSelectionState22, brush2, z1522 && !z8, scrollState2, orientation222));
                                TextLayoutState textLayoutState222 = textLayoutState22;
                                TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                                TextStyle textStyle6 = textStyle3;
                                boolean z16 = areEqual22;
                                Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                                boolean z17 = z1522;
                                boolean z18 = booleanValue22;
                                boolean z19 = isWindowFocused22;
                                TextFieldSelectionState textFieldSelectionState222 = textFieldSelectionState22;
                                boolean z20 = z8;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap222 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(then);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor222);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                                }
                                modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                                BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState222, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                                composer3.startReplaceableGroup(-39277302);
                                ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                                if (z17 && z18 && z19 && textFieldSelectionState222.isInTouchMode()) {
                                    BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState222, composer3, 8);
                                    if (!z20) {
                                        BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState222, composer3, 8);
                                    }
                                }
                                composer3.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    codepointTransformation5 = codepointTransformation3;
                    inputTransformation3 = inputTransformation2;
                    keyboardActions3 = keyboardActions2;
                    modifier4 = modifier2;
                    keyboardOptions3 = keyboardOptions2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    textFieldLineLimits4 = textFieldLineLimits3;
                    textStyle4 = textStyle3;
                    brush3 = brush2;
                    z9 = z1522;
                    scrollState3 = scrollState2;
                    function23 = function22;
                    r14 = codepointTransformation4;
                    z10 = z8;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z4 = z2;
                i7 = i3 & 16;
                int i262 = 8192;
                if (i7 == 0) {
                }
                i8 = i3 & 32;
                if (i8 == 0) {
                }
                i9 = i3 & 64;
                if (i9 == 0) {
                }
                i10 = i3 & 128;
                if (i10 == 0) {
                }
                i11 = i3 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i3 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i3 & 1024;
                if (i15 == 0) {
                }
                i18 = i3 & 2048;
                if (i18 == 0) {
                }
                int i27222 = i17;
                i20 = i3 & 4096;
                if (i20 == 0) {
                }
                i22 = i3 & 8192;
                if (i22 == 0) {
                }
                if ((i2 & 57344) == 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i25 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                if (i22 == 0) {
                }
                if ((i3 & 16384) == 0) {
                }
                modifier2 = modifier3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume722 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume722;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localLayoutDirection222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection222 = (LayoutDirection) consume2222;
                ProvidableCompositionLocal<WindowInfo> localWindowInfo222 = CompositionLocalsKt.getLocalWindowInfo();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3222 = startRestartGroup.consume(localWindowInfo222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                WindowInfo windowInfo222 = (WindowInfo) consume3222;
                final boolean areEqual222 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
                startRestartGroup.startReplaceableGroup(-957633428);
                ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
                if (mutableInteractionSource2 != null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (!areEqual222) {
                }
                final boolean booleanValue222 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
                final boolean isWindowFocused222 = windowInfo222.isWindowFocused();
                startRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                if (codepointTransformation3 != null) {
                }
                rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed2 = startRestartGroup.changed(transformedTextFieldState);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue2 = new TextLayoutState();
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final TextLayoutState textLayoutState222 = (TextLayoutState) rememberedValue2;
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed3 = startRestartGroup.changed(transformedTextFieldState);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3) {
                }
                boolean z11222 = z7;
                boolean z12222 = z8;
                rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState222, density, z11222, z12222, !booleanValue222 && isWindowFocused222);
                transformedTextFieldState2 = transformedTextFieldState;
                textLayoutState222 = textLayoutState222;
                density2 = density;
                z7 = z11222;
                z8 = z12222;
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                final TextFieldSelectionState textFieldSelectionState222 = (TextFieldSelectionState) rememberedValue3;
                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback222 = CompositionLocalsKt.getLocalHapticFeedback();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4222 = startRestartGroup.consume(localHapticFeedback222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final HapticFeedback hapticFeedback222 = (HapticFeedback) consume4222;
                ProvidableCompositionLocal<ClipboardManager> localClipboardManager222 = CompositionLocalsKt.getLocalClipboardManager();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume5222 = startRestartGroup.consume(localClipboardManager222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final ClipboardManager clipboardManager222 = (ClipboardManager) consume5222;
                ProvidableCompositionLocal<TextToolbar> localTextToolbar222 = CompositionLocalsKt.getLocalTextToolbar();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume6222 = startRestartGroup.consume(localTextToolbar222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final TextToolbar textToolbar222 = (TextToolbar) consume6222;
                final Density density3222 = density2;
                final boolean z13222 = z7;
                final boolean z14222 = z8;
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                        TextFieldSelectionState.this.update(hapticFeedback222, clipboardManager222, textToolbar222, density3222, z13222, z14222);
                    }
                }, startRestartGroup, 0);
                EffectsKt.DisposableEffect(textFieldSelectionState222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final TextFieldSelectionState textFieldSelectionState2222 = TextFieldSelectionState.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                TextFieldSelectionState.this.dispose();
                            }
                        };
                    }
                }, startRestartGroup, 8);
                final boolean z15222 = z7;
                final Orientation orientation2222 = orientation;
                Modifier scrollable$default222 = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState222, textFieldSelectionState222, inputTransformation2, z15222, z8, keyboardOptions2, keyboardActions2, areEqual222)), z15222, mutableInteractionSource3), scrollState2, orientation2222, !z15222 && scrollState2.getMaxValue() > 0 && textFieldSelectionState222.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection222, orientation, false), null, mutableInteractionSource3, 16, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(scrollable$default222);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
                (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

                    public final void invoke(Composer composer3, int i30) {
                        int i31;
                        int i32;
                        ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                        if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                            }
                            TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                            if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                                i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                                i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                            } else {
                                i31 = 1;
                                i32 = 1;
                            }
                            Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState222.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue222 && isWindowFocused222, textLayoutState222, transformedTextFieldState2, textFieldSelectionState222, brush2, z15222 && !z8, scrollState2, orientation2222));
                            TextLayoutState textLayoutState2222 = textLayoutState222;
                            TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                            TextStyle textStyle6 = textStyle3;
                            boolean z16 = areEqual222;
                            Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                            boolean z17 = z15222;
                            boolean z18 = booleanValue222;
                            boolean z19 = isWindowFocused222;
                            TextFieldSelectionState textFieldSelectionState2222 = textFieldSelectionState222;
                            boolean z20 = z8;
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2222 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(then);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2222);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                            }
                            modifierMaterializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                            BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState2222, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                            composer3.startReplaceableGroup(-39277302);
                            ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                            if (z17 && z18 && z19 && textFieldSelectionState2222.isInTouchMode()) {
                                BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState2222, composer3, 8);
                                if (!z20) {
                                    BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState2222, composer3, 8);
                                }
                            }
                            composer3.endReplaceableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                codepointTransformation5 = codepointTransformation3;
                inputTransformation3 = inputTransformation2;
                keyboardActions3 = keyboardActions2;
                modifier4 = modifier2;
                keyboardOptions3 = keyboardOptions2;
                mutableInteractionSource4 = mutableInteractionSource2;
                textFieldLineLimits4 = textFieldLineLimits3;
                textStyle4 = textStyle3;
                brush3 = brush2;
                z9 = z15222;
                scrollState3 = scrollState2;
                function23 = function22;
                r14 = codepointTransformation4;
                z10 = z8;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z4 = z2;
            i7 = i3 & 16;
            int i2622 = 8192;
            if (i7 == 0) {
            }
            i8 = i3 & 32;
            if (i8 == 0) {
            }
            i9 = i3 & 64;
            if (i9 == 0) {
            }
            i10 = i3 & 128;
            if (i10 == 0) {
            }
            i11 = i3 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i3 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i3 & 1024;
            if (i15 == 0) {
            }
            i18 = i3 & 2048;
            if (i18 == 0) {
            }
            int i272222 = i17;
            i20 = i3 & 4096;
            if (i20 == 0) {
            }
            i22 = i3 & 8192;
            if (i22 == 0) {
            }
            if ((i2 & 57344) == 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i25 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            if (i22 == 0) {
            }
            if ((i3 & 16384) == 0) {
            }
            modifier2 = modifier3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume7222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            density = (Density) consume7222;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localLayoutDirection2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2222 = (LayoutDirection) consume22222;
            ProvidableCompositionLocal<WindowInfo> localWindowInfo2222 = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32222 = startRestartGroup.consume(localWindowInfo2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            WindowInfo windowInfo2222 = (WindowInfo) consume32222;
            final boolean areEqual2222 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
            startRestartGroup.startReplaceableGroup(-957633428);
            ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
            if (mutableInteractionSource2 != null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (!areEqual2222) {
            }
            final boolean booleanValue2222 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
            final boolean isWindowFocused2222 = windowInfo2222.isWindowFocused();
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            if (codepointTransformation3 != null) {
            }
            rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed2 = startRestartGroup.changed(transformedTextFieldState);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = new TextLayoutState();
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final TextLayoutState textLayoutState2222 = (TextLayoutState) rememberedValue2;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed3 = startRestartGroup.changed(transformedTextFieldState);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3) {
            }
            boolean z112222 = z7;
            boolean z122222 = z8;
            rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState2222, density, z112222, z122222, !booleanValue2222 && isWindowFocused2222);
            transformedTextFieldState2 = transformedTextFieldState;
            textLayoutState2222 = textLayoutState2222;
            density2 = density;
            z7 = z112222;
            z8 = z122222;
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            final TextFieldSelectionState textFieldSelectionState2222 = (TextFieldSelectionState) rememberedValue3;
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback2222 = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume42222 = startRestartGroup.consume(localHapticFeedback2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final HapticFeedback hapticFeedback2222 = (HapticFeedback) consume42222;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager2222 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume52222 = startRestartGroup.consume(localClipboardManager2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final ClipboardManager clipboardManager2222 = (ClipboardManager) consume52222;
            ProvidableCompositionLocal<TextToolbar> localTextToolbar2222 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume62222 = startRestartGroup.consume(localTextToolbar2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar2222 = (TextToolbar) consume62222;
            final Density density32222 = density2;
            final boolean z132222 = z7;
            final boolean z142222 = z8;
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                    TextFieldSelectionState.this.update(hapticFeedback2222, clipboardManager2222, textToolbar2222, density32222, z132222, z142222);
                }
            }, startRestartGroup, 0);
            EffectsKt.DisposableEffect(textFieldSelectionState2222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final TextFieldSelectionState textFieldSelectionState22222 = TextFieldSelectionState.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            TextFieldSelectionState.this.dispose();
                        }
                    };
                }
            }, startRestartGroup, 8);
            final boolean z152222 = z7;
            final Orientation orientation22222 = orientation;
            Modifier scrollable$default2222 = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState2222, textFieldSelectionState2222, inputTransformation2, z152222, z8, keyboardOptions2, keyboardActions2, areEqual2222)), z152222, mutableInteractionSource3), scrollState2, orientation22222, !z152222 && scrollState2.getMaxValue() > 0 && textFieldSelectionState2222.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection2222, orientation, false), null, mutableInteractionSource3, 16, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(scrollable$default2222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
            (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

                public final void invoke(Composer composer3, int i30) {
                    int i31;
                    int i32;
                    ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                    if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                        }
                        TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                        if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                            i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                            i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                        } else {
                            i31 = 1;
                            i32 = 1;
                        }
                        Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState2222.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue2222 && isWindowFocused2222, textLayoutState2222, transformedTextFieldState2, textFieldSelectionState2222, brush2, z152222 && !z8, scrollState2, orientation22222));
                        TextLayoutState textLayoutState22222 = textLayoutState2222;
                        TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                        TextStyle textStyle6 = textStyle3;
                        boolean z16 = areEqual2222;
                        Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                        boolean z17 = z152222;
                        boolean z18 = booleanValue2222;
                        boolean z19 = isWindowFocused2222;
                        TextFieldSelectionState textFieldSelectionState22222 = textFieldSelectionState2222;
                        boolean z20 = z8;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap22222 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(then);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor22222);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy22222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
                        }
                        modifierMaterializerOf22222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                        BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState22222, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                        composer3.startReplaceableGroup(-39277302);
                        ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                        if (z17 && z18 && z19 && textFieldSelectionState22222.isInTouchMode()) {
                            BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState22222, composer3, 8);
                            if (!z20) {
                                BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState22222, composer3, 8);
                            }
                        }
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            codepointTransformation5 = codepointTransformation3;
            inputTransformation3 = inputTransformation2;
            keyboardActions3 = keyboardActions2;
            modifier4 = modifier2;
            keyboardOptions3 = keyboardOptions2;
            mutableInteractionSource4 = mutableInteractionSource2;
            textFieldLineLimits4 = textFieldLineLimits3;
            textStyle4 = textStyle3;
            brush3 = brush2;
            z9 = z152222;
            scrollState3 = scrollState2;
            function23 = function22;
            r14 = codepointTransformation4;
            z10 = z8;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        z4 = z2;
        i7 = i3 & 16;
        int i26222 = 8192;
        if (i7 == 0) {
        }
        i8 = i3 & 32;
        if (i8 == 0) {
        }
        i9 = i3 & 64;
        if (i9 == 0) {
        }
        i10 = i3 & 128;
        if (i10 == 0) {
        }
        i11 = i3 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i3 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i3 & 1024;
        if (i15 == 0) {
        }
        i18 = i3 & 2048;
        if (i18 == 0) {
        }
        int i2722222 = i17;
        i20 = i3 & 4096;
        if (i20 == 0) {
        }
        i22 = i3 & 8192;
        if (i22 == 0) {
        }
        if ((i2 & 57344) == 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i25 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        if (i22 == 0) {
        }
        if ((i3 & 16384) == 0) {
        }
        modifier2 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume72222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume72222;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localLayoutDirection22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection22222 = (LayoutDirection) consume222222;
        ProvidableCompositionLocal<WindowInfo> localWindowInfo22222 = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322222 = startRestartGroup.consume(localWindowInfo22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        WindowInfo windowInfo22222 = (WindowInfo) consume322222;
        final boolean areEqual22222 = Intrinsics.areEqual(textFieldLineLimits2, TextFieldLineLimits.SingleLine.INSTANCE);
        startRestartGroup.startReplaceableGroup(-957633428);
        ComposerKt.sourceInformation(startRestartGroup, "341@20017L39");
        if (mutableInteractionSource2 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (!areEqual22222) {
        }
        final boolean booleanValue22222 = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue();
        final boolean isWindowFocused22222 = windowInfo22222.isWindowFocused();
        startRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(textFieldState) | startRestartGroup.changed(inputTransformation2) | startRestartGroup.changed(codepointTransformation3);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        if (codepointTransformation3 != null) {
        }
        rememberedValue = new TransformedTextFieldState(textFieldState, inputTransformation2, singleLineCodepointTransformation);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        transformedTextFieldState = (TransformedTextFieldState) rememberedValue;
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed2 = startRestartGroup.changed(transformedTextFieldState);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = new TextLayoutState();
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final TextLayoutState textLayoutState22222 = (TextLayoutState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed3 = startRestartGroup.changed(transformedTextFieldState);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed3) {
        }
        boolean z1122222 = z7;
        boolean z1222222 = z8;
        rememberedValue3 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState22222, density, z1122222, z1222222, !booleanValue22222 && isWindowFocused22222);
        transformedTextFieldState2 = transformedTextFieldState;
        textLayoutState22222 = textLayoutState22222;
        density2 = density;
        z7 = z1122222;
        z8 = z1222222;
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        final TextFieldSelectionState textFieldSelectionState22222 = (TextFieldSelectionState) rememberedValue3;
        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback22222 = CompositionLocalsKt.getLocalHapticFeedback();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume422222 = startRestartGroup.consume(localHapticFeedback22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final HapticFeedback hapticFeedback22222 = (HapticFeedback) consume422222;
        ProvidableCompositionLocal<ClipboardManager> localClipboardManager22222 = CompositionLocalsKt.getLocalClipboardManager();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume522222 = startRestartGroup.consume(localClipboardManager22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final ClipboardManager clipboardManager22222 = (ClipboardManager) consume522222;
        ProvidableCompositionLocal<TextToolbar> localTextToolbar22222 = CompositionLocalsKt.getLocalTextToolbar();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume622222 = startRestartGroup.consume(localTextToolbar22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final TextToolbar textToolbar22222 = (TextToolbar) consume622222;
        final Density density322222 = density2;
        final boolean z1322222 = z7;
        final boolean z1422222 = z8;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$3
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
                TextFieldSelectionState.this.update(hapticFeedback22222, clipboardManager22222, textToolbar22222, density322222, z1322222, z1422222);
            }
        }, startRestartGroup, 0);
        EffectsKt.DisposableEffect(textFieldSelectionState22222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                final TextFieldSelectionState textFieldSelectionState222222 = TextFieldSelectionState.this;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$4$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        TextFieldSelectionState.this.dispose();
                    }
                };
            }
        }, startRestartGroup, 8);
        final boolean z1522222 = z7;
        final Orientation orientation222222 = orientation;
        Modifier scrollable$default22222 = ScrollableKt.scrollable$default(FocusableKt.focusable(modifier2.then(new TextFieldDecoratorModifier(transformedTextFieldState2, textLayoutState22222, textFieldSelectionState22222, inputTransformation2, z1522222, z8, keyboardOptions2, keyboardActions2, areEqual22222)), z1522222, mutableInteractionSource3), scrollState2, orientation222222, !z1522222 && scrollState2.getMaxValue() > 0 && textFieldSelectionState22222.getDraggingHandle() == null, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection22222, orientation, false), null, mutableInteractionSource3, 16, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor22222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(scrollable$default22222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy22222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22222);
        modifierMaterializerOf22222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 481805554, "C425@23768L2308:BasicTextField2.kt#g98mwb");
        (codepointTransformation4 != null ? DefaultTextFieldDecorator : codepointTransformation4).Decoration(ComposableLambdaKt.composableLambda(startRestartGroup, 1476233751, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$BasicTextField2$5$1
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

            public final void invoke(Composer composer3, int i30) {
                int i31;
                int i32;
                ComposerKt.sourceInformation(composer3, "C436@24100L1966:BasicTextField2.kt#g98mwb");
                if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1476233751, i30, -1, "androidx.compose.foundation.text2.BasicTextField2.<anonymous>.<anonymous> (BasicTextField2.kt:426)");
                    }
                    TextFieldLineLimits textFieldLineLimits6 = TextFieldLineLimits.this;
                    if (textFieldLineLimits6 instanceof TextFieldLineLimits.MultiLine) {
                        i31 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits6).getMinHeightInLines();
                        i32 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                    } else {
                        i31 = 1;
                        i32 = 1;
                    }
                    Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState22222.m1459getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle3, i31, i32), textStyle3)).then(new TextFieldCoreModifier(booleanValue22222 && isWindowFocused22222, textLayoutState22222, transformedTextFieldState2, textFieldSelectionState22222, brush2, z1522222 && !z8, scrollState2, orientation222222));
                    TextLayoutState textLayoutState222222 = textLayoutState22222;
                    TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                    TextStyle textStyle6 = textStyle3;
                    boolean z16 = areEqual22222;
                    Function2<Density, Function0<TextLayoutResult>, Unit> function25 = function22;
                    boolean z17 = z1522222;
                    boolean z18 = booleanValue22222;
                    boolean z19 = isWindowFocused22222;
                    TextFieldSelectionState textFieldSelectionState222222 = textFieldSelectionState22222;
                    boolean z20 = z8;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap222222 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor222222 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222222 = LayoutKt.modifierMaterializerOf(then);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor222222);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy222222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap222222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222222);
                    }
                    modifierMaterializerOf222222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance222222 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1666145625, "C460@25204L370:BasicTextField2.kt#g98mwb");
                    BoxKt.Box(new TextFieldTextLayoutModifier(textLayoutState222222, transformedTextFieldState3, textStyle6, z16, function25), composer3, 0);
                    composer3.startReplaceableGroup(-39277302);
                    ComposerKt.sourceInformation(composer3, "472@25720L113,476@25895L117");
                    if (z17 && z18 && z19 && textFieldSelectionState222222.isInTouchMode()) {
                        BasicTextField2Kt.TextFieldSelectionHandles(textFieldSelectionState222222, composer3, 8);
                        if (!z20) {
                            BasicTextField2Kt.TextFieldCursorHandle(textFieldSelectionState222222, composer3, 8);
                        }
                    }
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 6);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        codepointTransformation5 = codepointTransformation3;
        inputTransformation3 = inputTransformation2;
        keyboardActions3 = keyboardActions2;
        modifier4 = modifier2;
        keyboardOptions3 = keyboardOptions2;
        mutableInteractionSource4 = mutableInteractionSource2;
        textFieldLineLimits4 = textFieldLineLimits3;
        textStyle4 = textStyle3;
        brush3 = brush2;
        z9 = z1522222;
        scrollState3 = scrollState2;
        function23 = function22;
        r14 = codepointTransformation4;
        z10 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(773754631);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)490@26277L629:BasicTextField2.kt#g98mwb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(773754631, i, -1, "androidx.compose.foundation.text2.TextFieldCursorHandle (BasicTextField2.kt:487)");
        }
        final TextFieldHandleState cursorHandle = textFieldSelectionState.getCursorHandle();
        if (cursorHandle.getVisible()) {
            long m1484getPositionF1C5BW0 = cursorHandle.m1484getPositionF1C5BW0();
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(1290415310);
            boolean changed = startRestartGroup.changed(cursorHandle);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$TextFieldCursorHandle$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, TextFieldHandleState.this.m1484getPositionF1C5BW0(), SelectionHandleAnchor.Middle, true, null));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1152CursorHandleULxng0E(m1484getPositionF1C5BW0, SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), textFieldSelectionState, new BasicTextField2Kt$TextFieldCursorHandle$2(textFieldSelectionState, null)), null, startRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$TextFieldCursorHandle$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BasicTextField2Kt.TextFieldCursorHandle(TextFieldSelectionState.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1194626330);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandles)528@27633L397:BasicTextField2.kt#g98mwb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1194626330, i, -1, "androidx.compose.foundation.text2.TextFieldSelectionHandles (BasicTextField2.kt:512)");
        }
        TextFieldHandleState startSelectionHandle = textFieldSelectionState.getStartSelectionHandle();
        startRestartGroup.startReplaceableGroup(-1453543870);
        ComposerKt.sourceInformation(startRestartGroup, "515@27123L401");
        if (startSelectionHandle.getVisible()) {
            AndroidSelectionHandles_androidKt.SelectionHandle(new OffsetProvider() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$TextFieldSelectionHandles$1
                @Override // androidx.compose.foundation.text.selection.OffsetProvider
                /* renamed from: provide-F1C5BW0 */
                public final long mo1153provideF1C5BW0() {
                    return TextFieldSelectionState.this.getStartSelectionHandle().m1484getPositionF1C5BW0();
                }
            }, true, startSelectionHandle.getDirection(), startSelectionHandle.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, textFieldSelectionState, new BasicTextField2Kt$TextFieldSelectionHandles$2(textFieldSelectionState, null)), startRestartGroup, 48);
        }
        startRestartGroup.endReplaceableGroup();
        TextFieldHandleState endSelectionHandle = textFieldSelectionState.getEndSelectionHandle();
        if (endSelectionHandle.getVisible()) {
            AndroidSelectionHandles_androidKt.SelectionHandle(new OffsetProvider() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$TextFieldSelectionHandles$3
                @Override // androidx.compose.foundation.text.selection.OffsetProvider
                /* renamed from: provide-F1C5BW0 */
                public final long mo1153provideF1C5BW0() {
                    return TextFieldSelectionState.this.getEndSelectionHandle().m1484getPositionF1C5BW0();
                }
            }, false, endSelectionHandle.getDirection(), endSelectionHandle.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, textFieldSelectionState, new BasicTextField2Kt$TextFieldSelectionHandles$4(textFieldSelectionState, null)), startRestartGroup, 48);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text2.BasicTextField2Kt$TextFieldSelectionHandles$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    BasicTextField2Kt.TextFieldSelectionHandles(TextFieldSelectionState.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
