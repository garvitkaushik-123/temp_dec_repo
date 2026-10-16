package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcct extends zzcbh implements TextureView.SurfaceTextureListener, zzcbr {
    private final zzccb zzc;
    private final zzccc zzd;
    private final zzcca zze;
    private final zzdsj zzf;
    private zzcbg zzg;
    private Surface zzh;
    private zzcbs zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm;
    private zzcbz zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcct(Context context, zzccc zzcccVar, zzccb zzccbVar, boolean z, boolean z2, zzcca zzccaVar, zzdsj zzdsjVar) {
        super(context);
        this.zzm = 1;
        this.zzc = zzccbVar;
        this.zzd = zzcccVar;
        this.zzo = z;
        this.zze = zzccaVar;
        zzcccVar.zza(this);
        this.zzf = zzdsjVar;
    }

    public static /* synthetic */ void zzG(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzi();
        }
    }

    public static /* synthetic */ void zzH(zzcct zzcctVar, int i) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.onWindowVisibilityChanged(i);
        }
    }

    public static /* synthetic */ void zzI(zzcct zzcctVar, String str) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    public static /* synthetic */ void zzJ(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zze();
        }
    }

    public static /* synthetic */ void zzK(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zza();
        }
    }

    public static /* synthetic */ void zzL(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzh();
        }
    }

    public static /* synthetic */ void zzM(zzcct zzcctVar) {
        float zza = zzcctVar.zzb.zza();
        zzcbs zzcbsVar = zzcctVar.zzi;
        if (zzcbsVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcbsVar.zzT(zza, false);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        }
    }

    public static /* synthetic */ void zzN(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzd();
        }
    }

    public static /* synthetic */ void zzO(zzcct zzcctVar, int i, int i2) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzj(i, i2);
        }
    }

    public static /* synthetic */ void zzP(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzf();
        }
    }

    public static /* synthetic */ void zzQ(zzcct zzcctVar, String str) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public static /* synthetic */ void zzS(zzcct zzcctVar) {
        zzcbg zzcbgVar = zzcctVar.zzg;
        if (zzcbgVar != null) {
            zzcbgVar.zzg();
        }
    }

    private static String zzT(String str, Exception exc) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccs
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzP(zzcct.this);
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzq) {
            zzp();
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null && !z) {
            zzcbsVar.zzP(num);
            return;
        }
        if (this.zzj == null || this.zzh == null) {
            return;
        }
        if (z) {
            if (!zzad()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcbsVar.zzU();
                zzY();
            }
        }
        if (this.zzj.startsWith("cache:")) {
            zzcdn zzo = this.zzc.zzo(this.zzj);
            if (zzo instanceof zzcdw) {
                zzcbs zza = ((zzcdw) zzo).zza();
                this.zzi = zza;
                zza.zzP(num);
                if (!this.zzi.zzV()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzo instanceof zzcdt)) {
                    String valueOf = String.valueOf(this.zzj);
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache miss: ".concat(valueOf));
                    return;
                }
                zzcdt zzcdtVar = (zzcdt) zzo;
                String zzF = zzF();
                ByteBuffer zzl = zzcdtVar.zzl();
                boolean zzm = zzcdtVar.zzm();
                String zzk = zzcdtVar.zzk();
                if (zzk == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Stream cache URL is null.");
                    return;
                } else {
                    zzcbs zzE = zzE(num);
                    this.zzi = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzk)}, zzF, zzl, zzm);
                }
            }
        } else {
            this.zzi = zzE(num);
            String zzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzk.length];
            int i5 = 0;
            while (true) {
                String[] strArr = this.zzk;
                if (i5 >= strArr.length) {
                    break;
                }
                uriArr[i5] = Uri.parse(strArr[i5]);
                i5++;
            }
            this.zzi.zzF(uriArr, zzF2);
        }
        this.zzi.zzL(this);
        zzZ(this.zzh, false);
        if (this.zzi.zzV()) {
            int zzt = this.zzi.zzt();
            this.zzm = zzt;
            if (zzt == 3) {
                zzV();
            }
        }
    }

    private final void zzX() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzi != null) {
            zzZ(null, true);
            zzcbs zzcbsVar = this.zzi;
            if (zzcbsVar != null) {
                zzcbsVar.zzL(null);
                this.zzi.zzH();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcbsVar.zzS(surface, z);
        } catch (IOException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        }
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzt != f) {
            this.zzt = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzm != 1;
    }

    private final boolean zzad() {
        zzcbs zzcbsVar = this.zzi;
        return (zzcbsVar == null || !zzcbsVar.zzV() || this.zzl) ? false : true;
    }

    @Override // android.view.TextureView, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzt;
        if (f != 0.0f && this.zzn == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (measuredHeight * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcbz zzcbzVar = this.zzn;
        if (zzcbzVar != null) {
            zzcbzVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzdsj zzdsjVar;
        if (this.zzo) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznF)).booleanValue() && (zzdsjVar = this.zzf) != null) {
                zzdsi zza = zzdsjVar.zza();
                zza.zzb("action", "svp_aepv");
                zza.zzj();
            }
            zzcbz zzcbzVar = new zzcbz(getContext());
            this.zzn = zzcbzVar;
            zzcbzVar.zzd(surfaceTexture, i, i2);
            zzcbz zzcbzVar2 = this.zzn;
            zzcbzVar2.start();
            SurfaceTexture zzb = zzcbzVar2.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzn.zze();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccp
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzL(zzcct.this);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcbz zzcbzVar = this.zzn;
        if (zzcbzVar != null) {
            zzcbzVar.zze();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzX();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccl
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzG(zzcct.this);
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzcbz zzcbzVar = this.zzn;
        if (zzcbzVar != null) {
            zzcbzVar.zzc(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcck
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzO(zzcct.this, i, i2);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzg);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccj
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzH(zzcct.this, i);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzA(int i) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzN(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzB(int i) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzR(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzD(int i, int i2) {
        this.zzr = i;
        this.zzs = i2;
        zzaa();
    }

    final zzcbs zzE(Integer num) {
        zzcca zzccaVar = this.zze;
        zzccb zzccbVar = this.zzc;
        zzceo zzceoVar = new zzceo(zzccbVar.getContext(), zzccaVar, zzccbVar, num);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("ExoPlayerAdapter initialized.");
        return zzceoVar;
    }

    final String zzF() {
        zzccb zzccbVar = this.zzc;
        return com.google.android.gms.ads.internal.zzv.zzr().zzc(zzccbVar.getContext(), zzccbVar.zzm().afmaVersion);
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zza() {
        if (zzac()) {
            return (int) this.zzi.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzb() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            return zzcbsVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzi.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zzd() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final int zze() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzf() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            return zzcbsVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzg() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            return zzcbsVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final long zzh() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            return zzcbsVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzi(final boolean z, final long j) {
        if (this.zzc != null) {
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccm
                @Override // java.lang.Runnable
                public final void run() {
                    zzcct.this.zzc.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzo ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzk(String str, Exception exc) {
        final String zzT = zzT(str, exc);
        String concat = "ExoPlayerAdapter error: ".concat(zzT);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(concat);
        this.zzl = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccq
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzI(zzcct.this, zzT);
            }
        });
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzl(String str, Exception exc) {
        final String zzT = zzT("onLoadException", exc);
        String concat = "ExoPlayerAdapter exception: ".concat(zzT);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj(concat);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccn
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzQ(zzcct.this, zzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzm(int i) {
        if (this.zzm != i) {
            this.zzm = i;
            if (i == 3) {
                zzV();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccr
                @Override // java.lang.Runnable
                public final void run() {
                    zzcct.zzK(zzcct.this);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh, com.google.android.gms.internal.ads.zzcce
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcci
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzM(zzcct.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzi.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcco
                @Override // java.lang.Runnable
                public final void run() {
                    zzcct.zzN(zzcct.this);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzp() {
        if (!zzac()) {
            this.zzq = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzi.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcch
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzJ(zzcct.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzq(int i) {
        if (zzac()) {
            this.zzi.zzI(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzr(zzcbg zzcbgVar) {
        this.zzg = zzcbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzs(String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzt() {
        if (zzad()) {
            this.zzi.zzU();
            zzY();
        }
        zzccc zzcccVar = this.zzd;
        zzcccVar.zze();
        this.zzb.zzc();
        zzcccVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzu(float f, float f2) {
        zzcbz zzcbzVar = this.zzn;
        if (zzcbzVar != null) {
            zzcbzVar.zzf(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccg
            @Override // java.lang.Runnable
            public final void run() {
                zzcct.zzS(zzcct.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final Integer zzw() {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            return zzcbsVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzx(int i) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzJ(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzy(int i) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzK(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzz(int i) {
        zzcbs zzcbsVar = this.zzi;
        if (zzcbsVar != null) {
            zzcbsVar.zzM(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbh
    public final void zzC(String str, String[] strArr, Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzk = new String[]{str};
        } else {
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzj;
        boolean z = this.zze.zzk && str2 != null && !str.equals(str2) && this.zzm == 4;
        this.zzj = str;
        zzW(z, num);
    }
}
