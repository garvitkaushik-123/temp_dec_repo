package com.applovin.impl;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.b3;
import com.applovin.impl.o2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;

/* loaded from: classes2.dex */
public class w3 extends o2 {
    private final b3 n;
    private final Context o;

    public w3(b3 b3Var, Context context) {
        super(o2.c.DETAIL);
        this.n = b3Var;
        this.o = context;
        this.c = t();
        this.d = s();
    }

    private SpannedString q() {
        if (!this.n.A()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", -65536);
        }
        if (TextUtils.isEmpty(this.n.c())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", -16777216);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.n.c(), -16777216));
        if (this.n.B()) {
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", m0.a(R.color.applovin_sdk_orangeColor, this.o)));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.n.k(), -16777216));
        }
        if (!this.n.C()) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("INCOMPATIBLE WITH MAX SDK VERSION", -65536));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!o()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) u());
        spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
        spannableStringBuilder.append((CharSequence) q());
        if (this.n.q() == b3.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", -65536));
        } else if (this.n.q() == b3.a.INCOMPLETE_INTEGRATION && this.n.F()) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Mismatched SDK/Adapter Versions", -65536));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString t() {
        return StringUtils.createSpannedString(this.n.g(), o() ? -16777216 : -7829368, 18, 1);
    }

    private SpannedString u() {
        if (!this.n.G()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", -65536);
        }
        if (!StringUtils.isValidString(this.n.p())) {
            return StringUtils.createListItemDetailSpannedString(this.n.A() ? "Retrieving SDK Version..." : "SDK Found", -16777216);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.n.p(), -16777216));
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.o2
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.o2
    public int e() {
        return m0.a(R.color.applovin_sdk_disclosureButtonColor, this.o);
    }

    @Override // com.applovin.impl.o2
    public int h() {
        int h = this.n.h();
        return h > 0 ? h : R.drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.o2
    public boolean o() {
        return this.n.q() != b3.a.MISSING;
    }

    public b3 r() {
        return this.n;
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.c) + ", detailText=" + ((Object) this.d) + ", network=" + this.n + "}";
    }
}
