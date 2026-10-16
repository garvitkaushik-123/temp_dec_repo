package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zzc extends zzd {
    zzc() {
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.zzd, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.zzd
    /* renamed from: zza */
    public final RoomEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzp;
        boolean canUnparcelSafely;
        unparcelClientVersion = RoomEntity.getUnparcelClientVersion();
        zzp = RoomEntity.zzp(unparcelClientVersion);
        if (!zzp) {
            canUnparcelSafely = RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                return new RoomEntity();
            }
        }
        return super.createFromParcel(parcel);
    }
}
