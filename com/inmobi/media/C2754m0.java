package com.inmobi.media;

import android.graphics.Bitmap;
import com.inmobi.adquality.models.AdQualityControl;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2754m0 implements Va {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2786o0 f2637a;
    public final /* synthetic */ V1 b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Jb d;

    public C2754m0(C2786o0 c2786o0, V1 v1, boolean z, Jb jb) {
        this.f2637a = c2786o0;
        this.b = v1;
        this.c = z;
        this.d = jb;
    }

    @Override // com.inmobi.media.Va
    public final void a(Object obj) {
        String beacon;
        Bitmap bitmap = (Bitmap) obj;
        C2786o0 c2786o0 = this.f2637a;
        V1 process = this.b;
        boolean z = this.c;
        Jb jb = this.d;
        c2786o0.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        c2786o0.a("Screen shot result received - isReporting - " + z);
        c2786o0.f.remove(process);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (bitmap != null && jb != null) {
            jb.f2327a.c("window.mraidview.broadcastEvent('ScreenshotSuccess')");
        }
        if (z) {
            String str = c2786o0.j;
            Intrinsics.checkNotNull(byteArray);
            c2786o0.a(str, byteArray, true);
        } else {
            AdQualityControl adQualityControl = c2786o0.g;
            if (adQualityControl != null && (beacon = adQualityControl.getBeacon()) != null) {
                c2786o0.a("saving to file - beacon - ".concat(beacon));
                Intrinsics.checkNotNull(byteArray);
                c2786o0.a(beacon, byteArray, false);
            }
        }
        c2786o0.l.set(false);
    }

    @Override // com.inmobi.media.Va
    public final void onError(Exception exc) {
        C2786o0 c2786o0 = this.f2637a;
        V1 process = this.b;
        c2786o0.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        c2786o0.a(exc, "error in running process - ".concat(process.getClass().getSimpleName()));
        c2786o0.f.remove(process);
        c2786o0.a(true);
    }
}
