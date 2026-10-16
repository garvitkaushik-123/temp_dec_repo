package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public final class zzcp {
    public static zzcn zza(Context context, String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int length = split.length;
        if (length == 1) {
            String valueOf = String.valueOf(context.getPackageName());
            str3 = split[0];
            str2 = valueOf.concat("_preferences");
        } else {
            if (length != 2) {
                return null;
            }
            str2 = split[0];
            str3 = split[1];
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        return new zzcn(str2, str3);
    }

    public static void zzb(Context context, Set set) {
        SharedPreferences.Editor zzf;
        zzco zzcoVar = new zzco(context);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzcn zza = zza(context, str);
            if (zza == null) {
                Log.d("UserMessagingPlatform", "clearKeys: unable to process key: ".concat(String.valueOf(str)));
            } else {
                zzf = zzcoVar.zzf(zza.zza);
                zzf.remove(zza.zzb);
            }
        }
        zzcoVar.zzc();
    }
}
