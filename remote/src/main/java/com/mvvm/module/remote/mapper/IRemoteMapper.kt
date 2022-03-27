package com.mvvm.module.remote.mapper

interface IRemoteMapper<RemoteModel, DataEntity> {

    fun mapFromApiResponseModel(remote: RemoteModel): DataEntity
}