package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.mediationsdk.IronSourceSegment;

/* loaded from: classes4.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1452a = z.a("nam");
    public static final int b = z.a("trk");
    public static final int c = z.a("cmt");
    public static final int d = z.a("day");
    public static final int e = z.a("ART");
    public static final int f = z.a("too");
    public static final int g = z.a("alb");
    public static final int h = z.a("com");
    public static final int i = z.a("wrt");
    public static final int j = z.a("lyr");
    public static final int k = z.a(IronSourceSegment.GENDER);
    public static final int l = z.a("covr");
    public static final int m = z.a("gnre");
    public static final int n = z.a("grp");
    public static final int o = z.a("disk");
    public static final int p = z.a("trkn");
    public static final int q = z.a("tmpo");
    public static final int r = z.a("cpil");
    public static final int s = z.a("aART");
    public static final int t = z.a("sonm");
    public static final int u = z.a("soal");
    public static final int v = z.a("soar");
    public static final int w = z.a("soaa");
    public static final int x = z.a("soco");
    public static final int y = z.a("rtng");
    public static final int z = z.a("pgap");
    public static final int A = z.a("sosn");
    public static final int B = z.a("tvsh");
    public static final int C = z.a("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o a(int i2, String str, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, boolean z2, boolean z3) {
        int i3;
        nVar.e(nVar.b + 4);
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            i3 = nVar.j();
        } else {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
            i3 = -1;
        }
        if (z3) {
            i3 = Math.min(1, i3);
        }
        if (i3 >= 0) {
            return z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, Integer.toString(i3)) : new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", str, Integer.toString(i3));
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j b(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int i5 = nVar.b;
            if (i5 >= i2) {
                break;
            }
            int b2 = nVar.b();
            int b3 = nVar.b();
            nVar.e(nVar.b + 4);
            if (b3 == c.D0) {
                str = nVar.a(b2 - 12);
            } else if (b3 == c.E0) {
                str2 = nVar.a(b2 - 12);
            } else {
                if (b3 == c.F0) {
                    i3 = i5;
                    i4 = b2;
                }
                nVar.e(nVar.b + (b2 - 12));
            }
        }
        if (!"com.apple.iTunes".equals(str) || !"iTunSMPB".equals(str2) || i3 == -1) {
            return null;
        }
        nVar.e(i3);
        nVar.e(nVar.b + 16);
        return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", str2, nVar.a(i4 - 16));
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j a(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int b2 = nVar.b();
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            String a2 = nVar.a(b2 - 16);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j("und", a2, a2);
        }
        Log.w("MetadataUtil", "Failed to parse comment attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s b(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        int b2 = nVar.b();
        if (nVar.b() == c.F0) {
            nVar.e(nVar.b + 8);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, nVar.a(b2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s a(int i2, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        int b2 = nVar.b();
        if (nVar.b() == c.F0 && b2 >= 22) {
            nVar.e(nVar.b + 10);
            int o2 = nVar.o();
            if (o2 > 0) {
                String a2 = com.fyber.inneractive.sdk.player.exoplayer2.m.a("", o2);
                int o3 = nVar.o();
                if (o3 > 0) {
                    a2 = a2 + RemoteSettings.FORWARD_SLASH_STRING + o3;
                }
                return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s(str, null, a2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: " + c.a(i2));
        return null;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        int b2 = nVar.b();
        if (nVar.b() == c.F0) {
            int b3 = nVar.b() & ViewCompat.MEASURED_SIZE_MASK;
            if (b3 == 13) {
                str = "image/jpeg";
            } else {
                str = b3 == 14 ? "image/png" : null;
            }
            if (str == null) {
                Log.w("MetadataUtil", "Unrecognized cover art flags: " + b3);
                return null;
            }
            nVar.e(nVar.b + 4);
            int i2 = b2 - 16;
            byte[] bArr = new byte[i2];
            nVar.a(bArr, 0, i2);
            return new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }
}
