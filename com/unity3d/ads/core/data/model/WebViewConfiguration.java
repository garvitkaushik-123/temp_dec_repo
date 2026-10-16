package com.unity3d.ads.core.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebViewConfiguration.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/unity3d/ads/core/data/model/WebViewConfiguration;", "", "version", "", "entryPoint", "", "additionalFiles", "", "type", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAdditionalFiles", "()Ljava/util/List;", "getEntryPoint", "()Ljava/lang/String;", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class WebViewConfiguration {
    private final List<String> additionalFiles;
    private final String entryPoint;
    private final String type;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewConfiguration copy$default(WebViewConfiguration webViewConfiguration, int i, String str, List list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = webViewConfiguration.version;
        }
        if ((i2 & 2) != 0) {
            str = webViewConfiguration.entryPoint;
        }
        if ((i2 & 4) != 0) {
            list = webViewConfiguration.additionalFiles;
        }
        if ((i2 & 8) != 0) {
            str2 = webViewConfiguration.type;
        }
        return webViewConfiguration.copy(i, str, list, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final List<String> component3() {
        return this.additionalFiles;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final WebViewConfiguration copy(int version, String entryPoint, List<String> additionalFiles, String type) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Intrinsics.checkNotNullParameter(additionalFiles, "additionalFiles");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WebViewConfiguration(version, entryPoint, additionalFiles, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewConfiguration)) {
            return false;
        }
        WebViewConfiguration webViewConfiguration = (WebViewConfiguration) other;
        return this.version == webViewConfiguration.version && Intrinsics.areEqual(this.entryPoint, webViewConfiguration.entryPoint) && Intrinsics.areEqual(this.additionalFiles, webViewConfiguration.additionalFiles) && Intrinsics.areEqual(this.type, webViewConfiguration.type);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.version) * 31) + this.entryPoint.hashCode()) * 31) + this.additionalFiles.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "WebViewConfiguration(version=" + this.version + ", entryPoint=" + this.entryPoint + ", additionalFiles=" + this.additionalFiles + ", type=" + this.type + ')';
    }

    public WebViewConfiguration(int i, String entryPoint, List<String> additionalFiles, String type) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        Intrinsics.checkNotNullParameter(additionalFiles, "additionalFiles");
        Intrinsics.checkNotNullParameter(type, "type");
        this.version = i;
        this.entryPoint = entryPoint;
        this.additionalFiles = additionalFiles;
        this.type = type;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final List<String> getAdditionalFiles() {
        return this.additionalFiles;
    }

    public final String getType() {
        return this.type;
    }
}
