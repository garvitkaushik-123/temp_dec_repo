package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzms extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzms> CREATOR = new zzmt();
    private zzkm zza;
    private zzjp zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private AdvertisingOptions zzf;
    private zzjv zzg;
    private byte[] zzh;

    private zzms() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzms) {
            zzms zzmsVar = (zzms) obj;
            if (Objects.equal(this.zza, zzmsVar.zza) && Objects.equal(this.zzb, zzmsVar.zzb) && Objects.equal(this.zzc, zzmsVar.zzc) && Objects.equal(this.zzd, zzmsVar.zzd) && Objects.equal(Long.valueOf(this.zze), Long.valueOf(zzmsVar.zze)) && Objects.equal(this.zzf, zzmsVar.zzf) && Objects.equal(this.zzg, zzmsVar.zzg) && Arrays.equals(this.zzh, zzmsVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Long.valueOf(this.zze), this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzh)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkm zzkmVar = this.zza;
        SafeParcelWriter.writeIBinder(parcel, 1, zzkmVar == null ? null : zzkmVar.asBinder(), false);
        zzjp zzjpVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 2, zzjpVar == null ? null : zzjpVar.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        zzjv zzjvVar = this.zzg;
        SafeParcelWriter.writeIBinder(parcel, 7, zzjvVar != null ? zzjvVar.asBinder() : null, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    zzms(IBinder iBinder, IBinder iBinder2, String str, String str2, long j, AdvertisingOptions advertisingOptions, IBinder iBinder3, byte[] bArr) {
        zzkm zzkkVar;
        zzjp zzjnVar;
        zzjv zzjvVar = null;
        if (iBinder == null) {
            zzkkVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            zzkkVar = queryLocalInterface instanceof zzkm ? (zzkm) queryLocalInterface : new zzkk(iBinder);
        }
        if (iBinder2 == null) {
            zzjnVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            zzjnVar = queryLocalInterface2 instanceof zzjp ? (zzjp) queryLocalInterface2 : new zzjn(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            zzjvVar = queryLocalInterface3 instanceof zzjv ? (zzjv) queryLocalInterface3 : new zzjt(iBinder3);
        }
        this.zza = zzkkVar;
        this.zzb = zzjnVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = j;
        this.zzf = advertisingOptions;
        this.zzg = zzjvVar;
        this.zzh = bArr;
    }

    /* synthetic */ zzms(zzmr zzmrVar) {
    }
}
