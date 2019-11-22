// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthActivity$ViewHolderRegister_ViewBinding implements Unbinder {
  private AuthActivity.ViewHolderRegister target;

  @UiThread
  public AuthActivity$ViewHolderRegister_ViewBinding(AuthActivity.ViewHolderRegister target,
      View source) {
    this.target = target;

    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.edtEmail, "field 'edtEmail'", MaterialEditText.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.edtPassword, "field 'edtPassword'", MaterialEditText.class);
    target.edtName = Utils.findRequiredViewAsType(source, R.id.edtName, "field 'edtName'", MaterialEditText.class);
    target.edtPhone = Utils.findRequiredViewAsType(source, R.id.edtPhone, "field 'edtPhone'", MaterialEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthActivity.ViewHolderRegister target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtEmail = null;
    target.edtPassword = null;
    target.edtName = null;
    target.edtPhone = null;
  }
}
