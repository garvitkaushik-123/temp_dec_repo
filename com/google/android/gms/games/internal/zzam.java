package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.compose.runtime.ComposeVersion;
import com.facebook.ads.AdError;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
public final class zzam extends com.google.android.gms.internal.games_v2.zza implements IInterface {
    zzam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    public final void zzA(zzaj zzajVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zzc(12002, zza);
    }

    public final void zzB(zzaj zzajVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, contents);
        zzc(12007, zza);
    }

    public final void zzC(Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, contents);
        zzc(ComposeVersion.version, zza);
    }

    public final void zzD(zzaj zzajVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zzc(12020, zza);
    }

    public final void zzE(zzaj zzajVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, contents);
        zzc(12033, zza);
    }

    public final int zzF() throws RemoteException {
        Parcel zzb = zzb(12035, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final int zzG() throws RemoteException {
        Parcel zzb = zzb(12036, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final void zzH(zzaj zzajVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zzc(12016, zza);
    }

    public final void zzI(zzaj zzajVar, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zza.writeStringArray(strArr);
        zzc(12031, zza);
    }

    public final void zzJ(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzc(12017, zza);
    }

    public final void zzK(zzaj zzajVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zzc(13006, zza);
    }

    public final void zzL(zzaj zzajVar, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(i);
        zzc(15001, zza);
    }

    public final void zzM(zzal zzalVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzalVar);
        zza.writeLong(j);
        zzc(15501, zza);
    }

    public final Intent zzN(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, playerEntity);
        Parcel zzb = zzb(15503, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final void zzO(zzaj zzajVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zzc(17001, zza);
    }

    public final Intent zzP(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zzb = zzb(18001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final PendingIntent zzQ() throws RemoteException {
        Parcel zzb = zzb(25015, zza());
        PendingIntent pendingIntent = (PendingIntent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, PendingIntent.CREATOR);
        zzb.recycle();
        return pendingIntent;
    }

    public final Intent zzR(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(25016, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final void zzS(zzaj zzajVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zzc(27003, zza);
    }

    public final void zzT(zzaj zzajVar, String str, boolean z, List list) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zza.writeStringList(list);
        zzc(27012, zza);
    }

    public final void zzd(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(5001, zza);
    }

    public final void zze(zzaj zzajVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zzc(5002, zza);
    }

    public final void zzf(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zzc(IronSourceConstants.errorCode_loadException, zza);
    }

    public final void zzg() throws RemoteException {
        zzc(IronSourceConstants.errorCode_showFailed, zza());
    }

    public final String zzh() throws RemoteException {
        Parcel zzb = zzb(5012, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final DataHolder zzi() throws RemoteException {
        Parcel zzb = zzb(5013, zza());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, DataHolder.CREATOR);
        zzb.recycle();
        return dataHolder;
    }

    public final void zzj(zzaj zzajVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(z ? 1 : 0);
        zzc(5019, zza);
    }

    public final void zzk(zzaj zzajVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(z ? 1 : 0);
        zzc(5020, zza);
    }

    public final void zzl(zzaj zzajVar, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(5021, zza);
    }

    public final void zzm(zzaj zzajVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zzc(5023, zza);
    }

    public final void zzn(zzaj zzajVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zzc(5024, zza);
    }

    public final void zzo(zzaj zzajVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zzc(5025, zza);
    }

    public final void zzp(zzaj zzajVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zzc(6001, zza);
    }

    public final void zzq(zzaj zzajVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeInt(z ? 1 : 0);
        zzc(6503, zza);
    }

    public final void zzr(zzaj zzajVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zzc(6504, zza);
    }

    public final void zzs(zzaj zzajVar, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzc(AdError.LOAD_CALLED_WHILE_SHOWING_AD, zza);
    }

    public final void zzt(zzaj zzajVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, bundle);
        zzc(AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED, zza);
    }

    public final void zzu(zzaj zzajVar, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(ConnectionsStatusCodes.STATUS_ALREADY_ADVERTISING, zza);
    }

    public final Intent zzv() throws RemoteException {
        Parcel zzb = zzb(9003, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzw() throws RemoteException {
        Parcel zzb = zzb(9005, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final Intent zzx() throws RemoteException {
        Parcel zzb = zzb(9010, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    public final void zzy(zzaj zzajVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, zzajVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zzc(9020, zza);
    }

    public final Intent zzz(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        int i2 = com.google.android.gms.internal.games_v2.zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeInt(i);
        Parcel zzb = zzb(12001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zzb(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }
}
