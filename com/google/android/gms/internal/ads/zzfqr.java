package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfqr extends zzfqy {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    /* synthetic */ zzfqr(String str, boolean z, int i, zzfqn zzfqnVar, zzfqo zzfqoVar, int i2, zzfqq zzfqqVar) {
        this.zzb = str;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfqy) {
            zzfqy zzfqyVar = (zzfqy) obj;
            if (this.zzb.equals(zzfqyVar.zzc())) {
                zzfqyVar.zzd();
                int i = this.zzc;
                int zze = zzfqyVar.zze();
                if (i == 0) {
                    throw null;
                }
                if (i == zze) {
                    zzfqyVar.zza();
                    zzfqyVar.zzb();
                    int i2 = this.zzd;
                    int zzf = zzfqyVar.zzf();
                    if (i2 == 0) {
                        throw null;
                    }
                    if (zzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode() ^ 1000003;
        int i = this.zzc;
        if (i == 0) {
            throw null;
        }
        int i2 = (((hashCode * 1000003) ^ 1237) * 1000003) ^ i;
        if (this.zzd != 0) {
            return (i2 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i = this.zzc;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        String str2 = this.zzd == 1 ? "READ_AND_WRITE" : "null";
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=false, fileChecks=" + str + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + str2 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqn zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final zzfqo zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final int zzf() {
        return this.zzd;
    }
}
