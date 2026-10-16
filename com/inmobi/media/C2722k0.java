package com.inmobi.media;

import com.inmobi.adquality.models.AdQualityResult;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2722k0 implements Va {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2786o0 f2617a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Dd c;
    public final /* synthetic */ String d;

    public C2722k0(C2786o0 c2786o0, boolean z, Dd dd, String str) {
        this.f2617a = c2786o0;
        this.b = z;
        this.c = dd;
        this.d = str;
    }

    @Override // com.inmobi.media.Va
    public final void a(Object obj) {
        String result = (String) obj;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f2617a.a("file saved - " + result + " , isReporting - " + this.b);
        C2786o0 c2786o0 = this.f2617a;
        Dd process = this.c;
        String beacon = this.d;
        boolean z = this.b;
        c2786o0.getClass();
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(beacon, "beacon");
        Unit unit = null;
        if (z) {
            c2786o0.a(new AdQualityResult(result, null, beacon, c2786o0.k.toString()), false);
            return;
        }
        c2786o0.f.remove(process);
        AdQualityResult adQualityResult = c2786o0.i;
        if (adQualityResult != null) {
            adQualityResult.setImageLocation(result);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            c2786o0.i = new AdQualityResult(result, null, beacon, null, 8, null);
        }
        c2786o0.a("file is saved. result - " + c2786o0.i);
        c2786o0.a(true);
    }

    @Override // com.inmobi.media.Va
    public final void onError(Exception exc) {
        C2786o0 c2786o0 = this.f2617a;
        Dd process = this.c;
        c2786o0.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        c2786o0.a(exc, "error in running process - ".concat("Dd"));
        c2786o0.f.remove(process);
        c2786o0.a(true);
    }
}
