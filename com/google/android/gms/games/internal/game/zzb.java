package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes4.dex */
final class zzb extends zzc {
    zzb() {
    }

    @Override // com.google.android.gms.games.internal.game.zzc, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.internal.game.zzc
    /* renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzp;
        boolean canUnparcelSafely;
        unparcelClientVersion = GameBadgeEntity.getUnparcelClientVersion();
        zzp = GameBadgeEntity.zzp(unparcelClientVersion);
        if (!zzp) {
            canUnparcelSafely = GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                return new GameBadgeEntity(readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
            }
        }
        return super.createFromParcel(parcel);
    }
}
