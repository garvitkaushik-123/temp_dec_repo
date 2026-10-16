package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import com.facebook.ads.androidx.media3.extractor.mp4.Mp4Extractor;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.m3, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2241m3 implements H9, HY {
    public static byte[] A0Q;
    public static String[] A0R = {"uzhMW", "LbToze1ZyMStOzMPMggUyU89k761Fydj", "roznHbdGo", "zeOiwqyw9G80TO", "hwgMtT9WWej", "AZ5CtgA3jsgDmrh", "c4g75mNjYzBkznfgxB8HcDFPfSogi", "Prtl1ARtkjOsoD"};
    public static final HD A0S;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0A;
    public long A0B;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0C;
    public C07364v A0D;
    public HA A0E;
    public MotionPhotoMetadata A0F;
    public JE[] A0G;
    public long[][] A0H;
    public final int A0I;
    public final C07364v A0J;
    public final C07364v A0K;
    public final C07364v A0L;
    public final C07364v A0M;
    public final JL A0N;
    public final ArrayDeque<C2252mE> A0O;
    public final List<Metadata.Entry> A0P;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private int A03(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        int i;
        long A8n = interfaceC2280ms.A8n();
        if (this.A08 == -1) {
            this.A08 = A01(A8n);
            if (this.A08 == -1) {
                return -1;
            }
        }
        JE je = this.A0G[this.A08];
        InterfaceC1036Hd interfaceC1036Hd = je.A01;
        int i2 = je.A00;
        long j = je.A04.A06[i2];
        int i3 = je.A04.A05[i2];
        C1037He c1037He = je.A02;
        long j2 = (j - A8n) + this.A05;
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            hv.A00 = j;
            return 1;
        }
        int i4 = je.A03.A02;
        if (A0R[2].length() != 19) {
            A0R[6] = "rX6gisAdcV7LBeXwmOhQV8Eb98OXk";
            if (i4 == 1) {
                j2 += 8;
                if (A0R[6].length() == 29) {
                    String[] strArr = A0R;
                    strArr[3] = "KKgaKTwS1RwNPE";
                    strArr[7] = "5hDvshmtbzc6vz";
                    i3 -= 8;
                }
            }
            interfaceC2280ms.AK3((int) j2);
            if (je.A03.A01 != 0) {
                byte[] A0l = this.A0K.A0l();
                A0l[0] = 0;
                A0l[1] = 0;
                A0l[2] = 0;
                int i5 = je.A03.A01;
                int i6 = 4 - je.A03.A01;
                while (this.A06 < i3) {
                    if (this.A07 == 0) {
                        interfaceC2280ms.readFully(A0l, i6, i5);
                        this.A05 += i5;
                        this.A0K.A0f(0);
                        int A0C = this.A0K.A0C();
                        if (A0C < 0) {
                            throw C3K.A01(A09(48, 18, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), null);
                        }
                        this.A07 = A0C;
                        this.A0L.A0f(0);
                        interfaceC1036Hd.AIr(this.A0L, 4);
                        this.A06 += 4;
                        i3 += i6;
                    } else {
                        int AIp = interfaceC1036Hd.AIp(interfaceC2280ms, this.A07, false);
                        this.A05 += AIp;
                        this.A06 += AIp;
                        this.A07 -= AIp;
                    }
                }
            } else {
                if (A09(66, 9, 68).equals(je.A03.A07.A0W)) {
                    if (this.A06 == 0) {
                        AbstractC1027Gu.A07(i3, this.A0M);
                        interfaceC1036Hd.AIr(this.A0M, 7);
                        this.A06 += 7;
                    }
                    i3 += 7;
                } else if (c1037He != null) {
                    c1037He.A03(interfaceC2280ms);
                }
                while (this.A06 < i3) {
                    int AIp2 = interfaceC1036Hd.AIp(interfaceC2280ms, i3 - this.A06, false);
                    this.A05 += AIp2;
                    this.A06 += AIp2;
                    this.A07 -= AIp2;
                }
            }
            long j3 = je.A04.A07[i2];
            int i7 = je.A04.A04[i2];
            if (A0R[4].length() == 11) {
                String[] strArr2 = A0R;
                strArr2[5] = "dniiMzQMBKOANx9";
                strArr2[0] = "Fj7cY";
                if (c1037He != null) {
                    i = 0;
                    c1037He.A04(interfaceC1036Hd, j3, i7, i3, 0, null);
                    if (i2 + 1 == je.A04.A01) {
                        c1037He.A05(interfaceC1036Hd, null);
                    }
                } else {
                    i = 0;
                    interfaceC1036Hd.AIu(j3, i7, i3, 0, null);
                }
                je.A00++;
                this.A08 = -1;
                this.A05 = i;
                this.A06 = i;
                this.A07 = i;
                return i;
            }
        }
        throw new RuntimeException();
    }

    public static String A09(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 83);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0Q = new byte[]{-47, 4, -1, -3, -80, 3, -7, 10, -11, -80, -4, -11, 3, 3, -80, 4, -8, -15, -2, -80, -8, -11, -15, -12, -11, 2, -80, -4, -11, -2, -9, 4, -8, -80, -72, 5, -2, 3, 5, 0, 0, -1, 2, 4, -11, -12, -71, -66, Ascii.DC2, 55, 63, 42, 53, 50, 45, -23, Ascii.ETB, 10, Ascii.NAK, -23, 53, 46, 55, 48, Base64.padSymbol, 49, -8, Ascii.FF, -5, 0, 6, -58, -8, -6, -53, 49, 69, 52, 57, 63, -1, 68, 66, 69, 53, -3, 56, 52};
    }

    static {
        A0C();
        A0S = new HD() { // from class: com.facebook.ads.redexgen.X.m4
            @Override // com.instagram.common.viewpoint.core.HD
            public final H9[] A5N() {
                return C2241m3.A0M();
            }

            @Override // com.instagram.common.viewpoint.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public C2241m3() {
        this(0);
    }

    public C2241m3(int i) {
        this.A0I = i;
        this.A04 = (i & 4) != 0 ? 3 : 0;
        this.A0N = new JL();
        this.A0P = new ArrayList();
        this.A0J = new C07364v(16);
        this.A0O = new ArrayDeque<>();
        this.A0L = new C07364v(HS.A03);
        this.A0K = new C07364v(4);
        this.A0M = new C07364v();
        this.A08 = -1;
        this.A0E = HA.A00;
        this.A0G = new JE[0];
    }

    public static int A00(int i) {
        switch (i) {
            case 1751476579:
                return 2;
            case 1903435808:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[1] = "rbgKKZbH0NS3XFJda55b1nN6iCZjcLPR";
                return 1;
            default:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[4] = "05jGjYjRxbz";
                return 0;
        }
    }

    private int A01(long j) {
        long j2 = Long.MAX_VALUE;
        int preferredTrackIndex = 1;
        int i = -1;
        long sampleOffset = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        int i2 = 1;
        int trackIndex = -1;
        int i3 = 0;
        while (true) {
            JE[] jeArr = this.A0G;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0R[6] = "Fcko3uaud46cO6nUcug7HhLZFNYBY";
            if (i3 >= jeArr.length) {
                if (j3 == Long.MAX_VALUE || i2 == 0) {
                    return i;
                }
                long j4 = 10485760 + j3;
                if (A0R[1].charAt(1) == 'b') {
                    A0R[1] = "AbIM1W3wiFJMRqsWOI3P0CqvLybO2M00";
                    if (sampleOffset < j4) {
                        return i;
                    }
                } else if (sampleOffset < j4) {
                    return i;
                }
                return trackIndex;
            }
            JE je = this.A0G[i3];
            int i4 = je.A00;
            if (i4 != je.A04.A01) {
                long j5 = je.A04.A06[i4];
                long minAccumulatedBytes = ((long[][]) C5C.A0f(this.A0H))[i3][i4];
                long j6 = j5 - j;
                int i5 = (j6 < 0 || j6 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) ? 1 : 0;
                if ((i5 == 0 && preferredTrackIndex != 0) || (i5 == preferredTrackIndex && j6 < j2)) {
                    preferredTrackIndex = i5;
                    j2 = j6;
                    i = i3;
                    if (A0R[6].length() != 29) {
                        String[] strArr2 = A0R;
                        strArr2[5] = "nNk7RawiIyahd9Y";
                        strArr2[0] = "017pL";
                        sampleOffset = minAccumulatedBytes;
                    } else {
                        A0R[1] = "1bC0in6G1ApWSL3PegJBmoVzHl6EE3tw";
                        sampleOffset = minAccumulatedBytes;
                    }
                }
                if (minAccumulatedBytes < j3) {
                    j3 = minAccumulatedBytes;
                    i2 = i5;
                    trackIndex = i3;
                }
            }
            i3++;
        }
    }

    public static int A02(C07364v c07364v) {
        c07364v.A0f(8);
        int majorBrand = A00(c07364v.A0C());
        if (majorBrand != 0) {
            return majorBrand;
        }
        c07364v.A0g(4);
        while (c07364v.A07() > 0) {
            int majorBrand2 = A00(c07364v.A0C());
            if (majorBrand2 != 0) {
                return majorBrand2;
            }
        }
        return 0;
    }

    private int A04(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        int A07 = this.A0N.A07(interfaceC2280ms, hv, this.A0P);
        if (A07 == 1 && hv.A00 == 0) {
            A0A();
        }
        return A07;
    }

    public static int A05(JR jr, long j) {
        int A00 = jr.A00(j);
        if (A00 == -1) {
            return jr.A01(j);
        }
        return A00;
    }

    public static long A06(JR jr, long j, long j2) {
        int A05 = A05(jr, j);
        if (A05 == -1) {
            return j2;
        }
        return Math.min(jr.A06[A05], j2);
    }

    private final HX A07(long j, int i) {
        long j2;
        long j3;
        int mainTrackIndex;
        if (this.A0G.length == 0) {
            return new HX(HZ.A04);
        }
        long j4 = -9223372036854775807L;
        long j5 = -1;
        int i2 = i != -1 ? i : this.A03;
        if (i2 != -1) {
            JR jr = this.A0G[i2].A04;
            int A05 = A05(jr, j);
            if (A05 == -1) {
                return new HX(HZ.A04);
            }
            j3 = jr.A07[A05];
            j2 = jr.A06[A05];
            if (A0R[6].length() != 29) {
                throw new RuntimeException();
            }
            A0R[1] = "zbT5rN6sguJCvWwII8HLCHwSkH7sQNQT";
            if (j3 < j && A05 < jr.A01 - 1 && (mainTrackIndex = jr.A01(j)) != -1 && mainTrackIndex != A05) {
                j4 = jr.A07[mainTrackIndex];
                j5 = jr.A06[mainTrackIndex];
            }
        } else {
            j2 = Long.MAX_VALUE;
            if (A0R[4].length() != 11) {
                j3 = j;
            } else {
                A0R[2] = "SenK5aC";
                j3 = j;
            }
        }
        if (i == -1) {
            for (int i3 = 0; i3 < this.A0G.length; i3++) {
                if (i3 != this.A03) {
                    JR sampleTable = this.A0G[i3].A04;
                    j2 = A06(sampleTable, j3, j2);
                    if (j4 != -9223372036854775807L) {
                        j5 = A06(sampleTable, j4, j5);
                    }
                }
            }
        }
        HZ hz = new HZ(j3, j2);
        if (j4 == -9223372036854775807L) {
            return new HX(hz);
        }
        return new HX(hz, new HZ(j4, j5));
    }

    public static /* synthetic */ JO A08(JO jo) {
        return jo;
    }

    private void A0A() {
        this.A04 = 0;
        this.A00 = 0;
    }

    private void A0B() {
        if (this.A02 == 2 && (this.A0I & 2) != 0) {
            this.A0E.AKS(0, 4).A6e(new C06802p().A0v(this.A0F == null ? null : new Metadata(this.A0F)).A14());
            this.A0E.A6O();
            this.A0E.AJ7(new C2275mn(-9223372036854775807L));
        }
    }

    private void A0D(long j) throws C3K {
        while (!this.A0O.isEmpty() && this.A0O.peek().A00 == j) {
            C2252mE pop = this.A0O.pop();
            if (((AbstractC1078Iu) pop).A00 == 1836019574) {
                A0G(pop);
                this.A0O.clear();
                this.A04 = 2;
            } else if (!this.A0O.isEmpty()) {
                C2252mE containerAtom = this.A0O.peek();
                containerAtom.A08(pop);
            }
        }
        if (this.A04 != 2) {
            A0A();
        }
    }

    private void A0E(long j) {
        if (this.A01 == 1836086884) {
            this.A0F = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + this.A00, this.A09 - this.A00);
        }
    }

    private void A0F(InterfaceC2280ms interfaceC2280ms) throws IOException {
        this.A0M.A0d(8);
        interfaceC2280ms.AGt(this.A0M.A0l(), 0, 8);
        J0.A0Q(this.A0M);
        interfaceC2280ms.AK3(this.A0M.A09());
        interfaceC2280ms.AIl();
    }

    /* JADX WARN: Incorrect condition in loop: B:55:0x0138 */
    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Adding average bitrate calculation logic")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0G(C2252mE c2252mE) throws C3K {
        int i;
        int i2 = -1;
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        List<Mp4Extractor.Mp4Track> tracks = new ArrayList<>();
        Metadata udtaMetaMetadata = null;
        Metadata metadata = null;
        boolean z = this.A02 == 1;
        HK hk = new HK();
        C2251mD A07 = c2252mE.A07(1969517665);
        if (A07 != null) {
            Pair<Metadata, Metadata> A0A = J0.A0A(A07);
            udtaMetaMetadata = (Metadata) A0A.first;
            metadata = (Metadata) A0A.second;
            if (udtaMetaMetadata != null) {
                hk.A05(udtaMetaMetadata);
            }
        }
        Metadata metadata2 = null;
        C2252mE A06 = c2252mE.A06(1835365473);
        if (A06 != null) {
            metadata2 = J0.A0F(A06);
        }
        List<JR> A0O = J0.A0O(c2252mE, hk, -9223372036854775807L, null, (this.A0I & 1) != 0, z, new InterfaceC2140kO() { // from class: com.facebook.ads.redexgen.X.m5
            @Override // com.instagram.common.viewpoint.core.InterfaceC2140kO
            public final Object A4B(Object obj) {
                return C2241m3.A08((JO) obj);
            }
        });
        int trackCount = A0O.size();
        for (int i3 = 0; i3 < trackCount; i3++) {
            JR jr = A0O.get(i3);
            int trackCount2 = jr.A01;
            if (trackCount2 == 0) {
                int i4 = A0R[1].charAt(1);
                if (i4 != 98) {
                    throw new RuntimeException();
                }
                A0R[1] = "ibvFTefsgA7pkzOq8AzNcMz9gVb8PR75";
            } else {
                JO track = jr.A03;
                HA ha = this.A0E;
                int trackCount3 = track.A03;
                JE je = new JE(track, jr, ha.AKS(i3, trackCount3));
                long j4 = track.A04 != -9223372036854775807L ? track.A04 : jr.A02;
                j = Math.max(j, j4);
                if (1 == track.A03) {
                    j3 = j4;
                } else if (2 == track.A03) {
                    j2 = j4;
                }
                if (A09(75, 13, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE).equals(track.A07.A0W)) {
                    int i5 = jr.A00;
                    if (A0R[6].length() != 29) {
                        throw new RuntimeException();
                    }
                    A0R[6] = "30Puiqoz9JCJMsN9BhlLDaWtr32u3";
                    i = i5 * 16;
                } else {
                    i = jr.A00 + 30;
                }
                C06802p formatBuilder = track.A07.A07();
                formatBuilder.A0h(i);
                if (track.A03 == 2 && j4 > 0 && jr.A01 > 1) {
                    formatBuilder.A0X(jr.A01 / (j4 / 1000000.0f));
                }
                if (j > 0 && jr.A01 > 0) {
                    int i6 = jr.A05.length;
                    if (i6 == jr.A01) {
                        long j5 = 0;
                        for (int i7 = 0; i7 < sampleIndex; i7++) {
                            int sampleIndex = jr.A05[i7];
                            j5 += sampleIndex;
                        }
                        formatBuilder.A0a((int) ((8000000 * j5) / j));
                    }
                }
                int i8 = track.A03;
                JB.A0D(i8, hk, formatBuilder);
                int i9 = track.A03;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata;
                metadataArr[1] = this.A0P.isEmpty() ? null : new Metadata(this.A0P);
                JB.A0C(i9, udtaMetaMetadata, metadata2, formatBuilder, metadataArr);
                je.A01.A6e(formatBuilder.A14());
                int i10 = track.A03;
                if (i10 == 2 && i2 == -1) {
                    i2 = tracks.size();
                }
                tracks.add(je);
            }
        }
        this.A03 = i2;
        this.A0B = j;
        this.A0C = j2;
        this.A0A = j3;
        this.A0G = (JE[]) tracks.toArray(new JE[0]);
        this.A0H = A0N(this.A0G);
        this.A0E.A6O();
        this.A0E.AJ7(this);
    }

    private void A0H(JE je, long j) {
        JR jr = je.A04;
        int sampleIndex = jr.A00(j);
        if (sampleIndex == -1) {
            sampleIndex = jr.A01(j);
        }
        je.A00 = sampleIndex;
        if (A0R[2].length() == 19) {
            throw new RuntimeException();
        }
        A0R[2] = "DxqZc2lJMNLNZhW19Xb8kO";
    }

    public static boolean A0I(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
    
        if (r4 != 1937007471) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
    
        if (r4 == 1668232756) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if (r4 == 1953196132) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        if (r4 == 1718909296) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
    
        if (r4 == 1969517665) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r4 == 1801812339) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008b, code lost:
    
        if (r4 != 1768715124) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        if (r4 != 1937007471) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0J(int i) {
        if (i != 1835296868 && i != 1836476516) {
            if (A0R[4].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A0R;
            strArr[3] = "UHuXZ9PGVGxrhu";
            strArr[7] = "Sv1JTBT1egKeuo";
            if (i != 1751411826 && i != 1937011556 && i != 1937011827 && i != 1937011571 && i != 1668576371 && i != 1701606260 && i != 1937011555 && i != 1937011578 && i != 1937013298) {
                if (A0R[2].length() != 19) {
                    A0R[6] = "0EWWhWMRQ7MgS85x4CKboIorprSqD";
                }
            }
        }
        return true;
    }

    private boolean A0K(InterfaceC2280ms interfaceC2280ms) throws IOException {
        C2252mE containerAtom;
        if (this.A00 == 0) {
            if (!interfaceC2280ms.AHR(this.A0J.A0l(), 0, 8, true)) {
                A0B();
                return false;
            }
            this.A00 = 8;
            this.A0J.A0f(0);
            this.A09 = this.A0J.A0Q();
            this.A01 = this.A0J.A0C();
        }
        if (this.A09 == 1) {
            if (A0R[2].length() == 19) {
                throw new RuntimeException();
            }
            A0R[2] = "uEfPCG8cZZkUCN4sq";
            interfaceC2280ms.readFully(this.A0J.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A09 = this.A0J.A0R();
        } else if (this.A09 == 0) {
            long A8O = interfaceC2280ms.A8O();
            if (A8O == -1 && (containerAtom = this.A0O.peek()) != null) {
                A8O = containerAtom.A00;
            }
            if (A8O != -1) {
                this.A09 = (A8O - interfaceC2280ms.A8n()) + this.A00;
            }
        }
        if (this.A09 >= this.A00) {
            if (A0I(this.A01)) {
                long A8n = (interfaceC2280ms.A8n() + this.A09) - this.A00;
                if (this.A09 != this.A00 && this.A01 == 1835365473) {
                    A0F(interfaceC2280ms);
                }
                this.A0O.push(new C2252mE(this.A01, A8n));
                if (this.A09 == this.A00) {
                    A0D(A8n);
                } else {
                    A0A();
                }
            } else if (A0J(this.A01)) {
                AbstractC07133y.A08(this.A00 == 8);
                AbstractC07133y.A08(this.A09 <= 2147483647L);
                C07364v c07364v = new C07364v((int) this.A09);
                C07364v atomData = this.A0J;
                System.arraycopy(atomData.A0l(), 0, c07364v.A0l(), 0, 8);
                this.A0D = c07364v;
                this.A04 = 1;
            } else {
                A0E(interfaceC2280ms.A8n() - this.A00);
                this.A0D = null;
                this.A04 = 1;
            }
            return true;
        }
        throw C3K.A00(A09(0, 48, 61));
    }

    private boolean A0L(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        long j = this.A09 - this.A00;
        long atomEndPosition = interfaceC2280ms.A8n() + j;
        boolean z = false;
        C07364v c07364v = this.A0D;
        if (c07364v != null) {
            interfaceC2280ms.readFully(c07364v.A0l(), this.A00, (int) j);
            if (this.A01 == 1718909296) {
                this.A02 = A02(c07364v);
            } else if (!this.A0O.isEmpty()) {
                this.A0O.peek().A09(new C2251mD(this.A01, c07364v));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            interfaceC2280ms.AK3((int) j);
        } else {
            long atomPayloadSize = interfaceC2280ms.A8n();
            hv.A00 = atomPayloadSize + j;
            z = true;
        }
        A0D(atomEndPosition);
        return z && this.A04 != 2;
    }

    public static /* synthetic */ H9[] A0M() {
        return new H9[]{new C2241m3()};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long[][] A0N(JE[] jeArr) {
        long[][] jArr = new long[jeArr.length][];
        int[] iArr = new int[jeArr.length];
        long[] jArr2 = new long[jeArr.length];
        boolean[] tracksFinished = new boolean[jeArr.length];
        for (int i = 0; i < jeArr.length; i++) {
            jArr[i] = new long[jeArr[i].A04.A01];
            jArr2[i] = jeArr[i].A04.A07[0];
        }
        long j = 0;
        if (A0R[2].length() == 19) {
            throw new RuntimeException();
        }
        A0R[1] = "qbCXFrWy43oBbJoUYfYqc11BUuHVPZxe";
        int i2 = 0;
        while (i2 < jeArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int minTimeTrackIndex = 0; minTimeTrackIndex < jeArr.length; minTimeTrackIndex++) {
                boolean z = tracksFinished[minTimeTrackIndex];
                if (A0R[6].length() != 29) {
                    A0R[2] = "AIMWoJADevTWezna7TxcWd";
                    if (z) {
                    }
                    if (jArr2[minTimeTrackIndex] > j2) {
                        i3 = minTimeTrackIndex;
                        j2 = jArr2[minTimeTrackIndex];
                    }
                } else {
                    String[] strArr = A0R;
                    strArr[3] = "DkVrMcHnnNdNTj";
                    strArr[7] = "McjqbXJyC3Esle";
                    if (z) {
                    }
                    if (jArr2[minTimeTrackIndex] > j2) {
                    }
                }
            }
            int i4 = iArr[i3];
            jArr[i3][i4] = j;
            j += jeArr[i3].A04.A05[i4];
            int i5 = i4 + 1;
            iArr[i3] = i5;
            if (i5 < jArr[i3].length) {
                JE je = jeArr[i3];
                if (A0R[1].charAt(1) != 'b') {
                    jArr2[i3] = je.A04.A07[i5];
                } else {
                    String[] strArr2 = A0R;
                    strArr2[5] = "FttiEMkEmxvjjK7";
                    strArr2[0] = "cOA5C";
                    jArr2[i3] = je.A04.A07[i5];
                }
            } else {
                tracksFinished[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A0B;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        return A07(j, -1);
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AAC(HA ha) {
        this.A0E = ha;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final int AHL(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        while (true) {
            switch (this.A04) {
                case 0:
                    if (!A0K(interfaceC2280ms)) {
                        return -1;
                    }
                    break;
                case 1:
                    if (!A0L(interfaceC2280ms, hv)) {
                        break;
                    } else {
                        return 1;
                    }
                case 2:
                    return A03(interfaceC2280ms, hv);
                case 3:
                    return A04(interfaceC2280ms, hv);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AHb() {
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AJ6(long j, long j2) {
        this.A0O.clear();
        this.A00 = 0;
        this.A08 = -1;
        this.A05 = 0;
        this.A06 = 0;
        this.A07 = 0;
        if (j == 0) {
            int i = this.A04;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0R;
            strArr2[3] = "BBO5nGzNDCjhdG";
            strArr2[7] = "Qq9RZt6cBQ724Z";
            if (i != 3) {
                A0A();
                return;
            } else {
                this.A0N.A08();
                this.A0P.clear();
                return;
            }
        }
        for (JE je : this.A0G) {
            A0H(je, j2);
            if (je.A02 != null) {
                je.A02.A02();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final boolean AK5(InterfaceC2280ms interfaceC2280ms) throws IOException {
        return JM.A02(interfaceC2280ms, (this.A0I & 2) != 0);
    }
}
