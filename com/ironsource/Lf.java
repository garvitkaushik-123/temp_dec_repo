package com.ironsource;

import com.ironsource.C3014bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Lf implements Pc {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f2947a;
    private final Runnable b;
    private final long c;
    private final List<Oc> d;
    private final C3014bf e;

    /* JADX WARN: Multi-variable type inference failed */
    public Lf(C3205n0 adTools, Runnable task, long j, List<? extends Oc> pauseTriggers) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(pauseTriggers, "pauseTriggers");
        this.f2947a = adTools;
        this.b = task;
        this.c = j;
        this.d = pauseTriggers;
        this.e = new C3014bf(adTools.a(), new Runnable() { // from class: com.ironsource.Lf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Lf.b(Lf.this);
            }
        }, j);
        for (Oc oc : pauseTriggers) {
            oc.a(this);
            if (oc.d()) {
                a(oc.b());
            }
        }
        if (a()) {
            C3014bf.a a2 = this.e.a();
            List<Oc> list = this.d;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Oc) obj).d()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                long c = ((Oc) next).c();
                do {
                    Object next2 = it.next();
                    long c2 = ((Oc) next2).c();
                    if (c > c2) {
                        next = next2;
                        c = c2;
                    }
                } while (it.hasNext());
            }
            a(((Oc) next).b(), a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Lf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    @Override // com.ironsource.Pc
    public void a(final Oc pauseableTrigger) {
        Intrinsics.checkNotNullParameter(pauseableTrigger, "pauseableTrigger");
        this.f2947a.d(new Runnable() { // from class: com.ironsource.Lf$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Lf.a(Lf.this, pauseableTrigger);
            }
        });
    }

    public final void c() {
        this.f2947a.d(new Runnable() { // from class: com.ironsource.Lf$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Lf.a(Lf.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Lf this$0, Oc pauseableTrigger) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pauseableTrigger, "$pauseableTrigger");
        this$0.a(pauseableTrigger.b());
        if (!this$0.a() || this$0.e.e()) {
            return;
        }
        this$0.a(pauseableTrigger.b(), this$0.e.a());
    }

    @Override // com.ironsource.Pc
    public void b(final Oc pauseableTrigger) {
        Intrinsics.checkNotNullParameter(pauseableTrigger, "pauseableTrigger");
        this.f2947a.d(new Runnable() { // from class: com.ironsource.Lf$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Lf.b(Lf.this, pauseableTrigger);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Lf this$0, Oc pauseableTrigger) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pauseableTrigger, "$pauseableTrigger");
        this$0.b(pauseableTrigger.b());
        if (this$0.a() || !this$0.e.e()) {
            return;
        }
        this$0.b(pauseableTrigger.b(), this$0.e.b());
    }

    private final void a(String str) {
        this.f2947a.e().h().d(str);
    }

    private final void a(String str, C3014bf.a aVar) {
        this.f2947a.e().h().a(str, this.c, aVar.c(), aVar.d());
    }

    private final void b(String str) {
        this.f2947a.e().h().e(str);
    }

    private final void b(String str, C3014bf.a aVar) {
        this.f2947a.e().h().b(str, this.c, aVar.c(), aVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Lf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<Oc> it = this$0.d.iterator();
        while (it.hasNext()) {
            it.next().a((Pc) null);
        }
        this$0.e.a();
    }

    private final void b() {
        c();
        this.b.run();
    }

    private final boolean a() {
        List<Oc> list = this.d;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Oc) it.next()).d()) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ Lf(C3205n0 c3205n0, Runnable runnable, long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3205n0, runnable, j, (i & 8) != 0 ? new ArrayList() : list);
    }
}
