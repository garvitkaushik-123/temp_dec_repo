package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.foundation.text2.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010Z\u001a\u00020[H\u0002J\u0010\u0010\\\u001a\u00020[2\b\b\u0002\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020[J\u0006\u0010_\u001a\u00020[J\u0006\u0010`\u001a\u00020[J\b\u0010a\u001a\u00020\u001eH\u0002J\u001d\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\tH\u0002J<\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020:2\u0006\u0010j\u001a\u00020:2\b\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020mH\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\b\u0010p\u001a\u00020[H\u0002J\b\u0010q\u001a\u00020[H\u0002J\u000e\u0010r\u001a\u00020[H\u0086@¢\u0006\u0002\u0010sJ\u000e\u0010t\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u000e\u0010u\u001a\u00020[H\u0082@¢\u0006\u0002\u0010sJ\u0006\u0010v\u001a\u00020[J\u0010\u0010w\u001a\u00020[2\u0006\u0010x\u001a\u00020\u001eH\u0002J6\u0010y\u001a\u00020[2\u0006\u00102\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\"\u0010z\u001a\u00020[2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~JN\u0010\u007f\u001a\u00020h2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020:2\u0007\u0010\u0083\u0001\u001a\u00020:2\u0006\u0010c\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0087\u0001\u001a\u00020[2\u0006\u0010T\u001a\u00020SJ\u0015\u0010\u0088\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u0015\u0010\u008b\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u008c\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u008d\u0001J%\u0010\u008e\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0091\u0001J5\u0010\u0092\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020[*\u00030\u0089\u0001H\u0082@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u0096\u0001\u001a\u00020[*\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u008d\u0001J5\u0010\u0097\u0001\u001a\u00020[*\u00030\u0089\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u00012\u000e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020[0\u0090\u0001H\u0086@¢\u0006\u0003\u0010\u0094\u0001R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b.\u0010\u0016R\u0017\u00100\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u0010\u0012R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b4\u00105R+\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010*\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u00105R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010=\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bA\u0010*\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010@R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010B\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u00105R1\u0010F\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00108B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bI\u0010*\u001a\u0004\bG\u0010\u0012\"\u0004\bH\u0010@R\u001b\u0010J\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0018\u001a\u0004\bK\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010T\u001a\u00020S2\u0006\u0010\"\u001a\u00020S8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0098\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "(Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentContentVisibleOffset", "Landroidx/compose/ui/geometry/Offset;", "getCurrentContentVisibleOffset-F1C5BW0", "()J", "cursorHandle", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "getCursorHandle", "()Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "cursorHandle$delegate", "Landroidx/compose/runtime/State;", "cursorHandleInBounds", "getCursorHandleInBounds", "()Z", "cursorHandleInBounds$delegate", "cursorRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "cursorRect$delegate", "<set-?>", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/runtime/MutableState;", "editable", "getEditable", "endSelectionHandle", "getEndSelectionHandle", "endSelectionHandle$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startContentVisibleOffset", "getStartContentVisibleOffset-F1C5BW0", "setStartContentVisibleOffset-k-4lQ0M", "startContentVisibleOffset$delegate", "startSelectionHandle", "getStartSelectionHandle", "startSelectionHandle$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text2/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "markStartContentVisibleOffset", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", C3040d4.h.L, "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "updateSelection-QNhciaU", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldLongPressAndAfterDrag", "requestFocus", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldGestures", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private SelectionLayout previousSelectionLayout;
    private boolean readOnly;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);

    /* renamed from: startContentVisibleOffset$delegate, reason: from kotlin metadata */
    private final MutableState startContentVisibleOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3811boximpl(Offset.INSTANCE.m3837getUnspecifiedF1C5BW0()), null, 2, null);

    /* renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3811boximpl(Offset.INSTANCE.m3837getUnspecifiedF1C5BW0()), null, 2, null);

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
    private int previousRawDragOffset = -1;

    /* renamed from: cursorHandle$delegate, reason: from kotlin metadata */
    private final State cursorHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
        
            if (r0 != false) goto L12;
         */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TextFieldHandleState invoke() {
            TransformedTextFieldState transformedTextFieldState;
            boolean showCursorHandle;
            boolean cursorHandleInBounds;
            transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
            TextFieldCharSequence text = transformedTextFieldState.getText();
            showCursorHandle = TextFieldSelectionState.this.getShowCursorHandle();
            if (showCursorHandle && TextRange.m5882getCollapsedimpl(text.getSelectionInChars()) && text.length() > 0) {
                if (TextFieldSelectionState.this.getDraggingHandle() != Handle.Cursor) {
                    cursorHandleInBounds = TextFieldSelectionState.this.getCursorHandleInBounds();
                }
                return new TextFieldHandleState(true, TextFieldSelectionState.this.getCursorRect().m3849getBottomCenterF1C5BW0(), ResolvedTextDirection.Ltr, false, null);
            }
            return TextFieldHandleState.INSTANCE.getHidden();
        }
    });

    /* renamed from: cursorHandleInBounds$delegate, reason: from kotlin metadata */
    private final State cursorHandleInBounds = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorHandleInBounds$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            LayoutCoordinates textLayoutCoordinates;
            Rect visibleBounds;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    long m3849getBottomCenterF1C5BW0 = textFieldSelectionState.getCursorRect().m3849getBottomCenterF1C5BW0();
                    createNonObservableSnapshot.dispose();
                    textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                    return Boolean.valueOf((textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1358containsInclusiveUv8p0NA(visibleBounds, m3849getBottomCenterF1C5BW0));
                } finally {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                }
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
    });

    /* renamed from: cursorRect$delegate, reason: from kotlin metadata */
    private final State cursorRect = SnapshotStateKt.derivedStateOf(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$cursorRect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Rect invoke() {
            TextLayoutState textLayoutState;
            TransformedTextFieldState transformedTextFieldState;
            Density density;
            float right;
            textLayoutState = TextFieldSelectionState.this.textLayoutState;
            TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
            if (layoutResult == null) {
                return Rect.INSTANCE.getZero();
            }
            transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
            TextFieldCharSequence text = transformedTextFieldState.getText();
            if (!TextRange.m5882getCollapsedimpl(text.getSelectionInChars())) {
                return Rect.INSTANCE.getZero();
            }
            Rect cursorRect = layoutResult.getCursorRect(TextRange.m5888getStartimpl(text.getSelectionInChars()));
            density = TextFieldSelectionState.this.density;
            float mo630toPx0680j_4 = density.mo630toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
            if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                right = cursorRect.getLeft() + (mo630toPx0680j_4 / 2);
            } else {
                right = cursorRect.getRight() - (mo630toPx0680j_4 / 2);
            }
            float f = mo630toPx0680j_4 / 2;
            float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, IntSize.m6559getWidthimpl(layoutResult.getSize()) - f), f);
            return new Rect(coerceAtLeast - f, cursorRect.getTop(), coerceAtLeast + f, cursorRect.getBottom());
        }
    });

    /* renamed from: startSelectionHandle$delegate, reason: from kotlin metadata */
    private final State startSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$startSelectionHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            TextFieldHandleState selectionHandleState;
            selectionHandleState = TextFieldSelectionState.this.getSelectionHandleState(true);
            return selectionHandleState;
        }
    });

    /* renamed from: endSelectionHandle$delegate, reason: from kotlin metadata */
    private final State endSelectionHandle = SnapshotStateKt.derivedStateOf(new Function0<TextFieldHandleState>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$endSelectionHandle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextFieldHandleState invoke() {
            TextFieldHandleState selectionHandleState;
            selectionHandleState = TextFieldSelectionState.this.getSelectionHandleState(false);
            return selectionHandleState;
        }
    });

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1500getStartContentVisibleOffsetF1C5BW0() {
        return ((Offset) this.startContentVisibleOffset.getValue()).getPackedValue();
    }

    /* renamed from: setStartContentVisibleOffset-k-4lQ0M, reason: not valid java name */
    private final void m1503setStartContentVisibleOffsetk4lQ0M(long j) {
        this.startContentVisibleOffset.setValue(Offset.m3811boximpl(j));
    }

    /* renamed from: getCurrentContentVisibleOffset-F1C5BW0, reason: not valid java name */
    private final long m1497getCurrentContentVisibleOffsetF1C5BW0() {
        Rect visibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3837getUnspecifiedF1C5BW0() : visibleBounds.m3857getTopLeftF1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1499getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).getPackedValue();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1502setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition.setValue(Offset.m3811boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1507getHandleDragPositionF1C5BW0() {
        if (OffsetKt.m3843isUnspecifiedk4lQ0M(m1499getRawHandleDragPositionF1C5BW0())) {
            return Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
        }
        if (OffsetKt.m3843isUnspecifiedk4lQ0M(m1500getStartContentVisibleOffsetF1C5BW0())) {
            return TextLayoutStateKt.m1465fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1499getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3826minusMKHz9U(Offset.m3827plusMKHz9U(m1499getRawHandleDragPositionF1C5BW0(), m1497getCurrentContentVisibleOffsetF1C5BW0()), m1500getStartContentVisibleOffsetF1C5BW0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandle() {
        return (TextFieldHandleState) this.cursorHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getCursorHandleInBounds() {
        return ((Boolean) this.cursorHandleInBounds.getValue()).booleanValue();
    }

    public final Rect getCursorRect() {
        return (Rect) this.cursorRect.getValue();
    }

    public final TextFieldHandleState getStartSelectionHandle() {
        return (TextFieldHandleState) this.startSelectionHandle.getValue();
    }

    public final TextFieldHandleState getEndSelectionHandle() {
        return (TextFieldHandleState) this.endSelectionHandle.getValue();
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object textFieldGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$textFieldGestures$2(this, pointerInputScope, function0, function02, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object observeChanges(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$observeChanges$1 textFieldSelectionState$observeChanges$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof TextFieldSelectionState$observeChanges$1) {
            textFieldSelectionState$observeChanges$1 = (TextFieldSelectionState$observeChanges$1) continuation;
            if ((textFieldSelectionState$observeChanges$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$observeChanges$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$observeChanges$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$observeChanges$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        TextFieldSelectionState$observeChanges$2 textFieldSelectionState$observeChanges$2 = new TextFieldSelectionState$observeChanges$2(this, null);
                        textFieldSelectionState$observeChanges$1.L$0 = this;
                        textFieldSelectionState$observeChanges$1.label = 1;
                        if (CoroutineScopeKt.coroutineScope(textFieldSelectionState$observeChanges$2, textFieldSelectionState$observeChanges$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                    } catch (Throwable th) {
                        th = th;
                        textFieldSelectionState = this;
                        textFieldSelectionState.setShowCursorHandle(false);
                        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                            textFieldSelectionState.hideTextToolbar();
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$observeChanges$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        textFieldSelectionState.setShowCursorHandle(false);
                        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        }
                        throw th;
                    }
                }
                textFieldSelectionState.setShowCursorHandle(false);
                if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                    textFieldSelectionState.hideTextToolbar();
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$observeChanges$1 = new TextFieldSelectionState$observeChanges$1(this, continuation);
        Object obj2 = textFieldSelectionState$observeChanges$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$observeChanges$1.label;
        if (i != 0) {
        }
        textFieldSelectionState.setShowCursorHandle(false);
        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
        }
        return Unit.INSTANCE;
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndDoubleTap = TapAndDoubleTapGestureKt.detectTapAndDoubleTap(pointerInputScope, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1480onEventk4lQ0M(long j) {
                boolean editable;
                TransformedTextFieldState transformedTextFieldState;
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState2;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                editable = this.getEditable();
                if (editable && this.getIsFocused()) {
                    function02.invoke();
                    transformedTextFieldState = this.textFieldState;
                    if (transformedTextFieldState.getText().length() > 0) {
                        this.setShowCursorHandle(true);
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    textLayoutState = this.textLayoutState;
                    int m1458getOffsetForPosition3MmeM6k$default = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState, j, false, 2, null);
                    if (m1458getOffsetForPosition3MmeM6k$default >= 0) {
                        transformedTextFieldState2 = this.textFieldState;
                        transformedTextFieldState2.placeCursorBeforeCharAt(m1458getOffsetForPosition3MmeM6k$default);
                    }
                }
            }
        }, new TapOnPosition() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3
            @Override // androidx.compose.foundation.text2.input.internal.selection.TapOnPosition
            /* renamed from: onEvent-k-4lQ0M */
            public final void mo1480onEventk4lQ0M(long j) {
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState;
                TransformedTextFieldState transformedTextFieldState2;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDoubleTapTextField";
                    }
                });
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                textLayoutState = TextFieldSelectionState.this.textLayoutState;
                int m1458getOffsetForPosition3MmeM6k$default = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState, j, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                transformedTextFieldState = textFieldSelectionState.textFieldState;
                long m1506updateSelectionQNhciaU$default = TextFieldSelectionState.m1506updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1405TextFieldCharSequence3r_uNRQ$default(transformedTextFieldState.getText(), TextRange.INSTANCE.m5893getZerod9O1mEE(), null, 4, null), m1458getOffsetForPosition3MmeM6k$default, m1458getOffsetForPosition3MmeM6k$default, false, SelectionAdjustment.INSTANCE.getWord(), false, 32, null);
                transformedTextFieldState2 = TextFieldSelectionState.this.textFieldState;
                transformedTextFieldState2.m1474selectCharsIn5zctL8(m1506updateSelectionQNhciaU$default);
            }
        }, continuation);
        return detectTapAndDoubleTap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndDoubleTap : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        Ref.LongRef longRef;
        Throwable th;
        Ref.LongRef longRef2;
        if (continuation instanceof TextFieldSelectionState$detectCursorHandleDragGestures$1) {
            textFieldSelectionState$detectCursorHandleDragGestures$1 = (TextFieldSelectionState$detectCursorHandleDragGestures$1) continuation;
            if ((textFieldSelectionState$detectCursorHandleDragGestures$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$detectCursorHandleDragGestures$1.label -= Integer.MIN_VALUE;
                TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$12 = textFieldSelectionState$detectCursorHandleDragGestures$1;
                Object obj = textFieldSelectionState$detectCursorHandleDragGestures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$detectCursorHandleDragGestures$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
                    try {
                        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1509invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m1509invokek4lQ0M(long j) {
                                Ref.LongRef.this.element = SelectionHandlesKt.m1321getAdjustedCoordinatesk4lQ0M(this.getCursorRect().m3849getBottomCenterF1C5BW0());
                                longRef4.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                this.setInTouchMode(true);
                                this.markStartContentVisibleOffset();
                                this.m1504updateHandleDraggingUv8p0NA(Handle.Cursor, Ref.LongRef.this.element);
                            }
                        };
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3
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
                                TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(Ref.LongRef.this, longRef4, this);
                            }
                        };
                        Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4
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
                                TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(Ref.LongRef.this, longRef4, this);
                            }
                        };
                        Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                                m1510invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                            public final void m1510invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                                TextLayoutState textLayoutState;
                                TransformedTextFieldState transformedTextFieldState;
                                HapticFeedback hapticFeedback;
                                TransformedTextFieldState transformedTextFieldState2;
                                Ref.LongRef longRef5 = Ref.LongRef.this;
                                longRef5.element = Offset.m3827plusMKHz9U(longRef5.element, j);
                                this.m1504updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m3827plusMKHz9U(longRef3.element, Ref.LongRef.this.element));
                                textLayoutState = this.textLayoutState;
                                TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                long TextRange = TextRangeKt.TextRange(layoutResult.m5860getOffsetForPositionk4lQ0M(this.m1507getHandleDragPositionF1C5BW0()));
                                transformedTextFieldState = this.textFieldState;
                                if (TextRange.m5881equalsimpl0(TextRange, transformedTextFieldState.getText().getSelectionInChars())) {
                                    return;
                                }
                                pointerInputChange.consume();
                                hapticFeedback = this.hapticFeedBack;
                                if (hapticFeedback != null) {
                                    hapticFeedback.mo4734performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4743getTextHandleMove5zf0vsI());
                                }
                                transformedTextFieldState2 = this.textFieldState;
                                transformedTextFieldState2.m1474selectCharsIn5zctL8(TextRange);
                            }
                        };
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$0 = this;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$1 = longRef3;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$2 = longRef4;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.label = 1;
                        if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, textFieldSelectionState$detectCursorHandleDragGestures$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                        longRef = longRef3;
                        longRef2 = longRef4;
                    } catch (Throwable th2) {
                        textFieldSelectionState = this;
                        longRef = longRef3;
                        th = th2;
                        longRef2 = longRef4;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$2;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$1;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$detectCursorHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                        throw th;
                    }
                }
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$detectCursorHandleDragGestures$1 = new TextFieldSelectionState$detectCursorHandleDragGestures$1(this, continuation);
        TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$122 = textFieldSelectionState$detectCursorHandleDragGestures$1;
        Object obj2 = textFieldSelectionState$detectCursorHandleDragGestures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$detectCursorHandleDragGestures$122.label;
        if (i != 0) {
        }
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m3841isSpecifiedk4lQ0M(longRef.element)) {
            longRef.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, androidx.compose.foundation.text.Handle] */
    public final Object detectTextFieldLongPressAndAfterDrag(PointerInputScope pointerInputScope, final Function0<Unit> function0, Continuation<? super Unit> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Handle.SelectionEnd;
        Object detectDragGesturesAfterLongPress = DragGestureDetectorKt.detectDragGesturesAfterLongPress(pointerInputScope, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1513invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1513invokek4lQ0M(final long j) {
                TextLayoutState textLayoutState;
                TransformedTextFieldState transformedTextFieldState;
                TextLayoutState textLayoutState2;
                TransformedTextFieldState transformedTextFieldState2;
                TransformedTextFieldState transformedTextFieldState3;
                TextLayoutState textLayoutState3;
                HapticFeedback hapticFeedback;
                TransformedTextFieldState transformedTextFieldState4;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDragStart after longPress " + ((Object) Offset.m3830toStringimpl(j));
                    }
                });
                function0.invoke();
                this.m1504updateHandleDraggingUv8p0NA(objectRef.element, j);
                longRef.element = j;
                longRef2.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
                this.previousRawDragOffset = -1;
                textLayoutState = this.textLayoutState;
                if (!textLayoutState.m1461isPositionOnTextk4lQ0M(j)) {
                    textLayoutState3 = this.textLayoutState;
                    int m1458getOffsetForPosition3MmeM6k$default = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState3, j, false, 2, null);
                    hapticFeedback = this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo4734performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4743getTextHandleMove5zf0vsI());
                    }
                    transformedTextFieldState4 = this.textFieldState;
                    transformedTextFieldState4.placeCursorBeforeCharAt(m1458getOffsetForPosition3MmeM6k$default);
                    this.setShowCursorHandle(true);
                    this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                transformedTextFieldState = this.textFieldState;
                if (transformedTextFieldState.getText().length() == 0) {
                    return;
                }
                textLayoutState2 = this.textLayoutState;
                int m1458getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState2, j, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = this;
                transformedTextFieldState2 = textFieldSelectionState.textFieldState;
                long m1506updateSelectionQNhciaU$default = TextFieldSelectionState.m1506updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1405TextFieldCharSequence3r_uNRQ$default(transformedTextFieldState2.getText(), TextRange.INSTANCE.m5893getZerod9O1mEE(), null, 4, null), m1458getOffsetForPosition3MmeM6k$default2, m1458getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                transformedTextFieldState3 = this.textFieldState;
                transformedTextFieldState3.m1474selectCharsIn5zctL8(m1506updateSelectionQNhciaU$default);
                this.updateTextToolbarState(TextToolbarState.Selection);
                intRef.element = TextRange.m5888getStartimpl(m1506updateSelectionQNhciaU$default);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$3
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef.this, this, intRef, longRef2);
            }
        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$4
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
                TextFieldSelectionState.detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef.this, this, intRef, longRef2);
            }
        }, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                m1514invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:15:0x00dd  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00fc  */
            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m1514invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                TransformedTextFieldState transformedTextFieldState;
                TextLayoutState textLayoutState;
                int m1460getOffsetForPosition3MmeM6k;
                TextLayoutState textLayoutState2;
                int m1460getOffsetForPosition3MmeM6k2;
                SelectionAdjustment word;
                TransformedTextFieldState transformedTextFieldState2;
                long selectionInChars;
                TransformedTextFieldState transformedTextFieldState3;
                long m1505updateSelectionQNhciaU;
                TransformedTextFieldState transformedTextFieldState4;
                T t;
                TextLayoutState textLayoutState3;
                TextLayoutState textLayoutState4;
                TextLayoutState textLayoutState5;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                if (transformedTextFieldState.getText().length() == 0) {
                    return;
                }
                Ref.LongRef longRef3 = longRef2;
                longRef3.element = Offset.m3827plusMKHz9U(longRef3.element, j);
                final long m3827plusMKHz9U = Offset.m3827plusMKHz9U(longRef.element, longRef2.element);
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectTextFieldLongPressAndAfterDrag$5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDrag after longPress " + ((Object) Offset.m3830toStringimpl(m3827plusMKHz9U));
                    }
                });
                if (intRef.element < 0) {
                    textLayoutState3 = TextFieldSelectionState.this.textLayoutState;
                    if (!textLayoutState3.m1461isPositionOnTextk4lQ0M(m3827plusMKHz9U)) {
                        textLayoutState4 = TextFieldSelectionState.this.textLayoutState;
                        m1460getOffsetForPosition3MmeM6k = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState4, longRef.element, false, 2, null);
                        textLayoutState5 = TextFieldSelectionState.this.textLayoutState;
                        m1460getOffsetForPosition3MmeM6k2 = TextLayoutState.m1458getOffsetForPosition3MmeM6k$default(textLayoutState5, m3827plusMKHz9U, false, 2, null);
                        if (m1460getOffsetForPosition3MmeM6k == m1460getOffsetForPosition3MmeM6k2) {
                            word = SelectionAdjustment.INSTANCE.getNone();
                        } else {
                            word = SelectionAdjustment.INSTANCE.getWord();
                        }
                        int i = m1460getOffsetForPosition3MmeM6k;
                        int i2 = m1460getOffsetForPosition3MmeM6k2;
                        SelectionAdjustment selectionAdjustment = word;
                        transformedTextFieldState2 = TextFieldSelectionState.this.textFieldState;
                        selectionInChars = transformedTextFieldState2.getText().getSelectionInChars();
                        TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                        transformedTextFieldState3 = textFieldSelectionState.textFieldState;
                        m1505updateSelectionQNhciaU = textFieldSelectionState.m1505updateSelectionQNhciaU(transformedTextFieldState3.getText(), i, i2, false, selectionAdjustment, false);
                        if (TextRange.m5887getReversedimpl(m1505updateSelectionQNhciaU)) {
                            m1505updateSelectionQNhciaU = TextFieldSelectionStateKt.m1516reverse5zctL8(m1505updateSelectionQNhciaU);
                        }
                        if (intRef.element == -1 && !TextRange.m5882getCollapsedimpl(m1505updateSelectionQNhciaU)) {
                            intRef.element = TextRange.m5888getStartimpl(m1505updateSelectionQNhciaU);
                        }
                        if (!TextRange.m5881equalsimpl0(m1505updateSelectionQNhciaU, selectionInChars)) {
                            Ref.ObjectRef<Handle> objectRef2 = objectRef;
                            if (TextRange.m5888getStartimpl(m1505updateSelectionQNhciaU) != TextRange.m5888getStartimpl(selectionInChars) && TextRange.m5883getEndimpl(m1505updateSelectionQNhciaU) == TextRange.m5883getEndimpl(selectionInChars)) {
                                t = Handle.SelectionStart;
                            } else if (TextRange.m5888getStartimpl(m1505updateSelectionQNhciaU) == TextRange.m5888getStartimpl(selectionInChars) && TextRange.m5883getEndimpl(m1505updateSelectionQNhciaU) != TextRange.m5883getEndimpl(selectionInChars)) {
                                t = Handle.SelectionEnd;
                            } else if ((TextRange.m5888getStartimpl(m1505updateSelectionQNhciaU) + TextRange.m5883getEndimpl(m1505updateSelectionQNhciaU)) / 2.0f > (TextRange.m5888getStartimpl(selectionInChars) + TextRange.m5883getEndimpl(selectionInChars)) / 2.0f) {
                                t = Handle.SelectionEnd;
                            } else {
                                t = Handle.SelectionStart;
                            }
                            objectRef2.element = t;
                        }
                        if (!TextRange.m5882getCollapsedimpl(selectionInChars) || !TextRange.m5882getCollapsedimpl(m1505updateSelectionQNhciaU)) {
                            transformedTextFieldState4 = TextFieldSelectionState.this.textFieldState;
                            transformedTextFieldState4.m1474selectCharsIn5zctL8(m1505updateSelectionQNhciaU);
                        }
                        TextFieldSelectionState.this.m1504updateHandleDraggingUv8p0NA(objectRef.element, m3827plusMKHz9U);
                    }
                }
                Integer valueOf = Integer.valueOf(intRef.element);
                if (valueOf.intValue() < 0) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    m1460getOffsetForPosition3MmeM6k = valueOf.intValue();
                } else {
                    textLayoutState = TextFieldSelectionState.this.textLayoutState;
                    m1460getOffsetForPosition3MmeM6k = textLayoutState.m1460getOffsetForPosition3MmeM6k(longRef.element, false);
                }
                textLayoutState2 = TextFieldSelectionState.this.textLayoutState;
                m1460getOffsetForPosition3MmeM6k2 = textLayoutState2.m1460getOffsetForPosition3MmeM6k(m3827plusMKHz9U, false);
                if (intRef.element >= 0 || m1460getOffsetForPosition3MmeM6k != m1460getOffsetForPosition3MmeM6k2) {
                    word = SelectionAdjustment.INSTANCE.getWord();
                    int i3 = m1460getOffsetForPosition3MmeM6k;
                    int i22 = m1460getOffsetForPosition3MmeM6k2;
                    SelectionAdjustment selectionAdjustment2 = word;
                    transformedTextFieldState2 = TextFieldSelectionState.this.textFieldState;
                    selectionInChars = transformedTextFieldState2.getText().getSelectionInChars();
                    TextFieldSelectionState textFieldSelectionState2 = TextFieldSelectionState.this;
                    transformedTextFieldState3 = textFieldSelectionState2.textFieldState;
                    m1505updateSelectionQNhciaU = textFieldSelectionState2.m1505updateSelectionQNhciaU(transformedTextFieldState3.getText(), i3, i22, false, selectionAdjustment2, false);
                    if (TextRange.m5887getReversedimpl(m1505updateSelectionQNhciaU)) {
                    }
                    if (intRef.element == -1) {
                        intRef.element = TextRange.m5888getStartimpl(m1505updateSelectionQNhciaU);
                    }
                    if (!TextRange.m5881equalsimpl0(m1505updateSelectionQNhciaU, selectionInChars)) {
                    }
                    if (!TextRange.m5882getCollapsedimpl(selectionInChars)) {
                    }
                    transformedTextFieldState4 = TextFieldSelectionState.this.textFieldState;
                    transformedTextFieldState4.m1474selectCharsIn5zctL8(m1505updateSelectionQNhciaU);
                    TextFieldSelectionState.this.m1504updateHandleDraggingUv8p0NA(objectRef.element, m3827plusMKHz9U);
                }
            }
        }, continuation);
        return detectDragGesturesAfterLongPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGesturesAfterLongPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectTextFieldLongPressAndAfterDrag$onDragStop$1(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.IntRef intRef, Ref.LongRef longRef2) {
        if (OffsetKt.m3841isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            intRef.element = -1;
            longRef.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, final boolean z, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$1;
        int i;
        final TextFieldSelectionState textFieldSelectionState;
        final Handle handle;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        if (continuation instanceof TextFieldSelectionState$detectSelectionHandleDragGestures$1) {
            textFieldSelectionState$detectSelectionHandleDragGestures$1 = (TextFieldSelectionState$detectSelectionHandleDragGestures$1) continuation;
            if ((textFieldSelectionState$detectSelectionHandleDragGestures$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$detectSelectionHandleDragGestures$1.label -= Integer.MIN_VALUE;
                TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$12 = textFieldSelectionState$detectSelectionHandleDragGestures$1;
                Object obj = textFieldSelectionState$detectSelectionHandleDragGestures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$detectSelectionHandleDragGestures$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    final Handle handle2 = z ? Handle.SelectionStart : Handle.SelectionEnd;
                    try {
                        try {
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1511invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m1511invokek4lQ0M(long j) {
                                    long m1498getHandlePositiontuRUvjQ;
                                    Ref.LongRef longRef5 = Ref.LongRef.this;
                                    m1498getHandlePositiontuRUvjQ = this.m1498getHandlePositiontuRUvjQ(z);
                                    longRef5.element = SelectionHandlesKt.m1321getAdjustedCoordinatesk4lQ0M(m1498getHandlePositiontuRUvjQ);
                                    this.m1504updateHandleDraggingUv8p0NA(handle2, Ref.LongRef.this.element);
                                    longRef4.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                    this.previousRawDragOffset = -1;
                                }
                            };
                            handle2 = handle2;
                            longRef3 = longRef3;
                            Function1<Offset, Unit> function12 = function1;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3
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
                                    TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4
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
                                    TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            try {
                                Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                                        m1512invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                                    public final void m1512invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                                        TextLayoutState textLayoutState;
                                        TransformedTextFieldState transformedTextFieldState;
                                        int m5888getStartimpl;
                                        int m5860getOffsetForPositionk4lQ0M;
                                        TransformedTextFieldState transformedTextFieldState2;
                                        TransformedTextFieldState transformedTextFieldState3;
                                        TransformedTextFieldState transformedTextFieldState4;
                                        TransformedTextFieldState transformedTextFieldState5;
                                        Ref.LongRef longRef5 = Ref.LongRef.this;
                                        longRef5.element = Offset.m3827plusMKHz9U(longRef5.element, j);
                                        textLayoutState = this.textLayoutState;
                                        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
                                        if (layoutResult == null) {
                                            return;
                                        }
                                        this.m1504updateHandleDraggingUv8p0NA(handle2, Offset.m3827plusMKHz9U(longRef3.element, Ref.LongRef.this.element));
                                        if (!z) {
                                            transformedTextFieldState = this.textFieldState;
                                            m5888getStartimpl = TextRange.m5888getStartimpl(transformedTextFieldState.getText().getSelectionInChars());
                                        } else {
                                            m5888getStartimpl = layoutResult.m5860getOffsetForPositionk4lQ0M(this.m1507getHandleDragPositionF1C5BW0());
                                        }
                                        int i2 = m5888getStartimpl;
                                        if (z) {
                                            transformedTextFieldState5 = this.textFieldState;
                                            m5860getOffsetForPositionk4lQ0M = TextRange.m5883getEndimpl(transformedTextFieldState5.getText().getSelectionInChars());
                                        } else {
                                            m5860getOffsetForPositionk4lQ0M = layoutResult.m5860getOffsetForPositionk4lQ0M(this.m1507getHandleDragPositionF1C5BW0());
                                        }
                                        int i3 = m5860getOffsetForPositionk4lQ0M;
                                        transformedTextFieldState2 = this.textFieldState;
                                        long selectionInChars = transformedTextFieldState2.getText().getSelectionInChars();
                                        TextFieldSelectionState textFieldSelectionState2 = this;
                                        transformedTextFieldState3 = textFieldSelectionState2.textFieldState;
                                        long m1506updateSelectionQNhciaU$default = TextFieldSelectionState.m1506updateSelectionQNhciaU$default(textFieldSelectionState2, transformedTextFieldState3.getText(), i2, i3, z, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), false, 32, null);
                                        if (TextRange.m5882getCollapsedimpl(selectionInChars) || !TextRange.m5882getCollapsedimpl(m1506updateSelectionQNhciaU$default)) {
                                            transformedTextFieldState4 = this.textFieldState;
                                            transformedTextFieldState4.m1474selectCharsIn5zctL8(m1506updateSelectionQNhciaU$default);
                                        }
                                    }
                                };
                                longRef4 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0 = this;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1 = longRef3;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$3 = handle2;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.label = 1;
                                if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function12, function0, function02, function2, textFieldSelectionState$detectSelectionHandleDragGestures$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                textFieldSelectionState = this;
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                            } catch (Throwable th) {
                                th = th;
                                longRef4 = longRef4;
                                textFieldSelectionState = this;
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                                    }
                                });
                                if (textFieldSelectionState.getDraggingHandle() == handle) {
                                    detectSelectionHandleDragGestures$onDragStop$2(longRef, textFieldSelectionState, longRef2);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            handle2 = handle2;
                            longRef3 = longRef3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    handle = (Handle) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$3;
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                            }
                        });
                        if (textFieldSelectionState.getDraggingHandle() == handle) {
                        }
                        throw th;
                    }
                }
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                    }
                });
                if (textFieldSelectionState.getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop$2(longRef, textFieldSelectionState, longRef2);
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$detectSelectionHandleDragGestures$1 = new TextFieldSelectionState$detectSelectionHandleDragGestures$1(this, continuation);
        TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$122 = textFieldSelectionState$detectSelectionHandleDragGestures$1;
        Object obj2 = textFieldSelectionState$detectSelectionHandleDragGestures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$detectSelectionHandleDragGestures$122.label;
        if (i != 0) {
        }
        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
            }
        });
        if (textFieldSelectionState.getDraggingHandle() == handle) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if (OffsetKt.m3841isSpecifiedk4lQ0M(longRef.element)) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                TransformedTextFieldState transformedTextFieldState;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                return transformedTextFieldState.getText();
            }
        }), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            
                if (r0 == null) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
            
                r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
            
                if (r0 == null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
            
                r2 = r6.this$0.getTextLayoutCoordinates();
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
            
                if (r2 == null) goto L21;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
            
                r2 = androidx.compose.ui.geometry.Offset.m3811boximpl(r2.mo5342localToRootMKHz9U(r0.m3857getTopLeftF1C5BW0()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
            
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
                r0 = androidx.compose.ui.geometry.RectKt.m3862Recttz77jQw(r2.getPackedValue(), r0.m3855getSizeNHjbRc());
                r2 = r6.this$0.getContentRect();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
            
                if (r0.overlaps(r2) == false) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
            
                r1 = r2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
            
                if (r1 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
            
                r0 = r1.intersect(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
            
                if (r0 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
            
                r2 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0028, code lost:
            
                if (r0 == androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Selection) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
            
                if (r1 != androidx.compose.foundation.text2.input.internal.selection.TextToolbarState.Cursor) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
            
                if (r6.this$0.getDraggingHandle() != null) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
            
                if (r6.this$0.isInTouchMode() == false) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
            
                r0 = r6.this$0.getTextLayoutCoordinates();
                r1 = null;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Rect invoke() {
                TransformedTextFieldState transformedTextFieldState;
                TextToolbarState textToolbarState;
                TextToolbarState textToolbarState2;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                boolean m5882getCollapsedimpl = TextRange.m5882getCollapsedimpl(transformedTextFieldState.getText().getSelectionInChars());
                if (m5882getCollapsedimpl) {
                    textToolbarState2 = TextFieldSelectionState.this.getTextToolbarState();
                }
                if (!m5882getCollapsedimpl) {
                    textToolbarState = TextFieldSelectionState.this.getTextToolbarState();
                }
                return Rect.INSTANCE.getZero();
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                if (Intrinsics.areEqual(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5882getCollapsedimpl(text.getSelectionInChars())) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m3862Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo5342localToRootMKHz9U(getCursorRect().m3857getTopLeftF1C5BW0()) : Offset.INSTANCE.m3838getZeroF1C5BW0(), getCursorRect().m3855getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long mo5342localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5342localToRootMKHz9U(m1498getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m3838getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long mo5342localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5342localToRootMKHz9U(m1498getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m3838getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Offset.m3823getYimpl(textLayoutCoordinates4.mo5342localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m5888getStartimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Offset.m3823getYimpl(textLayoutCoordinates5.mo5342localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m5883getEndimpl(text.getSelectionInChars()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3822getXimpl(mo5342localToRootMKHz9U), Offset.m3822getXimpl(mo5342localToRootMKHz9U2)), Math.min(f, f2), Math.max(Offset.m3822getXimpl(mo5342localToRootMKHz9U), Offset.m3822getXimpl(mo5342localToRootMKHz9U2)), Math.max(Offset.m3823getYimpl(mo5342localToRootMKHz9U), Offset.m3823getYimpl(mo5342localToRootMKHz9U2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextFieldHandleState getSelectionHandleState(boolean isStartHandle) {
        Rect visibleBounds;
        Rect visibleBounds2;
        Handle handle = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        if (TextRange.m5882getCollapsedimpl(selectionInChars)) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        long m1498getHandlePositiontuRUvjQ = m1498getHandlePositiontuRUvjQ(isStartHandle);
        if (getDraggingHandle() != handle) {
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (!((textLayoutCoordinates == null || (visibleBounds2 = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? false : SelectionManagerKt.m1358containsInclusiveUv8p0NA(visibleBounds2, m1498getHandlePositiontuRUvjQ))) {
                return TextFieldHandleState.INSTANCE.getHidden();
            }
        }
        ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(isStartHandle ? TextRange.m5888getStartimpl(selectionInChars) : Math.max(TextRange.m5883getEndimpl(selectionInChars) - 1, 0));
        boolean m5887getReversedimpl = TextRange.m5887getReversedimpl(selectionInChars);
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        if (textLayoutCoordinates2 != null && (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
            m1498getHandlePositiontuRUvjQ = TextLayoutStateKt.m1464coerceIn3MmeM6k(m1498getHandlePositiontuRUvjQ, visibleBounds);
        }
        return new TextFieldHandleState(true, m1498getHandlePositiontuRUvjQ, bidiRunDirection, m5887getReversedimpl, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1498getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int m5883getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m3838getZeroF1C5BW0();
        }
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        if (isStartHandle) {
            m5883getEndimpl = TextRange.m5888getStartimpl(selectionInChars);
        } else {
            m5883getEndimpl = TextRange.m5883getEndimpl(selectionInChars);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, m5883getEndimpl, isStartHandle, TextRange.m5887getReversedimpl(selectionInChars));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1504updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1502setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        Rect visibleBounds;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        m1503setStartContentVisibleOffsetk4lQ0M((textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) ? Offset.INSTANCE.m3837getUnspecifiedF1C5BW0() : visibleBounds.m3857getTopLeftF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1502setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m3837getUnspecifiedF1C5BW0());
        m1503setStartContentVisibleOffsetk4lQ0M(Offset.INSTANCE.m3837getUnspecifiedF1C5BW0());
    }

    public final void cut() {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5882getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionState.copy(z);
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence text = this.textFieldState.getText();
        if (TextRange.m5882getCollapsedimpl(text.getSelectionInChars())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(text).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    public final void paste() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (text2 = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTextToolbar(Rect contentRect) {
        ClipboardManager clipboardManager;
        long selectionInChars = this.textFieldState.getText().getSelectionInChars();
        Function0<Unit> function0 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$paste$1
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
                TextFieldSelectionState.this.paste();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function02 = !TextRange.m5882getCollapsedimpl(selectionInChars) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$copy$1
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
                TextFieldSelectionState.copy$default(TextFieldSelectionState.this, false, 1, null);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        } : null;
        Function0<Unit> function03 = (TextRange.m5882getCollapsedimpl(selectionInChars) || !getEditable()) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$cut$1
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
                TextFieldSelectionState.this.cut();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
            }
        };
        Function0<Unit> function04 = TextRange.m5884getLengthimpl(selectionInChars) != this.textFieldState.getText().length() ? new Function0<Unit>() { // from class: androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState$showTextToolbar$selectAll$1
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
                TransformedTextFieldState transformedTextFieldState;
                transformedTextFieldState = TextFieldSelectionState.this.textFieldState;
                transformedTextFieldState.selectAll();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
        } : null;
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            textToolbar.showMenu(contentRect, function02, function0, function03, function04);
        }
    }

    public final void deselect() {
        if (!TextRange.m5882getCollapsedimpl(this.textFieldState.getText().getSelectionInChars())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: updateSelection-QNhciaU$default, reason: not valid java name */
    static /* synthetic */ long m1506updateSelectionQNhciaU$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        return textFieldSelectionState.m1505updateSelectionQNhciaU(textFieldCharSequence, i, i2, z, selectionAdjustment, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-QNhciaU, reason: not valid java name */
    public final long m1505updateSelectionQNhciaU(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed) {
        HapticFeedback hapticFeedback;
        TextRange m5876boximpl = TextRange.m5876boximpl(textFieldCharSequence.getSelectionInChars());
        long packedValue = m5876boximpl.getPackedValue();
        if (!allowPreviousSelectionCollapsed && TextRange.m5882getCollapsedimpl(packedValue)) {
            m5876boximpl = null;
        }
        long m1501getTextFieldSelectionqeG_v_k = m1501getTextFieldSelectionqeG_v_k(startOffset, endOffset, m5876boximpl, isStartHandle, adjustment);
        if (!TextRange.m5881equalsimpl0(m1501getTextFieldSelectionqeG_v_k, textFieldCharSequence.getSelectionInChars())) {
            boolean z = TextRange.m5887getReversedimpl(m1501getTextFieldSelectionqeG_v_k) != TextRange.m5887getReversedimpl(textFieldCharSequence.getSelectionInChars()) && TextRange.m5881equalsimpl0(TextRangeKt.TextRange(TextRange.m5883getEndimpl(m1501getTextFieldSelectionqeG_v_k), TextRange.m5888getStartimpl(m1501getTextFieldSelectionqeG_v_k)), textFieldCharSequence.getSelectionInChars());
            if (isInTouchMode() && !z && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo4734performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4743getTextHandleMove5zf0vsI());
            }
        }
        return m1501getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1501getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m5893getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout m1324getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1324getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m5893getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !m1324getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long m1312toTextRanged9O1mEE = adjustment.adjust(m1324getTextFieldSelectionLayoutRcvTLA).m1312toTextRanged9O1mEE();
        this.previousSelectionLayout = m1324getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return m1312toTextRanged9O1mEE;
    }
}
