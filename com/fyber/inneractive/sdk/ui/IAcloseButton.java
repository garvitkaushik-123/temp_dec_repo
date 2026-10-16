package com.fyber.inneractive.sdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.fyber.inneractive.sdk.util.o;

/* loaded from: classes4.dex */
public class IAcloseButton extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1736a;
    public final Path b;

    public IAcloseButton(Context context, int i) {
        super(context);
        int b = o.b(10);
        int i2 = ((i - (b * 2)) / 4) + b;
        Point point = new Point(i2, i2);
        int i3 = i - i2;
        Point point2 = new Point(i2, i3);
        Point point3 = new Point(i3, i3);
        Point point4 = new Point(i3, i2);
        Path path = new Path();
        this.b = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point.x, point.y);
        path.lineTo(point3.x, point3.y);
        path.moveTo(point2.x, point2.y);
        path.lineTo(point4.x, point4.y);
        path.close();
        Paint paint = new Paint(1);
        this.f1736a = paint;
        paint.setStrokeWidth(o.b(2));
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1436657061);
        gradientDrawable.setStroke(o.b(2), -1);
        o.a(this, gradientDrawable);
        setPadding(b, b, b, b);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.b, this.f1736a);
    }
}
