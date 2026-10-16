package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface DownloadFileOutputStream {
    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j) throws IOException, IllegalAccessException;

    void setLength(long j) throws IOException, IllegalAccessException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
