package io.bidmachine.models;

/* loaded from: classes7.dex */
public interface IBlockedParams<SelfType> {
    SelfType addBlockedAdvertiserDomain(String domain);

    SelfType addBlockedAdvertiserIABCategory(String category);

    SelfType addBlockedApplication(String bundleOrPackage);
}
