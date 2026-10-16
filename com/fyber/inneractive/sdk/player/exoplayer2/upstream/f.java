package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.SystemClock;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f1567a;
    public final m b;
    public Uri c;
    public AssetFileDescriptor d;
    public FileInputStream e;
    public long f;
    public boolean g;

    public f(Context context, m mVar) {
        this.f1567a = context.getContentResolver();
        this.b = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) {
        try {
            Uri uri = kVar.f1570a;
            this.c = uri;
            AssetFileDescriptor openAssetFileDescriptor = this.f1567a.openAssetFileDescriptor(uri, "r");
            this.d = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            if (this.e.skip(kVar.c + startOffset) - startOffset != kVar.c) {
                throw new EOFException();
            }
            long j = kVar.d;
            if (j != -1) {
                this.f = j;
            } else {
                long length = this.d.getLength();
                this.f = length;
                if (length == -1) {
                    long available = this.e.available();
                    this.f = available;
                    if (available == 0) {
                        this.f = -1L;
                    }
                }
            }
            this.g = true;
            m mVar = this.b;
            if (mVar != null) {
                synchronized (mVar) {
                    if (mVar.b == 0) {
                        mVar.c = SystemClock.elapsedRealtime();
                    }
                    mVar.b++;
                }
            }
            return this.f;
        } catch (IOException e) {
            throw new e(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        this.c = null;
        try {
            try {
                FileInputStream fileInputStream = this.e;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new e(e);
                    }
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        m mVar = this.b;
                        if (mVar != null) {
                            mVar.a();
                        }
                    }
                }
            } catch (IOException e2) {
                throw new e(e2);
            }
        } catch (Throwable th) {
            this.e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        m mVar2 = this.b;
                        if (mVar2 != null) {
                            mVar2.a();
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new e(e3);
                }
            } finally {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    m mVar3 = this.b;
                    if (mVar3 != null) {
                        mVar3.a();
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new e(e);
            }
        }
        int read = this.e.read(bArr, i, i2);
        if (read == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new e(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - read;
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
