package com.inmobi.media;

import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.c5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2593c5 implements hf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2662g5 f2532a;

    public C2593c5(C2662g5 c2662g5) {
        this.f2532a = c2662g5;
    }

    @Override // com.inmobi.media.hf
    public final void a(ArrayList visibleViews, ArrayList invisibleViews) {
        Intrinsics.checkNotNullParameter(visibleViews, "visibleViews");
        Intrinsics.checkNotNullParameter(invisibleViews, "invisibleViews");
        Intrinsics.checkNotNullExpressionValue(this.f2532a.d, "access$getTAG$p(...)");
        Objects.toString(visibleViews);
        Objects.toString(invisibleViews);
        Iterator it = visibleViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            C2627e5 c2627e5 = (C2627e5) this.f2532a.f2577a.get(view);
            if (c2627e5 == null) {
                this.f2532a.a(view);
            } else {
                C2627e5 c2627e52 = (C2627e5) this.f2532a.b.get(view);
                if (!Intrinsics.areEqual(c2627e5.f2557a, c2627e52 != null ? c2627e52.f2557a : null)) {
                    c2627e5.d = SystemClock.uptimeMillis();
                    this.f2532a.b.put(view, c2627e5);
                }
            }
        }
        Iterator it2 = invisibleViews.iterator();
        while (it2.hasNext()) {
            this.f2532a.b.remove((View) it2.next());
        }
        C2662g5 c2662g5 = this.f2532a;
        if (c2662g5.e.hasMessages(0)) {
            return;
        }
        c2662g5.e.postDelayed(c2662g5.f, c2662g5.g);
    }
}
