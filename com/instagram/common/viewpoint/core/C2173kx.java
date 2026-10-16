package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.kx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2173kx implements LU<Bitmap> {
    public static byte[] A06;
    public final int A00;
    public final int A01;
    public final String A02 = C2173kx.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-110, -40, -47, -44, 3, 42, 53, 46, 34, 49, -31, 42, 52, -31, 47, 54, 45, 45, -55, -4, -25, -23, -12, -8, -19, -13, -14, -92, -24, -7, -10, -19, -14, -21, -92, -22, -19, -16, -23, -92, -25, -13, -15, -12, -10, -23, -9, -9, -19, -13, -14};
    }

    public C2173kx(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.A01 = i;
        this.A00 = i2;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = z3;
    }

    public static LT<Bitmap> A00(Throwable th) {
        return new LT<>(false, null, th);
    }

    private void A03(File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            ByteArrayOutputStream compressedBitmapOS = new ByteArrayOutputStream();
            byteArrayOutputStream = compressedBitmapOS;
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 25);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream2.write(bArr, 0, read);
                } else {
                    file2.delete();
                    return;
                }
            }
        } finally {
            AbstractC1149Ln.A07(byteArrayOutputStream);
            AbstractC1149Ln.A07(fileOutputStream);
            AbstractC1149Ln.A07(fileInputStream);
            AbstractC1149Ln.A07(fileOutputStream2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.LU
    public final LT<Bitmap> A3x(File file, InterfaceC1148Lm interfaceC1148Lm) {
        if (!this.A04) {
            return new LT<>(true, null);
        }
        try {
            Bitmap A03 = AbstractC1149Ln.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (A03 != null) {
                return new LT<>(true, A03);
            }
            interfaceC1148Lm.AB4(new C2164kn(A01(4, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)));
            return A00(null);
        } catch (Throwable t) {
            file.delete();
            interfaceC1148Lm.AB4(t);
            return A00(t);
        }
    }

    @Override // com.instagram.common.viewpoint.core.LU
    public final void A5D(File file, InterfaceC1148Lm interfaceC1148Lm) throws C2164kn {
        if (this.A03) {
            try {
                Bitmap bitmap = AbstractC1149Ln.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (bitmap != null) {
                    A03(file, bitmap);
                } else {
                    file.delete();
                    throw new C2164kn(A01(4, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
                }
            } catch (C2164kn e) {
                interfaceC1148Lm.ABI(e);
                throw e;
            } catch (Throwable th) {
                interfaceC1148Lm.ABI(th);
                Throwable t = new C2164kn(A01(18, 33, 57), th);
                throw t;
            }
        }
    }
}
