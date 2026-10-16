package com.mbridge.msdk.dycreator.utils;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.dycreator.baseview.MBHorizontalScrollView;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.playercommon.PlayerView;
import java.util.HashMap;

/* compiled from: AttributeUtil.java */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: AttributeUtil.java */
    /* renamed from: com.mbridge.msdk.dycreator.utils.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0326a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4176a;

        static {
            int[] iArr = new int[com.mbridge.msdk.dycreator.engine.c.values().length];
            f4176a = iArr;
            try {
                iArr[com.mbridge.msdk.dycreator.engine.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.visibility.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.padding.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingTop.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingLeft.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingRight.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingStart.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.paddingEnd.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.orientation.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.ellipsize.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.fadingEdge.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.scrollHorizontally.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.textColor.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.textSize.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.textStyle.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.style.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.tag.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.gravity.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.verticalSpacing.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.numColumns.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.splitMotionEvents.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.cacheColorHint.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.horizontalSpacing.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.singleLine.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.lines.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.drawableLeft.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.drawablePadding.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.src.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.scaleType.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.divider.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.scrollbars.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f4176a[com.mbridge.msdk.dycreator.engine.c.listSelector.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    private static void a() {
    }

    public static void a(View view, AttributeSet attributeSet) {
        if (view == null || attributeSet == null) {
            return;
        }
        try {
            HashMap<String, com.mbridge.msdk.dycreator.engine.c> c = com.mbridge.msdk.dycreator.engine.b.a().c();
            if (c != null && !c.isEmpty()) {
                int attributeCount = attributeSet.getAttributeCount();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < attributeCount; i5++) {
                    com.mbridge.msdk.dycreator.engine.c cVar = c.get(attributeSet.getAttributeName(i5));
                    if (cVar != null) {
                        switch (C0326a.f4176a[cVar.ordinal()]) {
                            case 1:
                                b(view, attributeSet.getAttributeValue(i5));
                                break;
                            case 2:
                                c(view, attributeSet.getAttributeValue(i5));
                                break;
                            case 3:
                                d(view, attributeSet.getAttributeValue(i5));
                                break;
                            case 4:
                                a(view, attributeSet.getAttributeValue(i5));
                                break;
                            case 5:
                                int a2 = com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5));
                                view.setPadding(a2, a2, a2, a2);
                                break;
                            case 6:
                                i2 = com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5));
                                view.setPadding(i, i2, i3, i4);
                                break;
                            case 7:
                                i4 = com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5));
                                view.setPadding(i, i2, i3, i4);
                                break;
                            case 8:
                                i = com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5));
                                view.setPadding(i, i2, i3, i4);
                                break;
                            case 9:
                                i3 = com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5));
                                view.setPadding(i, i2, i3, i4);
                                break;
                            case 10:
                                view.setPadding(com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5)), i2, i3, i4);
                                break;
                            case 11:
                                view.setPadding(i, i2, com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i5)), i4);
                                break;
                        }
                        if (view instanceof EditText) {
                            a();
                        } else if (view instanceof Button) {
                            a((Button) view, cVar, attributeSet, i5);
                        } else if (view instanceof TextView) {
                            a((TextView) view, cVar, attributeSet, i5);
                        } else if (view instanceof ImageView) {
                            a((ImageView) view, cVar, attributeSet, i5);
                        } else if (view instanceof ListView) {
                            a((ListView) view, cVar, attributeSet, i5);
                        } else if (view instanceof GridView) {
                            a((GridView) view, cVar, attributeSet, i5);
                        } else if (view instanceof ScrollView) {
                            a((ScrollView) view, cVar, attributeSet, i5);
                        } else if (view instanceof PlayerView) {
                            a((PlayerView) view, cVar, attributeSet, i5);
                        } else if (view instanceof MBHorizontalScrollView) {
                            a((MBHorizontalScrollView) view, cVar, attributeSet, i5);
                        } else if (view instanceof LinearLayout) {
                            a((LinearLayout) view, cVar, attributeSet, i5);
                        } else if (view instanceof RelativeLayout) {
                            a((RelativeLayout) view, cVar, attributeSet, i5);
                        } else if (view instanceof FrameLayout) {
                            a((FrameLayout) view, cVar, attributeSet, i5);
                        }
                    }
                }
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(FrameLayout frameLayout, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
    }

    private static void a(ScrollView scrollView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
    }

    private static void a(MBHorizontalScrollView mBHorizontalScrollView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025 A[Catch: Exception -> 0x002d, TRY_LEAVE, TryCatch #0 {Exception -> 0x002d, blocks: (B:2:0x0000, B:4:0x000a, B:6:0x001f, B:8:0x0025, B:13:0x0011, B:15:0x0019), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(View view, String str) {
        String substring;
        try {
            String str2 = "";
            if (!str.startsWith("@+id/")) {
                if (str.startsWith("@id/")) {
                    substring = str.substring(4);
                }
                if (TextUtils.isEmpty(str2)) {
                    view.setId(str2.hashCode());
                    return;
                }
                return;
            }
            substring = str.substring(5);
            str2 = substring;
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void c(View view, String str) {
        String[] strArr;
        try {
            if (!str.startsWith("#")) {
                if (str.startsWith("@color/")) {
                    view.setBackgroundColor(com.mbridge.msdk.dycreator.engine.b.a().d(str));
                    return;
                } else {
                    if (str.startsWith("@drawable/")) {
                        view.setBackgroundResource(com.mbridge.msdk.foundation.controller.c.m().d().getResources().getIdentifier(str.substring(10), "drawable", com.mbridge.msdk.foundation.controller.c.m().d().getPackageName()));
                        return;
                    }
                    return;
                }
            }
            try {
                strArr = str.split("-");
            } catch (Exception unused) {
                strArr = null;
            }
            if (strArr != null && strArr.length <= 2) {
                view.setBackgroundColor(com.mbridge.msdk.dycreator.engine.b.a().d(str));
                return;
            }
            if (strArr == null || strArr.length != 3) {
                return;
            }
            GradientDrawable a2 = com.mbridge.msdk.dycreator.engine.b.a().a(strArr);
            if (a2 != null) {
                view.setBackground(a2);
            } else {
                view.setBackgroundColor(com.mbridge.msdk.dycreator.engine.b.a().d(str));
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void d(View view, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals("invisible")) {
                view.setVisibility(4);
            } else if (str.equalsIgnoreCase("gone")) {
                view.setVisibility(8);
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(PlayerView playerView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            if (C0326a.f4176a[cVar.ordinal()] != 12) {
                return;
            }
            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                playerView.setOrientation(0);
            } else {
                playerView.setOrientation(1);
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(Button button, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            switch (C0326a.f4176a[cVar.ordinal()]) {
                case 13:
                    button.setText(com.mbridge.msdk.dycreator.engine.b.a().f(attributeSet.getAttributeValue(i)));
                    break;
                case 14:
                    if (attributeSet.getAttributeBooleanValue(i, false)) {
                        button.setFocusable(true);
                        button.setFocusableInTouchMode(true);
                        button.setSingleLine(true);
                        button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                        button.setMarqueeRepeatLimit(1000);
                        button.setSingleLine();
                        button.setHorizontallyScrolling(true);
                        button.requestFocus();
                        break;
                    }
                    break;
                case 15:
                    button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                    break;
                case 16:
                    button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i, false));
                    break;
                case 17:
                    button.setTextColor(com.mbridge.msdk.dycreator.engine.b.a().d(attributeSet.getAttributeValue(i)));
                    break;
                case 18:
                    if (!TextUtils.isEmpty(attributeSet.getAttributeValue(i))) {
                        button.setTextSize(com.mbridge.msdk.dycreator.engine.b.a().a(r4));
                        break;
                    }
                    break;
                case 19:
                    if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                        button.setTypeface(Typeface.defaultFromStyle(1));
                        break;
                    }
                    break;
                case 20:
                    String attributeValue = attributeSet.getAttributeValue(i);
                    button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.dycreator.engine.b.a().c("R.style." + attributeValue.substring(attributeValue.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1)));
                    break;
                case 21:
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue2)) {
                        String str = b.f4177a.get(attributeValue2.substring(8));
                        if (!TextUtils.isEmpty(str)) {
                            button.setTag(str);
                            break;
                        }
                    }
                    break;
                case 22:
                    button.setGravity(1);
                    break;
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(GridView gridView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        int i2;
        try {
            i2 = C0326a.f4176a[cVar.ordinal()];
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
            return;
        }
        if (i2 != 1) {
            switch (i2) {
                case 23:
                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i))));
                    break;
                case 24:
                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i, 2));
                    break;
                case 25:
                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i).equals("false"));
                    break;
                case 26:
                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.engine.b.a().d(attributeSet.getAttributeValue(i)));
                    break;
                case 27:
                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i))));
                    break;
            }
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(i);
        if (attributeValue.startsWith("@+id/")) {
            gridView.setId(attributeValue.substring(5).hashCode());
        }
    }

    private static void a(View view, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = b.f4177a.get(str.substring(8));
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            view.setContentDescription(str2);
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(LinearLayout linearLayout, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            if (C0326a.f4176a[cVar.ordinal()] != 12) {
                return;
            }
            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                linearLayout.setOrientation(0);
            } else {
                linearLayout.setOrientation(1);
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(RelativeLayout relativeLayout, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            if (C0326a.f4176a[cVar.ordinal()] != 22) {
                return;
            }
            relativeLayout.setGravity(com.mbridge.msdk.dycreator.engine.b.a().b(attributeSet.getAttributeValue(i)));
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(TextView textView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            int i2 = C0326a.f4176a[cVar.ordinal()];
            switch (i2) {
                case 13:
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.startsWith("@string/")) {
                            textView.setText(com.mbridge.msdk.dycreator.engine.b.a().f(attributeSet.getAttributeValue(i)));
                            break;
                        } else {
                            textView.setText(attributeValue);
                            break;
                        }
                    }
                    break;
                case 14:
                    String attributeValue2 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue2)) {
                        if (attributeValue2.equals("end")) {
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                        }
                        if (attributeValue2.equals("start")) {
                            textView.setEllipsize(TextUtils.TruncateAt.START);
                        }
                        if (attributeValue2.equals("middle")) {
                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                        }
                        if (attributeValue2.equals("marquee")) {
                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                            break;
                        }
                    }
                    break;
                case 15:
                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i, false));
                    break;
                case 16:
                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i, false));
                    break;
                case 17:
                    textView.setTextColor(com.mbridge.msdk.dycreator.engine.b.a().d(attributeSet.getAttributeValue(i)));
                    break;
                case 18:
                    if (!TextUtils.isEmpty(attributeSet.getAttributeValue(i))) {
                        textView.setTextSize(com.mbridge.msdk.dycreator.engine.b.a().a(r4));
                        break;
                    }
                    break;
                case 19:
                    if ("bold".equalsIgnoreCase(attributeSet.getAttributeValue(i))) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                        break;
                    }
                    break;
                case 20:
                    String attributeValue3 = attributeSet.getAttributeValue(i);
                    com.mbridge.msdk.dycreator.engine.b.a().c("R.style." + attributeValue3.substring(attributeValue3.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1));
                    break;
                case 21:
                    String attributeValue4 = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeValue4)) {
                        String str = b.f4177a.get(attributeValue4.substring(8));
                        if (!TextUtils.isEmpty(str)) {
                            textView.setTag(str);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                case 22:
                    textView.setGravity(com.mbridge.msdk.dycreator.engine.b.a().b(attributeSet.getAttributeValue(i)));
                    break;
                default:
                    switch (i2) {
                        case 28:
                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i, false));
                            break;
                        case 29:
                            textView.setLines(attributeSet.getAttributeIntValue(i, 1));
                            break;
                        case 30:
                            String attributeValue5 = attributeSet.getAttributeValue(i);
                            String str2 = "";
                            if (attributeValue5.startsWith("@drawable/")) {
                                str2 = attributeValue5.substring(10);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                textView.setCompoundDrawables(textView.getResources().getDrawable(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str2, "drawable")), null, null, null);
                                break;
                            }
                            break;
                        case 31:
                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i)));
                            break;
                    }
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(ImageView imageView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            int i2 = C0326a.f4176a[cVar.ordinal()];
            if (i2 == 32) {
                com.mbridge.msdk.dycreator.engine.b.a().a(attributeSet.getAttributeValue(i), imageView);
                return;
            }
            if (i2 != 33) {
                return;
            }
            String attributeValue = attributeSet.getAttributeValue(i);
            if (TextUtils.isEmpty(attributeValue)) {
                return;
            }
            if (attributeValue.equals("fitXY")) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            }
            if (attributeValue.equals("centerInside")) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else if (attributeValue.equals("centerCrop")) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if (attributeValue.equals("fitStart")) {
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
            }
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }

    private static void a(ListView listView, com.mbridge.msdk.dycreator.engine.c cVar, AttributeSet attributeSet, int i) {
        try {
            int i2 = C0326a.f4176a[cVar.ordinal()];
            if (i2 == 25) {
                listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i).equals("false"));
                return;
            }
            if (i2 != 26) {
                switch (i2) {
                    case 34:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue) && attributeValue.startsWith("@null")) {
                            listView.setDivider(null);
                            break;
                        }
                        break;
                    case 35:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue2)) {
                            if (attributeValue2.equals("none")) {
                                listView.setVerticalScrollBarEnabled(false);
                            }
                            if (attributeValue2.equals("false")) {
                                listView.setScrollbarFadingEnabled(false);
                                break;
                            }
                        }
                        break;
                    case 36:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            listView.setSelector(com.mbridge.msdk.dycreator.engine.b.a().d(attributeValue3));
                            break;
                        }
                        break;
                }
                return;
            }
            listView.setCacheColorHint(com.mbridge.msdk.dycreator.engine.b.a().d(attributeSet.getAttributeValue(i)));
        } catch (Exception e) {
            p0.b("AttributeUtil", e.getMessage());
        }
    }
}
