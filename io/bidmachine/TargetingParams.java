package io.bidmachine;

import android.location.Location;
import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.models.ITargetingParams;
import io.bidmachine.models.RequestParams;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.utils.Gender;
import io.bidmachine.utils.ProtoUtils;
import java.util.List;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class TargetingParams extends RequestParams<TargetingParams> implements ITargetingParams<TargetingParams> {
    static final String DATA_ID_EXTERNAL_USER_ID = "external_user_ids";
    private Integer birthdayYear;
    private BlockedParams blockedParams;
    private String city;
    private String country;
    private Location deviceLocation;
    private List<ExternalUserId> externalUserIdList;
    private String framework;
    private Gender gender;
    private Boolean isPaid;
    private String[] keywords;
    private String storeCategory;
    private String[] storeSubCategories;
    private String storeUrl;
    private String userId;
    private String zip;

    @Override // io.bidmachine.models.ITargetingParams
    public /* bridge */ /* synthetic */ TargetingParams setExternalUserIds(List externalUserIdList) {
        return setExternalUserIds((List<ExternalUserId>) externalUserIdList);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setBirthdayYear(Integer birthdayYear) {
        if (birthdayYear == null || Utils.isYearValid(birthdayYear.intValue())) {
            this.birthdayYear = birthdayYear;
            return this;
        }
        Logger.e("Birthday Year should be 4-digit integer, more or equal 1900 and less or equal than current year");
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setKeywords(String... keywords) {
        this.keywords = keywords;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setDeviceLocation(Location location) {
        this.deviceLocation = location;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setCountry(String country) {
        this.country = country;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setCity(String city) {
        this.city = city;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setZip(String zip) {
        this.zip = zip;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreUrl(String url) {
        this.storeUrl = url;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setStoreSubCategories(String... storeSubCategories) {
        this.storeSubCategories = storeSubCategories;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setFramework(String framework) {
        this.framework = framework;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setPaid(Boolean paid) {
        this.isPaid = paid;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ITargetingParams
    public TargetingParams setExternalUserIds(List<ExternalUserId> externalUserIdList) {
        this.externalUserIdList = externalUserIdList;
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedApplication(String bundleOrPackage) {
        prepareBlockParams();
        this.blockedParams.addBlockedApplication(bundleOrPackage);
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedAdvertiserIABCategory(String category) {
        prepareBlockParams();
        this.blockedParams.addBlockedAdvertiserIABCategory(category);
        return this;
    }

    @Override // io.bidmachine.models.IBlockedParams
    public TargetingParams addBlockedAdvertiserDomain(String domain) {
        prepareBlockParams();
        this.blockedParams.addBlockedAdvertiserDomain(domain);
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(TargetingParams instance) {
        this.userId = (String) Utils.oneOf(this.userId, instance.userId);
        this.gender = (Gender) Utils.oneOf(this.gender, instance.gender);
        this.birthdayYear = (Integer) Utils.oneOf(this.birthdayYear, instance.birthdayYear);
        this.keywords = (String[]) Utils.oneOf(this.keywords, instance.keywords);
        this.country = (String) Utils.oneOf(this.country, instance.country);
        this.city = (String) Utils.oneOf(this.city, instance.city);
        this.zip = (String) Utils.oneOf(this.zip, instance.zip);
        this.deviceLocation = (Location) Utils.oneOf(this.deviceLocation, instance.deviceLocation);
        this.storeUrl = (String) Utils.oneOf(this.storeUrl, instance.storeUrl);
        this.storeCategory = (String) Utils.oneOf(this.storeCategory, instance.storeCategory);
        this.storeSubCategories = (String[]) Utils.oneOf(this.storeSubCategories, instance.storeSubCategories);
        this.framework = (String) Utils.oneOf(this.framework, instance.framework);
        this.isPaid = (Boolean) Utils.oneOf(this.isPaid, instance.isPaid);
        this.externalUserIdList = (List) Utils.oneOf(this.externalUserIdList, instance.externalUserIdList);
        if (instance.blockedParams != null) {
            if (this.blockedParams == null) {
                this.blockedParams = new BlockedParams();
            }
            this.blockedParams.merge(instance.blockedParams);
        }
    }

    void build(Context.App.Builder builder) {
        String str = this.storeUrl;
        if (str != null) {
            builder.setStoreurl(str);
        }
        Boolean bool = this.isPaid;
        builder.setPaid(bool != null && bool.booleanValue());
    }

    void fillAppExtension(final App.Builder builder) {
        String str = this.storeCategory;
        Objects.requireNonNull(builder);
        Utils.ifNotNull(str, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                App.Builder.this.setStorecat((String) obj);
            }
        });
        Utils.ifNotNull(this.storeSubCategories, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                TargetingParams.lambda$fillAppExtension$0(App.Builder.this, (String[]) obj);
            }
        });
        String str2 = this.framework;
        Objects.requireNonNull(builder);
        Utils.ifNotNull(str2, new Executable() { // from class: io.bidmachine.TargetingParams$$ExternalSyntheticLambda2
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                App.Builder.this.setFmwname((String) obj);
            }
        });
    }

    static /* synthetic */ void lambda$fillAppExtension$0(App.Builder builder, String[] strArr) {
        for (String str : strArr) {
            builder.addStoresubcat(str);
        }
    }

    void build(Context.User.Builder builder) {
        String str = this.userId;
        if (str != null) {
            builder.setId(str);
        }
        Integer num = this.birthdayYear;
        if (num != null) {
            builder.setYob(num.intValue());
        }
        Gender gender = this.gender;
        if (gender != null) {
            builder.setGender(gender.getOrtbValue());
        }
        String[] strArr = this.keywords;
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : this.keywords) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            builder.setKeywords(sb.toString());
        }
        Context.Geo.Builder newBuilder = Context.Geo.newBuilder();
        build(newBuilder);
        ProtoUtils.fillGeoBuilder(newBuilder, null, false);
        builder.setGeo(newBuilder);
        List<ExternalUserId> list = this.externalUserIdList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Context.Data.Builder id = Context.Data.newBuilder().setId(DATA_ID_EXTERNAL_USER_ID);
        for (ExternalUserId externalUserId : this.externalUserIdList) {
            String sourceId = externalUserId.getSourceId();
            String value = externalUserId.getValue();
            if (!TextUtils.isEmpty(sourceId) && !TextUtils.isEmpty(value)) {
                id.addSegment(Context.Data.Segment.newBuilder().setId(sourceId).setValue(value));
            }
        }
        builder.addData(id);
    }

    void build(Context.Geo.Builder builder) {
        String str = this.country;
        if (str != null) {
            builder.setCountry(str);
        }
        String str2 = this.city;
        if (str2 != null) {
            builder.setCity(str2);
        }
        String str3 = this.zip;
        if (str3 != null) {
            builder.setZip(str3);
        }
    }

    BlockedParams getBlockedParams() {
        return this.blockedParams;
    }

    String getUserId() {
        return this.userId;
    }

    Gender getGender() {
        return this.gender;
    }

    Integer getBirthdayYear() {
        return this.birthdayYear;
    }

    String[] getKeywords() {
        return this.keywords;
    }

    Location getDeviceLocation() {
        return this.deviceLocation;
    }

    String getCountry() {
        return this.country;
    }

    String getCity() {
        return this.city;
    }

    String getZip() {
        return this.zip;
    }

    String getStoreUrl() {
        return this.storeUrl;
    }

    String getStoreCategory() {
        return this.storeCategory;
    }

    String[] getStoreSubCategories() {
        return this.storeSubCategories;
    }

    String getFramework() {
        return this.framework;
    }

    Boolean getPaid() {
        return this.isPaid;
    }

    List<ExternalUserId> getExternalUserIdList() {
        return this.externalUserIdList;
    }

    private void prepareBlockParams() {
        if (this.blockedParams == null) {
            this.blockedParams = new BlockedParams();
        }
    }
}
