package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* renamed from: com.facebook.ads.redexgen.X.1b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C06421b extends AE implements Handler.Callback {
    public static byte[] A0H;
    public static String[] A0I = {"58lW15hp88fFpLaSxErp", "56QScXrV6I", "DwEmmtKo2ODeTiA17rxauXwet98Z4", "A4aLtxZMLOPLaVE6SeDzXnpOLTGefetw", "FhOKuZuvLBWd8lghoK1mwxVLtzQRZ", "h1d8vpIJ83Cnf8DVjx4Ui7av1xQxYsFL", "y1YT0hSXczs7bGZDGpuR", "alxZNjekiwxoo3ZSsAAxphzspQJfVEZr"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public C2489qI A05;
    public InterfaceC2228lq A06;
    public C8S A07;
    public C8P A08;
    public C8P A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final Handler A0D;
    public final C07926z A0E;
    public final EP A0F;
    public final ES A0G;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0I;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[2] = "1YRuRVntTKbD5w1SSS8awuyRss3tM";
            strArr2[4] = "HmFGzdsys3t1iPkkAdwtO8Q44Z9aJ";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
            i4++;
        }
    }

    public static void A09() {
        A0H = new byte[]{89, Byte.MAX_VALUE, 104, 126, 99, 126, 102, 111, 42, 110, 111, 105, 101, 110, 99, 100, 109, 42, 108, 107, 99, 102, 111, 110, 36, 42, 121, 126, 120, 111, 107, 103, 76, 101, 120, 103, 107, 126, 55, 57, 8, Ascii.NAK, Ascii.EM, 63, 8, 3, 9, 8, Ascii.US, 8, Ascii.US};
    }

    static {
        A09();
    }

    public C06421b(ES es, Looper looper, EP ep) {
        super(3);
        this.A0G = (ES) AbstractC07133y.A01(es);
        this.A0D = looper == null ? null : C5C.A0c(looper, this);
        this.A0F = ep;
        this.A0E = new C07926z();
        this.A02 = -9223372036854775807L;
        this.A04 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }

    private long A00() {
        if (this.A01 == -1) {
            return Long.MAX_VALUE;
        }
        AbstractC07133y.A01(this.A09);
        if (this.A01 >= this.A09.A84()) {
            return Long.MAX_VALUE;
        }
        return this.A09.A83(this.A01);
    }

    @RequiresNonNull({"subtitle"})
    @SideEffectFree
    private long A01(long j) {
        int A8a = this.A09.A8a(j);
        if (A8a != 0) {
            int nextEventTimeIndex = this.A09.A84();
            if (nextEventTimeIndex != 0) {
                String[] strArr = A0I;
                String str = strArr[6];
                String str2 = strArr[0];
                int length = str.length();
                int nextEventTimeIndex2 = str2.length();
                if (length != nextEventTimeIndex2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[2] = "dWbBH4lKinuUlTA8CpNFonpmnzuPl";
                strArr2[4] = "MDue3s6tkJ65MZJ0TxYFZvpfeIb1w";
                if (A8a == -1) {
                    C8P c8p = this.A09;
                    if (A0I[1].length() != 10) {
                        int nextEventTimeIndex3 = this.A09.A84();
                        return c8p.A83(nextEventTimeIndex3 - 1);
                    }
                    A0I[3] = "us0wUp64B7rq5nQeuQUWAOSOIfPFOl8I";
                    int nextEventTimeIndex4 = this.A09.A84();
                    return c8p.A83(nextEventTimeIndex4 - 1);
                }
                int nextEventTimeIndex5 = A8a - 1;
                return this.A09.A83(nextEventTimeIndex5);
            }
        }
        return ((AbstractC2409oz) this.A09).A01;
    }

    @SideEffectFree
    private long A02(long j) {
        boolean z = true;
        AbstractC07133y.A08(j != -9223372036854775807L);
        if (this.A04 == -9223372036854775807L) {
            z = false;
        }
        AbstractC07133y.A08(z);
        return j - this.A04;
    }

    private void A04() {
        A0B(new C2437pR(MetaExoPlayerCustomizedCollections.A01(), A02(this.A03)));
    }

    private void A05() {
        this.A0C = true;
        this.A06 = this.A0F.A5K((C2489qI) AbstractC07133y.A01(this.A05));
    }

    private void A06() {
        this.A07 = null;
        this.A01 = -1;
        if (this.A09 != null) {
            this.A09.A0B();
            this.A09 = null;
        }
        if (this.A08 != null) {
            this.A08.A0B();
            this.A08 = null;
        }
    }

    private void A07() {
        A06();
        ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).AHb();
        this.A06 = null;
        this.A00 = 0;
    }

    private void A08() {
        A07();
        A05();
    }

    private void A0A(C2437pR c2437pR) {
        this.A0G.ADa(c2437pR.A01);
        this.A0G.ADZ(c2437pR);
    }

    private void A0B(C2437pR c2437pR) {
        if (this.A0D != null) {
            this.A0D.obtainMessage(0, c2437pR).sendToTarget();
        } else {
            A0A(c2437pR);
        }
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Method to propagate any SubtitleDecoder Error upwards")
    private void A0C(ER er) {
        if (this.A0D != null) {
            this.A0D.obtainMessage(1, er).sendToTarget();
        }
    }

    private void A0D(C2221lj c2221lj) {
        AbstractC07214g.A08(A03(39, 12, 23), A03(0, 39, 112) + this.A05, c2221lj);
        A0C(new ER(this.A05, c2221lj));
        A04();
        A08();
    }

    @Override // com.instagram.common.viewpoint.core.AE
    public final void A1Z() {
        this.A05 = null;
        this.A02 = -9223372036854775807L;
        A04();
        this.A04 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
        A07();
    }

    @Override // com.instagram.common.viewpoint.core.AE
    public final void A1a(long j, boolean z) {
        this.A03 = j;
        A04();
        this.A0A = false;
        this.A0B = false;
        this.A02 = -9223372036854775807L;
        if (this.A00 != 0) {
            A08();
        } else {
            A06();
            ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).flush();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AE
    public final void A1c(C2489qI[] c2489qIArr, long j, long j2) {
        this.A04 = j2;
        this.A05 = c2489qIArr[0];
        if (this.A06 != null) {
            this.A00 = 1;
        } else {
            A05();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final boolean AAP() {
        return this.A0B;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final boolean AAe() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e8, code lost:
    
        if (r7 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ea, code lost:
    
        r9.A09.A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:
    
        r9.A01 = r6.A8a(r10);
        r9.A09 = r6;
        r9.A08 = null;
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0102, code lost:
    
        if (r7 != null) goto L51;
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void AIX(long j, long j2) {
        this.A03 = j;
        if (AAN() && this.A02 != -9223372036854775807L && j >= this.A02) {
            A06();
            this.A0B = true;
        }
        if (this.A0B) {
            return;
        }
        if (this.A08 == null) {
            ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).AJh(j);
            try {
                this.A08 = ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).A5t();
            } catch (C2221lj e) {
                A0D(e);
                return;
            }
        }
        if (A9A() != 2) {
            return;
        }
        boolean z = false;
        if (this.A09 != null) {
            long A00 = A00();
            while (A00 <= j) {
                this.A01++;
                A00 = A00();
                z = true;
            }
        }
        if (this.A08 != null) {
            C8P c8p = this.A08;
            boolean textRendererNeedsUpdate = c8p.A05();
            if (textRendererNeedsUpdate) {
                if (!z && A00() == Long.MAX_VALUE) {
                    if (this.A00 == 2) {
                        A08();
                    } else {
                        A06();
                        this.A0B = true;
                    }
                }
            } else if (((AbstractC2409oz) c8p).A01 <= j) {
                C8P c8p2 = this.A09;
                if (A0I[1].length() != 10) {
                    String[] strArr = A0I;
                    strArr[6] = "SM2l9fwyY7vSK8U9dCan";
                    strArr[0] = "PLBzRsO91bLUZoRphjDr";
                } else {
                    A0I[1] = "uDUYlaOON0";
                }
            }
        }
        if (z) {
            AbstractC07133y.A01(this.A09);
            A0B(new C2437pR(this.A09.A7X(j), A02(A01(j))));
        }
        int i = this.A00;
        if (A0I[3].charAt(23) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[6] = "ML0YoWWFYnm1pIYkMDlj";
        strArr2[0] = "WzY2c9YM67lXJGPj7nnt";
        if (i == 2) {
            return;
        }
        while (true) {
            try {
                boolean textRendererNeedsUpdate2 = this.A0A;
                if (!textRendererNeedsUpdate2) {
                    C8S c8s = this.A07;
                    if (c8s == null) {
                        c8s = ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).A5r();
                        if (c8s != null) {
                            this.A07 = c8s;
                        } else {
                            return;
                        }
                    }
                    if (this.A00 == 1) {
                        c8s.A02(4);
                        ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).AHJ(c8s);
                        this.A07 = null;
                        this.A00 = 2;
                        return;
                    }
                    int A1R = A1R(this.A0E, c8s, 0);
                    if (A1R == -4) {
                        boolean textRendererNeedsUpdate3 = c8s.A05();
                        if (textRendererNeedsUpdate3) {
                            this.A0A = true;
                            this.A0C = false;
                        } else {
                            C2489qI c2489qI = this.A0E.A00;
                            if (c2489qI != null) {
                                c8s.A00 = c2489qI.A0M;
                                c8s.A0B();
                                boolean z2 = this.A0C;
                                boolean textRendererNeedsUpdate4 = c8s.A07();
                                this.A0C = (textRendererNeedsUpdate4 ? false : true) & z2;
                            } else {
                                return;
                            }
                        }
                        boolean textRendererNeedsUpdate5 = this.A0C;
                        if (!textRendererNeedsUpdate5) {
                            ((InterfaceC2228lq) AbstractC07133y.A01(this.A06)).AHJ(c8s);
                            this.A07 = null;
                        }
                    } else if (A1R == -3) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (C2221lj e2) {
                A0D(e2);
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC08087p
    public final int AKM(C2489qI c2489qI) {
        if (this.A0F.AKN(c2489qI)) {
            return AbstractC08017i.A00(4);
        }
        if (C3J.A0E(c2489qI.A0W)) {
            return AbstractC08017i.A00(1);
        }
        return AbstractC08017i.A00(0);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo, com.instagram.common.viewpoint.core.InterfaceC08087p
    public final String getName() {
        return A03(39, 12, 23);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A0A((C2437pR) message.obj);
                return true;
            case 1:
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
