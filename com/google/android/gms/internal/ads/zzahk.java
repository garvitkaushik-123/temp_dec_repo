package com.google.android.gms.internal.ads;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzahk extends zzahf {
    public final String zza;
    public final zzfyq zzb;

    public zzahk(String str, String str2, List list) {
        super(str);
        zzdd.zzd(!list.isEmpty());
        this.zza = str2;
        zzfyq zzl = zzfyq.zzl(list);
        this.zzb = zzl;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahk zzahkVar = (zzahk) obj;
            if (Objects.equals(this.zzf, zzahkVar.zzf) && Objects.equals(this.zza, zzahkVar.zza) && this.zzb.equals(zzahkVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzf.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str = this.zza;
        return (((hashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        return this.zzf + ": description=" + this.zza + ": values=" + String.valueOf(this.zzb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzahf, com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        char c;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        try {
            switch (c) {
                case 0:
                case 1:
                    zzarVar.zzr((CharSequence) this.zzb.get(0));
                    break;
                case 2:
                case 3:
                    zzarVar.zze((CharSequence) this.zzb.get(0));
                    break;
                case 4:
                case 5:
                    zzarVar.zzc((CharSequence) this.zzb.get(0));
                    break;
                case 6:
                case 7:
                    zzarVar.zzd((CharSequence) this.zzb.get(0));
                    break;
                case '\b':
                case '\t':
                    String str2 = (String) this.zzb.get(0);
                    String str3 = zzex.zza;
                    String[] split = str2.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                    int parseInt = Integer.parseInt(split[0]);
                    Integer valueOf = split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null;
                    zzarVar.zzu(Integer.valueOf(parseInt));
                    zzarVar.zzt(valueOf);
                    break;
                case '\n':
                case 11:
                    zzarVar.zzm(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                    break;
                case '\f':
                case '\r':
                    String str4 = (String) this.zzb.get(0);
                    int parseInt2 = Integer.parseInt(str4.substring(2, 4));
                    int parseInt3 = Integer.parseInt(str4.substring(0, 2));
                    zzarVar.zzl(Integer.valueOf(parseInt2));
                    zzarVar.zzk(Integer.valueOf(parseInt3));
                    break;
                case 14:
                    List zzb = zzb((String) this.zzb.get(0));
                    int size = zzb.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                zzarVar.zzk((Integer) zzb.get(2));
                            }
                        }
                        zzarVar.zzl((Integer) zzb.get(1));
                    }
                    zzarVar.zzm((Integer) zzb.get(0));
                    break;
                case 15:
                    List zzb2 = zzb((String) this.zzb.get(0));
                    int size2 = zzb2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                zzarVar.zzn((Integer) zzb2.get(2));
                            }
                        }
                        zzarVar.zzo((Integer) zzb2.get(1));
                    }
                    zzarVar.zzp((Integer) zzb2.get(0));
                    break;
                case 16:
                case 17:
                    zzarVar.zzf((CharSequence) this.zzb.get(0));
                    break;
                case 18:
                case 19:
                    zzarVar.zzg((CharSequence) this.zzb.get(0));
                    break;
                case 20:
                case 21:
                    zzarVar.zzv((CharSequence) this.zzb.get(0));
                    break;
                case 22:
                    zzfyq zzfyqVar = this.zzb;
                    Integer zzg = zzgbt.zzg((String) zzfyqVar.get(0), 10);
                    if (zzg != null) {
                        String zza = zzahg.zza(zzg.intValue());
                        if (zza != null) {
                            zzarVar.zzj(zza);
                            break;
                        }
                    } else {
                        zzarVar.zzj((CharSequence) zzfyqVar.get(0));
                        break;
                    }
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }
}
