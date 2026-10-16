package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* compiled from: CanvasDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo4542getSizeNHjbRc() {
                return DrawContext.this.mo4537getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo4541getCenterF1C5BW0() {
                return SizeKt.m3901getCenteruvyYCjk(mo4542getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float left, float top, float right, float bottom) {
                Canvas canvas = DrawContext.this.getCanvas();
                DrawContext drawContext2 = DrawContext.this;
                long Size = SizeKt.Size(Size.m3891getWidthimpl(mo4542getSizeNHjbRc()) - (right + left), Size.m3888getHeightimpl(mo4542getSizeNHjbRc()) - (bottom + top));
                if (Size.m3891getWidthimpl(Size) < 0.0f || Size.m3888getHeightimpl(Size) < 0.0f) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext2.mo4538setSizeuvyYCjk(Size);
                canvas.translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo4540clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
                DrawContext.this.getCanvas().mo3917clipRectN_I0leg(left, top, right, bottom, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo4539clipPathmtrdDE(Path path, int clipOp) {
                DrawContext.this.getCanvas().mo3916clipPathmtrdDE(path, clipOp);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float left, float top) {
                DrawContext.this.getCanvas().translate(left, top);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo4543rotateUv8p0NA(float degrees, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m3822getXimpl(pivot), Offset.m3823getYimpl(pivot));
                canvas.rotate(degrees);
                canvas.translate(-Offset.m3822getXimpl(pivot), -Offset.m3823getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo4544scale0AR0LA0(float scaleX, float scaleY, long pivot) {
                Canvas canvas = DrawContext.this.getCanvas();
                canvas.translate(Offset.m3822getXimpl(pivot), Offset.m3823getYimpl(pivot));
                canvas.scale(scaleX, scaleY);
                canvas.translate(-Offset.m3822getXimpl(pivot), -Offset.m3823getYimpl(pivot));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo4545transform58bKbWc(float[] matrix) {
                DrawContext.this.getCanvas().mo3918concat58bKbWc(matrix);
            }
        };
    }
}
