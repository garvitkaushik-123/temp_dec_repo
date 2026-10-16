package com.inmobi.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.d8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2613d8 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2546a;
    public final String b;
    public final String c;
    public final C2630e8 d;
    public Object e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public int n;
    public int o;
    public String p;
    public String q;
    public C2681h8 r;
    public final ArrayList s;
    public final HashMap t;
    public Object u;
    public int v;
    public C2613d8 w;

    public C2613d8(String assetId, String assetName, String assetType, C2630e8 assetStyle, List trackers) {
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.f2546a = assetId;
        this.b = assetName;
        this.c = assetType;
        this.d = assetStyle;
        this.g = "NO_ACTION";
        this.h = "";
        this.m = (byte) 2;
        this.n = -1;
        this.p = "";
        this.q = "";
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        this.t = new HashMap();
        arrayList.addAll(trackers);
    }

    public static void a(U8 tracker, HashMap hashMap, L7 l7, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        String str = tracker.d;
        boolean z = T9.f2439a;
        C2933x2.f2748a.a(T9.a(str, hashMap), tracker.c, true, l7, Ta.b, interfaceC2971z5);
    }

    public static void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final void b(byte b) {
        this.m = b;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void b(String str) {
        String str2;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            str2 = str.subSequence(i, length + 1).toString();
        } else {
            str2 = null;
        }
        this.p = str2;
    }

    public final void a(byte b) {
        this.j = b;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(C2681h8 c2681h8) {
        this.r = c2681h8;
    }

    public final HashMap a() {
        return this.t;
    }

    public final void a(String eventType, HashMap hashMap, L7 l7, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            U8 u8 = (U8) it.next();
            if (Intrinsics.areEqual(eventType, u8.b)) {
                a(u8, hashMap, l7, interfaceC2971z5);
            }
        }
    }

    public final void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) value.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        this.q = value.subSequence(i, length + 1).toString();
    }

    public /* synthetic */ C2613d8(String str, String str2, String str3, C2630e8 c2630e8, int i) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "root" : str2, (i & 4) != 0 ? "CONTAINER" : str3, (i & 8) != 0 ? new C2630e8() : c2630e8, new LinkedList());
    }
}
