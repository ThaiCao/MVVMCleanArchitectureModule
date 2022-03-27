package com.mvvm.module.remote.mapper

interface UiMapper<PresentationModel, UiModel> {

    fun mapToUi(presentation: PresentationModel): UiModel

}