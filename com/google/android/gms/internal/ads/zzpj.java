package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzpj {
    static final zzfyt zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpj zza = new zzpj(zzfyq.zzo(zzpi.zza));
    private static final zzfyq zzc = zzfyq.zzq(2, 5, 6);

    static {
        zzfys zzfysVar = new zzfys();
        zzfysVar.zza(5, 6);
        zzfysVar.zza(17, 6);
        zzfysVar.zza(7, 6);
        zzfysVar.zza(30, 10);
        zzfysVar.zza(18, 6);
        zzfysVar.zza(6, 8);
        zzfysVar.zza(8, 8);
        zzfysVar.zza(14, 8);
        zzb = zzfysVar.zzc();
    }

    private zzpj(List list) {
        for (int i = 0; i < list.size(); i++) {
            zzpi zzpiVar = (zzpi) list.get(i);
            this.zzd.put(zzpiVar.zzb, zzpiVar);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzd.size(); i3++) {
            i2 = Math.max(i2, ((zzpi) this.zzd.valueAt(i3)).zzc);
        }
        this.zze = i2;
    }

    static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    static zzpj zzc(Context context, zze zzeVar, zzpp zzppVar) {
        return zzd(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzeVar, zzppVar);
    }

    static zzpj zzd(Context context, Intent intent, zze zzeVar, zzpp zzppVar) {
        AudioManager zzc2 = zzcj.zzc(context);
        if (zzppVar == null) {
            zzpp zzppVar2 = null;
            if (Build.VERSION.SDK_INT >= 33) {
                List<AudioDeviceInfo> audioDevicesForAttributes = zzc2.getAudioDevicesForAttributes(zzeVar.zza().zza);
                if (!audioDevicesForAttributes.isEmpty()) {
                    zzppVar2 = new zzpp(audioDevicesForAttributes.get(0));
                }
            }
            zzppVar = zzppVar2;
        }
        if (Build.VERSION.SDK_INT >= 33 && (zzex.zzN(context) || zzex.zzJ(context))) {
            List<AudioProfile> directProfilesForAttributes = zzc2.getDirectProfilesForAttributes(zzeVar.zza().zza);
            HashMap hashMap = new HashMap();
            hashMap.put(2, new HashSet(zzgbt.zzh(12)));
            for (int i = 0; i < directProfilesForAttributes.size(); i++) {
                AudioProfile audioProfile = directProfilesForAttributes.get(i);
                if (audioProfile.getEncapsulationType() != 1) {
                    int format = audioProfile.getFormat();
                    if (zzex.zzK(format) || zzb.containsKey(Integer.valueOf(format))) {
                        Integer valueOf = Integer.valueOf(format);
                        if (hashMap.containsKey(valueOf)) {
                            Set set = (Set) hashMap.get(valueOf);
                            set.getClass();
                            set.addAll(zzgbt.zzh(audioProfile.getChannelMasks()));
                        } else {
                            hashMap.put(valueOf, new HashSet(zzgbt.zzh(audioProfile.getChannelMasks())));
                        }
                    }
                }
            }
            int i2 = zzfyq.zzd;
            zzfyn zzfynVar = new zzfyn();
            for (Map.Entry entry : hashMap.entrySet()) {
                zzfynVar.zzf(new zzpi(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
            }
            return new zzpj(zzfynVar.zzi());
        }
        AudioDeviceInfo[] devices = zzppVar == null ? zzc2.getDevices(2) : new AudioDeviceInfo[]{zzppVar.zza};
        zzfyu zzfyuVar = new zzfyu();
        zzfyuVar.zzg(8, 7);
        if (Build.VERSION.SDK_INT >= 31) {
            zzfyuVar.zzg(26, 27);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            zzfyuVar.zzf((Object) 30);
        }
        zzfyv zzi = zzfyuVar.zzi();
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (zzi.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                return zza;
            }
        }
        zzfyu zzfyuVar2 = new zzfyu();
        zzfyuVar2.zzf((Object) 2);
        if (Build.VERSION.SDK_INT >= 29 && (zzex.zzN(context) || zzex.zzJ(context))) {
            int i3 = zzfyq.zzd;
            zzfyn zzfynVar2 = new zzfyn();
            zzgaw it = zzb.keySet().iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (Build.VERSION.SDK_INT >= zzex.zzh(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zzeVar.zza().zza)) {
                    zzfynVar2.zzf(Integer.valueOf(intValue));
                }
            }
            zzfynVar2.zzf((Object) 2);
            zzfyuVar2.zzh(zzfynVar2.zzi());
            return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzfyuVar2.zzh(zzc);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzfyuVar2.zzh(zzgbt.zzh(intArrayExtra));
        }
        return new zzpj(zze(zzgbt.zzi(zzfyuVar2.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    private static zzfyq zze(int[] iArr, int i) {
        int i2 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        for (int i3 : iArr) {
            zzfynVar.zzf(new zzpi(i3, i));
        }
        return zzfynVar.zzi();
    }

    private static boolean zzf() {
        return Build.MANUFACTURER.equals("Amazon") || Build.MANUFACTURER.equals("Xiaomi");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if (r1.contentEquals(r3) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpj)) {
            return false;
        }
        zzpj zzpjVar = (zzpj) obj;
        SparseArray sparseArray = this.zzd;
        SparseArray<?> sparseArray2 = zzpjVar.zzd;
        String str = zzex.zza;
        if (Build.VERSION.SDK_INT < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i = 0; i < size; i++) {
                    if (!Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                        break;
                    }
                }
                if (this.zze == zzpjVar.zze) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        String str = zzex.zza;
        int i2 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzd;
        if (i2 >= 31) {
            i = sparseArray.contentHashCode();
        } else {
            int i3 = 17;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                i3 = (((i3 * 31) + sparseArray.keyAt(i4)) * 31) + Objects.hashCode(sparseArray.valueAt(i4));
            }
            i = i3;
        }
        return this.zze + (i * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + this.zzd.toString() + C3040d4.i.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        if (r7 != 5) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0047, code lost:
    
        if (com.google.android.gms.internal.ads.zzex.zzH(r9.zzd, 30) == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair zzb(zzz zzzVar, zze zzeVar) {
        SparseArray sparseArray;
        int zzi;
        String str = zzzVar.zzo;
        str.getClass();
        int zza2 = zzay.zza(str, zzzVar.zzk);
        if (!zzb.containsKey(Integer.valueOf(zza2))) {
            return null;
        }
        int i = 6;
        if (zza2 == 18) {
            if (zzex.zzH(this.zzd, 18)) {
                zza2 = 18;
            } else {
                zza2 = 6;
                sparseArray = this.zzd;
                if (!zzex.zzH(sparseArray, zza2)) {
                    return null;
                }
                zzpi zzpiVar = (zzpi) sparseArray.get(zza2);
                zzpiVar.getClass();
                int i2 = zzzVar.zzG;
                if (i2 == -1 || zza2 == 18) {
                    int i3 = zzzVar.zzH;
                    if (i3 == -1) {
                        i3 = 48000;
                    }
                    i2 = zzpiVar.zza(i3, zzeVar);
                } else if (!str.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
                    if (!zzpiVar.zzb(i2)) {
                        return null;
                    }
                } else if (i2 > 10) {
                    return null;
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    if (i2 == 7) {
                        i = 8;
                    } else if (i2 != 3) {
                        if (i2 != 4) {
                        }
                    }
                    zzi = zzex.zzi(i);
                    if (zzi == 0) {
                        return Pair.create(Integer.valueOf(zza2), Integer.valueOf(zzi));
                    }
                    return null;
                }
                i = i2;
                zzi = zzex.zzi(i);
                if (zzi == 0) {
                }
            }
        }
        if (zza2 == 8) {
            if (zzex.zzH(this.zzd, 8)) {
                zza2 = 8;
            }
            zza2 = 7;
            sparseArray = this.zzd;
            if (!zzex.zzH(sparseArray, zza2)) {
            }
        }
        if (zza2 == 30) {
        }
        sparseArray = this.zzd;
        if (!zzex.zzH(sparseArray, zza2)) {
        }
    }
}
