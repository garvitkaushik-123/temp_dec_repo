package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zzk extends zzl {
    zzk() {
    }

    @Override // com.google.android.gms.games.zzl, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.zzl
    /* renamed from: zza */
    public final PlayerEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzp;
        boolean canUnparcelSafely;
        unparcelClientVersion = PlayerEntity.getUnparcelClientVersion();
        zzp = PlayerEntity.zzp(unparcelClientVersion);
        if (!zzp) {
            canUnparcelSafely = PlayerEntity.canUnparcelSafely(PlayerEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                return new PlayerEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 != null ? Uri.parse(readString4) : null, parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1L, null, null, false, null);
            }
        }
        return super.createFromParcel(parcel);
    }
}
