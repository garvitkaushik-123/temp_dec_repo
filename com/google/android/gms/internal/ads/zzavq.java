package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzavq implements zzavp {
    protected static volatile zzawx zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzawp zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzavq(Context context) {
        try {
            zzaus.zze();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdd)).booleanValue()) {
                this.zzr = new zzawp();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzm() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzavo zzavoVar;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        String zzb;
        zzast zzc;
        int i5;
        int i6;
        int i7 = i;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcP)).booleanValue();
        zzast zzastVar = null;
        if (booleanValue) {
            zzavoVar = zza != null ? zza.zzd() : null;
            str2 = "be";
        } else {
            zzavoVar = null;
            str2 = null;
        }
        try {
            if (i7 == 3) {
                zzastVar = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i6 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    if (booleanValue) {
                        if (i7 != i2) {
                        }
                        i3 = i4;
                        zzavoVar.zzc(i3, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (zzastVar != null) {
                    }
                    zzb = Integer.toString(5);
                    return zzb;
                }
            } else {
                if (i7 == 2) {
                    zzc = zzi(context, view, activity);
                    i5 = 1008;
                } else {
                    zzc = zzc(context, null);
                    i5 = 1000;
                }
                zzastVar = zzc;
                i6 = i5;
            }
            if (!booleanValue || zzavoVar == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzavoVar.zzc(i6, -1, System.currentTimeMillis() - currentTimeMillis, str2, null);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (booleanValue && zzavoVar != null) {
                        if (i7 != i2) {
                            i4 = 1003;
                        } else if (i7 == 2) {
                            i4 = 1009;
                        } else {
                            i3 = 1001;
                            i7 = 1;
                            zzavoVar.zzc(i3, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzavoVar.zzc(i3, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
                    }
                    long currentTimeMillis22 = System.currentTimeMillis();
                    if (zzastVar != null) {
                    }
                    zzb = Integer.toString(5);
                    return zzb;
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 3;
        }
        long currentTimeMillis222 = System.currentTimeMillis();
        if (zzastVar != null) {
            try {
            } catch (Exception e4) {
                zzb = Integer.toString(7);
                if (booleanValue && zzavoVar != null) {
                    zzavoVar.zzc(i7 == i2 ? 1007 : i7 == 2 ? 1011 : 1005, -1, System.currentTimeMillis() - currentTimeMillis222, str2, e4);
                }
            }
            if (((zzatq) zzastVar.zzbr()).zzaY() != 0) {
                zzatq zzatqVar = (zzatq) zzastVar.zzbr();
                int i8 = zzaus.zzc;
                zzb = zzaus.zzb(zzatqVar.zzaV(), str);
                if (booleanValue && zzavoVar != null) {
                    zzavoVar.zzc(i7 == i2 ? 1006 : i7 == 2 ? 1010 : 1004, -1, System.currentTimeMillis() - currentTimeMillis222, str2, null);
                }
                return zzb;
            }
        }
        zzb = Integer.toString(5);
        return zzb;
    }

    protected abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzawn;

    protected abstract zzast zzb(Context context, View view, Activity activity);

    protected abstract zzast zzc(Context context, zzasg zzasgVar);

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzd(Context context, String str, View view) {
        return zzp(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zze(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzf(Context context) {
        if (zzaxa.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzp(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzh(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    protected abstract zzast zzi(Context context, View view, Activity activity);

    protected abstract zzawz zzj(MotionEvent motionEvent) throws zzawn;

    @Override // com.google.android.gms.internal.ads.zzavp
    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzm();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    this.zzb = obtain;
                    LinkedList linkedList = this.zzc;
                    linkedList.add(obtain);
                    if (linkedList.size() > 6) {
                        ((MotionEvent) linkedList.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zza(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += motionEvent.getHistorySize() + 1;
                    zzawz zzj = zzj(motionEvent);
                    Long l2 = zzj.zzd;
                    if (l2 != null && zzj.zzg != null) {
                        this.zzi += l2.longValue() + zzj.zzg.longValue();
                    }
                    if (this.zzq != null && (l = zzj.zze) != null && zzj.zzh != null) {
                        this.zzj += l.longValue() + zzj.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzawn unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final synchronized void zzl(int i, int i2, int i3) {
        if (this.zzb != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcN)).booleanValue()) {
                zzm();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            this.zzb = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, i2 * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawp zzawpVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdd)).booleanValue() || (zzawpVar = this.zzr) == null) {
            return;
        }
        zzawpVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public void zzo(View view) {
    }
}
