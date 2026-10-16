package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzfwc extends zzfuu {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    protected zzfwc(zzfwe zzfweVar, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzfuu
    protected final /* bridge */ /* synthetic */ Object zza() {
        int zzc;
        int i = this.zzc;
        while (true) {
            int i2 = this.zzc;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int zzd = zzd(i2);
            if (zzd == -1) {
                zzd = this.zzb.length();
                this.zzc = -1;
                zzc = -1;
            } else {
                zzc = zzc(zzd);
                this.zzc = zzc;
            }
            if (zzc != i) {
                if (i < zzd) {
                    this.zzb.charAt(i);
                }
                if (i < zzd) {
                    this.zzb.charAt(zzd - 1);
                }
                int i3 = this.zzd;
                if (i3 == 1) {
                    CharSequence charSequence = this.zzb;
                    int length = charSequence.length();
                    this.zzc = -1;
                    if (length > i) {
                        charSequence.charAt(length - 1);
                    }
                    zzd = length;
                } else {
                    this.zzd = i3 - 1;
                }
                return this.zzb.subSequence(i, zzd).toString();
            }
            int i4 = zzc + 1;
            this.zzc = i4;
            if (i4 > this.zzb.length()) {
                this.zzc = -1;
            }
        }
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
