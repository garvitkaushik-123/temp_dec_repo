package androidx.compose.foundation.text2.input;

import androidx.compose.foundation.text2.input.internal.ChangeTracker;
import androidx.compose.foundation.text2.input.internal.PartialGapBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldBuffer.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001VB%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u0014\u0010!\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010!\u001a\u00060\u0001j\u0002`\u00022\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010!\u001a\u00060\u0001j\u0002`\u00022\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0006\u0010(\u001a\u00020%J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0011J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0002J\u001a\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0002J\u001a\u00103\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b4\u0010/J \u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0002J\u000e\u00109\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010:\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010;\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010<\u001a\u0002012\u0006\u0010*\u001a\u00020\u0011J\u001e\u0010=\u001a\u0002012\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%J9\u0010=\u001a\u0002012\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010>\u001a\u00020\u00112\b\b\u0002\u0010?\u001a\u00020\u0011H\u0000¢\u0006\u0002\b@J(\u0010A\u001a\u0002012\u0006\u0010*\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0015H\u0002J\"\u0010E\u001a\u0002012\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u0006\u0010H\u001a\u000201J\u0018\u0010I\u001a\u0002012\u0006\u0010-\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u0018\u0010L\u001a\u0002012\u0006\u0010-\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\bM\u0010KJ\u0015\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020%H\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020RH\u0016J\u001c\u0010S\u001a\u00020\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\bUR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001a8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text2/input/internal/ChangeTracker;", "sourceValue", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;Landroidx/compose/foundation/text2/input/internal/ChangeTracker;Landroidx/compose/foundation/text2/input/TextFieldCharSequence;)V", "buffer", "Landroidx/compose/foundation/text2/input/internal/PartialGapBuffer;", "changeTracker", "changes", "Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "getChanges", "()Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "codepointLength", "", "getCodepointLength", "()I", "hasSelection", "", "()Z", "length", "getLength", "<set-?>", "Landroidx/compose/ui/text/TextRange;", "selectionInChars", "getSelectionInChars-d9O1mEE", "()J", "J", "selectionInCodepoints", "getSelectionInCodepoints-d9O1mEE", "append", "char", "", "text", "", "start", "end", "asCharSequence", "charAt", FirebaseAnalytics.Param.INDEX, "charIndexToCodepointIndex", "charsToCodepoints", "range", "charsToCodepoints-GEjPoXI", "(J)J", "clearChangeList", "", "codepointIndexToCharIndex", "codepointsToChars", "codepointsToChars-GEjPoXI", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "placeCursorAfterCharAt", "placeCursorAfterCodepointAt", "placeCursorBeforeCharAt", "placeCursorBeforeCodepointAt", "replace", "textStart", "textEnd", "replace$foundation_release", "requireValidIndex", "startExclusive", "endExclusive", "inCodepoints", "requireValidRange", "requireValidRange-72CqOWE", "(JZ)V", "revertAllChanges", "selectCharsIn", "selectCharsIn-5zc-tL8", "(J)V", "selectCodepointsIn", "selectCodepointsIn-5zc-tL8", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "toString", "", "toTextFieldCharSequence", "composition", "toTextFieldCharSequence-OEnZFl4$foundation_release", "ChangeList", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private final PartialGapBuffer buffer;
    private ChangeTracker changeTracker;
    private long selectionInChars;
    private final TextFieldCharSequence sourceValue;

    /* compiled from: TextFieldBuffer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text2/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ChangeList {
        int getChangeCount();

        /* renamed from: getOriginalRange--jx7JFs */
        long mo1391getOriginalRangejx7JFs(int changeIndex);

        /* renamed from: getRange--jx7JFs */
        long mo1392getRangejx7JFs(int changeIndex);
    }

    private final int charIndexToCodepointIndex(int index) {
        return index;
    }

    private final int codepointIndexToCharIndex(int index) {
        return index;
    }

    public TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2) {
        this.sourceValue = textFieldCharSequence2;
        this.buffer = new PartialGapBuffer(textFieldCharSequence);
        this.changeTracker = changeTracker != null ? new ChangeTracker(changeTracker) : null;
        this.selectionInChars = textFieldCharSequence.getSelectionInChars();
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldCharSequence, (i & 2) != 0 ? null : changeTracker, (i & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2);
    }

    public final int getLength() {
        return this.buffer.length();
    }

    public final int getCodepointLength() {
        return Character.codePointCount(this.buffer, 0, getLength());
    }

    public final ChangeList getChanges() {
        ChangeTracker changeTracker = this.changeTracker;
        return changeTracker != null ? changeTracker : EmptyChangeList.INSTANCE;
    }

    public final boolean hasSelection() {
        return !TextRange.m5882getCollapsedimpl(this.selectionInChars);
    }

    /* renamed from: getSelectionInChars-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelectionInChars() {
        return this.selectionInChars;
    }

    /* renamed from: getSelectionInCodepoints-d9O1mEE, reason: not valid java name */
    public final long m1398getSelectionInCodepointsd9O1mEE() {
        return m1393charsToCodepointsGEjPoXI(this.selectionInChars);
    }

    public final void replace(int start, int end, CharSequence text) {
        replace$foundation_release(start, end, text, 0, text.length());
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        textFieldBuffer.replace$foundation_release(i, i2, charSequence, i6, i4);
    }

    public final void replace$foundation_release(int start, int end, CharSequence text, int textStart, int textEnd) {
        if (start > end) {
            throw new IllegalArgumentException(("Expected start=" + start + " <= end=" + end).toString());
        }
        if (textStart > textEnd) {
            throw new IllegalArgumentException(("Expected textStart=" + textStart + " <= textEnd=" + textEnd).toString());
        }
        onTextWillChange(start, end, textEnd - textStart);
        this.buffer.replace(start, end, text, textStart, textEnd);
    }

    public final void setTextIfChanged$foundation_release(CharSequence newText) {
        int i;
        int i2;
        PartialGapBuffer partialGapBuffer = this.buffer;
        int length = partialGapBuffer.length();
        int length2 = newText.length();
        boolean z = false;
        if (partialGapBuffer.length() <= 0 || newText.length() <= 0) {
            i = 0;
            i2 = 0;
        } else {
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            while (true) {
                if (!z) {
                    if (partialGapBuffer.charAt(i3) == newText.charAt(i4)) {
                        i3++;
                        i4++;
                    } else {
                        z = true;
                    }
                }
                if (!z2) {
                    if (partialGapBuffer.charAt(length - 1) == newText.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z2 = true;
                    }
                }
                if (i3 >= length || i4 >= length2 || (z && z2)) {
                    break;
                }
            }
            i = i3;
            i2 = i4;
        }
        int i5 = length;
        int i6 = length2;
        if (i < i5 || i2 < i6) {
            replace$foundation_release(i, i5, newText, i2, i6);
        }
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), text.length());
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text, 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text, int start, int end) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), end - start);
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text.subSequence(start, end), 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(char r12) {
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer partialGapBuffer = this.buffer;
        PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), String.valueOf(r12), 0, 0, 24, null);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r5 == r1) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onTextWillChange(int replaceStart, int replaceEnd, int newLength) {
        int i;
        ChangeTracker changeTracker = this.changeTracker;
        if (changeTracker == null) {
            changeTracker = new ChangeTracker(null, 1, 0 == true ? 1 : 0);
            this.changeTracker = changeTracker;
        }
        changeTracker.trackChange(replaceStart, replaceEnd, newLength);
        int min = Math.min(replaceStart, replaceEnd);
        int max = Math.max(replaceStart, replaceEnd);
        int m5886getMinimpl = TextRange.m5886getMinimpl(this.selectionInChars);
        int m5885getMaximpl = TextRange.m5885getMaximpl(this.selectionInChars);
        if (m5885getMaximpl < min) {
            return;
        }
        if (m5886getMinimpl > min || max > m5885getMaximpl) {
            if (m5886getMinimpl > min && m5885getMaximpl < max) {
                min += newLength;
                m5886getMinimpl = min;
            } else if (m5886getMinimpl >= max) {
                i = newLength - (max - min);
                m5886getMinimpl += i;
                min = m5885getMaximpl + i;
            } else if (min < m5886getMinimpl) {
                m5886getMinimpl = min + newLength;
                i = newLength - (max - min);
                min = m5885getMaximpl + i;
            }
            this.selectionInChars = TextRangeKt.TextRange(m5886getMinimpl, min);
            return;
        }
        i = newLength - (max - min);
    }

    public final char charAt(int index) {
        return this.buffer.charAt(index);
    }

    public String toString() {
        return this.buffer.toString();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    private final void clearChangeList() {
        ChangeTracker changeTracker = this.changeTracker;
        if (changeTracker != null) {
            changeTracker.clearChanges();
        }
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.sourceValue.toString());
        this.selectionInChars = this.sourceValue.getSelectionInChars();
        clearChangeList();
    }

    public final void placeCursorBeforeCodepointAt(int index) {
        requireValidIndex(index, true, false, true);
        this.selectionInChars = TextRangeKt.TextRange(codepointIndexToCharIndex(index));
    }

    public final void placeCursorBeforeCharAt(int index) {
        requireValidIndex(index, true, false, false);
        this.selectionInChars = TextRangeKt.TextRange(index);
    }

    public final void placeCursorAfterCodepointAt(int index) {
        requireValidIndex(index, false, true, true);
        this.selectionInChars = TextRangeKt.TextRange(codepointIndexToCharIndex(RangesKt.coerceAtMost(index + 1, getCodepointLength())));
    }

    public final void placeCursorAfterCharAt(int index) {
        requireValidIndex(index, false, true, false);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(index + 1, getLength()));
    }

    /* renamed from: selectCodepointsIn-5zc-tL8, reason: not valid java name */
    public final void m1400selectCodepointsIn5zctL8(long range) {
        m1395requireValidRange72CqOWE(range, true);
        this.selectionInChars = m1394codepointsToCharsGEjPoXI(range);
    }

    /* renamed from: selectCharsIn-5zc-tL8, reason: not valid java name */
    public final void m1399selectCharsIn5zctL8(long range) {
        m1395requireValidRange72CqOWE(range, false);
        this.selectionInChars = range;
    }

    /* renamed from: toTextFieldCharSequence-OEnZFl4$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1396toTextFieldCharSequenceOEnZFl4$foundation_release$default(TextFieldBuffer textFieldBuffer, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            textRange = null;
        }
        return textFieldBuffer.m1401toTextFieldCharSequenceOEnZFl4$foundation_release(textRange);
    }

    /* renamed from: toTextFieldCharSequence-OEnZFl4$foundation_release, reason: not valid java name */
    public final TextFieldCharSequence m1401toTextFieldCharSequenceOEnZFl4$foundation_release(TextRange composition) {
        return TextFieldCharSequenceKt.m1404TextFieldCharSequence3r_uNRQ(this.buffer.toString(), this.selectionInChars, composition);
    }

    private final void requireValidIndex(int index, boolean startExclusive, boolean endExclusive, boolean inCodepoints) {
        int i = startExclusive ? 0 : -1;
        int length = endExclusive ? getLength() : getLength() + 1;
        if (inCodepoints) {
            i = charIndexToCodepointIndex(i);
            length = charIndexToCodepointIndex(length);
        }
        if (i > index || index >= length) {
            throw new IllegalArgumentException(("Expected " + index + " to be in [" + i + ", " + length + ") " + (inCodepoints ? "codepoints" : "chars")).toString());
        }
    }

    /* renamed from: requireValidRange-72CqOWE, reason: not valid java name */
    private final void m1395requireValidRange72CqOWE(long range, boolean inCodepoints) {
        long TextRange = TextRangeKt.TextRange(0, getLength());
        if (inCodepoints) {
            TextRange = m1393charsToCodepointsGEjPoXI(TextRange);
        }
        if (TextRange.m5878contains5zctL8(TextRange, range)) {
        } else {
            throw new IllegalArgumentException(("Expected " + ((Object) TextRange.m5891toStringimpl(range)) + " to be in " + ((Object) TextRange.m5891toStringimpl(TextRange)) + " (" + (inCodepoints ? "codepoints" : "chars") + ')').toString());
        }
    }

    /* renamed from: codepointsToChars-GEjPoXI, reason: not valid java name */
    private final long m1394codepointsToCharsGEjPoXI(long range) {
        return TextRangeKt.TextRange(codepointIndexToCharIndex(TextRange.m5888getStartimpl(range)), codepointIndexToCharIndex(TextRange.m5883getEndimpl(range)));
    }

    /* renamed from: charsToCodepoints-GEjPoXI, reason: not valid java name */
    private final long m1393charsToCodepointsGEjPoXI(long range) {
        return TextRangeKt.TextRange(charIndexToCodepointIndex(TextRange.m5888getStartimpl(range)), charIndexToCodepointIndex(TextRange.m5883getEndimpl(range)));
    }
}
