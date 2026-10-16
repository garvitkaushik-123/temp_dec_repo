package com.instagram.common.viewpoint.core;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class OO extends Handler {
    public static byte[] A09;
    public static String[] A0A = {"huWs6nyYMzfxZtpl5l", "fgwmKB6Qyc6FtxfQKB9IkKk97cCBhoPq", "Jv452jFQqMHbXRCew", "VJzjxvVEvnwAHRNG0UVfEBBm35lAgOcC", "2O55YLspBlua8aaDjHW6JYUsijhI69vr", "eg8WpOT66b5I3PrsSw6YGr9", "zIsMPTJraAXX1U7X8ddpQ67iDmaNCfrq", "78M1aKJi48odvK"};
    public Messenger A00;
    public InterfaceC1444Xh A01;
    public boolean A02;
    public final ServiceConnection A03;
    public final Handler A04;
    public final Messenger A05;
    public final InterfaceC1155Lt A06;
    public final C1925ge A07;
    public final AbstractRunnableC1416Wc A08;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A09 = new byte[]{-102, -83, -85, -83, -79, -66, -83, -84, 104, -80, -87, -74, -84, -69, -80, -87, -77, -83, 104, -82, -87, -79, -76, -83, -84, 116, 104, -85, -73, -84, -83, -126, 104, -116, -115, -117, -104, -119, 122, 124, -124, 122, Byte.MIN_VALUE, 126, -104, 122, -123, -117, 126, 122, 125, -110, -104, 126, -111, -126, -116, -115, -116, -104, -124, 126, -110, 0, 1, -1, Ascii.FF, -3, -18, -16, -8, -18, -12, -14, Ascii.FF, -10, -5, 0, 1, -18, -7, -7, -14, -15, Ascii.FF, -8, -14, 6, -28, -27, -29, -16, -31, -46, -44, -36, -46, -40, -42, -16, -36, -42, -22};
    }

    static {
        A06();
    }

    public OO(C1925ge c1925ge) {
        super(Looper.getMainLooper());
        this.A04 = new Handler(Looper.getMainLooper());
        this.A03 = new ON(this);
        this.A07 = c1925ge;
        this.A05 = new Messenger(this);
        InterfaceC1159Lx funnelModule = c1925ge.A00(c1925ge);
        if (funnelModule != null) {
            this.A06 = funnelModule.ACM();
        } else {
            this.A06 = new C2149kX();
        }
        this.A08 = new C2029iO(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(Messenger messenger) {
        Message obtain = Message.obtain((Handler) null, 1);
        obtain.replyTo = this.A05;
        obtain.setData(OX.A00(this.A07));
        try {
            messenger.send(obtain);
        } catch (RemoteException unused) {
        }
    }

    public final void A09() {
        if (this.A02) {
            this.A02 = false;
            this.A07.unbindService(this.A03);
            this.A00 = null;
        }
    }

    public final void A0A(String str, InterfaceC1444Xh interfaceC1444Xh, int i) {
        if (this.A02) {
            this.A06.AIN(i);
            this.A01 = interfaceC1444Xh;
            Message obtain = Message.obtain((Handler) null, i);
            obtain.replyTo = this.A05;
            if (str != null) {
                Bundle bundle = new Bundle();
                bundle.putString(A05(88, 15, 88), str);
                obtain.setData(bundle);
            }
            try {
                if (this.A00 != null) {
                    this.A00.send(obtain);
                    return;
                }
                return;
            } catch (RemoteException e) {
                this.A06.AIO(e.toString());
                return;
            }
        }
        InterfaceC1155Lt interfaceC1155Lt = this.A06;
        if (A0A[3].charAt(16) != '0') {
            throw new RuntimeException();
        }
        A0A[1] = "UrwnsONYHFKEsBm1tj1C3JCQoMa7O9rm";
        interfaceC1155Lt.AIP();
    }

    public final void A0B(boolean z) {
        this.A06.AIK();
        this.A02 = OM.A04(this.A07, z, this.A03);
        if (this.A02) {
            Messenger messenger = this.A00;
            if (A0A[2].length() != 17) {
                throw new RuntimeException();
            }
            A0A[6] = "P62SHD49IwhaYJMd1yj6mhn8O1XS0mYq";
            if (messenger == null) {
                this.A04.postDelayed(this.A08, AbstractC1382Us.A01(this.A07));
                return;
            }
            return;
        }
        U5.A05(this.A07);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (message.what == 2) {
                OM.A02(this.A07, message);
                this.A06.AIJ();
                return;
            }
            if (message.what == 20 || message.what == 40 || message.what == 30) {
                this.A06.AIL(message.what);
                if (message.what == 20) {
                    AbstractC1382Us.A07(this.A07);
                }
                String str = A05(0, 33, 15) + message.what;
                U5.A05(this.A07);
                return;
            }
            if (message.what == 4) {
                this.A06.AIM();
                Bundle data = message.getData();
                if (this.A01 != null) {
                    boolean z = data.getBoolean(A05(33, 30, 0), false);
                    String A05 = A05(88, 15, 88);
                    if (A0A[3].charAt(16) != '0') {
                        throw new RuntimeException();
                    }
                    A0A[0] = "zzNr3SVv6qtYyPyvWR";
                    if (z) {
                        this.A01.AF5(data.getString(A05));
                    } else if (data.getBoolean(A05(63, 25, 116), false)) {
                        this.A01.AF6(data.getString(A05));
                    }
                }
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
