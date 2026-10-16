package com.google.android.gms.internal.consent_sdk;

import io.bidmachine.IABSharedPreference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public abstract class zzdf extends zzdb implements Set {
    private transient zzde zza;

    zzdf() {
    }

    static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    public static zzdf zzi() {
        return zzdi.zza;
    }

    public static zzdf zzj(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzm(4, "IABTCF_TCString", IABSharedPreference.IAB_GPP_HDR_STRING, IABSharedPreference.IAB_GPP_SID, "IABUSPrivacy_String");
    }

    public static zzdf zzk(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzm(5, "UMP_CoMoAdStoragePurposeConsentStatus", "UMP_CoMoAdUserDataPurposeConsentStatus", "UMP_CoMoAdPersonalizationPurposeConsentStatus", "UMP_CoMoAnalyticsStoragePurposeConsentStatus", "IABTCF_gdprApplies");
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdf) && zzl() && ((zzdf) obj).zzl() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzdk iterator();

    public final zzde zzg() {
        zzde zzdeVar = this.zza;
        if (zzdeVar != null) {
            return zzdeVar;
        }
        zzde zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    zzde zzh() {
        Object[] array = toArray();
        int i = zzde.zzd;
        return zzde.zzg(array, array.length);
    }

    boolean zzl() {
        return false;
    }

    private static zzdf zzm(int i, Object... objArr) {
        if (i == 0) {
            return zzdi.zza;
        }
        if (i == 1) {
            return new zzdj(Objects.requireNonNull(objArr[0]));
        }
        int zzf = zzf(i);
        Object[] objArr2 = new Object[zzf];
        int i2 = zzf - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            if (obj == null) {
                throw new NullPointerException("at index " + i5);
            }
            int hashCode = obj.hashCode();
            int zza = zzda.zza(hashCode);
            while (true) {
                int i6 = zza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += hashCode;
                    i4++;
                    break;
                }
                if (!obj2.equals(obj)) {
                    zza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzdj(Objects.requireNonNull(objArr[0]));
        }
        if (zzf(i4) < zzf / 2) {
            return zzm(i4, objArr);
        }
        if (i4 < 3) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzdi(objArr, i3, objArr2, i2, i4);
    }
}
