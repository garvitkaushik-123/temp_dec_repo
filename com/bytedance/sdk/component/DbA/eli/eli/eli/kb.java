package com.bytedance.sdk.component.DbA.eli.eli.eli;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: classes3.dex */
public class kb extends InputStream {
    HttpURLConnection DbA;
    InputStream eli;

    public kb(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.eli = inputStream;
        this.DbA = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            inputStream.close();
            this.eli = null;
        }
        HttpURLConnection httpURLConnection = this.DbA;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.DbA = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            inputStream.mark(i);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.eli;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }
}
