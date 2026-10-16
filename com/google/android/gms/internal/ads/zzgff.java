package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgff {
    private final List zza = new ArrayList();
    private final zzgnh zzb = zzgnh.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgfd) it.next()).zza = false;
        }
    }

    public final zzgff zza(zzgfd zzgfdVar) {
        if (zzgfdVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgfdVar.zza) {
            zzd();
        }
        zzgfdVar.zzf = this;
        this.zza.add(zzgfdVar);
        return this;
    }

    public final zzgfi zzb() throws GeneralSecurityException {
        zzgfe zzgfeVar;
        int i;
        int i2;
        zzgfe zzgfeVar2;
        zzgfe zzgfeVar3;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        char c = 1;
        this.zzc = true;
        List<zzgfd> list = this.zza;
        zzguj zzc = zzgun.zzc();
        ArrayList arrayList = new ArrayList(list.size());
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size() - 1) {
            int i5 = i4 + 1;
            zzgfe zzgfeVar4 = ((zzgfd) list.get(i4)).zze;
            zzgfeVar2 = zzgfe.zza;
            if (zzgfeVar4 == zzgfeVar2) {
                zzgfe zzgfeVar5 = ((zzgfd) list.get(i5)).zze;
                zzgfeVar3 = zzgfe.zza;
                if (zzgfeVar5 != zzgfeVar3) {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            i4 = i5;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzgfd zzgfdVar : list) {
            zzgfb unused = zzgfdVar.zzb;
            if (zzgfdVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            zzgfe zzgfeVar6 = zzgfdVar.zze;
            zzgfeVar = zzgfe.zza;
            if (zzgfeVar6 == zzgfeVar) {
                int i6 = i3;
                while (true) {
                    if (i6 != 0 && !hashSet.contains(Integer.valueOf(i6))) {
                        break;
                    }
                    int i7 = zzgpj.zza;
                    i6 = i3;
                    while (i6 == 0) {
                        byte[] zzb = zzgpa.zzb(4);
                        i6 = (zzb[3] & 255) | ((zzb[i3] & 255) << 24) | ((zzb[c] & 255) << 16) | ((zzb[2] & 255) << 8);
                    }
                }
                i = i6;
            } else {
                zzgfe unused2 = zzgfdVar.zze;
                i = i3;
            }
            Integer valueOf = Integer.valueOf(i);
            if (hashSet.contains(valueOf)) {
                throw new GeneralSecurityException("Id " + i + " is used twice in the keyset");
            }
            hashSet.add(valueOf);
            zzgfd.zza(zzgfdVar);
            zzgez zza = zzgno.zzb().zza(zzgfdVar.zzd, c != zzgfdVar.zzd.zza() ? null : valueOf);
            zzgfg zzgfgVar = new zzgfg(zza, zzgfdVar.zzb, i, zzgfdVar.zza, null);
            int i8 = i;
            zzgfb zzgfbVar = zzgfdVar.zzb;
            zzgox zzgoxVar = (zzgox) zzgny.zzc().zzd(zza, zzgox.class, zzgfn.zza());
            Integer zzf = zzgoxVar.zzf();
            if (zzf != null && zzf.intValue() != i8) {
                throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
            }
            zzgfb zzgfbVar2 = zzgfb.zza;
            if (zzgfbVar2.equals(zzgfbVar)) {
                i2 = 3;
            } else if (zzgfb.zzb.equals(zzgfbVar)) {
                i2 = 4;
            } else {
                if (!zzgfb.zzc.equals(zzgfbVar)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i2 = 5;
            }
            zzguk zzc2 = zzgul.zzc();
            zzgty zza2 = zzgub.zza();
            zza2.zzb(zzgoxVar.zzg());
            zza2.zzc(zzgoxVar.zze());
            zza2.zza(zzgoxVar.zzb());
            zzc2.zza(zza2);
            zzc2.zzd(i2);
            zzc2.zzb(i8);
            zzc2.zzc(zzgoxVar.zzc());
            zzc.zza((zzgul) zzc2.zzbr());
            if (zzgfdVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgfdVar.zzb != zzgfbVar2) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = valueOf;
            }
            arrayList.add(zzgfgVar);
            c = 1;
            i3 = 0;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzc.zzb(num.intValue());
        zzgun zzgunVar = (zzgun) zzc.zzbr();
        zzgfi.zzj(zzgunVar);
        return new zzgfi(zzgunVar, arrayList, this.zzb);
    }
}
