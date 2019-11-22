// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MapsActivity_ViewBinding implements Unbinder {
  private MapsActivity target;

  private View view7f08006e;

  private View view7f08007e;

  private View view7f08007f;

  private View view7f0800c4;

  @UiThread
  public MapsActivity_ViewBinding(MapsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MapsActivity_ViewBinding(final MapsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgpick, "field 'imgpick' and method 'onViewClicked'");
    target.imgpick = Utils.castView(view, R.id.imgpick, "field 'imgpick'", ImageView.class);
    view7f08006e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lokasiawal, "field 'lokasiawal' and method 'onViewClicked'");
    target.lokasiawal = Utils.castView(view, R.id.lokasiawal, "field 'lokasiawal'", TextView.class);
    view7f08007e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lokasitujuan, "field 'lokasitujuan' and method 'onViewClicked'");
    target.lokasitujuan = Utils.castView(view, R.id.lokasitujuan, "field 'lokasitujuan'", TextView.class);
    view7f08007f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtcatatan = Utils.findRequiredViewAsType(source, R.id.edtcatatan, "field 'edtcatatan'", EditText.class);
    target.txtharga = Utils.findRequiredViewAsType(source, R.id.txtharga, "field 'txtharga'", TextView.class);
    target.txtjarak = Utils.findRequiredViewAsType(source, R.id.txtjarak, "field 'txtjarak'", TextView.class);
    target.txtdurasi = Utils.findRequiredViewAsType(source, R.id.txtdurasi, "field 'txtdurasi'", TextView.class);
    view = Utils.findRequiredView(source, R.id.requestorder, "field 'requestorder' and method 'onViewClicked'");
    target.requestorder = Utils.castView(view, R.id.requestorder, "field 'requestorder'", Button.class);
    view7f0800c4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rootlayout = Utils.findRequiredViewAsType(source, R.id.rootlayout, "field 'rootlayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MapsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgpick = null;
    target.lokasiawal = null;
    target.lokasitujuan = null;
    target.edtcatatan = null;
    target.txtharga = null;
    target.txtjarak = null;
    target.txtdurasi = null;
    target.requestorder = null;
    target.rootlayout = null;

    view7f08006e.setOnClickListener(null);
    view7f08006e = null;
    view7f08007e.setOnClickListener(null);
    view7f08007e = null;
    view7f08007f.setOnClickListener(null);
    view7f08007f = null;
    view7f0800c4.setOnClickListener(null);
    view7f0800c4 = null;
  }
}
