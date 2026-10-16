package io.bidmachine;

import android.text.TextUtils;
import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.core.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class Publisher {
    private final List<String> categories;
    private final String domain;
    private final String id;
    private final String name;

    private Publisher(String id, String name, String domain, List<String> categories) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.categories = categories;
    }

    void build(Context.App.Builder builder) {
        Context.App.Publisher.Builder newBuilder = Context.App.Publisher.newBuilder();
        String str = this.id;
        if (str != null) {
            newBuilder.setId(str);
        }
        String str2 = this.name;
        if (str2 != null) {
            newBuilder.setName(str2);
        }
        String str3 = this.domain;
        if (str3 != null) {
            newBuilder.setDomain(str3);
        }
        List<String> list = this.categories;
        if (list != null) {
            newBuilder.addAllCat(list);
        }
        builder.setPub(newBuilder.build());
    }

    public static final class Builder {
        private List<String> categories;
        private String domain;
        private String id;
        private String name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder addCategory(String category) {
            if (TextUtils.isEmpty(category)) {
                return this;
            }
            if (this.categories == null) {
                this.categories = new ArrayList();
            }
            this.categories.add(category);
            return this;
        }

        public Builder addCategories(List<String> categoryList) {
            if (!Utils.isEmpty(categoryList)) {
                Iterator<String> it = categoryList.iterator();
                while (it.hasNext()) {
                    addCategory(it.next());
                }
            }
            return this;
        }

        public Publisher build() {
            return new Publisher(this.id, this.name, this.domain, this.categories);
        }
    }
}
