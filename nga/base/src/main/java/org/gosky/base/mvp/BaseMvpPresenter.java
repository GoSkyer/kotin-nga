package org.gosky.base.mvp;


import android.widget.Toast;

import org.gosky.base.base.BaseApplication;
import com.sdsmdg.tastytoast.TastyToast;

/**
 * Created by hunji on 16/7/7.
 */
public class BaseMvpPresenter<V extends BaseView> implements BasePresenter<V> {

    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    protected void showToast(String arg) {
        Toast.makeText(BaseApplication.getContext().getApplicationContext(), arg, Toast.LENGTH_LONG).show();
    }
    /**
     * 短toast
     *
     * @param message
     * @param type
     */
    public void showToast(String message, int type) {
        TastyToast.makeText(BaseApplication.getContext(), message, TastyToast.LENGTH_SHORT, type);
    }


    /**
     * 长toast
     *
     * @param message
     * @param type
     */
    public void showLongToast(String message, int type) {
        TastyToast.makeText(BaseApplication.getContext().getApplicationContext(), message, TastyToast.LENGTH_LONG, type);
    }
}
