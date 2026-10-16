package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.wrappers.Wrappers;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdus {
    private final Context zza;
    private final ApplicationInfo zzb;
    private String zze = "";
    private final int zzc = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjC)).intValue();
    private final int zzd = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjD)).intValue();

    public zzdus(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
    }

    public final JSONObject zza() throws JSONException {
        String str;
        String encodeToString;
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.zza;
            String str2 = this.zzb.packageName;
            zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
            jSONObject.put("name", Wrappers.packageManager(context).getApplicationLabel(str2));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME, this.zzb.packageName);
        com.google.android.gms.ads.internal.zzv.zzr();
        Drawable drawable = null;
        try {
            str = com.google.android.gms.ads.internal.util.zzs.zzq(this.zza);
        } catch (RemoteException unused2) {
            str = null;
        }
        jSONObject.put("adMobAppId", str);
        if (this.zze.isEmpty()) {
            try {
                drawable = Wrappers.packageManager(this.zza).getApplicationLabelAndIcon(this.zzb.packageName).second;
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (drawable == null) {
                encodeToString = "";
            } else {
                int i = this.zzc;
                int i2 = this.zzd;
                drawable.setBounds(0, 0, i, i2);
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = encodeToString;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
