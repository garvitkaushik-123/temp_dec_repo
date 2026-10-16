package com.bytedance.sdk.component.ui.aGH.Os.eli.DbA;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.ui.nGm;

/* loaded from: classes3.dex */
public class DbA implements nGm {
    private int DbA;
    private int Os;
    private com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, byte[]> aGH;
    private long eli = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;

    public DbA(int i, int i2) {
        this.Os = i;
        this.DbA = i2;
        this.aGH = new com.bytedance.sdk.component.ui.aGH.Os.eli.Os<>(this.DbA);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            try {
                if (bArr.length > this.eli) {
                    return false;
                }
                this.aGH.eli(str, bArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public byte[] eli(String str) {
        try {
            return this.aGH.eli((com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, byte[]>) str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean DbA(String str) {
        return this.aGH.eli((com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, byte[]>) str) != null;
    }
}
