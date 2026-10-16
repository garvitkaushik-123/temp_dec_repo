package com.fyber.inneractive.sdk.config.global.features;

/* loaded from: classes4.dex */
public final class b extends h {
    public static final a e = a.OPEN;

    public b() {
        super("ad_identifier");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        b bVar = new b();
        a(bVar);
        return bVar;
    }

    public final a c() {
        String a2 = a("identifier_click_action", e.mKey);
        for (a aVar : a.values()) {
            if (a2.equalsIgnoreCase(aVar.mKey)) {
                return aVar;
            }
        }
        return a.NONE;
    }
}
