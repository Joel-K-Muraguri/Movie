package com.joel.movie.data.repository

sealed class ResourceHandler<T>(val data : T? = null,val message : String? = null){
    class Loading<T>(data: T? = null) : ResourceHandler<T>(data)
    class Success<T>(data: T) : ResourceHandler<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceHandler<T>(data, message)

}
