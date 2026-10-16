package com.instagram.common.viewpoint.core;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.facebook.ads.redexgen.X.om, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class SurfaceHolderCallbackC2396om implements GQ, InterfaceC08338p, ES, InterfaceC0886Bf, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"mdkndyL3N", "34XFwDl9WvKoMHQUixXhMeiNQCyC6vNP", "5uafIaN5", "lxzaK8fg5Pf0nzPouXyzPKk1aT8cB3T1", "DTIJ", "0UAV", "B5vkeIjqEzHsmqRbylQSobdgrKqNmXUo", "pkzfV8UoB1KOSL3E8gfET47OMeTC19My"};
    public final /* synthetic */ AA A00;

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final /* synthetic */ void AD4(C2489qI c2489qI, C6L c6l) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final /* synthetic */ void AD5(long j) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final /* synthetic */ void AD6(Exception exc) {
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final /* synthetic */ void ADU(int i, long j) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final /* synthetic */ void AFy(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final /* synthetic */ void AGV(C2489qI c2489qI, C6L c6l) {
    }

    public SurfaceHolderCallbackC2396om(AA aa) {
        this.A00 = aa;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final void AD0(String str, long j, long j2) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0H;
        Iterator it = copyOnWriteArraySet.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "1hpUDXdDopjYnxDN8fIPsNGSxN8OzRvU";
            if (hasNext) {
                ((InterfaceC08338p) it.next()).AD0(str, j, j2);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final void AD1(C6I c6i) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0H;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC08338p) it.next()).AD1(c6i);
        }
        this.A00.A07 = null;
        this.A00.A09 = null;
        this.A00.A01 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final void AD2(C6I c6i) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.A00.A09 = c6i;
        copyOnWriteArraySet = this.A00.A0H;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC08338p) it.next()).AD2(c6i);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final void AD3(C2489qI c2489qI) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.A00.A07 = c2489qI;
        copyOnWriteArraySet = this.A00.A0H;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC08338p) it.next()).AD3(c2489qI);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08338p
    public final void AD9(int i, long j, long j2) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0H;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC08338p) it.next()).AD9(i, j, j2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.ES
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ADZ(C2437pR c2437pR) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0I;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((C3U) it.next()).ADZ(c2437pR);
        }
    }

    @Override // com.instagram.common.viewpoint.core.ES
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Required until we deprecate and move ComponentListener to ExoPlayerImpl.")
    public final void ADa(List<C2439pT> list) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0I;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((C3U) it.next()).ADa(list);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void ADl(int i, long j) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).ADl(i, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0886Bf
    public final void AEt(Metadata metadata, long j) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0J;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC0886Bf) it.next()).AEt(metadata, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AFf(Object obj, long j) {
        Surface surface;
        CopyOnWriteArraySet copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2;
        surface = this.A00.A03;
        if (surface == obj) {
            copyOnWriteArraySet2 = this.A00.A0L;
            Iterator it = copyOnWriteArraySet2.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((GQ) it2.next()).AFf(obj, j);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AGN(String str, long j, long j2) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).AGN(str, j, j2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AGO(C6I c6i) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((GQ) it.next()).AGO(c6i);
        }
        this.A00.A08 = null;
        this.A00.A0A = null;
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AGP(C6I c6i) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.A00.A0A = c6i;
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it = copyOnWriteArraySet.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A01[0].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "MKCckBbCZrSSu6G06Z7NkbaNocq2WvpN";
            strArr[6] = "V8qjKHPFdvtphjyj0wrcUTYdTARdRgua";
            if (hasNext) {
                ((GQ) it.next()).AGP(c6i);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AGU(C2489qI c2489qI) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.A00.A08 = c2489qI;
        copyOnWriteArraySet = this.A00.A0K;
        Iterator it = copyOnWriteArraySet.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A01[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            A01[3] = "2z1T7IcDfmpzuxqypnwVKmOXmU8bKGPo";
            if (hasNext) {
                ((GQ) it.next()).AGU(c2489qI);
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.GQ
    public final void AGb(C2442pW c2442pW) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2;
        copyOnWriteArraySet = this.A00.A0L;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((C5L) it.next()).AGa(c2442pW.A03, c2442pW.A01, c2442pW.A02, c2442pW.A00);
        }
        copyOnWriteArraySet2 = this.A00.A0K;
        Iterator it2 = copyOnWriteArraySet2.iterator();
        while (it2.hasNext()) {
            GQ gq = (GQ) it2.next();
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[1] = "q7eFcMKXm9CoB0iVpo1HKrbod3G9GfaY";
            gq.AGb(c2442pW);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.A00.A0F(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.A00.A0F(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.A00.A0F(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.A00.A0F(null, false);
    }
}
