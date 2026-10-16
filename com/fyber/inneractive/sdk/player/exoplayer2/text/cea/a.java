package com.fyber.inneractive.sdk.player.exoplayer2.text.cea;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;

/* loaded from: classes4.dex */
public abstract class a {
    public static void a(long j, n nVar, r[] rVarArr) {
        int i;
        while (nVar.c - nVar.b > 1) {
            int i2 = 0;
            while (true) {
                if (nVar.c - nVar.b == 0) {
                    i = -1;
                    break;
                }
                int j2 = nVar.j();
                i2 += j2;
                if (j2 != 255) {
                    i = i2;
                    break;
                }
            }
            int i3 = 0;
            while (true) {
                if (nVar.c - nVar.b == 0) {
                    i3 = -1;
                    break;
                }
                int j3 = nVar.j();
                i3 += j3;
                if (j3 != 255) {
                    break;
                }
            }
            if (i3 != -1) {
                int i4 = nVar.c;
                int i5 = nVar.b;
                if (i3 <= i4 - i5) {
                    if (i == 4 && i3 >= 8) {
                        int j4 = nVar.j();
                        int o = nVar.o();
                        int b = nVar.b();
                        int j5 = nVar.j();
                        nVar.e(i5);
                        if (j4 == 181 && o == 49 && b == 1195456820 && j5 == 3) {
                            nVar.e(nVar.b + 8);
                            int j6 = nVar.j() & 31;
                            nVar.e(nVar.b + 1);
                            int i6 = j6 * 3;
                            int i7 = nVar.b;
                            for (r rVar : rVarArr) {
                                nVar.e(i7);
                                rVar.a(i6, nVar);
                                rVar.a(j, 1, i6, 0, null);
                            }
                            nVar.e(nVar.b + (i3 - (i6 + 10)));
                        }
                    }
                    nVar.e(nVar.b + i3);
                }
            }
            Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
            nVar.e(nVar.c);
        }
    }
}
