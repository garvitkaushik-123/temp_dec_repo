package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.ironsource.C3207n2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aî\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u000123\b\u0002\u0010\u001e\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010$\u001a0\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0002\b H\u0003¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010,\u001a\u0015\u0010-\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H\u0002\u001a\u0010\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u000204H\u0000\u001a \u00105\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0002\u001a0\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u0002012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0002\u001a \u0010;\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0001H\u0002\u001a2\u0010?\u001a\u00020\u0003*\u00020@2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H\u0080@¢\u0006\u0002\u0010D\u001a\u001c\u0010E\u001a\u00020\t*\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u0010&\u001a\u00020'H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006F²\u0006\n\u0010G\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"USE_WINDOW_FOCUS_ENABLED", "", "CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", C3207n2.v, "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", "state", "Landroidx/compose/foundation/text/TextFieldState;", "isWindowFocusedBehindFlag", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    public static final boolean USE_WINDOW_FOCUS_ENABLED = false;

    public static final boolean isWindowFocusedBehindFlag(WindowInfo windowInfo) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x04a2, code lost:
    
        if (r11 == null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x042f, code lost:
    
        if (r10 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L249;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x079a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0855  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x085e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0478  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        TextStyle textStyle2;
        int i9;
        VisualTransformation visualTransformation2;
        int i10;
        Function1<? super TextLayoutResult, Unit> function13;
        int i11;
        MutableInteractionSource mutableInteractionSource2;
        int i12;
        final SolidColor solidColor;
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
        boolean z4;
        int i26;
        int i27;
        ImeOptions imeOptions2;
        KeyboardActions keyboardActions2;
        boolean z5;
        Modifier modifier3;
        int i28;
        final Function1<? super TextLayoutResult, Unit> function14;
        ImeOptions imeOptions3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z6;
        Brush brush2;
        VisualTransformation visualTransformation3;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        Brush brush3;
        Object rememberedValue;
        TextStyle textStyle3;
        final TextInputService textInputService;
        FontFamily.Resolver resolver;
        boolean changed;
        boolean z7;
        boolean changed2;
        Object rememberedValue2;
        TextRange composition;
        boolean z8;
        int i29;
        AnnotatedString text;
        boolean changed3;
        Object rememberedValue3;
        AnnotatedString annotatedString;
        TextStyle textStyle4;
        boolean z9;
        FontFamily.Resolver resolver2;
        Object rememberedValue4;
        int i30;
        Object rememberedValue5;
        Object rememberedValue6;
        Object rememberedValue7;
        final FocusRequester focusRequester;
        BringIntoViewRequester bringIntoViewRequester;
        final TextInputService textInputService2;
        UndoManager undoManager;
        final boolean z10;
        Modifier.Companion companion;
        final int i31;
        Composer composer2;
        final boolean z11;
        final Function1<? super TextLayoutResult, Unit> function15;
        final Modifier modifier4;
        final MutableInteractionSource mutableInteractionSource4;
        final KeyboardActions keyboardActions3;
        final VisualTransformation visualTransformation4;
        final int i32;
        final boolean z12;
        final ImeOptions imeOptions4;
        final boolean z13;
        final TextStyle textStyle5;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        int i33;
        Composer startRestartGroup = composer.startRestartGroup(-958708118);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextField)P(14,10,8,13,15,9,4!1,12,6,7,3,5,2,11)214@11969L29,218@12167L7,219@12206L7,220@12267L7,221@12335L7,222@12400L7,223@12445L7,224@12514L7,229@12730L135,235@12906L268,247@13479L21,248@13517L397,277@14313L26,280@14399L51,286@14702L7,287@14753L7,288@14810L7,292@14921L24,293@14979L37,588@27132L86,592@27224L515,641@29030L4637:CoreTextField.kt#423gt5");
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
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else if ((i3 & 896) == 0) {
                modifier2 = modifier;
                i6 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    textStyle2 = textStyle;
                    i6 |= startRestartGroup.changed(textStyle2) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                        visualTransformation2 = visualTransformation;
                    } else {
                        visualTransformation2 = visualTransformation;
                        if ((i3 & 57344) == 0) {
                            i6 |= startRestartGroup.changed(visualTransformation2) ? 16384 : 8192;
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function13 = function12;
                    } else {
                        function13 = function12;
                        if ((i3 & 458752) == 0) {
                            i6 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
                        }
                    }
                    i11 = i5 & 64;
                    if (i11 == 0) {
                        i6 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i3 & 3670016) == 0) {
                            i6 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i12 = i5 & 128;
                    if (i12 == 0) {
                        i6 |= 12582912;
                        solidColor = brush;
                    } else {
                        solidColor = brush;
                        if ((i3 & 29360128) == 0) {
                            i6 |= startRestartGroup.changed(solidColor) ? 8388608 : 4194304;
                        }
                    }
                    i13 = i5 & 256;
                    if (i13 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i6 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                    }
                    i14 = i5 & 512;
                    if (i14 == 0) {
                        i6 |= C.ENCODING_PCM_32BIT;
                    } else if ((i3 & 1879048192) == 0) {
                        i15 = i14;
                        i6 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                        i16 = i5 & 1024;
                        if (i16 != 0) {
                            i18 = i4 | 6;
                            i17 = i16;
                        } else if ((i4 & 14) == 0) {
                            i17 = i16;
                            i18 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                        } else {
                            i17 = i16;
                            i18 = i4;
                        }
                        if ((i4 & 112) == 0) {
                            if ((i5 & 2048) == 0 && startRestartGroup.changed(imeOptions)) {
                                i33 = 32;
                                i18 |= i33;
                            }
                            i33 = 16;
                            i18 |= i33;
                        }
                        int i34 = i18;
                        i19 = i5 & 4096;
                        if (i19 != 0) {
                            i20 = i34 | 384;
                        } else {
                            int i35 = i34;
                            if ((i4 & 896) == 0) {
                                i35 |= startRestartGroup.changed(keyboardActions) ? 256 : 128;
                            }
                            i20 = i35;
                        }
                        i21 = i5 & 8192;
                        if (i21 != 0) {
                            i22 = i20 | 3072;
                        } else {
                            int i36 = i20;
                            if ((i4 & 7168) == 0) {
                                i22 = i36 | (startRestartGroup.changed(z2) ? 2048 : 1024);
                            } else {
                                i22 = i36;
                            }
                        }
                        i23 = i5 & 16384;
                        if (i23 != 0) {
                            i22 |= 24576;
                        } else if ((i4 & 57344) == 0) {
                            i24 = i22 | (startRestartGroup.changed(z3) ? 16384 : 8192);
                            i25 = i5 & 32768;
                            if (i25 == 0) {
                                i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i4 & 458752) == 0) {
                                i24 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                            }
                            if ((i6 & 1533916891) == 306783378 || (i24 & 374491) != 74898 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i7 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    TextStyle textStyle6 = i8 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                                    VisualTransformation none = i9 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation2;
                                    CoreTextFieldKt$CoreTextField$1 coreTextFieldKt$CoreTextField$1 = i10 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextLayoutResult textLayoutResult) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                            invoke2(textLayoutResult);
                                            return Unit.INSTANCE;
                                        }
                                    } : function13;
                                    if (i11 != 0) {
                                        mutableInteractionSource2 = null;
                                    }
                                    if (i12 != 0) {
                                        solidColor = new SolidColor(Color.INSTANCE.m4099getUnspecified0d7_KjU(), null);
                                    }
                                    z4 = i13 == 0 ? true : z;
                                    i26 = i15 == 0 ? Integer.MAX_VALUE : i;
                                    i27 = i17 == 0 ? 1 : i2;
                                    if ((i5 & 2048) == 0) {
                                        imeOptions2 = ImeOptions.INSTANCE.getDefault();
                                        i24 &= -113;
                                    } else {
                                        imeOptions2 = imeOptions;
                                    }
                                    keyboardActions2 = i19 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                    boolean z14 = i21 == 0 ? true : z2;
                                    z5 = i23 == 0 ? false : z3;
                                    if (i25 == 0) {
                                        function32 = ComposableSingletons$CoreTextFieldKt.INSTANCE.m1171getLambda1$foundation_release();
                                        VisualTransformation visualTransformation5 = none;
                                        textStyle2 = textStyle6;
                                        modifier3 = modifier2;
                                        i28 = i24;
                                        function14 = coreTextFieldKt$CoreTextField$1;
                                        imeOptions3 = imeOptions2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z6 = z14;
                                        brush2 = solidColor;
                                        visualTransformation3 = visualTransformation5;
                                    } else {
                                        VisualTransformation visualTransformation6 = none;
                                        textStyle2 = textStyle6;
                                        modifier3 = modifier2;
                                        i28 = i24;
                                        function14 = coreTextFieldKt$CoreTextField$1;
                                        imeOptions3 = imeOptions2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z6 = z14;
                                        brush2 = solidColor;
                                        visualTransformation3 = visualTransformation6;
                                        function32 = function3;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i5 & 2048) != 0) {
                                        i24 &= -113;
                                    }
                                    i26 = i;
                                    i27 = i2;
                                    keyboardActions2 = keyboardActions;
                                    z5 = z3;
                                    function32 = function3;
                                    brush2 = solidColor;
                                    visualTransformation3 = visualTransformation2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = modifier2;
                                    i28 = i24;
                                    imeOptions3 = imeOptions;
                                    z6 = z2;
                                    function14 = function13;
                                    z4 = z;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    brush3 = brush2;
                                } else {
                                    brush3 = brush2;
                                    ComposerKt.traceEventStart(-958708118, i6, i28, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:213)");
                                }
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new FocusRequester();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                FocusRequester focusRequester2 = (FocusRequester) rememberedValue;
                                ProvidableCompositionLocal<TextInputService> localTextInputService = CompositionLocalsKt.getLocalTextInputService();
                                textStyle3 = textStyle2;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localTextInputService);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                textInputService = (TextInputService) consume;
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Density density = (Density) consume2;
                                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = startRestartGroup.consume(localFontFamilyResolver);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                resolver = (FontFamily.Resolver) consume3;
                                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume4 = startRestartGroup.consume(localTextSelectionColors);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                long backgroundColor = ((TextSelectionColors) consume4).getBackgroundColor();
                                ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume5 = startRestartGroup.consume(localFocusManager);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                FocusManager focusManager = (FocusManager) consume5;
                                ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume6 = startRestartGroup.consume(localWindowInfo);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final WindowInfo windowInfo = (WindowInfo) consume6;
                                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume7 = startRestartGroup.consume(localSoftwareKeyboardController);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume7;
                                final Orientation orientation = (i26 == 1 || z4 || !imeOptions3.getSingleLine()) ? Orientation.Vertical : Orientation.Horizontal;
                                Object[] objArr = {orientation};
                                Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                final ImeOptions imeOptions5 = imeOptions3;
                                startRestartGroup.startReplaceableGroup(294183095);
                                changed = startRestartGroup.changed(orientation);
                                Object rememberedValue8 = startRestartGroup.rememberedValue();
                                if (changed) {
                                    z7 = z4;
                                } else {
                                    z7 = z4;
                                }
                                rememberedValue8 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final TextFieldScrollerPosition invoke() {
                                        return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue8);
                                startRestartGroup.endReplaceableGroup();
                                final TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue8, startRestartGroup, 72, 4);
                                startRestartGroup.startReplaceableGroup(511388516);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                    composition = textFieldValue.getComposition();
                                    z8 = z6;
                                    i29 = i27;
                                    if (composition != null) {
                                        rememberedValue2 = TextFieldDelegate.INSTANCE.m1227applyCompositionDecoration72CqOWE(composition.getPackedValue(), filterWithValidation);
                                    }
                                    rememberedValue2 = filterWithValidation;
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                } else {
                                    z8 = z6;
                                    i29 = i27;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final TransformedText transformedText = (TransformedText) rememberedValue2;
                                text = transformedText.getText();
                                final OffsetMapping offsetMapping = transformedText.getOffsetMapping();
                                RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed3 = startRestartGroup.changed(softwareKeyboardController);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    boolean z15 = z7;
                                    TextDelegate textDelegate = new TextDelegate(text, textStyle3, 0, 0, z15, 0, density, resolver, null, 300, null);
                                    annotatedString = text;
                                    textStyle4 = textStyle3;
                                    z9 = z15;
                                    resolver2 = resolver;
                                    density = density;
                                    rememberedValue3 = new TextFieldState(textDelegate, currentRecomposeScope, softwareKeyboardController);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                } else {
                                    annotatedString = text;
                                    textStyle4 = textStyle3;
                                    resolver2 = resolver;
                                    z9 = z7;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final TextFieldState textFieldState = (TextFieldState) rememberedValue3;
                                final Density density2 = density;
                                KeyboardActions keyboardActions4 = keyboardActions2;
                                textFieldState.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density2, resolver2, function1, keyboardActions4, focusManager, backgroundColor);
                                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
                                    i30 = i28;
                                    rememberedValue4 = new UndoManager(0, 1, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                } else {
                                    i30 = i28;
                                }
                                startRestartGroup.endReplaceableGroup();
                                UndoManager undoManager2 = (UndoManager) rememberedValue4;
                                UndoManager.snapshotIfNeeded$default(undoManager2, textFieldValue, 0L, 2, null);
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new TextFieldSelectionManager(undoManager2);
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) rememberedValue5;
                                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                                textFieldSelectionManager.setVisualTransformation$foundation_release(visualTransformation3);
                                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                                textFieldSelectionManager.setState$foundation_release(textFieldState);
                                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                                ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume8 = startRestartGroup.consume(localClipboardManager);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) consume8);
                                ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume9 = startRestartGroup.consume(localTextToolbar);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                textFieldSelectionManager.setTextToolbar((TextToolbar) consume9);
                                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume10 = startRestartGroup.consume(localHapticFeedback);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) consume10);
                                textFieldSelectionManager.setFocusRequester(focusRequester2);
                                textFieldSelectionManager.setEditable(!z5);
                                startRestartGroup.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue6 = compositionScopedCoroutineScopeCanceller;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue7 = startRestartGroup.rememberedValue();
                                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue7 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) rememberedValue7;
                                final boolean z16 = z5;
                                final boolean z17 = z8;
                                Modifier textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z17, focusRequester2, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                        invoke2(focusState);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(FocusState focusState) {
                                        TextLayoutResultProxy layoutResult;
                                        if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                            return;
                                        }
                                        TextFieldState.this.setHasFocus(focusState.isFocused());
                                        if (textInputService != null) {
                                            if (!TextFieldState.this.getHasFocus() || !z17 || z16) {
                                                CoreTextFieldKt.endInputSession(TextFieldState.this);
                                            } else {
                                                CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions5, offsetMapping);
                                            }
                                            if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester2, textFieldValue, TextFieldState.this, layoutResult, offsetMapping, null), 3, null);
                                            }
                                        }
                                        if (focusState.isFocused()) {
                                            return;
                                        }
                                        TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(-55007276);
                                ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
                                if (textInputService == null) {
                                    focusRequester = focusRequester2;
                                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(z17 && !z5), startRestartGroup, 0);
                                    Unit unit = Unit.INSTANCE;
                                    CoreTextFieldKt$CoreTextField$2 coreTextFieldKt$CoreTextField$2 = new CoreTextFieldKt$CoreTextField$2(textFieldState, rememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions5, null);
                                    textInputService2 = textInputService;
                                    undoManager = undoManager2;
                                    bringIntoViewRequester = bringIntoViewRequester2;
                                    EffectsKt.LaunchedEffect(unit, coreTextFieldKt$CoreTextField$2, startRestartGroup, 70);
                                } else {
                                    focusRequester = focusRequester2;
                                    bringIntoViewRequester = bringIntoViewRequester2;
                                    textInputService2 = textInputService;
                                    undoManager = undoManager2;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final FocusRequester focusRequester3 = focusRequester;
                                final boolean z18 = z5;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z19) {
                                        TextFieldState.this.setInTouchMode(z19);
                                    }
                                }), mutableInteractionSource3, z17, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                        m1172invokek4lQ0M(offset.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                    public final void m1172invokek4lQ0M(long j) {
                                        CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester3, !z18);
                                        if (TextFieldState.this.getHasFocus()) {
                                            if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                                if (layoutResult != null) {
                                                    TextFieldState textFieldState2 = TextFieldState.this;
                                                    TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState2.getProcessor(), offsetMapping, textFieldState2.getOnValueChange());
                                                    if (textFieldState2.getTextDelegate().getText().length() > 0) {
                                                        textFieldState2.setHandleState(HandleState.Cursor);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            textFieldSelectionManager.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                                        }
                                    }
                                }), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                final Modifier drawBehind = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        if (layoutResult != null) {
                                            TextFieldValue textFieldValue2 = textFieldValue;
                                            OffsetMapping offsetMapping2 = offsetMapping;
                                            TextFieldState textFieldState2 = TextFieldState.this;
                                            TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping2, layoutResult.getValue(), textFieldState2.getSelectionPaint());
                                        }
                                    }
                                });
                                final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                        TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        if (layoutResult != null) {
                                            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                        }
                                        if (z17) {
                                            if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                                if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo)) {
                                                    textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                } else {
                                                    textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                                }
                                                TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                                                TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                                            } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                            }
                                            CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping);
                                            TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                                            if (layoutResult2 != null) {
                                                TextFieldState textFieldState2 = TextFieldState.this;
                                                TextFieldValue textFieldValue2 = textFieldValue;
                                                OffsetMapping offsetMapping2 = offsetMapping;
                                                TextInputSession inputSession = textFieldState2.getInputSession();
                                                if (inputSession == null || !textFieldState2.getHasFocus()) {
                                                    return;
                                                }
                                                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2, layoutResult2);
                                            }
                                        }
                                    }
                                });
                                final boolean z19 = visualTransformation3 instanceof PasswordVisualTransformation;
                                final boolean z20 = z5;
                                final VisualTransformation visualTransformation7 = visualTransformation3;
                                Modifier semantics = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                        SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                        if (!z17) {
                                            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                        }
                                        if (z19) {
                                            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                        }
                                        final TextFieldState textFieldState2 = textFieldState;
                                        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(List<TextLayoutResult> list) {
                                                boolean z21;
                                                if (TextFieldState.this.getLayoutResult() != null) {
                                                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                                    Intrinsics.checkNotNull(layoutResult);
                                                    list.add(layoutResult.getValue());
                                                    z21 = true;
                                                } else {
                                                    z21 = false;
                                                }
                                                return Boolean.valueOf(z21);
                                            }
                                        }, 1, null);
                                        final boolean z21 = z20;
                                        final boolean z22 = z17;
                                        final TextFieldState textFieldState3 = textFieldState;
                                        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(AnnotatedString annotatedString2) {
                                                Unit unit2;
                                                if (z21 || !z22) {
                                                    return false;
                                                }
                                                TextInputSession inputSession = textFieldState3.getInputSession();
                                                if (inputSession != null) {
                                                    TextFieldState textFieldState4 = textFieldState3;
                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                                                    unit2 = Unit.INSTANCE;
                                                } else {
                                                    unit2 = null;
                                                }
                                                if (unit2 == null) {
                                                    textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                }
                                                return true;
                                            }
                                        }, 1, null);
                                        final boolean z23 = z20;
                                        final boolean z24 = z17;
                                        final TextFieldState textFieldState4 = textFieldState;
                                        final TextFieldValue textFieldValue2 = textFieldValue;
                                        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(AnnotatedString annotatedString2) {
                                                Unit unit2;
                                                if (z23 || !z24) {
                                                    return false;
                                                }
                                                TextInputSession inputSession = textFieldState4.getInputSession();
                                                if (inputSession != null) {
                                                    TextFieldState textFieldState5 = textFieldState4;
                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                                                    unit2 = Unit.INSTANCE;
                                                } else {
                                                    unit2 = null;
                                                }
                                                if (unit2 == null) {
                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                    textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                }
                                                return true;
                                            }
                                        }, 1, null);
                                        final OffsetMapping offsetMapping2 = offsetMapping;
                                        final boolean z25 = z17;
                                        final TextFieldValue textFieldValue3 = textFieldValue;
                                        final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                        final TextFieldState textFieldState5 = textFieldState;
                                        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                            }

                                            public final Boolean invoke(int i37, int i38, boolean z26) {
                                                if (!z26) {
                                                    i37 = OffsetMapping.this.transformedToOriginal(i37);
                                                }
                                                if (!z26) {
                                                    i38 = OffsetMapping.this.transformedToOriginal(i38);
                                                }
                                                boolean z27 = false;
                                                if (z25 && (i37 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i38 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                                                    if (Math.min(i37, i38) >= 0 && Math.max(i37, i38) <= textFieldValue3.getAnnotatedString().length()) {
                                                        if (z26 || i37 == i38) {
                                                            textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                        } else {
                                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                                        }
                                                        textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i37, i38), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                        z27 = true;
                                                    } else {
                                                        textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                    }
                                                }
                                                return Boolean.valueOf(z27);
                                            }
                                        }, 1, null);
                                        int imeAction = imeOptions5.getImeAction();
                                        final TextFieldState textFieldState6 = textFieldState;
                                        final ImeOptions imeOptions6 = imeOptions5;
                                        SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                                                return true;
                                            }
                                        }, 2, null);
                                        final TextFieldState textFieldState7 = textFieldState;
                                        final FocusRequester focusRequester4 = focusRequester;
                                        final boolean z26 = z20;
                                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                                                return true;
                                            }
                                        }, 1, null);
                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                return true;
                                            }
                                        }, 1, null);
                                        if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z19) {
                                            final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                    return true;
                                                }
                                            }, 1, null);
                                            if (z17 && !z20) {
                                                final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        TextFieldSelectionManager.this.cut$foundation_release();
                                                        return true;
                                                    }
                                                }, 1, null);
                                            }
                                        }
                                        if (!z17 || z20) {
                                            return;
                                        }
                                        final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager;
                                        SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.this.paste$foundation_release();
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                });
                                Brush brush4 = brush3;
                                final Modifier cursor = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState, textFieldValue, offsetMapping, brush4, (z17 || z5 || !isWindowFocusedBehindFlag(windowInfo)) ? false : true);
                                EffectsKt.DisposableEffect(textFieldSelectionManager, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                        final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                            }
                                        };
                                    }
                                }, startRestartGroup, 8);
                                EffectsKt.DisposableEffect(imeOptions5, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                        if (TextInputService.this != null && textFieldState.getHasFocus()) {
                                            textFieldState.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState.getProcessor(), imeOptions5, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
                                        }
                                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                            }
                                        };
                                    }
                                }, startRestartGroup, (i30 >> 3) & 14);
                                Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier), textFieldState, focusManager), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState, textFieldSelectionManager, textFieldValue, textFieldState.getOnValueChange(), !z5, i26 != 1, offsetMapping, undoManager, imeOptions5.getImeAction())), textFieldScrollerPosition, mutableInteractionSource5, z17).then(pointerHoverIcon$default).then(semantics), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        if (layoutResult == null) {
                                            return;
                                        }
                                        layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                    }
                                });
                                z10 = !z17 && textFieldState.getHasFocus() && textFieldState.isInTouchMode() && isWindowFocusedBehindFlag(windowInfo);
                                if (!z10) {
                                    companion = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, textFieldSelectionManager);
                                } else {
                                    companion = Modifier.INSTANCE;
                                }
                                Modifier modifier5 = modifier3;
                                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                final boolean z21 = z5;
                                final int i37 = i29;
                                final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                final int i38 = i26;
                                final Modifier modifier6 = companion;
                                final TextStyle textStyle7 = textStyle4;
                                CoreTextFieldRootBox(onGloballyPositioned2, textFieldSelectionManager, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                                        ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                                        if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                                            }
                                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34;
                                            final TextFieldState textFieldState2 = textFieldState;
                                            final TextStyle textStyle8 = textStyle7;
                                            final int i40 = i37;
                                            final int i41 = i38;
                                            final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                            final TextFieldValue textFieldValue2 = textFieldValue;
                                            final VisualTransformation visualTransformation8 = visualTransformation7;
                                            final Modifier modifier7 = cursor;
                                            final Modifier modifier8 = drawBehind;
                                            final Modifier modifier9 = onGloballyPositioned;
                                            final Modifier modifier10 = modifier6;
                                            final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester3;
                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                            final boolean z22 = z10;
                                            final boolean z23 = z21;
                                            final Function1<TextLayoutResult, Unit> function16 = function14;
                                            final OffsetMapping offsetMapping2 = offsetMapping;
                                            final Density density3 = density2;
                                            function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                                public final void invoke(Composer composer4, int i42) {
                                                    ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                                                    if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                                        }
                                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                                        VisualTransformation visualTransformation9 = visualTransformation8;
                                                        final TextFieldState textFieldState3 = TextFieldState.this;
                                                        Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final TextLayoutResultProxy invoke() {
                                                                return TextFieldState.this.getLayoutResult();
                                                            }
                                                        }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                        final TextFieldState textFieldState4 = TextFieldState.this;
                                                        final boolean z24 = z22;
                                                        final boolean z25 = z23;
                                                        final Function1<TextLayoutResult, Unit> function17 = function16;
                                                        final TextFieldValue textFieldValue4 = textFieldValue2;
                                                        final OffsetMapping offsetMapping3 = offsetMapping2;
                                                        final Density density4 = density3;
                                                        final int i43 = i41;
                                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer5, int i44) {
                                                                ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                                                if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                                                    }
                                                                    final TextFieldState textFieldState5 = textFieldState4;
                                                                    final Function1<TextLayoutResult, Unit> function18 = function17;
                                                                    final TextFieldValue textFieldValue5 = textFieldValue4;
                                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                                    final Density density5 = density4;
                                                                    final int i45 = i43;
                                                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                        /* renamed from: measure-3p2s80s */
                                                                        public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                            Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                                            TextFieldState textFieldState6 = TextFieldState.this;
                                                                            Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                                            try {
                                                                                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                                                try {
                                                                                    TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                    createNonObservableSnapshot.dispose();
                                                                                    Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                    int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                                                    int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                                                    TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                                                    if (!Intrinsics.areEqual(value, component3)) {
                                                                                        TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                                        function18.invoke(component3);
                                                                                        CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                                                    }
                                                                                    TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                    return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                            invoke2(placementScope);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                } finally {
                                                                                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                                                }
                                                                            } catch (Throwable th) {
                                                                                createNonObservableSnapshot.dispose();
                                                                                throw th;
                                                                            }
                                                                        }

                                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                                            TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                            return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                        }
                                                                    };
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                    boolean z26 = false;
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                                    Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                    composer5.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endNode();
                                                                    composer5.endReplaceableGroup();
                                                                    TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                                    if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                                        LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                                        if (layoutCoordinates.isAttached() && z24) {
                                                                            z26 = true;
                                                                        }
                                                                    }
                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                                                    if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer5.skipToGroupEnd();
                                                            }
                                                        }), composer4, 48, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), startRestartGroup, 448);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i31 = i38;
                                composer2 = startRestartGroup;
                                z11 = z21;
                                function15 = function14;
                                modifier4 = modifier5;
                                mutableInteractionSource4 = mutableInteractionSource5;
                                solidColor = brush4;
                                keyboardActions3 = keyboardActions4;
                                visualTransformation4 = visualTransformation7;
                                i32 = i29;
                                z12 = z17;
                                imeOptions4 = imeOptions5;
                                z13 = z9;
                                textStyle5 = textStyle4;
                                function33 = function34;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z13 = z;
                                imeOptions4 = imeOptions;
                                z12 = z2;
                                function33 = function3;
                                composer2 = startRestartGroup;
                                textStyle5 = textStyle2;
                                visualTransformation4 = visualTransformation2;
                                function15 = function13;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                modifier4 = modifier2;
                                i31 = i;
                                i32 = i2;
                                keyboardActions3 = keyboardActions;
                                z11 = z3;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
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
                                        CoreTextFieldKt.CoreTextField(TextFieldValue.this, function1, modifier4, textStyle5, visualTransformation4, function15, mutableInteractionSource4, solidColor, z13, i31, i32, imeOptions4, keyboardActions3, z12, z11, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i24 = i22;
                        i25 = i5 & 32768;
                        if (i25 == 0) {
                        }
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if ((i5 & 2048) == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i25 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        FocusRequester focusRequester22 = (FocusRequester) rememberedValue;
                        ProvidableCompositionLocal<TextInputService> localTextInputService2 = CompositionLocalsKt.getLocalTextInputService();
                        textStyle3 = textStyle2;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume11 = startRestartGroup.consume(localTextInputService2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        textInputService = (TextInputService) consume11;
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density3 = (Density) consume22;
                        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2 = CompositionLocalsKt.getLocalFontFamilyResolver();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume32 = startRestartGroup.consume(localFontFamilyResolver2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        resolver = (FontFamily.Resolver) consume32;
                        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2 = TextSelectionColorsKt.getLocalTextSelectionColors();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume42 = startRestartGroup.consume(localTextSelectionColors2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long backgroundColor2 = ((TextSelectionColors) consume42).getBackgroundColor();
                        ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume52 = startRestartGroup.consume(localFocusManager2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        FocusManager focusManager2 = (FocusManager) consume52;
                        ProvidableCompositionLocal<WindowInfo> localWindowInfo2 = CompositionLocalsKt.getLocalWindowInfo();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume62 = startRestartGroup.consume(localWindowInfo2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final WindowInfo windowInfo2 = (WindowInfo) consume62;
                        ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume72 = startRestartGroup.consume(localSoftwareKeyboardController2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) consume72;
                        if (i26 == 1) {
                        }
                        Object[] objArr2 = {orientation};
                        Saver<TextFieldScrollerPosition, Object> saver2 = TextFieldScrollerPosition.INSTANCE.getSaver();
                        final ImeOptions imeOptions52 = imeOptions3;
                        startRestartGroup.startReplaceableGroup(294183095);
                        changed = startRestartGroup.changed(orientation);
                        Object rememberedValue82 = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        rememberedValue82 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final TextFieldScrollerPosition invoke() {
                                return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue82);
                        startRestartGroup.endReplaceableGroup();
                        final TextFieldScrollerPosition textFieldScrollerPosition2 = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) rememberedValue82, startRestartGroup, 72, 4);
                        startRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed2) {
                        }
                        TransformedText filterWithValidation2 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                        composition = textFieldValue.getComposition();
                        z8 = z6;
                        i29 = i27;
                        if (composition != null) {
                        }
                        rememberedValue2 = filterWithValidation2;
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        final TransformedText transformedText2 = (TransformedText) rememberedValue2;
                        text = transformedText2.getText();
                        final OffsetMapping offsetMapping2 = transformedText2.getOffsetMapping();
                        RecomposeScope currentRecomposeScope2 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                        changed3 = startRestartGroup.changed(softwareKeyboardController2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (changed3) {
                        }
                        boolean z152 = z7;
                        TextDelegate textDelegate2 = new TextDelegate(text, textStyle3, 0, 0, z152, 0, density3, resolver, null, 300, null);
                        annotatedString = text;
                        textStyle4 = textStyle3;
                        z9 = z152;
                        resolver2 = resolver;
                        density3 = density3;
                        rememberedValue3 = new TextFieldState(textDelegate2, currentRecomposeScope2, softwareKeyboardController2);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        final TextFieldState textFieldState2 = (TextFieldState) rememberedValue3;
                        final Density density22 = density3;
                        KeyboardActions keyboardActions42 = keyboardActions2;
                        textFieldState2.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density22, resolver2, function1, keyboardActions42, focusManager2, backgroundColor2);
                        textFieldState2.getProcessor().reset(textFieldValue, textFieldState2.getInputSession());
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        UndoManager undoManager22 = (UndoManager) rememberedValue4;
                        UndoManager.snapshotIfNeeded$default(undoManager22, textFieldValue, 0L, 2, null);
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) rememberedValue5;
                        textFieldSelectionManager2.setOffsetMapping$foundation_release(offsetMapping2);
                        textFieldSelectionManager2.setVisualTransformation$foundation_release(visualTransformation3);
                        textFieldSelectionManager2.setOnValueChange$foundation_release(textFieldState2.getOnValueChange());
                        textFieldSelectionManager2.setState$foundation_release(textFieldState2);
                        textFieldSelectionManager2.setValue$foundation_release(textFieldValue);
                        ProvidableCompositionLocal<ClipboardManager> localClipboardManager2 = CompositionLocalsKt.getLocalClipboardManager();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume82 = startRestartGroup.consume(localClipboardManager2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        textFieldSelectionManager2.setClipboardManager$foundation_release((ClipboardManager) consume82);
                        ProvidableCompositionLocal<TextToolbar> localTextToolbar2 = CompositionLocalsKt.getLocalTextToolbar();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume92 = startRestartGroup.consume(localTextToolbar2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        textFieldSelectionManager2.setTextToolbar((TextToolbar) consume92);
                        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback2 = CompositionLocalsKt.getLocalHapticFeedback();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume102 = startRestartGroup.consume(localHapticFeedback2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        textFieldSelectionManager2.setHapticFeedBack((HapticFeedback) consume102);
                        textFieldSelectionManager2.setFocusRequester(focusRequester22);
                        textFieldSelectionManager2.setEditable(!z5);
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue7 = startRestartGroup.rememberedValue();
                        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final BringIntoViewRequester bringIntoViewRequester22 = (BringIntoViewRequester) rememberedValue7;
                        final boolean z162 = z5;
                        final boolean z172 = z8;
                        Modifier textFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z172, focusRequester22, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                invoke2(focusState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FocusState focusState) {
                                TextLayoutResultProxy layoutResult;
                                if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                    return;
                                }
                                TextFieldState.this.setHasFocus(focusState.isFocused());
                                if (textInputService != null) {
                                    if (!TextFieldState.this.getHasFocus() || !z172 || z162) {
                                        CoreTextFieldKt.endInputSession(TextFieldState.this);
                                    } else {
                                        CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions52, offsetMapping2);
                                    }
                                    if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester22, textFieldValue, TextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                    }
                                }
                                if (focusState.isFocused()) {
                                    return;
                                }
                                TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2, null, 1, null);
                            }
                        });
                        startRestartGroup.startReplaceableGroup(-55007276);
                        ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
                        if (textInputService == null) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final FocusRequester focusRequester32 = focusRequester;
                        final boolean z182 = z5;
                        MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                        Modifier pointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z192) {
                                TextFieldState.this.setInTouchMode(z192);
                            }
                        }), mutableInteractionSource3, z172, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1172invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m1172invokek4lQ0M(long j) {
                                CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester32, !z182);
                                if (TextFieldState.this.getHasFocus()) {
                                    if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        if (layoutResult != null) {
                                            TextFieldState textFieldState22 = TextFieldState.this;
                                            TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState22.getProcessor(), offsetMapping2, textFieldState22.getOnValueChange());
                                            if (textFieldState22.getTextDelegate().getText().length() > 0) {
                                                textFieldState22.setHandleState(HandleState.Cursor);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    textFieldSelectionManager2.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                                }
                            }
                        }), textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                        final Modifier drawBehind2 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    OffsetMapping offsetMapping22 = offsetMapping2;
                                    TextFieldState textFieldState22 = TextFieldState.this;
                                    TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping22, layoutResult.getValue(), textFieldState22.getSelectionPaint());
                                }
                            }
                        });
                        final Modifier onGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                }
                                if (z172) {
                                    if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                        if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo2)) {
                                            textFieldSelectionManager2.showSelectionToolbar$foundation_release();
                                        } else {
                                            textFieldSelectionManager2.hideSelectionToolbar$foundation_release();
                                        }
                                        TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, true));
                                        TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, false));
                                        TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                                    } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                        TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, true));
                                    }
                                    CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping2);
                                    TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                                    if (layoutResult2 != null) {
                                        TextFieldState textFieldState22 = TextFieldState.this;
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        OffsetMapping offsetMapping22 = offsetMapping2;
                                        TextInputSession inputSession = textFieldState22.getInputSession();
                                        if (inputSession == null || !textFieldState22.getHasFocus()) {
                                            return;
                                        }
                                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping22, layoutResult2);
                                    }
                                }
                            }
                        });
                        final boolean z192 = visualTransformation3 instanceof PasswordVisualTransformation;
                        final boolean z202 = z5;
                        final VisualTransformation visualTransformation72 = visualTransformation3;
                        Modifier semantics2 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                if (!z172) {
                                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                }
                                if (z192) {
                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                }
                                final TextFieldState textFieldState22 = textFieldState2;
                                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(List<TextLayoutResult> list) {
                                        boolean z212;
                                        if (TextFieldState.this.getLayoutResult() != null) {
                                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                            Intrinsics.checkNotNull(layoutResult);
                                            list.add(layoutResult.getValue());
                                            z212 = true;
                                        } else {
                                            z212 = false;
                                        }
                                        return Boolean.valueOf(z212);
                                    }
                                }, 1, null);
                                final boolean z212 = z202;
                                final boolean z22 = z172;
                                final TextFieldState textFieldState3 = textFieldState2;
                                SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString annotatedString2) {
                                        Unit unit2;
                                        if (z212 || !z22) {
                                            return false;
                                        }
                                        TextInputSession inputSession = textFieldState3.getInputSession();
                                        if (inputSession != null) {
                                            TextFieldState textFieldState4 = textFieldState3;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                                            unit2 = Unit.INSTANCE;
                                        } else {
                                            unit2 = null;
                                        }
                                        if (unit2 == null) {
                                            textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return true;
                                    }
                                }, 1, null);
                                final boolean z23 = z202;
                                final boolean z24 = z172;
                                final TextFieldState textFieldState4 = textFieldState2;
                                final TextFieldValue textFieldValue2 = textFieldValue;
                                SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString annotatedString2) {
                                        Unit unit2;
                                        if (z23 || !z24) {
                                            return false;
                                        }
                                        TextInputSession inputSession = textFieldState4.getInputSession();
                                        if (inputSession != null) {
                                            TextFieldState textFieldState5 = textFieldState4;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                                            unit2 = Unit.INSTANCE;
                                        } else {
                                            unit2 = null;
                                        }
                                        if (unit2 == null) {
                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                            textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return true;
                                    }
                                }, 1, null);
                                final OffsetMapping offsetMapping22 = offsetMapping2;
                                final boolean z25 = z172;
                                final TextFieldValue textFieldValue3 = textFieldValue;
                                final TextFieldSelectionManager textFieldSelectionManager22 = textFieldSelectionManager2;
                                final TextFieldState textFieldState5 = textFieldState2;
                                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                    }

                                    public final Boolean invoke(int i372, int i382, boolean z26) {
                                        if (!z26) {
                                            i372 = OffsetMapping.this.transformedToOriginal(i372);
                                        }
                                        if (!z26) {
                                            i382 = OffsetMapping.this.transformedToOriginal(i382);
                                        }
                                        boolean z27 = false;
                                        if (z25 && (i372 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i382 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                                            if (Math.min(i372, i382) >= 0 && Math.max(i372, i382) <= textFieldValue3.getAnnotatedString().length()) {
                                                if (z26 || i372 == i382) {
                                                    textFieldSelectionManager22.exitSelectionMode$foundation_release();
                                                } else {
                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager22, false, 1, null);
                                                }
                                                textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i372, i382), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                z27 = true;
                                            } else {
                                                textFieldSelectionManager22.exitSelectionMode$foundation_release();
                                            }
                                        }
                                        return Boolean.valueOf(z27);
                                    }
                                }, 1, null);
                                int imeAction = imeOptions52.getImeAction();
                                final TextFieldState textFieldState6 = textFieldState2;
                                final ImeOptions imeOptions6 = imeOptions52;
                                SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                                        return true;
                                    }
                                }, 2, null);
                                final TextFieldState textFieldState7 = textFieldState2;
                                final FocusRequester focusRequester4 = focusRequester;
                                final boolean z26 = z202;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                                        return true;
                                    }
                                }, 1, null);
                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                        return true;
                                    }
                                }, 1, null);
                                if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z192) {
                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2;
                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                            return true;
                                        }
                                    }, 1, null);
                                    if (z172 && !z202) {
                                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2;
                                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.this.cut$foundation_release();
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                }
                                if (!z172 || z202) {
                                    return;
                                }
                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2;
                                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.paste$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        });
                        Brush brush42 = brush3;
                        final Modifier cursor2 = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState2, textFieldValue, offsetMapping2, brush42, (z172 || z5 || !isWindowFocusedBehindFlag(windowInfo2)) ? false : true);
                        EffectsKt.DisposableEffect(textFieldSelectionManager2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final TextFieldSelectionManager textFieldSelectionManager22 = TextFieldSelectionManager.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                    }
                                };
                            }
                        }, startRestartGroup, 8);
                        EffectsKt.DisposableEffect(imeOptions52, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                if (TextInputService.this != null && textFieldState2.getHasFocus()) {
                                    textFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState2.getProcessor(), imeOptions52, textFieldState2.getOnValueChange(), textFieldState2.getOnImeActionPerformed()));
                                }
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        }, startRestartGroup, (i30 >> 3) & 14);
                        Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier2), textFieldState2, focusManager2), textFieldState2, textFieldSelectionManager2).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState2, textFieldSelectionManager2, textFieldValue, textFieldState2.getOnValueChange(), !z5, i26 != 1, offsetMapping2, undoManager, imeOptions52.getImeAction())), textFieldScrollerPosition2, mutableInteractionSource52, z172).then(pointerHoverIcon$default2).then(semantics2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                            }
                        });
                        if (z172) {
                        }
                        if (!z10) {
                        }
                        Modifier modifier52 = modifier3;
                        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342 = function32;
                        final boolean z212 = z5;
                        final int i372 = i29;
                        final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                        final int i382 = i26;
                        final Modifier modifier62 = companion;
                        final TextStyle textStyle72 = textStyle4;
                        CoreTextFieldRootBox(onGloballyPositioned22, textFieldSelectionManager2, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                                ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                                if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                                    }
                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function342;
                                    final TextFieldState textFieldState22 = textFieldState2;
                                    final TextStyle textStyle8 = textStyle72;
                                    final int i40 = i372;
                                    final int i41 = i382;
                                    final TextFieldScrollerPosition textFieldScrollerPosition22 = textFieldScrollerPosition2;
                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                    final VisualTransformation visualTransformation8 = visualTransformation72;
                                    final Modifier modifier7 = cursor2;
                                    final Modifier modifier8 = drawBehind2;
                                    final Modifier modifier9 = onGloballyPositioned3;
                                    final Modifier modifier10 = modifier62;
                                    final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester32;
                                    final TextFieldSelectionManager textFieldSelectionManager22 = textFieldSelectionManager2;
                                    final boolean z22 = z10;
                                    final boolean z23 = z212;
                                    final Function1<? super TextLayoutResult, Unit> function16 = function14;
                                    final OffsetMapping offsetMapping22 = offsetMapping2;
                                    final Density density32 = density22;
                                    function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                        public final void invoke(Composer composer4, int i42) {
                                            ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                                            if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                                }
                                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition22;
                                                TextFieldValue textFieldValue3 = textFieldValue2;
                                                VisualTransformation visualTransformation9 = visualTransformation8;
                                                final TextFieldState textFieldState3 = TextFieldState.this;
                                                Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final TextLayoutResultProxy invoke() {
                                                        return TextFieldState.this.getLayoutResult();
                                                    }
                                                }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22;
                                                final TextFieldState textFieldState4 = TextFieldState.this;
                                                final boolean z24 = z22;
                                                final boolean z25 = z23;
                                                final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                                final TextFieldValue textFieldValue4 = textFieldValue2;
                                                final OffsetMapping offsetMapping3 = offsetMapping22;
                                                final Density density4 = density32;
                                                final int i43 = i41;
                                                SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i44) {
                                                        ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                                        if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                                            }
                                                            final TextFieldState textFieldState5 = textFieldState4;
                                                            final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                            final TextFieldValue textFieldValue5 = textFieldValue4;
                                                            final OffsetMapping offsetMapping4 = offsetMapping3;
                                                            final Density density5 = density4;
                                                            final int i45 = i43;
                                                            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                /* renamed from: measure-3p2s80s */
                                                                public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                    Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                                    TextFieldState textFieldState6 = TextFieldState.this;
                                                                    Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                                    try {
                                                                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                                        try {
                                                                            TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                            createNonObservableSnapshot.dispose();
                                                                            Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                            int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                                            int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                                            TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                                TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                                function18.invoke(component3);
                                                                                CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                                            }
                                                                            TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                    invoke2(placementScope);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } finally {
                                                                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        createNonObservableSnapshot.dispose();
                                                                        throw th;
                                                                    }
                                                                }

                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                                    TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                    return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                }
                                                            };
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            boolean z26 = false;
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                            if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                                LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                                if (layoutCoordinates.isAttached() && z24) {
                                                                    z26 = true;
                                                                }
                                                            }
                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                                            if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, 448);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i31 = i382;
                        composer2 = startRestartGroup;
                        z11 = z212;
                        function15 = function14;
                        modifier4 = modifier52;
                        mutableInteractionSource4 = mutableInteractionSource52;
                        solidColor = brush42;
                        keyboardActions3 = keyboardActions42;
                        visualTransformation4 = visualTransformation72;
                        i32 = i29;
                        z12 = z172;
                        imeOptions4 = imeOptions52;
                        z13 = z9;
                        textStyle5 = textStyle4;
                        function33 = function342;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i4 & 112) == 0) {
                    }
                    int i342 = i18;
                    i19 = i5 & 4096;
                    if (i19 != 0) {
                    }
                    i21 = i5 & 8192;
                    if (i21 != 0) {
                    }
                    i23 = i5 & 16384;
                    if (i23 != 0) {
                    }
                    i24 = i22;
                    i25 = i5 & 32768;
                    if (i25 == 0) {
                    }
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if ((i5 & 2048) == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i25 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    FocusRequester focusRequester222 = (FocusRequester) rememberedValue;
                    ProvidableCompositionLocal<TextInputService> localTextInputService22 = CompositionLocalsKt.getLocalTextInputService();
                    textStyle3 = textStyle2;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume112 = startRestartGroup.consume(localTextInputService22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    textInputService = (TextInputService) consume112;
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density32 = (Density) consume222;
                    ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver22 = CompositionLocalsKt.getLocalFontFamilyResolver();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume322 = startRestartGroup.consume(localFontFamilyResolver22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    resolver = (FontFamily.Resolver) consume322;
                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors22 = TextSelectionColorsKt.getLocalTextSelectionColors();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume422 = startRestartGroup.consume(localTextSelectionColors22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    long backgroundColor22 = ((TextSelectionColors) consume422).getBackgroundColor();
                    ProvidableCompositionLocal<FocusManager> localFocusManager22 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume522 = startRestartGroup.consume(localFocusManager22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FocusManager focusManager22 = (FocusManager) consume522;
                    ProvidableCompositionLocal<WindowInfo> localWindowInfo22 = CompositionLocalsKt.getLocalWindowInfo();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume622 = startRestartGroup.consume(localWindowInfo22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final WindowInfo windowInfo22 = (WindowInfo) consume622;
                    ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController22 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume722 = startRestartGroup.consume(localSoftwareKeyboardController22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SoftwareKeyboardController softwareKeyboardController22 = (SoftwareKeyboardController) consume722;
                    if (i26 == 1) {
                    }
                    Object[] objArr22 = {orientation};
                    Saver<TextFieldScrollerPosition, Object> saver22 = TextFieldScrollerPosition.INSTANCE.getSaver();
                    final ImeOptions imeOptions522 = imeOptions3;
                    startRestartGroup.startReplaceableGroup(294183095);
                    changed = startRestartGroup.changed(orientation);
                    Object rememberedValue822 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    rememberedValue822 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final TextFieldScrollerPosition invoke() {
                            return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue822);
                    startRestartGroup.endReplaceableGroup();
                    final TextFieldScrollerPosition textFieldScrollerPosition22 = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr22, (Saver) saver22, (String) null, (Function0) rememberedValue822, startRestartGroup, 72, 4);
                    startRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2) {
                    }
                    TransformedText filterWithValidation22 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                    composition = textFieldValue.getComposition();
                    z8 = z6;
                    i29 = i27;
                    if (composition != null) {
                    }
                    rememberedValue2 = filterWithValidation22;
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    final TransformedText transformedText22 = (TransformedText) rememberedValue2;
                    text = transformedText22.getText();
                    final OffsetMapping offsetMapping22 = transformedText22.getOffsetMapping();
                    RecomposeScope currentRecomposeScope22 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed3 = startRestartGroup.changed(softwareKeyboardController22);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed3) {
                    }
                    boolean z1522 = z7;
                    TextDelegate textDelegate22 = new TextDelegate(text, textStyle3, 0, 0, z1522, 0, density32, resolver, null, 300, null);
                    annotatedString = text;
                    textStyle4 = textStyle3;
                    z9 = z1522;
                    resolver2 = resolver;
                    density32 = density32;
                    rememberedValue3 = new TextFieldState(textDelegate22, currentRecomposeScope22, softwareKeyboardController22);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    startRestartGroup.endReplaceableGroup();
                    final TextFieldState textFieldState22 = (TextFieldState) rememberedValue3;
                    final Density density222 = density32;
                    KeyboardActions keyboardActions422 = keyboardActions2;
                    textFieldState22.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density222, resolver2, function1, keyboardActions422, focusManager22, backgroundColor22);
                    textFieldState22.getProcessor().reset(textFieldValue, textFieldState22.getInputSession());
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    UndoManager undoManager222 = (UndoManager) rememberedValue4;
                    UndoManager.snapshotIfNeeded$default(undoManager222, textFieldValue, 0L, 2, null);
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final TextFieldSelectionManager textFieldSelectionManager22 = (TextFieldSelectionManager) rememberedValue5;
                    textFieldSelectionManager22.setOffsetMapping$foundation_release(offsetMapping22);
                    textFieldSelectionManager22.setVisualTransformation$foundation_release(visualTransformation3);
                    textFieldSelectionManager22.setOnValueChange$foundation_release(textFieldState22.getOnValueChange());
                    textFieldSelectionManager22.setState$foundation_release(textFieldState22);
                    textFieldSelectionManager22.setValue$foundation_release(textFieldValue);
                    ProvidableCompositionLocal<ClipboardManager> localClipboardManager22 = CompositionLocalsKt.getLocalClipboardManager();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume822 = startRestartGroup.consume(localClipboardManager22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    textFieldSelectionManager22.setClipboardManager$foundation_release((ClipboardManager) consume822);
                    ProvidableCompositionLocal<TextToolbar> localTextToolbar22 = CompositionLocalsKt.getLocalTextToolbar();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume922 = startRestartGroup.consume(localTextToolbar22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    textFieldSelectionManager22.setTextToolbar((TextToolbar) consume922);
                    ProvidableCompositionLocal<HapticFeedback> localHapticFeedback22 = CompositionLocalsKt.getLocalHapticFeedback();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume1022 = startRestartGroup.consume(localHapticFeedback22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    textFieldSelectionManager22.setHapticFeedBack((HapticFeedback) consume1022);
                    textFieldSelectionManager22.setFocusRequester(focusRequester222);
                    textFieldSelectionManager22.setEditable(!z5);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final BringIntoViewRequester bringIntoViewRequester222 = (BringIntoViewRequester) rememberedValue7;
                    final boolean z1622 = z5;
                    final boolean z1722 = z8;
                    Modifier textFieldFocusModifier22 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z1722, focusRequester222, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                            invoke2(focusState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusState focusState) {
                            TextLayoutResultProxy layoutResult;
                            if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                return;
                            }
                            TextFieldState.this.setHasFocus(focusState.isFocused());
                            if (textInputService != null) {
                                if (!TextFieldState.this.getHasFocus() || !z1722 || z1622) {
                                    CoreTextFieldKt.endInputSession(TextFieldState.this);
                                } else {
                                    CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions522, offsetMapping22);
                                }
                                if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester222, textFieldValue, TextFieldState.this, layoutResult, offsetMapping22, null), 3, null);
                                }
                            }
                            if (focusState.isFocused()) {
                                return;
                            }
                            TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager22, null, 1, null);
                        }
                    });
                    startRestartGroup.startReplaceableGroup(-55007276);
                    ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
                    if (textInputService == null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final FocusRequester focusRequester322 = focusRequester;
                    final boolean z1822 = z5;
                    MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                    Modifier pointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z1922) {
                            TextFieldState.this.setInTouchMode(z1922);
                        }
                    }), mutableInteractionSource3, z1722, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m1172invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1172invokek4lQ0M(long j) {
                            CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester322, !z1822);
                            if (TextFieldState.this.getHasFocus()) {
                                if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                    if (layoutResult != null) {
                                        TextFieldState textFieldState222 = TextFieldState.this;
                                        TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState222.getProcessor(), offsetMapping22, textFieldState222.getOnValueChange());
                                        if (textFieldState222.getTextDelegate().getText().length() > 0) {
                                            textFieldState222.setHandleState(HandleState.Cursor);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                textFieldSelectionManager22.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                            }
                        }
                    }), textFieldSelectionManager22.getMouseSelectionObserver(), textFieldSelectionManager22.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    final Modifier drawBehind22 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                TextFieldValue textFieldValue2 = textFieldValue;
                                OffsetMapping offsetMapping222 = offsetMapping22;
                                TextFieldState textFieldState222 = TextFieldState.this;
                                TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping222, layoutResult.getValue(), textFieldState222.getSelectionPaint());
                            }
                        }
                    });
                    final Modifier onGloballyPositioned32 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                            }
                            if (z1722) {
                                if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                    if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo22)) {
                                        textFieldSelectionManager22.showSelectionToolbar$foundation_release();
                                    } else {
                                        textFieldSelectionManager22.hideSelectionToolbar$foundation_release();
                                    }
                                    TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, true));
                                    TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, false));
                                    TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                                } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                    TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, true));
                                }
                                CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping22);
                                TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                                if (layoutResult2 != null) {
                                    TextFieldState textFieldState222 = TextFieldState.this;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    OffsetMapping offsetMapping222 = offsetMapping22;
                                    TextInputSession inputSession = textFieldState222.getInputSession();
                                    if (inputSession == null || !textFieldState222.getHasFocus()) {
                                        return;
                                    }
                                    TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping222, layoutResult2);
                                }
                            }
                        }
                    });
                    final boolean z1922 = visualTransformation3 instanceof PasswordVisualTransformation;
                    final boolean z2022 = z5;
                    final VisualTransformation visualTransformation722 = visualTransformation3;
                    Modifier semantics22 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                            SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                            if (!z1722) {
                                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                            }
                            if (z1922) {
                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                            }
                            final TextFieldState textFieldState222 = textFieldState22;
                            SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(List<TextLayoutResult> list) {
                                    boolean z2122;
                                    if (TextFieldState.this.getLayoutResult() != null) {
                                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                        Intrinsics.checkNotNull(layoutResult);
                                        list.add(layoutResult.getValue());
                                        z2122 = true;
                                    } else {
                                        z2122 = false;
                                    }
                                    return Boolean.valueOf(z2122);
                                }
                            }, 1, null);
                            final boolean z2122 = z2022;
                            final boolean z22 = z1722;
                            final TextFieldState textFieldState3 = textFieldState22;
                            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AnnotatedString annotatedString2) {
                                    Unit unit2;
                                    if (z2122 || !z22) {
                                        return false;
                                    }
                                    TextInputSession inputSession = textFieldState3.getInputSession();
                                    if (inputSession != null) {
                                        TextFieldState textFieldState4 = textFieldState3;
                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                                        unit2 = Unit.INSTANCE;
                                    } else {
                                        unit2 = null;
                                    }
                                    if (unit2 == null) {
                                        textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    }
                                    return true;
                                }
                            }, 1, null);
                            final boolean z23 = z2022;
                            final boolean z24 = z1722;
                            final TextFieldState textFieldState4 = textFieldState22;
                            final TextFieldValue textFieldValue2 = textFieldValue;
                            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AnnotatedString annotatedString2) {
                                    Unit unit2;
                                    if (z23 || !z24) {
                                        return false;
                                    }
                                    TextInputSession inputSession = textFieldState4.getInputSession();
                                    if (inputSession != null) {
                                        TextFieldState textFieldState5 = textFieldState4;
                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                                        unit2 = Unit.INSTANCE;
                                    } else {
                                        unit2 = null;
                                    }
                                    if (unit2 == null) {
                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                        textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    }
                                    return true;
                                }
                            }, 1, null);
                            final OffsetMapping offsetMapping222 = offsetMapping22;
                            final boolean z25 = z1722;
                            final TextFieldValue textFieldValue3 = textFieldValue;
                            final TextFieldSelectionManager textFieldSelectionManager222 = textFieldSelectionManager22;
                            final TextFieldState textFieldState5 = textFieldState22;
                            SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                    return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                }

                                public final Boolean invoke(int i3722, int i3822, boolean z26) {
                                    if (!z26) {
                                        i3722 = OffsetMapping.this.transformedToOriginal(i3722);
                                    }
                                    if (!z26) {
                                        i3822 = OffsetMapping.this.transformedToOriginal(i3822);
                                    }
                                    boolean z27 = false;
                                    if (z25 && (i3722 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i3822 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                                        if (Math.min(i3722, i3822) >= 0 && Math.max(i3722, i3822) <= textFieldValue3.getAnnotatedString().length()) {
                                            if (z26 || i3722 == i3822) {
                                                textFieldSelectionManager222.exitSelectionMode$foundation_release();
                                            } else {
                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager222, false, 1, null);
                                            }
                                            textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i3722, i3822), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                            z27 = true;
                                        } else {
                                            textFieldSelectionManager222.exitSelectionMode$foundation_release();
                                        }
                                    }
                                    return Boolean.valueOf(z27);
                                }
                            }, 1, null);
                            int imeAction = imeOptions522.getImeAction();
                            final TextFieldState textFieldState6 = textFieldState22;
                            final ImeOptions imeOptions6 = imeOptions522;
                            SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                                    return true;
                                }
                            }, 2, null);
                            final TextFieldState textFieldState7 = textFieldState22;
                            final FocusRequester focusRequester4 = focusRequester;
                            final boolean z26 = z2022;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                                    return true;
                                }
                            }, 1, null);
                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22;
                            SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                    return true;
                                }
                            }, 1, null);
                            if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z1922) {
                                final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager22;
                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                        return true;
                                    }
                                }, 1, null);
                                if (z1722 && !z2022) {
                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager22;
                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.this.cut$foundation_release();
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                            if (!z1722 || z2022) {
                                return;
                            }
                            final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager22;
                            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.paste$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    });
                    Brush brush422 = brush3;
                    final Modifier cursor22 = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState22, textFieldValue, offsetMapping22, brush422, (z1722 || z5 || !isWindowFocusedBehindFlag(windowInfo22)) ? false : true);
                    EffectsKt.DisposableEffect(textFieldSelectionManager22, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final TextFieldSelectionManager textFieldSelectionManager222 = TextFieldSelectionManager.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                }
                            };
                        }
                    }, startRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions522, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            if (TextInputService.this != null && textFieldState22.getHasFocus()) {
                                textFieldState22.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState22.getProcessor(), imeOptions522, textFieldState22.getOnValueChange(), textFieldState22.getOnImeActionPerformed()));
                            }
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    }, startRestartGroup, (i30 >> 3) & 14);
                    Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier22), textFieldState22, focusManager22), textFieldState22, textFieldSelectionManager22).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState22, textFieldSelectionManager22, textFieldValue, textFieldState22.getOnValueChange(), !z5, i26 != 1, offsetMapping22, undoManager, imeOptions522.getImeAction())), textFieldScrollerPosition22, mutableInteractionSource522, z1722).then(pointerHoverIcon$default22).then(semantics22), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                        }
                    });
                    if (z1722) {
                    }
                    if (!z10) {
                    }
                    Modifier modifier522 = modifier3;
                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422 = function32;
                    final boolean z2122 = z5;
                    final int i3722 = i29;
                    final BringIntoViewRequester bringIntoViewRequester322 = bringIntoViewRequester;
                    final int i3822 = i26;
                    final Modifier modifier622 = companion;
                    final TextStyle textStyle722 = textStyle4;
                    CoreTextFieldRootBox(onGloballyPositioned222, textFieldSelectionManager22, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                            ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                            if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                                }
                                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function3422;
                                final TextFieldState textFieldState222 = textFieldState22;
                                final TextStyle textStyle8 = textStyle722;
                                final int i40 = i3722;
                                final int i41 = i3822;
                                final TextFieldScrollerPosition textFieldScrollerPosition222 = textFieldScrollerPosition22;
                                final TextFieldValue textFieldValue2 = textFieldValue;
                                final VisualTransformation visualTransformation8 = visualTransformation722;
                                final Modifier modifier7 = cursor22;
                                final Modifier modifier8 = drawBehind22;
                                final Modifier modifier9 = onGloballyPositioned32;
                                final Modifier modifier10 = modifier622;
                                final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester322;
                                final TextFieldSelectionManager textFieldSelectionManager222 = textFieldSelectionManager22;
                                final boolean z22 = z10;
                                final boolean z23 = z2122;
                                final Function1<? super TextLayoutResult, Unit> function16 = function14;
                                final OffsetMapping offsetMapping222 = offsetMapping22;
                                final Density density322 = density222;
                                function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                    public final void invoke(Composer composer4, int i42) {
                                        ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                                        if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                            }
                                            Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition222;
                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                            VisualTransformation visualTransformation9 = visualTransformation8;
                                            final TextFieldState textFieldState3 = TextFieldState.this;
                                            Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final TextLayoutResultProxy invoke() {
                                                    return TextFieldState.this.getLayoutResult();
                                                }
                                            }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222;
                                            final TextFieldState textFieldState4 = TextFieldState.this;
                                            final boolean z24 = z22;
                                            final boolean z25 = z23;
                                            final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                            final TextFieldValue textFieldValue4 = textFieldValue2;
                                            final OffsetMapping offsetMapping3 = offsetMapping222;
                                            final Density density4 = density322;
                                            final int i43 = i41;
                                            SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i44) {
                                                    ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                                    if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                                        }
                                                        final TextFieldState textFieldState5 = textFieldState4;
                                                        final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                        final TextFieldValue textFieldValue5 = textFieldValue4;
                                                        final OffsetMapping offsetMapping4 = offsetMapping3;
                                                        final Density density5 = density4;
                                                        final int i45 = i43;
                                                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                            /* renamed from: measure-3p2s80s */
                                                            public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                                TextFieldState textFieldState6 = TextFieldState.this;
                                                                Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                                try {
                                                                    Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                                    try {
                                                                        TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                                        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                        createNonObservableSnapshot.dispose();
                                                                        Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                        int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                                        int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                                        TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                                        if (!Intrinsics.areEqual(value, component3)) {
                                                                            TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                            function18.invoke(component3);
                                                                            CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                                        }
                                                                        TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                        return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                invoke2(placementScope);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    } finally {
                                                                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                                    }
                                                                } catch (Throwable th) {
                                                                    createNonObservableSnapshot.dispose();
                                                                    throw th;
                                                                }
                                                            }

                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                                TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                            }
                                                        };
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        boolean z26 = false;
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                        if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                            LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                            if (layoutCoordinates.isAttached() && z24) {
                                                                z26 = true;
                                                            }
                                                        }
                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                                        if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 448);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i31 = i3822;
                    composer2 = startRestartGroup;
                    z11 = z2122;
                    function15 = function14;
                    modifier4 = modifier522;
                    mutableInteractionSource4 = mutableInteractionSource522;
                    solidColor = brush422;
                    keyboardActions3 = keyboardActions422;
                    visualTransformation4 = visualTransformation722;
                    i32 = i29;
                    z12 = z1722;
                    imeOptions4 = imeOptions522;
                    z13 = z9;
                    textStyle5 = textStyle4;
                    function33 = function3422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                textStyle2 = textStyle;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 == 0) {
                }
                i11 = i5 & 64;
                if (i11 == 0) {
                }
                i12 = i5 & 128;
                if (i12 == 0) {
                }
                i13 = i5 & 256;
                if (i13 == 0) {
                }
                i14 = i5 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 != 0) {
                }
                if ((i4 & 112) == 0) {
                }
                int i3422 = i18;
                i19 = i5 & 4096;
                if (i19 != 0) {
                }
                i21 = i5 & 8192;
                if (i21 != 0) {
                }
                i23 = i5 & 16384;
                if (i23 != 0) {
                }
                i24 = i22;
                i25 = i5 & 32768;
                if (i25 == 0) {
                }
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i17 == 0) {
                }
                if ((i5 & 2048) == 0) {
                }
                if (i19 == 0) {
                }
                if (i21 == 0) {
                }
                if (i23 == 0) {
                }
                if (i25 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                FocusRequester focusRequester2222 = (FocusRequester) rememberedValue;
                ProvidableCompositionLocal<TextInputService> localTextInputService222 = CompositionLocalsKt.getLocalTextInputService();
                textStyle3 = textStyle2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume1122 = startRestartGroup.consume(localTextInputService222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                textInputService = (TextInputService) consume1122;
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density322 = (Density) consume2222;
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver222 = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3222 = startRestartGroup.consume(localFontFamilyResolver222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                resolver = (FontFamily.Resolver) consume3222;
                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors222 = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume4222 = startRestartGroup.consume(localTextSelectionColors222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long backgroundColor222 = ((TextSelectionColors) consume4222).getBackgroundColor();
                ProvidableCompositionLocal<FocusManager> localFocusManager222 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume5222 = startRestartGroup.consume(localFocusManager222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager222 = (FocusManager) consume5222;
                ProvidableCompositionLocal<WindowInfo> localWindowInfo222 = CompositionLocalsKt.getLocalWindowInfo();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume6222 = startRestartGroup.consume(localWindowInfo222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final WindowInfo windowInfo222 = (WindowInfo) consume6222;
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController222 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume7222 = startRestartGroup.consume(localSoftwareKeyboardController222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SoftwareKeyboardController softwareKeyboardController222 = (SoftwareKeyboardController) consume7222;
                if (i26 == 1) {
                }
                Object[] objArr222 = {orientation};
                Saver<TextFieldScrollerPosition, Object> saver222 = TextFieldScrollerPosition.INSTANCE.getSaver();
                final ImeOptions imeOptions5222 = imeOptions3;
                startRestartGroup.startReplaceableGroup(294183095);
                changed = startRestartGroup.changed(orientation);
                Object rememberedValue8222 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                rememberedValue8222 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldScrollerPosition invoke() {
                        return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8222);
                startRestartGroup.endReplaceableGroup();
                final TextFieldScrollerPosition textFieldScrollerPosition222 = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr222, (Saver) saver222, (String) null, (Function0) rememberedValue8222, startRestartGroup, 72, 4);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2) {
                }
                TransformedText filterWithValidation222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                composition = textFieldValue.getComposition();
                z8 = z6;
                i29 = i27;
                if (composition != null) {
                }
                rememberedValue2 = filterWithValidation222;
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final TransformedText transformedText222 = (TransformedText) rememberedValue2;
                text = transformedText222.getText();
                final OffsetMapping offsetMapping222 = transformedText222.getOffsetMapping();
                RecomposeScope currentRecomposeScope222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed3 = startRestartGroup.changed(softwareKeyboardController222);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3) {
                }
                boolean z15222 = z7;
                TextDelegate textDelegate222 = new TextDelegate(text, textStyle3, 0, 0, z15222, 0, density322, resolver, null, 300, null);
                annotatedString = text;
                textStyle4 = textStyle3;
                z9 = z15222;
                resolver2 = resolver;
                density322 = density322;
                rememberedValue3 = new TextFieldState(textDelegate222, currentRecomposeScope222, softwareKeyboardController222);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                final TextFieldState textFieldState222 = (TextFieldState) rememberedValue3;
                final Density density2222 = density322;
                KeyboardActions keyboardActions4222 = keyboardActions2;
                textFieldState222.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density2222, resolver2, function1, keyboardActions4222, focusManager222, backgroundColor222);
                textFieldState222.getProcessor().reset(textFieldValue, textFieldState222.getInputSession());
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                UndoManager undoManager2222 = (UndoManager) rememberedValue4;
                UndoManager.snapshotIfNeeded$default(undoManager2222, textFieldValue, 0L, 2, null);
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final TextFieldSelectionManager textFieldSelectionManager222 = (TextFieldSelectionManager) rememberedValue5;
                textFieldSelectionManager222.setOffsetMapping$foundation_release(offsetMapping222);
                textFieldSelectionManager222.setVisualTransformation$foundation_release(visualTransformation3);
                textFieldSelectionManager222.setOnValueChange$foundation_release(textFieldState222.getOnValueChange());
                textFieldSelectionManager222.setState$foundation_release(textFieldState222);
                textFieldSelectionManager222.setValue$foundation_release(textFieldValue);
                ProvidableCompositionLocal<ClipboardManager> localClipboardManager222 = CompositionLocalsKt.getLocalClipboardManager();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume8222 = startRestartGroup.consume(localClipboardManager222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                textFieldSelectionManager222.setClipboardManager$foundation_release((ClipboardManager) consume8222);
                ProvidableCompositionLocal<TextToolbar> localTextToolbar222 = CompositionLocalsKt.getLocalTextToolbar();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume9222 = startRestartGroup.consume(localTextToolbar222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                textFieldSelectionManager222.setTextToolbar((TextToolbar) consume9222);
                ProvidableCompositionLocal<HapticFeedback> localHapticFeedback222 = CompositionLocalsKt.getLocalHapticFeedback();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume10222 = startRestartGroup.consume(localHapticFeedback222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                textFieldSelectionManager222.setHapticFeedBack((HapticFeedback) consume10222);
                textFieldSelectionManager222.setFocusRequester(focusRequester2222);
                textFieldSelectionManager222.setEditable(!z5);
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final BringIntoViewRequester bringIntoViewRequester2222 = (BringIntoViewRequester) rememberedValue7;
                final boolean z16222 = z5;
                final boolean z17222 = z8;
                Modifier textFieldFocusModifier222 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z17222, focusRequester2222, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState focusState) {
                        TextLayoutResultProxy layoutResult;
                        if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                            return;
                        }
                        TextFieldState.this.setHasFocus(focusState.isFocused());
                        if (textInputService != null) {
                            if (!TextFieldState.this.getHasFocus() || !z17222 || z16222) {
                                CoreTextFieldKt.endInputSession(TextFieldState.this);
                            } else {
                                CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions5222, offsetMapping222);
                            }
                            if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester2222, textFieldValue, TextFieldState.this, layoutResult, offsetMapping222, null), 3, null);
                            }
                        }
                        if (focusState.isFocused()) {
                            return;
                        }
                        TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager222, null, 1, null);
                    }
                });
                startRestartGroup.startReplaceableGroup(-55007276);
                ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
                if (textInputService == null) {
                }
                startRestartGroup.endReplaceableGroup();
                final FocusRequester focusRequester3222 = focusRequester;
                final boolean z18222 = z5;
                MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                Modifier pointerHoverIcon$default222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z19222) {
                        TextFieldState.this.setInTouchMode(z19222);
                    }
                }), mutableInteractionSource3, z17222, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                        m1172invokek4lQ0M(offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m1172invokek4lQ0M(long j) {
                        CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester3222, !z18222);
                        if (TextFieldState.this.getHasFocus()) {
                            if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    TextFieldState textFieldState2222 = TextFieldState.this;
                                    TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState2222.getProcessor(), offsetMapping222, textFieldState2222.getOnValueChange());
                                    if (textFieldState2222.getTextDelegate().getText().length() > 0) {
                                        textFieldState2222.setHandleState(HandleState.Cursor);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            textFieldSelectionManager222.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                        }
                    }
                }), textFieldSelectionManager222.getMouseSelectionObserver(), textFieldSelectionManager222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                final Modifier drawBehind222 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            TextFieldValue textFieldValue2 = textFieldValue;
                            OffsetMapping offsetMapping2222 = offsetMapping222;
                            TextFieldState textFieldState2222 = TextFieldState.this;
                            TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping2222, layoutResult.getValue(), textFieldState2222.getSelectionPaint());
                        }
                    }
                });
                final Modifier onGloballyPositioned322 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                        }
                        if (z17222) {
                            if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                                if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo222)) {
                                    textFieldSelectionManager222.showSelectionToolbar$foundation_release();
                                } else {
                                    textFieldSelectionManager222.hideSelectionToolbar$foundation_release();
                                }
                                TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, true));
                                TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, false));
                                TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                            } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                                TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, true));
                            }
                            CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping222);
                            TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                            if (layoutResult2 != null) {
                                TextFieldState textFieldState2222 = TextFieldState.this;
                                TextFieldValue textFieldValue2 = textFieldValue;
                                OffsetMapping offsetMapping2222 = offsetMapping222;
                                TextInputSession inputSession = textFieldState2222.getInputSession();
                                if (inputSession == null || !textFieldState2222.getHasFocus()) {
                                    return;
                                }
                                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2222, layoutResult2);
                            }
                        }
                    }
                });
                final boolean z19222 = visualTransformation3 instanceof PasswordVisualTransformation;
                final boolean z20222 = z5;
                final VisualTransformation visualTransformation7222 = visualTransformation3;
                Modifier semantics222 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                        SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                        if (!z17222) {
                            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                        }
                        if (z19222) {
                            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                        }
                        final TextFieldState textFieldState2222 = textFieldState222;
                        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(List<TextLayoutResult> list) {
                                boolean z21222;
                                if (TextFieldState.this.getLayoutResult() != null) {
                                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                    Intrinsics.checkNotNull(layoutResult);
                                    list.add(layoutResult.getValue());
                                    z21222 = true;
                                } else {
                                    z21222 = false;
                                }
                                return Boolean.valueOf(z21222);
                            }
                        }, 1, null);
                        final boolean z21222 = z20222;
                        final boolean z22 = z17222;
                        final TextFieldState textFieldState3 = textFieldState222;
                        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString annotatedString2) {
                                Unit unit2;
                                if (z21222 || !z22) {
                                    return false;
                                }
                                TextInputSession inputSession = textFieldState3.getInputSession();
                                if (inputSession != null) {
                                    TextFieldState textFieldState4 = textFieldState3;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                                    unit2 = Unit.INSTANCE;
                                } else {
                                    unit2 = null;
                                }
                                if (unit2 == null) {
                                    textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final boolean z23 = z20222;
                        final boolean z24 = z17222;
                        final TextFieldState textFieldState4 = textFieldState222;
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString annotatedString2) {
                                Unit unit2;
                                if (z23 || !z24) {
                                    return false;
                                }
                                TextInputSession inputSession = textFieldState4.getInputSession();
                                if (inputSession != null) {
                                    TextFieldState textFieldState5 = textFieldState4;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                                    unit2 = Unit.INSTANCE;
                                } else {
                                    unit2 = null;
                                }
                                if (unit2 == null) {
                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                    textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return true;
                            }
                        }, 1, null);
                        final OffsetMapping offsetMapping2222 = offsetMapping222;
                        final boolean z25 = z17222;
                        final TextFieldValue textFieldValue3 = textFieldValue;
                        final TextFieldSelectionManager textFieldSelectionManager2222 = textFieldSelectionManager222;
                        final TextFieldState textFieldState5 = textFieldState222;
                        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                            }

                            public final Boolean invoke(int i37222, int i38222, boolean z26) {
                                if (!z26) {
                                    i37222 = OffsetMapping.this.transformedToOriginal(i37222);
                                }
                                if (!z26) {
                                    i38222 = OffsetMapping.this.transformedToOriginal(i38222);
                                }
                                boolean z27 = false;
                                if (z25 && (i37222 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i38222 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                                    if (Math.min(i37222, i38222) >= 0 && Math.max(i37222, i38222) <= textFieldValue3.getAnnotatedString().length()) {
                                        if (z26 || i37222 == i38222) {
                                            textFieldSelectionManager2222.exitSelectionMode$foundation_release();
                                        } else {
                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2222, false, 1, null);
                                        }
                                        textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i37222, i38222), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        z27 = true;
                                    } else {
                                        textFieldSelectionManager2222.exitSelectionMode$foundation_release();
                                    }
                                }
                                return Boolean.valueOf(z27);
                            }
                        }, 1, null);
                        int imeAction = imeOptions5222.getImeAction();
                        final TextFieldState textFieldState6 = textFieldState222;
                        final ImeOptions imeOptions6 = imeOptions5222;
                        SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                                return true;
                            }
                        }, 2, null);
                        final TextFieldState textFieldState7 = textFieldState222;
                        final FocusRequester focusRequester4 = focusRequester;
                        final boolean z26 = z20222;
                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                                return true;
                            }
                        }, 1, null);
                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222;
                        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z19222) {
                            final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager222;
                            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                    return true;
                                }
                            }, 1, null);
                            if (z17222 && !z20222) {
                                final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager222;
                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.cut$foundation_release();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                        if (!z17222 || z20222) {
                            return;
                        }
                        final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager222;
                        SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.paste$foundation_release();
                                return true;
                            }
                        }, 1, null);
                    }
                });
                Brush brush4222 = brush3;
                final Modifier cursor222 = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState222, textFieldValue, offsetMapping222, brush4222, (z17222 || z5 || !isWindowFocusedBehindFlag(windowInfo222)) ? false : true);
                EffectsKt.DisposableEffect(textFieldSelectionManager222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final TextFieldSelectionManager textFieldSelectionManager2222 = TextFieldSelectionManager.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                            }
                        };
                    }
                }, startRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions5222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (TextInputService.this != null && textFieldState222.getHasFocus()) {
                            textFieldState222.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState222.getProcessor(), imeOptions5222, textFieldState222.getOnValueChange(), textFieldState222.getOnImeActionPerformed()));
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                }, startRestartGroup, (i30 >> 3) & 14);
                Modifier onGloballyPositioned2222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier222), textFieldState222, focusManager222), textFieldState222, textFieldSelectionManager222).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState222, textFieldSelectionManager222, textFieldValue, textFieldState222.getOnValueChange(), !z5, i26 != 1, offsetMapping222, undoManager, imeOptions5222.getImeAction())), textFieldScrollerPosition222, mutableInteractionSource5222, z17222).then(pointerHoverIcon$default222).then(semantics222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                    }
                });
                if (z17222) {
                }
                if (!z10) {
                }
                Modifier modifier5222 = modifier3;
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34222 = function32;
                final boolean z21222 = z5;
                final int i37222 = i29;
                final BringIntoViewRequester bringIntoViewRequester3222 = bringIntoViewRequester;
                final int i38222 = i26;
                final Modifier modifier6222 = companion;
                final TextStyle textStyle7222 = textStyle4;
                CoreTextFieldRootBox(onGloballyPositioned2222, textFieldSelectionManager222, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                        ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                        if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                            }
                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34222;
                            final TextFieldState textFieldState2222 = textFieldState222;
                            final TextStyle textStyle8 = textStyle7222;
                            final int i40 = i37222;
                            final int i41 = i38222;
                            final TextFieldScrollerPosition textFieldScrollerPosition2222 = textFieldScrollerPosition222;
                            final TextFieldValue textFieldValue2 = textFieldValue;
                            final VisualTransformation visualTransformation8 = visualTransformation7222;
                            final Modifier modifier7 = cursor222;
                            final Modifier modifier8 = drawBehind222;
                            final Modifier modifier9 = onGloballyPositioned322;
                            final Modifier modifier10 = modifier6222;
                            final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester3222;
                            final TextFieldSelectionManager textFieldSelectionManager2222 = textFieldSelectionManager222;
                            final boolean z22 = z10;
                            final boolean z23 = z21222;
                            final Function1<? super TextLayoutResult, Unit> function16 = function14;
                            final OffsetMapping offsetMapping2222 = offsetMapping222;
                            final Density density3222 = density2222;
                            function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                                public final void invoke(Composer composer4, int i42) {
                                    ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                                    if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                        }
                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2222;
                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                        VisualTransformation visualTransformation9 = visualTransformation8;
                                        final TextFieldState textFieldState3 = TextFieldState.this;
                                        Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final TextLayoutResultProxy invoke() {
                                                return TextFieldState.this.getLayoutResult();
                                            }
                                        }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2222;
                                        final TextFieldState textFieldState4 = TextFieldState.this;
                                        final boolean z24 = z22;
                                        final boolean z25 = z23;
                                        final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                        final TextFieldValue textFieldValue4 = textFieldValue2;
                                        final OffsetMapping offsetMapping3 = offsetMapping2222;
                                        final Density density4 = density3222;
                                        final int i43 = i41;
                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i44) {
                                                ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                                if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                                    }
                                                    final TextFieldState textFieldState5 = textFieldState4;
                                                    final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                    final TextFieldValue textFieldValue5 = textFieldValue4;
                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                    final Density density5 = density4;
                                                    final int i45 = i43;
                                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                        /* renamed from: measure-3p2s80s */
                                                        public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                            Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                            TextFieldState textFieldState6 = TextFieldState.this;
                                                            Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                            try {
                                                                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                                try {
                                                                    TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                    createNonObservableSnapshot.dispose();
                                                                    Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                    int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                                    int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                                    TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                                    if (!Intrinsics.areEqual(value, component3)) {
                                                                        TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                        function18.invoke(component3);
                                                                        CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                                    }
                                                                    TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                    return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                            invoke2(placementScope);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                } finally {
                                                                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                                }
                                                            } catch (Throwable th) {
                                                                createNonObservableSnapshot.dispose();
                                                                throw th;
                                                            }
                                                        }

                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                            TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                            return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                        }
                                                    };
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                    boolean z26 = false;
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                    if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                        LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                        if (layoutCoordinates.isAttached() && z24) {
                                                            z26 = true;
                                                        }
                                                    }
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                                    if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 448);
                if (ComposerKt.isTraceInProgress()) {
                }
                i31 = i38222;
                composer2 = startRestartGroup;
                z11 = z21222;
                function15 = function14;
                modifier4 = modifier5222;
                mutableInteractionSource4 = mutableInteractionSource5222;
                solidColor = brush4222;
                keyboardActions3 = keyboardActions4222;
                visualTransformation4 = visualTransformation7222;
                i32 = i29;
                z12 = z17222;
                imeOptions4 = imeOptions5222;
                z13 = z9;
                textStyle5 = textStyle4;
                function33 = function34222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            textStyle2 = textStyle;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 == 0) {
            }
            i11 = i5 & 64;
            if (i11 == 0) {
            }
            i12 = i5 & 128;
            if (i12 == 0) {
            }
            i13 = i5 & 256;
            if (i13 == 0) {
            }
            i14 = i5 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 != 0) {
            }
            if ((i4 & 112) == 0) {
            }
            int i34222 = i18;
            i19 = i5 & 4096;
            if (i19 != 0) {
            }
            i21 = i5 & 8192;
            if (i21 != 0) {
            }
            i23 = i5 & 16384;
            if (i23 != 0) {
            }
            i24 = i22;
            i25 = i5 & 32768;
            if (i25 == 0) {
            }
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i17 == 0) {
            }
            if ((i5 & 2048) == 0) {
            }
            if (i19 == 0) {
            }
            if (i21 == 0) {
            }
            if (i23 == 0) {
            }
            if (i25 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            FocusRequester focusRequester22222 = (FocusRequester) rememberedValue;
            ProvidableCompositionLocal<TextInputService> localTextInputService2222 = CompositionLocalsKt.getLocalTextInputService();
            textStyle3 = textStyle2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume11222 = startRestartGroup.consume(localTextInputService2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            textInputService = (TextInputService) consume11222;
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density3222 = (Density) consume22222;
            ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver2222 = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32222 = startRestartGroup.consume(localFontFamilyResolver2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            resolver = (FontFamily.Resolver) consume32222;
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors2222 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume42222 = startRestartGroup.consume(localTextSelectionColors2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long backgroundColor2222 = ((TextSelectionColors) consume42222).getBackgroundColor();
            ProvidableCompositionLocal<FocusManager> localFocusManager2222 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume52222 = startRestartGroup.consume(localFocusManager2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager2222 = (FocusManager) consume52222;
            ProvidableCompositionLocal<WindowInfo> localWindowInfo2222 = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume62222 = startRestartGroup.consume(localWindowInfo2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final WindowInfo windowInfo2222 = (WindowInfo) consume62222;
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2222 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume72222 = startRestartGroup.consume(localSoftwareKeyboardController2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SoftwareKeyboardController softwareKeyboardController2222 = (SoftwareKeyboardController) consume72222;
            if (i26 == 1) {
            }
            Object[] objArr2222 = {orientation};
            Saver<TextFieldScrollerPosition, Object> saver2222 = TextFieldScrollerPosition.INSTANCE.getSaver();
            final ImeOptions imeOptions52222 = imeOptions3;
            startRestartGroup.startReplaceableGroup(294183095);
            changed = startRestartGroup.changed(orientation);
            Object rememberedValue82222 = startRestartGroup.rememberedValue();
            if (changed) {
            }
            rememberedValue82222 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextFieldScrollerPosition invoke() {
                    return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue82222);
            startRestartGroup.endReplaceableGroup();
            final TextFieldScrollerPosition textFieldScrollerPosition2222 = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr2222, (Saver) saver2222, (String) null, (Function0) rememberedValue82222, startRestartGroup, 72, 4);
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2) {
            }
            TransformedText filterWithValidation2222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
            composition = textFieldValue.getComposition();
            z8 = z6;
            i29 = i27;
            if (composition != null) {
            }
            rememberedValue2 = filterWithValidation2222;
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final TransformedText transformedText2222 = (TransformedText) rememberedValue2;
            text = transformedText2222.getText();
            final OffsetMapping offsetMapping2222 = transformedText2222.getOffsetMapping();
            RecomposeScope currentRecomposeScope2222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed3 = startRestartGroup.changed(softwareKeyboardController2222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3) {
            }
            boolean z152222 = z7;
            TextDelegate textDelegate2222 = new TextDelegate(text, textStyle3, 0, 0, z152222, 0, density3222, resolver, null, 300, null);
            annotatedString = text;
            textStyle4 = textStyle3;
            z9 = z152222;
            resolver2 = resolver;
            density3222 = density3222;
            rememberedValue3 = new TextFieldState(textDelegate2222, currentRecomposeScope2222, softwareKeyboardController2222);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            final TextFieldState textFieldState2222 = (TextFieldState) rememberedValue3;
            final Density density22222 = density3222;
            KeyboardActions keyboardActions42222 = keyboardActions2;
            textFieldState2222.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density22222, resolver2, function1, keyboardActions42222, focusManager2222, backgroundColor2222);
            textFieldState2222.getProcessor().reset(textFieldValue, textFieldState2222.getInputSession());
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            UndoManager undoManager22222 = (UndoManager) rememberedValue4;
            UndoManager.snapshotIfNeeded$default(undoManager22222, textFieldValue, 0L, 2, null);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final TextFieldSelectionManager textFieldSelectionManager2222 = (TextFieldSelectionManager) rememberedValue5;
            textFieldSelectionManager2222.setOffsetMapping$foundation_release(offsetMapping2222);
            textFieldSelectionManager2222.setVisualTransformation$foundation_release(visualTransformation3);
            textFieldSelectionManager2222.setOnValueChange$foundation_release(textFieldState2222.getOnValueChange());
            textFieldSelectionManager2222.setState$foundation_release(textFieldState2222);
            textFieldSelectionManager2222.setValue$foundation_release(textFieldValue);
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager2222 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume82222 = startRestartGroup.consume(localClipboardManager2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            textFieldSelectionManager2222.setClipboardManager$foundation_release((ClipboardManager) consume82222);
            ProvidableCompositionLocal<TextToolbar> localTextToolbar2222 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume92222 = startRestartGroup.consume(localTextToolbar2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            textFieldSelectionManager2222.setTextToolbar((TextToolbar) consume92222);
            ProvidableCompositionLocal<HapticFeedback> localHapticFeedback2222 = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume102222 = startRestartGroup.consume(localHapticFeedback2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            textFieldSelectionManager2222.setHapticFeedBack((HapticFeedback) consume102222);
            textFieldSelectionManager2222.setFocusRequester(focusRequester22222);
            textFieldSelectionManager2222.setEditable(!z5);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final BringIntoViewRequester bringIntoViewRequester22222 = (BringIntoViewRequester) rememberedValue7;
            final boolean z162222 = z5;
            final boolean z172222 = z8;
            Modifier textFieldFocusModifier2222 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z172222, focusRequester22222, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState focusState) {
                    TextLayoutResultProxy layoutResult;
                    if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                        return;
                    }
                    TextFieldState.this.setHasFocus(focusState.isFocused());
                    if (textInputService != null) {
                        if (!TextFieldState.this.getHasFocus() || !z172222 || z162222) {
                            CoreTextFieldKt.endInputSession(TextFieldState.this);
                        } else {
                            CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions52222, offsetMapping2222);
                        }
                        if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester22222, textFieldValue, TextFieldState.this, layoutResult, offsetMapping2222, null), 3, null);
                        }
                    }
                    if (focusState.isFocused()) {
                        return;
                    }
                    TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2222, null, 1, null);
                }
            });
            startRestartGroup.startReplaceableGroup(-55007276);
            ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
            if (textInputService == null) {
            }
            startRestartGroup.endReplaceableGroup();
            final FocusRequester focusRequester32222 = focusRequester;
            final boolean z182222 = z5;
            MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
            Modifier pointerHoverIcon$default2222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z192222) {
                    TextFieldState.this.setInTouchMode(z192222);
                }
            }), mutableInteractionSource3, z172222, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m1172invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1172invokek4lQ0M(long j) {
                    CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester32222, !z182222);
                    if (TextFieldState.this.getHasFocus()) {
                        if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                TextFieldState textFieldState22222 = TextFieldState.this;
                                TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState22222.getProcessor(), offsetMapping2222, textFieldState22222.getOnValueChange());
                                if (textFieldState22222.getTextDelegate().getText().length() > 0) {
                                    textFieldState22222.setHandleState(HandleState.Cursor);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        textFieldSelectionManager2222.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                    }
                }
            }), textFieldSelectionManager2222.getMouseSelectionObserver(), textFieldSelectionManager2222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            final Modifier drawBehind2222 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult != null) {
                        TextFieldValue textFieldValue2 = textFieldValue;
                        OffsetMapping offsetMapping22222 = offsetMapping2222;
                        TextFieldState textFieldState22222 = TextFieldState.this;
                        TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping22222, layoutResult.getValue(), textFieldState22222.getSelectionPaint());
                    }
                }
            });
            final Modifier onGloballyPositioned3222 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                    TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult != null) {
                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                    }
                    if (z172222) {
                        if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                            if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo2222)) {
                                textFieldSelectionManager2222.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager2222.hideSelectionToolbar$foundation_release();
                            }
                            TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, true));
                            TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, false));
                            TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                        } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                            TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, true));
                        }
                        CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping2222);
                        TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                        if (layoutResult2 != null) {
                            TextFieldState textFieldState22222 = TextFieldState.this;
                            TextFieldValue textFieldValue2 = textFieldValue;
                            OffsetMapping offsetMapping22222 = offsetMapping2222;
                            TextInputSession inputSession = textFieldState22222.getInputSession();
                            if (inputSession == null || !textFieldState22222.getHasFocus()) {
                                return;
                            }
                            TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping22222, layoutResult2);
                        }
                    }
                }
            });
            final boolean z192222 = visualTransformation3 instanceof PasswordVisualTransformation;
            final boolean z202222 = z5;
            final VisualTransformation visualTransformation72222 = visualTransformation3;
            Modifier semantics2222 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                    SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                    if (!z172222) {
                        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                    }
                    if (z192222) {
                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                    }
                    final TextFieldState textFieldState22222 = textFieldState2222;
                    SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(List<TextLayoutResult> list) {
                            boolean z212222;
                            if (TextFieldState.this.getLayoutResult() != null) {
                                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                                Intrinsics.checkNotNull(layoutResult);
                                list.add(layoutResult.getValue());
                                z212222 = true;
                            } else {
                                z212222 = false;
                            }
                            return Boolean.valueOf(z212222);
                        }
                    }, 1, null);
                    final boolean z212222 = z202222;
                    final boolean z22 = z172222;
                    final TextFieldState textFieldState3 = textFieldState2222;
                    SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString annotatedString2) {
                            Unit unit2;
                            if (z212222 || !z22) {
                                return false;
                            }
                            TextInputSession inputSession = textFieldState3.getInputSession();
                            if (inputSession != null) {
                                TextFieldState textFieldState4 = textFieldState3;
                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                                unit2 = Unit.INSTANCE;
                            } else {
                                unit2 = null;
                            }
                            if (unit2 == null) {
                                textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                            }
                            return true;
                        }
                    }, 1, null);
                    final boolean z23 = z202222;
                    final boolean z24 = z172222;
                    final TextFieldState textFieldState4 = textFieldState2222;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString annotatedString2) {
                            Unit unit2;
                            if (z23 || !z24) {
                                return false;
                            }
                            TextInputSession inputSession = textFieldState4.getInputSession();
                            if (inputSession != null) {
                                TextFieldState textFieldState5 = textFieldState4;
                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                                unit2 = Unit.INSTANCE;
                            } else {
                                unit2 = null;
                            }
                            if (unit2 == null) {
                                TextFieldValue textFieldValue3 = textFieldValue2;
                                textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                            }
                            return true;
                        }
                    }, 1, null);
                    final OffsetMapping offsetMapping22222 = offsetMapping2222;
                    final boolean z25 = z172222;
                    final TextFieldValue textFieldValue3 = textFieldValue;
                    final TextFieldSelectionManager textFieldSelectionManager22222 = textFieldSelectionManager2222;
                    final TextFieldState textFieldState5 = textFieldState2222;
                    SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                        }

                        public final Boolean invoke(int i372222, int i382222, boolean z26) {
                            if (!z26) {
                                i372222 = OffsetMapping.this.transformedToOriginal(i372222);
                            }
                            if (!z26) {
                                i382222 = OffsetMapping.this.transformedToOriginal(i382222);
                            }
                            boolean z27 = false;
                            if (z25 && (i372222 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i382222 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                                if (Math.min(i372222, i382222) >= 0 && Math.max(i372222, i382222) <= textFieldValue3.getAnnotatedString().length()) {
                                    if (z26 || i372222 == i382222) {
                                        textFieldSelectionManager22222.exitSelectionMode$foundation_release();
                                    } else {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager22222, false, 1, null);
                                    }
                                    textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i372222, i382222), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    z27 = true;
                                } else {
                                    textFieldSelectionManager22222.exitSelectionMode$foundation_release();
                                }
                            }
                            return Boolean.valueOf(z27);
                        }
                    }, 1, null);
                    int imeAction = imeOptions52222.getImeAction();
                    final TextFieldState textFieldState6 = textFieldState2222;
                    final ImeOptions imeOptions6 = imeOptions52222;
                    SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                            return true;
                        }
                    }, 2, null);
                    final TextFieldState textFieldState7 = textFieldState2222;
                    final FocusRequester focusRequester4 = focusRequester;
                    final boolean z26 = z202222;
                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                            return true;
                        }
                    }, 1, null);
                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2222;
                    SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                            return true;
                        }
                    }, 1, null);
                    if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z192222) {
                        final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2222;
                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                return true;
                            }
                        }, 1, null);
                        if (z172222 && !z202222) {
                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2222;
                            SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.cut$foundation_release();
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                    if (!z172222 || z202222) {
                        return;
                    }
                    final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2222;
                    SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.this.paste$foundation_release();
                            return true;
                        }
                    }, 1, null);
                }
            });
            Brush brush42222 = brush3;
            final Modifier cursor2222 = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState2222, textFieldValue, offsetMapping2222, brush42222, (z172222 || z5 || !isWindowFocusedBehindFlag(windowInfo2222)) ? false : true);
            EffectsKt.DisposableEffect(textFieldSelectionManager2222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final TextFieldSelectionManager textFieldSelectionManager22222 = TextFieldSelectionManager.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                        }
                    };
                }
            }, startRestartGroup, 8);
            EffectsKt.DisposableEffect(imeOptions52222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    if (TextInputService.this != null && textFieldState2222.getHasFocus()) {
                        textFieldState2222.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState2222.getProcessor(), imeOptions52222, textFieldState2222.getOnValueChange(), textFieldState2222.getOnImeActionPerformed()));
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            }, startRestartGroup, (i30 >> 3) & 14);
            Modifier onGloballyPositioned22222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier2222), textFieldState2222, focusManager2222), textFieldState2222, textFieldSelectionManager2222).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState2222, textFieldSelectionManager2222, textFieldValue, textFieldState2222.getOnValueChange(), !z5, i26 != 1, offsetMapping2222, undoManager, imeOptions52222.getImeAction())), textFieldScrollerPosition2222, mutableInteractionSource52222, z172222).then(pointerHoverIcon$default2222).then(semantics2222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                    TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                }
            });
            if (z172222) {
            }
            if (!z10) {
            }
            Modifier modifier52222 = modifier3;
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342222 = function32;
            final boolean z212222 = z5;
            final int i372222 = i29;
            final BringIntoViewRequester bringIntoViewRequester32222 = bringIntoViewRequester;
            final int i382222 = i26;
            final Modifier modifier62222 = companion;
            final TextStyle textStyle72222 = textStyle4;
            CoreTextFieldRootBox(onGloballyPositioned22222, textFieldSelectionManager2222, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                    ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                    if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                        }
                        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function342222;
                        final TextFieldState textFieldState22222 = textFieldState2222;
                        final TextStyle textStyle8 = textStyle72222;
                        final int i40 = i372222;
                        final int i41 = i382222;
                        final TextFieldScrollerPosition textFieldScrollerPosition22222 = textFieldScrollerPosition2222;
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        final VisualTransformation visualTransformation8 = visualTransformation72222;
                        final Modifier modifier7 = cursor2222;
                        final Modifier modifier8 = drawBehind2222;
                        final Modifier modifier9 = onGloballyPositioned3222;
                        final Modifier modifier10 = modifier62222;
                        final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester32222;
                        final TextFieldSelectionManager textFieldSelectionManager22222 = textFieldSelectionManager2222;
                        final boolean z22 = z10;
                        final boolean z23 = z212222;
                        final Function1<? super TextLayoutResult, Unit> function16 = function14;
                        final OffsetMapping offsetMapping22222 = offsetMapping2222;
                        final Density density32222 = density22222;
                        function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                            public final void invoke(Composer composer4, int i42) {
                                ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                                if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                    }
                                    Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition22222;
                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                    VisualTransformation visualTransformation9 = visualTransformation8;
                                    final TextFieldState textFieldState3 = TextFieldState.this;
                                    Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final TextLayoutResultProxy invoke() {
                                            return TextFieldState.this.getLayoutResult();
                                        }
                                    }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22222;
                                    final TextFieldState textFieldState4 = TextFieldState.this;
                                    final boolean z24 = z22;
                                    final boolean z25 = z23;
                                    final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                    final OffsetMapping offsetMapping3 = offsetMapping22222;
                                    final Density density4 = density32222;
                                    final int i43 = i41;
                                    SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i44) {
                                            ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                            if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                                }
                                                final TextFieldState textFieldState5 = textFieldState4;
                                                final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                final TextFieldValue textFieldValue5 = textFieldValue4;
                                                final OffsetMapping offsetMapping4 = offsetMapping3;
                                                final Density density5 = density4;
                                                final int i45 = i43;
                                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                    /* renamed from: measure-3p2s80s */
                                                    public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                        Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                        TextFieldState textFieldState6 = TextFieldState.this;
                                                        Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                        try {
                                                            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                            try {
                                                                TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                createNonObservableSnapshot.dispose();
                                                                Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                                int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                                TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                                if (!Intrinsics.areEqual(value, component3)) {
                                                                    TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                    function18.invoke(component3);
                                                                    CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                                }
                                                                TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                        invoke2(placementScope);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            } finally {
                                                                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                            }
                                                        } catch (Throwable th) {
                                                            createNonObservableSnapshot.dispose();
                                                            throw th;
                                                        }
                                                    }

                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                        TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                        return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                    }
                                                };
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                boolean z26 = false;
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                    LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                    if (layoutCoordinates.isAttached() && z24) {
                                                        z26 = true;
                                                    }
                                                }
                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                                if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 448);
            if (ComposerKt.isTraceInProgress()) {
            }
            i31 = i382222;
            composer2 = startRestartGroup;
            z11 = z212222;
            function15 = function14;
            modifier4 = modifier52222;
            mutableInteractionSource4 = mutableInteractionSource52222;
            solidColor = brush42222;
            keyboardActions3 = keyboardActions42222;
            visualTransformation4 = visualTransformation72222;
            i32 = i29;
            z12 = z172222;
            imeOptions4 = imeOptions52222;
            z13 = z9;
            textStyle5 = textStyle4;
            function33 = function342222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        modifier2 = modifier;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        textStyle2 = textStyle;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 == 0) {
        }
        i11 = i5 & 64;
        if (i11 == 0) {
        }
        i12 = i5 & 128;
        if (i12 == 0) {
        }
        i13 = i5 & 256;
        if (i13 == 0) {
        }
        i14 = i5 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 != 0) {
        }
        if ((i4 & 112) == 0) {
        }
        int i342222 = i18;
        i19 = i5 & 4096;
        if (i19 != 0) {
        }
        i21 = i5 & 8192;
        if (i21 != 0) {
        }
        i23 = i5 & 16384;
        if (i23 != 0) {
        }
        i24 = i22;
        i25 = i5 & 32768;
        if (i25 == 0) {
        }
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i17 == 0) {
        }
        if ((i5 & 2048) == 0) {
        }
        if (i19 == 0) {
        }
        if (i21 == 0) {
        }
        if (i23 == 0) {
        }
        if (i25 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        FocusRequester focusRequester222222 = (FocusRequester) rememberedValue;
        ProvidableCompositionLocal<TextInputService> localTextInputService22222 = CompositionLocalsKt.getLocalTextInputService();
        textStyle3 = textStyle2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume112222 = startRestartGroup.consume(localTextInputService22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        textInputService = (TextInputService) consume112222;
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density32222 = (Density) consume222222;
        ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver22222 = CompositionLocalsKt.getLocalFontFamilyResolver();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322222 = startRestartGroup.consume(localFontFamilyResolver22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        resolver = (FontFamily.Resolver) consume322222;
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors22222 = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume422222 = startRestartGroup.consume(localTextSelectionColors22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long backgroundColor22222 = ((TextSelectionColors) consume422222).getBackgroundColor();
        ProvidableCompositionLocal<FocusManager> localFocusManager22222 = CompositionLocalsKt.getLocalFocusManager();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume522222 = startRestartGroup.consume(localFocusManager22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager22222 = (FocusManager) consume522222;
        ProvidableCompositionLocal<WindowInfo> localWindowInfo22222 = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume622222 = startRestartGroup.consume(localWindowInfo22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final WindowInfo windowInfo22222 = (WindowInfo) consume622222;
        ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController22222 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume722222 = startRestartGroup.consume(localSoftwareKeyboardController22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        SoftwareKeyboardController softwareKeyboardController22222 = (SoftwareKeyboardController) consume722222;
        if (i26 == 1) {
        }
        Object[] objArr22222 = {orientation};
        Saver<TextFieldScrollerPosition, Object> saver22222 = TextFieldScrollerPosition.INSTANCE.getSaver();
        final ImeOptions imeOptions522222 = imeOptions3;
        startRestartGroup.startReplaceableGroup(294183095);
        changed = startRestartGroup.changed(orientation);
        Object rememberedValue822222 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        rememberedValue822222 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldScrollerPosition invoke() {
                return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue822222);
        startRestartGroup.endReplaceableGroup();
        final TextFieldScrollerPosition textFieldScrollerPosition22222 = (TextFieldScrollerPosition) RememberSaveableKt.m3680rememberSaveable(objArr22222, (Saver) saver22222, (String) null, (Function0) rememberedValue822222, startRestartGroup, 72, 4);
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        changed2 = startRestartGroup.changed(textFieldValue) | startRestartGroup.changed(visualTransformation3);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2) {
        }
        TransformedText filterWithValidation22222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
        composition = textFieldValue.getComposition();
        z8 = z6;
        i29 = i27;
        if (composition != null) {
        }
        rememberedValue2 = filterWithValidation22222;
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final TransformedText transformedText22222 = (TransformedText) rememberedValue2;
        text = transformedText22222.getText();
        final OffsetMapping offsetMapping22222 = transformedText22222.getOffsetMapping();
        RecomposeScope currentRecomposeScope22222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed3 = startRestartGroup.changed(softwareKeyboardController22222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed3) {
        }
        boolean z1522222 = z7;
        TextDelegate textDelegate22222 = new TextDelegate(text, textStyle3, 0, 0, z1522222, 0, density32222, resolver, null, 300, null);
        annotatedString = text;
        textStyle4 = textStyle3;
        z9 = z1522222;
        resolver2 = resolver;
        density32222 = density32222;
        rememberedValue3 = new TextFieldState(textDelegate22222, currentRecomposeScope22222, softwareKeyboardController22222);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        final TextFieldState textFieldState22222 = (TextFieldState) rememberedValue3;
        final Density density222222 = density32222;
        KeyboardActions keyboardActions422222 = keyboardActions2;
        textFieldState22222.m1250updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle4, z9, density222222, resolver2, function1, keyboardActions422222, focusManager22222, backgroundColor22222);
        textFieldState22222.getProcessor().reset(textFieldValue, textFieldState22222.getInputSession());
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 != Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        UndoManager undoManager222222 = (UndoManager) rememberedValue4;
        UndoManager.snapshotIfNeeded$default(undoManager222222, textFieldValue, 0L, 2, null);
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final TextFieldSelectionManager textFieldSelectionManager22222 = (TextFieldSelectionManager) rememberedValue5;
        textFieldSelectionManager22222.setOffsetMapping$foundation_release(offsetMapping22222);
        textFieldSelectionManager22222.setVisualTransformation$foundation_release(visualTransformation3);
        textFieldSelectionManager22222.setOnValueChange$foundation_release(textFieldState22222.getOnValueChange());
        textFieldSelectionManager22222.setState$foundation_release(textFieldState22222);
        textFieldSelectionManager22222.setValue$foundation_release(textFieldValue);
        ProvidableCompositionLocal<ClipboardManager> localClipboardManager22222 = CompositionLocalsKt.getLocalClipboardManager();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume822222 = startRestartGroup.consume(localClipboardManager22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        textFieldSelectionManager22222.setClipboardManager$foundation_release((ClipboardManager) consume822222);
        ProvidableCompositionLocal<TextToolbar> localTextToolbar22222 = CompositionLocalsKt.getLocalTextToolbar();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume922222 = startRestartGroup.consume(localTextToolbar22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        textFieldSelectionManager22222.setTextToolbar((TextToolbar) consume922222);
        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback22222 = CompositionLocalsKt.getLocalHapticFeedback();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume1022222 = startRestartGroup.consume(localHapticFeedback22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        textFieldSelectionManager22222.setHapticFeedBack((HapticFeedback) consume1022222);
        textFieldSelectionManager22222.setFocusRequester(focusRequester222222);
        textFieldSelectionManager22222.setEditable(!z5);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue6).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final BringIntoViewRequester bringIntoViewRequester222222 = (BringIntoViewRequester) rememberedValue7;
        final boolean z1622222 = z5;
        final boolean z1722222 = z8;
        Modifier textFieldFocusModifier22222 = TextFieldGestureModifiersKt.textFieldFocusModifier(Modifier.INSTANCE, z1722222, focusRequester222222, mutableInteractionSource3, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                TextLayoutResultProxy layoutResult;
                if (TextFieldState.this.getHasFocus() == focusState.isFocused()) {
                    return;
                }
                TextFieldState.this.setHasFocus(focusState.isFocused());
                if (textInputService != null) {
                    if (!TextFieldState.this.getHasFocus() || !z1722222 || z1622222) {
                        CoreTextFieldKt.endInputSession(TextFieldState.this);
                    } else {
                        CoreTextFieldKt.startInputSession(textInputService, TextFieldState.this, textFieldValue, imeOptions522222, offsetMapping22222);
                    }
                    if (focusState.isFocused() && (layoutResult = TextFieldState.this.getLayoutResult()) != null) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(bringIntoViewRequester222222, textFieldValue, TextFieldState.this, layoutResult, offsetMapping22222, null), 3, null);
                    }
                }
                if (focusState.isFocused()) {
                    return;
                }
                TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager22222, null, 1, null);
            }
        });
        startRestartGroup.startReplaceableGroup(-55007276);
        ComposerKt.sourceInformation(startRestartGroup, "344@17012L42,345@17063L1006");
        if (textInputService == null) {
        }
        startRestartGroup.endReplaceableGroup();
        final FocusRequester focusRequester322222 = focusRequester;
        final boolean z1822222 = z5;
        MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
        Modifier pointerHoverIcon$default22222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(Modifier.INSTANCE, new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z1922222) {
                TextFieldState.this.setInTouchMode(z1922222);
            }
        }), mutableInteractionSource3, z1722222, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1172invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1172invokek4lQ0M(long j) {
                CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester322222, !z1822222);
                if (TextFieldState.this.getHasFocus()) {
                    if (TextFieldState.this.getHandleState() != HandleState.Selection) {
                        TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            TextFieldState textFieldState222222 = TextFieldState.this;
                            TextFieldDelegate.INSTANCE.m1229setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState222222.getProcessor(), offsetMapping22222, textFieldState222222.getOnValueChange());
                            if (textFieldState222222.getTextDelegate().getText().length() > 0) {
                                textFieldState222222.setHandleState(HandleState.Cursor);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    textFieldSelectionManager22222.m1377deselect_kEHs6E$foundation_release(Offset.m3811boximpl(j));
                }
            }
        }), textFieldSelectionManager22222.getMouseSelectionObserver(), textFieldSelectionManager22222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
        final Modifier drawBehind22222 = DrawModifierKt.drawBehind(Modifier.INSTANCE, new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
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
                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                if (layoutResult != null) {
                    TextFieldValue textFieldValue2 = textFieldValue;
                    OffsetMapping offsetMapping222222 = offsetMapping22222;
                    TextFieldState textFieldState222222 = TextFieldState.this;
                    TextFieldDelegate.INSTANCE.draw$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, offsetMapping222222, layoutResult.getValue(), textFieldState222222.getSelectionPaint());
                }
            }
        });
        final Modifier onGloballyPositioned32222 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                TextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                }
                if (z1722222) {
                    if (TextFieldState.this.getHandleState() == HandleState.Selection) {
                        if (TextFieldState.this.getShowFloatingToolbar() && CoreTextFieldKt.isWindowFocusedBehindFlag(windowInfo22222)) {
                            textFieldSelectionManager22222.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager22222.hideSelectionToolbar$foundation_release();
                        }
                        TextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, true));
                        TextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, false));
                        TextFieldState.this.setShowCursorHandle(TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()));
                    } else if (TextFieldState.this.getHandleState() == HandleState.Cursor) {
                        TextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, true));
                    }
                    CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue, offsetMapping22222);
                    TextLayoutResultProxy layoutResult2 = TextFieldState.this.getLayoutResult();
                    if (layoutResult2 != null) {
                        TextFieldState textFieldState222222 = TextFieldState.this;
                        TextFieldValue textFieldValue2 = textFieldValue;
                        OffsetMapping offsetMapping222222 = offsetMapping22222;
                        TextInputSession inputSession = textFieldState222222.getInputSession();
                        if (inputSession == null || !textFieldState222222.getHasFocus()) {
                            return;
                        }
                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping222222, layoutResult2);
                    }
                }
            }
        });
        final boolean z1922222 = visualTransformation3 instanceof PasswordVisualTransformation;
        final boolean z2022222 = z5;
        final VisualTransformation visualTransformation722222 = visualTransformation3;
        Modifier semantics22222 = SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                SemanticsPropertiesKt.m5733setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                if (!z1722222) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                if (z1922222) {
                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                }
                final TextFieldState textFieldState222222 = textFieldState22222;
                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(List<TextLayoutResult> list) {
                        boolean z2122222;
                        if (TextFieldState.this.getLayoutResult() != null) {
                            TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                            Intrinsics.checkNotNull(layoutResult);
                            list.add(layoutResult.getValue());
                            z2122222 = true;
                        } else {
                            z2122222 = false;
                        }
                        return Boolean.valueOf(z2122222);
                    }
                }, 1, null);
                final boolean z2122222 = z2022222;
                final boolean z22 = z1722222;
                final TextFieldState textFieldState3 = textFieldState22222;
                SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AnnotatedString annotatedString2) {
                        Unit unit2;
                        if (z2122222 || !z22) {
                            return false;
                        }
                        TextInputSession inputSession = textFieldState3.getInputSession();
                        if (inputSession != null) {
                            TextFieldState textFieldState4 = textFieldState3;
                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState4.getProcessor(), textFieldState4.getOnValueChange(), inputSession);
                            unit2 = Unit.INSTANCE;
                        } else {
                            unit2 = null;
                        }
                        if (unit2 == null) {
                            textFieldState3.getOnValueChange().invoke(new TextFieldValue(annotatedString2.getText(), TextRangeKt.TextRange(annotatedString2.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        }
                        return true;
                    }
                }, 1, null);
                final boolean z23 = z2022222;
                final boolean z24 = z1722222;
                final TextFieldState textFieldState4 = textFieldState22222;
                final TextFieldValue textFieldValue2 = textFieldValue;
                SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AnnotatedString annotatedString2) {
                        Unit unit2;
                        if (z23 || !z24) {
                            return false;
                        }
                        TextInputSession inputSession = textFieldState4.getInputSession();
                        if (inputSession != null) {
                            TextFieldState textFieldState5 = textFieldState4;
                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString2, 1)}), textFieldState5.getProcessor(), textFieldState5.getOnValueChange(), inputSession);
                            unit2 = Unit.INSTANCE;
                        } else {
                            unit2 = null;
                        }
                        if (unit2 == null) {
                            TextFieldValue textFieldValue3 = textFieldValue2;
                            textFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange((CharSequence) textFieldValue3.getText(), TextRange.m5888getStartimpl(textFieldValue3.getSelection()), TextRange.m5883getEndimpl(textFieldValue3.getSelection()), (CharSequence) annotatedString2).toString(), TextRangeKt.TextRange(TextRange.m5888getStartimpl(textFieldValue3.getSelection()) + annotatedString2.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                        }
                        return true;
                    }
                }, 1, null);
                final OffsetMapping offsetMapping222222 = offsetMapping22222;
                final boolean z25 = z1722222;
                final TextFieldValue textFieldValue3 = textFieldValue;
                final TextFieldSelectionManager textFieldSelectionManager222222 = textFieldSelectionManager22222;
                final TextFieldState textFieldState5 = textFieldState22222;
                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                    }

                    public final Boolean invoke(int i3722222, int i3822222, boolean z26) {
                        if (!z26) {
                            i3722222 = OffsetMapping.this.transformedToOriginal(i3722222);
                        }
                        if (!z26) {
                            i3822222 = OffsetMapping.this.transformedToOriginal(i3822222);
                        }
                        boolean z27 = false;
                        if (z25 && (i3722222 != TextRange.m5888getStartimpl(textFieldValue3.getSelection()) || i3822222 != TextRange.m5883getEndimpl(textFieldValue3.getSelection()))) {
                            if (Math.min(i3722222, i3822222) >= 0 && Math.max(i3722222, i3822222) <= textFieldValue3.getAnnotatedString().length()) {
                                if (z26 || i3722222 == i3822222) {
                                    textFieldSelectionManager222222.exitSelectionMode$foundation_release();
                                } else {
                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager222222, false, 1, null);
                                }
                                textFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getAnnotatedString(), TextRangeKt.TextRange(i3722222, i3822222), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                z27 = true;
                            } else {
                                textFieldSelectionManager222222.exitSelectionMode$foundation_release();
                            }
                        }
                        return Boolean.valueOf(z27);
                    }
                }, 1, null);
                int imeAction = imeOptions522222.getImeAction();
                final TextFieldState textFieldState6 = textFieldState22222;
                final ImeOptions imeOptions6 = imeOptions522222;
                SemanticsPropertiesKt.m5729onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m6049boximpl(imeOptions6.getImeAction()));
                        return true;
                    }
                }, 2, null);
                final TextFieldState textFieldState7 = textFieldState22222;
                final FocusRequester focusRequester4 = focusRequester;
                final boolean z26 = z2022222;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        CoreTextFieldKt.tapToFocus(TextFieldState.this, focusRequester4, !z26);
                        return true;
                    }
                }, 1, null);
                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22222;
                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.7
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                        return true;
                    }
                }, 1, null);
                if (!TextRange.m5882getCollapsedimpl(textFieldValue.getSelection()) && !z1922222) {
                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager22222;
                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.8
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                            return true;
                        }
                    }, 1, null);
                    if (z1722222 && !z2022222) {
                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager22222;
                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.9
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.cut$foundation_release();
                                return true;
                            }
                        }, 1, null);
                    }
                }
                if (!z1722222 || z2022222) {
                    return;
                }
                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager22222;
                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldSelectionManager.this.paste$foundation_release();
                        return true;
                    }
                }, 1, null);
            }
        });
        Brush brush422222 = brush3;
        final Modifier cursor22222 = TextFieldCursorKt.cursor(Modifier.INSTANCE, textFieldState22222, textFieldValue, offsetMapping22222, brush422222, (z1722222 || z5 || !isWindowFocusedBehindFlag(windowInfo22222)) ? false : true);
        EffectsKt.DisposableEffect(textFieldSelectionManager22222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                final TextFieldSelectionManager textFieldSelectionManager222222 = TextFieldSelectionManager.this;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
            }
        }, startRestartGroup, 8);
        EffectsKt.DisposableEffect(imeOptions522222, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                if (TextInputService.this != null && textFieldState22222.getHasFocus()) {
                    textFieldState22222.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(TextInputService.this, textFieldValue, textFieldState22222.getProcessor(), imeOptions522222, textFieldState22222.getOnValueChange(), textFieldState22222.getOnImeActionPerformed()));
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, startRestartGroup, (i30 >> 3) & 14);
        Modifier onGloballyPositioned222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier3.then(textFieldFocusModifier22222), textFieldState22222, focusManager22222), textFieldState22222, textFieldSelectionManager22222).then(TextFieldKeyInputKt.m1236textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, textFieldState22222, textFieldSelectionManager22222, textFieldValue, textFieldState22222.getOnValueChange(), !z5, i26 != 1, offsetMapping22222, undoManager, imeOptions522222.getImeAction())), textFieldScrollerPosition22222, mutableInteractionSource522222, z1722222).then(pointerHoverIcon$default22222).then(semantics22222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                TextLayoutResultProxy layoutResult = TextFieldState.this.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
            }
        });
        if (z1722222) {
        }
        if (!z10) {
        }
        Modifier modifier522222 = modifier3;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422222 = function32;
        final boolean z2122222 = z5;
        final int i3722222 = i29;
        final BringIntoViewRequester bringIntoViewRequester322222 = bringIntoViewRequester;
        final int i3822222 = i26;
        final Modifier modifier622222 = companion;
        final TextStyle textStyle722222 = textStyle4;
        CoreTextFieldRootBox(onGloballyPositioned222222, textFieldSelectionManager22222, ComposableLambdaKt.composableLambda(startRestartGroup, -374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
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
                ComposerKt.sourceInformation(composer3, "C642@29093L4568:CoreTextField.kt#423gt5");
                if ((i39 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-374338080, i39, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:642)");
                    }
                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function3422222;
                    final TextFieldState textFieldState222222 = textFieldState22222;
                    final TextStyle textStyle8 = textStyle722222;
                    final int i40 = i3722222;
                    final int i41 = i3822222;
                    final TextFieldScrollerPosition textFieldScrollerPosition222222 = textFieldScrollerPosition22222;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final VisualTransformation visualTransformation8 = visualTransformation722222;
                    final Modifier modifier7 = cursor22222;
                    final Modifier modifier8 = drawBehind22222;
                    final Modifier modifier9 = onGloballyPositioned32222;
                    final Modifier modifier10 = modifier622222;
                    final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester322222;
                    final TextFieldSelectionManager textFieldSelectionManager222222 = textFieldSelectionManager22222;
                    final boolean z22 = z10;
                    final boolean z23 = z2122222;
                    final Function1<? super TextLayoutResult, Unit> function16 = function14;
                    final OffsetMapping offsetMapping222222 = offsetMapping22222;
                    final Density density322222 = density222222;
                    function35.invoke(ComposableLambdaKt.composableLambda(composer3, 2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
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

                        public final void invoke(Composer composer4, int i42) {
                            ComposerKt.sourceInformation(composer4, "C667@30284L3367:CoreTextField.kt#423gt5");
                            if ((i42 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2032502107, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:645)");
                                }
                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldState.this.m1248getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle8, i40, i41);
                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition222222;
                                TextFieldValue textFieldValue3 = textFieldValue2;
                                VisualTransformation visualTransformation9 = visualTransformation8;
                                final TextFieldState textFieldState3 = TextFieldState.this;
                                Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation9, new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final TextLayoutResultProxy invoke() {
                                        return TextFieldState.this.getLayoutResult();
                                    }
                                }).then(modifier7).then(modifier8), textStyle8).then(modifier9).then(modifier10), bringIntoViewRequester4);
                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222222;
                                final TextFieldState textFieldState4 = TextFieldState.this;
                                final boolean z24 = z22;
                                final boolean z25 = z23;
                                final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                final TextFieldValue textFieldValue4 = textFieldValue2;
                                final OffsetMapping offsetMapping3 = offsetMapping222222;
                                final Density density4 = density322222;
                                final int i43 = i41;
                                SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.composableLambda(composer4, -363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i44) {
                                        ComposerKt.sourceInformation(composer5, "C668@30338L2699,721@33055L322,734@33579L40:CoreTextField.kt#423gt5");
                                        if ((i44 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-363167407, i44, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:668)");
                                            }
                                            final TextFieldState textFieldState5 = textFieldState4;
                                            final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                            final TextFieldValue textFieldValue5 = textFieldValue4;
                                            final OffsetMapping offsetMapping4 = offsetMapping3;
                                            final Density density5 = density4;
                                            final int i45 = i43;
                                            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                /* renamed from: measure-3p2s80s */
                                                public MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                    Snapshot.Companion companion2 = Snapshot.INSTANCE;
                                                    TextFieldState textFieldState6 = TextFieldState.this;
                                                    Snapshot createNonObservableSnapshot = companion2.createNonObservableSnapshot();
                                                    try {
                                                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                                                        try {
                                                            TextLayoutResultProxy layoutResult = textFieldState6.getLayoutResult();
                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                            createNonObservableSnapshot.dispose();
                                                            Triple<Integer, Integer, TextLayoutResult> m1228layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m1228layout_EkL_Y$foundation_release(TextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                            int intValue = m1228layout_EkL_Y$foundation_release.component1().intValue();
                                                            int intValue2 = m1228layout_EkL_Y$foundation_release.component2().intValue();
                                                            TextLayoutResult component3 = m1228layout_EkL_Y$foundation_release.component3();
                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                TextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3));
                                                                function18.invoke(component3);
                                                                CoreTextFieldKt.notifyFocusedRect(TextFieldState.this, textFieldValue5, offsetMapping4);
                                                            }
                                                            TextFieldState.this.m1249setMinHeightForSingleLineField0680j_4(density5.mo627toDpu2uoSUM(i45 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                    invoke2(placementScope);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        } finally {
                                                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                                                        }
                                                    } catch (Throwable th) {
                                                        createNonObservableSnapshot.dispose();
                                                        throw th;
                                                    }
                                                }

                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i46) {
                                                    TextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                    return TextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                }
                                            };
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            boolean z26 = false;
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                            Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, 1017247175, "C:CoreTextField.kt#423gt5");
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endReplaceableGroup();
                                            composer5.endNode();
                                            composer5.endReplaceableGroup();
                                            TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                            if (textFieldState4.getHandleState() != HandleState.None && textFieldState4.getLayoutCoordinates() != null) {
                                                LayoutCoordinates layoutCoordinates = textFieldState4.getLayoutCoordinates();
                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                if (layoutCoordinates.isAttached() && z24) {
                                                    z26 = true;
                                                }
                                            }
                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z26, composer5, 8);
                                            if (textFieldState4.getHandleState() == HandleState.Cursor && !z25 && z24) {
                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 8);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, 48, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 448);
        if (ComposerKt.isTraceInProgress()) {
        }
        i31 = i3822222;
        composer2 = startRestartGroup;
        z11 = z2122222;
        function15 = function14;
        modifier4 = modifier522222;
        mutableInteractionSource4 = mutableInteractionSource522222;
        solidColor = brush422222;
        keyboardActions3 = keyboardActions422222;
        visualTransformation4 = visualTransformation722222;
        i32 = i29;
        z12 = z1722222;
        imeOptions4 = imeOptions522222;
        z13 = z9;
        textStyle5 = textStyle4;
        function33 = function3422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)747@33825L95:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:746)");
        }
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1087268488, "C748@33881L33:CoreTextField.kt#423gt5");
        startRestartGroup.startReplaceableGroup(-1985516685);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ContextMenuArea)P(1)29@1062L9:ContextMenu.android.kt#423gt5");
        function2.invoke(startRestartGroup, Integer.valueOf(((((i >> 3) & 112) | 8) >> 3) & 14));
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
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

                public final void invoke(Composer composer2, int i2) {
                    CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final TextFieldState textFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1174invokeZmokQxo(keyEvent.m5060unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1174invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (TextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1176cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1373deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (keyboardController = textFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        textFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m5885getMaximpl(textFieldValue.getSelection()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, IntSize.m6558getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)1101@48248L202:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1082)");
        }
        if (z) {
            TextFieldState state = textFieldSelectionManager.getState();
            TextLayoutResult textLayoutResult = null;
            if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                TextFieldState state2 = textFieldSelectionManager.getState();
                if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m5882getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5888getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m5883getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498386756);
                    ComposerKt.sourceInformation(startRestartGroup, "1094@47925L203");
                    TextFieldState state3 = textFieldSelectionManager.getState();
                    if (state3 != null && state3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state4 = textFieldSelectionManager.getState();
                    if (state4 != null && state4.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state5 = textFieldSelectionManager.getState();
                if (state5 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state5.setShowFloatingToolbar(false);
                    }
                    if (state5.getHasFocus()) {
                        if (state5.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
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
                    CoreTextFieldKt.SelectionToolbarAndHandles(TextFieldSelectionManager.this, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        AnnotatedString transformedText$foundation_release;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)1127@49342L50,1128@49455L7,1129@49472L1101:CoreTextField.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1125)");
        }
        TextFieldState state = textFieldSelectionManager.getState();
        if (state != null && state.getShowCursorHandle() && (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) != null && transformedText$foundation_release.length() > 0) {
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final long m1379getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m1379getCursorPositiontuRUvjQ$foundation_release((Density) consume);
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, textDragObserver, new CoreTextFieldKt$TextFieldCursorHandle$1(textDragObserver, textFieldSelectionManager, null));
            startRestartGroup.startReplaceableGroup(294220498);
            boolean changed2 = startRestartGroup.changed(m1379getCursorPositiontuRUvjQ$foundation_release);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, m1379getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m1152CursorHandleULxng0E(m1379getCursorPositiontuRUvjQ$foundation_release, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue2, 1, null), null, startRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3
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
                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot createNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                if (layoutResult == null) {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    return;
                }
                TextInputSession inputSession = textFieldState.getInputSession();
                if (inputSession == null) {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    return;
                }
                LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    return;
                }
                TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, textFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            } catch (Throwable th) {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                throw th;
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
