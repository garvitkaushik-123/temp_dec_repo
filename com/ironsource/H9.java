package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class H9 {

    class a extends GZIPOutputStream {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2897a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(OutputStream outputStream, int i) throws IOException {
            super(outputStream);
            this.f2897a = i;
            if (i < 0 || i > 9) {
                return;
            }
            ((GZIPOutputStream) this).def.setLevel(i);
        }
    }

    public static byte[] a(String str, int i) throws Exception {
        byte[] bArr = new byte[0];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            a aVar = new a(byteArrayOutputStream, i);
            aVar.write(str.getBytes());
            aVar.close();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (OutOfMemoryError e) {
            C3260q4.d().a(e);
            String str2 = "Error while compressing:" + e.getMessage();
            IronLog.INTERNAL.error(str2);
            b(str2);
            return bArr;
        }
    }

    private static void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        C3334ub.U().q().a(new C3413z5(A5.TROUBLESHOOTING_FAILED_TO_GZIP, jSONObject));
    }

    public static byte[] a(String str) throws Exception {
        return a(str, -1);
    }

    public static String a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("exception while decompressing " + e);
            return null;
        } catch (OutOfMemoryError e2) {
            C3260q4.d().a(e2);
            String str = "Error while decompressing:" + e2.getMessage();
            IronLog.INTERNAL.error(str);
            b(str);
            return null;
        }
    }
}
