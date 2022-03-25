package com.mvvm.module.presentation.mapper

interface PresentationMapper<PresentationModel, DomainModel> {

    fun mapToPresentation(domain: DomainModel): PresentationModel

}