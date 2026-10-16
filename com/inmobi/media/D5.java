package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class D5 {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f2259a = new CopyOnWriteArrayList();
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final C5 c = new C5();

    public static void a(C2645f7 finishListener) {
        Intrinsics.checkNotNullParameter(finishListener, "finishListener");
        if (!b.getAndSet(true)) {
            b();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = f2259a;
        copyOnWriteArrayList.add(new WeakReference(finishListener));
        try {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() == null) {
                    f2259a.remove(weakReference);
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public static void b() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.D5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                D5.c();
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ie.f2319a.execute(runnable);
    }

    public static final void c() {
        Z6 d = Nc.d();
        C5 listener = c;
        d.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        d.b = listener;
    }

    public static ArrayList a() {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
        ArrayList arrayList2 = new ArrayList();
        try {
            Iterator it = AbstractC2713j7.f2611a.iterator();
            while (it.hasNext()) {
                Ab ab = (Ab) ((WeakReference) it.next()).get();
                if (ab != null) {
                    arrayList2.add(ab);
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = AbstractC2713j7.f2611a;
        arrayList2.toString();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList.add(new Fc((Ab) it2.next()));
        }
        return arrayList;
    }
}
