package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxl extends zzayk {
    private static final zzayl zzh = new zzayl();
    private final zzasp zzi;
    private final Context zzj;
    private final zzaup zzk;

    public zzaxl(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context, zzasg zzasgVar, zzasp zzaspVar, zzaup zzaupVar) {
        super(zzawxVar, "5l2BxulTXy+0Wovy9T0xreNvMgccuxz9Mfzqj2nIzDWreku9cf/hyHYbFP2gke7n", "rfz55QLsxMWzB2XqDjYWCElC2tXCWyMh5Hq3cP2KfWk=", zzastVar, i, 27);
        this.zzj = context;
        this.zzi = zzaspVar;
        this.zzk = zzaupVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzaum zzc() throws IllegalAccessException, InvocationTargetException {
        int zza;
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcW)).booleanValue()) {
            zza = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdb)).intValue();
        } else {
            zza = this.zzi.zza();
        }
        zzaum zzaumVar = new zzaum((String) this.zze.invoke(null, this.zzj, false, ""));
        zzaup zzaupVar = this.zzk;
        if (zzaupVar != null && zzaupVar.zza() != null) {
            try {
                str = (String) zzaupVar.zza().get(zza, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            }
            zzaumVar.zza = str;
            return zzaumVar;
        }
        str = ExifInterface.LONGITUDE_EAST;
        zzaumVar.zza = str;
        return zzaumVar;
    }

    private final String zzd() {
        try {
            zzawx zzawxVar = this.zza;
            if (zzawxVar.zzk() != null) {
                zzawxVar.zzk().get();
            }
            zzatq zzc = zzawxVar.zzc();
            if (zzc == null || !zzc.zzaf()) {
                return null;
            }
            return zzc.zzg();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i;
        zzaum zzaumVar;
        zzaum zzaumVar2;
        zzayl zzaylVar = zzh;
        Context context = this.zzj;
        AtomicReference zza = zzaylVar.zza(context.getPackageName());
        synchronized (zza) {
            zzaum zzaumVar3 = (zzaum) zza.get();
            if (zzaumVar3 == null || zzaxa.zzd(zzaumVar3.zza) || zzaumVar3.zza.equals(ExifInterface.LONGITUDE_EAST) || zzaumVar3.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (zzaxa.zzd(null)) {
                    (!zzaxa.zzd(null) ? false : false).booleanValue();
                    i = 3;
                } else {
                    i = 5;
                }
                if (this.zzk != null) {
                    zzaumVar = zzc();
                } else {
                    if (i == 3 && !this.zzi.zzd()) {
                        z = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcK);
                    String zzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcJ)).booleanValue() ? zzb() : null;
                    if (bool.booleanValue() && this.zza.zzo() && zzaxa.zzd(zzb)) {
                        zzb = zzd();
                    }
                    zzaum zzaumVar4 = new zzaum((String) this.zze.invoke(null, context, valueOf, zzb));
                    if (zzaxa.zzd(zzaumVar4.zza) || zzaumVar4.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                        int i2 = i - 1;
                        if (i2 == 3) {
                            String zzd = zzd();
                            if (!zzaxa.zzd(zzd)) {
                                zzaumVar4.zza = zzd;
                            }
                        } else if (i2 == 4) {
                            throw null;
                        }
                    }
                    zzaumVar = zzaumVar4;
                }
                zza.set(zzaumVar);
            }
            zzaumVar2 = (zzaum) zza.get();
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            if (zzaumVar2 != null) {
                zzastVar.zzv(zzaumVar2.zza);
                zzastVar.zzV(zzaumVar2.zzb);
                zzastVar.zzX(zzaumVar2.zzc);
                zzastVar.zzi(zzaumVar2.zzd);
                zzastVar.zzu(zzaumVar2.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            byte[] zzf = zzaxa.zzf((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcL));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals(AnalyticsConstants.SOURCE_USER_TYPE)) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzaxa.zzf((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcM)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zza.zzj();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            final zzgeh zze = zzgeh.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaym
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgeh zzgehVar = zzgeh.this;
                    if (list == null) {
                        zzgehVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                            if (apkChecksum.getType() == 8) {
                                zzgehVar.zzc(zzaxa.zzb(apkChecksum.getValue()));
                                return;
                            }
                        }
                        zzgehVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgehVar.zzc(null);
                    }
                }
            });
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
