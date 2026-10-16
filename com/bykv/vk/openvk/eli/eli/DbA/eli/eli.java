package com.bykv.vk.openvk.eli.eli.DbA.eli;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.DbA.eli.eli.DbA;
import com.bykv.vk.openvk.eli.eli.DbA.eli.eli.Os;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class eli extends MediaDataSource {
    public static final ConcurrentHashMap<String, eli> eli = new ConcurrentHashMap<>();
    private final Os DbA;
    private long Os = -2147483648L;
    private final Context aGH;
    private final com.bykv.vk.openvk.eli.eli.eli.Os.Os ui;

    public eli(Context context, com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        this.aGH = context;
        this.ui = os;
        this.DbA = new DbA(context, os);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int eli2 = this.DbA.eli(j, bArr, i, i2);
        new StringBuilder("readAt: position = ").append(j).append("  buffer.length =").append(bArr.length).append("  offset = ").append(i).append(" size =").append(eli2).append("  current = ").append(Thread.currentThread());
        return eli2;
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.Os == -2147483648L) {
            if (this.aGH == null || TextUtils.isEmpty(this.ui.aqO())) {
                return -1L;
            }
            this.Os = this.DbA.Os();
        }
        return this.Os;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        new Object[]{"close: ", this.ui.aqO()};
        Os os = this.DbA;
        if (os != null) {
            os.DbA();
        }
        eli.remove(this.ui.dV());
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.Os eli() {
        return this.ui;
    }

    public static eli eli(Context context, com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        eli eliVar = new eli(context, os);
        eli.put(os.dV(), eliVar);
        return eliVar;
    }
}
