package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes4.dex */
public final class Ue implements Ve {

    /* renamed from: a, reason: collision with root package name */
    public final AdConfig.VastVideoConfig f2455a;
    public final int b;
    public final int c;
    public final int d;
    public final ArrayList e;
    public String f;
    public String g;
    public final ArrayList h;
    public final ArrayList i;
    public Le j;
    public String k;
    public int l;

    public Ue(List trackers, AdConfig.VastVideoConfig vastVideoConfig) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(vastVideoConfig, "vastVideoConfig");
        this.f2455a = vastVideoConfig;
        this.b = 1048576;
        this.c = 8192;
        this.d = 60;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        arrayList.addAll(trackers);
        this.e = new ArrayList();
        this.i = new ArrayList();
        this.l = 0;
    }

    public static boolean a(double d, double d2, double d3) {
        return d3 > d && d3 <= d2;
    }

    public final int a() {
        List<String> split;
        String[] strArr;
        String str = this.g;
        if (str != null && (split = new Regex(":").split(str, 0)) != null && (strArr = (String[]) split.toArray(new String[0])) != null && strArr.length > 2) {
            try {
                return (Integer.parseInt(strArr[1]) * this.d) + ((int) Float.parseFloat(strArr[2]));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0181, code lost:
    
        if (r2 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01db, code lost:
    
        r15.f = r2.f2366a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01d9, code lost:
    
        if (r2 != null) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        Me me;
        int i;
        String str = this.f;
        if (str != null) {
            return str;
        }
        C2755m1 a2 = Nc.a();
        a2.getClass();
        ArrayList<C2705j> a3 = T1.a(a2, null, null, null, null, "created_ts DESC ", null, 47);
        ArrayList arrayList = new ArrayList();
        for (C2705j c2705j : a3) {
            if (c2705j != null) {
                arrayList.add(c2705j);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C2705j) it.next()).b);
        }
        Me me2 = null;
        if (!arrayList2.isEmpty()) {
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                me = (Me) it2.next();
                if (arrayList2.contains(me.f2366a)) {
                    break;
                }
            }
        }
        me = null;
        if (me != null) {
            String str2 = me.f2366a;
            this.f = str2;
            return str2;
        }
        double optimalVastVideoSize = (this.f2455a.getOptimalVastVideoSize() * 2.0d) / this.b;
        double vastMaxAssetSize = (this.f2455a.getVastMaxAssetSize() * 1.0d) / this.b;
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            Me me3 = (Me) it3.next();
            try {
                i = a();
            } catch (ArrayIndexOutOfBoundsException e) {
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
                i = 0;
            }
            double d = ((me3.b * 1.0d) * i) / this.c;
            me3.c = d;
            double d2 = optimalVastVideoSize;
            if (!a(0.0d, d2, d)) {
                optimalVastVideoSize = d2;
                if (a(optimalVastVideoSize, vastMaxAssetSize, d) && (me2 == null || d < me2.c)) {
                    me2 = me3;
                }
            } else if (me == null || d > me.c) {
                optimalVastVideoSize = d2;
                me = me3;
            } else {
                optimalVastVideoSize = d2;
            }
        }
        if (me != null) {
            this.f = me.f2366a;
        } else if (me2 != null) {
            this.f = me2.f2366a;
        }
        String str3 = this.f;
        if (str3 == null || str3.length() == 0) {
            AdConfig.BitRateConfig bitRate = this.f2455a.getBitRate();
            if (bitRate.getBitrate_mandatory() || this.e.size() == 0) {
                return this.f;
            }
            CountDownLatch countDownLatch = new CountDownLatch(this.e.size());
            try {
                try {
                    a(bitRate, countDownLatch);
                    countDownLatch.await(bitRate.getHeaderTimeout(), TimeUnit.MILLISECONDS);
                    Iterator it4 = this.e.iterator();
                    while (it4.hasNext()) {
                        Me me4 = (Me) it4.next();
                        double d3 = me4.c;
                        double d4 = optimalVastVideoSize;
                        if (a(0.0d, d4, d3)) {
                            if (me == null || d3 > me.c) {
                                me = me4;
                            }
                            optimalVastVideoSize = d4;
                        } else {
                            optimalVastVideoSize = d4;
                            if (a(optimalVastVideoSize, vastMaxAssetSize, d3) && (me2 == null || d3 < me2.c)) {
                                me2 = me4;
                            }
                        }
                    }
                    if (me == null) {
                    }
                } catch (Exception e2) {
                    S5 s52 = S5.f2425a;
                    C2640f2 event2 = new C2640f2(e2);
                    Intrinsics.checkNotNullParameter(event2, "event");
                    S5.d.a(event2);
                    Iterator it5 = this.e.iterator();
                    while (it5.hasNext()) {
                        Me me5 = (Me) it5.next();
                        double d5 = me5.c;
                        double d6 = optimalVastVideoSize;
                        if (!a(0.0d, d6, d5)) {
                            boolean a4 = a(d6, vastMaxAssetSize, d5);
                            d6 = d6;
                            if (a4 && (me2 == null || d5 < me2.c)) {
                                me2 = me5;
                            }
                        } else if (me == null || d5 > me.c) {
                            me = me5;
                        }
                        optimalVastVideoSize = d6;
                    }
                    if (me == null) {
                    }
                }
                this.f = me.f2366a;
            } catch (Throwable th) {
                double d7 = optimalVastVideoSize;
                Iterator it6 = this.e.iterator();
                while (it6.hasNext()) {
                    Me me6 = (Me) it6.next();
                    double d8 = me6.c;
                    if (!a(0.0d, d7, d8)) {
                        double d9 = d7;
                        d7 = d9;
                        if (a(d9, vastMaxAssetSize, d8) && (me2 == null || d8 < me2.c)) {
                            me2 = me6;
                        }
                    } else if (me == null || d8 > me.c) {
                        me = me6;
                    }
                }
                if (me != null) {
                    this.f = me.f2366a;
                } else if (me2 != null) {
                    this.f = me2.f2366a;
                }
                throw th;
            }
        }
        return this.f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Ue(String str, String str2, String str3, ArrayList trackers, ArrayList companionAds, AdConfig.VastVideoConfig vastVideoConfig) {
        this(trackers, vastVideoConfig);
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(companionAds, "companionAds");
        Intrinsics.checkNotNullParameter(vastVideoConfig, "vastVideoConfig");
        if (!companionAds.isEmpty()) {
            this.i = new ArrayList(companionAds);
        }
        if (str != null) {
            this.e.add(new Me(str, 1000));
        }
        this.f = str;
        this.g = str2;
        this.k = str3;
    }

    public final void a(AdConfig.BitRateConfig bitRateConfig, CountDownLatch countDownLatch) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            new Oe((Me) it.next(), bitRateConfig.getHeaderTimeout(), countDownLatch).a();
        }
    }
}
