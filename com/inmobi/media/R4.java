package com.inmobi.media;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R4 implements hf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S4 f2414a;

    public R4(S4 s4) {
        this.f2414a = s4;
    }

    @Override // com.inmobi.media.hf
    public final void a(ArrayList visibleViews, ArrayList invisibleViews) {
        Intrinsics.checkNotNullParameter(visibleViews, "visibleViews");
        Intrinsics.checkNotNullParameter(invisibleViews, "invisibleViews");
        Iterator it = visibleViews.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            ef efVar = (ef) this.f2414a.i.get(view);
            if (efVar != null) {
                efVar.a(view, true);
            }
        }
        Iterator it2 = invisibleViews.iterator();
        while (it2.hasNext()) {
            View view2 = (View) it2.next();
            ef efVar2 = (ef) this.f2414a.i.get(view2);
            if (efVar2 != null) {
                efVar2.a(view2, false);
            }
        }
    }
}
