package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class ResponseInfo {
    private final zzea zza;
    private final List zzb = new ArrayList();
    private AdapterResponseInfo zzc;

    private ResponseInfo(zzea zzeaVar) {
        this.zza = zzeaVar;
        if (zzeaVar != null) {
            try {
                List zzj = zzeaVar.zzj();
                if (zzj != null) {
                    Iterator it = zzj.iterator();
                    while (it.hasNext()) {
                        AdapterResponseInfo zza = AdapterResponseInfo.zza((zzv) it.next());
                        if (zza != null) {
                            this.zzb.add(zza);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzo.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
        zzea zzeaVar2 = this.zza;
        if (zzeaVar2 == null) {
            return;
        }
        try {
            zzv zzf = zzeaVar2.zzf();
            if (zzf != null) {
                this.zzc = AdapterResponseInfo.zza(zzf);
            }
        } catch (RemoteException e2) {
            zzo.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", e2);
        }
    }

    public static ResponseInfo zza(zzea zzeaVar) {
        if (zzeaVar != null) {
            return new ResponseInfo(zzeaVar);
        }
        return null;
    }

    public static ResponseInfo zzb(zzea zzeaVar) {
        return new ResponseInfo(zzeaVar);
    }

    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    public AdapterResponseInfo getLoadedAdapterResponseInfo() {
        return this.zzc;
    }

    public String getMediationAdapterClassName() {
        try {
            zzea zzeaVar = this.zza;
            if (zzeaVar != null) {
                return zzeaVar.zzg();
            }
            return null;
        } catch (RemoteException e) {
            zzo.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public Bundle getResponseExtras() {
        try {
            zzea zzeaVar = this.zza;
            if (zzeaVar != null) {
                return zzeaVar.zze();
            }
        } catch (RemoteException e) {
            zzo.zzh("Could not forward getResponseExtras to ResponseInfo.", e);
        }
        return new Bundle();
    }

    public String getResponseId() {
        try {
            zzea zzeaVar = this.zza;
            if (zzeaVar != null) {
                return zzeaVar.zzi();
            }
            return null;
        } catch (RemoteException e) {
            zzo.zzh("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public String toString() {
        try {
            return zzd().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zzea zzc() {
        return this.zza;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AdapterResponseInfo) it.next()).zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.zzc;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.zzb());
        }
        Bundle responseExtras = getResponseExtras();
        if (responseExtras != null) {
            jSONObject.put("Response Extras", zzbb.zzb().zzn(responseExtras));
        }
        return jSONObject;
    }
}
