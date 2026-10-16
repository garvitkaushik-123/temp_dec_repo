package com.mbridge.msdk.foundation.cache;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.j0;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CandidateEntity.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f4195a;
    private double b;
    private String c;
    private String d;
    private int e;
    private long f;
    private int g;
    private long h;
    private String i;
    private long j;

    public void a(long j) {
        this.j = j;
    }

    public double b() {
        return this.b;
    }

    public long c() {
        return this.j;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.g;
    }

    public long h() {
        return this.h;
    }

    public CopyOnWriteArrayList<CampaignEx> a() {
        return this.f4195a;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.i = str;
    }

    public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f4195a = copyOnWriteArrayList;
    }

    public void b(int i) {
        this.g = i;
    }

    public void c(long j) {
        this.h = j;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = j0.a(str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        try {
            double parseDouble = Double.parseDouble(a2);
            if (parseDouble <= 0.0d) {
                return;
            }
            this.b = parseDouble;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(long j) {
        this.f = j;
    }

    public void a(int i) {
        this.e = i;
    }
}
