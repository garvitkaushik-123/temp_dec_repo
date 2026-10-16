package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbsr extends zzbsu {
    private final Map zza;
    private final Context zzb;

    public zzbsr(zzcfg zzcfgVar, Map map) {
        super(zzcfgVar, "storePicture");
        this.zza = map;
        this.zzb = zzcfgVar.zzi();
    }

    public final void zzb() {
        Context context = this.zzb;
        if (context == null) {
            zzh("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        if (!new zzbcm(context).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzv.zzr();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources zze = com.google.android.gms.ads.internal.zzv.zzp().zze();
        com.google.android.gms.ads.internal.zzv.zzr();
        AlertDialog.Builder zzL = com.google.android.gms.ads.internal.util.zzs.zzL(context);
        zzL.setTitle(zze != null ? zze.getString(R.string.s1) : "Save image");
        zzL.setMessage(zze != null ? zze.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        zzL.setPositiveButton(zze != null ? zze.getString(R.string.s3) : HttpHeaders.ACCEPT, new zzbsp(this, str, lastPathSegment));
        zzL.setNegativeButton(zze != null ? zze.getString(R.string.s4) : "Decline", new zzbsq(this));
        zzL.create().show();
    }
}
