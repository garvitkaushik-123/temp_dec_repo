package com.google.android.gms.internal.ads;

import android.net.Uri;
import io.bidmachine.media3.common.MimeTypes;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzadq implements zzaea {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzadp zzc = new zzadp(new zzado() { // from class: com.google.android.gms.internal.ads.zzadm
        @Override // com.google.android.gms.internal.ads.zzado
        public final Constructor zza() {
            int i = zzadq.zza;
            if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzadv.class).getConstructor(Integer.TYPE);
            }
            return null;
        }
    });
    private static final zzadp zzd = new zzadp(new zzado() { // from class: com.google.android.gms.internal.ads.zzadn
        @Override // com.google.android.gms.internal.ads.zzado
        public final Constructor zza() {
            int i = zzadq.zza;
            return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(zzadv.class).getConstructor(new Class[0]);
        }
    });
    private zzfyq zze;
    private final zzakr zzf = new zzakm();

    /* JADX WARN: Removed duplicated region for block: B:14:0x01fb A[Catch: all -> 0x03e5, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:14:0x01fb, B:15:0x01fe, B:20:0x03c3, B:21:0x03c6, B:23:0x03cb, B:26:0x03d1, B:28:0x03d4, B:32:0x03d7, B:37:0x0207, B:39:0x020f, B:42:0x0219, B:45:0x0225, B:47:0x022d, B:50:0x0237, B:53:0x0242, B:56:0x024d, B:59:0x0258, B:61:0x0260, B:63:0x0268, B:66:0x0272, B:68:0x0280, B:71:0x028a, B:74:0x0295, B:76:0x029d, B:78:0x02ab, B:80:0x02b9, B:83:0x02c9, B:85:0x02d7, B:88:0x02e1, B:90:0x02e9, B:92:0x02f1, B:94:0x02f9, B:97:0x0303, B:99:0x030b, B:102:0x031b, B:104:0x0323, B:107:0x032d, B:109:0x0335, B:112:0x033f, B:114:0x0347, B:117:0x0350, B:120:0x035c, B:123:0x0368, B:126:0x0374, B:128:0x037c, B:131:0x0385, B:133:0x038d, B:136:0x0396, B:152:0x0048, B:153:0x0050, B:156:0x01c1, B:179:0x0055, B:182:0x0061, B:185:0x006c, B:188:0x0078, B:191:0x0084, B:194:0x008f, B:197:0x009b, B:200:0x00a6, B:203:0x00b2, B:206:0x00be, B:209:0x00c9, B:212:0x00d5, B:215:0x00e0, B:218:0x00eb, B:221:0x00f6, B:224:0x0102, B:227:0x010d, B:230:0x0119, B:233:0x0125, B:236:0x0131, B:239:0x013d, B:242:0x0149, B:245:0x0155, B:248:0x0161, B:251:0x016c, B:254:0x0177, B:257:0x0182, B:260:0x018d, B:263:0x0198, B:266:0x01a2, B:269:0x01ac, B:272:0x01b6), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0048 A[Catch: all -> 0x03e5, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:14:0x01fb, B:15:0x01fe, B:20:0x03c3, B:21:0x03c6, B:23:0x03cb, B:26:0x03d1, B:28:0x03d4, B:32:0x03d7, B:37:0x0207, B:39:0x020f, B:42:0x0219, B:45:0x0225, B:47:0x022d, B:50:0x0237, B:53:0x0242, B:56:0x024d, B:59:0x0258, B:61:0x0260, B:63:0x0268, B:66:0x0272, B:68:0x0280, B:71:0x028a, B:74:0x0295, B:76:0x029d, B:78:0x02ab, B:80:0x02b9, B:83:0x02c9, B:85:0x02d7, B:88:0x02e1, B:90:0x02e9, B:92:0x02f1, B:94:0x02f9, B:97:0x0303, B:99:0x030b, B:102:0x031b, B:104:0x0323, B:107:0x032d, B:109:0x0335, B:112:0x033f, B:114:0x0347, B:117:0x0350, B:120:0x035c, B:123:0x0368, B:126:0x0374, B:128:0x037c, B:131:0x0385, B:133:0x038d, B:136:0x0396, B:152:0x0048, B:153:0x0050, B:156:0x01c1, B:179:0x0055, B:182:0x0061, B:185:0x006c, B:188:0x0078, B:191:0x0084, B:194:0x008f, B:197:0x009b, B:200:0x00a6, B:203:0x00b2, B:206:0x00be, B:209:0x00c9, B:212:0x00d5, B:215:0x00e0, B:218:0x00eb, B:221:0x00f6, B:224:0x0102, B:227:0x010d, B:230:0x0119, B:233:0x0125, B:236:0x0131, B:239:0x013d, B:242:0x0149, B:245:0x0155, B:248:0x0161, B:251:0x016c, B:254:0x0177, B:257:0x0182, B:260:0x018d, B:263:0x0198, B:266:0x01a2, B:269:0x01ac, B:272:0x01b6), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x03c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x03cb A[Catch: all -> 0x03e5, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:14:0x01fb, B:15:0x01fe, B:20:0x03c3, B:21:0x03c6, B:23:0x03cb, B:26:0x03d1, B:28:0x03d4, B:32:0x03d7, B:37:0x0207, B:39:0x020f, B:42:0x0219, B:45:0x0225, B:47:0x022d, B:50:0x0237, B:53:0x0242, B:56:0x024d, B:59:0x0258, B:61:0x0260, B:63:0x0268, B:66:0x0272, B:68:0x0280, B:71:0x028a, B:74:0x0295, B:76:0x029d, B:78:0x02ab, B:80:0x02b9, B:83:0x02c9, B:85:0x02d7, B:88:0x02e1, B:90:0x02e9, B:92:0x02f1, B:94:0x02f9, B:97:0x0303, B:99:0x030b, B:102:0x031b, B:104:0x0323, B:107:0x032d, B:109:0x0335, B:112:0x033f, B:114:0x0347, B:117:0x0350, B:120:0x035c, B:123:0x0368, B:126:0x0374, B:128:0x037c, B:131:0x0385, B:133:0x038d, B:136:0x0396, B:152:0x0048, B:153:0x0050, B:156:0x01c1, B:179:0x0055, B:182:0x0061, B:185:0x006c, B:188:0x0078, B:191:0x0084, B:194:0x008f, B:197:0x009b, B:200:0x00a6, B:203:0x00b2, B:206:0x00be, B:209:0x00c9, B:212:0x00d5, B:215:0x00e0, B:218:0x00eb, B:221:0x00f6, B:224:0x0102, B:227:0x010d, B:230:0x0119, B:233:0x0125, B:236:0x0131, B:239:0x013d, B:242:0x0149, B:245:0x0155, B:248:0x0161, B:251:0x016c, B:254:0x0177, B:257:0x0182, B:260:0x018d, B:263:0x0198, B:266:0x01a2, B:269:0x01ac, B:272:0x01b6), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0207 A[Catch: all -> 0x03e5, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:14:0x01fb, B:15:0x01fe, B:20:0x03c3, B:21:0x03c6, B:23:0x03cb, B:26:0x03d1, B:28:0x03d4, B:32:0x03d7, B:37:0x0207, B:39:0x020f, B:42:0x0219, B:45:0x0225, B:47:0x022d, B:50:0x0237, B:53:0x0242, B:56:0x024d, B:59:0x0258, B:61:0x0260, B:63:0x0268, B:66:0x0272, B:68:0x0280, B:71:0x028a, B:74:0x0295, B:76:0x029d, B:78:0x02ab, B:80:0x02b9, B:83:0x02c9, B:85:0x02d7, B:88:0x02e1, B:90:0x02e9, B:92:0x02f1, B:94:0x02f9, B:97:0x0303, B:99:0x030b, B:102:0x031b, B:104:0x0323, B:107:0x032d, B:109:0x0335, B:112:0x033f, B:114:0x0347, B:117:0x0350, B:120:0x035c, B:123:0x0368, B:126:0x0374, B:128:0x037c, B:131:0x0385, B:133:0x038d, B:136:0x0396, B:152:0x0048, B:153:0x0050, B:156:0x01c1, B:179:0x0055, B:182:0x0061, B:185:0x006c, B:188:0x0078, B:191:0x0084, B:194:0x008f, B:197:0x009b, B:200:0x00a6, B:203:0x00b2, B:206:0x00be, B:209:0x00c9, B:212:0x00d5, B:215:0x00e0, B:218:0x00eb, B:221:0x00f6, B:224:0x0102, B:227:0x010d, B:230:0x0119, B:233:0x0125, B:236:0x0131, B:239:0x013d, B:242:0x0149, B:245:0x0155, B:248:0x0161, B:251:0x016c, B:254:0x0177, B:257:0x0182, B:260:0x018d, B:263:0x0198, B:266:0x01a2, B:269:0x01ac, B:272:0x01b6), top: B:3:0x0003 }] */
    @Override // com.google.android.gms.internal.ads.zzaea
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized zzadv[] zza(Uri uri, Map map) {
        ArrayList arrayList;
        String str;
        char c;
        int i;
        String lastPathSegment;
        int i2;
        int i3;
        arrayList = new ArrayList(21);
        List list = (List) map.get("Content-Type");
        if (list != null && !list.isEmpty()) {
            str = (String) list.get(0);
            if (str != null) {
                String zze = zzay.zze(str);
                switch (zze.hashCode()) {
                    case -2123537834:
                        if (zze.equals("audio/eac3-joc")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1662384011:
                        if (zze.equals("video/mp2p")) {
                            c = 20;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1662384007:
                        if (zze.equals("video/mp2t")) {
                            c = 21;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1662095187:
                        if (zze.equals("video/webm")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1606874997:
                        if (zze.equals("audio/amr-wb")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487656890:
                        if (zze.equals(MimeTypes.IMAGE_AVIF)) {
                            c = 31;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487464693:
                        if (zze.equals("image/heic")) {
                            c = 30;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487464690:
                        if (zze.equals("image/heif")) {
                            c = 29;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487394660:
                        if (zze.equals("image/jpeg")) {
                            c = 24;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1487018032:
                        if (zze.equals("image/webp")) {
                            c = 27;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1248337486:
                        if (zze.equals("application/mp4")) {
                            c = 18;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1079884372:
                        if (zze.equals("video/x-msvideo")) {
                            c = 25;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1004728940:
                        if (zze.equals("text/vtt")) {
                            c = 23;
                            break;
                        }
                        c = 65535;
                        break;
                    case -879272239:
                        if (zze.equals(MimeTypes.IMAGE_BMP)) {
                            c = 28;
                            break;
                        }
                        c = 65535;
                        break;
                    case -879258763:
                        if (zze.equals("image/png")) {
                            c = 26;
                            break;
                        }
                        c = 65535;
                        break;
                    case -387023398:
                        if (zze.equals("audio/x-matroska")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case -43467528:
                        if (zze.equals("application/webm")) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case 13915911:
                        if (zze.equals("video/x-flv")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 187078296:
                        if (zze.equals("audio/ac3")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 187078297:
                        if (zze.equals("audio/ac4")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 187078669:
                        if (zze.equals("audio/amr")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 187090232:
                        if (zze.equals("audio/mp4")) {
                            c = 17;
                            break;
                        }
                        c = 65535;
                        break;
                    case 187091926:
                        if (zze.equals("audio/ogg")) {
                            c = 19;
                            break;
                        }
                        c = 65535;
                        break;
                    case 187099443:
                        if (zze.equals("audio/wav")) {
                            c = 22;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1331848029:
                        if (zze.equals("video/mp4")) {
                            c = 16;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1503095341:
                        if (zze.equals("audio/3gpp")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1504578661:
                        if (zze.equals("audio/eac3")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1504619009:
                        if (zze.equals("audio/flac")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1504824762:
                        if (zze.equals("audio/midi")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1504831518:
                        if (zze.equals("audio/mpeg")) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1505118770:
                        if (zze.equals("audio/webm")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2039520277:
                        if (zze.equals("video/x-matroska")) {
                            c = '\n';
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
                    case 2:
                        i = 0;
                        break;
                    case 3:
                        i = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        i = 3;
                        break;
                    case 7:
                        i = 4;
                        break;
                    case '\b':
                        i = 5;
                        break;
                    case '\t':
                        i = 15;
                        break;
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                        i = 6;
                        break;
                    case 15:
                        i = 7;
                        break;
                    case 16:
                    case 17:
                    case 18:
                        i = 8;
                        break;
                    case 19:
                        i = 9;
                        break;
                    case 20:
                        i = 10;
                        break;
                    case 21:
                        i = 11;
                        break;
                    case 22:
                        i = 12;
                        break;
                    case 23:
                        i = 13;
                        break;
                    case 24:
                        i = 14;
                        break;
                    case 25:
                        i = 16;
                        break;
                    case 26:
                        i = 17;
                        break;
                    case 27:
                        i = 18;
                        break;
                    case 28:
                        i = 19;
                        break;
                    case 29:
                    case 30:
                        i = 20;
                        break;
                    case 31:
                        i = 21;
                        break;
                }
                if (i != -1) {
                    zzb(i, arrayList);
                }
                lastPathSegment = uri.getLastPathSegment();
                if (lastPathSegment != null) {
                    if (!lastPathSegment.endsWith(".ac3") && !lastPathSegment.endsWith(".ec3")) {
                        if (lastPathSegment.endsWith(".ac4")) {
                            i2 = 1;
                        } else {
                            if (!lastPathSegment.endsWith(".adts") && !lastPathSegment.endsWith(".aac")) {
                                if (lastPathSegment.endsWith(".amr")) {
                                    i2 = 3;
                                } else if (lastPathSegment.endsWith(".flac")) {
                                    i2 = 4;
                                } else if (lastPathSegment.endsWith(".flv")) {
                                    i2 = 5;
                                } else {
                                    if (!lastPathSegment.endsWith(".mid") && !lastPathSegment.endsWith(".midi") && !lastPathSegment.endsWith(".smf")) {
                                        if (!lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) && !lastPathSegment.endsWith(".webm")) {
                                            if (lastPathSegment.endsWith(".mp3")) {
                                                i2 = 7;
                                            } else {
                                                if (!lastPathSegment.endsWith(".mp4") && !lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) && !lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) && !lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
                                                    if (!lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) && !lastPathSegment.endsWith(".opus")) {
                                                        if (!lastPathSegment.endsWith(".ps") && !lastPathSegment.endsWith(".mpeg") && !lastPathSegment.endsWith(".mpg") && !lastPathSegment.endsWith(".m2p")) {
                                                            if (!lastPathSegment.endsWith(".ts") && !lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
                                                                if (!lastPathSegment.endsWith(".wav") && !lastPathSegment.endsWith(".wave")) {
                                                                    if (!lastPathSegment.endsWith(".vtt") && !lastPathSegment.endsWith(".webvtt")) {
                                                                        if (!lastPathSegment.endsWith(".jpg") && !lastPathSegment.endsWith(".jpeg")) {
                                                                            if (lastPathSegment.endsWith(".avi")) {
                                                                                i2 = 16;
                                                                            } else if (lastPathSegment.endsWith(".png")) {
                                                                                i2 = 17;
                                                                            } else if (lastPathSegment.endsWith(".webp")) {
                                                                                i2 = 18;
                                                                            } else {
                                                                                if (!lastPathSegment.endsWith(".bmp") && !lastPathSegment.endsWith(".dib")) {
                                                                                    if (!lastPathSegment.endsWith(".heic") && !lastPathSegment.endsWith(".heif")) {
                                                                                        if (lastPathSegment.endsWith(".avif")) {
                                                                                            i2 = 21;
                                                                                        }
                                                                                    }
                                                                                    i2 = 20;
                                                                                }
                                                                                i2 = 19;
                                                                            }
                                                                        }
                                                                        i2 = 14;
                                                                    }
                                                                    i2 = 13;
                                                                }
                                                                i2 = 12;
                                                            }
                                                            i2 = 11;
                                                        }
                                                        i2 = 10;
                                                    }
                                                    i2 = 9;
                                                }
                                                i2 = 8;
                                            }
                                        }
                                        i2 = 6;
                                    }
                                    i2 = 15;
                                }
                            }
                            i2 = 2;
                        }
                        if (i2 != -1 && i2 != i) {
                            zzb(i2, arrayList);
                        }
                        int[] iArr = zzb;
                        for (i3 = 0; i3 < 21; i3++) {
                            int i4 = iArr[i3];
                            if (i4 != i && i4 != i2) {
                                zzb(i4, arrayList);
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 != -1) {
                        zzb(i2, arrayList);
                    }
                    int[] iArr2 = zzb;
                    while (i3 < 21) {
                    }
                }
                i2 = -1;
                if (i2 != -1) {
                }
                int[] iArr22 = zzb;
                while (i3 < 21) {
                }
            }
            i = -1;
            if (i != -1) {
            }
            lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
            }
            i2 = -1;
            if (i2 != -1) {
            }
            int[] iArr222 = zzb;
            while (i3 < 21) {
            }
        }
        str = null;
        if (str != null) {
        }
        i = -1;
        if (i != -1) {
        }
        lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null) {
        }
        i2 = -1;
        if (i2 != -1) {
        }
        int[] iArr2222 = zzb;
        while (i3 < 21) {
        }
        return (zzadv[]) arrayList.toArray(new zzadv[arrayList.size()]);
    }

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzamq());
                break;
            case 1:
                list.add(new zzams());
                break;
            case 2:
                list.add(new zzamu(0));
                break;
            case 3:
                list.add(new zzafi(0));
                break;
            case 4:
                zzadv zza2 = zzc.zza(0);
                if (zza2 == null) {
                    list.add(new zzaga(0));
                    break;
                } else {
                    list.add(zza2);
                    break;
                }
            case 5:
                list.add(new zzagc());
                break;
            case 6:
                list.add(new zzahy(this.zzf, 0));
                break;
            case 7:
                list.add(new zzaie(0));
                break;
            case 8:
                zzakr zzakrVar = this.zzf;
                list.add(new zzajd(zzakrVar, 0, null, null, zzfyq.zzn(), null));
                list.add(new zzajj(zzakrVar, 0));
                break;
            case 9:
                list.add(new zzajz());
                break;
            case 10:
                list.add(new zzanz());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzfyq.zzn();
                }
                list.add(new zzaoj(1, 0, this.zzf, new zzeu(0L), new zzamw(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzaov());
                break;
            case 14:
                list.add(new zzagi(0));
                break;
            case 15:
                zzadv zza3 = zzd.zza(new Object[0]);
                if (zza3 != null) {
                    list.add(zza3);
                    break;
                }
                break;
            case 16:
                list.add(new zzafn(0, this.zzf));
                break;
            case 17:
                list.add(new zzakk());
                break;
            case 18:
                list.add(new zzapa());
                break;
            case 19:
                list.add(new zzafv());
                break;
            case 20:
                list.add(new zzagh());
                break;
            case 21:
                list.add(new zzafu());
                break;
        }
    }
}
