package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.Map;

/* renamed from: com.inmobi.media.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC2930x {
    void a(byte b, Map map);

    void b();

    boolean c();

    void e();

    AdConfig getAdConfig();

    String getAdType();

    String getCreativeId();

    Object getDataModel();

    InterfaceC2914w getFullScreenEventsListener();

    String getImpressionId();

    String getMarkupType();

    byte getPlacementType();

    View getVideoContainerView();

    Xe getViewableAd();

    void setFullScreenActivityContext(Activity activity);
}
