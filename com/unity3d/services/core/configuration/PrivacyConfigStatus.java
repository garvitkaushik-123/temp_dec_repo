package com.unity3d.services.core.configuration;

/* loaded from: classes7.dex */
public enum PrivacyConfigStatus {
    UNKNOWN,
    ALLOWED,
    DENIED;

    public String toLowerCase() {
        return name().toLowerCase();
    }
}
