package com.inmobi.media;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* renamed from: com.inmobi.media.k5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2727k5 extends ObservableProperty {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2743l5 f2620a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2727k5(EnumC2813pa enumC2813pa, C2743l5 c2743l5) {
        super(enumC2813pa);
        this.f2620a = c2743l5;
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty property, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        EnumC2813pa enumC2813pa = (EnumC2813pa) obj2;
        if (AbstractC2829qa.a((EnumC2813pa) obj) == AbstractC2829qa.a(enumC2813pa)) {
            return;
        }
        Iterator it = this.f2620a.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC2860sa) it.next()).a(enumC2813pa);
        }
    }
}
