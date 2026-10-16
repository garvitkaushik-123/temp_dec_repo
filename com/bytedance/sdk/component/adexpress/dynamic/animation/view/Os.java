package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.aGH.kb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.du;

/* loaded from: classes3.dex */
public class Os {
    private int MGA;
    private int aGH;
    Paint eli;
    private int ui;
    Path DbA = new Path();
    Path Os = new Path();

    public Os() {
        Paint paint = new Paint();
        this.eli = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(Canvas canvas, IAnimation iAnimation, View view) {
        int i;
        String str;
        float[] fArr;
        int i2 = 0;
        if (iAnimation.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArr = kb.DbA(str);
                    } catch (Exception unused) {
                        fArr = null;
                        if (!str.startsWith("#")) {
                        }
                        ((ViewGroup) view.getParent()).setClipChildren(true);
                        canvas.drawCircle(this.aGH, this.ui, Math.min(r2, r5) * 2 * iAnimation.getRippleValue(), this.eli);
                        if (iAnimation.getShineValue() != 0.0f) {
                        }
                        if (iAnimation.getMarqueeValue() == 0.0f) {
                        }
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (!str.startsWith("#")) {
                    this.eli.setColor(Color.parseColor(str));
                    this.eli.setAlpha(90);
                } else if (fArr != null) {
                    this.eli.setColor(com.bytedance.sdk.component.adexpress.aGH.kb.eli(fArr[3] * (1.0f - iAnimation.getRippleValue()), fArr[0] / 256.0f, fArr[1] / 256.0f, fArr[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.aGH, this.ui, Math.min(r2, r5) * 2 * iAnimation.getRippleValue(), this.eli);
        }
        if (iAnimation.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.DbA.reset();
            try {
                i = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                i = 0;
            }
            if (i >= 0) {
                int shineValue = ((int) ((((this.aGH * 4) + (i * 2)) + (this.ui * 2)) * iAnimation.getShineValue())) - ((this.ui * 2) + i);
                float f = shineValue;
                int i3 = this.ui;
                this.eli.setShader(new LinearGradient(f, 0.0f, ((i + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.eli.setStrokeWidth(this.aGH * 2);
                Path path = this.Os;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + i;
                canvas.drawLine(f, 0.0f, i4 + r2, this.ui, this.eli);
            }
        }
        if (iAnimation.getMarqueeValue() == 0.0f) {
            try {
                i2 = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
            }
            if (i2 >= 0) {
                this.DbA.reset();
                this.DbA.moveTo(0.0f, 0.0f);
                this.DbA.lineTo(this.aGH * 2, 0.0f);
                this.DbA.lineTo(this.aGH * 2, this.ui * 2);
                this.DbA.lineTo(0.0f, this.ui * 2);
                this.DbA.lineTo(0.0f, 0.0f);
                this.eli.setShader(new LinearGradient(0.0f, 0.0f, this.aGH * 2, this.ui * 2, new int[]{(int) (iAnimation.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - iAnimation.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.eli.setColor(-65536);
                this.eli.setStyle(Paint.Style.STROKE);
                this.eli.setStrokeWidth(i2);
                canvas.drawPath(this.DbA, this.eli);
            }
        }
    }

    public void eli(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.MGA * f);
        view.setTranslationX((this.MGA - layoutParams.width) / 2);
        if (view instanceof du) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.MGA - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void eli(View view, int i, int i2) {
        String str;
        this.aGH = i / 2;
        this.ui = i2 / 2;
        if (this.MGA == 0 && view.getLayoutParams().width > 0) {
            this.MGA = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.Os.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.aGH * 2);
            view.setPivotY(this.ui);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.ui);
        } else {
            view.setPivotX(this.aGH);
            view.setPivotY(this.ui);
        }
    }
}
