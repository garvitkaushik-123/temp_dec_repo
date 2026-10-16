package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;
import java.util.HashSet;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzy {
    private final zzz zza;
    private final zzcl zzb;
    private int zzc = 0;
    private ConsentInformation.PrivacyOptionsRequirementStatus zzd = ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN;

    zzy(zzz zzzVar, zzcl zzclVar) {
        this.zza = zzzVar;
        this.zzb = zzclVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzab zza() throws zzg {
        zzaq zzaqVar;
        zzaq zzaqVar2;
        String str;
        zze zzeVar;
        zzao zzaoVar;
        zzcl zzclVar = this.zzb;
        int i = zzclVar.zzf;
        boolean z = i == 8;
        zzz zzzVar = this.zza;
        zzaqVar = zzzVar.zzc;
        zzaqVar.zzh(z);
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                this.zzc = 3;
                break;
            case 4:
                this.zzc = 2;
                break;
            case 5:
                this.zzc = 1;
                break;
            case 6:
                throw new zzg(1, "Invalid response from server: ".concat(String.valueOf(zzclVar.zzc)));
            case 7:
                throw new zzg(3, "Publisher misconfiguration: ".concat(String.valueOf(zzclVar.zzc)));
            default:
                throw new zzg(1, "Invalid response from server.");
        }
        int i3 = zzclVar.zzg;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        if (i4 == 1) {
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
        } else {
            if (i4 != 2) {
                throw new zzg(1, "Invalid response from server.");
            }
            this.zzd = ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED;
        }
        String str2 = zzclVar.zza;
        zzbq zzbqVar = str2 == null ? null : new zzbq(zzclVar.zzb, str2);
        zzaqVar2 = zzzVar.zzc;
        zzaqVar2.zzj(new HashSet(zzclVar.zzd));
        for (zzck zzckVar : zzclVar.zze) {
            int i5 = zzckVar.zzb;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            if (i6 != 0) {
                if (i6 == 1) {
                    str = "write";
                } else if (i6 == 2) {
                    str = "clear";
                }
                if (str == null) {
                    zzeVar = zzzVar.zza;
                    String str3 = zzckVar.zza;
                    zzaoVar = zzzVar.zzb;
                    zzeVar.zzb(str, str3, zzaoVar);
                }
            }
            str = null;
            if (str == null) {
            }
        }
        return new zzab(this.zzc, this.zzd, zzbqVar, null);
    }
}
