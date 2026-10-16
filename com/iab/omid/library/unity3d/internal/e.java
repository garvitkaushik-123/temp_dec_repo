package com.iab.omid.library.unity3d.internal;

import android.view.View;
import com.iab.omid.library.unity3d.adsession.FriendlyObstructionPurpose;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.weakreference.a f2112a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f2112a = new com.iab.omid.library.unity3d.weakreference.a(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public com.iab.omid.library.unity3d.weakreference.a c() {
        return this.f2112a;
    }

    public String d() {
        return this.b;
    }
}
