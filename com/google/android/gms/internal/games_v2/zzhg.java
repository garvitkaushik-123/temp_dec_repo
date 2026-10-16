package com.google.android.gms.internal.games_v2;

import com.ironsource.D5;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
public abstract class zzhg implements Map, Serializable {
    private transient zzhk zza;
    private transient zzhk zzb;
    private transient zzgy zzc;

    zzhg() {
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzih.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzhk zzhkVar = this.zzb;
        if (zzhkVar != null) {
            return zzhkVar;
        }
        zzhk zzc = zzc();
        this.zzb = zzc;
        return zzc;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzgn.zzb(size, ContentDisposition.Parameters.Size);
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append(D5.T);
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    @Override // java.util.Map
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzhk entrySet() {
        zzhk zzhkVar = this.zza;
        if (zzhkVar != null) {
            return zzhkVar;
        }
        zzhk zzb = zzb();
        this.zza = zzb;
        return zzb;
    }

    abstract zzhk zzb();

    abstract zzhk zzc();

    @Override // java.util.Map
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzgy values() {
        zzgy zzgyVar = this.zzc;
        if (zzgyVar != null) {
            return zzgyVar;
        }
        zzgy zze = zze();
        this.zzc = zze;
        return zze;
    }

    abstract zzgy zze();
}
