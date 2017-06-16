package org.gosky.base.di.module;

import org.gosky.base.widget.imageloader.BaseImageLoaderStrategy;
import org.gosky.base.widget.imageloader.ImageLoader;
import org.gosky.base.widget.imageloader.glide.GlideImageLoaderStrategy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jess on 8/5/16 16:10
 * contact with jess.yan.effort@gmail.com
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy() {
        return new GlideImageLoaderStrategy();
    }

    @Singleton
    @Provides
    public ImageLoader provideImageLoader(BaseImageLoaderStrategy strategy) {
        return new ImageLoader(strategy);
    }
}
