package com.rise

class RiseInfo {

    String staticIP
    String framedRoute
    String rateLimit

    static constraints = {
        staticIP blank: false
        framedRoute blank: true
        rateLimit blank: false
    }

}
