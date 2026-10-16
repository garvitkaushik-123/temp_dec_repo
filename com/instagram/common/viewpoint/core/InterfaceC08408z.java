package com.instagram.common.viewpoint.core;

import android.media.AudioDeviceInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.nio.ByteBuffer;

/* renamed from: com.facebook.ads.redexgen.X.8z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC08408z {
    void A59(C2489qI c2489qI, int i, int[] iArr) throws C08358s;

    void A5z();

    void A6M();

    void A6T();

    long A7f(boolean z);

    C2468px A8m();

    boolean A9e(ByteBuffer byteBuffer, long j, int i) throws C08368t, C08398y;

    void A9h();

    boolean A9o();

    boolean AAP();

    void AH0();

    void AH2() throws C08398y;

    void AJG(C2495qQ c2495qQ);

    void AJH(int i);

    void AJI(AnonymousClass21 anonymousClass21);

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Enable Retry Audio Track")
    void AJQ(boolean z);

    void AJV(InterfaceC08378v interfaceC08378v);

    void AJd(C2468px c2468px);

    void AJg(C8O c8o);

    void AJi(AudioDeviceInfo audioDeviceInfo);

    void AJo(boolean z);

    boolean AKN(C2489qI c2489qI);

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old API that can be removed when we move to MediaCodecRenderer2")
    boolean AKP(int i, int i2);

    void flush();

    void pause();

    void setVolume(float f);
}
