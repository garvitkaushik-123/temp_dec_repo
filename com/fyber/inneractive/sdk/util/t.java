package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.Reference;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public abstract class t {
    public static StringBuffer a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream required");
        }
        ByteBuffer byteBuffer = (ByteBuffer) f.b.f1757a.poll();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocateDirect(16384);
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] array = (byteBuffer == null || !byteBuffer.hasArray()) ? new byte[8192] : byteBuffer.array();
        int i = 0;
        while (i != -1) {
            stringBuffer.append(new String(array, 0, i));
            i = inputStream.read(array);
        }
        f.b.f1757a.offer(byteBuffer);
        return stringBuffer;
    }

    public static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static String b(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return "------\r\n" + stringWriter.toString() + "------\r\n";
        } catch (Exception unused) {
            return "bad stackToString";
        }
    }

    public static void a(InputStream inputStream, FileOutputStream fileOutputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[65536];
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    i += read;
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    IAlog.a("Copied stream content length = %d", Integer.valueOf(i));
                    return;
                }
            }
        } else {
            throw new IOException("Unable to copy from or to a null stream.");
        }
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        } catch (Exception unused) {
        }
    }

    public static Object a(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static int a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int a(int i, int i2) {
        return Integer.compare(i, i2);
    }

    public static String a(Throwable th) {
        String message;
        if (th == null) {
            return null;
        }
        do {
            message = th.getMessage();
            th = th.getCause();
        } while (th != null);
        return message;
    }
}
