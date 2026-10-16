package com.inmobi.media;

import android.os.SystemClock;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.f5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC2643f5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final String f2567a;
    public final ArrayList b;
    public final WeakReference c;

    public RunnableC2643f5(C2662g5 impressionTracker) {
        Intrinsics.checkNotNullParameter(impressionTracker, "impressionTracker");
        this.f2567a = "f5";
        this.b = new ArrayList();
        this.c = new WeakReference(impressionTracker);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intrinsics.checkNotNull(this.f2567a);
        C2662g5 c2662g5 = (C2662g5) this.c.get();
        if (c2662g5 != null) {
            for (Map.Entry entry : c2662g5.b.entrySet()) {
                View view = (View) entry.getKey();
                C2627e5 c2627e5 = (C2627e5) entry.getValue();
                Intrinsics.checkNotNull(this.f2567a);
                Objects.toString(c2627e5);
                if (SystemClock.uptimeMillis() - c2627e5.d >= c2627e5.c) {
                    Intrinsics.checkNotNull(this.f2567a);
                    c2662g5.h.a(view, c2627e5.f2557a);
                    this.b.add(view);
                }
            }
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                c2662g5.a((View) it.next());
            }
            this.b.clear();
            if (c2662g5.b.isEmpty() || c2662g5.e.hasMessages(0)) {
                return;
            }
            c2662g5.e.postDelayed(c2662g5.f, c2662g5.g);
        }
    }
}
