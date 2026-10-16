package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaya extends zzayk {
    private List zzh;
    private final Context zzi;

    public zzaya(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context) {
        super(zzawxVar, "G1O+5tqulLBNCxZxcYiJSAGrazgAMWmQ49z8g8PEPhhOgnBizp9p2UWwJMiSx+ju", "xfUFYLaeYlsk7z1gy27YVxCq/UzpfsdVkNtosT4BuNc=", zzastVar, i, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzast zzastVar = this.zzd;
        zzastVar.zzU(-1L);
        zzastVar.zzQ(-1L);
        Context context = this.zzi;
        if (context == null) {
            context = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, context);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzastVar) {
            zzastVar.zzU(((Long) this.zzh.get(0)).longValue());
            zzastVar.zzQ(((Long) this.zzh.get(1)).longValue());
        }
    }
}
