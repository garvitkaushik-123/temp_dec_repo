package com.google.android.gms.internal.ads;

import com.ironsource.D5;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfyt implements Map, Serializable {
    private transient zzfyv zza;
    private transient zzfyv zzb;
    private transient zzfyl zzc;

    zzfyt() {
    }

    public static zzfyt zzc(Map map) {
        Set entrySet = map.entrySet();
        zzfys zzfysVar = new zzfys(entrySet instanceof Collection ? entrySet.size() : 4);
        zzfysVar.zzb(entrySet);
        return zzfysVar.zzc();
    }

    public static zzfyt zzd() {
        return zzgah.zza;
    }

    public static zzfyt zze(Object obj, Object obj2) {
        zzfxn.zzb("dialog_not_shown_reason", obj2);
        return zzgah.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
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
        return zzfzn.zzb(this, obj);
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
        return zzgas.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
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
        zzfxn.zza(size, ContentDisposition.Parameters.Size);
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

    abstract zzfyl zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfyl values() {
        zzfyl zzfylVar = this.zzc;
        if (zzfylVar != null) {
            return zzfylVar;
        }
        zzfyl zza = zza();
        this.zzc = zza;
        return zza;
    }

    abstract zzfyv zzf();

    abstract zzfyv zzg();

    @Override // java.util.Map
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzfyv entrySet() {
        zzfyv zzfyvVar = this.zza;
        if (zzfyvVar != null) {
            return zzfyvVar;
        }
        zzfyv zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    @Override // java.util.Map
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzfyv keySet() {
        zzfyv zzfyvVar = this.zzb;
        if (zzfyvVar != null) {
            return zzfyvVar;
        }
        zzfyv zzg = zzg();
        this.zzb = zzg;
        return zzg;
    }
}
