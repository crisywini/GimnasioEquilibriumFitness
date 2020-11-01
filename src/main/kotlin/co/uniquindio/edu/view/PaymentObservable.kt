package co.uniquindio.edu.view
class PaymentObservable(var code:String,
                        var date: String,
                        var total:String,
                        var member: String,
                        var membership: String,
                        var paymentType: String) {
    override fun toString(): String {
        return "PaymentObservable(code='$code', date='$date', total='$total', member='$member', membership='$membership', paymentType='$paymentType')"
    }
}