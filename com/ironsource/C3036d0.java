package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.d0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3036d0 implements InterfaceC3053e0 {
    public static final a b = new a(null);
    private static final String c = "ext_";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3236a = new HashMap();

    /* renamed from: com.ironsource.d0$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    @Override // com.ironsource.InterfaceC3053e0
    public Map<String, String> a() {
        return this.f3236a;
    }

    @Override // com.ironsource.InterfaceC3053e0
    public void b(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f3236a.put("ext_" + key, value);
    }

    @Override // com.ironsource.InterfaceC3053e0
    public void a(HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.f3236a.putAll(params);
    }

    @Override // com.ironsource.InterfaceC3053e0
    public void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f3236a.put(key, value);
    }
}
