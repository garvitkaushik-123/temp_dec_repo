package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.9v, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9v implements InterfaceC2338np, InterfaceC2339nq {
    public static String[] A06 = {"JXRw8dEnvO1Lr4g7cFUS0dvQrSj2gCrD", "hvHNuBxl", "xmWilmV3z2eIIj1", "UUtHfwhImwRJiupXWlBcpFq10hKf2hZ3", "Gjwbiw3zcCnfnivX0C6Z4KLegMayRhyW", "PFLAFIzQgEofbdrT2htWxpP7W2gVOOgi", "405rypbMY6P", "HWuA8Rz9jBHRgd5bymvhijPSyV36G6mN"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC2339nq A03;
    public C2342nt[] A04 = new C2342nt[0];
    public final InterfaceC2338np A05;

    public C9v(InterfaceC2338np interfaceC2338np, boolean z, long j, long j2) {
        this.A05 = interfaceC2338np;
        this.A02 = z ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j2;
    }

    private C08137u A00(long j, C08137u c08137u) {
        long toleranceBeforeUs = C5C.A0T(c08137u.A01, 0L, j - this.A01);
        long A0T = C5C.A0T(c08137u.A00, 0L, this.A00 == Long.MIN_VALUE ? Long.MAX_VALUE : this.A00 - j);
        if (toleranceBeforeUs == c08137u.A01) {
            long j2 = c08137u.A00;
            if (A06[6].length() != 11) {
                throw new RuntimeException();
            }
            A06[0] = "SySHx2FlEzism2SEaRZKk1Ki9OIwKCgL";
            if (A0T == j2) {
                return c08137u;
            }
        }
        return new C08137u(toleranceBeforeUs, A0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.DW
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void ADV(InterfaceC2338np interfaceC2338np) {
        ((InterfaceC2339nq) AbstractC07133y.A01(this.A03)).ADV(this);
    }

    public static boolean A02(long j, InterfaceC2301nE[] interfaceC2301nEArr) {
        if (j != 0) {
            for (InterfaceC2301nE interfaceC2301nE : interfaceC2301nEArr) {
                if (interfaceC2301nE != null) {
                    C2489qI A92 = interfaceC2301nE.A92();
                    if (!C3J.A0G(A92.A0W, A92.A0R)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.instagram.common.viewpoint.core.DX
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4s(long j) {
        this.A05.A4s(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final boolean A5C(long j) {
        return this.A05.A5C(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final void A60(long j, boolean z) {
        this.A05.A60(j, z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final long A6r(long j, C08137u c08137u) {
        if (j == this.A01) {
            return this.A01;
        }
        return this.A05.A6r(j, A00(j, c08137u));
    }

    @Override // com.instagram.common.viewpoint.core.DX
    @MetaExoPlayerCustomization("Added in D9949576 for unstall buffer")
    public final long A76(long j) {
        return this.A05.A76(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final long A78() {
        long A78 = this.A05.A78();
        if (A78 == Long.MIN_VALUE || (this.A00 != Long.MIN_VALUE && A78 >= this.A00)) {
            return Long.MIN_VALUE;
        }
        return A78;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final long A8b() {
        long A8b = this.A05.A8b();
        if (A8b != Long.MIN_VALUE) {
            long nextLoadPositionUs = this.A00;
            if (A06[0].charAt(29) != 'C') {
                throw new RuntimeException();
            }
            A06[0] = "QBPPyRyowan8CCGBQiXIHMf03VOUOCSC";
            if (nextLoadPositionUs == Long.MIN_VALUE || A8b < this.A00) {
                return A8b;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final C2319nW A9M() {
        return this.A05.A9M();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final void ACS() throws IOException {
        if (0 == 0) {
            this.A05.ACS();
            return;
        }
        throw null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2339nq
    public final void AFS(InterfaceC2338np interfaceC2338np) {
        if (0 != 0) {
            return;
        }
        ((InterfaceC2339nq) AbstractC07133y.A01(this.A03)).AFS(this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final void AH5(InterfaceC2339nq interfaceC2339nq, long j) {
        this.A03 = interfaceC2339nq;
        this.A05.AH5(this, j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final long AHQ() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            this.A02 = -9223372036854775807L;
            long AHQ = AHQ();
            return AHQ != -9223372036854775807L ? AHQ : childDiscontinuityUs;
        }
        InterfaceC2338np interfaceC2338np = this.A05;
        if (A06[2].length() == 0) {
            throw new RuntimeException();
        }
        A06[6] = "ABWUoGiNBoa";
        long AHQ2 = interfaceC2338np.AHQ();
        if (AHQ2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long discontinuityUs = this.A01;
        boolean z = true;
        AbstractC07133y.A08(AHQ2 >= discontinuityUs);
        if (this.A00 != Long.MIN_VALUE) {
            long discontinuityUs2 = this.A00;
            if (AHQ2 > discontinuityUs2) {
                z = false;
            }
        }
        AbstractC07133y.A08(z);
        return AHQ2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final void AHW(long j) {
        this.A05.AHW(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    public final long AJ8(@MetaExoPlayerCustomization long j, boolean z) {
        this.A02 = -9223372036854775807L;
        boolean z2 = false;
        for (C2342nt c2342nt : this.A04) {
            if (c2342nt != null) {
                c2342nt.A00();
            }
        }
        long AJ8 = this.A05.AJ8(j, z);
        if (AJ8 == j || (AJ8 >= this.A01 && (this.A00 == Long.MIN_VALUE || AJ8 <= this.A00))) {
            z2 = true;
        }
        AbstractC07133y.A08(z2);
        return AJ8;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2338np
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AJ9(InterfaceC2301nE[] interfaceC2301nEArr, boolean[] zArr, DT[] dtArr, boolean[] zArr2, long j) {
        long j2;
        int i;
        this.A04 = new C2342nt[dtArr.length];
        DT[] dtArr2 = new DT[dtArr.length];
        int i2 = 0;
        while (true) {
            DT dt = null;
            if (i2 >= dtArr.length) {
                break;
            }
            this.A04[i2] = (C2342nt) dtArr[i2];
            DT[] childStreams = this.A04;
            if (childStreams[i2] != null) {
                dt = this.A04[i2].A01;
            }
            dtArr2[i2] = dt;
            i2++;
        }
        long AJ9 = this.A05.AJ9(interfaceC2301nEArr, zArr, dtArr2, zArr2, j);
        if (A03() && j == this.A01) {
            long j3 = this.A01;
            String[] strArr = A06;
            if (strArr[4].charAt(5) == strArr[3].charAt(5)) {
                String[] strArr2 = A06;
                strArr2[7] = "en1LL2zHQFU7eKPWWtw7tqDicZnmZ9l5";
                strArr2[5] = "t66o2OzEfyctLQHjRBlZ897u0IFgDWGZ";
                if (A02(j3, interfaceC2301nEArr)) {
                    j2 = AJ9;
                    this.A02 = j2;
                    AbstractC07133y.A08(AJ9 != j || (AJ9 >= this.A01 && (this.A00 == Long.MIN_VALUE || AJ9 <= this.A00)));
                    i = 0;
                    while (true) {
                        int length = dtArr.length;
                        if (A06[1].length() == 30) {
                            String[] strArr3 = A06;
                            strArr3[7] = "DNi9UWzwfCWyYPkB4uGGg0YkPCShAQe6";
                            strArr3[5] = "fAixbEz1F3G47KA6JLUGcT01MO1ZofiJ";
                            if (i >= length) {
                                break;
                            }
                            if (dtArr2[i] != null) {
                                C2342nt[] c2342ntArr = this.A04;
                                String[] strArr4 = A06;
                                if (strArr4[4].charAt(5) != strArr4[3].charAt(5)) {
                                    break;
                                }
                                A06[6] = "ocXNdzhjsFv";
                                c2342ntArr[i] = null;
                            } else {
                                DT[] childStreams2 = this.A04;
                                if (childStreams2[i] != null) {
                                    DT dt2 = this.A04[i].A01;
                                    DT dt3 = dtArr2[i];
                                    if (A06[1].length() != 30) {
                                        String[] strArr5 = A06;
                                        strArr5[4] = "cYzDBwspbZ8a8DM9Dz10VjvDatAoG4Oi";
                                        strArr5[3] = "WIkG6wjldaaFwlHYCP34A8xHiCA5NCte";
                                        if (dt2 == dt3) {
                                        }
                                    } else if (dt2 == dt3) {
                                    }
                                }
                                this.A04[i] = new C2342nt(this, dtArr2[i]);
                            }
                            DT[] childStreams3 = this.A04;
                            dtArr[i] = childStreams3[i];
                            i++;
                        } else {
                            if (i >= length) {
                                break;
                            }
                            if (dtArr2[i] != null) {
                            }
                            DT[] childStreams32 = this.A04;
                            dtArr[i] = childStreams32[i];
                            i++;
                        }
                    }
                    return AJ9;
                }
            }
            throw new RuntimeException();
        }
        j2 = -9223372036854775807L;
        this.A02 = j2;
        AbstractC07133y.A08(AJ9 != j || (AJ9 >= this.A01 && (this.A00 == Long.MIN_VALUE || AJ9 <= this.A00)));
        i = 0;
        while (true) {
            int length2 = dtArr.length;
            if (A06[1].length() == 30) {
            }
            DT[] childStreams322 = this.A04;
            dtArr[i] = childStreams322[i];
            i++;
        }
        return AJ9;
    }

    @Override // com.instagram.common.viewpoint.core.DX
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AJc(boolean z) {
        this.A05.AJc(z);
    }

    @Override // com.instagram.common.viewpoint.core.DX
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AKb(byte b) {
        this.A05.AKb(b);
    }
}
