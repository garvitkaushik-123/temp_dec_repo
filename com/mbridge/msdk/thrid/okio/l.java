package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio.java */
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f4906a = Logger.getLogger(l.class.getName());

    /* compiled from: Okio.java */
    static class a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f4907a;
        final /* synthetic */ OutputStream b;

        a(t tVar, OutputStream outputStream) {
            this.f4907a = tVar;
            this.b = outputStream;
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            u.a(cVar.b, 0L, j);
            while (j > 0) {
                this.f4907a.e();
                o oVar = cVar.f4899a;
                int min = (int) Math.min(j, oVar.c - oVar.b);
                this.b.write(oVar.f4912a, oVar.b, min);
                int i = oVar.b + min;
                oVar.b = i;
                long j2 = min;
                j -= j2;
                cVar.b -= j2;
                if (i == oVar.c) {
                    cVar.f4899a = oVar.b();
                    p.a(oVar);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public t b() {
            return this.f4907a;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        public String toString() {
            return "sink(" + this.b + ")";
        }
    }

    /* compiled from: Okio.java */
    static class c extends com.mbridge.msdk.thrid.okio.a {
        final /* synthetic */ Socket k;

        c(Socket socket) {
            this.k = socket;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            try {
                this.k.close();
            } catch (AssertionError e) {
                if (!l.a(e)) {
                    throw e;
                }
                l.f4906a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e);
            } catch (Exception e2) {
                l.f4906a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e2);
            }
        }
    }

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        com.mbridge.msdk.thrid.okio.a c2 = c(socket);
        return c2.a(a(socket.getInputStream(), c2));
    }

    private static com.mbridge.msdk.thrid.okio.a c(Socket socket) {
        return new c(socket);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    private static r a(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new a(tVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                com.mbridge.msdk.thrid.okio.a c2 = c(socket);
                return c2.a(a(socket.getOutputStream(), c2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* compiled from: Okio.java */
    static class b implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f4908a;
        final /* synthetic */ InputStream b;

        b(t tVar, InputStream inputStream) {
            this.f4908a = tVar;
            this.b = inputStream;
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f4908a.e();
                o b = cVar.b(1);
                int read = this.b.read(b.f4912a, b.c, (int) Math.min(j, 8192 - b.c));
                if (read == -1) {
                    return -1L;
                }
                b.c += read;
                long j2 = read;
                cVar.b += j2;
                return j2;
            } catch (AssertionError e) {
                if (l.a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        public String toString() {
            return "source(" + this.b + ")";
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return this.f4908a;
        }
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new b(tVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
