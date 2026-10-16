package io.bidmachine;

import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.models.IBlockedParams;
import io.bidmachine.models.RequestParams;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public final class BlockedParams extends RequestParams<BlockedParams> implements IBlockedParams<BlockedParams> {
    private Set<String> blockedApplications;
    private Set<String> blockedCategories;
    private Set<String> blockedDomains;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedAdvertiserDomain(String domain) {
        if (this.blockedDomains == null) {
            this.blockedDomains = new HashSet();
        }
        this.blockedDomains.add(domain);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedAdvertiserIABCategory(String category) {
        if (this.blockedCategories == null) {
            this.blockedCategories = new HashSet();
        }
        this.blockedCategories.add(category);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedApplication(String bundleOrPackage) {
        if (this.blockedApplications == null) {
            this.blockedApplications = new HashSet();
        }
        this.blockedApplications.add(bundleOrPackage);
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(BlockedParams instance) {
        this.blockedDomains = updateList(instance.blockedDomains, this.blockedDomains);
        this.blockedCategories = updateList(instance.blockedCategories, this.blockedCategories);
        this.blockedApplications = updateList(instance.blockedApplications, this.blockedApplications);
    }

    void build(Context.Restrictions.Builder builder) {
        Set<String> set = this.blockedDomains;
        if (set != null) {
            builder.addAllBadv(set);
        }
        Set<String> set2 = this.blockedCategories;
        if (set2 != null) {
            builder.addAllBcat(set2);
        }
        Set<String> set3 = this.blockedApplications;
        if (set3 != null) {
            builder.addAllBapp(set3);
        }
    }

    private <T> Set<T> updateList(Set<T> input, Set<T> output) {
        if (input != null) {
            if (output == null) {
                return new HashSet(input);
            }
            output.addAll(input);
        }
        return output;
    }
}
