package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.SystemClock;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f1564a;
    public final m b;
    public Uri c;
    public InputStream d;
    public long e;
    public boolean f;

    public d(Context context, m mVar) {
        this.f1564a = context.getAssets();
        this.b = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) {
        try {
            Uri uri = kVar.f1570a;
            this.c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                path = path.substring(1);
            }
            InputStream open = this.f1564a.open(path, 1);
            this.d = open;
            if (open.skip(kVar.c) < kVar.c) {
                throw new EOFException();
            }
            long j = kVar.d;
            if (j != -1) {
                this.e = j;
            } else {
                long available = this.d.available();
                this.e = available;
                if (available == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            m mVar = this.b;
            if (mVar != null) {
                synchronized (mVar) {
                    if (mVar.b == 0) {
                        mVar.c = SystemClock.elapsedRealtime();
                    }
                    mVar.b++;
                }
            }
            return this.e;
        } catch (IOException e) {
            throw new c(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        this.c = null;
        try {
            try {
                InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new c(e);
            }
        } finally {
            this.d = null;
            if (this.f) {
                this.f = false;
                m mVar = this.b;
                if (mVar != null) {
                    mVar.a();
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new c(e);
            }
        }
        int read = this.d.read(bArr, i, i2);
        if (read == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new c(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - read;
        }
        m mVar = this.b;
        if (mVar == null) {
            return read;
        }
        synchronized (mVar) {
            mVar.d += read;
        }
        return read;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.c;
    }
}
