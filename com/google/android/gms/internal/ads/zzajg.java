package com.google.android.gms.internal.ads;

import io.bidmachine.media3.common.MimeTypes;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzajg {
    public static String zza(List list) {
        Iterator it = list.iterator();
        String str = null;
        boolean z = false;
        while (it.hasNext()) {
            String str2 = ((zzajs) it.next()).zza.zzg.zzo;
            if (zzay.zzj(str2)) {
                return "video/mp4";
            }
            if (zzay.zzh(str2)) {
                z = true;
            } else if (zzay.zzi(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, MimeTypes.IMAGE_AVIF)) {
                    str = MimeTypes.IMAGE_AVIF;
                }
            }
        }
        return z ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
