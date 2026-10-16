package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;
import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* compiled from: RetryBranchInterceptor.java */
/* loaded from: classes3.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String d;

    protected abstract String a(IN in);

    protected abstract String a(IN in, Throwable th, String str);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        this.d = a((j<IN, OUT>) in);
        l.a aVar = a().get(this.d);
        while (aVar != null) {
            List<h> list = aVar.f928a;
            try {
                Object a2 = c.a(list, bVar.f927a, this).a((b) in);
                return !a(list) ? a2 : bVar.a((b<OUT>) a2);
            } catch (i.a e) {
                Throwable cause = e.getCause();
                new m(bVar);
                this.d = a(in, cause, this.d);
                aVar = a().get(this.d);
            } catch (Throwable th) {
                new m(bVar);
                this.d = a(in, th, this.d);
                aVar = a().get(this.d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.d);
    }
}
