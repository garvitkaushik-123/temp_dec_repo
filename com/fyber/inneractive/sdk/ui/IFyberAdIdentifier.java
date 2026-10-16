package com.fyber.inneractive.sdk.ui;

import android.view.View;
import com.fyber.inneractive.sdk.config.global.r;

/* loaded from: classes4.dex */
public abstract class IFyberAdIdentifier {

    /* renamed from: a, reason: collision with root package name */
    public ClickListener f1738a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final String h;
    public final String i;
    public final boolean j;
    public Corner k = Corner.BOTTOM_LEFT;
    public final com.fyber.inneractive.sdk.config.global.features.a l;

    public interface ClickListener {
        void a();
    }

    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public IFyberAdIdentifier(r rVar) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = "";
        this.i = "";
        this.j = false;
        this.l = com.fyber.inneractive.sdk.config.global.features.b.e;
        if (rVar != null) {
            com.fyber.inneractive.sdk.config.global.features.b bVar = (com.fyber.inneractive.sdk.config.global.features.b) rVar.a(com.fyber.inneractive.sdk.config.global.features.b.class);
            Integer a2 = bVar.a("ad_identifier_text_size_w");
            this.b = a2 != null ? a2.intValue() : 110;
            Integer a3 = bVar.a("ad_identifier_text_size_h");
            this.c = a3 != null ? a3.intValue() : 18;
            Integer a4 = bVar.a("ad_identifier_image_size_w");
            this.d = a4 != null ? a4.intValue() : 18;
            Integer a5 = bVar.a("ad_identifier_image_size_h");
            this.e = a5 != null ? a5.intValue() : 18;
            Integer a6 = bVar.a("ad_identifier_text_size");
            this.f = a6 != null ? a6.intValue() : 8;
            this.g = bVar.a("ad_identifier_tint_color", "#75DCDCDC");
            this.l = bVar.c();
            this.h = bVar.a("ad_identifier_text", "Tap for more information");
            this.i = bVar.a("ad_identifier_icon_url", null);
            this.j = true;
        }
    }

    public abstract void a(View view);
}
