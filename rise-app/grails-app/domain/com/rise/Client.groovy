package com.rise

class Client {

    User user
    RiseInfo riseInfo

    static constraints = {
        user unique: true
        riseInfo nullable: true
    }
}
