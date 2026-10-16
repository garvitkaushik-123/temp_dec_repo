package io.bidmachine.iab.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class IabElementStyle implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private Integer f6849a;
    private Integer b;
    private Boolean c;
    private Boolean d;
    private Integer e;
    private Integer f;
    private String g;
    private Float h;
    private Float i;
    private Integer j;
    private Integer k;
    private Integer l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    private String r;
    private Float s;
    private Float t;
    private Float u;
    private Integer v;
    private Float w;

    public IabElementStyle() {
    }

    public void applyAlignment(FrameLayout.LayoutParams layoutParams) {
        layoutParams.gravity = positionAsGravity();
    }

    public void applyMargin(Context context, ViewGroup.MarginLayoutParams layoutParams) {
        layoutParams.leftMargin = getMarginLeft(context).intValue();
        layoutParams.topMargin = getMarginTop(context).intValue();
        layoutParams.rightMargin = getMarginRight(context).intValue();
        layoutParams.bottomMargin = getMarginBottom(context).intValue();
    }

    public void applyPadding(Context context, View view) {
        view.setPadding(getPaddingLeft(context).intValue(), getPaddingTop(context).intValue(), getPaddingRight(context).intValue(), getPaddingBottom(context).intValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r0 != 17) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void applyRelativeAlignment(RelativeLayout.LayoutParams layoutParams) {
        int intValue;
        int intValue2 = getHorizontalPosition().intValue();
        if (intValue2 != 1) {
            if (intValue2 == 3) {
                layoutParams.addRule(9);
            } else if (intValue2 == 5) {
                layoutParams.addRule(11);
            }
            intValue = getVerticalPosition().intValue();
            if (intValue != 16 || intValue == 17) {
                layoutParams.addRule(15);
            } else if (intValue == 48) {
                layoutParams.addRule(10);
                return;
            } else {
                if (intValue != 80) {
                    return;
                }
                layoutParams.addRule(12);
                return;
            }
        }
        layoutParams.addRule(14);
        intValue = getVerticalPosition().intValue();
        if (intValue != 16) {
        }
        layoutParams.addRule(15);
    }

    public IabElementStyle copyWith(IabElementStyle copyFrom) {
        IabElementStyle iabElementStyle = new IabElementStyle();
        iabElementStyle.merge(this);
        iabElementStyle.merge(copyFrom);
        return iabElementStyle;
    }

    public String getContent() {
        return this.r;
    }

    public Integer getFillColor() {
        Integer num = this.b;
        return num != null ? num : Integer.valueOf(Assets.BACKGROUND_COLOR);
    }

    public Float getFontSize(Context context) {
        return this.w != null ? Float.valueOf(Utils.dpToPx(context, r0.floatValue())) : Float.valueOf(Utils.dpToPx(context, 16.0f));
    }

    public Integer getFontStyle() {
        Integer num = this.v;
        if (num != null) {
            return num;
        }
        return 0;
    }

    public Integer getHeight(Context context) {
        Float f = this.u;
        if (f != null) {
            return f.floatValue() == -1.0f ? Integer.valueOf(this.u.intValue()) : this.u.floatValue() == -2.0f ? Integer.valueOf(this.u.intValue()) : Integer.valueOf(Utils.dpToPx(context, this.u.floatValue()));
        }
        return -2;
    }

    public Float getHideAfter() {
        return this.i;
    }

    public Integer getHorizontalPosition() {
        Integer num = this.e;
        if (num != null) {
            return num;
        }
        return 3;
    }

    public Integer getMarginBottom(Context context) {
        if (this.q != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getMarginLeft(Context context) {
        if (this.n != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getMarginRight(Context context) {
        if (this.p != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getMarginTop(Context context) {
        if (this.o != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Float getOpacity() {
        Float f = this.h;
        return f != null ? f : Float.valueOf(1.0f);
    }

    public Integer getPaddingBottom(Context context) {
        if (this.m != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getPaddingLeft(Context context) {
        if (this.j != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getPaddingRight(Context context) {
        if (this.k != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getPaddingTop(Context context) {
        if (this.l != null) {
            return Integer.valueOf(Utils.dpToPx(context, r0.intValue()));
        }
        return 0;
    }

    public Integer getStrokeColor() {
        Integer num = this.f6849a;
        return num != null ? num : Integer.valueOf(Assets.MAIN_ASSETS_COLOR);
    }

    public Float getStrokeWidth(Context context) {
        return this.s != null ? Float.valueOf(Utils.dpToPx(context, r0.floatValue())) : Float.valueOf(0.0f);
    }

    public String getStyle() {
        return this.g;
    }

    public Integer getVerticalPosition() {
        Integer num = this.f;
        if (num != null) {
            return num;
        }
        return 48;
    }

    public Integer getWidth(Context context) {
        Float f = this.t;
        if (f != null) {
            return f.floatValue() == -1.0f ? Integer.valueOf(this.t.intValue()) : this.t.floatValue() == -2.0f ? Integer.valueOf(this.t.intValue()) : Integer.valueOf(Utils.dpToPx(context, this.t.floatValue()));
        }
        return -2;
    }

    public boolean hasFillColor() {
        return this.b != null;
    }

    public boolean hasStrokeColor() {
        return this.f6849a != null;
    }

    public Boolean isOutlined() {
        Boolean bool = this.c;
        return bool != null ? bool : Boolean.FALSE;
    }

    public Boolean isVisible() {
        Boolean bool = this.d;
        return bool != null ? bool : Boolean.TRUE;
    }

    public void merge(IabElementStyle style) {
        if (style == null) {
            return;
        }
        Integer num = style.f6849a;
        if (num != null) {
            this.f6849a = num;
        }
        Integer num2 = style.b;
        if (num2 != null) {
            this.b = num2;
        }
        Boolean bool = style.c;
        if (bool != null) {
            this.c = bool;
        }
        Boolean bool2 = style.d;
        if (bool2 != null) {
            this.d = bool2;
        }
        Integer num3 = style.e;
        if (num3 != null) {
            this.e = num3;
        }
        Integer num4 = style.f;
        if (num4 != null) {
            this.f = num4;
        }
        String str = style.g;
        if (str != null) {
            this.g = str;
        }
        Float f = style.h;
        if (f != null) {
            this.h = f;
        }
        Float f2 = style.i;
        if (f2 != null) {
            this.i = f2;
        }
        Integer num5 = style.j;
        if (num5 != null) {
            this.j = num5;
        }
        Integer num6 = style.k;
        if (num6 != null) {
            this.k = num6;
        }
        Integer num7 = style.l;
        if (num7 != null) {
            this.l = num7;
        }
        Integer num8 = style.m;
        if (num8 != null) {
            this.m = num8;
        }
        Integer num9 = style.n;
        if (num9 != null) {
            this.n = num9;
        }
        Integer num10 = style.p;
        if (num10 != null) {
            this.p = num10;
        }
        Integer num11 = style.o;
        if (num11 != null) {
            this.o = num11;
        }
        Integer num12 = style.q;
        if (num12 != null) {
            this.q = num12;
        }
        String str2 = style.r;
        if (str2 != null) {
            this.r = str2;
        }
        Float f3 = style.s;
        if (f3 != null) {
            this.s = f3;
        }
        Float f4 = style.t;
        if (f4 != null) {
            this.t = f4;
        }
        Float f5 = style.u;
        if (f5 != null) {
            this.u = f5;
        }
        Integer num13 = style.v;
        if (num13 != null) {
            this.v = num13;
        }
        Float f6 = style.w;
        if (f6 != null) {
            this.w = f6;
        }
    }

    public int positionAsGravity() {
        return getVerticalPosition().intValue() | getHorizontalPosition().intValue();
    }

    public void setContent(String content) {
        this.r = content;
    }

    public void setFillColor(Integer fillColor) {
        this.b = fillColor;
    }

    public void setFontSize(Float fontSize) {
        this.w = fontSize;
    }

    public void setFontStyle(Integer fontStyle) {
        this.v = fontStyle;
    }

    public void setHeight(Number height) {
        this.u = height != null ? Float.valueOf(height.floatValue()) : null;
    }

    public void setHideAfter(Float hideAfter) {
        this.i = hideAfter;
    }

    public void setHorizontalPosition(Integer horizontalPosition) {
        this.e = horizontalPosition;
    }

    public void setMargin(Integer left, Integer top, Integer right, Integer bottom) {
        this.n = left;
        this.o = top;
        this.p = right;
        this.q = bottom;
    }

    public void setMarginBottom(Integer margin) {
        this.q = margin;
    }

    public void setMarginLeft(Integer margin) {
        this.n = margin;
    }

    public void setMarginRight(Integer margin) {
        this.p = margin;
    }

    public void setMarginTop(Integer margin) {
        this.o = margin;
    }

    public void setOpacity(Float opacity) {
        this.h = opacity;
    }

    public void setOutlined(Boolean outlined) {
        this.c = outlined;
    }

    public void setPadding(Integer left, Integer top, Integer right, Integer bottom) {
        this.j = left;
        this.l = top;
        this.k = right;
        this.m = bottom;
    }

    public void setPaddingBottom(Integer padding) {
        this.m = padding;
    }

    public void setPaddingLeft(Integer padding) {
        this.j = padding;
    }

    public void setPaddingRight(Integer padding) {
        this.k = padding;
    }

    public void setPaddingTop(Integer padding) {
        this.l = padding;
    }

    public void setStrokeColor(Integer strokeColor) {
        this.f6849a = strokeColor;
    }

    public void setStrokeWidth(Float strokeWidth) {
        this.s = strokeWidth;
    }

    public void setStyle(String style) {
        this.g = style;
    }

    public void setVerticalPosition(Integer verticalPosition) {
        this.f = verticalPosition;
    }

    public void setVisible(Boolean visible) {
        this.d = visible;
    }

    public void setWidth(Number width) {
        this.t = width != null ? Float.valueOf(width.floatValue()) : null;
    }

    public IabElementStyle(IabElementStyle copyFrom) {
        merge(copyFrom);
    }

    public void setMargin(String value) {
        if (TextUtils.isEmpty(value)) {
            setMargin(null, null, null, null);
            return;
        }
        String[] split = value.split(" ");
        if (split.length == 1) {
            int intValue = Utils.convertCssSizeToPx(split[0]).intValue();
            setMargin(Integer.valueOf(intValue), Integer.valueOf(intValue), Integer.valueOf(intValue), Integer.valueOf(intValue));
            return;
        }
        if (split.length == 2) {
            int intValue2 = Utils.convertCssSizeToPx(split[0]).intValue();
            int intValue3 = Utils.convertCssSizeToPx(split[1]).intValue();
            setMargin(Integer.valueOf(intValue3), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue2));
        } else {
            if (split.length == 3) {
                int intValue4 = Utils.convertCssSizeToPx(split[0]).intValue();
                int intValue5 = Utils.convertCssSizeToPx(split[1]).intValue();
                setMargin(Integer.valueOf(intValue5), Integer.valueOf(intValue4), Integer.valueOf(intValue5), Integer.valueOf(Utils.convertCssSizeToPx(split[2]).intValue()));
                return;
            }
            if (split.length == 4) {
                setMargin(Integer.valueOf(Utils.convertCssSizeToPx(split[3]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[0]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[1]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[2]).intValue()));
            }
        }
    }

    public void setPadding(String value) {
        if (TextUtils.isEmpty(value)) {
            setPadding(null, null, null, null);
            return;
        }
        String[] split = value.split(" ");
        if (split.length == 1) {
            int intValue = Utils.convertCssSizeToPx(split[0]).intValue();
            setPadding(Integer.valueOf(intValue), Integer.valueOf(intValue), Integer.valueOf(intValue), Integer.valueOf(intValue));
            return;
        }
        if (split.length == 2) {
            int intValue2 = Utils.convertCssSizeToPx(split[0]).intValue();
            int intValue3 = Utils.convertCssSizeToPx(split[1]).intValue();
            setPadding(Integer.valueOf(intValue3), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue2));
        } else {
            if (split.length == 3) {
                int intValue4 = Utils.convertCssSizeToPx(split[0]).intValue();
                int intValue5 = Utils.convertCssSizeToPx(split[1]).intValue();
                setPadding(Integer.valueOf(intValue5), Integer.valueOf(intValue4), Integer.valueOf(intValue5), Integer.valueOf(Utils.convertCssSizeToPx(split[2]).intValue()));
                return;
            }
            if (split.length == 4) {
                setPadding(Integer.valueOf(Utils.convertCssSizeToPx(split[3]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[0]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[1]).intValue()), Integer.valueOf(Utils.convertCssSizeToPx(split[2]).intValue()));
            }
        }
    }
}
