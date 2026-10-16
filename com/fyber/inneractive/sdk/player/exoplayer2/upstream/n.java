package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.C3040d4;

/* loaded from: classes4.dex */
public final class n implements h {

    /* renamed from: a, reason: collision with root package name */
    public final h f1573a;
    public final s b;
    public final d c;
    public final f d;
    public h e;

    public n(Context context, m mVar, h hVar) {
        hVar.getClass();
        this.f1573a = hVar;
        this.b = new s(mVar);
        this.c = new d(context, mVar);
        this.d = new f(context, mVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) {
        if (this.e != null) {
            throw new IllegalStateException();
        }
        String scheme = kVar.f1570a.getScheme();
        Uri uri = kVar.f1570a;
        int i = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1599a;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || scheme2.equals(C3040d4.h.b)) {
            if (kVar.f1570a.getPath().startsWith("/android_asset/")) {
                this.e = this.c;
            } else {
                this.e = this.b;
            }
        } else if ("asset".equals(scheme)) {
            this.e = this.c;
        } else if ("content".equals(scheme)) {
            this.e = this.d;
        } else {
            this.e = this.f1573a;
        }
        return this.e.a(kVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        h hVar = this.e;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.e = null;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        return this.e.read(bArr, i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        h hVar = this.e;
        if (hVar == null) {
            return null;
        }
        return hVar.a();
    }
}
