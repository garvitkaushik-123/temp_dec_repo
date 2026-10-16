package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfmw implements zzfmu {
    private final zzfmu zza;

    public zzfmw(zzfmu zzfmuVar) {
        this.zza = zzfmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final JSONObject zza(View view) {
        JSONObject zza = zzfne.zza(0, 0, 0, 0);
        int zzb = zzfnh.zzb();
        int i = zzb - 1;
        if (zzb == 0) {
            throw null;
        }
        try {
            zza.put("noOutputDevice", i == 0);
            return zza;
        } catch (JSONException e) {
            zzfnf.zza("Error with setting output device status", e);
            return zza;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final void zzb(View view, JSONObject jSONObject, zzfmt zzfmtVar, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        zzfmi zza = zzfmi.zza();
        if (zza != null) {
            Collection zzb = zza.zzb();
            int size = zzb.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator it = zzb.iterator();
            while (it.hasNext()) {
                View zzf = ((zzflp) it.next()).zzf();
                if (zzf != null && zzf.isAttachedToWindow() && zzf.isShown()) {
                    View view2 = zzf;
                    while (true) {
                        if (view2 == null) {
                            View rootView = zzf.getRootView();
                            if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                identityHashMap.put(rootView, rootView);
                                float z3 = rootView.getZ();
                                int size2 = arrayList.size();
                                while (size2 > 0) {
                                    int i = size2 - 1;
                                    if (((View) arrayList.get(i)).getZ() <= z3) {
                                        break;
                                    } else {
                                        size2 = i;
                                    }
                                }
                                arrayList.add(size2, rootView);
                            }
                        } else if (view2.getAlpha() != 0.0f) {
                            Object parent = view2.getParent();
                            view2 = parent instanceof View ? (View) parent : null;
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            zzfmtVar.zza((View) arrayList.get(i2), this.zza, jSONObject, z2);
        }
    }
}
