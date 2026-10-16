package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@MetaExoPlayerCustomization("Should be package private once we migrate to Factory pattern")
/* loaded from: assets/audience_network/classes2.dex */
public interface DD {
    void A5y();

    long A7a();

    void AAB(InterfaceC2425pF interfaceC2425pF, Uri uri, Map<String, List<String>> map, long j, long j2, HA ha) throws IOException;

    int AHM(HV hv) throws IOException;

    void AHb();

    void AJ6(long j, long j2);
}
