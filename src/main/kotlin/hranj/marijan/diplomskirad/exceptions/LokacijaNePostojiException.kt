package hranj.marijan.diplomskirad.exceptions

class LokacijaNePostojiException : Exception {

    constructor(msg: String, t: Throwable) : super(msg, t)

    constructor(msg: String) : super(msg)

}