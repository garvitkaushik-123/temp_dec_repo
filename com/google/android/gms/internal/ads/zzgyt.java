package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyt extends zzgys {
    zzgyt() {
    }

    @Override // com.google.android.gms.internal.ads.zzgys
    final void zza(Object obj) {
        ((zzgzd) obj).zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgys
    final void zzb(zzhcm zzhcmVar, Map.Entry entry) throws IOException {
        zzgze zzgzeVar = (zzgze) entry.getKey();
        if (!zzgzeVar.zzc) {
            zzhck zzhckVar = zzhck.DOUBLE;
            switch (zzgzeVar.zzb) {
                case DOUBLE:
                    zzhcmVar.zzf(zzgzeVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzhcmVar.zzo(zzgzeVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzhcmVar.zzt(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzhcmVar.zzK(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzhcmVar.zzr(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzhcmVar.zzm(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzhcmVar.zzk(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzhcmVar.zzb(zzgzeVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzhcmVar.zzG(zzgzeVar.zza, (String) entry.getValue());
                    break;
                case GROUP:
                    zzhcmVar.zzq(zzgzeVar.zza, entry.getValue(), zzhbc.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzhcmVar.zzv(zzgzeVar.zza, entry.getValue(), zzhbc.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzhcmVar.zzd(zzgzeVar.zza, (zzgxz) entry.getValue());
                    break;
                case UINT32:
                    zzhcmVar.zzI(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzhcmVar.zzr(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzhcmVar.zzx(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzhcmVar.zzz(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzhcmVar.zzB(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzhcmVar.zzD(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzhck zzhckVar2 = zzhck.DOUBLE;
        switch (zzgzeVar.zzb) {
            case DOUBLE:
                zzhbn.zzt(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case FLOAT:
                zzhbn.zzx(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case INT64:
                zzhbn.zzA(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case UINT64:
                zzhbn.zzI(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case INT32:
                zzhbn.zzz(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case FIXED64:
                zzhbn.zzw(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case FIXED32:
                zzhbn.zzv(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case BOOL:
                zzhbn.zzr(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case STRING:
                zzhbn.zzG(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzhbn.zzy(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzhbc.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzhbn.zzB(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzhbc.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzhbn.zzs(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar);
                break;
            case UINT32:
                zzhbn.zzH(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case ENUM:
                zzhbn.zzz(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case SFIXED32:
                zzhbn.zzC(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case SFIXED64:
                zzhbn.zzD(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case SINT32:
                zzhbn.zzE(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case SINT64:
                zzhbn.zzF(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
        }
    }
}
