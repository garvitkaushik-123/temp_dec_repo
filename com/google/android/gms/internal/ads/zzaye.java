package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaye extends zzayk {
    private final zzaxe zzh;
    private long zzi;

    public zzaye(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, zzaxe zzaxeVar) {
        super(zzawxVar, "YdsvNQpLn71zCPsmNiBmaxgvKAoUotN+t67Ej8NmXEez61kI/ElwL7USsI8xuH+E", "BTo9KBR1VAIklcWQcnKn1k6hpYvG+18rom++PUlQVcU=", zzastVar, i, 53);
        this.zzh = zzaxeVar;
        if (zzaxeVar != null) {
            this.zzi = zzaxeVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzN(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
