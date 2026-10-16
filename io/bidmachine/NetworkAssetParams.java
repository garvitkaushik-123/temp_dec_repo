package io.bidmachine;

/* loaded from: classes7.dex */
class NetworkAssetParams {
    private final String adapterVersion;
    private final String classpath;
    private final String name;
    private final String sdkVersion;

    public NetworkAssetParams(String name, String adapterVersion, String classpath, String sdkVersion) {
        this.name = name;
        this.adapterVersion = adapterVersion;
        this.classpath = classpath;
        this.sdkVersion = sdkVersion;
    }

    public String getName() {
        return this.name;
    }

    public String getAdapterVersion() {
        return this.adapterVersion;
    }

    public String getClasspath() {
        return this.classpath;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }
}
