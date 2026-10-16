package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public interface HD {
    public static final HD A00 = new HD() { // from class: com.facebook.ads.redexgen.X.mq
        @Override // com.instagram.common.viewpoint.core.HD
        public final H9[] A5N() {
            return HC.A00();
        }

        @Override // com.instagram.common.viewpoint.core.HD
        public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
            return HC.A01(this, uri, map);
        }
    };

    H9[] A5N();

    H9[] A5O(Uri uri, Map<String, List<String>> map);
}
