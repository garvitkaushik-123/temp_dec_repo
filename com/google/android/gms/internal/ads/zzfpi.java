package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfpi {
    public static boolean zza(int i) {
        int i2 = i - 1;
        return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int zzb(Context context, zzfoi zzfoiVar) {
        int i;
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (file.exists()) {
            File[] listFiles = file.listFiles(new zzgbh(Pattern.compile(".*\\.so$", 2)));
            if (listFiles != null && listFiles.length != 0) {
                try {
                    fileInputStream = new FileInputStream(listFiles[0]);
                    try {
                        bArr = new byte[20];
                    } finally {
                    }
                } catch (IOException e) {
                    zzd(null, e.toString(), context, zzfoiVar);
                }
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] != 2) {
                        bArr2[0] = bArr[19];
                        bArr2[1] = bArr[18];
                        short s = ByteBuffer.wrap(bArr2).getShort();
                        if (s == 3) {
                            i = 5;
                        } else if (s == 40) {
                            i = 3;
                        } else if (s == 62) {
                            i = 7;
                        } else if (s == 183) {
                            i = 6;
                        } else if (s != 243) {
                            zzd(bArr, null, context, zzfoiVar);
                            i = 1;
                        } else {
                            i = 8;
                        }
                        fileInputStream.close();
                        if (i == 1000) {
                            String zzc = zzc(context, zzfoiVar);
                            if (TextUtils.isEmpty(zzc)) {
                                zzd(null, "Empty dev arch", context, zzfoiVar);
                            } else if (zzc.equalsIgnoreCase("i686") || zzc.equalsIgnoreCase("x86")) {
                                i = 5;
                            } else if (zzc.equalsIgnoreCase("x86_64")) {
                                i = 7;
                            } else if (zzc.equalsIgnoreCase("arm64-v8a")) {
                                i = 6;
                            } else if (zzc.equalsIgnoreCase("armeabi-v7a") || zzc.equalsIgnoreCase("armv71")) {
                                i = 3;
                            } else if (zzc.equalsIgnoreCase("riscv64")) {
                                i = 8;
                            } else {
                                zzd(null, zzc, context, zzfoiVar);
                            }
                            i = 1;
                        }
                        zzfoiVar.zzb(5018, i != 1 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "null" : "RISCV64" : "X86_64" : "ARM64" : "X86" : "ARM7" : "UNSUPPORTED");
                        return i;
                    }
                    zzd(bArr, null, context, zzfoiVar);
                }
                fileInputStream.close();
                i = 1;
                if (i == 1000) {
                }
                zzfoiVar.zzb(5018, i != 1 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "null" : "RISCV64" : "X86_64" : "ARM64" : "X86" : "ARM7" : "UNSUPPORTED");
                return i;
            }
            zzfoiVar.zzb(5017, "No .so");
        } else {
            zzfoiVar.zzb(5017, "No lib/");
        }
        i = 1000;
        if (i == 1000) {
        }
        zzfoiVar.zzb(5018, i != 1 ? i != 3 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "null" : "RISCV64" : "X86_64" : "ARM64" : "X86" : "ARM7" : "UNSUPPORTED");
        return i;
    }

    private static final String zzc(Context context, zzfoi zzfoiVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String zza = zzfwf.OS_ARCH.zza();
        if (!TextUtils.isEmpty(zza) && hashSet.contains(zza)) {
            return zza;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e) {
            zzfoiVar.zzc(2024, 0L, e);
        } catch (NoSuchFieldException e2) {
            zzfoiVar.zzc(2024, 0L, e2);
        }
        return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
    }

    private static final void zzd(byte[] bArr, String str, Context context, zzfoi zzfoiVar) {
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(zzfwf.OS_ARCH.zza());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        zzfoiVar.zzb(4007, sb.toString());
    }
}
