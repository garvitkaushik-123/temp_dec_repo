package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
class Z5 implements Callable<C3058e5> {
    private static final String d = "FileWorkerThread";
    private static final String e = "X-Android-Protocols";
    private static final String f = "http/1.1,h2";

    /* renamed from: a, reason: collision with root package name */
    private final C3041d5 f3157a;
    private final String b;
    private long c;

    Z5(C3041d5 c3041d5, String str, long j) {
        this.f3157a = c3041d5;
        this.b = str;
        this.c = j;
    }

    int a(byte[] bArr, String str) throws Exception {
        return IronSourceStorageUtils.saveFile(bArr, str);
    }

    boolean a(String str, String str2) throws Exception {
        return IronSourceStorageUtils.renameFile(str, str2);
    }

    byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3058e5 call() {
        Z5 z5;
        if (this.c == 0) {
            this.c = 1L;
        }
        C3058e5 c3058e5 = null;
        int i = 0;
        while (true) {
            if (i >= this.c) {
                z5 = this;
                break;
            }
            z5 = this;
            c3058e5 = z5.a(this.f3157a.e(), i, this.f3157a.a(), this.f3157a.c(), this.f3157a.f());
            int b = c3058e5.b();
            if (b != 1008 && b != 1009) {
                break;
            }
            i++;
        }
        C3058e5 c3058e52 = c3058e5;
        if (c3058e52 != null && c3058e52.a() != null) {
            StringBuilder append = new StringBuilder().append(z5.b);
            String str = File.separator;
            String sb = append.append(str).append(z5.f3157a.b().getName()).toString();
            String str2 = z5.f3157a.d() + str + C3074f4.E + z5.f3157a.b().getName();
            try {
                if (a(c3058e52.a(), str2) == 0) {
                    c3058e52.a(1006);
                    return c3058e52;
                }
                if (!a(str2, sb)) {
                    c3058e52.a(1014);
                    return c3058e52;
                }
            } catch (FileNotFoundException e2) {
                C3260q4.d().a(e2);
                c3058e52.a(1018);
            } catch (Error e3) {
                C3260q4.d().a(e3);
                if (!TextUtils.isEmpty(e3.getMessage())) {
                    Logger.i(d, e3.getMessage());
                }
                c3058e52.a(1019);
            } catch (Exception e4) {
                C3260q4.d().a(e4);
                if (!TextUtils.isEmpty(e4.getMessage())) {
                    Logger.i(d, e4.getMessage());
                }
                c3058e52.a(1009);
            }
        }
        return c3058e52;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089 A[Catch: all -> 0x0090, TRY_ENTER, TryCatch #11 {all -> 0x0090, blocks: (B:21:0x0089, B:22:0x008c, B:45:0x00c4, B:47:0x00c9), top: B:7:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018a A[Catch: all -> 0x0186, TRY_LEAVE, TryCatch #3 {all -> 0x0186, blocks: (B:92:0x0182, B:84:0x018a), top: B:91:0x0182 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    C3058e5 a(String str, int i, int i2, int i3, boolean z) {
        HttpURLConnection httpURLConnection;
        C3058e5 c3058e5 = new C3058e5();
        if (TextUtils.isEmpty(str)) {
            c3058e5.a(str);
            c3058e5.a(1007);
            return c3058e5;
        }
        InputStream inputStream = null;
        Object[] objArr = 0;
        InputStream inputStream2 = null;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        int i4 = 0;
        try {
            try {
                try {
                    try {
                        URL url = new URL(str);
                        url.toURI();
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    } catch (Throwable th) {
                        C3260q4.d().a(th);
                        IronLog.INTERNAL.error(th.toString());
                        c3058e5.a(str);
                        c3058e5.a(i);
                        return c3058e5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            C3260q4.d().a(th3);
                            IronLog.INTERNAL.error(th3.toString());
                            c3058e5.a(str);
                            c3058e5.a(0);
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        (objArr == true ? 1 : 0).disconnect();
                    }
                    c3058e5.a(str);
                    c3058e5.a(0);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Error e3) {
                e = e3;
                httpURLConnection = null;
            } catch (MalformedURLException e4) {
                e = e4;
                httpURLConnection = null;
            } catch (SocketTimeoutException e5) {
                e = e5;
                httpURLConnection = null;
            } catch (URISyntaxException e6) {
                e = e6;
                httpURLConnection = null;
            } catch (Exception e7) {
                e = e7;
                httpURLConnection = null;
            } catch (Throwable th4) {
                th = th4;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                c3058e5.a(str);
                c3058e5.a(0);
                throw th;
            }
        } catch (Throwable th5) {
            C3260q4.d().a(th5);
            IronLog.INTERNAL.error(th5.toString());
        }
        try {
            httpURLConnection.setRequestMethod("GET");
            if (z) {
                try {
                    httpURLConnection.setRequestProperty(e, f);
                } catch (IllegalStateException e8) {
                    C3260q4.d().a(e8);
                }
            }
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i3);
            httpURLConnection.connect();
            i4 = httpURLConnection.getResponseCode();
        } catch (FileNotFoundException e9) {
            e = e9;
            C3260q4.d().a(e);
            i = 1018;
            if (0 != 0) {
                (objArr2 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i);
            return c3058e5;
        } catch (Error e10) {
            e = e10;
            C3260q4.d().a(e);
            i4 = 1019;
            if (!TextUtils.isEmpty(e.getMessage())) {
                Logger.i(d, e.getMessage());
            }
            if (0 != 0) {
                (objArr3 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i4);
            return c3058e5;
        } catch (MalformedURLException e11) {
            e = e11;
            C3260q4.d().a(e);
            i = 1004;
            if (0 != 0) {
                (objArr4 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i);
            return c3058e5;
        } catch (SocketTimeoutException e12) {
            e = e12;
            C3260q4.d().a(e);
            i = 1008;
            if (0 != 0) {
                (objArr5 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i);
            return c3058e5;
        } catch (URISyntaxException e13) {
            e = e13;
            C3260q4.d().a(e);
            i = 1010;
            if (0 != 0) {
                (objArr6 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i);
            return c3058e5;
        } catch (Exception e14) {
            e = e14;
            C3260q4.d().a(e);
            if (!TextUtils.isEmpty(e.getMessage())) {
                Logger.i(d, e.getMessage());
            }
            i = 1009;
            if (0 != 0) {
                (objArr7 == true ? 1 : 0).close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            c3058e5.a(str);
            c3058e5.a(i);
            return c3058e5;
        }
        if (i4 >= 200 && i4 < 400) {
            inputStream2 = httpURLConnection.getInputStream();
            c3058e5.a(a(inputStream2));
            if (inputStream2 != null) {
                inputStream2.close();
            }
            httpURLConnection.disconnect();
            c3058e5.a(str);
            c3058e5.a(i4);
            return c3058e5;
        }
        Logger.i(d, " RESPONSE CODE: " + i4 + " URL: " + str + " ATTEMPT: " + i);
        i4 = 1011;
        if (inputStream2 != null) {
        }
        httpURLConnection.disconnect();
        c3058e5.a(str);
        c3058e5.a(i4);
        return c3058e5;
    }
}
