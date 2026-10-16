package com.google.android.gms.internal.games_v2;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
abstract class zzgu implements Comparable, Serializable {
    final Comparable zza = "";

    zzgu(Comparable comparable) {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgu) {
            try {
                if (compareTo((zzgu) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    abstract void zza(StringBuilder sb);

    abstract void zzb(StringBuilder sb);

    @Override // java.lang.Comparable
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public int compareTo(zzgu zzguVar) {
        zzgt zzgtVar;
        zzgr zzgrVar;
        zzgtVar = zzgt.zzb;
        if (zzguVar == zzgtVar) {
            return 1;
        }
        zzgrVar = zzgr.zzb;
        if (zzguVar == zzgrVar) {
            return -1;
        }
        Comparable comparable = zzguVar.zza;
        int i = zzhw.zzc;
        int compareTo = "".compareTo("");
        return compareTo != 0 ? compareTo : Boolean.compare(this instanceof zzgs, zzguVar instanceof zzgs);
    }
}
