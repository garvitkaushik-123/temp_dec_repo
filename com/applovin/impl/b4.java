package com.applovin.impl;

import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;

/* loaded from: classes2.dex */
public interface b4 {
    c4 getAdEventTracker();

    String getOpenMeasurementContentUrl();

    String getOpenMeasurementCustomReferenceData();

    List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources();

    boolean isOpenMeasurementEnabled();
}
