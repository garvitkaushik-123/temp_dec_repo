package com.facebook.ads.androidx.media3.extractor;

import android.net.Uri;
import com.facebook.ads.androidx.media3.extractor.DefaultExtractorsFactory;
import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.instagram.common.viewpoint.core.AbstractC06752k;
import com.instagram.common.viewpoint.core.AnonymousClass53;
import com.instagram.common.viewpoint.core.C2175kz;
import com.instagram.common.viewpoint.core.C2179l3;
import com.instagram.common.viewpoint.core.C2186lA;
import com.instagram.common.viewpoint.core.C2201lP;
import com.instagram.common.viewpoint.core.C2203lR;
import com.instagram.common.viewpoint.core.C2206lU;
import com.instagram.common.viewpoint.core.C2209lX;
import com.instagram.common.viewpoint.core.C2234lw;
import com.instagram.common.viewpoint.core.C2240m2;
import com.instagram.common.viewpoint.core.C2241m3;
import com.instagram.common.viewpoint.core.C2254mG;
import com.instagram.common.viewpoint.core.C2265md;
import com.instagram.common.viewpoint.core.C2268mg;
import com.instagram.common.viewpoint.core.C2273ml;
import com.instagram.common.viewpoint.core.C2489qI;
import com.instagram.common.viewpoint.core.H4;
import com.instagram.common.viewpoint.core.H5;
import com.instagram.common.viewpoint.core.H9;
import com.instagram.common.viewpoint.core.HD;
import com.instagram.common.viewpoint.core.MetaExoPlayerCustomizedCollections;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public final class DefaultExtractorsFactory implements HD {
    public static byte[] A0D;
    public static String[] A0E = {"XjRCK", "YKKzt2Kz2K7V0l18n", "uXpf", "oBPf3SXxcwKIIjUAiSrSO2O", "bGsaI0", "ItuqzfwzHHPicVJR9bxtDiYARBCa2uxZ", "TYxjAZ909gRPDezWj", "NTeqQWiGfYp1zE0qSPlL6iBK546ff9Um"};
    public static final H5 A0F;
    public static final H5 A0G;
    public static final int[] A0H;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08 = 1;
    public int A09 = 112800;

    @MetaExoPlayerCustomization("Replaces ImmutableList with List")
    public List<C2489qI> A0A = MetaExoPlayerCustomizedCollections.A03(new C2489qI[0]);
    public boolean A0B;
    public boolean A0C;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 122);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0D = new byte[]{74, 86, 84, Ascii.NAK, 77, 72, 74, 76, 73, 86, 86, 82, Ascii.NAK, 72, 75, 90, Ascii.NAK, 72, 85, 75, 89, 86, 80, 75, 95, Ascii.NAK, 84, 76, 75, 80, 72, Ascii.SUB, Ascii.NAK, 75, 76, 74, 86, 75, 76, 89, Ascii.NAK, 84, 80, 75, 80, Ascii.NAK, 52, 80, 75, 80, 44, 95, 91, 89, 72, 74, 91, 86, 89, -6, 6, 4, -59, -3, -8, -6, -4, -7, 6, 6, 2, -59, -8, -5, 10, -59, -2, 6, 6, -2, 3, -4, -59, -8, 5, -5, 9, 6, 0, -5, -59, -4, Ascii.SI, 6, 7, 3, -8, Ascii.DLE, -4, 9, -55, -59, -4, Ascii.SI, Ascii.VT, -59, -3, 3, -8, -6, -59, -35, 3, -8, -6, -36, Ascii.SI, Ascii.VT, 9, -8, -6, Ascii.VT, 6, 9, Ascii.ESC, 39, 37, -26, Ascii.RS, Ascii.EM, Ascii.ESC, Ascii.GS, Ascii.SUB, 39, 39, 35, -26, Ascii.EM, Ascii.FS, 43, -26, Ascii.US, 39, 39, Ascii.US, 36, Ascii.GS, -26, Ascii.EM, 38, Ascii.FS, 42, 39, 33, Ascii.FS, -26, Ascii.GS, 48, 39, 40, 36, Ascii.EM, 49, Ascii.GS, 42, -22, -26, Ascii.GS, 48, 44, -26, Ascii.RS, 36, Ascii.EM, Ascii.ESC, -26, -2, 36, Ascii.EM, Ascii.ESC, 4, 33, Ascii.SUB, 42, Ascii.EM, 42, 49, 82, 92, 42, 95, 74, 82, 85, 74, 75, 85, 78};
    }

    static {
        A05();
        A0H = new int[]{5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
        A0F = new H5(new H4() { // from class: com.facebook.ads.redexgen.X.mw
            @Override // com.instagram.common.viewpoint.core.H4
            public final Constructor A7R() {
                Constructor A01;
                A01 = DefaultExtractorsFactory.A01();
                return A01;
            }
        });
        A0G = new H5(new H4() { // from class: com.facebook.ads.redexgen.X.mv
            @Override // com.instagram.common.viewpoint.core.H4
            public final Constructor A7R() {
                Constructor A02;
                A02 = DefaultExtractorsFactory.A02();
                return A02;
            }
        });
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public DefaultExtractorsFactory() {
    }

    public static Constructor<? extends H9> A01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean isFlacNativeLibraryAvailable = Boolean.TRUE.equals(Class.forName(A00(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 63, 62)).getMethod(A00(187, 11, 111), new Class[0]).invoke(null, new Object[0]));
        if (!isFlacNativeLibraryAvailable) {
            return null;
        }
        return Class.forName(A00(59, 65, 29)).asSubclass(H9.class).getConstructor(Integer.TYPE);
    }

    public static Constructor<? extends H9> A02() throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(A00(0, 59, 109)).asSubclass(H9.class).getConstructor(new Class[0]);
    }

    @MetaExoPlayerCustomization("Removed AVI and JPEG extractors")
    private void A06(int i, List<H9> list) {
        int i2 = 2;
        switch (i) {
            case 0:
                list.add(new C2209lX());
                return;
            case 1:
                list.add(new C2206lU());
                return;
            case 2:
                int i3 = (this.A0C ? 1 : 0) | this.A00;
                String[] strArr = A0E;
                if (strArr[2].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[5] = "0JYW4ys9S4cBRo9bfKNpoispKPkvAlfn";
                strArr2[7] = "ESM27VzyBHwJIaBfhIrCniRSUGwbmbgc";
                if (!this.A0B) {
                    i2 = 0;
                }
                list.add(new C2203lR(i2 | i3));
                return;
            case 3:
                int i4 = (this.A0C ? 1 : 0) | this.A01;
                boolean z = this.A0B;
                String[] strArr3 = A0E;
                if (strArr3[2].length() != strArr3[0].length()) {
                    String[] strArr4 = A0E;
                    strArr4[6] = "88SSgZrekVuE3ZpEu";
                    strArr4[1] = "yFmqseBd895DxKzOE";
                    if (!z) {
                        i2 = 0;
                    }
                    list.add(new C2273ml(i2 | i4));
                    return;
                }
                throw new RuntimeException();
            case 4:
                H9 flacExtractor = A0F.A03(Integer.valueOf(this.A02));
                if (flacExtractor != null) {
                    list.add(flacExtractor);
                    return;
                } else {
                    list.add(new C2268mg(this.A02));
                    return;
                }
            case 5:
                list.add(new C2265md());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.A04));
                return;
            case 7:
                int i5 = (this.A0C ? 1 : 0) | this.A05;
                if (!this.A0B) {
                    i2 = 0;
                }
                list.add(new C2254mG(i2 | i5));
                return;
            case 8:
                list.add(new C2240m2().A01(this.A03));
                list.add(new C2241m3(this.A06));
                return;
            case 9:
                list.add(new C2234lw());
                return;
            case 10:
                list.add(new C2186lA());
                return;
            case 11:
                list.add(new C2179l3(this.A08, new AnonymousClass53(0L), new C2201lP(this.A07, this.A0A), this.A09));
                return;
            case 12:
                list.add(new C2175kz());
                return;
            case 13:
            case 14:
            default:
                return;
            case 15:
                H9 midiExtractor = A0G.A03(new Object[0]);
                if (midiExtractor == null) {
                    return;
                }
                list.add(midiExtractor);
                return;
        }
    }

    @Override // com.instagram.common.viewpoint.core.HD
    public final synchronized H9[] A5N() {
        return A5O(Uri.EMPTY, new HashMap());
    }

    @Override // com.instagram.common.viewpoint.core.HD
    public final synchronized H9[] A5O(Uri uri, Map<String, List<String>> responseHeaders) {
        List<Extractor> extractors;
        extractors = new ArrayList<>(A0H.length);
        int fileType = AbstractC06752k.A02(responseHeaders);
        if (fileType != -1) {
            A06(fileType, extractors);
        }
        int A00 = AbstractC06752k.A00(uri);
        if (A00 != -1 && A00 != fileType) {
            A06(A00, extractors);
        }
        for (int responseHeadersInferredFileType : A0H) {
            if (responseHeadersInferredFileType != fileType && responseHeadersInferredFileType != A00) {
                A06(responseHeadersInferredFileType, extractors);
            }
        }
        return (H9[]) extractors.toArray(new H9[extractors.size()]);
    }
}
