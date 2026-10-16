package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.i7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2696i7 {
    public static void a(Ab ab) {
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
        Objects.toString(ab);
        if (ab == null) {
            return;
        }
        try {
            Iterator it = AbstractC2713j7.f2611a.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() == null || Intrinsics.areEqual(weakReference.get(), ab)) {
                    AbstractC2713j7.f2611a.remove(weakReference);
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
