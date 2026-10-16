package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.s;
import io.bidmachine.rendering.model.AppearanceParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u000b\u0010\u001bR \u0010\"\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR(\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b)\u0010!\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u00101\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b*\u0010+\u0012\u0004\b0\u0010!\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00106\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b2\u0010+\u0012\u0004\b5\u0010!\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/¨\u00067"}, d2 = {"Lio/bidmachine/rendering/internal/view/c;", "Landroid/view/View;", "Lio/bidmachine/rendering/internal/e;", "Lio/bidmachine/rendering/internal/s;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lio/bidmachine/rendering/model/AppearanceParams;", "appearanceParams", "", "a", "(Lio/bidmachine/rendering/model/AppearanceParams;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "maxProgressMs", "currentProgressMs", "", "percent", "(JJF)V", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "getLinePaint", "()Landroid/graphics/Paint;", "getLinePaint$annotations", "()V", "linePaint", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "F", "getPercent", "()F", "setPercent", "(F)V", "getPercent$annotations", "c", "I", "getLineColor", "()I", "setLineColor", "(I)V", "getLineColor$annotations", "lineColor", "d", "getLineBackgroundColor", "setLineBackgroundColor", "getLineBackgroundColor$annotations", "lineBackgroundColor", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c extends View implements io.bidmachine.rendering.internal.e, s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Paint linePaint;

    /* renamed from: b, reason: from kotlin metadata */
    private float percent;

    /* renamed from: c, reason: from kotlin metadata */
    private int lineColor;

    /* renamed from: d, reason: from kotlin metadata */
    private int lineBackgroundColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.linePaint = new Paint(1);
        this.lineColor = i.MAIN_ASSETS_COLOR;
    }

    public static /* synthetic */ void getLineBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getLineColor$annotations() {
    }

    public static /* synthetic */ void getLinePaint$annotations() {
    }

    public static /* synthetic */ void getPercent$annotations() {
    }

    @Override // io.bidmachine.rendering.internal.e
    public void a(AppearanceParams appearanceParams) {
        Intrinsics.checkNotNullParameter(appearanceParams, "appearanceParams");
        Integer fillColor = appearanceParams.getFillColor();
        if (fillColor != null) {
            this.lineBackgroundColor = fillColor.intValue();
        }
        Integer strokeColor = appearanceParams.getStrokeColor();
        if (strokeColor != null) {
            this.lineColor = strokeColor.intValue();
        }
    }

    public final int getLineBackgroundColor() {
        return this.lineBackgroundColor;
    }

    public final int getLineColor() {
        return this.lineColor;
    }

    public final Paint getLinePaint() {
        return this.linePaint;
    }

    public final float getPercent() {
        return this.percent;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float measuredHeight = (getMeasuredHeight() / 2.0f) + getPaddingTop();
        this.linePaint.setColor(this.lineBackgroundColor);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + width, measuredHeight, this.linePaint);
        this.linePaint.setColor(this.lineColor);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + ((width * this.percent) / 100), measuredHeight, this.linePaint);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.linePaint.setStrokeWidth(getMeasuredHeight());
    }

    public final void setLineBackgroundColor(int i) {
        this.lineBackgroundColor = i;
    }

    public final void setLineColor(int i) {
        this.lineColor = i;
    }

    public final void setPercent(float f) {
        this.percent = f;
    }

    @Override // io.bidmachine.rendering.internal.s
    public void a(long maxProgressMs, long currentProgressMs, float percent) {
        this.percent = percent;
        postInvalidate();
    }
}
