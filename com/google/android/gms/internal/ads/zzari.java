package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzari extends zzaqd {
    private final Object zza;
    private final zzaqi zzb;

    public zzari(int i, String str, zzaqi zzaqiVar, zzaqh zzaqhVar) {
        super(i, str, zzaqhVar);
        this.zza = new Object();
        this.zzb = zzaqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    protected final zzaqj zzh(zzapz zzapzVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapzVar.zzb;
            Map map = zzapzVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] split = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split(C3040d4.i.b, 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapzVar.zzb);
        }
        return zzaqj.zzb(str, zzara.zzb(zzapzVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaqd
    /* renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzaqi zzaqiVar;
        synchronized (this.zza) {
            zzaqiVar = this.zzb;
        }
        zzaqiVar.zza(str);
    }
}
