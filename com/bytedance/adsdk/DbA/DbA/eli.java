package com.bytedance.adsdk.DbA.DbA;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.DbA.Os;
import com.bytedance.adsdk.DbA.Os.kb;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli {
    private final AssetManager aGH;
    private Os ui;
    private final kb<String> eli = new kb<>();
    private final Map<kb<String>, Typeface> DbA = new HashMap();
    private final Map<String, Typeface> Os = new HashMap();
    private String MGA = ".ttf";

    public eli(Drawable.Callback callback, Os os) {
        this.ui = os;
        if (!(callback instanceof View)) {
            this.aGH = null;
        } else {
            this.aGH = ((View) callback).getContext().getAssets();
        }
    }

    public void eli(Os os) {
        this.ui = os;
    }

    public void eli(String str) {
        this.MGA = str;
    }

    public Typeface eli(com.bytedance.adsdk.DbA.Os.Os os) {
        this.eli.eli(os.eli(), os.Os());
        Typeface typeface = this.DbA.get(this.eli);
        if (typeface != null) {
            return typeface;
        }
        Typeface eli = eli(DbA(os), os.Os());
        this.DbA.put(this.eli, eli);
        return eli;
    }

    private Typeface DbA(com.bytedance.adsdk.DbA.Os.Os os) {
        Typeface typeface;
        String eli = os.eli();
        Typeface typeface2 = this.Os.get(eli);
        if (typeface2 != null) {
            return typeface2;
        }
        String Os = os.Os();
        String DbA = os.DbA();
        Os os2 = this.ui;
        if (os2 != null) {
            typeface = os2.eli(eli, Os, DbA);
            if (typeface == null) {
                typeface = this.ui.eli(eli);
            }
        } else {
            typeface = null;
        }
        Os os3 = this.ui;
        if (os3 != null && typeface == null) {
            String DbA2 = os3.DbA(eli, Os, DbA);
            if (DbA2 == null) {
                DbA2 = this.ui.DbA(eli);
            }
            if (DbA2 != null) {
                try {
                    typeface = Typeface.createFromAsset(this.aGH, DbA2);
                } catch (Throwable unused) {
                    typeface = Typeface.DEFAULT;
                }
            }
        }
        if (os.aGH() != null) {
            return os.aGH();
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.aGH, "fonts/" + eli + this.MGA);
            } catch (Throwable unused2) {
                typeface = Typeface.DEFAULT;
            }
        }
        this.Os.put(eli, typeface);
        return typeface;
    }

    private Typeface eli(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
