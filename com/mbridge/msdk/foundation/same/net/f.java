package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.p0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* compiled from: SocketManager.java */
/* loaded from: classes6.dex */
public class f {
    private static volatile AtomicInteger b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f4289a;

    /* compiled from: SocketManager.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("SocketThreadPool");
            return newThread;
        }
    }

    /* compiled from: SocketManager.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4291a;

        b(c cVar) {
            this.f4291a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4291a.a();
        }
    }

    /* compiled from: SocketManager.java */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        private static f f4293a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    public static f b() {
        return d.f4293a;
    }

    private f() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
        this.f4289a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public byte[] a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
        }
    }

    public void a(String str, int i, String str2, boolean z, com.mbridge.msdk.foundation.same.net.b bVar) {
        this.f4289a.execute(new b(new c(str, i, str2, z, bVar)));
    }

    /* compiled from: SocketManager.java */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private ByteBuffer f4292a;
        private String b;
        private boolean c;
        private com.mbridge.msdk.foundation.same.net.b d;
        private OutputStream e;
        private int f;
        private Socket g;
        private String h;

        c(String str, int i, String str2, boolean z, com.mbridge.msdk.foundation.same.net.b bVar) {
            this.b = str;
            this.f = i;
            this.h = str2;
            this.c = z;
            this.d = bVar;
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x00ce A[Catch: all -> 0x02b1, TryCatch #2 {all -> 0x02b1, blocks: (B:3:0x0010, B:5:0x0030, B:9:0x0042, B:11:0x0090, B:12:0x00a6, B:14:0x00bc, B:15:0x00f7, B:21:0x0148, B:25:0x0183, B:28:0x0191, B:43:0x01b3, B:56:0x01df, B:69:0x0202, B:71:0x0207, B:82:0x0215, B:90:0x0295, B:105:0x027f, B:108:0x0292, B:111:0x00ce, B:113:0x00d2, B:114:0x00e1, B:115:0x00db, B:116:0x0098, B:119:0x00a3, B:85:0x0236, B:86:0x0243, B:88:0x0249, B:89:0x0250, B:103:0x023d), top: B:2:0x0010, inners: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x0098 A[Catch: all -> 0x02b1, TryCatch #2 {all -> 0x02b1, blocks: (B:3:0x0010, B:5:0x0030, B:9:0x0042, B:11:0x0090, B:12:0x00a6, B:14:0x00bc, B:15:0x00f7, B:21:0x0148, B:25:0x0183, B:28:0x0191, B:43:0x01b3, B:56:0x01df, B:69:0x0202, B:71:0x0207, B:82:0x0215, B:90:0x0295, B:105:0x027f, B:108:0x0292, B:111:0x00ce, B:113:0x00d2, B:114:0x00e1, B:115:0x00db, B:116:0x0098, B:119:0x00a3, B:85:0x0236, B:86:0x0243, B:88:0x0249, B:89:0x0250, B:103:0x023d), top: B:2:0x0010, inners: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0090 A[Catch: all -> 0x02b1, TryCatch #2 {all -> 0x02b1, blocks: (B:3:0x0010, B:5:0x0030, B:9:0x0042, B:11:0x0090, B:12:0x00a6, B:14:0x00bc, B:15:0x00f7, B:21:0x0148, B:25:0x0183, B:28:0x0191, B:43:0x01b3, B:56:0x01df, B:69:0x0202, B:71:0x0207, B:82:0x0215, B:90:0x0295, B:105:0x027f, B:108:0x0292, B:111:0x00ce, B:113:0x00d2, B:114:0x00e1, B:115:0x00db, B:116:0x0098, B:119:0x00a3, B:85:0x0236, B:86:0x0243, B:88:0x0249, B:89:0x0250, B:103:0x023d), top: B:2:0x0010, inners: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00bc A[Catch: all -> 0x02b1, TryCatch #2 {all -> 0x02b1, blocks: (B:3:0x0010, B:5:0x0030, B:9:0x0042, B:11:0x0090, B:12:0x00a6, B:14:0x00bc, B:15:0x00f7, B:21:0x0148, B:25:0x0183, B:28:0x0191, B:43:0x01b3, B:56:0x01df, B:69:0x0202, B:71:0x0207, B:82:0x0215, B:90:0x0295, B:105:0x027f, B:108:0x0292, B:111:0x00ce, B:113:0x00d2, B:114:0x00e1, B:115:0x00db, B:116:0x0098, B:119:0x00a3, B:85:0x0236, B:86:0x0243, B:88:0x0249, B:89:0x0250, B:103:0x023d), top: B:2:0x0010, inners: #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x013d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0195  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01af  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            boolean z;
            int i;
            int length;
            boolean z2;
            com.mbridge.msdk.foundation.same.net.b bVar;
            try {
                Socket socket = new Socket(this.b, this.f);
                this.g = socket;
                socket.setSoTimeout(15000);
                if (!this.b.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().j) && !this.b.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().l)) {
                    z = false;
                    p0.b("SocketManager", "Socket connect : " + this.b + " : " + this.f + " isAnalytics : " + z);
                    this.e = this.g.getOutputStream();
                    ByteBuffer wrap = ByteBuffer.wrap(new byte[8]);
                    this.f4292a = wrap;
                    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                    wrap.order(byteOrder);
                    this.f4292a.put((byte) 2);
                    if (TextUtils.isEmpty(this.h)) {
                        i = 1;
                        this.f4292a.put(this.c ? (byte) 3 : (byte) 2);
                    } else {
                        this.f4292a.put((byte) 1);
                        i = 1;
                    }
                    this.f4292a.putShort((short) f.b.getAndIncrement());
                    if (TextUtils.isEmpty(this.h)) {
                        byte[] a2 = this.c ? f.this.a(this.h) : this.h.getBytes();
                        length = a2.length;
                        this.f4292a.putInt(length);
                        this.e.write(this.f4292a.array());
                        this.e.write(a2);
                    } else {
                        this.f4292a.putInt(0);
                        this.e.write(this.f4292a.array());
                        length = 0;
                    }
                    this.e.flush();
                    p0.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f4292a.array()) + " length : " + length);
                    InputStream inputStream = this.g.getInputStream();
                    byte[] bArr = new byte[8];
                    inputStream.read(bArr, 0, 8);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                    this.f4292a = wrap2;
                    wrap2.order(byteOrder);
                    int i2 = this.f4292a.getInt(4);
                    byte b = bArr[i];
                    z2 = b != 3 ? i : 0;
                    int i3 = b != 2 ? i : 0;
                    p0.b("SocketManager", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i2 + " isGzip : " + z2);
                    byte[] bArr2 = new byte[i2];
                    new DataInputStream(this.g.getInputStream()).readFully(bArr2);
                    int i4 = z2;
                    if (z2 == 0) {
                        i4 = z2;
                        if (i2 > 2) {
                            i4 = z2;
                            if (((bArr2[0] << 8) | (bArr2[i] & 255)) == 8075) {
                                i4 = i;
                            }
                        }
                    }
                    bVar = this.d;
                    if (bVar != null) {
                        Socket socket2 = this.g;
                        if (socket2 != null) {
                            try {
                                socket2.close();
                                this.f4292a = null;
                                this.e.close();
                                return;
                            } catch (IOException e) {
                                p0.b("SocketManager", e.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (i3 != 0 && i2 == 0) {
                        bVar.onSuccess(e.a(null, new com.mbridge.msdk.foundation.same.net.toolbox.a(204, null, null)));
                        Socket socket3 = this.g;
                        if (socket3 != null) {
                            try {
                                socket3.close();
                                this.f4292a = null;
                                this.e.close();
                                return;
                            } catch (IOException e2) {
                                p0.b("SocketManager", e2.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (i2 < i) {
                        a("The response data less than 1");
                        Socket socket4 = this.g;
                        if (socket4 != null) {
                            try {
                                socket4.close();
                                this.f4292a = null;
                                this.e.close();
                                return;
                            } catch (IOException e3) {
                                p0.b("SocketManager", e3.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    if (z) {
                        if (bArr2[0] == 1) {
                            bVar.onSuccess(e.a(null, new com.mbridge.msdk.foundation.same.net.toolbox.a(200, null, null)));
                        } else {
                            a("The server returns fail");
                        }
                        Socket socket5 = this.g;
                        if (socket5 != null) {
                            try {
                                socket5.close();
                                this.f4292a = null;
                                this.e.close();
                                return;
                            } catch (IOException e4) {
                                p0.b("SocketManager", e4.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        String a3 = i4 != 0 ? f.this.a(bArr2) : new String(bArr2);
                        JSONObject jSONObject = !TextUtils.isEmpty(a3) ? new JSONObject(a3) : null;
                        p0.b("SocketManager", "Socket Response length : " + i2 + " " + a3.length());
                        this.d.onSuccess(e.a(jSONObject, new com.mbridge.msdk.foundation.same.net.toolbox.a(200, null, null)));
                    } catch (Throwable th) {
                        String message = th.getMessage();
                        p0.b("SocketManager", th.getMessage());
                        if (TextUtils.isEmpty(message)) {
                            message = "The JSON data is illegal";
                        }
                        a(message);
                    }
                    inputStream.close();
                    Socket socket6 = this.g;
                    if (socket6 != null) {
                        try {
                            socket6.close();
                            this.f4292a = null;
                            this.e.close();
                            return;
                        } catch (IOException e5) {
                            p0.b("SocketManager", e5.getMessage());
                            return;
                        }
                    }
                    return;
                }
                z = true;
                p0.b("SocketManager", "Socket connect : " + this.b + " : " + this.f + " isAnalytics : " + z);
                this.e = this.g.getOutputStream();
                ByteBuffer wrap3 = ByteBuffer.wrap(new byte[8]);
                this.f4292a = wrap3;
                ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
                wrap3.order(byteOrder2);
                this.f4292a.put((byte) 2);
                if (TextUtils.isEmpty(this.h)) {
                }
                this.f4292a.putShort((short) f.b.getAndIncrement());
                if (TextUtils.isEmpty(this.h)) {
                }
                this.e.flush();
                p0.a("SocketManager", "Socket Request : header : " + Arrays.toString(this.f4292a.array()) + " length : " + length);
                InputStream inputStream2 = this.g.getInputStream();
                byte[] bArr3 = new byte[8];
                inputStream2.read(bArr3, 0, 8);
                ByteBuffer wrap22 = ByteBuffer.wrap(bArr3);
                this.f4292a = wrap22;
                wrap22.order(byteOrder2);
                int i22 = this.f4292a.getInt(4);
                byte b2 = bArr3[i];
                if (b2 != 3) {
                }
                if (b2 != 2) {
                }
                p0.b("SocketManager", "Socket Response : header : " + Arrays.toString(bArr3) + " length : " + i22 + " isGzip : " + z2);
                byte[] bArr22 = new byte[i22];
                new DataInputStream(this.g.getInputStream()).readFully(bArr22);
                int i42 = z2;
                if (z2 == 0) {
                }
                bVar = this.d;
                if (bVar != null) {
                }
            } catch (Throwable th2) {
                try {
                    String message2 = th2.getMessage();
                    p0.a("SocketManager", "Socket exception: " + message2);
                    a(message2);
                    Socket socket7 = this.g;
                    if (socket7 != null) {
                        try {
                            socket7.close();
                            this.f4292a = null;
                            this.e.close();
                        } catch (IOException e6) {
                            p0.b("SocketManager", e6.getMessage());
                        }
                    }
                } catch (Throwable th3) {
                    Socket socket8 = this.g;
                    if (socket8 == null) {
                        throw th3;
                    }
                    try {
                        socket8.close();
                        this.f4292a = null;
                        this.e.close();
                        throw th3;
                    } catch (IOException e7) {
                        p0.b("SocketManager", e7.getMessage());
                        throw th3;
                    }
                }
            }
        }

        private void a(String str) {
            if (this.d != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "Unknown exception";
                }
                this.d.onError(new com.mbridge.msdk.foundation.same.net.exception.a(13, new com.mbridge.msdk.foundation.same.net.toolbox.a(404, str.getBytes(), null)));
            }
        }
    }
}
