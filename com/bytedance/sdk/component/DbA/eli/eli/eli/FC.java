package com.bytedance.sdk.component.DbA.eli.eli.eli;

import com.bytedance.sdk.component.DbA.eli.Dfc;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes3.dex */
public class FC extends Dfc {
    InputStream DbA;
    HttpURLConnection eli;

    FC(HttpURLConnection httpURLConnection) throws IOException {
        this.eli = httpURLConnection;
        this.DbA = new kb(httpURLConnection.getInputStream(), httpURLConnection);
    }

    FC(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.eli = httpURLConnection;
        this.DbA = new kb(inputStream, httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc
    public long eli() {
        try {
            return this.eli.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc
    public String DbA() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.DbA));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine + "\n");
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    close();
                    return stringBuffer2;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.DbA.close();
            this.eli.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc
    public InputStream Os() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc
    public byte[] aGH() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = this.DbA.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.DbA.eli.Dfc
    public com.bytedance.sdk.component.DbA.eli.FC ui() {
        if (this.eli.getContentType() != null) {
            return com.bytedance.sdk.component.DbA.eli.FC.eli(this.eli.getContentType());
        }
        return null;
    }
}
