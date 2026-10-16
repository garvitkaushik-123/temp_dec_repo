package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* compiled from: BranchInterceptor.java */
/* loaded from: classes3.dex */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    protected abstract String a(IN in);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        String a2 = a((a<IN, OUT>) in);
        l.a aVar = a().get(a2);
        if (aVar == null) {
            throw new IllegalArgumentException("can not found branch, branch name is：".concat(String.valueOf(a2)));
        }
        List<h> list = aVar.f928a;
        Object a3 = c.a(list, ((i) bVar).f927a, this).a((b) in);
        return !a(list) ? a3 : bVar.a((b<OUT>) a3);
    }
}
