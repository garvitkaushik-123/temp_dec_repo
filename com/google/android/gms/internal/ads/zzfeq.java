package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.ironsource.C3355vf;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfeq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfeq> CREATOR = new zzfer();

    @Nullable
    public final Context zza;
    public final zzfen zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;
    public final int zzg;
    private final zzfen[] zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    public zzfeq(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        zzfen[] values = zzfen.values();
        this.zzh = values;
        int[] zza = zzfeo.zza();
        this.zzl = zza;
        int[] zza2 = zzfep.zza();
        this.zzm = zza2;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza[i5];
        this.zzk = i6;
        int i7 = zza2[i6];
    }

    @Nullable
    public static zzfeq zza(zzfen zzfenVar, Context context) {
        if (zzfenVar == zzfen.Rewarded) {
            return new zzfeq(context, zzfenVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgC)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgI)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgK)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgM), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgE), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgG));
        }
        if (zzfenVar == zzfen.Interstitial) {
            return new zzfeq(context, zzfenVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgD)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgJ)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgL)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgN), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgF), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgH));
        }
        if (zzfenVar != zzfen.AppOpen) {
            return null;
        }
        return new zzfeq(context, zzfenVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgQ)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgS)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgT)).intValue(), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgO), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgP), (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgR));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfeq(@Nullable Context context, zzfen zzfenVar, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfen.values();
        this.zzl = zzfeo.zza();
        this.zzm = zzfep.zza();
        this.zza = context;
        this.zzi = zzfenVar.ordinal();
        this.zzb = zzfenVar;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else {
            i4 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        C3355vf.g.equals(str3);
        this.zzk = 0;
    }
}
