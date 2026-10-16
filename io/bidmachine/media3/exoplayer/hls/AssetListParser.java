package io.bidmachine.media3.exoplayer.hls;

import android.net.Uri;
import android.util.JsonReader;
import android.util.JsonToken;
import com.google.common.collect.ImmutableList;
import io.bidmachine.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/* loaded from: classes7.dex */
final class AssetListParser implements ParsingLoadable.Parser<AssetList> {
    private static final String ASSET_LIST_JSON_NAME_ASSET_ARRAY = "ASSETS";
    private static final String ASSET_LIST_JSON_NAME_DURATION = "DURATION";
    private static final String ASSET_LIST_JSON_NAME_URI = "URI";

    AssetListParser() {
    }

    public static final class AssetList {
        private static final AssetList EMPTY = new AssetList(ImmutableList.of(), ImmutableList.of());
        public final ImmutableList<Asset> assets;
        public final ImmutableList<StringAttribute> stringAttributes;

        public AssetList(ImmutableList<Asset> immutableList, ImmutableList<StringAttribute> immutableList2) {
            this.assets = immutableList;
            this.stringAttributes = immutableList2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssetList)) {
                return false;
            }
            AssetList assetList = (AssetList) obj;
            return Objects.equals(this.assets, assetList.assets) && Objects.equals(this.stringAttributes, assetList.stringAttributes);
        }

        public int hashCode() {
            return Objects.hash(this.assets, this.stringAttributes);
        }
    }

    public static final class Asset {
        public final long durationUs;
        public final Uri uri;

        public Asset(Uri uri, long j) {
            this.uri = uri;
            this.durationUs = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Asset)) {
                return false;
            }
            Asset asset = (Asset) obj;
            return this.durationUs == asset.durationUs && Objects.equals(this.uri, asset.uri);
        }

        public int hashCode() {
            return Objects.hash(this.uri, Long.valueOf(this.durationUs));
        }
    }

    public static final class StringAttribute {
        public final String name;
        public final String value;

        public StringAttribute(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringAttribute)) {
                return false;
            }
            StringAttribute stringAttribute = (StringAttribute) obj;
            return Objects.equals(this.name, stringAttribute.name) && Objects.equals(this.value, stringAttribute.value);
        }

        public int hashCode() {
            return Objects.hash(this.name, this.value);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.media3.exoplayer.upstream.ParsingLoadable.Parser
    public AssetList parse(Uri uri, InputStream inputStream) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        try {
            if (jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                AssetList assetList = AssetList.EMPTY;
                jsonReader.close();
                return assetList;
            }
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.peek().equals(JsonToken.NAME)) {
                    String nextName = jsonReader.nextName();
                    if (nextName.equals(ASSET_LIST_JSON_NAME_ASSET_ARRAY) && jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                        parseAssetArray(jsonReader, builder);
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        builder2.add((ImmutableList.Builder) new StringAttribute(nextName, jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            AssetList assetList2 = new AssetList(builder.build(), builder2.build());
            jsonReader.close();
            return assetList2;
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void parseAssetArray(JsonReader jsonReader, ImmutableList.Builder<Asset> builder) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                parseAssetObject(jsonReader, builder);
            }
        }
        jsonReader.endArray();
    }

    private static void parseAssetObject(JsonReader jsonReader, ImmutableList.Builder<Asset> builder) throws IOException {
        jsonReader.beginObject();
        String str = null;
        long j = -9223372036854775807L;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(ASSET_LIST_JSON_NAME_URI) && jsonReader.peek() == JsonToken.STRING) {
                str = jsonReader.nextString();
            } else if (nextName.equals(ASSET_LIST_JSON_NAME_DURATION) && jsonReader.peek() == JsonToken.NUMBER) {
                j = (long) (jsonReader.nextDouble() * 1000000.0d);
            } else {
                jsonReader.skipValue();
            }
        }
        if (str != null && j != -9223372036854775807L) {
            builder.add((ImmutableList.Builder<Asset>) new Asset(Uri.parse(str), j));
        }
        jsonReader.endObject();
    }
}
