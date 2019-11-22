// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RatingActivity_ViewBinding implements Unbinder {
  private RatingActivity target;

  private View view7f08002c;

  @UiThread
  public RatingActivity_ViewBinding(RatingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RatingActivity_ViewBinding(final RatingActivity target, View source) {
    this.target = target;

    View view;
    target.txtReview = Utils.findRequiredViewAsType(source, R.id.txtReview, "field 'txtReview'", TextView.class);
    target.ivReviewFoto = Utils.findRequiredViewAsType(source, R.id.ivReviewFoto, "field 'ivReviewFoto'", ImageView.class);
    target.txtReviewUserNama = Utils.findRequiredViewAsType(source, R.id.txtReviewUserNama, "field 'txtReviewUserNama'", TextView.class);
    target.ratingReview = Utils.findRequiredViewAsType(source, R.id.ratingReview, "field 'ratingReview'", RatingBar.class);
    target.txtReview2 = Utils.findRequiredViewAsType(source, R.id.txtReview2, "field 'txtReview2'", TextView.class);
    target.edtReviewComment = Utils.findRequiredViewAsType(source, R.id.edtReviewComment, "field 'edtReviewComment'", MaterialEditText.class);
    target.txtReview3 = Utils.findRequiredViewAsType(source, R.id.txtReview3, "field 'txtReview3'", TextView.class);
    target.cboReview = Utils.findRequiredViewAsType(source, R.id.cboReview, "field 'cboReview'", CheckBox.class);
    view = Utils.findRequiredView(source, R.id.btnReview, "field 'btnReview' and method 'onViewClicked'");
    target.btnReview = Utils.castView(view, R.id.btnReview, "field 'btnReview'", Button.class);
    view7f08002c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RatingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtReview = null;
    target.ivReviewFoto = null;
    target.txtReviewUserNama = null;
    target.ratingReview = null;
    target.txtReview2 = null;
    target.edtReviewComment = null;
    target.txtReview3 = null;
    target.cboReview = null;
    target.btnReview = null;

    view7f08002c.setOnClickListener(null);
    view7f08002c = null;
  }
}
