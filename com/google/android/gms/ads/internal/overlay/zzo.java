package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        String str4 = null;
        com.google.android.gms.ads.internal.zzl zzlVar = null;
        IBinder iBinder6 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        IBinder iBinder7 = null;
        IBinder iBinder8 = null;
        IBinder iBinder9 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.createParcelable(parcel, readHeader, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 11:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 12:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.createParcelable(parcel, readHeader, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                case 20:
                case 21:
                case 22:
                case 23:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 16:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 17:
                    zzlVar = (com.google.android.gms.ads.internal.zzl) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.ads.internal.zzl.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 19:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 24:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 25:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 26:
                    iBinder7 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 27:
                    iBinder8 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 28:
                    iBinder9 = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 29:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 30:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, versionInfoParcel, str4, zzlVar, iBinder6, str5, str6, str7, iBinder7, iBinder8, iBinder9, z2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
