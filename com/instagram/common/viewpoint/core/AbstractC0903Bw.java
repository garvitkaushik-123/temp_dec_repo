package com.instagram.common.viewpoint.core;

import javax.annotation.CheckForNull;

/* renamed from: com.facebook.ads.redexgen.X.Bw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0903Bw extends AbstractC2123k6<String> {
    public static String[] A05 = {"Y6GgR6t8IKI", "VFkkD7m5TZieTdIGcMhjlI6kmFQATLKN", "mG5qNJ2cuZKVjOSNlAyh8B4xR9rE0ZKh", "CM7cohX4W2k9cinGHwlxigjKg6gGPkMn", "nFCnUuwWiAgAe84yG3jEJO62AyGyzlur", "7r", "4QyinOl4Or1zHXh0KCFmZglNOrfMdCYS", "IPc7SPgKd69USKaPje1bIKNcFeLlsWuv"};
    public int A00;
    public int A01 = 0;
    public final CC A02;
    public final CharSequence A03;
    public final boolean A04;

    public abstract int A04(int separatorPosition);

    public abstract int A05(int start);

    public AbstractC0903Bw(C2166kp splitter, CharSequence toSplit) {
        CC cc;
        boolean z;
        int i;
        cc = splitter.A01;
        this.A02 = cc;
        z = splitter.A03;
        this.A04 = z;
        i = splitter.A00;
        this.A00 = i;
        this.A03 = toSplit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        if (r7 == 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        r3 = r8.A03.length();
        r2 = com.instagram.common.viewpoint.core.AbstractC0903Bw.A05;
        r1 = r2[4];
        r2 = r2[6];
        r1 = r1.charAt(10);
        r0 = r2.charAt(10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
    
        if (r1 == r0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
    
        r2 = com.instagram.common.viewpoint.core.AbstractC0903Bw.A05;
        r2[4] = "SuB8QNIalYE0K4C3aNFCBNECGLTpXTA5";
        r2[6] = "ZMjLx3riby3c0ZsVFXnt0BJdbQ1Fsr1P";
        r8.A01 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c1, code lost:
    
        if (r3 <= r5) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c3, code lost:
    
        r0 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d1, code lost:
    
        if (r8.A02.A09(r8.A03.charAt(r0)) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d6, code lost:
    
        com.instagram.common.viewpoint.core.AbstractC0903Bw.A05[7] = "d3Q1ejutGvqDbQDKCEC2qDkOl0TUQWTa";
        r8.A01 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ef, code lost:
    
        r0 = r8.A00;
        r8.A00 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
    
        if (r7 == 1) goto L31;
     */
    /* JADX WARN: Incorrect condition in loop: B:3:0x0005 */
    @Override // com.instagram.common.viewpoint.core.AbstractC2123k6
    @CheckForNull
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String A03() {
        int i = this.A01;
        while (nextStart != -1) {
            int nextStart = this.A01;
            int separatorPosition = A05(nextStart);
            if (separatorPosition == -1) {
                separatorPosition = this.A03.length();
                this.A01 = -1;
            } else {
                int nextStart2 = A04(separatorPosition);
                this.A01 = nextStart2;
            }
            int nextStart3 = this.A01;
            if (nextStart3 == i) {
                int nextStart4 = this.A01;
                this.A01 = nextStart4 + 1;
                int start = this.A01;
                int nextStart5 = this.A03.length();
                if (start > nextStart5) {
                    this.A01 = -1;
                }
            } else {
                while (i < separatorPosition && this.A02.A09(this.A03.charAt(i))) {
                    i++;
                }
                while (separatorPosition > i) {
                    int nextStart6 = separatorPosition - 1;
                    if (!this.A02.A09(this.A03.charAt(nextStart6))) {
                        break;
                    }
                    separatorPosition--;
                }
                boolean z = this.A04;
                int start2 = A05[7].charAt(13);
                if (start2 == 89) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[5] = "Ef";
                strArr[0] = "Em1AIG0CRO3";
                if (z && i == separatorPosition) {
                    i = this.A01;
                } else {
                    int i2 = this.A00;
                    String[] strArr2 = A05;
                    String str = strArr2[3];
                    String str2 = strArr2[1];
                    int start3 = str.charAt(15);
                    int nextStart7 = str2.charAt(15);
                    if (start3 == nextStart7) {
                        String[] strArr3 = A05;
                        strArr3[3] = "tCIj44jeXfrUIeKGqWzYJFtUtJKCQpO9";
                        strArr3[1] = "3BTz6P6YlFAqNOcGdApEEEFNm8KDvcbh";
                    }
                    return this.A03.subSequence(i, separatorPosition).toString();
                }
            }
        }
        return A02();
    }
}
