package com.ironsource;

import android.util.Pair;
import com.ironsource.C7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class K5 implements Runnable {
    private static final String e = "Content-Type";
    private static final String f = "application/json";

    /* renamed from: a, reason: collision with root package name */
    private C7 f2924a;
    String b;
    String c;
    ArrayList<C3413z5> d;

    public K5(C7 c7, String str, String str2, ArrayList<C3413z5> arrayList) {
        this.f2924a = c7;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        C7.a a2;
        C7.a aVar = new C7.a(this.d);
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            C3218nd b = C3007b8.b(this.c, this.b, arrayList);
            a2 = aVar.a(b.a()).a(b.f3603a);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("EventsSender failed to send events - " + e2.getLocalizedMessage());
            a2 = aVar.a(e2 instanceof C3234oc).a(e2);
        }
        C7 c7 = this.f2924a;
        if (c7 != null) {
            c7.a(a2);
        }
    }
}
