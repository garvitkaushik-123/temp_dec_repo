package com.mbridge.msdk.dycreator.engine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ironsource.D5;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.utils.e;
import com.mbridge.msdk.dycreator.utils.g;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: MBResource.java */
/* loaded from: classes6.dex */
public class b {
    private static volatile b g;

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<HashMap<String, c>> f4168a;
    private SoftReference<HashMap<String, String>> b;
    private SoftReference<HashMap<String, c>> c;
    private String d;
    private String e;
    private Context f;

    private b() {
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public HashMap b() {
        SoftReference<HashMap<String, c>> softReference = this.f4168a;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(45);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("orientation", c.orientation);
            hashMap.put("layout_centerHorizontal", c.layout_centerHorizontal);
            hashMap.put("layout_centerVertical", c.layout_centerVertical);
            c cVar = c.layout_marginLeft;
            hashMap.put("layout_marginLeft", cVar);
            c cVar2 = c.layout_marginRight;
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_margin", c.layout_margin);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("layout_alignParentRight", c.layout_alignParentRight);
            hashMap.put("layout_weight", c.layout_weight);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("gravity", c.gravity);
            hashMap.put("id", c.id);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_above", c.layout_above);
            hashMap.put("layout_toLeftOf", c.layout_toLeftOf);
            hashMap.put("layout_toRightOf", c.layout_toRightOf);
            hashMap.put("layout_toEndOf", c.layout_toEndOf);
            hashMap.put("background", c.background);
            hashMap.put("layout_marginTop", c.layout_marginTop);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("layout_marginLeft", cVar);
            hashMap.put("layout_marginRight", cVar2);
            hashMap.put("layout_alignParentBottom", c.layout_alignParentBottom);
            hashMap.put("layout_alignParentTop", c.layout_alignParentTop);
            hashMap.put("layout_alignParentLeft", c.layout_alignParentLeft);
            hashMap.put("layout_alignWithParentIfMissing", c.layout_alignWithParentIfMissing);
            hashMap.put("layout_alignTop", c.layout_alignTop);
            hashMap.put("layout_alignBottom", c.layout_alignBottom);
            hashMap.put("layout_alignLeft", c.layout_alignLeft);
            hashMap.put("layout_alignRight", c.layout_alignRight);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("layout_alignParentEnd", c.layout_alignParentEnd);
            this.f4168a = new SoftReference<>(hashMap);
        }
        return this.f4168a.get();
    }

