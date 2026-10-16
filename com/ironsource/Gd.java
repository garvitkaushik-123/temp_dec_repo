package com.ironsource;

import com.ironsource.mediationsdk.model.Placement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class Gd {
    private static final int o = 0;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Placement> f2886a;
    private H1 b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private Placement l;
    private C3241p2 m;
    private boolean n;

    public Gd() {
        this.f2886a = new ArrayList<>();
        this.b = new H1();
    }

    public void a(Placement placement) {
        if (placement != null) {
            this.f2886a.add(placement);
            if (this.l == null) {
                this.l = placement;
            } else if (placement.isPlacementId(0)) {
                this.l = placement;
            }
        }
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.n;
    }

    public ArrayList<Placement> e() {
        return this.f2886a;
    }

    public boolean f() {
        return this.i;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public long i() {
        return TimeUnit.SECONDS.toMillis(this.e);
    }

    public boolean j() {
        return this.d;
    }

    public C3241p2 k() {
        return this.m;
    }

    public long l() {
        return this.h;
    }

    public H1 m() {
        return this.b;
    }

    public boolean n() {
        return this.k;
    }

    public boolean o() {
        return this.j;
    }

    public String toString() {
        return "RewardedVideoConfigurations{parallelLoad=" + this.c + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public Gd(int i, boolean z, int i2, int i3, H1 h1, C3241p2 c3241p2, int i4, boolean z2, long j, boolean z3, boolean z4, boolean z5) {
        this.f2886a = new ArrayList<>();
        this.c = i;
        this.d = z;
        this.e = i2;
        this.b = h1;
        this.f = i3;
        this.m = c3241p2;
        this.g = i4;
        this.n = z2;
        this.h = j;
        this.i = z3;
        this.j = z4;
        this.k = z5;
    }

    public Placement a(String str) {
        Iterator<Placement> it = this.f2886a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Placement a() {
        Iterator<Placement> it = this.f2886a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.l;
    }
}
