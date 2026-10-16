package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new zzy();
    public String afmaVersion;
    public int buddyApkVersion;
    public int clientJarVersion;
    public boolean isClientJar;
    public boolean isLiteSdk;

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public static VersionInfoParcel forPackage() {
        return new VersionInfoParcel(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.afmaVersion, false);
        SafeParcelWriter.writeInt(parcel, 3, this.buddyApkVersion);
        SafeParcelWriter.writeInt(parcel, 4, this.clientJarVersion);
        SafeParcelWriter.writeBoolean(parcel, 5, this.isClientJar);
        SafeParcelWriter.writeBoolean(parcel, 6, this.isLiteSdk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public VersionInfoParcel(int i, int i2, boolean z, boolean z2) {
        this(i, i2, z, false, z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VersionInfoParcel(int i, int i2, boolean z, boolean z2, boolean z3) {
        this("afma-sdk-a-v" + i + "." + i2 + "." + r12, i, i2, z, z3);
        String str;
        if (z) {
            str = "0";
        } else {
            str = z2 ? "2" : "1";
        }
    }

    VersionInfoParcel(String str, int i, int i2, boolean z, boolean z2) {
        this.afmaVersion = str;
        this.buddyApkVersion = i;
        this.clientJarVersion = i2;
        this.isClientJar = z;
        this.isLiteSdk = z2;
    }
}
