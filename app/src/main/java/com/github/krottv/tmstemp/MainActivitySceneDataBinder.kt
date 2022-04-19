package com.github.krottv.tmstemp

import android.app.Activity
import android.view.LayoutInflater
import com.github.krottv.tmstemp.animation.MainTransitionController
import com.github.krottv.tmstemp.binder.MainActivityDataBinder
import com.github.krottv.tmstemp.databinding.StartBinding

class MainActivitySceneDataBinder(private val activity: Activity): MainActivityDataBinder {
    override fun bind() {

        val startLayout = StartBinding.inflate(LayoutInflater.from(activity))
        activity.setContentView(startLayout.root)

        val transitionController = MainTransitionController(activity, startLayout)
        transitionController.performTransition()
    }
}