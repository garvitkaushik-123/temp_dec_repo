package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/video/framebasedlogging/FrameBasedLogger;", "", "videoId", "", "<init>", "(Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "videoFrameBuffer", "Ljava/util/concurrent/BlockingDeque;", "Lcom/facebook/video/framebasedlogging/VideoFrameInfo;", "getVideoFrameBuffer$annotations", "()V", "addVideoFrameToBuffer", "", "frame", "videoFramesAndEmptyBuffer", "", "getVideoFramesAndEmptyBuffer", "()Ljava/util/List;", "Companion", "fbandroid.java.com.facebook.video.framebasedlogging.framebasedlogging_an"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.iS, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2033iS {
    public static byte[] A02;
    public static String[] A03 = {"nvoCYT5lXV50ozFrdUrQJCA6z0GvB", "", "jdLKha1Na7nbzs0Nk4YLOHAcdwecuvvy", VastAttributes.HORIZONTAL_POSITION, "dSWVRlyTiHf7svvh2WPzEDVR9b7sv5FM", "fWYFOffN0cZPNc3vcPN7ReiBLy1A48b", "e5JjNsryHusTZGAVeTKu2QwvoQvLupoE", "SBHDzKPIpiPnF71bMjezo2z0"};
    public static final C2032iR A04;
    public final String A00;
    public final BlockingDeque<C2034iT> A01 = new LinkedBlockingDeque();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{Ascii.US, Ascii.VT, Ascii.CAN, Ascii.DC4, Ascii.FS};
    }

    static {
        A02();
        A04 = new C2032iR(null);
    }

    public C2033iS(String str) {
        this.A00 = str;
    }

    @JvmStatic
    public static final String A01(List<C2034iT> list) {
        return A04.A0A(list);
    }

    public final List<C2034iT> A03() {
        List frames = new ArrayList();
        this.A01.drainTo(frames);
        return frames;
    }

    public final void A04(C2034iT c2034iT) {
        C2503qY.A09(c2034iT, A00(0, 5, 47));
        C2034iT peekLast = this.A01.peekLast();
        if (peekLast != null) {
            long a03 = peekLast.getA03();
            long a032 = c2034iT.getA03();
            if (A03[4].charAt(10) == 'f') {
                A03[1] = "";
                if (a03 == a032 && peekLast.getA01() == c2034iT.getA01()) {
                    return;
                }
            }
            throw new RuntimeException();
        }
        this.A01.add(c2034iT);
        if (A03[4].charAt(10) == 'f') {
            A03[0] = "kleFc3GTYdmSeGzzaJMmIvt997RVj";
            return;
        }
        throw new RuntimeException();
    }
}
