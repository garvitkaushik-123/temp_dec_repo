package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public class Strategy extends AbstractSafeParcelable {

    @Deprecated
    public static final Strategy BLE_ONLY;
    public static final Parcelable.Creator<Strategy> CREATOR = new zzf();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;

    @Deprecated
    public static final Strategy zza;
    final int zzb;

    @Deprecated
    final int zzc;
    final int zzd;
    final int zze;

    @Deprecated
    final boolean zzf;
    final int zzg;
    final int zzh;
    private final int zzi;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
    public static class Builder {
        private int zza = 3;
        private int zzb = 300;
        private int zzc = 0;
        private int zzd = -1;

        public Builder setDiscoveryMode(int i) {
            this.zza = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.zzc = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            boolean z = true;
            if (i != Integer.MAX_VALUE && (i <= 0 || i > 86400)) {
                z = false;
            }
            Preconditions.checkArgument(z, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), 86400);
            this.zzb = i;
            return this;
        }

        public final Builder zza(int i) {
            this.zzd = 2;
            return this;
        }

        public Strategy build() {
            if (this.zzd == 2 && this.zzc == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzb, this.zzc, false, this.zzd, this.zza, 0);
        }
    }

    static {
        Builder builder = new Builder();
        builder.zza(2);
        builder.setTtlSeconds(Integer.MAX_VALUE);
        Strategy build = builder.build();
        BLE_ONLY = build;
        zza = build;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.zzb = i;
        this.zzc = i2;
        if (i2 != 0) {
            if (i2 != 2) {
                i6 = 3;
                if (i2 == 3) {
                    this.zzh = 2;
                }
            } else {
                this.zzh = 1;
            }
            this.zze = i4;
            this.zzf = z;
            if (z) {
                this.zzd = i3;
                if (i5 == -1 || i5 == 0 || i5 == 1 || i5 == 6) {
                    this.zzg = -1;
                } else {
                    this.zzg = i5;
                }
            } else {
                this.zzg = 2;
                this.zzd = Integer.MAX_VALUE;
            }
            this.zzi = i7;
        }
        this.zzh = i6;
        this.zze = i4;
        this.zzf = z;
        if (z) {
        }
        this.zzi = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.zzb == strategy.zzb && this.zzh == strategy.zzh && this.zzd == strategy.zzd && this.zze == strategy.zze && this.zzg == strategy.zzg && this.zzi == strategy.zzi;
    }

    public int hashCode() {
        return (((((((((this.zzb * 31) + this.zzh) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzg) * 31) + this.zzi;
    }

    public String toString() {
        String str;
        String obj;
        String obj2;
        int i = this.zzd;
        int i2 = this.zze;
        String str2 = "DEFAULT";
        if (i2 == 0) {
            str = "DEFAULT";
        } else if (i2 != 1) {
            str = "UNKNOWN:" + i2;
        } else {
            str = "EARSHOT";
        }
        int i3 = this.zzg;
        if (i3 == -1) {
            obj = "DEFAULT";
        } else {
            ArrayList arrayList = new ArrayList();
            if ((i3 & 4) > 0) {
                arrayList.add("ULTRASOUND");
            }
            if ((i3 & 2) > 0) {
                arrayList.add("BLE");
            }
            if (arrayList.isEmpty()) {
                obj = "UNKNOWN:" + i3;
            } else {
                obj = arrayList.toString();
            }
        }
        int i4 = this.zzh;
        if (i4 == 3) {
            obj2 = "DEFAULT";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if ((i4 & 1) > 0) {
                arrayList2.add("BROADCAST");
            }
            if ((i4 & 2) > 0) {
                arrayList2.add("SCAN");
            }
            if (arrayList2.isEmpty()) {
                obj2 = "UNKNOWN:" + i4;
            } else {
                obj2 = arrayList2.toString();
            }
        }
        int i5 = this.zzi;
        if (i5 != 0) {
            if (i5 != 1) {
                str2 = "UNKNOWN: " + i5;
            } else {
                str2 = "ALWAYS_ON";
            }
        }
        return "Strategy{ttlSeconds=" + i + ", distanceType=" + str + ", discoveryMedium=" + obj + ", discoveryMode=" + obj2 + ", backgroundScanMode=" + str2 + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzc);
        SafeParcelWriter.writeInt(parcel, 2, this.zzd);
        SafeParcelWriter.writeInt(parcel, 3, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzf);
        SafeParcelWriter.writeInt(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 6, this.zzh);
        SafeParcelWriter.writeInt(parcel, 7, this.zzi);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzi;
    }
}
