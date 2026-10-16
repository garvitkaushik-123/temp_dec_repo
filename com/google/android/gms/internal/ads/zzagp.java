package com.google.android.gms.internal.ads;

import androidx.compose.material3.TextFieldImplKt;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagp {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        r7 = -9223372036854775807L;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzagl zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.next();
            if (!zzey.zzc(newPullParser, "x:xmpmeta")) {
                throw zzaz.zza("Couldn't find xmp metadata", null);
            }
            zzfyq zzn = zzfyq.zzn();
            long j2 = -9223372036854775807L;
            do {
                newPullParser.next();
                if (zzey.zzc(newPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String zza2 = zzey.zza(newPullParser, strArr[i2]);
                        if (zza2 != null) {
                            if (Integer.parseInt(zza2) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= 4) {
                                    break;
                                }
                                String zza3 = zzey.zza(newPullParser, strArr2[i3]);
                                if (zza3 != null) {
                                    j = Long.parseLong(zza3);
                                    if (j == -1) {
                                    }
                                } else {
                                    i3++;
                                }
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzn = zzfyq.zzn();
                                    break;
                                }
                                String zza4 = zzey.zza(newPullParser, strArr3[i]);
                                if (zza4 != null) {
                                    zzn = zzfyq.zzp(new zzagk("image/jpeg", "Primary", 0L, 0L), new zzagk("video/mp4", "MotionPhoto", Long.parseLong(zza4), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzey.zzc(newPullParser, "Container:Directory")) {
                    zzn = zzb(newPullParser, TextFieldImplKt.ContainerId, "Item");
                } else if (zzey.zzc(newPullParser, "GContainer:Directory")) {
                    zzn = zzb(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzey.zzb(newPullParser, "x:xmpmeta"));
            if (zzn.isEmpty()) {
                return null;
            }
            return new zzagl(j2, zzn);
        } catch (zzaz | NumberFormatException | XmlPullParserException unused) {
            zzea.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzfyq zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        do {
            String concat = str.concat(":Item");
            xmlPullParser.next();
            if (zzey.zzc(xmlPullParser, concat)) {
                String concat2 = str2.concat(":Mime");
                String concat3 = str2.concat(":Semantic");
                String concat4 = str2.concat(":Length");
                String concat5 = str2.concat(":Padding");
                String zza2 = zzey.zza(xmlPullParser, concat2);
                String zza3 = zzey.zza(xmlPullParser, concat3);
                String zza4 = zzey.zza(xmlPullParser, concat4);
                String zza5 = zzey.zza(xmlPullParser, concat5);
                if (zza2 == null || zza3 == null) {
                    return zzfyq.zzn();
                }
                zzfynVar.zzf(new zzagk(zza2, zza3, zza4 != null ? Long.parseLong(zza4) : 0L, zza5 != null ? Long.parseLong(zza5) : 0L));
            }
        } while (!zzey.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfynVar.zzi();
    }
}
