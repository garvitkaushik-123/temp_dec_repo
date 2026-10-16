package com.apm.insight.runtime;

import com.apm.insight.entity.Header;

/* compiled from: ConfigPropGetter.java */
/* loaded from: classes2.dex */
public class e {
    private static final e b = new e() { // from class: com.apm.insight.runtime.e.1

        /* renamed from: a, reason: collision with root package name */
        private Header f327a = null;

        @Override // com.apm.insight.runtime.e
        public final Object b(String str) {
            if (this.f327a == null) {
                this.f327a = Header.b(com.apm.insight.e.g());
            }
            return this.f327a.f().opt(str);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f326a;

    e() {
        this(b);
    }

    private e(e eVar) {
        this.f326a = eVar;
    }

    public Object b(String str) {
        e eVar = this.f326a;
        if (eVar != null) {
            return eVar.b(str);
        }
        return null;
    }

    public Object a(String str) {
        e eVar = this.f326a;
        if (eVar != null) {
            return eVar.a(str);
        }
        return null;
    }
}
