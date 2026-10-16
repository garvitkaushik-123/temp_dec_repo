package com.sourcepoint.cmplibrary.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConsentReq.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/CustomConsentReq;", "", "consentUUID", "", "propertyId", "", "vendors", "", "categories", "legIntCategories", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getConsentUUID", "()Ljava/lang/String;", "getLegIntCategories", "getPropertyId", "()I", "getVendors", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CustomConsentReq {
    private final List<String> categories;
    private final String consentUUID;
    private final List<String> legIntCategories;
    private final int propertyId;
    private final List<String> vendors;

    public CustomConsentReq(String consentUUID, int i, List<String> vendors, List<String> categories, List<String> legIntCategories) {
        Intrinsics.checkNotNullParameter(consentUUID, "consentUUID");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(legIntCategories, "legIntCategories");
        this.consentUUID = consentUUID;
        this.propertyId = i;
        this.vendors = vendors;
        this.categories = categories;
        this.legIntCategories = legIntCategories;
    }

    public final String getConsentUUID() {
        return this.consentUUID;
    }

    public final int getPropertyId() {
        return this.propertyId;
    }

    public final List<String> getVendors() {
        return this.vendors;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final List<String> getLegIntCategories() {
        return this.legIntCategories;
    }
}
