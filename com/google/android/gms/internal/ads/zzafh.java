package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.ironsource.C3040d4;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzafh {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzav zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String str2 = zzex.zza;
            String[] split = str.split(C3040d4.i.b, 2);
            if (split.length != 2) {
                zzea.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzagt.zzb(new zzen(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzea.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzahq(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzav(arrayList);
    }

    public static zzafe zzc(zzen zzenVar, boolean z, boolean z2) throws zzaz {
        if (z) {
            zzd(3, zzenVar, false);
        }
        String zzB = zzenVar.zzB((int) zzenVar.zzs(), StandardCharsets.UTF_8);
        int length = zzB.length();
        long zzs = zzenVar.zzs();
        String[] strArr = new String[(int) zzs];
        int i = length + 15;
        for (int i2 = 0; i2 < zzs; i2++) {
            String zzB2 = zzenVar.zzB((int) zzenVar.zzs(), StandardCharsets.UTF_8);
            strArr[i2] = zzB2;
            i = i + 4 + zzB2.length();
        }
        if (z2 && (zzenVar.zzm() & 1) == 0) {
            throw zzaz.zza("framing bit expected to be set", null);
        }
        return new zzafe(zzB, strArr, i + 1);
    }

    public static boolean zzd(int i, zzen zzenVar, boolean z) throws zzaz {
        if (zzenVar.zza() < 7) {
            if (z) {
                return false;
            }
            throw zzaz.zza("too short header: " + zzenVar.zza(), null);
        }
        if (zzenVar.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzaz.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), null);
        }
        if (zzenVar.zzm() == 118 && zzenVar.zzm() == 111 && zzenVar.zzm() == 114 && zzenVar.zzm() == 98 && zzenVar.zzm() == 105 && zzenVar.zzm() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw zzaz.zza("expected characters 'vorbis'", null);
    }
}
