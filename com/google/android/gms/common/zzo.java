package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
abstract class zzo extends zzm {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    zzo(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    protected abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzm
    final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
