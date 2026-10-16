package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class S7 extends AsyncTask<S9, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"Er5x4Nf8UA9tVLePD2EX", "DtYF9X90t5u", "I941X6fzqWLmgCmjxes", "iBgQ7OI2DFUGAw4NUel9vSUdaaiAzSqO", "QcmiodlDN7oY3kgnmckrDpvdiERsjn9V", "z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "KLyCCmbDECCjA8c7XM6gY8wQDdZdMwfW"};
    public final S8 A00;
    public final C1929gi A01;
    public final boolean A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final Drawable A00(S9... s9Arr) {
        if (!WU.A02(this) && s9Arr != null) {
            try {
                if (s9Arr.length >= 1) {
                    String str = s9Arr[0].A01;
                    String str2 = s9Arr[0].A00;
                    Bitmap bitmap = null;
                    try {
                        bitmap = new C1335Sx(this.A01).A0O(str, -1, -1);
                    } catch (Throwable th) {
                        this.A01.A08().ABC(A01(0, 7, 4), AbstractC1341Td.A1V, new C1342Te(th));
                    }
                    if (bitmap != null) {
                        return UK.A05(this.A01, bitmap, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                WU.A00(th2, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] ^ i3) ^ 36;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[2] = "XzO4PGfz9rpTObXE3Krp6";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 69, 78, 69, 82, 73, 67};
    }

    static {
        A02();
    }

    public S7(C1929gi c1929gi, S8 s8, boolean z) {
        this.A01 = c1929gi;
        this.A00 = s8;
        this.A02 = z;
    }

    public /* synthetic */ S7(C1929gi c1929gi, S8 s8, boolean z, C1951h4 c1951h4) {
        this(c1929gi, s8, z);
    }

    private final void A03(Drawable drawable) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.AE8(drawable);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(S9[] s9Arr) {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A00(s9Arr);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) {
        if (WU.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
