package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.http2.d;
import com.mbridge.msdk.thrid.okio.s;
import com.mbridge.msdk.thrid.okio.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;

/* compiled from: Http2Reader.java */
/* loaded from: classes6.dex */
final class h implements Closeable {
    static final Logger e = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okio.e f4855a;
    private final a b;
    private final boolean c;
    final d.a d;

    /* compiled from: Http2Reader.java */
    interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list) throws IOException;

        void a(int i, long j);

        void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar);

        void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okio.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, com.mbridge.msdk.thrid.okio.e eVar, int i2) throws IOException;

        void a(boolean z, m mVar);
    }

    h(com.mbridge.msdk.thrid.okio.e eVar, boolean z) {
        this.f4855a = eVar;
        this.c = z;
        a aVar = new a(eVar);
        this.b = aVar;
        this.d = new d.a(4096, aVar);
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int readInt = this.f4855a.readInt();
        int readInt2 = this.f4855a.readInt();
        int i3 = i - 8;
        com.mbridge.msdk.thrid.okhttp.internal.http2.b a2 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(readInt2);
        if (a2 == null) {
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        }
        com.mbridge.msdk.thrid.okio.f fVar = com.mbridge.msdk.thrid.okio.f.e;
        if (i3 > 0) {
            fVar = this.f4855a.b(i3);
        }
        bVar.a(readInt, a2, fVar);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short readByte = (b2 & 8) != 0 ? (short) (this.f4855a.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, readByte), readByte, b2, i2));
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.f4855a.readInt(), this.f4855a.readInt());
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.f4855a.readByte() & 255) : (short) 0;
        bVar.a(i2, this.f4855a.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, readByte), readByte, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int readInt = this.f4855a.readInt();
        com.mbridge.msdk.thrid.okhttp.internal.http2.b a2 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.a(readInt);
        if (a2 == null) {
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        }
        bVar.a(i2, a2);
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        m mVar = new m();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.f4855a.readShort() & UShort.MAX_VALUE;
            int readInt = this.f4855a.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    if (readInt < 0) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    readShort = 7;
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                }
            } else if (readInt != 0 && readInt != 1) {
                throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
            mVar.a(readShort, readInt);
        }
        bVar.a(false, mVar);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long readInt = this.f4855a.readInt() & 2147483647L;
        if (readInt == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
        }
        bVar.a(i2, readInt);
    }

    public void a(b bVar) throws IOException {
        if (this.c) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.mbridge.msdk.thrid.okio.e eVar = this.f4855a;
        com.mbridge.msdk.thrid.okio.f fVar = e.f4850a;
        com.mbridge.msdk.thrid.okio.f b2 = eVar.b(fVar.e());
        Logger logger = e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.mbridge.msdk.thrid.okhttp.internal.c.a("<< CONNECTION %s", b2.b()));
        }
        if (!fVar.equals(b2)) {
            throw e.b("Expected a connection header but was %s", b2.h());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4855a.close();
    }

    /* compiled from: Http2Reader.java */
    static final class a implements s {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.e f4856a;
        int b;
        byte c;
        int d;
        int e;
        short f;

        a(com.mbridge.msdk.thrid.okio.e eVar) {
            this.f4856a = eVar;
        }

        private void d() throws IOException {
            int i = this.d;
            int a2 = h.a(this.f4856a);
            this.e = a2;
            this.b = a2;
            byte readByte = (byte) (this.f4856a.readByte() & 255);
            this.c = (byte) (this.f4856a.readByte() & 255);
            Logger logger = h.e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.d, this.b, readByte, this.c));
            }
            int readInt = this.f4856a.readInt() & Integer.MAX_VALUE;
            this.d = readInt;
            if (readByte != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            while (true) {
                int i = this.e;
                if (i != 0) {
                    long b = this.f4856a.b(cVar, Math.min(j, i));
                    if (b == -1) {
                        return -1L;
                    }
                    this.e = (int) (this.e - b);
                    return b;
                }
                this.f4856a.skip(this.f);
                this.f = (short) 0;
                if ((this.c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return this.f4856a.b();
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f4855a.e(9L);
            int a2 = a(this.f4855a);
            if (a2 >= 0 && a2 <= 16384) {
                byte readByte = (byte) (this.f4855a.readByte() & 255);
                if (z && readByte != 4) {
                    throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                }
                byte readByte2 = (byte) (this.f4855a.readByte() & 255);
                int readInt = this.f4855a.readInt() & Integer.MAX_VALUE;
                Logger logger = e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(e.a(true, readInt, a2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(bVar, a2, readByte2, readInt);
                        return true;
                    case 1:
                        c(bVar, a2, readByte2, readInt);
                        return true;
                    case 2:
                        e(bVar, a2, readByte2, readInt);
                        return true;
                    case 3:
                        g(bVar, a2, readByte2, readInt);
                        return true;
                    case 4:
                        h(bVar, a2, readByte2, readInt);
                        return true;
                    case 5:
                        f(bVar, a2, readByte2, readInt);
                        return true;
                    case 6:
                        d(bVar, a2, readByte2, readInt);
                        return true;
                    case 7:
                        b(bVar, a2, readByte2, readInt);
                        return true;
                    case 8:
                        i(bVar, a2, readByte2, readInt);
                        return true;
                    default:
                        this.f4855a.skip(a2);
                        return true;
                }
            }
            throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
        } catch (IOException unused) {
            return false;
        }
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.b;
        aVar.e = i;
        aVar.b = i;
        aVar.f = s;
        aVar.c = b2;
        aVar.d = i2;
        this.d.f();
        return this.d.c();
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) == 0) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f4855a.readByte() & 255) : (short) 0;
            bVar.a(z, i2, this.f4855a, a(i, b2, readByte));
            this.f4855a.skip(readByte);
            return;
        }
        throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    private void a(b bVar, int i) throws IOException {
        int readInt = this.f4855a.readInt();
        bVar.a(i, readInt & Integer.MAX_VALUE, (this.f4855a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    static int a(com.mbridge.msdk.thrid.okio.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
