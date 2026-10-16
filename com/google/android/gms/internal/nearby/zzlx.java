package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzlx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlx> CREATOR = new zzlu();
    private byte[] zza;
    private ParcelFileDescriptor zzb;

    private zzlx() {
        this.zza = new byte[0];
    }

    static byte[] zzd(ParcelFileDescriptor parcelFileDescriptor) {
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
        try {
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.read(bArr);
                return bArr;
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            }
        } finally {
            zze(dataInputStream);
        }
    }

    private static void zze(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("ParcelByteArray", "Could not close stream", e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlx) {
            return Arrays.equals(this.zza, ((zzlx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final byte[] zzc() {
        return this.zza;
    }

    zzlx(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = new byte[0];
        this.zzb = parcelFileDescriptor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ab, code lost:
    
        if (r7 == null) goto L38;
     */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00b5: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:48:0x00b5 */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void writeToParcel(Parcel parcel, int i) {
        Closeable closeable;
        DataOutputStream dataOutputStream;
        ParcelFileDescriptor parcelFileDescriptor;
        File zzb;
        byte[] bArr = this.zza;
        Closeable closeable2 = null;
        if (bArr != null) {
            try {
                if (this.zzb == null) {
                    try {
                        try {
                            zzb = zzmd.zzb();
                        } catch (IOException e) {
                            e = e;
                            dataOutputStream = null;
                        }
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dataOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (closeable2 != null) {
                            zze(closeable2);
                        }
                        throw th;
                    }
                    if (zzb == null) {
                        throw new IllegalStateException("Must set temp dir before writing this object to a parcel");
                    }
                    try {
                        File createTempFile = File.createTempFile("teleporter" + SystemClock.elapsedRealtime(), ".tmp", zzb);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                            ParcelFileDescriptor open = ParcelFileDescriptor.open(createTempFile, 268435456);
                            createTempFile.delete();
                            Pair create = Pair.create(fileOutputStream, open);
                            dataOutputStream = new DataOutputStream(new BufferedOutputStream((OutputStream) create.first));
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                parcelFileDescriptor = (ParcelFileDescriptor) create.second;
                                zze(dataOutputStream);
                            } catch (IOException e3) {
                                e = e3;
                                Log.e("ParcelByteArray", "Could not write into unlinked file. " + e.toString());
                                if (dataOutputStream != null) {
                                    zze(dataOutputStream);
                                }
                                parcelFileDescriptor = null;
                                this.zzb = parcelFileDescriptor;
                                int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                                SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i | 1, false);
                                SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
                                this.zzb = null;
                            } catch (IllegalStateException e4) {
                                e = e4;
                                Log.e("ParcelByteArray", "Could not create unlinked file. " + e.toString());
                            }
                            this.zzb = parcelFileDescriptor;
                        } catch (FileNotFoundException e5) {
                            throw new IllegalStateException("Temporary file is somehow already deleted", e5);
                        }
                    } catch (IOException e6) {
                        throw new IllegalStateException("Could not create temporary file", e6);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
            }
        }
        int beginObjectHeader2 = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader2);
        this.zzb = null;
    }
}
