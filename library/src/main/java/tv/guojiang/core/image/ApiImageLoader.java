package tv.guojiang.core.image;

import android.content.Context;
import tv.guojiang.core.image.factory.ImageFactory;

public class ApiImageLoader {

    private static ApiImageLoader mApiImageLoader;

    private ImageFactory mFactory;

    public static ApiImageLoader getInstance() {
        if (mApiImageLoader == null) {
            synchronized (ApiImageLoader.class) {
                if (mApiImageLoader == null) {
                    mApiImageLoader = new ApiImageLoader();
                }
            }
        }
        return mApiImageLoader;
    }

    public void setFactory(ImageFactory factory) {
        if (factory == null) {
            throw new NullPointerException("factory == null");
        }

        mFactory = factory;
    }

    public ImageBuilder newBuilder() {
        return new ImageBuilder();
    }

    Object loadImageSyn(Context context, ImageBuilder builder) throws Exception {
        if (mFactory == null) {
            throw new NullPointerException("factory == null");
        }

        return mFactory.loadImageSyn(context, builder.getImageEntity());
    }

    /**
     * 加载显示图片
     */
    void loadImage(Context context, ImageBuilder builder) {
        if (mFactory == null) {
            throw new NullPointerException("factory == null");
        }

        mFactory.loadImage(context, builder.getImageEntity());
    }

}
