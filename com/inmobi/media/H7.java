package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class H7 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2304a = new ConcurrentHashMap();
    public final ExecutorService b = Executors.newSingleThreadExecutor(new K5("MultiEventBus"));

    public static final void a(C2607d2 event, H7 this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = event.f2542a;
        this$0.a(event);
    }

    public final void b(final C2607d2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.b.execute(new Runnable() { // from class: com.inmobi.media.H7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    H7.a(C2607d2.this, this);
                }
            });
        } catch (InternalError unused) {
            a(event);
        }
    }

    public final void a(int[] eventIds, Function1 subscriber) {
        Intrinsics.checkNotNullParameter(eventIds, "eventIds");
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.f2304a.put(new G7(eventIds), new WeakReference(subscriber));
    }

    public final void a(Function1 subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Iterator it = this.f2304a.entrySet().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WeakReference) ((Map.Entry) it.next()).getValue()).get(), subscriber)) {
                it.remove();
            }
        }
    }

    public final void a(C2607d2 c2607d2) {
        Function1 function1;
        Set<Map.Entry> entrySet = this.f2304a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        for (Map.Entry entry : entrySet) {
            if (((WeakReference) entry.getValue()).get() == null) {
                this.f2304a.remove(entry.getKey());
            }
        }
        Set<Map.Entry> entrySet2 = this.f2304a.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet2, "<get-entries>(...)");
        for (Map.Entry entry2 : entrySet2) {
            Intrinsics.checkNotNull(entry2);
            Function1 function12 = (Function1) entry2.getKey();
            WeakReference weakReference = (WeakReference) entry2.getValue();
            try {
                if (((Boolean) function12.invoke(c2607d2)).booleanValue() && (function1 = (Function1) weakReference.get()) != null) {
                    function1.invoke(c2607d2);
                }
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
    }
}
