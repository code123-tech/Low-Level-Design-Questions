The Principle States that a class/module/package/method should be open for extension, not for modification.

For suppose, you have a payment system which makes payment for upi/card and based on payment mode you make payment with that
payment system.

1. Upi has makeUpiPayment method
2. Card has makeCardPayment method.

So, In future suppose, we want to extend this for Emi Payment, then we need to modify the existing class, which breaks the
Open Closed Principle as well as Single Responsibility.

For getting rid of above issue, we can create an interface which has makePayment method, and each paymentMode has its own
class which implements this interface.


### Pros of Using the Open-Closed Principle
- As per the principle, no modification should happen in existing code, so it leads to fewer bugs/errors in existing code.
- Code becomes more extendable for future purposes.

### Cons of Using the Open-Closed Principle
- This principle comes with the introduction of an Abstraction Layer which becomes a little tough at the beginner level.