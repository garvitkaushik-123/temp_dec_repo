package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final int f1246a;
    public final float b;

    public d(int i, int i2) {
        int i3 = i * i2;
        this.f1246a = i3;
        float f = i / i2;
        this.b = f;
        IAlog.a("IACompanionAdsPriorityComparator: screenWidth = %s, screenHeight = %s, mMaxArea = %s, mAspectRatio = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f));
        IAlog.d("IACompanionAdsPriorityComparator: screenWidth = %s, screenHeight = %s, mMaxArea = %s, mAspectRatio = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f));
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        com.fyber.inneractive.sdk.model.vast.c cVar = (com.fyber.inneractive.sdk.model.vast.c) obj;
        com.fyber.inneractive.sdk.model.vast.c cVar2 = (com.fyber.inneractive.sdk.model.vast.c) obj2;
        int a2 = t.a(cVar.h, cVar2.h);
        if (a2 != 0) {
            return a2;
        }
        com.fyber.inneractive.sdk.model.vast.i iVar = cVar.f1282a;
        com.fyber.inneractive.sdk.model.vast.i iVar2 = com.fyber.inneractive.sdk.model.vast.i.Html;
        int i = 3;
        int i2 = iVar == iVar2 ? 1 : iVar == com.fyber.inneractive.sdk.model.vast.i.Iframe ? 2 : iVar == com.fyber.inneractive.sdk.model.vast.i.Static ? 3 : Integer.MAX_VALUE;
        com.fyber.inneractive.sdk.model.vast.i iVar3 = cVar2.f1282a;
        if (iVar3 == iVar2) {
            i = 1;
        } else if (iVar3 == com.fyber.inneractive.sdk.model.vast.i.Iframe) {
            i = 2;
        } else if (iVar3 != com.fyber.inneractive.sdk.model.vast.i.Static) {
            i = Integer.MAX_VALUE;
        }
        int a3 = t.a(i2, i);
        if (a3 != 0) {
            return a3;
        }
        int compare = Float.compare(Math.abs((cVar.c / cVar.d) - this.b), Math.abs((cVar2.c / cVar2.d) - this.b));
        if (compare != 0) {
            return compare;
        }
        return t.a(Math.abs((cVar.c * cVar.d) - this.f1246a), Math.abs((cVar2.c * cVar2.d) - this.f1246a));
    }
}
