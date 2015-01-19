package com.rise

class Client {

    User user
    RiseInfo riseInfo

    static constraints = {
        user nullable: false
        riseInfo nullable: false
    }
}
