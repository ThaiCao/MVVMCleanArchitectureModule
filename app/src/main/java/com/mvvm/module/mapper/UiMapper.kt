package com.mvvm.module.mapper

interface UiMapper<PresentationModel, UiModel> {

    fun mapToUi(presentation: PresentationModel): UiModel

}