    public HashMap<String, c> c() {
        SoftReference<HashMap<String, c>> softReference = this.c;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(55);
            hashMap.put("id", c.id);
            hashMap.put("text", c.text);
            hashMap.put("ellipsize", c.ellipsize);
            hashMap.put("singleLine", c.singleLine);
            hashMap.put("lines", c.lines);
            hashMap.put("maxLength", c.maxLength);
            hashMap.put("drawableLeft", c.drawableLeft);
            hashMap.put("drawablePadding", c.drawablePadding);
            hashMap.put("fadingEdge", c.fadingEdge);
            hashMap.put("scrollHorizontally", c.scrollHorizontally);
            hashMap.put("textColor", c.textColor);
            hashMap.put("textSize", c.textSize);
            hashMap.put("visibility", c.visibility);
            c cVar = c.background;
            hashMap.put("background", cVar);
            hashMap.put("textStyle", c.textStyle);
            hashMap.put("style", c.style);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("src", c.src);
            hashMap.put("gravity", c.gravity);
            hashMap.put("orientation", c.orientation);
            hashMap.put("numColumns", c.numColumns);
            hashMap.put("verticalSpacing", c.verticalSpacing);
            hashMap.put("horizontalSpacing", c.horizontalSpacing);
            hashMap.put("background", cVar);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("scaleType", c.scaleType);
            hashMap.put("tag", c.tag);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("parent_view", c.parent_view);
            hashMap.put(VastAttributes.PADDING, c.padding);
            hashMap.put("paddingTop", c.paddingTop);
            hashMap.put("paddingBottom", c.paddingBottom);
            hashMap.put("paddingLeft", c.paddingLeft);
            hashMap.put("paddingRight", c.paddingRight);
            hashMap.put("divider", c.divider);
            hashMap.put("scrollbars", c.scrollbars);
            hashMap.put("listSelector", c.listSelector);
            this.c = new SoftReference<>(hashMap);
        }
        return this.c.get();
    }

    public int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (!str.startsWith("#")) {
            if (!str.startsWith("@color/")) {
                return -16777216;
            }
            return com.mbridge.msdk.foundation.controller.c.m().d().getColor(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str.substring(7), "color"));
        }
        int length = str.length();
        if (length == 7) {
            return (int) Long.decode(str.replace("#", "#FF")).longValue();
        }
        if (length == 9) {
            return (int) Long.decode(str).longValue();
        }
        g.a("返回白色背景");
        return -1;
    }

    public View e(String str) {
        if (this.f != null) {
            try {
                a aVar = new a(this.f);
                new String();
                g.a(str.toString());
                return aVar.a(str, (ViewGroup) null);
            } catch (Exception e) {
                p0.b("MBResource", e.getMessage());
            }
        }
        return null;
    }

    public String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("@")) {
            return str;
        }
        SoftReference<HashMap<String, String>> softReference = this.b;
        if (softReference == null || softReference.get() == null) {
            this.b = new SoftReference<>(d());
        }
        String substring = str.substring(8);
        if (this.b.get() == null || this.b.get().size() <= 0) {
            return null;
        }
        String str2 = this.b.get().get(substring);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return com.mbridge.msdk.foundation.controller.c.m().d().getString(h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), substring, "string"));
        } catch (Exception e) {
            p0.b("MBResource", e.getMessage());
            return null;
        }
    }

    public void a(Context context, String str) {
        try {
            if (g.f4179a) {
                this.d = context.getFilesDir().toString();
            } else {
                this.d = str;
            }
            if (e.a(context).heightPixels > 320) {
                if (g.f4179a) {
                    this.e = "/drawable-mdpi/";
                } else {
                    this.e = "/drawable-hdpi/";
                }
            } else {
                this.e = "/drawable-mdpi/";
            }
            this.f = context;
            com.mbridge.msdk.dycreator.utils.b.f4177a = a().d();
        } catch (Exception e) {
            p0.b("MBResource", e.getMessage());
        }
    }

    public HashMap<String, String> d() {
        InputStream inputStream;
        try {
            inputStream = this.f.getAssets().open("rv_binddatas.xml");
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, D5.N);
            HashMap<String, String> hashMap = new HashMap<>();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if ("string".equals(newPullParser.getName())) {
                        hashMap.put(newPullParser.getAttributeValue(0), newPullParser.nextText());
                    }
                }
            }
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        try {
            if (e.a(context).heightPixels > 320) {
                if (g.f4179a) {
                    this.e = "/drawable-mdpi/";
                } else {
                    this.e = "/drawable-hdpi/";
                }
            } else {
                this.e = "/drawable-mdpi/";
            }
            this.f = context;
            com.mbridge.msdk.dycreator.utils.b.f4177a = a().d();
        } catch (Exception e) {
            p0.b("MBResource", e.getMessage());
        }
    }

    public GradientDrawable a(String[] strArr) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
            gradientDrawable.setGradientType(0);
            return gradientDrawable;
        } catch (Exception e) {
            p0.b("MBResource", e.getMessage());
            return null;
        }
    }

    public int b(String str) {
        String[] split = str.toUpperCase().split("\\|");
        int i = 48;
        try {
            Class<?> cls = Class.forName("android.view.Gravity");
            for (String str2 : split) {
                i = cls.getField(str2).getInt(null);
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public int c(String str) {
        if (this.f == null) {
            return 0;
        }
        String h = com.mbridge.msdk.foundation.controller.c.m().h();
        if (TextUtils.isEmpty(h)) {
            h = this.f.getPackageName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h);
        sb.append(".R$");
        String[] split = str.split("\\.");
        sb.append(split[1]);
        try {
            Class<?> cls = Class.forName(sb.toString());
            Object newInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField(split[2]);
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(newInstance)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            int indexOf = str.indexOf("d");
            int indexOf2 = str.indexOf("s");
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            if (str.contains("d")) {
                return e.a(this.f, parseInt);
            }
            str.contains("s");
            return parseInt;
        }
    }

    public void a(String str, ImageView imageView) {
        Context context;
        if (str == null || !str.startsWith("@drawable/") || (context = this.f) == null) {
            return;
        }
        try {
            Resources resources = context.getResources();
            String h = com.mbridge.msdk.foundation.controller.c.m().h();
            if (TextUtils.isEmpty(h)) {
                h = this.f.getPackageName();
            }
            imageView.setImageResource(resources.getIdentifier(str, "drawable", h));
        } catch (Exception e) {
            p0.b("MBResource", e.getMessage());
        }
    }
}
