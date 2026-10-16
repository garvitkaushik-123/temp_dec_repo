package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfcg {
    private zzfcg(long j, int[] iArr) {
    }

    static zzfyq zza(JsonReader jsonReader) throws IOException {
        int[] iArr;
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzfyq zzn = zzfyq.zzn();
            jsonReader.beginObject();
            zzfcg zzfcgVar = null;
            Long l = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (Objects.equals(nextName, "id")) {
                    l = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(nextName, "event_types")) {
                    zzfyn zzfynVar2 = new zzfyn();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzfynVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzn = zzfynVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (l != null && !zzn.isEmpty()) {
                long longValue = l.longValue();
                if (zzn == null) {
                    iArr = new int[0];
                } else {
                    int[] iArr2 = new int[zzn.size()];
                    for (int i2 = 0; i2 < zzn.size(); i2++) {
                        iArr2[i2] = ((Integer) zzn.get(i2)).intValue();
                    }
                    iArr = iArr2;
                }
                zzfcgVar = new zzfcg(longValue, iArr);
            }
            if (zzfcgVar != null) {
                zzfynVar.zzf(zzfcgVar);
            }
        }
        jsonReader.endArray();
        return zzfynVar.zzi();
    }
}
