package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabElement;
import io.bidmachine.iab.utils.IabElementStyle;

/* loaded from: classes7.dex */
public class IabTextView extends TextView implements IabElement {

    /* renamed from: a, reason: collision with root package name */
    private final RectF f6927a;
    private GradientDrawable b;
    private Paint c;
    private boolean d;

    public IabTextView(Context context) {
        super(context);
        this.f6927a = new RectF();
        this.d = false;
        a(context);
    }

    protected void a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.b = gradientDrawable;
        gradientDrawable.setColor(Assets.BACKGROUND_COLOR);
        this.b.setShape(0);
        setBackgroundDrawable(this.b);
        setGravity(17);
        setMaxLines(1);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.d || this.c == null) {
            return;
        }
        float height = getHeight() / 2.0f;
        canvas.drawRoundRect(this.f6927a, height, height, this.c);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        if (View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            float size = (View.MeasureSpec.getSize(heightMeasureSpec) - getCompoundPaddingTop()) - getCompoundPaddingRight();
            if (getTextSize() != size) {
                setTextSize(0, size);
            }
        }
        if (mode == 1073741824 && getText() != null) {
            int size2 = (View.MeasureSpec.getSize(widthMeasureSpec) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            float measureText = getPaint().measureText(getText(), 0, getText().length());
            float f = size2;
            if (f < measureText) {
                float textSize = (int) (getTextSize() * (f / measureText));
                if (getTextSize() != textSize) {
                    setTextSize(0, textSize);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Paint paint;
        super.onSizeChanged(w, h, oldw, oldh);
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(h / 2.0f);
        }
        if (!this.d || (paint = this.c) == null) {
            return;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        float f = 0.0f + strokeWidth;
        this.f6927a.set(f, f, w - strokeWidth, h - strokeWidth);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        boolean booleanValue = style.isOutlined().booleanValue();
        this.d = booleanValue;
        if (booleanValue) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.c.setColor(style.getStrokeColor().intValue());
            this.c.setStrokeWidth(style.getStrokeWidth(getContext()).floatValue());
        }
        setTextColor(style.getStrokeColor().intValue());
        setBackgroundColor(style.getFillColor().intValue());
        setTextSize(0, style.getFontSize(getContext()).floatValue());
        setTypeface(Typeface.create(Typeface.DEFAULT, style.getFontStyle().intValue()));
        setAlpha(style.getOpacity().floatValue());
        setPadding(style.getPaddingLeft(getContext()).intValue(), style.getPaddingTop(getContext()).intValue(), style.getPaddingRight(getContext()).intValue(), style.getPaddingBottom(getContext()).intValue());
    }

    public IabTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f6927a = new RectF();
        this.d = false;
        a(context);
    }
}
