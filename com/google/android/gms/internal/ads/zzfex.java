package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfex {
    private final HashMap zza = new HashMap();

    public final zzfew zza(zzfen zzfenVar, Context context, zzfef zzfefVar, zzffd zzffdVar) {
        HashMap hashMap = this.zza;
        zzfew zzfewVar = (zzfew) hashMap.get(zzfenVar);
        if (zzfewVar != null) {
            return zzfewVar;
        }
        zzfek zzfekVar = new zzfek(zzfeq.zza(zzfenVar, context));
        zzfew zzfewVar2 = new zzfew(zzfekVar, new zzfff(zzfekVar, zzfefVar, zzffdVar));
        hashMap.put(zzfenVar, zzfewVar2);
        return zzfewVar2;
    }
}
