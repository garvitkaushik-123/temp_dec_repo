package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: assets/audience_network/classes2.dex */
public final class KM {
    public static byte[] A0D;
    public static String[] A0E = {"GeuvjWmU0qMIecUET3rH1sSpSiCCpV8d", "VWuGBdV", "r1UddSi70yifv9lgmWBFhDm81yvqf6sz", "XTFXH6doUzlPXpn0lOcCpEMXSJ", "Gs3RvICYSdgYtTZ", "LUo1PxiU5xdJ1hZxjmijWXp8gfNxa8cO", "PBxwyL5R7nlTE13P8yY94OOBBe", "AYtcaoWRC0gFrEQm0SEPSBapgfKgyhaj"};
    public List<KM> A00;
    public final long A01;
    public final long A02;
    public final KM A03;
    public final KT A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final HashMap<String, Integer> A0A;
    public final HashMap<String, Integer> A0B;
    public final String[] A0C;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0E[1].length() == 19) {
                throw new RuntimeException();
            }
            A0E[1] = "X7T2v9MzXPQN9wm4iApZn5l";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 80);
            i4++;
        }
    }

    public static void A04() {
        A0D = new byte[]{Ascii.RS, Ascii.SO, 38, 43, 52, 92, 84, 69, 80, 85, 80, 69, 80, 95};
    }

    static {
        A04();
    }

    public KM(String str, String str2, long j, long j2, KT kt, String[] strArr, String str3, String str4, KM km) {
        this.A07 = str;
        this.A08 = str2;
        this.A05 = str4;
        this.A04 = kt;
        this.A0C = strArr;
        this.A09 = str2 != null;
        this.A02 = j;
        this.A01 = j2;
        this.A06 = (String) AbstractC07133y.A01(str3);
        this.A03 = km;
        this.A0B = new HashMap<>();
        this.A0A = new HashMap<>();
    }

    public static SpannableStringBuilder A00(String str, Map<String, C07033o> map) {
        if (!map.containsKey(str)) {
            C07033o c07033o = new C07033o();
            c07033o.A0G(new SpannableStringBuilder());
            map.put(str, c07033o);
        }
        C07033o regionOutput = map.get(str);
        return (SpannableStringBuilder) AbstractC07133y.A01(regionOutput.A0I());
    }

    public static KM A01(String str) {
        return new KM(null, KO.A04(str), -9223372036854775807L, -9223372036854775807L, null, null, A03(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), null, null);
    }

    public static KM A02(String str, long j, long j2, KT kt, String[] strArr, String str2, String str3, KM km) {
        return new KM(str, null, j, j2, kt, strArr, str2, str3, km);
    }

    private void A05(long j, String str, List<Pair<String, String>> regionImageList) {
        if (!A03(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equals(this.A06)) {
            str = this.A06;
        }
        if (A0B(j)) {
            String A03 = A03(2, 3, 18);
            String resolvedRegionId = this.A07;
            if (A03.equals(resolvedRegionId)) {
                String resolvedRegionId2 = this.A05;
                if (resolvedRegionId2 != null) {
                    regionImageList.add(new Pair<>(str, this.A05));
                    return;
                }
            }
        }
        for (int i = 0; i < A0C(); i++) {
            A0D(i).A05(j, str, regionImageList);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:24:0x0089 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A06(long j, Map<String, KT> map, Map<String, KN> map2, String str, Map<String, C07033o> map3) {
        int end;
        String str2 = str;
        if (A0B(j)) {
            if (!A03(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equals(this.A06)) {
                str2 = this.A06;
            }
            for (Map.Entry<String, Integer> entry : this.A0A.entrySet()) {
                String key = entry.getKey();
                if (this.A0B.containsKey(key)) {
                    end = this.A0B.get(key).intValue();
                } else {
                    end = 0;
                }
                int intValue = entry.getValue().intValue();
                if (end != intValue) {
                    A09(map, (C07033o) AbstractC07133y.A01(map3.get(key)), end, intValue, ((KN) AbstractC07133y.A01(map2.get(str2))).A08);
                }
            }
            for (int i = 0; i < i; i++) {
                A0D(i).A06(j, map, map2, str2, map3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ec, code lost:
    
        if (r14 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ee, code lost:
    
        if (r4 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f7, code lost:
    
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f0, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0100, code lost:
    
        if (r14 == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A07(long j, boolean z, String str, Map<String, C07033o> map) {
        boolean z2;
        String str2 = str;
        this.A0B.clear();
        this.A0A.clear();
        if (A03(5, 8, 97).equals(this.A07)) {
            return;
        }
        if (!A03(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equals(this.A06)) {
            str2 = this.A06;
        }
        if (this.A09 && z) {
            SpannableStringBuilder A00 = A00(str2, map);
            String resolvedRegionId = this.A08;
            A00.append((CharSequence) AbstractC07133y.A01(resolvedRegionId));
            return;
        }
        String A03 = A03(0, 2, 44);
        String resolvedRegionId2 = this.A07;
        if (A03.equals(resolvedRegionId2) && z) {
            SpannableStringBuilder A002 = A00(str2, map);
            String[] strArr = A0E;
            if (strArr[0].charAt(26) == strArr[2].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[5] = "DvePMvlINfUrHf8oCshP3y2zgWJgm1y9";
            strArr2[7] = "g33vhajkRJhloC0qEKLO4Zm1g9rQEkrd";
            A002.append('\n');
            return;
        }
        if (!A0B(j)) {
            return;
        }
        for (Map.Entry<String, C07033o> entry : map.entrySet()) {
            this.A0B.put(entry.getKey(), Integer.valueOf(((CharSequence) AbstractC07133y.A01(entry.getValue().A0I())).length()));
        }
        String A032 = A03(13, 1, 127);
        String resolvedRegionId3 = this.A07;
        boolean equals = A032.equals(resolvedRegionId3);
        for (int i = 0; i < A0C(); i++) {
            KM A0D2 = A0D(i);
            String[] strArr3 = A0E;
            String str3 = strArr3[3];
            String resolvedRegionId4 = strArr3[6];
            if (str3.length() == resolvedRegionId4.length()) {
                A0E[1] = "BxcnzhC5XqKLAs";
            }
            A0D2.A07(j, z2, str2, map);
        }
        if (equals) {
            KO.A07(A00(str2, map));
        }
        for (Map.Entry<String, C07033o> entry2 : map.entrySet()) {
            HashMap<String, Integer> hashMap = this.A0A;
            String key = entry2.getKey();
            C07033o value = entry2.getValue();
            String[] strArr4 = A0E;
            if (strArr4[0].charAt(26) != strArr4[2].charAt(26)) {
                String[] strArr5 = A0E;
                strArr5[3] = "NvsWEQBQe6VAGnQhJA54b4pVjA";
                strArr5[6] = "RDTsakCOEzYFACc9hnpkZM81VS";
                hashMap.put(key, Integer.valueOf(((CharSequence) AbstractC07133y.A01(value.A0I())).length()));
            } else {
                String[] strArr6 = A0E;
                strArr6[5] = "CHxe0vxZr8lPRHvaCG5LBeS6gh9aVBuv";
                strArr6[7] = "HeV50lBh9JGf3GNHX7ZdMbjxgTQZONIp";
                hashMap.put(key, Integer.valueOf(((CharSequence) AbstractC07133y.A01(value.A0I())).length()));
            }
        }
    }

    public static void A08(SpannableStringBuilder spannableStringBuilder) {
        for (KF kf : (KF[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), KF.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(kf), spannableStringBuilder.getSpanEnd(kf), (CharSequence) A03(0, 0, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE));
        }
        loop1: for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                while (i2 < spannableStringBuilder.length()) {
                    char charAt = spannableStringBuilder.charAt(i2);
                    String[] strArr = A0E;
                    String str = strArr[5];
                    String str2 = strArr[7];
                    int i3 = str.charAt(24);
                    if (i3 != str2.charAt(24)) {
                        break loop1;
                    }
                    String[] strArr2 = A0E;
                    strArr2[0] = "TbkeKkbvotKRDkL3aJkR6CKPV2CRZepO";
                    strArr2[2] = "HOyzJt7YVHsiDEtesdPQS8q1On7uoMtF";
                    if (charAt != ' ') {
                        break;
                    } else {
                        i2++;
                    }
                }
                int j = i + 1;
                String[] strArr3 = A0E;
                String str3 = strArr3[0];
                String str4 = strArr3[2];
                int i4 = str3.charAt(26);
                if (i4 == str4.charAt(26)) {
                    throw new RuntimeException();
                }
                A0E[1] = "2IIAODStabB9";
                int i5 = i2 - j;
                if (i5 > 0) {
                    spannableStringBuilder.delete(i, i + i5);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i6 + 1) == ' ') {
                int i7 = i6 + 1;
                spannableStringBuilder.delete(i7, i6 + 2);
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i8 + 1) == '\n') {
                spannableStringBuilder.delete(i8, i8 + 1);
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void A09(Map<String, KT> map, C07033o c07033o, int i, int i2, int i3) {
        KT A02 = KO.A02(this.A04, this.A0C, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c07033o.A0I();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c07033o.A0G(spannableStringBuilder);
        }
        if (A02 != null) {
            KO.A06(spannableStringBuilder, i, i2, A02, this.A03, map, i3);
            if (A03(13, 1, 127).equals(this.A07)) {
                if (A02.A04() != Float.MAX_VALUE) {
                    c07033o.A05((A02.A04() * (-90.0f)) / 100.0f);
                }
                if (A02.A0C() != null) {
                    c07033o.A0F(A02.A0C());
                }
                if (A02.A0B() != null) {
                    c07033o.A0E(A02.A0B());
                }
            }
        }
    }

    private void A0A(TreeSet<Long> treeSet, boolean z) {
        boolean equals = A03(13, 1, 127).equals(this.A07);
        boolean isPNode = A03(2, 3, 18).equals(this.A07);
        if (z || equals || (isPNode && this.A05 != null)) {
            if (this.A02 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.A02));
            }
            if (this.A01 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.A01));
            }
        }
        if (this.A00 == null) {
            return;
        }
        for (int i = 0; i < this.A00.size(); i++) {
            KM km = this.A00.get(i);
            boolean isPNode2 = z || equals;
            km.A0A(treeSet, isPNode2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r2 != (-9223372036854775807L)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean A0B(long j) {
        if (this.A02 != -9223372036854775807L || this.A01 != -9223372036854775807L) {
            if (this.A02 <= j) {
                long j2 = this.A01;
                if (A0E[1].length() == 19) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[5] = "RgXDLQ3a08cIBfoVnl1r1eLIg5MUrfoW";
                strArr[7] = "Ter36j0QNwpTucwH0VATqUwzgkfFz8sj";
            }
            if ((this.A02 != -9223372036854775807L || j >= this.A01) && (this.A02 > j || j >= this.A01)) {
                return false;
            }
        }
        return true;
    }

    public final int A0C() {
        if (this.A00 == null) {
            return 0;
        }
        List<KM> list = this.A00;
        if (A0E[4].length() == 7) {
            throw new RuntimeException();
        }
        A0E[1] = "iiL";
        return list.size();
    }

    public final KM A0D(int i) {
        if (this.A00 != null) {
            return this.A00.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<C2439pT> A0E(long j, Map<String, KT> map, Map<String, KN> map2, Map<String, String> imageMap) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        A05(j, this.A06, arrayList);
        TreeMap treeMap = new TreeMap();
        A07(j, false, this.A06, treeMap);
        A06(j, map, map2, this.A06, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = imageMap.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                KN kn = (KN) AbstractC07133y.A01(map2.get(pair.first));
                arrayList2.add(new C07033o().A0D(decodeByteArray).A04(kn.A02).A0A(0).A07(kn.A01, 0).A09(kn.A05).A06(kn.A04).A03(kn.A00).A0B(kn.A08).A0H());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            KN kn2 = (KN) AbstractC07133y.A01(map2.get(entry.getKey()));
            C07033o c07033o = (C07033o) entry.getValue();
            A08((SpannableStringBuilder) AbstractC07133y.A01(c07033o.A0I()));
            c07033o.A07(kn2.A01, kn2.A06);
            c07033o.A09(kn2.A05);
            c07033o.A04(kn2.A02);
            c07033o.A06(kn2.A04);
            c07033o.A08(kn2.A03, kn2.A07);
            c07033o.A0B(kn2.A08);
            arrayList2.add(c07033o.A0H());
        }
        return arrayList2;
    }

    public final void A0F(KM km) {
        if (this.A00 == null) {
            this.A00 = new ArrayList();
        }
        this.A00.add(km);
    }

    public final long[] A0G() {
        TreeSet<Long> treeSet = new TreeSet<>();
        A0A(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public final String[] A0H() {
        return this.A0C;
    }
}
