package com.rise

class User {

    public static final int PASSWORD_MIN_SIZE = 6

    String emailAddress
    String password

    static constraints = {
        emailAddress blank: false, email: true
        password blank: false, minSize: PASSWORD_MIN_SIZE
    }

    static mapping = {
        table 'users'
        password column: '`password`'
        id generator: 'uuid'
    }


}
