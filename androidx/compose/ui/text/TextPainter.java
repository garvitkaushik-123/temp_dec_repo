package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Canvas canvas2;
        Throwable th;
        Brush brush;
        Canvas canvas3;
        long m4089getBlack0d7_KjU;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m6323equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m6332getVisiblegIe3tQ8());
        if (z) {
            Rect m3862Recttz77jQw = RectKt.m3862Recttz77jQw(Offset.INSTANCE.m3838getZeroF1C5BW0(), SizeKt.Size(IntSize.m6559getWidthimpl(textLayoutResult.getSize()), IntSize.m6558getHeightimpl(textLayoutResult.getSize())));
            canvas.save();
            canvas2 = null;
            Canvas.m4036clipRectmtrdDE$default(canvas, m3862Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
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
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            brush = spanStyle.getBrush();
        } catch (Throwable th2) {
            th = th2;
            canvas2 = canvas;
        }
        try {
            if (brush != null) {
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    try {
                        alpha = spanStyle.getTextForegroundStyle().getAlpha();
                    } catch (Throwable th3) {
                        th = th3;
                        canvas2 = canvas;
                        if (z) {
                            throw th;
                        }
                        canvas2.restore();
                        throw th;
                    }
                } else {
                    alpha = 1.0f;
                }
                canvas3 = canvas;
                MultiParagraph.m5763painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                canvas3 = canvas;
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    m4089getBlack0d7_KjU = spanStyle.getTextForegroundStyle().mo6179getColor0d7_KjU();
                } else {
                    m4089getBlack0d7_KjU = Color.INSTANCE.m4089getBlack0d7_KjU();
                }
                textLayoutResult.getMultiParagraph().m5767paintLG529CI(canvas3, (r14 & 2) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : m4089getBlack0d7_KjU, (r14 & 4) != 0 ? null : shadow2, (r14 & 8) != 0 ? null : textDecoration2, (r14 & 16) == 0 ? drawStyle2 : null, (r14 & 32) != 0 ? DrawScope.INSTANCE.m4613getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z) {
                canvas3.restore();
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            if (z) {
            }
        }
    }
}
