package com.inmobi.media;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.inmobi.commons.core.configs.AdConfig;
import com.squareup.picasso.Callback;
import com.squareup.picasso.RequestCreator;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class D9 {
    public static volatile WeakReference d;

    /* renamed from: a, reason: collision with root package name */
    public int f2263a;
    public final HashMap b;
    public static final HashMap c = MapsKt.hashMapOf(TuplesKt.to(J8.class, (byte) 0), TuplesKt.to(Sc.class, (byte) 1), TuplesKt.to(Rc.class, (byte) 2), TuplesKt.to(C2714j8.class, (byte) 3), TuplesKt.to(ImageView.class, (byte) 6), TuplesKt.to(C2763m9.class, (byte) 7), TuplesKt.to(C2812p9.class, (byte) 4), TuplesKt.to(Button.class, (byte) 5), TuplesKt.to(T8.class, (byte) 8), TuplesKt.to(GestureDetectorOnGestureListenerC2634ec.class, (byte) 9), TuplesKt.to(K4.class, (byte) 10));
    public static WeakReference e = new WeakReference(null);
    public static int f = 1;
    public static int g = 1;

    public D9(Context context) {
        e = new WeakReference(context);
        this.b = MapsKt.hashMapOf(TuplesKt.to((byte) 0, new C2924w9(this)), TuplesKt.to((byte) 3, new C2859s9(this)), TuplesKt.to((byte) 1, new B9(this)), TuplesKt.to((byte) 2, new C2940x9(this)), TuplesKt.to((byte) 6, new C2908v9(this)), TuplesKt.to((byte) 10, new C2892u9(this)), TuplesKt.to((byte) 7, new A9(this)), TuplesKt.to((byte) 4, new C2959y9(this)), TuplesKt.to((byte) 5, new C2876t9(this)), TuplesKt.to((byte) 8, new C2975z9(this)), TuplesKt.to((byte) 9, new C9(this)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006c, code lost:
    
        if (r3.equals("IMAGE") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
    
        r3 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0080, code lost:
    
        if (r3.equals("ICON") == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View a(Context context, C2613d8 asset, AdConfig adConfig) {
        byte b;
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(asset, "nativeAsset");
        if (!(asset instanceof C2681h8)) {
            String str = asset.c;
            switch (str.hashCode()) {
                case 67056:
                    if (str.equals(VastTagName.CTA)) {
                        b = 5;
                        break;
                    }
                    b = -1;
                    break;
                case 70564:
                    if (str.equals("GIF")) {
                        b = 10;
                        break;
                    }
                    b = -1;
                    break;
                case 2241657:
                    break;
                case 2571565:
                    if (str.equals("TEXT")) {
                        b = 4;
                        break;
                    }
                    b = -1;
                    break;
                case 69775675:
                    break;
                case 79826725:
                    if (str.equals("TIMER")) {
                        b = 8;
                        break;
                    }
                    b = -1;
                    break;
                case 81665115:
                    if (str.equals("VIDEO")) {
                        b = 7;
                        break;
                    }
                    b = -1;
                    break;
                case 1942407129:
                    if (str.equals("WEBVIEW")) {
                        b = 9;
                        break;
                    }
                    b = -1;
                    break;
                default:
                    b = -1;
                    break;
            }
        } else {
            C2681h8 c2681h8 = (C2681h8) asset;
            if (c2681h8.C) {
                b = 0;
            } else if (c2681h8.D) {
                byte b2 = c2681h8.z;
                b = (b2 != 0 && b2 == 1) ? (byte) 2 : (byte) 1;
            } else {
                b = 3;
            }
        }
        if (-1 == b) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            return null;
        }
        AbstractC2843r9 abstractC2843r9 = (AbstractC2843r9) this.b.get(Byte.valueOf(b));
        if (abstractC2843r9 == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        e = new WeakReference(context);
        if (abstractC2843r9.f2694a.isEmpty()) {
            abstractC2843r9.b++;
            view = abstractC2843r9.a(context);
        } else {
            abstractC2843r9.c++;
            view = (View) CollectionsKt.removeFirst(abstractC2843r9.f2694a);
            D9 d9 = abstractC2843r9.d;
            d9.f2263a--;
        }
        if (view != null) {
            abstractC2843r9.a(view, asset, adConfig);
        }
        return view;
    }

    public final void b(View view) {
        Byte b = (Byte) c.get(view.getClass());
        byte byteValue = b != null ? b.byteValue() : (byte) -1;
        if (-1 == byteValue) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            view.toString();
            return;
        }
        AbstractC2843r9 abstractC2843r9 = (AbstractC2843r9) this.b.get(Byte.valueOf(byteValue));
        if (abstractC2843r9 == null) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            return;
        }
        if (this.f2263a >= 300) {
            Iterator it = this.b.entrySet().iterator();
            int i = 0;
            AbstractC2843r9 abstractC2843r92 = null;
            while (it.hasNext()) {
                AbstractC2843r9 abstractC2843r93 = (AbstractC2843r9) ((Map.Entry) it.next()).getValue();
                if (abstractC2843r93.f2694a.size() > i) {
                    i = abstractC2843r93.f2694a.size();
                    abstractC2843r92 = abstractC2843r93;
                }
            }
            if (abstractC2843r92 != null && abstractC2843r92.f2694a.size() > 0) {
                CollectionsKt.removeFirst(abstractC2843r92.f2694a);
            }
        }
        abstractC2843r9.a(view);
    }

    public static final void a(D9 d9, Button button, C2613d8 c2613d8) {
        d9.getClass();
        C2630e8 c2630e8 = c2613d8.d;
        Intrinsics.checkNotNull(c2630e8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeCtaAsset.NativeCtaAssetStyle");
        C2730k8 c2730k8 = (C2730k8) c2630e8;
        button.setLayoutParams(new ViewGroup.LayoutParams(C2779n9.a(c2730k8.f2560a.x), C2779n9.a(c2730k8.f2560a.y)));
        Object obj = c2613d8.e;
        button.setText(obj instanceof CharSequence ? (CharSequence) obj : null);
        button.setTextSize(1, C2779n9.a(c2730k8.l));
        int parseColor = Color.parseColor("#ff000000");
        try {
            String str = c2730k8.n;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            parseColor = Color.parseColor(lowerCase);
        } catch (IllegalArgumentException e2) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        button.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(c2730k8.a());
        } catch (IllegalArgumentException e3) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            S5 s52 = S5.f2425a;
            C2640f2 event2 = new C2640f2(e3);
            Intrinsics.checkNotNullParameter(event2, "event");
            S5.d.a(event2);
        }
        button.setBackgroundColor(parseColor2);
        button.setTextAlignment(4);
        button.setGravity(17);
        C2779n9.a(button, c2730k8.o);
        C2779n9.a(button, c2730k8);
    }

    public static final void a(D9 d9, ImageView imageView, C2613d8 c2613d8) {
        int i;
        int i2;
        int i3;
        String str;
        d9.getClass();
        Object obj = c2613d8.e;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null) {
            int a2 = C2779n9.a(c2613d8.d.f2560a.x);
            int a3 = C2779n9.a(c2613d8.d.f2560a.y);
            String str3 = c2613d8.d.g;
            if (Intrinsics.areEqual(str3, "aspectFit")) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (Intrinsics.areEqual(str3, "aspectFill")) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            Context context = (Context) e.get();
            if (context != null && a2 > 0 && a3 > 0) {
                int length = str2.length() - 1;
                int i4 = 0;
                boolean z = false;
                while (i4 <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i4 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z2) {
                        i4++;
                    } else {
                        z = true;
                    }
                }
                if (str2.subSequence(i4, length + 1).toString().length() > 0) {
                    C2960ya c2960ya = C2960ya.f2764a;
                    RequestCreator load = c2960ya.a(context).load(str2);
                    Object a4 = c2960ya.a(new C2828q9(context, imageView, c2613d8));
                    Intrinsics.checkNotNull(a4, "null cannot be cast to non-null type com.squareup.picasso.Callback");
                    load.into(imageView, (Callback) a4);
                    if (StringsKt.equals("cross_button", c2613d8.b, true) && ((str = c2613d8.p) == null || str.length() == 0)) {
                        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC2795o9(context, imageView), 2000L);
                    }
                }
            }
            C2681h8 c2681h8 = c2613d8.r;
            if (c2681h8 == null || !Intrinsics.areEqual("line", c2681h8.d.e)) {
                i = 0;
                i2 = 0;
                i3 = 0;
            } else {
                C2630e8 c2630e8 = c2681h8.d;
                int i5 = c2630e8.c.x == c2613d8.d.c.x ? 1 : 0;
                i2 = C2779n9.a(c2630e8.f2560a.x) == C2779n9.a(c2613d8.d.f2560a.x) + c2613d8.d.c.x ? 1 : 0;
                i3 = C2779n9.a(c2681h8.d.c.y) == C2779n9.a(c2613d8.d.c.y) ? 1 : 0;
                r3 = C2779n9.a(c2681h8.d.f2560a.y) == C2779n9.a(c2613d8.d.c.y) + C2779n9.a(c2613d8.d.f2560a.y) ? 1 : 0;
                if (C2779n9.a(c2681h8.d.f2560a.x) == C2779n9.a(c2613d8.d.f2560a.x)) {
                    i = r3;
                    i2 = 1;
                    r3 = 1;
                } else {
                    i = r3;
                    r3 = i5;
                }
            }
            imageView.setPaddingRelative(r3, i3, i2, i);
            C2779n9.a(imageView, c2613d8.d);
        }
    }

    public static final void a(D9 d9, TextView textView, C2613d8 c2613d8) {
        d9.getClass();
        C2630e8 c2630e8 = c2613d8.d;
        Intrinsics.checkNotNull(c2630e8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeTextAsset.NativeTextAssetStyle");
        M8 m8 = (M8) c2630e8;
        textView.setLayoutParams(new ViewGroup.LayoutParams(C2779n9.a(m8.f2560a.x), C2779n9.a(m8.f2560a.y)));
        Object obj = c2613d8.e;
        textView.setText(obj instanceof CharSequence ? (CharSequence) obj : null);
        textView.setTypeface(Typeface.DEFAULT);
        byte b = m8.m;
        if (b == 0) {
            textView.setGravity(8388627);
        } else if (b == 1) {
            textView.setGravity(8388629);
        } else if (b == 2) {
            textView.setGravity(17);
        } else {
            textView.setGravity(8388627);
        }
        textView.setTextSize(1, C2779n9.a(m8.l));
        int parseColor = Color.parseColor("#ff000000");
        try {
            String str = m8.n;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            parseColor = Color.parseColor(lowerCase);
        } catch (IllegalArgumentException e2) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        textView.setTextColor(parseColor);
        int parseColor2 = Color.parseColor("#00000000");
        try {
            parseColor2 = Color.parseColor(m8.a());
        } catch (IllegalArgumentException e3) {
            Intrinsics.checkNotNullExpressionValue("D9", "TAG");
            S5 s52 = S5.f2425a;
            C2640f2 event2 = new C2640f2(e3);
            Intrinsics.checkNotNullParameter(event2, "event");
            S5.d.a(event2);
        }
        textView.setBackgroundColor(parseColor2);
        textView.setTextAlignment(1);
        C2779n9.a(textView, m8.o);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setHorizontallyScrolling(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        C2779n9.a(textView, m8);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof J8) && !(view instanceof C2714j8)) {
            b(view);
            return;
        }
        C2714j8 c2714j8 = (C2714j8) view;
        if (c2714j8.getChildCount() == 0) {
            b(view);
            return;
        }
        Stack stack = new Stack();
        stack.push(c2714j8);
        while (!stack.isEmpty()) {
            C2714j8 c2714j82 = (C2714j8) stack.pop();
            int childCount = c2714j82.getChildCount();
            while (true) {
                childCount--;
                if (-1 < childCount) {
                    View childAt = c2714j82.getChildAt(childCount);
                    c2714j82.removeViewAt(childCount);
                    if (childAt instanceof C2714j8) {
                        stack.push(childAt);
                    } else {
                        Intrinsics.checkNotNull(childAt);
                        b(childAt);
                    }
                }
            }
            Intrinsics.checkNotNull(c2714j82);
            b(c2714j82);
        }
    }

    public static void a(final T8 t8, C2613d8 c2613d8) {
        long a2;
        t8.setVisibility(4);
        Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeTimerAsset");
        final Q8 q8 = (Q8) c2613d8;
        P8 p8 = q8.x;
        O8 o8 = p8.f2397a;
        O8 o82 = p8.b;
        if (o8 != null) {
            try {
                a2 = o8.a();
            } catch (Exception e2) {
                Intrinsics.checkNotNullExpressionValue("D9", "TAG");
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e2, "event"));
                return;
            }
        } else {
            a2 = 0;
        }
        long a3 = o82 != null ? o82.a() : 0L;
        if (a3 >= 0) {
            t8.setTimerValue(a3);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.D9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    D9.a(Q8.this, t8);
                }
            }, a2 * 1000);
        }
    }

    public static final void a(Q8 timerAsset, T8 timerView) {
        Intrinsics.checkNotNullParameter(timerAsset, "$timerAsset");
        Intrinsics.checkNotNullParameter(timerView, "$timerView");
        if (e.get() != null) {
            if (timerAsset.y) {
                timerView.setVisibility(0);
            }
            timerView.d();
        }
    }
}
