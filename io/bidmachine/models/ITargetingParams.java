package io.bidmachine.models;

import android.location.Location;
import io.bidmachine.ExternalUserId;
import io.bidmachine.utils.Gender;
import java.util.List;

/* loaded from: classes7.dex */
public interface ITargetingParams<SelfType> extends IBlockedParams<SelfType> {
    SelfType setBirthdayYear(Integer birthdayYear);

    SelfType setCity(String city);

    SelfType setCountry(String country);

    SelfType setDeviceLocation(Location location);

    SelfType setExternalUserIds(List<ExternalUserId> externalUserIdList);

    SelfType setFramework(String framework);

    SelfType setGender(Gender gender);

    SelfType setKeywords(String... keywords);

    SelfType setPaid(Boolean paid);

    SelfType setStoreCategory(String storeCategory);

    SelfType setStoreSubCategories(String... storeSubCategories);

    SelfType setStoreUrl(String url);

    SelfType setUserId(String userId);

    SelfType setZip(String zip);
}
