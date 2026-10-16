package com.ironsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public final class kg {

    /* renamed from: a, reason: collision with root package name */
    private final List<AbstractC3407z> f3412a;

    /* JADX WARN: Multi-variable type inference failed */
    public kg(List<? extends AbstractC3407z> instances) {
        Intrinsics.checkNotNullParameter(instances, "instances");
        this.f3412a = instances;
    }

    public final List<AbstractC3407z> a() {
        return this.f3412a;
    }

    public final List<AbstractC3407z> b() {
        return this.f3412a;
    }

    public final int c() {
        return this.f3412a.size();
    }

    public final String d() {
        ArrayList arrayList = new ArrayList();
        for (AbstractC3407z abstractC3407z : this.f3412a) {
            arrayList.add(a(abstractC3407z.h(), abstractC3407z.r()));
        }
        return CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kg) && Intrinsics.areEqual(this.f3412a, ((kg) obj).f3412a);
    }

    public int hashCode() {
        return this.f3412a.hashCode();
    }

    public String toString() {
        return "WaterfallInstances(instances=" + this.f3412a + ")";
    }

    public final kg a(List<? extends AbstractC3407z> instances) {
        Intrinsics.checkNotNullParameter(instances, "instances");
        return new kg(instances);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kg a(kg kgVar, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kgVar.f3412a;
        }
        return kgVar.a(list);
    }

    private final String a(C3207n2 c3207n2, int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i), c3207n2.c()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
