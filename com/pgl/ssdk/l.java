package com.pgl.ssdk;

import com.pgl.ssdk.c;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.pgl.ssdk.g;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class l {
    public static List<e> a(q qVar, c.a aVar) throws IOException, g.a {
        return b(g.a(qVar, aVar, 1896449818).f6396a);
    }

    public static List<e> b(ByteBuffer byteBuffer) {
        try {
            ByteBuffer a2 = g.a(byteBuffer);
            if (!a2.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (a2.hasRemaining()) {
                try {
                    arrayList.add(a(g.a(a2)));
                } catch (a | BufferUnderflowException unused) {
                    return null;
                } catch (NoSuchAlgorithmException | CertificateException unused2) {
                }
            }
            return arrayList;
        } catch (a unused3) {
            return null;
        }
    }

    @DungeonFlag
    private static e a(ByteBuffer byteBuffer) throws a, NoSuchAlgorithmException, CertificateException {
        ByteBuffer a2 = g.a(byteBuffer);
        a2.get(new byte[a2.remaining()]);
        a2.flip();
        a2.position(0);
        g.a(a2);
        byte[] b = g.b(g.a(a2));
        try {
            Certificate generateCertificate = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(b));
            if (generateCertificate instanceof X509Certificate) {
                return new e(String.valueOf(((X509Certificate) generateCertificate).getSubjectDN()), b);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
