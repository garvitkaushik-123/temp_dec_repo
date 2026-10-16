package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfpt implements zzfol {
    private final Object zza;
    private final zzfpu zzb;
    private final zzfqf zzc;
    private final zzfoi zzd;

    zzfpt(Object obj, zzfpu zzfpuVar, zzfqf zzfqfVar, zzfoi zzfoiVar, boolean z) {
        this.zza = obj;
        this.zzb = zzfpuVar;
        this.zzc = zzfqfVar;
        this.zzd = zzfoiVar;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzaug zza = zzauh.zza();
        zza.zzc(5);
        zza.zza(zzgxz.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzauh) zza.zzbr()).zzaV(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map zza;
        zza = this.zzc.zza();
        zza.put(InneractiveMediationDefs.GENDER_FEMALE, "c");
        zza.put("ctx", context);
        zza.put("cs", str2);
        zza.put(C3114ha.b, null);
        zza.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
        zza.put("act", activity);
        return zzi(zzj(null, zza));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map zzc;
        zzc = this.zzc.zzc();
        zzc.put(InneractiveMediationDefs.GENDER_FEMALE, "v");
        zzc.put("ctx", context);
        zzc.put(C3114ha.b, null);
        zzc.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
        zzc.put("act", activity);
        return zzi(zzj(null, zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized String zzc(Context context, String str) {
        Map zzb;
        zzb = this.zzc.zzb();
        zzb.put(InneractiveMediationDefs.GENDER_FEMALE, CampaignEx.JSON_KEY_AD_Q);
        zzb.put("ctx", context);
        zzb.put(C3114ha.b, null);
        return zzi(zzj(null, zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfol
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfqd {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put(C3114ha.b, null);
            hashMap.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, hashMap);
            this.zzd.zzd(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfqd(2005, e);
        }
    }

    public final synchronized int zze() throws zzfqd {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfqd(2006, e);
        }
        return ((Integer) obj.getClass().getDeclaredMethod(CampaignEx.KEY_LOCAL_CHECK_STATE, new Class[0]).invoke(obj, new Object[0])).intValue();
    }

    final zzfpu zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfqd {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", new Class[0]).invoke(obj, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzfqd(2003, e);
        }
    }

    final synchronized boolean zzh() throws zzfqd {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfqd(2001, e);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod(C3040d4.a.f, new Class[0]).invoke(obj, new Object[0])).booleanValue();
    }
}
