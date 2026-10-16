package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzekb extends com.google.android.gms.ads.internal.client.zzbs {
    final zzfcu zza;
    final zzdjc zzb;
    private final Context zzc;
    private final zzche zzd;
    private com.google.android.gms.ads.internal.client.zzbk zze;

    public zzekb(zzche zzcheVar, Context context, String str) {
        zzfcu zzfcuVar = new zzfcu();
        this.zza = zzfcuVar;
        this.zzb = new zzdjc();
        this.zzd = zzcheVar;
        zzfcuVar.zzu(str);
        this.zzc = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final com.google.android.gms.ads.internal.client.zzbq zze() {
        zzdje zzg = this.zzb.zzg();
        ArrayList zzi = zzg.zzi();
        zzfcu zzfcuVar = this.zza;
        zzfcuVar.zzF(zzi);
        zzfcuVar.zzG(zzg.zzh());
        if (zzfcuVar.zzi() == null) {
            zzfcuVar.zzt(com.google.android.gms.ads.internal.client.zzr.zzc());
        }
        return new zzekc(this.zzc, this.zzd, zzfcuVar, zzg, this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzf(zzbhn zzbhnVar) {
        this.zzb.zza(zzbhnVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzg(zzbhq zzbhqVar) {
        this.zzb.zzb(zzbhqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzh(String str, zzbhw zzbhwVar, zzbht zzbhtVar) {
        this.zzb.zzc(str, zzbhwVar, zzbhtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzi(zzbmy zzbmyVar) {
        this.zzb.zzd(zzbmyVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzj(zzbia zzbiaVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb.zze(zzbiaVar);
        this.zza.zzt(zzrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzk(zzbid zzbidVar) {
        this.zzb.zzf(zzbidVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzl(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zze = zzbkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzs(adManagerAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzn(zzbmp zzbmpVar) {
        this.zza.zzx(zzbmpVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzo(zzbge zzbgeVar) {
        this.zza.zzE(zzbgeVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzI(publisherAdViewOptions);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzq(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zza.zzY(zzcsVar);
    }
}
