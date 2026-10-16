package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.a0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.c0;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class g implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f1427a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    public static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern t = Pattern.compile("AUTOSELECT".concat("=(NO|YES)"));
    public static final Pattern u = Pattern.compile("DEFAULT".concat("=(NO|YES)"));
    public static final Pattern v = Pattern.compile("FORCED".concat("=(NO|YES)"));

    public static d b(f fVar, String str) {
        String str2;
        long j2;
        int i2;
        f fVar2 = fVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str3 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        long j3 = -9223372036854775807L;
        c cVar = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = -1;
        int i6 = 1;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        boolean z3 = false;
        long j9 = -9223372036854775807L;
        while (fVar2.a()) {
            if (fVar2.a()) {
                str2 = fVar2.c;
                fVar2.c = str3;
            } else {
                str2 = str3;
            }
            if (str2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String b2 = b(str2, g);
                if ("VOD".equals(b2)) {
                    fVar2 = fVar;
                    str3 = null;
                    i3 = 1;
                } else if ("EVENT".equals(b2)) {
                    fVar2 = fVar;
                    str3 = null;
                    i3 = 2;
                } else {
                    j2 = j9;
                }
            } else {
                if (str2.startsWith("#EXT-X-START")) {
                    j9 = (long) (Double.parseDouble(b(str2, j)) * 1000000.0d);
                } else {
                    if (str2.startsWith("#EXT-X-MAP")) {
                        String b3 = b(str2, n);
                        String a2 = a(str2, l);
                        if (a2 != null) {
                            String[] split = a2.split("@");
                            j8 = Long.parseLong(split[0]);
                            if (split.length > 1) {
                                j5 = Long.parseLong(split[1]);
                            }
                        }
                        c cVar2 = new c(b3, 0L, -1, -9223372036854775807L, false, null, null, j5, j8);
                        fVar2 = fVar;
                        j5 = 0;
                        j8 = -1;
                        cVar = cVar2;
                    } else if (str2.startsWith("#EXT-X-TARGETDURATION")) {
                        j3 = 1000000 * Integer.parseInt(b(str2, e));
                    } else if (str2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        i4 = Integer.parseInt(b(str2, h));
                        fVar2 = fVar;
                        i8 = i4;
                    } else if (str2.startsWith("#EXT-X-VERSION")) {
                        i6 = Integer.parseInt(b(str2, f));
                    } else if (str2.startsWith("#EXTINF")) {
                        fVar2 = fVar;
                        j6 = (long) (Double.parseDouble(b(str2, i)) * 1000000.0d);
                    } else if (str2.startsWith("#EXT-X-KEY")) {
                        z = "AES-128".equals(b(str2, m));
                        if (z) {
                            str4 = b(str2, n);
                            str5 = a(str2, o);
                        } else {
                            fVar2 = fVar;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                        }
                    } else if (str2.startsWith("#EXT-X-BYTERANGE")) {
                        String[] split2 = b(str2, k).split("@");
                        j8 = Long.parseLong(split2[0]);
                        if (split2.length > 1) {
                            j5 = Long.parseLong(split2[1]);
                        }
                    } else if (str2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                        i7 = Integer.parseInt(str2.substring(str2.indexOf(58) + 1));
                        z2 = true;
                    } else if (str2.equals("#EXT-X-DISCONTINUITY")) {
                        i5++;
                    } else if (str2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                        if (j4 == 0) {
                            String substring = str2.substring(str2.indexOf(58) + 1);
                            Matcher matcher = z.f.matcher(substring);
                            if (!matcher.matches()) {
                                throw new r("Invalid date/time format: " + substring);
                            }
                            if (matcher.group(9) == null || matcher.group(9).equalsIgnoreCase("Z")) {
                                i2 = 0;
                            } else {
                                i2 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
                                if (matcher.group(11).equals("-")) {
                                    i2 *= -1;
                                }
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                            gregorianCalendar.clear();
                            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                            if (TextUtils.isEmpty(matcher.group(8))) {
                                j2 = j9;
                            } else {
                                j2 = j9;
                                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                            }
                            long timeInMillis = gregorianCalendar.getTimeInMillis();
                            if (i2 != 0) {
                                timeInMillis -= i2 * 60000;
                            }
                            int i9 = com.fyber.inneractive.sdk.player.exoplayer2.b.f1396a;
                            j4 = (timeInMillis == -9223372036854775807L ? -9223372036854775807L : timeInMillis * 1000) - j7;
                        }
                        j2 = j9;
                    } else {
                        j2 = j9;
                        if (str2.startsWith("#EXT-X-DATERANGE")) {
                            arrayList2.add(str2);
                        } else if (!str2.startsWith("#")) {
                            String hexString = !z ? null : str5 != null ? str5 : Integer.toHexString(i4);
                            int i10 = i4 + 1;
                            long j10 = j8 == -1 ? 0L : j5;
                            arrayList.add(new c(str2, j6, i5, j7, z, str4, hexString, j10, j8));
                            j7 += j6;
                            if (j8 != -1) {
                                j10 += j8;
                            }
                            j5 = j10;
                            i4 = i10;
                            j6 = 0;
                            j8 = -1;
                            j9 = j2;
                            str3 = null;
                            fVar2 = fVar;
                        } else if (str2.equals("#EXT-X-ENDLIST")) {
                            fVar2 = fVar;
                            z3 = true;
                            j9 = j2;
                        }
                    }
                    str3 = null;
                }
                fVar2 = fVar;
                str3 = null;
            }
            fVar2 = fVar;
            j9 = j2;
            str3 = null;
        }
        return new d(i3, str, j9, j4, z2, i7, i8, i6, j3, z3, j4 != 0, cVar, arrayList, arrayList2);
    }

    public final e a(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) {
        String trim;
        e a2;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jVar));
        LinkedList linkedList = new LinkedList();
        try {
            int read = bufferedReader.read();
            if (read == 239) {
                if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                    read = bufferedReader.read();
                }
                throw new a0("Input does not start with the #EXTM3U header.");
            }
            while (read != -1 && Character.isWhitespace(read)) {
                read = bufferedReader.read();
            }
            int i2 = 0;
            while (true) {
                if (i2 >= 7) {
                    while (read != -1 && Character.isWhitespace(read)) {
                        int i3 = z.f1599a;
                        if (read == 10 || read == 13) {
                            break;
                        }
                        read = bufferedReader.read();
                    }
                    int i4 = z.f1599a;
                    if (read != 10) {
                        if (read == 13) {
                        }
                    }
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            z.a(bufferedReader);
                            throw new r("Failed to parse the playlist, could not identify any tags.");
                        }
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                }
                                linkedList.add(trim);
                            } else {
                                linkedList.add(trim);
                                a2 = a(new f(linkedList, bufferedReader), uri.toString());
                                break;
                            }
                        }
                    }
                    linkedList.add(trim);
                    a2 = b(new f(linkedList, bufferedReader), uri.toString());
                    return a2;
                }
                if (read != "#EXTM3U".charAt(i2)) {
                    break;
                }
                read = bufferedReader.read();
                i2++;
            }
        } finally {
            z.a(bufferedReader);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0234 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(f fVar, String str) {
        String str2;
        int i2;
        String a2;
        String b2;
        String a3;
        int parseInt;
        String str3;
        int i3;
        int i4;
        String str4;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        o oVar = null;
        List list = null;
        boolean z = false;
        while (fVar.a()) {
            if (fVar.a()) {
                str2 = fVar.c;
                fVar.c = null;
            } else {
                str2 = null;
            }
            if (str2.startsWith("#EXT-X-MEDIA")) {
                Matcher matcher = u.matcher(str2);
                boolean equals = matcher.find() ? matcher.group(1).equals("YES") : 0;
                Matcher matcher2 = v.matcher(str2);
                int i5 = equals | (matcher2.find() ? matcher2.group(1).equals("YES") : false ? 2 : 0);
                Matcher matcher3 = t.matcher(str2);
                i2 = i5 | (matcher3.find() ? matcher3.group(1).equals("YES") : false ? 4 : 0);
                a2 = a(str2, n);
                b2 = b(str2, r);
                a3 = a(str2, q);
                String b3 = b(str2, p);
                b3.getClass();
                b3.hashCode();
                switch (b3) {
                    case "SUBTITLES":
                        arrayList3.add(new a(a2, new o(b2, "application/x-mpegURL", "text/vtt", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, a3, -1, Long.MAX_VALUE, null, null, null)));
                        break;
                    case "CLOSED-CAPTIONS":
                        String b4 = b(str2, s);
                        if (b4.startsWith("CC")) {
                            parseInt = Integer.parseInt(b4.substring(2));
                            str3 = "application/cea-608";
                        } else {
                            parseInt = Integer.parseInt(b4.substring(7));
                            str3 = "application/cea-708";
                        }
                        int i6 = parseInt;
                        String str5 = str3;
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(new o(b2, null, str5, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, a3, i6, Long.MAX_VALUE, null, null, null));
                        break;
                    case "AUDIO":
                        o oVar2 = new o(b2, "application/x-mpegURL", null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, a3, -1, Long.MAX_VALUE, null, null, null);
                        if (a2 != null) {
                            arrayList2.add(new a(a2, oVar2));
                            break;
                        } else {
                            oVar = oVar2;
                            break;
                        }
                }
            } else if (str2.startsWith("#EXT-X-STREAM-INF")) {
                int parseInt2 = Integer.parseInt(b(str2, b));
                String a4 = a(str2, f1427a);
                if (a4 != null) {
                    parseInt2 = Integer.parseInt(a4);
                }
                int i7 = parseInt2;
                String a5 = a(str2, c);
                String a6 = a(str2, d);
                z |= str2.contains("CLOSED-CAPTIONS=NONE");
                if (a6 != null) {
                    String[] split = a6.split(VastAttributes.HORIZONTAL_POSITION);
                    int parseInt3 = Integer.parseInt(split[0]);
                    int parseInt4 = Integer.parseInt(split[1]);
                    if (parseInt3 > 0 && parseInt4 > 0) {
                        i4 = parseInt4;
                        i3 = parseInt3;
                        if (fVar.a()) {
                            str4 = null;
                        } else {
                            str4 = fVar.c;
                            fVar.c = null;
                        }
                        if (!hashSet.add(str4)) {
                            arrayList.add(new a(str4, new o(Integer.toString(arrayList.size()), "application/x-mpegURL", null, a5, i7, -1, i3, i4, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null)));
                        }
                    }
                }
                i3 = -1;
                i4 = -1;
                if (fVar.a()) {
                }
                if (!hashSet.add(str4)) {
                }
            }
        }
        if (z) {
            list = Collections.emptyList();
        }
        return new b(str, arrayList, arrayList2, arrayList3, oVar, list);
    }

    public static String b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new r("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
