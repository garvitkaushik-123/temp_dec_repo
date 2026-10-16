package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m6048updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m5884getLengthimpl;
        int m5886getMinimpl = TextRange.m5886getMinimpl(j);
        int m5885getMaximpl = TextRange.m5885getMaximpl(j);
        if (TextRange.m5890intersects5zctL8(j2, j)) {
            if (TextRange.m5878contains5zctL8(j2, j)) {
                m5886getMinimpl = TextRange.m5886getMinimpl(j2);
                m5885getMaximpl = m5886getMinimpl;
            } else {
                if (TextRange.m5878contains5zctL8(j, j2)) {
                    m5884getLengthimpl = TextRange.m5884getLengthimpl(j2);
                } else if (TextRange.m5879containsimpl(j2, m5886getMinimpl)) {
                    m5886getMinimpl = TextRange.m5886getMinimpl(j2);
                    m5884getLengthimpl = TextRange.m5884getLengthimpl(j2);
                } else {
                    m5885getMaximpl = TextRange.m5886getMinimpl(j2);
                }
                m5885getMaximpl -= m5884getLengthimpl;
            }
        } else if (m5885getMaximpl > TextRange.m5886getMinimpl(j2)) {
            m5886getMinimpl -= TextRange.m5884getLengthimpl(j2);
            m5884getLengthimpl = TextRange.m5884getLengthimpl(j2);
            m5885getMaximpl -= m5884getLengthimpl;
        }
        return TextRangeKt.TextRange(m5886getMinimpl, m5885getMaximpl);
    }
}
