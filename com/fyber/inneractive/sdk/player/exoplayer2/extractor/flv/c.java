package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class c extends e {
    public long b;

    public c() {
        super(null);
        this.b = -9223372036854775807L;
    }

    public final void a(n nVar, long j) {
        if (nVar.j() != 2) {
            throw new r();
        }
        int o = nVar.o();
        int i = nVar.b;
        nVar.e(i + o);
        if ("onMetaData".equals(new String(nVar.f1591a, i, o)) && nVar.j() == 8) {
            HashMap a2 = a(nVar);
            if (a2.containsKey("duration")) {
                double doubleValue = ((Double) a2.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.b = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    public static Serializable a(int i, n nVar) {
        if (i == 8) {
            return a(nVar);
        }
        if (i == 10) {
            int m = nVar.m();
            ArrayList arrayList = new ArrayList(m);
            for (int i2 = 0; i2 < m; i2++) {
                arrayList.add(a(nVar.j(), nVar));
            }
            return arrayList;
        }
        if (i == 11) {
            Date date = new Date((long) Double.longBitsToDouble(nVar.g()));
            nVar.e(nVar.b + 2);
            return date;
        }
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(nVar.g()));
        }
        if (i == 1) {
            return Boolean.valueOf(nVar.j() == 1);
        }
        if (i == 2) {
            int o = nVar.o();
            int i3 = nVar.b;
            nVar.e(i3 + o);
            return new String(nVar.f1591a, i3, o);
        }
        if (i != 3) {
            return null;
        }
        HashMap hashMap = new HashMap();
        while (true) {
            int o2 = nVar.o();
            int i4 = nVar.b;
            nVar.e(i4 + o2);
            String str = new String(nVar.f1591a, i4, o2);
            int j = nVar.j();
            if (j == 9) {
                return hashMap;
            }
            hashMap.put(str, a(j, nVar));
        }
    }

    public static HashMap a(n nVar) {
        int m = nVar.m();
        HashMap hashMap = new HashMap(m);
        for (int i = 0; i < m; i++) {
            int o = nVar.o();
            int i2 = nVar.b;
            nVar.e(i2 + o);
            hashMap.put(new String(nVar.f1591a, i2, o), a(nVar.j(), nVar));
        }
        return hashMap;
    }
}
