package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.w, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3356w implements Oe<JSONObject>, Me<C3322u> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, G0> f3917a = new LinkedHashMap();
    private int b;

    /* renamed from: com.ironsource.w$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3918a;

        static {
            int[] iArr = new int[Le.values().length];
            try {
                iArr[Le.LoadRequest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Le.LoadSuccess.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Le.ShowSuccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Le.ShowFailed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Le.Destroyed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f3918a = iArr;
        }
    }

    private final void b(C3322u c3322u) {
        int i;
        int i2 = a.f3918a[c3322u.f().ordinal()];
        if (i2 == 2) {
            this.b++;
        } else if ((i2 == 3 || i2 == 4 || i2 == 5) && (i = this.b) > 0) {
            this.b = i - 1;
        }
    }

    public final int a() {
        return this.b;
    }

    @Override // com.ironsource.Me
    public void a(C3322u record) {
        Intrinsics.checkNotNullParameter(record, "record");
        String c = record.c();
        Map<String, G0> map = this.f3917a;
        G0 g0 = map.get(c);
        if (g0 == null) {
            g0 = new G0();
            map.put(c, g0);
        }
        g0.a(record.a(new C3339v()));
        b(record);
    }

    @Override // com.ironsource.InterfaceC3060e7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(Ne mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, G0> entry : this.f3917a.entrySet()) {
            String key = entry.getKey();
            JSONObject a2 = entry.getValue().a(mode);
            if (a2.length() > 0) {
                jSONObject.put(key, a2);
            }
        }
        return jSONObject;
    }

    public final boolean b() {
        return !this.f3917a.isEmpty();
    }
}
