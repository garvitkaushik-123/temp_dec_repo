package com.instagram.common.viewpoint.core;

import com.google.errorprone.annotations.DoNotMock;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@DoNotMock
/* renamed from: com.facebook.ads.redexgen.X.oV, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2379oV<K, V> {
    public static String[] A05 = {"Ik8goa9HXdjUedq8cEoRj", "yNhTKiocZ7rjCehz8OJ2i", "DkakVx1e11xcRXvmRC6v1TtF6afSopEP", "UtLKeYkY3MHutveLBbt6ViX4Ghxq7RLm", "uRXlO9IyqWrK3A2ygB5qFTtsXpO2Awm7", "zlj3Be3Z9w6linslu0iq2TGTNfwrs1VP", "5qPNzLkadTBG9NaQBiFovEuvvje4vKUT", "NGIyMpNx726S6ss9PVDsEc5y9iMjD192"};
    public int A00;
    public C2378oU A01;

    @CheckForNull
    public Comparator<? super V> A02;
    public boolean A03;
    public Object[] A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public C2379oV() {
        this(4);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public C2379oV(int initialCapacity) {
        this.A04 = new Object[initialCapacity * 2];
        this.A00 = 0;
        this.A03 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        if (r7 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        r0 = r6.A00;
        r3 = A03(r3, r0);
        r1 = r3.length;
        r0 = r6.A04.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        if (r1 >= r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        r0 = r3.length;
        r4 = r0 >>> 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        A02(r3, r4, r6.A02);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
    
        if (r7 == false) goto L22;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oX != com.google.common.collect.ImmutableMap<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AbstractC2381oX<K, V> A00(boolean throwIfDuplicateKeys) {
        Object[] objArr;
        if (!throwIfDuplicateKeys || this.A01 == null) {
            int i = this.A00;
            if (this.A02 == null) {
                objArr = this.A04;
            } else {
                if (this.A03) {
                    Object[] objArr2 = this.A04;
                    int localSize = this.A00;
                    this.A04 = Arrays.copyOf(objArr2, localSize * 2);
                }
                objArr = this.A04;
                String[] strArr = A05;
                String str = strArr[7];
                String str2 = strArr[6];
                int charAt = str.charAt(3);
                int localSize2 = str2.charAt(3);
                if (charAt != localSize2) {
                    String[] strArr2 = A05;
                    strArr2[7] = "tX3gZScD6fAOC4rORBvWPUmZGErHeLSO";
                    strArr2[6] = "jrBtMl0wusQaFHx7PyJGdvme9jU6DfCL";
                } else {
                    String[] strArr3 = A05;
                    strArr3[1] = "PSlulOu9AYbjP6HRhL598";
                    strArr3[0] = "W85FiMbgjq5wBNzVkCx7e";
                }
            }
            this.A03 = true;
            String[] strArr4 = A05;
            String str3 = strArr4[7];
            String str4 = strArr4[6];
            int charAt2 = str3.charAt(3);
            int localSize3 = str4.charAt(3);
            if (charAt2 == localSize3) {
                throw new RuntimeException();
            }
            String[] strArr5 = A05;
            strArr5[3] = "XM2Ql5x9fz20ei3IvXWTiqpzWNcACmEW";
            strArr5[5] = "FilAMF5uGkzgcjBUcpllGZjqGija48a5";
            B9 A00 = B9.A00(i, objArr, this);
            if (!throwIfDuplicateKeys || this.A01 == null) {
                return A00;
            }
            throw this.A01.A02();
        }
        throw this.A01.A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    private void A01(int minCapacity) {
        if (minCapacity * 2 > this.A04.length) {
            this.A04 = Arrays.copyOf(this.A04, AbstractC2371oN.A03(this.A04.length, minCapacity * 2));
            this.A03 = false;
        }
    }

    public static <V> void A02(Object[] alternatingKeysAndValues, int size, Comparator<? super V> valueComparator) {
        Map.Entry[] entryArr = new Map.Entry[size];
        for (int i = 0; i < size; i++) {
            Object key = Objects.requireNonNull(alternatingKeysAndValues[i * 2]);
            entryArr[i] = new AbstractMap.SimpleImmutableEntry(key, Objects.requireNonNull(alternatingKeysAndValues[(i * 2) + 1]));
        }
        Arrays.sort(entryArr, 0, size, AbstractC2491qK.A04(valueComparator).A05(AbstractC2459po.A04()));
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * 2;
            alternatingKeysAndValues[i3] = entryArr[i2].getKey();
            int i4 = (i2 * 2) + 1;
            alternatingKeysAndValues[i4] = entryArr[i2].getValue();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object[] A03(Object[] localAlternatingKeysAndValues, int size) {
        HashSet hashSet = new HashSet();
        BitSet bitSet = new BitSet();
        for (int i = size - 1; i >= 0; i--) {
            if (!hashSet.add(Objects.requireNonNull(localAlternatingKeysAndValues[i * 2]))) {
                bitSet.set(i);
            }
        }
        boolean isEmpty = bitSet.isEmpty();
        String[] strArr = A05;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[1] = "c6MJ0uR9bSKZ7TJmqu2Hw";
        strArr2[0] = "RsQ7tLk4pv8rflhmUKtuV";
        if (isEmpty) {
            return localAlternatingKeysAndValues;
        }
        Object[] objArr = new Object[(size - bitSet.cardinality()) * 2];
        int outI = 0;
        int i2 = 0;
        while (true) {
            int i3 = size * 2;
            String[] strArr3 = A05;
            if (strArr3[7].charAt(3) != strArr3[6].charAt(3)) {
                Object[] newAlternatingKeysAndValues = A05;
                newAlternatingKeysAndValues[3] = "KtRosFhRShMS8OmqJ5rxyo1E8ullyHpz";
                newAlternatingKeysAndValues[5] = "EZy12p44B0vHf3sXUsOAjtCOpwah16Ul";
                if (outI >= i3) {
                    break;
                }
                if (!bitSet.get(outI >>> 1)) {
                    outI += 2;
                } else {
                    int i4 = i2 + 1;
                    int i5 = outI + 1;
                    objArr[i2] = Objects.requireNonNull(localAlternatingKeysAndValues[outI]);
                    i2 = i4 + 1;
                    outI = i5 + 1;
                    objArr[i4] = Objects.requireNonNull(localAlternatingKeysAndValues[i5]);
                }
            } else {
                if (outI >= i3) {
                    break;
                }
                if (!bitSet.get(outI >>> 1)) {
                }
            }
        }
        return objArr;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public C2379oV<K, V> A04(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        if (entries instanceof Collection) {
            A01(this.A00 + ((Collection) entries).size());
        }
        for (Map.Entry<? extends K, ? extends V> entry : entries) {
            String[] strArr = A05;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[3] = "rS0In8hcQgouYJTkMI0NVISmFAAYCd82";
            strArr2[5] = "9F24JphxFR6iDhplWUuRUXCsXlHokznU";
            A06(entry);
        }
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public C2379oV<K, V> A05(K key, V value) {
        A01(this.A00 + 1);
        AbstractC2306nJ.A03(key, value);
        this.A04[this.A00 * 2] = key;
        this.A04[(this.A00 * 2) + 1] = value;
        this.A00++;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public C2379oV<K, V> A06(Map.Entry<? extends K, ? extends V> entry) {
        return A05(entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public AbstractC2381oX<K, V> A07() {
        return A08();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<K, V> */
    public AbstractC2381oX<K, V> A08() {
        return A00(true);
    }
}
