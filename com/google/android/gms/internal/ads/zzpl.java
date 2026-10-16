package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzpl extends ContentObserver {
    final /* synthetic */ zzpo zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpl(zzpo zzpoVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        Objects.requireNonNull(zzpoVar);
        this.zza = zzpoVar;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        Context context;
        zze zzeVar;
        zzpp zzppVar;
        zzpo zzpoVar = this.zza;
        context = zzpoVar.zza;
        zzeVar = zzpoVar.zzh;
        zzppVar = zzpoVar.zzg;
        zzpoVar.zzk(zzpj.zzc(context, zzeVar, zzppVar));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
