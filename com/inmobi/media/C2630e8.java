package com.inmobi.media;

import android.graphics.Point;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.e8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2630e8 {

    /* renamed from: a, reason: collision with root package name */
    public final Point f2560a;
    public final Point b;
    public final Point c;
    public final Point d;
    public final String e;
    public final String f;
    public final String g;
    public final float h;
    public final String i;
    public final String j;
    public final P8 k;

    public C2630e8() {
        this.f2560a = new Point(0, 0);
        this.c = new Point(0, 0);
        this.b = new Point(0, 0);
        this.d = new Point(0, 0);
        this.e = "none";
        this.f = "straight";
        this.h = 10.0f;
        this.i = "#ff000000";
        this.j = "#00000000";
        this.g = VastAttributes.FILL_COLOR;
        this.k = null;
    }

    public String a() {
        String str = this.j;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public C2630e8(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String contentMode, String borderStrokeStyle, String borderCornerStyle, String borderColor, String backgroundColor, P8 p8) {
        Intrinsics.checkNotNullParameter(contentMode, "contentMode");
        Intrinsics.checkNotNullParameter(borderStrokeStyle, "borderStrokeStyle");
        Intrinsics.checkNotNullParameter(borderCornerStyle, "borderCornerStyle");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.f2560a = new Point(i3, i4);
        this.b = new Point(i7, i8);
        this.c = new Point(i, i2);
        this.d = new Point(i5, i6);
        this.e = borderStrokeStyle;
        this.f = borderCornerStyle;
        this.h = 10.0f;
        this.g = contentMode;
        this.i = borderColor.length() == 0 ? "#ff000000" : borderColor;
        this.j = backgroundColor.length() == 0 ? "#00000000" : backgroundColor;
        this.k = p8;
    }
}
