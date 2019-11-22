package com.imastudio.driverappojol.base;

public interface BaseView <T extends BasePresenter> {
     void onAttachView();
     void onDetachView();

}
