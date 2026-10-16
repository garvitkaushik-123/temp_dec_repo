package com.apm.insight.k;

import com.apm.insight.MonitorCrash;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MultipartUtility.java */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final String f284a;
    private HttpURLConnection b;
    private String c;
    private boolean d;
    private f e;
    private k f;

    public i(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f284a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestMethod("POST");
        if (MonitorCrash.mCustomRequestHeader != null) {
            MonitorCrash.mCustomRequestHeader.addRequestHeader(this.b);
        }
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (z) {
            this.b.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
            this.f = new k(this.b.getOutputStream());
        } else {
            this.e = new f(this.b.getOutputStream());
        }
    }

    public final void a(String str, String str2) {
        b(str, str2);
    }

    public final void b(String str, String str2) {
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f284a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"\r\nContent-Type: text/plain; charset=").append(this.c).append("\r\n\r\n");
        try {
            if (this.d) {
                this.f.write(sb.toString().getBytes());
            } else {
                this.e.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        try {
            if (this.d) {
                this.f.write(bytes);
                this.f.write("\r\n".getBytes());
            } else {
                this.e.write(bytes);
                this.e.write("\r\n".getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    public final void a(String str, File... fileArr) throws IOException {
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f284a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(str).append("\"\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        if (this.d) {
            com.apm.insight.l.f.a(this.f, fileArr);
        } else {
            com.apm.insight.l.f.a(this.e, fileArr);
        }
        if (this.d) {
            this.f.write("\r\n".getBytes());
        } else {
            this.e.write("\r\n".getBytes());
            this.e.flush();
        }
    }

    public final void a(String str, File file, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder("--");
        sb.append(this.f284a).append("\r\nContent-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.f.write(bArr, 0, read);
            } else {
                this.e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.f.write("\r\n".getBytes());
        } else {
            this.e.write("\r\n".getBytes());
            this.e.flush();
        }
    }

    public final String a() throws IOException {
        ArrayList arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.f284a + "--\r\n").getBytes();
        if (this.d) {
            this.f.write(bytes);
            this.f.b();
            this.f.a();
        } else {
            this.e.write(bytes);
            this.e.flush();
            this.e.a();
        }
        int responseCode = this.b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.b.disconnect();
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: ".concat(String.valueOf(responseCode)));
    }
}
