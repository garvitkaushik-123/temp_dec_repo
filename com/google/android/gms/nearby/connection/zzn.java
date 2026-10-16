package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzn {
    private String zza;
    private String zzb;
    private BluetoothDevice zzc;
    private byte[] zzd;

    public final zzn zza(BluetoothDevice bluetoothDevice) {
        this.zzc = bluetoothDevice;
        this.zzb = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.zzd = "__UNRECOGNIZED_BLUETOOTH_DEVICE__".getBytes();
        return this;
    }

    public final zzn zzb(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzn zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzn zzd(String str) {
        this.zza = str;
        return this;
    }

    public final DiscoveredEndpointInfo zze() {
        return new DiscoveredEndpointInfo(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
