// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailOrderActivity_ViewBinding implements Unbinder {
  private DetailOrderActivity target;

  private View view7f080004;

  private View view7f0800c6;

  @UiThread
  public DetailOrderActivity_ViewBinding(DetailOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailOrderActivity_ViewBinding(final DetailOrderActivity target, View source) {
    this.target = target;

    View view;
    target.textView7 = Utils.findRequiredViewAsType(source, R.id.textView7, "field 'textView7'", TextView.class);
    target.textView8 = Utils.findRequiredViewAsType(source, R.id.textView8, "field 'textView8'", TextView.class);
    target.txtidbooking = Utils.findRequiredViewAsType(source, R.id.txtidbooking, "field 'txtidbooking'", TextView.class);
    target.requestFrom = Utils.findRequiredViewAsType(source, R.id.requestFrom, "field 'requestFrom'", TextView.class);
    target.requestTo = Utils.findRequiredViewAsType(source, R.id.requestTo, "field 'requestTo'", TextView.class);
    target.textView9 = Utils.findRequiredViewAsType(source, R.id.textView9, "field 'textView9'", TextView.class);
    target.requestWaktu = Utils.findRequiredViewAsType(source, R.id.requestWaktu, "field 'requestWaktu'", TextView.class);
    target.requestTarif = Utils.findRequiredViewAsType(source, R.id.requestTarif, "field 'requestTarif'", TextView.class);
    target.textView18 = Utils.findRequiredViewAsType(source, R.id.textView18, "field 'textView18'", TextView.class);
    target.requestNama = Utils.findRequiredViewAsType(source, R.id.requestNama, "field 'requestNama'", TextView.class);
    target.requestEmail = Utils.findRequiredViewAsType(source, R.id.requestEmail, "field 'requestEmail'", TextView.class);
    target.requestID = Utils.findRequiredViewAsType(source, R.id.requestID, "field 'requestID'", TextView.class);
    view = Utils.findRequiredView(source, R.id.CompleteBooking, "field 'CompleteBooking' and method 'onViewClicked'");
    target.CompleteBooking = Utils.castView(view, R.id.CompleteBooking, "field 'CompleteBooking'", Button.class);
    view7f080004 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.reviewbooking, "field 'reviewbooking' and method 'onViewClicked'");
    target.reviewbooking = Utils.castView(view, R.id.reviewbooking, "field 'reviewbooking'", Button.class);
    view7f0800c6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView7 = null;
    target.textView8 = null;
    target.txtidbooking = null;
    target.requestFrom = null;
    target.requestTo = null;
    target.textView9 = null;
    target.requestWaktu = null;
    target.requestTarif = null;
    target.textView18 = null;
    target.requestNama = null;
    target.requestEmail = null;
    target.requestID = null;
    target.CompleteBooking = null;
    target.reviewbooking = null;

    view7f080004.setOnClickListener(null);
    view7f080004 = null;
    view7f0800c6.setOnClickListener(null);
    view7f0800c6 = null;
  }
}
