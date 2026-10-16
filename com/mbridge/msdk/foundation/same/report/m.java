package com.mbridge.msdk.foundation.same.report;

import android.util.Log;
import com.mbridge.msdk.tracker.network.t;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* compiled from: SocketStack.java */
/* loaded from: classes6.dex */
public class m extends com.mbridge.msdk.tracker.network.toolbox.a {
    private static final AtomicInteger b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final byte f4326a;

    public m(byte b2) {
        this.f4326a = b2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb A[Catch: all -> 0x0136, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0136, blocks: (B:32:0x00ac, B:35:0x00bc, B:38:0x00ce, B:44:0x00eb, B:47:0x0102, B:49:0x0106, B:52:0x011f), top: B:31:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102 A[Catch: all -> 0x0136, TRY_ENTER, TryCatch #1 {all -> 0x0136, blocks: (B:32:0x00ac, B:35:0x00bc, B:38:0x00ce, B:44:0x00eb, B:47:0x0102, B:49:0x0106, B:52:0x011f), top: B:31:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0083 A[Catch: all -> 0x013b, TryCatch #3 {all -> 0x013b, blocks: (B:15:0x004d, B:17:0x005e, B:20:0x0062, B:21:0x006a, B:23:0x0077, B:26:0x007b, B:29:0x0084, B:30:0x009c, B:68:0x0083, B:69:0x0092, B:70:0x0067), top: B:14:0x004d }] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.mbridge.msdk.tracker.network.toolbox.g a(t<?> tVar, Map<String, String> map) throws IOException {
        ?? r0;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        OutputStream outputStream;
        ByteBuffer wrap;
        int i;
        boolean z;
        if (com.mbridge.msdk.tracker.a.f4921a) {
            Log.d("TrackManager_Volley", "SocketStack executeRequest " + tVar.t() + ":" + tVar.k());
        }
        Socket socket = null;
        try {
            Socket socket2 = new Socket(tVar.t(), tVar.k());
            try {
                socket2.setSoTimeout(tVar.q());
                OutputStream outputStream2 = socket2.getOutputStream();
                try {
                    if (outputStream2 == null) {
                        throw new IOException("create outputStream exception");
                    }
                    byteBuffer2 = ByteBuffer.wrap(new byte[8]);
                    try {
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        byteBuffer2.order(byteOrder);
                        byteBuffer2.put(this.f4326a);
                        byte[] b2 = tVar.b();
                        try {
                            if (b2 != null && b2.length != 0) {
                                byteBuffer2.put((byte) 3);
                                byteBuffer2.putShort((short) b.getAndIncrement());
                                if (b2 != null && b2.length != 0) {
                                    byte[] a2 = a(b2);
                                    byteBuffer2.putInt(a2 != null ? 0 : a2.length);
                                    outputStream2.write(byteBuffer2.array());
                                    outputStream2.write(a2);
                                    outputStream2.flush();
                                    byte[] bArr = new byte[8];
                                    socket2.getInputStream().read(bArr, 0, 8);
                                    wrap = ByteBuffer.wrap(bArr);
                                    wrap.order(byteOrder);
                                    i = wrap.getInt(4);
                                    z = bArr[1] != 2;
                                    byte[] bArr2 = new byte[i];
                                    new DataInputStream(socket2.getInputStream()).readFully(bArr2);
                                    if (!z && i == 0) {
                                        com.mbridge.msdk.tracker.network.toolbox.g gVar = new com.mbridge.msdk.tracker.network.toolbox.g(204, new ArrayList(), i, null);
                                        a(outputStream2);
                                        a(socket2);
                                        a(byteBuffer2);
                                        a(wrap);
                                        return gVar;
                                    }
                                    if (i >= 1) {
                                        com.mbridge.msdk.tracker.network.toolbox.g gVar2 = new com.mbridge.msdk.tracker.network.toolbox.g(500, new ArrayList(), 0, null);
                                        a(outputStream2);
                                        a(socket2);
                                        a(byteBuffer2);
                                        a(wrap);
                                        return gVar2;
                                    }
                                    if (bArr2[0] == 1) {
                                        com.mbridge.msdk.tracker.network.toolbox.g gVar3 = new com.mbridge.msdk.tracker.network.toolbox.g(200, new ArrayList(), i, null);
                                        a(outputStream2);
                                        a(socket2);
                                        a(byteBuffer2);
                                        a(wrap);
                                        return gVar3;
                                    }
                                    com.mbridge.msdk.tracker.network.toolbox.g gVar4 = new com.mbridge.msdk.tracker.network.toolbox.g(500, new ArrayList(), 0, null);
                                    a(outputStream2);
                                    a(socket2);
                                    a(byteBuffer2);
                                    a(wrap);
                                    return gVar4;
                                }
                                byteBuffer2.putInt(0);
                                outputStream2.write(byteBuffer2.array());
                                outputStream2.flush();
                                byte[] bArr3 = new byte[8];
                                socket2.getInputStream().read(bArr3, 0, 8);
                                wrap = ByteBuffer.wrap(bArr3);
                                wrap.order(byteOrder);
                                i = wrap.getInt(4);
                                if (bArr3[1] != 2) {
                                }
                                byte[] bArr22 = new byte[i];
                                new DataInputStream(socket2.getInputStream()).readFully(bArr22);
                                if (!z) {
                                }
                                if (i >= 1) {
                                }
                            }
                            if (b2 != null) {
                                byte[] a22 = a(b2);
                                byteBuffer2.putInt(a22 != null ? 0 : a22.length);
                                outputStream2.write(byteBuffer2.array());
                                outputStream2.write(a22);
                                outputStream2.flush();
                                byte[] bArr32 = new byte[8];
                                socket2.getInputStream().read(bArr32, 0, 8);
                                wrap = ByteBuffer.wrap(bArr32);
                                wrap.order(byteOrder);
                                i = wrap.getInt(4);
                                if (bArr32[1] != 2) {
                                }
                                byte[] bArr222 = new byte[i];
                                new DataInputStream(socket2.getInputStream()).readFully(bArr222);
                                if (!z) {
                                }
                                if (i >= 1) {
                                }
                            }
                            wrap.order(byteOrder);
                            i = wrap.getInt(4);
                            if (bArr32[1] != 2) {
                            }
                            byte[] bArr2222 = new byte[i];
                            new DataInputStream(socket2.getInputStream()).readFully(bArr2222);
                            if (!z) {
                            }
                            if (i >= 1) {
                            }
                        } catch (Throwable th) {
                            outputStream = outputStream2;
                            byteBuffer = wrap;
                            th = th;
                            socket = outputStream;
                            r0 = socket;
                            socket = socket2;
                            try {
                                throw new IOException(th);
                            } catch (Throwable th2) {
                                a((OutputStream) r0);
                                a(socket);
                                a(byteBuffer2);
                                a(byteBuffer);
                                throw th2;
                            }
                        }
                        byteBuffer2.put((byte) 1);
                        byteBuffer2.putShort((short) b.getAndIncrement());
                        byteBuffer2.putInt(0);
                        outputStream2.write(byteBuffer2.array());
                        outputStream2.flush();
                        byte[] bArr322 = new byte[8];
                        socket2.getInputStream().read(bArr322, 0, 8);
                        wrap = ByteBuffer.wrap(bArr322);
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = outputStream2;
                        byteBuffer = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    byteBuffer2 = null;
                    socket = outputStream2;
                    byteBuffer = null;
                }
            } catch (Throwable th5) {
                th = th5;
                byteBuffer = null;
                byteBuffer2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            r0 = 0;
            byteBuffer = null;
            byteBuffer2 = null;
        }
    }

    public byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }
}
