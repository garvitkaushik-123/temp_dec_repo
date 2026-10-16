package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public class o2 {

    /* renamed from: a, reason: collision with root package name */
    protected c f607a;
    protected boolean b;
    protected SpannedString c;
    protected SpannedString d;
    protected String e;
    protected String f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected boolean m;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final c f608a;
        boolean b;
        SpannedString c;
        SpannedString d;
        String e;
        String f;
        int g = 0;
        int h = 0;
        int i = -16777216;
        int j = -16777216;
        int k = 0;
        int l = 0;
        boolean m;

        public b(c cVar) {
            this.f608a = cVar;
        }

        public b a(boolean z) {
            this.b = z;
            return this;
        }

        public b b(SpannedString spannedString) {
            this.c = spannedString;
            return this;
        }

        public b c(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b d(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b a(SpannedString spannedString) {
            this.d = spannedString;
            return this;
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b a(String str) {
            this.f = str;
            return this;
        }

        public b b(int i) {
            this.l = i;
            return this;
        }

        public b c(int i) {
            this.j = i;
            return this;
        }

        public b d(int i) {
            this.i = i;
            return this;
        }

        public b a(int i) {
            this.h = i;
            return this;
        }

        public b b(boolean z) {
            this.m = z;
            return this;
        }

        public b a(Context context) {
            this.h = R.drawable.applovin_ic_disclosure_arrow;
            this.l = m0.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public o2 a() {
            return new o2(this);
        }
    }

    public enum c {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);


        /* renamed from: a, reason: collision with root package name */
        private final int f609a;

        c(int i) {
            this.f609a = i;
        }

        public int b() {
            return this == SECTION ? R.layout.mediation_debugger_list_section : this == SECTION_CENTERED ? R.layout.mediation_debugger_list_section_centered : this == SIMPLE ? android.R.layout.simple_list_item_1 : this == DETAIL ? R.layout.applovin_debugger_list_item_detail : R.layout.mediation_debugger_list_item_right_detail;
        }

        public int c() {
            return this.f609a;
        }
    }

    public static b a() {
        return a(c.RIGHT_DETAIL);
    }

    public static int n() {
        return c.COUNT.c();
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.l;
    }

    public SpannedString f() {
        return this.d;
    }

    public int g() {
        return this.j;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.f607a.b();
    }

    public SpannedString k() {
        return this.c;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.f607a.c();
    }

    public boolean o() {
        return this.b;
    }

    public boolean p() {
        return this.m;
    }

    protected o2(c cVar) {
        this.g = 0;
        this.h = 0;
        this.i = -16777216;
        this.j = -16777216;
        this.k = 0;
        this.l = 0;
        this.f607a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    private o2(b bVar) {
        this.g = 0;
        this.h = 0;
        this.i = -16777216;
        this.j = -16777216;
        this.k = 0;
        this.l = 0;
        this.f607a = bVar.f608a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
    }
}
