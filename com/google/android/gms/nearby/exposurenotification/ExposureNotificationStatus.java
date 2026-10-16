package com.google.android.gms.nearby.exposurenotification;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.nearby.zzsr;
import com.google.android.gms.internal.nearby.zzss;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public enum ExposureNotificationStatus {
    ACTIVATED(1),
    INACTIVATED(2),
    BLUETOOTH_DISABLED(4),
    LOCATION_DISABLED(8),
    NO_CONSENT(16),
    NOT_IN_ALLOWLIST(32),
    BLUETOOTH_SUPPORT_UNKNOWN(64),
    HW_NOT_SUPPORT(128),
    FOCUS_LOST(256),
    LOW_STORAGE(512),
    UNKNOWN(1024),
    EN_NOT_SUPPORT(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH),
    USER_PROFILE_NOT_SUPPORT(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);

    private final long zzb;

    ExposureNotificationStatus(long j) {
        this.zzb = j;
    }

    public static zzss zza(long j) {
        zzsr zzsrVar = new zzsr();
        for (ExposureNotificationStatus exposureNotificationStatus : values()) {
            if ((exposureNotificationStatus.zzb & j) != 0) {
                zzsrVar.zzb(exposureNotificationStatus);
            }
        }
        return zzsrVar.zzc();
    }
}
