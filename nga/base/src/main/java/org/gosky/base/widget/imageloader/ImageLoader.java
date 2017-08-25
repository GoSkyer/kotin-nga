package org.gosky.base.widget.imageloader;

/**
 * Created by jess on 8/5/16 15:57
 * contact with jess.yan.effort@gmail.com
 */
public class ImageLoader {
    //    private volatile static ImageLoader mImageLoader;
    private BaseImageLoaderStrategy mStrategy;

    public ImageLoader(BaseImageLoaderStrategy strategy) {
        setLoadImgStrategy(strategy);
    }


    public void setLoadImgStrategy(BaseImageLoaderStrategy strategy) {
        this.mStrategy = strategy;
    }

}
