package com.inmobi.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.n9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2779n9 {
    public static ViewGroup.LayoutParams a(C2613d8 asset, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(parent, "parent");
        C2630e8 c2630e8 = asset.d;
        Point point = c2630e8.f2560a;
        Point point2 = c2630e8.c;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(a(point.x), a(point.y));
        if (parent instanceof C2714j8) {
            C2697i8 c2697i8 = new C2697i8(a(point.x), a(point.y));
            int a2 = a(point2.x);
            int a3 = a(point2.y);
            c2697i8.f2598a = a2;
            c2697i8.b = a3;
            return c2697i8;
        }
        if (parent instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a(point.x), a(point.y));
            layoutParams2.setMargins(a(point2.x), a(point2.y), 0, 0);
            return layoutParams2;
        }
        if (parent instanceof AbsListView) {
            return new AbsListView.LayoutParams(a(point.x), a(point.y));
        }
        if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a(point.x), a(point.y));
            layoutParams3.setMargins(a(point2.x), a(point2.y), 0, 0);
            return layoutParams3;
        }
        HashMap hashMap = D9.c;
        Intrinsics.checkNotNullExpressionValue("D9", "access$getTAG$cp(...)");
        return layoutParams;
    }

    public static int a(int i) {
        int i2;
        return ((((Context) D9.e.get()) instanceof InMobiAdActivity) || (i2 = D9.f) == 0) ? i : (int) (((i2 * 1.0d) / D9.g) * i);
    }

    public static void a(Context context, ImageView imageView) {
        if (imageView.getDrawable() == null) {
            float f = U3.d().c;
            C2950y3 c2950y3 = new C2950y3(context, (byte) 0, null);
            c2950y3.layout(0, 0, (int) (a(40) * f), (int) (a(40) * f));
            Bitmap createBitmap = Bitmap.createBitmap((int) (a(40) * f), (int) (a(40) * f), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            c2950y3.draw(new Canvas(createBitmap));
            imageView.setImageBitmap(createBitmap);
        }
    }

    public static final void a(TextView textView, ArrayList arrayList) {
        HashMap hashMap = D9.c;
        int paintFlags = textView.getPaintFlags();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode != -1026963764) {
                    if (hashCode != -891985998) {
                        if (hashCode == 3029637 && str.equals("bold")) {
                            i |= 1;
                        }
                    } else if (str.equals("strike")) {
                        paintFlags |= 16;
                    }
                } else if (str.equals("underline")) {
                    paintFlags |= 8;
                }
            } else if (str.equals("italic")) {
                i |= 2;
            }
        }
        textView.setTypeface(Typeface.DEFAULT, i);
        textView.setPaintFlags(paintFlags);
    }

    public static void a(View view, C2630e8 assetStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        int parseColor = Color.parseColor("#00000000");
        try {
            parseColor = Color.parseColor(assetStyle.a());
        } catch (IllegalArgumentException e) {
            HashMap hashMap = D9.c;
            Intrinsics.checkNotNullExpressionValue("D9", "access$getTAG$cp(...)");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        view.setBackgroundColor(parseColor);
        if (Intrinsics.areEqual("line", assetStyle.e)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(parseColor);
            if (Intrinsics.areEqual("curved", assetStyle.f)) {
                gradientDrawable.setCornerRadius(assetStyle.h);
            }
            int parseColor2 = Color.parseColor("#ff000000");
            try {
                String str = assetStyle.i;
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = str.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                parseColor2 = Color.parseColor(lowerCase);
            } catch (IllegalArgumentException e2) {
                HashMap hashMap2 = D9.c;
                Intrinsics.checkNotNullExpressionValue("D9", "access$getTAG$cp(...)");
                S5 s52 = S5.f2425a;
                C2640f2 event2 = new C2640f2(e2);
                Intrinsics.checkNotNullParameter(event2, "event");
                S5.d.a(event2);
            }
            gradientDrawable.setStroke(1, parseColor2);
            view.setBackground(gradientDrawable);
        }
    }

    public static final void a(View view) {
        HashMap hashMap = D9.c;
        view.setBackground(null);
    }
}
