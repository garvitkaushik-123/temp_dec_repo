package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzakm implements zzakr {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final int zza(zzz zzzVar) {
        char c;
        String str = zzzVar.zzo;
        if (str != null) {
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1248334819:
                    if (str.equals("application/pgs")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1157994102:
                    if (str.equals("application/vobsub")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 1;
                case 4:
                case 5:
                case 6:
                case 7:
                    return 2;
                case '\b':
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final zzakt zzb(zzz zzzVar) {
        char c;
        String str = zzzVar.zzo;
        if (str != null) {
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1248334819:
                    if (str.equals("application/pgs")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1157994102:
                    if (str.equals("application/vobsub")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return new zzalj(zzzVar.zzr);
                case 1:
                    return new zzamm();
                case 2:
                    return new zzamb();
                case 3:
                    return new zzaln();
                case 4:
                    return new zzaly(zzzVar.zzr);
                case 5:
                    return new zzalh();
                case 6:
                    return new zzama(zzzVar.zzr);
                case 7:
                    return new zzalf(zzzVar.zzr);
                case '\b':
                    return new zzalt();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final boolean zzc(zzz zzzVar) {
        String str = zzzVar.zzo;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }
}
