package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.CodepointTransformation;
import androidx.compose.foundation.text2.input.CodepointTransformationKt;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: TransformedTextFieldState.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u0000 H2\u00020\u0001:\u0002HIB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0013J,\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00130\u001f¢\u0006\u0002\b!H\u0086\bJ\u0013\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u000e\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020%J\u0018\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b-\u0010*J\u001b\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020%ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u000e\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020%J\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000205J\"\u00106\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\b\b\u0002\u00107\u001a\u00020\u001d2\b\b\u0002\u00108\u001a\u000209J*\u0010:\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u0010(\u001a\u00020'2\b\b\u0002\u00108\u001a\u000209ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0006\u0010=\u001a\u00020\u0013J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020'ø\u0001\u0000¢\u0006\u0004\bD\u0010AJ\b\u0010E\u001a\u00020FH\u0016J\u0006\u0010G\u001a\u00020\u0013R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text2/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text2/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "(Landroidx/compose/foundation/text2/input/TextFieldState;Landroidx/compose/foundation/text2/input/InputTransformation;Landroidx/compose/foundation/text2/input/CodepointTransformation;)V", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "transformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "untransformedText", "getUntransformedText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text2/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "notifyImeOfChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "offset", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "(I)J", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-Sb-Bc2M", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text2/input/internal/undo/TextFieldEditUndoBehavior;)V", "selectAll", "selectCharsIn", "transformedRange", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", "Companion", "TransformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformedTextFieldState {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final CodepointTransformation codepointTransformation;
    private final InputTransformation inputTransformation;
    private final TextFieldState textFieldState;
    private final State<TransformedText> transformedText;

    @JvmStatic
    private static final TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation) {
        return Companion.calculateTransformedText(textFieldCharSequence, codepointTransformation);
    }

    @JvmStatic
    /* renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
    private static final long m1467mapFromTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1478mapFromTransformedxdX6G0(j, offsetMappingCalculator);
    }

    @JvmStatic
    /* renamed from: mapToTransformed-xdX6-G0, reason: not valid java name */
    private static final long m1468mapToTransformedxdX6G0(long j, OffsetMappingCalculator offsetMappingCalculator) {
        return Companion.m1479mapToTransformedxdX6G0(j, offsetMappingCalculator);
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, final CodepointTransformation codepointTransformation) {
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.transformedText = codepointTransformation != null ? SnapshotStateKt.derivedStateOf(new Function0<TransformedText>() { // from class: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$transformedText$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TransformedTextFieldState.TransformedText invoke() {
                return TransformedTextFieldState.Companion.calculateTransformedText(TransformedTextFieldState.this.textFieldState.getText(), codepointTransformation);
            }
        }) : null;
    }

    public final TextFieldCharSequence getText() {
        TransformedText value;
        TextFieldCharSequence text;
        State<TransformedText> state = this.transformedText;
        return (state == null || (value = state.getValue()) == null || (text = value.getText()) == null) ? this.textFieldState.getText() : text;
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getText();
    }

    public final void placeCursorBeforeCharAt(int transformedOffset) {
        m1474selectCharsIn5zctL8(TextRangeKt.TextRange(transformedOffset));
    }

    /* renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1474selectCharsIn5zctL8(long transformedRange) {
        m1475selectUntransformedCharsIn5zctL8(m1470mapFromTransformedGEjPoXI(transformedRange));
    }

    /* renamed from: selectUntransformedCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1475selectUntransformedCharsIn5zctL8(long untransformedRange) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().setSelection(TextRange.m5888getStartimpl(untransformedRange), TextRange.m5883getEndimpl(untransformedRange));
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void replaceAll(CharSequence newText) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        EditCommandKt.deleteAll(mainBuffer);
        EditCommandKt.commitText(mainBuffer, newText.toString(), 1);
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void selectAll() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(0, mainBuffer.getLength());
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void deleteSelectedText() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.NeverMerge;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.delete(TextRange.m5886getMinimpl(mainBuffer.m1423getSelectiond9O1mEE()), TextRange.m5885getMaximpl(mainBuffer.m1423getSelectiond9O1mEE()));
        mainBuffer.setSelection(TextRange.m5886getMinimpl(mainBuffer.m1423getSelectiond9O1mEE()), TextRange.m5886getMinimpl(mainBuffer.m1423getSelectiond9O1mEE()));
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* renamed from: replaceText-Sb-Bc2M$default, reason: not valid java name */
    public static /* synthetic */ void m1469replaceTextSbBc2M$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.m1473replaceTextSbBc2M(charSequence, j, textFieldEditUndoBehavior);
    }

    /* renamed from: replaceText-Sb-Bc2M, reason: not valid java name */
    public final void m1473replaceTextSbBc2M(CharSequence newText, long range, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        long m1470mapFromTransformedGEjPoXI = m1470mapFromTransformedGEjPoXI(range);
        mainBuffer.replace(TextRange.m5886getMinimpl(m1470mapFromTransformedGEjPoXI), TextRange.m5885getMaximpl(m1470mapFromTransformedGEjPoXI), newText);
        int m5886getMinimpl = TextRange.m5886getMinimpl(m1470mapFromTransformedGEjPoXI) + newText.length();
        mainBuffer.setSelection(m5886getMinimpl, m5886getMinimpl);
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, undoBehavior);
    }

    public static /* synthetic */ void replaceSelectedText$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, boolean z, TextFieldEditUndoBehavior textFieldEditUndoBehavior, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence, z, textFieldEditUndoBehavior);
    }

    public final void replaceSelectedText(CharSequence newText, boolean clearComposition, TextFieldEditUndoBehavior undoBehavior) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        if (clearComposition) {
            mainBuffer.commitComposition();
        }
        long m1423getSelectiond9O1mEE = mainBuffer.m1423getSelectiond9O1mEE();
        mainBuffer.replace(TextRange.m5886getMinimpl(m1423getSelectiond9O1mEE), TextRange.m5885getMaximpl(m1423getSelectiond9O1mEE), newText);
        int m5886getMinimpl = TextRange.m5886getMinimpl(m1423getSelectiond9O1mEE) + newText.length();
        mainBuffer.setSelection(m5886getMinimpl, m5886getMinimpl);
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, undoBehavior);
    }

    public final void collapseSelectionToMax() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(TextRange.m5885getMaximpl(mainBuffer.m1423getSelectiond9O1mEE()), TextRange.m5885getMaximpl(mainBuffer.m1423getSelectiond9O1mEE()));
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void collapseSelectionToEnd() {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.setSelection(TextRange.m5883getEndimpl(mainBuffer.m1423getSelectiond9O1mEE()), TextRange.m5883getEndimpl(mainBuffer.m1423getSelectiond9O1mEE()));
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, true, textFieldEditUndoBehavior);
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public static /* synthetic */ void editUntransformedTextAsUser$default(TransformedTextFieldState transformedTextFieldState, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        function1.invoke(textFieldState.getMainBuffer());
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, z, textFieldEditUndoBehavior);
    }

    public final void editUntransformedTextAsUser(boolean notifyImeOfChanges, Function1<? super EditingBuffer, Unit> block) {
        TextFieldState textFieldState = this.textFieldState;
        InputTransformation inputTransformation = this.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        block.invoke(textFieldState.getMainBuffer());
        if (textFieldState.getMainBuffer().getChangeTracker().getChangeCount() == 0 && TextRange.m5881equalsimpl0(text.getSelectionInChars(), textFieldState.getMainBuffer().m1423getSelectiond9O1mEE()) && Intrinsics.areEqual(text.getCompositionInChars(), textFieldState.getMainBuffer().m1422getCompositionMzsxiRA())) {
            return;
        }
        textFieldState.commitEditAsUser(text, inputTransformation, notifyImeOfChanges, textFieldEditUndoBehavior);
    }

    /* renamed from: mapToTransformed--jx7JFs, reason: not valid java name */
    public final long m1471mapToTransformedjx7JFs(int offset) {
        TransformedText value;
        OffsetMappingCalculator offsetMapping;
        State<TransformedText> state = this.transformedText;
        if (state == null || (value = state.getValue()) == null || (offsetMapping = value.getOffsetMapping()) == null) {
            return TextRangeKt.TextRange(offset);
        }
        return offsetMapping.m1428mapFromSourcejx7JFs(offset);
    }

    /* renamed from: mapToTransformed-GEjPoXI, reason: not valid java name */
    public final long m1472mapToTransformedGEjPoXI(long range) {
        TransformedText value;
        OffsetMappingCalculator offsetMapping;
        State<TransformedText> state = this.transformedText;
        return (state == null || (value = state.getValue()) == null || (offsetMapping = value.getOffsetMapping()) == null) ? range : Companion.m1479mapToTransformedxdX6G0(range, offsetMapping);
    }

    public final int mapFromTransformed(int offset) {
        TransformedText value;
        OffsetMappingCalculator offsetMapping;
        State<TransformedText> state = this.transformedText;
        return (state == null || (value = state.getValue()) == null || (offsetMapping = value.getOffsetMapping()) == null) ? offset : TextRange.m5886getMinimpl(offsetMapping.m1427mapFromDestjx7JFs(offset));
    }

    /* renamed from: mapFromTransformed-GEjPoXI, reason: not valid java name */
    public final long m1470mapFromTransformedGEjPoXI(long range) {
        TransformedText value;
        OffsetMappingCalculator offsetMapping;
        State<TransformedText> state = this.transformedText;
        return (state == null || (value = state.getValue()) == null || (offsetMapping = value.getOffsetMapping()) == null) ? range : Companion.m1478mapFromTransformedxdX6G0(range, offsetMapping);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImeNotifications(final TextFieldState.NotifyImeListener notifyImeListener, Continuation<?> continuation) {
        TransformedTextFieldState$collectImeNotifications$1 transformedTextFieldState$collectImeNotifications$1;
        int i;
        if (continuation instanceof TransformedTextFieldState$collectImeNotifications$1) {
            transformedTextFieldState$collectImeNotifications$1 = (TransformedTextFieldState$collectImeNotifications$1) continuation;
            if ((transformedTextFieldState$collectImeNotifications$1.label & Integer.MIN_VALUE) != 0) {
                transformedTextFieldState$collectImeNotifications$1.label -= Integer.MIN_VALUE;
                Object obj = transformedTextFieldState$collectImeNotifications$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformedTextFieldState$collectImeNotifications$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    transformedTextFieldState$collectImeNotifications$1.L$0 = this;
                    transformedTextFieldState$collectImeNotifications$1.L$1 = notifyImeListener;
                    transformedTextFieldState$collectImeNotifications$1.label = 1;
                    TransformedTextFieldState$collectImeNotifications$1 transformedTextFieldState$collectImeNotifications$12 = transformedTextFieldState$collectImeNotifications$1;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(transformedTextFieldState$collectImeNotifications$12), 1);
                    cancellableContinuationImpl.initCancellability();
                    this.textFieldState.addNotifyImeListener$foundation_release(notifyImeListener);
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.text2.input.internal.TransformedTextFieldState$collectImeNotifications$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            TransformedTextFieldState.this.textFieldState.removeNotifyImeListener$foundation_release(notifyImeListener);
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(transformedTextFieldState$collectImeNotifications$12);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        transformedTextFieldState$collectImeNotifications$1 = new TransformedTextFieldState$collectImeNotifications$1(this, continuation);
        Object obj2 = transformedTextFieldState$collectImeNotifications$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformedTextFieldState$collectImeNotifications$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformedTextFieldState)) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) other;
        if (Intrinsics.areEqual(this.textFieldState, transformedTextFieldState.textFieldState)) {
            return Intrinsics.areEqual(this.codepointTransformation, transformedTextFieldState.codepointTransformation);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.textFieldState.hashCode() * 31;
        CodepointTransformation codepointTransformation = this.codepointTransformation;
        return hashCode + (codepointTransformation != null ? codepointTransformation.hashCode() : 0);
    }

    public String toString() {
        return "TransformedTextFieldState(textFieldState=" + this.textFieldState + ", codepointTransformation=" + this.codepointTransformation + ", transformedText=" + this.transformedText + ", text=\"" + ((Object) getText()) + "\")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class TransformedText {
        private final OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;

        public static /* synthetic */ TransformedText copy$default(TransformedText transformedText, TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldCharSequence = transformedText.text;
            }
            if ((i & 2) != 0) {
                offsetMappingCalculator = transformedText.offsetMapping;
            }
            return transformedText.copy(textFieldCharSequence, offsetMappingCalculator);
        }

        /* renamed from: component1, reason: from getter */
        public final TextFieldCharSequence getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TransformedText copy(TextFieldCharSequence text, OffsetMappingCalculator offsetMapping) {
            return new TransformedText(text, offsetMapping);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransformedText)) {
                return false;
            }
            TransformedText transformedText = (TransformedText) other;
            return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
        }

        public String toString() {
            return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + ')';
        }

        public TransformedText(TextFieldCharSequence textFieldCharSequence, OffsetMappingCalculator offsetMappingCalculator) {
            this.text = textFieldCharSequence;
            this.offsetMapping = offsetMappingCalculator;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public final OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransformedTextFieldState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState$TransformedText;", "untransformedText", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "codepointTransformation", "Landroidx/compose/foundation/text2/input/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-xdX6-G0", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final TransformedText calculateTransformedText(TextFieldCharSequence untransformedText, CodepointTransformation codepointTransformation) {
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            CharSequence visualText = CodepointTransformationKt.toVisualText(untransformedText, codepointTransformation, offsetMappingCalculator);
            TextRange textRange = null;
            if (visualText == untransformedText) {
                return null;
            }
            long m1479mapToTransformedxdX6G0 = m1479mapToTransformedxdX6G0(untransformedText.getSelectionInChars(), offsetMappingCalculator);
            TextRange compositionInChars = untransformedText.getCompositionInChars();
            if (compositionInChars != null) {
                textRange = TextRange.m5876boximpl(TransformedTextFieldState.Companion.m1479mapToTransformedxdX6G0(compositionInChars.getPackedValue(), offsetMappingCalculator));
            }
            return new TransformedText(TextFieldCharSequenceKt.m1404TextFieldCharSequence3r_uNRQ(visualText, m1479mapToTransformedxdX6G0, textRange), offsetMappingCalculator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapToTransformed-xdX6-G0, reason: not valid java name */
        public final long m1479mapToTransformedxdX6G0(long range, OffsetMappingCalculator mapping) {
            long m1428mapFromSourcejx7JFs = mapping.m1428mapFromSourcejx7JFs(TextRange.m5888getStartimpl(range));
            long m1428mapFromSourcejx7JFs2 = TextRange.m5882getCollapsedimpl(range) ? m1428mapFromSourcejx7JFs : mapping.m1428mapFromSourcejx7JFs(TextRange.m5883getEndimpl(range));
            int min = Math.min(TextRange.m5886getMinimpl(m1428mapFromSourcejx7JFs), TextRange.m5886getMinimpl(m1428mapFromSourcejx7JFs2));
            int max = Math.max(TextRange.m5885getMaximpl(m1428mapFromSourcejx7JFs), TextRange.m5885getMaximpl(m1428mapFromSourcejx7JFs2));
            if (TextRange.m5887getReversedimpl(range)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        /* renamed from: mapFromTransformed-xdX6-G0, reason: not valid java name */
        public final long m1478mapFromTransformedxdX6G0(long range, OffsetMappingCalculator mapping) {
            long m1427mapFromDestjx7JFs = mapping.m1427mapFromDestjx7JFs(TextRange.m5888getStartimpl(range));
            long m1427mapFromDestjx7JFs2 = TextRange.m5882getCollapsedimpl(range) ? m1427mapFromDestjx7JFs : mapping.m1427mapFromDestjx7JFs(TextRange.m5883getEndimpl(range));
            int min = Math.min(TextRange.m5886getMinimpl(m1427mapFromDestjx7JFs), TextRange.m5886getMinimpl(m1427mapFromDestjx7JFs2));
            int max = Math.max(TextRange.m5885getMaximpl(m1427mapFromDestjx7JFs), TextRange.m5885getMaximpl(m1427mapFromDestjx7JFs2));
            if (TextRange.m5887getReversedimpl(range)) {
                return TextRangeKt.TextRange(max, min);
            }
            return TextRangeKt.TextRange(min, max);
        }
    }
}
