package io.bidmachine.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.BitmapLoader;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.datasource.DataSource;
import io.bidmachine.media3.datasource.DefaultDataSource;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final Supplier<ListeningExecutorService> DEFAULT_EXECUTOR_SERVICE = Suppliers.memoize(new Supplier() { // from class: io.bidmachine.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda1
        @Override // com.google.common.base.Supplier
        public final Object get() {
            ListeningExecutorService listeningDecorator;
            listeningDecorator = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
            return listeningDecorator;
        }
    });
    private final DataSource.Factory dataSourceFactory;
    private final ListeningExecutorService listeningExecutorService;
    private final int maximumOutputDimension;
    private final BitmapFactory.Options options;

    public DataSourceBitmapLoader(Context context) {
        this((ListeningExecutorService) Assertions.checkStateNotNull(DEFAULT_EXECUTOR_SERVICE.get()), new DefaultDataSource.Factory(context));
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory) {
        this(listeningExecutorService, factory, null);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory, BitmapFactory.Options options) {
        this(listeningExecutorService, factory, options, -1);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory, BitmapFactory.Options options, int i) {
        this.listeningExecutorService = listeningExecutorService;
        this.dataSourceFactory = factory;
        this.options = options;
        this.maximumOutputDimension = i;
    }

    @Override // io.bidmachine.media3.common.util.BitmapLoader
    public boolean supportsMimeType(String str) {
        return Util.isBitmapFactorySupportedMimeType(str);
    }

    @Override // io.bidmachine.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> decodeBitmap(final byte[] bArr) {
        return this.listeningExecutorService.submit(new Callable() { // from class: io.bidmachine.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DataSourceBitmapLoader.this.m9723x7515baa(bArr);
            }
        });
    }

    /* renamed from: lambda$decodeBitmap$1$io-bidmachine-media3-datasource-DataSourceBitmapLoader, reason: not valid java name */
    /* synthetic */ Bitmap m9723x7515baa(byte[] bArr) throws Exception {
        return BitmapUtil.decode(bArr, bArr.length, this.options, this.maximumOutputDimension);
    }

    @Override // io.bidmachine.media3.common.util.BitmapLoader
    public ListenableFuture<Bitmap> loadBitmap(final Uri uri) {
        return this.listeningExecutorService.submit(new Callable() { // from class: io.bidmachine.media3.datasource.DataSourceBitmapLoader$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DataSourceBitmapLoader.this.m9724x2675d951(uri);
            }
        });
    }

    /* renamed from: lambda$loadBitmap$2$io-bidmachine-media3-datasource-DataSourceBitmapLoader, reason: not valid java name */
    /* synthetic */ Bitmap m9724x2675d951(Uri uri) throws Exception {
        return load(this.dataSourceFactory.createDataSource(), uri, this.options, this.maximumOutputDimension);
    }

    private static Bitmap load(DataSource dataSource, Uri uri, BitmapFactory.Options options, int i) throws IOException {
        try {
            dataSource.open(new DataSpec(uri));
            byte[] readToEnd = DataSourceUtil.readToEnd(dataSource);
            return BitmapUtil.decode(readToEnd, readToEnd.length, options, i);
        } finally {
            dataSource.close();
        }
    }
}
