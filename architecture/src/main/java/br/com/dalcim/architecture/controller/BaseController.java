package br.com.dalcim.architecture.controller;

import android.app.Activity;

import br.com.dalcim.architecture.activity.BaseActivity;
import br.com.dalcim.architecture.presenter.contract.ViewPresenter;

public abstract class BaseController<A extends BaseActivity>{

    protected A activity;

    public BaseController(A activity) {
        this.activity = activity;
    }
}
