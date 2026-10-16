package com.fyber.inneractive.sdk.config.global.features;

/* loaded from: classes4.dex */
public final class u extends h {
    public static final t e = t.NONE;

    public u() {
        super("video_player");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        u uVar = new u();
        a(uVar);
        return uVar;
    }

    public final t c() {
        String a2 = a("click_action", e.mKey);
        for (t tVar : t.values()) {
            if (a2.equalsIgnoreCase(tVar.mKey)) {
                return tVar;
            }
        }
        return t.NONE;
    }
}
