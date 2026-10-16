package com.ironsource;

import com.ironsource.mediationsdk.model.InterstitialPlacement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* renamed from: com.ironsource.w9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3366w9 {
    private static final int n = 0;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<InterstitialPlacement> f3922a;
    private H1 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private C3241p2 g;
    private boolean h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private InterstitialPlacement m;

    public C3366w9() {
        this.f3922a = new ArrayList<>();
        this.b = new H1();
        this.g = new C3241p2();
    }

    public void a(InterstitialPlacement interstitialPlacement) {
        if (interstitialPlacement != null) {
            this.f3922a.add(interstitialPlacement);
            if (this.m == null) {
                this.m = interstitialPlacement;
            } else if (interstitialPlacement.isPlacementId(0)) {
                this.m = interstitialPlacement;
            }
        }
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.e;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean f() {
        return this.d;
    }

    public C3241p2 g() {
        return this.g;
    }

    public long h() {
        return this.i;
    }

    public H1 i() {
        return this.b;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.k;
    }

    public String toString() {
        return "InterstitialConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C3366w9(int i, boolean z, int i2, H1 h1, C3241p2 c3241p2, int i3, boolean z2, long j, boolean z3, boolean z4, boolean z5) {
        this.f3922a = new ArrayList<>();
        this.c = i;
        this.d = z;
        this.e = i2;
        this.b = h1;
        this.g = c3241p2;
        this.j = z3;
        this.k = z4;
        this.f = i3;
        this.h = z2;
        this.i = j;
        this.l = z5;
    }

    public InterstitialPlacement a(String str) {
        Iterator<InterstitialPlacement> it = this.f3922a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public InterstitialPlacement a() {
        Iterator<InterstitialPlacement> it = this.f3922a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.m;
    }
}
