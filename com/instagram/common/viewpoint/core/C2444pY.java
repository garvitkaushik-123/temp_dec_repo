package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.ads.androidx.media3.common.Tracks;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.pY, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2444pY implements AnonymousClass24 {

    @MetaExoPlayerCustomization("Remove Immutable List for Oculus")
    public final List<C2445pZ> A00;
    public static String[] A01 = {"0eRTZm", "wsJdmo7HTY", "VHUY43wJh5fnSZ3wEvYR5lxV3yQqNNMU", "k8", "kUjTCgoRRteoZ0", "6rJamNQt6U89KJOuF", "xAstRHAahUkfHwQSYEnj0qzfqp", "GuXFY9846UfmIsqOXXuGkg4YoPfa8R1b"};
    public static final C2444pY A03 = new C2444pY(new ArrayList());
    public static final String A04 = C5C.A0h(0);
    public static final AnonymousClass23<C2444pY> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pb
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2444pY.A00(bundle);
        }
    };

    public C2444pY(List<C2445pZ> list) {
        this.A00 = MetaExoPlayerCustomizedCollections.A03((C2445pZ[]) list.toArray(new C2445pZ[0]));
    }

    public static /* synthetic */ C2444pY A00(Bundle bundle) {
        List<Tracks.Group> groups;
        List<Tracks.Group> groups2 = bundle.getParcelableArrayList(A04);
        if (groups2 == null) {
            groups = Collections.emptyList();
        } else {
            groups = AnonymousClass44.A01(C2445pZ.A05, groups2);
        }
        return new C2444pY(groups);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.A00.equals(((C2444pY) obj).A00);
        }
        String[] strArr = A01;
        if (strArr[2].charAt(26) == strArr[7].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "oFMxQz";
        strArr2[3] = "4E";
        return false;
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }
}
