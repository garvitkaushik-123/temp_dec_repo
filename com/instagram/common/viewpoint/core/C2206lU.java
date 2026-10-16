package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.lU, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2206lU implements H9 {
    public static String[] A03 = {"MPtFkEiIPrQJk6C68eapJqoHhp6zbLCW", "P1eCuU1JvuL46IL3Xh4EOSVLMCcJCOjT", "W4WpROs4sm5j6Tf0ztR0Y16lEj4WGQ", "4wLB1kD6U2fJ8LvWKaQYimBngFnzynrL", "j1g6H1G7HHWswscQmxGermXRDRDROF5f", "vYNShvJ8K3s57yIlGqGLfJHMZKUSU02I", "LyEFdcIU17ooQUQ0BZMXWJLXZvdofmIX", "P7XGal"};
    public static final HD A04 = new HD() { // from class: com.facebook.ads.redexgen.X.lV
        @Override // com.instagram.common.viewpoint.core.HD
        public final H9[] A5N() {
            return C2206lU.A00();
        }

        @Override // com.instagram.common.viewpoint.core.HD
        public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
            return HC.A01(this, uri, map);
        }
    };
    public boolean A00;
    public final C2205lT A02 = new C2205lT();
    public final C07364v A01 = new C07364v(16384);

    public static /* synthetic */ H9[] A00() {
        return new H9[]{new C2206lU()};
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AAC(HA ha) {
        this.A02.A5c(ha, new LG(0, 1));
        ha.A6O();
        ha.AJ7(new C2275mn(-9223372036854775807L));
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final int AHL(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        int read = interfaceC2280ms.read(this.A01.A0l(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.A01.A0f(0);
        this.A01.A0e(read);
        if (!this.A00) {
            this.A02.AGq(0L, 4);
            this.A00 = true;
        }
        this.A02.A5A(this.A01);
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AHb() {
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AJ6(long j, long j2) {
        this.A00 = false;
        this.A02.AJ5();
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final boolean AK5(InterfaceC2280ms interfaceC2280ms) throws IOException {
        C07364v c07364v = new C07364v(10);
        int length = 0;
        while (true) {
            byte[] A0l = c07364v.A0l();
            if (A03[3].charAt(10) != 'f') {
                throw new RuntimeException();
            }
            A03[3] = "dKI30oOFAvfBQiacazr45UFgS6k9aj5a";
            interfaceC2280ms.AGt(A0l, 0, 10);
            c07364v.A0f(0);
            if (c07364v.A0K() != 4801587) {
                interfaceC2280ms.AIl();
                interfaceC2280ms.A47(length);
                int i = length;
                int syncBytes = 0;
                while (true) {
                    interfaceC2280ms.AGt(c07364v.A0l(), 0, 7);
                    c07364v.A0f(0);
                    int headerPosition = c07364v.A0M();
                    if (headerPosition != 44096 && headerPosition != 44097) {
                        syncBytes = 0;
                        interfaceC2280ms.AIl();
                        i++;
                        if (i - length >= 8192) {
                            return false;
                        }
                        interfaceC2280ms.A47(i);
                    } else {
                        syncBytes++;
                        if (syncBytes >= 4) {
                            return true;
                        }
                        int headerPosition2 = AbstractC1027Gu.A02(c07364v.A0l(), headerPosition);
                        if (headerPosition2 == -1) {
                            return false;
                        }
                        interfaceC2280ms.A47(headerPosition2 - 7);
                    }
                }
            } else {
                c07364v.A0g(3);
                int A0H = c07364v.A0H();
                length += A0H + 10;
                interfaceC2280ms.A47(A0H);
            }
        }
    }
}
