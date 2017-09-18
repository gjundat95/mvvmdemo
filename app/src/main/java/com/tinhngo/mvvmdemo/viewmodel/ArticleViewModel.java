package com.tinhngo.mvvmdemo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.tinhngo.mvvmdemo.BR;
import com.tinhngo.mvvmdemo.R;
import com.tinhngo.mvvmdemo.model.Article;

/**
 * Created by tinhngo on 9/18/17.
 */

public class ArticleViewModel extends BaseObservable{

    private Context context;
    private Article article;

    public ArticleViewModel(Context context, Article article) {
        this.context = context;
        this.article = article;
    }

    @Bindable
    public String getTitle () {
        return this.article.getTitle();
    }

    public void setTitle (String title) {
        this.article.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public int getCardBackgroundColor () {
        return article.isHighlight() ?
                ContextCompat.getColor(context, R.color.highlight) :
                Color.parseColor("#ffffffff");
    }

    public int getCommentsButtonVisibility () {
        return article.getCommentsNumber() == 0 ?
                View.GONE : View.VISIBLE;
    }

    public int getCommentNumber () {
        return article.getCommentsNumber();
    }

    public String getExcerpt () {
        return article.getExcerpt();
    }

    public String getImageUrl () {
        return article.getImageUrl();
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
    }

}
