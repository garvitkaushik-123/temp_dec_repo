package com.ironsource.mediationsdk.server;

import android.text.TextUtils;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC3077f7;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
/* loaded from: classes6.dex */
public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";

    /* renamed from: a, reason: collision with root package name */
    private static final int f3575a = 15000;
    private static final String b = "GET";
    private static final String c = "POST";
    private static final String d = "UTF-8";
    private static final String e = "Bad Request - 400";
    private static final ExecutorService f = Executors.newSingleThreadExecutor();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3576a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC3077f7 c;

        a(String str, String str2, InterfaceC3077f7 interfaceC3077f7) {
            this.f3576a = str;
            this.b = str2;
            this.c = interfaceC3077f7;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            OutputStream outputStream;
            try {
                httpURLConnection = HttpFunctions.a(this.f3576a);
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        try {
                            HttpFunctions.a(this.b, outputStream);
                            int responseCode = httpURLConnection.getResponseCode();
                            boolean z = responseCode == 200;
                            if (!z) {
                                IronLog.INTERNAL.error("invalid response code " + responseCode + " sending request");
                            }
                            this.c.a(z);
                        } catch (Exception e) {
                            e = e;
                            C3260q4.d().a(e);
                            IronLog.INTERNAL.error("exception while sending request " + e.getMessage());
                            this.c.a(false);
                            HttpFunctions.a(outputStream, httpURLConnection, null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        HttpFunctions.a(outputStream, httpURLConnection, null);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    outputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    HttpFunctions.a(outputStream, httpURLConnection, null);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                outputStream = null;
            }
            HttpFunctions.a(outputStream, httpURLConnection, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public static String getStringFromURL(String str) throws Exception {
        return getStringFromURL(str, null);
    }

    public static void sendPostRequest(String str, String str2, InterfaceC3077f7 interfaceC3077f7) {
        f.submit(new a(str, str2, interfaceC3077f7));
    }

    public static String getStringFromURL(String str, p.c cVar) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        Exception e2;
        BufferedReader bufferedReader2;
        Throwable th;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 400) {
                    if (cVar != null) {
                        cVar.a(e);
                    }
                    a(null, httpURLConnection, null);
                    return null;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    String a2 = a(bufferedReader2);
                    a(null, httpURLConnection, bufferedReader2);
                    return a2;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        C3260q4.d().a(e2);
                        a(null, httpURLConnection, bufferedReader2);
                        return null;
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        BufferedReader bufferedReader3 = bufferedReader;
                        th = th;
                        bufferedReader2 = bufferedReader3;
                        a(null, httpURLConnection, bufferedReader2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a(null, httpURLConnection, bufferedReader2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                e2 = e;
                bufferedReader2 = null;
                C3260q4.d().a(e2);
                a(null, httpURLConnection, bufferedReader2);
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                BufferedReader bufferedReader32 = bufferedReader;
                th = th;
                bufferedReader2 = bufferedReader32;
                a(null, httpURLConnection, bufferedReader2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public static String sendPostRequest(String str, String str2, p.c cVar) {
        Throwable th;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        Exception e2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = a(str);
            try {
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                outputStream = httpURLConnection.getOutputStream();
                try {
                    a(str2, outputStream);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        if (responseCode == 400 && cVar != null) {
                            cVar.a(e);
                        }
                        a(outputStream, httpURLConnection, null);
                        return null;
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        String a2 = a(bufferedReader);
                        a(outputStream, httpURLConnection, bufferedReader);
                        return a2;
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            C3260q4.d().a(e2);
                            IronLog.INTERNAL.error("exception while sending request " + e2.getMessage());
                            a(outputStream, httpURLConnection, bufferedReader);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection;
                            httpURLConnection = httpURLConnection2;
                            a(outputStream, httpURLConnection, bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        a(outputStream, httpURLConnection, bufferedReader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedReader = null;
                    C3260q4.d().a(e2);
                    IronLog.INTERNAL.error("exception while sending request " + e2.getMessage());
                    a(outputStream, httpURLConnection, bufferedReader);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection = httpURLConnection2;
                    a(outputStream, httpURLConnection, bufferedReader);
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                outputStream = null;
            }
        } catch (Exception e6) {
            e2 = e6;
            httpURLConnection = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
            outputStream = null;
            httpURLConnection = httpURLConnection2;
            a(outputStream, httpURLConnection, bufferedReader);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        bufferedWriter.write(str);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(OutputStream outputStream, HttpURLConnection httpURLConnection, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error("exception while closing output stream " + e2.getMessage());
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                C3260q4.d().a(e3);
                IronLog.INTERNAL.error("exception while closing reader " + e3.getMessage());
            }
        }
    }
}
