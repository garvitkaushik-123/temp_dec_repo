package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdb implements zzbkf {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                i = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i + ".");
        }
        return i;
    }

    private static void zzc(zzcbp zzcbpVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcbpVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                String format = String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(format);
                return;
            }
        }
        if (str2 != null) {
            zzcbpVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcbpVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcbpVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcbpVar.zzD(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int min;
        int min2;
        zzccb zzccbVar = (zzccb) obj;
        String str = (String) map.get("action");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from video GMSG.");
            return;
        }
        Integer num = null;
        Integer valueOf = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer zzb = zzccbVar.zzn() != null ? zzccbVar.zzn().zzb() : null;
        if (valueOf != null && zzb != null && !valueOf.equals(zzb) && !str.equals("load")) {
            String format = String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", valueOf, zzb);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(format);
            return;
        }
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zze("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if (str.equals("background")) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzccbVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if (str.equals("playerBackground")) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzccbVar.zzB(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        int i3 = 0;
        if (str.equals("decoderProps")) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("No MIME types specified for decoder properties inspection.");
                HashMap hashMap = new HashMap();
                hashMap.put("event", "decoderProps");
                hashMap.put("error", "missingMimeTypes");
                zzccbVar.zzd("onVideoEvent", hashMap);
                return;
            }
            HashMap hashMap2 = new HashMap();
            String[] split = str4.split(",");
            int length = split.length;
            while (i3 < length) {
                String str5 = split[i3];
                hashMap2.put(str5, com.google.android.gms.ads.internal.util.zzcj.zza(str5.trim()));
                i3++;
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event", "decoderProps");
            hashMap3.put("mimeTypes", hashMap2);
            zzccbVar.zzd("onVideoEvent", hashMap3);
            return;
        }
        zzcbq zzn = zzccbVar.zzn();
        if (zzn == null) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = str.equals("new");
        boolean equals2 = str.equals(C3040d4.h.L);
        if (equals || equals2) {
            Context context = zzccbVar.getContext();
            int zzb2 = zzb(context, map, VastAttributes.HORIZONTAL_POSITION, 0);
            int zzb3 = zzb(context, map, VastAttributes.VERTICAL_POSITION, 0);
            int zzb4 = zzb(context, map, "w", -1);
            zzbcv zzbcvVar = zzbde.zzeg;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                min = zzb4 == -1 ? zzccbVar.zzh() : Math.min(zzb4, zzccbVar.zzh());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate width with original width " + zzb4 + ", videoHost.getVideoBoundingWidth() " + zzccbVar.zzh() + ", x " + zzb2 + ".");
                }
                min = Math.min(zzb4, zzccbVar.zzh() - zzb2);
            }
            int i4 = min;
            int zzb5 = zzb(context, map, "h", -1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                min2 = zzb5 == -1 ? zzccbVar.zzg() : Math.min(zzb5, zzccbVar.zzg());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate height with original height " + zzb5 + ", videoHost.getVideoBoundingHeight() " + zzccbVar.zzg() + ", y " + zzb3 + ".");
                }
                min2 = Math.min(zzb5, zzccbVar.zzg() - zzb3);
            }
            int i5 = min2;
            try {
                i3 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
            }
            int i6 = i3;
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (!equals || zzn.zza() != null) {
                zzn.zzc(zzb2, zzb3, i4, i5);
                return;
            }
            zzn.zzd(zzb2, zzb3, i4, i5, i6, parseBoolean, new zzcca((String) map.get("flags")));
            zzcbp zza = zzn.zza();
            if (zza != null) {
                zzc(zza, map);
                return;
            }
            return;
        }
        zzcgi zzq = zzccbVar.zzq();
        if (zzq != null) {
            if (str.equals("timeupdate")) {
                String str6 = (String) map.get("currentTime");
                if (str6 == null) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzq.zzt(Float.parseFloat(str6));
                    return;
                } catch (NumberFormatException unused4) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if (str.equals("skip")) {
                zzq.zzu();
                return;
            }
        }
        zzcbp zza2 = zzn.zza();
        if (zza2 == null) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("event", "no_video_view");
            zzccbVar.zzd("onVideoEvent", hashMap4);
            return;
        }
        if (str.equals("click")) {
            Context context2 = zzccbVar.getContext();
            int zzb6 = zzb(context2, map, VastAttributes.HORIZONTAL_POSITION, 0);
            float zzb7 = zzb(context2, map, VastAttributes.VERTICAL_POSITION, 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zzb6, zzb7, 0);
            zza2.zzx(obtain);
            obtain.recycle();
            return;
        }
        if (str.equals("currentTime")) {
            String str7 = (String) map.get("time");
            if (str7 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zza2.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                return;
            } catch (NumberFormatException unused5) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if (str.equals("hide")) {
            zza2.setVisibility(4);
            return;
        }
        if (str.equals("remove")) {
            zza2.setVisibility(8);
            return;
        }
        if (str.equals("load")) {
            zza2.zzr(valueOf);
            return;
        }
        if (str.equals("loadControl")) {
            zzc(zza2, map);
            return;
        }
        if (str.equals("muted")) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zza2.zzs();
                return;
            } else {
                zza2.zzI();
                return;
            }
        }
        if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
            zza2.zzu();
            return;
        }
        if (str.equals("play")) {
            zza2.zzv();
            return;
        }
        if (str.equals(C3207n2.v)) {
            zza2.setVisibility(0);
            return;
        }
        if (!str.equals("src")) {
            if (str.equals("touchMove")) {
                Context context3 = zzccbVar.getContext();
                zza2.zzH(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
                if (this.zza) {
                    return;
                }
                zzccbVar.zzdi();
                this.zza = true;
                return;
            }
            if (!str.equals("volume")) {
                if (str.equals(MBridgeConstans.EXTRA_KEY_WM)) {
                    zza2.zzp();
                    return;
                } else {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unknown video action: ".concat(str));
                    return;
                }
            }
            String str8 = (String) map.get("volume");
            if (str8 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zza2.zzG(Float.parseFloat(str8));
                return;
            } catch (NumberFormatException unused6) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str8));
                return;
            }
        }
        String str9 = (String) map.get("src");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcn)).booleanValue() && TextUtils.isEmpty(str9)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Src parameter missing from src video GMSG.");
            return;
        }
        if (map.containsKey("periodicReportIntervalMs")) {
            try {
                num = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
            } catch (NumberFormatException unused7) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
            }
        }
        String[] strArr = {str9};
        String str10 = (String) map.get("demuxed");
        if (str10 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str10);
                ArrayList arrayList = new ArrayList();
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    String string = jSONArray.getString(i7);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcn)).booleanValue() || !TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcn)).booleanValue() && arrayList.isEmpty()) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("All demuxed URLs are empty for playback: " + str10);
                    return;
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (JSONException unused8) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Malformed demuxed URL list for playback: ".concat(str10));
                strArr = new String[]{str9};
            }
        }
        if (num != null) {
            zzccbVar.zzA(num.intValue());
        }
        zza2.zzE(str9, strArr);
    }
}
