package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import com.explorestack.protobuf.Struct;

/* loaded from: classes7.dex */
public interface NetworkParams {
    Struct getExt(Context context);

    String getNetworkKey();

    String getNetworkName();
}
