package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public class zzagu implements zzau {
    public final String zza;
    public final String zzb;

    public zzagu(String str, String str2) {
        this.zza = zzfuv.zzb(str);
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagu zzaguVar = (zzagu) obj;
            if (this.zza.equals(zzaguVar.zza) && this.zzb.equals(zzaguVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + C3040d4.i.b + this.zzb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        char c;
        String str = this.zza;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                zzarVar.zzr(this.zzb);
                break;
            case 1:
                zzarVar.zze(this.zzb);
                break;
            case 2:
                zzarVar.zzd(this.zzb);
                break;
            case 3:
                zzarVar.zzc(this.zzb);
                break;
            case 4:
                Integer zzg = zzgbt.zzg(this.zzb, 10);
                if (zzg != null) {
                    zzarVar.zzu(zzg);
                    break;
                }
                break;
            case 5:
                Integer zzg2 = zzgbt.zzg(this.zzb, 10);
                if (zzg2 != null) {
                    zzarVar.zzt(zzg2);
                    break;
                }
                break;
            case 6:
                Integer zzg3 = zzgbt.zzg(this.zzb, 10);
                if (zzg3 != null) {
                    zzarVar.zzi(zzg3);
                    break;
                }
                break;
            case 7:
                Integer zzg4 = zzgbt.zzg(this.zzb, 10);
                if (zzg4 != null) {
                    zzarVar.zzs(zzg4);
                    break;
                }
                break;
            case '\b':
                zzarVar.zzj(this.zzb);
                break;
            case '\t':
                zzarVar.zzh(this.zzb);
                break;
        }
    }
}
